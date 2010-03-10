/*
 * Copyright (C) 2005 Universitat d'Alacant / Universidad de Alicante
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
import java.util.HashMap;

/**
 *
 * @author jimregan
 */
public class ConstantManager {
    private HashMap<String, Integer> constants;

    public void ConstantManager() {
        constants = new HashMap<String, Integer>();
    }

    public void setConstant (String constant, int value) {
        constants.put(constant, value);
    }

    public int getConstant(String constant) {
        return constants.get(constant);
    }
}
