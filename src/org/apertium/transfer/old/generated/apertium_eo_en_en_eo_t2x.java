package org.apertium.transfer.old.generated;
import java.io.*;
import org.apertium.transfer.*;
import org.apertium.transfer.generated.GeneratedTransferBase;
import org.apertium.interchunk.InterchunkWord;
public class apertium_eo_en_en_eo_t2x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return false;
	}
	ApertiumRE attr_a_chunk = new ApertiumRE("<S(?:Adj|N|V)>");
	ApertiumRE attr_gen = new ApertiumRE("<(?:mf|nt|GD|GN|f|m)>");
	ApertiumRE attr_nbr = new ApertiumRE("<(?:sg|pl|sp|ND)>");
	ApertiumRE attr_cas = new ApertiumRE("<(?:nom|acc)>");
	ApertiumRE attr_a_tns = new ApertiumRE("<(?:pres|subs|pprs|past|pri|imp|inf|cni|ger|fti|pp)>");
	ApertiumRE attr_lem = new ApertiumRE("(([^<]|\"\\<\")+)");
	ApertiumRE attr_lemq = new ApertiumRE("\\#[- _][^<]+");
	ApertiumRE attr_lemh = new ApertiumRE("(([^<#]|\"\\<\"|\"\\#\")+)");
	ApertiumRE attr_whole = new ApertiumRE("(.+)");
	ApertiumRE attr_tags = new ApertiumRE("((<[^>]+>)+)");
	ApertiumRE attr_chname = new ApertiumRE("(\\{([^/]+)\\/)");
	ApertiumRE attr_chcontent = new ApertiumRE("(\\{.+)");
	ApertiumRE attr_content = new ApertiumRE("(\\{.+)");
	String var_numero = "";
	String var_genere = "";
	
	/**  En SN SV SAdj atribuas al SAdj la nombron: Tiun de SV, se difinita, aŭ tiun de SN, se difinita  kaj al SV, se ne difinita, la nombron de SN, se difinita, aŭ tiun de SAdj, se difinita  */
	private void macro_set_nbr3(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("macro_set_nbr3",  word1, blank1,  word2, blank2,  word3); } 
		/**  Atribuo de SAdj  */
		if ((word2.tl(attr_nbr).equals("<sg>")
    || word2.tl(attr_nbr).equals("<pl>")))
		{
			word3.tlSet(attr_nbr, word2.tl(attr_nbr));
		}
		else
		if ((word1.tl(attr_nbr).equals("<sg>")
    || word1.tl(attr_nbr).equals("<pl>")))
		{
			word3.tlSet(attr_nbr, word1.tl(attr_nbr));
		}
		/**  Atribuo de SV  */
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			if ((word1.tl(attr_nbr).equals("<sg>")
    || word1.tl(attr_nbr).equals("<pl>")))
			{
				word2.tlSet(attr_nbr, word1.tl(attr_nbr));
			}
			else
			if ((word3.tl(attr_nbr).equals("<sg>")
    || word3.tl(attr_nbr).equals("<pl>")))
			{
				word2.tlSet(attr_nbr, word3.tl(attr_nbr));
			}
		}
	}
	
	private void macro_set_tns(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_tns",  word1); } 
		if (word1.tl(attr_a_tns).equals("<inf>"))
		{
			word1.tlSet(attr_a_tns, "<pres>");
		}
		else
		if (word1.tl(attr_a_tns).equals("<pp>"))
		{
			word1.tlSet(attr_a_tns, "<past>");
		}
	}
	
	// REGLA: SN
	public void rule0__SN(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule0__SN",  word1); } 
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	/** 
    <b pos="1"/>
          <chunk>
            <clip pos="1" part="lem"/>
            <clip pos="1" part="tags"/>
      <get-case-from pos="2">
              <clip pos="1" part="chcontent"/>
      </get-case-from>
          </chunk>
 For questions "is the cat big?"  */
	// REGLA: Adv do SN SV - how did you work - kiel vi laboris
	public void rule1__Adv_aux_SN_aux_konstatovorto__vbdoSV__SN__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule1__Adv_aux_SN_aux_konstatovorto__vbdoSV__SN__SV",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		out.append(blank2);
		{
			String myword = 
			         word3.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank3);
		out.append('^');
		out.append(word4.tl(attr_lem));
		out.append("<SV><fArU>");
		out.append(word2.tl(attr_a_tns));
		out.append(word4.tl(attr_chcontent));
		out.append('$');
	}
	
	// REGLA: do SN SV - do you know the cat?
	public void rule2__vbdoSV__SN__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule2__vbdoSV__SN__SV",  word1, blank1,  word2, blank2,  word3); } 
		out.append("^ĉu<adv><itg>{^");
		out.append(TransferWord.copycase(word1.sl(attr_lem), "ĉu"));
		out.append("<adv><itg>$}$");
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		{
			String myword = 
			         word3.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// REGLA: Adv SV SN SN
	public void rule3__Adv_CA__SVall__SN__SN(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule3__Adv_CA__SVall__SN__SN",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		{
			String myword = 
			         word3.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank3);
		{
			String myword = 
			         word4.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	/**  ONTE: SNSubj, sed pli komplike  */
	// REGLA: SN SVcop SAdjGer - they are tall -> ili estas altaJ; they are living -> ili estas vivantaJ
	public void rule4__SN__SVcop__SAdjGer(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule4__SN__SVcop__SAdjGer",  word1, blank1,  word2, blank2,  word3); } 
		macro_set_nbr3(out, word1, blank1, word2, blank2, word3);
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		{
			String myword = 
			         word3.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("^<SN SVcop SAdjGer>$");
	}
	
	// REGLA: SN SV SN - akuzativo
	public void rule5__SNsubj__SV__SN_SAdj(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule5__SNsubj__SV__SN_SAdj",  word1, blank1,  word2, blank2,  word3); } 
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append(word3.tl(attr_a_chunk));
		out.append(word3.tl(attr_gen));
		out.append(word3.tl(attr_nbr));
		out.append("<acc>");
		out.append(word3.tl(attr_chcontent));
		out.append("$^<SN SV SN>$");
	}
	
	// REGLA: SN SVcop SVger SN - akuzativo
	public void rule6__SNsubj__SVcop__SVger__SN_SAdj(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule6__SNsubj__SVcop__SVger__SN_SAdj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_set_nbr3(out, word1, blank2, word3, " ", word1);
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		{
			String myword = 
			         word3.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank3);
		out.append('^');
		out.append(word4.tl(attr_lem));
		out.append(word4.tl(attr_a_chunk));
		out.append(word4.tl(attr_gen));
		out.append(word4.tl(attr_nbr));
		out.append("<acc>");
		out.append(word4.tl(attr_chcontent));
		out.append("$^<SN SVcop SVger SN>$");
	}
	
	// REGLA: SN SVcop SVcopger SAdj - nombro
	public void rule7__SNsubj__SVcop__SVcopger__SAdj(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule7__SNsubj__SVcop__SVcopger__SAdj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_set_nbr3(out, word1, blank2, word3, blank3, word4);
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		{
			String myword = 
			         word3.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank3);
		{
			String myword = 
			         word4.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("^<SN SVcop SVcopger SAdj>$");
	}
	
	// REGLA: SN Adv SV SN - akuzativo + eventuala ŝanĝo de tenso en SV
	public void rule8__SNsubj__Adv__SV__SN_SAdj(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule8__SNsubj__Adv__SV__SN_SAdj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_set_tns(out, word3);
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		{
			String myword = 
			         word3.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank3);
		out.append('^');
		out.append(word4.tl(attr_lem));
		out.append(word4.tl(attr_a_chunk));
		out.append(word4.tl(attr_gen));
		out.append(word4.tl(attr_nbr));
		out.append("<acc>");
		out.append(word4.tl(attr_chcontent));
		out.append("$^<SN Adv SV SN>$");
	}
	
	// REGLA: SNpers Adv SV - eventuala ŝanĝo de tenso en SV
	public void rule9__SNpers__Adv__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule9__SNpers__Adv__SV",  word1, blank1,  word2, blank2,  word3); } 
		macro_set_tns(out, word3);
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		{
			String myword = 
			         word3.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("^<SN Adv SV>$");
	}
	
	// REGLA: SV SN - akuzativo
	public void rule10__SV__SN_SAdj(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2) throws IOException
	{
		if (debug) { logCall("rule10__SV__SN_SAdj",  word1, blank1,  word2); } 
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append(word2.tl(attr_a_chunk));
		out.append(word2.tl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append("<acc>");
		out.append(word2.tl(attr_chcontent));
		out.append('$');
	}
	
	// REGLA: SV Adv SN - akuzativo
	public void rule11__SV__Adv__SN_SAdj(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule11__SV__Adv__SN_SAdj",  word1, blank1,  word2, blank2,  word3); } 
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append(word3.tl(attr_a_chunk));
		out.append(word3.tl(attr_gen));
		out.append(word3.tl(attr_nbr));
		out.append("<acc>");
		out.append(word3.tl(attr_chcontent));
		out.append('$');
	}
	
	/**  Ni kolektas tion ĉi en UNU SN en dosiero: antaux_t2x
    <rule comment="REGLA: SN SV SN SNcoo SN">
      <pattern>
        <pattern-item n="SN"/>
        <pattern-item n="SV"/>
        <pattern-item n="SN"/>
        <pattern-item n="SNcoo"/>
        <pattern-item n="SN"/>
      </pattern>
      <action>
        <out>
          <chunk>
            <clip pos="1" part="lem"/>
            <clip pos="1" part="tags"/>
            <clip pos="1" part="chcontent"/>
          </chunk>
    <b pos="1"/>
          <chunk>
            <clip pos="2" part="whole"/>
          </chunk>
    <b pos="2"/>
          <chunk>
            <clip pos="3" part="lem"/>
             <clip pos="3" part="a_chunk"/>
             <clip pos="3" part="gen"/>
             <clip pos="3" part="nbr"/>
           <lit-tag v="acc"/>
            <clip pos="3" part="chcontent"/>
          </chunk>
    <b pos="3"/>
          <chunk>
            <clip pos="4" part="whole"/>
          </chunk>
    <b pos="4"/>
          <chunk>
            <clip pos="5" part="lem"/>
             <clip pos="5" part="a_chunk"/>
             <clip pos="5" part="gen"/>
             <clip pos="5" part="nbr"/>
           <lit-tag v="acc"/>
            <clip pos="5" part="chcontent"/>
          </chunk>
        </out>
      </action>
    </rule>

    <rule comment="REGLA: SN SV SN CC SN SV">
      <pattern>
        <pattern-item n="SN"/>
        <pattern-item n="SV"/>
        <pattern-item n="SN"/>
        <pattern-item n="CC"/>
        <pattern-item n="SN"/>
        <pattern-item n="SV"/>
      </pattern>
      <action>
        <out>
          <chunk>
            <clip pos="1" part="whole"/>
          </chunk>
    <b pos="1"/>
          <chunk>
            <clip pos="2" part="whole"/>
          </chunk>
    <b pos="2"/>
          <chunk>
            <clip pos="3" part="lem"/>
             <clip pos="3" part="a_chunk"/>
             <clip pos="3" part="gen"/>
             <clip pos="3" part="nbr"/>
             <lit-tag v="acc"/>
            <clip pos="3" part="chcontent"/>
          </chunk>
    <b pos="3"/>
          <chunk>
            <clip pos="4" part="whole"/>
          </chunk>
    <b pos="4"/>
          <chunk>
            <clip pos="5" part="lem"/>
             <clip pos="5" part="a_chunk"/>
             <clip pos="5" part="gen"/>
             <clip pos="5" part="nbr"/>
             <lit-tag v="acc"/>
            <clip pos="5" part="chcontent"/>
          </chunk>
    <b pos="5"/>
          <chunk>
            <clip pos="6" part="lem"/>
            <clip pos="6" part="tags"/>
            <clip pos="6" part="chcontent"/>
          </chunk>
        </out>
      </action>
    </rule>
 */
	// REGLA: SN SV SN CC SN Adv - akuzativo
	public void rule12__SN__SV__SN__CC__SN__Adv_CA(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5, String blank5, InterchunkWord word6) throws IOException
	{
		if (debug) { logCall("rule12__SN__SV__SN__CC__SN__Adv_CA",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		{
			String myword = 
			         word1.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append(word3.tl(attr_a_chunk));
		out.append(word3.tl(attr_gen));
		out.append(word3.tl(attr_nbr));
		out.append("<acc>");
		out.append(word3.tl(attr_chcontent));
		out.append('$');
		out.append(blank3);
		{
			String myword = 
			         word4.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank4);
		out.append('^');
		out.append(word5.tl(attr_lem));
		out.append(word5.tl(attr_a_chunk));
		out.append(word5.tl(attr_gen));
		out.append(word5.tl(attr_nbr));
		out.append("<acc>");
		out.append(word5.tl(attr_chcontent));
		out.append('$');
		out.append(blank5);
		{
			String myword = 
			         word6.tl(attr_lem)
			         +word6.tl(attr_tags)
			         +word6.tl(attr_chcontent)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
}
