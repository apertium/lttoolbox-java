package org.apertium.transfer.old.generated;
import java.io.*;
import org.apertium.transfer.*;
import org.apertium.transfer.generated.GeneratedTransferBase;
public class apertium_eo_en_en_eo_t1x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return true;
	}
	/**  TODO
 make a transfer rule saying  DET + ADJ  can be a SN:
  The first was an animated feature     and
  the second was a TV live action version.

 */
	ApertiumRE attr_a_nom = new ApertiumRE("<n(?:><acr><re|p><ant|p><cog|p><top|><acr|p><al|p|)>");
	ApertiumRE attr_a_acr = new ApertiumRE("<(?:acr><re|np><top|np><al|acr)>");
	ApertiumRE attr_a_any = new ApertiumRE("<n(?:p|)>");
	ApertiumRE attr_a_prp = new ApertiumRE("<pr>");
	ApertiumRE attr_a_adj = new ApertiumRE("<adj(?:><sint><comp|><sint><sup|><pst|><itg|><pos|)>");
	ApertiumRE attr_a_vrb = new ApertiumRE("<v(?:blex><sep|blex|bser|aux)>");
	ApertiumRE attr_a_det = new ApertiumRE("<det><(?:def|ind|pos|qnt|itg|qnt|dem)>");
	/**  Jacob added  */
	ApertiumRE attr_a_prn = new ApertiumRE("<prn(?:><subj|><ref|><itg|><obj|><tn|)>");
	ApertiumRE attr_a_prn__sen__subj_obj = new ApertiumRE("<prn(?:><ref|><itg|><tn|)>");
	ApertiumRE attr_a_tns = new ApertiumRE("<(?:pres|subs|pprs|past|pri|imp|inf|cni|ger|fti|pp)>");
	ApertiumRE attr_a_gen = new ApertiumRE("<(?:nt|mf|GD|m|f)>");
	ApertiumRE attr_a_prs = new ApertiumRE("<p(?:1|2|3)>");
	ApertiumRE attr_a_nbr = new ApertiumRE("<(?:sp|sg|pl|ND)>");
	ApertiumRE attr_a_cas = new ApertiumRE("<(?:nom|acc)>");
	/**  taken from en-es.t1x, for use in macro firstWord  */
	ApertiumRE attr_a_np_acr = new ApertiumRE("<(?:acr|np)>");
	ApertiumRE attr_lem = new ApertiumRE("(([^<]|\"\\<\")+)");
	ApertiumRE attr_lemq = new ApertiumRE("\\#[- _][^<]+");
	ApertiumRE attr_lemh = new ApertiumRE("(([^<#]|\"\\<\"|\"\\#\")+)");
	ApertiumRE attr_whole = new ApertiumRE("(.+)");
	ApertiumRE attr_tags = new ApertiumRE("((<[^>]+>)+)");
	ApertiumRE attr_chname = new ApertiumRE("(\\{([^/]+)\\/)");
	ApertiumRE attr_chcontent = new ApertiumRE("(\\{.+)");
	ApertiumRE attr_content = new ApertiumRE("(\\{.+)");
	/**  TODO
 make a transfer rule saying  DET + ADJ  can be a SN:
  The first was an animated feature     and
  the second was a TV live action version.

 */
	String var_numero = "";
	String var_temps = "";
	String var_adjectiu = "";
	/** - adjektivo - eble kun preadverbo (pli, plej)  */
	String var_preadv_added = "";
	/**  if a "more" or "most" was added before an adj  */
	String var_nomvar = "";
	String var_tmp1 = "";
	String var_tmp2 = "";
	String var_caseFirstWord = "";
	/**  macro firstWord  */
	String var_EOS = "false";
	/**  macro firstWord     <def-var n="EOS" v="true"/> macro firstWord  */
	String var_venontaVortoEstuMajuskla = "";
	/**  macro firstWord  */
	String var_tipus_verb = "";
	/**  taken from en-ca.t1x, for use in macro tipus_verbs  */
	String var_macro_tmp1 = "";
	/**  taken from en-ca.t1x, for use in macro "set_verbkonj2"  */
	String var_verbkonj = "";
	/**  taken from en-ca.t1x, for use in macro "set_verbkonj2"  */
	String var_chunk_name = "";
	/**  taken from en-ca.t1x, for use in macro "set_verbkonj2"  */
	String var_determiner = "";
	/** - determiner kun tag'oj kaj ebla spaco  */
	String var_blanko = "";
	/** - de "set_blankon_se_havas_formaton2"  */
	String var_and_or_but = "";
	String var_DEBUG = "";
	/**  TODO
 make a transfer rule saying  DET + ADJ  can be a SN:
  The first was an animated feature     and
  the second was a TV live action version.

  <list-item v="never"/>  */
	WordList list_adv_neg = new WordList(new String[] { "not", });
	/**  verboj ne postulantaj THAT  */
	WordList list_reportingverb = new WordList(new String[] { "say", "admit", "agree", "decide", "deny", "explain", "insist", "promise", "recommend", "suggest", "point", "think", "believe", "hope", "fear", "suppose", });
	/**  ne-transitivaj verboj.   */
	WordList list_netransitivaj = new WordList(new String[] { "be", "seem", "become", "appear", "there be", });
	/**  help verboj kiuj malaperos en Esperantp */
	WordList list_willwouldshallhave = new WordList(new String[] { "have", "will", "would", "shall", });
	WordList list_listo_and_or_but = new WordList(new String[] { "and", "but", "or", });
	
	/**  TODO
 make a transfer rule saying  DET + ADJ  can be a SN:
  The first was an animated feature     and
  the second was a TV live action version.

 ekzamenas la vorton kaj metas majuskligajn informojn en variablo "firstWord"  */
	private void macro_firstWord(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_firstWord",  word1); } 
		if (((var_EOS.equals("true")
    && word1.sl(attr_a_np_acr).equals(""))
    || var_venontaVortoEstuMajuskla.equals("true")))
		{
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
			var_caseFirstWord = "Aa";
		}
		else
		{
			var_caseFirstWord = "aa";
		}
		var_EOS = "false";
		var_venontaVortoEstuMajuskla = "false";
	}
	
	/**  kontrolas cxu la parametro estas konata vorto.
         Se jes "nomvar" := <nom>. Se ne nomvar="".
         Tio cxu estas por eviti ke nekonataj vortoj ricevos tag'on kiu poste estas montrata.  */
	private void macro_set_nomvar_if_known1(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_nomvar_if_known1",  word1); } 
		if (word1.tl(attr_a_nbr).equals(""))
		{
			var_nomvar = "";
		}
		else
		{
			var_nomvar = "<nom>";
		}
	}
	
	/**  Sxangxas la genron de vorto: Se la genro estas nekonata "GD" gxi estas sxangxata al vira genro  */
	private void macro_ordigu_genron(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_ordigu_genron",  word1); } 
		if (word1.tl(attr_a_gen).equalsIgnoreCase("<GD>"))
		{
			word1.tlSet(attr_a_gen, "<m>");
		}
	}
	
	/**  Sxangxas la numeron de vorto: Se la numero estas nekonata "sp" gxi estas sxangxata al singularo
    <def-macro n="ordigu_numeron1" npar="1">
      <choose>
        <when>
          <test>
            <equal caseless="yes"><clip pos="1" side="tl" part="a_nbr"/><lit-tag v="sp"/></equal>
          </test>
          <let><clip pos="1" side="tl" part="a_nbr"/><lit-tag v="sg"/></let>
        </when>
      </choose>
    </def-macro>
 atribuas "numero"  al "pl" se estas pluralo, kaj al "sg" alikaze  (ND, sp aux nekonata vorto sen numero-etikedo) */
	private void macro_set_numero1(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_numero1",  word1); } 
		if (word1.tl(attr_a_nbr).equals("<pl>"))
		{
			var_numero = "<pl>";
		}
		else
		{
			var_numero = "<sg>";
		}
	}
	
	/**  Tiu cxi makroo rigardas anglan adjektivon kaj la rilatan substantivon kaj poste
         adjectiu = ^pli<preadv>$ ^bona<adj>
         preadv_added = yes    */
	private void macro_set_adjectiu2(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_adjectiu2",  word1, blank1,  word2); } 
		macro_set_numero1(out, word2);
		var_adjectiu = "";
		var_preadv_added = "";
		if (word1.sl(attr_a_adj).equals("<adj><sint><comp>"))
		{
			/**  ^pli<preadv>$ ^bona<adj><2>$  */
			var_adjectiu = (""+TransferWord.copycase(word1.sl(attr_lem), "pli")+"<preadv>"+"$ ^"+word1.tl(attr_lem)+"<adj>"+var_numero+"<2>");
			var_preadv_added = "preadv_";
		}
		else
		if (word1.sl(attr_a_adj).equals("<adj><sint><sup>"))
		{
			/**  ^plej<preadv>$ ^bona<adj><2>$  */
			var_adjectiu = (""+TransferWord.copycase(word1.sl(attr_lem), "plej")+"<preadv>"+"$ ^"+word1.tl(attr_lem)+"<adj>"+var_numero+"<2>");
			var_preadv_added = "preadv_";
		}
		else
		if (word1.tl(attr_a_adj).equals("<adj>"))
		{
			/**  ^bona<adj><2>$  */
			var_adjectiu = (""+word1.tl(attr_lem)+"<adj>"+var_numero+"<2>");
		}
		else
		{
			/**  ^bona<adj><2>$  */
			var_adjectiu = (""+word1.tl(attr_lem)+"<adj>"+var_numero+"<2>");
		}
	}
	
	private void macro_set_tipus_verbs1(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_tipus_verbs1",  word1); } 
		if (list_netransitivaj.containsIgnoreCase(word1.sl(attr_lemh)))
		{
			var_tipus_verb = "<netransitiva>";
		}
		else
		if (list_reportingverb.containsIgnoreCase(word1.sl(attr_lemh)))
		{
			var_tipus_verb = "<reporting>";
		}
		/** 
        <when>
          <test>
            <or>
              <equal caseless="yes"><clip pos="1" side="sl" part="lemh"/><lit v="be"/></equal>
              <equal caseless="yes"><clip pos="1" side="sl" part="lemh"/><lit v="seem"/></equal>
            </or>
          </test>
          <let><var n="tipus_verb"/><lit-tag v="netransitiva2"/></let>
        </when>
        <when>
          <test>
            <or>
              <equal caseless="yes"><clip pos="1" side="sl" part="lemh"/><lit v="like"/></equal>
              <equal caseless="yes"><clip pos="1" side="tl" part="lemh"/><lit v="encantar"/></equal>
            </or>
          </test>
          <let><var n="tipus_verb"/><lit-tag v="like"/></let>
        </when>
        <when>
          <test>
            <or>
              <equal caseless="yes"><clip pos="1" side="sl" part="lem"/><lit v="be# sorry"/></equal>
              <equal caseless="yes"><clip pos="1" side="sl" part="lem"/><lit v="be# very sorry"/></equal>
            </or>
          </test>
          <let><var n="tipus_verb"/><lit-tag v="sorry"/></let>
        </when>
         */
		else
		{
			var_tipus_verb = "<aliaj>";
		}
	}
	
	/** konjugacias verbon konsistanta en helpverbo kaj nepersona formo (will come).
pos 1= do, will, shall aŭ would.
pos 2= nekonjugaciita verbo

La rezulto estas unu sola leksika formo (venos):
verbfinal = pensi<vblex><pres>
  */
	private void macro_set_verbkonj2_do(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_verbkonj2_do",  word1, blank1,  word2); } 
		if ((word1.sl(attr_a_tns).equals("<pres>")
    || word1.sl(attr_a_tns).equals("<inf>")))
		{
			var_macro_tmp1 = "<pres>";
		}
		else
		if (word1.sl(attr_a_tns).equals("<past>"))
		{
			var_macro_tmp1 = "<past>";
		}
		else
		{
			var_macro_tmp1 = (""+"<ERROR1_>"+word1.sl(attr_a_tns));
		}
		var_verbkonj = (""+word2.tl(attr_lemh)+word2.tl(attr_a_vrb)+var_macro_tmp1+word2.tl(attr_lemq));
	}
	
	private void macro_set_verbkonj2_willShallWould(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_verbkonj2_willShallWould",  word1, blank1,  word2); } 
		if ((word1.sl(attr_lem).equalsIgnoreCase("will")
    || word1.sl(attr_lem).equalsIgnoreCase("shall")))
		{
			var_macro_tmp1 = "<fti>";
		}
		else
		if (word1.sl(attr_lem).equalsIgnoreCase("would"))
		{
			var_macro_tmp1 = "<cni>";
		}
		else
		{
			var_macro_tmp1 = (""+"<ERROR2_>"+word1.sl(attr_a_tns));
		}
		var_verbkonj = (""+word2.tl(attr_lemh)+word2.tl(attr_a_vrb)+var_macro_tmp1+word2.tl(attr_lemq));
	}
	
	private void macro_set_temps1(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_temps1",  word1); } 
		var_temps = "<UNKNOWN>";
		if ((word1.sl(attr_lem).equalsIgnoreCase("will")
    || word1.sl(attr_lem).equalsIgnoreCase("shall")))
		{
			var_temps = "<fti>";
		}
		else
		if (word1.sl(attr_lem).equalsIgnoreCase("would"))
		{
			var_temps = "<cni>";
		}
		else
		if (word1.sl(attr_lem).equalsIgnoreCase("have"))
		{
			var_temps = "<past>";
		}
	}
	
	/** 
      <when>
        <test>
          <equal caseless="yes"><clip pos="1" side="sl" part="lem"/><lit v="did"/></equal>
        </test>
        <let><var n="temps"/><lit-tag v="past"/></let>
      </when>
 Por rigardi, ĉu la blanko havas aŭ ne havas formaton.
     Tiu makroo estas necesa en la reguloj, en kiuj malaperas vorto por decidi,
     ĉu la blanko de la vorto devas esti forigita aŭ konservita.
     Se ĝi havas formaton, necesas konservi ĝin; se ne, indas viŝi,
     por ke ne aperu du sinsekvaj blankoj.

     Prenita de "f_bcond" apertium-en-es/apertium-en-es.es-en.t1x  */
	private void macro_sendu_blankon_se_havas_formaton2(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_sendu_blankon_se_havas_formaton2",  word1, blank1,  word2); } 
		if (!blank1.equals(" "))
		{
			out.append(blank1);
		}
	}
	
	/** 
            <chunk name="sendu_blankon_se_havas_formaton">
              <tags><tag><lit-tag v="xx"/></tag></tags>
              <lu>
                <b pos="1"/>
              </lu>
            </chunk> Por rigardi, ĉu la blanko havas aŭ ne havas formaton.
     "blanko" havos valoron "" se estas nur blanko " ", kaj
     la enhavon de la blanko gxi enhavis ion alian.
  */
	private void macro_set_blankon_se_havas_formaton2(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_blankon_se_havas_formaton2",  word1, blank1,  word2); } 
		if (blank1.equals(" "))
		{
			var_blanko = "";
		}
		else
		{
			var_blanko = blank1;
		}
	}
	
	/** 
        <choose>
        <when>
          <test>
            <equal><clip pos="1" side="sl" part="lem"/><lit v="A"/></equal>
          </test>
          <let><var n="venontaVortoEstuMajuskla"/><lit v="true"/></let>
        </when>
        </choose>
          <let><var n="EOS"/><lit v="false"/></let>
 */
	private void macro_set_determiner3(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("macro_set_determiner3",  word1, blank1,  word2, blank2,  word3); } 
		if (word1.sl(attr_lem).equalsIgnoreCase("a"))
		{
			if (blank1.equals(" "))
			{
				var_determiner = "";
			}
			else
			{
				var_determiner = (""+blank1);
			}
		}
		else
		{
			/**  lemh por subteni "most of<det>"  */
			var_determiner = (""+"^"+word1.tl(attr_lemh)+word1.tl(attr_a_det)+word3.tl(attr_a_nbr)+"<2>"+word1.tl(attr_lemq)+"$"+blank1);
		}
	}
	
	private void macro_set_determiner_de_genitivo2(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_determiner_de_genitivo2",  word1, blank1,  word2); } 
		macro_set_numero1(out, word2);
		if (word1.sl(attr_lem).equalsIgnoreCase("a"))
		{
			var_determiner = "";
		}
		else
		{
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
			/**  lemh por subteni "most of<det>"  */
			var_determiner = (""+"^"+word1.tl(attr_lemh)+word1.tl(attr_a_det)+var_numero+"<nom>"+word1.tl(attr_lemq)+"$"+" ");
		}
	}
	
	/** 
    c="and or but povas esti komenco de demando, sed la aliaj cnjoo NE povas esti parto de demando:
    ekzemple:   and/or/but did they acquire any influence?   - demando
    ekzemple:   neither/nor did they acquire any influence   - konstato
    "  */
	private void macro_set_and_or_but(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_and_or_but",  word1); } 
		if (list_listo_and_or_but.containsIgnoreCase(word1.sl(attr_lem)))
		{
			var_and_or_but = "<and_or_but>";
		}
		else
		{
			var_and_or_but = "<konstato>";
		}
	}
	
	/**  TODO
 make a transfer rule saying  DET + ADJ  can be a SN:
  The first was an animated feature     and
  the second was a TV live action version.

 */
	// REGLA: prnref   - himself, themselves
	public void rule0__prnref(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule0__prnref",  word1); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prnref"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_whole));
		out.append("<2>$}$");
	}
	
	// REGLA: Prn
	public void rule1__prnaltres(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule1__prnaltres",  word1); } 
		macro_firstWord(out, word1);
		macro_set_numero1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prn"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_a_prn));
		out.append(var_numero);
		out.append("<2>$}$");
	}
	
	// REGLA: PrnPers
	public void rule2__prnpers(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule2__prnpers",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prnpers"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_whole));
		out.append("<2>$}$");
	}
	
	public void rule3__num(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule3__num",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num"));
		out.append("<SN><nom>{");
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
		out.append("}$");
	}
	
	// July 2 - 2a de julio
	public void rule4__monato__num_dato(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule4__monato__num_dato",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "dato"));
		out.append("<SN><nom>{^");
		out.append(word2.tl(attr_lem));
		out.append("a<num><ord>$ ^de<pr>$");
		out.append(blank1);
		out.append('^');
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_tags));
		out.append("<nom>$}$");
	}
	
	// July 2nd - 2a de julio
	public void rule5__monato__num_ord(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule5__monato__num_ord",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "dato"));
		out.append("<SN><nom>{^");
		out.append(word2.tl(attr_lem));
		out.append("<num><ord>$ ^de<pr>$");
		out.append(blank1);
		out.append('^');
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_tags));
		out.append("<nom>$}$");
	}
	
	// on July 2 - la 2an de julio
	public void rule6__on__monato__num_dato(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule6__on__monato__num_dato",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "dato"));
		out.append("<SN><nom>{^la<det><def><sp>$");
		out.append(blank1);
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append("an<num><ord>$ ^de<pr>$");
		out.append(blank2);
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append(word2.tl(attr_tags));
		out.append("<nom>$}$");
	}
	
	// on July 2nd - la 2a de julio
	public void rule7__on__monato__num_ord(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule7__on__monato__num_ord",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "dato"));
		out.append("<SN><nom>{^la<det><def><sp>$^");
		out.append(word3.tl(attr_lem));
		out.append("n<num><ord>$");
		out.append(blank1);
		out.append(" ^de<pr>$");
		out.append(blank2);
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append(word2.tl(attr_tags));
		out.append("<nom>$}$");
	}
	
	// REGLA NUM of      5 of => 5 el 
	public void rule8__num_sen_ord__of(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule8__num_sen_ord__of",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num"));
		out.append("<SN>{");
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
		out.append("}$");
		out.append(blank1);
		out.append("^pr<PREP>{^el<pr>$}$");
	}
	
	// REGLA NUM times NUM  5 times 8 => 5 oble 8 
	public void rule9__num_sen_ord__times__num_sen_ord(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule9__num_sen_ord__times__num_sen_ord",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num"));
		out.append("<SN>{");
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
		out.append("^oble<cnjadv>$");
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
		out.append("}$");
	}
	
	/** 
    <rule comment="REGLA NUM of the     5 of the => 5 el la ">
      <pattern>
        <pattern-item n="num"/>
        <pattern-item n="of"/>
        <pattern-item n="the"/>
      </pattern>
      <action>
        <call-macro n="firstWord"><with-param pos="1"/></call-macro>
        <out>
          <chunk name="num" case="caseFirstWord">
            <tags>
              <tag><lit-tag v="SN"/></tag>
            </tags>
            <lu>
              <clip pos="1" side="tl" part="whole"/>
            </lu>
          </chunk>
          <b pos="1"/>
          <chunk name="pr">
            <tags>
              <tag><lit-tag v="PREP"/></tag>
            </tags>
                <lu>
                  <lit v="el"/>
                  <lit-tag v="pr"/>
                </lu>
          </chunk>
          <b pos="2"/>
          <chunk name="det5">
            <tags>
              <tag><lit-tag v="SD"/></tag>
              <tag><lit-tag v="sp"/></tag>
            </tags>
                <lu>
                  <clip pos="3" side="tl" part="whole"/>
                </lu>
          </chunk>
        </out>
      </action>
    </rule>
 */
	// REGLA NUM time   5 times => 5 fojoj, 5th time => 5a fojo,   
	public void rule10__num__times(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule10__num__times",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num"));
		out.append("<SN><nom>{");
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
		out.append("^fojo<n>");
		out.append(word2.tl(attr_a_nbr));
		out.append("<nom>$}$");
	}
	
	// REGLA: DET:a  - the derminier 'a' should just be deleted. Having this rule makes it possible to avoid handling 'a' in all the other rules
	public void rule11__a(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule11__a",  word1); } 
		if (word1.sl(attr_lem).equals("A"))
		{
			var_venontaVortoEstuMajuskla = "true";
		}
		var_EOS = "false";
	}
	
	// REGLA: DET the, his, ... (alia ol 'a')
	public void rule12__det(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule12__det",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det"));
		out.append("<SD><nom>{^");
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_tags));
		out.append("<2>");
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	/**  Sintagmas nominales  */
	// REGLA: NOM
	public void rule13__nom(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule13__nom",  word1); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: more NOM, f.eks. 'more tea'  to 'Pli da teo'
	public void rule14__more__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule14__more__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "more_nom"));
		out.append("<SN><nom>{");
		/**  <lit-tag v="2"/> no, keep <nom>  */
		out.append('^');
		out.append(word1.tl(attr_whole));
		out.append("<nom>$");
		out.append(blank1);
		/**  <lit-tag v="2"/> no, keep <nom>  */
		out.append('^');
		out.append(word2.tl(attr_whole));
		out.append("<nom>$}$");
	}
	
	// REGLA: DET NOM
	public void rule15__det__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule15__det__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word2);
		macro_set_determiner3(out, word1, blank1, word2, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom"));
		out.append("<SN><nom>{");
		out.append(var_determiner);
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append(word2.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	/** 
    <rule comment="REGLA: DET NOM NOM (malnova)  la testo-firmaoj">
      <pattern>
        <pattern-item n="det"/>
        <pattern-item n="nom"/>
        <pattern-item n="nom"/>
      </pattern>
      <action>
        <call-macro n="firstWord"><with-param pos="1"/></call-macro>
        <call-macro n="ordigu_genron"><with-param pos="2"/></call-macro>
        <call-macro n="ordigu_genron"><with-param pos="3"/></call-macro>
            <out>
              <chunk name="det_nom_guio_nom" case="caseFirstWord">
                <tags>
                  <tag><lit-tag v="SN.nom"/></tag>
                </tags>
                <lu>
                  <clip pos="1" side="tl" part="lem"/>
                  <clip pos="1" side="tl" part="a_det"/>
                  <clip pos="3" side="tl" part="a_nbr"/>
                  <lit-tag v="2"/>
                </lu>
                <b pos="1"/>
                <lu>
                  <clip pos="2" side="tl" part="lem"/>
                  <clip pos="2" side="tl" part="tags"/>
                  <lit-tag v="nom"/>
                </lu>
                <lu>
                  <lit v="-"/>
                  <lit-tag v="guio"/>
                </lu>
                <*-*- <b pos="2"/> inserts a space. Could just ONE space be deleted and rest of the blank be inserted. Francis: not that i'm aware of -*-*>
                <lu>
                  <clip pos="3" side="tl" part="lem"/>
                  <clip pos="3" side="tl" part="tags"/>
                  <lit-tag v="2"/>
                </lu>
              </chunk>
            </out>
      </action>
    </rule>
 */
	// REGLA: DET NOM NOM (nova)  la testaj firmaoj
	public void rule16__det__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule16__det__nom__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word2);
		macro_ordigu_genron(out, word3);
		macro_set_determiner3(out, word1, blank1, word2, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_2nom"));
		out.append("<SN><nom>{");
		out.append(var_determiner);
		/**  se estas akronimo  */
		/**  se havas genron  */
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append("<adj>");
		out.append(word2.tl(attr_a_acr));
		out.append(word2.tl(attr_a_gen));
		out.append(word3.tl(attr_a_nbr));
		out.append("<2>$");
		out.append(blank2);
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append(word3.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: DET NOM NOM NOM 
	public void rule17__det__nom__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule17__det__nom__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word2);
		macro_ordigu_genron(out, word3);
		macro_ordigu_genron(out, word4);
		macro_set_determiner3(out, word1, blank1, word2, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_3nom"));
		out.append("<SN><nom>{");
		out.append(var_determiner);
		/**  se estas akronimo  */
		/**  se havas genron  */
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append("<adj>");
		out.append(word2.tl(attr_a_acr));
		out.append(word2.tl(attr_a_gen));
		out.append(word4.tl(attr_a_nbr));
		out.append("<2>$");
		out.append(blank2);
		/**  se estas akronimo  */
		/**  se havas genron  */
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append("<adj>");
		out.append(word3.tl(attr_a_acr));
		out.append(word3.tl(attr_a_gen));
		out.append(word4.tl(attr_a_nbr));
		out.append("<2>$");
		out.append(blank3);
		out.append('^');
		out.append(word4.tl(attr_lem));
		out.append(word4.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: DET NOM NOM NOM NOM
	public void rule18__det__nom__nom__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule18__det__nom__nom__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word2);
		macro_ordigu_genron(out, word3);
		macro_ordigu_genron(out, word4);
		macro_ordigu_genron(out, word5);
		macro_set_determiner3(out, word1, blank1, word2, blank4, word5);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_4nom"));
		out.append("<SN><nom>{");
		out.append(var_determiner);
		/**  se estas akronimo  */
		/**  se havas genron  */
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append("<adj>");
		out.append(word2.tl(attr_a_acr));
		out.append(word2.tl(attr_a_gen));
		out.append(word5.tl(attr_a_nbr));
		out.append("<2>$");
		out.append(blank2);
		/**  se estas akronimo  */
		/**  se havas genron  */
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append("<adj>");
		out.append(word3.tl(attr_a_acr));
		out.append(word3.tl(attr_a_gen));
		out.append(word5.tl(attr_a_nbr));
		out.append("<2>$");
		out.append(blank3);
		/**  se estas akronimo  */
		/**  se havas genron  */
		out.append('^');
		out.append(word4.tl(attr_lem));
		out.append("<adj>");
		out.append(word4.tl(attr_a_acr));
		out.append(word4.tl(attr_a_gen));
		out.append(word5.tl(attr_a_nbr));
		out.append("<2>$");
		out.append(blank4);
		out.append('^');
		out.append(word5.tl(attr_lem));
		out.append(word5.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: ADJ
	public void rule19__adj(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule19__adj",  word1); } 
		macro_firstWord(out, word1);
		macro_set_adjectiu2(out, word1, " ", word1);
		macro_ordigu_genron(out, word1);
		var_chunk_name = (""+"adj"+var_preadv_added);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_chunk_name));
		out.append("<SN><nom>{");
		{
			String myword = 
			         var_adjectiu
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
	}
	
	// REGLA: DET ADJ NOM
	public void rule20__det__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule20__det__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word3);
		macro_set_adjectiu2(out, word2, blank2, word3);
		macro_set_determiner3(out, word1, blank1, word2, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_preadv?_adj_nom"));
		out.append("<SN><nom>{");
		out.append(var_determiner);
		{
			String myword = 
			         var_adjectiu
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
		out.append(word3.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	/**  enmeti??
    <rule comment="REGLA: DET UNKNOWN/ADV/NUM NOM">
      <pattern>
        <pattern-item n="det"/>
        <pattern-item n="unknown_adv_num"/>
        <pattern-item n="nom_prnaltres"/>
      </pattern>
      <action>
        <call-macro n="firstWord"><with-param pos="1"/></call-macro>
        <call-macro n="ordigu_genron"><with-param pos="3"/></call-macro>
        <call-macro n="set_determiner3"><with-param pos="1"/><with-param pos="2"/><with-param pos="3"/></call-macro>

        <out>
        <chunk name="det_unknown_nom" case="caseFirstWord">
            <tags>
              <tag><lit-tag v="SN.nom"/></tag>
            </tags>
            <var n="determiner"/>
            <lu>
              <clip pos="2" side="tl" part="whole"/>
            </lu>
            <b pos="2"/>
            <lu>
              <clip pos="3" side="tl" part="lem"/>
              <clip pos="3" side="tl" part="tags"/>
              <lit-tag v="2"/>
            </lu>
          </chunk>
        </out>
      </action>
    </rule>
 */
	// REGLA: ADJ NOM
	public void rule21__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule21__adj__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_adjectiu2(out, word1, blank1, word2);
		macro_ordigu_genron(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "preadv?_adj_nom"));
		out.append("<SN><nom>{");
		{
			String myword = 
			         var_adjectiu
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
		out.append(word2.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: ADJ ADJ NOM
	public void rule22__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule22__adj__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_adjectiu2(out, word1, blank2, word3);
		macro_ordigu_genron(out, word3);
		var_tmp1 = var_preadv_added;
		var_tmp2 = var_adjectiu;
		macro_set_adjectiu2(out, word2, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "preadv?_adj_adj_nom"));
		out.append("<SN><nom>{");
		{
			String myword = 
			         var_tmp2
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
			         var_adjectiu
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
		out.append(word3.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: DET UNKNOWN/ADV/NUM UNKNOWN/ADV/NUM NOM
	public void rule23__det__unknown_adv_num__unknown_adv_num__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule23__det__unknown_adv_num__unknown_adv_num__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word4);
		macro_set_determiner3(out, word1, blank1, word2, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_unkn_unkn_nom"));
		out.append("<SN><nom>{");
		out.append(var_determiner);
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
		out.append(word4.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: DET ADJ ADJ NOM
	public void rule24__det__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule24__det__adj__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word4);
		macro_set_adjectiu2(out, word2, blank3, word4);
		var_tmp1 = var_adjectiu;
		macro_set_adjectiu2(out, word3, blank3, word4);
		macro_set_determiner3(out, word1, blank1, word2, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_preadv?_adj_adj_nom"));
		out.append("<SN><nom>{");
		out.append(var_determiner);
		{
			String myword = 
			         var_tmp1
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
			         var_adjectiu
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
		out.append(word4.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: DET ADJ ADJ ADJ NOM
	public void rule25__det__adj__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule25__det__adj__adj__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word5);
		macro_set_adjectiu2(out, word2, blank4, word5);
		var_tmp1 = var_adjectiu;
		macro_set_adjectiu2(out, word3, blank4, word5);
		var_tmp2 = var_adjectiu;
		macro_set_adjectiu2(out, word4, blank4, word5);
		macro_set_determiner3(out, word1, blank1, word2, blank4, word5);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_preadv?_adj_adj_adj_nom"));
		out.append("<SN><nom>{");
		out.append(var_determiner);
		{
			String myword = 
			         var_tmp1
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
			         var_tmp2
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
			         var_adjectiu
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
		out.append(word5.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	/**   TODO: ADJ NOM NOM:  Private testing companies 
    <rule comment="REGLA: NOM NOM   - testo-firmaoj (malnova)">
      <pattern>
        <pattern-item n="nom"/>
        <pattern-item n="nom"/>
      </pattern>
      <action>
        <call-macro n="firstWord"><with-param pos="1"/></call-macro>
        <call-macro n="ordigu_genron"><with-param pos="1"/></call-macro>
        <call-macro n="ordigu_genron"><with-param pos="2"/></call-macro>
            <out>
              <chunk name="nom_guio_nom" case="caseFirstWord">
                <tags>
                  <tag><lit-tag v="SN.nom"/></tag>
                </tags>
                <lu>
                  <clip pos="1" side="tl" part="lem"/>
                  <clip pos="1" side="tl" part="a_nom"/>
                  <lit-tag v="sg.nom"/>
                </lu>
                <lu>
                  <lit v="-"/>
                  <lit-tag v="guio"/>
                </lu>
                <*-*- <b pos="1"/> inserts a space. Could just ONE space be deleted and rest of the blank be inserted. Francis: not that i'm aware of -*-*>
                <lu>
                  <clip pos="2" side="tl" part="lem"/>
                  <clip pos="2" side="tl" part="tags"/>
                  <lit-tag v="2"/>
                </lu>
              </chunk>
            </out>
      </action>
    </rule>
 */
	// REGLA: NOM NOM   - testaj firmaoj (nova provo)
	public void rule26__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule26__nom__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word1);
		macro_ordigu_genron(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_nom"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_lem));
		out.append("<adj>");
		out.append(word1.tl(attr_a_acr));
		out.append(word1.tl(attr_a_gen));
		out.append(word2.tl(attr_a_nbr));
		out.append("<2>$");
		out.append(blank1);
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append(word2.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: ANT
	public void rule27__ant_cog(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule27__ant_cog",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: ANT ANT
	public void rule28__ant_cog__ant_cog(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule28__ant_cog__ant_cog",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant_cog"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_tags));
		out.append("<2>$");
		out.append(blank1);
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append(word2.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: ANT ANT ANT
	public void rule29__ant_cog__ant_cog__ant_cog(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule29__ant_cog__ant_cog__ant_cog",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant_cog"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_tags));
		out.append("<2>$");
		out.append(blank1);
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append(word2.tl(attr_tags));
		out.append("<2>$");
		out.append(blank2);
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append(word3.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: ANT ANT ANT ANT
	public void rule30__ant_cog__ant_cog__ant_cog__ant_cog(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule30__ant_cog__ant_cog__ant_cog__ant_cog",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant_ant_cog_cog"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_tags));
		out.append("<2>$");
		out.append(blank1);
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append(word2.tl(attr_tags));
		out.append("<2>$");
		out.append(blank2);
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append(word3.tl(attr_tags));
		out.append("<2>$");
		out.append(blank3);
		out.append('^');
		out.append(word4.tl(attr_lem));
		out.append(word4.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: ANT - ANT ANT
	public void rule31__ant_cog__guio__ant_cog__ant_cog(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule31__ant_cog__guio__ant_cog__ant_cog",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant-ant_cog"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_tags));
		out.append("<2>$");
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
		out.append(word3.tl(attr_tags));
		out.append("<2>$");
		out.append(blank3);
		out.append('^');
		out.append(word4.tl(attr_lem));
		out.append(word4.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: ANT ANT - ANT
	public void rule32__ant_cog__ant_cog__guio__ant_cog(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule32__ant_cog__ant_cog__guio__ant_cog",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant_cog-cog"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_tags));
		out.append("<2>$");
		out.append(blank1);
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append(word2.tl(attr_tags));
		out.append("<2>$");
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
		out.append(word4.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: ANT - ANT ANT - ANT
	public void rule33__ant_cog__guio__ant_cog__ant_cog__guio__ant_cog(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule33__ant_cog__guio__ant_cog__ant_cog__guio__ant_cog",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant-ant_cog-cog"));
		out.append("<SN><nom>{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_tags));
		out.append("<2>$");
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
		out.append(word3.tl(attr_tags));
		out.append("<2>$");
		out.append(blank3);
		out.append('^');
		out.append(word4.tl(attr_lem));
		out.append(word4.tl(attr_tags));
		out.append("<2>$");
		out.append(blank4);
		{
			String myword = 
			         word5.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank5);
		out.append('^');
		out.append(word6.tl(attr_lem));
		out.append(word6.tl(attr_tags));
		out.append("<2>$}$");
	}
	
	// REGLA: NOM/ANT 's NOM:  gardener's dog => la hundo de gxardenisto
	public void rule34__genitive_possessors__gen__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule34__genitive_possessors__gen__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_nomvar_if_known1(out, word1);
		macro_ordigu_genron(out, word1);
		macro_ordigu_genron(out, word3);
		macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_gen_nom"));
		out.append("<SN><nom>{");
		/**  hundo  */
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append(word3.tl(attr_tags));
		out.append("<2>$");
		out.append(var_blanko);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
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
		/**  de  */
		out.append(blank2);
		/**  gxardenisto  */
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_tags)
			         +var_nomvar
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
	}
	
	// REGLA: NOM/ANT 's NOM:  gardener's dog => hundo de gxardenisto
	public void rule35__genitive_possessors__gen__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule35__genitive_possessors__gen__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_nomvar_if_known1(out, word1);
		macro_ordigu_genron(out, word1);
		macro_ordigu_genron(out, word3);
		macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_gen_nom"));
		out.append("<SN><nom>{");
		/**  hundo  */
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append(word3.tl(attr_tags));
		out.append("<2>$");
		out.append(var_blanko);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
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
		/**  de  */
		out.append(blank2);
		/**  gxardenisto  */
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_tags)
			         +var_nomvar
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
	}
	
	// REGLA: NOM/ANT 's NOM NOM:  gardener's dog house => hunda domo de gxardenisto
	public void rule36__genitive_possessors__gen__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule36__genitive_possessors__gen__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_set_nomvar_if_known1(out, word1);
		macro_ordigu_genron(out, word1);
		macro_ordigu_genron(out, word3);
		macro_ordigu_genron(out, word4);
		macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "n_n_de_n"));
		out.append("<SN><nom>{");
		/**  hundA  */
		/**  se estas akronimo  */
		/**  se havas genron  */
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append("<adj>");
		out.append(word3.tl(attr_a_acr));
		out.append(word3.tl(attr_a_gen));
		out.append(word4.tl(attr_a_nbr));
		out.append("<2>$");
		out.append(var_blanko);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
		/**  domo  */
		out.append('^');
		out.append(word4.tl(attr_lem));
		out.append(word4.tl(attr_tags));
		out.append("<2>$");
		out.append(blank2);
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
		/**  de  */
		out.append(blank3);
		/**  gxardenisto  */
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_tags)
			         +var_nomvar
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
	}
	
	// REGLA: DET NOM/ANT 's NOM:  his gardener's dog => la hundo de lia gxardenisto
	public void rule37__det__genitive_possessors__gen__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule37__det__genitive_possessors__gen__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_set_nomvar_if_known1(out, word2);
		macro_ordigu_genron(out, word2);
		macro_ordigu_genron(out, word4);
		macro_set_determiner_de_genitivo2(out, word1, blank1, word2);
		word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
		macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
		var_tmp2 = var_blanko;
		macro_set_blankon_se_havas_formaton2(out, word2, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_gen_det_nom"));
		out.append("<SN><nom>{^");
		out.append(TransferWord.copycase(word1.sl(attr_lem), "la"));
		out.append("<det><def><sp>$");
		/**  la  */
		out.append(var_tmp2);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
		/**  hundo  */
		out.append('^');
		out.append(word4.tl(attr_lem));
		out.append(word4.tl(attr_tags));
		out.append("<2>$");
		out.append(var_blanko);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
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
		/**  de  */
		out.append(blank3);
		out.append(var_determiner);
		/**  lia  */
		/**  gxardenisto  */
		{
			String myword = 
			         word2.tl(attr_lem)
			         +word2.tl(attr_tags)
			         +var_nomvar
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
	}
	
	// REGLA: DET NOM/ANT NOM/ANT 's NOM:  his garden man's dog   - La hundo de lia ĝardeno viro 
	public void rule38__det__genitive_possessors__genitive_possessors__gen__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule38__det__genitive_possessors__genitive_possessors__gen__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_set_nomvar_if_known1(out, word2);
		var_tmp1 = var_nomvar;
		macro_ordigu_genron(out, word2);
		macro_set_nomvar_if_known1(out, word3);
		macro_ordigu_genron(out, word3);
		macro_ordigu_genron(out, word5);
		macro_set_determiner_de_genitivo2(out, word1, blank2, word3);
		macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
		var_tmp2 = var_blanko;
		macro_set_blankon_se_havas_formaton2(out, word3, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_gen_det_nom_nom"));
		out.append("<SN><nom>{");
		out.append(var_tmp2);
		out.append('^');
		out.append(TransferWord.copycase(word1.sl(attr_lem), "la"));
		out.append("<det><def><sp>$");
		/**  la  */
		out.append(blank2);
		/**  hundo  */
		out.append('^');
		out.append(word5.tl(attr_lem));
		out.append(word5.tl(attr_tags));
		out.append("<2>$");
		out.append(var_blanko);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
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
		/**  de  */
		out.append(blank4);
		out.append(var_determiner);
		/**  lia  */
		/**  ĝardeno  */
		{
			String myword = 
			         word2.tl(attr_lem)
			         +word2.tl(attr_tags)
			         +var_tmp1
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ");
		/**  viro   */
		{
			String myword = 
			         word3.tl(attr_lem)
			         +word3.tl(attr_tags)
			         +var_nomvar
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
	}
	
	/**  Its Not clear this rule makes more harm than good

    <rule comment="REGLA: NOM/ANT NOM/ANT 's NOM:  Jacob Smith's dog   => hundo de Jacob Smith">
      <pattern>
        <pattern-item n="genitive_possessors"/>
        <pattern-item n="genitive_possessors"/>
        <pattern-item n="gen"/>
        <pattern-item n="nom"/>
      </pattern>
...
 ************************************************************* **                                                         ** **                    DIVERSAJ                             ** **                                                         ** ************************************************************* */
	// rekunu and, or kaj nor aparte - ĉar povas esti parto de listo de aferoj
	public void rule39__and_or_nor(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule39__and_or_nor",  word1); } 
		macro_firstWord(out, word1);
		macro_set_and_or_but(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "and_or"));
		out.append("<and_or>");
		out.append(var_and_or_but);
		out.append('{');
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
		out.append("}$");
	}
	
	/**  Conjunctions  */
	public void rule40__cnjcoo(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule40__cnjcoo",  word1); } 
		macro_firstWord(out, word1);
		macro_set_and_or_but(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "cnjcoo"));
		out.append("<CC>");
		out.append(var_and_or_but);
		out.append('{');
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
		out.append("}$");
	}
	
	public void rule41__cnjadv(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule41__cnjadv",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "cnjadv"));
		out.append("<CA>{");
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
		out.append("}$");
	}
	
	public void rule42__cnjsub(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule42__cnjsub",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "CS"));
		out.append("<NUM>{");
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
		out.append("}$");
	}
	
	public void rule43__cm(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule43__cm",  word1); } 
		out.append("^cm<CM>{");
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
		out.append("}$");
	}
	
	/** 
where:where<rel><adv>
after which:after which<rel><an><mf><sp>
which:which<rel><an><mf><sp>
whom:whom<rel><an><mf><sp>
the ones that:the ones that<rel><nn><mf><pl>
the ones who:the ones who<rel><nn><mf><pl>
 */
	public void rule44__rel(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule44__rel",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "rel"));
		out.append("<REL>{");
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
		out.append("}$");
	}
	
	/**  any, as, how, just as, more, most, pretty, really, so, too, very, fairly  */
	public void rule45__preadv(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule45__preadv",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "preadv"));
		out.append("<PREADV>{");
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
		out.append("}$");
	}
	
	/**  all<predet><sp>  */
	public void rule46__predet(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule46__predet",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "predet"));
		out.append("<PREDET>{");
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
		out.append("}$");
	}
	
	/**  regulo en antax_t2x ne funkscias, bedauxrinde.....
    <rule>
      <pattern>
        <pattern-item n="out"/>
      </pattern>
      <action>
        <call-macro n="firstWord"><with-param pos="1"/></call-macro>
        <out>
          <chunk name="out" case="caseFirstWord">
            <tags>
              <tag><lit-tag v="Adv"/></tag>
            </tags>
            <lu>
              <clip pos="1" side="tl" part="whole"/>
            </lu>
          </chunk>
        </out>
      </action>
    </rule>
 */
	public void rule47__adv(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule47__adv",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append("<Adv>{");
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
		out.append("}$");
	}
	
	/**  of<pr> off<pr> on<pr> onto<pr> over<pr> per<pr> ...  */
	public void rule48__pr(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule48__pr",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr"));
		out.append("<PREP>{");
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
		out.append("}$");
	}
	
	// REGLA: non-recognized genitive ('s) fallback :  XXX's YYY   => XXX'a YYY
	public void rule49__gen(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule49__gen",  word1); } 
		out.append("^gen<GEN>{^a<gen>$}$");
	}
	
	// REGLA: SENT ;: - frazparto
	public void rule50__sent_komopunkto_dupunkto(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule50__sent_komopunkto_dupunkto",  word1); } 
		out.append("^sent<S>{");
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
		out.append("}$");
	}
	
	// REGLA: SENT .?!  - fino de frazo
	public void rule51__sent(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule51__sent",  word1); } 
		var_EOS = "true";
		out.append("^sent<S>{");
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
		out.append("}$");
	}
	
	public void rule52__unknown(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule52__unknown",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "unknown"));
		/**  Traktu nekonatajn vortojn kiel nomoj en la venontaj stagxo  */
		out.append("<SN><nom>{");
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
		out.append("}$");
	}
	
	/**  ************************************************************* **                                                         ** **                    VERBOJ                               ** **                                                         ** ************************************************************* to run, to swim  */
	// REGLA: to VBLEXinf
	public void rule53__to__vblexinf(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule53__to__vblexinf",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word2);
		macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verbInf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word2.tl(attr_a_tns));
		out.append("{^");
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_vrb));
		out.append("<3>");
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: of VBLEXger - of being, of running, of looking - esti, kuri, vidi
	public void rule54__of__vblexger(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule54__of__vblexger",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word2);
		macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verbInf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append("<inf>{^");
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_vrb));
		out.append("<3>");
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: to have suffered  -  suferi
	public void rule55__to__vbhaverinf__vblex_vbser(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule55__to__vbhaverinf__vblex_vbser",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word3);
		macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
		macro_sendu_blankon_se_havas_formaton2(out, word2, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verbInf2"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append("<inf>{^");
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_vrb));
		out.append("<3>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	/**  ^be/be<vbser><inf>$ ^being/be<vbser><ger>$  ^been/be<vbser><pp>$ ^applying/apply<vblex><ger>$   */
	// REGLA: be VBLEXger
	public void rule56__vbser__vblexger(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule56__vbser__vblexger",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "be_vbger"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.tl(attr_a_tns));
		out.append("{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_a_vrb));
		out.append("<3>");
		out.append(word1.tl(attr_lemq));
		out.append('$');
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_vrb)
			         +word2.tl(attr_a_tns)
			         +word2.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
	}
	
	// REGLA: level out - elebenigi
	public void rule57__vblex__out(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule57__vblex__out",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word1);
		macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "el_verb"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.tl(attr_a_tns));
		out.append("{^el<adv>$^");
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_vrb));
		out.append("<3>");
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: VBSER not
	public void rule58__vbser__not(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule58__vbser__not",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ser_not"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.tl(attr_a_tns));
		out.append('{');
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
		out.append(blank1);
		out.append('^');
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_vrb));
		out.append("<3>");
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	// RULE: please + vblex in present => please + vblex in infinitive
	public void rule59__please__c_vblex_pres(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule59__please__c_vblex_pres",  word1, blank1,  word2); } 
		macro_set_tipus_verbs1(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pls_verb1"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.tl(attr_a_tns));
		out.append("{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_a_vrb));
		out.append("<3>$}$");
		out.append(blank1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pls_verb2"));
		out.append(word2.tl(attr_a_tns));
		out.append("{^");
		out.append(word2.tl(attr_lem));
		out.append(word2.tl(attr_a_vrb));
		out.append("<inf>$}$");
	}
	
	// REGLA: do ADV VERB (I do not think -> mi ne pensas. I do always think -> mi ja ĉiam pensas)
	public void rule60__do__adv__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule60__do__adv__infpres",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word3);
		macro_set_verbkonj2_do(out, word1, blank2, word3);
		if (!word2.sl(attr_lem).equalsIgnoreCase("not"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "ja2"));
			out.append("<Adv>{^ja<adv>$}$");
			out.append(blank1);
			var_caseFirstWord = "aa";
		}
		else
		{
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv2"));
		out.append("<Adv>{");
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
		out.append("}$");
		out.append(blank2);
		out.append("^verbcj<SV>");
		out.append(var_tipus_verb);
		out.append(word1.tl(attr_a_tns));
		out.append('{');
		{
			String myword = 
			         var_verbkonj
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
	}
	
	// REGLA: do VERB (I do think -> mi ja pensas) 
	public void rule61__do__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule61__do__infpres",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word2);
		macro_set_verbkonj2_do(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ja"));
		out.append("<Adv>{^ja<adv>$}$");
		out.append(blank1);
		out.append("^verbcj2<SV>");
		out.append(var_tipus_verb);
		out.append(word1.tl(attr_a_tns));
		out.append('{');
		{
			String myword = 
			         var_verbkonj
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
	}
	
	/** 
can:can<vaux><pres>
could:can<vaux><past>
will:will<vaux><inf>
shall:shall<vaux><inf>
would:would<vaux><inf>
must:must<vaux><inf>
should:should<vaux><inf>
may:may<vaux><inf>
might:might<vaux><inf>
 */
	// REGLA: VAUX VBLEX
	public void rule62__vaux_vbhaver__vblex_vbser(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule62__vaux_vbhaver__vblex_vbser",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word2);
		if (list_willwouldshallhave.containsIgnoreCase(word1.sl(attr_lem)))
		{
			macro_set_temps1(out, word1);
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb2"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append("{^");
			out.append(word2.tl(attr_lemh));
			out.append(word2.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word2.tl(attr_lemq));
			out.append("$}$");
		}
		else
		if (((word1.sl(attr_lem).equalsIgnoreCase("can")
    && word1.sl(attr_a_tns).equalsIgnoreCase("<past>"))
    || word1.sl(attr_lem).equalsIgnoreCase("might")))
		{
			var_temps = "<cni>";
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append("<inf>{^povi<vaux><cni>$");
			out.append(blank1);
			out.append('^');
			out.append(word2.tl(attr_lemh));
			out.append(word2.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word2.tl(attr_lemq));
			out.append("$}$");
		}
		/**  I may wash.
          <when>
            <test>
              <equal caseless="yes"><clip pos="1" side="sl" part="lem"/><lit v="may"/></equal>
            </test>
            <let><var n="temps"/><lit-tag v="cni"/></let>
            <out>
              <chunk name="vaux_verb" case="caseFirstWord">
                <tags>
                  <tag><lit-tag v="SV"/></tag>
                  <tag><var n="tipus_verb"/></tag>
                </tags>
                <lu>
                  <lit v="eble"/><lit-tag v="adv"/>
                </lu>
                <b pos="1"/>
                <lu>
                  <clip pos="2" side="tl" part="lemh"/>
                  <clip pos="2" side="tl" part="a_vrb"/>
                  <lit-tag v="inf"/>
                  <clip pos="2" side="tl" part="lemq"/>
                </lu>
              </chunk>
            </out>
          </when>
 */
		else
		{
			var_temps = word2.sl(attr_a_tns);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb2"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(word1.tl(attr_a_tns));
			out.append("{^");
			out.append(word1.tl(attr_lemh));
			out.append(word1.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word1.tl(attr_lemq));
			out.append('$');
			out.append(blank1);
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_vrb)
				         +var_temps
				         +word2.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append("}$");
		}
	}
	
	// REGLA: VAUX ADV VBLEX
	public void rule63__vaux_vbhaver__adv__vblex_vbser(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule63__vaux_vbhaver__adv__vblex_vbser",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word3);
		if (list_willwouldshallhave.containsIgnoreCase(word1.sl(attr_lem)))
		{
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			macro_set_temps1(out, word1);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb3"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
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
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		else
		if (((word1.sl(attr_lem).equalsIgnoreCase("can")
    && word1.sl(attr_a_tns).equalsIgnoreCase("<past>"))
    || word1.sl(attr_lem).equalsIgnoreCase("might")))
		{
			var_temps = "<cni>";
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb3"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append("<inf>{");
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
			out.append(blank1);
			out.append("^povi<vaux><cni>$");
			out.append(blank2);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			var_temps = word3.sl(attr_a_tns);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb4"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
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
			out.append(blank1);
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
			out.append(blank2);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
	}
	
	// REGLA: VAUX ADV ADV VBLEX - have also abruptly changed - ankaŭ abrupte ŝanĝis
	public void rule64__vaux_vbhaver__adv__adv__vblex_vbser(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule64__vaux_vbhaver__adv__adv__vblex_vbser",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word4);
		if (list_willwouldshallhave.containsIgnoreCase(word1.sl(attr_lem)))
		{
			macro_set_temps1(out, word1);
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb4"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
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
			out.append(word4.tl(attr_lemh));
			out.append(word4.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
		else
		if (((word1.sl(attr_lem).equalsIgnoreCase("can")
    && word1.sl(attr_a_tns).equalsIgnoreCase("<past>"))
    || word1.sl(attr_lem).equalsIgnoreCase("might")))
		{
			var_temps = "<cni>";
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb5"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append("<inf>{");
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
			out.append(blank1);
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
			out.append(blank2);
			out.append("^povi<vaux><cni>$");
			out.append(blank3);
			out.append('^');
			out.append(word4.tl(attr_lemh));
			out.append(word4.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			var_temps = word4.sl(attr_a_tns);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb6"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
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
			out.append(word4.tl(attr_lemh));
			out.append(word4.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
	}
	
	// REGLA: VAUX VBHAVER VBLEX/VBSER - would have been,  would have ended,  might have allowed,  could have levelled out, may have represented,  might have been
	public void rule65__vaux_vbhaver__vbhaver__vblex_vbser(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule65__vaux_vbhaver__vbhaver__vblex_vbser",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word3);
		if (list_willwouldshallhave.containsIgnoreCase(word1.sl(attr_lem)))
		{
			macro_set_temps1(out, word1);
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb_pp"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append("<pp3>{^esti<vbser>");
			out.append(var_temps);
			out.append('$');
			out.append(blank2);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		else
		if (word1.sl(attr_lem).equalsIgnoreCase("may"))
		{
			var_temps = "<past>";
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb3a"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append("{^eble<adv>$");
			out.append(blank2);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		else
		if (word1.sl(attr_lem).equalsIgnoreCase("might"))
		{
			var_temps = "<cni>";
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb3b"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append("{^eble<adv>$");
			out.append(blank2);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		else
		if ((word1.sl(attr_lem).equalsIgnoreCase("can")
    || word1.sl(attr_a_tns).equals("past")))
		{
			var_temps = "<cni>";
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_pp"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append("<inf>{^povi<vaux><past>$");
			out.append(blank2);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			var_temps = "<past>";
			if (word1.sl(attr_lem).equalsIgnoreCase("should"))
			{
				var_temps = "<cni>";
			}
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb7"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append("{^");
			out.append(word1.tl(attr_lemh));
			out.append(word1.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word1.tl(attr_lemq));
			out.append('$');
			out.append(blank2);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_vrb));
			out.append("<inf>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
	}
	
	// REGLA: VAUX VBSER VBLEXGER
	public void rule66__vaux_vbhaver__vbser__vblexger(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule66__vaux_vbhaver__vbser__vblexger",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word3);
		if (list_willwouldshallhave.containsIgnoreCase(word1.sl(attr_lem)))
		{
			macro_set_temps1(out, word1);
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb_vbger"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append("{^");
			out.append(word2.tl(attr_lemh));
			out.append(word2.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word2.tl(attr_lemq));
			out.append('$');
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
			out.append("}$");
		}
		else
		{
			var_temps = word2.sl(attr_a_tns);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb8"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
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
			out.append(word2.tl(attr_lemh));
			out.append(word2.tl(attr_a_vrb));
			out.append("<3>");
			out.append(word2.tl(attr_lemq));
			out.append('$');
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
			out.append("}$");
		}
	}
	
	/**  <b/><lu><lit v="DEBUG_vaux_vbser_vblexger"/></lu>  */
	public void rule67__vbdo(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule67__vbdo",  word1); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "vbdo"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.tl(attr_a_tns));
		out.append("{^");
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_vrb));
		out.append("<3>");
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	public void rule68__vb_all(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule68__vb_all",  word1); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verb_all"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.tl(attr_a_tns));
		out.append("{^");
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_vrb));
		out.append("<3>");
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
}
