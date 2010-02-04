/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer.compile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apertium.transfer.Transfer;
import org.apertium.transfer.TransferWord;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import static org.apertium.transfer.compile.DOMTools.*;


/**
 *
 * @author Jacob Nordfalk
 */
public class ParseTranserFile {

  public String className;

  /** For checking macro names and numbers of parameters */
  private HashMap<String, Integer> macroList = new HashMap<String, Integer>();

  /** For checking attributes. order is important */
  private LinkedHashSet<String> attrList = new LinkedHashSet<String>();

  /** For checking variables */
  private LinkedHashSet<String> varList = new LinkedHashSet<String>();

  /** For checking lists */
  private LinkedHashSet<String> listList = new LinkedHashSet<String>();



  /**
   * The number of parameters in the rule/macro/method currently being defined
   */
  private int currentNumberOfWordInParameterList;

  private Element currentNode;

  private void processLu(Element e) {
    // the lexical unit should only be outputted if it contains something
    println("{");
    println("String myword = ");
    boolean first=true;
    for (Element lu : listChildren(e)) {
      println((first?"         ":"         +")+evalString(lu));
      first = false;
    }
    println(first?"         \"\";":"         ;");
    println("if (myword.length()>0)");
    println("{");
    append("'^'");
    append("myword");
    append("'$'");
    println("}");
    println("}");
  }

  //public static final int OutputType_LU = 0;
  //public static final int OutputType_CHUNK = 1;
  enum OutputType {
    lu, chunk
  };
  OutputType defaultAttrs;
  

  public String getJavaCode() {
    return javaCode.toString();
  }

  private void append(String str) {
    println("out.append("+str+");");
  }



  private String getPathAsString(Node n) {
    if (n==null) return "";
    String path = "";
    do  {
      String attrss = "";
      NamedNodeMap attrs = n.getAttributes();
      //for (int i=0; i<attrs.getLength(); i++) attrss += " "+attrs.item(i).getNodeName()+"="+attrs.item(i).getNodeValue();
      if (attrs!=null) {
        for (int i=0; i<attrs.getLength(); i++) attrss += " "+attrs.item(i);
      }

      if (path.length()>0) path = "/"+path;
      path = "<"+n.getNodeName() + attrss + ">" + path;
      n = n.getParentNode();

    } while (!(n instanceof Document));
    return " - for "+path;
  }

  private void parseError(String string) {
    string = string + getPathAsString(currentNode);
    println(string);
    System.err.println( string);
  }

  private String escapeStr(String unescaped) {
    return unescaped.replace("\\", "\\\\").replace("\"", "\\\"");
  }


  private String attrItemRegexp(ArrayList<String> items) {
    StringBuilder re = null;
    for (String item : items) {
      if (re==null) re = new StringBuilder(items.size()*20);
      else re.append( '|');
      re.append( '<');
      re.append(escapeStr(item.replace(".", "><")));
      re.append( '>');
    }
    return re.toString();
  }


  /**
   * Generates Java code for reading the value of a clip
   * @param e the clip tag
   * @return java code
   */
  private String getReadClipExpr(Element e) {
    currentNode = e;
    String side=e.getAttribute("side");
    String part=e.getAttribute("part");
    String pos=e.getAttribute("pos");
    boolean cond=!e.getAttribute("queue").equals("no");
    if (side.equals("sl")) {
      return ""+word(pos)+".source("+attr(part)+", "+cond+")";
    } else if (side.equals("tl")) {
      return ""+word(pos)+".target("+attr(part)+", "+cond+")";
    } else throw new IllegalArgumentException(side);
  }

  /**
   * Generates Java code for writing to a clip
   * @param e the clip tag
   * @param value new value the clip will get assigned
   * @return java code
   */
  private String getWriteClipExpr(Element e, String value) {
    currentNode = e;
    String side=e.getAttribute("side");
    String part=e.getAttribute("part");
    String pos=e.getAttribute("pos");
    boolean cond=!e.getAttribute("queue").equals("no");
    String expr;
    if (side.equals("sl")) {
      expr=""+word(pos)+".setSource("+attr(part)+", "+value+", "+cond+");";
    } else if (side.equals("tl")) {
      expr=""+word(pos)+".setTarget("+attr(part)+", "+value+", "+cond+");";
    } else throw new IllegalArgumentException(side);
    return expr;
  }

