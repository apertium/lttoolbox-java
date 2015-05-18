package org.apertium.transfer.old.generated;
import java.io.*;
import org.apertium.transfer.*;
import org.apertium.transfer.generated.GeneratedTransferBase;
public class apertium_nn_nb_nn_nb_t1x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return false;
	}
	ApertiumRE attr_a_nom = new ApertiumRE("<n(?:p><top|><acr|p|)>");
	ApertiumRE attr_a_adj = new ApertiumRE("<adj(?:><ord><posi|><ord><comp|><ord><sup|><pprs|><posi|><comp|><sup|><pp|)>");
	ApertiumRE attr_persona = new ApertiumRE("<p(?:1|2|3)>");
	ApertiumRE attr_a_verb = new ApertiumRE("<vblex(?:><pstv|)>");
	ApertiumRE attr_temps = new ApertiumRE("<(?:pres|pret|inf|imp|pp)>");
	ApertiumRE attr_a_det = new ApertiumRE("<det(?:><emph|><ind|><dem|><itg|><qnt|><pos|)>");
	ApertiumRE attr_a_prn = new ApertiumRE("<prn><enc(?:><ref|)>");
	ApertiumRE attr_gen = new ApertiumRE("<(?:mf|nt|GD|m|f)>");
	ApertiumRE attr_nbr = new ApertiumRE("<(?:sg|pl|sp|ND)>");
	ApertiumRE attr_cas = new ApertiumRE("<(?:nom|gen|acc)>");
	ApertiumRE attr_art = new ApertiumRE("<(?:def|ind)>");
	ApertiumRE attr_lem = new ApertiumRE("(([^<]|\"\\<\")+)");
	ApertiumRE attr_lemq = new ApertiumRE("\\#[- _][^<]+");
	ApertiumRE attr_lemh = new ApertiumRE("(([^<#]|\"\\<\"|\"\\#\")+)");
	ApertiumRE attr_whole = new ApertiumRE("(.+)");
	ApertiumRE attr_tags = new ApertiumRE("((<[^>]+>)+)");
	ApertiumRE attr_chname = new ApertiumRE("(\\{([^/]+)\\/)");
	ApertiumRE attr_chcontent = new ApertiumRE("(\\{.+)");
	ApertiumRE attr_content = new ApertiumRE("(\\{.+)");
	String var_gender = "";
	String var_pre_number = "";
	String var_adj_gender = "";
	String var_n_number = "";
	
	private void macro_set_number1(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_number1",  word1); } 
		/**  arg.1: determiner
           "Heuristic": If ND, let pre_number be sp
       */
		if (word1.tl(attr_nbr).equals("<sp>"))
		{
			var_pre_number = "<sp>";
		}
		else
		{
			var_pre_number = word1.tl(attr_nbr);
		}
		if (word1.tl(attr_nbr).equals("<ND>"))
		{
			var_pre_number = "<sp>";
		}
	}
	
	private void macro_set_number2(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_number2",  word1, blank1,  word2); } 
		/**  arg.1: noun, arg.2: determiner (or adjective)
	   If it's ND, take that of noun, o/w take that of determiner.
           If determiner is sp or nil, or noun is sp, take that of noun.
       */
		var_pre_number = word2.tl(attr_nbr);
		if (var_pre_number.equals("<ND>"))
		{
			var_pre_number = word1.tl(attr_nbr);
		}
		var_n_number = var_pre_number;
		if ((var_n_number.equals("<sp>")
    || var_n_number.equals("")
    || word1.tl(attr_nbr).equals("<sp>")))
		{
			var_n_number = word1.tl(attr_nbr);
		}
		if ((word1.tl(attr_a_nom).equals("<np>")
    || word1.tl(attr_a_nom).equals("<np><top>")))
		{
			var_n_number = "";
		}
	}
	
	private void macro_set_gender1(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_gender1",  word1); } 
		/**  arg.1: determiner
           - default: keep determiner gender
           - GD in singular or sp gets m (only nouns may be mf sp)
           - plurals get no gender
           - make sure we never translate to f, in case
	     bidix has errors...
       */
		macro_set_number1(out, word1);
		var_gender = word1.tl(attr_gen);
		if (((var_pre_number.equals("<sg>")
    || var_pre_number.equals("<sp>"))
    && var_gender.equals("<GD>")))
		{
			var_gender = "<m>";
		}
		else
		if (var_pre_number.equals("<pl>"))
		{
			var_gender = "";
		}
		else
		if (var_gender.equals("<f>"))
		{
			var_gender = "<m>";
		}
	}
	
	private void macro_set_gender2(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_gender2",  word1, blank1,  word2); } 
		/**  arg.1: noun, arg.2: determiner (or adjective)
	   - iff sg AND has-some-gender, take gender of target noun 
	   - plurals get no gender (sp, however, may want mf);
	   - o/w take gender of target determiner
           - Finally, make sure we never translate to f, in case
	     bidix has errors...
       */
		macro_set_number2(out, word1, blank1, word2);
		if ((var_pre_number.equals("<sg>")
    && !word2.sl(attr_gen).equals("")))
		{
			var_gender = word1.tl(attr_gen);
		}
		else
		if (var_pre_number.equals("<pl>"))
		{
			var_gender = "";
		}
		else
		{
			var_gender = word2.tl(attr_gen);
		}
		if (var_gender.equals("<f>"))
		{
			var_gender = "<m>";
		}
	}
	
	private void macro_set_adj_gender(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_adj_gender",  word1); } 
		/**  arg.1: adjective (used for determination, "art")
          Assumes var gender is set, o/w we get empty string 
	   - if m or f or GD, use mf
	     (we might have GD if set_gender 'failed')
	   - o/w use what we're given.
         However, definite adjectives get no gender.
       */
		if ((var_gender.equals("<m>")
    || var_gender.equals("<f>")
    || var_gender.equals("<GD>")))
		{
			var_adj_gender = "<mf>";
		}
		else
		{
			var_adj_gender = var_gender;
		}
		if (word1.tl(attr_art).equals("<def>"))
		{
			var_adj_gender = "";
		}
	}
	
	// VBLEX_BLI VBLEX.PP - bli(r) lese => leses 
	public void rule0__vblex_bli__vblexpp(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule0__vblex_bli__vblexpp",  word1, blank1,  word2); } 
		out.append('^');
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_verb));
		out.append(word1.tl(attr_temps));
		out.append("<pass>");
		out.append(word2.tl(attr_lemq));
		out.append('$');
		out.append(blank1);
	}
	
	// VBLEX_BLI VBLEX.PP - blir ikkje lese => leses ikke 
	public void rule1__vblex_bli__adv__vblexpp(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule1__vblex_bli__adv__vblexpp",  word1, blank1,  word2, blank2,  word3); } 
		out.append('^');
		out.append(word3.tl(attr_lemh));
		out.append(word3.tl(attr_a_verb));
		out.append(word1.tl(attr_temps));
		out.append("<pass>");
		out.append(word3.tl(attr_lemq));
		out.append('$');
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
	
	// VBLEX_BLI VBLEX.PP - blir nok ikkje lese => leses nok ikke 
	public void rule2__vblex_bli__adv__adv__vblexpp(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule2__vblex_bli__adv__adv__vblexpp",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		out.append('^');
		out.append(word4.tl(attr_lemh));
		out.append(word4.tl(attr_a_verb));
		out.append(word1.tl(attr_temps));
		out.append("<pass>");
		out.append(word4.tl(attr_lemq));
		out.append('$');
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
	
	// VBLEX.INF.PST - lesast => leses 
	public void rule3__vblexinfpst(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule3__vblexinfpst",  word1); } 
		out.append('^');
		out.append(word1.tl(attr_lemh));
		out.append(word1.tl(attr_a_verb));
		out.append("<inf><pass>");
		out.append(word1.tl(attr_lemq));
		out.append('$');
	}
	
	// VBLEX                    Just in case we have nb multiwords; which need                    lemq after the inflected part.                    This has to be below the passive rules.
	public void rule4__vblex(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule4__vblex",  word1); } 
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_verb)
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
	}
	
	// DET: kva => hvilken                    If GD, choose m (we never mark determiners mf)
	public void rule5__det(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule5__det",  word1); } 
		macro_set_gender1(out, word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_gender
			         +var_pre_number
			         +word1.tl(attr_art)
			         +word1.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// DET NACR: eit kl => et kl
	public void rule6__det__nacr(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule6__det__nacr",  word1, blank1,  word2); } 
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
	
	// DET NOM
	public void rule7__det__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule7__det__nom",  word1, blank1,  word2); } 
		macro_set_gender2(out, word2, " ", word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_gender
			         +var_pre_number
			         +word1.tl(attr_art)
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
			         +var_n_number
			         +word2.tl(attr_art)
			         +word2.tl(attr_cas)
			         +word2.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// DET ADJ NOM
	public void rule8__det__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule8__det__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_set_gender2(out, word3, " ", word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_gender
			         +var_pre_number
			         +word1.tl(attr_art)
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
		var_gender = word3.tl(attr_gen);
		macro_set_adj_gender(out, word2);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +var_adj_gender
			         +word2.tl(attr_nbr)
			         +word2.tl(attr_art)
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
			         +var_n_number
			         +word3.tl(attr_art)
			         +word3.tl(attr_cas)
			         +word3.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// ADJ: open(m) => åpen(mf)
	public void rule9__adj(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule9__adj",  word1); } 
		var_gender = word1.tl(attr_gen);
		macro_set_adj_gender(out, word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_adj)
			         +var_adj_gender
			         +word1.tl(attr_nbr)
			         +word1.tl(attr_art)
			         +word1.tl(attr_lemq)
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
