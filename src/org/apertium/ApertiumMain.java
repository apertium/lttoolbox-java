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

package org.apertium;

import static org.apertium.utils.IOUtils.getStdinReader;
import static org.apertium.utils.IOUtils.getStdoutWriter;
import static org.apertium.utils.IOUtils.openInFileReader;
import static org.apertium.utils.IOUtils.openOutFileWriter;
import static org.apertium.utils.IOUtils.listFilesInDir;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.apertium.formatter.FormatterRegistry;
import org.apertium.lttoolbox.Getopt;
import org.apertium.modes.Dispatcher;
import org.apertium.modes.Mode;
import org.apertium.modes.Program;
import org.apertium.utils.StringTable;
import org.apertium.utils.StringTable.Entries;

/**
 * @author Stephen Tigner
 *
 */
public class ApertiumMain {

    //Directory to look for modes files in
    private static String _dataDir = null;
    //What mode to use
    private static String _direction;
    //Display ambiguity, defaults to false
    private static boolean _dispAmb = false;
    //Display marks '*' for unknown words, defaults to true
    private static boolean _dispMarks = true;
    /* List translation directions in the given data dir.
     * Done as a flag because we need to make sure the datadir
     * has been parsed from the command line before we try and read
     * the files in it.
     */
    private static boolean _listModes = false;

    private static Program _deformatter;
    private static Program _reformatter;
    
    private static Reader _extInput = null;
    private static Writer _extOutput = null;
    
    private static void _displayHelpAndExit() {
        PrintStream p = System.err;
        /* XXX Made datadir non-optional for now to solve the issue of not really
         * having a way to configure a "default dir" for the Java runtime, at the moment.
         */
        p.println("USAGE: Apertium -d datadir [-f format] [-u] <direction> [in [out]]");
        p.println(" -d datadir     directory of linguistic data");
        p.println(" -f format      input format, only txt available at this time,");
        p.println("                and is the default format.");
        /* Okay, I have the code to parse these options, but I haven't figured out what
         * I'm supposed to do with them yet.
         * In other words, I don't know where to pass them to, or how, at the moment.
        p.println(" -a             display ambiguity");
        p.println(" -u             don't display marks '*' for unknown words.");
        */
        /* Does the java code support translation memories right now?
         * It doesn't that I know of, at least... (could be wrong, though.)
        p.println(" -m memory.tmx  use a translation memory to recycle translations");
        p.println(" -o direction   translation direction using the translation memory,");
        p.println("                by default 'direction' is used instead");
        */
        p.println(" -l             lists the available translation directions and exits");
        p.println(" direction      typically, LANG1-LANG2, but see modes.xml in language");
        p.println("                data");
        p.println(" in             input file (stdin by default)");
        p.println(" out            output file (stdout by default)");
        
        System.exit(0);
    }
    
    private static void _setFormatter(String formatterName) {
        String deFormatProgName = "apertium-des" + formatterName;
        String reFormatProgName = "apertium-re" + formatterName;
        
        //Adding -c switch to enable C++ compat mode by default
        _deformatter = new Program(deFormatProgName + " -c");
        _reformatter = new Program(reFormatProgName + " -c");
    }

