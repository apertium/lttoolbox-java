package org.apertium.transfer.generated;
import java.util.*;
import java.io.*;
import org.apertium.transfer.*;
public class apertium_nn_nb_nn_nb_t1x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return false;
	}
	ApertiumRE attr_a_nom = new ApertiumRE("<np><top>|<n><acr>|<np>|<n>");
	ApertiumRE attr_a_adj = new ApertiumRE("<adj><ord><posi>|<adj><ord><comp>|<adj><ord><sup>|<adj><pprs>|<adj><posi>|<adj><comp>|<adj><sup>|<adj><pp>|<adj>");
	ApertiumRE attr_persona = new ApertiumRE("<p1>|<p2>|<p3>");
	ApertiumRE attr_a_verb = new ApertiumRE("<vblex><pstv>|<vblex>");
	ApertiumRE attr_temps = new ApertiumRE("<pres>|<pret>|<inf>|<imp>|<pp>");
	ApertiumRE attr_a_det = new ApertiumRE("<det><emph>|<det><ind>|<det><dem>|<det><itg>|<det><qnt>|<det><pos>|<det>");
	ApertiumRE attr_a_prn = new ApertiumRE("<prn><enc><ref>|<prn><enc>");
	ApertiumRE attr_gen = new ApertiumRE("<mf>|<nt>|<GD>|<m>|<f>");
	ApertiumRE attr_nbr = new ApertiumRE("<sg>|<pl>|<sp>|<ND>");
	ApertiumRE attr_cas = new ApertiumRE("<nom>|<gen>|<acc>");
	ApertiumRE attr_art = new ApertiumRE("<def>|<ind>");
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
	
	private void macro_set_number1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_number1"); }; 
		if (word1.target(attr_nbr, true).equals("<sp>"))
		{
			var_pre_number = "<sp>";
		}
		else
		{
			var_pre_number = word1.target(attr_nbr, true);
		}
		if (word1.target(attr_nbr, true).equals("<ND>"))
		{
			var_pre_number = "<sp>";
		}
	}
	
	private void macro_set_number2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_number2"); }; 
		var_pre_number = word2.target(attr_nbr, true);
		if (var_pre_number.equals("<ND>"))
		{
			var_pre_number = word1.target(attr_nbr, true);
		}
		var_n_number = var_pre_number;
		if ((var_n_number.equals("<sp>")
    || var_n_number.equals("")))
		{
			var_n_number = word1.target(attr_nbr, true);
		}
		if ((word1.target(attr_a_nom, true).equals("<np>")
    || word1.target(attr_a_nom, true).equals("<np><top>")))
		{
			var_n_number = "";
		}
	}
	
	private void macro_set_gender1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_gender1"); }; 
		macro_set_number1(out, word1);
		var_gender = word1.target(attr_gen, true);
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
	
	private void macro_set_gender2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_gender2"); }; 
		macro_set_number2(out, word1, blank1, word2);
		if ((var_pre_number.equals("<sg>")
    && !word2.source(attr_gen, true).equals("")))
		{
			var_gender = word1.target(attr_gen, true);
		}
		else
		if (var_pre_number.equals("<pl>"))
		{
			var_gender = "";
		}
		else
		{
			var_gender = word2.target(attr_gen, true);
		}
		if (var_gender.equals("<f>"))
		{
			var_gender = "<m>";
		}
	}
	
	private void macro_set_adj_gender(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_adj_gender"); }; 
		if ((var_gender.equals("<m>")
    || var_gender.equals("<f>")))
		{
			var_adj_gender = "<mf>";
		}
		else
		{
			var_adj_gender = var_gender;
		}
		if (word1.target(attr_art, true).equals("<def>"))
		{
			var_adj_gender = "";
		}
	}
	
	// VBLEX_BLI VBLEX.PP - bli(r) lese => leses 
	public void rule0__vblex_bli__vblexpp(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule0__vblex_bli__vblexpp"); }; 
		{
			String myword = 
			         word2.target(attr_lemh, true)
			         +word2.target(attr_a_verb, true)
			         +word1.target(attr_temps, true)
			         +"<pass>"
			         +word2.target(attr_lemq, true)
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
	
	// VBLEX_BLI VBLEX.PP - blir ikkje lese => leses ikke 
	public void rule1__vblex_bli__adv__vblexpp(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule1__vblex_bli__adv__vblexpp"); }; 
		{
			String myword = 
			         word3.target(attr_lemh, true)
			         +word3.target(attr_a_verb, true)
			         +word1.target(attr_temps, true)
			         +"<pass>"
			         +word3.target(attr_lemq, true)
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
	}
	
	// VBLEX_BLI VBLEX.PP - blir nok ikkje lese => leses nok ikke 
	public void rule2__vblex_bli__adv__adv__vblexpp(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule2__vblex_bli__adv__adv__vblexpp"); }; 
		{
			String myword = 
			         word4.target(attr_lemh, true)
			         +word4.target(attr_a_verb, true)
			         +word1.target(attr_temps, true)
			         +"<pass>"
			         +word4.target(attr_lemq, true)
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
	}
	
	// VBLEX.INF.PST - lesast => leses 
	public void rule3__vblexinfpst(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule3__vblexinfpst"); }; 
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_verb, true)
			         +"<inf>"
			         +"<pass>"
			         +word1.target(attr_lemq, true)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// VBLEX                    Just in case we have nb multiwords; which need                    lemq after the inflected part.                    This has to be below the passive rules.
	public void rule4__vblex(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule4__vblex"); }; 
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_verb, true)
			         +word1.target(attr_temps, true)
			         +word1.target(attr_lemq, true)
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
	public void rule5__det(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule5__det"); }; 
		macro_set_gender1(out, word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_gender
			         +var_pre_number
			         +word1.target(attr_art, true)
			         +word1.target(attr_lemq, true)
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
	public void rule6__det__nacr(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule6__det__nacr"); }; 
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
	}
	
	// DET NOM
	public void rule7__det__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule7__det__nom"); }; 
		macro_set_gender2(out, word2, " ", word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_gender
			         +var_pre_number
			         +word1.target(attr_art, true)
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
			         +word2.target(attr_a_nom, true)
			         +word2.target(attr_gen, true)
			         +var_n_number
			         +word2.target(attr_art, true)
			         +word2.target(attr_cas, true)
			         +word2.target(attr_lemq, true)
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
	public void rule8__det__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule8__det__adj__nom"); }; 
		macro_set_gender2(out, word3, " ", word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_gender
			         +var_pre_number
			         +word1.target(attr_art, true)
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
		var_gender = word3.target(attr_gen, true);
		macro_set_adj_gender(out, word2);
		{
			String myword = 
			         word2.target(attr_lemh, true)
			         +word2.target(attr_a_adj, true)
			         +var_adj_gender
			         +word2.target(attr_nbr, true)
			         +word2.target(attr_art, true)
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
			         word3.target(attr_lemh, true)
			         +word3.target(attr_a_nom, true)
			         +word3.target(attr_gen, true)
			         +var_n_number
			         +word3.target(attr_art, true)
			         +word3.target(attr_cas, true)
			         +word3.target(attr_lemq, true)
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
	public void rule9__adj(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule9__adj"); }; 
		var_gender = word1.target(attr_gen, true);
		macro_set_adj_gender(out, word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_adj, true)
			         +var_adj_gender
			         +word1.target(attr_nbr, true)
			         +word1.target(attr_art, true)
			         +word1.target(attr_lemq, true)
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
