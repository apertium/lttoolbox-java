/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox;

import java.io.File;
import java.io.IOException;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import static org.apertium.lttoolbox.TestTools.*;
import org.apertium.lttoolbox.compile.TransducerCompTest;

/**
 *
 * @author Jacob Nordfalk
 */
public class LTCompTest extends TestCase {
  protected void setUp() throws Exception {
    // Create and clean tmp dir
    rm("tmp");
    new File("tmp").mkdirs();
  }

  public void testLTCompWithFlagsJava() throws Exception {
    // Just test that it compiles
    LTComp.main(new String[]{"lr", "testdata/flag_matching/persian2.dix", "tmp/testJava.bin"});
    //int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testJava.bin testdata/correct-test.bin").waitFor();
    //assertEquals("files must be binary equal", 0, compareExitValue);
  }

  public void testLTCompJava() throws Exception {
    LTComp.main(new String[]{"lr", "testdata/test.dix", "tmp/testJava.bin"});
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testJava.bin testdata/correct-test.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

  public void testLTCompCpp() throws Exception {
    Runtime.getRuntime().exec("lt-comp lr testdata/test.dix tmp/testC++.bin").waitFor();
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testC++.bin testdata/correct-test.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

  public void testLTCompJava2() throws Exception {
    LTComp.main(new String[]{"lr", "testdata/short.dix", "tmp/testJava.bin"});
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testJava.bin testdata/correct-short.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

  public void testLTCompCpp2() throws Exception {
    Runtime.getRuntime().exec("lt-comp lr testdata/short.dix tmp/testC++.bin").waitFor();
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testC++.bin testdata/correct-short.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

  public void testLTCompJavaLatin1() throws Exception {
    LTComp.main(new String[]{"lr", "testdata/latin-1.dix", "tmp/testJava.bin"});
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testJava.bin testdata/correct-latin-1.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

  public void testLTCompCppLatin1() throws Exception {
    Runtime.getRuntime().exec("lt-comp lr testdata/latin-1.dix tmp/testC++.bin").waitFor();
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testC++.bin testdata/correct-latin-1.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

  public void testLTCompJavaRl() throws Exception {
    LTComp.main(new String[]{"rl", "testdata/test.dix", "tmp/testJava.bin"});
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testJava.bin testdata/correct-testRl.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

  public void testLTCompCppRl() throws Exception {
    Runtime.getRuntime().exec("lt-comp rl testdata/test.dix tmp/testC++.bin").waitFor();
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testC++.bin testdata/correct-testRl.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }


  public void testTransducerCompTest() throws Exception {
    TransducerCompTest.main(null);
  }


  /* skipping as they take too much CPU time. Should be working, though

  public void testLTCompJava3() throws Exception {
    LTComp.main(new String[] { "lr", "testdata/apertium-eo-en.eo-en.dix", "tmp/testJava.bin" });
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testJava.bin testdata/correct-apertium-eo-en.eo-en.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

  public void testLTCompCpp3() throws Exception {
    Runtime.getRuntime().exec("lt-comp lr testdata/apertium-eo-en.eo-en.dix tmp/testC++.bin").waitFor();
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testC++.bin testdata/correct-apertium-eo-en.eo-en.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

  public void testLTCompJavaBig() throws Exception {
    LTComp.main(new String[] { "rl", "testdata/apertium-fr-es.fr.dix", "tmp/testJava.bin" });
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testJava.bin testdata/es-fr.autogen.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

  public void testLTCompCppBig() throws Exception {
    Runtime.getRuntime().exec("lt-comp rl testdata/apertium-fr-es.fr.dix tmp/testC++.bin").waitFor();
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testC++.bin testdata/es-fr.autogen.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }
*/
}
