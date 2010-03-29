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

    boolean showSF;
    boolean null_flush;

    private int UNKNOWN_MODE=0;
    private int TRAIN_MODE=1;
    private int TAGGER_MODE=2;
    private int RETRAIN_MODE=3;
    private int TAGGER_SUPERVISED_MODE=4;
    private int TRAIN_SUPERVISED_MODE=5;
    private int RETRAIN_SUPERVISED_MODE=6;
    private int TAGGER_EVAL_MODE=7;
    private int TAGGER_FIRST_MODE=8;

    boolean generate_marks;
    boolean debug;

    Tagger () {
        debug = false;
        showSF = false;
        null_flush = false;
    }

    void setShowSF (boolean val) {
        showSF = val;
    }

    boolean getShowSF () {
        return showSF;
    }

    int getMode (String[] argv) {
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

                return mode;
            } catch (Exception e) {
                // FIXME
            }
        }
        return mode;
    }

    void help() {
        // FIXME
    }
}
