/*
# This file is part of Charlifter.
# Copyright 2008-2009 Kevin P. Scannell <kscanne at gmail dot com>
#
#     Charlifter is free software: you can redistribute it and/or modify
#     it under the terms of the GNU General Public License as published by
#     the Free Software Foundation, either version 3 of the License, or
#     (at your option) any later version.
#
#     Charlifter is distributed in the hope that it will be useful,
#     but WITHOUT ANY WARRANTY; without even the implied warranty of
#     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#     GNU General Public License for more details.
#
#     You should have received a copy of the GNU General Public License
#     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.apertium.charlifter;

/**
 *
 * @author jimregan
 */
public class Process {
    private double[][] features;

    private String diacritics;
    private String ints;
    private String extrabd;
    private static boolean okina;

    public static boolean isOkina () {
        return okina;
    }

    void init () {
        this.diacritics = "\\p{M}|[\\x{A8}\\x{B4}\\x{B8}\\x{02B9}-\\x{02DD}]";
        this.ints = "´'’-";
        this.extrabd = "a";
        this.okina = false;
    }
    
    void init (String lang) {
        if (lang.equals("sm") || lang.equals("haw")) {
            this.diacritics = "\\p{M}|[\\x{A8}\\x{B4}\\x{B8}\\x{02B9}-\\x{02DD}]";
            this.ints = "-";
            this.extrabd = "'’‘";
            this.okina = true;
        } else {
            init();
        }
    }


}
