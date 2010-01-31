/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.transfer;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.apertium.lttoolbox.Alphabet;
import org.apertium.lttoolbox.Compression;
import org.apertium.lttoolbox.Pair;
import org.apertium.lttoolbox.compile.Transducer;
import org.apertium.lttoolbox.process.Buffer;
import org.apertium.lttoolbox.process.FSTProcessor;
import org.apertium.lttoolbox.process.SetOfCharacters;
import org.apertium.lttoolbox.process.TransExe;
import org.apertium.transfer.TransferToken;

/**
 *
 * @author Jacob Nordfalk
 */
public class Transfer {

  public Alphabet alphabet=new Alphabet();
  String TRXReader__ANY_CHAR="<ANY_CHAR>";
  String TRXReader__ANY_TAG="<ANY_TAG>";
  private MatchExe me;
  MatchState ms=new MatchState();
  LinkedHashMap<String, ApertiumRE> attr_items = new LinkedHashMap<String, ApertiumRE>(); //   map<string, ApertiumRE, Ltstr> attr_items;
  LinkedHashMap<String, String> variables = new LinkedHashMap<String, String>(); // map<string, string, Ltstr> variables;  
  LinkedHashMap<String, Integer> macros= new LinkedHashMap<String, Integer>(); // map<string, int, Ltstr> macros;
  
  /*  
  map<string, set<string, Ltstr>, Ltstr> lists;
  map<string, set<string, Ltstr>, Ltstr> listslow;
  vector<xmlNode *> macro_map;
  xmlDoc *doc;
  xmlNode *root_element;
   */
  Method[] rule_map=null;// vector<xmlNode *> rule_map;
  int lword, lblank;
  BufferT<TransferToken> input_buffer=new BufferT<TransferToken>();
  ArrayList<String> tmpword=new ArrayList<String>();
  ArrayList<String> tmpblank=new ArrayList<String>();
  ArrayList<String> tmpword2=new ArrayList<String>();
  ArrayList<String> tmpblank2=new ArrayList<String>();
  FSTProcessor fstp;
  FSTProcessor extended;
  boolean isExtended;
  private int any_char;
  private int any_tag;
  Method lastrule; //xmlNode *lastrule;
  int nwords;
  private Object transferObject;
  private Class transferClass;

  private boolean DEBUG = false;

  private void fputwc_unlocked(char c, Writer output) throws IOException {
    output.append(c);
  }

  private void fputws_unlocked(String first, Writer output) throws IOException {
    output.append(first);
  }



  //map<xmlNode *, TransferInstr> evalStringCache;
  enum OutputType {

    lu, chunk
  };
  OutputType defaultAttrs;
  boolean useBilingual=true;
  boolean null_flush;
  boolean internal_null_flush;

  public void readData(InputStream in) throws IOException {

    // symbols
    alphabet=Alphabet.read(in);
    any_char=alphabet.cast(TRXReader__ANY_CHAR);
    any_tag=alphabet.cast(TRXReader__ANY_TAG);

    Transducer t=Transducer.read(in, alphabet.size());
    //System.err.println("  t = " + t.toString());


    HashMap<Integer, Integer> finals=new HashMap<Integer, Integer>();
    // finals
    for (int i=0, limit=Compression.multibyte_read(in); i!=limit; i++) {
      int key=Compression.multibyte_read(in);
      finals.put(key, Compression.multibyte_read(in));
    }

    //System.err.println("finals = " + finals);

    me=new MatchExe(t, finals);

  //System.err.println("me = " + me);

  // attr_items
  for(int i = 0, limit = Compression.multibyte_read(in); i != limit; i++)
  {
    String cad_k = Compression.wstring_read_toUtf8(in);
    ApertiumRE re = new ApertiumRE();
    int size = Compression.multibyte_read(in);
    byte[] reb = new byte[size];
    in.read(reb);
    //System.err.println("ApertiumRE.read(size = " + size+": "+new String(reb,"UTF-8")+ Arrays.toString(reb));
    attr_items.put(cad_k, re);

    //System.err.println("cad_k = " + cad_k);
  }

    if (DEBUG) System.err.println("attr_items = " + attr_items);

  // variables
  for(int i = 0, limit = Compression.multibyte_read(in); i != limit; i++)
  {
    String cad_k = Compression.wstring_read_toUtf8(in);
    variables.put(cad_k, Compression.wstring_read_toUtf8(in));
  }
    if (DEBUG) System.err.println("variables = " + variables);

  // macros
  for(int i = 0, limit = Compression.multibyte_read(in); i != limit; i++)
  {
    String cad_k = Compression.wstring_read_toUtf8(in);
    macros.put(cad_k, Compression.multibyte_read(in));
  }
    if (DEBUG) System.err.println("macros = " + macros);
/*
  // lists
  for(int i = 0, limit = Compression.multibyte_read(in); i != limit; i++)
  {
  string const cad_k = Compression.wstring_read_toUtf8(in);

  for(int j = 0, limit2 = Compression.multibyte_read(in); j != limit2; j++)
  {
  String const cad_v = Compression.String_read(in);
  lists[cad_k].insert(UtfConverter.toUtf8(cad_v));
  listslow[cad_k].insert(UtfConverter.toUtf8(StringUtils.tolower(cad_v)));
  }
   */


  }

