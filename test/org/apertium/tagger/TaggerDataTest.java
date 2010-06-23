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

import java.io.*;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jim
 */
public class TaggerDataTest extends TestCase {

    public TaggerDataTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of read method, of class TaggerData.
     */
    @Test
    public void testRead() throws Exception {
        //fail("This test is not ready yet. Comment this line to try it out, at your own risk.");
        System.out.println("read");
        String file = "testdata/tagger/en-es.prob";
        InputStream fin = new FileInputStream(file);
        BufferedInputStream buf = new BufferedInputStream(fin);
        TaggerData instance = new TaggerData();
        instance.read(fin);
        // TODO review the generated test code and remove the default call to fail.

    }

}