package org.apertium.transfer;

/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */

import org.apertium.lttoolbox.*;
import org.apertium.lttoolbox.process.FSTProcessor;
import java.io.*;
import org.apertium.lttoolbox.process.State;
import static org.apertium.lttoolbox.LTProc.*;
/*
// The implementation of MyGetOpt currently used is Sun proprietary API and may be removed in a future release.
// Making this small subclass makes the compiler warn only once instead of 3 times
class MyGetOpt extends com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt {

  public MyGetOpt(String[] argv, String string) {
    super(argv, string);
  }
}
 */

// Use GNU Getopt

class MyGetOpt extends Getopt {

  public MyGetOpt(String[] argv, String string) {
    super("lttoolbox", argv, string);
  }

  int getNextOption() {
    return getopt();
  }
}

/**
 * 
 * @author Raah
 */
public class ApertiumTransfer {


    static void endProgram(String name) {
        System.out.print(name + LTToolbox.PACKAGE_VERSION +": \n" +
"USAGE: "+name+" trules-class preproc biltrans [input [output]]\n" +
//"       "+name+" -n trules preproc [input [output]]\n" +
//"       "+name+" -x extended trules preproc biltrans [input [output]]\n" +
//"       "+name+" -c trules preproc biltrans [input [output]]\n" +
"  trules-class Java bytecode compiled transfer rules (.class file)\n" +
"  preproc    result of preprocess trules (.bin file)\n" +
"  biltrans   bilingual letter transducer file\n" +
"  input      input file, standard input by default\n" +
"  output     output file, standard output by default\n" +
//"  -n         don't use bilingual dictionary\n" +
//"  -x bindix  extended mode with user dictionary\n" +
//"  -c         case-sensitiveness while accessing bilingual dictionary\n" +
"  -z         null-flushing output on '\n" +
"  -h         shows this message\n" +
"");
        System.exit(-1);

    }

    public static void main(String[] argv) throws Exception {

        System.setProperty("file.encoding", "UTF-8");
        if (argv.length == 0) {
            endProgram("apertium-transfer-j");
        }

        Transfer t = new Transfer();
        MyGetOpt getopt = new MyGetOpt(argv, "zhD");

        int optind = -1;
        int counter = 0;
        while (true) {
            try {

                int c = getopt.getNextOption();
                if (c == -1) {
                    break;
                }

                switch (c) {
                    case 'c':
                        t.setCaseSensitiveMode(true);
                        break;

                    case 'D':
                      FSTProcessor.DEBUG = true;
                      State.DEBUG = true;
                      Transfer.DEBUG = true;
                        break;

                    case 'z':
                        t.setNullFlush(true);
                        break;

                    case 'v':
                        System.out.println(LTToolbox.PACKAGE_VERSION);
                        return;

                    case 'h':
                    default:
                        endProgram(argv[0]);
                        break;
                }
                counter++;

            } catch (Exception e) {
                e.printStackTrace();
                endProgram();
            }
        }

        Reader input;
        Writer output;
        if (argv.length > optind+3) {
          t.read(argv[optind + 1], argv[optind + 2], argv[optind + 3]);
        } else {
          endProgram();
        }
        if (argv.length > optind+4) {
            input = openReader(argv[optind + 4]);
        } else {
          input = new InputStreamReader(System.in);
        }
        if (argv.length > optind+5) {
            output = fout(argv[optind + 5]);
        } else {
          output = new OutputStreamWriter(System.out);
        }

        try {
          t.transfer(input, output);
          input.close();
          output.close();
        } catch (Exception e) {
          output.flush();
          System.out.flush();
          Thread.sleep(10);
          e.printStackTrace();
          if (t.getNullFlush()) {
              output.write('\0');
          }
          System.exit(1);
        }
        
    }

  private static void endProgram() {
    endProgram("apertium-transfer-j");
  }
}