  private String javaIdentifier(String str) {
    return str.replaceAll("\\W", "_");
  }

  private String javaStringArray(ArrayList<String> items) {
    String s = "new String[] { ";
    for (String i : items) s += "\""+i+"\", ";
    s += "}";
    return s;
  }

  //
  //  Code from transfer.c
  //

  private String evalString(Element e) {
    currentNode = e;
    String n = e.getTagName();
    if (n.equals("clip")) {
      String as = e.getAttribute("link-to");
      String expr=getReadClipExpr(e);
      if (as.isEmpty()) return expr;
      else return "("+expr+".isEmpty()?\"\" : \"<"+as+">\")";
    } else if (n.equals("lit-tag")) {
      return str("<"+e.getAttribute("v").replaceAll("\\.", "><")+">");
    } else if (n.equals("lit")) {
      return str(e.getAttribute("v"));
    } else if (n.equals("b")) {
      String pos = e.getAttribute("pos");
      if (pos.isEmpty()) return(str(" "));
      else return blank(pos);
    } else if (n.equals("get-case-from")) {
      String pos = e.getAttribute("pos");
      String eval = evalString(getFirstChildElement(e));
      boolean cond=!e.getAttribute("queue").equals("no");
      return "TransferWord.copycase("+word(pos)+".source(attr_lem, "+cond+"), "+ eval + ")";
    } else if (n.equals("var")) {
      return var(e.getAttribute("n"));
    } else if (n.equals("case-of")) {
      String side=e.getAttribute("side");
      String part=e.getAttribute("part");
      String pos=e.getAttribute("pos");
      boolean cond=true; //!e.getAttribute("queue").equals("no");
      if (side.equals("sl")) {
        return "TransferWord.caseOf("+word(pos)+".source("+attr(part)+", "+cond+"))";
      } else if (side.equals("tl")) {
        return "TransferWord.caseOf("+word(pos)+".target("+attr(part)+", "+cond+"))";
      } else throw new IllegalArgumentException(side);
    } else if (n.equals("concat")) {
      String res = "("+str("");
      for (Element c : listElements(e.getChildNodes())) {
        res += "+"+ evalString(c);
      }
      res += ")";
      return res;
    }
    throwParseError("// ERROR: unexpected rvalue expression "+e);
    return str("");// +"/* not supported yet: "+e + "*/";
  }

  private void processOut(Element instr) {
    currentNode = instr;
    if (defaultAttrs == OutputType.lu) {
    } else { // defaultAttrs == Transfer.OutputType.chunk
    }
   
    for (Element e : listChildren(instr)) {
      String n = e.getTagName();
      if (n.equals("lu")) {
        processLu(e);
      } else if (n.equals("mlu")) {
        append("'^'");
        for (java.util.Iterator<Element> it = listChildren(e).iterator(); it.hasNext();) {
            Element mlu = it.next();
            for (Element lu : listChildren(mlu)) {
              append(evalString(lu));
            }
            if (it.hasNext())
              append("'+'");
        }
        append("'$'");
      } else if (n.equals("chunk")) processChunk(e);
      else append( evalString(e) ); // takes care of 'b'
    }
  }


