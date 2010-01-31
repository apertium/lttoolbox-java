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
import java.util.LinkedHashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import static org.apertium.transfer.compile.DOMTools.*;

/**
 *
 * @author Jacob Nordfalk
 */
public class ParseTranserFile {
  public String className;

  private void append(String str) {
    println("out.append("+str+");");
  }

  private String attrItemRegexp(ArrayList<String> items) {
    StringBuilder re = null;
    for (String item : items) {
      if (re==null) re = new StringBuilder(items.size()*20);
      else re.append( '|');
      re.append( '<');
      re.append(item.replace(".", "><"));
      re.append( '>');
    }
    return re.toString();
  }


  private String evalString(Element e) {
    String n = e.getTagName();
    if (n.equals("clip")) {
      String as = e.getAttribute("link-to");
      String expr=getReadClipExpr(e);

      if (as.isEmpty()) return expr;
      else return "("+expr+".isEmpty()?\"\" : \"<"+e.getAttribute("pos")+">\")";
    } else if (n.equals("var")) {
      return "var_" + e.getAttribute("n");
    } else if (n.equals("lit")) {
      return str(e.getAttribute("v"));
    } else if (n.equals("lit-tag")) {
      return str("<"+e.getAttribute("v").replaceAll("\\.", "><")+">");
    } else if (n.equals("b")) {
      String pos = e.getAttribute("pos");
      if (pos.isEmpty()) return(str(" "));
      else return "blank"+pos;
    } else if (n.equals("get-case-from")) {
      String pos = e.getAttribute("pos");
      String eval = evalString(getFirstChildElement(e));
      boolean cond=!e.getAttribute("queue").equals("no");
      return "TransferWord.copycase(word"+pos+".source(attr_lem, "+cond+"), "+ eval + ")";
    } else if (n.equals("concat")) {
      String res = "("+str("");
      for (Element c : list(e.getChildNodes())) {
        res += "+"+ evalString(c);
      }
      res += ")";
      return res;
    }
    println("// evalString(): not supported yet: "+e);
    return str("");// +"/* not supported yet: "+e + "*/";
  }

  /**
   * Generates Java code for reading the value of a clip
   * @param e the clip tag
   * @return java code
   */
  private String getReadClipExpr(Element e) {
    String side=e.getAttribute("side");
    String part=e.getAttribute("part");
    String pos=e.getAttribute("pos");
    boolean cond=!e.getAttribute("queue").equals("no");
    String expr;
    if (side.equals("sl")) {
      expr="word"+pos+".source(attr_"+part+", "+cond+")";
    } else if (side.equals("tl")) {
      expr="word"+pos+".target(attr_"+part+", "+cond+")";
    } else throw new IllegalArgumentException(side);
    return expr;
  }

  /**
   * Generates Java code for writing to a clip
   * @param e the clip tag
   * @param value new value the clip will get assigned
   * @return java code
   */
  private String getWriteClipExpr(Element e, String value) {
    String side=e.getAttribute("side");
    String part=e.getAttribute("part");
    String pos=e.getAttribute("pos");
    boolean cond=!e.getAttribute("queue").equals("no");
    String expr;
    if (side.equals("sl")) {
      expr="word"+pos+".setSource(attr_"+part+", "+value+", "+cond+");\n";
    } else if (side.equals("tl")) {
      expr="word"+pos+".setTarget(attr_"+part+", "+value+", "+cond+");\n";
    } else throw new IllegalArgumentException(side);
    return expr;
  }

/*
  private String javaCatItemArray(ArrayList<CatItem> items) {
    //new ArrayList<CatItem>(Arrays.asList(new CatItem[] { new CatItem("ss","ss")}));
    String s = "new CatItem[] { ";
    for (CatItem i : items) s += "new CatItem("+str(i.lemma)+","+str(i.tags)+"), ";
    s += "}";
    return s;
  }
*/
  private String javaIdentifier(String str) {
    return str.replaceAll("\\W", "_");
  }

  private String javaStringArray(ArrayList<String> items) {
    String s = "new String[] { ";
    for (String i : items) s += "\""+i+"\", ";
    s += "}";
    return s;
  }

