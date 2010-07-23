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

package org.apertium.pretransfer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.apertium.lttoolbox.Getopt;

/**
 * @author Stephen Tigner
 *
 */
public class PreTransfer {
    /* The C++ code for pre-transfer is highly procedural, with no new classes, and thus
     * no member variables, just a bunch of functions called by each other and main().
     * As such, all functions have been declared as static, but private so that the
     * only entry point is main().
     */

    /**
     * Reads characters from an input stream and writes them to an output stream
     * until the specified character has been encountered. If it hits EOF before
     * the specified character is encountered, it prints an error message and exits.
     * @param input
     * @param output
     * @param charCode -- The integer character code of the character to stop reading
     * and writing when found. This character is read from the input stream, but not
     * written to the output stream.
     * @throws IOException
     */
    private static void readAndWriteUntil(InputStreamReader input, OutputStreamWriter output, 
            final int charCode) throws IOException {
        int myChar;
        
        while((myChar = input.read()) != charCode) {
            if(myChar == -1) {
                System.err.println("pretransfer -- ERROR: unexpected EOF");
                System.exit(1); //EXIT_FAILURE macro constant in the C++ code = 1
            }
            output.write(myChar);
            /* The C++ code has an additional condition checking for a backslash
             * character ('\\'), then reading and writing another character.
             * This additional read and write is different, however, because
             * the normal read and write use "unlocked" variants that don't
             * "implicitly lock the stream" according to the documentation.
             * Since there is no equivalent to those functions in the Java
             * implementation, that section of the code has been left out
             * of the Java version.
             */
        }
    }

    private static void procWord(InputStreamReader input, OutputStreamWriter output) 
            throws IOException {
        int myChar;
        /* Using a StringBuilder instead of just a string for performance reasons, 
         * because Strings are immutable objects in Java, and we're going to be
         * changing this one a lot. StringBuilders are for when you want mutable Strings.
         * StringBuilder is not synchronized, but this is single-threaded code, anyway.
         * If we need synchronization, then we'd want to use a StringBuffer instead.
         */
        StringBuilder buffer = new StringBuilder();
        
        boolean buffer_mode = false;
        boolean in_tag = false;
        boolean queuing = false;
        
        while((myChar = input.read()) != '$') {
            if(myChar == -1) {
                System.err.println("pretransfer -- ERROR: Unexpected EOF");
                System.exit(1); //EXIT_FAILURE = 1
            }
            
            switch(myChar) {
                case '<':
                    in_tag = true;
                    if(!buffer_mode) {
                        buffer_mode = true;
                    }
                    break;
                    
                case '>':
                    in_tag = false;
                    break;
                    
                case '#':
                    if(buffer_mode) {
                        buffer_mode = false;
                        queuing = true;
                    }
                    break;
            }

            if(buffer_mode) {
                if(myChar != '+' || (myChar == '+' && in_tag)) {
                    /* C++ code has 'in_tag == true', which is unnecessary
                     * because you can just test boolean values directly.
                     */
                    buffer.append(Character.toChars(myChar));
                } else if(!in_tag) { //Same here, no need for 'in_tag == false'
                    buffer.append("$ ^");
                }
            } else {
                if(myChar == '+' && queuing) { //Ditto for queuing 
                    buffer.append("$ ^");
                } else {
                    output.write(myChar);
                }
            }
        }
        output.write(buffer.toString());
    }

    private static void processStream(InputStreamReader input, OutputStreamWriter output,
            boolean null_flush) throws IOException {
        int myChar;
        while((myChar = input.read()) != -1) {
            /* The above while statement is equivalent to the C++ code:
             * 
             * while(true)
             * {
             *   int mychar = fgetwc_unlocked(input);
             *   if(feof(input))
             *   {
             *     break;
             *   }
             */
            
            switch(myChar) {
                case '[':
                    output.write('[');
                    readAndWriteUntil(input, output, ']');
                    output.write(']');
                    break;

                case '\\':
                    output.write(myChar);
                    int tempChar = input.read();
                    /* C++ code doesn't seem to handle a backslash at the end of the file
                     * with nothing after it. That's what this code is supposed to handle.
                     * Only write out the char after the backslash if there's actually a
                     * char to output.
                     */
                    if(tempChar != -1 ) { output.write(tempChar); }
                    break;

                case '^':
                    output.write(myChar);
                    procWord(input, output);
                    output.write('$');
                    break;

                case '\0':
                    output.write(myChar);
                    
                    if(null_flush) {
                        output.flush();
                    }
                    break;
                    
                default:
                    output.write(myChar);
                    break;
            }
        }
    }
    
