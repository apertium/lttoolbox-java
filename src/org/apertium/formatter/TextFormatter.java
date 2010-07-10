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

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * @author Stephen Tigner
 * Class to de-format and re-format plain text.
 * (De)escapes Apertium stream format special characters and inserts/removes
 * superblanks.
 */
public class TextFormatter extends GenericFormatter {

    private boolean isApertiumSpecialCharacter(int charCode) {
        switch(charCode) {
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
                return true;
            default:
                return false;
        }
    }
    
    @Override
    protected void deFormat(InputStream in, OutputStream out) {
        InputStreamReader inRead = null;
        Writer outWrite = null;
        try {
            inRead = new InputStreamReader(in, "UTF-8");
            /* The OutputStreamWriter is wrapped in a BufferedWriter for
             * performance reasons, per the Java API docs on OutputStreamWriter.
             * "Each invocation of a write() method causes the encoding converter 
             * to be invoked on the given character(s). [...]
             * For top efficiency, consider wrapping an OutputStreamWriter within a 
             * BufferedWriter so as to avoid frequent converter invocations."
             */
            outWrite = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
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
                if(DEBUG) {
                    System.err.println("currentChar: " + currentChar + ", char: '" +
                            new String(Character.toChars(currentChar)) + "'");
                }
                if(isApertiumSpecialCharacter(currentChar)) {
                    outWrite.write("\\");
                    outWrite.write(currentChar);
                    previousChar = currentChar;
                } else {
                    if(Character.isWhitespace(currentChar)) {
                        /* Insert a period before a newline, to mimic the behavior
                         * of the C++ deformatter. However, we don't have to completely
                         * mimic the behavior of inserting an extra period when one
                         * already exists.
                         */
                        if((currentChar == '\n') && (previousChar != '.')) {
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
                        if(currentChar != -1) {
                            if(isApertiumSpecialCharacter(currentChar)) {
                                outWrite.write('\\');
                            }
                            outWrite.write(currentChar);
                        }
                    } else {
                        /* This character could be a special character that needs
                         * escaping. 
                         */
                        if(isApertiumSpecialCharacter(currentChar)) {
                            outWrite.write('\\');
                        }
                        outWrite.write(currentChar);
                        previousChar = currentChar;
                    }
                }
            } while((currentChar = inRead.read()) != -1);
            /* Have to flush it, or you'll never get any output!
             * This is needed both with and without the BufferedWriter wrapped
             * around the OutputStreamWriter.
             */
            outWrite.flush();
        } catch (IOException e) {
            System.err.println("IOException occured in TextFormatter.deFormat()");
            e.printStackTrace();
        }
    }

    @Override
    protected void reFormat(InputStream in, OutputStream out) {
        InputStreamReader inRead = null;
        Writer outWrite = null;
        try {
            inRead = new InputStreamReader(in, "UTF-8");
            /* The OutputStreamWriter is wrapped in a BufferedWriter for
             * performance reasons, per the Java API docs on OutputStreamWriter.
             * "Each invocation of a write() method causes the encoding converter 
             * to be invoked on the given character(s). [...]
             * For top efficiency, consider wrapping an OutputStreamWriter within a 
             * BufferedWriter so as to avoid frequent converter invocations."
             */
            outWrite = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.err.println(_commandLabel + " -- This system apparently doesn't support UTF-8 encoding.");
            System.err.println("Cannot continue. Find a system that does and try again.");
            System.exit(1);
        }

        try {
            int currentChar = inRead.read();
            int previousChar = -1;
            
            do {
                if(currentChar == '\\') { //Escaped character
                    previousChar = currentChar;
                    currentChar = inRead.read();
                    if(currentChar == -1) {
                        /* This should never happen, we shouldn't get a single backslash at the end of the file,
                         * but we should expect the unexpected and deal with it anyway. Go ahead and output the
                         * backslash.
                         */
                        outWrite.write(previousChar);
                    } else {
                        //Output the char that was escaped.
                        outWrite.write(currentChar);
                    }
                } else if(currentChar == '[') { //Start of a superblank
                    previousChar = currentChar;
                    currentChar = inRead.read();
                    while((currentChar != -1) && (currentChar != ']')) {
                        /* Superblanks should have only whitespace characters in them
                         * in the plain text format, so no need to check all the characters 
                         * inside of them for escaped characters.
                         */
                        outWrite.write(currentChar);
                        previousChar = currentChar;
                        currentChar = inRead.read();
                    }
                } else {
                    outWrite.write(currentChar);
                }
                previousChar = currentChar;
            } while((currentChar = inRead.read()) != -1);
            /* Have to flush it, or you'll never get any output!
             * This is needed both with and without the BufferedWriter wrapped
             * around the OutputStreamWriter.
             */
            outWrite.flush();
        } catch (IOException e) {
            System.err.println("IOException occured in TextFormatter.reFormat()");
            e.printStackTrace();
        }
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
