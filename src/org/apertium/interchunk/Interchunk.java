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

package org.apertium.interchunk;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.apertium.lttoolbox.Alphabet;
import org.apertium.transfer.ApertiumRE;
import org.apertium.transfer.MatchExe;
import org.apertium.transfer.MatchState;
import org.apertium.transfer.generated.GeneratedTransferBase;

/**
 * @author Stephen Tigner
 *
 */
public class Interchunk {
    
    /* This class is very similar to the Transfer class, so some code was just copied
     * straight over, with alot of commented-out code removed.
     */

    //Private members and methods
    private Alphabet alphabet;
    private String TRXReader__ANY_CHAR="<ANY_CHAR>";
    private String TRXReader__ANY_TAG="<ANY_TAG>";
    
    private MatchExe me; //Pointer in C++ version
    private MatchState ms;
    //private Map<String, ApertiumRE> attr_items;
    //private Map<String, String> variables;
    //private Map<String, Integer> macros;
    //private Map<String, Set<String>> lists;
    //private Map<String, Set<String>> listslow;

    //vector<xmlNode *> macro_map; -- not in Transfer
    private Method[] rule_map=null; //vector<xmlNode *> rule_map;
    //xmlDoc *doc; -- not in Transfer
    //xmlNode *root_element; -- not in Transfer

    private InterchunkWord[] word; //InterchunkWord **
    private String[] blank; //string **
    private int lword, lblank;
    //Buffer<TransferToken> input_buffer;
    ArrayList<String> tmpword; //vector<wstring *> tmpword;
    ArrayList<String> tmpblank; //vector<wstring *> tmpblank;

    private OutputStreamWriter output;
    private int any_char;
    private int any_tag;
    
    //xmlNode *lastrule;
    private int nwords;
    public GeneratedTransferBase transferObject;
    
    //map<xmlNode *, TransferInstr> evalStringCache;
    private boolean inword;
    private boolean null_flush;
    private boolean internal_null_flush;
    
    public static boolean DEBUG = false;

    /**
     * Copied from {@link org.apertium.transfer.Transfer#readData(InputStream)}
     * @param in
     * @throws IOException
     */
    public void readData(InputStream in) throws IOException {
        // symbols
        alphabet=Alphabet.read(in);
        any_char=alphabet.cast(TRXReader__ANY_CHAR);
        any_tag=alphabet.cast(TRXReader__ANY_TAG);
    
        // faster - let it read itself, thus no need to make a big hashmap
        me = new MatchExe(in, alphabet.size());
        ms = new MatchState(me);
    }

    /**
     * Copied from {@link org.apertium.transfer.Transfer#read(String, String, String)}
     * @param classFile
     * @param datafile
     * @param fstfile
     * @throws Exception
     */
    public void read(String classFile, String datafile, String fstfile) throws Exception {
        if (!classFile.endsWith(".class")) {
          System.err.println("Warning: " + classFile+ " should be a Java .class file. You probably got it wrong");
        }

        read(new MyClassLoader().loadClassFile(classFile), datafile, fstfile);
      }

    /**
     * Copied from {@link org.apertium.transfer.Transfer#read(Class, String, String)}
     * @param transferClass
     * @param datafile
     * @param fstfile
     * @throws Exception
     */
    public void read(Class transferClass, String datafile, String fstfile) throws Exception {

        InputStream is = new BufferedInputStream(new FileInputStream(datafile));
        readData(is);
        is.close();

        Method[] mets =  transferClass.getMethods();
        rule_map = new Method[mets.length];

        for (Method method : mets) {
          String name = method.getName();

          //System.err.println("n = " + name);
          if (!name.startsWith("rule")) continue;

          int number = Integer.parseInt(name.substring(4, name.indexOf('_',5)));
          rule_map[number] = method;

          if (DEBUG) System.err.println(method.getName()+"  - #words=" +method.getParameterTypes().length/2 );
        }

        transferObject = (GeneratedTransferBase) transferClass.newInstance();
        transferObject.debug = DEBUG;
        transferObject.init();

        if (fstfile!=null&&fstfile.length()>0) {
          readBil(fstfile);
        }
      }

}

/**
 * Copied from {@link org.apertium.transfer.Transfer}
 * @author Jacob Nordfalk
 *
 */
class MyClassLoader extends ClassLoader {


    public MyClassLoader() {
        super(MyClassLoader.class.getClassLoader());
    }

    
    @SuppressWarnings("unchecked")
    public Class loadClassFile(String filename) throws ClassNotFoundException, IOException {
          //System.err.println("filename = " + filename);
          File file = new File(filename);
            InputStream input = new FileInputStream(file);
            byte data[] = new byte[(int) file.length()];
            input.read(data);
            input.close();
            return defineClass(null, data, 0, data.length);
    }
}
