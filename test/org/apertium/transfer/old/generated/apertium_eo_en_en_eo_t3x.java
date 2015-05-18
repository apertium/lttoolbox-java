package org.apertium.transfer.old.generated;
import java.io.*;
import org.apertium.transfer.*;
import org.apertium.transfer.generated.GeneratedTransferBase;
import org.apertium.interchunk.InterchunkWord;
public class apertium_eo_en_en_eo_t3x extends GeneratedTransferBase
{
	public boolean isOutputChunked()
	{
		return false;
	}
	ApertiumRE attr_a_nom = new ApertiumRE("<n(?:p|)>");
	ApertiumRE attr_a_nbr = new ApertiumRE("<(?:sg|pl|sp)>");
	ApertiumRE attr_a_gen = new ApertiumRE("<(?:mf|nt|GN|f|m)>");
	ApertiumRE attr_lem = new ApertiumRE("(([^<]|\"\\<\")+)");
	ApertiumRE attr_lemq = new ApertiumRE("\\#[- _][^<]+");
	ApertiumRE attr_lemh = new ApertiumRE("(([^<#]|\"\\<\"|\"\\#\")+)");
	ApertiumRE attr_whole = new ApertiumRE("(.+)");
	ApertiumRE attr_tags = new ApertiumRE("((<[^>]+>)+)");
	ApertiumRE attr_chname = new ApertiumRE("(\\{([^/]+)\\/)");
	ApertiumRE attr_chcontent = new ApertiumRE("(\\{.+)");
	ApertiumRE attr_content = new ApertiumRE("(\\{.+)");
	String var_paraula = "";
	String lu_count;
	
	private void macro_drop_gender1(Appendable out, InterchunkWord word1) throws IOException
	{
		if (debug) { logCall("macro_drop_gender1",  word1); } 
		if (word1.tl(attr_a_gen).equals("<GN>"))
		{
			word1.tlSet(attr_a_gen, "");
		}
	}
	
	// CHUNK: Ne-uzata regulo (nur cxar DEVAS esti unu cxi tie)
	public void rule0__nomxxxxxxx(Appendable out, InterchunkWord[] words, String[] blanks) throws IOException
	{
		if (debug) { logCall("rule0__nomxxxxxxx",  words[1]); } 
		lu_count = Integer.toString(words.length-1);
		/** <call-macro n="drop_gender1"><with-param pos="1"/></call-macro> */
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