  private void processChunk(Element e) {
    currentNode = e;
    String name = e.getAttribute("name");
    String namefromvar = e.getAttribute("namefrom");
    String caseofchunkvar = e.getAttribute("case");
//    if (caseofchunkvar.isEmpty()) caseofchunkvar = "aa";
//    else println("// not supported yet: case");

    append("'^'");
    if (caseofchunkvar.isEmpty()) {
      if (!name.isEmpty()) append(str(name));
      else if (!namefromvar.isEmpty()) {
        append(var(namefromvar));
      }
      else parseError("// ERROR: you must specify either 'name' or 'namefrom' for the 'chunk' element");
    } else {
      if (!name.isEmpty()) {
        append("TransferWord.copycase("+var(caseofchunkvar)+", "+str(name)+")");
      }
      else if (!namefromvar.isEmpty()) {
        append("TransferWord.copycase("+var(caseofchunkvar)+", "+var(namefromvar)+")");
      }
      else parseError("// ERROR: you must specify either 'name' or 'namefrom' for the 'chunk' element");
    }


    for (Element c0 : listChildren(e)) {
      String n = c0.getTagName();
      if (n.equals("tags")) {
        for (Element tag : listChildren(c0))
          append(evalString(findElementSibling(tag.getFirstChild())));
        append("'{'");
      } else if (n.equals("lu")) {
        processLu(c0);
        //append("'^'");
        //for (Element lu : listChildren(c0))
        //  append(evalString(lu));
        //append("'$'");
      } else if (n.equals("mlu")) {
        append("'^'");
        for (java.util.Iterator<Element> it = listChildren(c0).iterator(); it.hasNext();) {
            Element mlu = it.next();
            for (Element lu : listChildren(mlu)) {
              append(evalString(lu));
            }
            if (it.hasNext())
              append("'+'");
        }
        append("'$'");
      } else {
        append(evalString(c0));
      }
    }
    append("\"}$\"");
  }


  private void processInstruction(Element instr) {
    currentNode = instr;
    String n = instr.getTagName();
    if(n.equals("choose")) {
      processChoose(instr);
    }
    else if(n.equals("let"))
    {
      processLet(instr);
    }
    else if(n.equals("append"))
    {
      processAppend(instr);
    }
    else if(n.equals("out"))
    {
      processOut(instr);
    }
    else if(n.equals("call-macro"))
    {
      processCallMacro(instr);
    }
    else if(n.equals("modify-case"))
    {
      processModifyCase(instr);
    }
    else
      throwParseError("processInstruction(n = " + n);
  }

  private void processLet(Element instr) {
    currentNode = instr;
    Element leftSide = findElementSibling(instr.getFirstChild());
    Element rightSide = findElementSibling(leftSide.getNextSibling());

    String n = leftSide.getTagName();
    if (n.equals("var")) {
      String name = leftSide.getAttribute("n");
      println(var(name)+" = " + evalString(rightSide)+ ";");
    } else if (n.equals("clip")) {
      println(getWriteClipExpr(leftSide, evalString(rightSide)));
    } else throwParseError(n);
  }


  private void processAppend(Element instr) {
    currentNode = instr;
    String var = var(instr.getAttribute("n"));

    println(var +" = " + var);
    Element appendElement = findElementSibling(instr.getFirstChild());
    while (appendElement!=null) {
      println("    +" + evalString(appendElement));
      appendElement = findElementSibling(appendElement.getNextSibling());
    }
    println("    ;");
  }



  private void processModifyCase(Element instr) {
    currentNode = instr;
    Element leftSide = findElementSibling(instr.getFirstChild());
    Element rightSide = findElementSibling(leftSide.getNextSibling());

    String n = leftSide.getTagName();
    if (n.equals("var")) {
      String name = leftSide.getAttribute("n");
      if (varList.contains(name)) {
        String var = "var_"+name;
        println(var+" = TransferWord.copycase(" + evalString(rightSide)+ ", "+var+");");
      } else {
        parseError("// WARNING variable "+name+" doesent exist. Ignoring modify-case");
      }
    } else if (n.equals("clip")) {
      println(getWriteClipExpr(leftSide, "TransferWord.copycase("+evalString(rightSide)+", "+getReadClipExpr(leftSide)+")"));
    } else throwParseError(n);
  }


