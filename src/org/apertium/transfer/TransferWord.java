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

  @Override
  public String toString() {
    return source+"->"+target+"/"+queue_length;
  }

  public TransferWord(String src, String tgt, int queue) {
    source = src;
    target = tgt;
    queue_length = queue;
  }

  public String sl(ApertiumRE part) {
    if (part==null) return ""; // this can happen if an undefined attribute is used
    return part.match(source);
  }

  public String slNoQueue(ApertiumRE part) {
    if (part==null) return ""; // this can happen if an undefined attribute is used
    return part.match(source.substring(0, source.length() - queue_length));
  }

  public String tl(ApertiumRE part) {
    if (part==null) return ""; // this can happen if an undefined attribute is used
    return part.match(target);
  }

  public String tlNoQueue(ApertiumRE part) {
    if (part==null) return ""; // this can happen if an undefined attribute is used
    return part.match(target.substring(0, target.length() - queue_length));
  }


  public void slSet(ApertiumRE part, String value)
  {
    if (part==null) return; // this can happen if an undefined attribute is used
    source = part.replace(source, value);
  }


  public void slSetNoQueue(ApertiumRE part, String value)
  {
    if (part==null) return; // this can happen if an undefined attribute is used
    String mystring = source.substring(0, source.length() - queue_length);
    mystring = part.replace(mystring, value);
    source = mystring + source.substring(source.length() - queue_length);
  }


  public void tlSet(ApertiumRE part, String value)
  {
    if (part==null) return; // this can happen if an undefined attribute is used
    target = part.replace(target, value);
  }


  public void tlSetNoQueue(ApertiumRE part, String value)
  {
    if (part==null) return; // this can happen if an undefined attribute is used
    String mystring = target.substring(0, target.length() - queue_length);
    mystring = part.replace(mystring, value);
    target = mystring + target.substring(target.length() - queue_length);
  }



  /**
   * The C code correspodants - not used anymore
   */
  public String source(ApertiumRE part, boolean with_queue)
  {
    if(with_queue)
    {
      return sl(part);
    }
    else
    {
      return slNoQueue(part);
    }
  }

  public String target(ApertiumRE part, boolean with_queue)
  {
    if(with_queue)
    {
      return tl(part);
    }
    else
    {
      return tlNoQueue(part);
    }
  }


  public void setSource(ApertiumRE part, String value, boolean with_queue)
  {
    if(with_queue)
    {
      slSet(part, value);
    }
    else
    {
      slSetNoQueue(part, value);
    }
  }

  public void setTarget(ApertiumRE part, String value, boolean with_queue)
  {
    if(with_queue)
    {
      tlSet(part, value);
    }
    else
    {
      tlSetNoQueue(part, value);
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
