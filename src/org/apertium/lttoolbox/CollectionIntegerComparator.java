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

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author sortiz
 */
class CollectionIntegerComparator
    implements Comparator<Collection<Integer>> {

    public boolean equals(Collection<Integer> other) {
        if (other == this) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compare(Collection<Integer> o1, Collection<Integer> o2) {
        if (o1 == o2) {
            return 0;
        } else if (o1.size() > o2.size()) {
            return 1;
        } else if (o1.size() < o2.size()) {
            return -1;
        }

        Iterator<Integer> it1 = o1.iterator();
        Iterator<Integer> it2 = o2.iterator();

        while (it1.hasNext()) {
            Integer a = it1.next();
            Integer b = it2.next();

            if (a > b) {
                return 1;
            }
            if (a < b) {
                return -1;
            }
        }

        return 0;
    }
}