    private static void usage() {
        System.err.println("USAGE: PreTransfer [input_file [output_file]]");
        System.exit(1);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        /* Not sure, at the moment, what this line in the C++ code is supposed to do
         * LtLocale::tryToSetLocale();
         * Probably something to do with Unicode support or the like, so I'm igorning
         * it for now.
         */
        
        boolean null_flush = false;
        
        /* Only support short options, long opts are not currently supported.
         */
        Getopt getopt = new Getopt("PreTransfer", args, "zh");
        int c;
        while((c = getopt.getopt()) != -1) {
            switch(c) {
                case 'z':
                    null_flush = true;
                    break;
                case 'h':
                default:
                    usage();
                    break;
            }
        }

        /* getOptind() returns the index of the first non-option argument
         * encountered (since we iterated through the options until we got back
         * -1). 
         * 
         * In the C++ version, argv[0] is the command used to launch the program.
         * And since it's a zero-based array, adding 1 to it gives you the number
         * of options in argv. The expected arguments in argv (minus options) are
         * the program name, an input file, and an output file (3). If there are more
         * arguments supplied than that, then that is set of invalid arguments.
         * 
         * In the Java version, however, args does not have the command used to 
         * launch the program. So when subtracting options from the args, there
         * should be at most 2 options. And that's why the difference between
         * the C++ and Java versions in the following if statements.
         */

        // No need to run this same calculation over and over again.
        /**
         * Number of non-option arguments on the command-line.
         * Reminder: Does not include the executable's name, like in C++.
         */
        int numberOfArgs = args.length - getopt.getOptind();
        
        if(numberOfArgs > 2) {
            usage();
        }
        
        InputStream input = null;
        OutputStream output = null;
        
        /* This really probably should be a switch statement.
         * Kept it as a sequence of if/else statements for ease of understanding
         * and code checking when comparing it with the C++ version.
         */
        if(numberOfArgs == 0) { //C++ version numberOfArgs == 1
            input = System.in;
            output = System.out;
        } else if (numberOfArgs == 1) { //C++ version numberOfArgs == 2
            try {
                /* Attempt to open a file for input, using the last argument on the
                 * command line as the filename.
                 */
                input = new FileInputStream(args[args.length - 1]);
            } catch (FileNotFoundException e) {
                /* This exception is thrown if the file cannot be found, or
                 * otherwise cannot be opened for reading.
                 */
                usage();
            }
            output = System.out;
        } else {
            try {
                /* Attempt to open a file for input, using the next-to-last argument
                 * on the command line as the filename.
                 */
                input = new FileInputStream(args[args.length - 2]);
                /* Attempt to open a file for output, using the last argument on the
                 * command line as the filename.
                 */
                output = new FileOutputStream(args[args.length - 1]);
            } catch (FileNotFoundException e) {
                /* Either the input or the output file could not be found or otherwise
                 * could not be opened for reading/writing.
                 */
                usage();
            }
        }
        
        /* The C++ version checks for EOF at this point, and dies if it finds it.
         * However we can't check for EOF in the Java version w/o reading the file 
         * and advancing the pointer, so don't bother trying to check for EOF at 
         * this point.
         */
        
        /* The ported functions have been written in the Java version to accept
         * InputStreamReader and OutputStreamWriter objects. The reason for this is to
         * avoid mojibake, which is a loanword from Japanese that refers to the garbled
         * character garbage you get when your character encoding is messed up.
         * When working on the port of the Tagger, I kept encountering mojibake until I
         * switched from using just straight InputStream and OutputStream objects to
         * InputStreamReader and OutputStreamWriter objects.
         */
        
        InputStreamReader inputReader = null;
        OutputStreamWriter outputWriter = null;
        
        try {
            inputReader = new InputStreamReader(input, "UTF-8");
            outputWriter = new OutputStreamWriter(output, "UTF-8"); 
        } catch (UnsupportedEncodingException e) {
            /* This system doesn't support UTF-8 for whatever reason.
             * Complain and then die.
             */
            System.err.println("PreTransfer -- ERROR: This system doesn't seem to " +
                    "support UTF-8 encoding.");
            System.err.println("Please install/enable such support or find a system " +
                    "that does support UTF-8 and try again.");
            System.exit(1);
        }
        
        try {
            processStream(inputReader, outputWriter, null_flush);
            //Have to flush or won't get any output.
            outputWriter.flush();
        } catch (IOException e) {
            System.err.println("Pretransfer -- ERROR: IOException");
            e.printStackTrace();
        }
    }
}