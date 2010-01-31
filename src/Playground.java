
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.apertium.lttoolbox.process.FSTProcessor;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob Nordfalk
 */
public class Playground {



    public static void main(String[] args) throws IOException {

//   fstp.load(new BufferedInputStream(new FileInputStream("/home/j/esperanto/apertium/apertium-eo-en/apertium-eo-en.en-eo.bin")));

      FSTProcessor bilfstp = new FSTProcessor();
      bilfstp.load(new BufferedInputStream(new FileInputStream("/home/j/esperanto/apertium/apertium-eo-en/en-eo.autobil.bin")));
      bilfstp.initBiltrans();
      String output = bilfstp.biltrans("house<n><sg>" , false);
      System.err.println("output = " + output);

    }

      public static void xmain(String[] argv) throws Exception {
          
          FSTProcessor fstp = new FSTProcessor();
          fstp.load(new BufferedInputStream(new FileInputStream("testdata/cb.bin")));
          fstp.initAnalysis();
          StringWriter output = new StringWriter();
          String input = "c b[\n]";
          fstp.analysis(new StringReader2( input ), output);
          System.err.println("analysis output = " + output);
      }
}