  private void processCallMacro(Element instr) {
    currentNode = instr;
    String n = instr.getAttribute("n");
    if (!macroList.containsKey(n)) {
      // this macro doesent exists!
      parseError("// WARNING: Macro "+n+" is not defined. Ignoring call. Defined macros are: "+macroList.keySet());
      return;
    }
    int macronpar = macroList.get(n);
    String par = "";
    int npar = 0;
    for (Element c : listChildren(instr)) {
      if (npar>=macronpar) {
        parseError("// WARNING: Macro "+n+" is invoked with too many parameters. Ignoring: "+c);
        break;
      }
      int pos = Integer.parseInt(c.getAttribute("pos"));
      if (!par.isEmpty())  {
        par += (pos>1?", "+blank(pos-1): ", "+str(" "));
      }
      par += ", "+word(pos);
      npar++;
    }

    while (npar<macronpar) {
      parseError("// WARNING: Macro "+n+" is invoked with too few parameters. Adding blank parameters ");
      if (!par.isEmpty())  {
        par += ", "+str(" ");
      }
      par += ", "+"new TransferWord(\"\", \"\", 0)";
      npar++;
    }

    println("macro_"+javaIdentifier(n)+"(out"+par+");");
  }

  private void processChoose(Element e) {
    currentNode = e;
    boolean first = true;
    for (Element whenC : listChildren(e))
    {
      String n = whenC.getTagName();
      Element c0 = getFirstChildElement(whenC);
      if (!first) println("else");
      first = false;

      if (n.equals("when")) {
        String evalLogic = processLogical( getFirstChildElement(c0));
        c0 = findElementSibling(c0.getNextSibling());
        println("if ("+evalLogic+")");
      } else {
        assert(n.equals("otherwise"));
      }

      println("{");
      while (c0 !=null)
      {
        processInstruction(c0);
        c0 = findElementSibling(c0.getNextSibling());
      }
      println("}");
    }
  }





  String processLogical(Element e) {
    currentNode = e;
    String n=e.getTagName();

    if (n.equals("equal")) {
      return processEqual(e);
    } else if (n.equals("begins-with")) {
      return processBeginsWith(e);
    } else if (n.equals("begins-with-listElements")) {
      return processBeginsWithList(e);
    } else if (n.equals("ends-with")) {
      return processEndsWith(e);
    } else if (n.equals("ends-with-listElements")) {
      return processEndsWithList(e);
    } else if (n.equals("contains-substring")) {
      return processContainsSubstring(e);
    } else if (n.equals("in")) {
      return processIn(e);
    } else if (n.equals("or")) {
      Element first = getFirstChildElement(e);
      Element second = findElementSibling(first.getNextSibling());
      return "("+processLogical(first) + "\n    || " + processLogical(second)+")";
    } else if (n.equals("and")) {
      Element first = getFirstChildElement(e);
      Element second = findElementSibling(first.getNextSibling());
      return "("+processLogical(first) + "\n    && " + processLogical(second)+")";
    } else if (n.equals("not")) {
      return "!" + processLogical(getFirstChildElement(e));
    }
    parseError("// SORRY: not supported yet: processLogical(c0 = "+e);
    return "false /*not supported: processLogical("+e+" */";
  }

  private String processEqual(Element e) {
    currentNode = e;
    Element first = findElementSibling(e.getFirstChild());
    Element second = findElementSibling(first.getNextSibling());
    boolean caseless = "yes".equals(e.getAttribute("caseless"));
    if (caseless) {
      return evalString(first)+".equalsIgnoreCase("+evalString(second)+")";
    } else {
      return evalString(first)+".equals("+evalString(second)+")";
    }
  }


  private String processBeginsWith(Element e) {
    currentNode = e;
    Element first = findElementSibling(e.getFirstChild());
    Element second = findElementSibling(first.getNextSibling());
    boolean caseless = "yes".equals(e.getAttribute("caseless"));
    if (caseless) {
      return evalString(first)+".startsWith("+evalString(second)+")";
    } else {
      return evalString(first)+".toLowerCase().startsWith("+evalString(second)+".toLowerCase())";
    }
  }


