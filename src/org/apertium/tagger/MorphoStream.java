/*
 * Copyright 2010 Jimmy O'Regan
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

    MorphoStream () {
        foundEOF = false;
        alphabet = new Alphabet();
        ca_any_char = alphabet.cast(PatternList.ANY_CHAR);
        ca_any_tag = alphabet.cast(PatternList.ANY_TAG);

        null_flush = false;
        end_of_file = false;
    }

    MorphoStream (InputStream ftxt, boolean d, TaggerData t) {
        this();
        this.input = ftxt;
        this.td = t;
        this.me = this.td.getPatternList().newMatchExe();
        
        ConstantManager constants = td.getConstants();
        ca_kignorar = constants.getConstant("kIGNORAR");
        ca_kbarra = constants.getConstant("kBARRA");
        ca_kdollar = constants.getConstant("kDOLLAR");
        ca_kbegin = constants.getConstant("kBEGIN");
        ca_kmot = constants.getConstant("kMOT");
        ca_kmas = constants.getConstant("kMAS");
        ca_kunknown = constants.getConstant("kUNKNOWN");

        Map<String, Integer> tag_index = td.getTagIndex();
        ca_tag_keof = tag_index.get("TAG_kEOF");
        ca_tag_kundef = tag_index.get("TAG_kUNDEF");
    }

    TaggerWord get_next_word () throws IOException {
        if (vwords.size() != 0) {
            TaggerWord word = vwords.get(0);
            vwords.remove(0);

            if (word.isAmbiguous()) {
                ArrayList<String> ref = td.getDiscardRules();
                for (int i=0; i < ref.size(); i++) {
                    word.discardOnAmbiguity(ref.get(i));
                }
            }
            return word;
        }

        // FIXME!
        //if(feof(input))
        //{
        //    return NULL;
        //}

        int ivwords = 0;
        vwords.add(new TaggerWord());

        while (true) {
            int symbol = input.read();
            if (symbol == -1 || (null_flush && symbol == '\0')) {
                this.end_of_file = true;
                // vwords[ivwords]->add_tag(ca_tag_keof, "", td->getPreferRules());
                TaggerWord tmp = vwords.get(ivwords);
                tmp.add_tag(ca_tag_keof, "", td.getPreferRules());
                vwords.set(ivwords, tmp);
                return get_next_word ();
            }
        }

    }


}
