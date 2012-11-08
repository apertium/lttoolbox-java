
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.apertium.lttoolbox.process.FSTProcessor;
import org.apertium.pipeline.ApertiumMain;
import org.apertium.transfer.ApertiumTransfer;
import org.apertium.transfer.Transfer;
import org.apertium.transfer.old.compile.ApertiumTransferCompile;
import org.apertium.utils.IOUtils;

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

      //String[] arg = {"-d", "/usr/local/share/apertium/", "es-en", "europarl-v7.es-en.es.1000", "/tmp/europarl-v7.es-en.es.rezulto"};
      //String[] arg = {"-a", "-d", "/usr/local/share/apertium/", "en-es", "/tmp/will", "/tmp/will.rezulto"};
      //String[] arg = {"-d", "/usr/local/share/apertium/", "en-es", "/tmp/will", "/tmp/will.rezulto"};
      //ApertiumMain.main(arg);

      measureMemory();
      measureBigTransferMemory();

/*
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

  private static void measureMemory() throws InterruptedException, IOException {
    Runtime rt = Runtime.getRuntime();
    FSTProcessor fstp = new FSTProcessor();
     //fstp.load(new BufferedInputStream(new FileInputStream("/home/j/esperanto/apertium/apertium-eo-en/en-eo.autobil.bin")));
     fstp.load("/home/j/esperanto/apertium/trunk/apertium-eo-en/en-eo.autobil.bin");
     fstp = null;
     System.gc();
     Thread.sleep(200);
     System.gc();

    long alloc1 = rt.totalMemory()-rt.freeMemory();
     fstp = new FSTProcessor();
  //  fstp.load(new BufferedInputStream(new FileInputStream("testdata/wound-example.bin")));
  //   fstp.load(new BufferedInputStream(new FileInputStream("/home/j/esperanto/apertium/apertium-eo-en/en-eo.autobil.bin")));
     fstp.load("/home/j/esperanto/apertium/trunk/apertium-eo-en/en-eo.autobil.bin");
     System.gc();
     Thread.sleep(200);
     System.gc();
    long alloc2 = rt.totalMemory()-rt.freeMemory();

    System.err.println("alloc " + (alloc2 - alloc1));
  }

  private static void measureBigTransferMemory() throws InterruptedException, IOException {
    Runtime rt = Runtime.getRuntime();
    Transfer fstp = new Transfer();
     fstp.readData(IOUtils.openFileAsByteBuffer("../en-es.t1x.bin"));
     fstp = null;
     System.gc();
     Thread.sleep(200);
     System.gc();

    long alloc1 = rt.totalMemory()-rt.freeMemory();
     fstp = new Transfer();
     fstp.readData(IOUtils.openFileAsByteBuffer("../en-es.t1x.bin"));
     System.gc();
     Thread.sleep(200);
     System.gc();
    long alloc2 = rt.totalMemory()-rt.freeMemory();

    System.err.println("alloc " + (alloc2 - alloc1));
  }
}
