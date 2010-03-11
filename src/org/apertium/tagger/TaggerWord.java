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
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author jimregan
 */
public class TaggerWord {
    private String superficial_form;
    private Set<Integer> tags;
    private Map<Integer, String> lexical_forms;
    private String ignored_string;
    private boolean plus_cut;
    private boolean previous_plus_cut;
    private boolean show_sf;
    //  static map<wstring, ApertiumRE, Ltstr> patterns;
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

    void set_show_sf (boolean sf) {
        show_sf = sf;
    }

    boolean get_show_sf () {
        return show_sf;
    }
}
