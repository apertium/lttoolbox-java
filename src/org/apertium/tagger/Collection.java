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
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apertium.lttoolbox.Compression;

/**
 * 
 * @author jimregan
 */
public class Collection {
    Map<Set<Integer>, Integer> index;
    ArrayList<Set<Integer>> element;

    Collection () {
        index = new HashMap<Set<Integer>, Integer>();
        element = new ArrayList<Set<Integer>>();
    }

    int size () {
        return element.size();
    }

    boolean has_not (Set<Integer> t) {
        return !index.containsKey(t);
    }

    Set<Integer> get (int n) {
        return element.get(n);
    }

    int get (Set<Integer> t) {
        if (has_not(t)) {
            index.put(t, index.size() - 1);
            element.add(t);
        }
        return index.get(t);
    }

    int add (Set<Integer> t) {
        index.put(t, index.size() - 1);
        element.add(t);
        return index.get(t);
    }

    void read (InputStream input) throws IOException {
        int size = Compression.multibyte_read(input);

        for(; size != 0; size--) {
            Set<Integer> myset = new HashSet<Integer>();
            int set_size = Compression.multibyte_read(input);
            for(; set_size != 0; set_size--) {
                myset.add(Compression.multibyte_read(input));
            }
            add (myset);
        }
    }

}
