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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jimregan
 */
public class EndianDoubleUtilTest extends TestCase {

    /**
     * $ hexdump double-test
     * 0000000 fe3f 7066 c1e2 d82a
     * 
     * ...but I'm on a little endian machine - khexedit gives me this
     */
    byte[] doublebytes = new byte[] {(byte) 0x3f, (byte) 0xfe, (byte) 0x66, (byte) 0x70,
                                     (byte) 0xe2, (byte) 0xc1, (byte) 0x2a, (byte) 0xd8};

    double dtest=1.90001;

    /**
     * Test of read method, of class EndianDoubleUtil.
     *
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        FileOutputStream outtest = new FileOutputStream ("./tmp/readtest");
        DataOutputStream outbytes = new DataOutputStream (outtest);
        for (byte b : this.doublebytes)
            outbytes.writeByte(b);
        InputStream in = new FileInputStream("./tmp/readtest");
        double result = EndianDoubleUtil.read(in);
        outbytes.close();
        assertEquals(this.dtest, result, 1.90001);
    }

    /**
     * Test of write method, of class EndianDoubleUtil.
     */
    @Test
    public void testWrite() throws Exception {
        System.out.println("write");
        OutputStream out = new FileOutputStream("./tmp/writetest");
        Double d = 1.90001;
        EndianDoubleUtil.write(out, d);
        FileInputStream reread = new FileInputStream ("./tmp/writetest");
        DataInputStream bytesin = new DataInputStream (reread);
        for (int i=0; i<8; i++) {
            byte test = bytesin.readByte();
            assertEquals(this.doublebytes[i], test);
        }
        bytesin.close();
    }

}