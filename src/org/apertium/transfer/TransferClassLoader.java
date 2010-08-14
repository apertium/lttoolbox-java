package org.apertium.transfer;

import static org.apertium.utils.IOUtils.openFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TransferClassLoader extends ClassLoader {

    public TransferClassLoader() {
        super(TransferClassLoader.class.getClassLoader());
    }

    @SuppressWarnings("unchecked")
    public Class loadClassFile(String filename) throws ClassNotFoundException, IOException {
        // System.err.println("filename = " + filename);
        /* The reason for the static import of openFile, when we could just
         * do new File(filename), is to allow for future code centered in IOUtils.
         * This code will help deal with issues of disparate path notations, specifically
         * in the case of running this Java code on a Windows installation that has
         * the C++ code running under cygwin.
         */
        File file = openFile(filename);
        InputStream input = new FileInputStream(file);
        byte data[] = new byte[(int) file.length()];
        input.read(data);
        input.close();
        return defineClass(null, data, 0, data.length);
    }

}
