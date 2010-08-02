
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.apertium.lttoolbox.process.FSTProcessor;
import org.apertium.transfer.ApertiumTransfer;
import org.apertium.transfer.compile.ApertiumTransferCompile;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob Nordfalk
 */
public class Playground {

    public static void main(String[] args) throws Exception {

      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new BufferedInputStream(new FileInputStream("unhammer-fejl/hang.bin")));
      fstp.initAnalysis();
      StringWriter output = new StringWriter();
      fstp.analysis(new StringReader("sjokolade\n"), output);
      System.err.println("testAnalysis_small_oneWound_Java = '" + output.toString()+"'");


//   fstp.load(new BufferedInputStream(new FileInputStream("/home/j/esperanto/apertium/apertium-eo-en/apertium-eo-en.en-eo.bin")));
/*
      FSTProcessor bilfstp = new FSTProcessor();
      bilfstp.load(new BufferedInputStream(new FileInputStream("/home/j/esperanto/apertium/apertium-eo-en/en-eo.autobil.bin")));
      bilfstp.initBiltrans();
      String output = bilfstp.biltrans("house<n><sg>" , false);
      System.err.println("output = " + output);
*/
    }

}
