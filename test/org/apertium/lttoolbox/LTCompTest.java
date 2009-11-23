/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.lttoolbox;

import java.io.File;
import java.io.IOException;
import junit.framework.TestCase;
import static org.apertium.lttoolbox.TestTools.*;

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


  public void testLTCompJava() throws Exception {
    LTComp.main(new String[] { "lr", "testdata/test.dix", "tmp/testJava.bin"});
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testJava.bin testdata/correct-test.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }


  public void testLTCompCpp() throws Exception {
    Runtime.getRuntime().exec("lt-comp lr testdata/test.dix tmp/testC++.bin").waitFor();
    int compareExitValue = Runtime.getRuntime().exec("cmp tmp/testC++.bin testdata/correct-test.bin").waitFor();
    assertEquals("files must be binary equal", 0, compareExitValue);
  }

}
