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
      String datadir = "/home/j/esperanto/apertium-svn/apertium/trunk";
      //Process p = Runtime.getRuntime().exec("find "+datadir+" -name *nb-nn.t1x");
      Process p = Runtime.getRuntime().exec("find "+datadir+" -name *.t1x");

      BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

      String t1xFile;
      int n=0;
      while ((t1xFile = br.readLine()) != null) try {
        System.err.println("\n============");
        String relFile = t1xFile.substring(datadir.length());
        String relFileWOSufffix = relFile.substring(0,relFile.lastIndexOf('.'));
        String rootDir = "/tmp/transfertest/";
        new File(rootDir+"/res/"+relFile).getParentFile().mkdirs();
        String resFileWOSufffix = rootDir+"/res/"+relFileWOSufffix;
        new File(rootDir+"/actual/"+relFile).getParentFile().mkdirs();
        new File(rootDir+"/expected/"+relFile).getParentFile().mkdirs();
        Process p2 = Runtime.getRuntime().exec("apertium-validate-transfer "+t1xFile);
        if (p2.waitFor()!=0) {
          System.err.println(t1xFile+" does not pass apertium-validate-transfer");
          continue;
        }

        ApertiumTransferCompile.main(new String[]{t1xFile, resFileWOSufffix+".class"});
        Runtime.getRuntime().exec("apertium-preprocess-transfer "+t1xFile+" "+resFileWOSufffix+".bin").waitFor();

        Runtime.getRuntime().exec("cp "+t1xFile+" "+new File(rootDir+"/res/"+relFile).getParent());

        String testdir = "testdata/transfer/";
        
        p = Runtime.getRuntime().exec(new String[]{"apertium-transfer", t1xFile, resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          testdir+"transferinput-en-eo.t1x-malgranda.txt", rootDir+"/expected/"+relFileWOSufffix+".txt"}); //.waitFor();

        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          testdir+"transferinput-en-eo.t1x-malgranda.txt", rootDir+"/actual/"+relFileWOSufffix+".txt"});
        /*
        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          testdir+"transferinput-en-eo.t1x-malgranda.txt"});
//        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
//          testdir+"transferinput-en-eo.t1x-malgranda.txt"});
*/
      } catch (Exception e) {
        e.printStackTrace();
      }
      p.waitFor(); // wait for last process before exit
  }




}
