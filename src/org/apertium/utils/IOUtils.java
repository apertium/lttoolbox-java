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

package org.apertium.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * @author Stephen Tigner
 *
 */
public class IOUtils {
    
    public static String readFile(String path) throws IOException {
        return readFile(path, "UTF-8");
    }

    public static String readFile(String path, String encoding) throws IOException {
        File outFile = new File(path);
        FileInputStream fis = new FileInputStream(outFile);
        /* If we don't do it this way, by explicitly setting UTF-8 encoding
         * when reading in a file, we get mojibake (scrambled character encodings).
         */
        InputStreamReader fisReader = new InputStreamReader(fis, encoding);
        /* This will leave us with a bunch of extra nulls at the end if the
         * input file has any multi-byte characters in it, we take care of that
         * further down before returning the string.
         */
        char[] charArray = new char[(int) outFile.length()];
        fisReader.read(charArray);
        fisReader.close();
        String testOutput = new String(charArray);
        /* Work backwards from the end of the string to find the first non-null
         * character. That is the true end of the string. (Java strings don't have
         * a null at the end of them to mark the end, since they know exactly how
         * long they are, which is why we can have a bunch of nulls at the end of
         * the string.)
         * 
         * The reason why we need to remove these nulls is that they cause the string
         * to be longer than it actually should be, and messes up testing diffs.
         */
        for(int i = testOutput.length() - 1; i > -1; i--) {
            if(testOutput.charAt(i) != '\0') {
                testOutput = testOutput.substring(0, i + 1);
                break;
            }
        }
        return testOutput;
    }

    /**
     * 
     * @return A reader for System.in with the default encoding of UTF-8.
     * @throws UnsupportedEncodingException
     */
    public static Reader getStdinReader() throws UnsupportedEncodingException {
        return getStdinReader("UTF-8");
    }
    
    public static Reader getStdinReader(String encoding) throws UnsupportedEncodingException {
        return new BufferedReader(new InputStreamReader(System.in, encoding));
    }

    /**
     * 
     * @return A writer for System.out with the default encoding of UTF-8.
     * @throws UnsupportedEncodingException
     */
    public static Writer getStdoutWriter() throws UnsupportedEncodingException {
        return getStdoutWriter("UTF-8");
    }
    
    public static Writer getStdoutWriter(String encoding) throws UnsupportedEncodingException {
        return new BufferedWriter(new OutputStreamWriter(System.out, encoding));
    }
    
    /**
     * Takes a filename string and a command-line label and attempts to open an input
     * stream to the file given in the filename.
     * @param filename - A string with the filename to open
     * @return An InputStream for reading from the file specified.
     * @throws FileNotFoundException 
     */
    public static InputStream openInFileStream(String filename) 
            throws FileNotFoundException {
        return new BufferedInputStream(new FileInputStream(filename));
    }

    /**
     * 
     * @param filename -- The file to open for reading.
     * @return A reader for the file with the default UTF-8 encoding.
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     */
    public static Reader openInFileReader(String filename) 
            throws UnsupportedEncodingException, FileNotFoundException {
        return openInFileReader(filename, "UTF-8");
    }
    
    public static Reader openInFileReader(String filename, String encoding) 
            throws UnsupportedEncodingException, FileNotFoundException {
        return new InputStreamReader(openInFileStream(filename), encoding);
    }
    
    /**
     * Takes a filename string and a command-line label and attempts to open an output
     * stream to the file given in the filename.
     * @param filename - A string with the filename to open
     * @return An OutputStream for writing to the file specified.
     * @throws FileNotFoundException 
     */
    public static OutputStream openOutFileStream(String filename) throws FileNotFoundException {
        return new BufferedOutputStream(new FileOutputStream(filename));
    }

    /**
     * 
     * @param filename -- The file to open for writing.
     * @return A writer for the file with the default UTF-8 encoding.
     * @throws FileNotFoundException
     */
    public static Writer openOutFileWriter(String filename) throws FileNotFoundException {
        return openOutFileWriter(filename, "UTF-8");
    }
    
    public static Writer openOutFileWriter(String filename, String encoding) throws FileNotFoundException {
        return new OutputStreamWriter(openOutFileStream(filename));
    }

    public static FilenameFilter getExtensionFilter(final String extension) {
        FilenameFilter filter = new FilenameFilter() {
            private String _extension = extension;
            
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(_extension);
            }
        };
        return filter;
    }

    public static String[] listFilesInDir(String path) {
        return listFilesInDir(path, null);
    }
    
    public static String[] listFilesInDir(String path, String extension) {
        File directory = new File(path);
        String[] fileList;
        if(extension == null) {
            fileList = directory.list();
        } else {
            fileList = directory.list(getExtensionFilter(extension));
        }
        return fileList;
    }
}
