package org.apertium.transfer;

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
          //System.err.println("filename = " + filename);
          File file = new File(filename);
            InputStream input = new FileInputStream(file);
            byte data[] = new byte[(int) file.length()];
            input.read(data);
            input.close();
            return defineClass(null, data, 0, data.length);
    }

}
