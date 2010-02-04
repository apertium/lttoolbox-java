/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer.compile;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import org.apertium.lttoolbox.process.FSTProcessor;
import org.apertium.transfer.ApertiumTransfer;
import org.apertium.transfer.ApertiumTransferCompile;

/**
 *
 * @author Jacob Nordfalk
 */
public class FindAndCheckAllReleasedTransferFiles {

    public static void main(String[] args) throws Exception {
      //Process p = Runtime.getRuntime().exec(new String[] {"find", ".", "-name", "'*.t1x'"}, null, new File("/home/j/esperanto/apertium-svn/apertium/trunk"));
      String testdir = "testdata/transfer/";
      //String inputFile = testdir+"transferinput-en-eo.t1x-malgranda.txt";
      String inputFile = testdir+"transferinput-en-eo.t1x.txt";
      String datadir = "/home/j/esperanto/apertium-svn/apertium/trunk";
      //Process p = Runtime.getRuntime().exec("find "+datadir+" -name *nb-nn.t1x");
      Process pf = Runtime.getRuntime().exec("find "+datadir+" -name *.t1x");

      BufferedReader br = new BufferedReader(new InputStreamReader(pf.getInputStream()));

      String t1xFile;
      while ((t1xFile = br.readLine()) != null) try {
        System.err.println("\n============");
        String relFile = t1xFile.substring(datadir.length());
        String relFileWOSufffix = relFile.substring(0,relFile.lastIndexOf('.'));
        String rootDir = "/tmp/transfertest/";
        new File(rootDir+"/res/"+relFile).getParentFile().mkdirs();
        String resFileWOSufffix = rootDir+"/res/"+relFileWOSufffix;
        new File(rootDir+"/actual/"+relFile).getParentFile().mkdirs();
        new File(rootDir+"/expected/"+relFile).getParentFile().mkdirs();
        int ret = exec("apertium-validate-transfer "+t1xFile);
        if (ret!=0) {
//          System.err.println(t1xFile+" does not pass apertium-validate-transfer");
          System.err.println("ERROR: "+t1xFile+"\ndoes not pass apertium-validate-transfer. Skipping...");
          continue;
        }

        ApertiumTransferCompile.main(new String[]{t1xFile, resFileWOSufffix+".class"});
        exec("apertium-preprocess-transfer "+t1xFile+" "+resFileWOSufffix+".bin");


        exec("cp "+t1xFile+" "+new File(rootDir+"/res/"+relFile).getParent());


        long time = System.currentTimeMillis();
        exec(new String[]{"apertium-transfer", t1xFile, resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          inputFile, rootDir+"/expected/"+relFileWOSufffix+".txt"});

        long interpretedTime = System.currentTimeMillis()-time;
        System.err.println("Interpreted transfer took " + (interpretedTime/10)*0.01+" secs");
        time = System.currentTimeMillis();

        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          inputFile, rootDir+"/actual/"+relFileWOSufffix+".txt"});

        long bytecodeCompiledTime = System.currentTimeMillis()-time;
        System.err.println("bytecode compiled transfer took " + (bytecodeCompiledTime/10)*0.01+" secs");

        System.err.println("Speedup is " + (100*interpretedTime/bytecodeCompiledTime-100)+" %");

        ret = exec("diff "+rootDir+"/expected/"+relFileWOSufffix+".txt "+rootDir+"/actual/"+relFileWOSufffix+".txt");
        if (ret==0) System.err.println("Output of interpreted and bytecode compiled transfer is exactly the same");
        else System.err.println("Output of interpreted and bytecode compiled transfer HAS DIFFERENCES");

        /*
        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          testdir+"transferinput-en-eo.t1x-malgranda.txt"});
//        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
//          testdir+"transferinput-en-eo.t1x-malgranda.txt"});
*/
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  private static Object exec(String[] string) throws Exception {
      Process p = Runtime.getRuntime().exec(string);
      int ret = p.waitFor();
      p.getErrorStream().close();
      p.getInputStream().close();
      p.getOutputStream().close();
      return ret;
  }

  private static int exec(String string) throws Exception {
      Process p = Runtime.getRuntime().exec(string);
      int ret = p.waitFor();
      p.getErrorStream().close();
      p.getInputStream().close();
      p.getOutputStream().close();
      return ret;
  }




}
