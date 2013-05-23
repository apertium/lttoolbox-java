/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.apertium.lttoolbox.compile.TransducerComp;
import org.apertium.lttoolbox.process.FSTProcessor;

/**
 *
 * @author j
 */
public class LTPrint {

  public static void main(String[] args) throws IOException {
    if (args.length==0) args = new String[] { "testdata/wound-example.bin" };
    //if (args.length==0) args = new String[] { "testTransducer2.bin" };


    doPrint(args[0], System.out);
    
  }

  private static void doPrint(String file, PrintStream out) throws IOException {
    InputStream input = new BufferedInputStream (new FileInputStream(file));

    //FSTProcessor fstp = new FSTProcessor();
    //fstp.load(input);
    String letters = Compression.String_read(input);
    Alphabet alphabet = Alphabet.read(input);

    int len = Compression.multibyte_read(input);

    while (len > 0) {
      String name = Compression.String_read(input);

      //System.out.println("reading : " + name);
      TransducerComp t = TransducerComp.TEST_read(input);

      len--;
      t.show(alphabet, out);
      if (len>0) {
        //System.out.println("-- "+name);
        System.out.println("--");
      }
    }
    input.close();
  }
}
