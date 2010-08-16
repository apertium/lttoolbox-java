package org.apertium.transfer;

import static org.apertium.utils.IOUtils.openFile;
import static org.apertium.utils.IOUtils.getFilenameMinusExtension;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.apertium.transfer.compile.ApertiumTransferCompile;
import org.apertium.transfer.compile.ParseTransferFile;
import org.xml.sax.SAXException;

public class TransferClassLoader extends ClassLoader {

    public TransferClassLoader() {
        super(TransferClassLoader.class.getClassLoader());
    }

    public Class loadClassFile(String filename) throws ClassNotFoundException, IOException {
        return loadClassFile(openFile(filename));
    }
    
    @SuppressWarnings("unchecked")
    public Class loadClassFile(File classFile) throws ClassNotFoundException, IOException {
        // System.err.println("filename = " + filename);
        /* The reason for the static import of openFile, when we could just
         * do new File(filename), is to allow for future code centered in IOUtils.
         * This code will help deal with issues of disparate path notations, specifically
         * in the case of running this Java code on a Windows installation that has
         * the C++ code running under cygwin.
         */
        InputStream input = new FileInputStream(classFile);
        byte data[] = new byte[(int) classFile.length()];
        input.read(data);
        input.close();
        return defineClass(null, data, 0, data.length);
    }

    public static Class loadTxClass(File txFile, File binFile) 
            throws ClassNotFoundException, IOException {
        return loadTxClass(txFile, binFile, new TransferClassLoader());
    }

    
    public static Class loadTxClass(File txFile, File binFile, TransferClassLoader tcl)
            throws ClassNotFoundException, IOException {
        if (!txFile.exists()) {
            throw new FileNotFoundException("Loading TX Class txFile ("
                    + txFile + ")");
        }
        if (!binFile.exists()) {
            throw new FileNotFoundException("Loading TX Class binFile ("
                    + txFile + ")");
        }

        if (txFile.getName().endsWith(".class") && txFile.exists()) {
            return tcl.loadClassFile(txFile);
        } else {
            return buildAndLoadClass(txFile, binFile, tcl);
        }
    }

    private static Class buildAndLoadClass(File txFile, File binFile,
            TransferClassLoader tcl) throws ClassNotFoundException, IOException {
        String baseTxFilename = getFilenameMinusExtension(txFile.getName());
        String baseBinFilename = getFilenameMinusExtension(binFile.getName());
        String classFilename = baseBinFilename + ".class";

        File tempDir = openFile(System.getProperty("java.io.tmpdir"));

        File classFile = openFile(binFile.getParent() + classFilename);
        // If it doesn't exist in the binFile directory, try the temp directory
        if (!classFile.exists()) {
            classFile = openFile(tempDir + classFilename);
        }
        // If it doesn't exist there either, switch back to the binFile
        // directory
        if (!classFile.exists()) {
            openFile(binFile.getParent() + classFilename);
        }

        // If the class file exists already, try and load it.
        if (classFile.exists()) {
            return tcl.loadClassFile(classFile);
        }

        // Generate the java source.
        ParseTransferFile p = new ParseTransferFile();
        try {
            p.parse(txFile.getPath());
        } catch (ParserConfigurationException e) {
            throw new InternalError("TX File (" + txFile
                    + ") parsing failed -- " + e.getLocalizedMessage());
        } catch (SAXException e) {
            throw new InternalError("TX File (" + txFile
                    + ") parsing failed -- " + e.getLocalizedMessage());
        }

        File javaSource = openFile(binFile.getParent() + p.className + ".java");
        File outputClass = openFile(binFile.getParent() + p.className
                + ".class");

        // Write the source out to a file
        FileWriter fw = null;
        try {
            fw = new FileWriter(javaSource);
        } catch (IOException e) { //Unable to open output file for writing
            javaSource = openFile(tempDir + p.className + ".java");
            outputClass = openFile(tempDir + p.className + ".class");
            fw = new FileWriter(javaSource);
        }
        fw.append(p.getOptimizedJavaCode());
        fw.close();

        // Compile the source file
        ApertiumTransferCompile.doMain(txFile, classFile, javaSource,
                outputClass, false);

        // Load and return the class file.
        return tcl.loadClassFile(classFile);
    }
}
