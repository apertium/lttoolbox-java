package org.apertium.transfer.old.generated;
import java.io.*;
import org.apertium.transfer.*;
import org.apertium.transfer.generated.GeneratedTransferBase;
public class apertium_en_ca_en_ca_t1x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return true;
	}
	ApertiumRE attr_a_nom = new ApertiumRE("<(?:np><loc|np><ant|np><cog|n><acr|np><al|adv|n)>");
	ApertiumRE attr_a_np = new ApertiumRE("<np>");
	ApertiumRE attr_a_np_acr = new ApertiumRE("<(?:acr|np)>");
	ApertiumRE attr_a_adj = new ApertiumRE("<(?:vblex><pron><pp|vblex><pp|vbmod><pp|adj><pos|adjant|adj)>");
	ApertiumRE attr_grau_adj = new ApertiumRE("<(?:com|su)p>");
	ApertiumRE attr_a_det = new ApertiumRE("<(?:det><dem|det><ind|det><def|det><pos|det><qnt|det><itg|det><ord|adj><pos|predet|num)>");
	ApertiumRE attr_a_prnpro = new ApertiumRE("<prn><pro>");
	ApertiumRE attr_a_prnenc = new ApertiumRE("<prn><enc>");
	ApertiumRE attr_a_num = new ApertiumRE("<num(?:><percent|><ord|><mon|)>");
	ApertiumRE attr_a_verb = new ApertiumRE("<vb(?:lex><pron|haver|lex|ser|mod)>");
	ApertiumRE attr_a_have_aux = new ApertiumRE("<vbhaver>");
	ApertiumRE attr_a_pp = new ApertiumRE("<vb(?:lex><pron|lex|ser|mod)><pp>");
	ApertiumRE attr_a_aux = new ApertiumRE("<vaux>");
	ApertiumRE attr_a_prn = new ApertiumRE("<prn>");
	ApertiumRE attr_a_adv = new ApertiumRE("<(?:adv><itg|preadv|cnjadv|adv)>");
	ApertiumRE attr_a_rel = new ApertiumRE("<rel><(?:adv|nn|an|aa)>");
	ApertiumRE attr_tipus_rel = new ApertiumRE("<(?:adv|nn|an|aa)>");
	ApertiumRE attr_tipus_prn = new ApertiumRE("<(?:obj|enc|itg|pos|tn)>");
	ApertiumRE attr_pers = new ApertiumRE("<(?:p1|p2|p3|PD)>");
	ApertiumRE attr_gen = new ApertiumRE("<(?:mf|GD|nt|m|f)>");
	ApertiumRE attr_gen_sense_mf = new ApertiumRE("<(?:GD|nt|m|f)>");
	ApertiumRE attr_gen_mf = new ApertiumRE("<mf>");
	ApertiumRE attr_nbr = new ApertiumRE("<(?:sg|pl|sp|ND)>");
	ApertiumRE attr_nbr_sense_sp = new ApertiumRE("<(?:sg|pl|ND)>");
	ApertiumRE attr_nbr_sp = new ApertiumRE("<sp>");
	ApertiumRE attr_temps = new ApertiumRE("<(?:pres|past|pprs|subs|cni|fti|ifi|imp|pii|pis|inf|prs|pri|ger|pp)>");
	ApertiumRE attr_lem = new ApertiumRE("(([^<]|\"\\<\")+)");
	ApertiumRE attr_lemq = new ApertiumRE("\\#[- _][^<]+");
	ApertiumRE attr_lemh = new ApertiumRE("(([^<#]|\"\\<\"|\"\\#\")+)");
	ApertiumRE attr_whole = new ApertiumRE("(.+)");
	ApertiumRE attr_tags = new ApertiumRE("((<[^>]+>)+)");
	ApertiumRE attr_chname = new ApertiumRE("(\\{([^/]+)\\/)");
	ApertiumRE attr_chcontent = new ApertiumRE("(\\{.+)");
	ApertiumRE attr_content = new ApertiumRE("(\\{.+)");
	String var_genere = "<m>";
	String var_nombre = "<sg>";
	String var_interrogativa = "";
	String var_exclamativa = "";
	String var_neg = "";
	String var_adjectiu1 = "";
	String var_adjectiu2 = "";
	String var_auxiliar = "";
	String var_caseFirstWord = "";
	String var_EOS = "true";
	String var_lema = "";
	String var_lema_SV = "";
	String var_verbfinal = "";
	String var_chunk = "";
	String var_temps_chunk = "";
	String var_pers_chunk = "";
	String var_nbr_chunk = "";
	String var_nbr_qual = "";
	String var_gen_chunk = "";
	String var_gen_qual = "";
	String var_gen_paraula = "";
	String var_nbr_paraula = "";
	String var_pronom = "";
	String var_pronomenc = "";
	String var_paraula1 = "";
	String var_paraula2 = "";
	String var_tipus_verb = "";
	String var_tipus_verb_imp = "";
	String var_negative = "";
	/**  BCN */
	String var_tipus_det = "";
	/**  BCN verbs que poden no portar el THAT  */
	WordList list_reportingverb = new WordList(new String[] { "say", "admit", "agree", "decide", "deny", "explain", "insist", "promise", "recommend", "suggest", "point", "think", "believe", "hope", "fear", "suppose", });
	/**  BCN  */
	WordList list_controlnouns = new WordList(new String[] { "desire", "order", "need", "right", "duty", "failure", "power", "wish", "capacity", "ability", "hope", "chance", "honour", "compulsion", "responsibility", "opportunity", "idea", "record", "way", "attempt", "obligation", "impulse", "surprise", "will", "mean", });
	/** potser s'hauria de canviar categoria i posar com a determinants  */
	WordList list_tractaments = new WordList(new String[] { "Mr.", "Mrs.", "Ms.", "Dr.", });
	WordList list_days = new WordList(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", });
	WordList list_adv_neg = new WordList(new String[] { "not", "never", });
	WordList list_verbs_modals = new WordList(new String[] { "can", "must", "should", "may", "might", });
	WordList list_numeros25 = new WordList(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", });
	
	private void macro_elimina_GDND(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_elimina_GDND",  word1); } 
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			word1.tlSet(attr_nbr, "<sg>");
		}
	}
	
	private void macro_posa_GDND(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_posa_GDND",  word1); } 
		/** per a posar valors de GD i ND en adjectius i determinants, que venen del bilingüe sense cap valor i per tant és impossible fer-hi cap operació ni canvi  */
		if (word1.tl(attr_gen).equals(""))
		{
			var_paraula1 = word1.tl(attr_lemh);
			var_paraula1 = var_paraula1
			    +word1.tl(attr_tags)
			    +"<GD>"
			    +"<ND>"
			    +word1.tl(attr_lemq)
			    ;
			word1.tlSet(attr_whole, var_paraula1);
		}
		else
		if (word1.tl(attr_nbr).equals(""))
		{
			var_paraula1 = word1.tl(attr_lemh);
			var_paraula1 = var_paraula1
			    +word1.tl(attr_tags)
			    +"<ND>"
			    +word1.tl(attr_lemq)
			    ;
			word1.tlSet(attr_whole, var_paraula1);
		}
	}
	
	private void macro_genere_nombre(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_genere_nombre",  word1); } 
		if (word1.tl(attr_gen).equals("<f>"))
		{
			var_genere = "<f>";
		}
		else
		{
			var_genere = "<m>";
		}
		if (word1.tl(attr_nbr).equals("<pl>"))
		{
			var_nombre = "<pl>";
		}
		else
		{
			var_nombre = "<sg>";
		}
	}
	
	private void macro_f_concord2(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_f_concord2",  word1, blank1,  word2); } 
		/** 1 = main parameter (typically noun); 2 = secondary parameter (typically adj or det)  */
		var_gen_chunk = "";
		var_nbr_chunk = "";
		/** posa GD i ND a la paraula si no té valor per a gènere o per a nombre (excepte números)  */
		if (word2.tl(attr_a_num).equals(""))
		{
			/** si no te valor per a gènere i , per tant, tampoc per a nombre:  */
			if (word2.tl(attr_gen).equals(""))
			{
				var_paraula1 = word2.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word2.tl(attr_tags)
				    +"<GD>"
				    +"<ND>"
				    +word2.tl(attr_lemq)
				    ;
				word2.tlSet(attr_whole, var_paraula1);
			}
			else
			if (word2.tl(attr_nbr).equals(""))
			{
				var_paraula1 = word2.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word2.tl(attr_tags)
				    +"<ND>"
				    +word2.tl(attr_lemq)
				    ;
				word2.tlSet(attr_whole, var_paraula1);
			}
		}
		/** OPERACIONS DE GÈNERE  */
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				var_gen_chunk = "<GD>";
			}
			else
			if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("")))
			{
				word2.tlSet(attr_gen, word1.tl(attr_gen));
				var_gen_chunk = word1.tl(attr_gen);
			}
			else
			{
				var_gen_chunk = "<GD>";
			}
		}
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			var_gen_chunk = "<GD>";
		}
		else
		if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("")))
		{
			var_gen_chunk = word1.tl(attr_gen);
		}
		else
		{
			if (!word2.tl(attr_gen).equals("<GD>"))
			{
				var_gen_chunk = word1.tl(attr_gen);
			}
		}
		/** OPERACIONS DE NOMBRE  */
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				var_nbr_chunk = "<ND>";
			}
			else
			if (!(word1.tl(attr_nbr).equals("<sp>")
    || word1.tl(attr_nbr).equals("")))
			{
				word2.tlSet(attr_nbr, word1.tl(attr_nbr));
				var_nbr_chunk = word1.tl(attr_nbr);
			}
			else
			{
				var_nbr_chunk = "<ND>";
			}
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			var_nbr_chunk = "<ND>";
		}
		else
		if (!(word1.tl(attr_nbr).equals("<sp>")
    || word1.tl(attr_nbr).equals("")))
		{
			var_nbr_chunk = word1.tl(attr_nbr);
		}
		else
		{
			if ((word2.tl(attr_nbr).equals("<sg>")
    || word2.tl(attr_nbr).equals("<pl>")))
			{
				var_nbr_chunk = word2.tl(attr_nbr);
			}
			else
			if (word2.tl(attr_nbr).equals("<sp>"))
			{
				var_nbr_chunk = word1.tl(attr_nbr);
			}
			else
			if (word2.tl(attr_nbr).equals(""))
			{
				var_nbr_chunk = word1.tl(attr_nbr);
			}
		}
	}
	
	private void macro_f_concord3(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("macro_f_concord3",  word1, blank1,  word2, blank2,  word3); } 
		/** 1 = main parameter (typically noun); 2  = secondary parameter (typically adj or det). 3 = other secondary param. (typically det)  */
		var_gen_chunk = "";
		var_nbr_chunk = "";
		/** posa GD i ND a la paraula si no té valor per a gènere o per a nombre (excepte números)  */
		if (word2.tl(attr_a_num).equals(""))
		{
			if (word2.tl(attr_gen).equals(""))
			{
				var_paraula1 = word2.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word2.tl(attr_tags)
				    +"<GD>"
				    +"<ND>"
				    +word2.tl(attr_lemq)
				    ;
				word2.tlSet(attr_whole, var_paraula1);
			}
			else
			if (word2.tl(attr_nbr).equals(""))
			{
				var_paraula1 = word2.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word2.tl(attr_tags)
				    +"<ND>"
				    +word2.tl(attr_lemq)
				    ;
				word2.tlSet(attr_whole, var_paraula1);
			}
		}
		/** posa GD i ND a la paraula si no té valor per a gènere o per a nombre (excepte números)  */
		if (word3.tl(attr_a_num).equals(""))
		{
			if (word3.tl(attr_gen).equals(""))
			{
				var_paraula1 = word3.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word3.tl(attr_tags)
				    +"<GD>"
				    +"<ND>"
				    +word3.tl(attr_lemq)
				    ;
				word3.tlSet(attr_whole, var_paraula1);
			}
			else
			if (word3.tl(attr_nbr).equals(""))
			{
				var_paraula1 = word3.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word3.tl(attr_tags)
				    +"<ND>"
				    +word3.tl(attr_lemq)
				    ;
				word3.tlSet(attr_whole, var_paraula1);
			}
		}
		/** OPERACIONS DE GÈNERE  */
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				var_gen_chunk = "<GD>";
			}
			else
			if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("")))
			{
				word2.tlSet(attr_gen, word1.tl(attr_gen));
				var_gen_chunk = word1.tl(attr_gen);
			}
			else
			{
				var_gen_chunk = "<GD>";
			}
		}
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			var_gen_chunk = "<GD>";
		}
		else
		if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("")))
		{
			var_gen_chunk = word1.tl(attr_gen);
		}
		else
		{
			if ((!word2.tl(attr_gen).equals("<GD>")
    && !word3.tl(attr_gen).equals("<GD>")))
			{
				var_gen_chunk = word1.tl(attr_gen);
			}
		}
		/** i aquí les operacions per a posició 3.  */
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			if (!var_gen_chunk.equals(""))
			{
				word3.tlSet(attr_gen, var_gen_chunk);
			}
			else
			{
				var_gen_chunk = "<GD>";
			}
		}
		/** OPERACIONS DE NOMBRE  */
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				var_nbr_chunk = "<ND>";
			}
			else
			if (!(word1.tl(attr_nbr).equals("<sp>")
    || word1.tl(attr_nbr).equals("")))
			{
				word2.tlSet(attr_nbr, word1.tl(attr_nbr));
				var_nbr_chunk = word1.tl(attr_nbr);
			}
			else
			{
				var_nbr_chunk = "<ND>";
			}
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			var_nbr_chunk = "<ND>";
		}
		else
		if (!(word1.tl(attr_nbr).equals("<sp>")
    || word1.tl(attr_nbr).equals("")))
		{
			var_nbr_chunk = word1.tl(attr_nbr);
		}
		else
		{
			if ((word2.tl(attr_nbr).equals("<sg>")
    || word2.tl(attr_nbr).equals("<pl>")))
			{
				var_nbr_chunk = word2.tl(attr_nbr);
			}
			else
			if (word2.tl(attr_nbr).equals("<sp>"))
			{
				/** si pos 3 no és sp o ND, assigna gènere de pos 3 al chunk */
				if ((word3.tl(attr_nbr).equals("<sg>")
    || word3.tl(attr_nbr).equals("<pl>")))
				{
					var_nbr_chunk = word3.tl(attr_nbr);
				}
			}
			else
			if (word2.tl(attr_nbr).equals(""))
			{
				if ((word3.tl(attr_nbr).equals("<sg>")
    || word3.tl(attr_nbr).equals("<pl>")))
				{
					var_nbr_chunk = word3.tl(attr_nbr);
				}
				else
				{
					var_nbr_chunk = word1.tl(attr_nbr);
				}
			}
		}
		/** i aquí les operacions per a posició 3.  */
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			if (!var_nbr_chunk.equals(""))
			{
				word3.tlSet(attr_nbr, var_nbr_chunk);
			}
			else
			{
				var_nbr_chunk = "<ND>";
			}
		}
	}
	
	private void macro_f_concord4(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("macro_f_concord4",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		/** 1 = main parameter (typically noun); 2 = secondary parameter (typically adj); 3 and 4 = other secondary param. (typically det)  */
		var_gen_chunk = "";
		var_nbr_chunk = "";
		/** posa GD i ND a la paraula si no té valor per a gènere o per a nombre (excepte números)  */
		if (word2.tl(attr_a_num).equals(""))
		{
			if (word2.tl(attr_gen).equals(""))
			{
				var_paraula1 = word2.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word2.tl(attr_tags)
				    +"<GD>"
				    +"<ND>"
				    +word2.tl(attr_lemq)
				    ;
				word2.tlSet(attr_whole, var_paraula1);
			}
			else
			if (word2.tl(attr_nbr).equals(""))
			{
				var_paraula1 = word2.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word2.tl(attr_tags)
				    +"<ND>"
				    +word2.tl(attr_lemq)
				    ;
				word2.tlSet(attr_whole, var_paraula1);
			}
		}
		/** posa GD i ND a la paraula si no té valor per a gènere o per a nombre (excepte números)  */
		if (word3.tl(attr_a_num).equals(""))
		{
			if (word3.tl(attr_gen).equals(""))
			{
				var_paraula1 = word3.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word3.tl(attr_tags)
				    +"<GD>"
				    +"<ND>"
				    +word3.tl(attr_lemq)
				    ;
				word3.tlSet(attr_whole, var_paraula1);
			}
			else
			if (word3.tl(attr_nbr).equals(""))
			{
				var_paraula1 = word3.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word3.tl(attr_tags)
				    +"<ND>"
				    +word3.tl(attr_lemq)
				    ;
				word3.tlSet(attr_whole, var_paraula1);
			}
		}
		/** posa GD i ND a la paraula si no té valor per a gènere o per a nombre (excepte números)  */
		if (word4.tl(attr_a_num).equals(""))
		{
			if (word4.tl(attr_gen).equals(""))
			{
				var_paraula1 = word4.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word4.tl(attr_tags)
				    +"<GD>"
				    +"<ND>"
				    +word4.tl(attr_lemq)
				    ;
				word4.tlSet(attr_whole, var_paraula1);
			}
			else
			if (word4.tl(attr_nbr).equals(""))
			{
				var_paraula1 = word4.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word4.tl(attr_tags)
				    +"<ND>"
				    +word4.tl(attr_lemq)
				    ;
				word4.tlSet(attr_whole, var_paraula1);
			}
		}
		/** OPERACIONS DE GÈNERE  */
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				var_gen_chunk = "<GD>";
			}
			else
			if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("")))
			{
				word2.tlSet(attr_gen, word1.tl(attr_gen));
				var_gen_chunk = word1.tl(attr_gen);
			}
			else
			{
				var_gen_chunk = "<GD>";
			}
		}
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			var_gen_chunk = "<GD>";
		}
		else
		if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("")))
		{
			var_gen_chunk = word1.tl(attr_gen);
		}
		else
		{
			if ((!word2.tl(attr_gen).equals("<GD>")
    && !word3.tl(attr_gen).equals("<GD>")
    && !word4.tl(attr_gen).equals("<GD>")))
			{
				var_gen_chunk = word1.tl(attr_gen);
			}
		}
		/** i aquí les operacions per a posició 3  */
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			if (!var_gen_chunk.equals(""))
			{
				word3.tlSet(attr_gen, var_gen_chunk);
			}
			else
			{
				var_gen_chunk = "<GD>";
			}
		}
		/** i aquí les operacions per a posició 4  */
		if (word4.tl(attr_gen).equals("<GD>"))
		{
			if (!var_gen_chunk.equals(""))
			{
				word4.tlSet(attr_gen, var_gen_chunk);
			}
			else
			{
				var_gen_chunk = "<GD>";
			}
		}
		/** OPERACIONS DE NOMBRE  */
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				var_nbr_chunk = "<ND>";
			}
			else
			if (!(word1.tl(attr_nbr).equals("<sp>")
    || word1.tl(attr_nbr).equals("")))
			{
				word2.tlSet(attr_nbr, word1.tl(attr_nbr));
				var_nbr_chunk = word1.tl(attr_nbr);
			}
			else
			{
				var_nbr_chunk = "<ND>";
			}
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			var_nbr_chunk = "<ND>";
		}
		else
		if (!(word1.tl(attr_nbr).equals("<sp>")
    || word1.tl(attr_nbr).equals("")))
		{
			var_nbr_chunk = word1.tl(attr_nbr);
		}
		else
		{
			if ((word2.tl(attr_nbr).equals("<sg>")
    || word2.tl(attr_nbr).equals("<pl>")))
			{
				var_nbr_chunk = word2.tl(attr_nbr);
			}
			else
			if (word2.tl(attr_nbr).equals("<sp>"))
			{
				/** si pos 3 no és sp o ND, assigna gènere de pos 3 al chunk */
				if ((word3.tl(attr_nbr).equals("<sg>")
    || word3.tl(attr_nbr).equals("<pl>")))
				{
					var_nbr_chunk = word3.tl(attr_nbr);
				}
				else
				if (word3.tl(attr_nbr).equals("<sp>"))
				{
					/** si pos 4 no és sp o ND, assigna gènere de pos 4 al chunk */
					if ((word4.tl(attr_nbr).equals("<sg>")
    || word4.tl(attr_nbr).equals("<pl>")))
					{
						var_nbr_chunk = word4.tl(attr_nbr);
					}
				}
			}
			else
			if (word2.tl(attr_nbr).equals(""))
			{
				if ((word3.tl(attr_nbr).equals("<sg>")
    || word3.tl(attr_nbr).equals("<pl>")))
				{
					var_nbr_chunk = word3.tl(attr_nbr);
				}
				else
				if ((word4.tl(attr_nbr).equals("<sg>")
    || word4.tl(attr_nbr).equals("<pl>")))
				{
					var_nbr_chunk = word4.tl(attr_nbr);
				}
				else
				{
					var_nbr_chunk = word1.tl(attr_nbr);
				}
			}
		}
		/** i aquí les operacions per a posició 3.  */
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			if (!var_nbr_chunk.equals(""))
			{
				word3.tlSet(attr_nbr, var_nbr_chunk);
			}
			else
			{
				var_nbr_chunk = "<ND>";
			}
		}
		/** i aquí les operacions per a posició 4.  */
		if (word4.tl(attr_nbr).equals("<ND>"))
		{
			if (!var_nbr_chunk.equals(""))
			{
				word4.tlSet(attr_nbr, var_nbr_chunk);
			}
			else
			{
				var_nbr_chunk = "<ND>";
			}
		}
	}
	
	private void macro_f_concord5(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("macro_f_concord5",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		/** 1 = main parameter (typically noun); 2 = secondary parameter (typically adj); 3 , 4 and 5 = other secondary param. (typically det)  */
		var_gen_chunk = "";
		var_nbr_chunk = "";
		/** PRIMER ASSIGNEM VALORS DE GD I ND SI CAL A LES POSICIONES SECUNDÀRIES  */
		/** posa GD i ND a la paraula si no té valor per a gènere o per a nombre (excepte números)  */
		if (word2.tl(attr_a_num).equals(""))
		{
			if (word2.tl(attr_gen).equals(""))
			{
				var_paraula1 = word2.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word2.tl(attr_tags)
				    +"<GD>"
				    +"<ND>"
				    +word2.tl(attr_lemq)
				    ;
				word2.tlSet(attr_whole, var_paraula1);
			}
			else
			if (word2.tl(attr_nbr).equals(""))
			{
				var_paraula1 = word2.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word2.tl(attr_tags)
				    +"<ND>"
				    +word2.tl(attr_lemq)
				    ;
				word2.tlSet(attr_whole, var_paraula1);
			}
		}
		/** posa GD i ND a la paraula si no té valor per a gènere o per a nombre (excepte números)  */
		if (word3.tl(attr_a_num).equals(""))
		{
			if (word3.tl(attr_gen).equals(""))
			{
				var_paraula1 = word3.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word3.tl(attr_tags)
				    +"<GD>"
				    +"<ND>"
				    +word3.tl(attr_lemq)
				    ;
				word3.tlSet(attr_whole, var_paraula1);
			}
			else
			if (word3.tl(attr_nbr).equals(""))
			{
				var_paraula1 = word3.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word3.tl(attr_tags)
				    +"<ND>"
				    +word3.tl(attr_lemq)
				    ;
				word3.tlSet(attr_whole, var_paraula1);
			}
		}
		/** posa GD i ND a la paraula si no té valor per a gènere o per a nombre (excepte números)  */
		if (word4.tl(attr_a_num).equals(""))
		{
			if (word4.tl(attr_gen).equals(""))
			{
				var_paraula1 = word4.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word4.tl(attr_tags)
				    +"<GD>"
				    +"<ND>"
				    +word4.tl(attr_lemq)
				    ;
				word4.tlSet(attr_whole, var_paraula1);
			}
			else
			if (word4.tl(attr_nbr).equals(""))
			{
				var_paraula1 = word4.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word4.tl(attr_tags)
				    +"<ND>"
				    +word4.tl(attr_lemq)
				    ;
				word4.tlSet(attr_whole, var_paraula1);
			}
		}
		/** posa GD i ND a la paraula si no té valor per a gènere o per a nombre (excepte números)  */
		if (word5.tl(attr_a_num).equals(""))
		{
			if (word5.tl(attr_gen).equals(""))
			{
				var_paraula1 = word5.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word5.tl(attr_tags)
				    +"<GD>"
				    +"<ND>"
				    +word5.tl(attr_lemq)
				    ;
				word5.tlSet(attr_whole, var_paraula1);
			}
			else
			if (word5.tl(attr_nbr).equals(""))
			{
				var_paraula1 = word5.tl(attr_lemh);
				var_paraula1 = var_paraula1
				    +word5.tl(attr_tags)
				    +"<ND>"
				    +word5.tl(attr_lemq)
				    ;
				word5.tlSet(attr_whole, var_paraula1);
			}
		}
		/** OPERACIONS DE GÈNERE  */
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			if (word1.tl(attr_gen).equals("<GD>"))
			{
				var_gen_chunk = "<GD>";
			}
			else
			if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("")))
			{
				word2.tlSet(attr_gen, word1.tl(attr_gen));
				var_gen_chunk = word1.tl(attr_gen);
			}
			else
			{
				var_gen_chunk = "<GD>";
			}
		}
		if (word1.tl(attr_gen).equals("<GD>"))
		{
			var_gen_chunk = "<GD>";
		}
		else
		if (!(word1.tl(attr_gen).equals("<mf>")
    || word1.tl(attr_gen).equals("")))
		{
			var_gen_chunk = word1.tl(attr_gen);
		}
		else
		{
			if ((!word2.tl(attr_gen).equals("<GD>")
    && !word3.tl(attr_gen).equals("<GD>")
    && !word4.tl(attr_gen).equals("<GD>")
    && !word5.tl(attr_gen).equals("<GD>")))
			{
				var_gen_chunk = word1.tl(attr_gen);
			}
		}
		/** i aquí les operacions per a posició 3  */
		if (word3.tl(attr_gen).equals("<GD>"))
		{
			if (!var_gen_chunk.equals(""))
			{
				word3.tlSet(attr_gen, var_gen_chunk);
			}
			else
			{
				var_gen_chunk = "<GD>";
			}
		}
		/** i aquí les operacions per a posició 4  */
		if (word4.tl(attr_gen).equals("<GD>"))
		{
			if (!var_gen_chunk.equals(""))
			{
				word4.tlSet(attr_gen, var_gen_chunk);
			}
			else
			{
				var_gen_chunk = "<GD>";
			}
		}
		/** i aquí les operacions per a posició 5  */
		if (word5.tl(attr_gen).equals("<GD>"))
		{
			if (!var_gen_chunk.equals(""))
			{
				word5.tlSet(attr_gen, var_gen_chunk);
			}
			else
			{
				var_gen_chunk = "<GD>";
			}
		}
		/** OPERACIONS DE NOMBRE  */
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			if (word1.tl(attr_nbr).equals("<ND>"))
			{
				var_nbr_chunk = "<ND>";
			}
			else
			if (!(word1.tl(attr_nbr).equals("<sp>")
    || word1.tl(attr_nbr).equals("")))
			{
				word2.tlSet(attr_nbr, word1.tl(attr_nbr));
				var_nbr_chunk = word1.tl(attr_nbr);
			}
			else
			{
				var_nbr_chunk = "<ND>";
			}
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			var_nbr_chunk = "<ND>";
		}
		else
		if (!(word1.tl(attr_nbr).equals("<sp>")
    || word1.tl(attr_nbr).equals("")))
		{
			var_nbr_chunk = word1.tl(attr_nbr);
		}
		else
		{
			if ((word2.tl(attr_nbr).equals("<sg>")
    || word2.tl(attr_nbr).equals("<pl>")))
			{
				var_nbr_chunk = word2.tl(attr_nbr);
			}
			else
			if (word2.tl(attr_nbr).equals("<sp>"))
			{
				/** si pos 3 no és sp o ND, assigna gènere de pos 3 al chunk */
				if ((word3.tl(attr_nbr).equals("<sg>")
    || word3.tl(attr_nbr).equals("<pl>")))
				{
					var_nbr_chunk = word3.tl(attr_nbr);
				}
				else
				if (word3.tl(attr_nbr).equals("<sp>"))
				{
					/** si pos 4 no és sp o ND, assigna gènere de pos 4 al chunk */
					if ((word4.tl(attr_nbr).equals("<sg>")
    || word4.tl(attr_nbr).equals("<pl>")))
					{
						var_nbr_chunk = word4.tl(attr_nbr);
					}
					else
					if (word4.tl(attr_nbr).equals("<sp>"))
					{
						/** si pos 5 no és sp o ND, assigna gènere de pos 5 al chunk */
						if ((word5.tl(attr_nbr).equals("<sg>")
    || word5.tl(attr_nbr).equals("<pl>")))
						{
							var_nbr_chunk = word5.tl(attr_nbr);
						}
					}
				}
			}
			else
			if (word2.tl(attr_nbr).equals(""))
			{
				if ((word3.tl(attr_nbr).equals("<sg>")
    || word3.tl(attr_nbr).equals("<pl>")))
				{
					var_nbr_chunk = word3.tl(attr_nbr);
				}
				else
				if ((word4.tl(attr_nbr).equals("<sg>")
    || word4.tl(attr_nbr).equals("<pl>")))
				{
					var_nbr_chunk = word4.tl(attr_nbr);
				}
				else
				if ((word5.tl(attr_nbr).equals("<sg>")
    || word5.tl(attr_nbr).equals("<pl>")))
				{
					var_nbr_chunk = word5.tl(attr_nbr);
				}
				else
				{
					var_nbr_chunk = word1.tl(attr_nbr);
				}
			}
		}
		/** i aquí les operacions per a posició 3.  */
		if (word3.tl(attr_nbr).equals("<ND>"))
		{
			if (!var_nbr_chunk.equals(""))
			{
				word3.tlSet(attr_nbr, var_nbr_chunk);
			}
			else
			{
				var_nbr_chunk = "<ND>";
			}
		}
		/** i aquí les operacions per a posició 4.  */
		if (word4.tl(attr_nbr).equals("<ND>"))
		{
			if (!var_nbr_chunk.equals(""))
			{
				word4.tlSet(attr_nbr, var_nbr_chunk);
			}
			else
			{
				var_nbr_chunk = "<ND>";
			}
		}
		/** i aquí les operacions per a posició 5.  */
		if (word5.tl(attr_nbr).equals("<ND>"))
		{
			if (!var_nbr_chunk.equals(""))
			{
				word5.tlSet(attr_nbr, var_nbr_chunk);
			}
			else
			{
				var_nbr_chunk = "<ND>";
			}
		}
	}
	
	private void macro_f_bcond(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_f_bcond",  word1, blank1,  word2); } 
		/** Per mirar si el blanc conté o no format. Cal posar aquesta funció en les regles en què desaparegui alguna paraula, per tal de decidir si el blanc de la paraula eliminada s'ha d'eliminar o conservar. Si conté format cal conservar-la, si no en conté cal eliminar-la perquè no apareguin dos espais seguits.  */
		if (!blank1.equals(" "))
		{
			out.append(blank1);
		}
	}
	
	private void macro_million(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_million",  word1); } 
		if (word1.tl(attr_lem).equalsIgnoreCase("milió"))
		{
			word1.tlSet(attr_lem, "milió de");
		}
		else
		if (word1.tl(attr_lem).equalsIgnoreCase("un milió"))
		{
			word1.tlSet(attr_lem, "un milió de");
		}
		if (word1.tl(attr_lem).equalsIgnoreCase("bilió"))
		{
			word1.tlSet(attr_lem, "bilió de");
		}
		else
		if (word1.tl(attr_lem).equalsIgnoreCase("un bilió"))
		{
			word1.tlSet(attr_lem, "un bilió de");
		}
	}
	
	private void macro_flexio_numerals(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_flexio_numerals",  word1, blank1,  word2); } 
		/**   <choose>
	<when>
	  <test>
	    <equal>
	      <clip pos="1" side="tl" part="gen"/>
	      <lit-tag v="GD"/>
	    </equal>
	  </test>	
	  <let>
	    <clip pos="1" side="tl" part="gen"/>
	    <clip pos="2" side="tl" part="gen"/>
	  </let>
	</when>
      </choose>  */
		if (word2.sl(attr_lem).equals("percent"))
		{
			word2.tlSet(attr_lem, "per cent");
			word2.tlSet(attr_gen, "<GD>");
			word2.tlSet(attr_nbr, "<pl>");
		}
	}
	
	private void macro_det_no(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_det_no",  word1, blank1,  word2); } 
		/** No cars -> cap cotxe (canvia nombre del nom de pl a sg)  */
		if ((word1.sl(attr_lem).equalsIgnoreCase("no")
    && word2.sl(attr_nbr).equals("<pl>")))
		{
			word2.tlSet(attr_nbr, "<sg>");
			var_negative = "<negacio>";
		}
		else
		if ((word1.sl(attr_lem).equalsIgnoreCase("no")
    && word2.sl(attr_nbr).equals("<sg>")))
		{
			var_negative = "<negacio>";
		}
		else
		{
			var_negative = "";
		}
	}
	
	private void macro_determiner(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_determiner",  word1); } 
		/**  to put in rules beginning with a determiner  */
		if (word1.tl(attr_a_det).equals("<det><ord>"))
		{
			var_tipus_det = "<UNDET>";
		}
		else
		if (word1.tl(attr_a_det).equals("<det><qnt>"))
		{
			var_tipus_det = "<UNDEF>";
		}
		else
		{
			var_tipus_det = "<DET>";
		}
	}
	
	private void macro_comparatiu_adj1(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_comparatiu_adj1",  word1); } 
		/** per a afegir adverbi 'més' en adjs comparatius.  */
		var_adjectiu1 = "";
		if ((word1.sl(attr_grau_adj).equals("<comp>")
    || word1.sl(attr_grau_adj).equals("<sup>")))
		{
			if (!(word1.sl(attr_lem).equalsIgnoreCase("good")
    || word1.sl(attr_lem).equalsIgnoreCase("bad")))
			{
				var_adjectiu1 = var_adjectiu1
				    +"més"
				    +"<preadv>"
				    +"$ ^"
				    ;
			}
		}
		else
		{
			var_adjectiu1 = var_adjectiu1
			    +""
			    ;
		}
	}
	
	private void macro_comparatiu_adj2(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_comparatiu_adj2",  word1); } 
		/** per a afegir adverbi 'més' en adjs comparatius. Per a regles amb 2 adjectius.  */
		var_adjectiu2 = "";
		if ((word1.sl(attr_grau_adj).equals("<comp>")
    || word1.sl(attr_grau_adj).equals("<sup>")))
		{
			if (!(word1.sl(attr_lem).equalsIgnoreCase("good")
    || word1.sl(attr_lem).equalsIgnoreCase("bad")))
			{
				var_adjectiu2 = var_adjectiu2
				    +"més"
				    +"<preadv>"
				    +"$ ^"
				    ;
			}
		}
		else
		{
			var_adjectiu2 = var_adjectiu2
			    +""
			    ;
		}
	}
	
	private void macro_firstWord(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_firstWord",  word1); } 
		if (word1.sl(attr_a_np_acr).equals(""))
		{
			if (var_EOS.equals("true"))
			{
				word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
				var_caseFirstWord = "Aa";
			}
			else
			{
				var_caseFirstWord = "aa";
			}
		}
		else
		{
			var_caseFirstWord = "aa";
		}
		var_EOS = "false";
	}
	
	private void macro_tipus_verbs(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_tipus_verbs",  word1); } 
		if (word1.tl(attr_a_verb).equals("<vblex><pron>"))
		{
			var_tipus_verb = "<pron>";
		}
		else
		if ((word1.sl(attr_lemh).equalsIgnoreCase("like")
    || word1.tl(attr_lemh).equalsIgnoreCase("encantar")
    || word1.sl(attr_lem).equalsIgnoreCase("be# afraid of")))
		{
			var_tipus_verb = "<like>";
		}
		else
		if ((word1.sl(attr_lem).equalsIgnoreCase("be# sorry")
    || word1.sl(attr_lem).equalsIgnoreCase("be# very sorry")))
		{
			var_tipus_verb = "<sorry>";
		}
		else
		if (list_reportingverb.containsIgnoreCase(word1.sl(attr_lemh)))
		{
			var_tipus_verb = "<reporting>";
		}
		else
		{
			var_tipus_verb = word1.tl(attr_a_verb);
		}
	}
	
	private void macro_tipus_verbs_imp(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_tipus_verbs_imp",  word1); } 
		/** per quan hi ha un verb en forma impersonal en una regla (el pronom no serà proclític sinó enclític: dir-se, convertint-se/me... etc  */
		if (word1.tl(attr_a_verb).equals("<vblex><pron>"))
		{
			var_tipus_verb_imp = "<pron>";
		}
		else
		if ((word1.sl(attr_lemh).equalsIgnoreCase("like")
    || word1.tl(attr_lemh).equalsIgnoreCase("encantar")
    || word1.sl(attr_lem).equalsIgnoreCase("be# afraid of")))
		{
			var_tipus_verb_imp = "<like>";
		}
		else
		if (list_reportingverb.containsIgnoreCase(word1.sl(attr_lemh)))
		{
			var_tipus_verb_imp = "<reporting>";
		}
		else
		{
			var_tipus_verb_imp = word1.tl(attr_a_verb);
		}
	}
	
	private void macro_pron(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_pron",  word1); } 
		/** Aquesta macro s'ha d'aplicar, en les regles, després de la macro tipus_verbs. Asigna a la variable 'pronom' el valor del pronom que han de dur els verbs pronominals  */
		var_pronom = "";
		/** envia el pronom en els verbs pronominals  */
		if (var_tipus_verb.equals("<pron>"))
		{
			var_pronom = "prpers";
			var_pronom = var_pronom
			    +"<prn><pro>"
			    +"<4>"
			    +"<mf>"
			    +"<5>"
			    +"$ ^"
			    ;
		}
	}
	
	private void macro_pronenc(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_pronenc",  word1); } 
		/**  fa el mateix que la funció 'pron' però crea un enclític reflexiu (per a verbs en formes no personals), que asigna a la variable 'pronomenc'. Funciona només si abans s'ha cridat la macro 'tipus_verbs_imp' per al verb que ha de portar l'enclític. 
No es crea mlu, per a poder fer canvis de posició en el t3x. En el t3x es crea la mlu i es canvia el pronom de 3a persona a reflexiu si toca.  */
		var_pronomenc = "";
		/** envia el pronom en els verbs pronominals  */
		if (var_tipus_verb_imp.equals("<pron>"))
		{
			var_pronomenc = "$^prpers";
			var_pronomenc = var_pronomenc
			    +"<prn><enc>"
			    +"<4>"
			    +"<mf>"
			    +"<5>"
			    ;
		}
	}
	
	private void macro_conj_verb1(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_conj_verb1",  word1); } 
		/** conjuga un verb Primera part: si aquest verb és un verb modal  */
		if (list_verbs_modals.containsIgnoreCase(word1.sl(attr_lem)))
		{
			if ((word1.sl(attr_lem).equalsIgnoreCase("can")
    && word1.sl(attr_temps).equals("<pres>")))
			{
				var_temps_chunk = "<pri>";
			}
			else
			if ((word1.sl(attr_lem).equalsIgnoreCase("can")
    && word1.sl(attr_temps).equals("<past>")))
			{
				var_temps_chunk = "<cni>";
			}
			else
			if ((word1.sl(attr_lem).equalsIgnoreCase("must")
    || word1.sl(attr_lem).equalsIgnoreCase("may")))
			{
				var_temps_chunk = "<pri>";
			}
			else
			if ((word1.sl(attr_lem).equalsIgnoreCase("should")
    || word1.sl(attr_lem).equalsIgnoreCase("might")))
			{
				var_temps_chunk = "<cni>";
			}
			var_lema_SV = "mod";
			var_pers_chunk = "<PD>";
			var_nbr_chunk = "<ND>";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
		}
		/**  Segona part: la resta de casos, o sigui, tots els altres verbs   */
		else
		{
			if ((word1.sl(attr_temps).equals("<past>")
    && word1.sl(attr_pers).equals("")
    && word1.sl(attr_nbr).equals("")))
			{
				var_lema_SV = "verbcj_perif";
				var_temps_chunk = "<ifip>";
				var_pers_chunk = "<PD>";
				var_nbr_chunk = "<ND>";
				var_verbfinal = (""+"anar"+"<vaux>"+"<4>"+"<5>"+"$ ^"+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<inf>"+word1.tl(attr_lemq));
			}
			else
			if ((word1.sl(attr_temps).equals("<past>")
    && word1.sl(attr_nbr).equals("<sg>")))
			{
				var_lema_SV = "verbcj_perif";
				var_temps_chunk = "<ifip>";
				var_pers_chunk = "<PD>";
				var_nbr_chunk = word1.tl(attr_nbr);
				var_verbfinal = (""+"anar"+"<vaux>"+"<4>"+"<5>"+"$ ^"+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<inf>"+word1.tl(attr_lemq));
			}
			else
			if (word1.sl(attr_temps).equals("<pres>"))
			{
				word1.tlSet(attr_temps, "<pri>");
				var_lema_SV = "verbcj";
				var_temps_chunk = word1.tl(attr_temps);
				var_pers_chunk = "<PD>";
				var_nbr_chunk = "<ND>";
				var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
			}
			else
			if (word1.sl(attr_temps).equals("<pri>"))
			{
				var_lema_SV = "verbcj";
				var_temps_chunk = word1.tl(attr_temps);
				var_pers_chunk = word1.tl(attr_pers);
				var_nbr_chunk = word1.tl(attr_nbr);
				var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
			}
			else
			if (word1.sl(attr_temps).equals("<ger>"))
			{
				var_lema_SV = "ger";
				var_temps_chunk = word1.tl(attr_temps);
				var_pers_chunk = "<PD>";
				var_nbr_chunk = "<ND>";
				var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+word1.tl(attr_lemq));
			}
			else
			if (word1.sl(attr_temps).equals("<inf>"))
			{
				var_lema_SV = "inf";
				var_temps_chunk = word1.tl(attr_temps);
				var_pers_chunk = "<PD>";
				var_nbr_chunk = "<ND>";
				var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+word1.tl(attr_lemq));
			}
		}
	}
	
	private void macro_conj_verb_compost(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_conj_verb_compost",  word1, blank1,  word2); } 
		/** conjuga un verb format per un auxiliar i una forma no personal (will come). 
pos 1= do, will, shall o would.
pos 2= verb no conjugat
El resultat és una sola forma lèxica (vindré) (excepte en el cas 'I did come' - 'vaig venir', que es fa en forma perifràstica)  */
		if (word1.sl(attr_lem).equalsIgnoreCase("do"))
		{
			if (word1.sl(attr_temps).equals("<pri>"))
			{
				var_temps_chunk = "<pri>";
				var_pers_chunk = word1.sl(attr_pers);
				var_nbr_chunk = word1.sl(attr_nbr);
				var_lema_SV = "verbcj";
				var_verbfinal = (""+word2.tl(attr_lemh)+word2.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word2.tl(attr_lemq));
			}
			else
			if ((word1.sl(attr_temps).equals("<pres>")
    || word1.sl(attr_temps).equals("<inf>")))
			{
				var_temps_chunk = "<pri>";
				var_pers_chunk = "<PD>";
				var_nbr_chunk = "<ND>";
				var_lema_SV = "verbcj";
				var_verbfinal = (""+word2.tl(attr_lemh)+word2.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word2.tl(attr_lemq));
			}
			else
			if (word1.sl(attr_temps).equals("<past>"))
			{
				var_lema_SV = "verbcj_perif";
				var_temps_chunk = "<ifip>";
				var_pers_chunk = "<PD>";
				var_nbr_chunk = "<ND>";
				var_verbfinal = (""+"anar"+"<vaux>"+"<4>"+"<5>"+"$ ^"+word2.tl(attr_lemh)+word2.tl(attr_a_verb)+"<inf>"+word2.tl(attr_lemq));
			}
		}
		else
		{
			if ((word1.sl(attr_lem).equalsIgnoreCase("will")
    || word1.sl(attr_lem).equalsIgnoreCase("shall")))
			{
				var_temps_chunk = "<fti>";
			}
			else
			if (word1.sl(attr_lem).equalsIgnoreCase("would"))
			{
				var_temps_chunk = "<cni>";
			}
			var_pers_chunk = "<PD>";
			var_nbr_chunk = "<ND>";
			var_lema_SV = "verbcj";
			var_verbfinal = (""+word2.tl(attr_lemh)+word2.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word2.tl(attr_lemq));
		}
	}
	
	private void macro_conj_be_ger(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_conj_be_ger",  word1, blank1,  word2); } 
		var_gen_chunk = "";
		if (word1.sl(attr_temps).equals("<pp>"))
		{
			var_temps_chunk = word1.sl(attr_temps);
			var_pers_chunk = "";
			var_gen_chunk = "<m>";
			var_nbr_chunk = "<sg>";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
		}
		else
		if ((word1.sl(attr_temps).equals("<past>")
    && word1.sl(attr_pers).equals("")
    && word1.sl(attr_nbr).equals("")))
		{
			var_temps_chunk = "<pii>";
			var_pers_chunk = "<PD>";
			var_nbr_chunk = "<ND>";
			var_verbfinal = (""+word2.tl(attr_lemh)+word2.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word2.tl(attr_lemq));
		}
		else
		if ((word1.sl(attr_temps).equals("<past>")
    && word1.sl(attr_nbr).equals("<sg>")))
		{
			var_temps_chunk = "<pii>";
			var_pers_chunk = "<PD>";
			var_nbr_chunk = word1.tl(attr_nbr);
			var_verbfinal = (""+word2.tl(attr_lemh)+word2.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word2.tl(attr_lemq));
		}
		else
		if (word1.sl(attr_temps).equals("<pres>"))
		{
			var_temps_chunk = "<pri>";
			var_pers_chunk = "<PD>";
			var_nbr_chunk = "<ND>";
			word1.tlSet(attr_lemh, "estar");
			word1.tlSet(attr_a_verb, "<vblex>");
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
		}
		else
		if (word1.sl(attr_temps).equals("<pri>"))
		{
			word1.tlSet(attr_lemh, "estar");
			word1.tlSet(attr_a_verb, "<vblex>");
			var_temps_chunk = word1.tl(attr_temps);
			var_pers_chunk = word1.tl(attr_pers);
			var_nbr_chunk = word1.tl(attr_nbr);
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
		}
		else
		if ((word1.sl(attr_temps).equals("<inf>")
    || word1.sl(attr_temps).equals("<ger>")))
		{
			var_temps_chunk = word1.tl(attr_temps);
			var_pers_chunk = "<PD>";
			var_nbr_chunk = "<ND>";
			word1.tlSet(attr_lemh, "estar");
			word1.tlSet(attr_a_verb, "<vblex>");
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+word1.tl(attr_lemq));
		}
	}
	
	private void macro_conj_going_to_inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("macro_conj_going_to_inf",  word1, blank1,  word2, blank2,  word3); } 
		if ((word1.sl(attr_temps).equals("<pres>")
    || word1.sl(attr_temps).equals("<pri>")))
		{
			var_temps_chunk = "<fti>";
			var_lema_SV = "verbcj";
			if (word1.sl(attr_temps).equals("<pres>"))
			{
				var_pers_chunk = "<PD>";
				var_nbr_chunk = "<ND>";
			}
			else
			if (word1.sl(attr_temps).equals("<pri>"))
			{
				var_pers_chunk = word1.tl(attr_pers);
				var_nbr_chunk = word1.tl(attr_nbr);
			}
			var_verbfinal = (""+word3.tl(attr_lemh)+word3.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word3.tl(attr_lemq));
		}
		else
		if (word1.sl(attr_temps).equals("<past>"))
		{
			var_temps_chunk = "<pii>";
			var_lema_SV = "going_to_inf";
			if ((word1.sl(attr_pers).equals("")
    && word1.sl(attr_nbr).equals("")))
			{
				var_pers_chunk = "<PD>";
				var_nbr_chunk = "<ND>";
			}
			else
			if (word1.sl(attr_nbr).equals("<sg>"))
			{
				var_pers_chunk = "<PD>";
				var_nbr_chunk = word1.tl(attr_nbr);
			}
			var_verbfinal = (""+word2.tl(attr_lemh)+word2.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word2.tl(attr_lemq)+"$ ^"+"a"+"<pr>"+"$ ^"+word3.tl(attr_lemh)+word3.tl(attr_a_verb)+"<inf>"+word3.tl(attr_lemq));
		}
	}
	
	private void macro_passa_inf_a_pres(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_passa_inf_a_pres",  word1); } 
		if (word1.sl(attr_temps).equals("<inf>"))
		{
			var_temps_chunk = "<pri>";
			var_pers_chunk = "<PD>";
			var_nbr_chunk = "<ND>";
			var_lema_SV = "verbcj";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
		}
	}
	
	private void macro_passa_pp_a_ifip(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_passa_pp_a_ifip",  word1); } 
		if (word1.sl(attr_temps).equals("<pp>"))
		{
			var_temps_chunk = "<ifip>";
			var_pers_chunk = "<PD>";
			var_nbr_chunk = "<ND>";
			var_lema_SV = "verbcj";
			var_verbfinal = (""+"anar"+"<vaux>"+"<4>"+"<5>"+"$ ^"+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<inf>"+word1.tl(attr_lemq));
		}
	}
	
	/** ********************************* REGLES DE SN *****************************************************  primer les regles lèxiques */
	// REGLA: ALL NOUNplural (BCN: per afegir l'article definit en català 'all students' :: 'tots els estudiants'
	public void rule0__all__nomplural(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule0__all__nomplural",  word1, blank1,  word2); } 
		macro_det_no(out, word1, blank1, word2);
		macro_f_concord2(out, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_det_nom"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^el<det><def>");
		out.append((word1.tl(attr_gen_sense_mf)==""?"" : "<3>"));
		out.append("<pl>$");
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	
	// REGLA: ALL ADJ NOUNplural (BCN: per afegir l'article definit en català 'all legal states' :: 'tots els estats legals'.
	public void rule1__all__adj__nomplural(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule1__all__adj__nomplural",  word1, blank1,  word2, blank2,  word3); } 
		macro_det_no(out, word1, blank2, word3);
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word2);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_det_nom_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^el<det><def>");
		out.append((word1.tl(attr_gen_sense_mf)==""?"" : "<3>"));
		out.append("<pl>$");
		out.append(blank1);
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
		out.append(blank2);
		{
			String myword = 
			         var_adjectiu1
			         +word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +(word2.tl(attr_nbr_sp)==""?"" : "<4>")
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
	
	// REGLA: DET NOM
	public void rule2__det__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule2__det__nom",  word1, blank1,  word2); } 
		macro_det_no(out, word1, blank1, word2);
		macro_f_concord2(out, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append(var_negative);
		out.append('{');
		/**  BCN per recollir si es negacio */
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	public void rule3__num__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule3__num__nom",  word1, blank1,  word2); } 
		macro_million(out, word1);
		macro_flexio_numerals(out, word1, blank1, word2);
		macro_f_concord2(out, word2, " ", word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_nom"));
		out.append("<SN><NUM>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	
	// REGLA: DET DET NOM
	public void rule4__det__det__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule4__det__det__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_det_nom"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_det)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: DET NUM NOM
	public void rule5__det__num__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule5__det__num__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_million(out, word2);
		macro_flexio_numerals(out, word2, blank2, word3);
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_num_nom"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: NUM NUM NOM
	public void rule6__num__num__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule6__num__num__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_million(out, word2);
		if (((word2.tl(attr_lem).equalsIgnoreCase("milió de")
    || word2.tl(attr_lem).equalsIgnoreCase("un milió de"))
    && word1.tl(attr_gen).equals("<GD>")))
		{
			word1.tlSet(attr_gen, "<m>");
		}
		else
		{
			macro_flexio_numerals(out, word1, blank2, word3);
		}
		macro_flexio_numerals(out, word2, blank2, word3);
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_num_nom"));
		out.append("<SN><NUM>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: DET DET NUM NOM
	public void rule7__det__det__num__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule7__det__det__num__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_million(out, word3);
		macro_flexio_numerals(out, word3, blank3, word4);
		macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_det_num_nom"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_det)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +word3.tl(attr_a_num)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
	}
	
	// REGLA: DET NUM NUM NOM
	public void rule8__det__num__num__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule8__det__num__num__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_million(out, word3);
		macro_determiner(out, word1);
		if (((word3.tl(attr_lem).equalsIgnoreCase("milió de")
    || word3.tl(attr_lem).equalsIgnoreCase("un milió de"))
    && word2.tl(attr_gen).equals("<GD>")))
		{
			word2.tlSet(attr_gen, "<m>");
		}
		else
		{
			macro_flexio_numerals(out, word2, blank3, word4);
		}
		macro_flexio_numerals(out, word3, blank3, word4);
		macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_num_num_nom"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +word3.tl(attr_a_num)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
	}
	
	/**  SINTAGNES NOMINALS AMB UN ADJ  */
	// REGLA: such a ADJ NOM (afegir tb una regla such a ADJ ADJ NOM?. Aquí no he posat funció 'envia_adj' i per tant desapareix el comparatiu/superlatiu: such a bigger field = un camp tan gran. Pensar-hi
	public void rule9__such_a__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule9__such_a__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		/** per a donar gènere i nombre a l'article afegit  */
		if (var_gen_chunk.equals("<mf>"))
		{
			var_gen_chunk = "<GD>";
		}
		/** per a donar gènere i nombre a l'article afegit  */
		if (var_nbr_chunk.equals("<sp>"))
		{
			var_nbr_chunk = "<ND>";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adv_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^un<det><ind><3><4>$");
		out.append(blank1);
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		out.append("^tan<preadv>$ ");
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	
	// REGLA: ADJ NOM
	public void rule10__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule10__adj__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		macro_f_concord2(out, word2, " ", word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         var_adjectiu1
			         +word1.tl(attr_lemh)
			         +word1.tl(attr_a_adj)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
	
	// REGLA: DET ADJ NOM
	public void rule11__det__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule11__det__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_det_no(out, word1, blank2, word3);
		macro_firstWord(out, word1);
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_comparatiu_adj1(out, word2);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append(var_negative);
		out.append('{');
		/**  BCN per recollir si es negacio */
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
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
			         var_adjectiu1
			         +word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	
	// REGLA: NUM ADJ NOM
	public void rule12__num__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule12__num__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_det_no(out, word1, blank2, word3);
		macro_million(out, word1);
		macro_flexio_numerals(out, word1, blank2, word3);
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_nom_adj"));
		out.append("<SN><NUM>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
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
			         var_adjectiu1
			         +word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	
	// REGLA: DET DET ADJ NOM (your many beautiful cats)
	public void rule13__det__det__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule13__det__det__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
		macro_comparatiu_adj1(out, word3);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_det_nom_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +word2.tl(attr_a_det)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
			         var_adjectiu1
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: DET NUM ADJ NOM (your three beautiful cats)
	public void rule14__det__num__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule14__det__num__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_million(out, word2);
		macro_flexio_numerals(out, word2, blank3, word4);
		macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word3);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_num_nom_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
			         var_adjectiu1
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: ADJ NUM ADJ NOM (top 100 listed companies)
	public void rule15__adj__num__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule15__adj__num__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_million(out, word2);
		macro_flexio_numerals(out, word2, blank3, word4);
		macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adj_num_nom_adj"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_adj)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
			         var_adjectiu1
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: DET ADV (incl preadv) ADJ NOM
	public void rule16__det__adv_preadv__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule16__det__adv_preadv__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_det_no(out, word1, blank3, word4);
		macro_firstWord(out, word1);
		macro_f_concord3(out, word4, blank2, word3, " ", word1);
		macro_comparatiu_adj1(out, word3);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adv_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
		out.append(blank3);
		{
			String myword = 
			         var_adjectiu1
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: NUM ADV (incl preadv) ADJ NOM
	public void rule17__num__adv_preadv__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule17__num__adv_preadv__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_million(out, word1);
		macro_flexio_numerals(out, word1, blank3, word4);
		macro_f_concord3(out, word4, blank2, word3, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_nom_adv_adj"));
		out.append("<SN><NUM>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
		out.append(blank3);
		{
			String myword = 
			         var_adjectiu1
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: PREADV ADJ NOM
	public void rule18__preadv__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule18__preadv__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_f_concord2(out, word3, blank1, word2);
		macro_comparatiu_adj1(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_adv_adj"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
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
		{
			String myword = 
			         var_adjectiu1
			         +word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	
	// REGLA: DET DET ADV (incl preadv) ADJ NOM (BCN)
	public void rule19__det__detquant__adv_preadv__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule19__det__detquant__adv_preadv__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_det_no(out, word1, blank4, word5);
		macro_firstWord(out, word1);
		macro_f_concord4(out, word5, blank3, word4, blank1, word2, " ", word1);
		macro_comparatiu_adj1(out, word4);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_det_nom_adv_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_det)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
		out.append(blank4);
		{
			String myword = 
			         var_adjectiu1
			         +word4.tl(attr_lemh)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
	}
	
	// REGLA: DET NUM ADV (incl preadv) ADJ NOM (BCN)
	public void rule20__det__num__adv_preadv__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule20__det__num__adv_preadv__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_million(out, word2);
		macro_flexio_numerals(out, word2, blank4, word5);
		macro_f_concord4(out, word5, blank3, word4, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word4);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_num_nom_adv_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
		out.append(blank4);
		{
			String myword = 
			         var_adjectiu1
			         +word4.tl(attr_lemh)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
	}
	
	// REGLA: PREADV ADJ NOM (és com la regla anterior, però inclou tb adverbis junt amb pp: 'locally produced materials'. No hi ha cap regla per ADV ADJ(pp) NOM perquè l'adverbi no sempre modifica l'adjectiu o pp (....'always green articles'). He pensat que quan és 'pp' és més probable que l'adverbi modifiqui el pp, tot i que tampoc sempre és així.
	public void rule21__adv_preadv__pp__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule21__adv_preadv__pp__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_f_concord2(out, word3, blank1, word2);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj_adv"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
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
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	
	/**  SINTAGMES NOMINALS AMB DOS ADJS (ADJ ADJ) */
	// REGLA: DET ADJ ADJ NOM
	public void rule22__det__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule22__det__adj__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_det_no(out, word1, blank3, word4);
		macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word2);
		macro_comparatiu_adj2(out, word3);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
			         var_adjectiu2
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
			         var_adjectiu1
			         +word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	
	// REGLA: DET DET ADJ ADJ NOM (BCN)
	public void rule23__det__det__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule23__det__det__adj__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_det_no(out, word1, blank4, word5);
		macro_f_concord5(out, word5, blank3, word4, blank2, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word3);
		macro_comparatiu_adj2(out, word4);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_det_nom_adj_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_det)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
			         var_adjectiu2
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
			         var_adjectiu1
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: DET ADV ADJ ADJ NOM (BCN a currently valid legislative delegation ->  una delegació legislativa actualment vàlida)
	public void rule24__det__adv_preadv__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule24__det__adv_preadv__adj__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_det_no(out, word1, blank4, word5);
		macro_f_concord4(out, word5, blank3, word4, blank2, word3, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word3);
		macro_comparatiu_adj2(out, word4);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_adv_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
			         var_adjectiu2
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
			         word2.tl(attr_whole)
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
			         var_adjectiu1
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: NUM ADV ADJ ADJ NOM (BCN two currently valid legislative delegations)
	public void rule25__num__adv_preadv__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule25__num__adv_preadv__adj__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_f_concord4(out, word5, blank3, word4, blank2, word3, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word3);
		macro_comparatiu_adj2(out, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_nom_adj_adv_adj"));
		out.append("<SN><NUM>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
			         var_adjectiu2
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
			         word2.tl(attr_whole)
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
			         var_adjectiu1
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: NUM ADJ ADJ NOM
	public void rule26__num__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule26__num__adj__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_million(out, word1);
		macro_flexio_numerals(out, word1, blank3, word4);
		macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word2);
		macro_comparatiu_adj2(out, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_nom_adj_adj"));
		out.append("<SN><NUM>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
			         var_adjectiu2
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
			         var_adjectiu1
			         +word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	
	// REGLA: DET NUM ADJ ADJ NOM (BCN)
	public void rule27__det__num__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule27__det__num__adj__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_million(out, word1);
		macro_flexio_numerals(out, word1, blank4, word5);
		macro_f_concord5(out, word5, blank3, word4, blank2, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word3);
		macro_comparatiu_adj2(out, word4);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_num_nom_adj_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
			         var_adjectiu2
			         +word4.tl(attr_lemh)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
			         var_adjectiu1
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	public void rule28__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule28__adj__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		macro_comparatiu_adj2(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj_adj"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
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
			         var_adjectiu2
			         +word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         var_adjectiu1
			         +word1.tl(attr_lemh)
			         +word1.tl(attr_a_adj)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
	
	// REGLA: DET NUM PREADV ADJ ADJ NOM (BCN)
	public void rule29__det__num__adv_preadv__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule29__det__num__adv_preadv__adj__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_million(out, word2);
		macro_flexio_numerals(out, word2, blank5, word6);
		macro_f_concord5(out, word6, blank4, word5, blank3, word4, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word4);
		macro_comparatiu_adj2(out, word5);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_num_nom_adj_adv_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         word6.tl(attr_lemh)
			         +word6.tl(attr_a_nom)
			         +(word6.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word6.tl(attr_gen_mf)
			         +(word6.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word6.tl(attr_nbr_sp)
			         +word6.tl(attr_lemq)
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
			         var_adjectiu2
			         +word5.tl(attr_lemh)
			         +word5.tl(attr_a_adj)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
			         word3.tl(attr_whole)
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
			         var_adjectiu1
			         +word4.tl(attr_lemh)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
	}
	
	// REGLA: DET DETquant PREADV ADJ ADJ NOM (BCN)
	public void rule30__det__detquant__adv_preadv__adj__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule30__det__detquant__adv_preadv__adj__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_million(out, word2);
		macro_flexio_numerals(out, word2, blank5, word6);
		macro_f_concord5(out, word6, blank4, word5, blank3, word4, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word4);
		macro_comparatiu_adj2(out, word5);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_det_nom_adj_adv_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_det)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         word6.tl(attr_lemh)
			         +word6.tl(attr_a_nom)
			         +(word6.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word6.tl(attr_gen_mf)
			         +(word6.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word6.tl(attr_nbr_sp)
			         +word6.tl(attr_lemq)
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
			         var_adjectiu2
			         +word5.tl(attr_lemh)
			         +word5.tl(attr_a_adj)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
			         word3.tl(attr_whole)
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
			         var_adjectiu1
			         +word4.tl(attr_lemh)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
	}
	
	/**  SINTAGMES NOMINALS AMB DOS ADJS COORDINATS */
	// REGLA: ADJ AND ADJ NOM (BCN)
	public void rule31__adj__cnjcoo__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule31__adj__cnjcoo__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_f_concord3(out, word4, blank2, word3, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		macro_comparatiu_adj2(out, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj_conj_adj"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
			         var_adjectiu1
			         +word1.tl(attr_lemh)
			         +word1.tl(attr_a_adj)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_whole)
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
			         var_adjectiu2
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: ADJ AND ADV ADJ NOM
	public void rule32__adj__cnjcoo__adv_preadv__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule32__adj__cnjcoo__adv_preadv__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_f_concord3(out, word5, blank3, word4, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		macro_comparatiu_adj2(out, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj_conj_adv_adj"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
			         var_adjectiu1
			         +word1.tl(attr_lemh)
			         +word1.tl(attr_a_adj)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word2.tl(attr_whole)
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
		out.append(blank4);
		{
			String myword = 
			         var_adjectiu2
			         +word4.tl(attr_lemh)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
	}
	
	// REGLA: DET ADJ AND ADJ NOM (BCN)
	public void rule33__det__adj__cnjcoo__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule33__det__adj__cnjcoo__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_det_no(out, word1, blank4, word5);
		macro_f_concord4(out, word5, blank3, word4, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word2);
		macro_comparatiu_adj2(out, word4);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_conj_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
			         var_adjectiu1
			         +word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         word3.tl(attr_whole)
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
			         var_adjectiu2
			         +word4.tl(attr_lemh)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
	}
	
	// REGLA: DET ADJ AND ADV ADJ NOM (BCN)
	public void rule34__det__adj__cnjcoo__adv_preadv__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule34__det__adj__cnjcoo__adv_preadv__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_det_no(out, word1, blank5, word6);
		macro_f_concord4(out, word6, blank4, word5, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word2);
		macro_comparatiu_adj2(out, word5);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_conj_adv_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word6.tl(attr_lemh)
			         +word6.tl(attr_a_nom)
			         +(word6.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word6.tl(attr_gen_mf)
			         +(word6.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word6.tl(attr_nbr_sp)
			         +word6.tl(attr_lemq)
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
			         var_adjectiu1
			         +word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         word3.tl(attr_whole)
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
			         word4.tl(attr_whole)
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
			         var_adjectiu2
			         +word5.tl(attr_lemh)
			         +word5.tl(attr_a_adj)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
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
	
	// REGLA: DET ADV ADJ AND ADJ NOM (BCN: the most popular and largest city)
	public void rule35__det__adv_preadv__adj__cnjcoo__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule35__det__adv_preadv__adj__cnjcoo__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_det_no(out, word1, blank5, word6);
		macro_f_concord4(out, word6, blank4, word5, blank2, word3, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word3);
		macro_comparatiu_adj2(out, word5);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adv_adj_conj_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word6.tl(attr_lemh)
			         +word6.tl(attr_a_nom)
			         +(word6.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word6.tl(attr_gen_mf)
			         +(word6.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word6.tl(attr_nbr_sp)
			         +word6.tl(attr_lemq)
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
		out.append(blank3);
		{
			String myword = 
			         var_adjectiu1
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
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
			         word4.tl(attr_whole)
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
			         var_adjectiu2
			         +word5.tl(attr_lemh)
			         +word5.tl(attr_a_adj)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
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
	
	/**  SINTAGMES NOMINALS AMB DOS ADJS AMB COMA */
	// REGLA: DET ADJ, ADJ NOM (Those wild, wonderful places)
	public void rule36__det__adj__coma__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule36__det__adj__coma__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_det_no(out, word1, blank4, word5);
		macro_f_concord4(out, word5, blank3, word4, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word2);
		macro_comparatiu_adj2(out, word4);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_cm_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
			         var_adjectiu1
			         +word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
			         +word2.tl(attr_lemq)
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
			         word3.tl(attr_whole)
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
			         var_adjectiu2
			         +word4.tl(attr_lemh)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
	}
	
	// REGLA: ADJ, ADJ NOM (wild, wonderful places)
	public void rule37__adj__coma__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule37__adj__coma__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_f_concord3(out, word4, blank2, word3, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		macro_comparatiu_adj2(out, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj_cm_adj"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
			         var_adjectiu1
			         +word1.tl(attr_lemh)
			         +word1.tl(attr_a_adj)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
			         +word1.tl(attr_lemq)
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
			         word2.tl(attr_whole)
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
			         var_adjectiu2
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	/**  SINTAGMES NOMINALS AMB APOS */
	// REGLA:  APOS ADJ APOS NOM
	public void rule38__apos__adj__apos__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule38__apos__adj__apos__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_f_concord2(out, word4, blank1, word2);
		macro_firstWord(out, word2);
		macro_comparatiu_adj1(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_'adj'"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
			         word1.tl(attr_whole)
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
			         var_adjectiu1
			         +word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
			         +word2.tl(attr_lemq)
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
	
	// REGLA: ADJ APOS NOM APOS
	public void rule39__adj__apos__nom__apos(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule39__adj__apos__nom__apos",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_f_concord2(out, word3, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "'nom'_adj"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
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
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
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
			         word4.tl(attr_whole)
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
			         var_adjectiu1
			         +word1.tl(attr_lemh)
			         +word1.tl(attr_a_adj)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
	
	// REGLA: DET ADJ APOS 'NOM' APOS
	public void rule40__det__adj__apos__nom__apos(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule40__det__adj__apos__nom__apos",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_det_no(out, word1, blank2, word3);
		macro_f_concord3(out, word4, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word2);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_'nom'_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
			         word5.tl(attr_whole)
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
			         var_adjectiu1
			         +word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	
	// REGLA: DET APOS 'ADJ' APOS NOM
	public void rule41__det__apos__adj__apos__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule41__det__apos__adj__apos__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_det_no(out, word1, blank4, word5);
		macro_f_concord3(out, word5, blank2, word3, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word3);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_'adj'"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +(word1.tl(attr_nbr_sp)==""?"" : "<4>")
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
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
			         word2.tl(attr_whole)
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
			         var_adjectiu1
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
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
	
	/**  SINTAGMES NOMINALS AMB MES D'UN NOM */
	// REGLA: NOM1 NOM2 -> NOM2 de NOM1
	public void rule42__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule42__nom__nom",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		if (!(word2.tl(attr_a_nom).equals("<np><ant>")
    || word2.tl(attr_a_nom).equals("<np><cog>")
    || word1.tl(attr_a_nom).equals("<np><ant>")
    || word1.tl(attr_a_nom).equals("<np><cog>")
    || list_tractaments.containsIgnoreCase(word1.sl(attr_lem))
    || list_tractaments.containsIgnoreCase(word2.sl(attr_lem))
    || list_days.containsIgnoreCase(word2.sl(attr_lem))))
		{
			macro_elimina_GDND(out, word1);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_pr_nom"));
			out.append("<SN><UNDET>");
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +(word2.tl(attr_gen)==""?"" : "<3>")
				         +(word2.tl(attr_nbr)==""?"" : "<4>")
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
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_nom)
				         +word1.tl(attr_gen)
				         +word1.tl(attr_nbr)
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
		else
		{
			macro_elimina_GDND(out, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_nom"));
			out.append("<SN><UNDET>");
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_nom)
				         +(word1.tl(attr_gen)==""?"" : "<3>")
				         +(word1.tl(attr_nbr)==""?"" : "<4>")
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
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +word2.tl(attr_gen)
				         +word2.tl(attr_nbr)
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
	
	// REGLA: DET NOM1 NOM2 -> DET NOM2 de NOM1
	public void rule43__det__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule43__det__nom__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		if (!(word3.tl(attr_a_nom).equals("<np><ant>")
    || word3.tl(attr_a_nom).equals("<np><cog>")
    || word2.tl(attr_a_nom).equals("<np><ant>")
    || word2.tl(attr_a_nom).equals("<np><cog>")
    || list_tractaments.containsIgnoreCase(word2.sl(attr_lem))
    || list_tractaments.containsIgnoreCase(word3.sl(attr_lem))
    || list_days.containsIgnoreCase(word3.sl(attr_lem))))
		{
			macro_f_concord2(out, word3, " ", word1);
			macro_elimina_GDND(out, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +word2.tl(attr_gen)
				         +word2.tl(attr_nbr)
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
		else
		{
			macro_f_concord2(out, word2, " ", word1);
			macro_elimina_GDND(out, word3);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
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
	
	// REGLA: NUM NOM1 NOM2 -> NUM NOM2 de NOM1 (Three street chairs) 
	public void rule44__num__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule44__num__nom__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_million(out, word1);
		macro_flexio_numerals(out, word1, blank2, word3);
		macro_firstWord(out, word1);
		if (!(word3.tl(attr_a_nom).equals("<np><ant>")
    || word3.tl(attr_a_nom).equals("<np><cog>")
    || word2.tl(attr_a_nom).equals("<np><ant>")
    || word2.tl(attr_a_nom).equals("<np><cog>")
    || list_tractaments.containsIgnoreCase(word2.sl(attr_lem))
    || list_tractaments.containsIgnoreCase(word3.sl(attr_lem))
    || list_days.containsIgnoreCase(word3.sl(attr_lem))))
		{
			macro_f_concord2(out, word3, " ", word1);
			macro_elimina_GDND(out, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "num_nom_pr_nom"));
			out.append("<SN><NUM>");
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_num)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +word2.tl(attr_gen)
				         +word2.tl(attr_nbr)
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
		else
		{
			macro_f_concord2(out, word2, " ", word1);
			macro_elimina_GDND(out, word3);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "num_nom_nom"));
			out.append("<SN><NUM>");
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_num)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
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
	
	// REGLA: NUM-NOM1 NOM2 -> NOM2 de NUM NOM1(pl) (Three-month extension - extensió de tres mesos)
	public void rule45__num__guio__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule45__num__guio__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_million(out, word1);
		macro_flexio_numerals(out, word1, blank2, word3);
		macro_firstWord(out, word1);
		/** aquí no poso funció f_concord entre 3 i 1 perquè els valors no van enllaçats al chunk i per tant no es poden deixar GDs */
		macro_elimina_GDND(out, word3);
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
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_pr_num_nom"));
		out.append("<SN><NUM>");
		out.append(word4.tl(attr_gen));
		out.append(word4.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen)==""?"" : "<3>")
			         +(word4.tl(attr_nbr)==""?"" : "<4>")
			         +word4.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank3);
		out.append("^de<pr>$ ");
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
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
		out.append(" ");
		/** MG: atenció! i quan és 'one-month'? - arreglar  */
		out.append('^');
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_nom));
		out.append(word3.tl(attr_gen));
		out.append("<pl>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: ADJ-NOM1 NOM2 -> NOM2 de NOM1 ADJ (BCN open-source software)
	public void rule46__adj__guio__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule46__adj__guio__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_comparatiu_adj1(out, word2);
		macro_firstWord(out, word1);
		/** aquí no poso  funció f_concord entre 3 i 1 perquè els valors no van enllaçats al chunk i per tant no es poden deixar GDs'ni NDs: */
		macro_elimina_GDND(out, word3);
		macro_posa_GDND(out, word1);
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
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_pr_nom_adj"));
		out.append("<SN><UNDET>");
		out.append(word4.tl(attr_gen));
		out.append(word4.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen)==""?"" : "<3>")
			         +(word4.tl(attr_nbr)==""?"" : "<4>")
			         +word4.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank3);
		out.append("^de<pr>$ ");
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_adj)
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
	
	// REGLA: DET ADJ-NOM1 NOM2 -> DET NOM2 de NOM1 ADJ (BCN the open-source software)
	public void rule47__det__adj__guio__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule47__det__adj__guio__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_det_no(out, word1, blank4, word5);
		macro_determiner(out, word1);
		macro_f_concord2(out, word5, " ", word1);
		macro_comparatiu_adj1(out, word2);
		macro_firstWord(out, word1);
		/** aquí no poso  funció f_concord entre 4 i 2 perquè els valors no van enllaçats al chunk i per tant no es poden deixar GDs'ni NDs: */
		macro_elimina_GDND(out, word4);
		macro_posa_GDND(out, word2);
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			if (!word4.tl(attr_gen).equals("<mf>"))
			{
				word2.tlSet(attr_gen, word4.tl(attr_gen));
			}
			else
			{
				word2.tlSet(attr_gen, "<m>");
			}
		}
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			if (!word4.tl(attr_nbr).equals("<sp>"))
			{
				word2.tlSet(attr_nbr, word4.tl(attr_nbr));
			}
			else
			{
				word2.tlSet(attr_nbr, "<sg>");
			}
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_nom_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$ ");
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
			         +word4.tl(attr_lemq)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
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
	
	// REGLA: NUM ADJ-NOM1 NOM2 -> NOM NOM2 de NOM1 ADJ (BCN three open-source softwares)
	public void rule48__num__adj__guio__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule48__num__adj__guio__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_million(out, word1);
		macro_flexio_numerals(out, word1, blank4, word5);
		macro_f_concord2(out, word5, " ", word1);
		macro_comparatiu_adj1(out, word2);
		macro_firstWord(out, word1);
		/** aquí no poso  funció f_concord entre 4 i 2 perquè els valors no van enllaçats al chunk i per tant no es poden deixar GDs'ni NDs: */
		macro_elimina_GDND(out, word4);
		macro_posa_GDND(out, word2);
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			if (!word4.tl(attr_gen).equals("<mf>"))
			{
				word2.tlSet(attr_gen, word4.tl(attr_gen));
			}
			else
			{
				word2.tlSet(attr_gen, "<m>");
			}
		}
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			if (!word4.tl(attr_nbr).equals("<sp>"))
			{
				word2.tlSet(attr_nbr, word4.tl(attr_nbr));
			}
			else
			{
				word2.tlSet(attr_nbr, "<sg>");
			}
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_nom_pr_nom_adj"));
		out.append("<SN><NUM>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$ ");
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
			         +word4.tl(attr_lemq)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
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
	
	// REGLA: ADJ-NOM1 NOM2 NOM3-> NOM3 de NOM1 NOM ADJ (BCN open-source software systems) MG falta comprovar np i days
	public void rule49__adj__guio__nom__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule49__adj__guio__nom__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_comparatiu_adj1(out, word2);
		macro_firstWord(out, word1);
		macro_elimina_GDND(out, word4);
		/** aquí no poso  funció f_concord entre 3 i 1 perquè els valors no van enllaçats al chunk i per tant no es poden deixar GDs'ni NDs: */
		macro_elimina_GDND(out, word3);
		macro_posa_GDND(out, word1);
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
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_pr_nom_pr_nom_adj"));
		out.append("<SN><UNDET>");
		out.append(word5.tl(attr_gen));
		out.append(word5.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen)==""?"" : "<3>")
			         +(word5.tl(attr_nbr)==""?"" : "<4>")
			         +word5.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$ ");
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
			         +word4.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$");
		out.append(blank3);
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
			         +word3.tl(attr_lemq)
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
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_adj)
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
	
	// REGLA: DET ADJ-NOM1 NOM2 NOM3-> NOM3 de NOM1 NOM ADJ (BCN the open-source software systems)
	public void rule50__det__adj__guio__nom__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule50__det__adj__guio__nom__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_comparatiu_adj1(out, word3);
		macro_det_no(out, word1, blank5, word6);
		macro_determiner(out, word1);
		macro_f_concord2(out, word6, " ", word1);
		macro_firstWord(out, word1);
		macro_elimina_GDND(out, word5);
		/** aquí no poso  funció f_concord entre 4 i 2 perquè els valors no van enllaçats al chunk i per tant no es poden deixar GDs'ni NDs: */
		macro_elimina_GDND(out, word4);
		macro_posa_GDND(out, word2);
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			if (!word4.tl(attr_gen).equals("<mf>"))
			{
				word2.tlSet(attr_gen, word4.tl(attr_gen));
			}
			else
			{
				word2.tlSet(attr_gen, "<m>");
			}
		}
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			if (!word4.tl(attr_nbr).equals("<sp>"))
			{
				word2.tlSet(attr_nbr, word4.tl(attr_nbr));
			}
			else
			{
				word2.tlSet(attr_nbr, "<sg>");
			}
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_nom_pr_nom_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word6.tl(attr_lemh)
			         +word6.tl(attr_a_nom)
			         +(word6.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word6.tl(attr_gen_mf)
			         +(word6.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word6.tl(attr_nbr_sp)
			         +word6.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$ ");
		{
			String myword = 
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +word5.tl(attr_gen)
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
		out.append(blank4);
		out.append("^de<pr>$ ");
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
			         +word4.tl(attr_lemq)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
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
	
	// REGLA: NUM ADJ-NOM1 NOM2 NOM3-> NOM3 de NOM1 NOM ADJ (BCN three open-source software systems)
	public void rule51__num__adj__guio__nom__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule51__num__adj__guio__nom__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_million(out, word1);
		macro_flexio_numerals(out, word1, blank5, word6);
		macro_f_concord2(out, word6, " ", word1);
		macro_comparatiu_adj1(out, word3);
		macro_firstWord(out, word1);
		macro_elimina_GDND(out, word5);
		/** aquí no poso  funció f_concord entre 4 i 2 perquè els valors no van enllaçats al chunk i per tant no es poden deixar GDs'ni NDs: */
		macro_elimina_GDND(out, word4);
		macro_posa_GDND(out, word2);
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			if (!word4.tl(attr_gen).equals("<mf>"))
			{
				word2.tlSet(attr_gen, word4.tl(attr_gen));
			}
			else
			{
				word2.tlSet(attr_gen, "<m>");
			}
		}
		if (word2.tl(attr_nbr).equals("<ND>"))
		{
			if (!word4.tl(attr_nbr).equals("<sp>"))
			{
				word2.tlSet(attr_nbr, word4.tl(attr_nbr));
			}
			else
			{
				word2.tlSet(attr_nbr, "<sg>");
			}
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_nom_pr_nom_pr_nom_adj"));
		out.append("<SN><NUM>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word6.tl(attr_lemh)
			         +word6.tl(attr_a_nom)
			         +(word6.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word6.tl(attr_gen_mf)
			         +(word6.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word6.tl(attr_nbr_sp)
			         +word6.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$ ");
		{
			String myword = 
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +word5.tl(attr_gen)
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
		out.append(blank4);
		out.append("^de<pr>$ ");
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
			         +word4.tl(attr_lemq)
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
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_adj)
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
	
	// REGLA: ADV-ADJ NOM2 -> NOM NOM2 de ADV NOM1 (BCN non-free software)
	public void rule52__adv__guio__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule52__adv__guio__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_f_concord2(out, word4, blank2, word3);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_adv_adj"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
			         word1.tl(attr_whole)
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
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
	
	// REGLA: NUM ADV-ADJ NOM2 (BCN non-free software)
	public void rule53__num__adv__guio__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule53__num__adv__guio__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_million(out, word1);
		macro_flexio_numerals(out, word1, blank4, word5);
		macro_f_concord3(out, word5, blank3, word4, " ", word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_nom_adv_adj"));
		out.append("<SN><NUM>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
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
			         word2.tl(attr_whole)
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
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
	}
	
	// REGLA: DET ADV-ADJ NOM2 (BCN the non-free software)
	public void rule54__det__adv__guio__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule54__det__adv__guio__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_det_no(out, word1, blank4, word5);
		macro_determiner(out, word1);
		macro_f_concord3(out, word5, blank3, word4, " ", word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adv_adj"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
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
			         word2.tl(attr_whole)
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
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_adj)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
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
	}
	
	// REGLA: DET DET NOM1 NOM2 -> DET DET NOM2 de NOM1
	public void rule55__det__det__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule55__det__det__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		if (!(word4.tl(attr_a_nom).equals("<np><ant>")
    || word4.tl(attr_a_nom).equals("<np><cog>")
    || word3.tl(attr_a_nom).equals("<np><ant>")
    || word3.tl(attr_a_nom).equals("<np><cog>")
    || list_tractaments.containsIgnoreCase(word4.sl(attr_lem))
    || list_tractaments.containsIgnoreCase(word3.sl(attr_lem))
    || list_days.containsIgnoreCase(word4.sl(attr_lem))))
		{
			macro_f_concord3(out, word4, blank1, word2, " ", word1);
			macro_elimina_GDND(out, word3);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_det_nom_pr_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         word2.tl(attr_lem)
				         +word2.tl(attr_a_det)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         +word4.tl(attr_a_nom)
				         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word4.tl(attr_gen_mf)
				         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word4.tl(attr_nbr_sp)
				         +word4.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank3);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
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
		else
		{
			macro_f_concord3(out, word3, blank1, word2, " ", word1);
			macro_elimina_GDND(out, word4);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_det_nom_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         word2.tl(attr_lem)
				         +word2.tl(attr_a_det)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
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
				         +word4.tl(attr_a_nom)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
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
		}
	}
	
	// REGLA: DET NUM NOM1 NOM2 -> DET NUM NOM2 de NOM1
	public void rule56__det__num__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule56__det__num__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_million(out, word2);
		macro_determiner(out, word1);
		macro_flexio_numerals(out, word2, blank3, word4);
		macro_firstWord(out, word1);
		if (!(word4.tl(attr_a_nom).equals("<np><ant>")
    || word4.tl(attr_a_nom).equals("<np><cog>")
    || word3.tl(attr_a_nom).equals("<np><ant>")
    || word3.tl(attr_a_nom).equals("<np><cog>")
    || list_tractaments.containsIgnoreCase(word4.sl(attr_lem))
    || list_tractaments.containsIgnoreCase(word3.sl(attr_lem))
    || list_days.containsIgnoreCase(word4.sl(attr_lem))))
		{
			macro_f_concord3(out, word4, blank1, word2, " ", word1);
			macro_elimina_GDND(out, word3);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_num_nom_pr_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         word2.tl(attr_lem)
				         +word2.tl(attr_a_num)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         +word4.tl(attr_a_nom)
				         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word4.tl(attr_gen_mf)
				         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word4.tl(attr_nbr_sp)
				         +word4.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank3);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
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
		else
		{
			macro_f_concord3(out, word3, blank1, word2, " ", word1);
			macro_elimina_GDND(out, word4);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_num_nom_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         word2.tl(attr_lem)
				         +word2.tl(attr_a_num)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
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
				         +word4.tl(attr_a_nom)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
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
		}
	}
	
	// REGLA: DET NUM-NOM1 NOM2 ->DET NOM2 de NUM NOM1(pl) (A three-month extension - una extensió de tres mesos
	public void rule57__det__num__guio__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule57__det__num__guio__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_million(out, word2);
		macro_determiner(out, word1);
		macro_flexio_numerals(out, word2, blank3, word4);
		macro_f_concord2(out, word5, " ", word1);
		macro_firstWord(out, word1);
		/** aquí no poso funció f_concord entre 4 i 2 perquè els valors no van enllaçats al chunk i per tant no es poden deixar GDs */
		macro_elimina_GDND(out, word4);
		if (word2.tl(attr_gen).equals("<GD>"))
		{
			if (!word4.tl(attr_gen).equals("<mf>"))
			{
				word2.tlSet(attr_gen, word4.tl(attr_gen));
			}
			else
			{
				word2.tlSet(attr_gen, "<m>");
			}
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_num_nom"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$ ");
		{
			String myword = 
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_num)
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
		out.append(blank4);
		out.append('^');
		out.append(word4.tl(attr_lemh));
		out.append(word4.tl(attr_a_nom));
		out.append(word4.tl(attr_gen));
		out.append("<pl>");
		out.append(word4.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: ADJ NOM1 NOM2 -> NOM2 de NOM1 ADJ
	public void rule58__adj__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule58__adj__nom__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		if (!(word3.tl(attr_a_nom).equals("<np><ant>")
    || word3.tl(attr_a_nom).equals("<np><cog>")
    || word2.tl(attr_a_nom).equals("<np><ant>")
    || word2.tl(attr_a_nom).equals("<np><cog>")
    || list_tractaments.containsIgnoreCase(word2.sl(attr_lem))
    || list_tractaments.containsIgnoreCase(word3.sl(attr_lem))
    || list_days.containsIgnoreCase(word3.sl(attr_lem))))
		{
			macro_elimina_GDND(out, word2);
			macro_posa_GDND(out, word1);
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
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_pr_nom_adj"));
			out.append("<SN><UNDET>");
			out.append(word3.tl(attr_gen));
			out.append(word3.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen)==""?"" : "<3>")
				         +(word3.tl(attr_nbr)==""?"" : "<4>")
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +word2.tl(attr_gen)
				         +word2.tl(attr_nbr)
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
				         var_adjectiu1
				         +word1.tl(attr_lemh)
				         +word1.tl(attr_a_adj)
				         +word1.tl(attr_gen)
				         +word1.tl(attr_nbr)
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
		else
		{
			macro_f_concord2(out, word2, " ", word1);
			macro_elimina_GDND(out, word3);
			/** 'beautiful son James'  */
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj_nom"));
			out.append("<SN><UNDET>");
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         var_adjectiu1
				         +word1.tl(attr_lemh)
				         +word1.tl(attr_a_adj)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
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
	
	// REGLA: DET ADJ NOM1 NOM2 -> DET NOM2 de NOM1 ADJ
	public void rule59__det__adj__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule59__det__adj__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		macro_comparatiu_adj1(out, word2);
		if (!(word4.tl(attr_a_nom).equals("<np><ant>")
    || word4.tl(attr_a_nom).equals("<np><cog>")
    || word3.tl(attr_a_nom).equals("<np><ant>")
    || word3.tl(attr_a_nom).equals("<np><cog>")
    || list_tractaments.containsIgnoreCase(word4.sl(attr_lem))
    || list_tractaments.containsIgnoreCase(word3.sl(attr_lem))
    || list_days.containsIgnoreCase(word4.sl(attr_lem))))
		{
			macro_f_concord3(out, word4, " ", word1, blank1, word2);
			macro_elimina_GDND(out, word3);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_nom_adj"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word4.tl(attr_a_nom)
				         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word4.tl(attr_gen_mf)
				         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word4.tl(attr_nbr_sp)
				         +word4.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
				         +word3.tl(attr_lemq)
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
				         var_adjectiu1
				         +word2.tl(attr_lemh)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
		else
		{
			macro_f_concord3(out, word3, blank1, word2, " ", word1);
			macro_elimina_GDND(out, word4);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
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
				         var_adjectiu1
				         +word2.tl(attr_lemh)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         +word4.tl(attr_a_nom)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
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
		}
	}
	
	// REGLA: ADJ1 ADJ2 NOM1 NOM2 -> NOM2 de NOM1 ADJ2 ADJ1
	public void rule60__adj__adj__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule60__adj__adj__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		macro_comparatiu_adj2(out, word2);
		if (!(word4.tl(attr_a_nom).equals("<np><ant>")
    || word4.tl(attr_a_nom).equals("<np><cog>")
    || word3.tl(attr_a_nom).equals("<np><ant>")
    || word3.tl(attr_a_nom).equals("<np><cog>")
    || list_tractaments.containsIgnoreCase(word4.sl(attr_lem))
    || list_tractaments.containsIgnoreCase(word3.sl(attr_lem))
    || list_days.containsIgnoreCase(word4.sl(attr_lem))))
		{
			macro_f_concord3(out, word4, " ", word1, blank1, word2);
			macro_elimina_GDND(out, word3);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_pr_nom_adj_adj"));
			out.append("<SN><UNDET>");
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word4.tl(attr_lemh)
				         +word4.tl(attr_a_nom)
				         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word4.tl(attr_gen_mf)
				         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word4.tl(attr_nbr_sp)
				         +word4.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
				         +word3.tl(attr_lemq)
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
				         var_adjectiu2
				         +word2.tl(attr_lemh)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         var_adjectiu1
				         +word1.tl(attr_lem)
				         +word1.tl(attr_a_adj)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
			macro_f_concord3(out, word3, blank1, word2, " ", word1);
			macro_elimina_GDND(out, word4);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_adj_adj_nom"));
			out.append("<SN><UNDET>");
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
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
				         var_adjectiu2
				         +word2.tl(attr_lemh)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         var_adjectiu1
				         +word1.tl(attr_lem)
				         +word1.tl(attr_a_adj)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word4.tl(attr_a_nom)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
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
		}
	}
	
	// REGLA: DET ADJ1 ADJ2 NOM1 NOM2 -> DET NOM2 de NOM1 ADJ2 ADJ1
	public void rule61__det__adj__adj__nom__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule61__det__adj__adj__nom__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		macro_comparatiu_adj1(out, word2);
		macro_comparatiu_adj2(out, word3);
		if (!(word5.tl(attr_a_nom).equals("<np><ant>")
    || word5.tl(attr_a_nom).equals("<np><cog>")
    || word4.tl(attr_a_nom).equals("<np><ant>")
    || word4.tl(attr_a_nom).equals("<np><cog>")
    || list_tractaments.containsIgnoreCase(word5.sl(attr_lem))
    || list_tractaments.containsIgnoreCase(word4.sl(attr_lem))
    || list_days.containsIgnoreCase(word5.sl(attr_lem))))
		{
			macro_f_concord4(out, word5, blank1, word2, blank2, word3, " ", word1);
			macro_elimina_GDND(out, word4);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_nom_adj_adj"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         word5.tl(attr_lemh)
				         +word5.tl(attr_a_nom)
				         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word5.tl(attr_gen_mf)
				         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word5.tl(attr_nbr_sp)
				         +word5.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word4.tl(attr_lemh)
				         +word4.tl(attr_a_nom)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
				         +word4.tl(attr_lemq)
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
				         var_adjectiu2
				         +word3.tl(attr_lemh)
				         +word3.tl(attr_a_adj)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
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
				         var_adjectiu1
				         +word2.tl(attr_lem)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
			macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
			macro_elimina_GDND(out, word5);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_adj_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word4.tl(attr_a_nom)
				         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word4.tl(attr_gen_mf)
				         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word4.tl(attr_nbr_sp)
				         +word4.tl(attr_lemq)
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
				         var_adjectiu2
				         +word3.tl(attr_lemh)
				         +word3.tl(attr_a_adj)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
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
				         var_adjectiu1
				         +word2.tl(attr_lem)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         +word5.tl(attr_gen)
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
	}
	
	// REGLA: NOM1 NOM2 NOM3 -> NOM3 de NOM2 del NOM1 (noms comuns: una altra manera de solucionar reordenaments no volguts de noms propis, que en les regles anteriors es fa mitjançant operacions dins la regla
	public void rule62__nom__nom__nomcomu(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule62__nom__nom__nomcomu",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		if (!(list_tractaments.containsIgnoreCase(word3.sl(attr_lem))
    || list_days.containsIgnoreCase(word3.sl(attr_lem))))
		{
			macro_elimina_GDND(out, word2);
			macro_elimina_GDND(out, word1);
			macro_genere_nombre(out, word1);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_pr_nom_pr_det_nom"));
			out.append("<SN><UNDET>");
			out.append(word3.tl(attr_gen));
			out.append(word3.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen)==""?"" : "<3>")
				         +(word3.tl(attr_nbr)==""?"" : "<4>")
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +word2.tl(attr_gen)
				         +word2.tl(attr_nbr)
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
			out.append("^de<pr>$ ");
			/** De moment hi posarem article, potser no sempre és correcte, estudiar-ho.  */
			out.append("^el<det><def>");
			out.append(var_genere);
			out.append(var_nombre);
			out.append("$ ");
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_nom)
				         +word1.tl(attr_gen)
				         +word1.tl(attr_nbr)
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
		else
		{
			macro_elimina_GDND(out, word3);
			macro_elimina_GDND(out, word1);
			macro_genere_nombre(out, word1);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_pr_det_nom_nom"));
			out.append("<SN><UNDET>");
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +(word2.tl(attr_gen)==""?"" : "<3>")
				         +(word2.tl(attr_nbr)==""?"" : "<4>")
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
			out.append("^de<pr>$ ");
			/** De moment hi posarem article, potser no sempre és correcte, estudiar-ho.  */
			out.append("^el<det><def>");
			out.append(var_genere);
			out.append(var_nombre);
			out.append('$');
			out.append(blank2);
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_nom)
				         +word1.tl(attr_gen)
				         +word1.tl(attr_nbr)
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
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
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
	
	// REGLA: NOMpropi1 NOMpropi2 NOMpropi3 -> NOMpropi1 NOMpropi2 NOMpropi3
	public void rule63__nompropi__nompropi__nompropi(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule63__nompropi__nompropi__nompropi",  word1, blank1,  word2, blank2,  word3); } 
		macro_genere_nombre(out, word3);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_nom_nom"));
		out.append("<SN><UNDET>");
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +(word1.tl(attr_gen)==""?"" : "<3>")
			         +(word1.tl(attr_nbr)==""?"" : "<4>")
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
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
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
	
	// REGLA: DET NOM1 NOM2 NOM3 -> DET NOM3 de NOM2 del NOM1
	public void rule64__det__nom__nom__nomcomu(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule64__det__nom__nom__nomcomu",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_genere_nombre(out, word4);
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		if (!(list_tractaments.containsIgnoreCase(word4.sl(attr_lem))
    || list_days.containsIgnoreCase(word4.sl(attr_lem))))
		{
			macro_f_concord2(out, word4, " ", word1);
			macro_elimina_GDND(out, word3);
			macro_elimina_GDND(out, word2);
			macro_genere_nombre(out, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_nom_pr_det_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word4.tl(attr_a_nom)
				         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word4.tl(attr_gen_mf)
				         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word4.tl(attr_nbr_sp)
				         +word4.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank3);
			out.append("^de<pr>$ ");
			/** De moment hi posarem article, potser no sempre és correcte, estudiar-ho.  */
			out.append("^el<det><def>");
			out.append(var_genere);
			out.append(var_nombre);
			out.append("$ ");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +word2.tl(attr_gen)
				         +word2.tl(attr_nbr)
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
		else
		{
			macro_f_concord2(out, word3, " ", word1);
			macro_elimina_GDND(out, word4);
			macro_elimina_GDND(out, word2);
			macro_genere_nombre(out, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_det_nom_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
			out.append("^de<pr>$ ");
			/** De moment hi posarem article, potser no sempre és correcte, estudiar-ho.  */
			out.append("^el<det><def>");
			out.append(var_genere);
			out.append(var_nombre);
			out.append("$ ");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +word2.tl(attr_gen)
				         +word2.tl(attr_nbr)
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
				         +word4.tl(attr_a_nom)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
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
		}
	}
	
	// REGLA: ADJ NOM1 NOM2 NOM3 -> NOM3 de NOM2 de NOM1 ADJ (professional video game design -> disseny de joc de vídeo professional (?)
	public void rule65__adj__nom__nom__nomcomu(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule65__adj__nom__nom__nomcomu",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		if (!(list_tractaments.containsIgnoreCase(word4.sl(attr_lem))
    || list_days.containsIgnoreCase(word4.sl(attr_lem))))
		{
			macro_f_concord2(out, word4, " ", word1);
			macro_elimina_GDND(out, word2);
			macro_elimina_GDND(out, word3);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_pr_nom_pr_nom_adj"));
			out.append("<SN><UNDET>");
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word4.tl(attr_lemh)
				         +word4.tl(attr_a_nom)
				         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word4.tl(attr_gen_mf)
				         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word4.tl(attr_nbr_sp)
				         +word4.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +word2.tl(attr_gen)
				         +word2.tl(attr_nbr)
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
				         var_adjectiu1
				         +word1.tl(attr_lemh)
				         +word1.tl(attr_a_adj)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
		else
		{
			macro_f_concord2(out, word3, " ", word1);
			macro_elimina_GDND(out, word2);
			macro_elimina_GDND(out, word4);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_pr_nom_adj_nom"));
			out.append("<SN><UNDET>");
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank1);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +word2.tl(attr_gen)
				         +word2.tl(attr_nbr)
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
				         var_adjectiu1
				         +word1.tl(attr_lemh)
				         +word1.tl(attr_a_adj)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word4.tl(attr_a_nom)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
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
		}
	}
	
	// REGLA: DET ADJ NOM1 NOM2 NOM3 -> DET NOM3 de NOM2 de NOM1 ADJ
	public void rule66__det__adj__nom__nom__nomcomu(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule66__det__adj__nom__nom__nomcomu",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word2);
		macro_determiner(out, word1);
		if (!(list_tractaments.containsIgnoreCase(word5.sl(attr_lem))
    || list_days.containsIgnoreCase(word5.sl(attr_lem))))
		{
			macro_f_concord3(out, word5, blank1, word2, " ", word1);
			macro_elimina_GDND(out, word4);
			macro_elimina_GDND(out, word3);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_nom_pr_nom_adj"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         word5.tl(attr_lemh)
				         +word5.tl(attr_a_nom)
				         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word5.tl(attr_gen_mf)
				         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word5.tl(attr_nbr_sp)
				         +word5.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word4.tl(attr_lemh)
				         +word4.tl(attr_a_nom)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
				         +word4.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank3);
			out.append("^de<pr>$");
			out.append(blank4);
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
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
				         var_adjectiu1
				         +word2.tl(attr_lemh)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
		else
		{
			macro_f_concord3(out, word4, blank1, word2, " ", word1);
			macro_elimina_GDND(out, word5);
			macro_elimina_GDND(out, word3);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_nom_adj_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word4.tl(attr_a_nom)
				         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word4.tl(attr_gen_mf)
				         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word4.tl(attr_nbr_sp)
				         +word4.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
				         +word3.tl(attr_lemq)
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
				         var_adjectiu1
				         +word2.tl(attr_lemh)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         +word5.tl(attr_a_nom)
				         +word5.tl(attr_gen)
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
	}
	
	// REGLA: NOM1 NOM2 NOM3 NOM4-> NOM4 de NOM3 de NOM2 de NOM1 (video game design industry -> indústria de disseny de joc de vídeo (?)
	public void rule67__nom__nom__nom__nomcomu(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule67__nom__nom__nom__nomcomu",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_elimina_GDND(out, word1);
		macro_elimina_GDND(out, word2);
		macro_elimina_GDND(out, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_pr_nom_pr_nom_pr_nom"));
		out.append("<SN><UNDET>");
		out.append(word4.tl(attr_gen));
		out.append(word4.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen)==""?"" : "<3>")
			         +(word4.tl(attr_nbr)==""?"" : "<4>")
			         +word4.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		out.append("^de<pr>$ ");
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
			         +word3.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		out.append("^de<pr>$ ");
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
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
		out.append("^de<pr>$ ");
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +word1.tl(attr_gen)
			         +word1.tl(attr_nbr)
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
	
	// REGLA: DET NOM1 NOM2 NOM3 NOM4-> DET NOM4 de NOM3 de NOM2 de NOM1 (the video game design industry -> la indústria de disseny de joc de vídeo (?)
	public void rule68__det__nom__nom__nom__nomcomu(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule68__det__nom__nom__nom__nomcomu",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		if (!(list_tractaments.containsIgnoreCase(word5.sl(attr_lem))
    || list_days.containsIgnoreCase(word5.sl(attr_lem))))
		{
			macro_f_concord2(out, word5, " ", word1);
			macro_elimina_GDND(out, word2);
			macro_elimina_GDND(out, word3);
			macro_elimina_GDND(out, word4);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_nom_pr_nom_pr_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         word5.tl(attr_lemh)
				         +word5.tl(attr_a_nom)
				         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word5.tl(attr_gen_mf)
				         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word5.tl(attr_nbr_sp)
				         +word5.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word4.tl(attr_lemh)
				         +word4.tl(attr_a_nom)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
				         +word4.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank3);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank4);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +word2.tl(attr_gen)
				         +word2.tl(attr_nbr)
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
		else
		{
			macro_f_concord2(out, word4, " ", word1);
			macro_elimina_GDND(out, word2);
			macro_elimina_GDND(out, word3);
			macro_elimina_GDND(out, word5);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_pr_nom_pr_nom_nom"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word4.tl(attr_a_nom)
				         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word4.tl(attr_gen_mf)
				         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word4.tl(attr_nbr_sp)
				         +word4.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank2);
			out.append("^de<pr>$ ");
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
				         +word3.tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blank3);
			out.append("^de<pr>$");
			out.append(blank4);
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +word2.tl(attr_gen)
				         +word2.tl(attr_nbr)
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
				         word5.tl(attr_lemh)
				         +word5.tl(attr_a_nom)
				         +word5.tl(attr_gen)
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
	}
	
	// REGLA: NOM1 and NOM2 -> NOM1 i NOM2
	public void rule69__nom__cnjcoo__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule69__nom__cnjcoo__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_elimina_GDND(out, word3);
		macro_elimina_GDND(out, word1);
		/** To determine value of variables of gender */
		if ((word1.tl(attr_gen).equals("<f>")
    && word3.tl(attr_gen).equals("<f>")))
		{
			var_genere = "<f>";
		}
		else
		{
			var_genere = "<m>";
		}
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_conj_nom"));
		out.append("<SN><UNDET>");
		out.append(var_genere);
		out.append("<pl>{");
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +word1.tl(attr_gen)
			         +word1.tl(attr_nbr)
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
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
	
	// REGLA: NOM1 and NOM2 NOM3 (BCN  safety and security issues)
	public void rule70__nom__cnjcoo__nom__nomcomu(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule70__nom__cnjcoo__nom__nomcomu",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_elimina_GDND(out, word1);
		macro_elimina_GDND(out, word3);
		macro_elimina_GDND(out, word4);
		/** To determine value of variables of gender */
		if ((word1.tl(attr_gen).equals("<f>")
    && word3.tl(attr_gen).equals("<f>")))
		{
			var_genere = "<f>";
		}
		else
		{
			var_genere = "<m>";
		}
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_conj_nom_pr_nom"));
		out.append("<SN><UNDET>");
		out.append(var_genere);
		out.append("<pl>{");
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +word1.tl(attr_gen)
			         +word1.tl(attr_nbr)
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
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
			         +word4.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank3);
		out.append("^de<pr>$ ");
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
	
	// REGLA: ADJ NOM1 and NOM2 -> NOM1 i NOM2 ADJ ('native plants and animals')
	public void rule71__adj__nom__cnjcoo__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule71__adj__nom__cnjcoo__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_elimina_GDND(out, word2);
		macro_elimina_GDND(out, word4);
		macro_f_concord2(out, word2, " ", word1);
		macro_comparatiu_adj1(out, word1);
		/** To determine value of variables of gender and
		    number */
		if ((word2.tl(attr_gen).equals("<f>")
    && word4.tl(attr_gen).equals("<f>")))
		{
			var_genere = "<f>";
		}
		else
		{
			var_genere = "<m>";
		}
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_conj_nom_adj"));
		out.append("<SN><UNDET>");
		out.append(var_genere);
		out.append("<pl>{");
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
			         +word4.tl(attr_lemq)
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
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
			         var_adjectiu1
			         +word1.tl(attr_lemh)
			         +word1.tl(attr_a_adj)
			         +word1.tl(attr_gen)
			         +word1.tl(attr_nbr)
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
	
	/**  SINTAGMES NOMINALS AMB GENITIU   <rule comment="REGLA: NOM1 GENITIU NOM2 (Mexico's history)">
      <pattern>
	<pattern-item n="nom"/>
	<pattern-item n="genitiu"/>
	<pattern-item n="nom"/>
      </pattern>
      <action>
	<call-macro n="firstWord">
	  <with-param pos="1"/>
	</call-macro>
	<call-macro n="elimina_GDND">
	  <with-param pos="1"/>
	</call-macro>
	<choose>
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="3" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <var n="gen_chunk"/>
	      <clip pos="3" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>	    
	    <let>
	      <var n="gen_chunk"/>
	      <lit-tag v="GD"/>
	    </let>
	  </otherwise>
	</choose>
	<out> 
	  <chunk name="nom_genitiu_nom" case="caseFirstWord">
	    <tags>
	      <tag><lit-tag v="SN"/></tag>
		  <tag><var n="tipus_det"/></tag>
	      <tag><var n="gen_chunk"/></tag>
	      <tag><clip pos="3" side="tl" part="nbr"/></tag>
	    </tags>
	    <lu>
	      <lit v="el"/>
	      <lit-tag v="det.def.3.4"/>
	    </lu>
	    <b pos="2"/>
	    <lu> 
	      <clip pos="3" side="tl" part="lemh"/> 
	      <clip pos="3" side="tl" part="a_nom"/>
	      <clip pos="3" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="3" side="tl" part="gen_mf"/>
	      <clip pos="3" side="tl" part="nbr" link-to="4"/>
	      <clip pos="3" side="tl" part="lemq"/>  
	    </lu> 
	    <b/>
	    <lu>
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b/>
	    <lu> 
	      <clip pos="1" side="tl" part="lemh"/> 
	      <clip pos="1" side="tl" part="a_nom"/>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="1" side="tl" part="nbr"/>
	      <clip pos="1" side="tl" part="lemq"/>  
	    </lu> 
	  </chunk>
	</out>
      </action>
    </rule>  <rule comment="REGLA: DET NOM1 GENITIU NOM2 (my mother's house)">
      <pattern>
	<pattern-item n="det"/>
	<pattern-item n="nom"/>
	<pattern-item n="genitiu"/>
	<pattern-item n="nom"/>
      </pattern>
      <action>
	<call-macro n="firstWord">
	  <with-param pos="1"/>
	</call-macro>
	<call-macro n="elimina_GDND">
	  <with-param pos="2"/>
	</call-macro>
	<choose><!-s-  concordança det pos1 i nom pos2 (no es pot deixar GD ni ND-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="2" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="2" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>
	    <let>
	      <clip pos="1" side="tl" part="gen"/>
	      <lit-tag v="m"/>
	    </let>
	  </otherwise>
	</choose>
	<choose>
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="2" side="tl" part="nbr"/>
		  <lit-tag v="sp"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <clip pos="1" side="tl" part="nbr"/>
	      <clip pos="2" side="tl" part="nbr"/>
	    </let>
	  </when>
	  <otherwise>
	    <let>
	      <clip pos="1" side="tl" part="nbr"/>
	      <lit-tag v="sg"/>
	    </let>
	  </otherwise>
	</choose> 

	<choose><!-s- concordança nom4 amb det afegit-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="4" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <var n="gen_chunk"/>
	      <clip pos="4" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>	    
	    <let>
	      <var n="gen_chunk"/>
	      <lit-tag v="GD"/>
	    </let>
	  </otherwise>
	</choose>

	<out> 
	  <chunk name="det_nom_genitiu_nom" case="caseFirstWord">
	    <tags>
	      <tag><lit-tag v="SN"/></tag>
		  <tag><var n="tipus_det"/></tag>
	      <tag><var n="gen_chunk"/></tag>
	      <tag><clip pos="4" side="tl" part="nbr"/></tag>
	    </tags>
	    <lu>
	      <lit v="el"/>
	      <lit-tag v="det.def.3.4"/>
	    </lu>
	    <b pos="1"/>
	    <lu> 
	      <clip pos="4" side="tl" part="lemh"/> 
	      <clip pos="4" side="tl" part="a_nom"/>
	      <clip pos="4" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="4" side="tl" part="gen_mf"/>
	      <clip pos="4" side="tl" part="nbr" link-to="4"/>
	      <clip pos="4" side="tl" part="lemq"/>  
	    </lu> 
	    <b pos="3"/>
	    <lu>
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b/>
	    <lu>   
	      <clip pos="1" side="tl" part="lem"/> 
	      <clip pos="1" side="tl" part="a_det"/>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="1" side="tl" part="nbr"/>
	    </lu> 
	    <b/>
	    <lu> 
	      <clip pos="2" side="tl" part="lemh"/> 
	      <clip pos="2" side="tl" part="a_nom"/>
	      <clip pos="2" side="tl" part="gen"/>
	      <clip pos="2" side="tl" part="nbr"/>
	      <clip pos="2" side="tl" part="lemq"/>  
	    </lu> 
	  </chunk>
	</out>
      </action>
    </rule>  <rule comment="REGLA: NOM1 GENITIU ADJ NOM2 (Mexico's long history)">
      <pattern>
	<pattern-item n="nom"/>
	<pattern-item n="genitiu"/>
	<pattern-item n="adj2"/>
	<pattern-item n="nom"/>
      </pattern>
      <action>
	<call-macro n="firstWord">
	  <with-param pos="1"/>
	</call-macro>
	<call-macro n="comparatiu_adj1">
	  <with-param pos="3"/>
	</call-macro>  
	<call-macro n="elimina_GDND">
	  <with-param pos="1"/>
	</call-macro> 
	<call-macro n="f_concord2">
	  <with-param pos="4"/>
	  <with-param pos="3"/>
	</call-macro> 

	<choose><!-s- concordança nom4 amb det afegit-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="4" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <var n="gen_chunk"/>
	      <clip pos="4" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>	    
	    <let>
	      <var n="gen_chunk"/>
	      <lit-tag v="GD"/>
	    </let>
	  </otherwise>
	</choose>
	<out> 
	  <chunk name="nom_genitiu_adj_nom" case="caseFirstWord">
	    <tags>
	      <tag><lit-tag v="SN"/></tag>
		  <tag><var n="tipus_det"/></tag>
	      <tag><var n="gen_chunk"/></tag>
	      <tag><var n="nbr_chunk"/></tag>
	    </tags>
	    <lu>
	      <lit v="el"/>
	      <lit-tag v="det.def.3.4"/>
	    </lu>
	    <b pos="2"/>
	    <lu> 
	      <clip pos="4" side="tl" part="lemh"/> 
	      <clip pos="4" side="tl" part="a_nom"/>
	      <clip pos="4" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="4" side="tl" part="gen_mf"/>
	      <clip pos="4" side="tl" part="nbr_sense_sp" link-to="4"/>
	      <clip pos="4" side="tl" part="nbr_sp"/>
	      <clip pos="4" side="tl" part="lemq"/>  
	    </lu> 
	    <b pos="3"/>
	    <lu> 
	      <var n="adjectiu1"/>   
	      <clip pos="3" side="tl" part="lem"/> 
	      <clip pos="3" side="tl" part="a_adj"/>
	      <clip pos="3" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="3" side="tl" part="gen_mf"/>
	      <clip pos="3" side="tl" part="nbr_sense_sp" link-to="4"/>
	      <clip pos="3" side="tl" part="nbr_sp"/>
	    </lu> 
	    <b/>
	    <lu>
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b/>
	    <lu> 
	      <clip pos="1" side="tl" part="lemh"/> 
	      <clip pos="1" side="tl" part="a_nom"/>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="1" side="tl" part="nbr"/>
	      <clip pos="1" side="tl" part="lemq"/>  
	    </lu> 
	  </chunk>
	</out>
      </action>
    </rule>    <rule comment="REGLA: DET NOM GENITIU DET NOM (my mother's first house)">
      <pattern>
	<pattern-item n="det"/>
	<pattern-item n="nom"/>
	<pattern-item n="genitiu"/>
	<pattern-item n="det2"/>
	<pattern-item n="nom"/>
      </pattern>
      <action>
	<call-macro n="firstWord">
	  <with-param pos="1"/>
	</call-macro>
	<call-macro n="f_concord2">
	  <with-param pos="5"/>
	  <with-param pos="4"/>
	</call-macro> 
	<call-macro n="elimina_GDND">
	  <with-param pos="2"/>
	</call-macro>
	<choose><!-s-  concordança det pos1 i nom pos2 (no es pot deixar GD ni ND-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="2" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="2" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>
	    <let>
	      <clip pos="1" side="tl" part="gen"/>
	      <lit-tag v="m"/>
	    </let>
	  </otherwise>
	</choose>
	<choose>
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="2" side="tl" part="nbr"/>
		  <lit-tag v="sp"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <clip pos="1" side="tl" part="nbr"/>
	      <clip pos="2" side="tl" part="nbr"/>
	    </let>
	  </when>
	  <otherwise>
	    <let>
	      <clip pos="1" side="tl" part="nbr"/>
	      <lit-tag v="sg"/>
	    </let>
	  </otherwise>
	</choose> 
	<choose><!-s- concordança nom5 amb det afegit-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="5" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <var n="gen_chunk"/>
	      <clip pos="5" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>	    
	    <let>
	      <var n="gen_chunk"/>
	      <lit-tag v="GD"/>
	    </let>
	  </otherwise>
	</choose>
	<out> 
	  <chunk name="det_nom_genitiu_det_nom" case="caseFirstWord">
	    <tags>
	      <tag><lit-tag v="SN"/></tag>
		  <tag><var n="tipus_det"/></tag>
	      <tag><var n="gen_chunk"/></tag>
	      <tag><var n="nbr_chunk"/></tag>
	    </tags>
	    <lu>
	      <lit v="el"/>
	      <lit-tag v="det.def.3.4"/>
	    </lu>
	    <b pos="1"/>
	    <lu>
	      <clip pos="4" side="tl" part="lem"/> 
	      <clip pos="4" side="tl" part="a_det"/>
	      <clip pos="4" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="4" side="tl" part="gen_mf"/>
	      <clip pos="4" side="tl" part="nbr_sense_sp" link-to="4"/>
	      <clip pos="4" side="tl" part="nbr_sp"/>
	    </lu> 
	    <b pos="3"/>
	    <lu> 
	      <clip pos="5" side="tl" part="lemh"/> 
	      <clip pos="5" side="tl" part="a_nom"/>
	      <clip pos="5" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="5" side="tl" part="gen_mf"/>
	      <clip pos="5" side="tl" part="nbr_sense_sp" link-to="4"/>
	      <clip pos="5" side="tl" part="nbr_sp"/>
	      <clip pos="5" side="tl" part="lemq"/>  
	    </lu> 
	    <b pos="4"/>
	    <lu>
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b/>
	    <lu>   
	      <clip pos="1" side="tl" part="lem"/> 
	      <clip pos="1" side="tl" part="a_det"/>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="1" side="tl" part="nbr"/>
	    </lu> 
	    <b/>
	    <lu> 
	      <clip pos="2" side="tl" part="lemh"/> 
	      <clip pos="2" side="tl" part="a_nom"/>
	      <clip pos="2" side="tl" part="gen"/>
	      <clip pos="2" side="tl" part="nbr"/>
	      <clip pos="2" side="tl" part="lemq"/>  
	    </lu> 
	  </chunk>
	</out>
      </action>
    </rule>  <rule comment="REGLA: DET NOM1 GENITIU ADJ NOM2 (my mother's big house)">
      <pattern>
	<pattern-item n="det"/>
	<pattern-item n="nom"/>
	<pattern-item n="genitiu"/>
	<pattern-item n="adj2"/>
	<pattern-item n="nom"/>
      </pattern>
      <action>
	<call-macro n="firstWord">
	  <with-param pos="1"/>
	</call-macro>
	<call-macro n="comparatiu_adj1">
	  <with-param pos="4"/>
	</call-macro>  
	<call-macro n="f_concord2">
	  <with-param pos="5"/>
	  <with-param pos="4"/>
	</call-macro> 
	<call-macro n="elimina_GDND">
	  <with-param pos="2"/>
	</call-macro>
	<choose><!-s-  concordança det pos1 i nom pos2 (no es pot deixar GD ni ND-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="2" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="2" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>
	    <let>
	      <clip pos="1" side="tl" part="gen"/>
	      <lit-tag v="m"/>
	    </let>
	  </otherwise>
	</choose>
	<choose>
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="2" side="tl" part="nbr"/>
		  <lit-tag v="sp"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <clip pos="1" side="tl" part="nbr"/>
	      <clip pos="2" side="tl" part="nbr"/>
	    </let>
	  </when>
	  <otherwise>
	    <let>
	      <clip pos="1" side="tl" part="nbr"/>
	      <lit-tag v="sg"/>
	    </let>
	  </otherwise>
	</choose> 
	<choose><!-s- concordança nom5 amb det afegit-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="5" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <var n="gen_chunk"/>
	      <clip pos="5" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>	    
	    <let>
	      <var n="gen_chunk"/>
	      <lit-tag v="GD"/>
	    </let>
	  </otherwise>
	</choose>
	<out> 
	  <chunk name="det_nom_genitiu_adj_nom" case="caseFirstWord">
	    <tags>
	      <tag><lit-tag v="SN"/></tag>
		  <tag><var n="tipus_det"/></tag>
	      <tag><var n="gen_chunk"/></tag>
	      <tag><var n="nbr_chunk"/></tag>
	    </tags>
	    <lu>
	      <lit v="el"/>
	      <lit-tag v="det.def.3.4"/>
	    </lu>
	    <b pos="1"/>
	    <lu> 
	      <clip pos="5" side="tl" part="lemh"/> 
	      <clip pos="5" side="tl" part="a_nom"/>
	      <clip pos="5" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="5" side="tl" part="gen_mf"/>
	      <clip pos="5" side="tl" part="nbr_sense_sp" link-to="4"/>
	      <clip pos="5" side="tl" part="nbr_sp"/>
	      <clip pos="5" side="tl" part="lemq"/>  
	    </lu> 
	    <b pos="3"/>
	    <lu> 
	      <var n="adjectiu1"/>   
	      <clip pos="4" side="tl" part="lem"/> 
	      <clip pos="4" side="tl" part="a_adj"/>
	      <clip pos="4" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="4" side="tl" part="gen_mf"/>
	      <clip pos="4" side="tl" part="nbr_sense_sp" link-to="4"/>
	      <clip pos="4" side="tl" part="nbr_sp"/>
	    </lu> 
	    <b pos="4"/>
	    <lu>
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b/>
	    <lu>   
	      <clip pos="1" side="tl" part="lem"/> 
	      <clip pos="1" side="tl" part="a_det"/>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="1" side="tl" part="nbr"/>
	    </lu> 
	    <b/>
	    <lu> 
	      <clip pos="2" side="tl" part="lemh"/> 
	      <clip pos="2" side="tl" part="a_nom"/>
	      <clip pos="2" side="tl" part="gen"/>
	      <clip pos="2" side="tl" part="nbr"/>
	      <clip pos="2" side="tl" part="lemq"/>  
	    </lu> 
	  </chunk>
	</out>
      </action>
    </rule>   <rule comment="REGLA: DET NOM1 GENITIU NUM NOM2 (my mother's two houses)">
      <pattern>
	<pattern-item n="det"/>
	<pattern-item n="nom"/>
	<pattern-item n="genitiu"/>
	<pattern-item n="num"/>
	<pattern-item n="nom"/>
      </pattern>
      <action>
	<call-macro n="firstWord">
	  <with-param pos="1"/>
	</call-macro>
	<call-macro n="million">
	  <with-param pos="4"/>
	</call-macro>
	<call-macro n="flexio_numerals">
	  <with-param pos="4"/>
	  <with-param pos="5"/>
	</call-macro> 
	<call-macro n="f_concord2">
	  <with-param pos="5"/>
	  <with-param pos="4"/>
	</call-macro> 
	<call-macro n="elimina_GDND">
	  <with-param pos="2"/>
	</call-macro>
	<choose><!-s-  concordança det pos1 i nom pos2 (no es pot deixar GD ni ND-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="2" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="2" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>
	    <let>
	      <clip pos="1" side="tl" part="gen"/>
	      <lit-tag v="m"/>
	    </let>
	  </otherwise>
	</choose>
	<choose>
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="2" side="tl" part="nbr"/>
		  <lit-tag v="sp"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <clip pos="1" side="tl" part="nbr"/>
	      <clip pos="2" side="tl" part="nbr"/>
	    </let>
	  </when>
	  <otherwise>
	    <let>
	      <clip pos="1" side="tl" part="nbr"/>
	      <lit-tag v="sg"/>
	    </let>
	  </otherwise>
	</choose> 
	<choose><!-s- concordança nom5 amb det afegit-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="5" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <var n="gen_chunk"/>
	      <clip pos="5" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>	    
	    <let>
	      <var n="gen_chunk"/>
	      <lit-tag v="GD"/>
	    </let>
	  </otherwise>
	</choose>
	<out> 
	  <chunk name="det_nom_genitiu_num_nom" case="caseFirstWord">
	    <tags>
	      <tag><lit-tag v="SN"/></tag>
		  <tag><var n="tipus_det"/></tag>
	      <tag><var n="gen_chunk"/></tag>
	      <tag><var n="nbr_chunk"/></tag>
	    </tags>
	    <lu>
	      <lit v="el"/>
	      <lit-tag v="det.def.3.4"/>
	    </lu>
	    <b pos="1"/>
	    <lu>
	      <clip pos="4" side="tl" part="lem"/>  
	      <clip pos="4" side="tl" part="a_num"/> 
	      <clip pos="4" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="4" side="tl" part="gen_mf"/>
	      <clip pos="4" side="tl" part="nbr_sense_sp" link-to="4"/>
	      <clip pos="4" side="tl" part="nbr_sp"/>
	    </lu> 
	    <b pos="3"/>
	    <lu> 
	      <clip pos="5" side="tl" part="lemh"/> 
	      <clip pos="5" side="tl" part="a_nom"/>
	      <clip pos="5" side="tl" part="gen" link-to="3"/>
	      <clip pos="5" side="tl" part="nbr" link-to="4"/>
	      <clip pos="5" side="tl" part="lemq"/>  
	    </lu> 
	    <b pos="4"/>
	    <lu> 
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b/>
	    <lu>   
	      <clip pos="1" side="tl" part="lem"/> 
	      <clip pos="1" side="tl" part="a_det"/>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="1" side="tl" part="nbr"/>
	    </lu> 
	    <b/>
	    <lu> 
	      <clip pos="2" side="tl" part="lemh"/> 
	      <clip pos="2" side="tl" part="a_nom"/>
	      <clip pos="2" side="tl" part="gen"/>
	      <clip pos="2" side="tl" part="nbr"/>
	      <clip pos="2" side="tl" part="lemq"/>  
	    </lu> 
	  </chunk>
	</out>
      </action>
    </rule>  <rule comment="REGLA: ADJ NOM GENITIU NOM">
      <pattern>
	<pattern-item n="adj2"/>
	<pattern-item n="nom"/>
	<pattern-item n="genitiu"/>
	<pattern-item n="nom"/>
      </pattern>
      <action>
	<call-macro n="genere_nombre">
	  <with-param pos="2"/>
	</call-macro>
	<call-macro n="firstWord">
	  <with-param pos="1"/>
	</call-macro>
	<call-macro n="comparatiu_adj1">
	  <with-param pos="1"/>
	</call-macro>  	
	<call-macro n="elimina_GDND"><!-s-concordança adj1 i nom2 -s->
	  <with-param pos="2"/>
	</call-macro>   
	<call-macro n="posa_GDND">
	  <with-param pos="1"/>
	</call-macro>
	<choose>
	  <when>
	    <test>
	      <equal>
		<clip pos="1" side="tl" part="gen"/>
		<lit-tag v="GD"/>
	      </equal>
	    </test>
	    <choose>
	      <when>
		<test>
		  <not>
		    <equal>
		      <clip pos="2" side="tl" part="gen"/>
		      <lit-tag v="mf"/>
		    </equal>
		  </not>
		</test>
		<let>
		  <clip pos="1" side="tl" part="gen"/>
		  <clip pos="2" side="tl" part="gen"/>
		</let>
	      </when>
	      <otherwise>
		<let>
		  <clip pos="1" side="tl" part="gen"/>
		  <lit-tag v="m"/>
		</let>
	      </otherwise>
	    </choose>
	  </when>
	</choose>
	<choose>
	  <when>
	    <test>
	      <equal>
		<clip pos="1" side="tl" part="nbr"/>
		<lit-tag v="ND"/>
	      </equal>
	    </test>
	    <choose>
	      <when>
		<test>
		  <not>
		    <equal>
		      <clip pos="2" side="tl" part="nbr"/>
		      <lit-tag v="sp"/>
		    </equal>
		  </not>
		</test>
		<let>
		  <clip pos="1" side="tl" part="nbr"/>
		  <clip pos="2" side="tl" part="nbr"/>
		</let>
	      </when>
	      <otherwise>
		<let>
		  <clip pos="1" side="tl" part="nbr"/>
		  <lit-tag v="sg"/>
		</let>
	      </otherwise>
	    </choose>
	  </when>
	</choose>
	<choose><!-s- concordança nom4 amb det afegit-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="4" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <var n="gen_chunk"/>
	      <clip pos="4" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>	    
	    <let>
	      <var n="gen_chunk"/>
	      <lit-tag v="GD"/>
	    </let>
	  </otherwise>
	</choose>
	<out> 
	  <chunk name="adj_nom_genitiu_nom" case="caseFirstWord">
	    <tags>
	      <tag><lit-tag v="SN"/></tag>
		  <tag><var n="tipus_det"/></tag>
	      <tag><var n="gen_chunk"/></tag>
	      <tag><clip pos="4" side="tl" part="nbr"/></tag>
	    </tags>
	    <lu>
	      <lit v="el"/>
	      <lit-tag v="det.def.3.4"/>
	    </lu>
	    <b pos="1"/>
	    <lu> 
	      <clip pos="4" side="tl" part="lemh"/> 
	      <clip pos="4" side="tl" part="a_nom"/>
	      <clip pos="4" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="4" side="tl" part="gen_mf"/>
	      <clip pos="4" side="tl" part="nbr_sense_sp" link-to="4"/>
	      <clip pos="4" side="tl" part="nbr_sp"/>
	      <clip pos="4" side="tl" part="lemq"/>  
	    </lu> 
	    <b pos="3"/>
	    <lu>   
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b/>
	    <lu>
	      <lit v="el"/><!-s-Està bé posar l'article davant el primer nom? -s->
	      <lit-tag v="det.def"/>
	      <var n="genere"/>
	      <var n="nombre"/>
	    </lu>
	    <b/>
	    <lu> 
	      <clip pos="2" side="tl" part="lemh"/> 
	      <clip pos="2" side="tl" part="a_nom"/>
	      <clip pos="2" side="tl" part="gen"/>
	      <clip pos="2" side="tl" part="nbr"/>
	      <clip pos="2" side="tl" part="lemq"/> 
	    </lu>
	    <b/>
	    <lu> 
	      <var n="adjectiu1"/>   
	      <clip pos="1" side="tl" part="lem"/> 
	      <clip pos="1" side="tl" part="a_adj"/>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="1" side="tl" part="nbr"/>
	    </lu> 
	  </chunk>
	</out>
      </action>
    </rule> 
    <rule comment="REGLA: NOM GENITIU NOM NOM (Mexico's emergencies ministry)">
      <pattern>
	<pattern-item n="nom"/>
	<pattern-item n="genitiu"/>
	<pattern-item n="nom"/>
	<pattern-item n="nom"/>
      </pattern>
      <action>
	<call-macro n="elimina_GDND">
	  <with-param pos="1"/>
	</call-macro>
	<call-macro n="elimina_GDND">
	  <with-param pos="3"/>
	</call-macro>
	<call-macro n="firstWord">
	  <with-param pos="1"/>
	</call-macro>
	<choose><!-s- concordança nom4 amb det afegit-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="4" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <var n="gen_chunk"/>
	      <clip pos="4" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>	    
	    <let>
	      <var n="gen_chunk"/>
	      <lit-tag v="GD"/>
	    </let>
	  </otherwise>
	</choose>
	<out> 
	  <chunk name="nom_genitiu_nom_nom" case="caseFirstWord">
	    <tags>
	      <tag><lit-tag v="SN"/></tag>
		  <tag><var n="tipus_det"/></tag>
	      <tag><var n="gen_chunk"/></tag>
	      <tag><clip pos="4" side="tl" part="nbr"/></tag>
	    </tags>
	    <lu>
	      <lit v="el"/>
	      <lit-tag v="det.def.3.4"/>
	    </lu>
	    <b pos="2"/>
	    <lu> 
	      <clip pos="4" side="tl" part="lemh"/> 
	      <clip pos="4" side="tl" part="a_nom"/>
	      <clip pos="4" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="4" side="tl" part="gen_mf"/>
	      <clip pos="4" side="tl" part="nbr" link-to="4"/>
	      <clip pos="4" side="tl" part="lemq"/>  
	    </lu> 
	    <b/>
	    <lu>
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b pos="3"/>
	    <lu> 
	      <clip pos="3" side="tl" part="lemh"/> 
	      <clip pos="3" side="tl" part="a_nom"/>
	      <clip pos="3" side="tl" part="gen"/>
	      <clip pos="3" side="tl" part="nbr"/>
	      <clip pos="3" side="tl" part="lemq"/> 
	    </lu>
	    <b/>
	    <lu>   
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b/>
	    <lu> 
	      <clip pos="1" side="tl" part="lemh"/> 
	      <clip pos="1" side="tl" part="a_nom"/>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="1" side="tl" part="nbr"/>
	      <clip pos="1" side="tl" part="lemq"/>  
	    </lu> 
	  </chunk>
	</out>
      </action>
    </rule> 

   <rule comment="REGLA: NOM GENITIU NOM NOM NOM (Colombia's child welfare agency)">
      <pattern>
	<pattern-item n="nom"/>
	<pattern-item n="genitiu"/>
	<pattern-item n="nom"/>
	<pattern-item n="nom"/>
	<pattern-item n="nom"/>
      </pattern>
      <action>
	<call-macro n="elimina_GDND">
	  <with-param pos="1"/>
	</call-macro>
	<call-macro n="elimina_GDND">
	  <with-param pos="3"/>
	</call-macro>
	<call-macro n="elimina_GDND">
	  <with-param pos="4"/>
	</call-macro>
	<call-macro n="firstWord">
	  <with-param pos="1"/>
	</call-macro>
	<choose><!-s- concordança nom5 amb det afegit-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="5" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <var n="gen_chunk"/>
	      <clip pos="5" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>	    
	    <let>
	      <var n="gen_chunk"/>
	      <lit-tag v="GD"/>
	    </let>
	  </otherwise>
	</choose>
	<out> 
	  <chunk name="nom_genitiu_nom_nom_nom" case="caseFirstWord">
	    <tags>
	      <tag><lit-tag v="SN"/></tag>
		  <tag><var n="tipus_det"/></tag>
	      <tag><var n="gen_chunk"/></tag>
	      <tag><clip pos="5" side="tl" part="nbr"/></tag>
	    </tags>
	    <lu>
	      <lit v="el"/>
	      <lit-tag v="det.def.3.4"/>
	    </lu>
	    <b pos="2"/>
	    <lu> 
	      <clip pos="5" side="tl" part="lemh"/> 
	      <clip pos="5" side="tl" part="a_nom"/>
	      <clip pos="5" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="5" side="tl" part="gen_mf"/>
	      <clip pos="5" side="tl" part="nbr" link-to="4"/>
	      <clip pos="5" side="tl" part="lemq"/>  
	    </lu> 
	    <b/>
	    <lu>
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b pos="3"/>
	    <lu> 
	      <clip pos="4" side="tl" part="lemh"/> 
	      <clip pos="4" side="tl" part="a_nom"/>
	      <clip pos="4" side="tl" part="gen"/>
	      <clip pos="4" side="tl" part="nbr"/>
	      <clip pos="4" side="tl" part="lemq"/> 
	    </lu>
	    <b pos="4"/>
	    <lu>   
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b/>
	    <lu> 
	      <clip pos="3" side="tl" part="lemh"/> 
	      <clip pos="3" side="tl" part="a_nom"/>
	      <clip pos="3" side="tl" part="gen"/>
	      <clip pos="3" side="tl" part="nbr"/>
	      <clip pos="3" side="tl" part="lemq"/>  
	    </lu> 
	    <b/>
	    <lu>   
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b/>
	    <lu> 
	      <clip pos="1" side="tl" part="lemh"/> 
	      <clip pos="1" side="tl" part="a_nom"/>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="1" side="tl" part="nbr"/>
	      <clip pos="1" side="tl" part="lemq"/>  
	    </lu>
	  </chunk>
	</out>
      </action>
    </rule> 
    <rule comment="REGLA: DET ADJ NOM GENITIU NOM (the American public's imagination)">
      <pattern>
	<pattern-item n="det"/>
	<pattern-item n="adj2"/>
	<pattern-item n="nom"/>
	<pattern-item n="genitiu"/>
	<pattern-item n="nom"/>
      </pattern>
      <action>
	<call-macro n="firstWord">
	  <with-param pos="1"/>
	</call-macro>
	<call-macro n="comparatiu_adj1">
	  <with-param pos="2"/>
	</call-macro> 
	<call-macro n="elimina_GDND"><!-s-concordança det1, adj2 i nom3 -s->
	  <with-param pos="3"/>
	</call-macro> 
	<call-macro n="posa_GDND">
	  <with-param pos="2"/>
	</call-macro>  
	<choose>
	<when>
	  <test>
	    <equal>
	      <clip pos="2" side="tl" part="gen"/>
	      <lit-tag v="GD"/>
	    </equal>
	  </test>
	  <choose>
	    <when>
	      <test>
		<not>
		  <equal>
		    <clip pos="3" side="tl" part="gen"/>
		    <lit-tag v="mf"/>
		  </equal>
		</not>
	      </test>
	      <let>
		<clip pos="2" side="tl" part="gen"/>
		<clip pos="3" side="tl" part="gen"/>
	      </let>
	    </when>
	    <otherwise>
	      <let>
		<clip pos="2" side="tl" part="gen"/>
		<lit-tag v="m"/>
	      </let>
	    </otherwise>
	  </choose>
	</when>
	</choose>
	<choose>
	<when>
	  <test>
	    <equal>
	      <clip pos="2" side="tl" part="nbr"/>
	      <lit-tag v="ND"/>
	    </equal>
	  </test>
	  <choose>
	    <when>
	      <test>
		<not>
		  <equal>
		    <clip pos="3" side="tl" part="nbr"/>
		    <lit-tag v="sp"/>
		  </equal>
		</not>
	      </test>
	      <let>
		<clip pos="2" side="tl" part="nbr"/>
		<clip pos="3" side="tl" part="nbr"/>
	      </let>
	    </when>
	    <otherwise>
	      <let>
		<clip pos="2" side="tl" part="nbr"/>
		<lit-tag v="sg"/>
	      </let>
	    </otherwise>
	  </choose>
	</when>
	</choose>

	<choose>
	<when>
	  <test>
	    <equal>
	      <clip pos="1" side="tl" part="gen"/>
	      <lit-tag v="GD"/>
	    </equal>
	  </test>
	  <choose>
	    <when>
	      <test>
		<not>
		  <equal>
		    <clip pos="3" side="tl" part="gen"/>
		    <lit-tag v="mf"/>
		  </equal>
		</not>
	      </test>
	      <let>
		<clip pos="1" side="tl" part="gen"/>
		<clip pos="3" side="tl" part="gen"/>
	      </let>
	    </when>
	    <otherwise>
	      <let>
		<clip pos="1" side="tl" part="gen"/>
		<lit-tag v="m"/>
	      </let>
	    </otherwise>
	  </choose>
	</when>
	</choose>
	<choose>
	<when>
	  <test>
	    <equal>
	      <clip pos="1" side="tl" part="nbr"/>
	      <lit-tag v="ND"/>
	    </equal>
	  </test>
	  <choose>
	    <when>
	      <test>
		<not>
		  <equal>
		    <clip pos="3" side="tl" part="nbr"/>
		    <lit-tag v="sp"/>
		  </equal>
		</not>
	      </test>
	      <let>
		<clip pos="1" side="tl" part="nbr"/>
		<clip pos="3" side="tl" part="nbr"/>
	      </let>
	    </when>
	    <otherwise>
	      <let>
		<clip pos="1" side="tl" part="nbr"/>
		<lit-tag v="sg"/>
	      </let>
	    </otherwise>
	  </choose>
	</when>
	</choose>

	<choose><!-s- concordança nom5 amb det afegit-s->
	  <when>
	    <test>
	      <not>
		<equal>
		  <clip pos="5" side="tl" part="gen"/>
		  <lit-tag v="mf"/>
		</equal>
	      </not>
	    </test>
	    <let>
	      <var n="gen_chunk"/>
	      <clip pos="5" side="tl" part="gen"/>
	    </let>
	  </when>
	  <otherwise>	    
	    <let>
	      <var n="gen_chunk"/>
	      <lit-tag v="GD"/>
	    </let>
	  </otherwise>
	</choose>

	<out> 
	  <chunk name="det_adj_nom_genitiu_nom" case="caseFirstWord">
	    <tags>
	      <tag><lit-tag v="SN"/></tag>
		  <tag><var n="tipus_det"/></tag>
	      <tag><var n="gen_chunk"/></tag>
	      <tag><clip pos="5" side="tl" part="nbr"/></tag>
	    </tags>
	    <lu>
	      <lit v="el"/>
	      <lit-tag v="det.def.3.4"/>
	    </lu>
	    <b pos="1"/>
	    <lu> 
	      <clip pos="5" side="tl" part="lemh"/> 
	      <clip pos="5" side="tl" part="a_nom"/>
	      <clip pos="5" side="tl" part="gen_sense_mf" link-to="3"/>
	      <clip pos="5" side="tl" part="gen_mf"/>
	      <clip pos="5" side="tl" part="nbr" link-to="4"/>
	      <clip pos="5" side="tl" part="lemq"/>  
	    </lu> 
	    <b pos="2"/>
	    <lu>   
	      <lit v="de"/>
	      <lit-tag v="pr"/>
	    </lu>
	    <b pos="4"/>
	    <lu>
	      <clip pos="1" side="tl" part="lem"/> 
	      <clip pos="1" side="tl" part="a_det"/>
	      <clip pos="1" side="tl" part="gen"/>
	      <clip pos="1" side="tl" part="nbr"/>
	    </lu>
	    <b/>
	    <lu> 
	      <clip pos="3" side="tl" part="lemh"/> 
	      <clip pos="3" side="tl" part="a_nom"/>
	      <clip pos="3" side="tl" part="gen"/>
	      <clip pos="3" side="tl" part="nbr"/>
	      <clip pos="3" side="tl" part="lemq"/> 
	    </lu>
	    <b/>
	    <lu> 
	      <var n="adjectiu1"/>   
	      <clip pos="2" side="tl" part="lem"/> 
	      <clip pos="2" side="tl" part="a_adj"/>
	      <clip pos="2" side="tl" part="gen"/>
	      <clip pos="2" side="tl" part="nbr"/>
	    </lu> 
	  </chunk>
	</out>
      </action>
    </rule>  SINTAGMES NOMINALS ALTRES */
	// REGLA: NUM NOM1 OLD -> NUM NOM1 (300 years old - 300 anys)
	public void rule72__num__yearmonth__old(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule72__num__yearmonth__old",  word1, blank1,  word2, blank2,  word3); } 
		macro_f_concord2(out, word2, " ", word1);
		macro_million(out, word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num_yearold"));
		out.append("<SN><NUM>");
		out.append(word2.tl(attr_gen));
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
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
	
	// REGLA: NUM-NOM1-OLD NOM3 -> NOM3 de NUM NOM1(pl) (48-year-old man - home de 48 anys)
	public void rule73__num__guio__yearmonth__guio__old__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule73__num__guio__yearmonth__guio__old__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_million(out, word1);
		macro_f_concord2(out, word3, " ", word1);
		macro_firstWord(out, word1);
		if ((word1.sl(attr_lem).equals("1")
    || word1.sl(attr_lem).equals("one")))
		{
			word3.tlSet(attr_nbr, "<sg>");
		}
		else
		{
			word3.tlSet(attr_nbr, "<pl>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_num_yearold"));
		out.append("<SN><UNDET>");
		out.append(word6.tl(attr_gen));
		out.append(word6.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word6.tl(attr_lemh)
			         +word6.tl(attr_a_nom)
			         +(word6.tl(attr_gen)==""?"" : "<3>")
			         +(word6.tl(attr_nbr)==""?"" : "<4>")
			         +word6.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank5);
		out.append("^de<pr>$ ");
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
		out.append(" ");
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
	
	// REGLA: NUM NOM1 OLD NOM3 -> NOM3 de NUM NOM1(pl) (48 year old man - home de 48 anys)
	public void rule74__num__yearmonth__old__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule74__num__yearmonth__old__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_million(out, word1);
		macro_f_concord2(out, word2, " ", word1);
		macro_firstWord(out, word1);
		if ((word1.sl(attr_lem).equals("1")
    || word1.sl(attr_lem).equals("one")))
		{
			word2.tlSet(attr_nbr, "<sg>");
		}
		else
		{
			word2.tlSet(attr_nbr, "<pl>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_num_yearold"));
		out.append("<SN><UNDET>");
		out.append(word4.tl(attr_gen));
		out.append(word4.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen)==""?"" : "<3>")
			         +(word4.tl(attr_nbr)==""?"" : "<4>")
			         +word4.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		out.append("^de<pr>$");
		out.append(blank2);
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
		out.append(blank3);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
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
	
	// REGLA: DET NUM-NOM1-OLD NOM3 -> DET NOM3 de NUM NOM1(pl) (the 48-year-old man - l'home de 48 anys)
	public void rule75__det__num__guio__yearmonth__guio__old__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6, String blank6, TransferWord word7) throws IOException
	{
		if (debug) { logCall("rule75__det__num__guio__yearmonth__guio__old__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6, blank6,  word7); } 
		macro_million(out, word2);
		macro_f_concord2(out, word4, blank1, word2);
		macro_f_concord2(out, word7, " ", word1);
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		if ((word2.sl(attr_lem).equals("1")
    || word2.sl(attr_lem).equals("one")))
		{
			word4.tlSet(attr_nbr, "<sg>");
		}
		else
		{
			word4.tlSet(attr_nbr, "<pl>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_num_yearold"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word7.tl(attr_lemh)
			         +word7.tl(attr_a_nom)
			         +(word7.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word7.tl(attr_gen_mf)
			         +(word7.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word7.tl(attr_nbr_sp)
			         +word7.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank6);
		out.append("^de<pr>$ ");
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
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
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
	}
	
	// REGLA: DET NUM NOM1 OLD NOM3 -> DET NOM3 de NUM NOM1(pl) (the 48 year old man - l'home de 48 anys)
	public void rule76__det__num__yearmonth__old__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule76__det__num__yearmonth__old__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_million(out, word2);
		macro_determiner(out, word1);
		macro_f_concord2(out, word3, blank1, word2);
		macro_f_concord2(out, word5, " ", word1);
		macro_firstWord(out, word1);
		if ((word2.sl(attr_lem).equals("1")
    || word2.sl(attr_lem).equals("one")))
		{
			word3.tlSet(attr_nbr, "<sg>");
		}
		else
		{
			word3.tlSet(attr_nbr, "<pl>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_num_yearold"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         word5.tl(attr_lemh)
			         +word5.tl(attr_a_nom)
			         +(word5.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word5.tl(attr_gen_mf)
			         +(word5.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word5.tl(attr_nbr_sp)
			         +word5.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank2);
		out.append("^de<pr>$");
		out.append(blank3);
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
		out.append(blank4);
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
	
	// REGLA: NUM-NOM1-OLD NOM3 -> NOM3 de NUM NOM1(pl) (9-year-old - (nen) de 9 anys)
	public void rule77__num__guio__yearmonth__guio__old(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule77__num__guio__yearmonth__guio__old",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_million(out, word1);
		macro_f_concord2(out, word3, " ", word1);
		macro_firstWord(out, word1);
		if (list_numeros25.containsIgnoreCase(word1.sl(attr_lem)))
		{
			var_paraula1 = (""+"nen"+"<n><3><4>");
			var_gen_chunk = "<GD>";
			var_nbr_chunk = "<sg>";
		}
		else
		{
			var_paraula1 = (""+"persona"+"<n><f><sg>");
			var_gen_chunk = "<f>";
			var_nbr_chunk = "<sg>";
		}
		if ((word1.sl(attr_lem).equals("1")
    || word1.sl(attr_lem).equalsIgnoreCase("one")))
		{
			word3.tlSet(attr_nbr, "<sg>");
		}
		else
		{
			word3.tlSet(attr_nbr, "<pl>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_num_yearold"));
		out.append("<SN><UNDET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_paraula1
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$ ");
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
		out.append(" ");
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
	
	// REGLA: NUM-NOM1-OLD NOM3 unknown -> NOM3 de NUM NOM1(pl) unknown (9-year-old xxxxxx - de 9 anys xxxxxx) - quan va abans d'una desconeguda no s'afegeix el nom (nen/persona)
	public void rule78__num__guio__yearmonth__guio__old__descon(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule78__num__guio__yearmonth__guio__old__descon",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_million(out, word1);
		macro_f_concord2(out, word3, " ", word1);
		macro_firstWord(out, word1);
		if ((word1.sl(attr_lem).equals("1")
    || word1.sl(attr_lem).equals("one")))
		{
			word3.tlSet(attr_nbr, "<sg>");
		}
		else
		{
			word3.tlSet(attr_nbr, "<pl>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr_num_yearold"));
		out.append("<SA><mf><sp>{^de<pr>$ ");
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
		out.append(" ");
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
		out.append(blank5);
		out.append("^unknown<unknown>{");
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
		out.append("}$");
	}
	
	// REGLA: DET NUM-NOM1-OLD NOM3 -> DET NOM3 de NUM NOM1(pl) (the 9-year-old - el nen de 9 anys)
	public void rule79__det__num__guio__yearmonth__guio__old(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule79__det__num__guio__yearmonth__guio__old",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_million(out, word2);
		macro_determiner(out, word1);
		macro_f_concord2(out, word4, blank1, word2);
		macro_firstWord(out, word1);
		if (list_numeros25.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_paraula1 = (""+"nen"+"<n><3><4>");
			var_gen_chunk = "<GD>";
			var_nbr_chunk = "<sg>";
		}
		else
		{
			var_paraula1 = (""+"persona"+"<n><f><sg>");
			var_gen_chunk = "<f>";
			var_nbr_chunk = "<sg>";
		}
		if ((word2.sl(attr_lem).equals("1")
    || word2.sl(attr_lem).equalsIgnoreCase("one")))
		{
			word4.tlSet(attr_nbr, "<sg>");
		}
		else
		{
			word4.tlSet(attr_nbr, "<pl>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_num_yearold"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         var_paraula1
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$ ");
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
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
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
	}
	
	// REGLA: DET NUM-NOM1-OLD NOM3 unknown-> DET NOM3 de NUM NOM1(pl) unknown (the 9-year-old xxxxxx - de 9 anys xxxxx)
	public void rule80__det__num__guio__yearmonth__guio__old__descon(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6, String blank6, TransferWord word7) throws IOException
	{
		if (debug) { logCall("rule80__det__num__guio__yearmonth__guio__old__descon",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6, blank6,  word7); } 
		macro_million(out, word2);
		macro_determiner(out, word1);
		macro_f_concord2(out, word4, blank1, word2);
		macro_firstWord(out, word1);
		if ((word2.sl(attr_lem).equals("1")
    || word2.sl(attr_lem).equalsIgnoreCase("one")))
		{
			word4.tlSet(attr_nbr, "<sg>");
		}
		else
		{
			word4.tlSet(attr_nbr, "<pl>");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr_num_yearold"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^de<pr>$");
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
		out.append(" ");
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
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
		out.append(blank6);
		out.append("^unknown<unknown>{");
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
		out.append("}$");
	}
	
	// REGLA: DET NOM ago (a week ago)
	public void rule81__det__nom__ago(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule81__det__nom__ago",  word1, blank1,  word2, blank2,  word3); } 
		macro_det_no(out, word1, blank1, word2);
		macro_determiner(out, word1);
		macro_elimina_GDND(out, word2);
		macro_f_concord2(out, word2, " ", word1);
		macro_elimina_GDND(out, word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "fa_det_nom"));
		out.append("<SP>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append(var_negative);
		out.append('{');
		/**  BCN per recollir si es negacio */
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
		out.append(blank1);
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
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
		out.append(blank2);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
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
	
	// REGLA: NUM NOM ago (two weeks ago)
	public void rule82__num__nom__ago(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule82__num__nom__ago",  word1, blank1,  word2, blank2,  word3); } 
		macro_million(out, word1);
		macro_elimina_GDND(out, word2);
		macro_flexio_numerals(out, word1, blank1, word2);
		macro_f_concord2(out, word2, " ", word1);
		macro_elimina_GDND(out, word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "fa_num_nom"));
		out.append("<SP><NUM>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
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
		out.append(blank1);
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
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
		out.append(blank2);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
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
	
	// REGLA: NOM ago (years ago)
	public void rule83__nom__ago(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule83__nom__ago",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_elimina_GDND(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "fa_nom"));
		out.append("<SADV>");
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
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
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +word1.tl(attr_gen)
			         +word1.tl(attr_nbr)
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
	
	// REGLA: DET NOM hence (several years hence)
	public void rule84__det__periode__hence(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule84__det__periode__hence",  word1, blank1,  word2, blank2,  word3); } 
		macro_det_no(out, word1, blank1, word2);
		macro_elimina_GDND(out, word2);
		macro_f_concord2(out, word2, " ", word1);
		macro_elimina_GDND(out, word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr_det_nom"));
		out.append("<SP><UNDEF>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append(var_negative);
		out.append("{^");
		out.append("d'aquí a");
		out.append("<pr>$");
		out.append(blank1);
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
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
		out.append(blank2);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
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
	
	// REGLA: NUM NOM hence (two weeks hence)
	public void rule85__num__periode__hence(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule85__num__periode__hence",  word1, blank1,  word2, blank2,  word3); } 
		macro_million(out, word1);
		macro_elimina_GDND(out, word2);
		macro_f_concord2(out, word2, " ", word1);
		macro_elimina_GDND(out, word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr_num_nom"));
		out.append("<SP><NUM>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^");
		out.append("d'aquí a");
		out.append("<pr>$");
		out.append(blank1);
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
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
		out.append(blank2);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
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
	
	// REGLA: COMA WHICH (BCN noun, which noun -> el qual)
	public void rule86__coma__which(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule86__coma__which",  word1, blank1,  word2); } 
		macro_firstWord(out, word2);
		out.append("^coma");
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
		out.append(blank1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "relnom"));
		out.append("<REL><nn><GD><ND>{^el qual<rel><nn><3><4>$}$");
	}
	
	// REGLA: PREP WHICH (to which all belong -> 'al qual(rel.nn)' i no 'a que(rel.an.)')
	public void rule87__prep__which(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule87__prep__which",  word1, blank1,  word2); } 
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
		out.append("^relnom<REL><nn><GD><ND>{^el qual<rel><nn><3><4>$}$");
	}
	
	// REGLA: NUMERAL. Si pot ser 'm' o 'f', sortirà com a GD. Caldrà tractar-ho en interchunk o postchunk.
	public void rule88__num(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule88__num",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "num"));
		out.append("<NUM>");
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_num)
			         +(word1.tl(attr_gen)==""?"" : "<2>")
			         +(word1.tl(attr_nbr)==""?"" : "<3>")
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
	
	// REGLA: DETERMINANT 
	public void rule89__det(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule89__det",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det"));
		out.append("<DET>");
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<2>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<3>")
			         +word1.tl(attr_nbr_sp)
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
	
	// REGLA: NOM ( per a col·locar la cua en les multiparaules amb g )
	public void rule90__nom(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule90__nom",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom"));
		out.append("<SN><UNDET>");
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +(word1.tl(attr_gen)==""?"" : "<3>")
			         +(word1.tl(attr_nbr)==""?"" : "<4>")
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
	
	// REGLA: PRONOM
	public void rule91__prnsubj(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule91__prnsubj",  word1); } 
		macro_firstWord(out, word1);
		if (!word1.sl(attr_lem).equalsIgnoreCase("prpers"))
		{
			var_lema = "prnsubj2";
		}
		else
		{
			var_lema = "prnsubj";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema));
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
			         +(word1.tl(attr_tipus_prn)==""?"" : "<2>")
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
	
	// REGLA: PRONOM reflexiu
	public void rule92__prnref(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule92__prnref",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prnref"));
		out.append("<SNref>");
		out.append(word1.tl(attr_tipus_prn));
		out.append(word1.tl(attr_pers));
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_prn)
			         +(word1.tl(attr_tipus_prn)==""?"" : "<2>")
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
	
	// REGLA: DET NUM (per quan va davant de desconegudes, almenys que concordin entre ells) - The two xxx : el(s) dos xxx
	public void rule93__det__num(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule93__det__num",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_f_concord2(out, word1, blank1, word2);
		macro_determiner(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_num"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word1.tl(attr_nbr_sp)
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
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
	
	// REGLA: PREPOSICIÓ PRONOM_OBJECTE : with him - amb ell
	public void rule94__prep__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule94__prep__probj",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		if ((word2.sl(attr_pers).equals("<p3>")
    && word2.sl(attr_nbr).equals("<pl>")))
		{
			word2.tlSet(attr_gen, "<m>");
		}
		else
		if ((word2.sl(attr_pers).equals("<p3>")
    && word2.sl(attr_nbr).equals("<sg>")
    && !word2.sl(attr_gen).equals("<nt>")))
		{
			word2.tlSet(attr_gen, word2.sl(attr_gen));
		}
		else
		if ((word2.sl(attr_pers).equals("<p1>")
    && word2.sl(attr_nbr).equals("<sg>")))
		{
			word2.tlSet(attr_lem, "mi");
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
		out.append("^probj<SN><tn>");
		out.append(word2.tl(attr_pers));
		out.append(word2.tl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append("{^");
		out.append(word2.tl(attr_lem));
		out.append("<prn><2>");
		out.append(word2.tl(attr_pers));
		out.append((word2.tl(attr_gen)==""?"" : "<4>"));
		out.append((word2.tl(attr_nbr)==""?"" : "<5>"));
		out.append("$}$");
	}
	
	/**  SINTAGMES NOMINALS AMB CANVI DE PREP DAVANT INFINITIU  */
	// REGLA: DET NOM TO INF (BCN:  Regla que canvia la preposició TO de l'anglès per DE del català per A noms de control i per PER per als altres ('the need to work' - 'la necessitat de treballr' vs. 'a book to read' - 'un llibre per llegir'. Com que és d'aplicació general es codifica via regla i no al lèxic. Els noms de control (o equi nouns) es llisten sota la marca equinouns. Amb això evitem duplicar entrades. Les excepcions que hi pugui haver s'han de codificar al lèxic).       EN principi la regla es justifica per evitar que la prep TO es tradueixi per A/PER.
	public void rule95__det__nom__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule95__det__nom__to__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		macro_det_no(out, word1, blank1, word2);
		macro_f_concord2(out, word2, " ", word1);
		/**  per tractar la cua en verbs multiparaula  */
		macro_tipus_verbs(out, word4);
		if (list_controlnouns.containsIgnoreCase(word2.sl(attr_lem)))
		{
			word3.tlSet(attr_lem, "de");
		}
		else
		{
			word3.tlSet(attr_lem, "per");
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_to_inf"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
			out.append(word4.tl(attr_a_verb));
			out.append((word4.tl(attr_temps)==""?"" : "<5>"));
			out.append("+es<prn><enc><ref><p3><mf><sp>");
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_to_inf"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         word4.tl(attr_lemh)
				         +word4.tl(attr_a_verb)
				         +(word4.tl(attr_temps)==""?"" : "<5>")
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
		}
	}
	
	// REGLA: DET NOM TO INF+clitic (igual que l'anterior, amb inf + pronom obj= inf+clític)
	public void rule96__det__nom__to__inf__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule96__det__nom__to__inf__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		macro_det_no(out, word1, blank1, word2);
		macro_f_concord2(out, word2, " ", word1);
		/**  per tractar la cua en verbs multiparaula  */
		macro_tipus_verbs(out, word4);
		if (list_controlnouns.containsIgnoreCase(word2.sl(attr_lem)))
		{
			word3.tlSet(attr_lem, "de");
		}
		else
		{
			word3.tlSet(attr_lem, "per");
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_to_inf"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
			out.append(word4.tl(attr_a_verb));
			out.append((word4.tl(attr_temps)==""?"" : "<5>"));
			out.append("+es<prn><enc><ref><p3><mf><sp>+");
			out.append(word5.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word5.tl(attr_pers));
			out.append(word5.tl(attr_gen));
			out.append(word5.tl(attr_nbr));
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_to_inf"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
			out.append(word4.tl(attr_a_verb));
			out.append((word4.tl(attr_temps)==""?"" : "<5>"));
			out.append('+');
			out.append(word5.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word5.tl(attr_pers));
			out.append(word5.tl(attr_gen));
			out.append(word5.tl(attr_nbr));
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
		macro_f_bcond(out, word4, blank4, word5);
	}
	
	// REGLA: NOM TO INF (BCN:  Regla que canvia la preposició TO de l'anglès per DE del català per A noms de control i per PER per als altres ('the need to work' - 'la necessitat de treballr' vs. 'a book to read' - 'un llibre per llegir'. Com que és d'aplicació general es codifica via regla i no al lèxic. Els noms de control (o equi nouns) es llisten sota la marca equinouns. Amb això evitem duplicar entrades. Les exepcions que hi pugui haver s'han de codificar al lèxic).       EN principi la regla es justifica per evitar que la prep TO es tradueixi per A.
	public void rule97__nom__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule97__nom__to__inf",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		/**  per tractar la cua en verbs multiparaula  */
		macro_tipus_verbs(out, word3);
		if (list_controlnouns.containsIgnoreCase(word1.sl(attr_lem)))
		{
			word2.tlSet(attr_lem, "de");
		}
		else
		{
			word2.tlSet(attr_lem, "per");
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_to_inf"));
			out.append("<SN><UNDET>");
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_nom)
				         +(word1.tl(attr_gen)==""?"" : "<3>")
				         +(word1.tl(attr_nbr)==""?"" : "<4>")
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
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append((word3.tl(attr_temps)==""?"" : "<5>"));
			out.append("+es<prn><enc><ref><p3><mf><sp>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_to_inf"));
			out.append("<SN><UNDET>");
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_nom)
				         +(word1.tl(attr_gen)==""?"" : "<3>")
				         +(word1.tl(attr_nbr)==""?"" : "<4>")
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
				         +(word3.tl(attr_temps)==""?"" : "<5>")
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
	
	// REGLA: NOM TO INF + PRNobj
	public void rule98__nom__to__inf__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule98__nom__to__inf__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		/**  per tractar la cua en verbs multiparaula  */
		macro_tipus_verbs(out, word3);
		if (list_controlnouns.containsIgnoreCase(word1.sl(attr_lem)))
		{
			word2.tlSet(attr_lem, "de");
		}
		else
		{
			word2.tlSet(attr_lem, "per");
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_to_inf"));
			out.append("<SN><UNDET>");
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_nom)
				         +(word1.tl(attr_gen)==""?"" : "<3>")
				         +(word1.tl(attr_nbr)==""?"" : "<4>")
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
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append((word3.tl(attr_temps)==""?"" : "<5>"));
			out.append("+es<prn><enc><ref><p3><mf><sp>+");
			out.append(word4.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word4.tl(attr_pers));
			out.append(word4.tl(attr_gen));
			out.append(word4.tl(attr_nbr));
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom_to_inf"));
			out.append("<SN><UNDET>");
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_nom)
				         +(word1.tl(attr_gen)==""?"" : "<3>")
				         +(word1.tl(attr_nbr)==""?"" : "<4>")
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
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append((word3.tl(attr_temps)==""?"" : "<5>"));
			out.append('+');
			out.append(word4.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word4.tl(attr_pers));
			out.append(word4.tl(attr_gen));
			out.append(word4.tl(attr_nbr));
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// REGLA: DET ADJ NOM TO INF (BCN:  Regla que canvia la preposició TO de l'anglès per DE del català per A noms de control i per PER per als altres ('the need to work' - 'la necessitat de treballr' vs. 'a book to read' - 'un llibre per llegir'. Com que és d'aplicació general es codifica via regla i no al lèxic. Els noms de control (o equi nouns) es llisten sota la marca equinouns. Amb això evitem duplicar entrades. Les exepcions que hi pugui haver s'han de codificar al lèxic).       EN principi la regla es justifica per evitar que la prep TO es tradueixi per A.
	public void rule99__det__adj__nom__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule99__det__adj__nom__to__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		macro_det_no(out, word1, blank2, word3);
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_comparatiu_adj1(out, word2);
		/**  per tractar la cua en verbs multiparaula  */
		macro_tipus_verbs(out, word5);
		if (list_controlnouns.containsIgnoreCase(word3.sl(attr_lem)))
		{
			word4.tlSet(attr_lem, "de");
		}
		else
		{
			word4.tlSet(attr_lem, "per");
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_to_inf"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
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
				         var_adjectiu1
				         +word2.tl(attr_lemh)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
			out.append('^');
			out.append(word5.tl(attr_lemh));
			out.append(word5.tl(attr_a_verb));
			out.append((word5.tl(attr_temps)==""?"" : "<5>"));
			out.append("+es<prn><enc><ref><p3><mf><sp>");
			out.append(word5.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_to_inf"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
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
				         var_adjectiu1
				         +word2.tl(attr_lemh)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
				         word5.tl(attr_lemh)
				         +word5.tl(attr_a_verb)
				         +(word5.tl(attr_temps)==""?"" : "<5>")
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
	
	// REGLA: DET ADJ NOM TO INF PRNobj (igual que l'anterior però amb inf + clític).
	public void rule100__det__adj__nom__to__inf__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule100__det__adj__nom__to__inf__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		macro_genere_nombre(out, word3);
		macro_det_no(out, word1, blank2, word3);
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_comparatiu_adj1(out, word2);
		/**  per tractar la cua en verbs multiparaula  */
		macro_tipus_verbs(out, word5);
		if (list_controlnouns.containsIgnoreCase(word3.sl(attr_lem)))
		{
			word4.tlSet(attr_lem, "de");
		}
		else
		{
			word4.tlSet(attr_lem, "per");
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_to_inf"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
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
				         var_adjectiu1
				         +word2.tl(attr_lemh)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
			out.append('^');
			out.append(word5.tl(attr_lemh));
			out.append(word5.tl(attr_a_verb));
			out.append((word5.tl(attr_temps)==""?"" : "<5>"));
			out.append("+es<prn><enc><ref><p3><mf><sp>+");
			out.append(word6.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word6.tl(attr_pers));
			out.append(word6.tl(attr_gen));
			out.append(word6.tl(attr_nbr));
			out.append(word5.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_to_inf"));
			out.append("<SN>");
			out.append(var_tipus_det);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
			out.append("<inf>{");
			/**  posat a mà */
			{
				String myword = 
				         word1.tl(attr_lem)
				         +word1.tl(attr_a_det)
				         +(word1.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word1.tl(attr_gen_mf)
				         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word1.tl(attr_nbr_sp)
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
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word3.tl(attr_gen_mf)
				         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word3.tl(attr_nbr_sp)
				         +word3.tl(attr_lemq)
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
				         var_adjectiu1
				         +word2.tl(attr_lemh)
				         +word2.tl(attr_a_adj)
				         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
				         +word2.tl(attr_gen_mf)
				         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
				         +word2.tl(attr_nbr_sp)
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
			out.append('^');
			out.append(word5.tl(attr_lemh));
			out.append(word5.tl(attr_a_verb));
			out.append((word5.tl(attr_temps)==""?"" : "<5>"));
			out.append('+');
			out.append(word6.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word6.tl(attr_pers));
			out.append(word6.tl(attr_gen));
			out.append(word6.tl(attr_nbr));
			out.append(word5.tl(attr_lemq));
			out.append("$}$");
		}
		macro_f_bcond(out, word5, blank5, word6);
	}
	
	/** sintagma nominal amb relatiu  */
	// REGLA: whose NOM
	public void rule101__relaa__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule101__relaa__nom",  word1, blank1,  word2); } 
		if (!(var_gen_chunk.equals("<GD>")
    || var_gen_chunk.equals("<mf>")))
		{
			var_gen_qual = var_gen_chunk;
		}
		else
		{
			var_gen_qual = "<m>";
		}
		if (!(var_nbr_chunk.equals("<ND>")
    || var_nbr_chunk.equals("<sp>")))
		{
			var_nbr_qual = var_nbr_chunk;
		}
		else
		{
			var_nbr_qual = "<sg>";
		}
		macro_f_concord2(out, word2, " ", word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_qual"));
		out.append("<SN><DET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^el<det><def>");
		out.append((word1.tl(attr_gen_sense_mf)==""?"" : "<3>"));
		out.append(word1.tl(attr_gen_mf));
		out.append((word1.tl(attr_nbr_sense_sp)==""?"" : "<4>"));
		out.append(word1.tl(attr_nbr_sp));
		out.append('$');
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
			         +word2.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^del qual");
		out.append(word1.tl(attr_a_rel));
		out.append(var_gen_qual);
		out.append(var_nbr_qual);
		out.append("$}$");
	}
	
	// REGLA: whose DET NOM
	public void rule102__relaa__det__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule102__relaa__det__nom",  word1, blank1,  word2, blank2,  word3); } 
		if (!(var_gen_chunk.equals("<GD>")
    || var_gen_chunk.equals("<mf>")))
		{
			var_gen_qual = var_gen_chunk;
		}
		else
		{
			var_gen_qual = "<m>";
		}
		if (!(var_nbr_chunk.equals("<ND>")
    || var_nbr_chunk.equals("<sp>")))
		{
			var_nbr_qual = var_nbr_chunk;
		}
		else
		{
			var_nbr_qual = "<sg>";
		}
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_det_nom_qual"));
		out.append("<SN><DET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^el<det><def>");
		out.append((word1.tl(attr_gen_sense_mf)==""?"" : "<3>"));
		out.append(word1.tl(attr_gen_mf));
		out.append((word1.tl(attr_nbr_sense_sp)==""?"" : "<4>"));
		out.append(word1.tl(attr_nbr_sp));
		out.append('$');
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_det)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^del qual");
		out.append(word1.tl(attr_a_rel));
		out.append(var_gen_qual);
		out.append(var_nbr_qual);
		out.append("$}$");
	}
	
	// REGLA: whose NUM NOM
	public void rule103__relaa__num__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule103__relaa__num__nom",  word1, blank1,  word2, blank2,  word3); } 
		if (!(var_gen_chunk.equals("<GD>")
    || var_gen_chunk.equals("<mf>")))
		{
			var_gen_qual = var_gen_chunk;
		}
		else
		{
			var_gen_qual = "<m>";
		}
		if (!(var_nbr_chunk.equals("<ND>")
    || var_nbr_chunk.equals("<sp>")))
		{
			var_nbr_qual = var_nbr_chunk;
		}
		else
		{
			var_nbr_qual = "<sg>";
		}
		macro_million(out, word2);
		macro_flexio_numerals(out, word2, blank2, word3);
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_num_nom_qual"));
		out.append("<SN><DET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^el<det><def>");
		out.append((word1.tl(attr_gen_sense_mf)==""?"" : "<3>"));
		out.append(word1.tl(attr_gen_mf));
		out.append((word1.tl(attr_nbr_sense_sp)==""?"" : "<4>"));
		out.append(word1.tl(attr_nbr_sp));
		out.append('$');
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^del qual");
		out.append(word1.tl(attr_a_rel));
		out.append(var_gen_qual);
		out.append(var_nbr_qual);
		out.append("$}$");
	}
	
	// REGLA: whose DET NUM NOM
	public void rule104__relaa__det__num__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule104__relaa__det__num__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_million(out, word3);
		if (!(var_gen_chunk.equals("<GD>")
    || var_gen_chunk.equals("<mf>")))
		{
			var_gen_qual = var_gen_chunk;
		}
		else
		{
			var_gen_qual = "<m>";
		}
		if (!(var_nbr_chunk.equals("<ND>")
    || var_nbr_chunk.equals("<sp>")))
		{
			var_nbr_qual = var_nbr_chunk;
		}
		else
		{
			var_nbr_qual = "<sg>";
		}
		macro_flexio_numerals(out, word3, blank3, word4);
		macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_det_num_nom_qual"));
		out.append("<SN><DET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^el<det><def>");
		out.append((word1.tl(attr_gen_sense_mf)==""?"" : "<3>"));
		out.append(word1.tl(attr_gen_mf));
		out.append((word1.tl(attr_nbr_sense_sp)==""?"" : "<4>"));
		out.append(word1.tl(attr_nbr_sp));
		out.append('$');
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_det)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +word3.tl(attr_a_num)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^del qual");
		out.append(word1.tl(attr_a_rel));
		out.append(var_gen_qual);
		out.append(var_nbr_qual);
		out.append("$}$");
	}
	
	// REGLA: whose NUM NUM NOM
	public void rule105__relaa__num__num__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule105__relaa__num__num__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_million(out, word3);
		if (((word3.tl(attr_lem).equalsIgnoreCase("milió de")
    || word3.tl(attr_lem).equalsIgnoreCase("un milió de"))
    && word2.tl(attr_gen).equals("<GD>")))
		{
			word2.tlSet(attr_gen, "<m>");
		}
		else
		{
			macro_flexio_numerals(out, word2, blank3, word4);
		}
		macro_flexio_numerals(out, word3, blank3, word4);
		if (!(var_gen_chunk.equals("<GD>")
    || var_gen_chunk.equals("<mf>")))
		{
			var_gen_qual = var_gen_chunk;
		}
		else
		{
			var_gen_qual = "<m>";
		}
		if (!(var_nbr_chunk.equals("<ND>")
    || var_nbr_chunk.equals("<sp>")))
		{
			var_nbr_qual = var_nbr_chunk;
		}
		else
		{
			var_nbr_qual = "<sg>";
		}
		macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_num_num_nom_qual"));
		out.append("<SN><DET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^el<det><def>");
		out.append((word1.tl(attr_gen_sense_mf)==""?"" : "<3>"));
		out.append(word1.tl(attr_gen_mf));
		out.append((word1.tl(attr_nbr_sense_sp)==""?"" : "<4>"));
		out.append(word1.tl(attr_nbr_sp));
		out.append('$');
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_lem)
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +word3.tl(attr_a_num)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^del qual");
		out.append(word1.tl(attr_a_rel));
		out.append(var_gen_qual);
		out.append(var_nbr_qual);
		out.append("$}$");
	}
	
	// REGLA: whose ADJ NOM
	public void rule106__relaa__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule106__relaa__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		if (!(var_gen_chunk.equals("<GD>")
    || var_gen_chunk.equals("<mf>")))
		{
			var_gen_qual = var_gen_chunk;
		}
		else
		{
			var_gen_qual = "<m>";
		}
		if (!(var_nbr_chunk.equals("<ND>")
    || var_nbr_chunk.equals("<sp>")))
		{
			var_nbr_qual = var_nbr_chunk;
		}
		else
		{
			var_nbr_qual = "<sg>";
		}
		macro_f_concord3(out, word3, blank1, word2, " ", word1);
		macro_comparatiu_adj1(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj_qual"));
		out.append("<SN><DET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^el<det><def>");
		out.append((word1.tl(attr_gen_sense_mf)==""?"" : "<3>"));
		out.append(word1.tl(attr_gen_mf));
		out.append((word1.tl(attr_nbr_sense_sp)==""?"" : "<4>"));
		out.append(word1.tl(attr_nbr_sp));
		out.append('$');
		out.append(blank1);
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
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
			         var_adjectiu1
			         +word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^del qual");
		out.append(word1.tl(attr_a_rel));
		out.append(var_gen_qual);
		out.append(var_nbr_qual);
		out.append("$}$");
	}
	
	// REGLA: whose DET ADJ NOM (whose many beautiful cats)
	public void rule107__relaa__det__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule107__relaa__det__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		if (!(var_gen_chunk.equals("<GD>")
    || var_gen_chunk.equals("<mf>")))
		{
			var_gen_qual = var_gen_chunk;
		}
		else
		{
			var_gen_qual = "<m>";
		}
		if (!(var_nbr_chunk.equals("<ND>")
    || var_nbr_chunk.equals("<sp>")))
		{
			var_nbr_qual = var_nbr_chunk;
		}
		else
		{
			var_nbr_qual = "<sg>";
		}
		macro_firstWord(out, word1);
		macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
		macro_comparatiu_adj1(out, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_det_nom_adj_qual"));
		out.append("<SN><DET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^el<det><def>");
		out.append((word1.tl(attr_gen_sense_mf)==""?"" : "<3>"));
		out.append(word1.tl(attr_gen_mf));
		out.append((word1.tl(attr_nbr_sense_sp)==""?"" : "<4>"));
		out.append(word1.tl(attr_nbr_sp));
		out.append('$');
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_det)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
			         var_adjectiu1
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^del qual");
		out.append(word1.tl(attr_a_rel));
		out.append(var_gen_qual);
		out.append(var_nbr_qual);
		out.append("$}$");
	}
	
	// REGLA: whose NUM ADJ NOM (whose three beautiful cats)
	public void rule108__relaa__num__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule108__relaa__num__adj__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		if (!(var_gen_chunk.equals("<GD>")
    || var_gen_chunk.equals("<mf>")))
		{
			var_gen_qual = var_gen_chunk;
		}
		else
		{
			var_gen_qual = "<m>";
		}
		if (!(var_nbr_chunk.equals("<ND>")
    || var_nbr_chunk.equals("<sp>")))
		{
			var_nbr_qual = var_nbr_chunk;
		}
		else
		{
			var_nbr_qual = "<sg>";
		}
		macro_million(out, word2);
		macro_flexio_numerals(out, word2, blank3, word4);
		macro_f_concord4(out, word4, blank2, word3, blank1, word2, " ", word1);
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word3);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_num_nom_adj_qual"));
		out.append("<SN><DET>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^el<det><def>");
		out.append((word1.tl(attr_gen_sense_mf)==""?"" : "<3>"));
		out.append(word1.tl(attr_gen_mf));
		out.append((word1.tl(attr_nbr_sense_sp)==""?"" : "<4>"));
		out.append(word1.tl(attr_nbr_sp));
		out.append('$');
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_num)
			         +(word2.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word2.tl(attr_gen_mf)
			         +(word2.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word2.tl(attr_nbr_sp)
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
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word4.tl(attr_gen_mf)
			         +(word4.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word4.tl(attr_nbr_sp)
			         +word4.tl(attr_lemq)
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
			         var_adjectiu1
			         +word3.tl(attr_lemh)
			         +word3.tl(attr_a_adj)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<3>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<4>")
			         +word3.tl(attr_nbr_sp)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^del qual");
		out.append(word1.tl(attr_a_rel));
		out.append(var_gen_qual);
		out.append(var_nbr_qual);
		out.append("$}$");
	}
	
	/**  SINTAGMES ADJECTIVALS  */
	// REGLA: ADJECTIU + enough (BCN strong enough :: prou fort)
	public void rule109__adj__enough(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule109__adj__enough",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		if (word1.tl(attr_gen).equals("<mf>"))
		{
			var_gen_chunk = word1.tl(attr_gen);
		}
		else
		{
			var_gen_chunk = "<GD>";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv_adj"));
		out.append("<SA>");
		out.append(var_gen_chunk);
		out.append("<ND>{");
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
		out.append(" ^");
		out.append(var_adjectiu1);
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_adj));
		out.append("<2><3>");
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: ADJECTIU (queda com a GD i ND fins al interchunk)
	public void rule110__adj2pos(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule110__adj2pos",  word1); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		if (word1.tl(attr_gen).equals("<mf>"))
		{
			var_gen_chunk = word1.tl(attr_gen);
		}
		else
		{
			var_gen_chunk = "<GD>";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adj"));
		out.append("<SA>");
		out.append(var_gen_chunk);
		out.append("<ND>{^");
		out.append(var_adjectiu1);
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_adj));
		out.append("<2><3>");
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: PREADV ADJECTIU ('very difficult'; queda com a GD i ND fins al interchunk)
	public void rule111__preadv__adj(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule111__preadv__adj",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word2);
		if (word2.tl(attr_gen).equals("<mf>"))
		{
			var_gen_chunk = word2.tl(attr_gen);
		}
		else
		{
			var_gen_chunk = "<GD>";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "preadv_adj"));
		out.append("<SA>");
		out.append(var_gen_chunk);
		out.append("<ND>{");
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
		out.append(var_adjectiu1);
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_adj));
		out.append("<2><3>");
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: ADJECTIU superlatiu EVER ('biggest ever'; queda com a GD i ND fins al interchunk)
	public void rule112__adjsup__ever(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule112__adjsup__ever",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		if (word1.tl(attr_gen).equals("<mf>"))
		{
			var_gen_chunk = word1.tl(attr_gen);
		}
		else
		{
			var_gen_chunk = "<GD>";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adjsup"));
		out.append("<SA>");
		out.append(var_gen_chunk);
		out.append("<ND>{^");
		out.append(var_adjectiu1);
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_adj));
		out.append("<2><3>");
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word1, blank1, word2);
	}
	
	// REGLA: NPLOC-PP (London-based)
	public void rule113__nploc__guio__pp(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule113__nploc__guio__pp",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pp_pr_np"));
		out.append("<SA><GD><ND>{^");
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_adj));
		out.append("<2><3>$ ^a<pr>$ ");
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
	
	// REGLA: DET NPLOC-PP (a London-based)
	public void rule114__det__nploc__guio__pp(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule114__det__nploc__guio__pp",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det"));
		out.append("<DET>");
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append("{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_a_det));
		out.append("<2><3>$}$");
		out.append(blank1);
		out.append("^pp_pr_np<SA><GD><ND>{^");
		out.append(word4.tl(attr_lemh));
		out.append(word4.tl(attr_a_adj));
		out.append("<2><3>$ ^a<pr>$ ");
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
	
	/**  BCN només volesm adjs 'reals' no PPs */
	// REGLA: ADJ TO INF (BCN: canviem la prep TO per DE; els adjectius que no compleixin la regla s'han de codificar al lèxic. Queda com a GD i ND fins al interchunk)
	public void rule115__adj2__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule115__adj2__to__inf",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		macro_tipus_verbs(out, word3);
		if (word1.tl(attr_gen).equals("<mf>"))
		{
			var_gen_chunk = word1.tl(attr_gen);
		}
		else
		{
			var_gen_chunk = "<GD>";
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adj_de_inf"));
			out.append("<SA>");
			out.append(var_gen_chunk);
			out.append("<ND><inf>{");
			/**  posat a mà */
			out.append('^');
			out.append(var_adjectiu1);
			out.append(word1.tl(attr_lem));
			out.append(word1.tl(attr_a_adj));
			out.append("<2><3>$");
			out.append(blank1);
			out.append("^de<pr>$");
			out.append(blank2);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append((word3.tl(attr_temps)==""?"" : "<4>"));
			out.append("+es<prn><enc><ref><p3><mf><sp>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adj_de_inf"));
			out.append("<SA>");
			out.append(var_gen_chunk);
			out.append("<ND><inf>{");
			/**  posat a mà */
			out.append('^');
			out.append(var_adjectiu1);
			out.append(word1.tl(attr_lem));
			out.append(word1.tl(attr_a_adj));
			out.append("<2><3>$");
			out.append(blank1);
			out.append("^de<pr>$");
			out.append(blank2);
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_verb)
				         +(word3.tl(attr_temps)==""?"" : "<4>")
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
	
	/**  BCN només volesm adjs 'reals' no PPs */
	// REGLA: ADJ TO INF PRNobj (BCN: canviem la prep TO per DE; els adjectius que no compleixin la regla s'han de codificar al lèxic. Queda com a GD i ND fins al interchunk)
	public void rule116__adj2__to__inf__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule116__adj2__to__inf__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		macro_tipus_verbs(out, word3);
		if (word1.tl(attr_gen).equals("<mf>"))
		{
			var_gen_chunk = word1.tl(attr_gen);
		}
		else
		{
			var_gen_chunk = "<GD>";
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adj_de_inf_enc"));
			out.append("<SA>");
			out.append(var_gen_chunk);
			out.append("<ND><inf>{");
			/**  posat a mà */
			out.append('^');
			out.append(var_adjectiu1);
			out.append(word1.tl(attr_lem));
			out.append(word1.tl(attr_a_adj));
			out.append("<2><3>$");
			out.append(blank1);
			out.append("^de<pr>$");
			out.append(blank2);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append((word3.tl(attr_temps)==""?"" : "<4>"));
			out.append("+es<prn><enc><ref><p3><mf><sp>+");
			out.append(word4.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word4.tl(attr_pers));
			out.append(word4.tl(attr_gen));
			out.append(word4.tl(attr_nbr));
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adj_de_inf_enc"));
			out.append("<SA>");
			out.append(var_gen_chunk);
			out.append("<ND><inf>{");
			/**  posat a mà */
			out.append('^');
			out.append(var_adjectiu1);
			out.append(word1.tl(attr_lem));
			out.append(word1.tl(attr_a_adj));
			out.append("<2><3>$");
			out.append(blank1);
			out.append("^de<pr>$");
			out.append(blank2);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append((word3.tl(attr_temps)==""?"" : "<4>"));
			out.append('+');
			out.append(word4.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word4.tl(attr_pers));
			out.append(word4.tl(attr_gen));
			out.append(word4.tl(attr_nbr));
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	/**  BCN només volem adjs 'reals' no PPs */
	// REGLA: ADV ADJ TO INF (BCN: canviem la prep TO per DE; els adjectius que no compleixin la regla s'han de codificar al lèxic. Queda com a GD i ND fins al interchunk)
	public void rule117__preadv__adj2__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule117__preadv__adj2__to__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		/**  per tractar la cua en verbs multiparaula  */
		macro_tipus_verbs(out, word4);
		if (word2.tl(attr_gen).equals("<mf>"))
		{
			var_gen_chunk = word2.tl(attr_gen);
		}
		else
		{
			var_gen_chunk = "<GD>";
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adv_adj_de_inf"));
			out.append("<SA>");
			out.append(var_gen_chunk);
			out.append("<ND><inf>{");
			/**  posat a mà */
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
			out.append(var_adjectiu1);
			out.append(word2.tl(attr_lem));
			out.append(word2.tl(attr_a_adj));
			out.append("<2><3>$");
			out.append(blank2);
			out.append("^de<pr>$");
			out.append(blank3);
			out.append('^');
			out.append(word4.tl(attr_lemh));
			out.append(word4.tl(attr_a_verb));
			out.append((word4.tl(attr_temps)==""?"" : "<4>"));
			out.append("+es<prn><enc><ref><p3><mf><sp>");
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adv_adj_de_inf"));
			out.append("<SA>");
			out.append(var_gen_chunk);
			out.append("<ND><inf>{");
			/**  posat a mà */
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
			out.append(var_adjectiu1);
			out.append(word2.tl(attr_lem));
			out.append(word2.tl(attr_a_adj));
			out.append("<2><3>$");
			out.append(blank2);
			out.append("^de<pr>$");
			out.append(blank3);
			{
				String myword = 
				         word4.tl(attr_lemh)
				         +word4.tl(attr_a_verb)
				         +(word4.tl(attr_temps)==""?"" : "<4>")
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
		}
	}
	
	/**  BCN només volem adjs 'reals' no PPs */
	// REGLA: ADV ADJ TO INF ENC (BCN: canviem la prep TO per DE; els adjectius que no compleixin la regla s'han de codificar al lèxic. Queda com a GD i ND fins al interchunk)
	public void rule118__preadv__adj2__to__inf__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule118__preadv__adj2__to__inf__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_comparatiu_adj1(out, word1);
		/**  per tractar la cua en verbs multiparaula  */
		macro_tipus_verbs(out, word4);
		if (word2.tl(attr_gen).equals("<mf>"))
		{
			var_gen_chunk = word2.tl(attr_gen);
		}
		else
		{
			var_gen_chunk = "<GD>";
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adv_adj_de_inf_enc"));
			out.append("<SA>");
			out.append(var_gen_chunk);
			out.append("<ND><inf>{");
			/**  posat a mà */
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
			out.append(var_adjectiu1);
			out.append(word2.tl(attr_lem));
			out.append(word2.tl(attr_a_adj));
			out.append("<2><3>$");
			out.append(blank2);
			out.append("^de<pr>$");
			out.append(blank3);
			out.append('^');
			out.append(word4.tl(attr_lemh));
			out.append(word4.tl(attr_a_verb));
			out.append((word4.tl(attr_temps)==""?"" : "<4>"));
			out.append("+es<prn><enc><ref><p3><mf><sp>+");
			out.append(word5.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word5.tl(attr_pers));
			out.append(word5.tl(attr_gen));
			out.append(word5.tl(attr_nbr));
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "adv_adj_de_inf_enc"));
			out.append("<SA>");
			out.append(var_gen_chunk);
			out.append("<ND><inf>{");
			/**  posat a mà */
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
			out.append(var_adjectiu1);
			out.append(word2.tl(attr_lem));
			out.append(word2.tl(attr_a_adj));
			out.append("<2><3>$");
			out.append(blank2);
			out.append("^de<pr>$");
			out.append(blank3);
			out.append('^');
			out.append(word4.tl(attr_lemh));
			out.append(word4.tl(attr_a_verb));
			out.append((word4.tl(attr_temps)==""?"" : "<4>"));
			out.append('+');
			out.append(word5.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word5.tl(attr_pers));
			out.append(word5.tl(attr_gen));
			out.append(word5.tl(attr_nbr));
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
		macro_f_bcond(out, word4, blank4, word5);
	}
	
	/** ********************************* REGLES DE SV *****************************************************  */
	// REGLA: VERB copulatiu
	public void rule119__copulatiu(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule119__copulatiu",  word1); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		macro_conj_verb1(out, word1);
		/** aquí sobrescrivim alguns valors assignats per la macro conj_verb1  */
		var_lema_SV = word1.sl(attr_lem);
		if (word1.sl(attr_temps).equals("<past>"))
		{
			var_temps_chunk = "<pii>";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
		}
		/** envia-ho tot tal com ha quedat  */
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<Vcop>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
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
		out.append("}$");
	}
	
	// REGLA: VERB copulatiu PP (el verb 'ser' del passat agafa aquí la forma perifràstica) Nota: en en-es el verb 'to be' + participi es tradueix per 'estar'. De moment en català no, si de cas es pot copiar de la regla castellana
	public void rule120__copulatiu__pp(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule120__copulatiu__pp",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		macro_conj_verb1(out, word1);
		var_lema_SV = word1.sl(attr_lem);
		var_lema_SV = var_lema_SV
		    +"_pp"
		    ;
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<Vcop>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append("<GD>{");
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
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_pp));
		out.append("<6><5>");
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: VERB copulatiu ADV
	public void rule121__be__adv_not(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule121__be__adv_not",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		macro_conj_verb1(out, word1);
		var_lema_SV = word1.sl(attr_lem);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append('^');
		out.append(var_lema_SV);
		out.append("<Vcop>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
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
		out.append("}$");
	}
	
	// REGLA: be sorry ADV
	public void rule122__be_sorry__adv_not(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule122__be_sorry__adv_not",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		macro_conj_verb1(out, word1);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append('^');
		out.append(var_lema_SV);
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
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
		out.append("}$");
	}
	
	// REGLA: VERB
	public void rule123__verbcj(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule123__verbcj",  word1); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		macro_pron(out, word1);
		macro_conj_verb1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
	
	// REGLA: VERB+clític: finds it-> el troba
	public void rule124__verbcj__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule124__verbcj__probj",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		macro_pron(out, word1);
		macro_conj_verb1(out, word1);
		var_lema_SV = (""+"pro_"+var_lema_SV);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word2.tl(attr_lem)
			         +word2.tl(attr_a_prnpro)
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
		out.append("}$");
	}
	
	// REGLA: VERB MODAL (have to, want to). Per quan apareix sol o amb un verb desconegut
	public void rule125__mod(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule125__mod",  word1); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		macro_conj_verb1(out, word1);
		/** Si el tagger s'equivoca i tria 'inf', ho tractarem com si fos 'pres' */
		macro_passa_inf_a_pres(out, word1);
		/** si entra com a 'pp', ho tractarem com si fos 'past'  */
		macro_passa_pp_a_ifip(out, word1);
		/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb1'  */
		if (word1.sl(attr_temps).equals("<past>"))
		{
			var_lema_SV = "mod_perif";
		}
		else
		{
			var_lema_SV = "mod";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
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
		out.append("}$");
	}
	
	// REGLA: INF (per a col·locar la cua en les multiparaules)
	public void rule126__inf(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule126__inf",  word1); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		if (!(word1.sl(attr_lem).equalsIgnoreCase("will")
    || word1.sl(attr_lem).equalsIgnoreCase("shall")
    || word1.sl(attr_lem).equalsIgnoreCase("would")))
		{
			if (var_tipus_verb.equals("<pron>"))
			{
				var_pronomenc = "$ ^prpers";
				var_pronomenc = var_pronomenc
				    +"<prn><enc><4><mf><5>"
				    ;
				var_lema_SV = "inf_enc";
			}
			else
			{
				var_lema_SV = "inf";
				var_pronomenc = "";
			}
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(word1.tl(attr_temps));
			out.append("<PD><ND>{");
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_verb)
				         +(word1.tl(attr_temps)==""?"" : "<3>")
				         +var_pronomenc
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
	}
	
	// REGLA: INF+clític
	public void rule127__inf__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule127__inf__probj",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		if (!(word1.sl(attr_lem).equalsIgnoreCase("will")
    || word1.sl(attr_lem).equalsIgnoreCase("shall")
    || word1.sl(attr_lem).equalsIgnoreCase("would")))
		{
			if (var_tipus_verb.equals("<pron>"))
			{
				var_pronomenc = "$ ^prpers";
				var_pronomenc = var_pronomenc
				    +"<prn><enc><4><mf><5>"
				    ;
				var_lema_SV = "inf_enc_enc";
			}
			else
			{
				var_lema_SV = "inf_enc";
				var_pronomenc = "";
			}
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(word1.tl(attr_temps));
			out.append("<PD><ND>{");
			/** 	<mlu> */
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_verb)
				         +(word1.tl(attr_temps)==""?"" : "<3>")
				         +var_pronomenc
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append('^');
			out.append(word2.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word2.tl(attr_pers));
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append(word1.tl(attr_lemq));
			out.append("$}$");
		}
	}
	
	/** 	</mlu> */
	// REGLA: TO INF (BCN canvia la prep 'a' per 'per' davant infinitiu')
	public void rule128__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule128__to__inf",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		word1.tlSet(attr_lem, "per");
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
		if (!(word2.sl(attr_lem).equalsIgnoreCase("will")
    || word2.sl(attr_lem).equalsIgnoreCase("shall")
    || word2.sl(attr_lem).equalsIgnoreCase("would")))
		{
			if (var_tipus_verb.equals("<pron>"))
			{
				var_pronomenc = "$ ^prpers";
				var_pronomenc = var_pronomenc
				    +"<prn><enc><4><mf><5>"
				    ;
				var_lema_SV = "inf_enc";
			}
			else
			{
				var_lema_SV = "inf";
				var_pronomenc = "";
			}
			out.append('^');
			out.append(var_lema_SV);
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(word2.tl(attr_temps));
			out.append("<PD><ND>{");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_verb)
				         +(word2.tl(attr_temps)==""?"" : "<3>")
				         +var_pronomenc
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
	
	// REGLA: TO INF (BCN canvia la prep 'a' per 'per' davant infinitiu')
	public void rule129__to__inf__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule129__to__inf__probj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		word1.tlSet(attr_lem, "per");
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
		if (!(word2.sl(attr_lem).equalsIgnoreCase("will")
    || word2.sl(attr_lem).equalsIgnoreCase("shall")
    || word2.sl(attr_lem).equalsIgnoreCase("would")))
		{
			if (var_tipus_verb.equals("<pron>"))
			{
				var_pronomenc = "$ ^prpers";
				var_pronomenc = var_pronomenc
				    +"<prn><enc><4><mf><5>"
				    ;
				var_lema_SV = "inf_enc_enc";
			}
			else
			{
				var_lema_SV = "inf_enc";
				var_pronomenc = "";
			}
			out.append('^');
			out.append(var_lema_SV);
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(word2.tl(attr_temps));
			out.append("<PD><ND>{");
			/** 	<mlu>  */
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_verb)
				         +(word2.tl(attr_temps)==""?"" : "<3>")
				         +var_pronomenc
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append('^');
			out.append(word3.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word3.tl(attr_pers));
			out.append(word3.tl(attr_gen));
			out.append(word3.tl(attr_nbr));
			out.append(word2.tl(attr_lemq));
			out.append("$}$");
		}
	}
	
	/** 	</mlu>  */
	// REGLA: PPRS (per a col·locar la cua en les multiparaules. per ara 'pprs' no es fa servir per res, he copiat la regla del gerundi per treure com a chunk gerundi; si de cas, més endavant s'ha d'estudiar la utilitat del pprs.)
	public void rule130__pprs(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule130__pprs",  word1); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		if (var_tipus_verb.equals("<pron>"))
		{
			var_pronomenc = "$ ^prpers";
			var_pronomenc = var_pronomenc
			    +"<prn><enc><4><mf><5>"
			    ;
			var_lema_SV = "ger_enc";
		}
		else
		{
			var_lema_SV = "ger";
			var_pronomenc = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append("<ger><PD><ND>{^");
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_verb));
		out.append("<3>");
		out.append(var_pronomenc);
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: PPRS+clític (ídem regla anterior PPRS)
	public void rule131__pprs__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule131__pprs__probj",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		if (var_tipus_verb.equals("<pron>"))
		{
			var_pronomenc = "$ ^prpers";
			var_pronomenc = var_pronomenc
			    +"<prn><enc><4><mf><5>"
			    ;
			var_lema_SV = "ger_enc_enc";
		}
		else
		{
			var_lema_SV = "ger_enc";
			var_pronomenc = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append("<ger><PD><ND>{^");
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_verb));
		out.append("<3>");
		out.append(var_pronomenc);
		out.append('$');
		out.append(blank1);
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append("<prn><enc>");
		out.append(word2.tl(attr_pers));
		out.append(word2.tl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: GER (per a col·locar la cua en les multiparaules i el pronom dels verbs pronominals)
	public void rule132__ger(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule132__ger",  word1); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		if (var_tipus_verb.equals("<pron>"))
		{
			var_pronomenc = "$ ^prpers";
			var_pronomenc = var_pronomenc
			    +"<prn><enc><4><mf><5>"
			    ;
			var_lema_SV = "ger_enc";
		}
		else
		{
			var_lema_SV = "ger";
			var_pronomenc = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append("<ger><PD><ND>{^");
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_verb));
		out.append("<3>");
		out.append(var_pronomenc);
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: GER+clític
	public void rule133__ger__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule133__ger__probj",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		if (var_tipus_verb.equals("<pron>"))
		{
			var_pronomenc = "$ ^prpers";
			var_pronomenc = var_pronomenc
			    +"<prn><enc><4><mf><5>"
			    ;
			var_lema_SV = "ger_enc_enc";
		}
		else
		{
			var_lema_SV = "ger_enc";
			var_pronomenc = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append("<ger><PD><ND>{^");
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_verb));
		out.append("<3>");
		out.append(var_pronomenc);
		out.append('$');
		out.append(blank1);
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append("<prn><enc>");
		out.append(word2.tl(attr_pers));
		out.append(word2.tl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: PREP GER 
	public void rule134__prep_cnjadv__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule134__prep_cnjadv__ger",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		word2.tlSet(attr_temps, "<inf>");
		if (word1.sl(attr_lem).equalsIgnoreCase("before"))
		{
			word1.tlSet(attr_lem, "abans de");
		}
		else
		if (word1.sl(attr_lem).equalsIgnoreCase("after"))
		{
			word1.tlSet(attr_lem, "després de");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr"));
		out.append("<PREP>{^");
		out.append(word1.tl(attr_lem));
		out.append("<pr>$}$");
		/** perquè per a 'before' i 'after' no envii <cnjadv>  */
		out.append(blank1);
		if (var_tipus_verb.equals("<pron>"))
		{
			var_pronomenc = "$ ^prpers";
			var_pronomenc = var_pronomenc
			    +"<prn><enc><4><mf><5>"
			    ;
			var_lema_SV = "inf_enc";
		}
		else
		{
			var_lema_SV = "inf";
			var_pronomenc = "";
		}
		out.append('^');
		out.append(var_lema_SV);
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word2.tl(attr_temps));
		out.append("<PD><ND>{");
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +(word2.tl(attr_temps)==""?"" : "<3>")
			         +var_pronomenc
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
	
	// REGLA: PREP GER+clític
	public void rule135__prep_cnjadv__ger__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule135__prep_cnjadv__ger__probj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		word2.tlSet(attr_temps, "<inf>");
		if (word1.sl(attr_lem).equalsIgnoreCase("before"))
		{
			word1.tlSet(attr_lem, "abans de");
		}
		else
		if (word1.sl(attr_lem).equalsIgnoreCase("after"))
		{
			word1.tlSet(attr_lem, "després de");
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr"));
		out.append("<PREP>{^");
		out.append(word1.tl(attr_lem));
		out.append("<pr>$}$");
		/** perquè per a 'before' i 'after' no envii <cnjadv>  */
		out.append(blank1);
		if (var_tipus_verb.equals("<pron>"))
		{
			var_pronomenc = "$ ^prpers";
			var_pronomenc = var_pronomenc
			    +"<prn><enc><4><mf><5>"
			    ;
			var_lema_SV = "inf_enc_enc";
		}
		else
		{
			var_lema_SV = "inf_enc";
			var_pronomenc = "";
		}
		out.append('^');
		out.append(var_lema_SV);
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word2.tl(attr_temps));
		out.append('{');
		/**   <mlu> */
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +(word2.tl(attr_temps)==""?"" : "<3>")
			         +var_pronomenc
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append('^');
		out.append(word3.tl(attr_lem));
		out.append("<prn><enc>");
		out.append(word3.tl(attr_pers));
		out.append(word3.tl(attr_gen));
		out.append(word3.tl(attr_nbr));
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	/**   </mlu>		 */
	// PREP HAVERger PARTICIPI (without having finished - sense haver(inf) acabat)
	public void rule136__prep_cnjadv__haveger__pp(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule136__prep_cnjadv__haveger__pp",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		word2.tlSet(attr_temps, "<inf>");
		if (word1.sl(attr_lem).equalsIgnoreCase("before"))
		{
			word1.tlSet(attr_lem, "abans de");
		}
		else
		if (word1.sl(attr_lem).equalsIgnoreCase("after"))
		{
			word1.tlSet(attr_lem, "després de");
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			var_pronomenc = "$ ^prpers";
			var_pronomenc = var_pronomenc
			    +"<prn><enc><4><mf><5>"
			    ;
			var_lema_SV = "have_enc_pp";
		}
		else
		{
			var_lema_SV = "have_pp";
			var_pronomenc = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr"));
		out.append("<PREP>{^");
		out.append(word1.tl(attr_lem));
		out.append("<pr>$}$");
		/** perquè per a 'before' i 'after' no envii <cnjadv>  */
		out.append(blank1);
		out.append('^');
		out.append(var_lema_SV);
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word2.tl(attr_temps));
		out.append("<PD><ND>{");
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +(word2.tl(attr_temps)==""?"" : "<3>")
			         +var_pronomenc
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
		out.append('^');
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	// PREP HAVERger PARTICIPI clític (without having finished it - sense haver-lo acabat)
	public void rule137__prep_cnjadv__haveger__pp__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule137__prep_cnjadv__haveger__pp__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		word2.tlSet(attr_temps, "<inf>");
		if (word1.sl(attr_lem).equalsIgnoreCase("before"))
		{
			word1.tlSet(attr_lem, "abans de");
		}
		else
		if (word1.sl(attr_lem).equalsIgnoreCase("after"))
		{
			word1.tlSet(attr_lem, "després de");
		}
		if (var_tipus_verb.equals("<pron>"))
		{
			var_pronomenc = "$ ^prpers";
			var_pronomenc = var_pronomenc
			    +"<prn><enc><4><mf><5>"
			    ;
			var_lema_SV = "have_enc_enc_pp";
		}
		else
		{
			var_lema_SV = "have_enc_pp";
			var_pronomenc = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr"));
		out.append("<PREP>{^");
		out.append(word1.tl(attr_lem));
		out.append("<pr>$}$");
		out.append(blank1);
		out.append('^');
		out.append(var_lema_SV);
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word2.tl(attr_temps));
		out.append("<PD><ND>{");
		/**   <mlu> */
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +(word2.tl(attr_temps)==""?"" : "<3>")
			         +var_pronomenc
			         +word2.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append('^');
		out.append(word4.tl(attr_lem));
		out.append("<prn><enc>");
		out.append(word4.tl(attr_pers));
		out.append(word4.tl(attr_gen));
		out.append(word4.tl(attr_nbr));
		out.append('$');
		/**     </mlu> */
		out.append(blank2);
		out.append('^');
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// REGLA: non-GER NOM, non-eating area > àrea de no menjar
	public void rule138__non__guio__ger__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule138__non__guio__ger__nom",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		word3.tlSet(attr_temps, "<inf>");
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "non_ger_nom"));
		out.append("<SN><UNDET>");
		out.append(var_tipus_verb);
		out.append(word4.tl(attr_gen));
		out.append(word4.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word4.tl(attr_lemh)
			         +word4.tl(attr_a_nom)
			         +(word4.tl(attr_gen)==""?"" : "<4>")
			         +(word4.tl(attr_nbr)==""?"" : "<5>")
			         +word4.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$ ^no<adv>$");
		out.append(blank3);
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_verb)
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
	
	// REGLA: non GER NOM, non eating area > àrea de no menjar
	public void rule139__non__ger__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule139__non__ger__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		word2.tlSet(attr_temps, "<inf>");
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "non_ger_nom"));
		out.append("<SN><UNDET>");
		out.append(var_tipus_verb);
		out.append(word3.tl(attr_gen));
		out.append(word3.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen)==""?"" : "<4>")
			         +(word3.tl(attr_nbr)==""?"" : "<5>")
			         +word3.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		out.append("^de<pr>$ ^no<adv>$");
		out.append(blank2);
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
		out.append("}$");
	}
	
	// REGLA: det GER NOM, no eating area > cap àrea de menjar / an eating area - una àrea de menjar
	public void rule140__det__ger__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule140__det__ger__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_determiner(out, word1);
		macro_det_no(out, word1, blank2, word3);
		macro_f_concord2(out, word3, " ", word1);
		macro_tipus_verbs(out, word2);
		word2.tlSet(attr_temps, "<inf>");
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det_ger_nom"));
		out.append("<SN>");
		out.append(var_tipus_det);
		out.append(var_tipus_verb);
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append(var_negative);
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_det)
			         +(word1.tl(attr_gen_sense_mf)==""?"" : "<4>")
			         +word1.tl(attr_gen_mf)
			         +(word1.tl(attr_nbr_sense_sp)==""?"" : "<5>")
			         +word1.tl(attr_nbr_sp)
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
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen_sense_mf)==""?"" : "<4>")
			         +word3.tl(attr_gen_mf)
			         +(word3.tl(attr_nbr_sense_sp)==""?"" : "<5>")
			         +word3.tl(attr_nbr_sp)
			         +word3.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$");
		out.append(blank2);
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
		out.append("}$");
	}
	
	// REGLA: with no GER NOM, with no eating disorders > sense desordres de menjar
	public void rule141__withno__ger__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule141__withno__ger__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		word2.tlSet(attr_temps, "<inf>");
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr_ger_nom"));
		out.append("<SP><UNDET>");
		out.append(var_tipus_verb);
		out.append(word3.tl(attr_gen));
		out.append(word3.tl(attr_nbr));
		out.append("<negacio>{");
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
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +(word3.tl(attr_gen)==""?"" : "<4>")
			         +(word3.tl(attr_nbr)==""?"" : "<5>")
			         +word3.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ^de<pr>$");
		out.append(blank2);
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
		out.append("}$");
	}
	
	// REGLA: no GER: no eating  > no menjar 
	public void rule142__no__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule142__no__ger",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		word2.tlSet(attr_temps, "<inf>");
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "no_inf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(word2.tl(attr_temps));
		out.append("{^no<adv>$");
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
		out.append("}$");
	}
	
	// REGLA: ADV-GER: fast-growing > que creix/en ràpidament
	public void rule143__adv__guio__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule143__adv__guio__ger",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		word3.tlSet(attr_temps, "<pri>");
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv_ger"));
		out.append("<SA>");
		out.append(var_tipus_verb);
		out.append(word3.tl(attr_temps));
		out.append("<p3><ND>{^que<rel><an><mf><sp>$ ^");
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_verb));
		out.append(word3.tl(attr_temps));
		out.append("<4><5>");
		out.append(word3.tl(attr_lemq));
		out.append("$ ");
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
	
	// REGLA: ADJ-GER: fast-growing > que creix/en ràpidament (tagger tria adj i no adv)
	public void rule144__adj__guio__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule144__adj__guio__ger",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		word3.tlSet(attr_temps, "<pri>");
		if (word1.tl(attr_gen).equals("<mf>"))
		{
			var_gen_chunk = word1.tl(attr_gen);
		}
		else
		{
			var_gen_chunk = "<GD>";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adj_ger"));
		out.append("<SA>");
		out.append(var_tipus_verb);
		out.append(word3.tl(attr_temps));
		out.append("<p3>");
		out.append(var_gen_chunk);
		out.append("<ND>{^que<rel><an><mf><sp>$ ^");
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_verb));
		out.append(word3.tl(attr_temps));
		out.append("<4><6>");
		out.append(word3.tl(attr_lemq));
		out.append("$ ^");
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_adj));
		out.append("<5><6>");
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: NOM-GER: Holocaust-denying (bishop) > (bisbe) que nega holocaust
	public void rule145__nomcomu__guio__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule145__nomcomu__guio__ger",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_elimina_GDND(out, word1);
		word3.tlSet(attr_temps, "<pri>");
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom_ger"));
		out.append("<SA>");
		out.append(var_tipus_verb);
		out.append(word3.tl(attr_temps));
		out.append("<p3><ND>{^que<rel><an><mf><sp>$ ^");
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_verb));
		out.append(word3.tl(attr_temps));
		out.append("<4><5>");
		out.append(word3.tl(attr_lemq));
		out.append("$ ");
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +word1.tl(attr_gen)
			         +word1.tl(attr_nbr)
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
	
	/**  les 3 regles anteriors amb un det al davant, que es fa concordar amb el nom en el t2x */
	// REGLA: DET ADV-GER: the fast-growing > que creix/en ràpidament
	public void rule146__det__adv__guio__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule146__det__adv__guio__ger",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word4);
		word4.tlSet(attr_temps, "<pri>");
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det"));
		out.append("<DET>");
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append("{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_a_det));
		out.append("<2><3>$}$");
		out.append(blank1);
		out.append("^adv_ger<SA>");
		out.append(var_tipus_verb);
		out.append(word4.tl(attr_temps));
		out.append("<p3><ND>{^que<rel><an><mf><sp>$ ^");
		out.append(word4.tl(attr_lemh));
		out.append(word4.tl(attr_a_verb));
		out.append(word4.tl(attr_temps));
		out.append("<4><5>");
		out.append(word4.tl(attr_lemq));
		out.append("$ ");
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
	
	// REGLA: DET ADJ-GER: the fast-growing > que creix/en ràpidament (tagger tria adj i no adv)
	public void rule147__det__adj__guio__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule147__det__adj__guio__ger",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word4);
		word4.tlSet(attr_temps, "<pri>");
		if (word2.tl(attr_gen).equals("<mf>"))
		{
			var_gen_chunk = word2.tl(attr_gen);
		}
		else
		{
			var_gen_chunk = "<GD>";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det"));
		out.append("<DET>");
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append("{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_a_det));
		out.append("<2><3>$}$");
		out.append(blank1);
		out.append("^adj_ger<SA>");
		out.append(var_tipus_verb);
		out.append(word4.tl(attr_temps));
		out.append("<p3>");
		out.append(var_gen_chunk);
		out.append("<ND>{^que<rel><an><mf><sp>$ ^");
		out.append(word4.tl(attr_lemh));
		out.append(word4.tl(attr_a_verb));
		out.append(word4.tl(attr_temps));
		out.append("<4><6>");
		out.append(word4.tl(attr_lemq));
		out.append("$ ^");
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_adj));
		out.append("<5><6>");
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: DET NOM-GER: the Holocaust-denying (bishop) > el (bisbe) que nega holocaust
	public void rule148__det__nomcomu__guio__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule148__det__nomcomu__guio__ger",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word4);
		macro_elimina_GDND(out, word2);
		word4.tlSet(attr_temps, "<pri>");
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "det"));
		out.append("<DET>");
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append("{^");
		out.append(word1.tl(attr_lem));
		out.append(word1.tl(attr_a_det));
		out.append("<2><3>$}$");
		out.append(blank1);
		out.append("^nom_ger<SA>");
		out.append(var_tipus_verb);
		out.append(word4.tl(attr_temps));
		out.append("<p3><ND>{^que<rel><an><mf><sp>$ ^");
		out.append(word4.tl(attr_lemh));
		out.append(word4.tl(attr_a_verb));
		out.append(word4.tl(attr_temps));
		out.append("<4><5>");
		out.append(word4.tl(attr_lemq));
		out.append("$ ");
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
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
	
	// REGLA: VERB SUBS (living -> viure)
	public void rule149__vbsubs(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule149__vbsubs",  word1); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		if (var_tipus_verb.equals("<pron>"))
		{
			var_pronomenc = "$ ^prpers";
			var_pronomenc = var_pronomenc
			    +"<prn><enc><4><mf><5>"
			    ;
			var_lema_SV = "subs_enc";
		}
		else
		{
			var_lema_SV = "subs";
			var_pronomenc = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append("<inf><PD><ND>{");
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_verb)
			         +(word1.tl(attr_temps)==""?"" : "<3>")
			         +var_pronomenc
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
	
	// REGLA: VERB SUBS+clític (living it -> viure'l) ATENCIÓ: no he pogut comprovar si funciona -carmentano
	public void rule150__vbsubs__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule150__vbsubs__probj",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		if (var_tipus_verb.equals("<pron>"))
		{
			var_pronomenc = "$ ^prpers";
			var_pronomenc = var_pronomenc
			    +"<prn><enc><4><mf><5>"
			    ;
			var_lema_SV = "subs_enc_enc";
		}
		else
		{
			var_lema_SV = "subs_enc";
			var_pronomenc = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append("<inf>{");
		/**    <mlu> */
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_verb)
			         +(word1.tl(attr_temps)==""?"" : "<3>")
			         +var_pronomenc
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append('^');
		out.append(word2.tl(attr_lem));
		out.append("<prn><enc>");
		out.append(word2.tl(attr_pers));
		out.append(word2.tl(attr_gen));
		out.append(word2.tl(attr_nbr));
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	/** 	    </mlu>	 */
	// REGLA: VERB PART. Seran GD i ND excepte 'ser' i 'estar'. Caldria afegir el pp en les regles d'adjectiu?)
	public void rule151__pp(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule151__pp",  word1); } 
		macro_firstWord(out, word1);
		if ((word1.tl(attr_a_verb).equals("<vbser>")
    || word1.tl(attr_lemh).equalsIgnoreCase("estar")))
		{
			var_gen_chunk = "<m>";
			var_nbr_chunk = "<sg>";
		}
		else
		{
			var_gen_chunk = "<GD>";
			var_nbr_chunk = "<ND>";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pp"));
		out.append("<SA>");
		out.append(var_gen_chunk);
		out.append(var_nbr_chunk);
		out.append("{^");
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_pp));
		out.append("<2><3>");
		out.append(word1.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: AUX (de temps) VERB (will come, would come)
	public void rule152__auxtemps__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule152__auxtemps__infpres",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		macro_conj_verb_compost(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
	
	// REGLA: AUX (de temps) VERB (will come, would come) + clític: will sing it -> el cantarà
	public void rule153__auxtemps__infpres__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule153__auxtemps__infpres__probj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		macro_conj_verb_compost(out, word1, blank1, word2);
		var_lema_SV = (""+"pro_"+var_lema_SV);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_prnpro)
			         +word3.tl(attr_pers)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
		macro_f_bcond(out, word2, blank2, word3);
	}
	
	// REGLA: AUX (de mode) VERB (can come, should come)
	public void rule154__auxmod__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule154__auxmod__infpres",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		macro_conj_verb1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "auxmod_inf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append(word2.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: AUX (de mode) VERB (can come, should come) + clític (she should sing it -> l'hauria de cantar)
	public void rule155__auxmod__infpres__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule155__auxmod__infpres__probj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		macro_conj_verb1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pro_auxmod_inf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_prnpro)
			         +word3.tl(attr_pers)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: DO (aux) VERB (do come, did come -> vénen, van venir)
	public void rule156__do__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule156__do__infpres",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		macro_conj_verb_compost(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
	
	// REGLA: DO (aux) VERB + clític (do come, did come -> vénen, van venir)
	public void rule157__do__infpres__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule157__do__infpres__probj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		macro_conj_verb_compost(out, word1, blank1, word2);
		var_lema_SV = (""+"pro_"+var_lema_SV);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_prnpro)
			         +word3.tl(attr_pers)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
		macro_f_bcond(out, word2, blank2, word3);
	}
	
	// REGLA: MODAL conjugable + VERB (had to come - va/van haver de venir)
	public void rule158__mod__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule158__mod__infpres",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		macro_conj_verb1(out, word1);
		/** Si el tagger s'equivoca i tria 'inf', ho tractarem com si fos 'pres' */
		macro_passa_inf_a_pres(out, word1);
		/** si entra com a 'pp', ho tractarem com si fos 'past'  */
		macro_passa_pp_a_ifip(out, word1);
		/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb1'  */
		if (word1.sl(attr_temps).equals("<past>"))
		{
			var_lema_SV = "mod_inf_perif";
		}
		else
		{
			var_lema_SV = "mod_inf";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append(word2.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: MODAL conjugable + VERB + clític (had to sing it -> el van haver de cantar)
	public void rule159__mod__infpres__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule159__mod__infpres__probj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		macro_conj_verb1(out, word1);
		/** Si el tagger s'equivoca i tria 'inf', ho tractarem com si fos 'pres' */
		macro_passa_inf_a_pres(out, word1);
		/** si entra com a 'pp', ho tractarem com si fos 'past'  */
		macro_passa_pp_a_ifip(out, word1);
		/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb1'  */
		if (word1.sl(attr_temps).equals("<past>"))
		{
			var_lema_SV = "pro_mod_inf_perif";
		}
		else
		{
			var_lema_SV = "pro_mod_inf";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_prnpro)
			         +word3.tl(attr_pers)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: AUX + MODAL conjugable + VERB (I will have to come - hauré de venir)
	public void rule160__auxnocan__modinf__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule160__auxnocan__modinf__infpres",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		/** MG: potser ho hauria de desdoblar en dues regles, una per a conj_verb1 i una per a conj_verb_compost  */
		if ((word1.sl(attr_lem).equalsIgnoreCase("will")
    || word1.sl(attr_lem).equalsIgnoreCase("shall")
    || word1.sl(attr_lem).equalsIgnoreCase("would")
    || word1.sl(attr_lem).equalsIgnoreCase("do")))
		{
			macro_conj_verb_compost(out, word1, blank1, word2);
			/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb'  */
			if (word1.sl(attr_temps).equals("<past>"))
			{
				var_lema_SV = "mod_inf_perif";
			}
			else
			{
				var_lema_SV = "mod_inf";
			}
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         var_pronom
				         +var_verbfinal
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
			out.append("<inf>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
			macro_f_bcond(out, word2, blank2, word3);
		}
		else
		{
			macro_conj_verb1(out, word1);
			var_lema_SV = "auxmod_mod_inf";
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         var_pronom
				         +var_verbfinal
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
			out.append(word2.tl(attr_a_verb));
			out.append("<inf>");
			out.append(word2.tl(attr_lemq));
			out.append('$');
			out.append(blank2);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append("<inf>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
	}
	
	// REGLA: AUX + MODAL conjugable + VERB + clític (I will have to sing it - l'hauré de cantar)
	public void rule161__auxnocan__modinf__infpres__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule161__auxnocan__modinf__infpres__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		/** MG: potser ho hauria de desdoblar en dues regles, una per a conj_verb1 i una per a conj_verb_compost  */
		if ((word1.sl(attr_lem).equalsIgnoreCase("will")
    || word1.sl(attr_lem).equalsIgnoreCase("shall")
    || word1.sl(attr_lem).equalsIgnoreCase("would")
    || word1.sl(attr_lem).equalsIgnoreCase("do")))
		{
			macro_conj_verb_compost(out, word1, blank1, word2);
			/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb'  */
			if (word1.sl(attr_temps).equals("<past>"))
			{
				var_lema_SV = "pro_mod_inf_perif";
			}
			else
			{
				var_lema_SV = "pro_mod_inf";
			}
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         var_pronom
				         +word4.tl(attr_lem)
				         +word4.tl(attr_a_prnpro)
				         +word4.tl(attr_pers)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
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
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append("<inf>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
			macro_f_bcond(out, word3, blank3, word4);
		}
		else
		{
			macro_conj_verb1(out, word1);
			var_lema_SV = "pro_auxmod_mod_inf";
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         var_pronom
				         +word4.tl(attr_lem)
				         +word4.tl(attr_a_prnpro)
				         +word4.tl(attr_pers)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
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
			out.append(word2.tl(attr_lemh));
			out.append(word2.tl(attr_a_verb));
			out.append("<inf>");
			out.append(word2.tl(attr_lemq));
			out.append('$');
			out.append(blank3);
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append("<inf>");
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
		}
	}
	
	// REGLA: AUX + MODAL conjugable + VERB (I will have to - hauré de)
	public void rule162__auxnocan__modinf(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule162__auxnocan__modinf",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		/** MG: potser ho hauria de desdoblar en dues regles, una per a conj_verb1 i una per a conj_verb_compost  */
		if ((word1.sl(attr_lem).equalsIgnoreCase("will")
    || word1.sl(attr_lem).equalsIgnoreCase("shall")
    || word1.sl(attr_lem).equalsIgnoreCase("would")
    || word1.sl(attr_lem).equalsIgnoreCase("do")))
		{
			macro_conj_verb_compost(out, word1, blank1, word2);
			macro_tipus_verbs(out, word2);
			/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb'  */
			if (word1.sl(attr_temps).equals("<past>"))
			{
				var_lema_SV = "mod_perif";
			}
			else
			{
				var_lema_SV = "mod";
			}
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
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
			out.append("}$");
			macro_f_bcond(out, word1, blank1, word2);
		}
		else
		{
			macro_conj_verb1(out, word1);
			macro_tipus_verbs(out, word1);
			var_lema_SV = "aux_mod";
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
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
			out.append(word2.tl(attr_lemh));
			out.append(word2.tl(attr_a_verb));
			out.append("<inf>");
			out.append(word2.tl(attr_lemq));
			out.append("$}$");
		}
	}
	
	// HAVER PARTICIPI (have finished - han acabat)
	public void rule163__have_aux__pp(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule163__have_aux__pp",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		macro_conj_verb1(out, word1);
		/** Si el tagger s'equivoca i tria 'inf', ho tractarem com si fos 'pres' (MG revisar) */
		macro_passa_inf_a_pres(out, word1);
		if (word1.sl(attr_temps).equals("<past>"))
		{
			var_temps_chunk = "<pii>";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "have_pp"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append(word2.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	/** MG: en cal una per a have_aux_ger per la diferent colocació de l'enclític. i potser tb separar-ho en la regla anterior  */
	// HAVER PARTICIPI clític (have finished it - l'han acabat)
	public void rule164__have_aux_inf__pp__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule164__have_aux_inf__pp__probj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		macro_conj_verb1(out, word1);
		/** Si el tagger s'equivoca i tria 'inf', ho tractarem com si fos 'pres' (MG revisar) */
		macro_passa_inf_a_pres(out, word1);
		if (word1.sl(attr_temps).equals("<past>"))
		{
			var_temps_chunk = "<pii>";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pro_have_pp"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word3.tl(attr_lem)
			         +word3.tl(attr_a_prnpro)
			         +word3.tl(attr_pers)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
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
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	// HAVER PARTICIPIcontrolverb TO INF (BCN)
	public void rule165__have_aux__controlverbpp__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule165__have_aux__controlverbpp__to__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		/** 	<call-macro n="pron"> per si hi ha algun controlverb que sigui pronominal (en ppi no) 
	  <with-param pos="2"/>
	</call-macro>  */
		macro_tipus_verbs_imp(out, word4);
		macro_pronenc(out, word4);
		if (word2.sl(attr_lem).equals("try"))
		{
			word2.tlSet(attr_lem, "intentar");
		}
		macro_conj_verb1(out, word1);
		/** Si el tagger s'equivoca i tria 'inf', ho tractarem com si fos 'pres' (MG revisar) */
		macro_passa_inf_a_pres(out, word1);
		if (word1.sl(attr_temps).equals("<past>"))
		{
			var_temps_chunk = "<pii>";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "have_pp_inf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
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
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word2.tl(attr_lemq));
		out.append('$');
		out.append(blank2);
		out.append('^');
		out.append(word4.tl(attr_lemh));
		out.append(word4.tl(attr_a_verb));
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append(word4.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: VERBcontrol + to + INF (BCN 'try/need/... to do this -> intentar/necessitar/ fer'
	public void rule166__controlverb__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule166__controlverb__to__inf",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		/** 	<call-macro n="pron">
	  <with-param pos="1"/>
	</call-macro>  */
		macro_tipus_verbs_imp(out, word3);
		macro_pronenc(out, word3);
		if (word1.sl(attr_lem).equals("try"))
		{
			word1.tlSet(attr_lem, "intentar");
		}
		macro_conj_verb1(out, word1);
		if (word1.tl(attr_temps).equals("<inf>"))
		{
			var_lema_SV = "inf_inf";
		}
		else
		if (word1.tl(attr_temps).equals("<ger>"))
		{
			var_lema_SV = "ger_inf";
		}
		else
		{
			var_lema_SV = "verbcj_inf";
		}
		/** definitivament decidit, si és 'perif' no canvio el nom del lema sinó que ja se sap pq temps=ifip  */
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		/** 	  <var n="pronom"/> */
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
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: VERBcontrol + to + INF (BCN 'try/need/... to do this -> intentar/necessitar/ fer
	public void rule167__controlverb__to__inf__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule167__controlverb__to__inf__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		/** 	<call-macro n="pron">
	  <with-param pos="1"/>
	</call-macro>  */
		macro_tipus_verbs_imp(out, word3);
		macro_pronenc(out, word3);
		if (word1.sl(attr_lem).equals("try"))
		{
			word1.tlSet(attr_lem, "intentar");
		}
		macro_conj_verb1(out, word1);
		if (word1.tl(attr_temps).equals("<inf>"))
		{
			var_lema_SV = "inf_inf_enc";
		}
		else
		if (word1.tl(attr_temps).equals("<ger>"))
		{
			var_lema_SV = "ger_inf_enc";
		}
		else
		{
			var_lema_SV = "verbcj_inf_enc";
		}
		/** definitivament decidit, si és 'perif' no canvio el nom del lema sinó que ja se sap pq temps=ifip  */
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
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
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append("$^");
		out.append(word4.tl(attr_lem));
		out.append("<prn><enc>");
		out.append(word4.tl(attr_pers));
		out.append(word4.tl(attr_gen));
		out.append(word4.tl(attr_nbr));
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word2, blank2, word3);
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// REGLA: AUX + VERBcontrol + to + INF (BCN 'try/need/... to do this -> intentar/necessitar/ fer'
	public void rule168__auxmod__controlverb__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule168__auxmod__controlverb__to__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_tipus_verbs_imp(out, word4);
		macro_pronenc(out, word4);
		if (word2.sl(attr_lem).equals("try"))
		{
			word2.tlSet(attr_lem, "intentar");
		}
		macro_conj_verb1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "auxmod_inf_inf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
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
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word2.tl(attr_lemq));
		out.append('$');
		out.append(blank2);
		out.append('^');
		out.append(word4.tl(attr_lemh));
		out.append(word4.tl(attr_a_verb));
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append(word4.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// REGLA: AUX + ADV + VERBcontrol + to + INF (BCN 'try/need/... to do this -> intentar/necessitar/ fer'
	public void rule169__auxmod__adv__controlverb__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule169__auxmod__adv__controlverb__to__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_tipus_verbs_imp(out, word5);
		macro_pronenc(out, word5);
		if (word3.sl(attr_lem).equals("try"))
		{
			word3.tlSet(attr_lem, "intentar");
		}
		macro_conj_verb1(out, word1);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append("^auxmod_inf_inf<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
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
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word3.tl(attr_lemq));
		out.append('$');
		out.append(blank3);
		out.append('^');
		out.append(word5.tl(attr_lemh));
		out.append(word5.tl(attr_a_verb));
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append(word5.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word4, blank4, word5);
	}
	
	// REGLA: AUX (temps) + VERBcontrol + to + INF (BCN 'try/need/... to do this -> intentar/necessitar/ fer'
	public void rule170__auxtemps__controlverb__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule170__auxtemps__controlverb__to__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_tipus_verbs_imp(out, word4);
		macro_pronenc(out, word4);
		if (word2.sl(attr_lem).equals("try"))
		{
			word2.tlSet(attr_lem, "intentar");
		}
		macro_conj_verb_compost(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verbcj_inf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
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
		out.append(word4.tl(attr_a_verb));
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append(word4.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word2, blank2, word3);
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// REGLA: AUX (temps) + ADV + VERBcontrol + to + INF (BCN 'try/need/... to do this -> intentar/necessitar/ fer'
	public void rule171__auxtemps__adv__controlverb__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule171__auxtemps__adv__controlverb__to__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_tipus_verbs_imp(out, word5);
		macro_pronenc(out, word5);
		if (word3.sl(attr_lem).equals("try"))
		{
			word3.tlSet(attr_lem, "intentar");
		}
		macro_conj_verb_compost(out, word1, blank2, word3);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append("^verbcj_inf<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
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
		out.append(word5.tl(attr_lemh));
		out.append(word5.tl(attr_a_verb));
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append(word5.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word3, blank3, word4);
		macro_f_bcond(out, word4, blank4, word5);
	}
	
	/** ***************** present i past continuous ******************************  */
	// REGLA: BE GER (am saying -> estic dient)
	public void rule172__be__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule172__be__ger",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		/**  amb això fem el proclític  */
		macro_pron(out, word2);
		/** aquest serveix per fer un enclític  */
		macro_tipus_verbs_imp(out, word2);
		/** amb això fem l'enclític  */
		macro_pronenc(out, word2);
		macro_conj_be_ger(out, word1, blank1, word2);
		if (word1.sl(attr_temps).equals("<past>"))
		{
			macro_f_bcond(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verbcj"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			/** aquí el pronom va davant, en la resta va a darrera  */
			{
				String myword = 
				         var_pronom
				         +var_verbfinal
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
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "be_ger"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
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
				         +word2.tl(attr_temps)
				         +var_pronomenc
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
	
	// REGLA: BE GER clític (am saying it-> ho estic dient)
	public void rule173__be__ger__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule173__be__ger__probj",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		/** aquest serveix per fer un enclític  */
		macro_tipus_verbs_imp(out, word2);
		/** amb això fem l'enclític  */
		macro_pronenc(out, word2);
		macro_conj_be_ger(out, word1, blank1, word2);
		if (word1.sl(attr_temps).equals("<past>"))
		{
			macro_f_bcond(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "pro_verbcj"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			/** aquí el pronom va davant, en la resta va a darrera  */
			{
				String myword = 
				         var_pronom
				         +word3.tl(attr_lem)
				         +word3.tl(attr_a_prnpro)
				         +word3.tl(attr_pers)
				         +word3.tl(attr_gen)
				         +word3.tl(attr_nbr)
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
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "be_ger_enc"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
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
				         +word2.tl(attr_temps)
				         +var_pronomenc
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append('^');
			out.append(word3.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word3.tl(attr_pers));
			out.append(word3.tl(attr_gen));
			out.append(word3.tl(attr_nbr));
			out.append(word2.tl(attr_lemq));
			out.append("$}$");
			macro_f_bcond(out, word2, blank2, word3);
		}
	}
	
	// REGLA: BE ADV GER (is always/not working -> sempre/no està treballant
	public void rule174__be__adv__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule174__be__adv__ger",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		/** aquest serveix per fer un enclític  */
		macro_tipus_verbs_imp(out, word3);
		/** amb això fem l'enclític  */
		macro_pronenc(out, word3);
		macro_conj_be_ger(out, word1, blank2, word3);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		if (word1.sl(attr_temps).equals("<past>"))
		{
			macro_f_bcond(out, word2, blank2, word3);
			out.append("^verbcj<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			/** aquí el pronom va davant, en la resta va a darrera  */
			{
				String myword = 
				         var_pronom
				         +var_verbfinal
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
			out.append("^be_ger<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
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
				         +word3.tl(attr_a_verb)
				         +word3.tl(attr_temps)
				         +var_pronomenc
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
	
	// REGLA: BE ADV GER clític (is always singing it-> sempre l'està cantant
	public void rule175__be__adv__ger__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule175__be__adv__ger__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		/** aquest serveix per fer un enclític  */
		macro_tipus_verbs_imp(out, word3);
		/** amb això fem l'enclític  */
		macro_pronenc(out, word3);
		macro_conj_be_ger(out, word1, blank2, word3);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		if (word1.sl(attr_temps).equals("<past>"))
		{
			macro_f_bcond(out, word2, blank2, word3);
			out.append("^pro_verbcj<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			/** aquí el pronom va davant, en la resta va a darrera  */
			{
				String myword = 
				         var_pronom
				         +word4.tl(attr_lem)
				         +word4.tl(attr_a_prnpro)
				         +word4.tl(attr_pers)
				         +word4.tl(attr_gen)
				         +word4.tl(attr_nbr)
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
		else
		{
			out.append("^be_ger_enc<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
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
				         +word3.tl(attr_a_verb)
				         +word3.tl(attr_temps)
				         +var_pronomenc
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append('^');
			out.append(word4.tl(attr_lem));
			out.append("<prn><enc>");
			out.append(word4.tl(attr_pers));
			out.append(word4.tl(attr_gen));
			out.append(word4.tl(attr_nbr));
			out.append(word3.tl(attr_lemq));
			out.append("$}$");
			macro_f_bcond(out, word3, blank3, word4);
		}
	}
	
	// REGLA: BE CONTROLger TO INF (BCN am planning to go -> estic planejant anar)
	public void rule176__be__controlverbger__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule176__be__controlverbger__to__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_tipus_verbs_imp(out, word4);
		macro_pronenc(out, word4);
		if (word2.sl(attr_lem).equals("try"))
		{
			word2.tlSet(attr_lem, "intentar");
		}
		macro_conj_be_ger(out, word1, blank1, word2);
		if (word1.sl(attr_temps).equals("<past>"))
		{
			macro_f_bcond(out, word1, blank1, word2);
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "verbcj_inf"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
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
			out.append(word4.tl(attr_a_verb));
			out.append("<inf>");
			out.append(var_pronomenc);
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "be_ger_inf"));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_gen_chunk);
			out.append(var_nbr_chunk);
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
			out.append('^');
			out.append(word4.tl(attr_lemh));
			out.append(word4.tl(attr_a_verb));
			out.append("<inf>");
			out.append(var_pronomenc);
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	/** ****************   going to + inf   **********************  */
	// REGLA: BE going to INF (am going to read -> llegiré; was going to read -> anava a llegir ) mireia
	public void rule177__be_past_pres__going__to__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule177__be_past_pres__going__to__infpres",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word4);
		/**  amb això fem el proclític  */
		macro_pron(out, word4);
		macro_conj_going_to_inf(out, word1, blank1, word2, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		macro_f_bcond(out, word2, blank2, word3);
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// REGLA: BE going to INF clitic (am going to read it -> el llegiré; was going to read -> l'anava a llegir )
	public void rule178__be_past_pres__going__to__infpres__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule178__be_past_pres__going__to__infpres__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word4);
		/**  amb això fem el proclític  */
		macro_pron(out, word4);
		macro_conj_going_to_inf(out, word1, blank1, word2, blank3, word4);
		var_lema_SV = (""+"pro_"+var_lema_SV);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word5.tl(attr_lem)
			         +word5.tl(attr_a_prnpro)
			         +word5.tl(attr_pers)
			         +word5.tl(attr_gen)
			         +word5.tl(attr_nbr)
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
		macro_f_bcond(out, word2, blank2, word3);
		macro_f_bcond(out, word3, blank3, word4);
		macro_f_bcond(out, word4, blank4, word5);
	}
	
	// REGLA: BE ADV going to INF (am not/always going to read ->no llegiré; was not/always going to read -> no anava a llegir ) mireia
	public void rule179__be_past_pres__adv__going__to__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule179__be_past_pres__adv__going__to__infpres",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word5);
		/**  amb això fem el proclític  */
		macro_pron(out, word5);
		macro_conj_going_to_inf(out, word1, blank2, word3, blank4, word5);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		macro_f_bcond(out, word3, blank3, word4);
		macro_f_bcond(out, word4, blank4, word5);
	}
	
	// REGLA: BE ADV going to INF clitic (am not/always going to read ->no llegiré; was not/always going to read -> no anava a llegir )
	public void rule180__be_past_pres__adv__going__to__infpres__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule180__be_past_pres__adv__going__to__infpres__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word5);
		/**  amb això fem el proclític  */
		macro_pron(out, word5);
		macro_conj_going_to_inf(out, word1, blank2, word3, blank4, word5);
		var_lema_SV = (""+"pro_"+var_lema_SV);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word6.tl(attr_lem)
			         +word6.tl(attr_a_prnpro)
			         +word6.tl(attr_pers)
			         +word6.tl(attr_gen)
			         +word6.tl(attr_nbr)
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
		macro_f_bcond(out, word3, blank3, word4);
		macro_f_bcond(out, word4, blank4, word5);
		macro_f_bcond(out, word5, blank5, word6);
	}
	
	/** ***************************************** altres ***************  */
	// REGLA: VERB + ING (BCN 'avoid doing -> evitar fer'
	public void rule181__verbcjnoser__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule181__verbcjnoser__ger",  word1, blank1,  word2); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word1);
		macro_pron(out, word1);
		macro_tipus_verbs_imp(out, word2);
		macro_pronenc(out, word2);
		macro_conj_verb1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verbcj_inf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append(word2.tl(attr_a_verb));
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append(word2.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: AUX + VERB + ING (BCN 'can avoid doing -> pot evitar fer'
	public void rule182__auxmod__infpres__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule182__auxmod__infpres__ger",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		/** 	<call-macro n="pron"> ho trec pq no està feta la regla al t3x per arreglar pronoms
	  <with-param pos="2"/>
	</call-macro>  */
		macro_tipus_verbs_imp(out, word3);
		macro_pronenc(out, word3);
		macro_conj_verb1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "auxmod_inf_inf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		/**      <var n="pronom"/>  */
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
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word2.tl(attr_lemq));
		out.append('$');
		out.append(blank2);
		out.append('^');
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_verb));
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: AUX (temps) + VERB + ING (BCN 'will avoid doing this -> evitar fer'
	public void rule183__auxtemps__infpres__ger(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule183__auxtemps__infpres__ger",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word2);
		macro_pron(out, word2);
		macro_tipus_verbs_imp(out, word3);
		macro_pronenc(out, word3);
		macro_conj_verb_compost(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verbcj_inf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: AUX ADV VERB (will always think -> sempre pensaré. will not think -> no pensaré.)
	public void rule184__auxtemps__adv__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule184__auxtemps__adv__infpres",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb_compost(out, word1, blank2, word3);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append('^');
		out.append(var_lema_SV);
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
	
	// REGLA: AUX ADV VERB clític (will always sing it-> sempre el cantaré. will not sing it-> no el cantaré.)
	public void rule185__auxtemps__adv__infpres__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule185__auxtemps__adv__infpres__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb_compost(out, word1, blank2, word3);
		var_lema_SV = (""+"pro_"+var_lema_SV);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append('^');
		out.append(var_lema_SV);
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_prnpro)
			         +word4.tl(attr_pers)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
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
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// REGLA: AUX ADV VERB (can always think -> sempre puc pensar)
	public void rule186__auxmod__adv__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule186__auxmod__adv__infpres",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb1(out, word1);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append("^auxmod_inf<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append("<inf>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: AUX ADV VERB clític (can always think it -> sempre el puc pensar)
	public void rule187__auxmod__adv__infpres__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule187__auxmod__adv__infpres__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb1(out, word1);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append("^pro_auxmod_inf<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_prnpro)
			         +word4.tl(attr_pers)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
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
		out.append('^');
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	// REGLA: AUX ADV VERB (I do not think -> no penso. I do always think -> sempre penso)
	public void rule188__do__adv__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule188__do__adv__infpres",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb_compost(out, word1, blank2, word3);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append('^');
		out.append(var_lema_SV);
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
	
	// REGLA: AUX ADV VERB clític (I do not sing it -> no el canto. I do always sing it-> sempre el canto)
	public void rule189__do__adv__infpres__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule189__do__adv__infpres__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb_compost(out, word1, blank2, word3);
		var_lema_SV = (""+"pro_"+var_lema_SV);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_prnpro)
			         +word4.tl(attr_pers)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
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
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// AUX + ADV + MODAL conjugable + VERB (He will sometimes have to explain - Alguna vegada haurà d'explicar. He will not have to explain -> No haurà d'explicar. He does not have to explain - No ha d'explicar)
	public void rule190__auxnocan__adv__modinf__infpres(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule190__auxnocan__adv__modinf__infpres",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word4);
		macro_pron(out, word4);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		/**  Aquí comença la part de conjugació dels verbsMG: potser ho hauria de desdoblar en dues regles, una per a conj_verb1 i una per a conj_verb_compost  */
		if ((word1.sl(attr_lem).equalsIgnoreCase("will")
    || word1.sl(attr_lem).equalsIgnoreCase("shall")
    || word1.sl(attr_lem).equalsIgnoreCase("would")
    || word1.sl(attr_lem).equalsIgnoreCase("do")))
		{
			macro_conj_verb_compost(out, word1, blank2, word3);
			/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb'  */
			if (word1.sl(attr_temps).equals("<past>"))
			{
				var_lema_SV = "mod_inf_perif";
			}
			else
			{
				var_lema_SV = "mod_inf";
			}
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         var_pronom
				         +var_verbfinal
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
			out.append(word4.tl(attr_a_verb));
			out.append("<inf>");
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
			macro_f_bcond(out, word3, blank3, word4);
		}
		else
		{
			macro_conj_verb1(out, word1);
			var_lema_SV = "auxmod_mod_inf";
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         var_pronom
				         +var_verbfinal
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
			out.append("<inf>");
			out.append(word3.tl(attr_lemq));
			out.append('$');
			out.append(blank3);
			out.append('^');
			out.append(word4.tl(attr_lemh));
			out.append(word4.tl(attr_a_verb));
			out.append("<inf>");
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
	}
	
	// AUX + ADV + MODAL conjugable + VERB + clític (He will sometimes have to explain it- Alguna vegada l'haurà d'explicar. He will not have to explain it-> No l'haurà d'explicar. He does not have to explain it- No l'ha d'explicar)
	public void rule191__auxnocan__adv__modinf__infpres__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule191__auxnocan__adv__modinf__infpres__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word4);
		macro_pron(out, word4);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		/**  Aquí comença la part de conjugació dels verbs */
		if ((word1.sl(attr_lem).equalsIgnoreCase("will")
    || word1.sl(attr_lem).equalsIgnoreCase("shall")
    || word1.sl(attr_lem).equalsIgnoreCase("would")
    || word1.sl(attr_lem).equalsIgnoreCase("do")))
		{
			macro_conj_verb_compost(out, word1, blank2, word3);
			/**  sobrescriu el nom de chunk assignat per la macro 'conj_verb'  */
			if (word1.sl(attr_temps).equals("<past>"))
			{
				var_lema_SV = "pro_mod_inf_perif";
			}
			else
			{
				var_lema_SV = "pro_mod_inf";
			}
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         var_pronom
				         +word5.tl(attr_lem)
				         +word5.tl(attr_a_prnpro)
				         +word5.tl(attr_pers)
				         +word5.tl(attr_gen)
				         +word5.tl(attr_nbr)
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
			out.append('^');
			out.append(word4.tl(attr_lemh));
			out.append(word4.tl(attr_a_verb));
			out.append("<inf>");
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
			macro_f_bcond(out, word4, blank4, word5);
		}
		else
		{
			macro_conj_verb1(out, word1);
			var_lema_SV = "pro_auxmod_mod_inf";
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, var_lema_SV));
			out.append("<SV>");
			out.append(var_tipus_verb);
			out.append(var_temps_chunk);
			out.append(var_pers_chunk);
			out.append(var_nbr_chunk);
			out.append('{');
			{
				String myword = 
				         var_pronom
				         +word5.tl(attr_lem)
				         +word5.tl(attr_a_prnpro)
				         +word5.tl(attr_pers)
				         +word5.tl(attr_gen)
				         +word5.tl(attr_nbr)
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
			out.append('^');
			out.append(word3.tl(attr_lemh));
			out.append(word3.tl(attr_a_verb));
			out.append("<inf>");
			out.append(word3.tl(attr_lemq));
			out.append('$');
			out.append(blank4);
			out.append('^');
			out.append(word4.tl(attr_lemh));
			out.append(word4.tl(attr_a_verb));
			out.append("<inf>");
			out.append(word4.tl(attr_lemq));
			out.append("$}$");
		}
	}
	
	// HAVER ADV PARTICIPI (have always/not asked - Sempre/No han preguntat)
	public void rule192__have_aux__adv__pp(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule192__have_aux__adv__pp",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb1(out, word1);
		/** Si el tagger s'equivoca i tria 'inf', ho tractarem com si fos 'pres' (MG revisar) */
		macro_passa_inf_a_pres(out, word1);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		if (word1.sl(attr_temps).equals("<past>"))
		{
			var_temps_chunk = "<pii>";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
		}
		out.append("^have_pp<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append(word3.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	/** MG: en cal una per a have_aux_ger per la diferent colocació de l'enclític. i potser tb separar-ho en la regla anterior  */
	// PRONOM HAVER PARTICIPI clític (have always/not asked it- Sempre/No l'han preguntat)
	public void rule193__have_aux_inf__adv__pp__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule193__have_aux_inf__adv__pp__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb1(out, word1);
		/** Si el tagger s'equivoca i tria 'inf', ho tractarem com si fos 'pres' (MG revisar) */
		macro_passa_inf_a_pres(out, word1);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		if (word1.sl(attr_temps).equals("<past>"))
		{
			var_temps_chunk = "<pii>";
			var_verbfinal = (""+word1.tl(attr_lemh)+word1.tl(attr_a_verb)+"<3>"+"<4>"+"<5>"+word1.tl(attr_lemq));
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pro_have_pp"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_prnpro)
			         +word4.tl(attr_pers)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
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
		out.append('^');
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	/** pingui would have */
	// AUXtemps HAVER PARTICIPI (would have finished - hauria acabat)
	public void rule194__auxtemps__have_aux_inf__pp(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule194__auxtemps__have_aux_inf__pp",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb_compost(out, word1, blank1, word2);
		macro_f_bcond(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "have_pp"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append(word3.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	// AUXmod HAVER PARTICIPI (might have finished - podria haver acabat)
	public void rule195__auxmod__have_aux_inf__pp(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule195__auxmod__have_aux_inf__pp",  word1, blank1,  word2, blank2,  word3); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "auxmod_have_pp"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append(word2.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word2.tl(attr_lemq));
		out.append('$');
		out.append(blank2);
		out.append('^');
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	// AUXtemps HAVER PARTICIPI clític (would have finished it - l'hauria acabat)
	public void rule196__auxtemps__have_aux_inf__pp__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule196__auxtemps__have_aux_inf__pp__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb_compost(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pro_have_pp"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_prnpro)
			         +word4.tl(attr_pers)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
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
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// AUXmod HAVER PARTICIPI clític (might have finished it - el podria haver acabat)
	public void rule197__auxmod__have_aux_inf__pp__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule197__auxmod__have_aux_inf__pp__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_pron(out, word3);
		macro_conj_verb1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pro_auxmod_have_pp"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word4.tl(attr_lem)
			         +word4.tl(attr_a_prnpro)
			         +word4.tl(attr_pers)
			         +word4.tl(attr_gen)
			         +word4.tl(attr_nbr)
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
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word2.tl(attr_lemq));
		out.append('$');
		out.append(blank3);
		out.append('^');
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word3.tl(attr_lemq));
		out.append("$}$");
	}
	
	// AUXtemps HAVER PARTICIPIcontrolverb TO INF (would have decided to come)
	public void rule198__auxtemps__have_aux_inf__controlverbpp__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule198__auxtemps__have_aux_inf__controlverbpp__to__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_tipus_verbs_imp(out, word5);
		macro_pronenc(out, word5);
		if (word3.sl(attr_lem).equals("try"))
		{
			word3.tlSet(attr_lem, "intentar");
		}
		macro_conj_verb_compost(out, word1, blank1, word2);
		macro_f_bcond(out, word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "have_pp_inf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append(word3.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word3.tl(attr_lemq));
		out.append('$');
		out.append(blank3);
		out.append('^');
		out.append(word5.tl(attr_lemh));
		out.append(word5.tl(attr_a_verb));
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append(word5.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word4, blank4, word5);
	}
	
	// AUXmod HAVER PARTICIPIcontrolverb TO INF (should have decided to come)
	public void rule199__auxmod__have_aux_inf__controlverbpp__to__inf(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule199__auxmod__have_aux_inf__controlverbpp__to__inf",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word3);
		macro_tipus_verbs_imp(out, word5);
		macro_pronenc(out, word5);
		if (word3.sl(attr_lem).equals("try"))
		{
			word3.tlSet(attr_lem, "intentar");
		}
		macro_conj_verb1(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "auxmod_have_pp_inf"));
		out.append("<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append(word2.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word2.tl(attr_lemq));
		out.append('$');
		out.append(blank2);
		out.append('^');
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word3.tl(attr_lemq));
		out.append('$');
		out.append(blank3);
		out.append('^');
		out.append(word5.tl(attr_lemh));
		out.append(word5.tl(attr_a_verb));
		out.append("<inf>");
		out.append(var_pronomenc);
		out.append(word5.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word4, blank4, word5);
	}
	
	// AUXtemps ADV HAVER PARTICIPI (would always/not have asked - Sempre/No hauria preguntat)
	public void rule200__auxtemps__adv__have_aux_inf__pp(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule200__auxtemps__adv__have_aux_inf__pp",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word4);
		macro_pron(out, word4);
		macro_conj_verb_compost(out, word1, blank2, word3);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append("^have_pp<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append("<m><sg>");
		out.append(word4.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word3, blank3, word4);
	}
	
	// AUXmod ADV HAVER PARTICIPI (should always/not have asked - Sempre/No hauria d'haver preguntat)
	public void rule201__auxmod__adv__have_aux_inf__pp(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule201__auxmod__adv__have_aux_inf__pp",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word4);
		macro_pron(out, word4);
		macro_conj_verb1(out, word1);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append("^auxmod_have_pp<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +var_verbfinal
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
		out.append("<inf>");
		out.append(word3.tl(attr_lemq));
		out.append('$');
		out.append(blank3);
		out.append('^');
		out.append(word4.tl(attr_lemh));
		out.append(word4.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word4.tl(attr_lemq));
		out.append("$}$");
	}
	
	// AUXtemps PRONOM HAVER PARTICIPI clític (would always/not have asked it- Sempre/No ho hauria preguntat)
	public void rule202__auxtemps__adv__have_aux_inf__pp__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule202__auxtemps__adv__have_aux_inf__pp__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word4);
		macro_pron(out, word4);
		macro_conj_verb_compost(out, word1, blank2, word3);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append("^pro_have_pp<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word5.tl(attr_lem)
			         +word5.tl(attr_a_prnpro)
			         +word5.tl(attr_pers)
			         +word5.tl(attr_gen)
			         +word5.tl(attr_nbr)
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
		out.append('^');
		out.append(word4.tl(attr_lemh));
		out.append(word4.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word4.tl(attr_lemq));
		out.append("$}$");
		macro_f_bcond(out, word4, blank4, word5);
	}
	
	// AUXmod PRONOM HAVER PARTICIPI clític (should always/not have asked it- Sempre/No ho hauria d'haver preguntat)
	public void rule203__auxmod__adv__have_aux_inf__pp__probj(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule203__auxmod__adv__have_aux_inf__pp__probj",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		macro_firstWord(out, word1);
		macro_tipus_verbs(out, word4);
		macro_pron(out, word4);
		macro_conj_verb1(out, word1);
		if (list_adv_neg.containsIgnoreCase(word2.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word2.tl(attr_a_adv));
		out.append(var_neg);
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
		out.append(blank1);
		out.append("^pro_auxmod_have_pp<SV>");
		out.append(var_tipus_verb);
		out.append(var_temps_chunk);
		out.append(var_pers_chunk);
		out.append(var_nbr_chunk);
		out.append('{');
		{
			String myword = 
			         var_pronom
			         +word5.tl(attr_lem)
			         +word5.tl(attr_a_prnpro)
			         +word5.tl(attr_pers)
			         +word5.tl(attr_gen)
			         +word5.tl(attr_nbr)
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
		out.append('^');
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_verb));
		out.append("<inf>");
		out.append(word3.tl(attr_lemq));
		out.append('$');
		out.append(blank4);
		out.append('^');
		out.append(word4.tl(attr_lemh));
		out.append(word4.tl(attr_a_pp));
		out.append("<m><sg>");
		out.append(word4.tl(attr_lemq));
		out.append("$}$");
	}
	
	/** ***********************************************************************************************  */
	// REL (funció de nom)
	public void rule204__relnom(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule204__relnom",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "relnom"));
		out.append("<REL>");
		out.append(word1.tl(attr_tipus_rel));
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_rel)
			         +(word1.tl(attr_gen)==""?"" : "<3>")
			         +(word1.tl(attr_nbr)==""?"" : "<4>")
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
	
	// REL (funció adjectiva: visitors who search peace)
	public void rule205__reladj(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule205__reladj",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "reladj"));
		out.append("<REL>");
		out.append(word1.tl(attr_tipus_rel));
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lem)
			         +word1.tl(attr_a_rel)
			         +(word1.tl(attr_gen)==""?"" : "<3>")
			         +(word1.tl(attr_nbr)==""?"" : "<4>")
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
	
	// REL whose (quan va sol o amb desconegudes, ho traduïm com 'de qui'. 'The hotel, whose slkjdkj is John - L'hotel, de qui slkjdkj és John.)
	public void rule206__relaa(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule206__relaa",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "relaa"));
		out.append("<REL>");
		out.append(word1.tl(attr_tipus_rel));
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append("{^de<pr>$ ^qui<rel><nn><mf><sp>$}$");
	}
	
	// PRONOM tònic/interrogatiu/possessiu (queda com a GD o ND si és el cas)
	public void rule207__tn_itg_pos(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule207__tn_itg_pos",  word1); } 
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
			         +(word1.tl(attr_gen)==""?"" : "<3>")
			         +(word1.tl(attr_nbr)==""?"" : "<4>")
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
	public void rule208__prep(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule208__prep",  word1); } 
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
	
	// genitiu
	public void rule209__genitiu(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule209__genitiu",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "pr"));
		out.append("<GEN>{");
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
	
	// THERE
	public void rule210__there(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule210__there",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "there"));
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
	
	// ADV
	public void rule211__adv(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule211__adv",  word1); } 
		macro_firstWord(out, word1);
		if (list_adv_neg.containsIgnoreCase(word1.sl(attr_lem)))
		{
			var_neg = "<NEG>";
		}
		else
		{
			var_neg = "";
		}
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "adv"));
		out.append(word1.tl(attr_a_adv));
		out.append(var_neg);
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
	
	// ADV ITG
	public void rule212__advitg(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule212__advitg",  word1); } 
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
	
	// PREADV
	public void rule213__preadv(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule213__preadv",  word1); } 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "preadv"));
		out.append(word1.tl(attr_a_adv));
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
	
	// CNJ
	public void rule214__cnj(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule214__cnj",  word1); } 
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
	
	// REGLA: reset variables
	public void rule215__sent(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule215__sent",  word1); } 
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
	public void rule216__coma(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule216__coma",  word1); } 
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
