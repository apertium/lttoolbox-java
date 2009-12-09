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
      //fstp.DEBUG = true;
      //fstp.alphabet.debug_remember_removed_symbols();
      fstp.initFlagMatch_analysis(true);

      StringWriter output = new StringWriter();
      fstp.analysis(new StringReader2("\nbikhodam bikhodaš mikhoda khodan\n"), output);
      //fstp.DEBUG = false;
      assertEquals("\n^bikhodam/khodan<vblex><pri><p1><sg>$ ^bikhodaš/khodan<vblex><pri><p2><sg>$ "
          +"^mikhoda/khodan<vblex><prs><p3><sg>$ ^khodan/khodan<vblex><inf>$\n", output.toString());
  }
}
