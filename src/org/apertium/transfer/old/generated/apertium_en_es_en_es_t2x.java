package org.apertium.transfer.old.generated;
import java.io.*;
import org.apertium.transfer.*;
import org.apertium.transfer.generated.GeneratedTransferBase;
import org.apertium.interchunk.InterchunkWord;
public class apertium_en_es_en_es_t2x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return false;
	}
	ApertiumRE attr_pers = new ApertiumRE("<(?:p1|p2|p3|PD)>");
	ApertiumRE attr_gen = new ApertiumRE("<(?:mf|GD|nt|m|f)>");
	ApertiumRE attr_nbr = new ApertiumRE("<(?:sg|pl|sp|ND)>");
	/** MG: caldria treure totes les referències a ifip en les regles  */
	ApertiumRE attr_temps = new ApertiumRE("<(?:pres|past|ifip|pprs|subs|inf|pri|cni|fti|ger|imp|ifi|pii|pis|prs|pp)>");
	ApertiumRE attr_a_verb = new ApertiumRE("<(?:vblex><pron|vbhaver|vblex|vbser|vbmod|HAVER)>");
	/** 'Per determinar', per a SN UNDET que han de passar a determinats, transformació que farà el postchunk detectant els PDET.  */
	ApertiumRE attr_a_SN = new ApertiumRE("<(?:UNDET|UNDEF|PDET|DET|NUM)>");
	ApertiumRE attr_tipus_prn = new ApertiumRE("<(?:obj|enc|itg|pos|tn)>");
	ApertiumRE attr_a_negacio = new ApertiumRE("<negacio>");
	ApertiumRE attr_lem = new ApertiumRE("(([^<]|\"\\<\")+)");
	ApertiumRE attr_lemq = new ApertiumRE("\\#[- _][^<]+");
	ApertiumRE attr_lemh = new ApertiumRE("(([^<#]|\"\\<\"|\"\\#\")+)");
	ApertiumRE attr_whole = new ApertiumRE("(.+)");
	ApertiumRE attr_tags = new ApertiumRE("((<[^>]+>)+)");
	ApertiumRE attr_chname = new ApertiumRE("(\\{([^/]+)\\/)");
	ApertiumRE attr_chcontent = new ApertiumRE("(\\{.+)");
	ApertiumRE attr_content = new ApertiumRE("(\\{.+)");
	String var_uno = "";
	String var_nombre = "<sg>";
	String var_genere = "";
	
	private void macro_determina_nbr_gen_SN(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("macro_determina_nbr_gen_SN",  word1); } 
		/** To determine value of variables of gender and
		  number and propagate to other rules.  Variables are
		  not used again in this rule  */
		if (word1.tl(attr_nbr).equals("<sg>"))
		{
			var_nombre = "<sg>";
		}
		else
		if (word1.tl(attr_nbr).equals("<pl>"))
		{
			var_nombre = "<pl>";
		}
		else
		{
			var_nombre = "<sg>";
		}
		if (word1.tl(attr_gen).equals("<m>"))
		{
			var_genere = "<m>";
		}
		else
		if (word1.tl(attr_gen).equals("<f>"))
		{
			var_genere = "<f>";
		}
		else
		{
			var_genere = "<m>";
		}
	}
	
	private void macro_f_bcond(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("macro_f_bcond",  word1); } 
		/** Per mirar si el blanc conté o no format. Cal posar aquesta funció en les regles en què desaparegui alguna paraula, per tal de decidir si el blanc de la paraula eliminada s'ha d'eliminar o conservar. Si conté format cal conservar-la, si no en conté cal eliminar-la perquè no apareguin dos espais seguits.  */
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <interchunk>/<section-def-macros>/<def-macro n="f_bcond" npar="1">/<choose>/<when>/<test>/<not>/<equal>/<b pos="1">
		if (!"".equals(" "))
		{
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <interchunk>/<section-def-macros>/<def-macro n="f_bcond" npar="1">/<choose>/<when>/<out>/<b pos="1">
			out.append("");
		}
	}
	
	private void macro_concord_SN_SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2) throws IOException
	{
		if (debug) { logCall("macro_concord_SN_SV",  word1, blank1,  word2); } 
		if ((word1.tl(attr_lem).equalsIgnoreCase("prnsubj")
    || word1.tl(attr_lem).equalsIgnoreCase("prnsubj2")))
		{
			if ((((word2.tl(attr_pers).equals("<p3>")
    && word2.tl(attr_lem).equalsIgnoreCase("pro_verbcj"))
    || word2.tl(attr_pers).equals("<PD>"))
    && !word2.tl(attr_temps).equals("<ger>")))
			{
				word2.tlSet(attr_pers, word1.tl(attr_pers));
				if ((word1.tl(attr_nbr).equals("<sg>")
    && word1.tl(attr_pers).equals("<p3>")))
				{
					word2.tlSet(attr_temps, "<prs>");
				}
			}
			if ((word2.tl(attr_nbr).equals("<ND>")
    && !word2.tl(attr_temps).equals("<ger>")))
			{
				word2.tlSet(attr_nbr, word1.tl(attr_nbr));
			}
			if (word2.tl(attr_gen).equals("<GD>"))
			{
				if (!word1.tl(attr_gen).equals("<mf>"))
				{
					word2.tlSet(attr_gen, word1.tl(attr_gen));
				}
				else
				{
					word2.tlSet(attr_gen, "<m>");
				}
			}
		}
		else
		{
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				if ((word2.tl(attr_temps).equals("<pri>")
    && word2.tl(attr_nbr).equals("<ND>")))
				{
					word1.tlSet(attr_nbr, "<pl>");
				}
				else
				if (word2.tl(attr_temps).equals("<pri>"))
				{
					word1.tlSet(attr_nbr, "<sg>");
				}
				else
				if ((word2.tl(attr_temps).equals("<ifip>")
    && word2.tl(attr_lem).equalsIgnoreCase("be")
    && word2.tl(attr_nbr).equals("<ND>")))
				{
					word1.tlSet(attr_nbr, "<pl>");
				}
				else
				{
					word1.tlSet(attr_nbr, "<sg>");
				}
			}
			if ((word2.tl(attr_pers).equals("<PD>")
    && !word2.tl(attr_temps).equals("<ger>")))
			{
				word2.tlSet(attr_pers, "<p3>");
			}
			if ((word2.tl(attr_nbr).equals("<ND>")
    && !word2.tl(attr_temps).equals("<ger>")))
			{
				if (!word1.tl(attr_nbr).equals("<sp>"))
				{
					word2.tlSet(attr_nbr, word1.tl(attr_nbr));
				}
				else
				{
					word2.tlSet(attr_nbr, "<sg>");
				}
			}
			if (word2.tl(attr_gen).equals("<GD>"))
			{
				if (!word1.tl(attr_gen).equals("<mf>"))
				{
					word2.tlSet(attr_gen, word1.tl(attr_gen));
				}
				else
				{
					word2.tlSet(attr_gen, "<m>");
				}
			}
		}
	}
	
	private void macro_concord_SNcoo_SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("macro_concord_SNcoo_SV",  word1, blank1,  word2, blank2,  word3); } 
		/** per a 2 sintagmes nominals, coordinats entre sí. El nombre del SV serà sempre pl. 
Arreglar si pot ser alguns errors de concordança encara:
You and your mother will come - Tu i la vostra mare vindreu
Your mother and you will come - La vostra mare i tu vindran
 */
		if ((word1.tl(attr_lem).equalsIgnoreCase("prnsubj")
    || word1.tl(attr_lem).equalsIgnoreCase("prnsubj2")))
		{
			if ((word3.tl(attr_pers).equals("<PD>")
    && !word3.tl(attr_temps).equals("<ger>")))
			{
				word3.tlSet(attr_pers, word1.tl(attr_pers));
			}
			if ((word3.tl(attr_nbr).equals("<ND>")
    && !word2.tl(attr_temps).equals("<ger>")))
			{
				word3.tlSet(attr_nbr, "<pl>");
			}
			if (word3.tl(attr_gen).equals("<GD>"))
			{
				if ((!word1.tl(attr_gen).equals("<mf>")
    && word1.tl(attr_gen).equals(word2.tl(attr_gen))))
				{
					word3.tlSet(attr_gen, word1.tl(attr_gen));
				}
				else
				{
					word3.tlSet(attr_gen, "<m>");
				}
			}
		}
		else
		{
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				if ((word3.tl(attr_temps).equals("<pri>")
    && word3.tl(attr_nbr).equals("<ND>")))
				{
					word1.tlSet(attr_nbr, "<pl>");
				}
				else
				if (word3.tl(attr_temps).equals("<pri>"))
				{
					word1.tlSet(attr_nbr, "<sg>");
				}
				else
				if ((word3.tl(attr_temps).equals("<ifip>")
    && word3.tl(attr_lem).equalsIgnoreCase("be")
    && word3.tl(attr_nbr).equals("<ND>")))
				{
					word1.tlSet(attr_nbr, "<pl>");
				}
				else
				{
					word1.tlSet(attr_nbr, "<sg>");
				}
			}
			if ((word3.tl(attr_pers).equals("<PD>")
    && !word3.tl(attr_temps).equals("<ger>")))
			{
				word3.tlSet(attr_pers, "<p3>");
			}
			if ((word3.tl(attr_nbr).equals("<ND>")
    && !word3.tl(attr_temps).equals("<ger>")))
			{
				word3.tlSet(attr_nbr, "<pl>");
			}
			if (word3.tl(attr_gen).equals("<GD>"))
			{
				if ((!word1.tl(attr_gen).equals("<mf>")
    && word1.tl(attr_gen).equals(word2.tl(attr_gen))))
				{
					word3.tlSet(attr_gen, word1.tl(attr_gen));
				}
				else
				{
					word3.tlSet(attr_gen, "<m>");
				}
			}
		}
		/**  per al segon SN, repassar */
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			word2.tlSet(attr_gen, "<m>");
		}
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			word2.tlSet(attr_nbr, "<sg>");
		}
	}
	
	private void macro_posadet_SN(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("macro_posadet_SN",  word1); } 
		if ((word1.tl(attr_lem).equalsIgnoreCase("nom")
    || word1.tl(attr_lem).equalsIgnoreCase("nom_adj")
    || word1.tl(attr_lem).equalsIgnoreCase("nom_'adj'")
    || word1.tl(attr_lem).equalsIgnoreCase("'nom'_adj")
    || word1.tl(attr_lem).equalsIgnoreCase("nom_conj_nom")
    || word1.tl(attr_lem).equalsIgnoreCase("nom_adj_adj")))
		{
			word1.tlSet(attr_a_SN, "<PDET>");
		}
	}
	
	/** REGLES LÈXIQUES: definides en primer lloc perquè si no es posen per altres regles  */
	// REGLA: SN like SN
	public void rule0__SN__vblike__SNnorel(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule0__SN__vblike__SNnorel",  word1, blank1,  word2, blank2,  word3); } 
		macro_posadet_SN(out, word3);
		/**  primer assignem els canvis necessaris al verb */
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		word2.tlSet(attr_pers, "<p3>");
		word2.tlSet(attr_nbr, word3.tl(attr_nbr));
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj2"))
		{
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
			{
				String myword = 
				         TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lem))
				         +word1.tl(attr_tags)
				         +word1.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
		}
		/**  quan el subjecte és un pronom... */
		if ((word1.tl(attr_lem).equalsIgnoreCase("prnsubj")
    || word1.tl(attr_lem).equalsIgnoreCase("prnsubj2")))
		{
			/** ...creo un chunk que tindrà un pronom feble  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "prpers"));
			out.append("<prn><pro>");
			out.append(word1.tl(attr_pers));
			out.append("<mf>");
			out.append(word1.tl(attr_nbr));
			out.append("$}$");
			out.append(blank1);
		}
		else
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
			if (!word1.tl(attr_nbr).equals("<pl>"))
			{
				var_nombre = "<sg>";
			}
			else
			{
				var_nombre = "<pl>";
			}
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
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
			/** ...i un altre amb un pronom feble (nois els agraden les patates)  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word2.sl(attr_lem), "prpers"));
			out.append("<prn><pro><p3><mf>");
			out.append(var_nombre);
			out.append("$}$ ");
		}
		/** Assigna gènere i nombre al segon SN (GD i ND)  */
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			word3.tlSet(attr_gen, "<m>");
		}
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			word3.tlSet(attr_nbr, "<sg>");
		}
		/** envio el verb amb la persona i el nombre canviats (he fet els canvis dalt de tot) */
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
		/**  i envio també el segon SN */
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
		macro_determina_nbr_gen_SN(out, word3);
	}
	
	// REGLA: SN adv like SN
	public void rule1__SN__ADV__vblike__SNnorel(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule1__SN__ADV__vblike__SNnorel",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_posadet_SN(out, word4);
		/**  primer assignem els canvis necessaris al verb */
		if (word3.tl(attr_temps).equals("<inf>"))
		{
			word3.tlSet(attr_temps, "<pri>");
		}
		word3.tlSet(attr_pers, "<p3>");
		word3.tlSet(attr_nbr, word4.tl(attr_nbr));
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj2"))
		{
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
			{
				String myword = 
				         TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lem))
				         +word1.tl(attr_tags)
				         +word1.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
		}
		/**  quan el subjecte és un pronom... */
		if ((word1.tl(attr_lem).equalsIgnoreCase("prnsubj")
    || word1.tl(attr_lem).equalsIgnoreCase("prnsubj2")))
		{
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
			/** ...creo un chunk que tindrà un pronom feble  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "prpers"));
			out.append("<prn><pro>");
			out.append(word1.tl(attr_pers));
			out.append("<mf>");
			out.append(word1.tl(attr_nbr));
			out.append("$}$");
			out.append(blank2);
		}
		else
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
			if (!word1.tl(attr_nbr).equals("<pl>"))
			{
				var_nombre = "<sg>";
			}
			else
			{
				var_nombre = "<pl>";
			}
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
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
			/**  l'adv */
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
			/** ...i un altre amb un pronom feble (als nois no els agraden les patates)  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word3.sl(attr_lem), "prpers"));
			out.append("<prn><pro><p3><mf>");
			out.append(var_nombre);
			out.append("$}$ ");
		}
		/** Assigna gènere i nombre al segon SN (GD i ND)  */
		if (word4.tl(attr_gen).equals("<GD>"))
		{
			word4.tlSet(attr_gen, "<m>");
		}
		if (word4.tl(attr_nbr).equals("<ND>"))
		{
			word4.tlSet(attr_nbr, "<sg>");
		}
		/** envio el verb amb la persona i el nombre canviats (he fet els canvis dalt de tot) */
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
		/**  i envio també el segon SN */
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
		macro_determina_nbr_gen_SN(out, word4);
	}
	
	// REGLA: SN adv adv like SN (igual que l'anterior però amb dos adverbis, per a tractar: 'she really does not like potatoes'
	public void rule2__SN__ADV__ADV__vblike__SNnorel(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5) throws IOException
	{
		if (debug) { logCall("rule2__SN__ADV__ADV__vblike__SNnorel",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_posadet_SN(out, word5);
		/**  primer assignem els canvis necessaris al verb */
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		word4.tlSet(attr_pers, "<p3>");
		word4.tlSet(attr_nbr, word5.tl(attr_nbr));
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj2"))
		{
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
			{
				String myword = 
				         TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lem))
				         +word1.tl(attr_tags)
				         +word1.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
		}
		/**  quan el subjecte és un pronom... */
		if ((word1.tl(attr_lem).equalsIgnoreCase("prnsubj")
    || word1.tl(attr_lem).equalsIgnoreCase("prnsubj2")))
		{
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
			/** ...creo un chunk que tindrà un pronom feble  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "prpers"));
			out.append("<prn><pro>");
			out.append(word1.tl(attr_pers));
			out.append("<mf>");
			out.append(word1.tl(attr_nbr));
			out.append("$}$");
			out.append(blank3);
		}
		else
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
			if (!word1.tl(attr_nbr).equals("<pl>"))
			{
				var_nombre = "<sg>";
			}
			else
			{
				var_nombre = "<pl>";
			}
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
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
			/**  l'adv */
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
			/**  l'adv */
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
			/** ...i un altre amb un pronom feble (als nois no els agraden les patates)  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word4.sl(attr_lem), "prpers"));
			out.append("<prn><pro><p3><mf>");
			out.append(var_nombre);
			out.append("$}$ ");
		}
		/** Assigna gènere i nombre al segon SN (GD i ND)  */
		if (word5.tl(attr_gen).equals("<GD>"))
		{
			word5.tlSet(attr_gen, "<m>");
		}
		if (word5.tl(attr_nbr).equals("<ND>"))
		{
			word5.tlSet(attr_nbr, "<sg>");
		}
		/** envio el verb amb la persona i el nombre canviats (he fet els canvis dalt de tot) */
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
		/**  i envio també el segon SN */
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
		macro_determina_nbr_gen_SN(out, word5);
	}
	
	// REGLA: SN pro_vblike
	public void rule3__SN__pro_vblike(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2) throws IOException
	{
		if (debug) { logCall("rule3__SN__pro_vblike",  word1, blank1,  word2); } 
		/**  primer assignem els canvis que podem al verb */
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		/**  canvia el nom del chunk per poder-hi treballar més facilment al t3x */
		if (word2.tl(attr_lem).equalsIgnoreCase("pro_verbcj"))
		{
			word2.tlSet(attr_lem, "pro_vblike");
		}
		else
		{
			if ((word2.tl(attr_lem).equalsIgnoreCase("pro_auxmod_inf")
    || word2.tl(attr_lem).equalsIgnoreCase("pro_mod_inf")
    || word2.tl(attr_lem).equalsIgnoreCase("pro_have_pp")
    || word2.tl(attr_lem).equalsIgnoreCase("pro_be_ger")
    || word2.tl(attr_lem).equalsIgnoreCase("pro_do_inf")))
			{
				word2.tlSet(attr_lem, "pro_vblike2");
			}
			else
			{
				if (word2.tl(attr_lem).equalsIgnoreCase("pro_auxmod_mod_inf"))
				{
					word2.tlSet(attr_lem, "pro_vblike3");
				}
			}
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj2"))
		{
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
			{
				String myword = 
				         TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lem))
				         +word1.tl(attr_tags)
				         +word1.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
		}
		/**  quan el subjecte és un pronom... */
		if ((word1.tl(attr_lem).equalsIgnoreCase("prnsubj")
    || word1.tl(attr_lem).equalsIgnoreCase("prnsubj2")))
		{
			/** ...creo un chunk que tindrà un pronom feble  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "prpers"));
			out.append("<prn><pro>");
			out.append(word1.tl(attr_pers));
			out.append("<mf>");
			out.append(word1.tl(attr_nbr));
			out.append("$}$");
			out.append(blank1);
		}
		else
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
			if (!word1.tl(attr_nbr).equals("<pl>"))
			{
				var_nombre = "<sg>";
			}
			else
			{
				var_nombre = "<pl>";
			}
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
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
			/** ...i un altre amb un pronom feble (nois els agraden les patates)  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word2.sl(attr_lem), "prpers"));
			out.append("<prn><pro><p3><mf>");
			out.append(var_nombre);
			out.append("$}$ ");
		}
		/**  envio el verb al t3x amb uns canvis pendents de fer */
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
	}
	
	// REGLA: SN adv like-prn
	public void rule4__SN__ADV__pro_vblike(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule4__SN__ADV__pro_vblike",  word1, blank1,  word2, blank2,  word3); } 
		/**  primer assignem els canvis possibles al verb */
		if (word3.tl(attr_temps).equals("<inf>"))
		{
			word3.tlSet(attr_temps, "<pri>");
		}
		/**  canvia el nom del chunk per poder-hi treballar més facilment al t3x */
		if (word3.tl(attr_lem).equalsIgnoreCase("pro_verbcj"))
		{
			word3.tlSet(attr_lem, "pro_vblike");
		}
		else
		{
			if ((word3.tl(attr_lem).equalsIgnoreCase("pro_auxmod_inf")
    || word3.tl(attr_lem).equalsIgnoreCase("pro_mod_inf")
    || word3.tl(attr_lem).equalsIgnoreCase("pro_have_pp")
    || word3.tl(attr_lem).equalsIgnoreCase("pro_be_ger")
    || word3.tl(attr_lem).equalsIgnoreCase("pro_do_inf")))
			{
				word3.tlSet(attr_lem, "pro_vblike2");
			}
			else
			{
				if (word3.tl(attr_lem).equalsIgnoreCase("pro_auxmod_mod_inf"))
				{
					word3.tlSet(attr_lem, "pro_vblike3");
				}
			}
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj2"))
		{
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
			{
				String myword = 
				         TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lem))
				         +word1.tl(attr_tags)
				         +word1.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
		}
		/**  quan el subjecte és un pronom... */
		if ((word1.tl(attr_lem).equalsIgnoreCase("prnsubj")
    || word1.tl(attr_lem).equalsIgnoreCase("prnsubj2")))
		{
			/**  primer envio l'adverbi */
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
			/** ...creo un chunk que tindrà un pronom feble  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word2.sl(attr_lem), "prpers"));
			out.append("<prn><pro>");
			out.append(word1.tl(attr_pers));
			out.append("<mf>");
			out.append(word1.tl(attr_nbr));
			out.append("$}$");
			out.append(blank2);
		}
		else
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
			if (!word1.tl(attr_nbr).equals("<pl>"))
			{
				var_nombre = "<sg>";
			}
			else
			{
				var_nombre = "<pl>";
			}
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
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
			/**  l'adv */
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
			/** ...i un altre amb un pronom feble (als nois no els agraden les patates)  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word3.sl(attr_lem), "prpers"));
			out.append("<prn><pro><p3><mf>");
			out.append(var_nombre);
			out.append("$}$ ");
		}
		/** envio el verb al t3x amb canvis pendents */
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
	
	// REGLA: SN adv adv like-prn (igual que regla anterior però amb dos adverbis)
	public void rule5__SN__ADV__ADV__pro_vblike(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule5__SN__ADV__ADV__pro_vblike",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		/**  primer assignem els canvis possibles al verb */
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		/**  canvia el nom del chunk per poder-hi treballar més facilment al t3x */
		if (word4.tl(attr_lem).equalsIgnoreCase("pro_verbcj"))
		{
			word4.tlSet(attr_lem, "pro_vblike");
		}
		else
		{
			if ((word4.tl(attr_lem).equalsIgnoreCase("pro_auxmod_inf")
    || word4.tl(attr_lem).equalsIgnoreCase("pro_mod_inf")
    || word4.tl(attr_lem).equalsIgnoreCase("pro_have_pp")
    || word4.tl(attr_lem).equalsIgnoreCase("pro_be_ger")
    || word4.tl(attr_lem).equalsIgnoreCase("pro_do_inf")))
			{
				word4.tlSet(attr_lem, "pro_vblike2");
			}
			else
			{
				if (word4.tl(attr_lem).equalsIgnoreCase("pro_auxmod_mod_inf"))
				{
					word4.tlSet(attr_lem, "pro_vblike3");
				}
			}
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj2"))
		{
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
			{
				String myword = 
				         TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lem))
				         +word1.tl(attr_tags)
				         +word1.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
		}
		/**  quan el subjecte és un pronom... */
		if ((word1.tl(attr_lem).equalsIgnoreCase("prnsubj")
    || word1.tl(attr_lem).equalsIgnoreCase("prnsubj2")))
		{
			/**  primer envio l'adverbi */
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
			/**  el segon adverbi */
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
			/** ...creo un chunk que tindrà un pronom feble  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word3.sl(attr_lem), "prpers"));
			out.append("<prn><pro>");
			out.append(word1.tl(attr_pers));
			out.append("<mf>");
			out.append(word1.tl(attr_nbr));
			out.append("$}$");
			out.append(blank3);
		}
		else
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
			if (!word1.tl(attr_nbr).equals("<pl>"))
			{
				var_nombre = "<sg>";
			}
			else
			{
				var_nombre = "<pl>";
			}
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
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
			/**  l'adv */
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
			/**  l'adv */
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
			/** ...i un altre amb un pronom feble (als nois no els agraden les patates)  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word3.sl(attr_lem), "prpers"));
			out.append("<prn><pro><p3><mf>");
			out.append(var_nombre);
			out.append("$}$ ");
		}
		/** envio el verb al t3x amb canvis pendents */
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
	
	// REGLA: SN vblike
	public void rule6__SN__vblike(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2) throws IOException
	{
		if (debug) { logCall("rule6__SN__vblike",  word1, blank1,  word2); } 
		/**  primer assignem els canvis que podem al verb */
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		word2.tlSet(attr_pers, "<p3>");
		word2.tlSet(attr_nbr, "<sg>");
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj2"))
		{
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
			{
				String myword = 
				         TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lem))
				         +word1.tl(attr_tags)
				         +word1.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
		}
		/**  quan el subjecte és un pronom... */
		if ((word1.tl(attr_lem).equalsIgnoreCase("prnsubj")
    || word1.tl(attr_lem).equalsIgnoreCase("prnsubj2")))
		{
			/** ...creo un chunk que tindrà un pronom feble  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "prpers"));
			out.append("<prn><pro>");
			out.append(word1.tl(attr_pers));
			out.append("<mf>");
			out.append(word1.tl(attr_nbr));
			out.append("$}$");
			out.append(blank1);
		}
		else
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
			if (!word1.tl(attr_nbr).equals("<pl>"))
			{
				var_nombre = "<sg>";
			}
			else
			{
				var_nombre = "<pl>";
			}
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
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
			/** ...i un altre amb un pronom feble (nois els agraden les patates)  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word2.sl(attr_lem), "prpers"));
			out.append("<prn><pro><p3><mf>");
			out.append(var_nombre);
			out.append("$}$ ");
		}
		/**  envio el verb */
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
	}
	
	// REGLA: SN adv vblike
	public void rule7__SN__ADV__vblike(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule7__SN__ADV__vblike",  word1, blank1,  word2, blank2,  word3); } 
		/**  primer assignem els canvis que podem al verb */
		if (word3.tl(attr_temps).equals("<inf>"))
		{
			word3.tlSet(attr_temps, "<pri>");
		}
		word3.tlSet(attr_pers, "<p3>");
		word3.tlSet(attr_nbr, "<sg>");
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj2"))
		{
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
			{
				String myword = 
				         TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lem))
				         +word1.tl(attr_tags)
				         +word1.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
		}
		/**  quan el subjecte és un pronom... */
		if ((word1.tl(attr_lem).equalsIgnoreCase("prnsubj")
    || word1.tl(attr_lem).equalsIgnoreCase("prnsubj2")))
		{
			/**  envio l'adv */
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
			/** ...creo un chunk que tindrà un pronom feble  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word2.sl(attr_lem), "prpers"));
			out.append("<prn><pro>");
			out.append(word1.tl(attr_pers));
			out.append("<mf>");
			out.append(word1.tl(attr_nbr));
			out.append("$}$");
			out.append(blank1);
		}
		else
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
			if (!word1.tl(attr_nbr).equals("<pl>"))
			{
				var_nombre = "<sg>";
			}
			else
			{
				var_nombre = "<pl>";
			}
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
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
			/**  l'adv */
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
			/** ...i un altre amb un pronom feble (nois els agraden les patates)  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word2.sl(attr_lem), "prpers"));
			out.append("<prn><pro><p3><mf>");
			out.append(var_nombre);
			out.append("$}$ ");
		}
		/**  envio el verb */
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
	
	// REGLA: SN adv adv vblike
	public void rule8__SN__ADV__ADV__vblike(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule8__SN__ADV__ADV__vblike",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		/**  primer assignem els canvis que podem al verb */
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		word4.tlSet(attr_pers, "<p3>");
		word4.tlSet(attr_nbr, "<sg>");
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj2"))
		{
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
			{
				String myword = 
				         TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lem))
				         +word1.tl(attr_tags)
				         +word1.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
		}
		/**  quan el subjecte és un pronom... */
		if ((word1.tl(attr_lem).equalsIgnoreCase("prnsubj")
    || word1.tl(attr_lem).equalsIgnoreCase("prnsubj2")))
		{
			/**  envio l'adv */
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
			/**  envio l'adv */
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
			/** ...creo un chunk que tindrà un pronom feble  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word3.sl(attr_lem), "prpers"));
			out.append("<prn><pro>");
			out.append(word1.tl(attr_pers));
			out.append("<mf>");
			out.append(word1.tl(attr_nbr));
			out.append("$}$");
			out.append(blank1);
		}
		else
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
			if (!word1.tl(attr_nbr).equals("<pl>"))
			{
				var_nombre = "<sg>";
			}
			else
			{
				var_nombre = "<pl>";
			}
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
			/**  envio la preposició "a"  */
			out.append("^pr<PREP>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "a"));
			out.append("<pr>$}$ ");
			/** envio el chunk amb el SN */
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
			/**  l'adv */
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
			/**  l'adv */
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
			/** ...i un altre amb un pronom feble (nois els agraden les patates)  */
			out.append("^comp_like<prn><pro>{^");
			out.append(TransferWord.copycase(word3.sl(attr_lem), "prpers"));
			out.append("<prn><pro><p3><mf>");
			out.append(var_nombre);
			out.append("$}$ ");
		}
		/**  envio el verb */
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
	
	/** NOTA MG: la millor manera de fer el canvi de 'ser' per 'haver' hauria estat enllaçar la categoria del verb (vbser, vblex, vbhaver, vbmod) en les tags del chunk en el t1x, i aquí canviar l'etiqueta, de manera que el canvia hauria estat automàtic i no hauria fet falta fer operacions complicades en el t3x per a canviar les etiquetes segons el nom de chunk. Tanmateix, en el t1x hem posat la variable 'tipus_verb' com a etiqueta del chunk que pot contenir 'pron' i 'like' a part dels tipus de verb normals (vbser, vbhaver, vbmod, vblex), la qual cosa impossibilita fer l'enllaç correctament. Amb més temps caldria canviar la manera de passar la informació de 'pron' i 'like' en el segon transfer de manera que fos possible fer l'enllaç del tipus de verb.  */
	// REGLA: there BE SN
	public void rule9__there__thereis__SNnorel(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule9__there__thereis__SNnorel",  word1, blank1,  word2, blank2,  word3); } 
		/** NOTA MG: la millor manera de fer el canvi de 'ser' per 'haver' hauria estat enllaçar la categoria del verb (vbser, vblex, vbhaver, vbmod) en les tags del chunk en el t1x, i aquí canviar l'etiqueta, de manera que el canvia hauria estat automàtic i no hauria fet falta fer operacions complicades en el t3x per a canviar les etiquetes segons el nom de chunk. Tanmateix, en el t1x hem posat la variable 'tipus_verb' com a etiqueta del chunk que pot contenir 'pron' i 'like' a part dels tipus de verb normals (vbser, vbhaver, vbmod, vblex), la qual cosa impossibilita fer l'enllaç correctament. Amb més temps caldria canviar la manera de passar la informació de 'pron' i 'like' en el segon transfer de manera que fos possible fer l'enllaç del tipus de verb.  */
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		word2.tlSet(attr_pers, "<p3>");
		word2.tlSet(attr_nbr, "<sg>");
		word2.tlSet(attr_a_verb, "<HAY>");
		/** Quan SN és GD o ND  */
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			word3.tlSet(attr_gen, "<m>");
		}
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			if ((word2.tl(attr_temps).equals("<pri>")
    && word2.tl(attr_nbr).equals("<ND>")))
			{
				word3.tlSet(attr_nbr, "<pl>");
			}
			else
			if (word2.tl(attr_temps).equals("<pri>"))
			{
				word3.tlSet(attr_nbr, "<sg>");
			}
			else
			if ((word2.tl(attr_temps).equals("<ifip>")
    && word2.tl(attr_lem).equalsIgnoreCase("be")
    && word2.tl(attr_nbr).equals("<ND>")))
			{
				word3.tlSet(attr_nbr, "<pl>");
			}
			else
			{
				word3.tlSet(attr_nbr, "<sg>");
			}
		}
		if (word3.tl(attr_a_negacio).equals("<negacio>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "adv"));
			out.append("<NEG>{^no<adv>$}$");
			out.append(blank1);
		}
		else
		{
			macro_f_bcond(out, word1);
			word2.tlSet(attr_lem, TransferWord.copycase(TransferWord.caseOf(word1.tl(attr_lem)), word2.tl(attr_lem)));
		}
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
		macro_determina_nbr_gen_SN(out, word3);
	}
	
	// REGLA: there ADV BE SN (there can not be a cat)
	public void rule10__there__ADV__thereis__SNnorel(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule10__there__ADV__thereis__SNnorel",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		if (word3.tl(attr_temps).equals("<inf>"))
		{
			word3.tlSet(attr_temps, "<pri>");
		}
		word3.tlSet(attr_pers, "<p3>");
		word3.tlSet(attr_nbr, "<sg>");
		word3.tlSet(attr_a_verb, "<HAY>");
		/** Quan SN és GD o ND  */
		if (word4.tl(attr_gen).equals("<GD>"))
		{
			word4.tlSet(attr_gen, "<m>");
		}
		if (word4.tl(attr_nbr).equals("<ND>"))
		{
			if ((word3.tl(attr_temps).equals("<pri>")
    && word3.tl(attr_nbr).equals("<ND>")))
			{
				word4.tlSet(attr_nbr, "<pl>");
			}
			else
			if (word3.tl(attr_temps).equals("<pri>"))
			{
				word4.tlSet(attr_nbr, "<sg>");
			}
			else
			if ((word3.tl(attr_temps).equals("<ifip>")
    && word3.tl(attr_lem).equalsIgnoreCase("be")
    && word3.tl(attr_nbr).equals("<ND>")))
			{
				word4.tlSet(attr_nbr, "<pl>");
			}
			else
			{
				word4.tlSet(attr_nbr, "<sg>");
			}
		}
		macro_f_bcond(out, word1);
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
		macro_determina_nbr_gen_SN(out, word4);
	}
	
	// REGLA: there ADV ADV BE SN (there really can not be a cat)
	public void rule11__there__ADV__ADV__thereis__SNnorel(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5) throws IOException
	{
		if (debug) { logCall("rule11__there__ADV__ADV__thereis__SNnorel",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		word4.tlSet(attr_pers, "<p3>");
		word4.tlSet(attr_nbr, "<sg>");
		word4.tlSet(attr_a_verb, "<HAY>");
		/** Quan SN és GD o ND  */
		if (word5.tl(attr_gen).equals("<GD>"))
		{
			word5.tlSet(attr_gen, "<m>");
		}
		if (word5.tl(attr_nbr).equals("<ND>"))
		{
			if ((word4.tl(attr_temps).equals("<pri>")
    && word4.tl(attr_nbr).equals("<ND>")))
			{
				word5.tlSet(attr_nbr, "<pl>");
			}
			else
			if (word4.tl(attr_temps).equals("<pri>"))
			{
				word5.tlSet(attr_nbr, "<sg>");
			}
			else
			if ((word4.tl(attr_temps).equals("<ifip>")
    && word4.tl(attr_lem).equalsIgnoreCase("be")
    && word4.tl(attr_nbr).equals("<ND>")))
			{
				word5.tlSet(attr_nbr, "<pl>");
			}
			else
			{
				word5.tlSet(attr_nbr, "<sg>");
			}
		}
		macro_f_bcond(out, word1);
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
		macro_determina_nbr_gen_SN(out, word5);
	}
	
	// REGLA: there BE (sense SN clar a continuació)
	public void rule12__there__thereis(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2) throws IOException
	{
		if (debug) { logCall("rule12__there__thereis",  word1, blank1,  word2); } 
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		word2.tlSet(attr_pers, "<p3>");
		word2.tlSet(attr_nbr, "<sg>");
		word2.tlSet(attr_a_verb, "<HAY>");
		macro_f_bcond(out, word1);
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
	}
	
	// REGLA: there ADV BE (sense SN clar a continuació)
	public void rule13__there__ADV__thereis(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule13__there__ADV__thereis",  word1, blank1,  word2, blank2,  word3); } 
		if (word3.tl(attr_temps).equals("<inf>"))
		{
			word3.tlSet(attr_temps, "<pri>");
		}
		word3.tlSet(attr_pers, "<p3>");
		word3.tlSet(attr_nbr, "<sg>");
		word3.tlSet(attr_a_verb, "<HAY>");
		macro_f_bcond(out, word1);
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
	
	// REGLA: there ADV ADV BE (sense SN clar a continuació - There really can not be)
	public void rule14__there__ADV__ADV__thereis(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule14__there__ADV__ADV__thereis",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		word4.tlSet(attr_pers, "<p3>");
		word4.tlSet(attr_nbr, "<sg>");
		word4.tlSet(attr_a_verb, "<HAY>");
		macro_f_bcond(out, word1);
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
	
	/** REGLES GENERALS  */
	// REGLA: SN SV
	public void rule15__SN__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2) throws IOException
	{
		if (debug) { logCall("rule15__SN__SV",  word1, blank1,  word2); } 
		macro_concord_SN_SV(out, word1, blank1, word2);
		macro_posadet_SN(out, word1);
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word1);
			/** el pronom no l'envio, només el 2n chunk  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
				         +word2.tl(attr_tags)
				         +word2.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
		}
		else
		{
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
		}
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN and SN SV (BCN)
	public void rule16__SNnorel__and__SN__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule16__SNnorel__and__SN__SV",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_concord_SNcoo_SV(out, word1, blank2, word3, blank3, word4);
		macro_posadet_SN(out, word1);
		macro_posadet_SN(out, word3);
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
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
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN GEN SN SV (Europe's top 100 listed companies are...)
	public void rule17__SNnorel__GEN__SNundet_num__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule17__SNnorel__GEN__SNundet_num__SV",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_concord_SN_SV(out, word3, blank3, word4);
		macro_posadet_SN(out, word1);
		word3.tlSet(attr_a_SN, "<PDET>");
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		/** arregla GD i ND de SN pos1  */
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
		{
			String myword = 
			         TransferWord.copycase(word1.sl(attr_lem), word3.tl(attr_lem))
			         +word3.tl(attr_tags)
			         +word3.tl(attr_chcontent)
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
		out.append(TransferWord.copycase(word2.sl(attr_lem), "pr"));
		out.append("<PREP>{^de<pr>$}$");
		out.append(blank2);
		{
			String myword = 
			         TransferWord.copycase(word3.sl(attr_lem), word1.tl(attr_lem))
			         +word1.tl(attr_tags)
			         +word1.tl(attr_chcontent)
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
		macro_determina_nbr_gen_SN(out, word3);
	}
	
	// REGLA: SN ADV SV
	public void rule18__SN__ADV__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule18__SN__ADV__SV",  word1, blank1,  word2, blank2,  word3); } 
		macro_concord_SN_SV(out, word1, blank2, word3);
		macro_posadet_SN(out, word1);
		if (word3.tl(attr_temps).equals("<inf>"))
		{
			word3.tlSet(attr_temps, "<pri>");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word1);
			/** el pronom no l'envio  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
				         +word2.tl(attr_tags)
				         +word2.tl(attr_chcontent)
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
		else
		{
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
		}
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN ADV ADV SV (We really can not say)
	public void rule19__SN__ADV__ADV__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule19__SN__ADV__ADV__SV",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_concord_SN_SV(out, word1, blank3, word4);
		macro_posadet_SN(out, word1);
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word1);
			/** el pronom no l'envio  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
				         +word2.tl(attr_tags)
				         +word2.tl(attr_chcontent)
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
		else
		{
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
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN and SN ADV SV (BCN)
	public void rule20__SNnorel__and__SN__ADV__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5) throws IOException
	{
		if (debug) { logCall("rule20__SNnorel__and__SN__ADV__SV",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_concord_SNcoo_SV(out, word1, blank2, word3, blank4, word5);
		macro_posadet_SN(out, word1);
		macro_posadet_SN(out, word3);
		if (word5.tl(attr_temps).equals("<inf>"))
		{
			word5.tlSet(attr_temps, "<pri>");
		}
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
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN and SN ADV ADV SV (com l'anterior però dos adv: 'You and your father really can not say')
	public void rule21__SNnorel__and__SN__ADV__ADV__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5, String blank5, InterchunkWord word6) throws IOException
	{
		if (debug) { logCall("rule21__SNnorel__and__SN__ADV__ADV__SV",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_concord_SNcoo_SV(out, word1, blank2, word3, blank5, word6);
		macro_posadet_SN(out, word1);
		macro_posadet_SN(out, word3);
		if (word6.tl(attr_temps).equals("<inf>"))
		{
			word6.tlSet(attr_temps, "<pri>");
		}
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
		{
			String myword = 
			         word6.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN GEN SN ADV SV
	public void rule22__SNnorel__GEN__SNundet_num__ADV__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5) throws IOException
	{
		if (debug) { logCall("rule22__SNnorel__GEN__SNundet_num__ADV__SV",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_concord_SN_SV(out, word3, blank4, word5);
		macro_posadet_SN(out, word1);
		word3.tlSet(attr_a_SN, "<PDET>");
		if (word5.tl(attr_temps).equals("<inf>"))
		{
			word5.tlSet(attr_temps, "<pri>");
		}
		/** arregla GD i ND de SN pos1  */
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
		{
			String myword = 
			         TransferWord.copycase(word1.sl(attr_lem), word3.tl(attr_lem))
			         +word3.tl(attr_tags)
			         +word3.tl(attr_chcontent)
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
		out.append(TransferWord.copycase(word2.sl(attr_lem), "pr"));
		out.append("<PREP>{^de<pr>$}$");
		out.append(blank2);
		{
			String myword = 
			         TransferWord.copycase(word3.sl(attr_lem), word1.tl(attr_lem))
			         +word1.tl(attr_tags)
			         +word1.tl(attr_chcontent)
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
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN GEN SN ADV ADV SV (com l'anterior però dos adv)
	public void rule23__SNnorel__GEN__SNundet_num__ADV__ADV__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5, String blank5, InterchunkWord word6) throws IOException
	{
		if (debug) { logCall("rule23__SNnorel__GEN__SNundet_num__ADV__ADV__SV",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_concord_SN_SV(out, word3, blank5, word6);
		macro_posadet_SN(out, word1);
		word3.tlSet(attr_a_SN, "<PDET>");
		if (word6.tl(attr_temps).equals("<inf>"))
		{
			word6.tlSet(attr_temps, "<pri>");
		}
		/** arregla GD i ND de SN pos1  */
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
		{
			String myword = 
			         TransferWord.copycase(word1.sl(attr_lem), word3.tl(attr_lem))
			         +word3.tl(attr_tags)
			         +word3.tl(attr_chcontent)
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
		out.append(TransferWord.copycase(word2.sl(attr_lem), "pr"));
		out.append("<PREP>{^de<pr>$}$");
		out.append(blank2);
		{
			String myword = 
			         TransferWord.copycase(word3.sl(attr_lem), word1.tl(attr_lem))
			         +word1.tl(attr_tags)
			         +word1.tl(attr_chcontent)
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
		{
			String myword = 
			         word6.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN SV SA (they live/are happy - viuen feliços (BCN s'ha modificat)
	public void rule24__SN__SV__SA(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule24__SN__SV__SA",  word1, blank1,  word2, blank2,  word3); } 
		macro_concord_SN_SV(out, word1, blank1, word2);
		macro_posadet_SN(out, word1);
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word1);
			/** el pronom no l'envio, només el 2n chunk  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
				         +word2.tl(attr_tags)
				         +word2.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
		}
		else
		{
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
		}
		macro_determina_nbr_gen_SN(out, word1);
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			word3.tlSet(attr_nbr, var_nombre);
		}
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			word3.tlSet(attr_gen, var_genere);
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
	
	// REGLA: SN and SN SV SA (BCN)
	public void rule25__SNnorel__and__SN__SV__SA(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5) throws IOException
	{
		if (debug) { logCall("rule25__SNnorel__and__SN__SV__SA",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_concord_SNcoo_SV(out, word1, blank2, word3, blank3, word4);
		macro_posadet_SN(out, word1);
		macro_posadet_SN(out, word3);
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
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
		/**  part del SA per a genere i nombre */
		if (word5.tl(attr_gen).equals("<GD>"))
		{
			if ((word1.tl(attr_gen).equals("<m>")
    || word1.tl(attr_gen).equals("<mf>")
    || word3.tl(attr_gen).equals("<m>")
    || word3.tl(attr_gen).equals("<mf>")))
			{
				word5.tlSet(attr_gen, "<m>");
			}
			else
			{
				word5.tlSet(attr_gen, "<f>");
			}
		}
		if (word5.tl(attr_nbr).equals("<ND>"))
		{
			word5.tlSet(attr_nbr, "<pl>");
		}
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
		macro_determina_nbr_gen_SN(out, word1);
		var_nombre = "<pl>";
	}
	
	// REGLA: SN SV SA and SA (BCN)
	public void rule26__SN__SV__SA__cnjcoo__SA(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5) throws IOException
	{
		if (debug) { logCall("rule26__SN__SV__SA__cnjcoo__SA",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_concord_SN_SV(out, word1, blank1, word2);
		macro_posadet_SN(out, word1);
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word1);
			/** el pronom no l'envio, només el 2n chunk  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
				         +word2.tl(attr_tags)
				         +word2.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
		}
		else
		{
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
		}
		/** Assigna gènere i nombre a adjectiu (GD i ND)  */
		macro_determina_nbr_gen_SN(out, word1);
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			word3.tlSet(attr_nbr, var_nombre);
		}
		if (word5.tl(attr_nbr).equals("<ND>"))
		{
			word5.tlSet(attr_nbr, var_nombre);
		}
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			word3.tlSet(attr_gen, var_genere);
		}
		if (word5.tl(attr_gen).equals("<GD>"))
		{
			word5.tlSet(attr_gen, var_genere);
		}
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
	}
	
	// REGLA: SN adv SV SA
	public void rule27__SN__ADV__SV__SA(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule27__SN__ADV__SV__SA",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_concord_SN_SV(out, word1, blank2, word3);
		macro_posadet_SN(out, word1);
		if (word3.tl(attr_temps).equals("<inf>"))
		{
			word3.tlSet(attr_temps, "<pri>");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word1);
			/** el pronom no l'envio, només el 2n chunk  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
				         +word2.tl(attr_tags)
				         +word2.tl(attr_chcontent)
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
		}
		else
		{
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
		}
		/** Assigna gènere i nombre a adjectiu (GD i ND)  */
		macro_determina_nbr_gen_SN(out, word1);
		if (word4.tl(attr_nbr).equals("<ND>"))
		{
			word4.tlSet(attr_nbr, var_nombre);
		}
		if (word4.tl(attr_gen).equals("<GD>"))
		{
			word4.tlSet(attr_gen, var_genere);
		}
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
	
	// REGLA: SN adv adv SV SA (com l'anterior però amb dos adverbis)
	public void rule28__SN__ADV__ADV__SV__SA(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5) throws IOException
	{
		if (debug) { logCall("rule28__SN__ADV__ADV__SV__SA",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_concord_SN_SV(out, word1, blank3, word4);
		macro_posadet_SN(out, word1);
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word1);
			/** el pronom no l'envio, només el 2n chunk  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
				         +word2.tl(attr_tags)
				         +word2.tl(attr_chcontent)
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
			out.append(blank4);
		}
		else
		{
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
			out.append(blank4);
		}
		/** Assigna gènere i nombre a adjectiu (GD i ND)  */
		macro_determina_nbr_gen_SN(out, word1);
		if (word5.tl(attr_nbr).equals("<ND>"))
		{
			word5.tlSet(attr_nbr, var_nombre);
		}
		if (word5.tl(attr_gen).equals("<GD>"))
		{
			word5.tlSet(attr_gen, var_genere);
		}
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
	}
	
	// REGLA: SN and SN ADV SV SA (BCN)
	public void rule29__SNnorel__and__SN__ADV__SV__SA(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5, String blank5, InterchunkWord word6) throws IOException
	{
		if (debug) { logCall("rule29__SNnorel__and__SN__ADV__SV__SA",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_concord_SNcoo_SV(out, word1, blank2, word3, blank4, word5);
		macro_posadet_SN(out, word1);
		macro_posadet_SN(out, word3);
		if (word5.tl(attr_temps).equals("<inf>"))
		{
			word5.tlSet(attr_temps, "<pri>");
		}
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
		/**  part del SA per a genere i nombre */
		if (word6.tl(attr_gen).equals("<GD>"))
		{
			if ((word1.tl(attr_gen).equals("<m>")
    || word1.tl(attr_gen).equals("<mf>")
    || word3.tl(attr_gen).equals("<m>")
    || word3.tl(attr_gen).equals("<mf>")))
			{
				word6.tlSet(attr_gen, "<m>");
			}
			else
			{
				word6.tlSet(attr_gen, "<f>");
			}
		}
		if (word6.tl(attr_nbr).equals("<ND>"))
		{
			word6.tlSet(attr_nbr, "<pl>");
		}
		out.append(blank5);
		{
			String myword = 
			         word6.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_determina_nbr_gen_SN(out, word1);
		var_nombre = "<pl>";
	}
	
	// REGLA: SN and SN ADV ADV SV SA (com l'anterior però amb dos adv)
	public void rule30__SNnorel__and__SN__ADV__ADV__SV__SA(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5, String blank5, InterchunkWord word6, String blank6, InterchunkWord word7) throws IOException
	{
		if (debug) { logCall("rule30__SNnorel__and__SN__ADV__ADV__SV__SA",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6, blank6,  word7); } 
		macro_concord_SNcoo_SV(out, word1, blank2, word3, blank5, word6);
		macro_posadet_SN(out, word1);
		macro_posadet_SN(out, word3);
		if (word6.tl(attr_temps).equals("<inf>"))
		{
			word6.tlSet(attr_temps, "<pri>");
		}
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
		{
			String myword = 
			         word6.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  part del SA per a genere i nombre */
		if (word7.tl(attr_gen).equals("<GD>"))
		{
			if ((word1.tl(attr_gen).equals("<m>")
    || word1.tl(attr_gen).equals("<mf>")
    || word3.tl(attr_gen).equals("<m>")
    || word3.tl(attr_gen).equals("<mf>")))
			{
				word7.tlSet(attr_gen, "<m>");
			}
			else
			{
				word7.tlSet(attr_gen, "<f>");
			}
		}
		if (word6.tl(attr_nbr).equals("<ND>"))
		{
			word7.tlSet(attr_nbr, "<pl>");
		}
		out.append(blank6);
		{
			String myword = 
			         word7.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_determina_nbr_gen_SN(out, word1);
		var_nombre = "<pl>";
	}
	
	/** regles amb verb copulatiu i sintagma nominal atribut (les regles amb SA com a atribut es tracten en les regles SN SV SA)  */
	// REGLA: SN Vcop SN (my sister is teacher - la meva germa és mestra
	public void rule31__SN__vbcopulatiu__SN(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule31__SN__vbcopulatiu__SN",  word1, blank1,  word2, blank2,  word3); } 
		macro_concord_SN_SV(out, word1, blank1, word2);
		macro_posadet_SN(out, word1);
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		if ((word3.tl(attr_lem).equals("num_yearold")
    && word2.tl(attr_a_verb).equals("<vbser>")))
		{
			word2.tlSet(attr_lem, "tener");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word1);
			/** el pronom no l'envio, només el 2n chunk  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
				         +word2.tl(attr_tags)
				         +word2.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
		}
		else
		{
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
		}
		macro_determina_nbr_gen_SN(out, word1);
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			word3.tlSet(attr_nbr, var_nombre);
		}
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			word3.tlSet(attr_gen, var_genere);
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
	
	// REGLA: SN Vcop ADV SN (the man is almost 10 years old / my mother was always a teacher) 
	public void rule32__SN__vbcopulatiu__ADV__SN(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule32__SN__vbcopulatiu__ADV__SN",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_concord_SN_SV(out, word1, blank1, word2);
		macro_posadet_SN(out, word1);
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		if ((word4.tl(attr_lem).equals("num_yearold")
    && word2.tl(attr_a_verb).equals("<vbser>")))
		{
			word2.tlSet(attr_lem, "tener");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word1);
			/** el pronom no l'envio, només el 2n chunk  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
				         +word2.tl(attr_tags)
				         +word2.tl(attr_chcontent)
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
		else
		{
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
		}
		macro_determina_nbr_gen_SN(out, word1);
		if (word4.tl(attr_nbr).equals("<ND>"))
		{
			word4.tlSet(attr_nbr, var_nombre);
		}
		if (word4.tl(attr_gen).equals("<GD>"))
		{
			word4.tlSet(attr_gen, var_genere);
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
	
	// REGLA: SN SP Vcop SN (The International Council of Nurses is 10 years old)
	public void rule33__SN__pr__SNnorel__vbcopulatiu__SN(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5) throws IOException
	{
		if (debug) { logCall("rule33__SN__pr__SNnorel__vbcopulatiu__SN",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_concord_SN_SV(out, word1, blank3, word4);
		macro_posadet_SN(out, word1);
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		if ((word5.tl(attr_lem).equals("num_yearold")
    && word4.tl(attr_a_verb).equals("<vbser>")))
		{
			word4.tlSet(attr_lem, "tener");
		}
		/**  quan el segon SN és GD o ND */
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("<nt>")))
			{
				word3.tlSet(attr_gen, word1.tl(attr_gen));
			}
			else
			{
				word3.tlSet(attr_gen, "<m>");
			}
		}
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			if (!word1.tl(attr_nbr).equals("<sp>"))
			{
				word3.tlSet(attr_nbr, word1.tl(attr_nbr));
			}
			else
			{
				word3.tlSet(attr_nbr, word4.tl(attr_nbr));
			}
		}
		/** aquí enviem el primer SN tant si és pronom subjecte com si no.  */
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
		macro_determina_nbr_gen_SN(out, word1);
		if (word5.tl(attr_nbr).equals("<ND>"))
		{
			word5.tlSet(attr_nbr, var_nombre);
		}
		if (word5.tl(attr_gen).equals("<GD>"))
		{
			word5.tlSet(attr_gen, var_genere);
		}
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
	}
	
	// REGLA: SN SP Vcop ADV SN (The International Council of Nurses is almost 10 years old)
	public void rule34__SN__pr__SNnorel__vbcopulatiu__ADV__SN(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5, String blank5, InterchunkWord word6) throws IOException
	{
		if (debug) { logCall("rule34__SN__pr__SNnorel__vbcopulatiu__ADV__SN",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_concord_SN_SV(out, word1, blank3, word4);
		macro_posadet_SN(out, word1);
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		if ((word6.tl(attr_lem).equals("num_yearold")
    && word4.tl(attr_a_verb).equals("<vbser>")))
		{
			word4.tlSet(attr_lem, "tener");
		}
		/**  quan el segon SN és GD o ND */
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("<nt>")))
			{
				word3.tlSet(attr_gen, word1.tl(attr_gen));
			}
			else
			{
				word3.tlSet(attr_gen, "<m>");
			}
		}
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			if (!word1.tl(attr_nbr).equals("<sp>"))
			{
				word3.tlSet(attr_nbr, word1.tl(attr_nbr));
			}
			else
			{
				word3.tlSet(attr_nbr, word4.tl(attr_nbr));
			}
		}
		/** aquí enviem el primer SN tant si és pronom subjecte com si no.  */
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
		macro_determina_nbr_gen_SN(out, word1);
		if (word6.tl(attr_nbr).equals("<ND>"))
		{
			word6.tlSet(attr_nbr, var_nombre);
		}
		if (word6.tl(attr_gen).equals("<GD>"))
		{
			word6.tlSet(attr_gen, var_genere);
		}
		out.append(blank5);
		{
			String myword = 
			         word6.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	/**  regles amb pronoms reflexius */
	// REGLA: SN SV refl (I find myself - (jo) em trobo / I find yourself - et trobo)
	public void rule35__SN__SV__prnref(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule35__SN__SV__prnref",  word1, blank1,  word2, blank2,  word3); } 
		macro_concord_SN_SV(out, word1, blank1, word2);
		macro_posadet_SN(out, word1);
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		word3.tlSet(attr_tipus_prn, "<pro>");
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			if ((word1.tl(attr_pers).equals(word3.tl(attr_pers))
    && word1.tl(attr_gen).equals(word3.tl(attr_gen))
    && word1.tl(attr_nbr).equals(word3.tl(attr_nbr))))
			{
				word3.tlSet(attr_lem, "reflexiu");
			}
			macro_f_bcond(out, word1);
			/** el pronom no l'envio, només el 2n i 3r chunk  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word3.tl(attr_lem))
				         +word3.tl(attr_tags)
				         +word3.tl(attr_chcontent)
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
				         word2.tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
		}
		else
		{
			if ((word3.tl(attr_pers).equals("<p3>")
    && word1.tl(attr_nbr).equals(word3.tl(attr_nbr))))
			{
				word3.tlSet(attr_lem, "reflexiu");
			}
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
		}
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN ADV SV refl (I always find myself - (jo) sempre em trobo)
	public void rule36__SN__ADV__SV__prnref(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule36__SN__ADV__SV__prnref",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_concord_SN_SV(out, word1, blank2, word3);
		macro_posadet_SN(out, word1);
		if (word3.tl(attr_temps).equals("<inf>"))
		{
			word3.tlSet(attr_temps, "<pri>");
		}
		word4.tlSet(attr_tipus_prn, "<pro>");
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			if ((word1.tl(attr_pers).equals(word4.tl(attr_pers))
    && word1.tl(attr_gen).equals(word4.tl(attr_gen))
    && word1.tl(attr_nbr).equals(word4.tl(attr_nbr))))
			{
				word4.tlSet(attr_lem, "reflexiu");
			}
			macro_f_bcond(out, word1);
			/** el pronom no l'envio  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
				         +word2.tl(attr_tags)
				         +word2.tl(attr_chcontent)
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
				         word4.tl(attr_whole)
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
		else
		{
			if ((word4.tl(attr_pers).equals("<p3>")
    && word1.tl(attr_nbr).equals(word4.tl(attr_nbr))))
			{
				word4.tlSet(attr_lem, "reflexiu");
			}
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
				         word4.tl(attr_whole)
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
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SV refl (xxxx finds itself) 
	public void rule37__SV__prnref(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2) throws IOException
	{
		if (debug) { logCall("rule37__SV__prnref",  word1, blank1,  word2); } 
		if (!(word1.tl(attr_temps).equals("<inf>")
    || word1.tl(attr_temps).equals("<ger>")))
		{
			if (word1.tl(attr_pers).equals("<PD>"))
			{
				word1.tlSet(attr_pers, "<p3>");
			}
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
		}
		word2.tlSet(attr_tipus_prn, "<pro>");
		if ((word2.tl(attr_pers).equals("<p3>")
    && word1.tl(attr_nbr).equals(word2.tl(attr_nbr))))
		{
			word2.tlSet(attr_lem, "reflexiu");
		}
		{
			String myword = 
			         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
			         +word2.tl(attr_tags)
			         +word2.tl(attr_chcontent)
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
			         TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lem))
			         +word1.tl(attr_tags)
			         +word1.tl(attr_chcontent)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// REGLA: reporting VERBS (BCN: per afegir QUE quan tenim un 'reporting' werb seguit d'una clàusula: she said they would go home -- va dir que anirien casa. Falta fer el mateix per quan tenim: SN Vcop SA; SN ADV SV; SN SV SA; a la segona part )
	public void rule38__SN__vbreporting__SNnorel__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule38__SN__vbreporting__SNnorel__SV",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_concord_SN_SV(out, word1, blank1, word2);
		macro_posadet_SN(out, word1);
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word1);
			/** el pronom no l'envio, només el 2n chunk  */
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
				         +word2.tl(attr_tags)
				         +word2.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(" ^cnjsub<PREP>{^");
			out.append(TransferWord.copycase(word2.sl(attr_lem), "que"));
			out.append("<cnjsub>$}$");
			out.append(blank2);
		}
		else
		{
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
			out.append(" ^cnjsub<PREP>{^");
			out.append(TransferWord.copycase(word2.sl(attr_lem), "que"));
			out.append("<cnjsub>$}$");
			out.append(blank2);
		}
		/** 	<call-macro n="determina_nbr_gen_SN">
	  <with-param pos="1"/>
	</call-macro> ens quedem amb els valors del SN 3(?) ara la concordança entre el SN 3 i el SV 4  */
		macro_concord_SN_SV(out, word3, blank3, word4);
		macro_posadet_SN(out, word3);
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		if (word3.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word3);
			/** el pronom no l'envio, només el 2n chunk  */
			{
				String myword = 
				         TransferWord.copycase(word2.sl(attr_lem), word4.tl(attr_lem))
				         +word4.tl(attr_tags)
				         +word4.tl(attr_chcontent)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
		}
		else
		{
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
			macro_determina_nbr_gen_SN(out, word3);
		}
	}
	
	// REGLA: SN SP SV (BCN, modificat per MG)
	public void rule39__SN__pr__SNnorel__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4) throws IOException
	{
		if (debug) { logCall("rule39__SN__pr__SNnorel__SV",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_concord_SN_SV(out, word1, blank3, word4);
		macro_posadet_SN(out, word1);
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		/**  quan el segon SN és GD o ND */
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("<nt>")))
			{
				word3.tlSet(attr_gen, word1.tl(attr_gen));
			}
			else
			{
				word3.tlSet(attr_gen, "<m>");
			}
		}
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			if (!word1.tl(attr_nbr).equals("<sp>"))
			{
				word3.tlSet(attr_nbr, word1.tl(attr_nbr));
			}
			else
			{
				word3.tlSet(attr_nbr, word4.tl(attr_nbr));
			}
		}
		/** aquí enviem el primer SN tant si és pronom subjecte com si no.  */
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
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN SP SV SA (BCN, modificat per MG)
	public void rule40__SN__pr__SNnorel__SV__SA(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5) throws IOException
	{
		if (debug) { logCall("rule40__SN__pr__SNnorel__SV__SA",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_concord_SN_SV(out, word1, blank3, word4);
		macro_posadet_SN(out, word1);
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		/**  quan el segon SN és GD o ND */
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("<nt>")))
			{
				word3.tlSet(attr_gen, word1.tl(attr_gen));
			}
			else
			{
				word3.tlSet(attr_gen, "<m>");
			}
		}
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			if (!word1.tl(attr_nbr).equals("<sp>"))
			{
				word3.tlSet(attr_nbr, word1.tl(attr_nbr));
			}
			else
			{
				word3.tlSet(attr_nbr, word4.tl(attr_nbr));
			}
		}
		/** aquí enviem el primer SN tant si és pronom subjecte com si no.  */
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
		/** Assigna gènere i nombre a l'adjectiu  */
		macro_determina_nbr_gen_SN(out, word1);
		if (word5.tl(attr_nbr).equals("<ND>"))
		{
			word5.tlSet(attr_nbr, var_nombre);
		}
		if (word5.tl(attr_gen).equals("<GD>"))
		{
			word5.tlSet(attr_gen, var_genere);
		}
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
	}
	
	// REGLA: SN SP SV SA and SA (BCN, modificada per MG)
	public void rule41__SN__pr__SNnorel__SV__SA__cnjcoo__SA(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3, String blank3, InterchunkWord word4, String blank4, InterchunkWord word5, String blank5, InterchunkWord word6, String blank6, InterchunkWord word7) throws IOException
	{
		if (debug) { logCall("rule41__SN__pr__SNnorel__SV__SA__cnjcoo__SA",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6, blank6,  word7); } 
		macro_concord_SN_SV(out, word1, blank3, word4);
		macro_posadet_SN(out, word1);
		if (word4.tl(attr_temps).equals("<inf>"))
		{
			word4.tlSet(attr_temps, "<pri>");
		}
		/**  quan el segon SN és GD o ND (p. ex. quan tenim 'of which' en el segon SN ens ve sense genere i nombre)  */
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("<nt>")))
			{
				word3.tlSet(attr_gen, word1.tl(attr_gen));
			}
			else
			{
				word3.tlSet(attr_gen, "<m>");
			}
		}
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			if (!word1.tl(attr_nbr).equals("<sp>"))
			{
				word3.tlSet(attr_nbr, word1.tl(attr_nbr));
			}
			else
			{
				word3.tlSet(attr_nbr, word4.tl(attr_nbr));
			}
		}
		/** aquí enviem el primer SN tant si és pronom subjecte com si no.  */
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
		out.append(blank4);
		/** Assigna gènere i nombre a adjectiu (GD i ND)  */
		macro_determina_nbr_gen_SN(out, word1);
		if (word5.tl(attr_nbr).equals("<ND>"))
		{
			word5.tlSet(attr_nbr, var_nombre);
		}
		if (word7.tl(attr_nbr).equals("<ND>"))
		{
			word7.tlSet(attr_nbr, var_nombre);
		}
		if (word5.tl(attr_gen).equals("<GD>"))
		{
			word5.tlSet(attr_gen, var_genere);
		}
		if (word7.tl(attr_gen).equals("<GD>"))
		{
			word7.tlSet(attr_gen, var_genere);
		}
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
		{
			String myword = 
			         word6.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank6);
		{
			String myword = 
			         word7.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// REGLA: SN SV SN.negacio (BCN I read no books -- NO llegeixo cap llibre
	public void rule42__SN__SV__negacio(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule42__SN__SV__negacio",  word1, blank1,  word2, blank2,  word3); } 
		macro_concord_SN_SV(out, word1, blank1, word2);
		macro_posadet_SN(out, word1);
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			word3.tlSet(attr_gen, "<m>");
		}
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			word3.tlSet(attr_nbr, "<sg>");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("prnsubj"))
		{
			macro_f_bcond(out, word1);
			/** el pronom no l'envio, només el 2n chunk  */
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "adv"));
			out.append("<NEG>{^no<adv>$}$ ");
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
		}
		else
		{
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
			out.append("^adv<NEG>{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "no"));
			out.append("<adv>$}$ ");
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
		macro_determina_nbr_gen_SN(out, word3);
	}
	
	// REGLA: SN SVger (BCN the man working in the garage :: l'home que treballa ...)
	public void rule43__SN_nopron__SVGER(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2) throws IOException
	{
		if (debug) { logCall("rule43__SN_nopron__SVGER",  word1, blank1,  word2); } 
		macro_posadet_SN(out, word1);
		word2.tlSet(attr_temps, "<pri>");
		/** Aquí  SN no és mai pronom subjecte, la categoria no l'inclou  */
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
		/** el gerundi sempre és PD i ND, ara cal assignar-li persona p3 i nbr del SN  */
		word2.tlSet(attr_pers, "<p3>");
		if (!word1.tl(attr_nbr).equals("<sp>"))
		{
			word2.tlSet(attr_nbr, word1.tl(attr_nbr));
		}
		else
		{
			word2.tlSet(attr_nbr, "<sg>");
		}
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
		out.append(" ^reladj<REL>{^");
		out.append(TransferWord.copycase(word2.sl(attr_lem), "que"));
		out.append("<rel><an><mf><sp>$}$");
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
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN PP (patients treated -> pacients tractats)
	public void rule44__SN_nopron__pp(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2) throws IOException
	{
		if (debug) { logCall("rule44__SN_nopron__pp",  word1, blank1,  word2); } 
		macro_concord_SN_SV(out, word1, blank1, word2);
		macro_posadet_SN(out, word1);
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
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: SN ADV PP (representatives freely elected )
	public void rule45__SN_nopron__ADV__pp(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule45__SN_nopron__ADV__pp",  word1, blank1,  word2, blank2,  word3); } 
		macro_concord_SN_SV(out, word1, blank2, word3);
		macro_posadet_SN(out, word1);
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
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: RELAN SV
	public void rule46__RELAN__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2) throws IOException
	{
		if (debug) { logCall("rule46__RELAN__SV",  word1, blank1,  word2); } 
		if (word2.tl(attr_temps).equals("<inf>"))
		{
			word2.tlSet(attr_temps, "<pri>");
		}
		if (word2.tl(attr_pers).equals("<PD>"))
		{
			word2.tlSet(attr_pers, "<p3>");
		}
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			if (!var_nombre.equals(""))
			{
				word2.tlSet(attr_nbr, var_nombre);
			}
			else
			{
				word2.tlSet(attr_nbr, "<sg>");
			}
		}
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			if (!var_genere.equals(""))
			{
				word2.tlSet(attr_gen, var_genere);
			}
			else
			{
				word2.tlSet(attr_gen, "<m>");
			}
		}
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
	}
	
	// REGLA: RELAN ADV SV
	public void rule47__RELAN__ADV__SV(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule47__RELAN__ADV__SV",  word1, blank1,  word2, blank2,  word3); } 
		if (word3.tl(attr_temps).equals("<inf>"))
		{
			word3.tlSet(attr_temps, "<pri>");
		}
		if (word3.tl(attr_pers).equals("<PD>"))
		{
			word3.tlSet(attr_pers, "<p3>");
		}
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			if (!var_nombre.equals(""))
			{
				word3.tlSet(attr_nbr, var_nombre);
			}
			else
			{
				word3.tlSet(attr_nbr, "<sg>");
			}
		}
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			if (!var_genere.equals(""))
			{
				word3.tlSet(attr_gen, var_genere);
			}
			else
			{
				word3.tlSet(attr_gen, "<m>");
			}
		}
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
	}
	
	// REGLA: SA SN (London-based design company)
	public void rule48__adj__SNundet(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2) throws IOException
	{
		if (debug) { logCall("rule48__adj__SNundet",  word1, blank1,  word2); } 
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			word2.tlSet(attr_gen, "<m>");
		}
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			word2.tlSet(attr_nbr, "<sg>");
		}
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			if (!word2.tl(attr_gen).equals("<mf>"))
			{
				word1.tlSet(attr_gen, word2.tl(attr_gen));
			}
			else
			{
				word1.tlSet(attr_gen, "<m>");
			}
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			if (!word2.tl(attr_nbr).equals("<sp>"))
			{
				word1.tlSet(attr_nbr, word2.tl(attr_nbr));
			}
			else
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
		}
		{
			String myword = 
			         TransferWord.copycase(word1.sl(attr_lem), word2.tl(attr_lem))
			         +word2.tl(attr_tags)
			         +word2.tl(attr_chcontent)
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
			         TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lem))
			         +word1.tl(attr_tags)
			         +word1.tl(attr_chcontent)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_determina_nbr_gen_SN(out, word2);
	}
	
	// REGLA: DET SA SN (a London-based design company)
	public void rule49__DET__adj__SNundet(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule49__DET__adj__SNundet",  word1, blank1,  word2, blank2,  word3); } 
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			word3.tlSet(attr_gen, "<m>");
		}
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			if (!(word1.tl(attr_nbr).equals("<sp>")
    || word1.tl(attr_nbr).equals("<ND>")))
			{
				word3.tlSet(attr_nbr, word1.tl(attr_nbr));
			}
			else
			{
				word3.tlSet(attr_nbr, "<sg>");
			}
		}
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			if (!word3.tl(attr_gen).equals("<mf>"))
			{
				word2.tlSet(attr_gen, word3.tl(attr_gen));
			}
			else
			{
				word2.tlSet(attr_gen, "<m>");
			}
		}
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			if (!word3.tl(attr_nbr).equals("<sp>"))
			{
				word2.tlSet(attr_nbr, word3.tl(attr_nbr));
			}
			else
			{
				word2.tlSet(attr_nbr, "<sg>");
			}
		}
		/** fem que el DET concordi amb el SN  */
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			if (!word3.tl(attr_gen).equals("<mf>"))
			{
				word1.tlSet(attr_gen, word3.tl(attr_gen));
			}
			else
			{
				word1.tlSet(attr_gen, "<m>");
			}
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			if (!word3.tl(attr_nbr).equals("<sp>"))
			{
				word1.tlSet(attr_nbr, word3.tl(attr_nbr));
			}
			else
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
		}
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
		macro_determina_nbr_gen_SN(out, word3);
	}
	
	// REGLA: SN GEN SN (Europe's top 100 listed companies...)
	public void rule50__SNnorel__GEN__SNundet_num(Appendable out, InterchunkWord word1, String blank1, InterchunkWord word2, String blank2, InterchunkWord word3) throws IOException
	{
		if (debug) { logCall("rule50__SNnorel__GEN__SNundet_num",  word1, blank1,  word2, blank2,  word3); } 
		macro_posadet_SN(out, word1);
		word3.tlSet(attr_a_SN, "<PDET>");
		/** arregla GD i ND de SN pos1  */
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
		/** arregla GD i ND de SN pos3  */
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			word3.tlSet(attr_gen, "<m>");
		}
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			word3.tlSet(attr_nbr, "<sg>");
		}
		{
			String myword = 
			         TransferWord.copycase(word1.sl(attr_lem), word3.tl(attr_lem))
			         +word3.tl(attr_tags)
			         +word3.tl(attr_chcontent)
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
		out.append(TransferWord.copycase(word2.sl(attr_lem), "pr"));
		out.append("<PREP>{^de<pr>$}$");
		out.append(blank2);
		{
			String myword = 
			         TransferWord.copycase(word3.sl(attr_lem), word1.tl(attr_lem))
			         +word1.tl(attr_tags)
			         +word1.tl(attr_chcontent)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_determina_nbr_gen_SN(out, word3);
	}
	
	/** Regles per a sintagmes sols que han pogut quedarse amb GD, ND o PD  */
	// REGLA: SA (per assignar gènere i nombre si hi ha GD i ND que no s'han pogut determinar)
	public void rule51__SA(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule51__SA",  word1); } 
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		if ((word1.tl(attr_nbr).equals("<ND>")
    && var_nombre.equals("<>")))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
		else
		{
			word1.tlSet(attr_nbr, var_nombre);
		}
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
	
	// REGLA: SN (per assignar gènere i nombre si hi ha GD i ND que no s'han pogut determinar, com passa en alguns pronoms: both, etc.)
	public void rule52__SN(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule52__SN",  word1); } 
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
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
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: DET (per assignar gènere i nombre si hi ha GD i ND que no s'han pogut determinar, com passa en alguns pronoms: both, etc.)
	public void rule53__DET(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule53__DET",  word1); } 
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
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
	
	// REGLA: SV (per assignar persona i nombre si hi ha PD i ND que no s'han pogut determinar, escepte per als infinitius i gerundis 
	public void rule54__SV(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule54__SV",  word1); } 
		if (!(word1.tl(attr_temps).equals("<inf>")
    || word1.tl(attr_temps).equals("<ger>")))
		{
			if (word1.tl(attr_pers).equals("<PD>"))
			{
				word1.tlSet(attr_pers, "<p3>");
			}
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				word1.tlSet(attr_nbr, "<sg>");
			}
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				word1.tlSet(attr_gen, "<m>");
			}
		}
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
		macro_determina_nbr_gen_SN(out, word1);
	}
	
	// REGLA: NUM (per assignar gènere si hi ha GD)
	public void rule55__NUM(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule55__NUM",  word1); } 
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
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
	
	// REGLA: RELNN (per assignar gènere i nombre si hi ha GD i ND que no s'han pogut determinar (whom).)
	public void rule56__RELNN(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule56__RELNN",  word1); } 
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
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
	
	/**  REGLA: reset variables */
	public void rule57__punt(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule57__punt",  word1); } 
		/**  REGLA: reset variables */
		var_nombre = "<sg>";
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
}
