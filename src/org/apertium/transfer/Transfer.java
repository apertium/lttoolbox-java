/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.transfer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import org.apertium.lttoolbox.Alphabet;
import org.apertium.lttoolbox.Pair;
import org.apertium.lttoolbox.process.FSTProcessor;
import org.apertium.transfer.development.Timing;
import org.apertium.transfer.generated.GeneratedTransferBase;



/**
 * Java port of transfer.
<pre>
The Java port of transfer differs from the C++ version in some very important ways:

I will take apertium-eo-en (which works as 'pure' C++ as well as 'Java verson') as example.

And here you just *must* be able to debug the Java code step-by-step. Its mandatory to step-by-step the whole TransferEoEnTest.java test class.




In transfer three things are happening.
1) words are input in one language (English) and output in another (Esperanto)
2) some rules are matched (for example adjective_noun)
3) for each rule matched a transfer action is being done

1) is called bilingual transfer. Here you have for each word a SL (source language - English) and a TL (target language - Esperanto) - see TransferWord. C++ and Java are same.

2) the rule MATCHING, is done by the FSTProcessor. This is normally used to match letters in a word, but can also be used to match a sequence of words. C++ and Java are same.

3) the rule EXECUTING is done completely different in C++ and Java! In C++ we interpret XML, in Java we execute bytecode.




To Compile a transfer file, e.g. apertium-eo-en.en-eo.t1x, together with the bilingual dictionary, apertium-eo-en.eo-en.dix, type:

First validate (optional steps):
$ apertium-validate-dictionary apertium-eo-en.eo-en.dix
$ apertium-validate-transfer apertium-eo-en.en-eo.t1x

C++ and Java:
$ lt-comp rl apertium-eo-en.eo-en.dix en-eo.autobil.bin
(gives en-eo.autobil.bin - the bilingual dictionary, ie translating words from en to eo)
$ apertium-preprocess-transfer apertium-eo-en.en-eo.t1x en-eo.t1x.bin
(gives en-eo.t1x.bin - the transfer rule MATCHING/EXECUTING file)

C++ only: Slow (interpreted) transfer
Here is how to execute in C++ (for 'blue cats')
$ echo "^blue<adj>$ ^cat<n><pl>$" | apertium-transfer apertium-eo-en.en-eo.t1x en-eo.t1x.bin en-eo.autobil.bin
^preadv?_adj_nom<SN><pl><nom>{^blua<adj><2><3>$ ^kato<n><pl><3>$}$

Here step 3 is done by INTERPRETING the XML in the first file (apertium-eo-en.en-eo.t1x)


Only Java:
$ apertium-preprocess-transfer-bytecode-j apertium-eo-en.en-eo.t1x en-eo.t1x.class
(gives en-eo.t1x.class  - the rule EXECUTING file)

Java only: Fast (bytecode) transfer
$ echo "^blue<adj>$ ^cat<n><pl>$" | apertium-transfer-j en-eo.t1x.class apertium-eo-en.en-eo.t1x en-eo.t1x.bin en-eo.autobil.bin
^preadv?_adj_nom<SN><pl><nom>{^blua<adj><2><3>$ ^kato<n><pl><3>$}$
(must give same output, of course)

Here step 3 is done by EXECUTING the bytecode in the first file (apertium-eo-en.en-eo.t1x)



So, you see:  en-eo.t1x.bin is for rule matching (much like the other .bin files, they are just for matching words).
In the end of en-eo.t1x.bin some stuff is added which makes the C++ version run faster (attr_items, variables, macros, lists). We ignore that as its compiled into the bytecode (see Transfer.java public void readData() line 96-141).

In Transfer.java public void transfer() you see the main loop, collecting characters.  If you want to see how the rule match works, set debug breakpoints in ms.step() and look.  ms.classifyFinals() gives the rule index that was matched.


And now we get to the essential step 3:

In Java code, we use that to look up (in Method[] rule_map) some code to invoke.

In C++ code there is a pure XML HELL, jumping around like something jumping very badly (and taking aaages of time).


So, how do we set up the array of rule_map Method?

Well, during compilation the ParseTransferFile.java takes the XML hell of for example apertium-eo-en.en-eo.t1x, and converts it into Java code like the apertium_eo_en_eo_en_t1x java class (in package org.apertium.transfer.generated), which is loaded during runtime.

So the array of rule_map Method is taken by introspection, taking all methods beginning with rule<number>, like rule0__la__num_ord__de__monato, rule1__de_ekde__tempo etc etc and kicks them into the array.


Now, the transfer code could need a big cleanup. This is the stuff I experimented most with. Rename stuff in the code, comment it as hell, etc. Please make sure more or less evrything I covered above (and what you self found out) gets in somewhere in the documentation.
</pre>
 * @author Jacob Nordfalk
 */
