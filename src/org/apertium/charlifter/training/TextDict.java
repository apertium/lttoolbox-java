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

package org.apertium.charlifter.training;
import org.apertium.charlifter.Data;
import org.apertium.charlifter.Process;

/**
 *
 * @author jimregan
 */
public class TextDict {
    Data read_clean_dict (String file, Data data) {
        String[] words;
        try {
            words = Wordlist.read(file);
            for (String word : words) {
                String asc = Asciify.toascii(word.toLowerCase());
                if (Process.isOkina() && asc.contains("'")) {
                    String stripped = asc;
                    stripped.replaceAll("'", "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
