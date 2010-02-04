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
	ApertiumRE attr_a_nom = new ApertiumRE("<n><acr><re>|<np><ant>|<np><cog>|<np><top>|<n><acr>|<np><al>|<np>|<n>");
	ApertiumRE attr_a_acr = new ApertiumRE("<acr><re>|<np><top>|<np><al>|<acr>");
	ApertiumRE attr_a_any = new ApertiumRE("<np>|<n>");
	ApertiumRE attr_a_prp = new ApertiumRE("<pr>");
	ApertiumRE attr_a_adj = new ApertiumRE("<adj><sint><comp>|<adj><sint><sup>|<adj><pst>|<adj><itg>|<adj><pos>|<adj>");
	ApertiumRE attr_a_vrb = new ApertiumRE("<vblex><sep>|<vblex>|<vbser>|<vaux>");
	ApertiumRE attr_a_det = new ApertiumRE("<det><def>|<det><ind>|<det><pos>|<det><qnt>|<det><itg>|<det><qnt>|<det><dem>");
	ApertiumRE attr_a_prn = new ApertiumRE("<prn><subj>|<prn><ref>|<prn><itg>|<prn><obj>|<prn><tn>|<prn>");
	ApertiumRE attr_a_prn__sen__subj_obj = new ApertiumRE("<prn><ref>|<prn><itg>|<prn><tn>|<prn>");
	ApertiumRE attr_a_tns = new ApertiumRE("<pres>|<subs>|<pprs>|<past>|<pri>|<imp>|<inf>|<cni>|<ger>|<fti>|<pp>");
	ApertiumRE attr_a_gen = new ApertiumRE("<nt>|<mf>|<GD>|<m>|<f>");
	ApertiumRE attr_a_prs = new ApertiumRE("<p1>|<p2>|<p3>");
	ApertiumRE attr_a_nbr = new ApertiumRE("<sp>|<sg>|<pl>|<ND>");
	ApertiumRE attr_a_cas = new ApertiumRE("<nom>|<acc>");
	ApertiumRE attr_a_np_acr = new ApertiumRE("<acr>|<np>");
	ApertiumRE attr_lem = new ApertiumRE("(([^<]|\"\\<\")+)");
	ApertiumRE attr_lemq = new ApertiumRE("\\#[- _][^<]+");
	ApertiumRE attr_lemh = new ApertiumRE("(([^<#]|\"\\<\"|\"\\#\")+)");
	ApertiumRE attr_whole = new ApertiumRE("(.+)");
	ApertiumRE attr_tags = new ApertiumRE("((<[^>]+>)+)");
	ApertiumRE attr_chname = new ApertiumRE("(\\{([^/]+)\\/)");
	ApertiumRE attr_chcontent = new ApertiumRE("(\\{.+)");
	ApertiumRE attr_content = new ApertiumRE("(\\{.+)");
	String var_numero = "";
	String var_temps = "";
	String var_adjectiu = "";
	String var_preadv_added = "";
	String var_nomvar = "";
	String var_tmp1 = "";
	String var_tmp2 = "";
	String var_caseFirstWord = "";
	String var_EOS = "false";
	String var_venontaVortoEstuMajuskla = "";
	String var_tipus_verb = "";
	String var_macro_tmp1 = "";
	String var_verbkonj = "";
	String var_chunk_name = "";
	String var_determiner = "";
	String var_blanko = "";
	String var_and_or_but = "";
	String var_DEBUG = "";
	TransferWordList list_adv_neg = new TransferWordList(new String[] { "not", });
	TransferWordList list_reportingverb = new TransferWordList(new String[] { "say", "admit", "agree", "decide", "deny", "explain", "insist", "promise", "recommend", "suggest", "point", "think", "believe", "hope", "fear", "suppose", });
	TransferWordList list_netransitivaj = new TransferWordList(new String[] { "be", "seem", "become", "appear", "there be", });
	TransferWordList list_willwouldshallhave = new TransferWordList(new String[] { "have", "will", "would", "shall", });
	TransferWordList list_listo_and_or_but = new TransferWordList(new String[] { "and", "but", "or", });
	
	private void macro_firstWord(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_firstWord"); }; 
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
	
	private void macro_set_nomvar_if_known1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_nomvar_if_known1"); }; 
		if (word1.target(attr_a_nbr, true).equals(""))
		{
			var_nomvar = "";
		}
		else
		{
			var_nomvar = "<nom>";
		}
	}
	
	private void macro_ordigu_genron(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_ordigu_genron"); }; 
		if (word1.target(attr_a_gen, true).equalsIgnoreCase("<GD>"))
		{
			word1.setTarget(attr_a_gen, "<m>", true);
		}
	}
	
	private void macro_set_numero1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_numero1"); }; 
		if (word1.target(attr_a_nbr, true).equals("<pl>"))
		{
			var_numero = "<pl>";
		}
		else
		{
			var_numero = "<sg>";
		}
	}
	
	private void macro_set_adjectiu2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_adjectiu2"); }; 
		macro_set_numero1(out, word2);
		var_adjectiu = "";
		var_preadv_added = "";
		if (word1.source(attr_a_adj, true).equals("<adj><sint><comp>"))
		{
			var_adjectiu = (""+TransferWord.copycase(word1.source(attr_lem, true), "pli")+"<preadv>"+"$ ^"+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
			var_preadv_added = "preadv_";
		}
		else
		if (word1.source(attr_a_adj, true).equals("<adj><sint><sup>"))
		{
			var_adjectiu = (""+TransferWord.copycase(word1.source(attr_lem, true), "plej")+"<preadv>"+"$ ^"+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
			var_preadv_added = "preadv_";
		}
		else
		if (word1.target(attr_a_adj, true).equals("<adj>"))
		{
			var_adjectiu = (""+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
		}
		else
		{
			var_adjectiu = (""+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
		}
	}
	
	private void macro_set_tipus_verbs1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_tipus_verbs1"); }; 
		if (list_netransitivaj.containsIgnoreCase(word1.source(attr_lemh, true)))
		{
			var_tipus_verb = "<netransitiva>";
		}
		else
		if (list_reportingverb.containsIgnoreCase(word1.source(attr_lemh, true)))
		{
			var_tipus_verb = "<reporting>";
		}
		else
		{
			var_tipus_verb = "<aliaj>";
		}
	}
	
	private void macro_set_verbkonj2_do(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_verbkonj2_do"); }; 
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
		if (debug) { logCall("macro_set_verbkonj2_willShallWould"); }; 
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
		if (debug) { logCall("macro_set_temps1"); }; 
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
	
	private void macro_sendu_blankon_se_havas_formaton2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_sendu_blankon_se_havas_formaton2"); }; 
		if (!blank1.equals(" "))
		{
			out.append(blank1);
		}
	}
	
	private void macro_set_blankon_se_havas_formaton2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_blankon_se_havas_formaton2"); }; 
		if (blank1.equals(" "))
		{
			var_blanko = "";
		}
		else
		{
			var_blanko = blank1;
		}
	}
	
	private void macro_set_determiner3(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("macro_set_determiner3"); }; 
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
			var_determiner = (""+"^"+word1.target(attr_lemh, true)+word1.target(attr_a_det, true)+word3.target(attr_a_nbr, true)+"<2>"+word1.target(attr_lemq, true)+"$"+blank1);
		}
	}
	
	private void macro_set_determiner_de_genitivo2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_determiner_de_genitivo2"); }; 
		macro_set_numero1(out, word2);
		if (word1.source(attr_lem, true).equalsIgnoreCase("a"))
		{
			var_determiner = "";
		}
		else
		{
			word1.setTarget(attr_lem, TransferWord.copycase("aa", word1.target(attr_lem, true)), true);
			var_determiner = (""+"^"+word1.target(attr_lemh, true)+word1.target(attr_a_det, true)+var_numero+"<nom>"+word1.target(attr_lemq, true)+"$"+" ");
		}
	}
	
	private void macro_set_and_or_but(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_and_or_but"); }; 
		if (list_listo_and_or_but.containsIgnoreCase(word1.source(attr_lem, true)))
		{
			var_and_or_but = "<and_or_but>";
		}
		else
		{
			var_and_or_but = "<konstato>";
		}
	}
	
	// REGLA: prnref   - himself, themselves
	public void rule0__prnref(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule0__prnref"); }; 
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
		if (debug) { logCall("rule1__prnaltres"); }; 
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
		if (debug) { logCall("rule2__prnpers"); }; 
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
		if (debug) { logCall("rule3__num"); }; 
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
		if (debug) { logCall("rule4__monato__num_dato"); }; 
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
		if (debug) { logCall("rule5__monato__num_ord"); }; 
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
		if (debug) { logCall("rule6__on__monato__num_dato"); }; 
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
		if (debug) { logCall("rule7__on__monato__num_ord"); }; 
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
		if (debug) { logCall("rule8__num_sen_ord__of"); }; 
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
		if (debug) { logCall("rule9__num_sen_ord__times__num_sen_ord"); }; 
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
	
	// REGLA NUM time   5 times => 5 fojoj, 5th time => 5a fojo,   
	public void rule10__num__times(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule10__num__times"); }; 
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
		if (debug) { logCall("rule11__a"); }; 
		if (word1.source(attr_lem, true).equals("A"))
		{
			var_venontaVortoEstuMajuskla = "true";
		}
		var_EOS = "false";
	}
	
	// REGLA: DET the, his, ... (alia ol 'a')
	public void rule12__det(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule12__det"); }; 
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
	
	// REGLA: NOM
	public void rule13__nom(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule13__nom"); }; 
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
		if (debug) { logCall("rule14__more__nom"); }; 
		macro_firstWord(out, word1);
		macro_ordigu_genron(out, word2);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "more_nom"));
		out.append("<SN><nom>");
		out.append('{');
		{
			String myword = 
			         word1.target(attr_whole, true)
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
		if (debug) { logCall("rule15__det__nom"); }; 
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
	
	// REGLA: DET NOM NOM (nova)  la testaj firmaoj
	public void rule16__det__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule16__det__nom__nom"); }; 
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
			         +word2.target(attr_a_gen, true)
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
		if (debug) { logCall("rule17__det__nom__nom__nom"); }; 
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
			         +word2.target(attr_a_gen, true)
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
			         +word3.target(attr_a_gen, true)
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
		if (debug) { logCall("rule18__det__nom__nom__nom__nom"); }; 
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
			         +word2.target(attr_a_gen, true)
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
			         +word3.target(attr_a_gen, true)
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
			         +word4.target(attr_a_gen, true)
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
		if (debug) { logCall("rule19__adj"); }; 
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
		if (debug) { logCall("rule20__det__adj__nom"); }; 
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
	
	// REGLA: ADJ NOM
	public void rule21__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule21__adj__nom"); }; 
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
		if (debug) { logCall("rule22__adj__adj__nom"); }; 
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
		if (debug) { logCall("rule23__det__unknown_adv_num__unknown_adv_num__nom"); }; 
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
		if (debug) { logCall("rule24__det__adj__adj__nom"); }; 
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
		if (debug) { logCall("rule25__det__adj__adj__adj__nom"); }; 
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
	
	// REGLA: NOM NOM   - testaj firmaoj (nova provo)
	public void rule26__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule26__nom__nom"); }; 
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
		if (debug) { logCall("rule27__ant_cog"); }; 
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
		if (debug) { logCall("rule28__ant_cog__ant_cog"); }; 
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
		if (debug) { logCall("rule29__ant_cog__ant_cog__ant_cog"); }; 
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
		if (debug) { logCall("rule30__ant_cog__ant_cog__ant_cog__ant_cog"); }; 
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
		if (debug) { logCall("rule31__ant_cog__guio__ant_cog__ant_cog"); }; 
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
		if (debug) { logCall("rule32__ant_cog__ant_cog__guio__ant_cog"); }; 
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
		if (debug) { logCall("rule33__ant_cog__guio__ant_cog__ant_cog__guio__ant_cog"); }; 
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
		if (debug) { logCall("rule34__genitive_possessors__gen__nom"); }; 
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
		out.append(blank2);
		{
			String myword = 
			         word1.target(attr_lem, true)
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
		if (debug) { logCall("rule35__genitive_possessors__gen__nom"); }; 
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
		out.append(blank2);
		{
			String myword = 
			         word1.target(attr_lem, true)
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
		if (debug) { logCall("rule36__genitive_possessors__gen__nom__nom"); }; 
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
			         +"<adj>"
			         +word3.target(attr_a_acr, true)
			         +word3.target(attr_a_gen, true)
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
		out.append(" ");
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
		out.append(blank3);
		{
			String myword = 
			         word1.target(attr_lem, true)
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
		if (debug) { logCall("rule37__det__genitive_possessors__gen__nom"); }; 
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
		out.append(var_tmp2);
		out.append(" ");
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
		out.append(var_blanko);
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
		out.append(blank3);
		out.append(var_determiner);
		{
			String myword = 
			         word2.target(attr_lem, true)
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
		if (debug) { logCall("rule38__det__genitive_possessors__genitive_possessors__gen__nom"); }; 
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
		out.append(blank2);
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
		out.append(var_blanko);
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
		out.append(blank4);
		out.append(var_determiner);
		{
			String myword = 
			         word2.target(attr_lem, true)
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
	
	// rekunu and, or kaj nor aparte - ĉar povas esti parto de listo de aferoj
	public void rule39__and_or_nor(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule39__and_or_nor"); }; 
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
	
	public void rule40__cnjcoo(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule40__cnjcoo"); }; 
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
		if (debug) { logCall("rule41__cnjadv"); }; 
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
		if (debug) { logCall("rule42__cnjsub"); }; 
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
		if (debug) { logCall("rule43__cm"); }; 
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
	
	public void rule44__rel(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule44__rel"); }; 
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
	
	public void rule45__preadv(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule45__preadv"); }; 
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
	
	public void rule46__predet(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule46__predet"); }; 
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
	
	public void rule47__adv(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule47__adv"); }; 
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
	
	public void rule48__pr(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule48__pr"); }; 
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
		if (debug) { logCall("rule49__gen"); }; 
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
		if (debug) { logCall("rule50__sent_komopunkto_dupunkto"); }; 
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
		if (debug) { logCall("rule51__sent"); }; 
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
		if (debug) { logCall("rule52__unknown"); }; 
		macro_firstWord(out, word1);
		out.append('^');
		out.append(TransferWord.copycase(var_caseFirstWord, "unknown"));
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
	
	// REGLA: to VBLEXinf
	public void rule53__to__vblexinf(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule53__to__vblexinf"); }; 
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
		if (debug) { logCall("rule54__of__vblexger"); }; 
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
		if (debug) { logCall("rule55__to__vbhaverinf__vblex_vbser"); }; 
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
	
	// REGLA: be VBLEXger
	public void rule56__vbser__vblexger(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule56__vbser__vblexger"); }; 
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
		if (debug) { logCall("rule57__vblex__out"); }; 
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
		if (debug) { logCall("rule58__vbser__not"); }; 
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
		if (debug) { logCall("rule59__please__c_vblex_pres"); }; 
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
		if (debug) { logCall("rule60__do__adv__infpres"); }; 
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
		if (debug) { logCall("rule61__do__infpres"); }; 
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
	
	// REGLA: VAUX VBLEX
	public void rule62__vaux_vbhaver__vblex_vbser(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule62__vaux_vbhaver__vblex_vbser"); }; 
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
		if (debug) { logCall("rule63__vaux_vbhaver__adv__vblex_vbser"); }; 
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
		if (debug) { logCall("rule64__vaux_vbhaver__adv__adv__vblex_vbser"); }; 
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
		if (debug) { logCall("rule65__vaux_vbhaver__vbhaver__vblex_vbser"); }; 
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
		if (debug) { logCall("rule66__vaux_vbhaver__vbser__vblexger"); }; 
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
	
	public void rule67__vbdo(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule67__vbdo"); }; 
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
		if (debug) { logCall("rule68__vb_all"); }; 
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
