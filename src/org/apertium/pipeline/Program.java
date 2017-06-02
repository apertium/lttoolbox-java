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
package org.apertium.pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Stephen Tigner
 *
 */
public class Program {
  public enum ProgEnum {
    LT_PROC, TAGGER, PRETRANSFER, TRANSFER, INTERCHUNK, POSTCHUNK,
    TXT_DEFORMAT, TXT_REFORMAT, OMEGAT_DEFORMAT, OMEGAT_REFORMAT, UNKNOWN
  }

  //Each program has a "name" which is a command line.
  private String _commandName;
  private String _fullPath;
  private final ProgEnum _program;
  //Each program also has a list of files, which are used, in order.
  private String _parameters_deprecated;
  private String[] _parameterArray;

  public Program(String commandLine) {
    ArrayList<String> list = splitCommandLineString(commandLine);
    int n = list.size();
    _parameterArray = list.subList(1, n).toArray(new String[n-1]);
    _fullPath = list.get(0);

    /* Split off the command name from the rest of the path, as the paths in
     * mode files are absolute unix paths and will fail in cygwin, as Java
     * doesn't run in the cygwin filesystem.
     * Running the executables w/o a path prefix will work in Windows with
     * cygwin, provided that the user has the cygwin bin dir in their path.
     */
    String[] commandPathList = _fullPath.split("\\/");
    //Grab the last entry
    _commandName = commandPathList[commandPathList.length - 1];

    String[] paramList = commandLine.split(" ", 2); // deprecated june 2017 - remove in 2019
    if (paramList.length > 1) {
      _parameters_deprecated = paramList[1];
    } else {
      _parameters_deprecated = "";
    }

    if (_commandName.equals("lt-proc")) {
      _program = ProgEnum.LT_PROC;
    } else if (_commandName.matches("^apertium-tagger(-j)?$")) {
      _program = ProgEnum.TAGGER;
    } else if (_commandName.matches("^apertium-pretransfer(-j)?$")) {
      _program = ProgEnum.PRETRANSFER;
    } else if (_commandName.matches("^apertium-transfer(-j)?$")) {
      _program = ProgEnum.TRANSFER;
    } else if (_commandName.matches("^apertium-interchunk(-j)?$")) {
      _program = ProgEnum.INTERCHUNK;
    } else if (_commandName.matches("^apertium-postchunk(-j)?$")) {
      _program = ProgEnum.POSTCHUNK;
    } else if (_commandName.matches("^apertium-destxt(-j)?$")) {
      _program = ProgEnum.TXT_DEFORMAT;
    } else if (_commandName.matches("^apertium-retxt(-j)?$")) {
      _program = ProgEnum.TXT_REFORMAT;
    } else if (_commandName.matches("^apertium-desomegat(-j)?$")) {
      _program = ProgEnum.OMEGAT_DEFORMAT;
    } else if (_commandName.matches("^apertium-reomegat(-j)?$")) {
      _program = ProgEnum.OMEGAT_REFORMAT;
    } else {
      _program = ProgEnum.UNKNOWN;
    }
  }

  public String getCommandName() {
    return _commandName;
  }

  public String getFullPath() {
    return _fullPath;
  }

  public ProgEnum getProgram() {
    return _program;
  }

  /**
   * Allows for all the filename strings to be retrieved at once.
   * @deprecated You will have to take quotation and spaces in path names yourself if you use this method.
   * @return A copy of the internal list of parameters.
   */
  public String getParameters() {
    return _parameters_deprecated;
  }

  /**
   * Returns the list of parameters. Spaces in path names are allowed and quotation have been removed.
   * @return A copy of the internal list of parameters.
   */
  public String[] getParameterArray() {
    return _parameterArray;
  }

  @Override
  public String toString() {
    /* StringBuilder tempString = new StringBuilder();
     * tempString.append("{Program -- " + _commandName + " (" +
     * _program.toString() + "): \n");
     * tempString.append("Parameters: " + _parameters + " }");
     * return tempString.toString(); */
    return _commandName + " " + _parameters_deprecated;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 23 * hash + (this._program != null ? this._program.hashCode() : 0);
    hash = 23 * hash + (this._parameters_deprecated != null ? this._parameters_deprecated.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Program other = (Program) obj;
    if (this._program != other._program) {
      return false;
    }
    if ((this._parameters_deprecated == null) ? (other._parameters_deprecated != null) : !this._parameters_deprecated.equals(other._parameters_deprecated)) {
      return false;
    }
    return true;
  }

  private static Pattern commandLineParameterRegex = Pattern.compile("'([^']*)'|\"([^\"]*)\"|(\\S+)");
  /**
   * Utility method for splitting a (mode) command line into its parts, taking quoted spaces into account and removing quotes
   * Source: https://stackoverflow.com/questions/3366281/tokenizing-a-string-but-ignoring-delimiters-within-quotes
   * @param commandLine
   * @return
   */
  public static ArrayList<String> splitCommandLineString(String commandLine) {
    ArrayList<String> list = new ArrayList<String>();

    Matcher m = commandLineParameterRegex.matcher(commandLine);
    while (m.find()) {
      int n=0;
      String str;
      do str = m.group(++n); while (str==null);
      list.add(str);
    }
    return list;
  }

  public static void main(String[] args) {
    System.out.println(splitCommandLineString("a b c"));
    System.out.println(splitCommandLineString("  user   123712378 suspend \"They are 'bad guys'\" 'bad guys'  "));
  }
}
