/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox;

import junit.framework.TestCase;
import static org.apertium.lttoolbox.TestTools.*;

/**
 *
 * @author Jacob Nordfalk
 */
public class RegressionTest extends TestCase {
  String dir = "testdata/regression/";

  /*
   * public void xxxtestByInvoking_compare_java_and_c() throws Exception {
   * Process p = exep(dir,dir+"compare_java_and_c.sh");
   * //Process p = exep(dir,"ls");
   * assertEquals("compare_java_and_c.sh exit value", 0, p.exitValue());
   * }
   */
  public void testjavaAnalysis() throws Exception {
    String outFile = "./tmp/lt-proc-output1a.txt";
    org.apertium.lttoolbox.LTProc.main(new String[]{"-a", dir + "fr-es.automorf.bin", dir + "analysis_input", outFile});
    assertEquals("Difference", "", exec("diff " + dir + "analysis_output " + outFile));
    rm(outFile);
  }

  public void testjavaGeneration() throws Exception {
    String outFile = "./tmp/lt-proc-output1b.txt";
    org.apertium.lttoolbox.LTProc.main(new String[]{"-g", dir + "fr-es.autogen.bin", dir + "generator_input", outFile});
    assertEquals("Difference", "", exec("diff " + dir + "generator_g_output " + outFile));
    rm(outFile);
  }

  public void testjavaDGeneration() throws Exception {
    String outFile = "./tmp/lt-proc-output3g.txt";
    org.apertium.lttoolbox.LTProc.main(new String[]{"-d", dir + "fr-es.autogen.bin", dir + "generator_input", outFile});
    assertEquals("Difference", "", exec("diff " + dir + "generator_d_output " + outFile));
    rm(outFile);
  }

  public void testjavaNGeneration() throws Exception {
    String outFile = "./tmp/lt-proc-output4.txt";
    org.apertium.lttoolbox.LTProc.main(new String[]{"-n", dir + "fr-es.autogen.bin", dir + "generator_input", outFile});
    assertEquals("Difference", "", exec("diff " + dir + "generator_n_output " + outFile));
    rm(outFile);
  }

  public void testjavaPostgeneration() throws Exception {
    String outFile = "./tmp/lt-proc-output5.txt";
    org.apertium.lttoolbox.LTProc.main(new String[]{"-p", dir + "fr-es.autopgen.bin", dir + "postgenerator_input", outFile});
    assertEquals("Difference", "", exec("diff " + dir + "postgenerator_output " + outFile));
    rm(outFile);
  }
}
