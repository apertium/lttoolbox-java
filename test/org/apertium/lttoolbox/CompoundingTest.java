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
import static org.junit.Assert.*;

/**
 *
 * @author Jacob Nordfalk
 */
public class CompoundingTest extends TestCase {



  public void testCompound() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/compounding/eo-en.automorf.bin")));
      fstp.initAnalysis();
      fstp.setCompoundAnalysis(true);
      fstp.setCompoundingSymbol("compounding");

      assertEquals("/domo<n><sg><nom>+detektivo<n><m><sg><nom>", fstp.compoundAnalysis("domodetektivo"));

  }


  // lt-comp lr apertium-eo-en.eo.dix eo-en.automorf.bin

  public void testCompound0() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/compounding/eo-en.automorf.bin")));
      fstp.initAnalysis();
      fstp.setCompoundAnalysis(true);
      fstp.setCompoundingSymbol("compounding");

      assertEquals("/domo<n><sg><nom>+detektivo<n><m><sg><nom>", fstp.compoundAnalysis("domodetektivo"));


      StringWriter output = new StringWriter();
      fstp.analysis(new StringReader2("diktatorodio domo\n"), output);
      assertEquals("^diktatorodio/diktatoro<n><m><sg><nom>+dio<n><m><sg><nom>$ ^domo/domo<n><sg><nom>$\n", output.toString());
    
      System.out.println(output);
  }



  /*
  public void xxtestCompoiund() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("testdata/compounding/foo.bin")));
      fstp.initAnalysis();
      fstp.initDecomposition();

      StringWriter output = new StringWriter();
      fstp.analysis(new StringReader2("danning\n"), output);
      System.err.println(output);
  }

  public void testCompoiund2() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("/home/j/esperanto/apertium/apertium-is-en/is.bin")));
      fstp.initAnalysis();
      fstp.setCompoundAnalysis(true);

      StringWriter output = new StringWriter();
      fstp.analysis(new StringReader2("Bændasamtökunum samtökunum\n"), output);
      System.err.println(output);

      output.getBuffer().setLength(0);
      fstp.analysis(new StringReader2("lambakjöti\n"), output);
      System.err.println(output);

      output.getBuffer().setLength(0);
      fstp.analysis(new StringReader2("persónukjöri\n"), output);
      System.err.println(output);

      output.getBuffer().setLength(0);
      fstp.analysis(new StringReader2("Reykjavíkurborg\n"), output);
      System.err.println(output);


      output.getBuffer().setLength(0);
      fstp.analysis(new StringReader2("Þýsklandi\n"), output);
      System.err.println(output);


  }



  
// ^Bændasamtökunum/Bóndi<n><m><pl><gen><ind>+samtök<n><nt><sg><dat><ind>/Bóndi<n><m><pl><gen><ind>+samtök<n><nt><pl><dat><def>$ ^samtökunum/samtök<n><nt><sg><dat><ind>/samtök<n><nt><pl><dat><def>$
*/

}














