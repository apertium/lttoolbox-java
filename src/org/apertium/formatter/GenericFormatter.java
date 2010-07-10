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

package org.apertium.formatter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apertium.lttoolbox.Getopt;

/**
 * @author Stephen
 * Generic formatter, base class for other formatters.
 */
public abstract class GenericFormatter {
    protected enum FormatterMode {
        DEFORMAT, REFORMAT, NOMODE
    }
    
    protected String _inputFile = null;
    protected String _outputFile = null;
    protected String _commandLabel = null;

    protected static boolean _cppCompat = false;
    //Low-level dev debugging
    protected boolean DEBUG = false;
    
    /**
     * Gets the mode (either deformat or reformat) selected on the command line.
     * Also parses the input and output file parameters.
     * If the command-line is invalid (missing or extra command-line options)
     * then help text is printed out, and null is returned.
     * @param argv
     * @param commandLabel
     * @return A FormatterMode object representing the mode selected, or null if
     * there was no mode selected or there otherwise was a bad command line.
     */
    protected FormatterMode getModeAndFiles(String[] argv, String commandLabel) {
        Getopt getOpt = new Getopt(commandLabel,argv, "dri:o:");
        FormatterMode mode = FormatterMode.NOMODE;
        
        int opt = getOpt.getopt();
        boolean helpNeeded = false;
        
        do {
            switch(opt) {
                case 'd':
                    if(mode == FormatterMode.NOMODE) {
                        mode = FormatterMode.DEFORMAT;
                    } else {
                        helpNeeded = true;
                    }
                    break;
                case 'r':
                    if(mode == FormatterMode.NOMODE) {
                        mode = FormatterMode.REFORMAT;
                    } else {
                        helpNeeded = true;
                    }
                    break;
                case 'i':
                    _inputFile = getOpt.getOptarg();
                    break;
                case 'o':
                    _outputFile = getOpt.getOptarg();
                    break;
                default:
                    helpNeeded = true;
            }
        } while((opt = getOpt.getopt()) != -1);
        if(mode == FormatterMode.NOMODE) { helpNeeded = true; }
        if(helpNeeded) { 
            help(commandLabel);
            //Reset mode to NOMODE since we have an invalid command line
            mode = FormatterMode.NOMODE;
        }
        return mode;
    }
    
    protected void help(String commandLabel) {
        System.out.println(commandLabel + ": deformatter and reformatter");
        System.out.println("USAGE: " + commandLabel + " -d [-i INPUT_FILE] [-o OUTPUT_FILE]");
        System.out.println("       " + commandLabel + " -r [-i INPUT_FILE] [-o OUTPUT_FILE]");
        System.out.println("OPTIONS:");
        System.out.println(" -d: Deformat, escape special characters and whitespace.");
        System.out.println(" -r: Reformat, un-escape special characters and whitespace.");
        System.out.println(" -i: Input file, uses the file INPUT_FILE as input.");
        System.out.println(" -o: Output file, uses the file OUTPUT_FILE as output");
        System.out.println("If the input and output files are not specified, then " +
                           "stdin and stdout are used, respectively.");
    }
    
    protected InputStream openInFile(String filename, String commandLabel) {
        InputStream in = null;
        try {
            in = new FileInputStream(filename);
        } catch(FileNotFoundException e) {
            System.err.println(commandLabel + " -- Input file not found or could not be opened: " + filename);
            System.err.println("Cannot continue.");
            System.exit(1);
        } 
        return in;
    }
    
    protected OutputStream openOutFile(String filename, String commandLabel) {
        OutputStream out = null;
        try {
            out = new FileOutputStream(filename);
        } catch(FileNotFoundException e) {
            System.err.println(commandLabel + " -- Output file not found or could not be opened: " + filename);
            System.err.println("Cannot continue.");
            System.exit(1);
        } 
        return out;
    }
    
    /**
     * De-formats the incoming text in a format-specific manner.
     * In other words, it converts the text into Apertium stream format by escaping
     * special characters, white space, and other data that should not be translated.
     * (Such as tags in the case of HTML.)
     * @param in - An InputStream to pull the text to deformat from.
     * @param out - An OutputStream to output the deformatted text to.
     */
    protected abstract void deFormat(InputStream in, OutputStream out);

    /**
     * Re-formats the incoming text in a format-specific manner.
     * In other words, it converts the text from Apertium stream format by de-escaping
     * special characters, and removing the superblanks around whitespace and other data
     * that was not to be translated. (Such as tags in the case of HTML.)
     * @param in - An InputStream to pull the text to deformat from.
     * @param out - An OutputStream to output the deformatted text to.
     */
    protected abstract void reFormat(InputStream in, OutputStream out);

    /**
     * Reads the command-line arguments, sets up the mode and input/output streams, 
     * and calls the appropriate deFormat or reFormat function.
     * @param args
     */
    protected void doMain(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        FormatterMode mode = getModeAndFiles(args, _commandLabel);

        if(DEBUG) {
            System.err.println("mode: " + mode);
        }
        
        if(_inputFile != null) {
            in =  openInFile(_inputFile, _commandLabel);
        } else {
            in = System.in;
        }
        if(_outputFile != null) {
            out = openOutFile(_outputFile, _commandLabel);
        } else {
            out = System.out;
        }
        
        switch(mode) {
            case DEFORMAT:
                deFormat(in, out);
                break;
            case REFORMAT:
                reFormat(in, out);
                break;
            case NOMODE:
                //do nothing, help text should have been printed out already.
                break;
            default:
                //We should never get here, if we do, something is broken.
                System.err.println(_commandLabel + ": invalid mode");
                System.err.println("Cannot continue.");
                System.exit(1);
        }
    }
    
    GenericFormatter(String commandLabel) {
        _commandLabel = commandLabel;
    }
    
    GenericFormatter() {
        _commandLabel = "ThisNeedsToBeSet";
    }
}
