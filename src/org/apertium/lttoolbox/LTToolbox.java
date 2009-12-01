/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.lttoolbox;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Arrays;
import org.apertium.lttoolbox.process.FSTProcessor;

/**
 *
 * @author Jacob Nordfalk
 */
public class LTToolbox {

    static void showHelp() {

      String jar = System.getProperty("java.class.path");
      if (jar.contains(":") || !jar.endsWith("lttoolbox.jar")) jar = "lttoolbox.jar";
      /*
      System.out.println(System.getProperty("java.class.path"));
      System.out.println(System.getProperties());
      System.out.println(System.getenv());
      System.out.println(LTToolbox.class.getResource("/x"));
      System.out.println(LTToolbox.class.getResource("."));
       */
        System.out.println("lttoolbox: is a toolbox for lexical processing, morphological analysis and generation of words\n" +
            "USAGE: java -jar " +jar+ " [task]\n" +
            "Examples:\n" +
            " java -jar " +jar+ " lt-expand dictionary.dix     expands a dictionary\n" +
            " java -jar " +jar+ " lt-comp lr dic.dix dic.bin   compiles a dictionary\n" +
            " java -jar " +jar+ " lt-proc dic.bin              morphological analysis\n" +
            "See also http://wiki.apertium.org/wiki/Lttoolbox");
        System.exit(-1);

    }

  public static void main(String[] argv) throws Exception {
      if (argv.length == 0) showHelp();
      String task = argv[0];
      String[] restOfArgs = Arrays.copyOfRange(argv, 1 , argv.length);
      if (task.equals("lt-proc")) LTProc.main(restOfArgs);
      else if (task.equals("lt-comp")) LTComp.main(restOfArgs);
      else if (task.equals("lt-expand")) LTExpand.main(restOfArgs);
      else showHelp();
    }

}
