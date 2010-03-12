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
import java.io.InputStream;
import java.io.IOException;
import org.apertium.lttoolbox.Compression;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author jimregan
 */
public class HMM {
    private double ZERO = 1e-10;
    private TaggerData td;
    private int eos;
    private boolean debug;
    private boolean show_sf;
    private boolean null_flush;

    void set_eos(int t) {
        eos = t;
    }

    void set_debug (boolean d) {
        debug = d;
    }

    void set_show_sf (boolean sf) {
        show_sf = sf;
    }

    void read_ambiguity_classes (InputStream in) throws IOException {
        boolean eof = false;
        while (!eof) {
            int ntags = Compression.multibyte_read(in);
            if (ntags == -1) {
                eof = true;
                break;
            }
            
            Set<Integer> ambiguity_class = new HashSet<Integer>();

            for (; ntags != 0; ntags--) {
                ambiguity_class.add(Compression.multibyte_read(in));
            }

            if (ambiguity_class.size() != 0) {
                td.getOutput().add(ambiguity_class);
            }
        }
        td.setProbabilities(td.getTagIndex().size(), td.getOutput().size());
    }
}
