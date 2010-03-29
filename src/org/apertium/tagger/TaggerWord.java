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
import java.util.Set;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import org.apertium.transfer.ApertiumRE;
import java.io.OutputStream;
import java.io.IOException;

/**
 *
 * @author jimregan
 */
public class TaggerWord {
    private String superficial_form;
    private Set<Integer> tags;
    private Map<Integer, String> lexical_forms;
    private String ignored_string;
    /**
     * Flag to distinguish the way in which the word was ended.
     * If it was done by '$' its value should be false
     * If it was done by '+' its value should be true
     */
    private boolean plus_cut;
    /**
     * Flag to distinguish the way in which the
     * previous word was ended. It has the same
     * plus_cut meaning
     */
    private boolean previous_plus_cut;
    /**
     * Show the superficial form in the output
     */
    private boolean show_sf;
    //  static map<wstring, ApertiumRE, Ltstr> patterns;
    private Map<String, ApertiumRE> patterns;
    public boolean generate_marks = false;
    public ArrayList<String> array_tags;
    public boolean show_ignored_string = true;

    public TaggerWord (boolean prev_plus_cut) {
        ignored_string = "";
        plus_cut = false;
        previous_plus_cut = prev_plus_cut;
    }

    public TaggerWord () {
        this(false);
    }

    public void set_show_sf (boolean sf) {
        this.show_sf = sf;
    }

    public boolean get_show_sf () {
        return this.show_sf;
    }

    public void set_superficial_form (String sf) {
        this.superficial_form = sf;
    }

    public String get_superficial_form () {
        return this.superficial_form;
    }

    public boolean match (String s, String pattern) {
        //Map<String, ApertiumRE>.Iterator it = patterns.find(pattern);
        
        return false;
    }

    public void add_tag (int t, String lf, ArrayList<String> prefer_rules) {
        if (!tags.contains(t)) {
            tags.add(t);
            lexical_forms.put(t, lf);
        } else {
            for (int i=0; i < prefer_rules.size(); i++) {
                if (match(lf, prefer_rules.get(i))) {
                    lexical_forms.put(t, lf);
                    break;
                }
            }
        }
    }

    public Set<Integer> get_tags () {
        return tags;
    }

    public boolean isAmbiguous () {
        return tags.size() > 1;
    }

    public String get_string_tags () {
        String st="{";

        // FIXME - is this doing the same thing? I need more coffee...
        for (int i=0;i<tags.size();i++) {
            if (i != 0) {
                st +=",";
            }
            st += array_tags.get(i);
        }
        st += "}";

        return st;
    }

    public String get_lexical_form (int t, int TAG_kEOF) {
        String ret = "";

        if (this.show_ignored_string) {
            ret += ignored_string;
        }

        if (t==TAG_kEOF) {
            return ret;
        }

        if (!this.previous_plus_cut) {
            if (generate_marks && isAmbiguous()) {
                ret += "^=";
            } else {
                ret += "^";
            }

            if (get_show_sf()) {
                ret += superficial_form;
                ret += '/';
            }
        }

        if (lexical_forms.size()==0) {
            ret += '*';
            ret += superficial_form;
        } else if (lexical_forms.get(0).startsWith("*")) {
            ret += '*';
            ret += superficial_form;
        } else if (lexical_forms.size()>1){
            ret += lexical_forms.get(t);
        } else {
            ret += lexical_forms.get(t);
        }

        if (!ret.equals(ignored_string)) {
            if (this.plus_cut) {
                ret += '+';
            } else {
                ret += '$';
            }
        }
        return ret;
    }

    public String get_all_chosen_tag_first () {
        String ret = "";
        if (show_ignored_string)
            ret += ignored_string;

        //if(t==TAG_kEOF)
        //    return ret;

        if (!previous_plus_cut) {
            if (generate_marks && isAmbiguous()) {
                ret += "^=";
            } else {
                ret += "^";
            }

            ret += superficial_form;

            if (lexical_forms.size()==0) { // This is an UNKNOWN WORD
                ret += "/*";
                ret += superficial_form;
            } else {
                ret += "/";
                //ret += lexical_forms.get(t);
            }
        }
        return ret;
    }

    public void add_ignored_string (String s) {
        ignored_string += s;
    }

    public void set_plus_cut(boolean c) {
        plus_cut=c;
    }

    public boolean get_plus_cut() {
        return plus_cut;
    }

    public void setArrayTags(ArrayList<String> at) {
        array_tags = at;
    }

    public void print () {
        System.out.print("[#" + superficial_form + "# ");
        Iterator<Integer> it = tags.iterator();
        while (it.hasNext()) {
            int f = it.next();
            System.out.print("(" + f + " " + lexical_forms.get(f) + ") ");
        }
        System.out.print("\b]\n");
    }

    public void outputOriginal (OutputStream o) throws IOException {
        String s=this.superficial_form;
        //TODO
        //Iterator<Integer, String> it = lexical_forms.entrySet().iterator();

    }

    public void discardOnAmbiguity (String tags) {
        if (isAmbiguous()) {
            // TODO
        }
    }
}