public class Transfer {

  public Alphabet alphabet=new Alphabet();
  private String TRXReader__ANY_CHAR="<ANY_CHAR>";
  private String TRXReader__ANY_TAG="<ANY_TAG>";
  private MatchExe me;
  private MatchState ms;
  //private LinkedHashMap<String, ApertiumRE> attr_items = new LinkedHashMap<String, ApertiumRE>(); //   map<string, ApertiumRE, Ltstr> attr_items;
  //private LinkedHashMap<String, String> variables = new LinkedHashMap<String, String>(); // map<string, string, Ltstr> variables;
  //private LinkedHashMap<String, Integer> macros= new LinkedHashMap<String, Integer>(); // map<string, int, Ltstr> macros;
  

  /**
   *
So, how do we set up the array of rule_map Method?
Well, during compilation the ParseTransferFile.java takes the XML hell of for example apertium-eo-en.en-eo.t1x, and converts it into Java code like the apertium_eo_en_eo_en_t1x java class (in package org.apertium.transfer.generated), which is loaded during runtime.
So the array of rule_map Method is taken by introspection, taking all methods beginning with rule<number>, like rule0__la__num_ord__de__monato, rule1__de_ekde__tempo etc etc and kicks them into the array.
   */
  private Method[] rule_map=null;// vector<xmlNode *> rule_map;

  private BufferT<TransferToken> input_buffer=new BufferT<TransferToken>();
  private ArrayList<String> tmpword=new ArrayList<String>();
  private ArrayList<String> tmpblank=new ArrayList<String>();
  private ArrayList<String> tmpword2=new ArrayList<String>();
  private ArrayList<String> tmpblank2=new ArrayList<String>();
  private FSTProcessor fstp =new FSTProcessor();
  private FSTProcessor extended;
  private boolean isExtended;
  private int any_char;
  private int any_tag;
  private Method lastrule; //xmlNode *lastrule;
  public GeneratedTransferBase transferObject;

  public static boolean DEBUG = false;


  //map<xmlNode *, TransferInstr> evalStringCache;
  private boolean useBilingual=true;
  /**
   * if true, flush the output when the null character is found
   */
  private boolean null_flush;
  private boolean internal_null_flush;

