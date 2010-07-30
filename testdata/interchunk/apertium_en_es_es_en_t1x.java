package org.apertium.transfer.generated;
import java.io.*;
import org.apertium.transfer.*;
public class apertium_en_es_es_en_t1x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return true;
	}
	/** 
****************************************************************************
                    PRONOMBRES CLÍTICOS

Cuando el pronombre proclítico es el reflexivo 'se', y no aparece con un verbo pronominal
, se envía en un chunk aparte con lema 'ref', para que pueda detectarse en el t2x en caso necesario,
para tratar frase impersonales y pasivas reflejas ('se dice que' vs. 'se casa mañana'...).
Cuando sucede lo mismo pero se trata de un pronombre *enclítico*, no se envía aparte, simplemente
se envia el verbo sin el pronombre reflexivo. Así, por ahora, no se puede saber si un pronombre enclítico
'desaparecido' era un pronombre reflexivo aparecido junto con un verbo pronominal o un verbo no pronominal.
Si se quiere empezar a tratar las frase impersonales en el t2x, habría que hacer algo al respecto.



**************************************************************************
 */
	ApertiumRE attr_a_nom = new ApertiumRE("<n(?:p><loc|p><ant|p><cog|><acr|p><al|um|)>");
	ApertiumRE attr_a_np_acr = new ApertiumRE("<(?:acr|np)>");
	ApertiumRE attr_a_adj = new ApertiumRE("<(?:adj><sint><comp|adj><sint><sup|adj><sint|vblex><pp|adj><pos|adj)>");
	ApertiumRE attr_grau = new ApertiumRE("<sup>");
	ApertiumRE attr_a_det = new ApertiumRE("<(?:det><dem|det><ind|det><def|det><pos|det><qnt|det><itg|det><ord|predet|num)>");
	ApertiumRE attr_a_num = new ApertiumRE("<num(?:><percent|><ord|><mon|)>");
	ApertiumRE attr_a_verb = new ApertiumRE("<v(?:bhaver|blex|bser|bmod|aux)>");
	ApertiumRE attr_pron = new ApertiumRE("<pron>");
	ApertiumRE attr_sep = new ApertiumRE("<sep>");
	ApertiumRE attr_a_adv = new ApertiumRE("<(?:adv><itg|preadv|adv)>");
	ApertiumRE attr_a_rel = new ApertiumRE("<rel><(?:adv|nn|an)>");
	ApertiumRE attr_a_pp = new ApertiumRE("<v(?:blex><sep|bser><sep|bmod><sep|bhaver|blex|bser|bmod|aux)><pp>");
	ApertiumRE attr_a_prn = new ApertiumRE("<prn>");
	ApertiumRE attr_tipus_prn = new ApertiumRE("<(?:subj|obj|itg|pos|tn)>");
	ApertiumRE attr_pers = new ApertiumRE("<p(?:1|2|3)>");
	ApertiumRE attr_gen = new ApertiumRE("<(?:mf|nt|m|f)>");
	ApertiumRE attr_nbr = new ApertiumRE("<(?:sg|pl|sp|ND)>");
	ApertiumRE attr_temps = new ApertiumRE("<(?:pres|past|pprs|subs|cni|fti|ifi|imp|pii|pis|fts|pri|prs|ger|inf|pp)>");
	ApertiumRE attr_neg = new ApertiumRE("<NEG>");
	ApertiumRE attr_lem = new ApertiumRE("(([^<]|\"\\<\")+)");
	ApertiumRE attr_lemq = new ApertiumRE("\\#[- _][^<]+");
	ApertiumRE attr_lemh = new ApertiumRE("(([^<#]|\"\\<\"|\"\\#\")+)");
	ApertiumRE attr_whole = new ApertiumRE("(.+)");
	ApertiumRE attr_tags = new ApertiumRE("((<[^>]+>)+)");
	ApertiumRE attr_chname = new ApertiumRE("(\\{([^/]+)\\/)");
	ApertiumRE attr_chcontent = new ApertiumRE("(\\{.+)");
	ApertiumRE attr_content = new ApertiumRE("(\\{.+)");
	/** 
****************************************************************************
                    PRONOMBRES CLÍTICOS

Cuando el pronombre proclítico es el reflexivo 'se', y no aparece con un verbo pronominal
, se envía en un chunk aparte con lema 'ref', para que pueda detectarse en el t2x en caso necesario,
para tratar frase impersonales y pasivas reflejas ('se dice que' vs. 'se casa mañana'...).
Cuando sucede lo mismo pero se trata de un pronombre *enclítico*, no se envía aparte, simplemente
se envia el verbo sin el pronombre reflexivo. Así, por ahora, no se puede saber si un pronombre enclítico
'desaparecido' era un pronombre reflexivo aparecido junto con un verbo pronominal o un verbo no pronominal.
Si se quiere empezar a tratar las frase impersonales en el t2x, habría que hacer algo al respecto.



**************************************************************************
 */
	String var_nombre = "<sg>";
	String var_genere = "<m>";
	String var_concDet = "";
	String var_concAdj = "";
	String var_concPrimero = "";
	String var_concSegundo = "";
	String var_concTercero = "";
	String var_interrogativa = "";
	String var_exclamativa = "";
	String var_caseFirstWord = "";
	String var_caseSecondWord = "";
	String var_lema = "";
	String var_lema_SV = "";
	String var_EOS = "true";
	String var_paraula1 = "";
	String var_SVnegatiu = "";
	String var_auxiliar = "";
	String var_adv_adjectiu = "";
	String var_tempsv = "";
	String var_temps_chunk = "";
	String var_pers_chunk = "";
	String var_nbr_chunk = "";
	String var_gen_chunk = "";
	String var_nom_chunk = "";
	String var_verbfinal = "";
	String var_superlatiu1 = "";
	String var_superlatiu2 = "";
	/** 
****************************************************************************
                    PRONOMBRES CLÍTICOS

Cuando el pronombre proclítico es el reflexivo 'se', y no aparece con un verbo pronominal
, se envía en un chunk aparte con lema 'ref', para que pueda detectarse en el t2x en caso necesario,
para tratar frase impersonales y pasivas reflejas ('se dice que' vs. 'se casa mañana'...).
Cuando sucede lo mismo pero se trata de un pronombre *enclítico*, no se envía aparte, simplemente
se envia el verbo sin el pronombre reflexivo. Así, por ahora, no se puede saber si un pronombre enclítico
'desaparecido' era un pronombre reflexivo aparecido junto con un verbo pronominal o un verbo no pronominal.
Si se quiere empezar a tratar las frase impersonales en el t2x, habría que hacer algo al respecto.



**************************************************************************
 */
	TransferWordList list_det_canviant = new TransferWordList(new String[] { "uno", "otro", "poco", "cuánto", "menos", "mucho", "tanto", "demasiado", });
	TransferWordList list_preps_inf = new TransferWordList(new String[] { "so as to", "with a view to", "to", "in order to", });
	TransferWordList list_en_majuscules = new TransferWordList(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", });
	
	/** 
****************************************************************************
                    PRONOMBRES CLÍTICOS

Cuando el pronombre proclítico es el reflexivo 'se', y no aparece con un verbo pronominal
, se envía en un chunk aparte con lema 'ref', para que pueda detectarse en el t2x en caso necesario,
para tratar frase impersonales y pasivas reflejas ('se dice que' vs. 'se casa mañana'...).
Cuando sucede lo mismo pero se trata de un pronombre *enclítico*, no se envía aparte, simplemente
se envia el verbo sin el pronombre reflexivo. Así, por ahora, no se puede saber si un pronombre enclítico
'desaparecido' era un pronombre reflexivo aparecido junto con un verbo pronominal o un verbo no pronominal.
Si se quiere empezar a tratar las frase impersonales en el t2x, habría que hacer algo al respecto.



**************************************************************************
 */
	private void macro_f_bcond(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_f_bcond",  word1, blank1,  word2); } 
		/** Per mirar si el blanc conté o no format. Cal posar aquesta funció en les regles en què desaparegui alguna paraula, per tal de decidir si el blanc de la paraula eliminada s'ha d'eliminar o conservar. Si conté format cal conservar-la, si no en conté cal eliminar-la perquè no apareguin dos espais seguits.  */
		if (!blank1.equals(" "))
		{
			out.append(blank1);
		}
	}
	
	private void macro_nombre_nom(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_nombre_nom",  word1); } 
		/**  per determinar si hi ha hagut canvi de nombre en la traducció. Després d'aquesta macro s'aplica la macro 'canvia_det'. Caldria ajuntar aquesta macro i la 'canvia_det' !!!!!!!  */
		var_nombre = "";
		if ((word1.sl(attr_nbr).equals("<sg>")
    && word1.tl(attr_nbr).equals("<pl>")))
		{
			var_nombre = "<pl_slsg>";
		}
		else
		if ((word1.sl(attr_nbr).equals("<pl>")
    && word1.tl(attr_nbr).equals("<sg>")))
		{
			var_nombre = "<sg_slpl>";
		}
		else
		{
			var_nombre = word1.tl(attr_nbr);
		}
	}
	
	private void macro_canvia_det(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_canvia_det",  word1, blank1,  word2); } 
		if (list_det_canviant.containsIgnoreCase(word1.sl(attr_lem)))
		{
			if ((var_nombre.equals("<sg_slpl>")
    || (word2.sl(attr_nbr).equals("<sg>")
    && word1.sl(attr_nbr).equals("<pl>"))))
			{
				if (word1.tl(attr_lem).equalsIgnoreCase("some"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "a"));
					word1.tlSet(attr_a_det, "<det><ind>");
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("other"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "another"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("few"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "little"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("how many"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "how much"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("fewer"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "less"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("many"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "much"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("so many"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "so much"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("too many"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "too much"));
				}
			}
			else
			if ((var_nombre.equals("<pl_slsg>")
    || (word2.sl(attr_nbr).equals("<pl>")
    && word1.sl(attr_nbr).equals("<sg>"))))
			{
				if (word1.tl(attr_lem).equalsIgnoreCase("a"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "some"));
					word1.tlSet(attr_a_det, "<det><qnt>");
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("another"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "other"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("little"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "few"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("how much"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "how many"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("less"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "fewer"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("much"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "many"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("so much"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "so many"));
				}
				else
				if (word1.tl(attr_lem).equalsIgnoreCase("too much"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "too many"));
				}
			}
			else
			if (word1.sl(attr_lem).equalsIgnoreCase("menys"))
			{
				if (word2.tl(attr_nbr).equals("<sg>"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "less"));
				}
				else
				if (word2.tl(attr_nbr).equals("<pl>"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "fewer"));
				}
			}
			else
			if (word1.sl(attr_lem).equalsIgnoreCase("massa"))
			{
				if (word2.tl(attr_nbr).equals("<sg>"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "too much"));
				}
				else
				if (word2.tl(attr_nbr).equals("<pl>"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "too many"));
				}
			}
		}
	}
	
	private void macro_f_concord2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_f_concord2",  word1, blank1,  word2); } 
		/** element 1= principal (nom). Element 2 = secundari (adj/det) 
				    En anglès els noms poden ser sg, pl o ND (mai sp en els diccs actuals) */
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			if ((word2.tl(attr_nbr).equals("<sg>")
    || word2.tl(attr_nbr).equals("<pl>")))
			{
				word1.tlSet(attr_nbr, word2.tl(attr_nbr));
			}
			else
			if (word2.tl(attr_a_num).equals("<num>"))
			{
				word1.tlSet(attr_nbr, "<pl>");
			}
		}
	}
	
	private void macro_f_concord3(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("macro_f_concord3",  word1, blank1,  word2, blank2,  word3); } 
		/** element 1= principal (nom). Element 2 i 3 = secundari (adj/det) 
				    En anglès els noms poden ser sg, pl o ND (mai sp en els diccs actuals) */
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			if ((word2.tl(attr_nbr).equals("<sg>")
    || word2.tl(attr_nbr).equals("<pl>")))
			{
				word1.tlSet(attr_nbr, word2.tl(attr_nbr));
			}
			else
			if (word2.tl(attr_a_num).equals("<num>"))
			{
				word1.tlSet(attr_nbr, "<pl>");
			}
			else
			if ((word3.tl(attr_nbr).equals("<sg>")
    || word3.tl(attr_nbr).equals("<pl>")))
			{
				word1.tlSet(attr_nbr, word3.tl(attr_nbr));
			}
			else
			if (word3.tl(attr_a_num).equals("<num>"))
			{
				word1.tlSet(attr_nbr, "<pl>");
			}
		}
	}
	
	private void macro_f_concord4(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("macro_f_concord4",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		/** element 1= principal (nom). Element 2 i 3 = secundari (adj/det) 
				    En anglès els noms poden ser sg, pl o ND (mai sp en els diccs actuals) */
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			if ((word2.tl(attr_nbr).equals("<sg>")
    || word2.tl(attr_nbr).equals("<pl>")))
			{
				word1.tlSet(attr_nbr, word2.tl(attr_nbr));
			}
			else
			if (word2.tl(attr_a_num).equals("<num>"))
			{
				word1.tlSet(attr_nbr, "<pl>");
			}
			else
			if ((word3.tl(attr_nbr).equals("<sg>")
    || word3.tl(attr_nbr).equals("<pl>")))
			{
				word1.tlSet(attr_nbr, word3.tl(attr_nbr));
			}
			else
			if (word3.tl(attr_a_num).equals("<num>"))
			{
				word1.tlSet(attr_nbr, "<pl>");
			}
			else
			if ((word4.tl(attr_nbr).equals("<sg>")
    || word4.tl(attr_nbr).equals("<pl>")))
			{
				word1.tlSet(attr_nbr, word4.tl(attr_nbr));
			}
			else
			if (word4.tl(attr_a_num).equals("<num>"))
			{
				word1.tlSet(attr_nbr, "<pl>");
			}
		}
	}
	
	private void macro_elimina_ND(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_elimina_ND",  word1); } 
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
	}
	
	private void macro_firstWord(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_firstWord",  word1); } 
		/** nova versió 8-febr-08   */
		if (var_EOS.equals("true"))
		{
			if ((word1.sl(attr_a_np_acr).equals("")
    && !list_en_majuscules.contains(word1.tl(attr_lem))))
			{
				word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
			}
			var_caseFirstWord = "Aa";
		}
		else
		{
			var_caseFirstWord = "aa";
		}
		/** 	</when>
	<otherwise>
	  <let>
	    <var n="caseFirstWord"/>
	    <lit v="aa"/>
	  </let>
	</otherwise>
      </choose> */
		var_EOS = "false";
	}
	
	private void macro_prep_inf(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_prep_inf",  word1, blank1,  word2); } 
		if ((word1.sl(attr_lem).equalsIgnoreCase("para")
    || word1.sl(attr_lem).equalsIgnoreCase("de")))
		{
			word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "to"));
		}
		else
		if (word1.sl(attr_lem).equalsIgnoreCase("por"))
		{
			word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "for"));
		}
		if (word2.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "be able to"));
			word2.tlSet(attr_a_verb, "<vbmod>");
		}
		if (!list_preps_inf.containsIgnoreCase(word1.tl(attr_lem)))
		{
			word2.tlSet(attr_temps, "<ger>");
			var_tempsv = "ger";
		}
		else
		{
			var_tempsv = "inf";
		}
	}
	
	private void macro_adv_adj(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_adv_adj",  word1, blank1,  word2); } 
		/**  (per a fer el comparatiu si cal: 'més fosc' = darker; i també per a canviar 'well' per 'very' davant adjectius )". En les regles, és obligatori que s'executi després de la macro 'f_superlatiu1' aplicada a l'adjectiu.   */
		if ((word1.sl(attr_lem).equalsIgnoreCase("más")
    && word2.tl(attr_a_adj).equals("<adj><sint>")))
		{
			var_adv_adjectiu = (""+word2.tl(attr_lem)+word2.tl(attr_a_adj)+"<comp>");
		}
		else
		if ((word1.sl(attr_lem).equalsIgnoreCase("mucho más")
    && word2.tl(attr_a_adj).equals("<adj><sint>")))
		{
			word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "much"));
			var_adv_adjectiu = (""+word1.tl(attr_whole)+"$ ^"+word2.tl(attr_lem)+word2.tl(attr_a_adj)+"<comp>");
		}
		else
		if ((word1.sl(attr_lem).equalsIgnoreCase("bien")
    && !word2.sl(attr_a_adj).equals("<vblex><pp>")))
		{
			var_adv_adjectiu = (""+TransferWord.copycase(word1.sl(attr_lem), "very")+"<preadv>"+"$ ^"+word2.tl(attr_lem)+word2.tl(attr_a_adj));
		}
		else
		{
			var_adv_adjectiu = (""+word1.tl(attr_whole)+"$ ^"+var_superlatiu1+word2.tl(attr_lem)+word2.tl(attr_a_adj));
		}
	}
	
	private void macro_det_adv_adj(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("macro_det_adv_adj",  word1, blank1,  word2, blank2,  word3); } 
		/**  (per a fer el comparatiu i superlatiu si cal: 'més fosc' = 'darker'; 'el més fosc' = 'the darkest')". En les regles, és obligatori que s'executi després de la macro 'f_superlatiu1' aplicada a l'adjectiu.  */
		if ((word2.sl(attr_lem).equalsIgnoreCase("más")
    && word3.tl(attr_a_adj).equals("<adj><sint>")))
		{
			if (word1.sl(attr_a_det).equals("<det><def>"))
			{
				var_adv_adjectiu = (""+word3.tl(attr_lem)+word3.tl(attr_a_adj)+"<sup>");
			}
			else
			{
				var_adv_adjectiu = (""+word3.tl(attr_lem)+word3.tl(attr_a_adj)+"<comp>");
			}
		}
		else
		if ((word2.sl(attr_lem).equalsIgnoreCase("mucho más")
    && word3.tl(attr_a_adj).equals("<adj><sint>")))
		{
			word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "much"));
			var_adv_adjectiu = (""+word2.tl(attr_whole)+"$ ^"+word3.tl(attr_lem)+word3.tl(attr_a_adj)+"<comp>");
		}
		else
		if ((word2.sl(attr_lem).equalsIgnoreCase("más")
    && word1.sl(attr_a_det).equals("<det><def>")))
		{
			word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "most"));
			var_adv_adjectiu = (""+word2.tl(attr_whole)+"$ ^"+word3.tl(attr_lem)+word3.tl(attr_a_adj));
		}
		else
		if ((word2.sl(attr_lem).equalsIgnoreCase("bien")
    && !word3.sl(attr_a_adj).equals("<vblex><pp>")))
		{
			var_adv_adjectiu = (""+TransferWord.copycase(word2.sl(attr_lem), "very")+"<preadv>"+"$ ^"+word3.tl(attr_lem)+word3.tl(attr_a_adj));
		}
		else
		{
			var_adv_adjectiu = (""+word2.tl(attr_whole)+"$ ^"+var_superlatiu1+word3.tl(attr_lem)+word3.tl(attr_a_adj));
		}
	}
	
	private void macro_el_millor_pitjor(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_el_millor_pitjor",  word1, blank1,  word2); } 
		/**  per a crear forma superlativa quan lema és superlatiu i l'article és definit o poss  */
		if (((word1.tl(attr_a_det).equals("<det><def>")
    || word1.tl(attr_a_det).equals("<det><pos>"))
    && (word2.sl(attr_lem).equalsIgnoreCase("mejor")
    || word2.sl(attr_lem).equalsIgnoreCase("peor"))))
		{
			word2.tlSet(attr_a_adj, "<adj><sint><sup>");
		}
	}
	
	private void macro_f_superlatiu1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_f_superlatiu1",  word1); } 
		if (word1.sl(attr_grau).equals("<sup>"))
		{
			var_superlatiu1 = (""+TransferWord.copycase(word1.sl(attr_lem), "very")+"<preadv>"+"$ ^");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
			if (word1.tl(attr_a_adj).equals("<adj><sint><sup>"))
			{
				word1.tlSet(attr_a_adj, "<adj><sint>");
			}
		}
		else
		{
			var_superlatiu1 = "";
		}
	}
	
	private void macro_f_superlatiu2(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_f_superlatiu2",  word1); } 
		/**  Aquesta és per quan hi ha dos adjs en una regla  */
		if (word1.sl(attr_grau).equals("<sup>"))
		{
			var_superlatiu2 = (""+TransferWord.copycase(word1.sl(attr_lem), "very")+"<preadv>"+"$ ^");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
			if (word1.tl(attr_a_adj).equals("<adj><sint><sup>"))
			{
				word1.tlSet(attr_a_adj, "<adj><sint>");
			}
		}
		else
		{
			var_superlatiu2 = "";
		}
	}
	
	private void macro_conj_verb1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_conj_verb1",  word1); } 
		/** conjuga un verb  */
		if ((word1.tl(attr_lemh).equalsIgnoreCase("be")
    && (word1.sl(attr_temps).equals("<ifi>")
    || word1.sl(attr_temps).equals("<pii>")
    || word1.sl(attr_temps).equals("<pis>")
    || word1.sl(attr_temps).equals("<fts>")
    || word1.sl(attr_temps).equals("<prs>"))
    && (word1.sl(attr_pers).equals("<p1>")
    || word1.sl(attr_pers).equals("<p3>"))
    && word1.sl(attr_nbr).equals("<sg>")))
		{
			word1.tlSet(attr_temps, "<past>");
			var_temps_chunk = "<past>";
			var_lema_SV = "verbcj";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_sep)+word1.tl(attr_temps)+word1.tl(attr_pers)+word1.tl(attr_nbr));
		}
		else
		if ((word1.tl(attr_lemh).equalsIgnoreCase("be")
    && word1.sl(attr_temps).equals("<pri>")
    && (word1.sl(attr_pers).equals("<p1>")
    || word1.sl(attr_pers).equals("<p3>"))
    && word1.sl(attr_nbr).equals("<sg>")))
		{
			var_temps_chunk = word1.tl(attr_temps);
			var_lema_SV = "verbcj";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_sep)+word1.tl(attr_temps)+word1.tl(attr_pers)+word1.tl(attr_nbr));
		}
		else
		if ((word1.sl(attr_temps).equals("<pri>")
    && word1.sl(attr_pers).equals("<p3>")
    && word1.sl(attr_nbr).equals("<sg>")
    && !word1.sl(attr_lem).equalsIgnoreCase("poder")))
		{
			var_lema_SV = "verbcj";
			var_temps_chunk = word1.tl(attr_temps);
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_sep)+word1.tl(attr_temps)+word1.tl(attr_pers)+word1.tl(attr_nbr));
		}
		else
		{
			if ((word1.sl(attr_temps).equals("<cni>")
    && !word1.sl(attr_lem).equalsIgnoreCase("poder")))
			{
				var_temps_chunk = word1.sl(attr_temps);
				word1.tlSet(attr_temps, "<inf>");
				var_lema_SV = "aux_verb";
				word1.tlSet(attr_lemh, TransferWord.copycase("aa", word1.tl(attr_lemh)));
				var_verbfinal = (""+TransferWord.copycase(word1.sl(attr_lem), "would")+"<vaux><inf>"+"$ ^"+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_sep)+word1.tl(attr_temps));
			}
			else
			if ((word1.sl(attr_temps).equals("<cni>")
    && word1.sl(attr_lem).equalsIgnoreCase("poder")))
			{
				word1.tlSet(attr_temps, "<past>");
				var_temps_chunk = word1.sl(attr_temps);
				var_lema_SV = "verbcj";
				var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_sep)+word1.tl(attr_temps));
			}
			else
			if (word1.sl(attr_temps).equals("<fti>"))
			{
				word1.tlSet(attr_temps, "<inf>");
				var_temps_chunk = word1.sl(attr_temps);
				var_lema_SV = "aux_verb";
				if (word1.sl(attr_lem).equalsIgnoreCase("poder"))
				{
					word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "be able to"));
					word1.tlSet(attr_a_verb, "<vbmod>");
				}
				word1.tlSet(attr_lemh, TransferWord.copycase("aa", word1.tl(attr_lemh)));
				var_verbfinal = (""+TransferWord.copycase(word1.sl(attr_lem), "will")+"<vaux><inf>"+"$ ^"+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_sep)+word1.tl(attr_temps));
			}
			else
			if ((word1.sl(attr_temps).equals("<pri>")
    || word1.sl(attr_temps).equals("<prs>")
    || word1.sl(attr_temps).equals("<imp>")))
			{
				word1.tlSet(attr_temps, "<pres>");
				var_temps_chunk = word1.sl(attr_temps);
				var_lema_SV = "verbcj";
				var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_sep)+word1.tl(attr_temps));
			}
			else
			if ((word1.sl(attr_temps).equals("<ifi>")
    || word1.sl(attr_temps).equals("<pii>")
    || word1.sl(attr_temps).equals("<pis>")
    || word1.sl(attr_temps).equals("<fts>")))
			{
				word1.tlSet(attr_temps, "<past>");
				var_temps_chunk = word1.sl(attr_temps);
				var_lema_SV = "verbcj";
				var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_sep)+word1.tl(attr_temps));
			}
			else
			{
				var_temps_chunk = word1.sl(attr_temps);
				var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_sep)+word1.tl(attr_temps));
			}
		}
	}
	
	private void macro_conj_haverhi_pp(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_conj_haverhi_pp",  word1); } 
		/** conjuga el verb haver-hi quan va seguit de pp  */
		var_pers_chunk = word1.sl(attr_pers);
		if ((word1.sl(attr_temps).equals("<pri>")
    || word1.sl(attr_temps).equals("<prs>")
    || word1.sl(attr_temps).equals("<imp>")))
		{
			word1.tlSet(attr_temps, "<pri>");
			var_temps_chunk = word1.tl(attr_temps);
			var_nbr_chunk = "<ND>";
			var_lema_SV = "haverhi_pp";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_temps)+word1.tl(attr_pers)+"<5>");
		}
		else
		if ((word1.sl(attr_temps).equals("<ifi>")
    || word1.sl(attr_temps).equals("<pii>")
    || word1.sl(attr_temps).equals("<pis>")
    || word1.sl(attr_temps).equals("<fts>")))
		{
			word1.tlSet(attr_temps, "<past>");
			var_temps_chunk = word1.tl(attr_temps);
			var_nbr_chunk = word1.sl(attr_nbr);
			var_lema_SV = "haverhi_pp";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_temps));
		}
		else
		if (word1.sl(attr_temps).equals("<cni>"))
		{
			var_temps_chunk = word1.sl(attr_temps);
			word1.tlSet(attr_temps, "<inf>");
			var_nbr_chunk = word1.sl(attr_nbr);
			var_lema_SV = "aux_haverhi_pp";
			word1.tlSet(attr_lemh, TransferWord.copycase("aa", word1.tl(attr_lemh)));
			var_verbfinal = (""+TransferWord.copycase(word1.sl(attr_lem), "would")+"<vaux><inf>"+"$ ^"+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_temps));
		}
		else
		if (word1.sl(attr_temps).equals("<fti>"))
		{
			var_temps_chunk = word1.sl(attr_temps);
			var_nbr_chunk = word1.sl(attr_nbr);
			word1.tlSet(attr_temps, "<inf>");
			var_lema_SV = "aux_haverhi_pp";
			word1.tlSet(attr_lemh, TransferWord.copycase("aa", word1.tl(attr_lemh)));
			var_verbfinal = (""+TransferWord.copycase(word1.sl(attr_lem), "will")+"<vaux><inf>"+"$ ^"+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_temps));
		}
	}
	
	private void macro_conj_haverhi(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_conj_haverhi",  word1); } 
		/** conjuga el verb haver-hi  */
		var_pers_chunk = word1.sl(attr_pers);
		if ((word1.sl(attr_temps).equals("<pri>")
    || word1.sl(attr_temps).equals("<prs>")
    || word1.sl(attr_temps).equals("<imp>")))
		{
			word1.tlSet(attr_temps, "<pri>");
			var_temps_chunk = word1.tl(attr_temps);
			var_nbr_chunk = "<ND>";
			var_lema_SV = "haverhi";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_temps)+word1.tl(attr_pers)+"<5>");
		}
		else
		if ((word1.sl(attr_temps).equals("<ifi>")
    || word1.sl(attr_temps).equals("<pii>")
    || word1.sl(attr_temps).equals("<pis>")
    || word1.sl(attr_temps).equals("<fts>")))
		{
			word1.tlSet(attr_temps, "<past>");
			var_temps_chunk = word1.tl(attr_temps);
			var_nbr_chunk = "<ND>";
			var_lema_SV = "haverhi";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_temps)+word1.tl(attr_pers)+"<5>");
		}
		else
		if (word1.sl(attr_temps).equals("<cni>"))
		{
			var_temps_chunk = word1.sl(attr_temps);
			word1.tlSet(attr_temps, "<inf>");
			var_nbr_chunk = word1.sl(attr_nbr);
			var_lema_SV = "aux_haverhi";
			word1.tlSet(attr_lemh, TransferWord.copycase("aa", word1.tl(attr_lemh)));
			var_verbfinal = (""+TransferWord.copycase(word1.sl(attr_lem), "would")+"<vaux><inf>"+"$ ^"+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_temps));
		}
		else
		if (word1.sl(attr_temps).equals("<fti>"))
		{
			var_temps_chunk = word1.sl(attr_temps);
			var_nbr_chunk = word1.sl(attr_nbr);
			word1.tlSet(attr_temps, "<inf>");
			var_lema_SV = "aux_haverhi";
			word1.tlSet(attr_lemh, TransferWord.copycase("aa", word1.tl(attr_lemh)));
			var_verbfinal = (""+TransferWord.copycase(word1.sl(attr_lem), "will")+"<vaux><inf>"+"$ ^"+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+word1.tl(attr_temps));
		}
	}
	
	/** 
****************************************************************************
                    PRONOMBRES CLÍTICOS

Cuando el pronombre proclítico es el reflexivo 'se', y no aparece con un verbo pronominal
, se envía en un chunk aparte con lema 'ref', para que pueda detectarse en el t2x en caso necesario,
para tratar frase impersonales y pasivas reflejas ('se dice que' vs. 'se casa mañana'...).
Cuando sucede lo mismo pero se trata de un pronombre *enclítico*, no se envía aparte, simplemente
se envia el verbo sin el pronombre reflexivo. Así, por ahora, no se puede saber si un pronombre enclítico
'desaparecido' era un pronombre reflexivo aparecido junto con un verbo pronominal o un verbo no pronominal.
Si se quiere empezar a tratar las frase impersonales en el t2x, habría que hacer algo al respecto.



**************************************************************************
*************************************** REGLES DE SN ********************************************  */
	// REGLA: NOM (per a col·locar la cua en les multiparaules amb g
	public void rule0__nom(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule0__nom",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom"));
		out.append("<SN>");
		out.append(word1.sl(attr_gen));
		/** es manté per finalitats informatives  */
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +(word1.tl(attr_nbr).isEmpty()?"" : "<3>")
			         +word1.tl(attr_lemq)
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
	
	// REGLA: ANTROPÒNIM
	public void rule1__ant(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule1__ant",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant"));
		out.append("<SN>");
		out.append(word1.sl(attr_gen));
		out.append(word1.tl(attr_nbr));
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
	
	// REGLA: DET ANTROPÒNIM (La Maria - Maria)
	public void rule2__det__ant(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule2__det__ant",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant"));
		out.append("<SN>");
		out.append(word2.sl(attr_gen));
		out.append(word2.tl(attr_nbr));
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
		out.append("}$");
	}
	
	// REGLA: TITULO ANTROPÒNIM (Su Majestad Juan Carlos - His Majesty Juan Carlos)
	public void rule3__majestad__ant(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule3__majestad__ant",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		if (word2.sl(attr_gen).equals("<f>"))
		{
			if (word1.sl(attr_lem).equals("Su Majestad"))
			{
				word1.tlSet(attr_lem, "Her Majesty");
			}
			else
			if (word1.sl(attr_lem).equals("Su Alteza"))
			{
				word1.tlSet(attr_lem, "Her Highness");
			}
			else
			if (word1.sl(attr_lem).equals("Su Alteza Real"))
			{
				word1.tlSet(attr_lem, "Her Royal Highness");
			}
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ant"));
		out.append("<SN>");
		out.append(word2.sl(attr_gen));
		out.append(word2.tl(attr_nbr));
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
		out.append("}$");
	}
	
	// REGLA: DET NOM
	public void rule4__det__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule4__det__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_nombre_nom(out, word2);
		macro_canvia_det(out, word1, blank1, word2);
		macro_f_concord2(out, word2, " ", word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom"));
		out.append("<SN>");
		out.append(word2.sl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_nbr).isEmpty()?"" : "<3>")
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +(word2.tl(attr_nbr).isEmpty()?"" : "<3>")
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
	
	// REGLA: NUM NOM
	public void rule5__num__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule5__num__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_f_concord2(out, word2, " ", word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_nom"));
		out.append("<SN>");
		out.append(word2.sl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_tags)
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +(word2.tl(attr_nbr).isEmpty()?"" : "<3>")
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
	
	// REGLA: NOM ADJ
	public void rule6__nom__adj(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule6__nom__adj",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_f_superlatiu1(out, word2);
		macro_f_concord2(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj"));
		out.append("<SN>");
		out.append(word1.sl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         var_superlatiu1
			         +word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
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
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +(word1.tl(attr_nbr).isEmpty()?"" : "<3>")
			         +word1.tl(attr_lemq)
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
	
	// REGLA: NOM ADJ ADJ
	public void rule7__nom__adj_pp__adj(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule7__nom__adj_pp__adj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_f_superlatiu1(out, word2);
		macro_f_superlatiu2(out, word3);
		macro_f_concord3(out, word1, blank1, word2, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj_adj"));
		out.append("<SN>");
		out.append(word1.sl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         var_superlatiu2
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_adj)
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
			         var_superlatiu1
			         +word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
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
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +(word1.tl(attr_nbr).isEmpty()?"" : "<3>")
			         +word1.tl(attr_lemq)
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
	
	// REGLA: DET NOM ADJ
	public void rule8__det__nom__adj(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule8__det__nom__adj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_nombre_nom(out, word2);
		macro_f_superlatiu1(out, word3);
		macro_canvia_det(out, word1, blank1, word2);
		macro_f_concord3(out, word2, " ", word1, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj"));
		out.append("<SN>");
		out.append(word2.sl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +word1.tl(attr_nbr)
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
			         var_superlatiu1
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_adj)
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +(word2.tl(attr_nbr).isEmpty()?"" : "<3>")
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
	
	// REGLA: DET ADJ NOM
	public void rule9__det__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule9__det__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_nombre_nom(out, word3);
		macro_f_superlatiu1(out, word2);
		macro_canvia_det(out, word1, blank2, word3);
		macro_el_millor_pitjor(out, word1, blank1, word2);
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_adj_nom"));
		out.append("<SN>");
		out.append(word3.sl(attr_gen));
		out.append(word3.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +word1.tl(attr_nbr)
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
			         var_superlatiu1
			         +word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
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
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_nbr).isEmpty()?"" : "<3>")
			         +word3.tl(attr_lemq)
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
	
	// REGLA: DET ADJ NOM ADJ
	public void rule10__det__adj__nom__adj(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule10__det__adj__nom__adj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_nombre_nom(out, word3);
		macro_canvia_det(out, word1, blank2, word3);
		macro_f_superlatiu1(out, word2);
		macro_f_superlatiu2(out, word4);
		macro_el_millor_pitjor(out, word1, blank1, word2);
		macro_f_concord4(out, word3, blank1, word2, " ", word1, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_adj_adj_nom"));
		out.append("<SN>");
		out.append(word3.sl(attr_gen));
		out.append(word3.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +word1.tl(attr_nbr)
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
			         var_superlatiu1
			         +word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
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
			         var_superlatiu2
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_adj)
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
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_nbr).isEmpty()?"" : "<3>")
			         +word3.tl(attr_lemq)
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
	
	// REGLA: DET NOM ADJ ADJ
	public void rule11__det__nom__adj__adj(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule11__det__nom__adj__adj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_nombre_nom(out, word2);
		macro_canvia_det(out, word1, blank1, word2);
		macro_f_superlatiu1(out, word3);
		macro_f_superlatiu2(out, word4);
		macro_f_concord4(out, word2, blank2, word3, " ", word1, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_adj_adj_nom"));
		out.append("<SN>");
		out.append(word2.sl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +word1.tl(attr_nbr)
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
			         var_superlatiu2
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_adj)
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
			         var_superlatiu1
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_adj)
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +(word2.tl(attr_nbr).isEmpty()?"" : "<3>")
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
	
	// REGLA: NUM NOM ADJ
	public void rule12__num__nom__adj(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule12__num__nom__adj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_f_superlatiu1(out, word3);
		macro_f_concord3(out, word2, " ", word1, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_nom_adj"));
		out.append("<SN>");
		out.append(word2.sl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_tags)
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
			         var_superlatiu1
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_adj)
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +(word2.tl(attr_nbr).isEmpty()?"" : "<3>")
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
	
	// REGLA: DET NOM ADV ADJ
	public void rule13__det__nom__adv_preadv__adj_pp(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule13__det__nom__adv_preadv__adj_pp",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_nombre_nom(out, word2);
		macro_canvia_det(out, word1, blank1, word2);
		/** aquí no envio variable 'superlatiu' perquè s'envia dins de adv_adjectiu  */
		macro_f_superlatiu1(out, word4);
		macro_det_adv_adj(out, word1, blank2, word3, blank3, word4);
		macro_f_concord3(out, word2, " ", word1, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adv_adj"));
		out.append("<SN>");
		out.append(word2.sl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +word1.tl(attr_nbr)
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
			         var_adv_adjectiu
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +(word2.tl(attr_nbr).isEmpty()?"" : "<3>")
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
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// REGLA: NUM NOM ADV ADJ
	public void rule14__num__nom__adv_preadv__adj_pp(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule14__num__nom__adv_preadv__adj_pp",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_nombre_nom(out, word2);
		/** aquí no envio variable 'superlatiu' perquè s'envia dins de adv_adjectiu  */
		macro_f_superlatiu1(out, word4);
		macro_adv_adj(out, word3, blank3, word4);
		macro_f_concord3(out, word2, " ", word1, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_nom_adv_adj"));
		out.append("<SN>");
		out.append(word2.sl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_tags)
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
			         var_adv_adjectiu
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +(word2.tl(attr_nbr).isEmpty()?"" : "<3>")
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
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// REGLA: NOM ADJ conj ADJ NOM (aspecte fràgil i tímida aparença -> fragile look and shy appearance. Regla creada perquè no entrin frases que no toquen en la regla següent
	public void rule15__nom__adj_pp__cnjcoo__adj_pp__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule15__nom__adj_pp__cnjcoo__adj_pp__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_f_superlatiu1(out, word2);
		macro_f_superlatiu2(out, word4);
		if ((word4.sl(attr_gen).equals(word5.sl(attr_gen))
    && word4.sl(attr_nbr).equals(word5.sl(attr_nbr))))
		{
			macro_f_concord2(out, word1, blank1, word2);
			macro_f_concord2(out, word5, blank3, word4);
			macro_elimina_ND(out, word5);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj_coo_adj_nom"));
			out.append("<SN>");
			out.append(word1.sl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_superlatiu1
				         +word2.tl(attr_lem)
				         +word2.tl(attr_a_adj)
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
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_nom)
				         +(word1.tl(attr_nbr).isEmpty()?"" : "<3>")
				         +word1.tl(attr_lemq)
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
				         var_superlatiu2
				         +word4.tl(attr_lem)
				         +word4.tl(attr_a_adj)
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
				         word5.tl(attr_lemh)
				         +word5.tl(attr_a_nom)
				         +word5.tl(attr_nbr)
				         +word5.tl(attr_lemq)
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
			macro_f_concord3(out, word1, blank1, word2, blank3, word4);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj_coo_adj"));
			out.append("<SN>");
			out.append(word1.sl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_superlatiu1
				         +word2.tl(attr_lem)
				         +word2.tl(attr_a_adj)
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
				         var_superlatiu2
				         +word4.tl(attr_lem)
				         +word4.tl(attr_a_adj)
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
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_nom)
				         +(word1.tl(attr_nbr).isEmpty()?"" : "<3>")
				         +word1.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append("}$");
			out.append(blank4);
			out.append("^nom<SN>");
			out.append(word5.sl(attr_gen));
			out.append(word5.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word5.tl(attr_lemh)
				         +word5.tl(attr_a_nom)
				         +(word5.tl(attr_nbr).isEmpty()?"" : "<3>")
				         +word5.tl(attr_lemq)
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
	
	// REGLA: NOM ADJ conj ADJ (aspecte fràgil i tímid -> fragile and shy look
	public void rule16__nom__adj_pp__cnjcoo__adj(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule16__nom__adj_pp__cnjcoo__adj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		/** Pot haver-hi errors per lo de mf perquè pot ser que un sigui m i l'altra f perquè el tagger s'hagi equivocat (noia bonica i interessant). No donarà error en frases com "aspecte fràgil i tímida aparença" perquè entraran per la regla anterior. mireia adequar a novetat mf  */
		macro_firstWord(out, word1);
		macro_f_superlatiu1(out, word2);
		macro_f_superlatiu2(out, word4);
		macro_f_concord3(out, word1, blank1, word2, blank3, word4);
		/** 	<choose>
	  <when>
	    <test>
	      <and>
		<equal>
		  <clip pos="1" side="sl" part="gen"/>
		  <clip pos="4" side="sl" part="gen"/>
		</equal>
		<equal>
		  <clip pos="1" side="sl" part="nbr"/>
		  <clip pos="4" side="sl" part="nbr"/>
		</equal>
	      </and>
	    </test>  */
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj_coo_adj"));
		out.append("<SN>");
		out.append(word1.sl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         var_superlatiu1
			         +word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
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
			         var_superlatiu2
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_adj)
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
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +(word1.tl(attr_nbr).isEmpty()?"" : "<3>")
			         +word1.tl(attr_lemq)
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
	
	/**   </when>
	  <otherwise>
	    <out>
	      <chunk name="nom_adj" case="caseFirstWord">
		<tags>
		  <tag><lit-tag v="SN"/></tag>
		  <tag><clip pos="1" side="sl" part="gen"/></tag>
		  <tag><var n="nombre"/></tag>
		</tags>
		<lu>   
		  <clip pos="2" side="tl" part="lem"/> 
		  <clip pos="2" side="tl" part="a_adj"/>
		</lu> 
		<b pos="1"/>
		<lu>       
		  <clip pos="1" side="tl" part="lemh"/> 
		  <clip pos="1" side="tl" part="a_nom"/>
		  <clip pos="1" side="tl" part="nbr"/>
		  <clip pos="1" side="tl" part="lemq"/>  
		</lu>
	      </chunk>	       
	      <b pos="2"/>
	      <chunk name="coo_adj">
		<tags>
		  <tag><lit-tag v="SA"/></tag>
		  <tag><clip pos="4" side="sl" part="gen"/></tag>
		  <tag><clip pos="4" side="sl" part="nbr"/></tag>
		</tags>		 
		<lu>
		  <clip pos="3" side="tl" part="whole"/> 
		</lu>
		<b pos="3"/>
		<lu>   
		  <clip pos="4" side="tl" part="lem"/> 
		  <clip pos="4" side="tl" part="a_adj"/>
		</lu>
	      </chunk>
	    </out>	 
	  </otherwise>
	</choose>       */
	// REGLA: DET NOM ADJ conj ADJ NOM (un aspecte fràgil i tímida aparença -> a fragile look and shy appearance. Regla creada perquè no entrin frases que no toquen en la regla següent)
	public void rule17__det__nom__adj_pp__cnjcoo__adj_pp__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule17__det__nom__adj_pp__cnjcoo__adj_pp__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_firstWord(out, word1);
		macro_nombre_nom(out, word2);
		macro_f_superlatiu1(out, word3);
		macro_f_superlatiu2(out, word5);
		macro_canvia_det(out, word1, blank1, word2);
		if ((word5.sl(attr_gen).equals(word6.sl(attr_gen))
    && word5.sl(attr_nbr).equals(word6.sl(attr_nbr))))
		{
			macro_f_concord3(out, word2, " ", word1, blank2, word3);
			macro_f_concord2(out, word6, blank4, word5);
			macro_elimina_ND(out, word6);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_coo_adj_nom"));
			out.append("<SN>");
			out.append(word2.sl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append(var_nombre);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +word1.tl(attr_nbr)
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
				         var_superlatiu1
				         +word3.tl(attr_lem)
				         +word3.tl(attr_a_adj)
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
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +(word2.tl(attr_nbr).isEmpty()?"" : "<3>")
				         +word2.tl(attr_lemq)
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
				         var_superlatiu2
				         +word5.tl(attr_lem)
				         +word5.tl(attr_a_adj)
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
				         word6.tl(attr_lemh)
				         +word6.tl(attr_a_nom)
				         +word6.tl(attr_nbr)
				         +word6.tl(attr_lemq)
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
			macro_f_concord4(out, word2, " ", word1, blank2, word3, blank4, word5);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_coo_adj"));
			out.append("<SN>");
			out.append(word2.sl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +word1.tl(attr_nbr)
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
				         var_superlatiu1
				         +word3.tl(attr_lem)
				         +word3.tl(attr_a_adj)
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
				         var_superlatiu2
				         +word5.tl(attr_lem)
				         +word5.tl(attr_a_adj)
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
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +(word2.tl(attr_nbr).isEmpty()?"" : "<3>")
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
			out.append(blank5);
			out.append("^nom<SN>");
			out.append(word6.sl(attr_gen));
			out.append(word6.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word6.tl(attr_lemh)
				         +word6.tl(attr_a_nom)
				         +(word6.tl(attr_nbr).isEmpty()?"" : "<3>")
				         +word6.tl(attr_lemq)
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
	
	// REGLA: DET NOM ADJ conj ADJ (un aspecte fràgil i tímid -> a fragile and shy look
	public void rule18__det__nom__adj__cnjcoo__adj(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule18__det__nom__adj__cnjcoo__adj",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_nombre_nom(out, word2);
		macro_f_superlatiu1(out, word3);
		macro_f_superlatiu2(out, word5);
		macro_canvia_det(out, word1, blank1, word2);
		macro_f_concord4(out, word2, " ", word1, blank2, word3, blank4, word5);
		/** 	<choose>
	  <when>
	    <test>
	      <and>
		<equal>
		  <clip pos="2" side="sl" part="gen"/>
		  <clip pos="5" side="sl" part="gen"/>
		</equal>
		<equal>
		  <clip pos="2" side="sl" part="nbr"/>
		  <clip pos="5" side="sl" part="nbr"/>
		</equal>
	      </and>		
	    </test>  */
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_coo_adj"));
		out.append("<SN>");
		out.append(word2.sl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +word1.tl(attr_nbr)
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
			         var_superlatiu1
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_adj)
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
			         var_superlatiu2
			         +word5.tl(attr_lem)
			         +word5.tl(attr_a_adj)
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +(word2.tl(attr_nbr).isEmpty()?"" : "<3>")
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
	
	/** 	  </when>
	  <otherwise>	      
	    <out>
	      <chunk name="det_nom_adj" case="caseFirstWord">
		<tags>
		  <tag><lit-tag v="SN"/></tag>
		  <tag><clip pos="2" side="sl" part="gen"/></tag>
		  <tag><var n="nombre"/></tag>
		</tags>
		<lu>   
		  <clip pos="1" side="tl" part="lem"/> 
		  <clip pos="1" side="tl" part="a_det"/>
		  <clip pos="2" side="tl" part="nbr"/>
		</lu>
		<b pos="1"/>
		<lu>   
		  <clip pos="3" side="tl" part="lem"/> 
		  <clip pos="3" side="tl" part="a_adj"/>
		</lu> 
		<b pos="2"/>
		<lu>
		  <clip pos="2" side="tl" part="lemh"/> 
		  <clip pos="2" side="tl" part="a_nom"/>
		  <clip pos="2" side="tl" part="nbr"/>
		  <clip pos="2" side="tl" part="lemq"/>  
		</lu>
	      </chunk>	       
	      <b pos="3"/>
	      <chunk name="coo_adj">
		<tags>
		  <tag><lit-tag v="SA"/></tag>
		  <tag><clip pos="5" side="sl" part="gen"/></tag>
		  <tag><clip pos="5" side="sl" part="nbr"/></tag>
		</tags>
		<lu>
		  <clip pos="4" side="tl" part="whole"/> 
		</lu>
		<b pos="4"/>
		<lu>   
		  <clip pos="5" side="tl" part="lem"/> 
		  <clip pos="5" side="tl" part="a_adj"/>
		</lu> 
	      </chunk>
	    </out>
	  </otherwise>
	</choose>      */
	// REGLA: ADJECTIU (quan no acompanya res o va amb desconeguda)
	public void rule19__adj(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule19__adj",  word1); } 
		macro_firstWord(out, word1);
		macro_f_superlatiu1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adj"));
		out.append("<SA>");
		out.append(word1.sl(attr_gen));
		out.append(word1.sl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         var_superlatiu1
			         +word1.tl(attr_lem)
			         +word1.tl(attr_a_adj)
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
	
	// REGLA: ADV ADJECTIU (per a fer comparatius i superlatius: 'més llarg - longer')
	public void rule20__adv_preadv__adj_pp(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule20__adv_preadv__adj_pp",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		/** 'siempre buenísimo' aquí no envio variable 'superlatiu' perquè s'envia dins de adv_adjectiu  */
		macro_f_superlatiu1(out, word2);
		macro_adv_adj(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv_adj"));
		out.append("<SA>");
		out.append(word2.sl(attr_gen));
		out.append(word2.sl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         var_adv_adjectiu
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
		macro_f_bcond(out, word1, blank1, word2);
	}
	
	// REGLA: DET ADJECTIU (el lleig / el millor) 
	public void rule21__det__adj(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule21__det__adj",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_f_superlatiu1(out, word2);
		macro_el_millor_pitjor(out, word1, blank1, word2);
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			if (!word2.sl(attr_nbr).equals("<sp>"))
			{
				word1.tlSet(attr_nbr, word2.sl(attr_nbr));
			}
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_adj"));
		out.append("<SA>");
		out.append(word2.sl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_nbr).isEmpty()?"" : "<3>")
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
			         var_superlatiu1
			         +word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
		macro_f_bcond(out, word1, blank1, word2);
	}
	
	// REGLA: DET ADV ADJECTIU (per a fer comparatius i superlatius: 'la més gran - the biggest; la més important - the most important')
	public void rule22__det__m_s__adj_pp(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule22__det__m_s__adj_pp",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		if (word2.sl(attr_a_adv).equals(""))
		{
			word2.tlSet(attr_whole, (""+word2.tl(attr_lem)+"<adv>"));
		}
		macro_det_adv_adj(out, word1, blank1, word2, blank2, word3);
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			if (!word3.sl(attr_nbr).equals("<sp>"))
			{
				word1.tlSet(attr_nbr, word3.sl(attr_nbr));
			}
		}
		/** 	<choose>
	  <when>
	    <test>
	      <and>
		<equal caseless="yes">
		  <clip pos="1" side="sl" part="lem"/> 
		  <lit v="más"/>
		</equal>
		<equal>
		  <clip pos="2" side="tl" part="a_adj"/> 
		  <lit-tag v="adj.sint"/>
		</equal>
	      </and>
	    </test>  */
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_adv_adj"));
		out.append("<SA>");
		out.append(word3.sl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_nbr).isEmpty()?"" : "<3>")
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
			         var_adv_adjectiu
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$");
		macro_f_bcond(out, word2, blank2, word3);
	}
	
	// REGLA: DETERMINANT (perquè no doni error si va davant de desconegudes i no es pot assignar nombre. MG: falta regla t2x per al ND)
	public void rule23__det(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule23__det",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det"));
		out.append("<DET>");
		out.append(word1.sl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_nbr).isEmpty()?"" : "<3>")
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
	
	// REGLA: el (num)%
	public void rule24__el__percent(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule24__el__percent",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		out.append("^percent<SN>");
		out.append(word1.sl(attr_gen));
		out.append(word1.sl(attr_nbr));
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
		out.append("}$");
	}
	
	/**  *************************************** REGLES DE SV ***********************************************  */
	// REGLA: HABER
	public void rule25__hay(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule25__hay",  word1); } 
		macro_firstWord(out, word1);
		word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "be"));
		word1.tlSet(attr_a_verb, "<vbser>");
		macro_conj_haverhi(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(word1.tl(attr_a_verb));
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append("{^");
		out.append(TransferWord.copycase(word1.sl(attr_lem), "there"));
		out.append("<adv>$ ");
		{
			String myword = 
			         var_verbfinal
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
	
	// REGLA: HABER QUE
	public void rule26__haber_que(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule26__haber_que",  word1); } 
		macro_firstWord(out, word1);
		/**  envia el pronom subjecte 'it'  */
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prpers"));
		out.append("<SN><subj><p3><nt><sg>{^");
		out.append(TransferWord.copycase(word1.sl(attr_lem), "prpers"));
		out.append("<prn><2><p3><nt><sg>$}$ ");
		var_caseFirstWord = "aa";
		macro_conj_verb1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(word1.tl(attr_a_verb));
		out.append(var_temps_chunk);
		out.append(word1.tl(attr_pers));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         var_verbfinal
			         +word1.tl(attr_lemq)
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
	
	// REGLA: VERB conjugat
	public void rule27__verbcj(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule27__verbcj",  word1); } 
		macro_firstWord(out, word1);
		macro_conj_verb1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(word1.tl(attr_a_verb));
		out.append(var_temps_chunk);
		out.append(word1.tl(attr_pers));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         var_verbfinal
			         +word1.tl(attr_lemq)
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
	
	// HAVER + PP (han vist - have seen)
	public void rule28__haver__pp(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule28__haver__pp",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		if ((word2.sl(attr_lem).equalsIgnoreCase("haber")
    && word1.sl(attr_pers).equals("<p3>")
    && word1.sl(attr_nbr).equals("<sg>")))
		{
			word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "be"));
			word2.tlSet(attr_a_verb, "<vbser>");
			macro_conj_haverhi_pp(out, word1);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append("{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "there"));
			out.append("<adv>$");
			out.append(blank1);
			{
				String myword = 
				         var_verbfinal
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
				         word2.tl(attr_lem)
				         +word2.tl(attr_a_pp)
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
			if (word2.sl(attr_lem).equalsIgnoreCase("poder"))
			{
				word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "be able to"));
				word2.tlSet(attr_a_pp, "<vbmod><pp>");
			}
			macro_conj_verb1(out, word1);
			/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb1'  */
			if ((word1.sl(attr_temps).equals("<cni>")
    || word1.sl(attr_temps).equals("<fti>")))
			{
				var_lema_SV = "aux_haver_pp";
			}
			else
			{
				var_lema_SV = "haver_pp";
			}
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word1.tl(attr_pers));
			out.append(word1.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_verbfinal
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
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_pp)
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
	
	// pro HAVER + PP (l'han vist - have seen it)
	public void rule29__pro__haver__pp(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule29__pro__haver__pp",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		if ((word3.sl(attr_lem).equalsIgnoreCase("haber")
    && word2.sl(attr_pers).equals("<p3>")
    && word2.sl(attr_nbr).equals("<sg>")))
		{
			word3.tlSet(attr_lem, TransferWord.copycase(word3.sl(attr_lem), "be"));
			word3.tlSet(attr_a_verb, "<vbser>");
			macro_conj_haverhi_pp(out, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(word3.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append("{^");
			out.append(TransferWord.copycase(word1.sl(attr_lem), "there"));
			out.append("<adv>$");
			out.append(blank1);
			{
				String myword = 
				         var_verbfinal
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
				         word3.tl(attr_lem)
				         +word3.tl(attr_a_pp)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append("}$ ^pro<SN>");
			out.append(word1.tl(attr_tipus_prn));
			out.append(word1.sl(attr_pers));
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
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
		else
		{
			if (word3.sl(attr_lem).equalsIgnoreCase("poder"))
			{
				word3.tlSet(attr_lem, TransferWord.copycase(word3.sl(attr_lem), "be able to"));
				word3.tlSet(attr_a_pp, "<vbmod><pp>");
			}
			macro_conj_verb1(out, word2);
			if ((word3.tl(attr_sep).equals("<sep>")
    && !word3.sl(attr_pron).equals("<pron>")))
			{
				/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb1'  */
				if ((word2.sl(attr_temps).equals("<cni>")
    || word2.sl(attr_temps).equals("<fti>")))
				{
					var_lema_SV = "aux_haver_pp_enc";
				}
				else
				{
					var_lema_SV = "haver_pp_enc";
				}
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
				out.append("<SV>");
				out.append(word3.tl(attr_a_verb));
				out.append(var_temps_chunk);
				out.append(word2.tl(attr_pers));
				out.append(word2.tl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         var_verbfinal
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
				out.append(word3.tl(attr_lemh));
				out.append(word3.tl(attr_a_pp));
				out.append('+');
				out.append(word1.tl(attr_lem));
				out.append(word1.tl(attr_a_prn));
				out.append(word1.tl(attr_tipus_prn));
				out.append(word1.tl(attr_pers));
				out.append(word1.tl(attr_gen));
				out.append(word1.tl(attr_nbr));
				out.append(word3.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb1'  */
				if ((word2.sl(attr_temps).equals("<cni>")
    || word2.sl(attr_temps).equals("<fti>")))
				{
					var_lema_SV = "aux_haver_pp";
				}
				else
				{
					var_lema_SV = "haver_pp";
				}
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
				out.append("<SV>");
				out.append(word3.tl(attr_a_verb));
				out.append(var_temps_chunk);
				out.append(word2.tl(attr_pers));
				out.append(word2.tl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         var_verbfinal
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
					         word3.tl(attr_lemh)
					         +word3.tl(attr_a_pp)
					         +word3.tl(attr_lemq)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append("}$");
				/**  ... i després enviem el prn (si cal) */
				if ((word3.sl(attr_pron).equals("<pron>")
    && word1.sl(attr_pers).equals(word2.sl(attr_pers))
    && (word1.sl(attr_nbr).equals(word2.sl(attr_nbr))
    || word1.sl(attr_lem).equalsIgnoreCase("se"))))
				{
					/** imprimeix el blanc si té info de format, el pronom no l'imprimeixis  */
					macro_f_bcond(out, word2, blank2, word3);
				}
				else
				{
					if (word1.sl(attr_lem).equalsIgnoreCase("se"))
					{
						var_lema = "ref";
						var_nom_chunk = "<ref>";
					}
					else
					{
						var_lema = "pro";
						var_nom_chunk = "<SN>";
					}
					out.append(blank2);
					out.append('^');
					out.append(var_lema);
					out.append(var_nom_chunk);
					out.append(word1.tl(attr_tipus_prn));
					out.append(word1.sl(attr_pers));
					out.append(word1.tl(attr_gen));
					out.append(word1.tl(attr_nbr));
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
			}
		}
	}
	
	// pro + pro + HAVER + PP (se lo han dado - have given it to him)
	public void rule30__pro__pro__haver__pp(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule30__pro__pro__haver__pp",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		if (word4.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word4.tlSet(attr_lem, TransferWord.copycase(word4.sl(attr_lem), "be able to"));
			word4.tlSet(attr_a_pp, "<vbmod><pp>");
		}
		macro_conj_verb1(out, word3);
		/**  aquí s'ha de mirar la separabilitat */
		if (word4.tl(attr_sep).equals("<sep>"))
		{
			/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb1'  */
			if ((word3.sl(attr_temps).equals("<cni>")
    || word3.sl(attr_temps).equals("<fti>")))
			{
				var_lema_SV = "aux_haver_pp_enc";
			}
			else
			{
				var_lema_SV = "haver_pp_enc";
			}
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(word4.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word3.tl(attr_pers));
			out.append(word3.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_verbfinal
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
			out.append(word4.tl(attr_lemh));
			out.append(word4.tl(attr_a_pp));
			out.append('+');
			out.append(word2.tl(attr_lem));
			out.append(word2.tl(attr_a_prn));
			out.append(word2.tl(attr_tipus_prn));
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
			macro_f_bcond(out, word2, blank2, word3);
		}
		else
		{
			/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb1'  */
			if ((word3.sl(attr_temps).equals("<cni>")
    || word3.sl(attr_temps).equals("<fti>")))
			{
				var_lema_SV = "aux_haver_pp";
			}
			else
			{
				var_lema_SV = "haver_pp";
			}
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(word4.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word3.tl(attr_pers));
			out.append(word3.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_verbfinal
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
				         word4.tl(attr_lemh)
				         +word4.tl(attr_a_pp)
				         +word4.tl(attr_lemq)
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
			out.append("^pro<SN>");
			out.append(word2.tl(attr_tipus_prn));
			out.append(word2.sl(attr_pers));
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
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
			out.append("}$");
		}
		/** ara ens cuidem del primer pronom  */
		if (!((word4.sl(attr_pron).equals("<pron>")
    && word1.sl(attr_pers).equals(word3.sl(attr_pers))
    && (word1.sl(attr_nbr).equals(word3.sl(attr_nbr))
    || word1.sl(attr_lem).equalsIgnoreCase("se")))
    || word1.tl(attr_whole).equals("")))
		{
			out.append("^to_prn<SP>");
			out.append(word1.tl(attr_tipus_prn));
			out.append(word1.tl(attr_pers));
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append('{');
			out.append(blank3);
			out.append('^');
			out.append(TransferWord.copycase(word2.sl(attr_lem), "to"));
			out.append("<pr>$ ");
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
		else
		if ((!word4.sl(attr_pron).equals("<pron>")
    && word1.sl(attr_lem).equalsIgnoreCase("se")))
		{
			out.append(blank3);
			out.append("^ref<ref>");
			out.append(word1.tl(attr_tipus_prn));
			out.append(word1.sl(attr_pers));
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
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
		else
		{
			macro_f_bcond(out, word3, blank3, word4);
		}
	}
	
	// REGLA: PROCLÍTIC HAY
	public void rule31__pro_noref__hay(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule31__pro_noref__hay",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "be"));
		word2.tlSet(attr_a_verb, "<vbser>");
		macro_conj_haverhi(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(word2.tl(attr_a_verb));
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append("{^");
		out.append(TransferWord.copycase(word1.sl(attr_lem), "there"));
		out.append("<adv>$");
		out.append(blank1);
		{
			String myword = 
			         var_verbfinal
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$ ^pro<SN>");
		out.append(word1.tl(attr_tipus_prn));
		out.append(word1.sl(attr_pers));
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
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
	
	// REGLA: PROCLÍTIC VERB conjugat
	public void rule32__pro__verbcj(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule32__pro__verbcj",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		if ((word2.tl(attr_sep).equals("<sep>")
    && !word2.sl(attr_pron).equals("<pron>")))
		{
			macro_conj_verb1(out, word2);
			var_lema_SV = var_lema_SV
			    +"_enc"
			    ;
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_nbr));
			out.append("{^");
			out.append(var_verbfinal);
			out.append('+');
			out.append(word1.tl(attr_lem));
			out.append(word1.tl(attr_a_prn));
			out.append(word1.tl(attr_tipus_prn));
			out.append(word1.tl(attr_pers));
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append(word2.tl(attr_lemq));
			out.append("$}$");
			/**  si cal, enviem els blancs  */
			macro_f_bcond(out, word1, blank1, word2);
		}
		else
		{
			macro_conj_verb1(out, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_verbfinal
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
			/** després d'imprimir el verb, mirem el proclític  */
			if ((word2.sl(attr_pron).equals("<pron>")
    && word1.sl(attr_pers).equals(word2.sl(attr_pers))
    && (word1.sl(attr_nbr).equals(word2.sl(attr_nbr))
    || word1.sl(attr_lem).equalsIgnoreCase("se"))))
			{
				/** imprimeix el blanc si té info de format, el pronom no l'imprimeixis  */
				macro_f_bcond(out, word1, blank1, word2);
			}
			else
			{
				if (word1.sl(attr_lem).equalsIgnoreCase("se"))
				{
					var_lema = "ref";
					var_nom_chunk = "<ref>";
				}
				else
				{
					var_lema = "pro";
					var_nom_chunk = "<SN>";
				}
				out.append(blank1);
				out.append('^');
				out.append(var_lema);
				out.append(var_nom_chunk);
				out.append(word1.tl(attr_tipus_prn));
				out.append(word1.sl(attr_pers));
				out.append(word1.tl(attr_gen));
				out.append(word1.tl(attr_nbr));
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
		}
	}
	
	// REGLA: PROCL + PROCL + VERB conjugat (se lo digo)
	public void rule33__pro__pro__verbcj(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule33__pro__pro__verbcj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_conj_verb1(out, word3);
		if (word3.tl(attr_sep).equals("<sep>"))
		{
			var_lema_SV = var_lema_SV
			    +"_enc"
			    ;
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(word3.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word3.tl(attr_pers));
			out.append(word3.tl(attr_nbr));
			out.append("{^");
			out.append(var_verbfinal);
			out.append('+');
			out.append(word2.tl(attr_lem));
			out.append(word2.tl(attr_a_prn));
			out.append(word2.tl(attr_tipus_prn));
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
			/**  si cal, enviem el blanc  */
			macro_f_bcond(out, word1, blank1, word2);
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(word3.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word3.tl(attr_pers));
			out.append(word3.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_verbfinal
				         +word3.tl(attr_lemq)
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
			out.append("^pro<SN>");
			out.append(word2.tl(attr_tipus_prn));
			out.append(word2.sl(attr_pers));
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
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
			out.append("}$");
		}
		/** ara mirem el primer pronom  */
		if (!((word3.sl(attr_pron).equals("<pron>")
    && word1.sl(attr_pers).equals(word3.sl(attr_pers))
    && (word1.sl(attr_nbr).equals(word3.sl(attr_nbr))
    || word1.sl(attr_lem).equalsIgnoreCase("se")))
    || word1.tl(attr_whole).equals("")))
		{
			/** imprimeix 'to + prn'  */
			out.append("^to_prn<SP>");
			out.append(word1.tl(attr_tipus_prn));
			out.append(word1.tl(attr_pers));
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append('{');
			out.append(blank2);
			out.append('^');
			out.append(TransferWord.copycase(word2.sl(attr_lem), "to"));
			out.append("<pr>$ ");
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
		else
		{
			if ((!word3.sl(attr_pron).equals("<pron>")
    && word1.sl(attr_lem).equalsIgnoreCase("se")))
			{
				out.append(blank2);
				out.append("^ref<ref>");
				out.append(word1.tl(attr_tipus_prn));
				out.append(word1.sl(attr_pers));
				out.append(word1.tl(attr_gen));
				out.append(word1.tl(attr_nbr));
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
			else
			{
				macro_f_bcond(out, word2, blank2, word3);
			}
		}
	}
	
	// VERB + ENCL (ajudar-me - help me)
	public void rule34__verbnm_inf_ger__enc(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule34__verbnm_inf_ger__enc",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		if (word1.tl(attr_sep).equals("<sep>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb_enc"));
			out.append("<SV>");
			out.append(word1.tl(attr_a_verb));
			out.append(word1.tl(attr_temps));
			out.append("{^");
			out.append(word1.tl(attr_lemh));
			out.append(word1.tl(attr_a_verb));
			out.append(word1.tl(attr_sep));
			out.append((word1.tl(attr_temps).isEmpty()?"" : "<3>"));
			out.append('+');
			out.append(word2.tl(attr_lem));
			out.append(word2.tl(attr_a_prn));
			out.append(word2.tl(attr_tipus_prn));
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append(word1.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verb_enc"));
			out.append("<SV>");
			out.append(word1.tl(attr_a_verb));
			out.append(word1.sl(attr_temps));
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_verb)
				         +word1.tl(attr_sep)
				         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
				         +word1.tl(attr_lemq)
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
		}
	}
	
	// VERB + ENCL (ajuda'm - help me)
	public void rule35__verbnm_imp__enc(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule35__verbnm_imp__enc",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		word1.tlSet(attr_temps, "<inf>");
		if ((word1.sl(attr_pron).equals("<pron>")
    && word1.sl(attr_pers).equals(word2.sl(attr_pers))
    && (word1.sl(attr_nbr).equals(word2.sl(attr_nbr))
    || word2.sl(attr_lem).equalsIgnoreCase("se"))))
		{
			word2.tlSet(attr_whole, "");
		}
		if (word1.tl(attr_sep).equals("<sep>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "imp_enc"));
			out.append("<SV>");
			out.append(word1.tl(attr_a_verb));
			out.append(word1.sl(attr_temps));
			out.append(word1.sl(attr_pers));
			out.append(word1.sl(attr_nbr));
			out.append("{^");
			out.append(word1.tl(attr_lemh));
			out.append(word1.tl(attr_a_verb));
			out.append(word1.tl(attr_sep));
			out.append(word1.tl(attr_temps));
			out.append('+');
			out.append(word2.tl(attr_lem));
			out.append(word2.tl(attr_a_prn));
			out.append(word2.tl(attr_tipus_prn));
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append(word1.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "imp_enc"));
			out.append("<SV>");
			out.append(word1.tl(attr_a_verb));
			out.append(word1.sl(attr_temps));
			out.append(word1.sl(attr_pers));
			out.append(word1.sl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_verb)
				         +word1.tl(attr_sep)
				         +word1.tl(attr_temps)
				         +word1.tl(attr_lemq)
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
		}
	}
	
	// VERB + ENCL + ENCL (portar-me'ls - bring them to me)
	public void rule36__verbnm_inf_ger__enc__enc(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule36__verbnm_inf_ger__enc__enc",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		if (word3.tl(attr_whole).equals(""))
		{
			if (word1.tl(attr_sep).equals("<sep>"))
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "verb_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.tl(attr_temps));
				out.append("{^");
				out.append(word1.tl(attr_lemh));
				out.append(word1.tl(attr_a_verb));
				out.append(word1.tl(attr_sep));
				out.append((word1.tl(attr_temps).isEmpty()?"" : "<3>"));
				out.append('+');
				out.append(word2.tl(attr_lem));
				out.append(word2.tl(attr_a_prn));
				out.append(word2.tl(attr_tipus_prn));
				out.append(word2.tl(attr_pers));
				out.append(word2.tl(attr_gen));
				out.append(word2.tl(attr_nbr));
				out.append(word1.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "verb_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.sl(attr_temps));
				out.append('{');
				{
					String myword = 
					         word1.tl(attr_lemh)
					         +word1.tl(attr_a_verb)
					         +word1.tl(attr_sep)
					         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word1.tl(attr_lemq)
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
			}
		}
		else
		{
			if (word1.tl(attr_sep).equals("<sep>"))
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "verb_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.tl(attr_temps));
				out.append("{^");
				out.append(word1.tl(attr_lemh));
				out.append(word1.tl(attr_a_verb));
				out.append(word1.tl(attr_sep));
				out.append((word1.tl(attr_temps).isEmpty()?"" : "<3>"));
				out.append('+');
				out.append(word3.tl(attr_lem));
				out.append(word3.tl(attr_a_prn));
				out.append(word3.tl(attr_tipus_prn));
				out.append(word3.tl(attr_pers));
				out.append(word3.tl(attr_gen));
				out.append(word3.tl(attr_nbr));
				out.append(word1.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "verb_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.sl(attr_temps));
				out.append('{');
				{
					String myword = 
					         word1.tl(attr_lemh)
					         +word1.tl(attr_a_verb)
					         +word1.tl(attr_sep)
					         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word1.tl(attr_lemq)
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
			if (!word2.tl(attr_whole).equals(""))
			{
				out.append(" ^to_prn<SP>");
				out.append(word2.tl(attr_tipus_prn));
				out.append(word2.tl(attr_pers));
				out.append(word2.tl(attr_gen));
				out.append(word2.tl(attr_nbr));
				out.append("{^");
				out.append(TransferWord.copycase(word2.sl(attr_lem), "to"));
				out.append("<pr>$ ");
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
			}
		}
	}
	
	// VERB + ENCL + ENCL (porta-me'ls - bring them to me)
	public void rule37__verbnm_imp__enc__enc(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule37__verbnm_imp__enc__enc",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		word1.tlSet(attr_temps, "<inf>");
		if ((word1.sl(attr_pron).equals("<pron>")
    && word1.sl(attr_pers).equals(word2.sl(attr_pers))
    && (word1.sl(attr_nbr).equals(word2.sl(attr_nbr))
    || word2.sl(attr_lem).equalsIgnoreCase("se"))))
		{
			word2.tlSet(attr_whole, "");
		}
		if (word3.tl(attr_whole).equals(""))
		{
			if (word1.tl(attr_sep).equals("<sep>"))
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "imp_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.sl(attr_temps));
				out.append(word1.sl(attr_pers));
				out.append(word1.sl(attr_nbr));
				out.append("{^");
				out.append(word1.tl(attr_lemh));
				out.append(word1.tl(attr_a_verb));
				out.append(word1.tl(attr_sep));
				out.append(word1.tl(attr_temps));
				out.append('+');
				out.append(word2.tl(attr_lem));
				out.append(word2.tl(attr_a_prn));
				out.append(word2.tl(attr_tipus_prn));
				out.append(word2.tl(attr_pers));
				out.append(word2.tl(attr_gen));
				out.append(word2.tl(attr_nbr));
				out.append(word1.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "imp_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.sl(attr_temps));
				out.append(word1.sl(attr_pers));
				out.append(word1.sl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         word1.tl(attr_lemh)
					         +word1.tl(attr_a_verb)
					         +word1.tl(attr_sep)
					         +word1.tl(attr_temps)
					         +word1.tl(attr_lemq)
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
			}
		}
		else
		{
			if (word1.tl(attr_sep).equals("<sep>"))
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "imp_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.sl(attr_temps));
				out.append(word1.sl(attr_pers));
				out.append(word1.sl(attr_nbr));
				out.append("{^");
				out.append(word1.tl(attr_lemh));
				out.append(word1.tl(attr_a_verb));
				out.append(word1.tl(attr_sep));
				out.append(word1.tl(attr_temps));
				out.append('+');
				out.append(word3.tl(attr_lem));
				out.append(word3.tl(attr_a_prn));
				out.append(word3.tl(attr_tipus_prn));
				out.append(word3.tl(attr_pers));
				out.append(word3.tl(attr_gen));
				out.append(word3.tl(attr_nbr));
				out.append(word1.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "imp_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.sl(attr_temps));
				out.append(word1.sl(attr_pers));
				out.append(word1.sl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         word1.tl(attr_lemh)
					         +word1.tl(attr_a_verb)
					         +word1.tl(attr_sep)
					         +word1.tl(attr_temps)
					         +word1.tl(attr_lemq)
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
			if (!word2.tl(attr_whole).equals(""))
			{
				out.append(" ^to_prn<SP>");
				out.append(word2.tl(attr_tipus_prn));
				out.append(word2.tl(attr_pers));
				out.append(word2.tl(attr_gen));
				out.append(word2.tl(attr_nbr));
				out.append("{^");
				out.append(TransferWord.copycase(word2.sl(attr_lem), "to"));
				out.append("<pr>$ ");
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
			}
		}
	}
	
	/**  aquí tb separaria entre inf/ger i imperatiu, per poder fer enllaços coherents en 'temps' i poder deixar temps 'sl' en imperatiu i 'tl' en inf i ger. */
	// VERBMOD + ENCL + INF (poder-ho fer - be able to do it)(no he fet res per a pronominals, difícil fer la concordança de persona en frases que no són de 3a persona ('es'): per poder-te enamorar...
	public void rule38__verbm__enc__inf(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule38__verbm__enc__inf",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_temps).equals("<imp>"))
		{
			word1.tlSet(attr_temps, "<inf>");
		}
		if (word1.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "be able to"));
			word1.tlSet(attr_a_verb, "<vbmod>");
		}
		if (word3.tl(attr_sep).equals("<sep>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "mod_inf_enc"));
			out.append("<SV>");
			out.append(word1.tl(attr_a_verb));
			out.append(word1.tl(attr_temps));
			out.append(word1.sl(attr_pers));
			out.append(word1.sl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_verb)
				         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
				         +word1.tl(attr_lemq)
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
			out.append(word3.tl(attr_a_verb));
			out.append(word3.tl(attr_sep));
			out.append(word3.tl(attr_temps));
			out.append('+');
			out.append(word2.tl(attr_lem));
			out.append(word2.tl(attr_a_prn));
			out.append(word2.tl(attr_tipus_prn));
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "mod_inf_enc"));
			out.append("<SV>");
			out.append(word1.tl(attr_a_verb));
			out.append(word1.tl(attr_temps));
			out.append(word1.sl(attr_pers));
			out.append(word1.sl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_verb)
				         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
				         +word1.tl(attr_lemq)
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
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_verb)
				         +word3.tl(attr_sep)
				         +word3.tl(attr_temps)
				         +word3.tl(attr_lemq)
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
		}
	}
	
	// VERBMOD + ENCL + ENCL + INF (poder-los-ho explicar -> be able to explain it to them)
	public void rule39__verbm__enc__enc__inf(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule39__verbm__enc__enc__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_temps).equals("<imp>"))
		{
			word1.tlSet(attr_temps, "<inf>");
		}
		if (word1.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "be able to"));
			word1.tlSet(attr_a_verb, "<vbmod>");
		}
		if (word3.tl(attr_whole).equals(""))
		{
			if (word4.tl(attr_sep).equals("<sep>"))
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "mod_inf_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.tl(attr_temps));
				out.append(word1.sl(attr_pers));
				out.append(word1.sl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         word1.tl(attr_lemh)
					         +word1.tl(attr_a_verb)
					         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word1.tl(attr_lemq)
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
				out.append(word4.tl(attr_a_verb));
				out.append(word4.tl(attr_sep));
				out.append(word4.tl(attr_temps));
				out.append('+');
				out.append(word2.tl(attr_lem));
				out.append(word2.tl(attr_a_prn));
				out.append(word2.tl(attr_tipus_prn));
				out.append(word2.tl(attr_pers));
				out.append(word2.tl(attr_gen));
				out.append(word2.tl(attr_nbr));
				out.append(word4.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "mod_inf_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.tl(attr_temps));
				out.append(word1.sl(attr_pers));
				out.append(word1.sl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         word1.tl(attr_lemh)
					         +word1.tl(attr_a_verb)
					         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word1.tl(attr_lemq)
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
					         word4.tl(attr_lemh)
					         +word4.tl(attr_a_verb)
					         +word4.tl(attr_sep)
					         +word4.tl(attr_temps)
					         +word4.tl(attr_lemq)
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
			}
		}
		else
		{
			if (word4.tl(attr_sep).equals("<sep>"))
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "mod_inf_enc_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.tl(attr_temps));
				out.append(word1.sl(attr_pers));
				out.append(word1.sl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         word1.tl(attr_lemh)
					         +word1.tl(attr_a_verb)
					         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word1.tl(attr_lemq)
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
				out.append(word4.tl(attr_a_verb));
				out.append(word4.tl(attr_sep));
				out.append(word4.tl(attr_temps));
				out.append('+');
				out.append(word3.tl(attr_lem));
				out.append(word3.tl(attr_a_prn));
				out.append(word3.tl(attr_tipus_prn));
				out.append(word3.tl(attr_pers));
				out.append(word3.tl(attr_gen));
				out.append(word3.tl(attr_nbr));
				out.append(word4.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "mod_inf_enc_enc"));
				out.append("<SV>");
				out.append(word1.tl(attr_a_verb));
				out.append(word1.tl(attr_temps));
				out.append(word1.sl(attr_pers));
				out.append(word1.sl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         word1.tl(attr_lemh)
					         +word1.tl(attr_a_verb)
					         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word1.tl(attr_lemq)
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
					         word4.tl(attr_lemh)
					         +word4.tl(attr_a_verb)
					         +word4.tl(attr_temps)
					         +word4.tl(attr_lemq)
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
			if (!word2.tl(attr_whole).equals(""))
			{
				out.append(" ^to_prn<SP>");
				out.append(word2.tl(attr_tipus_prn));
				out.append(word2.tl(attr_pers));
				out.append(word2.tl(attr_gen));
				out.append(word2.tl(attr_nbr));
				out.append("{^");
				out.append(TransferWord.copycase(word2.sl(attr_lem), "to"));
				out.append("<pr>$ ");
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
			}
		}
	}
	
	// REGLA: procl + verb modal + inf (em pot sorprendre -> can surprise me)
	public void rule40__pro__verbm__inf(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule40__pro__verbm__inf",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_conj_verb1(out, word2);
		if ((word3.tl(attr_sep).equals("<sep>")
    && !word3.sl(attr_pron).equals("<pron>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "mod_inf_enc"));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word2.sl(attr_pers));
			out.append(word2.sl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_verbfinal
				         +word2.tl(attr_lemq)
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
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append(word3.tl(attr_sep));
			out.append(word3.tl(attr_temps));
			out.append('+');
			out.append(word1.tl(attr_lem));
			out.append(word1.tl(attr_a_prn));
			out.append(word1.tl(attr_tipus_prn));
			out.append(word1.tl(attr_pers));
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
			macro_f_bcond(out, word2, blank2, word3);
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "mod_inf"));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word2.sl(attr_pers));
			out.append(word2.sl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_verbfinal
				         +word2.tl(attr_lemq)
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
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_verb)
				         +word3.tl(attr_sep)
				         +word3.tl(attr_temps)
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append("}$");
			/** després d'imprimir el verb, mirem el proclític  */
			if ((word3.sl(attr_pron).equals("<pron>")
    && word1.sl(attr_pers).equals(word2.sl(attr_pers))
    && (word1.sl(attr_nbr).equals(word2.sl(attr_nbr))
    || word1.sl(attr_lem).equalsIgnoreCase("se"))))
			{
				/** imprimeix el blanc si té info de format, el pronom no l'imprimeixis  */
				macro_f_bcond(out, word2, blank2, word3);
			}
			else
			{
				if (word1.sl(attr_lem).equalsIgnoreCase("se"))
				{
					var_lema = "ref";
					var_nom_chunk = "<ref>";
				}
				else
				{
					var_lema = "pro";
					var_nom_chunk = "<SN>";
				}
				out.append(blank2);
				out.append('^');
				out.append(var_lema);
				out.append(var_nom_chunk);
				out.append(word1.tl(attr_tipus_prn));
				out.append(word1.sl(attr_pers));
				out.append(word1.tl(attr_gen));
				out.append(word1.tl(attr_nbr));
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
		}
	}
	
	// VERBMOD + ENCL (per quan va davant desconegudes, perquè almenys no peti: poder-ho xxx - be able to it xxx)
	public void rule41__verbm__enc(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule41__verbm__enc",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_temps).equals("<imp>"))
		{
			word1.tlSet(attr_temps, "<inf>");
		}
		if (word1.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "be able to"));
			word1.tlSet(attr_a_verb, "<vbmod>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "mod_enc_x"));
		out.append("<SV>");
		out.append(word1.tl(attr_a_verb));
		out.append(word1.tl(attr_temps));
		out.append(word1.sl(attr_pers));
		out.append(word1.sl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_verb)
			         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
			         +word1.tl(attr_lemq)
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
	}
	
	// VERBMOD + ENCL + ENCL (per quan va davant desconegudes, perquè almenys no peti: poder-los-ho xxx - be able to them it xxx
	public void rule42__verbm__enc__enc(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule42__verbm__enc__enc",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_temps).equals("<imp>"))
		{
			word1.tlSet(attr_temps, "<inf>");
		}
		if (word1.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "be able to"));
			word1.tlSet(attr_a_verb, "<vbmod>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "mod_enc_enc_x"));
		out.append("<SV>");
		out.append(word1.tl(attr_a_verb));
		out.append(word1.tl(attr_temps));
		out.append(word1.sl(attr_pers));
		out.append(word1.sl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_verb)
			         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
			         +word1.tl(attr_lemq)
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
			         word2.tl(attr_whole)
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
	
	// REGLA: PARTICIPI (perquè no enviï gènere ni nombre quan va sol (per tal que no doni error). Caldrà posar-lo tb en les regles d'adjectiu
	public void rule43__pp(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule43__pp",  word1); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "be able to"));
			word1.tlSet(attr_a_pp, "<vbmod><pp>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pp"));
		out.append("<SA>");
		out.append(word1.sl(attr_gen));
		out.append(word1.sl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_pp)
			         +word1.tl(attr_lemq)
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
	
	// PER + INF (per ajudar - to help (en general; cal estudiar quan hi va gerundi)
	public void rule44__prep__inf(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule44__prep__inf",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_prep_inf(out, word1, blank1, word2);
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
		out.append(blank1);
		out.append('^');
		out.append(var_tempsv);
		out.append("<SV>");
		out.append(word2.tl(attr_a_verb));
		out.append(word2.tl(attr_temps));
		out.append('{');
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +word2.tl(attr_sep)
			         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
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
	
	// PREP + HAVER + PP (per haver ajudat)
	public void rule45__prep__haverinf__pp(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule45__prep__haverinf__pp",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_prep_inf(out, word1, blank1, word2);
		word2.tlSet(attr_temps, "<ger>");
		if (word3.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word3.tlSet(attr_lem, TransferWord.copycase(word3.sl(attr_lem), "be able to"));
			word3.tlSet(attr_a_pp, "<vbmod><pp>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "por_haver_pp"));
		out.append("<SV>");
		out.append(word2.tl(attr_a_verb));
		out.append(word2.tl(attr_temps));
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +word2.tl(attr_temps)
			         +word2.tl(attr_lemq)
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
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_pp)
			         +word3.tl(attr_lemq)
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
	
	// AL + INF (al llegar - when arriving)
	public void rule46__a__el__inf(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule46__a__el__inf",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		word3.tlSet(attr_temps, "<ger>");
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "cnj"));
		out.append("<cnjadv>{^");
		out.append(TransferWord.copycase(word1.sl(attr_lem), "when"));
		out.append("<cnjadv>$}$");
		out.append(blank2);
		out.append("^ger<SV>");
		out.append(word3.tl(attr_a_verb));
		out.append(word3.tl(attr_temps));
		out.append('{');
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_verb)
			         +word3.tl(attr_sep)
			         +(word3.tl(attr_temps).isEmpty()?"" : "<3>")
			         +word3.tl(attr_lemq)
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
	
	/**  <rule comment="REGLA: PARTICIPI + per (canvia 'for' per 'by' ja que es considera que generalment serà passiva.">
      <pattern>
	<pattern-item n="pp"/>
	<pattern-item n="por"/>
      </pattern>
      <action>       	
	<call-macro n="firstWord">
	  <with-param pos="1"/>
	</call-macro>
	<let>
	  <clip pos="2" side="tl" part="lem"/> 
	  <lit v="by"/>
	</let>	  
	<choose>
	  <when>
	    <test>
	      <equal>
		<clip pos="1" side="sl" part="lem"/> 
		<lit v="poder"/>
	      </equal>
	    </test>
	    <let>
	      <clip pos="1" side="tl" part="lem"/> 
	      <lit v="be able to"/>
	    </let>
	    <let>
	      <clip pos="1" side="tl" part="a_pp"/> 
	      <lit-tag v="vbmod.pp"/>
	    </let>
	  </when>
	</choose>
	<out>
	  <chunk name="pp" case="caseFirstWord">
	    <tags>
	      <tag><lit-tag v="SA"/></tag>
	      <tag><clip pos="1" side="sl" part="gen"/></tag>
	      <tag><clip pos="1" side="sl" part="nbr"/></tag>
	    </tags> 	
	    <lu>
	      <clip pos="1" side="tl" part="lemh"/> 
	      <clip pos="1" side="tl" part="a_pp"/>
	      <clip pos="1" side="tl" part="lemq"/>    
	    </lu>
	  </chunk>
	  <b pos="1"/>
	  <chunk name="pr">
	    <tags>
	      <tag><lit-tag v="PREP"/></tag>
	    </tags>
	    <lu>
	      <clip pos="2" side="tl" part="whole"/>
	    </lu>
	  </chunk>
	</out> 
      </action>
    </rule>  */
	// PP + PER + INF (preparat per ajudar - prepared to help (perquè no entri per la regla anterior i digui 'prepared by')
	public void rule47__pp__prep__inf(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule47__pp__prep__inf",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		/** -MG: en aquest cas, el 'de' potser hauria de traduir-se per 'of'?  */
		macro_prep_inf(out, word2, blank2, word3);
		if (word1.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "be able to"));
			word1.tlSet(attr_a_pp, "<vbmod><pp>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pp_pr_inf"));
		out.append("<SA>");
		out.append(word1.sl(attr_gen));
		out.append(word1.sl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_pp)
			         +word1.tl(attr_lemq)
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
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_verb)
			         +word3.tl(attr_sep)
			         +word3.tl(attr_temps)
			         +word3.tl(attr_lemq)
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
	
	// REGLA: VERB no conjugat (perquè posi bé la cua en multiparaules)
	public void rule48__inf(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule48__inf",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "inf"));
		out.append("<SV>");
		out.append(word1.tl(attr_a_verb));
		out.append(word1.tl(attr_temps));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_verb)
			         +word1.tl(attr_sep)
			         +(word1.tl(attr_temps).isEmpty()?"" : "<3>")
			         +word1.tl(attr_lemq)
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
	
	// REGLA: VERB no conjugat (perquè posi bé la cua en multiparaules)
	public void rule49__ger(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule49__ger",  word1); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_lemh).equalsIgnoreCase("poder"))
		{
			word1.tlSet(attr_lemh, TransferWord.copycase(word1.sl(attr_lem), "be able to"));
			word1.tlSet(attr_a_verb, "<vbmod>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "ger"));
		out.append("<SV>");
		out.append(word1.tl(attr_a_verb));
		out.append(word1.sl(attr_temps));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_verb)
			         +word1.tl(attr_sep)
			         +word1.tl(attr_temps)
			         +word1.tl(attr_lemq)
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
	
	// REGLA: ESTAR + GER (estan estudiant)
	public void rule50__estar__ger(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule50__estar__ger",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_conj_verb1(out, word1);
		var_lema_SV = var_lema_SV
		    +"_ger"
		    ;
		if (word2.sl(attr_lemh).equalsIgnoreCase("poder"))
		{
			word2.tlSet(attr_lemh, TransferWord.copycase(word2.sl(attr_lem), "be able to"));
			word2.tlSet(attr_a_verb, "<vbmod>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(word1.tl(attr_a_verb));
		out.append(var_temps_chunk);
		out.append(word1.tl(attr_pers));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         var_verbfinal
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +word2.tl(attr_sep)
			         +word2.tl(attr_temps)
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
	
	// REGLA: PROCLÍTIC ESTAR GER (els estan buscant) mireia falta els negatius i amb dos proclítics
	public void rule51__pro__estar__ger(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule51__pro__estar__ger",  word1, blank1,  word2, blank2,  word3); } 
		macro_conj_verb1(out, word2);
		var_lema_SV = var_lema_SV
		    +"_ger"
		    ;
		if ((word3.tl(attr_sep).equals("<sep>")
    && !word3.sl(attr_pron).equals("<pron>")))
		{
			var_lema_SV = var_lema_SV
			    +"_enc"
			    ;
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_verbfinal
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
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append(word3.tl(attr_sep));
			out.append(word3.tl(attr_temps));
			out.append('+');
			out.append(word1.tl(attr_lem));
			out.append(word1.tl(attr_a_prn));
			out.append(word1.tl(attr_tipus_prn));
			out.append(word1.tl(attr_pers));
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
			/**  si cal, enviem els blancs  */
			macro_f_bcond(out, word2, blank2, word3);
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_verbfinal
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
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_verb)
				         +word3.tl(attr_sep)
				         +word3.tl(attr_temps)
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append("}$");
			/** després d'imprimir el verb, mirem el proclític  */
			if ((word3.sl(attr_pron).equals("<pron>")
    && word1.sl(attr_pers).equals(word2.sl(attr_pers))
    && (word1.sl(attr_nbr).equals(word2.sl(attr_nbr))
    || word1.sl(attr_lem).equalsIgnoreCase("se"))))
			{
				/** imprimeix el blanc si té info de format, el pronom no l'imprimeixis  */
				macro_f_bcond(out, word2, blank2, word3);
			}
			else
			{
				if (word1.sl(attr_lem).equalsIgnoreCase("se"))
				{
					var_lema = "ref";
					var_nom_chunk = "<ref>";
				}
				else
				{
					var_lema = "pro";
					var_nom_chunk = "<SN>";
				}
				out.append(blank2);
				out.append('^');
				out.append(var_lema);
				out.append(var_nom_chunk);
				out.append(word1.tl(attr_tipus_prn));
				out.append(word1.sl(attr_pers));
				out.append(word1.tl(attr_gen));
				out.append(word1.tl(attr_nbr));
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
		}
	}
	
	/** **************************** SV precedits d'adverbi (negacions i altres)  */
	// REGLA: ADV HAY (no había)
	public void rule52__adv__hay(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule52__adv__hay",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_lem).equalsIgnoreCase("no"))
		{
			var_SVnegatiu = "<SVneg>";
			macro_f_bcond(out, word1, blank1, word2);
			var_caseSecondWord = var_caseFirstWord;
		}
		else
		{
			var_SVnegatiu = "<SV>";
			var_caseSecondWord = TransferWord.caseOf(word2.sl(attr_lem));
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
			out.append(word1.tl(attr_a_adv));
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
			out.append(blank1);
		}
		word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "be"));
		word2.tlSet(attr_a_verb, "<vbser>");
		macro_conj_haverhi(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseSecondWord, var_lema_SV));
		out.append(var_SVnegatiu);
		out.append(word2.tl(attr_a_verb));
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append("{^");
		out.append(TransferWord.copycase(word2.sl(attr_lem), "there"));
		out.append("<adv>$ ");
		{
			String myword = 
			         var_verbfinal
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
	
	// REGLA: ADV VERB conjugat (no volia)
	public void rule53__adv__verbcj(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule53__adv__verbcj",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_lem).equalsIgnoreCase("no"))
		{
			var_SVnegatiu = "<SVneg>";
			macro_f_bcond(out, word1, blank1, word2);
			var_caseSecondWord = var_caseFirstWord;
		}
		else
		{
			var_SVnegatiu = "<SV>";
			var_caseSecondWord = TransferWord.caseOf(word2.sl(attr_lem));
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
			out.append(word1.tl(attr_a_adv));
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
			out.append(blank1);
		}
		macro_conj_verb1(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseSecondWord, var_lema_SV));
		out.append(var_SVnegatiu);
		out.append(word2.tl(attr_a_verb));
		out.append(var_temps_chunk);
		out.append(word2.tl(attr_pers));
		out.append(word2.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         var_verbfinal
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
	
	// ADV HAVER + PP (no han vist - have  seen)
	public void rule54__adv__haver__pp(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule54__adv__haver__pp",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_lem).equalsIgnoreCase("no"))
		{
			var_SVnegatiu = "<SVneg>";
			macro_f_bcond(out, word1, blank1, word2);
			var_caseSecondWord = var_caseFirstWord;
		}
		else
		{
			var_SVnegatiu = "<SV>";
			var_caseSecondWord = TransferWord.caseOf(word2.sl(attr_lem));
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
			out.append(word1.tl(attr_a_adv));
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
			out.append(blank1);
		}
		if ((word3.sl(attr_lem).equalsIgnoreCase("haber")
    && word2.sl(attr_pers).equals("<p3>")
    && word2.sl(attr_nbr).equals("<sg>")))
		{
			word3.tlSet(attr_lem, TransferWord.copycase(word3.sl(attr_lem), "be"));
			word3.tlSet(attr_a_verb, "<vbser>");
			macro_conj_haverhi_pp(out, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseSecondWord, var_lema_SV));
			out.append(var_SVnegatiu);
			out.append(word2.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append("{^");
			out.append(TransferWord.copycase(word2.sl(attr_lem), "there"));
			out.append("<adv>$");
			out.append(blank2);
			{
				String myword = 
				         var_verbfinal
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
				         word3.tl(attr_lem)
				         +word3.tl(attr_a_pp)
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
			if (word3.sl(attr_lem).equalsIgnoreCase("poder"))
			{
				word3.tlSet(attr_lem, TransferWord.copycase(word3.sl(attr_lem), "be able to"));
				word3.tlSet(attr_a_pp, "<vbmod><pp>");
			}
			macro_conj_verb1(out, word2);
			/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb1'  */
			if ((word2.sl(attr_temps).equals("<cni>")
    || word2.sl(attr_temps).equals("<fti>")))
			{
				var_lema_SV = "aux_haver_pp";
			}
			else
			{
				var_lema_SV = "haver_pp";
			}
			out.append('^');
			out.append(TransferWord.copycase(var_caseSecondWord, var_lema_SV));
			out.append(var_SVnegatiu);
			out.append(word3.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_verbfinal
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
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_pp)
				         +word3.tl(attr_lemq)
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
	
	// ADV pro HAVER + PP (no els han vist - have not seen them)
	public void rule55__adv__pro__haver__pp(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule55__adv__pro__haver__pp",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_lem).equalsIgnoreCase("no"))
		{
			var_SVnegatiu = "<SVneg>";
			macro_f_bcond(out, word1, blank1, word2);
			var_caseSecondWord = var_caseFirstWord;
		}
		else
		{
			var_SVnegatiu = "<SV>";
			var_caseSecondWord = TransferWord.caseOf(word2.sl(attr_lem));
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
			out.append(word1.tl(attr_a_adv));
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
			out.append(blank1);
		}
		if ((word4.sl(attr_lem).equalsIgnoreCase("haber")
    && word3.sl(attr_pers).equals("<p3>")
    && word3.sl(attr_nbr).equals("<sg>")))
		{
			word4.tlSet(attr_lem, TransferWord.copycase(word4.sl(attr_lem), "be"));
			word4.tlSet(attr_a_verb, "<vbser>");
			macro_conj_haverhi_pp(out, word3);
			out.append('^');
			out.append(TransferWord.copycase(var_caseSecondWord, var_lema_SV));
			out.append(var_SVnegatiu);
			out.append(word4.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append("{^");
			out.append(TransferWord.copycase(word2.sl(attr_lem), "there"));
			out.append("<adv>$");
			out.append(blank2);
			{
				String myword = 
				         var_verbfinal
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
				         word4.tl(attr_lem)
				         +word4.tl(attr_a_pp)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append("}$^pro<SN>");
			out.append(word2.tl(attr_tipus_prn));
			out.append(word2.sl(attr_pers));
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append("{ ");
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
		}
		else
		{
			if (word4.sl(attr_lem).equalsIgnoreCase("poder"))
			{
				word4.tlSet(attr_lem, TransferWord.copycase(word4.sl(attr_lem), "be able to"));
				word4.tlSet(attr_a_pp, "<vbmod><pp>");
			}
			macro_conj_verb1(out, word3);
			if ((word4.tl(attr_sep).equals("<sep>")
    && !word4.sl(attr_pron).equals("<pron>")))
			{
				/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb1'  */
				if ((word3.sl(attr_temps).equals("<cni>")
    || word3.sl(attr_temps).equals("<fti>")))
				{
					var_lema_SV = "aux_haver_pp_enc";
				}
				else
				{
					var_lema_SV = "haver_pp_enc";
				}
				out.append('^');
				out.append(TransferWord.copycase(var_caseSecondWord, var_lema_SV));
				out.append(var_SVnegatiu);
				out.append(word4.tl(attr_a_verb));
				out.append(var_temps_chunk);
				out.append(word3.tl(attr_pers));
				out.append(word3.tl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         var_verbfinal
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
				out.append(word4.tl(attr_lemh));
				out.append(word4.tl(attr_a_pp));
				out.append('+');
				out.append(word2.tl(attr_lem));
				out.append(word2.tl(attr_a_prn));
				out.append(word2.tl(attr_tipus_prn));
				out.append(word2.tl(attr_pers));
				out.append(word2.tl(attr_gen));
				out.append(word2.tl(attr_nbr));
				out.append(word4.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb1'  */
				if ((word3.sl(attr_temps).equals("<cni>")
    || word3.sl(attr_temps).equals("<fti>")))
				{
					var_lema_SV = "aux_haver_pp";
				}
				else
				{
					var_lema_SV = "haver_pp";
				}
				out.append('^');
				out.append(TransferWord.copycase(var_caseSecondWord, var_lema_SV));
				out.append(var_SVnegatiu);
				out.append(word4.tl(attr_a_verb));
				out.append(var_temps_chunk);
				out.append(word3.tl(attr_pers));
				out.append(word3.tl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         var_verbfinal
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
					         word4.tl(attr_lemh)
					         +word4.tl(attr_a_pp)
					         +word4.tl(attr_lemq)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append("}$");
				if ((word4.sl(attr_pron).equals("<pron>")
    && word2.sl(attr_pers).equals(word3.sl(attr_pers))
    && (word2.sl(attr_nbr).equals(word3.sl(attr_nbr))
    || word2.sl(attr_lem).equalsIgnoreCase("se"))))
				{
					/** imprimeix el blanc si té info de format, el pronom no l'imprimeixis  */
					macro_f_bcond(out, word3, blank3, word4);
				}
				else
				{
					if (word2.sl(attr_lem).equalsIgnoreCase("se"))
					{
						var_lema = "ref";
						var_nom_chunk = "<ref>";
					}
					else
					{
						var_lema = "pro";
						var_nom_chunk = "<SN>";
					}
					out.append(blank3);
					out.append('^');
					out.append(var_lema);
					out.append(var_nom_chunk);
					out.append(word2.tl(attr_tipus_prn));
					out.append(word2.sl(attr_pers));
					out.append(word2.tl(attr_gen));
					out.append(word2.tl(attr_nbr));
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
					out.append("}$");
				}
			}
		}
	}
	
	// PER + NO + INF (per no oblidar - not to forget
	public void rule56__para__no__inf(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule56__para__no__inf",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append("<adv><NEG>{");
		{
			String myword = 
			         TransferWord.copycase(word1.sl(attr_lem), "not")
			         +word2.tl(attr_tags)
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
		out.append("^to<PREP>{");
		{
			String myword = 
			         TransferWord.copycase(word2.sl(attr_lem), "to")
			         +word1.tl(attr_tags)
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
		out.append("^inf<SV>");
		out.append(word3.tl(attr_a_verb));
		out.append(word3.sl(attr_temps));
		out.append('{');
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_verb)
			         +word3.tl(attr_sep)
			         +(word3.tl(attr_temps).isEmpty()?"" : "<3>")
			         +word3.tl(attr_lemq)
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
	
	// REGLA: ADV PROCLÍTIC VERB conjugat (no el veig) MG: aquí no he posat lo de 'no lo hubo' perquè és molt més freqüent que la següent paraula sigui desconeguda. només es mira si és 'hay'
	public void rule57__adv__pro__hay_lex(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule57__adv__pro__hay_lex",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_lem).equalsIgnoreCase("no"))
		{
			var_SVnegatiu = "<SVneg>";
			macro_f_bcond(out, word1, blank1, word2);
			var_caseSecondWord = var_caseFirstWord;
		}
		else
		{
			var_SVnegatiu = "<SV>";
			var_caseSecondWord = TransferWord.caseOf(word2.sl(attr_lem));
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
			out.append(word1.tl(attr_a_adv));
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
			out.append(blank1);
		}
		word3.tlSet(attr_lem, TransferWord.copycase(word3.sl(attr_lem), "be"));
		word3.tlSet(attr_a_verb, "<vbser>");
		macro_conj_haverhi(out, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseSecondWord, var_lema_SV));
		out.append(var_SVnegatiu);
		out.append(word3.tl(attr_a_verb));
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append("{^");
		out.append(TransferWord.copycase(word2.sl(attr_lem), "there"));
		out.append("<adv>$ ");
		{
			String myword = 
			         var_verbfinal
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
		out.append("^pro<SN>");
		out.append(word2.tl(attr_tipus_prn));
		out.append(word2.sl(attr_pers));
		out.append(word2.tl(attr_gen));
		out.append(word2.tl(attr_nbr));
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
		out.append("}$");
	}
	
	// REGLA: ADV PROCLÍTIC VERB conjugat (no el veig)
	public void rule58__adv__pro__verbcj(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule58__adv__pro__verbcj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_lem).equalsIgnoreCase("no"))
		{
			var_SVnegatiu = "<SVneg>";
			macro_f_bcond(out, word1, blank1, word2);
			var_caseSecondWord = var_caseFirstWord;
		}
		else
		{
			var_SVnegatiu = "<SV>";
			var_caseSecondWord = TransferWord.caseOf(word2.sl(attr_lem));
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
			out.append(word1.tl(attr_a_adv));
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
			out.append(blank1);
		}
		/** 	<choose>
	  <when>
	    <test>
	     <and>
		<equal>
		  <clip pos="3" side="sl" part="lem"/>		     
		  <lit v="haver"/>
		</equal>
		<equal>
		  <clip pos="3" side="sl" part="pers"/>		     
		  <lit-tag v="p3"/>
		</equal>
		<equal>
		  <clip pos="3" side="sl" part="nbr"/>		     
		  <lit-tag v="sg"/>
		</equal>
	      </and>
	    </test>
	    <let>
	      <clip pos="3" side="tl" part="lem"/>
	      <lit v="be"/>
	    </let>
	    <let>
	      <clip pos="3" side="tl" part="a_verb"/>
	      <lit-tag v="vbser"/>
	    </let>
	    <call-macro n="conj_haverhi">
	      <with-param pos="3"/>
	    </call-macro>
	    <out>
	      <chunk namefrom="lema_SV" case="caseSecondWord">
		<tags>
		  <tag><var n="SVnegatiu"/></tag>
		  <tag><clip pos="3" side="tl" part="a_verb"/></tag>
		  <tag><var n="temps_chunk"/></tag>
		  <tag><var n="pers_chunk"/></tag>
		  <tag><var n="nbr_chunk"/></tag>
		</tags>
		<lu>
		  <clip pos="3" side="tl" part="whole"/>
		</lu>		  
	      </chunk>
	      <b pos="2"/>
	      <chunk name="pro">
		<tags>
		  <tag><lit-tag v="SN"/></tag>
		  <tag><clip pos="2" side="tl" part="tipus_prn"/></tag>
		  <tag><clip pos="2" side="sl" part="pers"/></tag>
		  <tag><clip pos="2" side="tl" part="gen"/></tag>
		  <tag><clip pos="2" side="tl" part="nbr"/></tag>
		</tags>
		<lu>
		  <clip pos="2" side="tl" part="whole"/>
		</lu>
	      </chunk>
	    </out>
	  </when>  */
		if ((word3.tl(attr_sep).equals("<sep>")
    && !word3.sl(attr_pron).equals("<pron>")))
		{
			macro_conj_verb1(out, word3);
			var_lema_SV = var_lema_SV
			    +"_enc"
			    ;
			out.append('^');
			out.append(TransferWord.copycase(var_caseSecondWord, var_lema_SV));
			out.append(var_SVnegatiu);
			out.append(word3.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word3.tl(attr_pers));
			out.append(word3.tl(attr_nbr));
			out.append("{^");
			out.append(var_verbfinal);
			out.append('+');
			out.append(word2.tl(attr_lem));
			out.append(word2.tl(attr_a_prn));
			out.append(word2.tl(attr_tipus_prn));
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
			/**  si cal, enviem el blanc  */
			macro_f_bcond(out, word2, blank2, word3);
		}
		else
		{
			macro_conj_verb1(out, word3);
			out.append('^');
			out.append(TransferWord.copycase(var_caseSecondWord, var_lema_SV));
			out.append(var_SVnegatiu);
			out.append(word3.tl(attr_a_verb));
			out.append(var_temps_chunk);
			out.append(word3.tl(attr_pers));
			out.append(word3.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         var_verbfinal
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append("}$");
			/** I ara que ja hem imprès el verb, mirem els proclítics (si no és haver-hi)  */
			if ((word3.sl(attr_pron).equals("<pron>")
    && word2.sl(attr_pers).equals(word3.sl(attr_pers))
    && (word2.sl(attr_nbr).equals(word3.sl(attr_nbr))
    || word2.sl(attr_lem).equalsIgnoreCase("se"))))
			{
				/** imprimeix el blanc si té info de format, el pronom no l'imprimeixis  */
				macro_f_bcond(out, word2, blank2, word3);
			}
			else
			{
				if (word2.sl(attr_lem).equalsIgnoreCase("se"))
				{
					var_lema = "ref";
					var_nom_chunk = "<ref>";
				}
				else
				{
					var_lema = "pro";
					var_nom_chunk = "<SN>";
				}
				out.append(blank2);
				out.append('^');
				out.append(var_lema);
				out.append(var_nom_chunk);
				out.append(word2.tl(attr_tipus_prn));
				out.append(word2.sl(attr_pers));
				out.append(word2.tl(attr_gen));
				out.append(word2.tl(attr_nbr));
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
				out.append("}$");
			}
		}
	}
	
	// NO VERB + ENCL (no ajudar-me - not to help me) (posar-ho en gerundi en anglès?)
	public void rule59__no__verbnm_inf_ger__enc(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule59__no__verbnm_inf_ger__enc",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		if (word2.tl(attr_sep).equals("<sep>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "to_verb_enc"));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(word2.tl(attr_temps));
			out.append('{');
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), "not")
				         +word1.tl(attr_tags)
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
			out.append(TransferWord.copycase(word2.sl(attr_lem), "to"));
			out.append("<pr>$ ^");
			out.append(word2.tl(attr_lemh));
			out.append(word2.tl(attr_a_verb));
			out.append(word2.tl(attr_sep));
			out.append((word2.tl(attr_temps).isEmpty()?"" : "<3>"));
			out.append('+');
			out.append(word3.tl(attr_lem));
			out.append(word3.tl(attr_a_prn));
			out.append(word3.tl(attr_tipus_prn));
			out.append(word3.tl(attr_pers));
			out.append(word3.tl(attr_gen));
			out.append(word3.tl(attr_nbr));
			out.append(word2.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "to_verb_enc"));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(word2.sl(attr_temps));
			out.append('{');
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), "not")
				         +word1.tl(attr_tags)
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
			out.append(TransferWord.copycase(word2.sl(attr_lem), "to"));
			out.append("<pr>$ ");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_verb)
				         +word2.tl(attr_sep)
				         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
				         +word2.tl(attr_lemq)
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
	
	// NO VERB + ENCL + ENCL (no portar-me'ls - not to bring them to me)(en gerundi?)
	public void rule60__no__verbnm_inf_ger__enc__enc(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule60__no__verbnm_inf_ger__enc__enc",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		if (word4.tl(attr_whole).equals(""))
		{
			if (word2.tl(attr_sep).equals("<sep>"))
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "to_verb_enc"));
				out.append("<SV>");
				out.append(word2.tl(attr_a_verb));
				out.append(word2.tl(attr_temps));
				out.append('{');
				{
					String myword = 
					         TransferWord.copycase(word1.sl(attr_lem), "not")
					         +word1.tl(attr_tags)
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
				out.append(TransferWord.copycase(word2.sl(attr_lem), "to"));
				out.append("<pr>$ ^");
				out.append(word2.tl(attr_lemh));
				out.append(word2.tl(attr_a_verb));
				out.append(word2.tl(attr_sep));
				out.append((word2.tl(attr_temps).isEmpty()?"" : "<3>"));
				out.append('+');
				out.append(word3.tl(attr_lem));
				out.append(word3.tl(attr_a_prn));
				out.append(word3.tl(attr_tipus_prn));
				out.append(word3.tl(attr_pers));
				out.append(word3.tl(attr_gen));
				out.append(word3.tl(attr_nbr));
				out.append(word2.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "to_verb_enc"));
				out.append("<SV>");
				out.append(word2.tl(attr_a_verb));
				out.append(word2.sl(attr_temps));
				out.append('{');
				{
					String myword = 
					         TransferWord.copycase(word1.sl(attr_lem), "not")
					         +word1.tl(attr_tags)
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
				out.append(TransferWord.copycase(word2.sl(attr_lem), "to"));
				out.append("<pr>$ ");
				{
					String myword = 
					         word2.tl(attr_lemh)
					         +word2.tl(attr_a_verb)
					         +word2.tl(attr_sep)
					         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word2.tl(attr_lemq)
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
		else
		{
			if (word2.tl(attr_sep).equals("<sep>"))
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "to_verb_enc"));
				out.append("<SV>");
				out.append(word2.tl(attr_a_verb));
				out.append(word2.tl(attr_temps));
				out.append('{');
				{
					String myword = 
					         TransferWord.copycase(word1.sl(attr_lem), "not")
					         +word1.tl(attr_tags)
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
				out.append(TransferWord.copycase(word2.sl(attr_lem), "to"));
				out.append("<pr>$ ^");
				out.append(word2.tl(attr_lemh));
				out.append(word2.tl(attr_a_verb));
				out.append(word2.tl(attr_sep));
				out.append((word2.tl(attr_temps).isEmpty()?"" : "<3>"));
				out.append('+');
				out.append(word4.tl(attr_lem));
				out.append(word4.tl(attr_a_prn));
				out.append(word4.tl(attr_tipus_prn));
				out.append(word4.tl(attr_pers));
				out.append(word4.tl(attr_gen));
				out.append(word4.tl(attr_nbr));
				out.append(word2.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "to_verb_enc"));
				out.append("<SV>");
				out.append(word2.tl(attr_a_verb));
				out.append(word2.sl(attr_temps));
				out.append('{');
				{
					String myword = 
					         TransferWord.copycase(word1.sl(attr_lem), "not")
					         +word1.tl(attr_tags)
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
				out.append(TransferWord.copycase(word2.sl(attr_lem), "to"));
				out.append("<pr>$ ");
				{
					String myword = 
					         word2.tl(attr_lemh)
					         +word2.tl(attr_a_verb)
					         +word2.tl(attr_sep)
					         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word2.tl(attr_lemq)
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
					         word4.tl(attr_whole)
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
			if (!word3.tl(attr_whole).equals(""))
			{
				out.append(" ^to_prn<SP>");
				out.append(word3.tl(attr_tipus_prn));
				out.append(word3.tl(attr_pers));
				out.append(word3.tl(attr_gen));
				out.append(word3.tl(attr_nbr));
				out.append("{^");
				out.append(TransferWord.copycase(word3.sl(attr_lem), "to"));
				out.append("<pr>$ ");
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
	}
	
	// NO + VERBMOD + ENCL + INF (no poder-ho fer - not being able to do it)(aquí ho he posat en gerundi, en els altres casos d'infinitiu negat no, revisar)
	public void rule61__no__verbm_inf_ger__enc__inf(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule61__no__verbm_inf_ger__enc__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		word2.tlSet(attr_temps, "<ger>");
		if (word2.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "be able to"));
			word2.tlSet(attr_a_verb, "<vbmod>");
		}
		if (word4.tl(attr_sep).equals("<sep>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "no_mod_inf_enc"));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(word2.tl(attr_temps));
			out.append(word2.sl(attr_pers));
			out.append(word2.sl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), "not")
				         +word1.tl(attr_tags)
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
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_verb)
				         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
				         +word2.tl(attr_lemq)
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
			out.append(word4.tl(attr_a_verb));
			out.append(word4.tl(attr_sep));
			out.append(word4.tl(attr_temps));
			out.append('+');
			out.append(word3.tl(attr_lem));
			out.append(word3.tl(attr_a_prn));
			out.append(word3.tl(attr_tipus_prn));
			out.append(word3.tl(attr_pers));
			out.append(word3.tl(attr_gen));
			out.append(word3.tl(attr_nbr));
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "no_mod_inf_enc"));
			out.append("<SV>");
			out.append(word2.tl(attr_a_verb));
			out.append(word2.tl(attr_temps));
			out.append(word2.sl(attr_pers));
			out.append(word2.sl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         TransferWord.copycase(word1.sl(attr_lem), "not")
				         +word1.tl(attr_tags)
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
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_verb)
				         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
				         +word2.tl(attr_lemq)
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
				         word4.tl(attr_lemh)
				         +word4.tl(attr_a_verb)
				         +word4.tl(attr_sep)
				         +word4.tl(attr_temps)
				         +word4.tl(attr_lemq)
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
	
	// NO + VERBMOD + ENCL + ENCL + INF (no poder-los-ho explicar -> not being able to explain it to them)
	public void rule62__no__verbm_inf_ger__enc__enc__inf(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule62__no__verbm_inf_ger__enc__enc__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		word2.tlSet(attr_temps, "<ger>");
		if (word2.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "be able to"));
			word2.tlSet(attr_a_verb, "<vbmod>");
		}
		if (word4.tl(attr_whole).equals(""))
		{
			if (word5.tl(attr_sep).equals("<sep>"))
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "no_mod_inf_enc"));
				out.append("<SV>");
				out.append(word2.tl(attr_a_verb));
				out.append(word2.tl(attr_temps));
				out.append(word2.sl(attr_pers));
				out.append(word2.sl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         TransferWord.copycase(word1.sl(attr_lem), "not")
					         +word1.tl(attr_tags)
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
					         word2.tl(attr_lemh)
					         +word2.tl(attr_a_verb)
					         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word2.tl(attr_lemq)
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
				out.append(word5.tl(attr_lemh));
				out.append(word5.tl(attr_a_verb));
				out.append(word5.tl(attr_sep));
				out.append(word5.tl(attr_temps));
				out.append('+');
				out.append(word3.tl(attr_lem));
				out.append(word3.tl(attr_a_prn));
				out.append(word3.tl(attr_tipus_prn));
				out.append(word3.tl(attr_pers));
				out.append(word3.tl(attr_gen));
				out.append(word3.tl(attr_nbr));
				out.append(word5.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "no_mod_inf_enc"));
				out.append("<SV>");
				out.append(word2.tl(attr_a_verb));
				out.append(word2.tl(attr_temps));
				out.append(word2.sl(attr_pers));
				out.append(word2.sl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         TransferWord.copycase(word1.sl(attr_lem), "not")
					         +word1.tl(attr_tags)
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
					         word2.tl(attr_lemh)
					         +word2.tl(attr_a_verb)
					         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word2.tl(attr_lemq)
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
					         word5.tl(attr_lemh)
					         +word5.tl(attr_a_verb)
					         +word5.tl(attr_sep)
					         +word5.tl(attr_temps)
					         +word5.tl(attr_lemq)
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
		else
		{
			if (word5.tl(attr_sep).equals("<sep>"))
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "no_mod_inf_enc_enc"));
				out.append("<SV>");
				out.append(word2.tl(attr_a_verb));
				out.append(word2.tl(attr_temps));
				out.append(word2.sl(attr_pers));
				out.append(word2.sl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         TransferWord.copycase(word1.sl(attr_lem), "not")
					         +word1.tl(attr_tags)
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
					         word2.tl(attr_lemh)
					         +word2.tl(attr_a_verb)
					         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word2.tl(attr_lemq)
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
				out.append(word5.tl(attr_lemh));
				out.append(word5.tl(attr_a_verb));
				out.append(word5.tl(attr_sep));
				out.append(word5.tl(attr_temps));
				out.append('+');
				out.append(word4.tl(attr_lem));
				out.append(word4.tl(attr_a_prn));
				out.append(word4.tl(attr_tipus_prn));
				out.append(word4.tl(attr_pers));
				out.append(word4.tl(attr_gen));
				out.append(word4.tl(attr_nbr));
				out.append(word5.tl(attr_lemq));
				out.append("$}$");
			}
			else
			{
				out.append('^');
				out.append(TransferWord.copycase(var_caseFirstWord, "no_mod_inf_enc_enc"));
				out.append("<SV>");
				out.append(word2.tl(attr_a_verb));
				out.append(word2.tl(attr_temps));
				out.append(word2.sl(attr_pers));
				out.append(word2.sl(attr_nbr));
				out.append('{');
				{
					String myword = 
					         TransferWord.copycase(word1.sl(attr_lem), "not")
					         +word1.tl(attr_tags)
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
					         word2.tl(attr_lemh)
					         +word2.tl(attr_a_verb)
					         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
					         +word2.tl(attr_lemq)
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
					         word5.tl(attr_lemh)
					         +word5.tl(attr_a_verb)
					         +word5.tl(attr_sep)
					         +word5.tl(attr_temps)
					         +word5.tl(attr_lemq)
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
					         word4.tl(attr_whole)
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
			if (!word3.tl(attr_whole).equals(""))
			{
				out.append(" ^to_prn<SP>");
				out.append(word3.tl(attr_tipus_prn));
				out.append(word3.tl(attr_pers));
				out.append(word3.tl(attr_gen));
				out.append(word3.tl(attr_nbr));
				out.append("{^");
				out.append(TransferWord.copycase(word3.sl(attr_lem), "to"));
				out.append("<pr>$ ");
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
	}
	
	// NO + VERBMOD + ENCL (per quan va davant desconegudes, perquè almenys no peti: no poder-ho xxx - not being able to it xxx)
	public void rule63__no__verbm_inf_ger__enc(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule63__no__verbm_inf_ger__enc",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		word2.tlSet(attr_temps, "<ger>");
		if (word2.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "be able to"));
			word2.tlSet(attr_a_verb, "<vbmod>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "no_mod_enc_x"));
		out.append("<SV>");
		out.append(word2.tl(attr_a_verb));
		out.append(word2.tl(attr_temps));
		out.append(word2.sl(attr_pers));
		out.append(word2.sl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         TransferWord.copycase(word1.sl(attr_lem), "not")
			         +word1.tl(attr_tags)
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
			         +word2.tl(attr_lemq)
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
	
	// NO + VERBMOD + ENCL + ENCL (per quan va davant desconegudes, perquè almenys no peti: no poder-los-ho xxx - not being able to them it xxx)
	public void rule64__no__verbm_inf_ger__enc__enc(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule64__no__verbm_inf_ger__enc__enc",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		word2.tlSet(attr_temps, "<ger>");
		if (word2.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "be able to"));
			word2.tlSet(attr_a_verb, "<vbmod>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "no_mod_enc_enc_x"));
		out.append("<SV>");
		out.append(word2.tl(attr_a_verb));
		out.append(word2.tl(attr_temps));
		out.append(word2.sl(attr_pers));
		out.append(word2.sl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         TransferWord.copycase(word1.sl(attr_lem), "not")
			         +word1.tl(attr_tags)
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
			         +word2.tl(attr_lemq)
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
			         word3.tl(attr_whole)
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
			         word4.tl(attr_whole)
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
	
	// REGLA: NO + INF (no jugar - not playing)
	public void rule65__no__inf(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule65__no__inf",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		word2.tlSet(attr_temps, "<ger>");
		if (word2.sl(attr_lem).equalsIgnoreCase("poder"))
		{
			word2.tlSet(attr_lem, TransferWord.copycase(word2.sl(attr_lem), "be able to"));
			word2.tlSet(attr_a_verb, "<vbmod>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "no_inf"));
		out.append("<SV>");
		out.append(word2.tl(attr_a_verb));
		out.append(word2.tl(attr_temps));
		out.append('{');
		{
			String myword = 
			         TransferWord.copycase(word1.sl(attr_lem), "not")
			         +word1.tl(attr_tags)
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +word2.tl(attr_sep)
			         +(word2.tl(attr_temps).isEmpty()?"" : "<3>")
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
	
	// REGLA: NO + GER (no fent - not doing)
	public void rule66__no__ger(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule66__no__ger",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		if (word2.sl(attr_lemh).equalsIgnoreCase("poder"))
		{
			word2.tlSet(attr_lemh, TransferWord.copycase(word2.sl(attr_lem), "be able to"));
			word2.tlSet(attr_a_verb, "<vbmod>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "no_ger"));
		out.append("<SV>");
		out.append(word2.tl(attr_a_verb));
		out.append(word2.tl(attr_temps));
		out.append('{');
		{
			String myword = 
			         TransferWord.copycase(word1.sl(attr_lem), "not")
			         +word1.tl(attr_tags)
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +word2.tl(attr_sep)
			         +word2.tl(attr_temps)
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
	
	/** ************************************ ALTRES ************************************************  */
	// ADV
	public void rule67__adv(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule67__adv",  word1); } 
		macro_firstWord(out, word1);
		if (word1.sl(attr_lem).equalsIgnoreCase("no"))
		{
			var_paraula1 = word1.tl(attr_whole);
			var_paraula1 = var_paraula1
			    +"<NEG>"
			    ;
			word1.tlSet(attr_whole, var_paraula1);
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word1.tl(attr_a_adv));
		out.append(word1.tl(attr_neg));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_adv)
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
	
	// ADV ITG
	public void rule68__advitg(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule68__advitg",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word1.tl(attr_a_adv));
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
	
	// PRONOM tònic/interrogatiu/possessiu
	public void rule69__tn_itg_pos(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule69__tn_itg_pos",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prn"));
		out.append("<SN>");
		out.append(word1.tl(attr_tipus_prn));
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_prn)
			         +word1.tl(attr_tipus_prn)
			         +(word1.tl(attr_gen).isEmpty()?"" : "<3>")
			         +(word1.tl(attr_nbr).isEmpty()?"" : "<4>")
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
	
	// PRN personal
	public void rule70__prpers(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule70__prpers",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prpers"));
		out.append("<SN>");
		out.append(word1.tl(attr_tipus_prn));
		out.append(word1.tl(attr_pers));
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_prn)
			         +(word1.tl(attr_tipus_prn).isEmpty()?"" : "<2>")
			         +word1.tl(attr_pers)
			         +word1.tl(attr_gen)
			         +word1.tl(attr_nbr)
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
	
	// PREP PRN personal (amb ell = with him (prn obj))
	public void rule71__prep__prpers(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule71__prep__prpers",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		word2.tlSet(attr_tipus_prn, "<obj>");
		if ((word2.sl(attr_pers).equals("<p3>")
    && word2.sl(attr_nbr).equals("<pl>")))
		{
			word2.tlSet(attr_gen, "<mf>");
		}
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
		out.append(blank1);
		out.append("^prpers<SN>");
		out.append(word2.tl(attr_tipus_prn));
		out.append(word2.tl(attr_pers));
		out.append(word2.tl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_prn)
			         +(word2.tl(attr_tipus_prn).isEmpty()?"" : "<2>")
			         +word2.tl(attr_pers)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
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
	
	// PREP PRN personal (amb ell = with him (prn obj))
	public void rule72__prep__el_que(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule72__prep__el_que",  word1, blank1,  word2); } 
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
		out.append(blank1);
		out.append("^rel");
		out.append(word2.tl(attr_a_rel));
		out.append("{^");
		out.append(TransferWord.copycase(word2.sl(attr_lem), "which"));
		out.append("<rel><an><mf><sp>$}$");
	}
	
	// CNJ
	public void rule73__cnj(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule73__cnj",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "cnj"));
		out.append(word1.tl(attr_tags));
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
	
	// de
	public void rule74__de(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule74__de",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "de"));
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
	
	// PREP
	public void rule75__prep(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule75__prep",  word1); } 
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
	
	// REL
	public void rule76__rel(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule76__rel",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "rel"));
		out.append(word1.tl(attr_a_rel));
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
	
	// PREADV
	public void rule77__preadv(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule77__preadv",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "preadv"));
		out.append(word1.tl(attr_a_adv));
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
	
	// REGLA: NP cognom
	public void rule78__cog(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule78__cog",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "cog"));
		out.append("<SN>");
		out.append(word1.sl(attr_gen));
		out.append(word1.tl(attr_nbr));
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
	
	// REGLA: NP altres
	public void rule79__al(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule79__al",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "al"));
		out.append("<SN>");
		out.append(word1.sl(attr_gen));
		out.append(word1.tl(attr_nbr));
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
	
	// REGLA: NUM
	public void rule80__num(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule80__num",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num"));
		out.append("<SN>");
		out.append(word1.sl(attr_gen));
		out.append(word1.tl(attr_nbr));
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
	
	/**  REGLA: reset variables */
	public void rule81__sent(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule81__sent",  word1); } 
		/**  REGLA: reset variables */
		var_nombre = "<sg>";
		var_genere = "<m>";
		if (!(word1.sl(attr_lem).equals(";")
    || word1.sl(attr_lem).equals(":")))
		{
			var_EOS = "true";
		}
		out.append("^punt<sent>{");
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
	
	// REGLA: reset variables
	public void rule82__coma(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule82__coma",  word1); } 
		/** 	<let>
	  <var n="nombre"/>
	  <lit-tag v="sg"/>
	</let>
	<let>
	  <var n="genere"/>
	  <lit-tag v="m"/>
	</let>  */
		var_EOS = "false";
		out.append("^coma<cm>{");
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
}
