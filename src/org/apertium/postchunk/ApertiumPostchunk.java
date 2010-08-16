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

package org.apertium.postchunk;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.apertium.interchunk.ApertiumInterchunk;
import org.apertium.interchunk.Interchunk;
import org.apertium.utils.StringTable;

/**
 * @author Stephen Tigner
 *
 */
public class ApertiumPostchunk extends ApertiumInterchunk {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        Postchunk p = new Postchunk();

        CommandLineParams par = new CommandLineParams();
        try {
            /* Parse the command line. The passed-in CommandLineParams object
             * will be modified by this method.
             */
            parseCommandLine(args, par, "Postchunk", false);
        } catch (FileNotFoundException e) {
            System.err.println("ApertiumPostchunk (I/O files) -- " +
                    StringTable.FILE_NOT_FOUND);
            System.exit(1);
        } catch (UnsupportedEncodingException e) {
            System.err.println("ApertiumPostchunk (I/O files) -- " +
                    StringTable.UNSUPPORTED_ENCODING);
            System.exit(1);
        }
        
        try {
            doMain(par, p);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
