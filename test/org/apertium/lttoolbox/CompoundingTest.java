/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import junit.framework.TestCase;
import org.apertium.lttoolbox.process.FSTProcessor;
import org.apertium.lttoolbox.process.State;
import static org.junit.Assert.*;
import static org.apertium.lttoolbox.TestTools.*;

/**
 *
 * @author Jacob Nordfalk
 */
public class CompoundingTest extends TestCase {
  public void testCLIJava() throws Exception {
    String outFile = "./tmp/testCLIJava-eo-output.txt.txt";
    LTProc.main(new String[]{"-e", "testdata/compounding/eo-en.automorf.bin", "testdata/compounding/eo-input.txt", outFile});
    assertEquals("Difference", "", exec("diff testdata/compounding/eo-output.txt " + outFile));
    rm(outFile);
  }

  public void testCLIJava_show_symbols() throws Exception {
    String outFile = "./tmp/testCLIJava-eo-output-show-symbols.txt";
    LTProc.main(new String[]{"-eS", "testdata/compounding/eo-en.automorf.bin", "testdata/compounding/eo-input.txt", outFile});
    assertEquals("Difference", "", exec("diff testdata/compounding/eo-output-show-symbols.txt " + outFile));
    rm(outFile);
  }

  /*
   * public void testLTCompCpp() throws Exception {
   * Runtime.getRuntime().exec("lt-proc lr testdata/test.dix tmp/testC++.bin").waitFor();
   * int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testC++.bin testdata/correct-test.bin").waitFor();
   * assertEquals("files must be binary equal", 0, compareExitValue);
   * }
   */
  /*
   * public void testCompound2_Nnnb() throws IOException {
   * FSTProcessor fstp = new FSTProcessor();
   * fstp.load("/home/j/esperanto/apertium/apertium-nn-nb/compound.dix.bin");
   * fstp.initDecomposition(true);
   *
   * // FSTProcessor.DEBUG = true;
   * // State.DEBUG = true;
   * assertNull(fstp.compoundAnalysis2("befinner"));
   *
   *
   * StringWriter output = new StringWriter();
   * fstp.analysis(new StringReader("fader\n"), output);
   * System.err.println("output.toString() = " + output.toString().replaceAll("/", "\n/"));
   * assertEquals("^fader/fader<n><m><sg><ind>$\n", output.toString());
   * }
   */
  public void testCompound2_Esperanto() throws IOException {
    FSTProcessor fstp = new FSTProcessor();
    fstp.load("testdata/compounding/eo-en.automorf.bin");
    fstp.initDecomposition();

    //State.DEBUG = true;
    // lt-comp lr apertium-eo-en.eo.dix eo-en.automorf.bin
    assertEquals("/domo<n><sg><nom>+detektivo<n><m><pl><acc>", fstp.compoundAnalysis2("domodetektivojn"));

    assertEquals("/domo<n><sg><nom>+detektivo<n><m><sg><nom>", fstp.compoundAnalysis2("domodetektivo"));

    assertEquals("/domo<n><sg><nom>+detektivo<n><m><sg><nom>", fstp.compoundAnalysis2("domdetektivo"));

    assertEquals("/detektivo<n><m><sg><nom>+domo<n><sg><nom>", fstp.compoundAnalysis2("detektivdomo"));
    assertEquals("/detektivo<n><f><sg><nom>+domo<n><sg><nom>", fstp.compoundAnalysis2("detektivindomo"));

    assertEquals(null, fstp.compoundAnalysis2("dom"));
    assertEquals(null, fstp.compoundAnalysis2("domojdetektivo"));
    assertEquals(null, fstp.compoundAnalysis2("domondetektivo"));


    StringWriter output = new StringWriter();
    fstp.analysis(new StringReader("Ó dom diktatorindiino domo\n"), output);
    System.err.println("output.toString() = " + output.toString().replaceAll("/", "\n/"));
    assertEquals("^Ó/*Ó$ ^dom/*dom$ ^diktatorindiino/diktatoro<n><f><sg><nom>+dio<n><f><sg><nom>$ ^domo/domo<n><sg><nom>$\n", output.toString());
  }

  public void testCompoundOld() throws IOException {
    FSTProcessor fstp = new FSTProcessor();
    fstp.load("testdata/compounding/eo-en.automorf.bin");
    fstp.initAnalysis();
    fstp.alphabet.setSymbol(fstp.alphabet.cast("<:compound:only-L>"), "");
    fstp.alphabet.setSymbol(fstp.alphabet.cast("<:compound:R>"), "");

    String res = fstp.compoundAnalysisOld("domodefendo");
    System.err.println("res = " + res.replaceAll("/", "\n/"));
    assertEquals("/domo<n><sg><nom>+defendo<n><sg><nom>", res);
  }
  /*
   * public void xxtestCompoiund() throws IOException {
   * FSTProcessor fstp = new FSTProcessor();
   * fstp.load(new BufferedInputStream(new FileInputStream("testdata/compounding/foo.bin")));
   * fstp.initAnalysis();
   * fstp.initDecomposition();
   *
   * StringWriter output = new StringWriter();
   * fstp.analysis(new StringReader("danning\n"), output);
   * System.err.println(output);
   * }
   *
   * public void testCompoiund2() throws IOException {
   * FSTProcessor fstp = new FSTProcessor();
   * fstp.load(new BufferedInputStream(new FileInputStream("/home/j/esperanto/apertium/apertium-is-en/is.bin")));
   * fstp.initAnalysis();
   * fstp.setCompoundAnalysis(true);
   *
   * StringWriter output = new StringWriter();
   * fstp.analysis(new StringReader("Bændasamtökunum samtökunum\n"), output);
   * System.err.println(output);
   *
   * output.getBuffer().setLength(0);
   * fstp.analysis(new StringReader("lambakjöti\n"), output);
   * System.err.println(output);
   *
   * output.getBuffer().setLength(0);
   * fstp.analysis(new StringReader("persónukjöri\n"), output);
   * System.err.println(output);
   *
   * output.getBuffer().setLength(0);
   * fstp.analysis(new StringReader("Reykjavíkurborg\n"), output);
   * System.err.println(output);
   *
   *
   * output.getBuffer().setLength(0);
   * fstp.analysis(new StringReader("Þýsklandi\n"), output);
   * System.err.println(output);
   *
   *
   * }
   *
   *
   *
   *
   * // ^Bændasamtökunum/Bóndi<n><m><pl><gen><ind>+samtök<n><nt><sg><dat><ind>/Bóndi<n><m><pl><gen><ind>+samtök<n><nt><pl><dat><def>$ ^samtökunum/samtök<n><nt><sg><dat><ind>/samtök<n><nt><pl><dat><def>$
   */
}
