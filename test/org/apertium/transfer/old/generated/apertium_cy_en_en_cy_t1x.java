package org.apertium.transfer.old.generated;
import java.io.*;
import org.apertium.transfer.*;
import org.apertium.transfer.generated.GeneratedTransferBase;
public class apertium_cy_en_en_cy_t1x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return true;
	}
	ApertiumRE attr_a_det = new ApertiumRE("<det><(?:ind|def|dem|pos|ord)>");
	ApertiumRE attr_a_verb = new ApertiumRE("<vb(?:haver|lex|mod|ser)>");
	ApertiumRE attr_a_adj = new ApertiumRE("<adj(?:><sint|)>");
	ApertiumRE attr_a_nom = new ApertiumRE("<n(?:p><loc|p><ant|><acr|><unc|)>");
	ApertiumRE attr_a_np_acr = new ApertiumRE("<(?:acr|np)>");
	ApertiumRE attr_pers = new ApertiumRE("<p(?:1|2|3)>");
	ApertiumRE attr_deg = new ApertiumRE("<(?:com|su)p>");
	ApertiumRE attr_nbr = new ApertiumRE("<(?:sg|pl|sp|ND)>");
	ApertiumRE attr_gen = new ApertiumRE("<(?:mf|nt|f|m)>");
	ApertiumRE attr_temps = new ApertiumRE("<(?:past|pres|prs|cni|pii|fut|imp|inf|plu|cns|ger)>");
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
	WordList list_prepos_adjs = new WordList(new String[] { "hen", "ambell", "pob", "prif", "holl", "cryn", });
	
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
		}
		else
		{
			var_caseFirstWord = "aa";
		}
		var_EOS = "false";
	}
	
	private void macro_adjectiu(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_adjectiu",  word1); } 
		var_adjectiu1 = "";
		if ((word1.sl(attr_a_adj).equals("<adj><sint>")
    && word1.sl(attr_deg).equals("<comp>")
    && word1.tl(attr_a_adj).equals("<adj>")))
		{
			var_adjectiu1 = (""+"mawr"+"<adj><sint><comp>"+"$ ^"+word1.tl(attr_lem)+word1.tl(attr_a_adj));
		}
		else
		if ((word1.sl(attr_a_adj).equals("<adj><sint>")
    && word1.sl(attr_deg).equals("<sup>")
    && word1.tl(attr_a_adj).equals("<adj>")))
		{
			var_adjectiu1 = (""+"mawr"+"<adj><sint><sup>"+"$ ^"+word1.tl(attr_lem)+word1.tl(attr_a_adj));
		}
		else
		{
			var_adjectiu1 = (""+word1.tl(attr_whole));
		}
	}
	
	// REGLA: NOM
	public void rule0__nom(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule0__nom",  word1); } 
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "nom"));
		out.append("<SN>");
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +(word1.tl(attr_gen)==""?"" : "<2>")
			         +(word1.tl(attr_nbr)==""?"" : "<3>")
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
		var_caseFirstWord = "aa";
	}
	
	// REGLA: DET NOM
	public void rule1__det__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule1__det__nom",  word1, blank1,  word2); } 
		if (word1.sl(attr_a_det).equals("<det><ind>"))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom"));
			out.append("<SN>");
			out.append(word2.tl(attr_gen));
			out.append(word2.tl(attr_nbr));
			out.append('{');
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +(word2.tl(attr_gen)==""?"" : "<2>")
				         +(word2.tl(attr_nbr)==""?"" : "<3>")
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
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom"));
			out.append("<SN>");
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
			out.append(" ");
			{
				String myword = 
				         word2.tl(attr_lemh)
				         +word2.tl(attr_a_nom)
				         +(word2.tl(attr_gen)==""?"" : "<2>")
				         +(word2.tl(attr_nbr)==""?"" : "<3>")
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
			var_caseFirstWord = "aa";
		}
	}
	
	// REGLA: DET ADJ NOM
	public void rule2__det__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule2__det__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_adjectiu(out, word2);
		if (list_prepos_adjs.containsIgnoreCase(word2.tl(attr_lem)))
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_adj_nom"));
			out.append("<SN>");
			out.append(word3.tl(attr_gen));
			out.append(word3.tl(attr_nbr));
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
			out.append(" ");
			{
				String myword = 
				         word2.tl(attr_lem)
				         +word2.tl(attr_a_adj)
				         +word2.tl(attr_deg)
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
				         +(word3.tl(attr_gen)==""?"" : "<2>")
				         +(word3.tl(attr_nbr)==""?"" : "<3>")
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
			var_caseFirstWord = "aa";
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "det_nom_adj"));
			out.append("<SN>");
			out.append(word3.tl(attr_gen));
			out.append(word3.tl(attr_nbr));
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
			out.append(" ");
			{
				String myword = 
				         word3.tl(attr_lemh)
				         +word3.tl(attr_a_nom)
				         +(word3.tl(attr_gen)==""?"" : "<2>")
				         +(word3.tl(attr_nbr)==""?"" : "<3>")
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
	public void rule3__det(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule3__det",  word1); } 
		if (word1.sl(attr_a_det).equals("<det><ind>"))
		{
			out.append(" ");
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(var_caseFirstWord, "nom"));
			out.append("<SN>");
			out.append(word1.tl(attr_gen));
			out.append(word1.tl(attr_nbr));
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
			out.append("}$");
			var_caseFirstWord = "aa";
		}
	}
	
	// REGLA: VBLEX
	public void rule4__verb(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule4__verb",  word1); } 
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verb"));
		out.append("<SV>");
		out.append(word1.tl(attr_nbr));
		out.append('{');
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_verb)
			         +word1.tl(attr_temps)
			         +word1.tl(attr_pers)
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
		var_caseFirstWord = "aa";
	}
	
	// REGLA: instead of VERB ger
	public void rule5__instead_of__verbger(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule5__instead_of__verbger",  word1, blank1,  word2); } 
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "verbinf"));
		out.append("<SV>");
		out.append(word2.tl(attr_a_verb));
		out.append("<inf>{");
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
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_verb)
			         +(word2.tl(attr_temps)==""?"" : "<3>")
			         +word2.tl(attr_lemq)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append("}$ ");
	}
	
	// REGLA: PRSUBJ VBLEX
	public void rule6__prsubj__verb(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule6__prsubj__verb",  word1, blank1,  word2); } 
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "prn_verb"));
		out.append("<SV>");
		out.append(word1.tl(attr_pers));
		out.append(word1.tl(attr_nbr));
		out.append('{');
		/** 
              <clip pos="2" side="tl" part="pers" link-to="2"/>
              <clip pos="2" side="tl" part="nbr" link-to="3"/>
	       */
		out.append('^');
		out.append(word2.tl(attr_lemh));
		out.append(word2.tl(attr_a_verb));
		out.append(word2.tl(attr_temps));
		out.append("<2><3>");
		out.append(word2.tl(attr_lemq));
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
		var_caseFirstWord = "aa";
	}
}
