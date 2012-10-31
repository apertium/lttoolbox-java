package org.apertium.transfer.old.generated;
import java.io.*;
import org.apertium.transfer.*;
import org.apertium.transfer.generated.GeneratedTransferBase;
public class apertium_nn_nb_nb_nn_t1x extends GeneratedTransferBase
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
	ApertiumRE attr_a_det = new ApertiumRE("<det(?:><emph|><dem|><itg|><qnt|><pos|)>");
	ApertiumRE attr_a_prn = new ApertiumRE("<prn><enc(?:><ref|)>");
	ApertiumRE attr_gen = new ApertiumRE("<(?:mf|nt|GD|m|f)>");
	ApertiumRE attr_nbr = new ApertiumRE("<(?:sg|pl|sp|ND)>");
	ApertiumRE attr_cas = new ApertiumRE("<(?:nom|gen|acc|CD)>");
	ApertiumRE attr_art = new ApertiumRE("<(?:def|ind)>");
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
	/**  feels like these should have their own
           sub-pos... «<det><dem> som kan ha <ind> etter seg på
           bokmål»  */
	WordList list_det_indef = new WordList(new String[] { "denne", "disse", "dette", "den", "de", "DENNE", "DISSE", "DETTE", "DEN", "DE", "Denne", "Disse", "Dette", "Den", "De", });
	
	private void macro_f_bcond(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_f_bcond",  word1); } 
		/** Per mirar si el blanc conté o no format awhatnow?  */
		// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <transfer>/<section-def-macros>/<def-macro n="f_bcond" npar="1">/<choose>/<when>/<test>/<not>/<equal>/<b pos="1">
		if (!"".equals(" "))
		{
			// WARNING blank pos=1 is out of range. Replacing with a zero-space blank. - for <transfer>/<section-def-macros>/<def-macro n="f_bcond" npar="1">/<choose>/<when>/<out>/<b pos="1">
			out.append("");
		}
	}
	
	/**  Macros which set concordance variables:  */
	private void macro_set_number1(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_number1",  word1); } 
		var_number = word1.tl(attr_nbr);
		var_number_no_sp = var_number;
		if ((var_number.equals("<sp>")
    || var_number.equals("")))
		{
			var_number_no_sp = "<pl>";
		}
	}
	
	private void macro_set_number2(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_number2",  word1, blank1,  word2); } 
		/**  arg.1: noun, arg.2: determiner or adjective
      sets number and n_number
      - If number is sp or empty (or noun actually is sp), use nbr
        from noun. Eg. <adj><pp> doesn't have a number, so in that case
        use noun.
      - If we've been given an adjective, and the noun is sg def,
        we can be pretty sure the noun is right about this, so go with
        sg def (set_adj_GND should make sure we add the def if adjective
        is plural). And the other way around, pl noun versus adjective
        is sure not to be sg def.
       */
		macro_set_number1(out, word2);
		if (var_number.equals("<ND>"))
		{
			var_number = word1.tl(attr_nbr);
		}
		var_n_number = var_number;
		if ((word2.tl(attr_a_adj).equals("<adj><pp>")
    || word2.tl(attr_a_adj).toLowerCase().endsWith("<posi>".toLowerCase())))
		{
			if ((word1.tl(attr_nbr).equals("<sg>")
    && word1.tl(attr_art).equals("<def>")))
			{
				var_number = "<sg>";
			}
			if (word1.tl(attr_nbr).equals("<pl>"))
			{
				var_number = "<pl>";
			}
			var_n_number = var_number;
		}
		if ((var_n_number.equals("<sp>")
    || var_n_number.equals("")
    || word1.tl(attr_nbr).equals("<sp>")))
		{
			var_n_number = word1.tl(attr_nbr);
		}
		if ((word1.tl(attr_a_nom).toLowerCase().startsWith("<np>".toLowerCase())
    || word1.tl(attr_a_nom).toLowerCase().endsWith("<acr>".toLowerCase())))
		{
			var_n_number = "";
		}
	}
	
	private void macro_set_case(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_case",  word1); } 
		/**  keep only case for proper nouns  */
		var_case = "";
		if (word1.tl(attr_a_nom).toLowerCase().startsWith("<np>".toLowerCase()))
		{
			var_case = "<gen>";
		}
	}
	
	private void macro_set_gender1(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_gender1",  word1); } 
		/**  arg.1: determiner
	   - iff sg and GD, take a wild guess and go for m;
	   - plurals get no gender;
	   - o/w take gender of target determiner;
           - if we have sp or nothing, go with pl
       */
		var_det_gender = "";
		macro_set_number1(out, word1);
		if ((var_number.equals("<sg>")
    && word1.tl(attr_gen).equals("<GD>")))
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
			var_det_gender = word1.tl(attr_gen);
		}
	}
	
	private void macro_set_n_defness(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_n_defness",  word1, blank1,  word2); } 
		/**  arg.1: noun, arg.2: determiner/adjective
           Make sure we have double definiteness marking, eg.:
           disse<def> friheter<ind> => desse<def> fridomane<def>
       */
		if ((word1.tl(attr_art).equals("<ind>")
    && (list_det_indef.contains(word2.sl(attr_lem))
    || (word2.tl(attr_a_adj).toLowerCase().startsWith("<adj>".toLowerCase())
    && word2.tl(attr_art).equals("<def>")))))
		{
			var_n_defness = "<def>";
		}
		else
		{
			var_n_defness = word1.tl(attr_art);
		}
	}
	
	private void macro_set_gender2(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_set_gender2",  word1, blank1,  word2); } 
		/**  arg.1: noun, arg.2: determiner
           - if a noun is given as arg.2, use set_gender1 instead (but
             set_number2 with arg.1); this is just so we can generalise
             with the POSGEN category
           - plurals get no gender
           - if sg/sp (all sp determiners have gender): 
           +++ default: take gender of target determiner
           +++ det m:   take gender of target noun unless mf/empty
           +++ det GD:  take gender of target noun;
                        but if GD/mf/empty, just take masc to choose Something
           - No number? No gender.
           Masculine determiners in bokmål may be used with femininine gender nouns
           without being marked as such in bidix.
           Determiners are less ambiguous wrt. number.
           
           Note: does not set adj_GND, use set_gender3 or an explicit call to set_adj_GND.
       */
		var_det_gender = "";
		if (word2.tl(attr_a_nom).toLowerCase().startsWith("<n>".toLowerCase()))
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
				var_det_gender = word2.tl(attr_gen);
				/**  ^^^ sg gender default: determiner gender  */
				if ((var_det_gender.equals("<m>")
    && !word1.tl(attr_gen).equals("")
    && !word1.tl(attr_gen).equals("<mf>")))
				{
					var_det_gender = word1.tl(attr_gen);
				}
				/**  ^^^ masc determiner => noun gender unless mf/empty  */
				else
				if (var_det_gender.equals("<GD>"))
				{
					var_det_gender = word1.tl(attr_gen);
					if ((var_det_gender.equals("")
    || var_det_gender.equals("<mf>")))
					{
						var_det_gender = "<m>";
					}
				}
				/**  ^^^ empty/mf noun gender, GD determiner => masc  */
				else
				if (var_det_gender.equals(""))
				{
					var_det_gender = word2.tl(attr_gen);
				}
			}
		}
	}
	
	/**  ^^^ noun had no gender (was eg. np/acr), use det  otherwise: no number, no gender  */
	private void macro_set_adj_number(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_adj_number",  word1); } 
		/**  arg.1: adjective
           
           Assumes that set_number is called!

           Number is only a feature of positive/pp adjectives. Use
           variable "number" for these unless it's empty/sp.
       */
		var_adj_number = "";
		if ((word1.tl(attr_a_adj).equals("<adj><pp>")
    || word1.tl(attr_a_adj).toLowerCase().endsWith("<posi>".toLowerCase())))
		{
			var_adj_number = var_number;
			if ((var_adj_number.equals("")
    || var_adj_number.equals("<sp>")))
			{
				var_adj_number = word1.tl(attr_nbr);
			}
		}
	}
	
	private void macro_set_adj_GND(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_set_adj_GND",  word1); } 
		/**  arg.1: adjective
           
           Assumes that number and det_gender are set! Only make changes
           for GD-marked adjectives.

           adj_gender is either nt, f or mf. Most adjectives only have
           nt or mf forms, some also have an f form. These we need to
           mark in bidix (nb <mf> => <GD>, nb <f> => <f>). <GD> turns
           into noun gender (or <mf> as fallback); however, we never
           use nn <m> so any <m> noun turns into <mf> adj_gender.
       */
		var_adj_gender = word1.tl(attr_gen);
		var_adj_number = word1.tl(attr_nbr);
		var_adj_defness = word1.tl(attr_art);
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
	
	private void macro_set_gender3(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("macro_set_gender3",  word1, blank1,  word2, blank2,  word3); } 
		/**  arg.1: noun, arg.2: determiner, arg.3: adjective 

           call set_gender2, then set adj_gender.  adj_gender is
           either nt, f or mf. Most adjectives only have nt or mf
           forms, some also have an f form. These we need to mark in
           bidix (nb <mf> => <GD>, nb <f> => <f>). <GD> turns into
           noun gender (or <mf> as fallback); however, we never use
           <m> so any <m> noun turns into <mf> adj_gender.
       */
		macro_set_gender2(out, word1, blank1, word2);
		macro_set_adj_GND(out, word3);
	}
	
	/**  Output macros:  */
	private void macro_out_ndef(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_out_ndef",  word1, blank1,  word2); } 
		/**  arg.1: possessed noun. arg.2 gives typographic case
           
           Strip case, add definiteness.   */
		out.append('^');
		out.append(TransferWord.copycase(word2.sl(attr_lem), word1.tl(attr_lemh)));
		out.append(word1.tl(attr_a_nom));
		out.append(word1.tl(attr_gen));
		out.append(word1.tl(attr_nbr));
		out.append("<def>");
		out.append(word1.tl(attr_lemq));
		out.append('$');
	}
	
	private void macro_out_posgen(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_out_posgen",  word1); } 
		/**  arg.1: possessor, either genitive noun or det.pos.
           Assumes that "det_gender" and "number" are set.
           Choose 'til NOUN' unless we have a determiner. Only determiners
           use variable gender and number */
		if (word1.sl(attr_a_det).equals("<det><pos>"))
		{
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_det)
				         +var_det_gender
				         +var_number
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
			out.append("^til<pr>$ ");
			{
				String myword = 
				         word1.tl(attr_lemh)
				         +word1.tl(attr_a_nom)
				         +word1.tl(attr_gen)
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
	
	private void macro_out_sin(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_out_sin",  word1); } 
		macro_set_gender1(out, word1);
		if ((var_number.equals("<sp>")
    || var_number.equals("")))
		{
			var_det_gender = "";
		}
		out.append("^sin<det><pos>");
		out.append(var_det_gender);
		out.append(var_number_no_sp);
		out.append('$');
	}
	
	private void macro_out_adj(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("macro_out_adj",  word1); } 
		macro_set_adj_GND(out, word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_adj)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
	
	/**  Verbs  */
	// VBLEX.INF.PASS: kan leses => kan lesast
	public void rule0__vblexinfpass(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule0__vblexinfpass",  word1); } 
		if (word1.tl(attr_a_verb).equals("<vblex><pstv>"))
		{
			var_pass = "";
		}
		else
		{
			var_pass = "<pst>";
		}
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_verb)
			         +word1.tl(attr_temps)
			         +var_pass
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
	
	// VBLEX.PRES.PASS: leses => blir lest                    todo: verb probably should lose possible uppercasing,                    although it's unlikely to find the passive verb in                    the beginning of a sentence                     If we translate into a pstv verb, don't change anything.
	public void rule1__vblexprespass(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule1__vblexprespass",  word1); } 
		if (word1.tl(attr_a_verb).equals("<vblex><pstv>"))
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
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "bli"));
			out.append("<vblex><pres>$ ^");
			out.append(word1.tl(attr_lemh));
			out.append(word1.tl(attr_a_verb));
			out.append("<pp>");
			out.append(word1.tl(attr_lemq));
			out.append('$');
		}
	}
	
	// VBLEX.PRES.PASS ADV: leses ikke => blir ikke lest                    Based on the above rule.
	public void rule2__vblexprespass__adv(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule2__vblexprespass__adv",  word1, blank1,  word2); } 
		if (word1.tl(attr_a_verb).equals("<vblex><pstv>"))
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
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "bli"));
			out.append("<vblex><pres>$");
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
			out.append(" ^");
			out.append(word1.tl(attr_lemh));
			out.append(word1.tl(attr_a_verb));
			out.append("<pp>");
			out.append(word1.tl(attr_lemq));
			out.append('$');
		}
	}
	
	// VBLEX.PRES.PASS ADV ADV: leses ikke alltid => blir ikke alltid lest                    Based on the above rule.
	public void rule3__vblexprespass__adv__adv(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule3__vblexprespass__adv__adv",  word1, blank1,  word2, blank2,  word3); } 
		if (word1.tl(attr_a_verb).equals("<vblex><pstv>"))
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
		}
		else
		{
			out.append('^');
			out.append(TransferWord.copycase(word1.sl(attr_lem), "bli"));
			out.append("<vblex><pres>$");
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
			out.append(" ^");
			out.append(word1.tl(attr_lemh));
			out.append(word1.tl(attr_a_verb));
			out.append("<pp>");
			out.append(word1.tl(attr_lemq));
			out.append('$');
		}
	}
	
	// VBLEX                    Just in case we have nn multiwords; which need                    lemq after the inflected part.                    This has to be below the passive rules.
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
	
	/**  Possessive noun phrases  First: exceptions to these, since earlier rules match first.  */
	// NGEN_TEMPORAL: dagens => dagens.
	public void rule5__ngen_temporal(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule5__ngen_temporal",  word1); } 
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
	
	// NGEN_TEMPORAL NIND: dagens avis => dagens avis
	public void rule6__ngen_temporal__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule6__ngen_temporal__nind",  word1, blank1,  word2); } 
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
	
	// DET NGEN_TEMPORAL NIND: et års tid => eit års tid                    TODO: disse års tid => ?
	public void rule7__det__ngen_temporal__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule7__det__ngen_temporal__nind",  word1, blank1,  word2, blank2,  word3); } 
		macro_set_gender2(out, word2, " ", word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
	}
	
	// NGEN_TEMPORAL ADJ NIND: dagens siste avis => dagens siste avis
	public void rule8__ngen_temporal__adj__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule8__ngen_temporal__adj__nind",  word1, blank1,  word2, blank2,  word3); } 
		macro_set_gender3(out, word3, blank1, word2, blank1, word2);
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
		macro_out_adj(out, word2);
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
	}
	
	// ADJ NGEN_TEMPORAL NIND: flere års tid => fleire års tid                                            hele dagens region => heile dagens region
	public void rule9__adj__ngen_temporal__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule9__adj__ngen_temporal__nind",  word1, blank1,  word2, blank2,  word3); } 
		macro_set_gender3(out, word2, " ", word1, " ", word1);
		macro_out_adj(out, word1);
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
	}
	
	// DET ADJ NGEN_TEMPORAL NIND: et langt års tid => eit langt års tid                    TODO: disse lange års tid =>?
	public void rule10__det__adj__ngen_temporal__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule10__det__adj__ngen_temporal__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
		macro_out_adj(out, word2);
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
			         word4.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
	}
	
	/**  The regular possessive noun phrases, with more complex
         transfer operations.

         Fleire reglar trengst for å matche ADJ* (eigentleg ADJ{0,4} i reglane under)
         men det jo berre kopiere og lime inn (og fikse litt) etter at ADJ{1} regelen 
         er ferdig. Sjå http://wiki.apertium.org/wiki/Norsk#Genitive.2Fpossessive   */
	// NGEN: mannens => mannen sin                    Very heuristic fallback rule.                    If we can't match with the below rules, turn the                    genitive -s into 'sin' garpegenitiv instead.                    A bit more fluent where eg. input is incomplete:                          mannens *sykkel => mannen sin *sykkel                    But we don't know gen/nbr of object, so we could end                    up with                          mannens *sykler => mannen sin *sykler                    So let's just hope plurals possess plurals etc...
	public void rule11__ngen(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule11__ngen",  word1); } 
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_nom)
			         +word1.tl(attr_gen)
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
		out.append(" ");
		macro_out_sin(out, word1);
	}
	
	// ADJ NGEN: lille mannens => lille mannen sin                    Very heuristic fallback rule  (needed since we have an                    ADJ NOM rule below)                                        We use an adjective to set determiner adj_gender, so call                    set_gender1 again.
	public void rule12__adj__ngen(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule12__adj__ngen",  word1, blank1,  word2); } 
		macro_set_gender3(out, word2, " ", word1, " ", word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_adj)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
		out.append(" ");
		macro_out_sin(out, word2);
	}
	
	// DETNONPOS ADJ NGEN: den lille mannens => den lille mannen sin                    Very heuristic fallback rule (needed since we have a                    DETNONPOS ADJ NOM rule below)
	public void rule13__detnonpos__adj__ngen(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule13__detnonpos__adj__ngen",  word1, blank1,  word2, blank2,  word3); } 
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		if (var_number.equals("<sp>"))
		{
			var_number = "<pl>";
			var_det_gender = "";
		}
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
			         +word2.tl(attr_a_adj)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
			         +word3.tl(attr_art)
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
		macro_out_sin(out, word3);
	}
	
	/**  POSGEN ADJ* NIND:  */
	// POSGEN NIND: naboens bil => bilen til naboen                                 min mor => mora mi                                 ditt hus => huset ditt                    nind makes sure we don't match 'min Per(np)' nor 'min bils(gen)'                    Third example shows how determiners ..um..determine number.
	public void rule14__posgen__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule14__posgen__nind",  word1, blank1,  word2); } 
		word1.tlSet(attr_lemh, TransferWord.copycase(word2.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_set_gender2(out, word2, " ", word1);
		macro_out_ndef(out, word2, " ", word1);
		out.append(blank1);
		macro_out_posgen(out, word1);
	}
	
	// POSGEN ADJ NIND: naboens lille bil => den vesle bilen til naboen                                     mitt lille navn => det vesle namnet mitt                                     mitt svarte hus => det svarte huset mitt                    nind: vil ikkje ha 'det vesle #Noreg(def) mitt'
	public void rule15__posgen__adj__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule15__posgen__adj__nind",  word1, blank1,  word2, blank2,  word3); } 
		word1.tlSet(attr_lemh, TransferWord.copycase(word2.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		out.append('^');
		out.append(TransferWord.copycase(word1.sl(attr_lem), "den"));
		out.append("<det><dem>");
		out.append(var_det_gender);
		out.append(var_number_no_sp);
		out.append('$');
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_adj)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
		macro_out_ndef(out, word3, blank2, word3);
		out.append(" ");
		macro_out_posgen(out, word1);
	}
	
	// POSGEN ADJ ADJ NIND
	public void rule16__posgen__adj__adj__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule16__posgen__adj__adj__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		word1.tlSet(attr_lemh, TransferWord.copycase(word2.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_set_gender3(out, word4, " ", word1, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(word1.sl(attr_lem), "den"));
		out.append("<det><dem>");
		out.append(var_det_gender);
		out.append(var_number_no_sp);
		out.append('$');
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
	public void rule17__posgen__adj__adj__adj__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule17__posgen__adj__adj__adj__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		word1.tlSet(attr_lemh, TransferWord.copycase(word2.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_set_gender3(out, word5, " ", word1, blank3, word4);
		out.append('^');
		out.append(TransferWord.copycase(word1.sl(attr_lem), "den"));
		out.append("<det><dem>");
		out.append(var_det_gender);
		out.append(var_number_no_sp);
		out.append('$');
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
	public void rule18__posgen__adj__adj__adj__adj__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule18__posgen__adj__adj__adj__adj__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		word1.tlSet(attr_lemh, TransferWord.copycase(word2.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_set_gender3(out, word6, " ", word1, blank4, word5);
		out.append('^');
		out.append(TransferWord.copycase(word1.sl(attr_lem), "den"));
		out.append("<det><dem>");
		out.append(var_det_gender);
		out.append(var_number_no_sp);
		out.append('$');
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
	
	/**  POSGEN ADJ* NGEN ADJ* NIND:  */
	// POSGEN NGEN NIND: min katts snute => snuten til katten min                                      naboens katts snute => snuten til katten til naboen                                      (but not *'min din snute')
	public void rule19__posgen__ngen__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule19__posgen__ngen__nind",  word1, blank1,  word2, blank2,  word3); } 
		word1.tlSet(attr_lemh, TransferWord.copycase(word3.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_set_gender2(out, word2, " ", word1);
		macro_out_ndef(out, word3, " ", word1);
		out.append(blank1);
		out.append("^til<pr>$ ");
		macro_out_ndef(out, word2, blank1, word2);
		out.append(blank2);
		macro_out_posgen(out, word1);
	}
	
	// POSGEN ADJ NGEN NIND: min sorte katts snute => snuten til den svarte katten min
	public void rule20__posgen__adj__ngen__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule20__posgen__adj__ngen__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		word1.tlSet(attr_lemh, TransferWord.copycase(word4.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		macro_out_ndef(out, word4, " ", word1);
		out.append(blank1);
		out.append("^til<pr>$ ^den<det><dem>");
		out.append(var_det_gender);
		out.append(var_number_no_sp);
		out.append("$ ");
		macro_out_adj(out, word2);
		out.append(blank2);
		macro_out_ndef(out, word3, blank2, word3);
		out.append(blank3);
		macro_out_posgen(out, word1);
	}
	
	// POSGEN NGEN ADJ NIND: min katts hvite snute => den kvite snuten til katten min
	public void rule21__posgen__ngen__adj__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule21__posgen__ngen__adj__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		word1.tlSet(attr_lemh, TransferWord.copycase(word4.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_set_gender3(out, word2, " ", word1, blank2, word3);
		out.append('^');
		out.append(TransferWord.copycase(word1.sl(attr_lem), "den"));
		out.append("<det><dem>");
		out.append(var_det_gender);
		out.append(var_number_no_sp);
		out.append("$ ");
		macro_out_adj(out, word3);
		out.append(blank1);
		macro_out_ndef(out, word4, blank3, word4);
		out.append(blank2);
		out.append("^til<pr>$ ");
		macro_out_ndef(out, word2, blank1, word2);
		out.append(blank3);
		macro_out_posgen(out, word1);
	}
	
	/**  DETNONPOS* ADJ* NGEN ADJ* NIND:  */
	// DETNONPOS NGEN NIND: en katts snute => snuten til ein katt
	public void rule22__detnonpos__ngen__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule22__detnonpos__ngen__nind",  word1, blank1,  word2, blank2,  word3); } 
		macro_set_gender2(out, word2, " ", word1);
		word1.tlSet(attr_lemh, TransferWord.copycase(word3.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_out_ndef(out, word3, " ", word1);
		out.append(blank1);
		out.append("^til<pr>$ ");
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
		out.append(blank2);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
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
	}
	
	// DETNONPOS ADJ NGEN NIND: en sort katts snute => snuten til ein svart katt                                            den nye Lamaens bil => bilen til den nye Lamaen
	public void rule23__detnonpos__adj__ngen__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule23__detnonpos__adj__ngen__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		word1.tlSet(attr_lemh, TransferWord.copycase(word4.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		macro_out_ndef(out, word4, " ", word1);
		out.append(blank1);
		out.append("^til<pr>$ ");
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
		out.append(blank2);
		macro_out_adj(out, word2);
		out.append(blank3);
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
			         +word3.tl(attr_art)
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
	
	// DETNONPOS DETNONPOS NGEN NIND: den neste Lamaens bil => bilen til den neste Lamaen                                                   hver en Lamas bil => bilen til kvar ein Lama                                                   (vel... logisk tvitydig, er det ikkje?)
	public void rule24__detnonpos__detnonpos__ngen__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule24__detnonpos__detnonpos__ngen__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		word1.tlSet(attr_lemh, TransferWord.copycase(word4.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_out_ndef(out, word4, " ", word1);
		macro_set_gender2(out, word3, " ", word1);
		out.append(blank1);
		out.append("^til<pr>$ ");
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
		out.append(blank2);
		macro_set_gender2(out, word3, blank1, word2);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
		out.append(blank3);
		{
			String myword = 
			         word3.tl(attr_lemh)
			         +word3.tl(attr_a_nom)
			         +word3.tl(attr_gen)
			         +word3.tl(attr_nbr)
			         +word3.tl(attr_art)
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
	
	// DETNONPOS NGEN ADJ NIND: en katts hvite snute => den kvite snuten til ein katt                                             forrige århundres største filosofer => dei største filosofane til forrige århundre                    (ja, me burde ha ein måte å velje preposisjon)                    Merk at «en katts hvite hus» er tvitydig mellom sg/pl, så me nyttar set_gender1 først.
	public void rule25__detnonpos__ngen__adj__nind(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule25__detnonpos__ngen__adj__nind",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		word1.tlSet(attr_lemh, TransferWord.copycase(word4.tl(attr_lemh), word1.tl(attr_lemh)));
		macro_set_gender1(out, word4);
		out.append('^');
		out.append(TransferWord.copycase(word1.sl(attr_lem), "den"));
		out.append("<det><dem>");
		out.append(var_det_gender);
		out.append(var_number_no_sp);
		out.append("$ ");
		macro_out_adj(out, word3);
		out.append(blank1);
		macro_out_ndef(out, word4, blank3, word4);
		macro_set_gender2(out, word2, " ", word1);
		out.append(blank2);
		out.append("^til<pr>$ ");
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
		out.append(blank3);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
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
	}
	
	/**  Other determiner/noun phrases  */
	// DET: en => ein      Frequency is on our side, but politically incorrect..hmm..
	public void rule26__det(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule26__det",  word1); } 
		macro_set_gender1(out, word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
	public void rule27__det__nacr(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule27__det__nacr",  word1, blank1,  word2); } 
		macro_set_gender1(out, word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
	
	// NDEF DETPOS: jenten min => jenta mi
	public void rule28__ndef__detpos(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule28__ndef__detpos",  word1, blank1,  word2); } 
		macro_set_gender2(out, word1, blank1, word2);
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
			         +word2.tl(attr_a_det)
			         +var_det_gender
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
	}
	
	// DET NOM: en kvinne => ei kvinne               hvilken jente => kva for ei jente        egne hus => eigne hus        et Norge => eit Noreg                             dette hus => dette huset             np får ikkje noko tal i den siste.
	public void rule29__det__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule29__det__nom",  word1, blank1,  word2); } 
		macro_set_gender2(out, word2, " ", word1);
		macro_set_n_defness(out, word2, " ", word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
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
		out.append(blank1);
		{
			String myword = 
			         word2.tl(attr_lemh)
			         +word2.tl(attr_a_nom)
			         +word2.tl(attr_gen)
			         +word2.tl(attr_nbr)
			         +var_n_defness
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
	
	/**  Adjectives  */
	// ADJ: åpne (hus) => opne (hus), liten(f) => lita
	public void rule30__adj(Appendable out, TransferWord word1) throws IOException
	{
		if (debug) { logCall("rule30__adj",  word1); } 
		macro_set_number1(out, word1);
		macro_out_adj(out, word1);
	}
	
	// ADJ NOM: liten bok => lita bok               hele Norge => heile Noreg             np får ikkje noko tal i den siste.      We let CG disambiguate art and nbr using the following noun,      o/w all info should be in the adjective wordform (eg. in the above      example, hus being ind should give plural).                                        We include case here since this should catch proper as well as common nouns,                    and earlier rules should catch any _possessive_ noun phrases.
	public void rule31__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule31__adj__nom",  word1, blank1,  word2); } 
		macro_set_gender3(out, word2, " ", word1, " ", word1);
		macro_set_n_defness(out, word2, " ", word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_adj)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
			         +var_n_defness
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
	
	// DET ADJ: en liten(f) => ei lita 
	public void rule32__det__adj(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("rule32__det__adj",  word1, blank1,  word2); } 
		macro_set_gender1(out, word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
		macro_out_adj(out, word2);
	}
	
	// DETNONPOS ADJ NOM: en(mf) viktig(mf) dag(m) => ein(m) viktig(mf) dag(m)                                       denne viktige dag => denne viktige dagen      Note that the adjective might have different gender specificity from the      determiner; so we have an extra test to set adj_gender.                                        We include case here since this should catch proper as well as common nouns,                    and earlier rules should catch any _possessive_ noun phrases.
	public void rule33__detnonpos__adj__nom(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule33__detnonpos__adj__nom",  word1, blank1,  word2, blank2,  word3); } 
		macro_set_gender3(out, word3, " ", word1, blank1, word2);
		macro_set_n_defness(out, word3, " ", word1);
		{
			String myword = 
			         word1.tl(attr_lemh)
			         +word1.tl(attr_a_det)
			         +var_det_gender
			         +var_number
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
			         +word2.tl(attr_a_adj)
			         +var_adj_gender
			         +var_adj_number
			         +var_adj_defness
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
			         +var_n_defness
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
}
