/*
 * Copyright (C) 2004-2006 Felipe Sánchez-Martínez
 * Copyright (C) 2006 Universitat d'Alacant
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

/**
 *
 * @author jimregan
 */
public class Prob2Txt {
    TaggerData td;
    Integer eos;

    private static String program = "prob2txt";

    Prob2Txt () {
        td = new TaggerData();
    }

    void help () {
        System.err.println("HMM parameters are writen in text format");
        System.err.println();
        System.err.println("Usage: ");
        System.err.println(program + " --file file.prob [--human]");
        System.err.println("Arguments: ");
        System.err.println("-f: To specify the file with the HMM parameter to process");
    }

    void print_A(boolean human_readable) {
        System.out.println("TRANSITION MATRIX (A)");
        System.out.println("------------------------------");
        for (int i=0; i<td.getN();i++)
            for (int j=0; j<td.getN();j++) {
                if (human_readable) {
                    System.out.println("A["+td.getArrayTags().get(i)+"]["+td.getArrayTags().get(j)+"] = ");
                } else {
                    
                }
            }
    }
}
