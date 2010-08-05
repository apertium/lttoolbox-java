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

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import org.apertium.interchunk.Interchunk;
import org.apertium.transfer.TransferWord;

/**
 * @author Stephen Tigner
 * 
 * This extends the Interchunk class since they have alot of the same code.
 *
 */
public class Postchunk extends Interchunk {
    
    /**
     * This function parses a chunk and reads all the tags
     * from the beginning part of the chunk (before the first "{") 
     * into an ArrayList.
     * @param chunk -- The string chunk to process.
     * @return An ArrayList of tags in the beginning part of the chunk.
     */
    private static ArrayList<String> getVecTags(final String chunk) {
        ArrayList<String> vecTags = new ArrayList<String>();
        
        for(int i = 0, limit = chunk.length(); i != limit; i++) {
            if(chunk.charAt(i) == '\\') {
                i++;
            }
            else if(chunk.charAt(i) == '<') {
                StringBuilder myTag = new StringBuilder();
                do {
                    myTag.append(chunk.charAt(i));
                    i++;
                } while(chunk.charAt(i) != '>');
                myTag.append('>');
                vecTags.add(myTag.toString());
            } else if(chunk.charAt(i) == '{') {
                break;
            }
        }
        return vecTags;
    }

    /**
     * Returns the length of the beginning part of the chunk, before the
     * curly brace-enclosed ("{}") part of it.
     * @param chunk -- The string chunk to process.
     * @return The length of the beginning part of the chunk, which may
     * be the entire chunk, if there is no end part.
     */
    private static int beginChunk(final String chunk) {
        for(int i = 0, limit = chunk.length(); i != limit; i++) {
            if(chunk.charAt(i) == '\\') {
                i++;
            } else if(chunk.charAt(i) == '{') {
                /* We only want the length of first part of the chunk,
                 * before the {}. Adding 1 to i gives the length of
                 * that substring.
                 */
                return i + 1;
            }
        }
        /* We ran through the entire chunk and didn't find a single
         * curly brace '{', so the part of the chunk we want is the
         * entire thing. 
         */
        return chunk.length();
    }
    
    private static int endChunk(final String chunk) {
        /* Returns the length of the chunk - 2,
         * If passing in an entire chunk, this would return
         * the length up to the final '}$'
         */
        return chunk.length() - 2;
    }

    /**
     * This will return the beginning part of the chunk, up to
     * the end part (the first '{'), or an empty string of there is
     * no end part found.
     * @param chunk
     * @return
     */
    private String wordZero(final String chunk) {
        for(int i = 0, limit = chunk.length(); i != limit; i++) {
            if(chunk.charAt(i) == '\\') {
                i++;
            } else if(chunk.charAt(i) == '{') {
                /* We want everything up to the '{', but not
                 * including it. Since substring will return
                 * a string from the startIndex to endIndex - 1,
                 * and '{' is at the endIndex of i, just feed
                 * i to it.
                 */
                return chunk.substring(0, i);
            }
        }
        return "";
    }
    
    private static String pseudolemma(final String chunk) {
        for(int i = 0, limit = chunk.length(); i != limit; i++) {
            if(chunk.charAt(i) == '\\') {
                i++;
            } else if(chunk.charAt(i) == '<' || chunk.charAt(i) == '{') {
                /* Return the chunk text up to the first tag.
                 */
                return chunk.substring(0, i);
            }
        }
        //No tags found, return an empty string.
        return "";
    }
    
    private void unchunk(final String chunk, Writer output) throws IOException {
        ArrayList<String> vecTags = getVecTags(chunk);
        String caseInfo = TransferWord.caseOf(pseudolemma(chunk));
        
        boolean uppercaseAll = false;
        boolean uppercaseFirst = false;
        
        if(caseInfo.equals("AA")) {
            uppercaseAll = true;
        } else if(caseInfo.equals("Aa")) {
            uppercaseFirst = true;
        }
        
        /* This for loop runs from the beginning of the first '{' in the chunk
         * to the end of the chunk right before the ending '}$'.
         */
        for(int i = beginChunk(chunk), limit = endChunk(chunk); i < limit; i++) {
            if(chunk.charAt(i) == '\\') {
                output.write('\\');
                /* Pre-increment of i, increments it, then evaluates the expression
                 * with the incremented value of i. This means that it grabs the
                 * next character after the backslash.
                 */
                output.write(chunk.charAt(++i));
            } else if(chunk.charAt(i) == '^') {
                output.write('^');
                while(chunk.charAt(++i) != '$') {
                    if(chunk.charAt(i) == '\\') {
                        output.write('\\');
                        output.write(chunk.charAt(++i));
                    } else if(chunk.charAt(i) == '<') {
                        if(Character.isDigit(chunk.charAt(i + 1))) {
                            //replace tag
                            /* Using int instead of long because thats what
                             * ArrayList.get() expects.
                             */
                            int value = Integer.parseInt(chunk.substring(i + 1)) - 1;
                            if(vecTags.size() > value) {
                                output.write(vecTags.get(value));
                            }
                            //increment i until we hit the end of the tag
                            while(chunk.charAt(i) != '>');
                        } else {
                            output.write('<');
                            while(chunk.charAt(++i) != '>') { output.write(chunk.charAt(i)); }
                            output.write('>');
                        }
                    } else {
                        if(uppercaseAll) {
                            output.write(Character.toUpperCase(chunk.charAt(i)));
                        } else if(uppercaseFirst) {
                            if(Character.isLetterOrDigit(chunk.charAt(i))) {
                                output.write(Character.toUpperCase(chunk.charAt(i)));
                                uppercaseFirst = false;
                            } else {
                                output.write(chunk.charAt(i));
                            }
                        } else {
                            output.write(chunk.charAt(i));
                        }
                    }
                }
                output.write('$');
            } else if(chunk.charAt(i) == '[') {
                output.write('[');
                while(chunk.charAt(i) != ']') {
                    if(chunk.charAt(i) == '\\') {
                        output.write('\\');
                        output.write(chunk.charAt(i));
                    } else {
                        output.write(chunk.charAt(i));
                    }
                }
                output.write(']');
            } else {
                output.write(chunk.charAt(i));
            }
        }
    }
    
