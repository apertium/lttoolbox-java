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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author Stephen Tigner
 * Class to de-format and re-format plain text.
 * (De)escapes Apertium stream format special characters and inserts/removes
 * superblanks.
 */
public class TextFormatter extends GenericFormatter {

    @Override
    protected void deFormat(InputStream in, OutputStream out) {
        InputStreamReader inRead = null;
        OutputStreamWriter outWrite = null;
        try {
            inRead = new InputStreamReader(in, "UTF-8");
            outWrite = new OutputStreamWriter(out, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.err.println(_commandLabel + " -- This system apparently doesn't support UTF-8 encoding.");
            System.err.println("Cannot continue. Find a system that does and try again.");
            System.exit(1);
        }
        try {
            int currentChar = inRead.read();
            /* Keep track of the previous char, intended for use if needing
             * to backtrack one character for some reason.
             */
            int previousChar = -1;
            do {
                switch(currentChar) {
                    //Apertium stream format special characters
                    case '^':
                    case '$':
                    case '/':
                    case '<':
                    case '>':
                    case '{':
                    case '}':
                    case '\\':
                    case '*':
                    case '@':
                    case '#':
                    case '+':
                    case '~':
                    case '[':
                    case ']':
                        outWrite.write('\\');
                        outWrite.write(currentChar);
                        previousChar = currentChar;
                        break;
                    default:
                        /* Insert a period before a newline, to mimic the behavior
                         * of the C++ deformatter.
                         */
                        if(Character.isWhitespace(currentChar)) {
                            if(currentChar == '\n') {
                                outWrite.write('.');
                            }
                            outWrite.write('[');
                            outWrite.write(currentChar);
                            previousChar = currentChar;
                            while(Character.isWhitespace((currentChar = inRead.read()))) {
                                outWrite.write(currentChar);
                                previousChar = currentChar;
                            }
                            outWrite.write(']');
                        } else {
                            outWrite.write(currentChar);
                            previousChar = currentChar;
                        }
                        break;
                }
            } while((currentChar = inRead.read()) != -1);
        } catch (IOException e) {
            System.err.println("IOException occured in TextFormatter.deFormat()");
            e.printStackTrace();
        }
    }

    @Override
    protected void reFormat(InputStream in, OutputStream out) {
        // TODO Auto-generated method stub
        
    }

    TextFormatter(String commandLabel) {
        super(commandLabel);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        TextFormatter formatter = new TextFormatter("TextFormatter");
        formatter.doMain(args);
    }
}
