/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.transfer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import org.apertium.lttoolbox.Alphabet;
import org.apertium.transfer.development.Timing;
import org.apertium.transfer.generated.GeneratedTransferBase;
import org.apertium.utils.IOUtils;

/**
  Base class for tranfer, interchunk and postchunk
  @author Jacob Nordfalk
 */
public abstract class AbstractTransfer {
  public static final boolean DEBUG = false;
  public static final boolean DO_TIMING = false;
  public Timing timing;

  protected Alphabet alphabet;
  protected String TRXReader__ANY_CHAR = "<ANY_CHAR>";
  protected String TRXReader__ANY_TAG = "<ANY_TAG>";
  protected int any_char;
  protected int any_tag;

  protected MatchExe me; // Pointer in C++ version
  protected MatchState ms;

  /**
So, how do we set up the array of rule_map Method?
Well, during compilation the ParseTransferFile.java takes the XML hell of for example apertium-eo-en.en-eo.t1x, and converts it into Java code like the apertium_eo_en_eo_en_t1x java class (in package org.apertium.transfer.generated), which is loaded during runtime.
So the array of rule_map Method is taken by introspection, taking all methods beginning with rule<number>, like rule0__la__num_ord__de__monato, rule1__de_ekde__tempo etc etc and kicks them into the array.
   */
  protected Method[] rule_map = null; // vector<xmlNode *> rule_map;

  protected BufferT<TransferToken> input_buffer = new BufferT<TransferToken>(); // Buffer<TransferToken> input_buffer;

  public GeneratedTransferBase transferObject;

  /**
   * if true, flush the output when the null character is found
   */
  protected boolean null_flush;
  protected boolean internal_null_flush;


  public boolean getNullFlush() {
    return null_flush;
  }

  public void setNullFlush(boolean b) {
    null_flush = b;
  }

  /**
   @deprecated
   */
  public void readData(ByteBuffer in) throws IOException {
    readData(in, null);
  }

  public final void readData(ByteBuffer in, String filename) throws IOException {
    // symbols
    alphabet = Alphabet.read(in);
    any_char = alphabet.cast(TRXReader__ANY_CHAR);
    any_tag = alphabet.cast(TRXReader__ANY_TAG);
    File cacheFile = null;
    //System.out.println("reading : "+name);
    if (IOUtils.cacheDir != null && filename != null) {
      // Try to load make cached a memmapped transducer cache file
      cacheFile = new File(IOUtils.cacheDir, filename.replace(File.separatorChar, '_'));
      //System.out.println("cachedFile = " + cacheFile);
    }
    // faster - let it read itself, thus no need to make a big hashmap
    me = new MatchExe(in, alphabet.size(), cacheFile);
    ms = new MatchState(me);

    // Rest of data file contains attr_items, variables. macros, lists.
    // This is encoded in the class/bytecode, so we skip the rest of the file.
    // See old code at: http://apertium.svn.sourceforge.net/viewvc/apertium/trunk/lttoolbox-java/src/org/apertium/transfer/Transfer.java?r1=24752&r2=24751&pathrev=24752
  }

  /**
   * Reads data
   * @param classFile the file name of the java bytecode file containing the transfer instructions
   *  so, preprocessed by, apertium-preprocess-transfer-bytecode-j  (.class)
   * @param datafile same file, preprocessed by, apertium-preprocess-transfer  (.bin)
   * @param bilFstFile bilingual FST file - might be null
   @throws Exception
   */
  @SuppressWarnings(value = "unchecked")
  public void read(Class transferClass, String datafile) throws Exception {
    ByteBuffer is = IOUtils.openFileAsByteBuffer(datafile);
    readData(is, datafile);

    Method[] mets = transferClass.getMethods();
    rule_map = new Method[mets.length];
    // Find all methods starting with name 'rule'
    // So the array of rule_map Method is taken by introspection, taking all methods beginning with rule<number>,
    // like rule0__la__num_ord__de__monato, rule1__de_ekde__tempo etc etc and kicks them into the array.
    for (Method method : mets) {
      String name = method.getName();
      if (DEBUG) {
        System.err.println("n = " + name);
      }
      if (!name.startsWith("rule")) {
        continue;
      }
      int number = Integer.parseInt(name.substring(4, name.indexOf('_', 5)));
      rule_map[number] = method;
      if (DEBUG) {
        System.err.println(method.getName() + "  - #words=" + method.getParameterTypes().length / 2);
      }
    }
    transferObject = (GeneratedTransferBase) transferClass.newInstance();
    transferObject.debug = DEBUG;
    transferObject.init();
  }



  protected void process_wrapper_null_flush(Reader input, Appendable output) throws Exception {
    null_flush = false;
    internal_null_flush = true;
    while (input.ready()) {
      process(input, output);
      output.append('\0');
    }
    internal_null_flush = false;
    null_flush = true;
  }

  public abstract void process(Reader input, Appendable output) throws Exception;
}
