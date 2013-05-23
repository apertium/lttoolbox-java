/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox;

import org.apertium.lttoolbox.compile.TransducerCollection;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.apertium.lttoolbox.compile.TransducerComp;

/**
 *
 * @author j
 */
public class LTPrint {

  public static void main(String[] args) throws IOException {
    if (args.length==0) args = new String[] { "testdata/Automatically_trimming_a_monodix/test-en.bin" };
    //if (args.length==0) args = new String[] { "testdata/wound-example.bin" };
    //if (args.length==0) args = new String[] { "testTransducer2.bin" };

    doPrint(args[0], System.out);
    doExpand(args[0], System.out);
    doIntersect("testdata/Automatically_trimming_a_monodix/test-en.bin",
        "testdata/Automatically_trimming_a_monodix/test-en-eu.bin",
        "tmp/xx.bin");
  }




  private static void doIntersect(String monodixf, String bidixf, String intersectedf) throws IOException {
    TransducerCollection mon = new TransducerCollection();
    mon.read(monodixf);
    for (TransducerComp t : mon.sections.values()) {
      t.expand(mon.alphabet, System.out);
    }
    System.out.println(" --- ");

    TransducerCollection bil = new TransducerCollection();
    bil.read(bidixf);
    for (TransducerComp t : bil.sections.values()) {
      t.expand(bil.alphabet, System.out);
    }

    for (TransducerComp t : mon.sections.values()) {
      t.intersect(mon.alphabet, bil);
    }
    System.out.println(" --- ");

  }




  private static void doExpand(String file, PrintStream out) throws IOException {

    TransducerCollection tc = new TransducerCollection();
    tc.read(file);
    for (TransducerComp t : tc.sections.values()) {
      t.expand(tc.alphabet, out);
    }
  }



  private static void doPrint(String file, PrintStream out) throws IOException {

    TransducerCollection tc = new TransducerCollection();
    tc.read(file);
    boolean first = true;
    for (TransducerComp t : tc.sections.values()) {
      t.show(tc.alphabet, out);
      if (!first) {
        //System.out.println("-- "+name);
        System.out.println("--");
      }
      first = false;
    }
  }
}
