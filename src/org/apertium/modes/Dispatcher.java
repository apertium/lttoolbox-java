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

package org.apertium.modes;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.apertium.interchunk.ApertiumInterchunk;
import org.apertium.interchunk.Interchunk;
import org.apertium.postchunk.ApertiumPostchunk;
import org.apertium.postchunk.Postchunk;
import org.apertium.pretransfer.PreTransfer;
import org.apertium.tagger.Tagger;

/**
 * @author Stephen Tigner
 *
 */
public class Dispatcher {

    private static void doInterchunk(Program prog, Reader input, Writer output) {
        ApertiumInterchunk.CommandLineParams par = 
            new ApertiumInterchunk.CommandLineParams();
        /* Parse the command line. The passed-in CommandLineParams object
         * will be modified by this method.
         */
        String[] args = prog.getParameters().split(" ");
        ApertiumInterchunk.parseCommandLine(args, par, "Interchunk");
        /* Assume internal i/o, don't allow for specifying external temp
         * files for i/o.
         */
        par.input = input;
        par.output = output;

        try {
            ApertiumInterchunk.doMain(par, new Interchunk());
        } catch (Exception e) {
            //Add message that exception occurred in Interchunk.
            throw new RuntimeException("Exception occurred in Interchunk.", e);
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
        String[] args = prog.getParameters().split(" ");
        ApertiumInterchunk.parseCommandLine(args, par, "Interchunk");
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
            //Add message that exception occurred in Postchunk.
            throw new RuntimeException("Exception occurred in Postchunk.", e);
        }
    }

    private static void doPretransfer(Program prog, Reader input, Writer output) {
        PreTransfer.CommandLineParams params = new PreTransfer.CommandLineParams();
        String[] args = prog.getParameters().split(" ");
        PreTransfer.parseArgs(args, params);

        try {
            /* Assume internal I/O, don't allow for specifying external temp
             * files for I/O.
             * External input and output files are used only at the beginning
             * and end of the chain, and are handled by the code that calls the
             * dispatcher.
             */
            PreTransfer.processStream(input, output, params.nullFlush);
        } catch (IOException e) {
            throw new RuntimeException("IOException occured in Pretransfer.", e);
        }
    }
    
    private static void doTagger(Program prog, Reader input, Writer output) {
        String[] args = prog.getParameters().split(" ");
        /* Existing tagger code requires Input and Output streams, not readers
         * and writers.
         */
        Tagger.taggerDispatch(args, input, output);
    }
    
    public static void dispatch(Program prog, Reader input, Writer output) {
        switch(prog.getProgram()) {
            case INTERCHUNK:
                doInterchunk(prog, input, output);
                break;
            case LT_PROC:
                //TODO: call lt-proc
                break;
            case POSTCHUNK:
                doPostchunk(prog, input, output);
                break;
            case PRETRANSFER:
                doPretransfer(prog, input, output);
                break;
            case TAGGER:
                //TODO: call tagger
                break;
            case TRANSFER:
                //TODO: call transfer
                break;
            case TXT_DEFORMAT:
                //TODO: call text deformatter
                break;
            case TXT_REFORMAT:
                //TODO: call text reformatter
                break;
            case UNKNOWN:
                //TODO: call the literal program
                break;
            default:
                //We should never get here.
                throw new IllegalArgumentException("Unrecognized ProgEnum: " + prog);
        }
    }
}
