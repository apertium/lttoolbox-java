package org.apertium.transfer.generated;
import java.io.*;
import org.apertium.transfer.*;
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
	
	private void macro_f_bcond(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("macro_f_bcond",  word1); } 
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-def-macros>/<def-macro n="f_bcond" npar="1">/<choose>/<when>/<test>/<not>/<equal>/<b pos="1">
		if (!"".equals(" "))
		{
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-def-macros>/<def-macro n="f_bcond" npar="1">/<choose>/<when>/<out>/<b pos="1">
			out.append("");
		}
	}
	
	private void macro_gen_nbr_determinante(Writer out, InterchunkWord word1) throws IOException
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
	public void rule0__nom(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule0__nom",  word1); } 
		macro_gen_nbr_determinante(out, word1);
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
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
	
	// CHUNK: SN_2words3
	public void rule1__SN_2words3(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule1__SN_2words3",  word1); } 
		macro_gen_nbr_determinante(out, word1);
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
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
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_2words3">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_2words3">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  si s'ha afegit l'adverbi 'més' davant adj, cal enviar una posició més  */
		// TODO - lu-count is not implemented yet. Returning dummy value '42' - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_2words3">/<action>/<choose>/<when>/<test>/<equal>/<lu-count>
		if ("42".equals("3"))
		{
			// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_2words3">/<action>/<choose>/<when>/<out>/<b pos="2">
			out.append("");
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_2words3">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
	public void rule2__nom_i_nom(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule2__nom_i_nom",  word1); } 
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
			macro_gen_nbr_determinante(out, word1);
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: nom conj nom">/<action>/<choose>/<when>/<out>/<b pos="1">
			out.append("");
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: nom conj nom">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: nom conj nom">/<action>/<choose>/<when>/<out>/<b pos="2">
			out.append("");
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: nom conj nom">/<action>/<choose>/<when>/<call-macro n="gen_nbr_determinante">
			macro_gen_nbr_determinante(out, new InterchunkWord(""));
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: nom conj nom">/<action>/<choose>/<when>/<out>/<lu>/<get-case-from pos="3">/<lit v="el">
			out.append('^');
			out.append(TransferWord.copycase(new InterchunkWord("").sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: nom conj nom">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: nom conj nom">/<action>/<choose>/<otherwise>/<out>/<b pos="1">
			out.append("");
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: nom conj nom">/<action>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="2">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: nom conj nom">/<action>/<choose>/<otherwise>/<out>/<b pos="2">
			out.append("");
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: nom conj nom">/<action>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="3">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
	public void rule3__SN_3words5(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule3__SN_3words5",  word1); } 
		macro_gen_nbr_determinante(out, word1);
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
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
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<out>/<b pos="2">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  si s'ha afegit l'adverbi 'més' davant adj, cal enviar una posició (o dues) més  */
		// TODO - lu-count is not implemented yet. Returning dummy value '42' - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<choose>/<when>/<test>/<equal>/<lu-count>
		if ("42".equals("4"))
		{
			// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<choose>/<when>/<out>/<b pos="3">
			out.append("");
			// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="4">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
		// TODO - lu-count is not implemented yet. Returning dummy value '42' - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<choose>/<when>/<test>/<equal>/<lu-count>
		if ("42".equals("5"))
		{
			// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<choose>/<when>/<out>/<b pos="3">
			out.append("");
			// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="4">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			// WARNING blank pos=4 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<choose>/<when>/<out>/<b pos="4">
			out.append("");
			// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words5">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="5">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
	public void rule4__SN_3words(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule4__SN_3words",  word1); } 
		macro_gen_nbr_determinante(out, word1);
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
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
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words">/<action>/<out>/<b pos="2">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_3words">/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
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
	public void rule5__SN_4words6(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule5__SN_4words6",  word1); } 
		macro_gen_nbr_determinante(out, word1);
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
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
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<out>/<b pos="2">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<out>/<b pos="3">
		out.append("");
		// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<out>/<lu>/<clip part="whole" pos="4">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  si s'ha afegit l'adverbi 'més' davant adj, cal enviar una posició (o dues) més  */
		// TODO - lu-count is not implemented yet. Returning dummy value '42' - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<choose>/<when>/<test>/<equal>/<lu-count>
		if ("42".equals("5"))
		{
			// WARNING blank pos=4 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<choose>/<when>/<out>/<b pos="4">
			out.append("");
			// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="5">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
		// TODO - lu-count is not implemented yet. Returning dummy value '42' - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<choose>/<when>/<test>/<equal>/<lu-count>
		if ("42".equals("6"))
		{
			// WARNING blank pos=4 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<choose>/<when>/<out>/<b pos="4">
			out.append("");
			// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="5">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			// WARNING blank pos=5 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<choose>/<when>/<out>/<b pos="5">
			out.append("");
			// WARNING clip pos=6 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words6">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="6">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
	public void rule6__SN_5words(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule6__SN_5words",  word1); } 
		macro_gen_nbr_determinante(out, word1);
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
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
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<b pos="2">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<b pos="3">
		out.append("");
		// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="4">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=4 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<b pos="4">
		out.append("");
		// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="5">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
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
	public void rule7__SN_6words(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule7__SN_6words",  word1); } 
		macro_gen_nbr_determinante(out, word1);
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
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
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 paraules: es posa det si son PDET">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 paraules: es posa det si son PDET">/<action>/<out>/<b pos="2">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 paraules: es posa det si son PDET">/<action>/<out>/<b pos="3">
		out.append("");
		// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="4">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=4 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 paraules: es posa det si son PDET">/<action>/<out>/<b pos="4">
		out.append("");
		// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="5">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=5 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 paraules: es posa det si son PDET">/<action>/<out>/<b pos="5">
		out.append("");
		// WARNING clip pos=6 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="6">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
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
	public void rule8__SN_5words7(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule8__SN_5words7",  word1); } 
		macro_gen_nbr_determinante(out, word1);
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
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
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<b pos="2">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<b pos="3">
		out.append("");
		// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="4">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=4 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<b pos="4">
		out.append("");
		// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="5">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  si s'ha afegit l'adverbi 'més' davant adj, cal enviar una posició (o dues) més  */
		// TODO - lu-count is not implemented yet. Returning dummy value '42' - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<choose>/<when>/<test>/<equal>/<lu-count>
		if ("42".equals("6"))
		{
			// WARNING blank pos=5 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<choose>/<when>/<out>/<b pos="5">
			out.append("");
			// WARNING clip pos=6 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="6">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
		// TODO - lu-count is not implemented yet. Returning dummy value '42' - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<choose>/<when>/<test>/<equal>/<lu-count>
		if ("42".equals("7"))
		{
			// WARNING blank pos=5 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<choose>/<when>/<out>/<b pos="5">
			out.append("");
			// WARNING clip pos=6 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="6">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			// WARNING blank pos=6 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<choose>/<when>/<out>/<b pos="6">
			out.append("");
			// WARNING clip pos=7 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 5 paraules: es posa det si son PDET">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="7">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
	public void rule9__SN_6words7(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule9__SN_6words7",  word1); } 
		macro_gen_nbr_determinante(out, word1);
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
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
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<out>/<b pos="2">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<out>/<b pos="3">
		out.append("");
		// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<out>/<lu>/<clip part="whole" pos="4">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=4 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<out>/<b pos="4">
		out.append("");
		// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<out>/<lu>/<clip part="whole" pos="5">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=5 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<out>/<b pos="5">
		out.append("");
		// WARNING clip pos=6 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<out>/<lu>/<clip part="whole" pos="6">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		/**  si s'ha afegit l'adverbi 'més' davant adj, cal enviar una posició (o dues) més  */
		// TODO - lu-count is not implemented yet. Returning dummy value '42' - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<choose>/<when>/<test>/<equal>/<lu-count>
		if ("42".equals("7"))
		{
			// WARNING blank pos=6 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<choose>/<when>/<out>/<b pos="6">
			out.append("");
			// WARNING clip pos=7 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 6 o 7 paraules: es posa det si son PDET, i s'envia la 7a paraula si hi ha un 'més' preadv">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="7">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
	public void rule10__SN_7words(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule10__SN_7words",  word1); } 
		macro_gen_nbr_determinante(out, word1);
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
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
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<b pos="2">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<b pos="3">
		out.append("");
		// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="4">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=4 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<b pos="4">
		out.append("");
		// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="5">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=5 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<b pos="5">
		out.append("");
		// WARNING clip pos=6 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="6">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=6 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<b pos="6">
		out.append("");
		// WARNING clip pos=7 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN de 7 paraules: es posa det si son PDET">/<action>/<out>/<lu>/<clip part="whole" pos="7">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
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
	public void rule11__SN_4words(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule11__SN_4words",  word1); } 
		macro_gen_nbr_determinante(out, word1);
		if ((word1.tl(attr_a_SN).equals("<PDET>")
    && !word1.tl(attr_a_nom).equals("<np>")
    && !word1.tl(attr_a_nom).equals("<n><acr>")))
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "el"));
			out.append("<det><def>");
			out.append(var_genero);
			out.append(var_numero);
			out.append("$ ");
			word1.tlSet(attr_lem, TransferWord.copycase("aa", word1.tl(attr_lem)));
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
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words">/<action>/<out>/<b pos="2">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words">/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words">/<action>/<out>/<b pos="3">
		out.append("");
		// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: SN_4words">/<action>/<out>/<lu>/<clip part="whole" pos="4">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
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
	public void rule12__inf(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule12__inf",  word1); } 
		if ((!word1.tl(attr_pers).equals("<PD>")
    && !word1.tl(attr_temps).equals("<inf>")))
		{
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_tags)
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
		}
	}
	
	// CHUNK: INF + 2a paraula
	public void rule13__inf_2(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule13__inf_2",  word1); } 
		if ((!word1.tl(attr_pers).equals("<PD>")
    && !word1.tl(attr_temps).equals("<inf>")))
		{
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_tags)
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
		}
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + 2a paraula">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + 2a paraula">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
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
	public void rule14__inf_enc(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule14__inf_enc",  word1); } 
		if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			/** Si no ha rebut persona i nombre, el pronom es torna reflexiu. Si ha rebut persona i nbr, s'enllaçarà automàticament pers i nbr del verb amb pers i nbr del pronom (pronom afegit en el t1x en veure que era un verb pronominal)  */
			if (word1.tl(attr_pers).equals("<PD>"))
			{
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				new InterchunkWord("").tlSet(attr_lem, "se");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				new InterchunkWord("").tlSet(attr_pers, "<p3>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				new InterchunkWord("").tlSet(attr_nbr, "<sp>");
				/** creem una mlu amb el verb i l'enclític  */
				out.append('^');
				out.append(word1.tl(attr_whole));
				out.append('+');
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
			}
			else
			{
				if (word1.tl(attr_pers).equals("<p3>"))
				{
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="lem" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="lem" pos="2">
					new InterchunkWord("").tlSet(attr_lem, "se");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
					new InterchunkWord("").tlSet(attr_a_prn, "<prn><pro><ref>");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="pers" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="pers" pos="2">
					new InterchunkWord("").tlSet(attr_pers, "<p3>");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
					new InterchunkWord("").tlSet(attr_nbr, "<sp>");
				}
				else
				{
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<otherwise>/<let>/<clip part="a_prn" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<otherwise>/<let>/<clip part="a_prn" pos="2">
					new InterchunkWord("").tlSet(attr_a_prn, "<prn><pro>");
				}
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
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
					         word1.tl(attr_lemh)
					         +word1.tl(attr_tags)
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
			}
		}
		else
		{
			if ((!word1.tl(attr_pers).equals("<PD>")
    && !word1.tl(attr_temps).equals("<inf>")))
			{
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="tipusprn" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="tipusprn" pos="2">
				new InterchunkWord("").tlSet(attr_tipusprn, "<pro>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
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
					         word1.tl(attr_lemh)
					         +word1.tl(attr_tags)
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
			}
			else
			{
				/** creem una mlu amb el verb i l'enclític  */
				out.append('^');
				out.append(word1.tl(attr_whole));
				out.append('+');
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF + enc">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
			}
		}
	}
	
	public void rule15__inf_enc_enc(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule15__inf_enc_enc",  word1); } 
		if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			/** Si no ha rebut persona i nombre, el pronom es torna reflexiu. Si ha rebut persona i nbr, s'enllaçarà automàticament pers i nbr del verb amb pers i nbr del pronom (pronom afegit en el t1x en veure que era un verb pronominal)  */
			if (word1.tl(attr_pers).equals("<PD>"))
			{
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				new InterchunkWord("").tlSet(attr_lem, "se");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				new InterchunkWord("").tlSet(attr_pers, "<p3>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				new InterchunkWord("").tlSet(attr_nbr, "<sp>");
				/** creem una mlu amb el verb i l'enclític  */
				out.append('^');
				out.append(word1.tl(attr_whole));
				out.append('+');
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
			}
			else
			{
				if (word1.tl(attr_pers).equals("<p3>"))
				{
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="lem" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="lem" pos="2">
					new InterchunkWord("").tlSet(attr_lem, "se");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
					new InterchunkWord("").tlSet(attr_a_prn, "<prn><pro><ref>");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="pers" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="pers" pos="2">
					new InterchunkWord("").tlSet(attr_pers, "<p3>");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
					new InterchunkWord("").tlSet(attr_nbr, "<sp>");
				}
				else
				{
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<otherwise>/<let>/<clip part="a_prn" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<otherwise>/<let>/<clip part="a_prn" pos="2">
					new InterchunkWord("").tlSet(attr_a_prn, "<prn><pro>");
				}
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<let>/<clip part="tipusprn" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<let>/<clip part="tipusprn" pos="3">
				new InterchunkWord("").tlSet(attr_tipusprn, "<pro>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(" ");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="3">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
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
					         word1.tl(attr_lemh)
					         +word1.tl(attr_tags)
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
			}
		}
		else
		{
			if ((!word1.tl(attr_pers).equals("<PD>")
    && !word1.tl(attr_temps).equals("<inf>")))
			{
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="tipusprn" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="tipusprn" pos="2">
				new InterchunkWord("").tlSet(attr_tipusprn, "<pro>");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="tipusprn" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="tipusprn" pos="3">
				new InterchunkWord("").tlSet(attr_tipusprn, "<pro>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				out.append(" ");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
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
					         word1.tl(attr_lemh)
					         +word1.tl(attr_tags)
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
			}
			else
			{
				/** creem una mlu amb el verb i els enclítics  */
				out.append('^');
				out.append(word1.tl(attr_whole));
				out.append('+');
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
			}
		}
	}
	
	// CHUNK: INF +INF + enc
	public void rule16__inf_inf_enc(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule16__inf_inf_enc",  word1); } 
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<test>/<equal>/<clip part="a_verb" pos="2">
		if (new InterchunkWord("").tl(attr_a_verb).equals("<vblex><pron>"))
		{
			/** Si no ha rebut persona i nombre, el pronom es torna reflexiu. Si ha rebut persona i nbr, s'enllaçarà automàticament pers i nbr del verb amb pers i nbr del pronom (pronom afegit en el t1x en veure que era un verb pronominal)  */
			if (word1.tl(attr_pers).equals("<PD>"))
			{
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
				new InterchunkWord("").tlSet(attr_lem, "se");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
				new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="3">
				new InterchunkWord("").tlSet(attr_pers, "<p3>");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
				new InterchunkWord("").tlSet(attr_nbr, "<sp>");
				/** creem una mlu amb el verb i l'enclític  */
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="1">
				out.append("");
				out.append('^');
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
			}
			else
			{
				if (word1.tl(attr_pers).equals("<p3>"))
				{
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="lem" pos="3">
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="lem" pos="3">
					new InterchunkWord("").tlSet(attr_lem, "se");
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
					new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="pers" pos="3">
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="pers" pos="3">
					new InterchunkWord("").tlSet(attr_pers, "<p3>");
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
					new InterchunkWord("").tlSet(attr_nbr, "<sp>");
				}
				{
					String myword = 
					         word1.tl(attr_lemh)
					         +word1.tl(attr_tags)
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<b pos="1">
				out.append("");
				out.append('^');
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
			}
		}
		else
		{
			if ((!word1.tl(attr_pers).equals("<PD>")
    && !word1.tl(attr_temps).equals("<inf>")))
			{
				{
					String myword = 
					         word1.tl(attr_lemh)
					         +word1.tl(attr_tags)
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="1">
				out.append("");
				out.append('^');
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
			}
			else
			{
				/** creem una mlu amb el verb i l'enclític  */
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<b pos="1">
				out.append("");
				out.append('^');
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: INF +INF + enc">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
			}
		}
	}
	
	public void rule17__have_enc_pp(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule17__have_enc_pp",  word1); } 
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
		if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			/** Si no ha rebut persona i nombre, el pronom es torna reflexiu. Si ha rebut persona i nbr, s'enllaçarà automàticament pers i nbr cap a dins del pronom  */
			if (word1.tl(attr_pers).equals("<PD>"))
			{
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				new InterchunkWord("").tlSet(attr_lem, "se");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				new InterchunkWord("").tlSet(attr_pers, "<p3>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				new InterchunkWord("").tlSet(attr_nbr, "<sp>");
			}
		}
		/** creem una mlu amb el verb i l'enclític  */
		out.append('^');
		out.append(word1.tl(attr_whole));
		out.append('+');
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
		out.append(new InterchunkWord("").tl(attr_whole));
		out.append('$');
		// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule>/<action>/<out>/<b pos="2">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	public void rule18__have_enc_enc_pp(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule18__have_enc_enc_pp",  word1); } 
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
		if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			/** Si no ha rebut persona i nombre, el pronom es torna reflexiu. Si ha rebut persona i nbr, s'enllaçarà automàticament pers i nbr cap a dins del pronom  */
			if (word1.tl(attr_pers).equals("<PD>"))
			{
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				new InterchunkWord("").tlSet(attr_lem, "se");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				new InterchunkWord("").tlSet(attr_pers, "<p3>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				new InterchunkWord("").tlSet(attr_nbr, "<sp>");
			}
		}
		/** creem una mlu amb el verb i els enclítics  */
		out.append('^');
		out.append(word1.tl(attr_whole));
		out.append('+');
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
		out.append(new InterchunkWord("").tl(attr_whole));
		out.append('+');
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
		out.append(new InterchunkWord("").tl(attr_whole));
		out.append('$');
		// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule>/<action>/<out>/<b pos="3">
		out.append("");
		// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule>/<action>/<out>/<lu>/<clip part="whole" pos="4">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
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
	public void rule19__ger(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule19__ger",  word1); } 
		if ((!word1.tl(attr_pers).equals("<PD>")
    && !word1.tl(attr_temps).equals("<ger>")))
		{
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_tags)
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
		}
	}
	
	// CHUNK: GER ENC
	public void rule20__ger_enc(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule20__ger_enc",  word1); } 
		if ((!word1.tl(attr_pers).equals("<PD>")
    && !word1.tl(attr_temps).equals("<ger>")))
		{
			if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				new InterchunkWord("").tlSet(attr_lem, "se");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				new InterchunkWord("").tlSet(attr_a_prn, "<prn><pro><ref>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				new InterchunkWord("").tlSet(attr_pers, "<p3>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				new InterchunkWord("").tlSet(attr_nbr, "<sp>");
			}
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="lem" pos="2">
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="a_ref" pos="2">
			/** només tindrà valor si el pronom és reflexiu  */
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="pers" pos="2">
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="gen" pos="2">
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="nbr" pos="2">
			out.append('^');
			out.append(new InterchunkWord("").tl(attr_lem));
			out.append("<prn><pro>");
			out.append(new InterchunkWord("").tl(attr_a_ref));
			out.append(new InterchunkWord("").tl(attr_pers));
			out.append(new InterchunkWord("").tl(attr_gen));
			out.append(new InterchunkWord("").tl(attr_nbr));
			out.append('$');
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<b pos="1">
			out.append("");
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="lemq" pos="2">
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_tags)
				         +word1.tl(attr_pers)
				         +word1.tl(attr_nbr)
				         +new InterchunkWord("").tl(attr_lemq)
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
			if ((word1.tl(attr_pers).equals("<PD>")
    && word1.tl(attr_temps).equals("<ger>")))
			{
				if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
				{
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
					new InterchunkWord("").tlSet(attr_lem, "se");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
					new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
					new InterchunkWord("").tlSet(attr_pers, "<p3>");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
					new InterchunkWord("").tlSet(attr_nbr, "<sp>");
				}
			}
			out.append('^');
			out.append(word1.tl(attr_whole));
			out.append('+');
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('$');
		}
		macro_f_bcond(out, word1);
	}
	
	// CHUNK: GER ENC
	public void rule21__ger_enc_enc(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule21__ger_enc_enc",  word1); } 
		if ((!word1.tl(attr_pers).equals("<PD>")
    && !word1.tl(attr_temps).equals("<ger>")))
		{
			if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				new InterchunkWord("").tlSet(attr_lem, "se");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
				new InterchunkWord("").tlSet(attr_a_prn, "<prn><pro><ref>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
				new InterchunkWord("").tlSet(attr_pers, "<p3>");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
				new InterchunkWord("").tlSet(attr_nbr, "<sp>");
			}
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="lem" pos="2">
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="a_ref" pos="2">
			/** només tindrà valor si el pronom és reflexiu  */
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="pers" pos="2">
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="gen" pos="2">
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="nbr" pos="2">
			out.append('^');
			out.append(new InterchunkWord("").tl(attr_lem));
			out.append("<prn><pro>");
			out.append(new InterchunkWord("").tl(attr_a_ref));
			out.append(new InterchunkWord("").tl(attr_pers));
			out.append(new InterchunkWord("").tl(attr_gen));
			out.append(new InterchunkWord("").tl(attr_nbr));
			out.append('$');
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<b pos="1">
			out.append("");
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="lem" pos="3">
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="pers" pos="3">
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="gen" pos="3">
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="nbr" pos="3">
			out.append('^');
			out.append(new InterchunkWord("").tl(attr_lem));
			out.append("<prn><pro>");
			out.append(new InterchunkWord("").tl(attr_pers));
			out.append(new InterchunkWord("").tl(attr_gen));
			out.append(new InterchunkWord("").tl(attr_nbr));
			out.append("$ ");
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<when>/<out>/<lu>/<clip part="lemq" pos="2">
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_tags)
				         +word1.tl(attr_pers)
				         +word1.tl(attr_nbr)
				         +new InterchunkWord("").tl(attr_lemq)
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
			if ((word1.tl(attr_pers).equals("<PD>")
    && word1.tl(attr_temps).equals("<ger>")))
			{
				if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
				{
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
					new InterchunkWord("").tlSet(attr_lem, "se");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="2">
					new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="pers" pos="2">
					new InterchunkWord("").tlSet(attr_pers, "<p3>");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="2">
					new InterchunkWord("").tlSet(attr_nbr, "<sp>");
				}
			}
			out.append('^');
			out.append(word1.tl(attr_whole));
			out.append('+');
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('+');
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="CHUNK: GER ENC">/<action>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('$');
		}
		macro_f_bcond(out, word1);
	}
	
	// CHUNK: BE (there is)
	public void rule22__be(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule22__be",  word1); } 
		if (word1.tl(attr_a_verb).equals("<HAY>"))
		{
			if (word1.tl(attr_temps).equals("<pri>"))
			{
				word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "hay"));
				word1.tlSet(attr_a_verb, "<vblex>");
			}
			else
			{
				word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "haber"));
				word1.tlSet(attr_a_verb, "<vbhaver>");
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
	}
	
	/**  regles per arreglar els verbs tipus "like->m'agrada"  */
	// assigna persona i nombre als verbs tipus LIKE amb pronom
	public void rule23__pro_vblike(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule23__pro_vblike",  word1); } 
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="pers" pos="2">
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="pers" pos="2">
		new InterchunkWord("").tlSet(attr_pers, word1.tl(attr_pers));
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="nbr" pos="2">
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="nbr" pos="2">
		new InterchunkWord("").tlSet(attr_nbr, word1.tl(attr_nbr));
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_f_bcond(out, word1);
	}
	
	// assigna persona i nombre als verbs tipus LIKE amb pronom
	public void rule24__pro_vblike2(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule24__pro_vblike2",  word1); } 
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="pers" pos="2">
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="pers" pos="2">
		new InterchunkWord("").tlSet(attr_pers, word1.tl(attr_pers));
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="nbr" pos="2">
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="nbr" pos="2">
		new InterchunkWord("").tlSet(attr_nbr, word1.tl(attr_nbr));
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<call-macro n="f_bcond">
		macro_f_bcond(out, new InterchunkWord(""));
	}
	
	// assigna persona i nombre als verbs tipus LIKE amb pronom
	public void rule25__pro_vblike3(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule25__pro_vblike3",  word1); } 
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="pers" pos="2">
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="pers" pos="2">
		new InterchunkWord("").tlSet(attr_pers, word1.tl(attr_pers));
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="nbr" pos="2">
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<let>/<clip part="nbr" pos="2">
		new InterchunkWord("").tlSet(attr_nbr, word1.tl(attr_nbr));
		// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<out>/<lu>/<clip part="whole" pos="2">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<out>/<b pos="1">
		out.append("");
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<out>/<lu>/<clip part="whole" pos="3">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<out>/<b pos="2">
		out.append("");
		// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<out>/<lu>/<clip part="whole" pos="4">
		{
			String myword = 
			         new InterchunkWord("").tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="assigna persona i nombre als verbs tipus LIKE amb pronom">/<action>/<call-macro n="f_bcond">
		macro_f_bcond(out, new InterchunkWord(""));
	}
	
	/**  regles per arreglar el pronom reflexiu de tercera persona (li-> se) */
	// arregla el pronom proclític, i arregla el verb 'haver-hi'
	public void rule26__have_pp(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule26__have_pp",  word1); } 
		if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			if ((word1.tl(attr_temps).equals("<ger>")
    && word1.tl(attr_pers).equals("<PD>")))
			{
				word1.tlSet(attr_lem, "se");
				word1.tlSet(attr_a_prn, "<prn><enc><ref>");
				word1.tlSet(attr_pers, "<p3>");
				word1.tlSet(attr_nbr, "<sp>");
				out.append('^');
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				out.append(word1.tl(attr_whole));
				out.append('$');
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="1">
				out.append("");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<when>/<call-macro n="f_bcond">
				macro_f_bcond(out, new InterchunkWord(""));
			}
			else
			if (word1.tl(attr_pers).equals("<p3>"))
			{
				word1.tlSet(attr_lem, "se");
				word1.tlSet(attr_a_prn, "<prn><pro><ref>");
				word1.tlSet(attr_nbr, "<sp>");
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="1">
				out.append("");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="2">
				out.append("");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<b pos="1">
				out.append("");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<b pos="2">
				out.append("");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="3">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
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
			if (word1.tl(attr_a_verb).equals("<HAY>"))
			{
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="lem" pos="2">
				new InterchunkWord("").tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "haber"));
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="a_verb" pos="2">
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<otherwise>/<choose>/<when>/<let>/<clip part="a_verb" pos="2">
				new InterchunkWord("").tlSet(attr_a_verb, "<vbhaver>");
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<otherwise>/<out>/<b pos="1">
			out.append("");
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pronom proclític, i arregla el verb 'haver-hi'">/<action>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="2">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
	public void rule27__be_ger(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule27__be_ger",  word1); } 
		if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			if (word1.tl(attr_pers).equals("<p3>"))
			{
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
				new InterchunkWord("").tlSet(attr_lem, "se");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
				new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
				new InterchunkWord("").tlSet(attr_nbr, "<sp>");
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<b pos="1">
			out.append("");
			out.append('^');
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('+');
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('$');
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<b pos="1">
			out.append("");
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="2">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
	public void rule28__be_ger_enc(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule28__be_ger_enc",  word1); } 
		if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			if (word1.tl(attr_pers).equals("<p3>"))
			{
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
				new InterchunkWord("").tlSet(attr_lem, "se");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
				new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
				new InterchunkWord("").tlSet(attr_nbr, "<sp>");
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<b pos="1">
			out.append("");
			out.append('^');
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('+');
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('+');
			// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('$');
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<b pos="1">
			out.append("");
			out.append('^');
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('+');
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('$');
		}
	}
	
	// arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)
	public void rule29__be_ger_inf(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule29__be_ger_inf",  word1); } 
		// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<test>/<equal>/<clip part="a_verb" pos="3">
		if (new InterchunkWord("").tl(attr_a_verb).equals("<vblex><pron>"))
		{
			if (word1.tl(attr_pers).equals("<p3>"))
			{
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="4">
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="4">
				new InterchunkWord("").tlSet(attr_lem, "se");
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="4">
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="4">
				new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="4">
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="4">
				new InterchunkWord("").tlSet(attr_nbr, "<sp>");
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<b pos="1">
			out.append("");
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<b pos="2">
			out.append("");
			out.append('^');
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('+');
			// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('$');
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<b pos="1">
			out.append("");
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="2">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<b pos="2">
			out.append("");
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="3">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
	public void rule30__auxmod_have_pp_inf(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule30__auxmod_have_pp_inf",  word1); } 
		// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<test>/<equal>/<clip part="a_verb" pos="4">
		if (new InterchunkWord("").tl(attr_a_verb).equals("<vblex><pron>"))
		{
			if (word1.tl(attr_pers).equals("<p3>"))
			{
				// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="5">
				// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="5">
				new InterchunkWord("").tlSet(attr_lem, "se");
				// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="5">
				// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="5">
				new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
				// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="5">
				// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="5">
				new InterchunkWord("").tlSet(attr_nbr, "<sp>");
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<b pos="1">
			out.append("");
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<b pos="2">
			out.append("");
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<b pos="3">
			out.append("");
			out.append('^');
			// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('+');
			// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="5">
			out.append(new InterchunkWord("").tl(attr_whole));
			out.append('$');
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<b pos="1">
			out.append("");
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="2">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<b pos="2">
			out.append("");
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="3">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<b pos="3">
			out.append("");
			// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític: si és p3 fes que sigui 'es' (reflexiu)">/<action>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="4">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
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
	public void rule31__verbcj_inf(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule31__verbcj_inf",  word1); } 
		if (!word1.tl(attr_temps).equals("<ifip>"))
		{
			if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				if (word1.tl(attr_pers).equals("<p3>"))
				{
					word1.tlSet(attr_lem, "se");
					word1.tlSet(attr_a_prn, "<prn><pro><ref>");
					word1.tlSet(attr_nbr, "<sp>");
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="1">
				out.append("");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="2">
				out.append("");
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<b pos="1">
				out.append("");
			}
			if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<test>/<equal>/<clip part="a_verb" pos="3">
				if (new InterchunkWord("").tl(attr_a_verb).equals("<vblex><pron>"))
				{
					if (word1.tl(attr_pers).equals("<p3>"))
					{
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="4">
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="4">
						new InterchunkWord("").tlSet(attr_lem, "se");
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="4">
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="4">
						new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="4">
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="4">
						new InterchunkWord("").tlSet(attr_nbr, "<sp>");
					}
					out.append('^');
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('+');
					// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('$');
				}
				else
				{
					out.append('^');
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('$');
				}
			}
			else
			{
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<test>/<equal>/<clip part="a_verb" pos="2">
				if (new InterchunkWord("").tl(attr_a_verb).equals("<vblex><pron>"))
				{
					if (word1.tl(attr_pers).equals("<p3>"))
					{
						// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
						// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
						new InterchunkWord("").tlSet(attr_lem, "se");
						// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
						// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
						new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
						// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
						// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
						new InterchunkWord("").tlSet(attr_nbr, "<sp>");
					}
					out.append('^');
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('+');
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('$');
				}
				else
				{
					out.append('^');
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('$');
				}
			}
		}
		else
		{
			if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				if (word1.tl(attr_pers).equals("<p3>"))
				{
					word1.tlSet(attr_lem, "se");
					word1.tlSet(attr_a_prn, "<prn><pro><ref>");
					word1.tlSet(attr_nbr, "<sp>");
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="1">
				out.append("");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="2">
				out.append("");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="3">
				out.append("");
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<b pos="1">
				out.append("");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<b pos="2">
				out.append("");
			}
			if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
			{
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<test>/<equal>/<clip part="a_verb" pos="4">
				if (new InterchunkWord("").tl(attr_a_verb).equals("<vblex><pron>"))
				{
					if (word1.tl(attr_pers).equals("<p3>"))
					{
						// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="5">
						// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="5">
						new InterchunkWord("").tlSet(attr_lem, "se");
						// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="5">
						// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="5">
						new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
						// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="5">
						// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="5">
						new InterchunkWord("").tlSet(attr_nbr, "<sp>");
					}
					out.append('^');
					// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('+');
					// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="5">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('$');
				}
				else
				{
					out.append('^');
					// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('$');
				}
			}
			else
			{
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<choose>/<when>/<test>/<equal>/<clip part="a_verb" pos="3">
				if (new InterchunkWord("").tl(attr_a_verb).equals("<vblex><pron>"))
				{
					if (word1.tl(attr_pers).equals("<p3>"))
					{
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="4">
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="4">
						new InterchunkWord("").tlSet(attr_lem, "se");
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="4">
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="4">
						new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="4">
						// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="4">
						new InterchunkWord("").tlSet(attr_nbr, "<sp>");
					}
					out.append('^');
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('+');
					// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('$');
				}
				else
				{
					out.append('^');
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
					out.append(new InterchunkWord("").tl(attr_whole));
					out.append('$');
				}
			}
		}
	}
	
	// arregla el pron reflexiu de tercera persona, enclític
	public void rule32__verbcj_inf_enc(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule32__verbcj_inf_enc",  word1); } 
		if (!word1.tl(attr_temps).equals("<ifip>"))
		{
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<test>/<equal>/<clip part="a_verb" pos="2">
			if (new InterchunkWord("").tl(attr_a_verb).equals("<vblex><pron>"))
			{
				if (word1.tl(attr_pers).equals("<p3>"))
				{
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
					new InterchunkWord("").tlSet(attr_lem, "se");
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="3">
					new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="3">
					new InterchunkWord("").tlSet(attr_nbr, "<sp>");
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="1">
				out.append("");
				out.append('^');
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<b pos="1">
				out.append("");
				out.append('^');
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="2">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<when>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
			}
		}
		else
		{
			// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<test>/<equal>/<clip part="a_verb" pos="3">
			if (new InterchunkWord("").tl(attr_a_verb).equals("<vblex><pron>"))
			{
				if (word1.tl(attr_pers).equals("<p3>"))
				{
					// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="4">
					// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="4">
					new InterchunkWord("").tlSet(attr_lem, "se");
					// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="4">
					// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_prn" pos="4">
					new InterchunkWord("").tlSet(attr_a_prn, "<prn><enc><ref>");
					// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="4">
					// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="nbr" pos="4">
					new InterchunkWord("").tlSet(attr_nbr, "<sp>");
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="1">
				out.append("");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="2">
				out.append("");
				out.append('^');
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<mlu>/<lu>/<clip part="whole" pos="5">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
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
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<b pos="1">
				out.append("");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<b pos="2">
				out.append("");
				out.append('^');
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="3">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('+');
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, enclític">/<action>/<choose>/<otherwise>/<choose>/<otherwise>/<out>/<mlu>/<lu>/<clip part="whole" pos="4">
				out.append(new InterchunkWord("").tl(attr_whole));
				out.append('$');
			}
		}
	}
	
	// arregla el pron reflexiu de tercera persona, quan és proclític
	public void rule33__pottenirpronom(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule33__pottenirpronom",  word1); } 
		if (word1.tl(attr_tipus_verb).equals("<SV><pron>"))
		{
			if (word1.tl(attr_pers).equals("<p3>"))
			{
				word1.tlSet(attr_lem, "se");
				word1.tlSet(attr_a_prnpro, "<prn><pro><ref>");
				word1.tlSet(attr_nbr, "<sp>");
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
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<out>/<b pos="1">
			out.append("");
			// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
			{
				String myword = 
				         new InterchunkWord("").tl(attr_whole)
				         ;
				if (myword.length()>0)
				{
					out.append('^');
					out.append(myword);
					out.append('$');
				}
			}
			if ((word1.tl(attr_lem).equalsIgnoreCase("pro_verbcj")
    || word1.tl(attr_lem).equalsIgnoreCase("auxmod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("mod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("have_pp")
    || word1.tl(attr_lem).equalsIgnoreCase("be_ger")))
			{
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="2">
				out.append("");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
			}
			if ((word1.tl(attr_lem).equalsIgnoreCase("auxmod_mod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("auxmod_have_pp")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_be_ger")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_auxmod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_mod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_have_pp")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_do_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("going_to_inf")))
			{
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="2">
				out.append("");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="3">
				out.append("");
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="4">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
			}
			if ((word1.tl(attr_lem).equalsIgnoreCase("pro_auxmod_mod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_auxmod_have_pp")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_going_to_inf")))
			{
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="2">
				out.append("");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="3">
				out.append("");
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="4">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=4 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<b pos="4">
				out.append("");
				// WARNING clip pos=5 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<when>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="5">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
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
			if (word1.tl(attr_a_verb).equals("<HAY>"))
			{
				if (word1.tl(attr_lem).equalsIgnoreCase("verbcj"))
				{
					if (word1.tl(attr_temps).equals("<pri>"))
					{
						word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "hay"));
						word1.tlSet(attr_a_verb, "<vblex>");
					}
					else
					{
						word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "haber"));
						word1.tlSet(attr_a_verb, "<vbhaver>");
					}
				}
				else
				if ((word1.tl(attr_lem).equalsIgnoreCase("auxmod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("mod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("have_pp")))
				{
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="2">
					new InterchunkWord("").tlSet(attr_lem, "haber");
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_verb" pos="2">
					// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_verb" pos="2">
					new InterchunkWord("").tlSet(attr_a_verb, "<vbhaver>");
				}
				else
				if ((word1.tl(attr_lem).equalsIgnoreCase("auxmod_mod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("auxmod_have_pp")))
				{
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="lem" pos="3">
					new InterchunkWord("").tlSet(attr_lem, "haber");
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_verb" pos="3">
					// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<choose>/<when>/<let>/<clip part="a_verb" pos="3">
					new InterchunkWord("").tlSet(attr_a_verb, "<vbhaver>");
				}
			}
			/** I ara imprimeix el resultat de tot  */
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
			if ((word1.tl(attr_lem).equalsIgnoreCase("pro_verbcj")
    || word1.tl(attr_lem).equalsIgnoreCase("auxmod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("mod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("have_pp")
    || word1.tl(attr_lem).equalsIgnoreCase("be_ger")))
			{
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="1">
				out.append("");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
			}
			if ((word1.tl(attr_lem).equalsIgnoreCase("auxmod_mod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("auxmod_have_pp")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_be_ger")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_auxmod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_mod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_have_pp")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_be_ger")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_do_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("going_to_inf")))
			{
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="1">
				out.append("");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="2">
				out.append("");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
			}
			if ((word1.tl(attr_lem).equalsIgnoreCase("pro_auxmod_mod_inf")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_auxmod_have_pp")
    || word1.tl(attr_lem).equalsIgnoreCase("pro_going_to_inf")))
			{
				// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="1">
				out.append("");
				// WARNING clip pos=2 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="2">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=2 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="2">
				out.append("");
				// WARNING clip pos=3 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="3">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
					         ;
					if (myword.length()>0)
					{
						out.append('^');
						out.append(myword);
						out.append('$');
					}
				}
				// WARNING blank pos=3 is out of range. Replacing with a zero-space blank. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<b pos="3">
				out.append("");
				// WARNING clip pos=4 is out of range. Replacing with an empty placeholder. - for <postchunk>/<section-rules>/<rule comment="arregla el pron reflexiu de tercera persona, quan és proclític">/<action>/<choose>/<otherwise>/<choose>/<when>/<out>/<lu>/<clip part="whole" pos="4">
				{
					String myword = 
					         new InterchunkWord("").tl(attr_whole)
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
	public void rule34__reflexiu(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule34__reflexiu",  word1); } 
		if (word1.tl(attr_pers).equals("<p3>"))
		{
			word1.tlSet(attr_lem, "se");
			word1.tlSet(attr_gen, "<mf>");
			word1.tlSet(attr_nbr, "<sp>");
			word1.tlSet(attr_a_prnpro, "<prn><pro><ref>");
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
	
	// CHUNK: HI
	public void rule35__hi(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule35__hi",  word1); } 
		word1.tlSet(attr_lem, "hi");
		word1.tlSet(attr_tags, "<prn><pro><adv>");
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
	
	// CHUNK: tenir (el chunk 'tenir' és resultat de canviar 'ser' per 'tenir' en el t2x en el patró 'I am 20 years old'
	public void rule36__tener(Writer out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("rule36__tener",  word1); } 
		word1.tlSet(attr_lem, TransferWord.copycase(word1.sl(attr_lem), "tener"));
		word1.tlSet(attr_a_verb, "<vblex>");
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
