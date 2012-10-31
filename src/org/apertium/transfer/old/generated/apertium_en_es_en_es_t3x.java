package org.apertium.transfer.old.generated;
import java.io.*;
import org.apertium.transfer.*;
import org.apertium.transfer.generated.GeneratedTransferBase;
import org.apertium.interchunk.InterchunkWord;
public class apertium_en_es_en_es_t3x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return false;
	}
	ApertiumRE attr_pers = new ApertiumRE("<(?:p1|p2|p3|PD)>");
	ApertiumRE attr_gen = new ApertiumRE("<(?:mf|GD|nt|m|f)>");
	ApertiumRE attr_nbr = new ApertiumRE("<(?:sg|pl|sp|ND)>");
	ApertiumRE attr_tipus_verb = new ApertiumRE("<SV(?:><pron|)>");
	ApertiumRE attr_temps = new ApertiumRE("<(?:pres|past|pprs|subs|ifip|cni|fti|ifi|imp|pii|pis|inf|prs|pri|ger|pp)>");
	/** 'Per determinar', per a SN UNDET que han de passar a determinats, transformació que farà el postchunk detectant els PDET.  */
	ApertiumRE attr_a_SN = new ApertiumRE("<(?:UNDET|PDET|DET|NUM)>");
	ApertiumRE attr_a_verb = new ApertiumRE("<(?:vblex><pron|vbhaver|vblex|vbser|vbmod|HAY)>");
	ApertiumRE attr_a_nom = new ApertiumRE("<n(?:><acr|p|)>");
	ApertiumRE attr_a_np = new ApertiumRE("<np><(?:ant|cog|al)>");
	ApertiumRE attr_a_prnpro = new ApertiumRE("<prn><pro(?:><ref|)>");
	ApertiumRE attr_a_prnenc = new ApertiumRE("<prn><enc(?:><ref|)>");
	ApertiumRE attr_a_prn = new ApertiumRE("<prn><(?:pro><ref|enc><ref|pro|enc)>");
	ApertiumRE attr_tipusprn = new ApertiumRE("<(?:pro|enc)>");
	ApertiumRE attr_a_ref = new ApertiumRE("<ref>");
	ApertiumRE attr_lem = new ApertiumRE("(([^<]|\"\\<\")+)");
	ApertiumRE attr_lemq = new ApertiumRE("\\#[- _][^<]+");
	ApertiumRE attr_lemh = new ApertiumRE("(([^<#]|\"\\<\"|\"\\#\")+)");
	ApertiumRE attr_whole = new ApertiumRE("(.+)");
	ApertiumRE attr_tags = new ApertiumRE("((<[^>]+>)+)");
	ApertiumRE attr_chname = new ApertiumRE("(\\{([^/]+)\\/)");
	ApertiumRE attr_chcontent = new ApertiumRE("(\\{.+)");
	ApertiumRE attr_content = new ApertiumRE("(\\{.+)");
	String var_paraula = "";
	String var_genero = "";
	String var_numero = "";
	String lu_count;
	
	private void macro_f_bcond(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("macro_f_bcond",  word1); } 
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-def-macros>/<def-macro n="f_bcond" npar="1">/<choose>/<when>/<test>/<not>/<equal>/<b pos="1">
		if (!"".equals(" "))
		{
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-def-macros>/<def-macro n="f_bcond" npar="1">/<choose>/<when>/<out>/<b pos="1">
			out.append("");
		}
	}
	
	private void macro_gen_nbr_determinante(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("macro_gen_nbr_determinante",  word1); } 
		if (!word1.tl(attr_gen).equals("<mf>"))
		{
			var_genero = word1.tl(attr_gen);
		}
		else
		{
			var_genero = "<m>";
		}
		if (!word1.tl(attr_nbr).equals("<sp>"))
		{
			var_numero = word1.tl(attr_nbr);
		}
		else
		{
			var_numero = "<sg>";
		}
	}
	
	// CHUNK: nom
	public void rule0__nom(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule0__nom",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		macro_gen_nbr_determinante(out, words[0]);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// CHUNK: SN_2words3
	public void rule1__SN_2words3(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule1__SN_2words3",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		macro_gen_nbr_determinante(out, words[0]);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  si s'ha afegit l'adverbi 'més' davant adj, cal enviar una posició més  */
		if (lu_count.equals("3"))
		{
			out.append(blanks[2]);
			{
				String myword = 
				         words[3].tl(attr_whole)
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
	
	// CHUNK: nom conj nom
	public void rule2__nom_i_nom(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule2__nom_i_nom",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
			macro_gen_nbr_determinante(out, words[1]);
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			{
				String myword = 
				         words[2].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[2]);
			macro_gen_nbr_determinante(out, words[3]);
			out.append('^');
			out.append(TransferWord.copycase(words[3].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			{
				String myword = 
				         words[3].tl(attr_whole)
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
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			{
				String myword = 
				         words[2].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[2]);
			{
				String myword = 
				         words[3].tl(attr_whole)
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
	
	// CHUNK: SN_3words5
	public void rule3__SN_3words5(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule3__SN_3words5",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		macro_gen_nbr_determinante(out, words[0]);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[2]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  si s'ha afegit l'adverbi 'més' davant adj, cal enviar una posició (o dues) més  */
		if (lu_count.equals("4"))
		{
			out.append(blanks[3]);
			{
				String myword = 
				         words[4].tl(attr_whole)
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
		if (lu_count.equals("5"))
		{
			out.append(blanks[3]);
			{
				String myword = 
				         words[4].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[4]);
			{
				String myword = 
				         words[5].tl(attr_whole)
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
	
	// CHUNK: SN_3words
	public void rule4__SN_3words(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule4__SN_3words",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		macro_gen_nbr_determinante(out, words[0]);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[2]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// CHUNK: SN_4words6
	public void rule5__SN_4words6(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule5__SN_4words6",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		macro_gen_nbr_determinante(out, words[0]);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[2]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[3]);
		{
			String myword = 
			         words[4].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  si s'ha afegit l'adverbi 'més' davant adj, cal enviar una posició (o dues) més  */
		if (lu_count.equals("5"))
		{
			out.append(blanks[4]);
			{
				String myword = 
				         words[5].tl(attr_whole)
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
		if (lu_count.equals("6"))
		{
			out.append(blanks[4]);
			{
				String myword = 
				         words[5].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[5]);
			{
				String myword = 
				         words[6].tl(attr_whole)
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
	
	// CHUNK: SN de 5 paraules: es posa det si son PDET
	public void rule6__SN_5words(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule6__SN_5words",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		macro_gen_nbr_determinante(out, words[0]);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[2]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[3]);
		{
			String myword = 
			         words[4].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[4]);
		{
			String myword = 
			         words[5].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// CHUNK: SN de 6 paraules: es posa det si son PDET
	public void rule7__SN_6words(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule7__SN_6words",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		macro_gen_nbr_determinante(out, words[0]);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[2]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[3]);
		{
			String myword = 
			         words[4].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[4]);
		{
			String myword = 
			         words[5].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[5]);
		{
			String myword = 
			         words[6].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// CHUNK: SN de 5 paraules: es posa det si son PDET
	public void rule8__SN_5words7(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule8__SN_5words7",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		macro_gen_nbr_determinante(out, words[0]);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[2]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[3]);
		{
			String myword = 
			         words[4].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[4]);
		{
			String myword = 
			         words[5].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  si s'ha afegit l'adverbi 'més' davant adj, cal enviar una posició (o dues) més  */
		if (lu_count.equals("6"))
		{
			out.append(blanks[5]);
			{
				String myword = 
				         words[6].tl(attr_whole)
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
		if (lu_count.equals("7"))
		{
			out.append(blanks[5]);
			{
				String myword = 
				         words[6].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[6]);
			{
				String myword = 
				         words[7].tl(attr_whole)
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
	
	// CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv
	public void rule9__SN_6words7(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule9__SN_6words7",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		macro_gen_nbr_determinante(out, words[0]);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[2]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[3]);
		{
			String myword = 
			         words[4].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[4]);
		{
			String myword = 
			         words[5].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[5]);
		{
			String myword = 
			         words[6].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  si s'ha afegit l'adverbi 'més' davant adj, cal enviar una posició (o dues) més  */
		if (lu_count.equals("7"))
		{
			out.append(blanks[6]);
			{
				String myword = 
				         words[7].tl(attr_whole)
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
	
	// CHUNK: SN de 7 paraules: es posa det si son PDET
	public void rule10__SN_7words(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule10__SN_7words",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		macro_gen_nbr_determinante(out, words[0]);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[2]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[3]);
		{
			String myword = 
			         words[4].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[4]);
		{
			String myword = 
			         words[5].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[5]);
		{
			String myword = 
			         words[6].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[6]);
		{
			String myword = 
			         words[7].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// CHUNK: SN_4words
	public void rule11__SN_4words(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule11__SN_4words",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		macro_gen_nbr_determinante(out, words[0]);
		if ((words[0].tl(attr_a_SN).equals("<PDET>")
    && !words[1].tl(attr_a_nom).equals("<np>")
    && !words[1].tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(words[0].sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			words[1].tlSet(attr_lem, TransferWord.copycase("aa", words[1].tl(attr_lem)));
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[2]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[3]);
		{
			String myword = 
			         words[4].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// CHUNK: INF
	public void rule12__inf(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule12__inf",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if ((!words[0].tl(attr_pers).equals("<PD>")
    && !words[0].tl(attr_temps).equals("<inf>")))
		{
			{
				String myword = 
				         words[1].tl(attr_lemh)
				         +words[1].tl(attr_tags)
				         +words[0].tl(attr_pers)
				         +words[0].tl(attr_nbr)
				         +words[1].tl(attr_lemq)
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
				         words[1].tl(attr_whole)
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
	
	// CHUNK: INF + 2a paraula
	public void rule13__inf_2(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule13__inf_2",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if ((!words[0].tl(attr_pers).equals("<PD>")
    && !words[0].tl(attr_temps).equals("<inf>")))
		{
			{
				String myword = 
				         words[1].tl(attr_lemh)
				         +words[1].tl(attr_tags)
				         +words[0].tl(attr_pers)
				         +words[0].tl(attr_nbr)
				         +words[1].tl(attr_lemq)
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
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// CHUNK: INF + enc
	public void rule14__inf_enc(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule14__inf_enc",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			/** Si no ha rebut persona i nombre, el pronom es torna reflexiu. Si ha rebut persona i nbr, s'enllaçarà automàticament pers i nbr del verb amb pers i nbr del pronom (pronom afegit en el t1x en veure que era un verb pronominal)  */
			if (words[0].tl(attr_pers).equals("<PD>"))
			{
				words[2].tlSet(attr_lem, "se");
				words[2].tlSet(attr_a_prn, "<prn><enc><ref>");
				words[2].tlSet(attr_pers, "<p3>");
				words[2].tlSet(attr_nbr, "<sp>");
				/** creem una mlu amb el verb i l'enclític  */
				out.append('^');
				out.append(words[1].tl(attr_whole));
				out.append('+');
				out.append(words[2].tl(attr_whole));
				out.append('$');
			}
			else
			{
				if (words[0].tl(attr_pers).equals("<p3>"))
				{
					words[2].tlSet(attr_lem, "se");
					words[2].tlSet(attr_a_prn, "<prn><pro><ref>");
					words[2].tlSet(attr_pers, "<p3>");
					words[2].tlSet(attr_nbr, "<sp>");
				}
				else
				{
					words[2].tlSet(attr_a_prn, "<prn><pro>");
				}
				{
					String myword = 
					         words[2].tl(attr_whole)
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
					         words[1].tl(attr_lemh)
					         +words[1].tl(attr_tags)
					         +words[0].tl(attr_pers)
					         +words[0].tl(attr_nbr)
					         +words[1].tl(attr_lemq)
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
		else
		{
			if ((!words[0].tl(attr_pers).equals("<PD>")
    && !words[0].tl(attr_temps).equals("<inf>")))
			{
				words[2].tlSet(attr_tipusprn, "<pro>");
				{
					String myword = 
					         words[2].tl(attr_whole)
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
					         words[1].tl(attr_lemh)
					         +words[1].tl(attr_tags)
					         +words[0].tl(attr_pers)
					         +words[0].tl(attr_nbr)
					         +words[1].tl(attr_lemq)
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
				/** creem una mlu amb el verb i l'enclític  */
				out.append('^');
				out.append(words[1].tl(attr_whole));
				out.append('+');
				out.append(words[2].tl(attr_whole));
				out.append('$');
			}
		}
	}
	
	public void rule15__inf_enc_enc(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule15__inf_enc_enc",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			/** Si no ha rebut persona i nombre, el pronom es torna reflexiu. Si ha rebut persona i nbr, s'enllaçarà automàticament pers i nbr del verb amb pers i nbr del pronom (pronom afegit en el t1x en veure que era un verb pronominal)  */
			if (words[0].tl(attr_pers).equals("<PD>"))
			{
				words[2].tlSet(attr_lem, "se");
				words[2].tlSet(attr_a_prn, "<prn><enc><ref>");
				words[2].tlSet(attr_pers, "<p3>");
				words[2].tlSet(attr_nbr, "<sp>");
				/** creem una mlu amb el verb i l'enclític  */
				out.append('^');
				out.append(words[1].tl(attr_whole));
				out.append('+');
				out.append(words[2].tl(attr_whole));
				out.append('+');
				out.append(words[3].tl(attr_whole));
				out.append('$');
			}
			else
			{
				if (words[0].tl(attr_pers).equals("<p3>"))
				{
					words[2].tlSet(attr_lem, "se");
					words[2].tlSet(attr_a_prn, "<prn><pro><ref>");
					words[2].tlSet(attr_pers, "<p3>");
					words[2].tlSet(attr_nbr, "<sp>");
				}
				else
				{
					words[2].tlSet(attr_a_prn, "<prn><pro>");
				}
				words[3].tlSet(attr_tipusprn, "<pro>");
				{
					String myword = 
					         words[2].tl(attr_whole)
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
					         words[3].tl(attr_whole)
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
					         words[1].tl(attr_lemh)
					         +words[1].tl(attr_tags)
					         +words[0].tl(attr_pers)
					         +words[0].tl(attr_nbr)
					         +words[1].tl(attr_lemq)
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
		else
		{
			if ((!words[0].tl(attr_pers).equals("<PD>")
    && !words[0].tl(attr_temps).equals("<inf>")))
			{
				words[2].tlSet(attr_tipusprn, "<pro>");
				words[3].tlSet(attr_tipusprn, "<pro>");
				{
					String myword = 
					         words[2].tl(attr_whole)
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
					         words[3].tl(attr_whole)
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
					         words[1].tl(attr_lemh)
					         +words[1].tl(attr_tags)
					         +words[0].tl(attr_pers)
					         +words[0].tl(attr_nbr)
					         +words[1].tl(attr_lemq)
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
				/** creem una mlu amb el verb i els enclítics  */
				out.append('^');
				out.append(words[1].tl(attr_whole));
				out.append('+');
				out.append(words[2].tl(attr_whole));
				out.append('+');
				out.append(words[3].tl(attr_whole));
				out.append('$');
			}
		}
	}
	
	// CHUNK: INF +INF + enc
	public void rule16__inf_inf_enc(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule16__inf_inf_enc",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (words[2].tl(attr_a_verb).equals("<vblex><pron>"))
		{
			/** Si no ha rebut persona i nombre, el pronom es torna reflexiu. Si ha rebut persona i nbr, s'enllaçarà automàticament pers i nbr del verb amb pers i nbr del pronom (pronom afegit en el t1x en veure que era un verb pronominal)  */
			if (words[0].tl(attr_pers).equals("<PD>"))
			{
				words[3].tlSet(attr_lem, "se");
				words[3].tlSet(attr_a_prn, "<prn><enc><ref>");
				words[3].tlSet(attr_pers, "<p3>");
				words[3].tlSet(attr_nbr, "<sp>");
				/** creem una mlu amb el verb i l'enclític  */
				{
					String myword = 
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				out.append('^');
				out.append(words[2].tl(attr_whole));
				out.append('+');
				out.append(words[3].tl(attr_whole));
				out.append('+');
				out.append(words[4].tl(attr_whole));
				out.append('$');
			}
			else
			{
				if (words[0].tl(attr_pers).equals("<p3>"))
				{
					words[3].tlSet(attr_lem, "se");
					words[3].tlSet(attr_a_prn, "<prn><enc><ref>");
					words[3].tlSet(attr_pers, "<p3>");
					words[3].tlSet(attr_nbr, "<sp>");
				}
				{
					String myword = 
					         words[1].tl(attr_lemh)
					         +words[1].tl(attr_tags)
					         +words[0].tl(attr_pers)
					         +words[0].tl(attr_nbr)
					         +words[1].tl(attr_lemq)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				out.append('^');
				out.append(words[2].tl(attr_whole));
				out.append('+');
				out.append(words[3].tl(attr_whole));
				out.append('+');
				out.append(words[4].tl(attr_whole));
				out.append('$');
			}
		}
		else
		{
			if ((!words[0].tl(attr_pers).equals("<PD>")
    && !words[0].tl(attr_temps).equals("<inf>")))
			{
				{
					String myword = 
					         words[1].tl(attr_lemh)
					         +words[1].tl(attr_tags)
					         +words[0].tl(attr_pers)
					         +words[0].tl(attr_nbr)
					         +words[1].tl(attr_lemq)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				out.append('^');
				out.append(words[2].tl(attr_whole));
				out.append('+');
				out.append(words[3].tl(attr_whole));
				out.append('$');
			}
			else
			{
				/** creem una mlu amb el verb i l'enclític  */
				{
					String myword = 
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				out.append('^');
				out.append(words[2].tl(attr_whole));
				out.append('+');
				out.append(words[3].tl(attr_whole));
				out.append('$');
			}
		}
	}
	
	public void rule17__have_enc_pp(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule17__have_enc_pp",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		/** 	<choose>
	  <when>
	    <test><!-*-Mirem si ha deixat de ser 'inf' i ha rebut persona i nombre. Si no és PD tampoc serà ND, en principi 
	    PER AL CAS DE INF_ENC, PER ARA NO ES DÓNA EL CAS QUE DEIXI DE SER INF-*->
	      <and>
		<not>
		  <equal>
		    <clip pos="0" part="pers"/>
		    <lit-tag v="PD"/>
		  </equal>
		</not>
		<not>
		  <equal>
		    <clip pos="0" part="temps"/>
		    <lit-tag v="inf"/>
		  </equal>
		</not>
	      </and>
	    </test>      
	    <out>
	      <lu>
		<clip pos="1" part="lemh"/>
		<clip pos="1" part="tags"/>
		<clip pos="0" part="pers"/>
		<clip pos="0" part="nbr"/>
		<clip pos="1" part="lemq"/>
	      </lu> 
	    </out>  
	  </when>
	  <otherwise>
	    <out>
	      <lu>
		<clip pos="1" part="whole"/>
	      </lu>
	    </out>
	  </otherwise>
	</choose>  */
		if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			/** Si no ha rebut persona i nombre, el pronom es torna reflexiu. Si ha rebut persona i nbr, s'enllaçarà automàticament pers i nbr cap a dins del pronom  */
			if (words[0].tl(attr_pers).equals("<PD>"))
			{
				words[2].tlSet(attr_lem, "se");
				words[2].tlSet(attr_a_prn, "<prn><enc><ref>");
				words[2].tlSet(attr_pers, "<p3>");
				words[2].tlSet(attr_nbr, "<sp>");
			}
		}
		/** creem una mlu amb el verb i l'enclític  */
		out.append('^');
		out.append(words[1].tl(attr_whole));
		out.append('+');
		out.append(words[2].tl(attr_whole));
		out.append('$');
		out.append(blanks[2]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	public void rule18__have_enc_enc_pp(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule18__have_enc_enc_pp",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		/** 	<choose>
	  <when>
	    <test><!-*-Mirem si ha deixat de ser 'inf' i ha rebut persona i nombre. Si no és PD tampoc serà ND, en principi 
	    PER AL CAS DE INF_ENC, PER ARA NO ES DÓNA EL CAS QUE DEIXI DE SER INF-*->
	      <and>
		<not>
		  <equal>
		    <clip pos="0" part="pers"/>
		    <lit-tag v="PD"/>
		  </equal>
		</not>
		<not>
		  <equal>
		    <clip pos="0" part="temps"/>
		    <lit-tag v="inf"/>
		  </equal>
		</not>
	      </and>
	    </test>      
	    <out>
	      <lu>
		<clip pos="1" part="lemh"/>
		<clip pos="1" part="tags"/>
		<clip pos="0" part="pers"/>
		<clip pos="0" part="nbr"/>
		<clip pos="1" part="lemq"/>
	      </lu> 
	    </out>  
	  </when>
	  <otherwise>
	    <out>
	      <lu>
		<clip pos="1" part="whole"/>
	      </lu>
	    </out>
	  </otherwise>
	</choose>  */
		if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			/** Si no ha rebut persona i nombre, el pronom es torna reflexiu. Si ha rebut persona i nbr, s'enllaçarà automàticament pers i nbr cap a dins del pronom  */
			if (words[0].tl(attr_pers).equals("<PD>"))
			{
				words[2].tlSet(attr_lem, "se");
				words[2].tlSet(attr_a_prn, "<prn><enc><ref>");
				words[2].tlSet(attr_pers, "<p3>");
				words[2].tlSet(attr_nbr, "<sp>");
			}
		}
		/** creem una mlu amb el verb i els enclítics  */
		out.append('^');
		out.append(words[1].tl(attr_whole));
		out.append('+');
		out.append(words[2].tl(attr_whole));
		out.append('+');
		out.append(words[3].tl(attr_whole));
		out.append('$');
		out.append(blanks[3]);
		{
			String myword = 
			         words[4].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// CHUNK: GER  (BCN)
	public void rule19__ger(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule19__ger",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if ((!words[0].tl(attr_pers).equals("<PD>")
    && !words[0].tl(attr_temps).equals("<ger>")))
		{
			{
				String myword = 
				         words[1].tl(attr_lemh)
				         +words[1].tl(attr_tags)
				         +words[0].tl(attr_pers)
				         +words[0].tl(attr_nbr)
				         +words[1].tl(attr_lemq)
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
				         words[1].tl(attr_whole)
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
	
	// CHUNK: GER ENC
	public void rule20__ger_enc(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule20__ger_enc",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if ((!words[0].tl(attr_pers).equals("<PD>")
    && !words[0].tl(attr_temps).equals("<ger>")))
		{
			if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				words[2].tlSet(attr_lem, "se");
				words[2].tlSet(attr_a_prn, "<prn><pro><ref>");
				words[2].tlSet(attr_pers, "<p3>");
				words[2].tlSet(attr_nbr, "<sp>");
			}
			/** només tindrà valor si el pronom és reflexiu  */
			out.append('^');
			out.append(words[2].tl(attr_lem));
			out.append("<prn><pro>");
			out.append(words[2].tl(attr_a_ref));
			out.append(words[2].tl(attr_pers));
			out.append(words[2].tl(attr_gen));
			out.append(words[2].tl(attr_nbr));
			out.append('$');
			out.append(blanks[1]);
			{
				String myword = 
				         words[1].tl(attr_lemh)
				         +words[1].tl(attr_tags)
				         +words[0].tl(attr_pers)
				         +words[0].tl(attr_nbr)
				         +words[2].tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
		}
		/** atenció: lemq de posició 2, tot i que ho és del verb, perquè per les operacions del t1x ha passat a ser cua del pronom i no del verb, aquí cal recolocar-la  */
		else
		{
			if ((words[0].tl(attr_pers).equals("<PD>")
    && words[0].tl(attr_temps).equals("<ger>")))
			{
				if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
				{
					words[2].tlSet(attr_lem, "se");
					words[2].tlSet(attr_a_prn, "<prn><enc><ref>");
					words[2].tlSet(attr_pers, "<p3>");
					words[2].tlSet(attr_nbr, "<sp>");
				}
			}
			out.append('^');
			out.append(words[1].tl(attr_whole));
			out.append('+');
			out.append(words[2].tl(attr_whole));
			out.append('$');
		}
		macro_f_bcond(out, words[1]);
	}
	
	// CHUNK: GER ENC
	public void rule21__ger_enc_enc(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule21__ger_enc_enc",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if ((!words[0].tl(attr_pers).equals("<PD>")
    && !words[0].tl(attr_temps).equals("<ger>")))
		{
			if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				words[2].tlSet(attr_lem, "se");
				words[2].tlSet(attr_a_prn, "<prn><pro><ref>");
				words[2].tlSet(attr_pers, "<p3>");
				words[2].tlSet(attr_nbr, "<sp>");
			}
			/** només tindrà valor si el pronom és reflexiu  */
			out.append('^');
			out.append(words[2].tl(attr_lem));
			out.append("<prn><pro>");
			out.append(words[2].tl(attr_a_ref));
			out.append(words[2].tl(attr_pers));
			out.append(words[2].tl(attr_gen));
			out.append(words[2].tl(attr_nbr));
			out.append('$');
			out.append(blanks[1]);
			out.append('^');
			out.append(words[3].tl(attr_lem));
			out.append("<prn><pro>");
			out.append(words[3].tl(attr_pers));
			out.append(words[3].tl(attr_gen));
			out.append(words[3].tl(attr_nbr));
			out.append("$ ");
			{
				String myword = 
				         words[1].tl(attr_lemh)
				         +words[1].tl(attr_tags)
				         +words[0].tl(attr_pers)
				         +words[0].tl(attr_nbr)
				         +words[2].tl(attr_lemq)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
		}
		/** atenció: lemq de posició 2, tot i que ho és del verb, perquè per les operacions del t1x ha passat a ser cua del pronom i no del verb, aquí cal recolocar-la  */
		else
		{
			if ((words[0].tl(attr_pers).equals("<PD>")
    && words[0].tl(attr_temps).equals("<ger>")))
			{
				if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
				{
					words[2].tlSet(attr_lem, "se");
					words[2].tlSet(attr_a_prn, "<prn><enc><ref>");
					words[2].tlSet(attr_pers, "<p3>");
					words[2].tlSet(attr_nbr, "<sp>");
				}
			}
			out.append('^');
			out.append(words[1].tl(attr_whole));
			out.append('+');
			out.append(words[2].tl(attr_whole));
			out.append('+');
			out.append(words[3].tl(attr_whole));
			out.append('$');
		}
		macro_f_bcond(out, words[1]);
	}
	
	// CHUNK: BE (there is)
	public void rule22__be(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule22__be",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (words[0].tl(attr_a_verb).equals("<HAY>"))
		{
			if (words[1].tl(attr_temps).equals("<pri>"))
			{
				words[1].tlSet(attr_lem, TransferWord.copycase(words[0].sl(attr_lem), "hay"));
				words[1].tlSet(attr_a_verb, "<vblex>");
			}
			else
			{
				words[1].tlSet(attr_lem, TransferWord.copycase(words[0].sl(attr_lem), "haber"));
				words[1].tlSet(attr_a_verb, "<vbhaver>");
			}
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	/**  regles per arreglar els verbs tipus "like->m'agrada"  */
	// assigna persona i nombre als verbs tipus LIKE amb pronom
	public void rule23__pro_vblike(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule23__pro_vblike",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		words[2].tlSet(attr_pers, words[1].tl(attr_pers));
		words[2].tlSet(attr_nbr, words[1].tl(attr_nbr));
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_f_bcond(out, words[1]);
	}
	
	// assigna persona i nombre als verbs tipus LIKE amb pronom
	public void rule24__pro_vblike2(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule24__pro_vblike2",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		words[2].tlSet(attr_pers, words[1].tl(attr_pers));
		words[2].tlSet(attr_nbr, words[1].tl(attr_nbr));
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_f_bcond(out, words[2]);
	}
	
	// assigna persona i nombre als verbs tipus LIKE amb pronom
	public void rule25__pro_vblike3(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule25__pro_vblike3",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		words[2].tlSet(attr_pers, words[1].tl(attr_pers));
		words[2].tlSet(attr_nbr, words[1].tl(attr_nbr));
		{
			String myword = 
			         words[2].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[1]);
		{
			String myword = 
			         words[3].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blanks[2]);
		{
			String myword = 
			         words[4].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_f_bcond(out, words[3]);
	}
	
	/**  regles per arreglar el pronom reflexiu de tercera persona (li-> se) */
	// arregla el pronom proclític, i arregla el verb 'haver-hi'
	public void rule26__have_pp(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule26__have_pp",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			if ((words[0].tl(attr_temps).equals("<ger>")
    && words[0].tl(attr_pers).equals("<PD>")))
			{
				words[1].tlSet(attr_lem, "se");
				words[1].tlSet(attr_a_prn, "<prn><enc><ref>");
				words[1].tlSet(attr_pers, "<p3>");
				words[1].tlSet(attr_nbr, "<sp>");
				out.append('^');
				out.append(words[2].tl(attr_whole));
				out.append('+');
				out.append(words[1].tl(attr_whole));
				out.append('$');
				out.append(blanks[1]);
				{
					String myword = 
					         words[3].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				macro_f_bcond(out, words[2]);
			}
			else
			if (words[0].tl(attr_pers).equals("<p3>"))
			{
				words[1].tlSet(attr_lem, "se");
				words[1].tlSet(attr_a_prn, "<prn><pro><ref>");
				words[1].tlSet(attr_nbr, "<sp>");
				{
					String myword = 
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				{
					String myword = 
					         words[2].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[2]);
				{
					String myword = 
					         words[3].tl(attr_whole)
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
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				{
					String myword = 
					         words[2].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[2]);
				{
					String myword = 
					         words[3].tl(attr_whole)
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
		else
		{
			if (words[0].tl(attr_a_verb).equals("<HAY>"))
			{
				words[2].tlSet(attr_lem, TransferWord.copycase(words[0].sl(attr_lem), "haber"));
				words[2].tlSet(attr_a_verb, "<vbhaver>");
			}
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			{
				String myword = 
				         words[2].tl(attr_whole)
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
	
	// arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)
	public void rule27__be_ger(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule27__be_ger",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			if (words[0].tl(attr_pers).equals("<p3>"))
			{
				words[3].tlSet(attr_lem, "se");
				words[3].tlSet(attr_a_prn, "<prn><enc><ref>");
				words[3].tlSet(attr_nbr, "<sp>");
			}
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			out.append('^');
			out.append(words[2].tl(attr_whole));
			out.append('+');
			out.append(words[3].tl(attr_whole));
			out.append('$');
		}
		else
		{
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			{
				String myword = 
				         words[2].tl(attr_whole)
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
	
	// arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)
	public void rule28__be_ger_enc(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule28__be_ger_enc",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			if (words[0].tl(attr_pers).equals("<p3>"))
			{
				words[3].tlSet(attr_lem, "se");
				words[3].tlSet(attr_a_prn, "<prn><enc><ref>");
				words[3].tlSet(attr_nbr, "<sp>");
			}
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			out.append('^');
			out.append(words[2].tl(attr_whole));
			out.append('+');
			out.append(words[3].tl(attr_whole));
			out.append('+');
			out.append(words[4].tl(attr_whole));
			out.append('$');
		}
		else
		{
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			out.append('^');
			out.append(words[2].tl(attr_whole));
			out.append('+');
			out.append(words[3].tl(attr_whole));
			out.append('$');
		}
	}
	
	// arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)
	public void rule29__be_ger_inf(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule29__be_ger_inf",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (words[3].tl(attr_a_verb).equals("<vblex><pron>"))
		{
			if (words[0].tl(attr_pers).equals("<p3>"))
			{
				words[4].tlSet(attr_lem, "se");
				words[4].tlSet(attr_a_prn, "<prn><enc><ref>");
				words[4].tlSet(attr_nbr, "<sp>");
			}
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			{
				String myword = 
				         words[2].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[2]);
			out.append('^');
			out.append(words[3].tl(attr_whole));
			out.append('+');
			out.append(words[4].tl(attr_whole));
			out.append('$');
		}
		else
		{
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			{
				String myword = 
				         words[2].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[2]);
			{
				String myword = 
				         words[3].tl(attr_whole)
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
	
	// arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)
	public void rule30__auxmod_have_pp_inf(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule30__auxmod_have_pp_inf",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (words[4].tl(attr_a_verb).equals("<vblex><pron>"))
		{
			if (words[0].tl(attr_pers).equals("<p3>"))
			{
				words[5].tlSet(attr_lem, "se");
				words[5].tlSet(attr_a_prn, "<prn><enc><ref>");
				words[5].tlSet(attr_nbr, "<sp>");
			}
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			{
				String myword = 
				         words[2].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[2]);
			{
				String myword = 
				         words[3].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[3]);
			out.append('^');
			out.append(words[4].tl(attr_whole));
			out.append('+');
			out.append(words[5].tl(attr_whole));
			out.append('$');
		}
		else
		{
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			{
				String myword = 
				         words[2].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[2]);
			{
				String myword = 
				         words[3].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[3]);
			{
				String myword = 
				         words[4].tl(attr_whole)
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
	
	// arregla el pron reflexiu de tercera persona, enclític
	public void rule31__verbcj_inf(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule31__verbcj_inf",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (!words[0].tl(attr_temps).equals("<ifip>"))
		{
			if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				if (words[0].tl(attr_pers).equals("<p3>"))
				{
					words[1].tlSet(attr_lem, "se");
					words[1].tlSet(attr_a_prn, "<prn><pro><ref>");
					words[1].tlSet(attr_nbr, "<sp>");
				}
				{
					String myword = 
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				{
					String myword = 
					         words[2].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[2]);
			}
			else
			{
				{
					String myword = 
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
			}
			if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				if (words[3].tl(attr_a_verb).equals("<vblex><pron>"))
				{
					if (words[0].tl(attr_pers).equals("<p3>"))
					{
						words[4].tlSet(attr_lem, "se");
						words[4].tlSet(attr_a_prn, "<prn><enc><ref>");
						words[4].tlSet(attr_nbr, "<sp>");
					}
					out.append('^');
					out.append(words[3].tl(attr_whole));
					out.append('+');
					out.append(words[4].tl(attr_whole));
					out.append('$');
				}
				else
				{
					out.append('^');
					out.append(words[3].tl(attr_whole));
					out.append('$');
				}
			}
			else
			{
				if (words[2].tl(attr_a_verb).equals("<vblex><pron>"))
				{
					if (words[0].tl(attr_pers).equals("<p3>"))
					{
						words[3].tlSet(attr_lem, "se");
						words[3].tlSet(attr_a_prn, "<prn><enc><ref>");
						words[3].tlSet(attr_nbr, "<sp>");
					}
					out.append('^');
					out.append(words[2].tl(attr_whole));
					out.append('+');
					out.append(words[3].tl(attr_whole));
					out.append('$');
				}
				else
				{
					out.append('^');
					out.append(words[2].tl(attr_whole));
					out.append('$');
				}
			}
		}
		else
		{
			if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				if (words[0].tl(attr_pers).equals("<p3>"))
				{
					words[1].tlSet(attr_lem, "se");
					words[1].tlSet(attr_a_prn, "<prn><pro><ref>");
					words[1].tlSet(attr_nbr, "<sp>");
				}
				{
					String myword = 
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				{
					String myword = 
					         words[2].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[2]);
				{
					String myword = 
					         words[3].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[3]);
			}
			else
			{
				{
					String myword = 
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				{
					String myword = 
					         words[2].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[2]);
			}
			if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				if (words[4].tl(attr_a_verb).equals("<vblex><pron>"))
				{
					if (words[0].tl(attr_pers).equals("<p3>"))
					{
						words[5].tlSet(attr_lem, "se");
						words[5].tlSet(attr_a_prn, "<prn><enc><ref>");
						words[5].tlSet(attr_nbr, "<sp>");
					}
					out.append('^');
					out.append(words[4].tl(attr_whole));
					out.append('+');
					out.append(words[5].tl(attr_whole));
					out.append('$');
				}
				else
				{
					out.append('^');
					out.append(words[4].tl(attr_whole));
					out.append('$');
				}
			}
			else
			{
				if (words[3].tl(attr_a_verb).equals("<vblex><pron>"))
				{
					if (words[0].tl(attr_pers).equals("<p3>"))
					{
						words[4].tlSet(attr_lem, "se");
						words[4].tlSet(attr_a_prn, "<prn><enc><ref>");
						words[4].tlSet(attr_nbr, "<sp>");
					}
					out.append('^');
					out.append(words[3].tl(attr_whole));
					out.append('+');
					out.append(words[4].tl(attr_whole));
					out.append('$');
				}
				else
				{
					out.append('^');
					out.append(words[3].tl(attr_whole));
					out.append('$');
				}
			}
		}
	}
	
	// arregla el pron reflexiu de tercera persona, enclític
	public void rule32__verbcj_inf_enc(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule32__verbcj_inf_enc",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (!words[0].tl(attr_temps).equals("<ifip>"))
		{
			if (words[2].tl(attr_a_verb).equals("<vblex><pron>"))
			{
				if (words[0].tl(attr_pers).equals("<p3>"))
				{
					words[3].tlSet(attr_lem, "se");
					words[3].tlSet(attr_a_prn, "<prn><enc><ref>");
					words[3].tlSet(attr_nbr, "<sp>");
				}
				{
					String myword = 
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				out.append('^');
				out.append(words[2].tl(attr_whole));
				out.append('+');
				out.append(words[3].tl(attr_whole));
				out.append('+');
				out.append(words[4].tl(attr_whole));
				out.append('$');
			}
			else
			{
				{
					String myword = 
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				out.append('^');
				out.append(words[2].tl(attr_whole));
				out.append('+');
				out.append(words[3].tl(attr_whole));
				out.append('$');
			}
		}
		else
		{
			if (words[3].tl(attr_a_verb).equals("<vblex><pron>"))
			{
				if (words[0].tl(attr_pers).equals("<p3>"))
				{
					words[4].tlSet(attr_lem, "se");
					words[4].tlSet(attr_a_prn, "<prn><enc><ref>");
					words[4].tlSet(attr_nbr, "<sp>");
				}
				{
					String myword = 
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				{
					String myword = 
					         words[2].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[2]);
				out.append('^');
				out.append(words[3].tl(attr_whole));
				out.append('+');
				out.append(words[4].tl(attr_whole));
				out.append('+');
				out.append(words[5].tl(attr_whole));
				out.append('$');
			}
			else
			{
				{
					String myword = 
					         words[1].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[1]);
				{
					String myword = 
					         words[2].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[2]);
				out.append('^');
				out.append(words[3].tl(attr_whole));
				out.append('+');
				out.append(words[4].tl(attr_whole));
				out.append('$');
			}
		}
	}
	
	// arregla el pron reflexiu de tercera persona, quan és proclític
	public void rule33__pottenirpronom(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule33__pottenirpronom",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (words[0].tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			if (words[0].tl(attr_pers).equals("<p3>"))
			{
				words[1].tlSet(attr_lem, "se");
				words[1].tlSet(attr_a_prnpro, "<prn><pro><ref>");
				words[1].tlSet(attr_nbr, "<sp>");
			}
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			out.append(blanks[1]);
			{
				String myword = 
				         words[2].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			if ((words[0].tl(attr_lem).equalsIgnoreCase("pro_verbcj")
    || words[0].tl(attr_lem).equalsIgnoreCase("auxmod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("mod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("have_pp")
    || words[0].tl(attr_lem).equalsIgnoreCase("be_ger")))
			{
				out.append(blanks[2]);
				{
					String myword = 
					         words[3].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
			}
			if ((words[0].tl(attr_lem).equalsIgnoreCase("auxmod_mod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("auxmod_have_pp")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_be_ger")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_auxmod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_mod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_have_pp")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_do_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("going_to_inf")))
			{
				out.append(blanks[2]);
				{
					String myword = 
					         words[3].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[3]);
				{
					String myword = 
					         words[4].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
			}
			if ((words[0].tl(attr_lem).equalsIgnoreCase("pro_auxmod_mod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_auxmod_have_pp")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_going_to_inf")))
			{
				out.append(blanks[2]);
				{
					String myword = 
					         words[3].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[3]);
				{
					String myword = 
					         words[4].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[4]);
				{
					String myword = 
					         words[5].tl(attr_whole)
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
		else
		{
			/** Mira si hi ha algun verb que sigui HAVER (d'haver-hi), en tal cas cal canviar lemes i etiquetes del verb principal ('ser' passa a 'haver')  */
			if (words[0].tl(attr_a_verb).equals("<HAY>"))
			{
				if (words[0].tl(attr_lem).equalsIgnoreCase("verbcj"))
				{
					if (words[1].tl(attr_temps).equals("<pri>"))
					{
						words[1].tlSet(attr_lem, TransferWord.copycase(words[0].sl(attr_lem), "hay"));
						words[1].tlSet(attr_a_verb, "<vblex>");
					}
					else
					{
						words[1].tlSet(attr_lem, TransferWord.copycase(words[0].sl(attr_lem), "haber"));
						words[1].tlSet(attr_a_verb, "<vbhaver>");
					}
				}
				else
				if ((words[0].tl(attr_lem).equalsIgnoreCase("auxmod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("mod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("have_pp")))
				{
					words[2].tlSet(attr_lem, "haber");
					words[2].tlSet(attr_a_verb, "<vbhaver>");
				}
				else
				if ((words[0].tl(attr_lem).equalsIgnoreCase("auxmod_mod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("auxmod_have_pp")))
				{
					words[3].tlSet(attr_lem, "haber");
					words[3].tlSet(attr_a_verb, "<vbhaver>");
				}
			}
			/** I ara imprimeix el resultat de tot  */
			{
				String myword = 
				         words[1].tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			if ((words[0].tl(attr_lem).equalsIgnoreCase("pro_verbcj")
    || words[0].tl(attr_lem).equalsIgnoreCase("auxmod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("mod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("have_pp")
    || words[0].tl(attr_lem).equalsIgnoreCase("be_ger")))
			{
				out.append(blanks[1]);
				{
					String myword = 
					         words[2].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
			}
			if ((words[0].tl(attr_lem).equalsIgnoreCase("auxmod_mod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("auxmod_have_pp")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_be_ger")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_auxmod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_mod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_have_pp")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_be_ger")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_do_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("going_to_inf")))
			{
				out.append(blanks[1]);
				{
					String myword = 
					         words[2].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[2]);
				{
					String myword = 
					         words[3].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
			}
			if ((words[0].tl(attr_lem).equalsIgnoreCase("pro_auxmod_mod_inf")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_auxmod_have_pp")
    || words[0].tl(attr_lem).equalsIgnoreCase("pro_going_to_inf")))
			{
				out.append(blanks[1]);
				{
					String myword = 
					         words[2].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[2]);
				{
					String myword = 
					         words[3].tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(blanks[3]);
				{
					String myword = 
					         words[4].tl(attr_whole)
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
	}
	
	/** <rule comment="arregla el pron reflexiu de tercera persona quan és enclític. No es pot accedir el lema del pronom enclític i per ara no es pot fer la regla">
      <pattern>
	<pattern-item n="pottenirenclitic"/>
      </pattern>
      <action>
	<choose>
	  <when>
	    <test>
		<equal>
		  <clip pos="3" part="a_prnenc"/>
		  <lit-tag v="prn.enc"/>
		</equal>
	    </test>
	    <out>
	      <lu>
		<lit v="hola"/>
	      </lu>
	    </out>
	  </when>
	</choose>
      </action>
</rule> */
	// CHUNK: reflexiu (arregla el pronom reflexiu creat en t2x)
	public void rule34__reflexiu(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule34__reflexiu",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		if (words[0].tl(attr_pers).equals("<p3>"))
		{
			words[1].tlSet(attr_lem, "se");
			words[1].tlSet(attr_gen, "<mf>");
			words[1].tlSet(attr_nbr, "<sp>");
			words[1].tlSet(attr_a_prnpro, "<prn><pro><ref>");
		}
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// CHUNK: HI
	public void rule35__hi(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule35__hi",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		words[1].tlSet(attr_lem, "hi");
		words[1].tlSet(attr_tags, "<prn><pro><adv>");
		{
			String myword = 
			         words[1].tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// CHUNK: tenir (el chunk 'tenir' és resultat de canviar 'ser' per 'tenir' en el t2x en el patró 'I am 20 years old'
	public void rule36__tener(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule36__tener",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		words[1].tlSet(attr_lem, TransferWord.copycase(words[0].sl(attr_lem), "tener"));
		words[1].tlSet(attr_a_verb, "<vblex>");
		{
			String myword = 
			         words[1].tl(attr_whole)
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