  private void parseError(String string) {
    println(string);
    System.err.println( string);
  }

  private void processAppend(Element instr) {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  private void processCallMacro(Element instr) {
    String n = instr.getAttribute("n");
    String par = "";
    for (Element c : children(instr)) {
      int pos = Integer.parseInt(c.getAttribute("pos"));
      if (par.isEmpty()) par += ", word"+pos;
      else par += (pos>1?", blank"+(pos-1): ", "+str(" ")) + ", word"+pos;
    }
    println("macro_"+n+"(out"+par+");");
  }

  private void processChoose(Element e) {
    boolean first = true;
    for (Element whenC : children(e))
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

  private void processChunk(Element e) {
    String name = e.getAttribute("name");
    String namefromvar = e.getAttribute("namefrom");
    String caseofchunkvar = e.getAttribute("case");
//    if (caseofchunkvar.isEmpty()) caseofchunkvar = "aa";
//    else println("// not supported yet: case");

    if (caseofchunkvar.isEmpty()) {
      if (!name.isEmpty()) append(str("^"+name));
      else if (!namefromvar.isEmpty()) append(str("^")+"+var_"+namefromvar);
      else parseError("//Error: you must specify either 'name' or 'namefrom' for the 'chunk' element");
    } else {
      if (!name.isEmpty()) append(str("^")+"+TransferWord.copycase(var_"+caseofchunkvar+", "+str(name)+")");
      else if (!namefromvar.isEmpty()) append(str("^")+"+TransferWord.copycase(var_"+caseofchunkvar+", var_"+namefromvar+")");
      else parseError("//Error: you must specify either 'name' or 'namefrom' for the 'chunk' element");
    }


    for (Element c0 : children(e)) {
      String n = c0.getTagName();
      if (n.equals("tags")) {
        for (Element tag : children(c0))
          append(evalString(findElementSibling(tag.getFirstChild())));
        append("'{'");
      } else if (n.equals("lu")) {
        append("'^'");
        for (Element lu : children(c0))
          append(evalString(lu));
        append("'$'");
      } else if (n.equals("mlu")) {
        append("'^'");
        for (java.util.Iterator<Element> it = children(c0).iterator(); it.hasNext();) {
            Element mlu = it.next();
            for (Element lu : children(mlu)) {
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

  private String processEqual(Element e) {
    Element first = findElementSibling(e.getFirstChild());
    Element second = findElementSibling(first.getNextSibling());
    boolean caseless = "yes".equals(e.getAttribute("caseless"));

    if (caseless) {
      return "("+ evalString(first)+").equalsIgnoreCase("+evalString(second)+")";
    } else {
      return "("+ evalString(first)+").equals("+evalString(second)+")";
    }
  }

  private String processIn(Element e) {
    Element first = getFirstChildElement(e);
    Element second = findElementSibling(first.getNextSibling());
    String listName = "list_"+second.getAttribute("n");

    if (e.getAttribute("caseless").equals("yes")) {
      return listName +".containsIgnoreCase("+evalString(first)+")";
    }
    return listName +".contains("+evalString(first)+")";
  }

  private void processInstruction(Element instr) {
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
      System.err.println("processInstruction(n = " + n);
  }

  private void processLet(Element instr) {
    Element leftSide = findElementSibling(instr.getFirstChild());
    Element rightSide = findElementSibling(leftSide.getNextSibling());

    String n = leftSide.getTagName();
    if (n.equals("var")) {
      println("var_"+leftSide.getAttribute("n")+" = " + evalString(rightSide)+ ";");
    } else if (n.equals("clip")) {
      print(getWriteClipExpr(leftSide, evalString(rightSide)));
    } else throwParseError(n);
  }


  String processLogical(Element e) {
    String n=e.getTagName();

    if (n.equals("equal")) {
      return processEqual(e);
    /* TODO
    } else if (n.equals("begins-with")) {
      return processBeginsWith(e);
    } else if (n.equals("begins-with-list")) {
      return processBeginsWithList(e);
    } else if (n.equals("ends-with")) {
      return processEndsWith(e);
    } else if (n.equals("ends-with-list")) {
      return processEndsWithList(e);
    } else if (n.equals("contains-substring")) {
      return processContainsSubstring(e);
     */
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
    System.err.println("not supported: processLogical(c0 = "+e);
    return "false /*not supported: processLogical("+e+" */";
  }

  private void processModifyCase(Element instr) {
    Element leftSide = findElementSibling(instr.getFirstChild());
    Element rightSide = findElementSibling(leftSide.getNextSibling());

    String n = leftSide.getTagName();
    if (n.equals("var")) {
      String var = "var_"+leftSide.getAttribute("n");
      println(var+" = TransferWord.copycase(" + evalString(rightSide)+ ", "+var+");");
    } else if (n.equals("clip")) {
      print(getWriteClipExpr(leftSide, "TransferWord.copycase("+evalString(rightSide)+", "+getReadClipExpr(leftSide)+")"));
    } else throwParseError(n);
  }

  private void processOut(Element instr) {
    // XXX TODO lu not supported
    for (Element e : children(instr)) {
      String n = e.getTagName();
      if (n.equals("chunk")) processChunk(e);
      else append( evalString(e) );
    }
  }

  private String str(String n) {
    if (n==null) return "null";
    return "\""+n+"\"";
  }


//  Appendable javaCode = System.out; // new StringBuilder(1000);
  StringBuilder javaCode = new StringBuilder(1000);

  private void println(String string) {
    print(string+"\n");
  }

  private void print(String string) {
     javaCode.append(string);
     //System.err.print(string);
  }

  private void throwParseError(String n) {
    throw new UnsupportedOperationException("Not yet implemented:"+n);
  }


/*
public class CatItem {
  String lemma;
  String tags;

  public CatItem(String lem, String ta) {
      lemma = lem; tags = ta;
    }
    @Override
  public String toString() { return "item[l="+lemma + ",t="+tags+"]"; }
}

class DefCat {
  String n;
  CatItem[] items;

  public DefCat(String n, CatItem[] items) {
      this.n = n; this.items = items;
  }

  @Override
  public String toString() { return "def-cat n="+n+":"+items; }
}
*/
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
      println("public class "+className+" {");

      try {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(file));
        Element root = doc.getDocumentElement();

        //LinkedHashMap<String,DefCat> defCats = new LinkedHashMap<String,DefCat>();
        LinkedHashMap<String,ParseApertiumRE> defAttrs = new LinkedHashMap<String,ParseApertiumRE>();
        ArrayList<String> defVars = new ArrayList<String>();
        LinkedHashMap<String,ParseDefList> defLists = new LinkedHashMap<String,ParseDefList>();

        /*
        for (Element c0 : getChildsChildrenElements(root, "section-def-cats")) {
          String n = c0.getAttribute("n");
          ArrayList<CatItem> items = new ArrayList<CatItem>();
          for (Element c1 : children(c0)) {
            items.add(new CatItem(c1.getAttribute("lemma"), c1.getAttribute("tags")));
          }
          defCats.put(n,new DefCat(n, items.toArray(new CatItem[items.size()])));
          println("DefCat cat_"+n+" = new DefCat("+str(n)+", "+javaCatItemArray(items)+");");
        }*/

        ArrayList<String> attList = new ArrayList<String>();


        for (Element c0 : getChildsChildrenElements(root, "section-def-attrs")) {
          String n = c0.getAttribute("n");
          ArrayList<String> items = new ArrayList<String>();
          for (Element c1 : children(c0))
            items.add(c1.getAttribute("tags"));
          defAttrs.put(n,new ParseApertiumRE(n, items.toArray(new String[items.size()])));
          println("ApertiumRE attr_"+n+" = new ApertiumRE(\""+attrItemRegexp(items)+"\");");
          attList.add("attr_"+n);
        }

        println("public void initAttrLists(ApertiumRE[] attrList) {");
        int no = 0;
        for (String name : attList) println(name +" = attrList["+no++ +"];");
        println("}");

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
  println("ApertiumRE attr_lem = new ApertiumRE(\"(([^<]|\\\"\\\\<\\\")+)\");");
  println("ApertiumRE attr_lemq = new ApertiumRE(\"\\\\#[- _][^<]+\");");
  println("ApertiumRE attr_lemh = new ApertiumRE(\"(([^<#]|\\\"\\\\<\\\"|\\\"\\\\#\\\")+)\");");
  println("ApertiumRE attr_whole = new ApertiumRE(\"(.+)\");");
  println("ApertiumRE attr_tags = new ApertiumRE(\"((<[^>]+>)+)\");");
  //println("ApertiumRE attr_chname = new ApertiumRE(\"({([^/]+)\\\\/)\");"); // includes delimiters { and / !!!
  println("ApertiumRE attr_chname = new ApertiumRE(\"(\\\\{([^/]+)\\\\/)\");"); // includes delimiters { and / !!!
  println("ApertiumRE attr_chcontent = new ApertiumRE(\"(\\\\{.+)\");");
  println("ApertiumRE attr_content = new ApertiumRE(\"(\\\\{.+)\");");


        for (Element c0 : getChildsChildrenElements(root, "section-def-vars")) {
          String n = c0.getAttribute("n");
          defVars.add(n);
          String v = c0.getAttribute("v");
          println("String var_"+n+" = \""+v+"\";");
        }

        for (Element c0 : getChildsChildrenElements(root, "section-def-lists")) {
          String n = c0.getAttribute("n");
          ArrayList<String> items = new ArrayList<String>();
          for (Element c1 : children(c0))
            items.add(c1.getAttribute("v"));
          defLists.put(n,new ParseDefList(n, items.toArray(new String[items.size()])));
          println("TransferWordList list_"+n+" = new TransferWordList("+javaStringArray(items)+");");
        }


        for (Element c0 : getChildsChildrenElements(root, "section-def-macros")) {
          String n = c0.getAttribute("n");
          int npar = Integer.parseInt(c0.getAttribute("npar"));
          String par = "";
          for (int i=1; i<=npar; i++) par += (i==1?", ":", String blank"+(i-1)+", ")+"TransferWord word"+i;
          println("");
          println("void macro_"+n+"(Writer out"+par+") throws IOException");
          println("{");
          for (Element c1 : list(c0.getChildNodes())) processInstruction(c1);
          println("}");
        }


        int ruleNo = 0;
        for (Element c0 : getChildsChildrenElements(root, "section-rules")) {
          String comment = c0.getAttribute("comment");
          ArrayList<String> patternItems = new ArrayList<String>();

          String methodName = "rule"+(ruleNo++);
          for (Element c1 : getChildsChildrenElements(c0, "pattern")) {
            String n = c1.getAttribute("n");
            methodName += "__"+n;
            patternItems.add(n);
          }
          String par = "";
          for (int i=1; i<=patternItems.size(); i++) par += (i==1?", ":", String blank"+(i-1)+", ")+"TransferWord word"+i;
          println("");
          if (!comment.isEmpty()) println("// "+comment);
          println("public void "+methodName+"(Writer out"+par+") throws IOException");
          println("{");
          for (Element c1 : getChildsChildrenElements(c0, "action")) processInstruction(c1);
          println("}");
        }
        println("}");


        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: Cannot open '" + file + "'.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParserConfigurationException {
        // TODO code application logic here
      ParseTranserFile p = new ParseTranserFile();
    try {
      //p.parse("/home/j/esperanto/apertium/apertium-eo-en/apertium-eo-en.eo-en.t1x");
      p.parse("/home/jim/NetBeansProjects/lttoolbox-java/apertium-en-ca.en-ca.t1x");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
      System.out.flush();
      System.err.flush();
      System.out.println("p.javaCode = " + p.javaCode);
      //FileWriter fw = new FileWriter("/home/j/esperanto/apertium/apertium-eo-en/"+p.className+"java");
      new File("src/org/apertium/transfer/generated/").mkdirs();
      FileWriter fw = new FileWriter("src/org/apertium/transfer/generated/"+p.className+".java");
      fw.append(p.javaCode);
      fw.close();
      System.out.flush();
    }

}
