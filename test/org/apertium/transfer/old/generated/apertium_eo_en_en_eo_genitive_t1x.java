package org.apertium.transfer.old.generated;
import java.io.*;
import org.apertium.transfer.*;
import org.apertium.transfer.generated.GeneratedTransferBase;
public class apertium_eo_en_en_eo_genitive_t1x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return false;
	}
	ApertiumRE attr_nbr = new ApertiumRE("<(?:sp|sg|pl)>");
	ApertiumRE attr_lem = new ApertiumRE("(([^<]|\"\\<\")+)");
	ApertiumRE attr_lemq = new ApertiumRE("\\#[- _][^<]+");
	ApertiumRE attr_lemh = new ApertiumRE("(([^<#]|\"\\<\"|\"\\#\")+)");
	ApertiumRE attr_whole = new ApertiumRE("(.+)");
	ApertiumRE attr_tags = new ApertiumRE("((<[^>]+>)+)");
	ApertiumRE attr_chname = new ApertiumRE("(\\{([^/]+)\\/)");
	ApertiumRE attr_chcontent = new ApertiumRE("(\\{.+)");
	ApertiumRE attr_content = new ApertiumRE("(\\{.+)");
	String var_aposv = "[']";
	
	/**  Por rigardi, ĉu la blanko havas aŭ ne havas formaton.
     Tiu makroo estas necesa en la reguloj, en kiuj malaperas vorto por decidi,
     ĉu la blanko de la vorto devas esti forigita aŭ konservita.
     Se ĝi havas formaton, necesas konservi ĝin; se ne, indas viŝi,
     por ke ne aperu du sinsekvaj blankoj.

     Prenita de "f_bcond" apertium-en-es/apertium-en-es.es-en.t1x  */
	private void macro_sendu_blankon_se_havas_formaton2(Appendable out, TransferWord word1, String blank1, TransferWord word2) throws IOException
	{
		if (debug) { logCall("macro_sendu_blankon_se_havas_formaton2",  word1, blank1,  word2); } 
		if (!blank1.equals(" "))
		{
			out.append(blank1);
		}
	}
	
	public void rule0__apos__any__apos_aposgen(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
	{
		if (debug) { logCall("rule0__apos__any__apos_aposgen",  word1, blank1,  word2, blank2,  word3); } 
		out.append(var_aposv);
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
		macro_sendu_blankon_se_havas_formaton2(out, word2, blank2, word3);
		out.append(var_aposv);
	}
	
	public void rule1__apos__any__any__apos_aposgen(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
	{
		if (debug) { logCall("rule1__apos__any__any__apos_aposgen",  word1, blank1,  word2, blank2,  word3, blank3,  word4); } 
		out.append(var_aposv);
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
		macro_sendu_blankon_se_havas_formaton2(out, word3, blank3, word4);
		out.append(var_aposv);
	}
	
	public void rule2__apos__any__any__any__apos_aposgen(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
	{
		if (debug) { logCall("rule2__apos__any__any__any__apos_aposgen",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5); } 
		out.append(var_aposv);
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
		macro_sendu_blankon_se_havas_formaton2(out, word4, blank4, word5);
		out.append(var_aposv);
	}
	
	public void rule3__apos__any__any__any__any__apos_aposgen(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
	{
		if (debug) { logCall("rule3__apos__any__any__any__any__apos_aposgen",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6); } 
		out.append(var_aposv);
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
			         word5.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_sendu_blankon_se_havas_formaton2(out, word5, blank5, word6);
		out.append(var_aposv);
	}
	
	public void rule4__apos__any__any__any__any__any__apos_aposgen(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6, String blank6, TransferWord word7) throws IOException
	{
		if (debug) { logCall("rule4__apos__any__any__any__any__any__apos_aposgen",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6, blank6,  word7); } 
		out.append(var_aposv);
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
			         word5.tl(attr_whole)
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
			         word6.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		macro_sendu_blankon_se_havas_formaton2(out, word6, blank6, word7);
		out.append(var_aposv);
	}
	
	public void rule5__apos__any__any__any__any__any__any__apos_aposgen(Appendable out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6, String blank6, TransferWord word7, String blank7, TransferWord word8) throws IOException
	{
		if (debug) { logCall("rule5__apos__any__any__any__any__any__any__apos_aposgen",  word1, blank1,  word2, blank2,  word3, blank3,  word4, blank4,  word5, blank5,  word6, blank6,  word7, blank7,  word8); } 
		out.append(var_aposv);
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
			         word5.tl(attr_whole)
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
			         word6.tl(attr_whole)
			         ;
			if (myword.length()>0)
			{
				out.append('^');
				out.append(myword);
				out.append('$');
			}
		}
		out.append(blank6);
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
		macro_sendu_blankon_se_havas_formaton2(out, word7, blank7, word8);
		out.append(var_aposv);
	}
}