  private void readBil(String fstfile) throws IOException {
    fstp=new FSTProcessor();
    fstp.load(new BufferedInputStream(new FileInputStream(fstfile)));
    fstp.initBiltrans();
  //String output = fstp.biltrans("house<n><sg>" , false);
  //System.err.println("output = " + output);
  }

  private void setExtendedDictionary(String fstfile) throws IOException {
    extended=new FSTProcessor();
    extended.load(new BufferedInputStream(new FileInputStream(fstfile)));
    extended.initBiltrans();
  }

  public void read(String classFile, String datafile, String fstfile) throws Exception {
    /*
    if (classFile.endsWith(".java")) {
        com.sun.tools.javac.Main oversætter = new com.sun.tools.javac.Main();
        String[] filer = { classFile };
        oversætter.compile( filer );
        classFile = classFile.substring(0,classFile.length())
    }
    */

    read(new MyClassLoader().loadClass(classFile), datafile, fstfile);
  }


  public void read(Class transferClass, String datafile, String fstfile) throws Exception {

    InputStream is = new BufferedInputStream(new FileInputStream(datafile));
    readData(is);
    is.close();


    Method[] mets =  transferClass.getMethods();
    rule_map = new Method[mets.length];

    for (Method method : mets) {
      String name = method.getName();

      //System.err.println("n = " + name);
      if (!name.startsWith("rule")) continue;

      int number = Integer.parseInt(name.substring(4, name.indexOf('_',5)));
      rule_map[number] = method;

      if (DEBUG) System.err.println(method.getName()+"  - #words=" +method.getParameterTypes().length/2 );
    }

    transferObject = transferClass.newInstance();

    if (fstfile!=null&&fstfile.length()>0) {
      readBil(fstfile);
    }
  }

  // this and the following methods should not implemented, as we use bytecode compiled transfer
  private void readTransfer() {
    throw new UnsupportedOperationException("Not implemented (and should not be)");
  }

  TransferToken readToken(Reader in) throws IOException {
    if (!input_buffer.isEmpty()) {
      return input_buffer.next();
    }

    String content="";
    while (true) {
      int val=in.read();
      if (val==-1||(val==0&&internal_null_flush)) {
        return input_buffer.add(new TransferToken(content, TransferToken.TransferTokenType.tt_eof));
      }
      if (val=='\\') {
        content+='\\';
        content+=(char) in.read();
      } else if (val=='[') {
        content+='[';
        while (true) {
          int val2=in.read();
          if (val2=='\\') {
            content+='\\';
            content+=(char) in.read();
          } else if (val2==']') {
            content+=']';
            break;
          } else {
            content+=(char) val2;
          }
        }
      } else if (val=='$') {
        return input_buffer.add(new TransferToken(content, TransferToken.TransferTokenType.tt_word));
      } else if (val=='^') {
        return input_buffer.add(new TransferToken(content, TransferToken.TransferTokenType.tt_blank));
      } else {
        content+=(char) val;
      }
    }
  }