  public void readData(InputStream in) throws IOException {

    // symbols
    alphabet=Alphabet.read(in);
    any_char=alphabet.cast(TRXReader__ANY_CHAR);
    any_tag=alphabet.cast(TRXReader__ANY_TAG);

    //System.err.println("  timing = " + timing.toString());

    /* old code
     * 
    HashMap<Integer, Integer> finals=new HashMap<Integer, Integer>();
    // finals
    for (int i=0, limit=Compression.multibyte_read(in); i!=limit; i++) {
      int key=Compression.multibyte_read(in);
      finals.put(key, Compression.multibyte_read(in));
    }

    me=new MatchExe(t, finals);
     */

    // faster - let it read itselv, thus no need to make a big hashmap
    me=new MatchExe(in, alphabet.size());
    ms =new MatchState(me);
  //System.err.println("me = " + me);

    
/*  Rest of data file is not used

  // attr_items
  for(int i = 0, limit = Compression.multibyte_read(in); i != limit; i++)
  {
    String cad_k = Compression.wstring_read_toUtf8(in);
    //ApertiumRE re = new ApertiumRE();
    int size = Compression.multibyte_read(in);
    byte[] reb = new byte[size];
    in.read(reb);
    //System.err.println("ApertiumRE.read(size = " + size+": "+new String(reb,"UTF-8")+ Arrays.toString(reb));
    //attr_items.put(cad_k, re);

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

  /**
   * Read bilingual dictionary
   * @param bilFstFile file name
   */
  private void readBil(String bilFstFile) throws IOException {
    InputStream is = new BufferedInputStream(new FileInputStream(bilFstFile));
    fstp.load(is);
    is.close();
    fstp.initBiltrans();
  }

  /**
   * What is 'extended mode' ?? Hints:
   *       apertium-transfer -x extended trules preproc biltrans [input [output]]
   *  -x bindix  extended mode with user dictionary
   * @param fstfile
   */
  private void setExtendedDictionary(String fstfile) throws IOException {
    extended=new FSTProcessor();
    InputStream is = new BufferedInputStream(new FileInputStream(fstfile));
    extended.load(is);
    is.close();
    extended.initBiltrans();
    isExtended = true;
  }

  /**
   * Reads data
   * @param classFile the file name of the java bytecode file containing the transfer instructions
   *  so, preprocessed by, apertium-preprocess-transfer-bytecode-j  (.class)
   * @param datafile same file, preprocessed by, apertium-preprocess-transfer  (.bin)
   * @param bilFstFile bilingual FST file - might be null
   */
  public void read(String classFile, String datafile, String bilFstFile) throws Exception {
    if (!classFile.endsWith(".class")) {
      System.err.println("Warning: " + classFile+ " should be a Java .class file. You probably got it wrong");
    }

    read(new TransferClassLoader().loadClassFile(classFile), datafile, bilFstFile);
//    read(apertium_nn_nb_nb_nn_t1x.class, "testdata/transfer/nb-nn.t1x.bin", fstfile);
  }


  @SuppressWarnings("unchecked")
  public void read(Class transferClass, String datafile, String bilFstFile) throws Exception {

    InputStream is = new BufferedInputStream(new FileInputStream(datafile));
    readData(is);
    is.close();

    Method[] mets =  transferClass.getMethods();
    rule_map = new Method[mets.length];

    // Find all methods starting with name 'rule'
    // So the array of rule_map Method is taken by introspection, taking all methods beginning with rule<number>,
    // like rule0__la__num_ord__de__monato, rule1__de_ekde__tempo etc etc and kicks them into the array.
    for (Method method : mets) {
      String name = method.getName();
      if (!name.startsWith("rule")) continue;
      int number = Integer.parseInt(name.substring(4, name.indexOf('_',5)));
      rule_map[number] = method;
      if (DEBUG) System.err.println(method.getName()+"  - #words=" +method.getParameterTypes().length/2 );
    }

    transferObject = (GeneratedTransferBase) transferClass.newInstance();
    transferObject.debug = DEBUG;
    transferObject.init();

    if (bilFstFile!=null&&bilFstFile.length()>0) {
      readBil(bilFstFile);
    }
  }

  // this and the following methods should not implemented, as we use bytecode compiled transfer
  //private void readTransfer() {
  //  throw new UnsupportedOperationException("Not implemented (and should not be)");
  //}

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

  public boolean getNullFlush() {
    return null_flush;
  }

  public void setNullFlush(boolean b) {
    null_flush=b;
  }


  private void transfer_wrapper_null_flush(Reader input, Writer output) throws Exception {
    null_flush= false;
    internal_null_flush = true;
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
    internal_null_flush = false;
    null_flush= true;
  }


  public Timing timing;
  public static final boolean DO_TIMING = false;

  public void transfer(Reader in, Writer output) throws Exception {
    if (getNullFlush()) {
      transfer_wrapper_null_flush(in, output);
    }

    int last=0;
    ms.init(me.getInitial());
    if (DO_TIMING) timing=new Timing("Transfer");
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
                if (DO_TIMING) timing.log("transfer");
                tr=fstp.biltransWithQueue(tmpword.get(0), false);
                if (DO_TIMING) timing.log("transfer/fstp.biltransWithQueue ");
              }
            } else {
              tr=new Pair<String, Integer>(tmpword.get(0), 0);
            }

