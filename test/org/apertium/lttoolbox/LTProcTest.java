/*
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.lttoolbox;

import org.apertium.lttoolbox.process.FSTProcessor;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import junit.framework.TestCase;

/**
 *
 * @author Jacob Nordfalk
 */
public class LTProcTest extends TestCase {





  /**
   * Tests a transducer like http://wiki.apertium.org/wiki/Morphological_dictionaries
   * @throws java.io.IOException
   */
  public void testAnalysis_small_oneWound_Java() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/wound-example.bin")));
      fstp.initAnalysis();
      StringWriter output = new StringWriter();
      fstp.analysis(new StringReader("wound\n"), output);
      System.err.println("testAnalysis_small_oneWound_Java = '" + output.toString()+"'");

      // WORKS!!
      assertEquals("^wound/wind<vblex><pp>/wound<n><sg>$\n" , output.toString());
  }



  public void testAnalysis_small_oneWord_Java() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/correct-test.bin")));
      fstp.initAnalysis();
      // input a single 'a'   - should give  ^a/avoir<vbhaver><pri><p3><sg>$
      InputStream input = new ByteArrayInputStream("a\n".getBytes());
      StringWriter output = new StringWriter();
      fstp.analysis(new StringReader("a\n"), output);
      System.err.println("testAnalysis_small_oneWord_Java() output = " + output);

      // WORKS!
      assertEquals("^a/avoir<vbhaver><pri><p3><sg>$\n" , output.toString());
  }



  public void testAnalysis_small_twoWords_Java() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/correct-test.bin")));
      fstp.initAnalysis();
      InputStream input = new ByteArrayInputStream("a a\n".getBytes());
      StringWriter output = new StringWriter();
      fstp.analysis(new StringReader("a a\n"), output);
      String correct = "^a/avoir<vbhaver><pri><p3><sg>$ ^a/avoir<vbhaver><pri><p3><sg>$\n";

      System.err.println("I: '" + input+"'");
      System.err.println("O: '" + output+"'");
      System.err.println("C: '" + correct+"'");
      // WORKS
      assertEquals(correct , output.toString());
  }



  public void testAnalysis_small_oneWord_Cpp() throws IOException {
    Process p = Runtime.getRuntime().exec("lt-proc testdata/correct-test.bin");
    p.getOutputStream().write("a\n".getBytes());
    p.getOutputStream().close();
    String res = new BufferedReader(new InputStreamReader(p.getInputStream())).readLine();

    assertEquals("^a/avoir<vbhaver><pri><p3><sg>$" , res);
  }

  public void testAnalysisUppercasetransformation() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/regression/fr-es.automorf.bin")));
      fstp.initAnalysis();
      StringWriter output = new StringWriter();
      String input = "Un article ";
      String correct = "^Un/Un<num><m><sg>/Un<prn><tn><m><sg>/Un<det><ind><m><sg>$ ^article/article<n><m><sg>$ ";
      fstp.analysis(new StringReader(input), output);

      System.err.println("I: '" + input+"'");
      System.err.println("O: '" + output+"'");
      System.err.println("C: '" + correct+"'");

      // WORKS
      assertEquals(correct, output.toString());

  }

  public void testAnalysis3wordsWithSuperblanksAndNewlines() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/regression/fr-es.automorf.bin")));
      fstp.initAnalysis();
      StringWriter output = new StringWriter();
      String input = "je[\npart ]\n[]suis"
          +" [&#160;]:[ <b>]10,8[&#161;]%.[][<\\/b><\\/li>]content ";
      String correct = "^je/je<prn><tn><p1><mf><sg>$[\npart ]\n[]^suis/être<vblex><pri><p1><sg>/être<vbser><pri><p1><sg>/suivre<vblex><pri><p1><sg>/suivre<vblex><pri><p2><sg>/suivre<vblex><imp><p2><sg>$"
          +"[&#160;] ^:/:<sent>$[ <b>]^10,8/10,8<num>$[&#161;]%^./.<sent>$[][<\\/b><\\/li>]^content/content<adj><m><sg>/conter<vblex><pri><p3><pl>/conter<vblex><prs><p3><pl>$ ";
      fstp.analysis(new StringReader(input), output);

      System.err.println("I: '" + input+"'");
      System.err.println("O: '" + output+"'");
      System.err.println("C: '" + correct+"'");

      // WORKS
      assertEquals(correct, output.toString());

  }



    public void testAnalysis13words() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/regression/fr-es.automorf.bin")));
      fstp.initAnalysis();
      StringWriter output = new StringWriter();
      fstp.analysis(new StringReader("Militairement, la France possède l'une des principales forces armées d'Europe et est une\n"), output);
      String correct = "^Militairement/*Militairement$^,/,<cm>$ ^la/le<det><def><f><sg>/le<prn><pro><p3><f><sg>$ ^France/France<np><loc>$ ^possède/posséder<vblex><pri><p3><sg>/posséder<vblex><pri><p1><sg>/posséder<vblex><prs><p3><sg>/posséder<vblex><prs><p1><sg>/posséder<vblex><imp><p2><sg>$ ^l'/le<det><def><mf><sg>/le<prn><pro><p3><m><sg>/le<prn><pro><p3><f><sg>$ ^une/un<prn><tn><f><sg>/un<det><ind><f><sg>$ ^des/de<pr>+le<det><def><mf><pl>$ ^principales/principal<adj><f><pl>$ ^forces/force<n><f><pl>/forcer<vblex><pri><p2><sg>/forcer<vblex><prs><p2><sg>$ ^armées/armée<n><f><pl>/armer<vblex><pp><f><pl>$ ^d'/de<pr>$ ^Europe/Europe<np><loc>$ ^et/et<cnjcoo>$ ^est/est<n><m><sg>/être<vblex><pri><p3><sg>/être<vbser><pri><p3><sg>$ ^une/un<prn><tn><f><sg>/un<det><ind><f><sg>$\n";
      System.err.println("O: '" + output+"'");
      System.err.println("C: '" + correct+"'");

      // WORKS
      assertEquals(correct, output.toString());
  }




  public void testGeneration() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/generator.bin")));
      fstp.initGeneration();
      StringWriter output = new StringWriter();

      fstp.generation(new StringReader("^je<prn><tn><p1><mf><sg>$ ^moi<prn><tn><p1><mf><sg>$ \n"), output, FSTProcessor.GenerationMode.gm_unknown);
      System.err.println("testGeneration() output = " + output);

      // WORKS
      assertEquals("~je moi \n", output.toString());
  }




  public void testTaggedGeneration() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/generator.bin")));
      fstp.initGeneration();
      StringWriter output = new StringWriter();

      fstp.generation(new StringReader("^je<prn><tn><p1><mf><sg>$ ^moi<prn><tn><p1><mf><sg>$ \n"), output, FSTProcessor.GenerationMode.gm_tagged);
      System.err.println("testGeneration() output = " + output);

      // WORKS
      assertEquals("^~je/je<prn><tn><p1><mf><sg>$ ^moi/moi<prn><tn><p1><mf><sg>$ \n", output.toString());
  }

  public void testGenerationSuperblankAndUnknown() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/generator.bin")));
      fstp.initGeneration();
      StringWriter output = new StringWriter();
      fstp.generation(new StringReader( "^de<n>$ ^Europe<np><loc>$[<\\/a> <i>]\n"), output, FSTProcessor.GenerationMode.gm_unknown);
      System.err.println("testGeneration() output = " + output);

      // WORKS
      assertEquals("#de Europe[<\\/a> <i>]\n", output.toString());
  }


  public void testPostGeneration() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/regression/fr-es.autopgen.bin")));
      fstp.initGeneration();

      StringWriter output = new StringWriter();
      fstp.postgeneration(new StringReader("~je moi \n"), output);
      System.err.println("testGeneration() output = " + output);

      // WORKS
      assertEquals("je moi \n", output.toString());
  }



}
