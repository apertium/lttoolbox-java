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

import static org.apertium.utils.IOUtils.getStdinReader;
import static org.apertium.utils.IOUtils.getStdoutWriter;
import static org.apertium.utils.IOUtils.openInFileReader;
import static org.apertium.utils.IOUtils.openOutFileWriter;

import org.apertium.lttoolbox.*;
import org.apertium.lttoolbox.process.FSTProcessor;
import java.io.*;

import org.apertium.lttoolbox.process.State;

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
"  -n         don't use bilingual dictionary\n" +
//"  -x bindix  extended mode with user dictionary\n" +
//"  -c         case-sensitiveness while accessing bilingual dictionary\n" +
"  -z         null-flushing output on '\n" +
"  -h         shows this message\n" +
"");
        System.exit(-1);

    }

    public static void main(String[] argv) throws Exception {
        doMain(argv, null, null);
    }
    
    public static void doMain(String[] argv, Reader input, Writer output) 
            throws IOException, InstantiationException, IllegalAccessException, 
            ClassNotFoundException {

        System.setProperty("file.encoding", "UTF-8");
        if (argv.length == 0) {
            endProgram("apertium-transfer-j");
        }

        Transfer t = new Transfer();
        MyGetOpt getopt = new MyGetOpt(argv, "cvnzhD");

        int optind = -1;
        while (true) {
            try {

                int c = getopt.getNextOption();
                if (c == -1) {
                    break;
                }
                optind ++;
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

                    case 'n':
                        t.setUseBilingual(false);
                        break;

                    case 'v':
                        System.out.println(LTToolbox.PACKAGE_VERSION);
                        return;

                    case 'h':
                    default:
                        endProgram(argv[0]);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                endProgram();
            }
        }

        if (argv.length > optind+3) {
          t.read(argv[optind + 1], argv[optind + 2], argv[optind + 3]);
          if (t.DEBUG) t.transferObject.debug = true;
        } else {
          endProgram();
        }
        
        if(input != null || output != null) {
            /* If either is supplied, ignore command-line input/output files,
             * as we are in inter-jvm pipeline mode, and if the modes file
             * is supplying input/ouput files, we don't want to use them,
             * as we are keeping everything in memory inside the jvm.
             */
            if(input == null) { input = getStdinReader(); }
            if(output == null) { output = getStdoutWriter(); }
        } else {
            if (argv.length > optind+4) {
                input = openInFileReader(argv[optind + 4]);
            } else {
              input = getStdinReader();
            }
            if (argv.length > optind+5) {
                output = openOutFileWriter(argv[optind + 5]);
            } else {
              output = getStdoutWriter();
            }
        }

        try {
            t.transfer(input, output);
            input.close();
            output.close();
        } catch (Exception e) {
            output.flush();
            System.out.flush();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e1) {
                /* Do nothing, we really don't care if we've been
                 * interrupted by anything, as this isn't synchronized
                 * code.
                 */
            }
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
