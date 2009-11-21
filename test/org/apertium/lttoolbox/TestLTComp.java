/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.lttoolbox;

import java.io.File;
import java.io.IOException;
import junit.framework.TestCase;

/**
 *
 * @author Jacob Nordfalk
 */
public class TestLTComp extends TestCase {

    protected void setUp() throws Exception {
      // Create and clean tmp dir
       File tmpdir = new File("tmp");
       tmpdir.mkdirs();
       for (File f : tmpdir.listFiles()) f.delete();
    }

  public void testLTCompJava() throws Exception {
    LTComp.main(new String[] { "lr", "src/test/org/apertium/lttoolbox/test.dix", "tmp/testJava.bin"});
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testJava.bin src/test/org/apertium/lttoolbox/correct-test.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }


  public void testLTCompCpp() throws Exception {
    Runtime.getRuntime().exec("lt-comp lr src/test/org/apertium/lttoolbox/test.dix tmp/testC++.bin").waitFor();
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testC++.bin src/test/org/apertium/lttoolbox/correct-test.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

}
