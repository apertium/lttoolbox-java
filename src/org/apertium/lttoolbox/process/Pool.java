package org.apertium.lttoolbox.process;

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

import java.util.List;
import java.util.ArrayList;

/**
 * Pool of T objects
 * Created by Nic Cottrell, Jan 27, 2009 5:19:23 PM
 */
public class Pool<T> {

    /**
     * Free pointers to objects
     */
    List<T> free;
    
    /**
     * Currently created objects
     */
    List<T> created;

    /**
     * copy method
     * @param p other pool object
     */
    void copy(Pool p) {
        created = p.created;
        for (T t : created) {
            free.add(t);
        }
    }

    /**
     * destroy method
     */
    void destroy() {
    // do nothing
    }

    /**
     * Allocate a pool of nelems size
     * @param nelems initial size of the pool
     */
    void init(int nelems) {
        created = new ArrayList<T>();
        free = new ArrayList<T>();
        // T tmp;
        for (int i = 0; i != nelems; i++) {
            created.add(0, null);
            free.add(0, ((created.get(0))));
        }
    }

    /**
     * Allocate a pool of nelems size with objects equal to 'object'
     * @param nelems initial size of the pool
     * @param object initial value of the objects in the pool
     */
    void init(int nelems, T object) {
        created.clear();
        free.clear();
        for (int i = 0; i != nelems; i++) {
            created.add(0, object);
            free.add(0, ((created.get(0))));
        }
    }

    /**
     * Constructor
     */
    Pool() {
        init(1);
    }

    /**
     * Parametrized constructor
     * @param nelems initial size of the pool
     * @param object initial value of the objects in the pool
     */
    Pool(int nelems, T object) {
        init(nelems, object);
    }

    /**
     * Parametrized constructor
     * @param nelems initial size of the pool
     */
    Pool(int nelems) {
        init(nelems);
    }

    /**
     * Copy constructor
     */
    Pool(Pool p) {
        copy(p);
    }

    /**
     * Allocate a pointer to a free 'new' object.
     * @return pointer to the object
     */
    T get() {
        if (free.size() != 0) {
            T result = (free.get(0));
            free.remove(free.get(0));
            return result;
        } else {
            T tmp; // = new T();
            created.add(0, null);
            return created.get(0);
        }
    }

    /**
     * Release a no more needed instance of a pooled object
     * @param item the no more needed instance of the object
     */
    void release(T item) {
        free.add(0, item);
    }
}
