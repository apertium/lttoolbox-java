
import java.io.BufferedInputStream;
import java.io.FileInputStream;
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
      public static void main(String[] argv) throws Exception {
          String input = "c b[\n]";
          
          FSTProcessor fstp = new FSTProcessor();
          fstp.load(new BufferedInputStream(new FileInputStream("testdata/cb.bin")));
          fstp.initAnalysis();
          StringWriter output = new StringWriter();
          fstp.analysis(new StringReader2( input ), output);
          System.err.println("analysis output = " + output);
      }
}
