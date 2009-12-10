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
import org.apertium.lttoolbox.process.State;
import static org.junit.Assert.*;
/**
 *
 * @author Jacob Nordfalk
 */
public class FlagMatchingTest extends TestCase {

  String[] correctPairs = (
    "bikhodam:khodan<vblex><prs><p1><sg>\n"+
    "bikhodaš:khodan<vblex><prs><p2><sg>\n"+
    "bikhoda:khodan<vblex><prs><p3><sg>\n"+
    "mikhodam:khodan<vblex><pri><p1><sg>\n"+
    "mikhodaš:khodan<vblex><pri><p2><sg>\n"+
    "mikhoda:khodan<vblex><pri><p3><sg>\n"+
    "khodan:khodan<vblex><inf>").split("\n");

	static public void assertEquals(String expected, String actual) {
		if (expected == null && actual == null)
			return;
		if (expected != null && expected.equals(actual))
			return;

    System.err.println("expect = " + expected);
    System.err.println("actual = " + actual);
    assertEquals(null, expected, actual);
  }


  private String check(FSTProcessor fstp, String input) throws IOException {
    StringWriter output=new StringWriter();
    fstp.analysis(new StringReader2(input), output);
    String result=output.toString();
    return result;
  }

  public void testFlagMatch_analysis_Persian2() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/flag_matching/persian-automorf2.bin")));
      fstp.DEBUG = State.DEBUG = true;
      fstp.alphabet.debug_remember_removed_symbols();
      fstp.initFlagMatch_analysis(true);

      for (String s : correctPairs) {
        String[] p = s.split(":");
        assertEquals("^"+p[0]+"/"+p[1]+"$ ", check(fstp, p[0]+" "));
      }

      fstp.DEBUG = State.DEBUG =false;
      String result = check(fstp, "\nbikhodam bikhodaš mikhoda khodan\n");
      assertEquals("\n^bikhodam/khodan<vblex><prs><p1><sg>$ ^bikhodaš/khodan<vblex><prs><p2><sg>$ "
          +"^mikhoda/khodan<vblex><pri><p3><sg>$ ^khodan/khodan<vblex><inf>$\n", result);
  }

  public void testFlagMatch_analysis_Persian() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/flag_matching/persian-automorf.bin")));
      fstp.DEBUG = true;
      fstp.alphabet.debug_remember_removed_symbols();
      fstp.initFlagMatch_analysis(true);

      String result = check(fstp, "\nbikhodam bikhodaš mikhoda khodan\n");
      fstp.DEBUG = State.DEBUG =false;
      assertEquals("\n^bikhodam/khodan<vblex><prs><p1><sg>$ ^bikhodaš/khodan<vblex><prs><p2><sg>$ "
          +"^mikhoda/khodan<vblex><pri><p3><sg>$ ^khodan/khodan<vblex><inf>$\n", result);

      for (String s : correctPairs) {
        String[] p = s.split(":");
        assertEquals("^"+p[0]+"/"+p[1]+"$ ", check(fstp, p[0]+" "));
      }
  }

}