  private String processEndsWith(Element e) {
    currentNode = e;
    Element first = findElementSibling(e.getFirstChild());
    Element second = findElementSibling(first.getNextSibling());
    boolean caseless = "yes".equals(e.getAttribute("caseless"));
    if (caseless) {
      return evalString(first)+".endsWith("+evalString(second)+")";
    } else {
      return evalString(first)+".toLowerCase().endsWith("+evalString(second)+".toLowerCase())";
    }
  }

  private String processBeginsWithList(Element e) {
    currentNode = e;
    Element first = getFirstChildElement(e);
    Element second = findElementSibling(first.getNextSibling());
    String listName = list(second.getAttribute("n"));

    if (e.getAttribute("caseless").equals("yes")) {
      return listName +".containsIgnoreCaseBeginningWith("+evalString(first)+")";
    }
    return listName +".containsBeginningWith("+evalString(first)+")";
  }


  private String processEndsWithList(Element e) {
    currentNode = e;
    Element first = getFirstChildElement(e);
    Element second = findElementSibling(first.getNextSibling());
    String listName = list(second.getAttribute("n"));

    if (e.getAttribute("caseless").equals("yes")) {
      return listName +".containsIgnoreCaseEndingWith("+evalString(first)+")";
    }
    return listName +".containsEndingWith("+evalString(first)+")";
  }

  private String processContainsSubstring(Element e) {
    currentNode = e;
    Element first = findElementSibling(e.getFirstChild());
    Element second = findElementSibling(first.getNextSibling());
    boolean caseless = "yes".equals(e.getAttribute("caseless"));
    if (caseless) {
      return evalString(first)+".contains("+evalString(second)+")";
    } else {
      return evalString(first)+".toLowerCase().contains("+evalString(second)+".toLowerCase())";
    }
  }



  private String processIn(Element e) {
    currentNode = e;
    Element first = getFirstChildElement(e);
    Element second = findElementSibling(first.getNextSibling());
    String listName = list(second.getAttribute("n"));

    if (e.getAttribute("caseless").equals("yes")) {
      return listName +".containsIgnoreCase("+evalString(first)+")";
    }
    return listName +".contains("+evalString(first)+")";
  }


  private String str(String n) {
    if (n==null) return "null";
    return "\""+escapeStr(n)+"\"";
  }


//  Appendable javaCode = System.out; // new StringBuilder(1000);
  StringBuilder javaCode = new StringBuilder(1000);

  int indent = 0;

  private void println(String string) {
    if (indent>0 && string.equals("}")) indent--;
    print("\t\t\t\t\t\t\t\t\t\t".substring(0,indent));
    print(string+"\n");
    if (string.equals("{") && indent < 10) indent++;
  }

  private void print(String string) {
     javaCode.append(string);
     //System.err.print(string);
  }

  private void throwParseError(String n) {
    throw new UnsupportedOperationException("Not yet implemented:"+n+getPathAsString(currentNode));
  }

  private boolean error_UNKNOWN_VAR = false;
  private String var(String name) {
    if (varList.contains(name)) {
      return "var_"+javaIdentifier(name);
    }
    parseError("// WARNING variable "+name+" doesent exist. Valid variables are: "+varList
       + "\n// Replacing with error_UNKNOWN_VAR");
    error_UNKNOWN_VAR = true;
    return "error_UNKNOWN_VAR";
  }


  private boolean error_UNKNOWN_ATTR = false;
  private String attr(String name) {
    if (attrList.contains(name))
      return "attr_"+javaIdentifier(name);

    parseError("// WARNING: Attribute "+name+" is not defined. Valid attributes are: "+attrList
        + "\n// Replacing with error_UNKNOWN_ATTR");
    error_UNKNOWN_ATTR = true;
    return "error_UNKNOWN_ATTR";
  }

  private boolean error_UNKNOWN_LIST = false;
  private String list(String name) {
    if (listList.contains(name))
      return "list_"+javaIdentifier(name);

    parseError("// WARNING: List "+name+" is not defined. Valid lists are: "+listList
        + "\n// Replacing with error_UNKNOWN_LIST");
    error_UNKNOWN_LIST = true;
    return "error_UNKNOWN_LIST";
  }


