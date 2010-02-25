package org.apertium.transfer.generated;
import java.util.*;
import java.io.*;
import org.apertium.transfer.*;
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
	ApertiumRE attr_a_nom = new ApertiumRE("<n><acr><re>|<np><ant>|<np><cog>|<np><top>|<n><acr>|<np><al>|<np>|<n>");
	ApertiumRE attr_a_acr = new ApertiumRE("<acr><re>|<np><top>|<np><al>|<acr>");
	ApertiumRE attr_a_any = new ApertiumRE("<np>|<n>");
	ApertiumRE attr_a_prp = new ApertiumRE("<pr>");
	ApertiumRE attr_a_adj = new ApertiumRE("<adj><sint><comp>|<adj><sint><sup>|<adj><pst>|<adj><itg>|<adj><pos>|<adj>");
	ApertiumRE attr_a_vrb = new ApertiumRE("<vblex><sep>|<vblex>|<vbser>|<vaux>");
	ApertiumRE attr_a_det = new ApertiumRE("<det><def>|<det><ind>|<det><pos>|<det><qnt>|<det><itg>|<det><qnt>|<det><dem>");
	/**  Jacob added  */
	ApertiumRE attr_a_prn = new ApertiumRE("<prn><subj>|<prn><ref>|<prn><itg>|<prn><obj>|<prn><tn>|<prn>");
	ApertiumRE attr_a_prn__sen__subj_obj = new ApertiumRE("<prn><ref>|<prn><itg>|<prn><tn>|<prn>");
	ApertiumRE attr_a_tns = new ApertiumRE("<pres>|<subs>|<pprs>|<past>|<pri>|<imp>|<inf>|<cni>|<ger>|<fti>|<pp>");
	ApertiumRE attr_a_gen = new ApertiumRE("<nt>|<mf>|<GD>|<m>|<f>");
	ApertiumRE attr_a_prs = new ApertiumRE("<p1>|<p2>|<p3>");
	ApertiumRE attr_a_nbr = new ApertiumRE("<sp>|<sg>|<pl>|<ND>");
	ApertiumRE attr_a_cas = new ApertiumRE("<nom>|<acc>");
	/**  taken from en-es.t1x, for use in macro firstWord  */
	ApertiumRE attr_a_np_acr = new ApertiumRE("<acr>|<np>");
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
	TransferWordList list_adv_neg = new TransferWordList(new String[] { "not", });
	/**  verboj ne postulantaj THAT  */
	TransferWordList list_reportingverb = new TransferWordList(new String[] { "say", "admit", "agree", "decide", "deny", "explain", "insist", "promise", "recommend", "suggest", "point", "think", "believe", "hope", "fear", "suppose", });
	/**  ne-transitivaj verboj.   */
	TransferWordList list_netransitivaj = new TransferWordList(new String[] { "be", "seem", "become", "appear", "there be", });
	/**  help verboj kiuj malaperos en Esperantp */
	TransferWordList list_willwouldshallhave = new TransferWordList(new String[] { "have", "will", "would", "shall", });
	TransferWordList list_listo_and_or_but = new TransferWordList(new String[] { "and", "but", "or", });
	
	/**  TODO
 make a transfer rule saying  DET + ADJ  can be a SN:
  The first was an animated feature     and
  the second was a TV live action version.

 ekzamenas la vorton kaj metas majuskligajn informojn en variablo "firstWord"  */
	private void macro_firstWord(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_firstWord",  word1); } 
		if (((var_EOS.equals("true")
    && word1.source(attr_a_np_acr, true).equals(""))
    || var_venontaVortoEstuMajuskla.equals("true")))
		{
			word1.setTarget(attr_lem, TransferWord.copycase("aa", word1.target(attr_lem, true)), true);
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
	private void macro_set_nomvar_if_known1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_nomvar_if_known1",  word1); } 
		if (word1.target(attr_a_nbr, true).equals(""))
		{
			var_nomvar = "";
		}
		else
		{
			var_nomvar = "<nom>";
		}
	}
	
	/**  Sxangxas la genron de vorto: Se la genro estas nekonata "GD" gxi estas sxangxata al vira genro  */
	private void macro_ordigu_genron(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_ordigu_genron",  word1); } 
		if (word1.target(attr_a_gen, true).equalsIgnoreCase("<GD>"))
		{
			word1.setTarget(attr_a_gen, "<m>", true);
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
	private void macro_set_numero1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_numero1",  word1); } 
		if (word1.target(attr_a_nbr, true).equals("<pl>"))
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
	private void macro_set_adjectiu2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_adjectiu2",  word1, blank1,  word2); } 
		macro_set_numero1(out, word2);
		var_adjectiu = "";
		var_preadv_added = "";
		if (word1.source(attr_a_adj, true).equals("<adj><sint><comp>"))
		{
			/**  ^pli<preadv>$ ^bona<adj><2>$  */
			var_adjectiu = (""+TransferWord.copycase(word1.source(attr_lem, true), "pli")+"<preadv>"+"$ ^"+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
			var_preadv_added = "preadv_";
		}
		else
		if (word1.source(attr_a_adj, true).equals("<adj><sint><sup>"))
		{
			/**  ^plej<preadv>$ ^bona<adj><2>$  */
			var_adjectiu = (""+TransferWord.copycase(word1.source(attr_lem, true), "plej")+"<preadv>"+"$ ^"+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
			var_preadv_added = "preadv_";
		}
		else
		if (word1.target(attr_a_adj, true).equals("<adj>"))
		{
			/**  ^bona<adj><2>$  */
			var_adjectiu = (""+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
		}
		else
		{
			/**  ^bona<adj><2>$  */
			var_adjectiu = (""+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
		}
	}
	
	private void macro_set_tipus_verbs1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_tipus_verbs1",  word1); } 
		if (list_netransitivaj.containsIgnoreCase(word1.source(attr_lemh, true)))
		{
			var_tipus_verb = "<netransitiva>";
		}
		else
		if (list_reportingverb.containsIgnoreCase(word1.source(attr_lemh, true)))
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
	private void macro_set_verbkonj2_do(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_verbkonj2_do",  word1, blank1,  word2); } 
		if ((word1.source(attr_a_tns, true).equals("<pres>")
    || word1.source(attr_a_tns, true).equals("<inf>")))
		{
			var_macro_tmp1 = "<pres>";
		}
		else
		if (word1.source(attr_a_tns, true).equals("<past>"))
		{
			var_macro_tmp1 = "<past>";
		}
		else
		{
			var_macro_tmp1 = (""+"<ERROR1_>"+word1.source(attr_a_tns, true));
		}
		var_verbkonj = (""+word2.target(attr_lemh, true)+word2.target(attr_a_vrb, true)+var_macro_tmp1+word2.target(attr_lemq, true));
	}
	
	private void macro_set_verbkonj2_willShallWould(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_verbkonj2_willShallWould",  word1, blank1,  word2); } 
		if ((word1.source(attr_lem, true).equalsIgnoreCase("will")
    || word1.source(attr_lem, true).equalsIgnoreCase("shall")))
		{
			var_macro_tmp1 = "<fti>";
		}
		else
		if (word1.source(attr_lem, true).equalsIgnoreCase("would"))
		{
			var_macro_tmp1 = "<cni>";
		}
		else
		{
			var_macro_tmp1 = (""+"<ERROR2_>"+word1.source(attr_a_tns, true));
		}
		var_verbkonj = (""+word2.target(attr_lemh, true)+word2.target(attr_a_vrb, true)+var_macro_tmp1+word2.target(attr_lemq, true));
	}
	
	private void macro_set_temps1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_temps1",  word1); } 
		var_temps = "<UNKNOWN>";
		if ((word1.source(attr_lem, true).equalsIgnoreCase("will")
    || word1.source(attr_lem, true).equalsIgnoreCase("shall")))
		{
			var_temps = "<fti>";
		}
		else
		if (word1.source(attr_lem, true).equalsIgnoreCase("would"))
		{
			var_temps = "<cni>";
		}
		else
		if (word1.source(attr_lem, true).equalsIgnoreCase("have"))
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
	private void macro_sendu_blankon_se_havas_formaton2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
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
	private void macro_set_blankon_se_havas_formaton2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
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
	private void macro_set_determiner3(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("macro_set_determiner3",  word1, blank1,  word2, blank2,  word3); } 
		if (word1.source(attr_lem, true).equalsIgnoreCase("a"))
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
			var_determiner = (""+"^"+word1.target(attr_lemh, true)+word1.target(attr_a_det, true)+word3.target(attr_a_nbr, true)+"<2>"+word1.target(attr_lemq, true)+"$"+blank1);
		}
	}
	
	private void macro_set_determiner_de_genitivo2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_determiner_de_genitivo2",  word1, blank1,  word2); } 
		macro_set_numero1(out, word2);
		if (word1.source(attr_lem, true).equalsIgnoreCase("a"))
		{
			var_determiner = "";
		}
		else
		{
			word1.setTarget(attr_lem, TransferWord.copycase("aa", word1.target(attr_lem, true)), true);
			/**  lemh por subteni "most of<det>"  */
			var_determiner = (""+"^"+word1.target(attr_lemh, true)+word1.target(attr_a_det, true)+var_numero+"<nom>"+word1.target(attr_lemq, true)+"$"+" ");
		}
	}
	
	/** 
    c="and or but povas esti komenco de demando, sed la aliaj cnjoo NE povas esti parto de demando:
    ekzemple:   and/or/but did they acquire any influence?   - demando
    ekzemple:   neither/nor did they acquire any influence   - konstato
    "  */
	private void macro_set_and_or_but(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_and_or_but",  word1); } 
		if (list_listo_and_or_but.containsIgnoreCase(word1.source(attr_lem, true)))
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
	public void rule0__prnref(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule0__prnref",  word1); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prnref"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
			         +"<2>"
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
	
	// REGLA: Prn
	public void rule1__prnaltres(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule1__prnaltres",  word1); } 
		macro_firstWord(out, word1);
		macro_set_numero1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prn"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +word1.target(attr_a_prn, true)
			         +var_numero
			         +"<2>"
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
	
	// REGLA: PrnPers
	public void rule2__prnpers(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule2__prnpers",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prnpers"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
			         +"<2>"
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
	
	public void rule3__num(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule3__num",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	public void rule4__monato__num_dato(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule4__monato__num_dato",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "dato"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word2.target(attr_lem, true)
			         +"a"
			         +"<num><ord>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ");
		{
			String myword = 
			         "de"
			         +"<pr>"
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
			         word1.target(attr_lem, true)
			         +word1.target(attr_tags, true)
			         +"<nom>"
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
	
	// July 2nd - 2a de julio
	public void rule5__monato__num_ord(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule5__monato__num_ord",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "dato"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word2.target(attr_lem, true)
			         +"<num><ord>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ");
		{
			String myword = 
			         "de"
			         +"<pr>"
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
			         word1.target(attr_lem, true)
			         +word1.target(attr_tags, true)
			         +"<nom>"
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
	
	// on July 2 - la 2an de julio
	public void rule6__on__monato__num_dato(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule6__on__monato__num_dato",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "dato"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         "la"
			         +"<det><def><sp>"
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
			         word3.target(attr_lem, true)
			         +"an"
			         +"<num><ord>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ");
		{
			String myword = 
			         "de"
			         +"<pr>"
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
			         word2.target(attr_lem, true)
			         +word2.target(attr_tags, true)
			         +"<nom>"
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
	
	// on July 2nd - la 2a de julio
	public void rule7__on__monato__num_ord(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule7__on__monato__num_ord",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "dato"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         "la"
			         +"<det><def><sp>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		{
			String myword = 
			         word3.target(attr_lem, true)
			         +"n"
			         +"<num><ord>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		out.append(" ");
		{
			String myword = 
			         "de"
			         +"<pr>"
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
			         word2.target(attr_lem, true)
			         +word2.target(attr_tags, true)
			         +"<nom>"
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
	
	// REGLA NUM of      5 of => 5 el 
	public void rule8__num_sen_ord__of(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule8__num_sen_ord__of",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num"));
		out.append("<SN>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
		out.append('^');
		out.append("pr");
		out.append("<PREP>");
		out.append('{');
		{
			String myword = 
			         "el"
			         +"<pr>"
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
	
	// REGLA NUM times NUM  5 times 8 => 5 oble 8 
	public void rule9__num_sen_ord__times__num_sen_ord(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule9__num_sen_ord__times__num_sen_ord",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num"));
		out.append("<SN>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
			         "oble"
			         +"<cnjadv>"
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
			         word3.target(attr_whole, true)
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
	public void rule10__num__times(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule10__num__times",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
			         "fojo"
			         +"<n>"
			         +word2.target(attr_a_nbr, true)
			         +"<nom>"
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
	
	// REGLA: DET:a  - the derminier 'a' should just be deleted. Having this rule makes it possible to avoid handling 'a' in all the other rules
	public void rule11__a(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule11__a",  word1); } 
		if (word1.source(attr_lem, true).equals("A"))
		{
			var_venontaVortoEstuMajuskla = "true";
		}
		var_EOS = "false";
	}
	
	// REGLA: DET the, his, ... (alia ol 'a')
	public void rule12__det(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule12__det",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det"));
		out.append("<SD><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_tags, true)
			         +"<2>"
			         +word1.target(attr_lemq, true)
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
	
	/**  Sintagmas nominales  */
	// REGLA: NOM
	public void rule13__nom(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule13__nom",  word1); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +word1.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: more NOM, f.eks. 'more tea'  to 'Pli da teo'
	public void rule14__more__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule14__more__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "more_nom"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
			/**  <lit-tag v="2"/> no, keep <nom>  */
			         +"<nom>"
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
			         word2.target(attr_whole, true)
			/**  <lit-tag v="2"/> no, keep <nom>  */
			         +"<nom>"
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
	
	// REGLA: DET NOM
	public void rule15__det__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule15__det__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word2);
		macro_set_determiner3(out, word1, blank1, word2, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom"));
		out.append("<SN><nom>");
		out.append('{');
		out.append(var_determiner);
		{
			String myword = 
			         word2.target(attr_lem, true)
			         +word2.target(attr_tags, true)
			         +"<2>"
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
	public void rule16__det__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule16__det__nom__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word2);
		macro_ordigu_genron(out, word3);
		macro_set_determiner3(out, word1, blank1, word2, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_2nom"));
		out.append("<SN><nom>");
		out.append('{');
		out.append(var_determiner);
		{
			String myword = 
			         word2.target(attr_lem, true)
			         +"<adj>"
			         +word2.target(attr_a_acr, true)
			/**  se estas akronimo  */
			         +word2.target(attr_a_gen, true)
			/**  se havas genron  */
			         +word3.target(attr_a_nbr, true)
			         +"<2>"
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
			         word3.target(attr_lem, true)
			         +word3.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: DET NOM NOM NOM 
	public void rule17__det__nom__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule17__det__nom__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word2);
		macro_ordigu_genron(out, word3);
		macro_ordigu_genron(out, word4);
		macro_set_determiner3(out, word1, blank1, word2, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_3nom"));
		out.append("<SN><nom>");
		out.append('{');
		out.append(var_determiner);
		{
			String myword = 
			         word2.target(attr_lem, true)
			         +"<adj>"
			         +word2.target(attr_a_acr, true)
			/**  se estas akronimo  */
			         +word2.target(attr_a_gen, true)
			/**  se havas genron  */
			         +word4.target(attr_a_nbr, true)
			         +"<2>"
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
			         word3.target(attr_lem, true)
			         +"<adj>"
			         +word3.target(attr_a_acr, true)
			/**  se estas akronimo  */
			         +word3.target(attr_a_gen, true)
			/**  se havas genron  */
			         +word4.target(attr_a_nbr, true)
			         +"<2>"
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
			         word4.target(attr_lem, true)
			         +word4.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: DET NOM NOM NOM NOM
	public void rule18__det__nom__nom__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
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
		out.append("<SN><nom>");
		out.append('{');
		out.append(var_determiner);
		{
			String myword = 
			         word2.target(attr_lem, true)
			         +"<adj>"
			         +word2.target(attr_a_acr, true)
			/**  se estas akronimo  */
			         +word2.target(attr_a_gen, true)
			/**  se havas genron  */
			         +word5.target(attr_a_nbr, true)
			         +"<2>"
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
			         word3.target(attr_lem, true)
			         +"<adj>"
			         +word3.target(attr_a_acr, true)
			/**  se estas akronimo  */
			         +word3.target(attr_a_gen, true)
			/**  se havas genron  */
			         +word5.target(attr_a_nbr, true)
			         +"<2>"
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
			         word4.target(attr_lem, true)
			         +"<adj>"
			         +word4.target(attr_a_acr, true)
			/**  se estas akronimo  */
			         +word4.target(attr_a_gen, true)
			/**  se havas genron  */
			         +word5.target(attr_a_nbr, true)
			         +"<2>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank4);
		{
			String myword = 
			         word5.target(attr_lem, true)
			         +word5.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: ADJ
	public void rule19__adj(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule19__adj",  word1); } 
		macro_firstWord(out, word1);
		macro_set_adjectiu2(out, word1, " ", word1);
		macro_ordigu_genron(out, word1);
		var_chunk_name = (""+"adj"+var_preadv_added);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_chunk_name));
		out.append("<SN><nom>");
		out.append('{');
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
	public void rule20__det__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule20__det__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word3);
		macro_set_adjectiu2(out, word2, blank2, word3);
		macro_set_determiner3(out, word1, blank1, word2, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_preadv?_adj_nom"));
		out.append("<SN><nom>");
		out.append('{');
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
		{
			String myword = 
			         word3.target(attr_lem, true)
			         +word3.target(attr_tags, true)
			         +"<2>"
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
	public void rule21__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule21__adj__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_adjectiu2(out, word1, blank1, word2);
		macro_ordigu_genron(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "preadv?_adj_nom"));
		out.append("<SN><nom>");
		out.append('{');
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
		{
			String myword = 
			         word2.target(attr_lem, true)
			         +word2.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: ADJ ADJ NOM
	public void rule22__adj__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
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
		out.append("<SN><nom>");
		out.append('{');
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
		{
			String myword = 
			         word3.target(attr_lem, true)
			         +word3.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: DET UNKNOWN/ADV/NUM UNKNOWN/ADV/NUM NOM
	public void rule23__det__unknown_adv_num__unknown_adv_num__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule23__det__unknown_adv_num__unknown_adv_num__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word4);
		macro_set_determiner3(out, word1, blank1, word2, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_unkn_unkn_nom"));
		out.append("<SN><nom>");
		out.append('{');
		out.append(var_determiner);
		{
			String myword = 
			         word2.target(attr_whole, true)
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
			         word3.target(attr_whole, true)
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
			         word4.target(attr_lem, true)
			         +word4.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: DET ADJ ADJ NOM
	public void rule24__det__adj__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
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
		out.append("<SN><nom>");
		out.append('{');
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
		{
			String myword = 
			         word4.target(attr_lem, true)
			         +word4.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: DET ADJ ADJ ADJ NOM
	public void rule25__det__adj__adj__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
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
		out.append("<SN><nom>");
		out.append('{');
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
		{
			String myword = 
			         word5.target(attr_lem, true)
			         +word5.target(attr_tags, true)
			         +"<2>"
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
	public void rule26__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule26__nom__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word1);
		macro_ordigu_genron(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_nom"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +"<adj>"
			         +word1.target(attr_a_acr, true)
			         +word1.target(attr_a_gen, true)
			         +word2.target(attr_a_nbr, true)
			         +"<2>"
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
			         word2.target(attr_lem, true)
			         +word2.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: ANT
	public void rule27__ant_cog(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule27__ant_cog",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +word1.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: ANT ANT
	public void rule28__ant_cog__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule28__ant_cog__ant_cog",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant_cog"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +word1.target(attr_tags, true)
			         +"<2>"
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
			         word2.target(attr_lem, true)
			         +word2.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: ANT ANT ANT
	public void rule29__ant_cog__ant_cog__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule29__ant_cog__ant_cog__ant_cog",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant_cog"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +word1.target(attr_tags, true)
			         +"<2>"
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
			         word2.target(attr_lem, true)
			         +word2.target(attr_tags, true)
			         +"<2>"
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
			         word3.target(attr_lem, true)
			         +word3.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: ANT ANT ANT ANT
	public void rule30__ant_cog__ant_cog__ant_cog__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule30__ant_cog__ant_cog__ant_cog__ant_cog",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant_ant_cog_cog"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +word1.target(attr_tags, true)
			         +"<2>"
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
			         word2.target(attr_lem, true)
			         +word2.target(attr_tags, true)
			         +"<2>"
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
			         word3.target(attr_lem, true)
			         +word3.target(attr_tags, true)
			         +"<2>"
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
			         word4.target(attr_lem, true)
			         +word4.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: ANT - ANT ANT
	public void rule31__ant_cog__guio__ant_cog__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule31__ant_cog__guio__ant_cog__ant_cog",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant-ant_cog"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +word1.target(attr_tags, true)
			         +"<2>"
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
			         word2.target(attr_whole, true)
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
			         word3.target(attr_lem, true)
			         +word3.target(attr_tags, true)
			         +"<2>"
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
			         word4.target(attr_lem, true)
			         +word4.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: ANT ANT - ANT
	public void rule32__ant_cog__ant_cog__guio__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule32__ant_cog__ant_cog__guio__ant_cog",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant_cog-cog"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +word1.target(attr_tags, true)
			         +"<2>"
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
			         word2.target(attr_lem, true)
			         +word2.target(attr_tags, true)
			         +"<2>"
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
			         word3.target(attr_whole, true)
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
			         word4.target(attr_lem, true)
			         +word4.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: ANT - ANT ANT - ANT
	public void rule33__ant_cog__guio__ant_cog__ant_cog__guio__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule33__ant_cog__guio__ant_cog__ant_cog__guio__ant_cog",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant-ant_cog-cog"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +word1.target(attr_tags, true)
			         +"<2>"
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
			         word2.target(attr_whole, true)
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
			         word3.target(attr_lem, true)
			         +word3.target(attr_tags, true)
			         +"<2>"
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
			         word4.target(attr_lem, true)
			         +word4.target(attr_tags, true)
			         +"<2>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank4);
		{
			String myword = 
			         word5.target(attr_whole, true)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank5);
		{
			String myword = 
			         word6.target(attr_lem, true)
			         +word6.target(attr_tags, true)
			         +"<2>"
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
	
	// REGLA: NOM/ANT 's NOM:  gardener's dog => la hundo de gxardenisto
	public void rule34__genitive_possessors__gen__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule34__genitive_possessors__gen__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_nomvar_if_known1(out, word1);
		macro_ordigu_genron(out, word1);
		macro_ordigu_genron(out, word3);
		macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_gen_nom"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word3.target(attr_lem, true)
			/**  hundo  */
			         +word3.target(attr_tags, true)
			         +"<2>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(var_blanko);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
		{
			String myword = 
			         word2.target(attr_whole, true)
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
		{
			String myword = 
			         word1.target(attr_lem, true)
			/**  gxardenisto  */
			         +word1.target(attr_tags, true)
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
	public void rule35__genitive_possessors__gen__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule35__genitive_possessors__gen__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_nomvar_if_known1(out, word1);
		macro_ordigu_genron(out, word1);
		macro_ordigu_genron(out, word3);
		macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_gen_nom"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word3.target(attr_lem, true)
			/**  hundo  */
			         +word3.target(attr_tags, true)
			         +"<2>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(var_blanko);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
		{
			String myword = 
			         word2.target(attr_whole, true)
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
		{
			String myword = 
			         word1.target(attr_lem, true)
			/**  gxardenisto  */
			         +word1.target(attr_tags, true)
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
	public void rule36__genitive_possessors__gen__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
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
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word3.target(attr_lem, true)
			/**  hundA  */
			         +"<adj>"
			         +word3.target(attr_a_acr, true)
			/**  se estas akronimo  */
			         +word3.target(attr_a_gen, true)
			/**  se havas genron  */
			         +word4.target(attr_a_nbr, true)
			         +"<2>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(var_blanko);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
		{
			String myword = 
			         word4.target(attr_lem, true)
			/**  domo  */
			         +word4.target(attr_tags, true)
			         +"<2>"
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
			         word2.target(attr_whole, true)
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
		{
			String myword = 
			         word1.target(attr_lem, true)
			/**  gxardenisto  */
			         +word1.target(attr_tags, true)
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
	public void rule37__det__genitive_possessors__gen__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule37__det__genitive_possessors__gen__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_set_nomvar_if_known1(out, word2);
		macro_ordigu_genron(out, word2);
		macro_ordigu_genron(out, word4);
		macro_set_determiner_de_genitivo2(out, word1, blank1, word2);
		word1.setTarget(attr_lem, TransferWord.copycase("aa", word1.target(attr_lem, true)), true);
		macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
		var_tmp2 = var_blanko;
		macro_set_blankon_se_havas_formaton2(out, word2, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_gen_det_nom"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         TransferWord.copycase(word1.source(attr_lem, true), "la")
			         +"<det><def><sp>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  la  */
		out.append(var_tmp2);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
		{
			String myword = 
			         word4.target(attr_lem, true)
			/**  hundo  */
			         +word4.target(attr_tags, true)
			         +"<2>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(var_blanko);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
		{
			String myword = 
			         word3.target(attr_whole, true)
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
		{
			String myword = 
			         word2.target(attr_lem, true)
			/**  gxardenisto  */
			         +word2.target(attr_tags, true)
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
	public void rule38__det__genitive_possessors__genitive_possessors__gen__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
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
		out.append("<SN><nom>");
		out.append('{');
		out.append(var_tmp2);
		{
			String myword = 
			         TransferWord.copycase(word1.source(attr_lem, true), "la")
			         +"<det><def><sp>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  la  */
		out.append(blank2);
		{
			String myword = 
			         word5.target(attr_lem, true)
			/**  hundo  */
			         +word5.target(attr_tags, true)
			         +"<2>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(var_blanko);
		/**  senspaca, sed eble estas aliaj aferoj en gxi  */
		out.append(" ");
		{
			String myword = 
			         word4.target(attr_whole, true)
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
		{
			String myword = 
			         word2.target(attr_lem, true)
			/**  ĝardeno  */
			         +word2.target(attr_tags, true)
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
		{
			String myword = 
			         word3.target(attr_lem, true)
			/**  viro   */
			         +word3.target(attr_tags, true)
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
	public void rule39__and_or_nor(Writer out, TransferWord word1) throws IOException
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
			         word1.target(attr_whole, true)
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
	public void rule40__cnjcoo(Writer out, TransferWord word1) throws IOException
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
			         word1.target(attr_whole, true)
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
	
	public void rule41__cnjadv(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule41__cnjadv",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "cnjadv"));
		out.append("<CA>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	
	public void rule42__cnjsub(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule42__cnjsub",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "CS"));
		out.append("<NUM>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	
	public void rule43__cm(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule43__cm",  word1); } 
		out.append('^');
		out.append("cm");
		out.append("<CM>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	public void rule44__rel(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule44__rel",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "rel"));
		out.append("<REL>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	public void rule45__preadv(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule45__preadv",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "preadv"));
		out.append("<PREADV>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	public void rule46__predet(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule46__predet",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "predet"));
		out.append("<PREDET>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	public void rule47__adv(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule47__adv",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append("<Adv>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	public void rule48__pr(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule48__pr",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr"));
		out.append("<PREP>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	public void rule49__gen(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule49__gen",  word1); } 
		out.append('^');
		out.append("gen");
		out.append("<GEN>");
		out.append('{');
		{
			String myword = 
			         "a"
			         +"<gen>"
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
	
	// REGLA: SENT ;: - frazparto
	public void rule50__sent_komopunkto_dupunkto(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule50__sent_komopunkto_dupunkto",  word1); } 
		out.append('^');
		out.append("sent");
		out.append("<S>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	public void rule51__sent(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule51__sent",  word1); } 
		var_EOS = "true";
		out.append('^');
		out.append("sent");
		out.append("<S>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	
	public void rule52__unknown(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule52__unknown",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "unknown"));
		/**  Traktu nekonatajn vortojn kiel nomoj en la venontaj stagxo  */
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
	public void rule53__to__vblexinf(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule53__to__vblexinf",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word2);
		macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verbInf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word2.target(attr_a_tns, true));
		out.append('{');
		{
			String myword = 
			         word2.target(attr_lemh, true)
			         +word2.target(attr_a_vrb, true)
			         +"<3>"
			         +word2.target(attr_lemq, true)
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
	
	// REGLA: of VBLEXger - of being, of running, of looking - esti, kuri, vidi
	public void rule54__of__vblexger(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule54__of__vblexger",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word2);
		macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verbInf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append("<inf>");
		out.append('{');
		{
			String myword = 
			         word2.target(attr_lemh, true)
			         +word2.target(attr_a_vrb, true)
			         +"<3>"
			         +word2.target(attr_lemq, true)
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
	
	// REGLA: to have suffered  -  suferi
	public void rule55__to__vbhaverinf__vblex_vbser(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
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
		out.append("<inf>");
		out.append('{');
		{
			String myword = 
			         word3.target(attr_lemh, true)
			         +word3.target(attr_a_vrb, true)
			         +"<3>"
			         +word3.target(attr_lemq, true)
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
	
	/**  ^be/be<vbser><inf>$ ^being/be<vbser><ger>$  ^been/be<vbser><pp>$ ^applying/apply<vblex><ger>$   */
	// REGLA: be VBLEXger
	public void rule56__vbser__vblexger(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule56__vbser__vblexger",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "be_vbger"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.target(attr_a_tns, true));
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +word1.target(attr_a_vrb, true)
			         +"<3>"
			         +word1.target(attr_lemq, true)
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
			         word2.target(attr_lemh, true)
			         +word2.target(attr_a_vrb, true)
			         +word2.target(attr_a_tns, true)
			         +word2.target(attr_lemq, true)
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
	public void rule57__vblex__out(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule57__vblex__out",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word1);
		macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "el_verb"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.target(attr_a_tns, true));
		out.append('{');
		{
			String myword = 
			         "el"
			         +"<adv>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_vrb, true)
			         +"<3>"
			         +word1.target(attr_lemq, true)
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
	
	// REGLA: VBSER not
	public void rule58__vbser__not(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule58__vbser__not",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ser_not"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.target(attr_a_tns, true));
		out.append('{');
		{
			String myword = 
			         word2.target(attr_whole, true)
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
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_vrb, true)
			         +"<3>"
			         +word1.target(attr_lemq, true)
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
	
	// RULE: please + vblex in present => please + vblex in infinitive
	public void rule59__please__c_vblex_pres(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule59__please__c_vblex_pres",  word1, blank1,  word2); } 
		macro_set_tipus_verbs1(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pls_verb1"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.target(attr_a_tns, true));
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lem, true)
			         +word1.target(attr_a_vrb, true)
			         +"<3>"
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
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pls_verb2"));
		out.append(word2.target(attr_a_tns, true));
		out.append('{');
		{
			String myword = 
			         word2.target(attr_lem, true)
			         +word2.target(attr_a_vrb, true)
			         +"<inf>"
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
	
	// REGLA: do ADV VERB (I do not think -> mi ne pensas. I do always think -> mi ja ĉiam pensas)
	public void rule60__do__adv__infpres(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule60__do__adv__infpres",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word3);
		macro_set_verbkonj2_do(out, word1, blank2, word3);
		if (!word2.source(attr_lem, true).equalsIgnoreCase("not"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "ja2"));
			out.append("<Adv>");
			out.append('{');
			{
				String myword = 
				         "ja"
				         +"<adv>"
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
			var_caseFirstWord = "aa";
		}
		else
		{
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv2"));
		out.append("<Adv>");
		out.append('{');
		{
			String myword = 
			         word2.target(attr_whole, true)
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
		out.append('^');
		out.append("verbcj");
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.target(attr_a_tns, true));
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
	public void rule61__do__infpres(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule61__do__infpres",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word2);
		macro_set_verbkonj2_do(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ja"));
		out.append("<Adv>");
		out.append('{');
		{
			String myword = 
			         "ja"
			         +"<adv>"
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
		out.append('^');
		out.append("verbcj2");
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.target(attr_a_tns, true));
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
	public void rule62__vaux_vbhaver__vblex_vbser(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule62__vaux_vbhaver__vblex_vbser",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word2);
		if (list_willwouldshallhave.containsIgnoreCase(word1.source(attr_lem, true)))
		{
			macro_set_temps1(out, word1);
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb2"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
			{
				String myword = 
				         word2.target(attr_lemh, true)
				         +word2.target(attr_a_vrb, true)
				         +"<3>"
				         +word2.target(attr_lemq, true)
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
		if (((word1.source(attr_lem, true).equalsIgnoreCase("can")
    && word1.source(attr_a_tns, true).equalsIgnoreCase("<past>"))
    || word1.source(attr_lem, true).equalsIgnoreCase("might")))
		{
			var_temps = "<cni>";
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append("<inf>");
			out.append('{');
			{
				String myword = 
				         "povi"
				         +"<vaux><cni>"
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
				         word2.target(attr_lemh, true)
				         +word2.target(attr_a_vrb, true)
				         +"<3>"
				         +word2.target(attr_lemq, true)
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
			var_temps = word2.source(attr_a_tns, true);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb2"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(word1.target(attr_a_tns, true));
			out.append('{');
			{
				String myword = 
				         word1.target(attr_lemh, true)
				         +word1.target(attr_a_vrb, true)
				         +"<3>"
				         +word1.target(attr_lemq, true)
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
				         word2.target(attr_lemh, true)
				         +word2.target(attr_a_vrb, true)
				         +var_temps
				         +word2.target(attr_lemq, true)
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
	public void rule63__vaux_vbhaver__adv__vblex_vbser(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule63__vaux_vbhaver__adv__vblex_vbser",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word3);
		if (list_willwouldshallhave.containsIgnoreCase(word1.source(attr_lem, true)))
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
				         word2.target(attr_whole, true)
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
				         word3.target(attr_lemh, true)
				         +word3.target(attr_a_vrb, true)
				         +"<3>"
				         +word3.target(attr_lemq, true)
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
		if (((word1.source(attr_lem, true).equalsIgnoreCase("can")
    && word1.source(attr_a_tns, true).equalsIgnoreCase("<past>"))
    || word1.source(attr_lem, true).equalsIgnoreCase("might")))
		{
			var_temps = "<cni>";
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb3"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append("<inf>");
			out.append('{');
			{
				String myword = 
				         word2.target(attr_whole, true)
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
				         "povi"
				         +"<vaux><cni>"
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
				         word3.target(attr_lemh, true)
				         +word3.target(attr_a_vrb, true)
				         +"<3>"
				         +word3.target(attr_lemq, true)
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
			var_temps = word3.source(attr_a_tns, true);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb4"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
			{
				String myword = 
				         word2.target(attr_whole, true)
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
				         word1.target(attr_whole, true)
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
				         word3.target(attr_lemh, true)
				         +word3.target(attr_a_vrb, true)
				         +"<3>"
				         +word3.target(attr_lemq, true)
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
	
	// REGLA: VAUX ADV ADV VBLEX - have also abruptly changed - ankaŭ abrupte ŝanĝis
	public void rule64__vaux_vbhaver__adv__adv__vblex_vbser(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule64__vaux_vbhaver__adv__adv__vblex_vbser",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word4);
		if (list_willwouldshallhave.containsIgnoreCase(word1.source(attr_lem, true)))
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
				         word2.target(attr_whole, true)
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
				         word3.target(attr_whole, true)
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
				         word4.target(attr_lemh, true)
				         +word4.target(attr_a_vrb, true)
				         +"<3>"
				         +word4.target(attr_lemq, true)
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
		if (((word1.source(attr_lem, true).equalsIgnoreCase("can")
    && word1.source(attr_a_tns, true).equalsIgnoreCase("<past>"))
    || word1.source(attr_lem, true).equalsIgnoreCase("might")))
		{
			var_temps = "<cni>";
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb5"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append("<inf>");
			out.append('{');
			{
				String myword = 
				         word2.target(attr_whole, true)
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
				         word3.target(attr_whole, true)
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
				         "povi"
				         +"<vaux><cni>"
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
				         word4.target(attr_lemh, true)
				         +word4.target(attr_a_vrb, true)
				         +"<3>"
				         +word4.target(attr_lemq, true)
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
			var_temps = word4.source(attr_a_tns, true);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb6"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
			{
				String myword = 
				         word1.target(attr_whole, true)
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
				         word2.target(attr_whole, true)
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
				         word3.target(attr_whole, true)
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
				         word4.target(attr_lemh, true)
				         +word4.target(attr_a_vrb, true)
				         +"<3>"
				         +word4.target(attr_lemq, true)
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
	
	// REGLA: VAUX VBHAVER VBLEX/VBSER - would have been,  would have ended,  might have allowed,  could have levelled out, may have represented,  might have been
	public void rule65__vaux_vbhaver__vbhaver__vblex_vbser(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule65__vaux_vbhaver__vbhaver__vblex_vbser",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word3);
		if (list_willwouldshallhave.containsIgnoreCase(word1.source(attr_lem, true)))
		{
			macro_set_temps1(out, word1);
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb_pp"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append("<pp3>");
			out.append('{');
			{
				String myword = 
				         "esti"
				         +"<vbser>"
				         +var_temps
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
				         word3.target(attr_lemh, true)
				         +word3.target(attr_a_vrb, true)
				         +"<3>"
				         +word3.target(attr_lemq, true)
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
		if (word1.source(attr_lem, true).equalsIgnoreCase("may"))
		{
			var_temps = "<past>";
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb3a"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
			{
				String myword = 
				         "eble"
				         +"<adv>"
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
				         word3.target(attr_lemh, true)
				         +word3.target(attr_a_vrb, true)
				         +"<3>"
				         +word3.target(attr_lemq, true)
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
		if (word1.source(attr_lem, true).equalsIgnoreCase("might"))
		{
			var_temps = "<cni>";
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb3b"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
			{
				String myword = 
				         "eble"
				         +"<adv>"
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
				         word3.target(attr_lemh, true)
				         +word3.target(attr_a_vrb, true)
				         +"<3>"
				         +word3.target(attr_lemq, true)
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
		if ((word1.source(attr_lem, true).equalsIgnoreCase("can")
    || word1.source(attr_a_tns, true).equals("past")))
		{
			var_temps = "<cni>";
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_pp"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append("<inf>");
			out.append('{');
			{
				String myword = 
				         "povi"
				         +"<vaux><past>"
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
				         word3.target(attr_lemh, true)
				         +word3.target(attr_a_vrb, true)
				         +"<3>"
				         +word3.target(attr_lemq, true)
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
			var_temps = "<past>";
			if (word1.source(attr_lem, true).equalsIgnoreCase("should"))
			{
				var_temps = "<cni>";
			}
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb7"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
			{
				String myword = 
				         word1.target(attr_lemh, true)
				         +word1.target(attr_a_vrb, true)
				         +"<3>"
				         +word1.target(attr_lemq, true)
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
				         word3.target(attr_lemh, true)
				         +word3.target(attr_a_vrb, true)
				         +"<inf>"
				         +word3.target(attr_lemq, true)
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
	
	// REGLA: VAUX VBSER VBLEXGER
	public void rule66__vaux_vbhaver__vbser__vblexger(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule66__vaux_vbhaver__vbser__vblexger",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word3);
		if (list_willwouldshallhave.containsIgnoreCase(word1.source(attr_lem, true)))
		{
			macro_set_temps1(out, word1);
			macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb_vbger"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
			{
				String myword = 
				         word2.target(attr_lemh, true)
				         +word2.target(attr_a_vrb, true)
				         +"<3>"
				         +word2.target(attr_lemq, true)
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
				         word3.target(attr_whole, true)
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
			var_temps = word2.source(attr_a_tns, true);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "vaux_verb8"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps);
			out.append('{');
			{
				String myword = 
				         word1.target(attr_whole, true)
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
				         word2.target(attr_lemh, true)
				         +word2.target(attr_a_vrb, true)
				         +"<3>"
				         +word2.target(attr_lemq, true)
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
				         word3.target(attr_whole, true)
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
	public void rule67__vbdo(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule67__vbdo",  word1); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "vbdo"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.target(attr_a_tns, true));
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_vrb, true)
			         +"<3>"
			         +word1.target(attr_lemq, true)
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
	
	public void rule68__vb_all(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule68__vb_all",  word1); } 
		macro_firstWord(out, word1);
		macro_set_tipus_verbs1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verb_all"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word1.target(attr_a_tns, true));
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_vrb, true)
			         +"<3>"
			         +word1.target(attr_lemq, true)
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