            if (tr.first.length()!=0)
            {
              if (!transferObject.isOutputChunked())
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
      if (DO_TIMING) timing.log("transfer");
      int val=ms.classifyFinals();
      if (DO_TIMING) timing.log("transfer/ms.classifyFinals");
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

      if (DO_TIMING) timing.log("transfer");
      TransferToken current=readToken(in);
      if (DO_TIMING) timing.log("readToken");

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
            if (DO_TIMING) {
              timing.log("transfer");
              timing.report();
            }
            return;
          }
          break;

        default:

          System.err.println("Error: Unknown input token.");
          return;
      }
    }
  }

  // Kanmuri: Cleanup needed. Pls do :-)
  private void applyRule(Writer output) throws Exception {
    if (DEBUG) System.err.println("tmpword = " + tmpword2+ "  tmpblank = " + tmpblank2);
    if (DO_TIMING) timing.log("other1");

    // TODO. Cleanup. Code is a mess! Jacob

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
        if (limit!=0)
        {
          blank=new String[limit-1];
        } else
        {
          blank=null;
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
        if (DO_TIMING) timing.log("applyRule 1");
        tr=fstp.biltransWithQueue(tmpword2.get(i), false);
        if (DO_TIMING) timing.log("applyRule/fstp.biltransWithQueue ");
      } 
      else
      {
        // If no bilingual dictionary is used (i.e. for apertium-transfer -n, for apertium-interchunk and for apertium-postchunk), then the sl and tl values will be the same.
        tr=new Pair<String, Integer>(tmpword2.get(i), 0);
      }

      args[argn++] = word[i]=new TransferWord(tmpword2.get(i), tr.first, tr.second);
    }

    if (DEBUG) System.err.println("word = " + Arrays.toString(word));

    if (DEBUG) System.err.println("#args = " + args.length);
    if (DEBUG) System.err.println("processRule:"+lastrule.getName()+"("+Arrays.toString(args));
    try {
      if (DO_TIMING) timing.log("applyRule 1");
      lastrule.invoke(transferObject, args);
      if (DO_TIMING) timing.log("rule invoke");
    } catch (Exception e) {
      System.err.println("Error during invokation of "+lastrule);
      System.err.println("word = " + Arrays.toString(word));
      System.err.println("#args = " + args.length);
      System.err.println("processRule:"+lastrule.getName()+"("+Arrays.toString(args));
      throw e;
    }
    if (DEBUG) output.flush();
    
    //processRule(lastrule);
    lastrule=null;

    word=null;
    blank=null;
    tmpword.clear();
    tmpblank.clear();
    tmpword2.clear();
    tmpblank2.clear();
    if (DO_TIMING) timing.log("applyRule 1");
    ms.init(me.getInitial());
    if (DO_TIMING) timing.log("applyRule 2");
  }

  void applyWord(String word_str) {
    if (DO_TIMING) timing.log("other");
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
    if (DO_TIMING) timing.log("applyWord");
  }

  void setCaseSensitiveMode(boolean b) {
    throw new UnsupportedOperationException("Not yet implemented");
  }


  public void setUseBilingual(boolean useBilingual) {
    this.useBilingual=useBilingual;
  }

  //TODO: Cleanup -- unnecessary method
  private void fputwc_unlocked(char c, Writer output) throws IOException {
    output.append(c);
  }

  //TODO: Cleanup -- unnecessary method
  private void fputws_unlocked(String first, Writer output) throws IOException {
    output.append(first);
  }
}
