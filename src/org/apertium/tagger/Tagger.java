/*
 * Copyright (C) 2005 Universitat d'Alacant / Universidad de Alicante
 * 
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

package org.apertium.tagger;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import org.apertium.lttoolbox.Getopt;

// Use GNU Getopt

class MyGetOpt extends Getopt {

  public MyGetOpt(String[] argv, String string) {
    super("apertium-tagger", argv, string);
  }

  int getNextOption() {
    return getopt();
  }
}


/**
 *
 * @author jimregan
 */
public class Tagger {

    static boolean showSF;
    static boolean null_flush;

    private static final int UNKNOWN_MODE=0;
    private static final int TRAIN_MODE=1;
    private static final int TAGGER_MODE=2;
    private static final int RETRAIN_MODE=3;
    private static final int TAGGER_SUPERVISED_MODE=4;
    private static final int TRAIN_SUPERVISED_MODE=5;
    private static final int RETRAIN_SUPERVISED_MODE=6;
    private static final int TAGGER_EVAL_MODE=7;
    private static final int TAGGER_FIRST_MODE=8;

    static boolean generate_marks;
    static boolean debug;

    static List<String> filenames;

    Tagger () {
        debug = false;
        showSF = false;
        null_flush = false;
        filenames = new ArrayList<String>();
    }

    static void setShowSF (boolean val) {
        showSF = val;
    }

    boolean getShowSF () {
        return showSF;
    }

    static int getMode (String[] argv) {
        int mode = UNKNOWN_MODE;

        int option_index = 0;
        MyGetOpt getopt = new MyGetOpt(argv, "mdtsrgpefhz");

        while (true) {
            try {
                int c = getopt.getNextOption();
                if (c == -1) {
                    break;
                }

                switch (c) {
                    case 'm':
                        generate_marks = true;
                        break;

                    case 'd':
                        debug=true;
                        break;

                    case 't':
                        System.err.println("Training not supported");
                        System.exit(0);
                        break;

                    case 's':
                        System.err.println("Training not supported");
                        System.exit(0);
                        break;

                    case 'p':
                        setShowSF(true);
                        break;

                    case 'r':
                        System.err.println("Training not supported");
                        System.exit(0);
                        break;

                    case 'g':
                        mode = TAGGER_MODE;
                        break;

                    case 'e':
                        if (mode==TAGGER_MODE) {
                            mode=TAGGER_EVAL_MODE;
                        } else {
                            System.err.println("Error: -e optional argument should only appear after -t argument");
                            help();
                        }
                        break;

                    case 'f':
                        if (mode==TAGGER_MODE) {
                            mode=TAGGER_FIRST_MODE;
                        } else {
                            System.err.println("Error: -f optional argument should only appear after -t argument");
                            help();
                        }
                        break;

                    case 'z':
                        null_flush = true;
                        break;

                    case 'h':
                        help();
                        break;

                    default:
                        help();
                        break;
                }

                if (mode==UNKNOWN_MODE) {
                    System.err.println("Error: Arguments missing");
                    help();
                }

                switch (argv.length-getopt.getOptind()) {
                    case 6:
                        if (mode != TRAIN_SUPERVISED_MODE)
                            help();
                        break;

                    case 4:
                        if (mode != TRAIN_MODE)
                            help();
                        break;

                    case 3:
                        if ((mode != TAGGER_MODE) && (mode != TAGGER_FIRST_MODE))
                            help();
                        break;

                    case 2:
                        if ((mode != RETRAIN_MODE) && (mode != TAGGER_MODE))
                            help();
                        break;

                    case 1:
                        if ((mode != TAGGER_MODE) && (mode != TAGGER_FIRST_MODE))
                            help();
                        break;

                    default:
                        help();
                        break;
                }

                for (int i=getopt.getOptind(); i!=argv.length; i++) {
                    filenames.add(argv[i]);
                }

                return mode;
            } catch (Exception e) {
                // FIXME
            }
        }
        return mode;
    }

    static void help() {
        // FIXME
    }

    public static void main (String[] argv) {
        int mode = getMode(argv);

        switch (mode) {
            case TRAIN_MODE:
                //train();
                break;

            case TRAIN_SUPERVISED_MODE:
                //trainSupervised();
                break;

            case RETRAIN_MODE:
                //retrain();
                break;

            case TAGGER_MODE:
                try {
                    tagger();
                } catch (Exception e) {
                    // Foo
                }
                break;

            case TAGGER_FIRST_MODE:
                try {
                    tagger(true);
                } catch (Exception e) {
                    // Foo
                }
                break;

            default:
                System.err.println("Error: unknown mode");
                help();
                break;
        }
    }

    static void tagger (boolean mode_first) throws IOException {
        InputStream ftdata = fopen(filenames.get(0));

        TaggerData td = new TaggerData();

        td.read(ftdata);
        ftdata.close();

        HMM hmm = new HMM(td);

        hmm.set_show_sf(showSF);
        hmm.setNullFlush(null_flush);

        if (filenames.size()==1) {
            hmm.tagger(System.in, System.out, mode_first);
        } else {
            InputStream finput = fopen(filenames.get(1));
            if (filenames.size()==2) {
                hmm.tagger(finput, System.out, mode_first);
            } else {
                OutputStream foutput = foutopen(filenames.get(2));
                hmm.tagger(finput, foutput, mode_first);
                foutput.close();
            }
            finput.close();
        }

    }

    static void tagger () throws IOException {
        tagger(false);
    }

    public static InputStream fopen(String filename) throws FileNotFoundException {
        String encoding = "UTF-8";
        if (System.getProperties().containsKey("file.encoding")) {
            encoding = System.getProperty("file.encoding");
        }
        return new BufferedInputStream(new FileInputStream(filename));
    }

    public static OutputStream foutopen(String filename) throws FileNotFoundException {
        String encoding = "UTF-8";
        if (System.getProperties().containsKey("file.encoding")) {
            encoding = System.getProperty("file.encoding");
        }
        return new BufferedOutputStream(new FileOutputStream(filename));
    }
}
