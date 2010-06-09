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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.apertium.lttoolbox.Alphabet;
import org.apertium.transfer.MatchExe;
import org.apertium.transfer.MatchState;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/**
 *
 * @author jimregan
 */
/** Class MorphoStream.
 *  This class processes the FST, and
 *  builds the TaggerWord objects managed by the tagger
 */
public class MorphoStream {

    private boolean foundEOF;
    private boolean debug = false;
    private String last_string_tag;
    private int ca_any_char;
    private int ca_any_tag;
    private int ca_kignorar;
    private int ca_kbarra;
    private int ca_kdollar;
    private int ca_kbegin;
    private int ca_kmot;
    private int ca_kmas;
    private int ca_kunknown;
    private int ca_tag_keof;
    private int ca_tag_kundef;
    private ArrayList<TaggerWord> vwords;
    private InputStream input;
    private MatchExe me;
    private TaggerData td;
    private Alphabet alphabet;
    private MatchState ms;
    private boolean end_of_file;
    private boolean null_flush;
    private Map<String, Integer> tag_index;
    private ConstantManager constants;

//    MorphoStream() {
//    }
    /**
     * Constructor
     * @param ftxt the input stream.
     */
    MorphoStream(InputStream ftxt, boolean d, TaggerData t) {
        // this();
        foundEOF = false;
        alphabet = new Alphabet();
        ca_any_char = alphabet.cast(PatternList.ANY_CHAR);
        ca_any_tag = alphabet.cast(PatternList.ANY_TAG);

        null_flush = false;
        this.input = ftxt;
        this.td = t;
        this.end_of_file = false;
//        this.me = this.td.getPatternList().newMatchExe();

        this.constants = td.getConstants();
        this.ca_kignorar = constants.getConstant("kIGNORAR");
        this.ca_kbarra = constants.getConstant("kBARRA");
        this.ca_kdollar = constants.getConstant("kDOLLAR");
        this.ca_kbegin = constants.getConstant("kBEGIN");
        this.ca_kmot = constants.getConstant("kMOT");
        this.ca_kmas = constants.getConstant("kMAS");
        this.ca_kunknown = constants.getConstant("kUNKNOWN");

        this.tag_index = td.getTagIndex();
        this.ca_tag_keof = tag_index.get("TAG_kEOF");
        this.ca_tag_kundef = tag_index.get("TAG_kUNDEF");
        this.vwords = new ArrayList<TaggerWord>();
    }

    /**
     * Get next word in the input stream
     * @return The next word in the input stream
     */
    TaggerWord get_next_word() throws IOException {

        if (vwords.size() != 0) {
            TaggerWord word = vwords.get(0);
            vwords.remove(0);

            if (word.isAmbiguous()) {
                List<String> ref = td.getDiscardRules();
                for (int i = 0; i < ref.size(); i++) {
                    word.discardOnAmbiguity(ref.get(i));
                }
            }
            return word;
        }

        int symbol = input.read();
        /* The mark() function takes an int argument that is the number of bytes 
         * that can be read before the mark is invalidated. Supplying an argument of 0 
         * is pretty much useless, in other words. ^^; That really should be 1, because 
         * we're only going to try and read one byte before calling reset().
         * 
         * However, that's a moot point though, because of a line in the documentation 
         * for reset(): "The method reset for class InputStream  does nothing except throw 
         * an IOException." In other words, expecting the reset() method to work on a 
         * generic InputStream object is not type-safe, and will likely fail. Even though 
         * there's a "markSupported()" method, the program logic at that point depends on 
         * being able to mark and reset the pointer like that.
         * 
         * Thus the while() loop below was slightly changed to remove the need to reset
         * the read pointer.
         */
        //input.mark(0);  // Mark the current possition of this input stream so we can go back to that possition
        // bcoz testing input.read()==-1 will advance the pointer/cursor! it will not read
        /*(if (end_of_file || input.read() == -1) {*/
        if(end_of_file || symbol == -1) {
            return null;
        }
        //input.reset();
        // no word in the buffer, so read from input
        int ivwords = 0;
        vwords.add(new TaggerWord());

        while (true) {

            //int symbol = input.read();
            if (symbol == -1 || (null_flush && symbol == '\0')) {
                this.end_of_file = true;
                vwords.get(ivwords).add_tag(ca_tag_keof, "", td.getPreferRules());
                // word read, use above code to return it
                return get_next_word();
            }
            if (symbol == (int) '^') {
                readRestOfWord(ivwords);
                // word read, use above code to return it
                return get_next_word();
            } else {
                String str = "";
                if (symbol == (int) '\\') {
                    symbol = input.read();
                    str += '\\';
                    str += (char) symbol;
                    symbol = (int) '\\';
                } else {
                    str += (char) symbol;

                }
                while (symbol != (int) '^') {
                    symbol = input.read();
                    if (symbol == -1 || (null_flush && symbol == '\0')) {
                        end_of_file = true;
                        vwords.get(ivwords).add_ignored_string(str);
                        vwords.get(ivwords).add_tag(ca_tag_keof, "", td.getPreferRules());
                        // word read, use above code to return it
                        return get_next_word();
                    } else if (symbol == (int) '\\') {
                    	str += '\\';
                    	symbol = input.read();
                        if (symbol == -1 || (null_flush && symbol == '\0')) {
                            end_of_file = true;
                            vwords.get(ivwords).add_ignored_string(str);
                            vwords.get(ivwords).add_tag(ca_tag_keof, "", td.getPreferRules());
                            // word read, use above code to return it
                            return get_next_word();
                        }
                        str += (char) symbol;
                        symbol = (int) '\\';
                    } else if (symbol == (int) '^') {
                    	if (str.length() > 0) {
                    		vwords.get(ivwords).add_ignored_string(str);
                    	}
                    	readRestOfWord(ivwords);
                    	return get_next_word();
                    } else {
                    	str += (char) symbol;
                    }
                }

            }
            /* Moved this down to here, to allow for read before initial run of loop.
             * Will effectively still be run in the same order as before, just won't be 
             * called at the beginning of the first iteration of the loop. 
             */
            symbol = input.read();
        }

    }

