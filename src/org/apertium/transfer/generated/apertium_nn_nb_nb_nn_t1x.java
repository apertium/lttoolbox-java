package org.apertium.transfer.generated;
import java.util.*;
import java.io.*;
import org.apertium.transfer.*;
public class apertium_nn_nb_nb_nn_t1x extends GeneratedTransferBase
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
	ApertiumRE attr_a_det = new ApertiumRE("<det><emph>|<det><dem>|<det><itg>|<det><qnt>|<det><pos>|<det>");
	ApertiumRE attr_a_prn = new ApertiumRE("<prn><enc><ref>|<prn><enc>");
	ApertiumRE attr_gen = new ApertiumRE("<mf>|<nt>|<GD>|<m>|<f>");
	ApertiumRE attr_nbr = new ApertiumRE("<sg>|<pl>|<sp>|<ND>");
	ApertiumRE attr_cas = new ApertiumRE("<nom>|<gen>|<acc>|<CD>");
	ApertiumRE attr_art = new ApertiumRE("<def>|<ind>");
	ApertiumRE attr_lem = new ApertiumRE("(([^<]|\"\\<\")+)");
	ApertiumRE attr_lemq = new ApertiumRE("\\#[- _][^<]+");
	ApertiumRE attr_lemh = new ApertiumRE("(([^<#]|\"\\<\"|\"\\#\")+)");
	ApertiumRE attr_whole = new ApertiumRE("(.+)");
	ApertiumRE attr_tags = new ApertiumRE("((<[^>]+>)+)");
	ApertiumRE attr_chname = new ApertiumRE("(\\{([^/]+)\\/)");
	ApertiumRE attr_chcontent = new ApertiumRE("(\\{.+)");
	ApertiumRE attr_content = new ApertiumRE("(\\{.+)");
	String var_det_gender = "";
	String var_number = "";
	String var_number_no_sp = "";
	String var_adj_number = "";
	String var_adj_gender = "";
	String var_adj_defness = "";
	String var_n_number = "";
	String var_case = "";
	String var_pass = "";
	String var_n_defness = "";
	TransferWordList list_det_indef = new TransferWordList(new String[] { "denne", "disse", "dette", "den", "de", "DENNE", "DISSE", "DETTE", "DEN", "DE", "Denne", "Disse", "Dette", "Den", "De", });
	
	private void macro_f_bcond(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_f_bcond",  word1); }; 
		// WARNING blank pos=1 is out of range. Replacing with an zero-space blank. - for <transfer>/<section-def-macros>/<def-macro n="f_bcond" npar="1">/<choose>/<when>/<test>/<not>/<equal>/<b pos="1">
		if (!"".equals(" "))
		{
			// WARNING blank pos=1 is out of range. Replacing with an zero-space blank. - for <transfer>/<section-def-macros>/<def-macro n="f_bcond" npar="1">/<choose>/<when>/<out>/<b pos="1">
			out.append("");
		}
	}
	
	private void macro_set_number1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_number1",  word1); }; 
		var_number = word1.target(attr_nbr, true);
		var_number_no_sp = var_number;
		if ((var_number.equals("<sp>")
    || var_number.equals("")))
		{
			var_number_no_sp = "<pl>";
		}
	}
	
	private void macro_set_number2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_number2",  word1, blank1,  word2); }; 
		macro_set_number1(out, word2);
		if (var_number.equals("<ND>"))
		{
			var_number = word1.target(attr_nbr, true);
		}
		var_n_number = var_number;
		if ((word2.target(attr_a_adj, true).equals("<adj><pp>")
    || word2.target(attr_a_adj, true).toLowerCase().endsWith("<posi>".toLowerCase())))
		{
			if ((word1.target(attr_nbr, true).equals("<sg>")
    && word1.target(attr_art, true).equals("<def>")))
			{
				var_number = "<sg>";
			}
			if (word1.target(attr_nbr, true).equals("<pl>"))
			{
				var_number = "<pl>";
			}
			var_n_number = var_number;
		}
		if ((var_n_number.equals("<sp>")
    || var_n_number.equals("")))
		{
			var_n_number = word1.target(attr_nbr, true);
		}
		if ((word1.target(attr_a_nom, true).toLowerCase().startsWith("<np>".toLowerCase())
    || word1.target(attr_a_nom, true).toLowerCase().endsWith("<acr>".toLowerCase())))
		{
			var_n_number = "";
		}
	}
	
	private void macro_set_case(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_case",  word1); }; 
		var_case = "";
		if (word1.target(attr_a_nom, true).toLowerCase().startsWith("<np>".toLowerCase()))
		{
			var_case = "<gen>";
		}
	}
	
	private void macro_set_gender1(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_gender1",  word1); }; 
		var_det_gender = "";
		macro_set_number1(out, word1);
		if ((var_number.equals("<sg>")
    && word1.target(attr_gen, true).equals("<GD>")))
		{
			var_det_gender = "<m>";
		}
		else
		if (var_number.equals("<pl>"))
		{
			var_det_gender = "";
		}
		else
		{
			var_det_gender = word1.target(attr_gen, true);
		}
	}
	
	private void macro_set_n_defness(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_n_defness",  word1, blank1,  word2); }; 
		if ((word1.target(attr_art, true).equals("<ind>")
    && (list_det_indef.contains(word2.source(attr_lem, true))
    || (word2.target(attr_a_adj, true).toLowerCase().startsWith("<adj>".toLowerCase())
    && word2.target(attr_art, true).equals("<def>")))))
		{
			var_n_defness = "<def>";
		}
		else
		{
			var_n_defness = word1.target(attr_art, true);
		}
	}
	
	private void macro_set_gender2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_gender2",  word1, blank1,  word2); }; 
		var_det_gender = "";
		if (word2.target(attr_a_nom, true).toLowerCase().startsWith("<n>".toLowerCase()))
		{
			macro_set_gender1(out, word1);
			macro_set_number2(out, word1, " ", word1);
		}
		else
		{
			macro_set_number2(out, word1, blank1, word2);
			if (var_number.equals("<pl>"))
			{
				var_det_gender = "";
			}
			else
			if ((var_number.equals("<sg>")
    || var_number.equals("<sp>")))
			{
				var_det_gender = word2.target(attr_gen, true);
				if ((var_det_gender.equals("<m>")
    && !word1.target(attr_gen, true).equals("")))
				{
					var_det_gender = word1.target(attr_gen, true);
				}
				else
				if (var_det_gender.equals("<GD>"))
				{
					var_det_gender = word1.target(attr_gen, true);
					if ((var_det_gender.equals("")
    || var_det_gender.equals("<mf>")))
					{
						var_det_gender = "<m>";
					}
				}
				else
				if (var_det_gender.equals(""))
				{
					var_det_gender = word2.target(attr_gen, true);
				}
			}
		}
	}
	
	private void macro_set_adj_number(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_adj_number",  word1); }; 
		var_adj_number = "";
		if ((word1.target(attr_a_adj, true).equals("<adj><pp>")
    || word1.target(attr_a_adj, true).toLowerCase().endsWith("<posi>".toLowerCase())))
		{
			var_adj_number = var_number;
			if ((var_adj_number.equals("")
    || var_adj_number.equals("<sp>")))
			{
				var_adj_number = word1.target(attr_nbr, true);
			}
		}
	}
	
	private void macro_set_adj_GND(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_adj_GND",  word1); }; 
		var_adj_gender = word1.target(attr_gen, true);
		var_adj_number = word1.target(attr_nbr, true);
		var_adj_defness = word1.target(attr_art, true);
		if (var_adj_gender.equals("<GD>"))
		{
			macro_set_adj_number(out, word1);
			if (var_adj_number.equals("<sg>"))
			{
				if (!var_det_gender.equals(""))
				{
					var_adj_gender = var_det_gender;
				}
				if ((var_adj_gender.equals("<m>")
    || var_adj_gender.equals("<GD>")))
				{
					var_adj_gender = "<mf>";
				}
				var_adj_defness = "<ind>";
				if (var_adj_gender.equals(""))
				{
					var_adj_defness = "<sg>";
				}
			}
			if (var_adj_number.equals("<pl>"))
			{
				var_adj_gender = "";
				if (var_adj_defness.equals("<ind>"))
				{
					var_adj_defness = "";
				}
			}
		}
	}
	
	private void macro_set_gender3(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("macro_set_gender3",  word1, blank1,  word2, blank2,  word3); }; 
		macro_set_gender2(out, word1, blank1, word2);
		macro_set_adj_GND(out, word3);
	}
	
	private void macro_out_ndef(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_out_ndef",  word1, blank1,  word2); }; 
		{
			String myword = 
			         TransferWord.copycase(word2.source(attr_lem, true), word1.target(attr_lemh, true))
			         +word1.target(attr_a_nom, true)
			         +word1.target(attr_gen, true)
			         +word1.target(attr_nbr, true)
			         +"<def>"
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
	
	private void macro_out_posgen(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_out_posgen",  word1); }; 
		if (word1.source(attr_a_det, true).equals("<det><pos>"))
		{
			{
				String myword = 
				         word1.target(attr_lemh, true)
				         +word1.target(attr_a_det, true)
				         +var_det_gender
				         +var_number
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
		else
		{
			{
				String myword = 
				         "til"
				         +"<pr>"
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
				         word1.target(attr_lemh, true)
				         +word1.target(attr_a_nom, true)
				         +word1.target(attr_gen, true)
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
	
	private void macro_out_sin(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_out_sin",  word1); }; 
		macro_set_gender1(out, word1);
		if ((var_number.equals("<sp>")
    || var_number.equals("")))
		{
			var_det_gender = "";
		}
		{
			String myword = 
			         "sin"
			         +"<det><pos>"
			         +var_det_gender
			         +var_number_no_sp
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	private void macro_out_adj(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_out_adj",  word1); }; 
		macro_set_adj_GND(out, word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_adj, true)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
	
	// VBLEX.INF.PASS: kan leses => kan lesast
	public void rule0__vblexinfpass(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule0__vblexinfpass",  word1); }; 
		if (word1.target(attr_a_verb, true).equals("<vblex><pstv>"))
		{
			var_pass = "";
		}
		else
		{
			var_pass = "<pst>";
		}
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_verb, true)
			         +word1.target(attr_temps, true)
			         +var_pass
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
	
	// VBLEX.PRES.PASS: leses => blir lest                    todo: verb probably should lose possible uppercasing,                    although it's unlikely to find the passive verb in                    the beginning of a sentence                     If we translate into a pstv verb, don't change anything.
	public void rule1__vblexprespass(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule1__vblexprespass",  word1); }; 
		if (word1.target(attr_a_verb, true).equals("<vblex><pstv>"))
		{
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
		}
		else
		{
			{
				String myword = 
				         TransferWord.copycase(word1.source(attr_lem, true), "bli")
				         +"<vblex><pres>"
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
				         word1.target(attr_lemh, true)
				         +word1.target(attr_a_verb, true)
				         +"<pp>"
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
	
	// VBLEX.PRES.PASS ADV: leses ikke => blir ikke lest                    Based on the above rule.
	public void rule2__vblexprespass__adv(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule2__vblexprespass__adv",  word1, blank1,  word2); }; 
		if (word1.target(attr_a_verb, true).equals("<vblex><pstv>"))
		{
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
		else
		{
			{
				String myword = 
				         TransferWord.copycase(word1.source(attr_lem, true), "bli")
				         +"<vblex><pres>"
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
			out.append(" ");
			{
				String myword = 
				         word1.target(attr_lemh, true)
				         +word1.target(attr_a_verb, true)
				         +"<pp>"
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
	
	// VBLEX.PRES.PASS ADV ADV: leses ikke alltid => blir ikke alltid lest                    Based on the above rule.
	public void rule3__vblexprespass__adv__adv(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule3__vblexprespass__adv__adv",  word1, blank1,  word2, blank2,  word3); }; 
		if (word1.target(attr_a_verb, true).equals("<vblex><pstv>"))
		{
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
		}
		else
		{
			{
				String myword = 
				         TransferWord.copycase(word1.source(attr_lem, true), "bli")
				         +"<vblex><pres>"
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
			out.append(" ");
			{
				String myword = 
				         word1.target(attr_lemh, true)
				         +word1.target(attr_a_verb, true)
				         +"<pp>"
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
	
	// VBLEX                    Just in case we have nn multiwords; which need                    lemq after the inflected part.                    This has to be below the passive rules.
	public void rule4__vblex(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule4__vblex",  word1); }; 
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
	
	// NGEN_TEMPORAL: dagens => dagens.
	public void rule5__ngen_temporal(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule5__ngen_temporal",  word1); }; 
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
	}
	
	// NGEN_TEMPORAL NIND: dagens avis => dagens avis
	public void rule6__ngen_temporal__nind(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule6__ngen_temporal__nind",  word1, blank1,  word2); }; 
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
	
	// DET NGEN_TEMPORAL NIND: et års tid => eit års tid                    TODO: disse års tid => ?
	public void rule7__det__ngen_temporal__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule7__det__ngen_temporal__nind",  word1, blank1,  word2, blank2,  word3); }; 
		macro_set_gender2(out, word2, " ", word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
	}
	
	// NGEN_TEMPORAL ADJ NIND: dagens siste avis => dagens siste avis
	public void rule8__ngen_temporal__adj__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule8__ngen_temporal__adj__nind",  word1, blank1,  word2, blank2,  word3); }; 
		macro_set_gender3(out, word3, blank1, word2, blank1, word2);
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
		macro_out_adj(out, word2);
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
	}
	
	// ADJ NGEN_TEMPORAL NIND: flere års tid => fleire års tid                                            hele dagens region => heile dagens region
	public void rule9__adj__ngen_temporal__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule9__adj__ngen_temporal__nind",  word1, blank1,  word2, blank2,  word3); }; 
		macro_set_gender3(out, word2, " ", word1, " ", word1);
		macro_out_adj(out, word1);
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
	}
	
	// DET ADJ NGEN_TEMPORAL NIND: et langt års tid => eit langt års tid                    TODO: disse lange års tid =>?
	public void rule10__det__adj__ngen_temporal__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule10__det__adj__ngen_temporal__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); }; 
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
		macro_out_adj(out, word2);
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
			         word4.target(attr_whole, true)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	// NGEN: mannens => mannen sin                    Very heuristic fallback rule.                    If we can't match with the below rules, turn the                    genitive -s into 'sin' garpegenitiv instead.                    A bit more fluent where eg. input is incomplete:                          mannens *sykkel => mannen sin *sykkel                    But we don't know gen/nbr of object, so we could end                    up with                          mannens *sykler => mannen sin *sykler                    So let's just hope plurals possess plurals etc...
	public void rule11__ngen(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule11__ngen",  word1); }; 
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_nom, true)
			         +word1.target(attr_gen, true)
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
		out.append(" ");
		macro_out_sin(out, word1);
	}
	
	// ADJ NGEN: lille mannens => lille mannen sin                    Very heuristic fallback rule  (needed since we have an                    ADJ NOM rule below)                                        We use an adjective to set determiner adj_gender, so call                    set_gender1 again.
	public void rule12__adj__ngen(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule12__adj__ngen",  word1, blank1,  word2); }; 
		macro_set_gender3(out, word2, " ", word1, " ", word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_adj, true)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
		out.append(" ");
		macro_out_sin(out, word2);
	}
	
	// DETNONPOS ADJ NGEN: den lille mannens => den lille mannen sin                    Very heuristic fallback rule (needed since we have a                    DETNONPOS ADJ NOM rule below)
	public void rule13__detnonpos__adj__ngen(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule13__detnonpos__adj__ngen",  word1, blank1,  word2, blank2,  word3); }; 
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		if (var_number.equals("<sp>"))
		{
			var_number = "<pl>";
			var_det_gender = "";
		}
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
			         +word2.target(attr_a_adj, true)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
			         +word3.target(attr_nbr, true)
			         +word3.target(attr_art, true)
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
		macro_out_sin(out, word3);
	}
	
	// POSGEN NIND: naboens bil => bilen til naboen                                 min mor => mora mi                                 ditt hus => huset ditt                    nind makes sure we don't match 'min Per(np)' nor 'min bils(gen)'                    Third example shows how determiners ..um..determine number.
	public void rule14__posgen__nind(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule14__posgen__nind",  word1, blank1,  word2); }; 
		word1.setTarget(attr_lemh, TransferWord.copycase(word2.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_set_gender2(out, word2, " ", word1);
		macro_out_ndef(out, word2, " ", word1);
		out.append(blank1);
		macro_out_posgen(out, word1);
	}
	
	// POSGEN ADJ NIND: naboens lille bil => den vesle bilen til naboen                                     mitt lille navn => det vesle namnet mitt                                     mitt svarte hus => det svarte huset mitt                    nind: vil ikkje ha 'det vesle #Noreg(def) mitt'
	public void rule15__posgen__adj__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule15__posgen__adj__nind",  word1, blank1,  word2, blank2,  word3); }; 
		word1.setTarget(attr_lemh, TransferWord.copycase(word2.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		{
			String myword = 
			         TransferWord.copycase(word1.source(attr_lem, true), "den")
			         +"<det><dem>"
			         +var_det_gender
			         +var_number_no_sp
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
			         +word2.target(attr_a_adj, true)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
		macro_out_ndef(out, word3, blank2, word3);
		out.append(" ");
		macro_out_posgen(out, word1);
	}
	
	// POSGEN ADJ ADJ NIND
	public void rule16__posgen__adj__adj__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule16__posgen__adj__adj__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); }; 
		word1.setTarget(attr_lemh, TransferWord.copycase(word2.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_set_gender3(out, word4, " ", word1, blank2, word3);
		{
			String myword = 
			         TransferWord.copycase(word1.source(attr_lem, true), "den")
			         +"<det><dem>"
			         +var_det_gender
			         +var_number_no_sp
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		macro_out_adj(out, word2);
		out.append(blank2);
		macro_out_adj(out, word3);
		out.append(blank3);
		macro_out_ndef(out, word4, blank3, word4);
		out.append(" ");
		macro_out_posgen(out, word1);
	}
	
	// POSGEN ADJ ADJ ADJ NIND
	public void rule17__posgen__adj__adj__adj__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule17__posgen__adj__adj__adj__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); }; 
		word1.setTarget(attr_lemh, TransferWord.copycase(word2.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_set_gender3(out, word5, " ", word1, blank3, word4);
		{
			String myword = 
			         TransferWord.copycase(word1.source(attr_lem, true), "den")
			         +"<det><dem>"
			         +var_det_gender
			         +var_number_no_sp
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		macro_out_adj(out, word2);
		out.append(blank2);
		macro_out_adj(out, word3);
		out.append(blank3);
		macro_out_adj(out, word4);
		out.append(blank4);
		macro_out_ndef(out, word5, blank4, word5);
		out.append(" ");
		macro_out_posgen(out, word1);
	}
	
	// POSGEN ADJ ADJ ADJ ADJ NIND
	public void rule18__posgen__adj__adj__adj__adj__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule18__posgen__adj__adj__adj__adj__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); }; 
		word1.setTarget(attr_lemh, TransferWord.copycase(word2.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_set_gender3(out, word6, " ", word1, blank4, word5);
		{
			String myword = 
			         TransferWord.copycase(word1.source(attr_lem, true), "den")
			         +"<det><dem>"
			         +var_det_gender
			         +var_number_no_sp
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank1);
		macro_out_adj(out, word2);
		out.append(blank2);
		macro_out_adj(out, word3);
		out.append(blank3);
		macro_out_adj(out, word4);
		out.append(blank4);
		macro_out_adj(out, word5);
		out.append(blank5);
		macro_out_ndef(out, word6, blank5, word6);
		out.append(" ");
		macro_out_posgen(out, word1);
	}
	
	// POSGEN NGEN NIND: min katts snute => snuten til katten min                                      naboens katts snute => snuten til katten til naboen                                      (but not *'min din snute')
	public void rule19__posgen__ngen__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule19__posgen__ngen__nind",  word1, blank1,  word2, blank2,  word3); }; 
		word1.setTarget(attr_lemh, TransferWord.copycase(word3.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_set_gender2(out, word2, " ", word1);
		macro_out_ndef(out, word3, " ", word1);
		out.append(blank1);
		{
			String myword = 
			         "til"
			         +"<pr>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ");
		macro_out_ndef(out, word2, blank1, word2);
		out.append(blank2);
		macro_out_posgen(out, word1);
	}
	
	// POSGEN ADJ NGEN NIND: min sorte katts snute => snuten til den svarte katten min
	public void rule20__posgen__adj__ngen__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule20__posgen__adj__ngen__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); }; 
		word1.setTarget(attr_lemh, TransferWord.copycase(word4.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		macro_out_ndef(out, word4, " ", word1);
		out.append(blank1);
		{
			String myword = 
			         "til"
			         +"<pr>"
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
			         "den"
			         +"<det><dem>"
			         +var_det_gender
			         +var_number_no_sp
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ");
		macro_out_adj(out, word2);
		out.append(blank2);
		macro_out_ndef(out, word3, blank2, word3);
		out.append(blank3);
		macro_out_posgen(out, word1);
	}
	
	// POSGEN NGEN ADJ NIND: min katts hvite snute => den kvite snuten til katten min
	public void rule21__posgen__ngen__adj__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule21__posgen__ngen__adj__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); }; 
		word1.setTarget(attr_lemh, TransferWord.copycase(word4.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_set_gender3(out, word2, " ", word1, blank2, word3);
		{
			String myword = 
			         TransferWord.copycase(word1.source(attr_lem, true), "den")
			         +"<det><dem>"
			         +var_det_gender
			         +var_number_no_sp
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ");
		macro_out_adj(out, word3);
		out.append(blank1);
		macro_out_ndef(out, word4, blank3, word4);
		out.append(blank2);
		{
			String myword = 
			         "til"
			         +"<pr>"
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ");
		macro_out_ndef(out, word2, blank1, word2);
		out.append(blank3);
		macro_out_posgen(out, word1);
	}
	
	// DETNONPOS NGEN NIND: en katts snute => snuten til ein katt
	public void rule22__detnonpos__ngen__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule22__detnonpos__ngen__nind",  word1, blank1,  word2, blank2,  word3); }; 
		macro_set_gender2(out, word2, " ", word1);
		word1.setTarget(attr_lemh, TransferWord.copycase(word3.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_out_ndef(out, word3, " ", word1);
		out.append(blank1);
		{
			String myword = 
			         "til"
			         +"<pr>"
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
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
		out.append(blank2);
		{
			String myword = 
			         word2.target(attr_lemh, true)
			         +word2.target(attr_a_nom, true)
			         +word2.target(attr_gen, true)
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
	}
	
	// DETNONPOS ADJ NGEN NIND: en sort katts snute => snuten til ein svart katt                                            den nye Lamaens bil => bilen til den nye Lamaen
	public void rule23__detnonpos__adj__ngen__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule23__detnonpos__adj__ngen__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); }; 
		word1.setTarget(attr_lemh, TransferWord.copycase(word4.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		macro_out_ndef(out, word4, " ", word1);
		out.append(blank1);
		{
			String myword = 
			         "til"
			         +"<pr>"
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
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
		out.append(blank2);
		macro_out_adj(out, word2);
		out.append(blank3);
		{
			String myword = 
			         word3.target(attr_lemh, true)
			         +word3.target(attr_a_nom, true)
			         +word3.target(attr_gen, true)
			         +word3.target(attr_nbr, true)
			         +word3.target(attr_art, true)
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
	
	// DETNONPOS DETNONPOS NGEN NIND: den neste Lamaens bil => bilen til den neste Lamaen                                                   hver en Lamas bil => bilen til kvar ein Lama                                                   (vel... logisk tvitydig, er det ikkje?)
	public void rule24__detnonpos__detnonpos__ngen__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule24__detnonpos__detnonpos__ngen__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); }; 
		word1.setTarget(attr_lemh, TransferWord.copycase(word4.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_out_ndef(out, word4, " ", word1);
		macro_set_gender2(out, word3, " ", word1);
		out.append(blank1);
		{
			String myword = 
			         "til"
			         +"<pr>"
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
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
		out.append(blank2);
		macro_set_gender2(out, word3, blank1, word2);
		{
			String myword = 
			         word2.target(attr_lemh, true)
			         +word2.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
		out.append(blank3);
		{
			String myword = 
			         word3.target(attr_lemh, true)
			         +word3.target(attr_a_nom, true)
			         +word3.target(attr_gen, true)
			         +word3.target(attr_nbr, true)
			         +word3.target(attr_art, true)
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
	
	// DETNONPOS NGEN ADJ NIND: en katts hvite snute => den kvite snuten til ein katt                                             forrige århundres største filosofer => dei største filosofane til forrige århundre                    (ja, me burde ha ein måte å velje preposisjon)                    Merk at «en katts hvite hus» er tvitydig mellom sg/pl, så me nyttar set_gender1 først.
	public void rule25__detnonpos__ngen__adj__nind(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule25__detnonpos__ngen__adj__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); }; 
		word1.setTarget(attr_lemh, TransferWord.copycase(word4.target(attr_lemh, true), word1.target(attr_lemh, true)), true);
		macro_set_gender1(out, word4);
		{
			String myword = 
			         TransferWord.copycase(word1.source(attr_lem, true), "den")
			         +"<det><dem>"
			         +var_det_gender
			         +var_number_no_sp
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(" ");
		macro_out_adj(out, word3);
		out.append(blank1);
		macro_out_ndef(out, word4, blank3, word4);
		macro_set_gender2(out, word2, " ", word1);
		out.append(blank2);
		{
			String myword = 
			         "til"
			         +"<pr>"
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
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
		out.append(blank3);
		{
			String myword = 
			         word2.target(attr_lemh, true)
			         +word2.target(attr_a_nom, true)
			         +word2.target(attr_gen, true)
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
	}
	
	// DET: en => ein      Frequency is on our side, but politically incorrect..hmm..
	public void rule26__det(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule26__det",  word1); }; 
		macro_set_gender1(out, word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
	public void rule27__det__nacr(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule27__det__nacr",  word1, blank1,  word2); }; 
		macro_set_gender1(out, word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
	
	// NDEF DETPOS: jenten min => jenta mi
	public void rule28__ndef__detpos(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule28__ndef__detpos",  word1, blank1,  word2); }; 
		macro_set_gender2(out, word1, blank1, word2);
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
			         +word2.target(attr_a_det, true)
			         +var_det_gender
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
	}
	
	// DET NOM: en kvinne => ei kvinne               hvilken jente => kva for ei jente        egne hus => eigne hus        et Norge => eit Noreg                             dette hus => dette huset             np får ikkje noko tal i den siste.
	public void rule29__det__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule29__det__nom",  word1, blank1,  word2); }; 
		macro_set_gender2(out, word2, " ", word1);
		macro_set_n_defness(out, word2, " ", word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
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
		out.append(blank1);
		{
			String myword = 
			         word2.target(attr_lemh, true)
			         +word2.target(attr_a_nom, true)
			         +word2.target(attr_gen, true)
			         +word2.target(attr_nbr, true)
			         +var_n_defness
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
	
	// ADJ: åpne (hus) => opne (hus), liten(f) => lita
	public void rule30__adj(Writer out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule30__adj",  word1); }; 
		macro_set_number1(out, word1);
		macro_out_adj(out, word1);
	}
	
	// ADJ NOM: liten bok => lita bok               hele Norge => heile Noreg             np får ikkje noko tal i den siste.      We let CG disambiguate art and nbr using the following noun,      o/w all info should be in the adjective wordform (eg. in the above      example, hus being ind should give plural).                                        We include case here since this should catch proper as well as common nouns,                    and earlier rules should catch any _possessive_ noun phrases.
	public void rule31__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule31__adj__nom",  word1, blank1,  word2); }; 
		macro_set_gender3(out, word2, " ", word1, " ", word1);
		macro_set_n_defness(out, word2, " ", word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_adj, true)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
			         +word2.target(attr_nbr, true)
			         +var_n_defness
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
	
	// DET ADJ: en liten(f) => ei lita 
	public void rule32__det__adj(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule32__det__adj",  word1, blank1,  word2); }; 
		macro_set_gender1(out, word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
		macro_out_adj(out, word2);
	}
	
	// DETNONPOS ADJ NOM: en(mf) viktig(mf) dag(m) => ein(m) viktig(mf) dag(m)                                       denne viktige dag => denne viktige dagen      Note that the adjective might have different gender specificity from the      determiner; so we have an extra test to set adj_gender.                                        We include case here since this should catch proper as well as common nouns,                    and earlier rules should catch any _possessive_ noun phrases.
	public void rule33__detnonpos__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule33__detnonpos__adj__nom",  word1, blank1,  word2, blank2,  word3); }; 
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		macro_set_n_defness(out, word3, " ", word1);
		{
			String myword = 
			         word1.target(attr_lemh, true)
			         +word1.target(attr_a_det, true)
			         +var_det_gender
			         +var_number
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
			         +word2.target(attr_a_adj, true)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
			         +word3.target(attr_nbr, true)
			         +var_n_defness
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
}
