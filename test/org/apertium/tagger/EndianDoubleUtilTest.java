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
public class EndianDoubleUtilTest {

    public EndianDoubleUtilTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class EndianDoubleUtil.
     *
     * $ hexdump double-test
     * 0000000 fe3f 7066 c1e2 d82a
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        InputStream in = null;
        double expResult = 0.0;
        double result = EndianDoubleUtil.read(in);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class EndianDoubleUtil.
     */
    @Test
    public void testWrite() throws Exception {
        System.out.println("write");
        OutputStream out = null;
        Double d = null;
        EndianDoubleUtil.write(out, d);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}