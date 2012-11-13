/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.utils;

import java.util.LinkedHashMap;

/**
 *
 * @author Jacob Nordfalk
 */
  public class Timing {
    public boolean logging = true;
    public Timing(String name) { this.name=name; }
    public String name;
    public long timing = System.nanoTime();
    public LinkedHashMap<String, Long> times = new LinkedHashMap<String,Long>();
    public  void log(String task) {
      long now = System.currentTimeMillis();
      long diff = now - timing;
      timing = now;
      if ("".equals(task)) {
        if (diff<100) return;
        new Exception("You reset the timer at a place where you shoud use it, diff="+diff).printStackTrace();
      }
      //System.err.println("diff = " + diff);
      Long sum = times.get(task);
      sum = sum==null? diff : diff+sum;
      times.put(task, sum);
      if (logging) System.err.println(name+" used " + ((diff/10)/100.0)+ " ms for "+task);
    }

    public void report() {
      System.err.println("---- timing report for "+name+" -----------");
      long total = 0;
      for (Long l : times.values()) total += l;
      for (String task : times.keySet()) {
        long time = times.get(task);
        System.err.println(name+" used " + ((1000*time/total)/10.0)+ " % time for "+task);
      }
      System.err.println(name+" took total " + ((total/10000)/100.0)+ " sec");
    }
  }