    private static void splitWordsAndBlanks(final String chunk, ArrayList<String> words, ArrayList<String> blanks) {
        ArrayList<String> vecTags = getVecTags(chunk);
        StringBuilder result = new StringBuilder();
        String caseInfo = TransferWord.caseOf(pseudolemma(chunk));
        
        boolean uppercaseAll = false;
        boolean uppercaseFirst = false;
        boolean lastBlank = true;
        
        if(caseInfo.equals("AA")) {
            uppercaseAll = true;
        } else if(caseInfo.equals("Aa")) {
            uppercaseFirst = true;
        }
        
        for(int i = beginChunk(chunk), limit = endChunk(chunk); i < limit; i++) {
            if(chunk.charAt(i) == '\\') {
                result.append('\\');
                result.append(chunk.charAt(++i));
            } else if(chunk.charAt(i) == '^') {
                if(!lastBlank) {
                    blanks.add(result.toString());
                    result = new StringBuilder();
                }
                lastBlank = false;
                /* No need for pointer and reference acrobatics in the Java version.
                 * So will just be using myWord instead of "ref"
                 */
                StringBuilder myWord = new StringBuilder();
                
                while(chunk.charAt(++i) != '$') {
                    if(chunk.charAt(i) == '\\') {
                        myWord.append('\\');
                        myWord.append(chunk.charAt(++i));
                    } else if(chunk.charAt(i) == '<') {
                        if(Character.isDigit(chunk.charAt(i + 1))) {
                            //replace tag
                            int value = Integer.parseInt(chunk.substring(i + 1));
                            if(vecTags.size() > value) {
                                myWord.append(vecTags.get(value));
                            }
                            while(chunk.charAt(++i) != '>');
                        } else {
                            myWord.append('<');
                            while(chunk.charAt(++i) != '>') { myWord.append(chunk.charAt(i)); }
                            myWord.append('>');
                        }
                    } else {
                        if(uppercaseAll) {
                            myWord.append(Character.toUpperCase(chunk.charAt(i)));
                        } else if(uppercaseFirst) {
                            if(Character.isLetterOrDigit(chunk.charAt(i))) {
                                myWord.append(chunk.charAt(i));
                                uppercaseFirst = false;
                            } else {
                                myWord.append(chunk.charAt(i));
                            }
                        } else {
                            myWord.append(chunk.charAt(i));
                        }
                    }
                }
                words.add(myWord.toString());
            } else if(chunk.charAt(i) == '[') {
                //Again no need for "ref" in the Java code
                StringBuilder myBlank = new StringBuilder();
                myBlank.append('[');
                while(chunk.charAt(++i) != ']') {
                    if(chunk.charAt(i) == '\\') {
                        myBlank.append('\\');
                        myBlank.append(chunk.charAt(++i));
                    } else {
                        myBlank.append(chunk.charAt(i));
                    }
                }
                myBlank.append(chunk.charAt(i));
                blanks.add(myBlank.toString());
                lastBlank = true;
            } else if(chunk.charAt(i) == ' ') {
                blanks.add(" ");
                lastBlank = true;
            }
        }
    }


    /**
     * Much of this code originally copied from {@link org.apertium.transfer.Transfer#applyRule(Writer)}.
     * Modified to be in-line with the differences between transfer.cc and interchunk.cc
     */
    private void applyRule(Writer output) {
      // signature a la public void rule0__nom(Writer out, InterchunkWord[] words, String[] blanks)
        Object[] args = new Object[3];
        // Jacob TODO
    }
}
