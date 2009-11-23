package org.apertium.lttoolbox;

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

import java.io.*;


// The implementation of GetOpt currently used is Sun proprietary API and may be removed in a future release.
// Making this small subclass makes the compiler warn only once instead of 3 times
class GetOpt extends com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt {

  public GetOpt(String[] argv, String string) {
    super(argv, string);
  }
}

/**
 * 
 * @author Raah
 */
public class LTProc {

    private static final String PACKAGE_VERSION = "0.1j";

    static void endProgram(String name) {
        System.out.print(name + ": process a stream with a letter transducer\n" +
            "USAGE: " + name + " [-c] [-a|-g|-n|-d|-p|-s|-t] fst_file [input_file [output_file]]\n" +
            "Options:\n" +
            "  -a:   morphological analysis (default behavior)\n" +
            "  -c:   use the literal case of the incoming characters\n" +
            "  -g:   morphological generation\n" +
            "  -n:   morph. generation without unknown word marks\n" +
            "  -d:   morph. generation with all the stuff\n"+
            "  -p:   post-generation\n" +
            "  -s:   SAO annotation system input processing\n" +
            "  -t:   apply transliteration dictionary\n" +
            "  -z:   flush output on the null character \n" +
            "  -v:   version\n" +
            "  -h:   show this help\n");
        System.exit(-1);

    }

    static void checkValidity(FSTProcessor fstp) {
        if (!fstp.valid()) {
            throw new RuntimeException("Validity test for FSTProcessor failed");
        }
    }

    public static void main(String[] argv) throws Exception {

        InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
        
        //System.err.println( isr.getEncoding());
        //System.err.println(System.getProperty("file.encoding"));
        //System.exit(-1);
        System.setProperty("file.encoding", "UTF-8");
        //System.getProperties().list(new PrintStream(System.err));
        //System.exit(-1);
        if (argv.length == 0) {
            //argv = new String[]{"./testTransducer2.bin"};
            //argv = new String[]{"./outc"};
            endProgram("LTProc");
        }

        final int argc = argv.length;

        int cmd = 0;
        FSTProcessor fstp = new FSTProcessor();

        GetOpt getopt = new GetOpt(argv, "acgndpstzvh");

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
                        fstp.setCaseSensitiveMode(true);
                        break;

                    case 'a':
                    case 'g':
                    case 'n':
                    case 'd':
                    case 'p':
                    case 't':
                    case 's':
                        if (optind == -1) {
                            optind = counter;
                            cmd = c;
                        } else {
                            endProgram("LTProc");
                        }
                        break;

                    case 'z':
                        fstp.setNullFlush(true);
                        break;

                    case 'v':
                        System.out.println("org.apertium.lttoolbox.LTProc version " + PACKAGE_VERSION);
                        return;

                    case 'h':
                    default:
                        endProgram("LTProc");
                        break;
                }
                counter++;

            } catch (Exception e) {
                endProgram("LTProc");
            }
        }

        final DataInputStream input;
        Writer output = new OutputStreamWriter(System.out);

        if (optind == (argc - 4)) {

            DataInputStream in = fopen(argv[optind + 1]);
            if (in == null) {
                endProgram("LTProc");
            }

            input = fopen(argv[optind + 2]);
            if (input == null) {
                endProgram("LTProc");
            }

            output = fout(argv[optind + 3]);
            if (output == null) {
                endProgram("LTProc");
            }

            fstp.load(in);
            in.close();
        } else if (optind == (argc - 3)) {
            DataInputStream in = fopen(argv[optind + 1]);
            if (in == null) {
                endProgram("LTProc");
            }

            input = fopen(argv[optind + 2]);
            if (input == null) {
                endProgram("LTProc");
            }

//            int plop = 0;
//            while(plop<42) {
//                System.out.println((char)input.read());
//                plop++;
//            }
//            System.exit(-1);
            fstp.load(in);
            in.close();

        //System.out.println("hii :"+(char)input.read());
        } else {
//            InputStreamReader isr = new InputStreamReader (System.in);
//            FileWriter fw = new FileWriter (new File("TemporaryOutputFile.txt"));
//            if (isr.ready()){
//                int read_char=isr.read();
//                while (read_char != -1) {
//                    fw.write((char) read_char);
//                    read_char = isr.read();
//                }
//            }
//            isr.close();
//            fw.close();
//            input=fopen("TemporaryOutputFile.txt");
            input = new DataInputStream(System.in);

            if (optind == (argc - 2)) {
                final String filename = argv[optind + 1];
                DataInputStream in = fopen(filename);
                if (in == null) {
                    endProgram("LTProc");
                }
                fstp.load(in);
                in.close();
            } else {
                endProgram("LTProc");
            }
        }

        try {
            switch (cmd) {
                case 'n':
                    fstp.initGeneration();
                    checkValidity(fstp);
                    fstp.generation(input, output, FSTProcessor.GenerationMode.gm_clean);
                    break;

                case 'g':
                    fstp.initGeneration();
                    checkValidity(fstp);
                    fstp.generation(input, output, FSTProcessor.GenerationMode.gm_unknown);
                    break;

                case 'd':
                    fstp.initGeneration();
                    checkValidity(fstp);
                    fstp.generation(input, output, FSTProcessor.GenerationMode.gm_all);

                case 'p':
                    fstp.initPostgeneration();
                    checkValidity(fstp);
                    fstp.postgeneration(input, output);
                    break;

                case 's':
                    fstp.initAnalysis();
                    checkValidity(fstp);
                    fstp.SAO(input, output);
                    break;

                case 't':
                    fstp.initPostgeneration();
                    checkValidity(fstp);
                    fstp.transliteration(input, output);
                    break;

                case 'a':
                default:
                    //System.out.println("plop 333:" + (char) 0);
                    fstp.initAnalysis();
                    checkValidity(fstp);
                    fstp.analysis(input, output);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (fstp.getNullFlush()) {
                output.write('\0');
            }
            System.exit(1);
        }

        input.close();
        //output.write("\n\né\n");
        
        output.close();
        
//System.err.println(Charset.availableCharsets().keySet());
    }
    private static Writer fout(String filename) throws FileNotFoundException, UnsupportedEncodingException {
        String encoding = "UTF-8";
        if (System.getProperties().containsKey("file.encoding")) {
            encoding = System.getProperty("file.encoding");
        }
        return new OutputStreamWriter(new FileOutputStream(new File(filename)), encoding);
    }

    private static DataInputStream fopen(String filename) throws FileNotFoundException {
        String encoding = "UTF-8";
        if (System.getProperties().containsKey("file.encoding")) {
            encoding = System.getProperty("file.encoding");
        }
        return new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
    }
}