  public boolean getnullFlush() {
    return nullFlush;
  }
  /**
   * if true, flush the output when the null character is found
   */
  private boolean nullFlush=false;

  public void setnullFlush(boolean value) {
    nullFlush=value;
  }

  private void transfer_wrapper_null_flush(Reader input, Writer output) throws Exception {
    setnullFlush(false);
    while (input.ready()) {
      transfer(input, output);
      output.write('\0');
      try {
        output.flush();
      } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Could not flush output");
      }
    }
  }

  public void transfer(Reader in, Writer output) throws Exception {
    if (getnullFlush()) {
      transfer_wrapper_null_flush(in, output);
    }

    int last=0;
    ms.init(me.getInitial());
    while (true) {
      if (ms.size()==0) {
        if (lastrule!=null) {
          applyRule(output);
          input_buffer.setPos(last);
        } else {
          if (tmpword.size()!=0) {
            Pair<String, Integer> tr;
            if (useBilingual) {
              if (isExtended&&(tmpword.get(0)).charAt(0)=='*') {
                tr=extended.biltransWithQueue((tmpword.get(0)).substring(1), false);
                if (tr.first.charAt(0)=='@') {
                  tr.first='*'+tr.first.substring(1);
                } else {
                  tr.first="%"+tr.first;
                }
              } else {
                tr=fstp.biltransWithQueue(tmpword.get(0), false);
              }
            } else {
              tr=new Pair<String, Integer>(tmpword.get(0), 0);
            }

            if (tr.first.length()!=0)
            {
              if (defaultAttrs==OutputType.lu)
              {
                fputwc_unlocked('^', output);
                fputws_unlocked(tr.first, output);
                fputwc_unlocked('$', output);
              } 
              else
              {
                if (tr.first.charAt(0)=='*')
                {
                  fputws_unlocked("^unknown<unknown>{^", output);
                }
                else
                {
                  fputws_unlocked("^default<default>{^", output);
                }
                fputws_unlocked(tr.first, output);
                fputws_unlocked("$}$", output);
              }
            }
            tmpword.clear();
            input_buffer.setPos(last);
            input_buffer.next();
            last=input_buffer.getPos();
            ms.init(me.getInitial());
          } 
          else if (tmpblank.size()!=0)
          {
            fputws_unlocked(tmpblank.get(0), output);
            tmpblank.clear();
            last=input_buffer.getPos();
            ms.init(me.getInitial());
          }
        }
      }
      int val=ms.classifyFinals(me.getFinals());
      if (val!=-1) {

        lastrule=rule_map[(val-1)];
        // XXXXXXXX lastrule = rule_map.get(val-1);
        last=input_buffer.getPos();

        if (DEBUG) System.err.println("lastrule = "+(val-1)+ " "+lastrule.getName());
        if (DEBUG) System.err.println("tmpword = " + tmpword.size()+ "  tmpblank = " + tmpblank.size());
        if (DEBUG) System.err.println("tmpword = " + tmpword+ "  tmpblank = " + tmpblank);
    tmpword2.clear();
    tmpblank2.clear();
        tmpword2.addAll(tmpword);
        tmpblank2.addAll(tmpblank);
      }

      TransferToken current=readToken(in);

      switch (current.type) {
        case tt_word:
          applyWord(current.content);
          tmpword.add(current.content);
          break;

        case tt_blank:
          ms.step(' ');
          tmpblank.add(current.content);
          break;

        case tt_eof:
          if (tmpword.size()!=0) {
            tmpblank.add(current.content);
            ms.clear();
          } else {
            fputws_unlocked(current.content, output);
            return;
          }
          break;

        default:

          System.err.println("Error: Unknown input token.");
          return;
      }
    }
  }

  private void applyRule(Writer output) throws Exception {
    if (DEBUG) System.err.println("tmpword = " + tmpword2+ "  tmpblank = " + tmpblank2);

    int limit=tmpword2.size();

    Object[] args = new Object[1+limit + limit -1];
    int argn = 0;
    args[argn++] = output;


  TransferWord[] word=null; // TransferWord **word;
  String[] blank=null; // string **blank;

  for (int i=0; i!=limit; i++)
    {
      if (i==0)
      {
        word=new TransferWord[limit];
        lword=limit;
        if (limit!=0)
        {
          blank=new String[limit-1];
          lblank=limit-1;
        } else
        {
          blank=null;
          lblank=0;
        }
      }
      else
      {
        blank[i-1]=tmpblank2.get(i-1);
        args[argn++] = tmpblank2.get(i-1);
      }

      Pair<String, Integer> tr;
      if (useBilingual)
      {
        tr=fstp.biltransWithQueue(tmpword2.get(i), false);
      } 
      else
      {
        tr=new Pair<String, Integer>(tmpword2.get(i), 0);
      }

      args[argn++] = word[i]=new TransferWord(tmpword2.get(i), tr.first, tr.second);
    }



    if (DEBUG) System.err.println("word = " + Arrays.toString(word));

    if (DEBUG) System.err.println("#args = " + args.length);
    if (DEBUG) System.err.println("processRule:"+lastrule.getName()+"("+Arrays.toString(args));
    lastrule.invoke(transferObject, args);
    
    //processRule(lastrule);
    lastrule=null;

    word=null;
    blank=null;
    tmpword.clear();
    tmpblank.clear();
    tmpword2.clear();
    tmpblank2.clear();
    ms.init(me.getInitial());
  }

  void applyWord(String word_str) {
    ms.step('^');
    for (int i=0, limit=word_str.length(); i<limit; i++) {
      switch (word_str.charAt(i)) {
        case '\\':
          i++;
          ms.step(Character.toLowerCase(word_str.charAt(i)), any_char);
          break;

        case '<':
          for (int j=i+1; j!=limit; j++) {
            if (word_str.charAt(j)=='>') {
              int symbol=alphabet.cast(word_str.substring(i, j+1));
              if (symbol!=0) {
                ms.step(symbol, any_tag);
              } else {
                ms.step(any_tag);
              }
              i=j;
              break;
            }
          }
          break;

        default:
          ms.step(Character.toLowerCase(word_str.charAt(i)), any_char);
          break;
      }
    }
    ms.step('$');
  }


    public static void main(String[] args) throws Exception {
      Transfer t = new Transfer();
      String dir = "testdata/transfer/";

      Class transferClass =
       Class.forName("org.apertium.transfer.generated.apertium_eo_en_en_eo_t1x");


      t.read(transferClass, dir+"en-eo.t1x.bin", dir+"en-eo.autobil.bin");


      //t.read(args[0], args[1], args[2]);
      //t.transfer(new InputStreamReader( System.in ),  new OutputStreamWriter(System.out));

      Reader input = new FileReader(dir+"transferinput-en-eo.t1x.txt");
      //StringReader input = new StringReader("^Prpers<prn><subj><p3><m><sg>$ ^see<vblex><past>$ ^the<det><def><sp>$ ^saw<n><sg>$^'s<gen>$ ^tooth<n><sg>$   ^.<sent>$  \n");
      //Writer output = new StringWriter(); //new PrintWriter(System.err); //
      //Writer output = new OutputStreamWriter(System.out);
      Writer output = new FileWriter("/tmp/transferinput-en-eo.t1x.txt");
      t.transfer( input, output);
      output.flush();
      System.err.println("transfer output = " + output);

    }

}



class MyClassLoader extends ClassLoader {

    @Override
    public Class loadClass(String filename) throws ClassNotFoundException {
        try {
            URL myUrl = new URL(filename);
            URLConnection connection = myUrl.openConnection();
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();
            while(data != -1){
                buffer.write(data);
                data = input.read();
            }
            input.close();
            byte[] classData = buffer.toByteArray();
            return defineClass(null, classData, 0, classData.length);
        } catch (MalformedURLException e) {
          e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}