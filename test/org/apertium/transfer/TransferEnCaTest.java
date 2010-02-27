/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Jacob Nordfalk
 */
public class TransferEnCaTest extends TransferEoEnTest {

  {
    dir = "en-ca";
    tlx = "en-ca."+dir+".t1x";
    outFile = "transferoutput-"+dir+".t1x-malgranda.txt";
    t1xFile = folder+"apertium-"+tlx;
    binFile = folder+dir+".t1x.bin";
  }

}