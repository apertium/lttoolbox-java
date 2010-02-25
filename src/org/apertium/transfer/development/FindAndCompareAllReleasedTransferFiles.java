/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer.development;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import org.apertium.lttoolbox.process.FSTProcessor;
import org.apertium.transfer.ApertiumTransfer;
import org.apertium.transfer.ApertiumTransferCompile;

/**
 * comparison of all language pairs of interpreded and compiled version of transfer.
 * @author Jacob Nordfalk
 */
public class FindAndCompareAllReleasedTransferFiles {

  static String datadir = "/home/j/esperanto/apertium-svn/apertium/trunk";

static String[] transferFilesWithDifferences = {
"apertium-nn-nb/apertium-nn-nb.nn-nb.t1x",
"apertium-cy-en/apertium-cy-en.en-cy.t1x",
"apertium-cy-en/apertium-cy-en.cy-en.t1x",
"apertium-es-ast/apertium-es-ast.es-ast.t1x",
};


  public static String[] findAlllTransferFilesOnDisk() throws IOException {
    ArrayList<String> transerFiles = new ArrayList<String>();
    Process pf=Runtime.getRuntime().exec(new String[] {"find", ".", "-name", "*.t1x"}, null, new File(datadir));
    BufferedReader br=new BufferedReader(new InputStreamReader(pf.getInputStream()));
    String t1xFile;
    while ((t1xFile=br.readLine())!=null) {
      if (t1xFile.startsWith("./")) t1xFile = t1xFile.substring(2); // strip ./
      transerFiles.add(t1xFile);
    }

    return transerFiles.toArray(new String[transerFiles.size()]);
  }




    public static void main(String[] args) throws Exception {
      String testdir = "testdata/transfer/";

      // Average speedup: 1.168421052631579 - individual: [0.28, 0.63, 0.65, 1.07, 1.13, 1.01, 1.28, 1.24, 1.1, 1.33, 1.36, 1.0, 0.91, 0.94, 1.37, 1.47, 0.54, 1.69, 1.42, 1.37, 1.47, 1.51, 1.61, 1.6, 1.48, 1.35, 0.36, 1.63, 1.57, 1.46, 1.47, 1.22, 1.31, 0.31, 1.45, 1.52, 1.23, 0.34, 1.21, 1.64, 0.28, 1.49, 1.76, 1.4, 1.72, 0.43, 1.5, 0.65, 1.12, 1.27, 0.42, 1.45, 1.4, 1.05, 1.58, 1.1, 0.45]
      // Average speedup: 1.1305172413793103 - individual: [0.22, 0.8, 0.51, 1.28, 1.04, 1.02, 1.31, 1.07, 0.95, 1.14, 1.92, 1.66, 0.85, 1.17, 1.02, 1.3, 1.25, 0.55, 1.11, 1.29, 1.31, 0.8, 1.44, 1.46, 1.88, 1.7, 1.46, 0.32, 1.16, 1.89, 1.17, 1.56, 1.0, 1.47, 0.31, 1.53, 1.26, 1.48, 0.3, 1.58, 1.46, 0.32, 1.56, 1.48, 0.88, 1.5, 0.29, 0.89, 0.93, 1.32, 0.88, 0.37, 1.19, 1.43, 1.48, 1.21, 1.31, 0.53]
      String inputFile = testdir+"transferinput-en-eo.t1x-malgranda.txt";

      // Average speedup: 4.189285714285715 - individual: [3.96, 4.01, 4.43, 4.46, 4.27, 3.97, 4.4, 4.36, 4.44, 4.56, 4.34, 4.03, 4.21, 3.94, 4.75, 4.48, 3.83, 4.2, 4.41, 4.1, 4.8, 4.3, 4.09, 4.85, 4.22, 4.59, 3.68, 3.93, 4.78, 3.42, 4.54, 4.86, 4.56, 3.2, 3.97, 3.8, 4.86, 3.33, 4.09, 2.97, 4.54, 4.52, 4.64, 4.91, 3.27, 4.11, 4.3, 4.1, 4.34, 3.67, 3.68, 4.13, 4.35, 3.27, 4.46, 4.32]
      //String inputFile = testdir+"transferinput-en-eo.t1x.txt";

      //String[] transferFiles = transferFilesWithDifferences;
      String[] transferFiles = findAlllTransferFilesOnDisk();
      //printFilesAsJavaArray(transferFiles);


      ArrayList<String> doesentValidate = new ArrayList<String>();
      ArrayList<String> interpretedTranferFails = new ArrayList<String>();
      ArrayList<String> compiledTranferFails = new ArrayList<String>();
      ArrayList<String> tranferCompareOK = new ArrayList<String>();
      ArrayList<String> tranferCompareFail = new ArrayList<String>();
      ArrayList<Double> speedUps = new ArrayList<Double>();
      double speedupSum = 0;



      for (String relFile : transferFiles) try {
        System.err.println("\n============");
        String absFile = datadir + File.separator + relFile;
        String relFileWOSufffix = relFile.substring(0,relFile.lastIndexOf('.'));
        String rootDir = "/tmp/transfertest/";
        new File(rootDir+"/res/"+relFile).getParentFile().mkdirs();
        String resFileWOSufffix = rootDir+"/res/"+relFileWOSufffix;
        new File(rootDir+"/actual/"+relFile).getParentFile().mkdirs();
        new File(rootDir+"/expected/"+relFile).getParentFile().mkdirs();
        int ret = exec("apertium-validate-transfer "+absFile);
        if (ret!=0) {
//          System.err.println(t1xFile+" does not pass apertium-validate-transfer");
          System.err.println("ERROR: "+absFile+"\ndoes not pass apertium-validate-transfer. Skipping...");
          doesentValidate.add(relFile);
          continue;
        }

        try {
          ApertiumTransferCompile.main(new String[]{absFile, resFileWOSufffix+".class"});
        } catch (Throwable e) {
          System.err.println("COMPILATION failed:"+e);
          compiledTranferFails.add(relFile);
          continue;
        }
        exec("apertium-preprocess-transfer "+absFile+" "+resFileWOSufffix+".bin");


        exec("cp "+absFile+" "+new File(rootDir+"/res/"+relFile).getParent());


        long time = System.currentTimeMillis();
        ret = exec("apertium-transfer", absFile, resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          inputFile, rootDir+"/expected/"+relFileWOSufffix+".txt");

        if (ret!=0) interpretedTranferFails.add(relFile);


        long interpretedTime = System.currentTimeMillis()-time;
        System.err.println("Interpreted transfer took " + (interpretedTime/10)*0.01+" secs");
        time = System.currentTimeMillis();

        try {
        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          inputFile, rootDir+"/actual/"+relFileWOSufffix+".txt"});
        } catch (Exception e) {
          e.printStackTrace();
          compiledTranferFails.add(relFile);
          ret = -1;
        }

