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
package org.apertium.transfer.old.compile;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * @author Stephen Tigner
 *
 */
public class InternalTransferCompile extends BaseTransferCompile {
  /**
   * Calls the internal Java compilation interface, instead of using exec.
   *
   * @param input -- stdin InputStream for compilation process,
   * may be <code>null</code>
   * @param output -- stdout OutputStream for compilation process,
   * may be <code>null</code>
   * @param errOutput -- stderr OutputStream for compilation process,
   * may be <code>null</code>
   * @param args -- Arguments to pass to the java compiler
   * @return An int representing the return value of the compiler, typically
   * with 0 meaning success, and any other value meaning failure.
   * (This method returns -1 if the runtime system does not have an internal
   * Java compiler available.)
   * @throws UnsupportedEncodingException
   */
  public int compile(InputStream input, OutputStream output, OutputStream errOutput,
      File classPath, File javaFile) {
    //Default to stdin/out/err if not specified
    if (input == null) {
      input = System.in;
    }
    if (output == null) {
      output = System.out;
    }
    if (errOutput == null) {
      errOutput = System.err;
    }

    try {
      JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
      if (compiler == null) { //There is no system Java compiler available
        return -1;
      }

      String[] args = {"-cp", classPath.getPath(), javaFile.getPath()};

      return compiler.run(input, output, errOutput, args);
    } catch (Throwable t) {
      // no matter what error turns up this means we will have to try another compilation method!
      return -1;
    }
  }
}
