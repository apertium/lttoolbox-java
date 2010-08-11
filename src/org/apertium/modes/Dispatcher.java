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

import java.io.Reader;
import java.io.Writer;

import org.apertium.interchunk.ApertiumInterchunk;
import org.apertium.interchunk.ApertiumInterchunk.CommandLineParams;

/**
 * @author Stephen Tigner
 *
 */
public class Dispatcher {
    
    private static void doInterchunk(Program prog, Reader input, Writer output) {
        CommandLineParams par = new CommandLineParams();
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
        ApertiumInterchunk.doMain(par);
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
                //TODO: call postchunk
                break;
            case PRETRANSFER:
                //TODO: call pretransfer
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