        long bytecodeCompiledTime = System.currentTimeMillis()-time;
        System.err.println("bytecode compiled transfer took " + (bytecodeCompiledTime/10)*0.01+" secs");

        if (ret!=0) {
          System.err.println("(transfer failed so not comparing)");
        } else {
          double speedup =  (100*interpretedTime/bytecodeCompiledTime)/100.0;
          speedupSum += speedup;
          speedUps.add(speedup);
          System.err.println("Speedup factor: " +speedup);
          String diff = "diff -q "+rootDir+"/expected/"+relFileWOSufffix+".txt "+rootDir+"/actual/"+relFileWOSufffix+".txt";
          ret = exec(diff);
          if (ret==0) {
            System.err.println("OK: Output of interpreted and bytecode compiled transfer is exactly the same");
            tranferCompareOK.add(relFile);

          } else {
            System.err.println(diff);
            System.err.println("FAIL: Output of interpreted and bytecode compiled transfer HAS DIFFERENCES");
            tranferCompareFail.add(relFile);
          }
        }

        /*
        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          testdir+"transferinput-en-eo.t1x-malgranda.txt"});
//        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
//          testdir+"transferinput-en-eo.t1x-malgranda.txt"});
*/
      } catch (Exception e) {
        e.printStackTrace();
      }

      print("Transfer files doesent validate", doesentValidate);
      print("Interpreted (old) tranfer fails", interpretedTranferFails);
      print("Compiled (new) tranfer fails", compiledTranferFails);
      print("Old & new tranfer give same results", tranferCompareOK);
      print("Old & new tranfer give different results",tranferCompareFail );


      System.err.println("Average speedup: "+speedupSum/speedUps.size()+" - individual: "+speedUps);
    }

  public static void printFilesAsJavaArray(String[] transferFiles) {
    System.out.println("static String[] transferFiles = {");
    for (String relFile : transferFiles) {
      System.out.println("\""+relFile+"\",");
    }
    System.out.println("};");
  }

  public static int exec(String... cmd) throws Exception {
    //System.err.println("exec: " + Arrays.toString(cmd));
      Process p = Runtime.getRuntime().exec(cmd);
    BufferedReader br=new BufferedReader(new InputStreamReader(p.getErrorStream()));
    String s=br.readLine();
    if (s!=null) {
      System.err.println(s);
      p.destroy();
      return -1;
    }
      int ret = p.waitFor();
   // System.err.println("exec finish");
      p.getErrorStream().close();
      p.getInputStream().close();
      p.getOutputStream().close();
      return ret;
  }

  public static int exec(String cmd) throws Exception {
    return exec(cmd.split(" "));
  }

  private static void print(String string, ArrayList<String> doesentValidate) {
    System.err.println(string+" "+doesentValidate.size()+": "+doesentValidate);
  }



}
