/*
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

package org.apertium.modes;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.CharBuffer;

import org.apertium.formatter.TextFormatter;
import org.apertium.interchunk.ApertiumInterchunk;
import org.apertium.interchunk.Interchunk;
import org.apertium.lttoolbox.LTProc;
import org.apertium.postchunk.ApertiumPostchunk;
import org.apertium.postchunk.Postchunk;
import org.apertium.pretransfer.PreTransfer;
import org.apertium.tagger.Tagger;
import org.apertium.transfer.ApertiumTransfer;
import org.apertium.utils.StringTable;
import org.apertium.utils.StringTable.Entries;

/**
 * @author Stephen Tigner
 *
 */
public class Dispatcher {
    
    private static boolean _dispAmb = false;
    private static boolean _dispMarks = true;
    
    private static final String splitPattern = "[ ]+";
    
    private static void doInterchunk(Program prog, Reader input, Writer output) {
        ApertiumInterchunk.CommandLineParams par = 
            new ApertiumInterchunk.CommandLineParams();
        /* Parse the command line. The passed-in CommandLineParams object
         * will be modified by this method.
         */
        String[] args = prog.getParameters().split(splitPattern);
        try {
            ApertiumInterchunk.parseCommandLine(args, par, "Interchunk", true);
        } catch (FileNotFoundException e) {
            /* This is here because the compiler requires it, but with pipelineMode
             * set to true, it won't ever be thrown.
             * If we get this, something is wrong. Report it and die.
             */
            System.err.println("Apertium (Dispatch, Interchunk) -- " + 
                    StringTable.getString(Entries.UNEXPECTED_FILE_NOT_FOUND));
            e.printStackTrace();
            System.exit(1);
        } catch (UnsupportedEncodingException e) {
            /* This is here because the compiler requires it, but with pipelineMode
             * set to true, it won't ever be thrown.
             * If we get this, something is wrong. Report it and die.
             */
            System.err.println("Apertium (Dispatch, Interchunk) -- " + 
                    StringTable.getString(Entries.UNEXPECTED_UNSUPPORTED_ENCODING));
            e.printStackTrace();
            System.exit(1);
        }
        /* Assume internal i/o, don't allow for specifying external temp
         * files for i/o.
         */
        par.input = input;
        par.output = output;

        try {
            ApertiumInterchunk.doMain(par, new Interchunk());
        } catch (Exception e) {
            System.err.println("Interchunk -- " +
                    StringTable.getString(Entries.GENERIC_EXCEPTION));
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void doPostchunk(Program prog, Reader input, Writer output) {
        /* Yes, there's duplicate code here with the method above, but
         * there's only a few lines of actual code here, and I ran into issues
         * trying to reduce the duplication further than this.
         */
        
        ApertiumPostchunk.CommandLineParams par = 
            new ApertiumPostchunk.CommandLineParams();
        /* Parse the command line. The passed-in CommandLineParams object
         * will be modified by this method.
         */
        String[] args = prog.getParameters().split(splitPattern);
        try {
            ApertiumPostchunk.parseCommandLine(args, par, "Interchunk", true);
        } catch (FileNotFoundException e) {
            /* This is here because the compiler requires it, but with pipelineMode
             * set to true, it won't ever be thrown.
             * If we get this, something is wrong. Report it and die.
             */
            System.err.println("Apertium (Dispatch, Postchunk) -- " + 
                    StringTable.getString(Entries.UNEXPECTED_FILE_NOT_FOUND));
            e.printStackTrace();
            System.exit(1);
        } catch (UnsupportedEncodingException e) {
            /* This is here because the compiler requires it, but with pipelineMode
             * set to true, it won't ever be thrown.
             * If we get this, something is wrong. Report it and die.
             */
            System.err.println("Apertium (Dispatch, Postchunk) -- " + 
                    StringTable.getString(Entries.UNEXPECTED_UNSUPPORTED_ENCODING));
            e.printStackTrace();
            System.exit(1);
        }
        /* Assume internal I/O, don't allow for specifying external temp
         * files for I/O.
         * External input and output files are used only at the beginning
         * and end of the chain, and are handled by the code that calls the
         * dispatcher.
         */
        par.input = input;
        par.output = output;

        try {
            ApertiumPostchunk.doMain(par, new Postchunk());
        } catch (Exception e) {
            System.err.println("Postchunk -- " +
                    StringTable.getString(Entries.GENERIC_EXCEPTION));
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void doPretransfer(Program prog, Reader input, Writer output) {
        PreTransfer.CommandLineParams params = new PreTransfer.CommandLineParams();
        String[] args = prog.getParameters().split(splitPattern);
        PreTransfer.parseArgs(args, params, true);

        try {
            /* Assume internal I/O, don't allow for specifying external temp
             * files for I/O.
             * External input and output files are used only at the beginning
             * and end of the chain, and are handled by the code that calls the
             * dispatcher.
             */
            PreTransfer.processStream(input, output, params.nullFlush);
        } catch (IOException e) {
            System.err.println("Pretransfer -- " +
                    StringTable.getString(Entries.IO_EXCEPTION));
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    private static void doTagger(Program prog, Reader input, Writer output) {
        String paramString = prog.getParameters();
        String replacement = (_dispAmb ? "-m" : "");
        paramString = paramString.replaceAll("\\$2", replacement);
        
        String[] args = paramString.split(splitPattern);
        Tagger.taggerDispatch(args, input, output);
    }
    
    private static void doTextFormat(Program prog, Reader input, Writer output, 
            boolean deformatMode) {
        String paramString = prog.getParameters();

        if(deformatMode) {
            /* Since the same class is used for deformatting and re-formatting, but the
             * .mode files aren't setup like that, so prepending "-d" to set it to 
             * deformatting mode.
             */
            paramString = "-d " + paramString;
        } else {
            /* If not in deformatting mode, must be in reformatting mode.
             * So prepend with "-r" instead.
             */
            paramString = "-r " + paramString;
        }
        
        TextFormatter formatter = new TextFormatter();

        String[] args = paramString.split(splitPattern);
        try {
            formatter.doMain(args, input, output);
        } catch (UnsupportedEncodingException e) {
            System.err.println("TextFormatter -- " + 
                    StringTable.getString(Entries.UNSUPPORTED_ENCODING));
            e.printStackTrace();
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("TextFormatter -- " + 
                    StringTable.getString(Entries.FILE_NOT_FOUND));
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    private static void doTransfer(Program prog, Reader input, Writer output) {
        String[] args = prog.getParameters().split("[ ]+");
        try {
            ApertiumTransfer.doMain(args, input, output);
        } catch (UnsupportedEncodingException e) {
            System.err.println("Transfer -- " + 
                    StringTable.getString(Entries.UNSUPPORTED_ENCODING));
            e.printStackTrace();
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("Transfer -- " + 
                    StringTable.getString(Entries.FILE_NOT_FOUND));
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Transfer -- " + 
                    StringTable.getString(Entries.GENERIC_EXCEPTION));
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void doLTProc(Program prog, Reader input, Writer output) {
        String paramString = prog.getParameters();
        String replacement = (_dispMarks ? "-g" : "-n");
        paramString = paramString.replaceAll("\\$1", replacement);
        
        String[] args = paramString.split(splitPattern);
        try {
            LTProc.doMain(args, input, output);
        } catch (IOException e) {
            System.err.println("LTProc -- " +
                    StringTable.getString(Entries.IO_EXCEPTION));
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void doUnknown(Program prog, byte[] input, OutputStream output) {
        try {
            Process extProcess = Runtime.getRuntime().exec(prog.getFullPath() + 
                    " " + prog.getParameters());
            extProcess.getOutputStream().write(input);
            while(true) { //Keep waiting until process is finished.
                try {
                    extProcess.waitFor();
                    /* If external process is finished, we'll get to the break
                     * statement below. If we are interrupted, we won't.
                     */
                    break;
                } catch (InterruptedException e) {
                    /* We got interrupted. Run the loop again.
                     */
                }
            }
            if(extProcess.exitValue() != 0) { 
                //Assume process follows convention of 0 == Success
                System.err.println(prog.getCommandName() + " (Unknown) -- " +
                        "External program failed, returned non-zero value: " + 
                        extProcess.exitValue());
                System.exit(1);
            }
            int currByte;
            while((currByte = extProcess.getInputStream().read()) != -1 ) {
                output.write(currByte);
            }
        } catch (IOException e) {
            System.err.println(prog.getCommandName() + " (Unknown) -- " +
                    StringTable.getString(Entries.IO_EXCEPTION));
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * This separate dispatch for UNKNOWN programs is because we have to use
     * a byte array and an output stream instead of Reader and Writer, when redirecting
     * input and output to and from the externally existing program.
     * @param prog
     * @param input
     * @param output
     */
    public static void dispatchUnknown(Program prog, byte[] input, 
            OutputStream output) {
        switch(prog.getProgram()) {
            case UNKNOWN:
                doUnknown(prog, input, output);
                break;
            default:
                throw new IllegalArgumentException("dispatchUnknown() should only be " + 
                        "used for UNKNOWN programs. ProgEnum was: " + prog.getProgram());
        }
    }
    

    public static void dispatch(Program prog, Reader input, Writer output) {
        switch(prog.getProgram()) {
            case INTERCHUNK:
                doInterchunk(prog, input, output);
                break;
            case LT_PROC:
                doLTProc(prog, input, output);
                break;
            case POSTCHUNK:
                doPostchunk(prog, input, output);
                break;
            case PRETRANSFER:
                doPretransfer(prog, input, output);
                break;
            case TAGGER:
                doTagger(prog, input, output);
                break;
            case TRANSFER:
                doTransfer(prog, input, output);
                break;
            case TXT_DEFORMAT:
                doTextFormat(prog, input, output, true);
                break;
            case TXT_REFORMAT:
                doTextFormat(prog, input, output, false);
                break;
            case UNKNOWN:
                throw new IllegalArgumentException("dispatch() should not be used for " + 
                        "UNKNOWN programs, use dispatchUnknown() instead.");
            default:
                //We should never get here.
                throw new IllegalArgumentException("Unrecognized ProgEnum: " + 
                        prog.getProgram());
        }
    }
    
    public static void setDispAmp(boolean dispAmb) {
        _dispAmb = dispAmb;
    }
    
    public static void setDispMarks(boolean dispMarks) {
        _dispMarks = dispMarks;
    }
}
