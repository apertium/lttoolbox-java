/*
 * Copyright (C) 2010 Stephen Tigner
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */
package org.apertium.interchunk;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.apertium.utils.IOUtils.readFile;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.apertium.transfer.old.compile.ApertiumTransferCompile;
import org.junit.Test;

/**
 * @author Stephen Tigner
 *
 */
public class TestInterchunk {
  static String testDataDir = "testdata/interchunk/";
  static String tempDir = "./tmp/";

  //@Test
  public void testInterchunkCompile() throws Exception {
    /* This method was setup to be able to more easily debug the transfer compile.
     * Can be launched to try and compile a t2x file and then step through it to see
     * where things are going wrong.
     */
    String inFile = testDataDir + "apertium-en-es.en-es.t2x";
    String outFile = tempDir + "apertium_en_es_en_es_t2x.class";

    String args[] = {inFile, outFile};

    ApertiumTransferCompile.main(args);
  }

  /**
   * Test method for {@link org.apertium.interchunk.Interchunk#interchunk(Reader, Writer)}.
   * Interchunk takes the output from transfer as its input and outputs to postchunk.
   * This tests Interchunk with a single constructed sample sentence.
   */
  @Test
  public void testThisIsATest() throws IOException {
    String testIn = "^Prn<SN><tn><m><sp>{^esto<prn><tn><3><4>$}$ ^be<Vcop><vbser><pri><p3><sg>{^ser<vbser><3><4><5>$}$ ^det_nom<SN><DET><f><sg>{^uno<det><ind><3><4>$ ^prueba<n><3><4>$}$^punt<sent>{^.<sent>$}$";
    String expTestOut = "^Prn<SN><tn><m><sp>{^esto<prn><tn><3><4>$}$ ^be<Vcop><vbser><pri><p3><sg>{^ser<vbser><3><4><5>$}$ ^det_nom<SN><DET><f><sg>{^uno<det><ind><3><4>$ ^prueba<n><3><4>$}$^punt<sent>{^.<sent>$}$";

    runSingleSentenceTest(testIn, expTestOut);
  }

  /* Extra tests added to test some specific representative sentences from the
   * 200 sentence test that are failing, while the above test still works.
   */
  @Test
  public void testSentenceNumber2() throws IOException {
    String testInp = "     ^Num<NUM>{^2<num>$}$^punt<sent>{^.<sent>$}$ ^Nom<SN><UNDET><m><sg>{^anarquismo<n><3><4>$}$ ^adv<adv><NEG>{^no<adv>$}$ ^be<Vcop><vbser><pri><p3><sg>{^ser<vbser><3><4><5>$}$ ^det_nom<SN><DET><m><sg>{^el<det><def><3><4>$ ^reinado<n><3><4>$}$ ^pr<PREP>{^de<pr>$}$ ^nom<SN><UNDET><m><sg>{^amor<n><3><4>$}$^coma<cm>{^,<cm>$}$ ^cnj<cnjcoo>{^pero<cnjcoo>$}$ ^det_nom<SN><DET><m><sg>{^el<det><def><3><4>$ ^reinado<n><3><4>$}$ ^pr<PREP>{^de<pr>$}$ ^nom<SN><UNDET><f><sg>{^justicia<n><3><4>$}$^punt<sent>{^.<sent>$}$";
    String testExp = "     ^Num<NUM>{^2<num>$}$^punt<sent>{^.<sent>$}$ ^Nom<SN><PDET><m><sg>{^anarquismo<n><3><4>$}$ ^adv<adv><NEG>{^no<adv>$}$ ^be<Vcop><vbser><pri><p3><sg>{^ser<vbser><3><4><5>$}$ ^det_nom<SN><DET><m><sg>{^el<det><def><3><4>$ ^reinado<n><3><4>$}$ ^pr<PREP>{^de<pr>$}$ ^nom<SN><UNDET><m><sg>{^amor<n><3><4>$}$^coma<cm>{^,<cm>$}$ ^cnj<cnjcoo>{^pero<cnjcoo>$}$ ^det_nom<SN><DET><m><sg>{^el<det><def><3><4>$ ^reinado<n><3><4>$}$ ^pr<PREP>{^de<pr>$}$ ^nom<SN><UNDET><f><sg>{^justicia<n><3><4>$}$^punt<sent>{^.<sent>$}$";

    runSingleSentenceTest(testInp, testExp);
  }

