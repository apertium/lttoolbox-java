package org.apertium.lttoolbox;

/*
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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Writer;

/**
 * Clase "Compression".
 * Methods to access or write compressed data by the byte-aligned method
 * @author gustave
 */
public class Compression {
 

    /**
     * Encodes an integer value and writes it into the output stream
     * @param value integer to write.
     * @param output output stream.
     * @throws java.io.IOException
     */
    static void multibyte_write(long value, DataOutputStream output) throws IOException {
        if (value < 0x00000040) {
            output.write((char) value);
        } else if (value < 0x00004000) {
            char low = (char) value;
            char up = (char) (value >> 8);
            up |= 0x40;
            output.write(up);
            output.write(low);
        } else if (value < 0x00400000) {
            char low = (char) value;
            char middle = (char) (value >> 8);
            char up = (char) (value >> 16);
            up |= 0x80;
            output.write(up);
            output.write(middle);
            output.write(low);
        } else if (value < 0x40000000) {
            char low = (char) value;
            char middlelow = (char) (value >> 8);
            char middleup = (char) (value >> 16);
            char up = (char) (value >> 24);
            up |= 0xc0;
            output.write(up);
            output.write(middleup);
            output.write(middlelow);
            output.write(low);
        } else {
            throw new RuntimeException("Out of range: " + value);

        }
    }

    /**
     * Read and decode an integer from the input stream.
     * @param input input stream.
     * @return the integer value readed.
     * @throws java.io.IOException
     */
    static int multibyte_read(DataInputStream input) throws IOException {
        char up;
        long result = 0;

        up = (char) input.read();
        if (up < 0x40) {
            result = (int) up;
        } else if (up < 0x80) {
            up &= 0x3f;
            int aux = (int) up;
            aux = aux << 8;
            char low = (char) input.read();
            result = (int) low;
            result = result | aux;
        } else if (up < 0xc0) {
            up &= 0x3f;
            int aux = (int) up;
            aux = aux << 8;
            char middle = (char) input.read();
            result = (int) middle;
            aux = (int) result | aux;
            aux = aux << 8;
            char low = (char) input.read();
            result = (int) low;
            result = result | aux;
        } else {
            up &= 0x3f;
            int aux = (int) up;
            aux = aux << 8;
            char middleup = (char) input.read();
            result = (int) middleup;
            aux = (int) result | aux;
            aux = aux << 8;
            char middlelow = (char) input.read();
            result = (int) middlelow;
            aux = (int) result | aux;
            aux = aux << 8;
            char low = (char) input.read();
            result = (int) low;
            result = result | aux;
        }
        if (result > 2147283647) {
            result -= 2147283647;
            result -= 2147283647;
            result -= 2;
        }
        return (int) result;
    }

    /**
     * This method allows to write a wide string to an output stream
     * using its UCSencoding as integer.
     * @param str the string to write.
     * @param output the output stream.
     * @throws java.io.IOException
     */
    static void String_write(String str, DataOutputStream output) throws IOException {
        multibyte_write(str.length(), output);
        for (int i = 0,  limit = str.length(); i != limit; i++) {
            multibyte_write((str.charAt(i)), output);
        }
    }

    /**
     * This method reads a wide string from the input stream.
     * @param input the input stream.
     * @return the wide string readed.
     * @throws java.io.IOException
     */
    static String String_read(DataInputStream input) throws IOException {
        String retval = "";
        for (int i = 0,  limit = multibyte_read(input); i != limit; i++) {
            retval += (char) (multibyte_read(input));
        }
        return retval;
    }
}
