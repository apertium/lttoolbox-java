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

import static org.apertium.lttoolbox.LTProc.fout;
import static org.apertium.lttoolbox.LTProc.openReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;

import org.apertium.lttoolbox.Getopt;
import org.apertium.lttoolbox.LTToolbox;
import org.apertium.lttoolbox.process.FSTProcessor;
import org.apertium.lttoolbox.process.State;
import org.apertium.transfer.Transfer;

/**
 * @author Stephen Tigner
 *
 */
public class ApertiumInterchunk {

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
    protected static InputStream openInput(String filename) {
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
    protected static OutputStream openOutput(String filename) {
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

        System.setProperty("file.encoding", "UTF-8");
        if (args.length == 0) {
            message();
        }

        Interchunk i = new Interchunk();
        Getopt getopt = new Getopt("Interchunk", args, "zh");

        while (true) {
            int c = getopt.getopt();
            if (c == -1) {
                break;
            }
            switch (c) {
                case 'z':
                    i.setNullFlush(true);
                    break;

                case 'h':
                default:
                    message();
                    break;
            }
        }

        Reader input = null;
        Writer output = null;

        String t2xFile = null;
        String preprocFile = null; //formerly f1, f2, these are more descriptive names

        int optIndex = getopt.getOptind();
        switch(args.length - optIndex ) { //number of non-option args
            /* This avoids code duplication by allowing cases to "fall through."
             * The higher cases just add extra lines to the top of the lower cases,
             * so by allowing the code to fall through to the lower cases (instead of
             * breaking), we don't need to duplicate the same code several times.
             */
            case 4:
                output = new OutputStreamWriter(openOutput(args[optIndex + 3]));
            case 3:
                input = new InputStreamReader(openInput(args[optIndex + 2]));
            case 2:
                preprocFile = args[optIndex + 1];
                t2xFile = args[optIndex];
                break;
            default:
                message();
                break;
        }
        
        try {
            i.read(t2xFile, preprocFile);
            i.interchunk(input, output);
            output.flush(); //Have to flush or there won't be any output.
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
