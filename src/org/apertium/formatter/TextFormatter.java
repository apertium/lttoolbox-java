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
import java.io.StringWriter;
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
            case '@':
            case '[':
            case ']':
                return true;
            case '*':
            case '#':
            case '+':
            case '~':
                /* If in C++ compatibility mode, return false, as these characters
                 * aren't escaped in the C++ version, even though they probably
                 * should be. If not in C++ compatibility mode, return true
                 */
                return !_cppCompat;
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
                        StringWriter spaceWrite = new StringWriter();
                        boolean writePeriod = false;
                        boolean writeBrackets = false; //Whitespace is other than a single space
                        if((currentChar == '\n') && ((previousChar != '.') || _cppCompat)) {
                            writePeriod = true;
                        }
                        if(currentChar != ' ') { //Whitespace char is other than space
                            writeBrackets = true;
                        }
                        spaceWrite.write(currentChar);
                        previousChar = currentChar;
                        while(Character.isWhitespace((currentChar = inRead.read()))) {
                            spaceWrite.write(currentChar);
                            previousChar = currentChar;
                        }
                        if(currentChar != -1) {
                            writePeriod = false; //There's text after the newline, don't add a period
                        }
                        if(writePeriod) {
                            outWrite.write(".[]");
                        }
                        /* If this section of whitespace is more than one character long,
                         * or if it has non-space whitespace, then we do a superblank.
                         * If it's only a single space, no superblank.
                         */
                        if((spaceWrite.toString().length() > 1) || writeBrackets) {
                            outWrite.write("[" + spaceWrite.toString() + "]");
                        } else {
                            outWrite.write(spaceWrite.toString());
                        }
                        if(currentChar != -1) {
                            if(isApertiumSpecialCharacter(currentChar)) {
                                outWrite.write('\\');
                            }
                            outWrite.write(currentChar);
                            previousChar = currentChar;
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
            /* Insert a period at the end if the last character of the stream isn't
             * a period already or whitespace. Except in the case of C++ compat mode.
             * When in C++ compat mode, ignore if there was a period before or not.
             */
            if(((previousChar != '.') || _cppCompat) && !Character.isWhitespace(previousChar)) {
                outWrite.write(".[]");
            }
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
            /* This variable is used as a flag for if we're dealing with an extra
             * period inserted by the deformatter or not. When a period is encountered,
             * this flag is set and the period is skipped. If the next character is not
             * a '[', indicating the beginning of a superblank, then it is output.
             * If it *is* a '[', then the period is held until the superblank is resolved.
             * If the superblank is empty, then it's marking an extra period that was
             * added, and the period should be discarded. If it's not empty, then the
             * period should be output. 
             */
            boolean foundPeriod = false;
            
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
                    StringWriter spaceWrite = new StringWriter();
                    while((currentChar != -1) && (currentChar != ']')) {
                        /* Superblanks should have only whitespace characters in them
                         * in the plain text format, so no need to check all the characters 
                         * inside of them for escaped characters.
                         */
                        spaceWrite.write(currentChar);
                        previousChar = currentChar;
                        currentChar = inRead.read();
                    }
                    /* spaceWrite should have all the characters inside the superblank
                     * in it. If the length is greater than 0, then we need to check
                     * foundPeriod to see if we need to output a period.
                     * If it's 0, then it was an empty superblank marking an added period
                     * and neither the period, nor the empty string should be output.
                     */
                    if(spaceWrite.toString().length() > 0) {
                        if(foundPeriod) {
                            outWrite.write('.');
                            foundPeriod = false;
                        }
                        outWrite.write(spaceWrite.toString());
                    }
                } else if(currentChar == '.') {
                    foundPeriod = true;
                } else {
                    if(foundPeriod) { outWrite.write('.'); }
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