    void readRestOfWord(int ivwords) throws IOException {
        String str = "";
        while (true) {
            int symbol = input.read();
            if (symbol == -1 || (null_flush && symbol == (int) '\0')) {
                end_of_file = true;
                if (str.length() > 0) {
                    vwords.get(ivwords).add_ignored_string(str);

                    System.err.println("Warning (internal): kIGNORE was returned while reading a word");
                    System.err.println("Word being read: " + vwords.get(ivwords).get_superficial_form());
                    System.err.println("Debug: " + str);
                }
                vwords.get(ivwords).add_tag(ca_tag_keof, "", td.getPreferRules());
                return;
            } else if (symbol == (int) '\\') {
                symbol = input.read();
                str += '\\';
                str += (char) symbol;
            } else if (symbol == (int) '/') {
                vwords.get(ivwords).set_superficial_form(str);
                str = "";
                break;
            } else if (symbol == (int) '$') {
                vwords.get(ivwords).set_superficial_form(str);
                vwords.get(ivwords).add_ignored_string("$");
                break;
            } else {
                str += (char) symbol;
            }
        }

        while (true) {
            int symbol = input.read();
            if (symbol == -1 || (null_flush && symbol == '\0')) {
                end_of_file = true;
                if (str.length() > 0) {
                    vwords.get(ivwords).add_ignored_string(str);
                    System.err.println("Warning (internal): kIGNORE was returned while reading a word");
                    System.err.println("Word being read: " + vwords.get(ivwords).get_superficial_form());
                    System.err.println("Debug: " + str);
                }
                vwords.get(ivwords).add_tag(ca_tag_keof, "", td.getPreferRules());
                return;
            } else if (symbol == (int) '\\') {
                symbol = input.read();
                str += '\\';
                str += (char) symbol;
                symbol = '\\';
            } else if (symbol == (int) '/') {
                lrlmClassify(str, ivwords);
                str = "";
                ivwords = 0;
                continue;
            } else if (symbol == (int) '$') {
                if (str.charAt(0) != '*') {
                    lrlmClassify(str, ivwords);
                }
                return;
            } else {
                str += (char) symbol;
            }

        }
    }

