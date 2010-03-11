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
import org.apertium.lttoolbox.Alphabet;
import org.apertium.transfer.MatchExe;
import org.apertium.transfer.MatchState;

/**
 *
 * @author jimregan
 */
public class MorphoStream {
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

    private MatchExe me;
    private TaggerData td;
    private Alphabet alphabet;
    private MatchState ms;

}
