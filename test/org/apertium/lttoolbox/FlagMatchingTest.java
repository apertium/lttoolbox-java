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

/**
 *
 * @author Jacob Nordfalk
 */
public class FlagMatchingTest extends TestCase {
  String[] correctPairs = ("bikhodam:khodan<vblex><prs><p1><sg>\n"
      + "bikhodaš:khodan<vblex><prs><p2><sg>\n"
      + "bikhoda:khodan<vblex><prs><p3><sg>\n"
      + "mikhodam:khodan<vblex><pri><p1><sg>\n"
      + "mikhodaš:khodan<vblex><pri><p2><sg>\n"
      + "mikhoda:khodan<vblex><pri><p3><sg>\n"
      + "khodan:khodan<vblex><inf>").split("\n");

  static public void assertEquals(String expected, String actual) {
    if (expected == null && actual == null)
      return;
    if (expected != null && expected.equals(actual))
      return;

    System.err.println("expect = " + expected);
    System.err.println("actual = " + actual);
    assertEquals(null, expected, actual);
  }

  private String checkAnalysis(FSTProcessor fstp, String input) throws IOException {
    StringWriter output = new StringWriter();
    fstp.analysis(new StringReader(input), output);
    String result = output.toString();
    return result;
  }

  private String checkGeneration(FSTProcessor fstp, String input) throws IOException {
    StringWriter output = new StringWriter();
    fstp.generation(new StringReader(input), output, FSTProcessor.GenerationMode.gm_unknown);
    String result = output.toString();
    return result;
  }

  public void testFlagMatch_analysis_Persian2() throws IOException {
    FSTProcessor fstp = new FSTProcessor();
    fstp.load("testdata/flag_matching/persian-automorf2.bin");
    fstp.DEBUG = State.DEBUG = false;
    fstp.setFlagMatchMode(true);
    fstp.initAnalysis();

    for (String s : correctPairs) {
      String[] p = s.split(":");
      assertEquals("^" + p[0] + "/" + p[1] + "$ ", checkAnalysis(fstp, p[0] + " "));
    }

    fstp.DEBUG = State.DEBUG = false;
    String result = checkAnalysis(fstp, "\nbikhodam bikhodaš mikhoda khodan\n");
    assertEquals("\n^bikhodam/khodan<vblex><prs><p1><sg>$ ^bikhodaš/khodan<vblex><prs><p2><sg>$ "
        + "^mikhoda/khodan<vblex><pri><p3><sg>$ ^khodan/khodan<vblex><inf>$\n", result);
  }

  public void testFlagMatch_generation_Persian2() throws IOException {
    FSTProcessor fstp = new FSTProcessor();
    fstp.load("testdata/flag_matching/persian-autogen2.bin");
    fstp.DEBUG = State.DEBUG = false;
    fstp.setFlagMatchMode(true);
    fstp.initGeneration();

    for (String s : correctPairs) {
      String[] p = s.split(":");
      assertEquals(p[0] + " ", checkGeneration(fstp, "^" + p[1] + "$ "));
    }

    fstp.DEBUG = State.DEBUG = false;
    String result = checkGeneration(fstp,
        "\n^khodan<vblex><prs><p1><sg>$ ^khodan<vblex><prs><p2><sg>$ "
        + "^khodan<vblex><pri><p3><sg>$ ^khodan<vblex><inf>$\n");
    assertEquals("\nbikhodam bikhodaš mikhoda khodan\n", result);
  }

  public void testFlagMatch_analysis_Persian() throws IOException {
    FSTProcessor fstp = new FSTProcessor();
    fstp.load("testdata/flag_matching/persian-automorf.bin");
    fstp.DEBUG = false;
    fstp.setFlagMatchMode(true);
    fstp.initAnalysis();

    String result = checkAnalysis(fstp, "\nbikhodam bikhodaš mikhoda khodan\n");
    fstp.DEBUG = State.DEBUG = false;
    assertEquals("\n^bikhodam/khodan<vblex><prs><p1><sg>$ ^bikhodaš/khodan<vblex><prs><p2><sg>$ "
        + "^mikhoda/khodan<vblex><pri><p3><sg>$ ^khodan/khodan<vblex><inf>$\n", result);

    for (String s : correctPairs) {
      String[] p = s.split(":");
      assertEquals("^" + p[0] + "/" + p[1] + "$ ", checkAnalysis(fstp, p[0] + " "));
    }
  }
}
