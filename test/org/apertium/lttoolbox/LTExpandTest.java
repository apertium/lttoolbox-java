/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox;

import java.io.FileWriter;
import junit.framework.TestCase;
import static org.apertium.lttoolbox.TestTools.*;

/**
 *
 * @author Jacob Nordfalk
 */
public class LTExpandTest extends TestCase {
  String dir = "testdata/";

  public void testjavaLTExpand() throws Exception {
    String outFile = "./tmp/lt-expand-output.txt";
    org.apertium.lttoolbox.LTExpand.main(new String[]{dir + "short.dix", outFile});
    assertEquals("Difference", "", exec("diff " + dir + "short.dix-expanded.txt " + outFile));
  }

  public void testCLTExpand() throws Exception {
    String outFile = "./tmp/lt-expand-output.txt";
    String res = exec("lt-expand " + dir + "short.dix");
    new FileWriter(outFile).append(res).close();
    assertEquals("Difference", "", exec("diff " + dir + "short.dix-expanded.txt " + outFile));
  }
}