    private static void _parseCommandLine(String[] args) {
        Getopt getopt = new Getopt("Apertium", args, "d:f:ual");

        while (true) {
            int c = getopt.getopt();
            if (c == -1) {
                break;
            }
            switch (c) {
                case 'd':
                    _dataDir = getopt.getOptarg();
                    break;
                case 'u':
                    _dispMarks = false;
                    break;
                case 'a':
                    _dispAmb = true;
                    break;
                case 'l':
                    _listModes = true;
                case 'f':
                    String formatterName = getopt.getOptarg();
                    if(FormatterRegistry.isRegistered(formatterName)) {
                        _setFormatter(formatterName);
                        break;
                    } 
                    /* If not registered, will fall through to bottom of switch and
                     * call displayHelpAndExit()
                     */
                case 'h':
                default:
                    _displayHelpAndExit();
                    break;
            }
        }
        
        if(_dataDir == null) { _displayHelpAndExit(); }
        
        if(_deformatter == null || _reformatter == null) {
            //Formatters weren't set on command-line, set default of txt
            _setFormatter("txt");
        }
        
        //Setup external input and output
        int optIndex = getopt.getOptind();
        try {
            switch(args.length - optIndex ) { //number of non-option args
                /* This avoids code duplication by allowing cases to "fall through."
                 * The higher cases just add extra lines to the top of the lower cases,
                 * so by allowing the code to fall through to the lower cases (instead of
                 * breaking), we don't need to duplicate the same code several times.
                 */
                case 3:
                    _extOutput = openOutFileWriter(args[optIndex + 2]);
                case 2:
                    _extInput = openInFileReader(args[optIndex + 1]);
                case 1:
                    _direction = args[optIndex];
                default:
                    break;
            }
            if(_extInput == null) { _extInput = getStdinReader(); }
            if(_extOutput == null) { _extOutput = getStdoutWriter(); }
        } catch (FileNotFoundException e) {
            System.err.println("Apertium (Input/Output files) -- " + 
                    StringTable.getString(Entries.FILE_NOT_FOUND));
            e.printStackTrace();
            System.exit(1);
        } catch (UnsupportedEncodingException e) {
            System.err.println("Apertium (Input/Output files) -- " + 
                    StringTable.getString(Entries.UNSUPPORTED_ENCODING));
            e.printStackTrace();
            System.exit(1);
        }
        
    }

    private static void _dispatchPipeline(Mode mode) {
        StringReader input = null;
        StringWriter output = new StringWriter();
        
        Dispatcher.dispatch(_deformatter, _extInput, output);
        int pipelineLength = mode.getPipelineLength();
        try {
            for(int i = 0; i < pipelineLength; i++) {
                Program currProg = mode.getProgramByIndex(i);
                switch(currProg.getProgram()) {
                    case UNKNOWN:
                        /* Okay, this probably needs some explanation. When executing
                         * an external program, as the UNKNOWN program type does, we can't
                         * use Readers and Writers, we have to use byte streams instead.
                         * Using a StringBufferInputStream is not recommended and is,
                         * in fact, deprecated because of encoding issues.
                         * To hopefully avoid those issues, byte array streams are
                         * used instead. The input is converted to a byte array using
                         * String.getBytes() with "UTF-8" as the charset name.
                         */
                        byte[] inputBytes = output.toString().getBytes("UTF-8");
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        Dispatcher.dispatchUnknown(currProg, inputBytes, outputStream);
                        /* When finished with the external program, we need to convert
                         * it back to a UTF-8 string and put the result in the output
                         * writer for the next iteration of the loop.
                         */
                        output = new StringWriter();
                        output.write(outputStream.toString("UTF-8"));
                        break;
                    default:
                        input = new StringReader(output.toString());
                        output = new StringWriter();
                        Dispatcher.dispatch(currProg, input, output);
                        break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            System.err.println("Apertium (pipeline) -- " + 
                    StringTable.getString(Entries.UNSUPPORTED_ENCODING));
            e.printStackTrace();
            System.exit(1);
        }

        input = new StringReader(output.toString());
        Dispatcher.dispatch(_reformatter, input, _extOutput);
    }

    
    private static void _listModes() {
        String[] modeList = listFilesInDir(_dataDir, "mode");
        
        if(modeList == null) {
            System.out.println("No translation directions in the specified directory.");
            System.exit(0);
        } else {
            for(String mode : modeList) {
                System.out.println(mode.replaceAll("\\.mode", ""));
            }
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        //Ensure we are using UTF-8 encoding by default
        System.setProperty("file.encoding", "UTF-8");

        _parseCommandLine(args);
        
        if(_listModes) { _listModes(); }
        
        Mode mode = null;
        
        try {
            mode = new Mode(_dataDir + _direction + ".mode");
        } catch (IOException e) {
            System.err.println("Apertium (mode parsing) -- " + 
                    StringTable.getString(Entries.IO_EXCEPTION));
            e.printStackTrace();
            System.exit(1);
        }
        
        _dispatchPipeline(mode);

        try {
            _extOutput.flush(); //Just to make sure it gets flushed.
        } catch (IOException e) {
            System.err.println("Apertium (flushing output) -- " + 
                    StringTable.getString(Entries.IO_EXCEPTION));
            e.printStackTrace();
            System.exit(1);
        }
    }

}