    void lrlmClassify(String str, int ivwords) {
        int floor = 0;
        int last_type = -1;
        int last_pos = 0;
        TaggerWord tw;

        this.ms = new MatchState(this.td.getPatternList().me);
        ms.init(this.td.getPatternList().me.getInitial());
        for (int i = 0, limit = str.length(); i != limit; i++) {
            if (str.charAt(i) != '<') {
                if (str.charAt(i) == '+') {
                    //int val = ms.classifyFinals(me.getFinals());
                    int val = ms.classifyFinals();
                    if (val != -1) {
                        last_pos = i - 1;
                        last_type = val;
                    }
                }
                ms.step(str.toLowerCase().charAt(i), ca_any_char);
            } else {
                String tag = "";
                for (int j = i + 1; j != limit; j++) {
                    if (str.charAt(j) == '\\') {
                        j++;
                    } else if (str.charAt(j) == '>') {
                        tag = str.substring(i, j);
                        i = j;
                        break;
                    }
                }

                // Check
                //int symbol = alphabet(tag);
                /* The C++ version has the () operator overloaded for Alphabet, when
                 * passing in a single string argument. Java version doesn't.
                 */
                int symbol = alphabet.cast(tag);
                if (symbol != 0) {
                    ms.step(symbol, ca_any_tag);
                } else {
                    ms.step(ca_any_tag);
                }
            }
            if (ms.size() == 0) {
                if (last_pos != floor) {
                    vwords.get(ivwords).add_tag(last_type,
                            str.substring(floor, last_pos),
                            td.getPreferRules());
                    if (str.charAt(last_pos + 1) == '+' && last_pos + 1 < limit) {
                        floor = last_pos + 1;
                        last_pos = floor;
                        vwords.get(ivwords).set_plus_cut(true);
                        if (vwords.size() <= (ivwords + 1)) {
                            vwords.add(new TaggerWord(true));
                        }
                        ivwords++;
                        ms.init(me.getInitial());
                    } else {
                        if (debug) {
                            System.err.println("Warning: There is no coarse tag for the fine tag '" + str.substring(floor) + "'");
                            System.err.println("         This is because of an incomplete tagset definition or a dictionary error");
                        }
                        //TaggerWord tw = new TaggerWord();
                        tw = vwords.get(ivwords);
                        tw.add_tag(ca_tag_kundef, str.substring(floor), td.getPreferRules());
                        vwords.set(ivwords, tw);
                        return;
                    }
                }
            } else if (i == (limit - 1)) {
            	if (ms.classifyFinals() == -1) {
            		if (last_pos != floor) {
            			vwords.get(ivwords).add_tag(last_type, 
            					str.substring(floor, last_pos), td.getPreferRules());
            			if(str.charAt(last_pos + 1) == '+' && last_pos + 1 < limit) {
            				floor = last_pos + 1;
            				last_pos = floor;
            				vwords.get(ivwords).set_plus_cut(true);
            				if(vwords.size() <= (ivwords +1)) {
            					vwords.add(new TaggerWord(true));
            				}
            				ivwords++;
            				ms.init(me.getInitial());
            			}
            			i = floor++;
            		} else {
            			if(debug) {
            				System.err.println("Warning: There is no coarse tag for the fine tag '" + str.substring(floor) + "'");
            				System.err.println("         This is because of an incomplete tageset definition or a dictionary error");
            			}
            			vwords.get(ivwords).add_tag(ca_tag_kundef, 
            					str.substring(floor), td.getPreferRules());
            			return;
            		}
            	}
            }
        }

        int val = ms.classifyFinals();
        if (val == -1) {
            val = ca_tag_kundef;
            if (debug) {
                System.err.println("Warning: There is no coarse tag for the fine tag '" + str.substring(floor) + "'");
                System.err.println("         This is because of an incomplete tagset definition or a dictionary error");
            }
            //TaggerWord tw = new TaggerWord();
            tw = vwords.get(ivwords);
            tw.add_tag(val, str.substring(floor), td.getPreferRules());
            vwords.set(ivwords, tw);
        }

    }

    /**
     * Set up the flag to detect '\0' characters
     * @param nf the null_flush value
     */
    void setNullFlush(boolean nf) {
        null_flush = nf;
    }

    /**
     * Return true if the last reading is end of file of '\0' when null_flush
     * is true
     * @returns the value of end_of_file
     */
    boolean getEndOfFile() {
        return end_of_file;
    }

    /**
     * Sets a new value for the end_of_file_flag
     * @param eof the new value for end_of_file
     */
    void setEndOfFile(boolean eof) {
        end_of_file = eof;
    }
}