  @Test
  public void testSentenceNumber7() throws IOException {
    String testInp = "     ^Num<NUM>{^7<num>$}$^punt<sent>{^.<sent>$}$ ^Prnsubj<SN><tn><p3><m><pl>{^prpers<prn><2><p3><4><pl>$}$ ^adv<adv>{^en cambio<adv>$}$ ^inf<SV><vblex><inf><PD><ND>{^defender<vblex><3>$}$ ^det_nom<SN><DET><m><sg>{^el<det><def><3><4>$ ^proceso<n><3><4>$}$ ^pr<PREP>{^de<pr>$}$ ^unknown<unknown>{^*rewilding$}$ ^cnj<cnjcoo>{^o<cnjcoo>$}$ ^unknown<unknown>{^*reconnecting$}$ ^pr<PREP>{^con<pr>$}$ ^det_nom_adj<SN><DET><m><sg>{^el<det><def><3><4>$ ^entorno<n><3><4>$ ^natural<adj><mf><4>$}$^punt<sent>{^.<sent>$}$";
    String testExp = "     ^Num<NUM>{^7<num>$}$^punt<sent>{^.<sent>$}$ ^Adv<adv>{^en cambio<adv>$}$ ^inf<SV><vblex><pri><p3><pl>{^defender<vblex><3>$}$ ^det_nom<SN><DET><m><sg>{^el<det><def><3><4>$ ^proceso<n><3><4>$}$ ^pr<PREP>{^de<pr>$}$ ^unknown<unknown>{^*rewilding$}$ ^cnj<cnjcoo>{^o<cnjcoo>$}$ ^unknown<unknown>{^*reconnecting$}$ ^pr<PREP>{^con<pr>$}$ ^det_nom_adj<SN><DET><m><sg>{^el<det><def><3><4>$ ^entorno<n><3><4>$ ^natural<adj><mf><4>$}$^punt<sent>{^.<sent>$}$";
    //String testInp = "^Prnsubj<SN><tn><p3><m><pl>{^prpers<prn><2><p3><4><pl>$}$ ^adv<adv>{^en cambio<adv>$}$ ^inf<SV><vblex><inf><PD><ND>{^defender<vblex><3>$}$";
    //String testExp = "^Adv<adv>{^en cambio<adv>$}$ ^inf<SV><vblex><pri><p3><pl>{^defender<vblex><3>$}$";
    runSingleSentenceTest(testInp, testExp);
  }

  @SuppressWarnings("unchecked")
  private void runSingleSentenceTest(String testIn, String expTestOut) throws IOException {
    Class transferClass = org.apertium.transfer.old.generated.apertium_en_es_en_es_t2x.class;
    String preprocFile = testDataDir + "en-es.t2x.bin";

    /* The logic in ApertiumInterchunk.main() is mostly for parsing the command-line,
     * since we're calling it directly in Java, we can bypass it.
     */
    StringReader input = new StringReader(testIn);
    Writer output = new StringWriter();

    Interchunk interchunk = new Interchunk();
    //Interchunk.DEBUG = true;
    try {
      interchunk.read(transferClass, preprocFile);
      interchunk.transferObject.debug = true;

      interchunk.process(input, output);
    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception occured during test.");
    }

    String testOutput = output.toString();

    System.err.println("output = " + testOutput);
    System.err.println("expout = " + expTestOut);
    assertEquals("TestInterchunk.testMainThisIsATest() failed: output does not match expected output.", expTestOut, testOutput);
  }

  /**
   * Test of Interchunk.interchunk(), using external text files.
   */
  @SuppressWarnings("unchecked")
  @Test
  public void test200Sentences() throws IOException {
    String inFile = testDataDir + "en-interchunk-input.txt";
    Class transferClass = org.apertium.transfer.old.generated.apertium_en_es_en_es_t2x.class;
    String preprocFile = testDataDir + "en-es.t2x.bin";
    String compareOutFile = testDataDir + "en-interchunk-output.txt";

    /* The logic in ApertiumInterchunk.main() is mostly for parsing the command-line,
     * since we're calling it directly in Java, we can bypass it.
     */
    Reader input = new FileReader(inFile);
    Writer output = new StringWriter();

    Interchunk interchunk = new Interchunk();
    //Debug produces too much output and slows down execution too much.
    //Interchunk.DEBUG = true;
    try {
      interchunk.read(transferClass, preprocFile);
      //interchunk.transferObject.debug = true;

      interchunk.process(input, output);
    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception occured during test.");
    }

    /* Do not trim. Trimming the output will result in a failed test.
     * Trim removes whitespace before and after the string, which will
     * cause it to fail when testing against the C++ output which does
     * not trim.
     */
    String testOutput = output.toString();

    String expectedOutput = readFile(compareOutFile);

    // write to file in case of fail, so we can debug
    if (!testOutput.equals(expectedOutput)) {
      PrintWriter pw = new PrintWriter(new FileOutputStream(tempDir + "en-interchunk-output-actual.txt"));
      pw.append(testOutput);
      pw.close();

      System.err.println("total   testOutput = " + testOutput.length());

      System.err.println("total expectedOutput = " + expectedOutput.length());
      for (int i = 0; i < 200; i++)
        if (testOutput.split("\n")[i].length() != expectedOutput.split("\n")[i].length()) {
          System.err.println(i + "    testOutput = " + testOutput.split("\n")[i].length());
          System.err.println(i + "expectedOutput = " + expectedOutput.split("\n")[i].length());
          System.err.println(i + "    testOutput = " + testOutput.split("\n")[i]);
          System.err.println(i + "expectedOutput = " + expectedOutput.split("\n")[i]);
        }


      //System.err.println("\n\n\ntestOutput = \n" + testOutput);

      //System.err.println("\n\n\nexpectedOutput = \n" + expectedOutput);
    }


    assertEquals("TestInterchunk.test200Sentences() failed: output does not match expected output.", expectedOutput, testOutput);
  }
}
