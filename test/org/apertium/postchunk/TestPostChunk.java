/*
 * Copyright (C) 2010 Stephen
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

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


/**
 * @author Stephen
 *
 */
public class TestPostChunk {
    
    //Tests for the static methods

    /**
     * This method uses the reflection API to run tests on the private static members of
     * Postchunk.
     */
    private static Object runPrivateMethod(String name, Class[] paramTypes, Object[] params)
            throws SecurityException, NoSuchMethodException, IllegalArgumentException, 
            IllegalAccessException, InvocationTargetException {
        Class pcClass = Postchunk.class;
        Method privateMethod = pcClass.getDeclaredMethod(name, paramTypes);
        /* Allows us to bypass the normal access checks and access a private
         * method for testing purposes.
         */
        privateMethod.setAccessible(true);
        Object returnObject = privateMethod.invoke(null, params);
        /* Reset it back to normal.
         */
        privateMethod.setAccessible(false);
        return returnObject;
    }

    @Test
    public void testGetVecTags() throws SecurityException, IllegalArgumentException, 
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String methodName = "getVecTags";
        String inputString = "^Nom<SN><PDET><m><sg>{^anarquismo<n><3><4>$}$";
        String[] expOutArray = {"<SN>", "<PDET>", "<m>", "<sg>"};
        ArrayList expectedOutput = new ArrayList<String>(Arrays.asList(expOutArray));
        
        Class[] paramTypes = {String.class};
        Object[] params = {inputString};
        
        ArrayList<String> returnVal = (ArrayList<String>) 
                runPrivateMethod(methodName, paramTypes, params);
        assertEquals("TestPostChunk.testGetVecTags() failed: output does not match expected output", returnVal, expectedOutput);
    }

    @Test
    public void testBeginChunk() throws SecurityException, IllegalArgumentException, 
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String methodName = "beginChunk";
        String inputString = "^Nom<SN><PDET><m><sg>{^anarquismo<n><3><4>$}$";
        int expectedOutput = 22; //This should be the index of the '^' after the '{'
        
        Class[] paramTypes = {String.class};
        Object[] params = {inputString};
        
        int returnVal = (Integer) 
                runPrivateMethod(methodName, paramTypes, params);

        assertEquals("TestPostChunk.testBeginChunk() failed: output does not match expected output", returnVal, expectedOutput);
    }
    
    /* There *was* a method for testing endChunk here... then I realized it was
     * one line... which returned the length of the string minus 2...
     * Yeah, no real need to test that. XD
     */
    
    public void testPseudoLemma() {
        //TODO: Implement this
    }
    
    public void testSplitWordsAndBlanks() {
        //TODO: Implement this
    }
}
