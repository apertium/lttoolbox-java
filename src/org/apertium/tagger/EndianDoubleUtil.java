/*
 * Copyright 2010 Jimmy O'Regan
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

package org.apertium.tagger;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * This class is a misnomer, as endianness is not an issue
 * @author jimregan
 */
public class EndianDoubleUtil {
    public static double read (InputStream in) throws IOException {
        // TODO - check for compatibility
        DataInputStream data = new DataInputStream(in);
        return data.readDouble();
    }

    public static void write (OutputStream out, Double d) throws IOException {
        // TODO - check for compatibility
        DataOutputStream data = new DataOutputStream(out);
        data.writeDouble(d);
    }
}
