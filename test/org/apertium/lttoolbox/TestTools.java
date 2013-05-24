/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Jacob Nordfalk
 */
public abstract class TestTools {
  public static String rm(String filename) throws FileNotFoundException {
    File f = new File(filename);
    if (f.isDirectory())
      for (File f2 : f.listFiles())
        rm(f2.getPath());
    f.delete();
    return filename;
  }

  public static String exec(String cmd) throws IOException, InterruptedException {

    System.err.println("exec: " + cmd);
    Process p = Runtime.getRuntime().exec(cmd);
    String s;
    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
    StringBuffer sb = new StringBuffer();
    while ((s = br.readLine()) != null) {
      sb.append(s);
      sb.append("\n");
    }
    String output = sb.toString();
    br.close();

    // some might want to switch it off on Windows, as the 'diff' command is lacking there.
    //if (System.getProperty("os.name").startsWith("Windows")) return output;

    p.waitFor();
    int retval = p.exitValue();

    if (output.length() > 0) {
      //System.err.println("exec: " + cmd);
      System.err.println("output: " + output);
    }

    if (p.exitValue() != 0)
      throw new RuntimeException(cmd + " reported error: " + retval);

    return output;
  }

  public static Process exep(String dir, String cmd) throws IOException, InterruptedException {

    File wd = new File(dir);

    Process p = Runtime.getRuntime().exec(cmd, null, wd);

    class Print extends Thread {
      BufferedReader br;

      private Print(InputStream errorStream) {
        br = new BufferedReader(new InputStreamReader(errorStream));
        start();
      }

      public void run() {
        try {
          String s;
          while ((s = br.readLine()) != null) {
            System.err.println(s);
          }
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    }
    new Print(p.getInputStream());
    new Print(p.getErrorStream());
    p.waitFor();

    return p;
  }
}
