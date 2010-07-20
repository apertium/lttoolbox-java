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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Stephen Tigner
 *
 */
public class InterchunkMain {
    
    private static void message() {
        PrintStream stderr = System.err; //Allows ouput lines to be shorter.
        stderr.println("USAGE: Interchunk  [-z] t2x preproc [input [output]]");
        stderr.println("  t2x        t2x rules file");
        stderr.println("  preproc    result of preprocess trules file");
        stderr.println("  input      input file, standard input by default");
        stderr.println("  output     output file, standard output by default");
        stderr.println("OPTIONS");
        stderr.println("  -z         flush buffer on '\0'");
        
        System.exit(1); //EXIT_FAILURE C++ macro = 1
    }
    
    /* We don't use or need the testfile() function that's here in the C++ version.
     * It's just used in main() to check for the existence of the t2x and preproc files.
     */

    /**
     * Takes a filename string and attempts to open an input stream to the file given 
     * in the filename. If the file is not found (or otherwise could not be opened), 
     * then prints an appropriate message and then exits.
     * @param filename - A string with the filename to open
     * @return An InputStream for reading from the file specified.
     */
    protected InputStream openInput(String filename) {
        InputStream in = null;
        try {
            in = new FileInputStream(filename);
        } catch(FileNotFoundException e) {
            System.err.println("Interchunk -- Input file not found or could not be opened: " + filename);
            System.err.println("Cannot continue.");
            System.exit(1);
        } 
        return in;
    }
    
    /**
     * Takes a filename string and attempts to open an output stream to the file given 
     * in the filename. If the file is not found (or otherwise could not be opened), 
     * then prints an appropriate message and then exits.
     * @param filename - A string with the filename to open
     * @return An OutputStream for reading from the file specified.
     */
    protected OutputStream openOutput(String filename) {
        OutputStream out = null;
        try {
            out = new FileOutputStream(filename);
        } catch(FileNotFoundException e) {
            System.err.println("Interchunk -- Output file not found or could not be opened: " + filename);
            System.err.println("Cannot continue.");
            System.exit(1);
        } 
        return out;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
