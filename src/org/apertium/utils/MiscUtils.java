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

/**
 * @author Stephen Tigner
 *
 */
public class MiscUtils {
    public static Class loadClassFromTxFilename(String filename) 
            throws ClassNotFoundException {
        /* I tried just separating based on the "file.separator"
         * system property, but that didn't split the unix-style paths
         * when running on windows.
         */
        String pathSep = System.getProperty("file.separator");
        filename = filename.replaceAll("[-.]", "_");
        /* Split by both / and \\, since we could have either in a mixed
         * environment.
         */
        String[] tRulesSplit = filename.split("\\\\");
        tRulesSplit = tRulesSplit[tRulesSplit.length - 1].split("/");
        String className = "org.apertium.transfer.generated." + 
            tRulesSplit[tRulesSplit.length - 1].trim();
        Class tRulesClass = Class.forName(className);
        return tRulesClass;
    }
}
