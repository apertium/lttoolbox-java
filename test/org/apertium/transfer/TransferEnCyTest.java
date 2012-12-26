/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.transfer;

/**
 *
 * @author Jacob Nordfalk
 */
public class TransferEnCyTest extends TransferEoEnTest {
  {
    dir = "en-cy";
    tlx = "cy-en." + dir + ".t1x";
    outFile = "transferoutput-" + dir + ".t1x-malgranda.txt";
    t1xFile = folder + "apertium-" + tlx;
    binFile = folder + dir + ".t1x.bin";
  }
}