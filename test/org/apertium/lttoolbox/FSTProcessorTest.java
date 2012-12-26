/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import junit.framework.TestCase;
import org.apertium.lttoolbox.process.FSTProcessor;

/**
 *
 * @author Jacob Nordfalk
 */
public class FSTProcessorTest extends TestCase {
  public void test_biltrans() throws IOException {
    FSTProcessor fstp = new FSTProcessor();
    fstp.load("testdata/bilingual/eo-en.autobil.bin");
    fstp.initBiltrans();

    String res = fstp.biltrans("^domo<n><sg>$", true);
    assertEquals("^house<n><sg>$", res);
    System.err.println(res);

    assertEquals("house<n><sg>", fstp.biltrans("domo<n><sg>", false));

    assertEquals("big<adj>/large<adj>", fstp.biltrans("granda<adj>", false));
  }

  /* TODO test Java and C compilation
   * lt-comp lr apertium-eo-en.eo-en.dix eo-en.autobil.bin
   * lt-comp rl apertium-eo-en.eo-en.dix en-eo.autobil.bin
   */
  public void test_biltrans2() throws IOException {
    FSTProcessor fstp = new FSTProcessor();
    fstp.load("testdata/bilingual/en-eo.autobil.bin");
    fstp.initBiltrans();

    assertEquals("^domo<n><sg>$", fstp.biltrans("^house<n><sg>$", true));;
    assertEquals("domo<n><sg>", fstp.biltrans("house<n><sg>", false));
    assertEquals("70aj jaroj<num>", fstp.biltrans("70s<num>", false));
  }
}
