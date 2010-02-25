/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer;

/**
 *
 * @author Jacob Nordfalk
 */
public class TransferWord {
  public String source;
  public String target;
  int queue_length;

  public String toString() {
    return source+"->"+target+"/"+queue_length;
  }

  public TransferWord(String src, String tgt, int queue) {
    source = src;
    target = tgt;
    queue_length = queue;
  }

  public String source(ApertiumRE part, boolean with_queue)
  {
    if (part==null) return ""; // this can happen if an undefined attribute is used
    if(with_queue)
    {
      return part.match(source);
    }
    else
    {
      return part.match(source.substring(0, source.length() - queue_length));
    }
  }

  public String target(ApertiumRE part, boolean with_queue)
  {
    if (part==null) return ""; // this can happen if an undefined attribute is used
    if(with_queue)
    {
      return part.match(target);
    }
    else
    {
      return part.match(target.substring(0, target.length() - queue_length));
    }
  }

  public void setSource(ApertiumRE part, String value, boolean with_queue)
  {
    if (part==null) return; // this can happen if an undefined attribute is used
    if(with_queue)
    {
      source = part.replace(source, value);
    }
    else
    {
      String mystring = source.substring(0, source.length() - queue_length);
      mystring = part.replace(mystring, value);
      source = mystring + source.substring(source.length() - queue_length);
    }
  }

  public void setTarget(ApertiumRE part, String value, boolean with_queue)
  {
    if (part==null) return; // this can happen if an undefined attribute is used
    if(with_queue)
    {
      target = part.replace(target, value);
    }
    else
    {
      String mystring = target.substring(0, target.length() - queue_length);
      mystring = part.replace(mystring, value);
      target = mystring + target.substring(target.length() - queue_length);
    }
  }


  public static String copycase(String s_word, String t_word) {
    // These 2 checks are needed to support buggy tranfer files
    if (s_word.length()==0) return t_word;
    if (t_word.length()==0) return t_word;

    String result;
    boolean firstupper = Character.isUpperCase(s_word.charAt(0));
    boolean uppercase = firstupper && Character.isUpperCase(s_word.charAt(s_word.length()-1));
    boolean sizeone = s_word.length() == 1;

    if(!uppercase || (sizeone && uppercase))
    {
      result = Character.toLowerCase(t_word.charAt(0)) + t_word.substring(1);
      //result = StringUtils::tolower(t_word);
    }
    else
    {
      result = t_word.toUpperCase();
    }

    if(firstupper)
    {
      result = Character.toUpperCase(result.charAt(0)) + result.substring(1);
    }
    return result;
  }



  public static String caseOf(String s_word) {
    if (s_word.length()==0) return "aa";

    if(s_word.length()>1)
    {
      if (!Character.isUpperCase(s_word.charAt(0))) {
        return "aa";
      } else if (!Character.isUpperCase(s_word.charAt(s_word.length()-1))) {
        return "Aa";
      }
      return "AA";
    }
    else
    {
      if (!Character.isUpperCase(s_word.charAt(0))) {
        return "aa";
      }
      return "Aa";
    }
  }
}
