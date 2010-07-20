/*
 * Copyright (C) 2010 Stephen Tigner
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

package org.apertium.interchunk;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.apertium.lttoolbox.Alphabet;
import org.apertium.transfer.ApertiumRE;
import org.apertium.transfer.MatchExe;
import org.apertium.transfer.MatchState;

/**
 * @author Stephen Tigner
 *
 */
public class Interchunk {

    //Private members and methods
    private Alphabet alphabet;
    private MatchExe me; //Pointer in C++ version
    private MatchState ms;
    private Map<String, ApertiumRE> attr_items;
    private Map<String, String> variables;
    private Map<String, Integer> macros;
    private Map<String, Set<String>> lists;
    private Map<String, Set<String>> listslow;
    //vector<xmlNode *> macro_map; //Need to find out what to use as an equiv for xmlNode
    //vector<xmlNode *> rule_map;
    //xmlDoc *doc; //Same here with xmlDoc
    //xmlNode *root_element;
    private InterchunkWord[][] word; //InterchunkWord **
    private String[][] blank; //string **
    private int lword, lblank;
    //Buffer<TransferToken> input_buffer;
    ArrayList<String> tmpword; //vector<wstring *> tmpword;
    ArrayList<String> tmpblank; //vector<wstring *> tmpblank;

    private OutputStreamWriter output;
    private int any_char;
    private int any_tag;
    
    //xmlNode *lastrule;
    private int nwords;
    
    //map<xmlNode *, TransferInstr> evalStringCache;
    private boolean inword;
    private boolean null_flush;
    private boolean internal_null_flush;
}
