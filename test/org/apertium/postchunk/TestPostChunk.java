/*
 * Copyright (C) 2010 Stephen
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
package org.apertium.postchunk;

import static org.apertium.utils.IOUtils.readFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import org.apertium.interchunk.Interchunk;
import org.junit.Test;

/**
 * @author Stephen
 *
 */
public class TestPostChunk {
  static String testDataDir = "testdata/postchunk/";
  static String tempDir = "./tmp/";

  //Tests for the static methods
  /**
   * This method uses the reflection API to run tests on the private static members of
   * Postchunk.
   */
  @SuppressWarnings("unchecked")
  private static Object runPrivateMethod(String name, Class[] paramTypes, Object[] params)
      throws SecurityException, NoSuchMethodException, IllegalArgumentException,
      IllegalAccessException, InvocationTargetException {
    Class pcClass = Postchunk.class;
    Method privateMethod = pcClass.getDeclaredMethod(name, paramTypes);
    /* Allows us to bypass the normal access checks and access a private
     * method for testing purposes.
     */
    privateMethod.setAccessible(true);
    Object returnObject = privateMethod.invoke(null, params);
    /* Reset it back to normal.
     */
    privateMethod.setAccessible(false);
    return returnObject;
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testGetVecTags() throws SecurityException, IllegalArgumentException,
      NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    String methodName = "getVecTags";
    String inputString = "^Nom<SN><PDET><m><sg>{^anarquismo<n><3><4>$}$";
    String[] expOutArray = {"<SN>", "<PDET>", "<m>", "<sg>"};
    ArrayList<String> expectedOutput = new ArrayList<String>(Arrays.asList(expOutArray));

    Class[] paramTypes = {String.class};
    Object[] params = {inputString};

    ArrayList<String> returnVal = (ArrayList<String>) runPrivateMethod(methodName, paramTypes, params);
    assertEquals("TestPostChunk.testGetVecTags() failed: output does not match expected output", expectedOutput, returnVal);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testBeginChunk() throws SecurityException, IllegalArgumentException,
      NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    String methodName = "beginChunk";
    String inputString = "^Nom<SN><PDET><m><sg>{^anarquismo<n><3><4>$}$";
    int expectedOutput = 22; //This should be the index of the '^' after the '{'

    Class[] paramTypes = {String.class};
    Object[] params = {inputString};

    int returnVal = (Integer) runPrivateMethod(methodName, paramTypes, params);

    assertEquals("TestPostChunk.testBeginChunk() failed: output does not match expected output", expectedOutput, returnVal);
  }

  /* There *was* a method for testing endChunk here... then I realized it was
   * one line... which returned the length of the string minus 2...
   * Yeah, no real need to test that. XD
   */
  @SuppressWarnings("unchecked")
  @Test
  public void testPseudoLemma() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    String methodName = "pseudolemma";
    String inputString = "^Nom<SN><PDET><m><sg>{^anarquismo<n><3><4>$}$";
    String expectedOutput = "^Nom";

    Class[] paramTypes = {String.class};
    Object[] params = {inputString};

    String returnVal = (String) runPrivateMethod(methodName, paramTypes, params);

    assertEquals("TestPostChunk.testPseudoLemma() failed: output does not match expected output", expectedOutput, returnVal);
  }

  public void testSplitWordsAndBlanks() {
    /* TODO: Implement this -- Not sure what the output of splitWordsAndBlanks() should
     * be yet. n.n;
     */
  }

  /**
   * Test method for {@link org.apertium.postchunk.Postchunk#postchunk(java.io.Reader, Writer)}.
   * Postchunk takes the output from interchunk as its input and outputs to lt-proc.
   * This tests Postchunk with a single constructed sample sentence.
   */
  @Test
  public void testThisIsATest() throws IOException {
    String testIn = "^Prn<SN><tn><m><sp>{^esto<prn><tn><3><4>$}$ ^be<Vcop><vbser><pri><p3><sg>{^ser<vbser><3><4><5>$}$ ^det_nom<SN><DET><f><sg>{^uno<det><ind><3><4>$ ^prueba<n><3><4>$}$^punt<sent>{^.<sent>$}$";
    String expTestOut = "^Esto<prn><tn><m><sp>$ ^ser<vbser><pri><p3><sg>$ ^uno<det><ind><f><sg>$ ^prueba<n><f><sg>$^.<sent>$";

    runSingleSentenceTest(testIn, expTestOut);
  }

  @Test
  public void testSentence4() throws IOException {
    String testIn = "^Det_nom<SN><DET><m><sg>{^el<det><def><3><4>$ ^plazo<n><3><4>$}$";
    String expTestOut = "^El<det><def><m><sg>$ ^plazo<n><m><sg>$";

    runSingleSentenceTest(testIn, expTestOut);
  }

  @SuppressWarnings("unchecked")
  private void runSingleSentenceTest(String testIn, String expTestOut) throws IOException {
    Class transferClass = org.apertium.transfer.old.generated.apertium_en_es_en_es_t3x.class;
    String preprocFile = testDataDir + "en-es.t3x.bin";

    /* The logic in ApertiumPostchunk.main() is mostly for parsing the command-line,
     * since we're calling it directly in Java, we can bypass it.
     */
    StringReader input = new StringReader(testIn);
    Writer output = new StringWriter();

    Postchunk postchunk = new Postchunk();
    //Interchunk.DEBUG = true;
    try {
      postchunk.read(transferClass, preprocFile);
      //postchunk.transferObject.debug = true;

      postchunk.process(input, output);
    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception occured during test.");
    }

    String testOutput = output.toString();

    System.err.println("output = " + testOutput);
    System.err.println("expout = " + expTestOut);
    assertEquals("TestPostchunk.testMainThisIsATest() failed: output does not match expected output.", expTestOut, testOutput);
  }

  /**
   * Test of Interchunk.interchunk(), using external text files.
   */
  @SuppressWarnings("unchecked")
  @Test
  public void test200Sentences() throws IOException {
    String inFile = testDataDir + "en-postchunk-input.txt";
    Class transferClass = org.apertium.transfer.old.generated.apertium_en_es_en_es_t3x.class;
    String preprocFile = testDataDir + "en-es.t3x.bin";
    String compareOutFile = testDataDir + "en-postchunk-output.txt";

    /* The logic in ApertiumPostchunk.main() is mostly for parsing the command-line,
     * since we're calling it directly in Java, we can bypass it.
     */
    Reader input = new FileReader(inFile);
    Writer output = new StringWriter();

    Postchunk postchunk = new Postchunk();
    //Debug produces too much output and slows down execution too much.
    //Postchunk.DEBUG = false;
    try {
      postchunk.read(transferClass, preprocFile);
      //interchunk.transferObject.debug = true;

      postchunk.process(input, output);
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

    assertEquals("TestPostchunk.test200Sentences() failed: output does not match expected output.", expectedOutput, testOutput);
  }
}
