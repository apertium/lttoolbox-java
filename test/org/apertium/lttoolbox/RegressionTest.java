/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.lttoolbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import junit.framework.TestCase;
import static org.apertium.lttoolbox.TestTools.*;

/**
 *
 * @author Jacob Nordfalk
 */
public class RegressionTest extends TestCase {


  String dir = "testdata/regression/";


  public void xxxtestByInvoking_compare_java_and_c() throws Exception {
      Process p = exep(dir,dir+"compare_java_and_c.sh");
    //Process p = exep(dir,"ls");
    assertEquals("compare_java_and_c.sh exit value", 0, p.exitValue());
}


  InputStream systemin = System.in;
  PrintStream systemout = System.out;

  public void testjavaAnalysis() throws Exception {
    String outFile = "/tmp/lt-proc-output.txt";
    System.setIn(new FileInputStream(dir+"analysis_input"));
    System.setOut(new PrintStream(outFile));
    org.apertium.lttoolbox.LTProc.main(new String[] {"-a",dir+"fr-es.automorf.bin"});
    System.setIn(systemin);
    System.setOut(systemout);
    assertEquals("Difference", "", exec("diff "+dir+"analysis_output "+outFile));
  }


  public void testjavaGeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output.txt";
    System.setIn(new FileInputStream(dir+"generator_input"));
    System.setOut(new PrintStream(outFile));
    org.apertium.lttoolbox.LTProc.main(new String[] {"-g",dir+"fr-es.autogen.bin"});
    System.setIn(systemin);
    System.setOut(systemout);
    assertEquals("Difference", "", exec("diff "+dir+"generator_g_output "+outFile));
  }


  public void testjavaDGeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output.txt";
    System.setIn(new FileInputStream(dir+"generator_input"));
    System.setOut(new PrintStream(outFile));
    org.apertium.lttoolbox.LTProc.main(new String[] {"-d",dir+"fr-es.autogen.bin"});
    System.setIn(systemin);
    System.setOut(systemout);
    assertEquals("Difference", "", exec("diff "+dir+"generator_d_output "+outFile));
  }


  public void testjavaNGeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output.txt";
    System.setIn(new FileInputStream(dir+"generator_input"));
    System.setOut(new PrintStream(outFile));
    org.apertium.lttoolbox.LTProc.main(new String[] {"-n",dir+"fr-es.autogen.bin"});
    System.setIn(systemin);
    System.setOut(systemout);
    assertEquals("Difference", "", exec("diff "+dir+"generator_n_output "+outFile));
  }


  public void testjavaPostgeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output.txt";
    System.setIn(new FileInputStream(dir+"postgenerator_input"));
    System.setOut(new PrintStream(outFile));
    org.apertium.lttoolbox.LTProc.main(new String[] {"-p",dir+"fr-es.autopgen.bin"});
    System.setIn(systemin);
    System.setOut(systemout);
    assertEquals("Difference", "", exec("diff "+dir+"postgenerator_output "+outFile));
  }
}