  private String word(int pos) {
    if (pos <= currentNumberOfWordInParameterList) {
      return "word"+pos;
    }
    parseError("// WARNING clip pos="+pos+" is out of range. Replacing with an empty TransferWord.");

    return "new TransferWord(\"\", \"\", 0)";
  }

  private String word(String pos) {
    return word(Integer.parseInt(pos.trim()));
  }

  private String blank(int pos) {
    if (pos < currentNumberOfWordInParameterList) {
      return "blank"+pos;
    }
    parseError("// WARNING blank pos="+pos+" is out of range. Replacing with an empty blank.");
    return str(" ");
  }

  private String blank(String pos) {
    return blank(Integer.parseInt(pos));
  }


public class ParseApertiumRE {
  String n;
  String[] items;

  public ParseApertiumRE(String n, String[] items) {
      this.n = n; this.items = items;
  }

  @Override
  public String toString() { return "def-attr n="+n+":"+Arrays.toString(items); }
  }


public class ParseDefList {
  String n;
  String[] items;

  public ParseDefList(String n, String[] items) {
      this.n = n; this.items = items;
  }

  @Override
  public String toString() { return "def-list n="+n+":"+Arrays.toString(items); }
  }
 
   /**
     * @param file the address of the XML file to be read
     */
    public void parse(String file) throws IOException, ParserConfigurationException, SAXException {
      className = javaIdentifier(new File(file).getName());
      println("package org.apertium.transfer.generated;");
      println("import java.util.*;");
      println("import java.io.*;");
      //println("import org.apertium.lttoolbox.transfer.*;");
      println("import org.apertium.transfer.*;");
      println("public class "+className+" extends GeneratedTransferBase");
      println("{");

      try {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(file));
        Element root = doc.getDocumentElement();

        println("public boolean isOutputChunked()");
        println("{");
        if (root.getAttribute("default").equals("chunk")) {
          defaultAttrs = OutputType.chunk;
          println("return true;");
        } else {
          defaultAttrs = OutputType.lu;
          println("return false;");
        }
        println("}");

        
        //LinkedHashMap<String,DefCat> defCats = new LinkedHashMap<String,DefCat>();
        //LinkedHashMap<String,ParseApertiumRE> defAttrs = new LinkedHashMap<String,ParseApertiumRE>();
        //ArrayList<String> defVars = new ArrayList<String>();
        //LinkedHashMap<String,ParseDefList> defLists = new LinkedHashMap<String,ParseDefList>();

        /*
        for (Element c0 : getChildsChildrenElements(root, "section-def-cats")) {
          String n = c0.getAttribute("n");
          ArrayList<CatItem> items = new ArrayList<CatItem>();
          for (Element c1 : listChildren(c0)) {
            items.add(new CatItem(c1.getAttribute("lemma"), c1.getAttribute("tags")));
          }
          defCats.put(n,new DefCat(n, items.toArray(new CatItem[items.size()])));
          println("DefCat cat_"+n+" = new DefCat("+str(n)+", "+javaCatItemArray(items)+");");
        }*/



        for (Element c0 : getChildsChildrenElements(root, "section-def-attrs")) {
          String n = c0.getAttribute("n");
          ArrayList<String> items = new ArrayList<String>();
          for (Element c1 : listChildren(c0))
            items.add(c1.getAttribute("tags"));


          /* FIX:
java match of (<prn>|<prn><ref>|<prn><itg>|<prn><tn>)  on ^what<prn><itg><sp>  is '<prn>'
pcre match of (<prn>|<prn><ref>|<prn><itg>|<prn><tn>)  on ^what<prn><itg><sp>  is '<prn><itg>'
           therefore I reorder so the longest are first.
           */
          Collections.sort(items, new Comparator<String>() {
            public int compare(String o1, String o2) {
              return o2.length() - o1.length();
            }
          });

          //defAttrs.put(n,new ParseApertiumRE(n, items.toArray(new String[items.size()])));
          println("ApertiumRE attr_"+javaIdentifier(n)+" = new ApertiumRE(\""+attrItemRegexp(items)+"\");");
          attrList.add(n);
        }

        //println("public void initAttrLists(ApertiumRE[] attrList) {");
        //int no = 0;
        //for (String name : attrList) println("attr_"+name +" = attrList["+no++ +"];");
        //println("}");

        String[][] fixed_attributes = {
          { "lem" , "(([^<]|\\\"\\\\<\\\")+)" },
          { "lemq" , "\\\\#[- _][^<]+" },
          { "lemh" , "(([^<#]|\\\"\\\\<\\\"|\\\"\\\\#\\\")+)" },
          { "whole" , "(.+)" },
          { "tags" , "((<[^>]+>)+)" },
          { "chname" , "(\\\\{([^/]+)\\\\/)" }, // includes delimiters { and / !!!
          { "chcontent" , "(\\\\{.+)" },
          { "content" , "(\\\\{.+)" },
        };

        for (String[] nameval : fixed_attributes) {
          if (attrList.add(nameval[0])) {
            println("ApertiumRE attr_"+nameval[0]+" = new ApertiumRE(\""+nameval[1]+"\");");
          } else {
            parseError("// WARNING: Don't define attribute "+nameval[0]+", it should keep its predefined value: "+nameval[1]);
          }
        }

        /*
  transfer_data.cc:
  // adding fixed attr_items
  attr_items[L"lem"]          = L"(([^<]|\"\\<\")+)";
  attr_items[L"lemq"]        = L"\\#[- _][^<]+";
  attr_items[L"lemh"]        = L"(([^<#]|\"\\<\"|\"\\#\")+)";
  attr_items[L"whole"]       = L"(.+)";
  attr_items[L"tags"]         = L"((<[^>]+>)+)";
  attr_items[L"chname"]    = L"({([^/]+)\\/)"; // includes delimiters { and / !!!
  attr_items[L"chcontent"] = L"(\\{.+)";
  attr_items[L"content"]    = L"(\\{.+)";
 */

/*
  println("ApertiumRE attr_lem = new ApertiumRE(\"(([^<]|\\\"\\\\<\\\")+)\");");
  println("ApertiumRE attr_lemq = new ApertiumRE(\"\\\\#[- _][^<]+\");");
  println("ApertiumRE attr_lemh = new ApertiumRE(\"(([^<#]|\\\"\\\\<\\\"|\\\"\\\\#\\\")+)\");");
  println("ApertiumRE attr_whole = new ApertiumRE(\"(.+)\");");
  println("ApertiumRE attr_tags = new ApertiumRE(\"((<[^>]+>)+)\");");
  //println("ApertiumRE attr_chname = new ApertiumRE(\"({([^/]+)\\\\/)\");"); // includes delimiters { and / !!!
  println("ApertiumRE attr_chname = new ApertiumRE(\"(\\\\{([^/]+)\\\\/)\");"); // includes delimiters { and / !!!
  println("ApertiumRE attr_chcontent = new ApertiumRE(\"(\\\\{.+)\");");
  println("ApertiumRE attr_content = new ApertiumRE(\"(\\\\{.+)\");");
*/

        for (Element c0 : getChildsChildrenElements(root, "section-def-vars")) {
          String n = c0.getAttribute("n");
          varList.add(n);
          String v = c0.getAttribute("v");
          println("String var_"+javaIdentifier(n)+" = \""+v+"\";");
        }

        for (Element c0 : getChildsChildrenElements(root, "section-def-lists")) {
          String n = c0.getAttribute("n");
          ArrayList<String> items = new ArrayList<String>();
          for (Element c1 : listChildren(c0))
            items.add(c1.getAttribute("v"));
          //listList.put(n,new ParseDefList(n, items.toArray(new String[items.size()])));
          listList.add(n);
          println("TransferWordList list_"+javaIdentifier(n)+" = new TransferWordList("+javaStringArray(items)+");");
        }


        for (Element c0 : getChildsChildrenElements(root, "section-def-macros")) {
          currentNode = c0;
          String n = c0.getAttribute("n");
          String npars = c0.getAttribute("npar");
          int npar = npars.length()>0 ?  Integer.parseInt(npars) : 0;
          String par = "";
          currentNumberOfWordInParameterList = npar;
          for (int i=1; i<=npar; i++) par += (i==1?", ":", String "+blank(i-1)+", ")+"TransferWord "+word(i);
          println("");
          macroList.put(n, npar);
          String methodName = "macro_"+javaIdentifier(n);
          println("private void "+methodName+"(Writer out"+par+") throws IOException");
          println("{");
          println("if (debug) { logCall(\""+methodName+"\"); }; "); // TODO Check performance impact
          currentNumberOfWordInParameterList = npar;
          for (Element c1 : listElements(c0.getChildNodes())) processInstruction(c1);
          println("}");
        }


        int ruleNo = 0;
        for (Element c0 : getChildsChildrenElements(root, "section-rules")) {
          currentNode = c0;
          String comment = c0.getAttribute("comment");
          ArrayList<String> patternItems = new ArrayList<String>();

          String methodName = "rule"+(ruleNo++);
          for (Element c1 : getChildsChildrenElements(c0, "pattern")) {
            String n = c1.getAttribute("n");
            methodName += "__"+javaIdentifier(n);
            patternItems.add(n);
          }
          String par = "";
          currentNumberOfWordInParameterList = patternItems.size();
          for (int i=1; i<=currentNumberOfWordInParameterList; i++) par += (i==1?", ":", String "+blank(i-1)+", ")+"TransferWord "+ word(i);
          println("");
          if (!comment.isEmpty()) println("// "+comment);
          println("public void "+methodName+"(Writer out"+par+") throws IOException");
          println("{");
          println("if (debug) { logCall(\""+methodName+"\"); }; "); // TODO Check performance impact
          for (Element c1 : getChildsChildrenElements(c0, "action")) processInstruction(c1);
          println("}");
        }

        // Error handling
        if (error_UNKNOWN_ATTR) {
          println("ApertiumRE error_UNKNOWN_ATTR = new ApertiumRE(\"error_UNKNOWN_ATTR\");");
        }

        if (error_UNKNOWN_VAR) {
          println("String error_UNKNOWN_VAR = \"\";");
        }

        if (error_UNKNOWN_LIST) {
          println("TransferWordList error_UNKNOWN_LIST = new TransferWordList(new String[0]);");
        }

        println("}");


        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: Cannot open '" + file + "'.");
        }
    }


  private static void parseAndWriteToSrc(String t1xFile) throws IOException, InterruptedException {
    ParseTranserFile p=new ParseTranserFile();
    try {
      p.parse(t1xFile);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    Thread.sleep(100);
    System.out.flush();
    System.err.flush();
    Thread.sleep(100);
    System.err.println("p.javaCode = "+p.javaCode);
    Thread.sleep(100);
    System.out.flush();
    System.err.flush();
    Thread.sleep(100);
    //FileWriter fw = new FileWriter("/home/j/esperanto/apertium/apertium-eo-en/"+p.className+"java");
    new File("src/org/apertium/transfer/generated/").mkdirs();
    FileWriter fw=new FileWriter("src/org/apertium/transfer/generated/"+p.className+".java");
    fw.append(p.javaCode);
    fw.close();
  }

    /**
     * Test 
     */
    public static void main(String[] args) throws Exception {

      System.err.println("System.out = " + System.in);
      //parseAndWriteToSrc("/home/j/esperanto/apertium/apertium-eo-en/apertium-eo-en.en-eo.t1x");

      parseAndWriteToSrc("testdata/transfer/apertium-eo-en.en-eo.t1x");
      parseAndWriteToSrc("testdata/transfer/apertium-eo-en.eo-en.t1x");
      parseAndWriteToSrc("testdata/transfer/apertium-nn-nb.nb-nn.t1x");

    //p.parse();
    //p.parse("/home/jim/NetBeansProjects/lttoolbox-java/apertium-en-ca.en-ca.t1x");
    }

}
