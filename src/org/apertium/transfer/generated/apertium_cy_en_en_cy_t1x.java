package org.apertium.transfer.generated;
import java.util.*;
import java.io.*;
import org.apertium.transfer.*;
public class apertium_cy_en_en_cy_t1x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return true;
	}
	ApertiumRE attr_a_det = new ApertiumRE("<det><ind>|<det><def>|<det><dem>|<det><pos>|<det><ord>");
	ApertiumRE attr_a_verb = new ApertiumRE("<vbhaver>|<vblex>|<vbmod>|<vbser>");
	ApertiumRE attr_a_adj = new ApertiumRE("<adj><sint>|<adj>");
	ApertiumRE attr_a_nom = new ApertiumRE("<np><loc>|<np><ant>|<n><acr>|<n><unc>|<n>");
	ApertiumRE attr_a_np_acr = new ApertiumRE("<acr>|<np>");
	ApertiumRE attr_pers = new ApertiumRE("<p1>|<p2>|<p3>");
	ApertiumRE attr_deg = new ApertiumRE("<comp>|<sup>");
	ApertiumRE attr_nbr = new ApertiumRE("<sg>|<pl>|<sp>|<ND>");
	ApertiumRE attr_gen = new ApertiumRE("<mf>|<nt>|<f>|<m>");
	ApertiumRE attr_temps = new ApertiumRE("<past>|<pres>|<prs>|<cni>|<pii>|<fut>|<imp>|<inf>|<plu>|<cns>|<ger>");
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
	String var_nombre = "";
	String var_caseFirstWord = "";
	String var_EOS = "";
	String var_adjectiu1 = "";
	TransferWordList list_prepos_adjs = new TransferWordList(new String[] { "hen", "ambell", "pob", "prif", "holl", "cryn", });
	
	private void macro_firstWord(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_firstWord",  word1); } 
		if (word1.source(attr_a_np_acr, true).equals(""))
		{
			if (var_EOS.equals("true"))
			{
				word1.setTarget(attr_lem, TransferWord.copycase("aa", word1.target(attr_lem, true)), true);
				var_caseFirstWord = "Aa";
			}
		}
		else
		{
			var_caseFirstWord = "aa";
		}
		var_EOS = "false";
	}
	
	private void macro_adjectiu(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_adjectiu",  word1); } 
		var_adjectiu1 = "";
		if ((word1.source(attr_a_adj, true).equals("<adj><sint>")
    && word1.source(attr_deg, true).equals("<comp>")))
		{
			var_adjectiu1 = (""+"mawr"+"<adj><sint><comp>"+"$ ^"+word1.target(attr_lem, true)+word1.target(attr_a_adj, true));
		}
		else
		if ((word1.source(attr_a_adj, true).equals("<adj><sint>")
    && word1.source(attr_deg, true).equals("<sup>")))
		{
			var_adjectiu1 = (""+"mawr"+"<adj><sint><sup>"+"$ ^"+word1.target(attr_lem, true)+word1.target(attr_a_adj, true));
		}
		else
		{
			var_adjectiu1 = (""+word1.target(attr_whole, true));
		}
	}
	
	// REGLA: NOM
	public void rule0__nom(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule0__nom",  word1); } 
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom"));
		out.append("<SN>");
		out.append(word1.target(attr_gen, true));
		out.append(word1.target(attr_nbr, true));
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_nom, true)
			         +(word1.target(attr_gen, true).isEmpty()?"" : "<2>")
			         +(word1.target(attr_nbr, true).isEmpty()?"" : "<3>")
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
		var_caseFirstWord = "aa";
	}
	
	// REGLA: DET NOM
	public void rule1__det__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule1__det__nom",  word1, blank1,  word2); } 
		if (word1.source(attr_a_det, true).equals("<det><ind>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom"));
			out.append("<SN>");
			out.append(word2.target(attr_gen, true));
			out.append(word2.target(attr_nbr, true));
			out.append('{');
			{
				String myword = 
				         word2.target(attr_lemh, true)
				         +word2.target(attr_a_nom, true)
				         +(word2.target(attr_gen, true).isEmpty()?"" : "<2>")
				         +(word2.target(attr_nbr, true).isEmpty()?"" : "<3>")
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
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom"));
			out.append("<SN>");
			out.append(word2.target(attr_gen, true));
			out.append(word2.target(attr_nbr, true));
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
			out.append(" ");
			{
				String myword = 
				         word2.target(attr_lemh, true)
				         +word2.target(attr_a_nom, true)
				         +(word2.target(attr_gen, true).isEmpty()?"" : "<2>")
				         +(word2.target(attr_nbr, true).isEmpty()?"" : "<3>")
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
			var_caseFirstWord = "aa";
		}
	}
	
	// REGLA: DET ADJ NOM
	public void rule2__det__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule2__det__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_adjectiu(out, word2);
		if (list_prepos_adjs.containsIgnoreCase(word2.target(attr_lem, true)))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_adj_nom"));
			out.append("<SN>");
			out.append(word3.target(attr_gen, true));
			out.append(word3.target(attr_nbr, true));
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
			out.append(" ");
			{
				String myword = 
				         word2.target(attr_lem, true)
				         +word2.target(attr_a_adj, true)
				         +word2.target(attr_deg, true)
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
				         word3.target(attr_lemh, true)
				         +word3.target(attr_a_nom, true)
				         +(word3.target(attr_gen, true).isEmpty()?"" : "<2>")
				         +(word3.target(attr_nbr, true).isEmpty()?"" : "<3>")
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
			var_caseFirstWord = "aa";
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj"));
			out.append("<SN>");
			out.append(word3.target(attr_gen, true));
			out.append(word3.target(attr_nbr, true));
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
			out.append(" ");
			{
				String myword = 
				         word3.target(attr_lemh, true)
				         +word3.target(attr_a_nom, true)
				         +(word3.target(attr_gen, true).isEmpty()?"" : "<2>")
				         +(word3.target(attr_nbr, true).isEmpty()?"" : "<3>")
				         +word3.target(attr_lemq, true)
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
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append("}$");
			var_caseFirstWord = "aa";
		}
	}
	
	// REGLA: DET
	public void rule3__det(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule3__det",  word1); } 
		if (word1.source(attr_a_det, true).equals("<det><ind>"))
		{
			out.append(" ");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom"));
			out.append("<SN>");
			out.append(word1.target(attr_gen, true));
			out.append(word1.target(attr_nbr, true));
			out.append('{');
			{
				String myword = 
				         word1.target(attr_lem, true)
				         +word1.target(attr_a_det, true)
				         +word1.target(attr_nbr, true)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append("}$");
			var_caseFirstWord = "aa";
		}
	}
	
	// REGLA: VBLEX
	public void rule4__verb(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule4__verb",  word1); } 
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verb"));
		out.append("<SV>");
		out.append(word1.target(attr_nbr, true));
		out.append('{');
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_verb, true)
			         +word1.target(attr_temps, true)
			         +word1.target(attr_pers, true)
			         +word1.target(attr_nbr, true)
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
		var_caseFirstWord = "aa";
	}
	
	// REGLA: instead of VERB ger
	public void rule5__instead_of__verbger(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule5__instead_of__verbger",  word1, blank1,  word2); } 
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verbinf"));
		out.append("<SV>");
		out.append(word2.target(attr_a_verb, true));
		out.append("<inf>");
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
		out.append(" ");
		{
			String myword = 
			         word2.target(attr_lemh, true)
			         +word2.target(attr_a_verb, true)
			         +(word2.target(attr_temps, true).isEmpty()?"" : "<3>")
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
		out.append(" ");
	}
	
	// REGLA: PRSUBJ VBLEX
	public void rule6__prsubj__verb(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule6__prsubj__verb",  word1, blank1,  word2); } 
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prn_verb"));
		out.append("<SV>");
		out.append(word1.target(attr_pers, true));
		out.append(word1.target(attr_nbr, true));
		out.append('{');
		{
			String myword = 
			         word2.target(attr_lemh, true)
			         +word2.target(attr_a_verb, true)
			         +word2.target(attr_temps, true)
			         +"<2>"
			         +"<3>"
			/** 
              <clip pos="2" side="tl" part="pers" link-to="2"/>
              <clip pos="2" side="tl" part="nbr" link-to="3"/>
	       */
			         +word2.target(attr_lemq, true)
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
		var_caseFirstWord = "aa";
	}
}
