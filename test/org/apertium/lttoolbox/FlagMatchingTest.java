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


  public void testFlagMatch_analysis_Persian() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/flag_matching/persian-automorf.bin")));
      fstp.initFlagMatch_analysis(true);

      StringWriter output = new StringWriter();
      fstp.analysis(new StringReader2("bikhodam bikhodaš mikhoda khodan\n"), output);
      assertEquals("^khodan<vblex><prs><p1><sg>$ ^khodan<vblex><prs><p2><sg>$ ^khodan<vblex><pri><p3><sg>$ ^khodan<vblex><inf>$ \n", output.toString());
  }
}
