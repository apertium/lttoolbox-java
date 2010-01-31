package org.apertium.transfer.generated;
import java.util.*;
import java.io.*;
import org.apertium.transfer.*;
public class apertium_eo_en_en_eo_t1x {
ApertiumRE attr_a_nom = new ApertiumRE("<n>|<n><acr>|<n><acr><re>|<np>|<np><al>|<np><ant>|<np><cog>|<np><top>");
ApertiumRE attr_a_acr = new ApertiumRE("<acr>|<acr><re>|<np><al>|<np><top>");
ApertiumRE attr_a_any = new ApertiumRE("<n>|<np>");
ApertiumRE attr_a_prp = new ApertiumRE("<pr>");
ApertiumRE attr_a_adj = new ApertiumRE("<adj>|<adj><pst>|<adj><sint><comp>|<adj><sint><sup>|<adj><itg>|<adj><pos>");
ApertiumRE attr_a_vrb = new ApertiumRE("<vblex>|<vblex><sep>|<vbser>|<vaux>");
ApertiumRE attr_a_det = new ApertiumRE("<det><def>|<det><ind>|<det><pos>|<det><qnt>|<det><itg>|<det><qnt>|<det><dem>");
ApertiumRE attr_a_prn = new ApertiumRE("<prn>|<prn><ref>|<prn><itg>|<prn><subj>|<prn><obj>|<prn><tn>");
ApertiumRE attr_a_prn__sen__subj_obj = new ApertiumRE("<prn>|<prn><ref>|<prn><itg>|<prn><tn>");
ApertiumRE attr_a_tns = new ApertiumRE("<pri>|<imp>|<pp>|<pres>|<inf>|<cni>|<ger>|<subs>|<pprs>|<fti>|<past>");
ApertiumRE attr_a_gen = new ApertiumRE("<m>|<f>|<nt>|<mf>|<GD>");
ApertiumRE attr_a_prs = new ApertiumRE("<p1>|<p2>|<p3>");
ApertiumRE attr_a_nbr = new ApertiumRE("<sp>|<sg>|<pl>|<ND>");
ApertiumRE attr_a_cas = new ApertiumRE("<nom>|<acc>");
ApertiumRE attr_a_np_acr = new ApertiumRE("<np>|<acr>");
public void initAttrLists(ApertiumRE[] attrList) {
attr_a_nom = attrList[0];
attr_a_acr = attrList[1];
attr_a_any = attrList[2];
attr_a_prp = attrList[3];
attr_a_adj = attrList[4];
attr_a_vrb = attrList[5];
attr_a_det = attrList[6];
attr_a_prn = attrList[7];
attr_a_prn__sen__subj_obj = attrList[8];
attr_a_tns = attrList[9];
attr_a_gen = attrList[10];
attr_a_prs = attrList[11];
attr_a_nbr = attrList[12];
attr_a_cas = attrList[13];
attr_a_np_acr = attrList[14];
}
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

void macro_firstWord(Writer out, TransferWord word1) throws IOException
{
if ((((var_EOS).equals("true")
    && (word1.source(attr_a_np_acr, true)).equals(""))
    || (var_venontaVortoEstuMajuskla).equals("true")))
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

void macro_set_nomvar_if_known1(Writer out, TransferWord word1) throws IOException
{
if ((word1.target(attr_a_nbr, true)).equals(""))
{
var_nomvar = "";
}
else
{
var_nomvar = "<nom>";
}
}

void macro_ordigu_genron(Writer out, TransferWord word1) throws IOException
{
if ((word1.target(attr_a_gen, true)).equalsIgnoreCase("<GD>"))
{
word1.setTarget(attr_a_gen, "<m>", true);
}
}

void macro_set_numero1(Writer out, TransferWord word1) throws IOException
{
if ((word1.target(attr_a_nbr, true)).equals("<pl>"))
{
var_numero = "<pl>";
}
else
{
var_numero = "<sg>";
}
}

void macro_set_adjectiu2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_set_numero1(out, word2);
var_adjectiu = "";
var_preadv_added = "";
if ((word1.source(attr_a_adj, true)).equals("<adj><sint><comp>"))
{
var_adjectiu = (""+TransferWord.copycase(word1.source(attr_lem, true), "pli")+"<preadv>"+"$ ^"+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
var_preadv_added = "preadv_";
}
else
if ((word1.source(attr_a_adj, true)).equals("<adj><sint><sup>"))
{
var_adjectiu = (""+TransferWord.copycase(word1.source(attr_lem, true), "plej")+"<preadv>"+"$ ^"+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
var_preadv_added = "preadv_";
}
else
if ((word1.target(attr_a_adj, true)).equals("<adj>"))
{
var_adjectiu = (""+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
}
else
{
var_adjectiu = (""+word1.target(attr_lem, true)+"<adj>"+var_numero+"<2>");
}
}

void macro_set_tipus_verbs1(Writer out, TransferWord word1) throws IOException
{
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

void macro_set_verbkonj2_do(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
if (((word1.source(attr_a_tns, true)).equals("<pres>")
    || (word1.source(attr_a_tns, true)).equals("<inf>")))
{
var_macro_tmp1 = "<pres>";
}
else
if ((word1.source(attr_a_tns, true)).equals("<past>"))
{
var_macro_tmp1 = "<past>";
}
else
{
var_macro_tmp1 = (""+"<ERROR1_>"+word1.source(attr_a_tns, true));
}
var_verbkonj = (""+word2.target(attr_lemh, true)+word2.target(attr_a_vrb, true)+var_macro_tmp1+word2.target(attr_lemq, true));
}

void macro_set_verbkonj2_willShallWould(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
if (((word1.source(attr_lem, true)).equalsIgnoreCase("will")
    || (word1.source(attr_lem, true)).equalsIgnoreCase("shall")))
{
var_macro_tmp1 = "<fti>";
}
else
if ((word1.source(attr_lem, true)).equalsIgnoreCase("would"))
{
var_macro_tmp1 = "<cni>";
}
else
{
var_macro_tmp1 = (""+"<ERROR2_>"+word1.source(attr_a_tns, true));
}
var_verbkonj = (""+word2.target(attr_lemh, true)+word2.target(attr_a_vrb, true)+var_macro_tmp1+word2.target(attr_lemq, true));
}

void macro_set_temps1(Writer out, TransferWord word1) throws IOException
{
var_temps = "<UNKNOWN>";
if (((word1.source(attr_lem, true)).equalsIgnoreCase("will")
    || (word1.source(attr_lem, true)).equalsIgnoreCase("shall")))
{
var_temps = "<fti>";
}
else
if ((word1.source(attr_lem, true)).equalsIgnoreCase("would"))
{
var_temps = "<cni>";
}
else
if ((word1.source(attr_lem, true)).equalsIgnoreCase("have"))
{
var_temps = "<past>";
}
}

void macro_sendu_blankon_se_havas_formaton2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
if (!(blank1).equals(" "))
{
out.append(blank1);
}
}

void macro_set_blankon_se_havas_formaton2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
if ((blank1).equals(" "))
{
var_blanko = "";
}
else
{
var_blanko = blank1;
}
}

void macro_set_determiner3(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
if ((word1.source(attr_lem, true)).equalsIgnoreCase("a"))
{
if ((blank1).equals(" "))
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

void macro_set_determiner_de_genitivo2(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_set_numero1(out, word2);
if ((word1.source(attr_lem, true)).equalsIgnoreCase("a"))
{
var_determiner = "";
}
else
{
word1.setTarget(attr_lem, TransferWord.copycase("aa", word1.target(attr_lem, true)), true);
var_determiner = (""+"^"+word1.target(attr_lemh, true)+word1.target(attr_a_det, true)+var_numero+"<nom>"+word1.target(attr_lemq, true)+"$"+" ");
}
}

void macro_set_and_or_but(Writer out, TransferWord word1) throws IOException
{
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
macro_firstWord(out, word1);
macro_ordigu_genron(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "prnref"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: Prn
public void rule1__prnaltres(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
macro_set_numero1(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "prn"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_a_prn, true));
out.append(var_numero);
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: PrnPers
public void rule2__prnpers(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "prnpers"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

public void rule3__num(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "num"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

// July 2 - 2a de julio
public void rule4__monato__num_dato(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "dato"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word2.target(attr_lem, true));
out.append("a");
out.append("<num><ord>");
out.append('$');
out.append(" ");
out.append('^');
out.append("de");
out.append("<pr>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_tags, true));
out.append("<nom>");
out.append('$');
out.append("}$");
}

// July 2nd - 2a de julio
public void rule5__monato__num_ord(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "dato"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word2.target(attr_lem, true));
out.append("<num><ord>");
out.append('$');
out.append(" ");
out.append('^');
out.append("de");
out.append("<pr>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_tags, true));
out.append("<nom>");
out.append('$');
out.append("}$");
}

// on July 2 - la 2an de julio
public void rule6__on__monato__num_dato(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "dato"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append("la");
out.append("<det><def><sp>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word3.target(attr_lem, true));
out.append("an");
out.append("<num><ord>");
out.append('$');
out.append(" ");
out.append('^');
out.append("de");
out.append("<pr>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2.target(attr_tags, true));
out.append("<nom>");
out.append('$');
out.append("}$");
}

// on July 2nd - la 2a de julio
public void rule7__on__monato__num_ord(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "dato"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append("la");
out.append("<det><def><sp>");
out.append('$');
out.append('^');
out.append(word3.target(attr_lem, true));
out.append("n");
out.append("<num><ord>");
out.append('$');
out.append(blank1);
out.append(" ");
out.append('^');
out.append("de");
out.append("<pr>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2.target(attr_tags, true));
out.append("<nom>");
out.append('$');
out.append("}$");
}

// REGLA NUM of      5 of => 5 el 
public void rule8__num_sen_ord__of(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "num"));
out.append("<SN>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
out.append(blank1);
out.append("^pr");
out.append("<PREP>");
out.append('{');
out.append('^');
out.append("el");
out.append("<pr>");
out.append('$');
out.append("}$");
}

// REGLA NUM times NUM  5 times 8 => 5 oble 8 
public void rule9__num_sen_ord__times__num_sen_ord(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "num"));
out.append("<SN>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append(blank1);
out.append('^');
out.append("oble");
out.append("<cnjadv>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_whole, true));
out.append('$');
out.append("}$");
}

// REGLA NUM time   5 times => 5 fojoj, 5th time => 5a fojo,   
public void rule10__num__times(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "num"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append(blank1);
out.append('^');
out.append("fojo");
out.append("<n>");
out.append(word2.target(attr_a_nbr, true));
out.append("<nom>");
out.append('$');
out.append("}$");
}

// REGLA: DET:a  - the derminier 'a' should just be deleted. Having this rule makes it possible to avoid handling 'a' in all the other rules
public void rule11__a(Writer out, TransferWord word1) throws IOException
{
if ((word1.source(attr_lem, true)).equals("A"))
{
var_venontaVortoEstuMajuskla = "true";
}
var_EOS = "false";
}

// REGLA: DET the, his, ... (alia ol 'a')
public void rule12__det(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "det"));
out.append("<SD><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_lemh, true));
out.append(word1.target(attr_tags, true));
out.append("<2>");
out.append(word1.target(attr_lemq, true));
out.append('$');
out.append("}$");
}

// REGLA: NOM
public void rule13__nom(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
macro_ordigu_genron(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "nom"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: more NOM, f.eks. 'more tea'  to 'Pli da teo'
public void rule14__more__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
macro_ordigu_genron(out, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "more_nom"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append("<nom>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_whole, true));
out.append("<nom>");
out.append('$');
out.append("}$");
}

// REGLA: DET NOM
public void rule15__det__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
macro_ordigu_genron(out, word2);
macro_set_determiner3(out, word1, blank1, word2, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "det_nom"));
out.append("<SN><nom>");
out.append('{');
out.append(var_determiner);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: DET NOM NOM (nova)  la testaj firmaoj
public void rule16__det__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
macro_ordigu_genron(out, word2);
macro_ordigu_genron(out, word3);
macro_set_determiner3(out, word1, blank1, word2, blank2, word3);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "det_2nom"));
out.append("<SN><nom>");
out.append('{');
out.append(var_determiner);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append("<adj>");
out.append(word2.target(attr_a_acr, true));
out.append(word2.target(attr_a_gen, true));
out.append(word3.target(attr_a_nbr, true));
out.append("<2>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lem, true));
out.append(word3.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: DET NOM NOM NOM 
public void rule17__det__nom__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
{
macro_firstWord(out, word1);
macro_ordigu_genron(out, word2);
macro_ordigu_genron(out, word3);
macro_ordigu_genron(out, word4);
macro_set_determiner3(out, word1, blank1, word2, blank3, word4);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "det_3nom"));
out.append("<SN><nom>");
out.append('{');
out.append(var_determiner);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append("<adj>");
out.append(word2.target(attr_a_acr, true));
out.append(word2.target(attr_a_gen, true));
out.append(word4.target(attr_a_nbr, true));
out.append("<2>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lem, true));
out.append("<adj>");
out.append(word3.target(attr_a_acr, true));
out.append(word3.target(attr_a_gen, true));
out.append(word4.target(attr_a_nbr, true));
out.append("<2>");
out.append('$');
out.append(blank3);
out.append('^');
out.append(word4.target(attr_lem, true));
out.append(word4.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: DET NOM NOM NOM NOM
public void rule18__det__nom__nom__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
{
macro_firstWord(out, word1);
macro_ordigu_genron(out, word2);
macro_ordigu_genron(out, word3);
macro_ordigu_genron(out, word4);
macro_ordigu_genron(out, word5);
macro_set_determiner3(out, word1, blank1, word2, blank4, word5);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "det_4nom"));
out.append("<SN><nom>");
out.append('{');
out.append(var_determiner);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append("<adj>");
out.append(word2.target(attr_a_acr, true));
out.append(word2.target(attr_a_gen, true));
out.append(word5.target(attr_a_nbr, true));
out.append("<2>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lem, true));
out.append("<adj>");
out.append(word3.target(attr_a_acr, true));
out.append(word3.target(attr_a_gen, true));
out.append(word5.target(attr_a_nbr, true));
out.append("<2>");
out.append('$');
out.append(blank3);
out.append('^');
out.append(word4.target(attr_lem, true));
out.append("<adj>");
out.append(word4.target(attr_a_acr, true));
out.append(word4.target(attr_a_gen, true));
out.append(word5.target(attr_a_nbr, true));
out.append("<2>");
out.append('$');
out.append(blank4);
out.append('^');
out.append(word5.target(attr_lem, true));
out.append(word5.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: ADJ
public void rule19__adj(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
macro_set_adjectiu2(out, word1, " ", word1);
macro_ordigu_genron(out, word1);
var_chunk_name = (""+"adj"+var_preadv_added);
out.append("^"+TransferWord.copycase(var_caseFirstWord, var_chunk_name));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(var_adjectiu);
out.append('$');
out.append("}$");
}

// REGLA: DET ADJ NOM
public void rule20__det__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
macro_ordigu_genron(out, word3);
macro_set_adjectiu2(out, word2, blank2, word3);
macro_set_determiner3(out, word1, blank1, word2, blank2, word3);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "det_preadv?_adj_nom"));
out.append("<SN><nom>");
out.append('{');
out.append(var_determiner);
out.append('^');
out.append(var_adjectiu);
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lem, true));
out.append(word3.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: ADJ NOM
public void rule21__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
macro_set_adjectiu2(out, word1, blank1, word2);
macro_ordigu_genron(out, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "preadv?_adj_nom"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(var_adjectiu);
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: ADJ ADJ NOM
public void rule22__adj__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
macro_set_adjectiu2(out, word1, blank2, word3);
macro_ordigu_genron(out, word3);
var_tmp1 = var_preadv_added;
var_tmp2 = var_adjectiu;
macro_set_adjectiu2(out, word2, blank2, word3);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "preadv?_adj_adj_nom"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(var_tmp2);
out.append('$');
out.append(blank1);
out.append('^');
out.append(var_adjectiu);
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lem, true));
out.append(word3.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: DET UNKNOWN/ADV/NUM UNKNOWN/ADV/NUM NOM
public void rule23__det__unknown_adv_num__unknown_adv_num__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
{
macro_firstWord(out, word1);
macro_ordigu_genron(out, word4);
macro_set_determiner3(out, word1, blank1, word2, blank3, word4);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "det_unkn_unkn_nom"));
out.append("<SN><nom>");
out.append('{');
out.append(var_determiner);
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_whole, true));
out.append('$');
out.append(blank3);
out.append('^');
out.append(word4.target(attr_lem, true));
out.append(word4.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: DET ADJ ADJ NOM
public void rule24__det__adj__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
{
macro_firstWord(out, word1);
macro_ordigu_genron(out, word4);
macro_set_adjectiu2(out, word2, blank3, word4);
var_tmp1 = var_adjectiu;
macro_set_adjectiu2(out, word3, blank3, word4);
macro_set_determiner3(out, word1, blank1, word2, blank3, word4);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "det_preadv?_adj_adj_nom"));
out.append("<SN><nom>");
out.append('{');
out.append(var_determiner);
out.append('^');
out.append(var_tmp1);
out.append('$');
out.append(blank2);
out.append('^');
out.append(var_adjectiu);
out.append('$');
out.append(blank3);
out.append('^');
out.append(word4.target(attr_lem, true));
out.append(word4.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: DET ADJ ADJ ADJ NOM
public void rule25__det__adj__adj__adj__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
{
macro_firstWord(out, word1);
macro_ordigu_genron(out, word5);
macro_set_adjectiu2(out, word2, blank4, word5);
var_tmp1 = var_adjectiu;
macro_set_adjectiu2(out, word3, blank4, word5);
var_tmp2 = var_adjectiu;
macro_set_adjectiu2(out, word4, blank4, word5);
macro_set_determiner3(out, word1, blank1, word2, blank4, word5);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "det_preadv?_adj_adj_adj_nom"));
out.append("<SN><nom>");
out.append('{');
out.append(var_determiner);
out.append('^');
out.append(var_tmp1);
out.append('$');
out.append(blank2);
out.append('^');
out.append(var_tmp2);
out.append('$');
out.append(blank3);
out.append('^');
out.append(var_adjectiu);
out.append('$');
out.append(blank4);
out.append('^');
out.append(word5.target(attr_lem, true));
out.append(word5.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: NOM NOM   - testaj firmaoj (nova provo)
public void rule26__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
macro_ordigu_genron(out, word1);
macro_ordigu_genron(out, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "nom_nom"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append("<adj>");
out.append(word1.target(attr_a_acr, true));
out.append(word1.target(attr_a_gen, true));
out.append(word2.target(attr_a_nbr, true));
out.append("<2>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: ANT
public void rule27__ant_cog(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "ant"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: ANT ANT
public void rule28__ant_cog__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "ant_cog"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: ANT ANT ANT
public void rule29__ant_cog__ant_cog__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "ant_cog"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lem, true));
out.append(word3.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: ANT ANT ANT ANT
public void rule30__ant_cog__ant_cog__ant_cog__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "ant_ant_cog_cog"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lem, true));
out.append(word3.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank3);
out.append('^');
out.append(word4.target(attr_lem, true));
out.append(word4.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: ANT - ANT ANT
public void rule31__ant_cog__guio__ant_cog__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "ant-ant_cog"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lem, true));
out.append(word3.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank3);
out.append('^');
out.append(word4.target(attr_lem, true));
out.append(word4.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: ANT ANT - ANT
public void rule32__ant_cog__ant_cog__guio__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "ant_cog-cog"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_whole, true));
out.append('$');
out.append(blank3);
out.append('^');
out.append(word4.target(attr_lem, true));
out.append(word4.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: ANT - ANT ANT - ANT
public void rule33__ant_cog__guio__ant_cog__ant_cog__guio__ant_cog(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5, String blank5, TransferWord word6) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "ant-ant_cog-cog"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lem, true));
out.append(word3.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank3);
out.append('^');
out.append(word4.target(attr_lem, true));
out.append(word4.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank4);
out.append('^');
out.append(word5.target(attr_whole, true));
out.append('$');
out.append(blank5);
out.append('^');
out.append(word6.target(attr_lem, true));
out.append(word6.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append("}$");
}

// REGLA: NOM/ANT 's NOM:  gardener's dog => la hundo de gxardenisto
public void rule34__genitive_possessors__gen__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
macro_set_nomvar_if_known1(out, word1);
macro_ordigu_genron(out, word1);
macro_ordigu_genron(out, word3);
macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "nom_gen_nom"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word3.target(attr_lem, true));
out.append(word3.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(var_blanko);
out.append(" ");
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1 .target(attr_tags, true));
out.append(var_nomvar);
out.append('$');
out.append("}$");
}

// REGLA: NOM/ANT 's NOM:  gardener's dog => hundo de gxardenisto
public void rule35__genitive_possessors__gen__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
macro_set_nomvar_if_known1(out, word1);
macro_ordigu_genron(out, word1);
macro_ordigu_genron(out, word3);
macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "nom_gen_nom"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word3.target(attr_lem, true));
out.append(word3.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(var_blanko);
out.append(" ");
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1 .target(attr_tags, true));
out.append(var_nomvar);
out.append('$');
out.append("}$");
}

// REGLA: NOM/ANT 's NOM NOM:  gardener's dog house => hunda domo de gxardenisto
public void rule36__genitive_possessors__gen__nom__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
{
macro_firstWord(out, word1);
macro_set_nomvar_if_known1(out, word1);
macro_ordigu_genron(out, word1);
macro_ordigu_genron(out, word3);
macro_ordigu_genron(out, word4);
macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "n_n_de_n"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word3.target(attr_lem, true));
out.append("<adj>");
out.append(word3.target(attr_a_acr, true));
out.append(word3.target(attr_a_gen, true));
out.append(word4.target(attr_a_nbr, true));
out.append("<2>");
out.append('$');
out.append(var_blanko);
out.append(" ");
out.append('^');
out.append(word4.target(attr_lem, true));
out.append(word4.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank3);
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1 .target(attr_tags, true));
out.append(var_nomvar);
out.append('$');
out.append("}$");
}

// REGLA: DET NOM/ANT 's NOM:  his gardener's dog => la hundo de lia gxardenisto
public void rule37__det__genitive_possessors__gen__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
{
macro_firstWord(out, word1);
macro_set_nomvar_if_known1(out, word2);
macro_ordigu_genron(out, word2);
macro_ordigu_genron(out, word4);
macro_set_determiner_de_genitivo2(out, word1, blank1, word2);
word1.setTarget(attr_lem, TransferWord.copycase("aa", word1.target(attr_lem, true)), true);
macro_set_blankon_se_havas_formaton2(out, word1, blank1, word2);
var_tmp2 = var_blanko;
macro_set_blankon_se_havas_formaton2(out, word2, blank2, word3);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "det_nom_gen_det_nom"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(TransferWord.copycase(word1.source(attr_lem, true), "la"));
out.append("<det><def><sp>");
out.append('$');
out.append(var_tmp2);
out.append(" ");
out.append('^');
out.append(word4.target(attr_lem, true));
out.append(word4.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(var_blanko);
out.append(" ");
out.append('^');
out.append(word3.target(attr_whole, true));
out.append('$');
out.append(blank3);
out.append(var_determiner);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2 .target(attr_tags, true));
out.append(var_nomvar);
out.append('$');
out.append("}$");
}

// REGLA: DET NOM/ANT NOM/ANT 's NOM:  his garden man's dog   - La hundo de lia ĝardeno viro 
public void rule38__det__genitive_possessors__genitive_possessors__gen__nom(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4, String blank4, TransferWord word5) throws IOException
{
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
out.append("^"+TransferWord.copycase(var_caseFirstWord, "det_nom_gen_det_nom_nom"));
out.append("<SN><nom>");
out.append('{');
out.append(var_tmp2);
out.append('^');
out.append(TransferWord.copycase(word1.source(attr_lem, true), "la"));
out.append("<det><def><sp>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word5.target(attr_lem, true));
out.append(word5.target(attr_tags, true));
out.append("<2>");
out.append('$');
out.append(var_blanko);
out.append(" ");
out.append('^');
out.append(word4.target(attr_whole, true));
out.append('$');
out.append(blank4);
out.append(var_determiner);
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2.target(attr_tags, true));
out.append(var_tmp1);
out.append('$');
out.append(" ");
out.append('^');
out.append(word3.target(attr_lem, true));
out.append(word3.target(attr_tags, true));
out.append(var_nomvar);
out.append('$');
out.append("}$");
}

// rekunu and, or kaj nor aparte - ĉar povas esti parto de listo de aferoj
public void rule39__and_or_nor(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
macro_set_and_or_but(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "and_or"));
out.append("<and_or>");
out.append(var_and_or_but);
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

public void rule40__cnjcoo(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
macro_set_and_or_but(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "cnjcoo"));
out.append("<CC>");
out.append(var_and_or_but);
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

public void rule41__cnjadv(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "cnjadv"));
out.append("<CA>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

public void rule42__cnjsub(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "CS"));
out.append("<NUM>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

public void rule43__cm(Writer out, TransferWord word1) throws IOException
{
out.append("^cm");
out.append("<CM>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

public void rule44__rel(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "rel"));
out.append("<REL>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

public void rule45__preadv(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "preadv"));
out.append("<PREADV>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

public void rule46__predet(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "predet"));
out.append("<PREDET>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

public void rule47__adv(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "adv"));
out.append("<Adv>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

public void rule48__pr(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "pr"));
out.append("<PREP>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

// REGLA: non-recognized genitive ('s) fallback :  XXX's YYY   => XXX'a YYY
public void rule49__gen(Writer out, TransferWord word1) throws IOException
{
out.append("^gen");
out.append("<GEN>");
out.append('{');
out.append('^');
out.append("a");
out.append("<gen>");
out.append('$');
out.append("}$");
}

// REGLA: SENT ;: - frazparto
public void rule50__sent_komopunkto_dupunkto(Writer out, TransferWord word1) throws IOException
{
out.append("^sent");
out.append("<S>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

// REGLA: SENT .?!  - fino de frazo
public void rule51__sent(Writer out, TransferWord word1) throws IOException
{
var_EOS = "true";
out.append("^sent");
out.append("<S>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

public void rule52__unknown(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "unknown"));
out.append("<SN><nom>");
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append("}$");
}

// REGLA: to VBLEXinf
public void rule53__to__vblexinf(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word2);
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "verbInf"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(word2.target(attr_a_tns, true));
out.append('{');
out.append('^');
out.append(word2.target(attr_lemh, true));
out.append(word2.target(attr_a_vrb, true));
out.append("<3>");
out.append(word2.target(attr_lemq, true));
out.append('$');
out.append("}$");
}

// REGLA: of VBLEXger - of being, of running, of looking - esti, kuri, vidi
public void rule54__of__vblexger(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word2);
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "verbInf"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append("<inf>");
out.append('{');
out.append('^');
out.append(word2.target(attr_lemh, true));
out.append(word2.target(attr_a_vrb, true));
out.append("<3>");
out.append(word2.target(attr_lemq, true));
out.append('$');
out.append("}$");
}

// REGLA: to have suffered  -  suferi
public void rule55__to__vbhaverinf__vblex_vbser(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word3);
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
macro_sendu_blankon_se_havas_formaton2(out, word2, blank2, word3);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "verbInf2"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append("<inf>");
out.append('{');
out.append('^');
out.append(word3.target(attr_lemh, true));
out.append(word3.target(attr_a_vrb, true));
out.append("<3>");
out.append(word3.target(attr_lemq, true));
out.append('$');
out.append("}$");
}

// REGLA: be VBLEXger
public void rule56__vbser__vblexger(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "be_vbger"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(word1.target(attr_a_tns, true));
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_a_vrb, true));
out.append("<3>");
out.append(word1.target(attr_lemq, true));
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_lemh, true));
out.append(word2.target(attr_a_vrb, true));
out.append(word2.target(attr_a_tns, true));
out.append(word2.target(attr_lemq, true));
out.append('$');
out.append("}$");
}

// REGLA: level out - elebenigi
public void rule57__vblex__out(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word1);
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "el_verb"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(word1.target(attr_a_tns, true));
out.append('{');
out.append('^');
out.append("el");
out.append("<adv>");
out.append('$');
out.append('^');
out.append(word1.target(attr_lemh, true));
out.append(word1.target(attr_a_vrb, true));
out.append("<3>");
out.append(word1.target(attr_lemq, true));
out.append('$');
out.append("}$");
}

// REGLA: VBSER not
public void rule58__vbser__not(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "ser_not"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(word1.target(attr_a_tns, true));
out.append('{');
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank1);
out.append('^');
out.append(word1.target(attr_lemh, true));
out.append(word1.target(attr_a_vrb, true));
out.append("<3>");
out.append(word1.target(attr_lemq, true));
out.append('$');
out.append("}$");
}

// RULE: please + vblex in present => please + vblex in infinitive
public void rule59__please__c_vblex_pres(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_set_tipus_verbs1(out, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "pls_verb1"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(word1.target(attr_a_tns, true));
out.append('{');
out.append('^');
out.append(word1.target(attr_lem, true));
out.append(word1.target(attr_a_vrb, true));
out.append("<3>");
out.append('$');
out.append("}$");
out.append(blank1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "pls_verb2"));
out.append(word2.target(attr_a_tns, true));
out.append('{');
out.append('^');
out.append(word2.target(attr_lem, true));
out.append(word2.target(attr_a_vrb, true));
out.append("<inf>");
out.append('$');
out.append("}$");
}

// REGLA: do ADV VERB (I do not think -> mi ne pensas. I do always think -> mi ja ĉiam pensas)
public void rule60__do__adv__infpres(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word3);
macro_set_verbkonj2_do(out, word1, blank2, word3);
if (!(word2.source(attr_lem, true)).equalsIgnoreCase("not"))
{
out.append("^"+TransferWord.copycase(var_caseFirstWord, "ja2"));
out.append("<Adv>");
out.append('{');
out.append('^');
out.append("ja");
out.append("<adv>");
out.append('$');
out.append("}$");
out.append(blank1);
var_caseFirstWord = "aa";
}
else
{
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
}
out.append("^"+TransferWord.copycase(var_caseFirstWord, "adv2"));
out.append("<Adv>");
out.append('{');
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append("}$");
out.append(blank2);
out.append("^verbcj");
out.append("<SV>");
out.append(var_tipus_verb);
out.append(word1.target(attr_a_tns, true));
out.append('{');
out.append('^');
out.append(var_verbkonj);
out.append('$');
out.append("}$");
}

// REGLA: do VERB (I do think -> mi ja pensas) 
public void rule61__do__infpres(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word2);
macro_set_verbkonj2_do(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "ja"));
out.append("<Adv>");
out.append('{');
out.append('^');
out.append("ja");
out.append("<adv>");
out.append('$');
out.append("}$");
out.append(blank1);
out.append("^verbcj2");
out.append("<SV>");
out.append(var_tipus_verb);
out.append(word1.target(attr_a_tns, true));
out.append('{');
out.append('^');
out.append(var_verbkonj);
out.append('$');
out.append("}$");
}

// REGLA: VAUX VBLEX
public void rule62__vaux_vbhaver__vblex_vbser(Writer out, TransferWord word1, String blank1, TransferWord word2) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word2);
if (list_willwouldshallhave.containsIgnoreCase(word1.source(attr_lem, true)))
{
macro_set_temps1(out, word1);
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "verb2"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(var_temps);
out.append('{');
out.append('^');
out.append(word2.target(attr_lemh, true));
out.append(word2.target(attr_a_vrb, true));
out.append("<3>");
out.append(word2.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
else
if ((((word1.source(attr_lem, true)).equalsIgnoreCase("can")
    && (word1.source(attr_a_tns, true)).equalsIgnoreCase("<past>"))
    || (word1.source(attr_lem, true)).equalsIgnoreCase("might")))
{
var_temps = "<cni>";
out.append("^"+TransferWord.copycase(var_caseFirstWord, "vaux_verb"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append("<inf>");
out.append('{');
out.append('^');
out.append("povi");
out.append("<vaux><cni>");
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_lemh, true));
out.append(word2.target(attr_a_vrb, true));
out.append("<3>");
out.append(word2.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
else
{
var_temps = word2.source(attr_a_tns, true);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "vaux_verb2"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(word1.target(attr_a_tns, true));
out.append('{');
out.append('^');
out.append(word1.target(attr_lemh, true));
out.append(word1.target(attr_a_vrb, true));
out.append("<3>");
out.append(word1.target(attr_lemq, true));
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_lemh, true));
out.append(word2.target(attr_a_vrb, true));
out.append(var_temps);
out.append(word2.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
}

// REGLA: VAUX ADV VBLEX
public void rule63__vaux_vbhaver__adv__vblex_vbser(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word3);
if (list_willwouldshallhave.containsIgnoreCase(word1.source(attr_lem, true)))
{
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
macro_set_temps1(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "verb3"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(var_temps);
out.append('{');
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lemh, true));
out.append(word3.target(attr_a_vrb, true));
out.append("<3>");
out.append(word3.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
else
if ((((word1.source(attr_lem, true)).equalsIgnoreCase("can")
    && (word1.source(attr_a_tns, true)).equalsIgnoreCase("<past>"))
    || (word1.source(attr_lem, true)).equalsIgnoreCase("might")))
{
var_temps = "<cni>";
out.append("^"+TransferWord.copycase(var_caseFirstWord, "vaux_verb3"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append("<inf>");
out.append('{');
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank1);
out.append('^');
out.append("povi");
out.append("<vaux><cni>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lemh, true));
out.append(word3.target(attr_a_vrb, true));
out.append("<3>");
out.append(word3.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
else
{
var_temps = word3.source(attr_a_tns, true);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "vaux_verb4"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(var_temps);
out.append('{');
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank1);
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lemh, true));
out.append(word3.target(attr_a_vrb, true));
out.append("<3>");
out.append(word3.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
}

// REGLA: VAUX ADV ADV VBLEX - have also abruptly changed - ankaŭ abrupte ŝanĝis
public void rule64__vaux_vbhaver__adv__adv__vblex_vbser(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3, String blank3, TransferWord word4) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word4);
if (list_willwouldshallhave.containsIgnoreCase(word1.source(attr_lem, true)))
{
macro_set_temps1(out, word1);
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "verb4"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(var_temps);
out.append('{');
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_whole, true));
out.append('$');
out.append(blank3);
out.append('^');
out.append(word4.target(attr_lemh, true));
out.append(word4.target(attr_a_vrb, true));
out.append("<3>");
out.append(word4.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
else
if ((((word1.source(attr_lem, true)).equalsIgnoreCase("can")
    && (word1.source(attr_a_tns, true)).equalsIgnoreCase("<past>"))
    || (word1.source(attr_lem, true)).equalsIgnoreCase("might")))
{
var_temps = "<cni>";
out.append("^"+TransferWord.copycase(var_caseFirstWord, "vaux_verb5"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append("<inf>");
out.append('{');
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank1);
out.append('^');
out.append(word3.target(attr_whole, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append("povi");
out.append("<vaux><cni>");
out.append('$');
out.append(blank3);
out.append('^');
out.append(word4.target(attr_lemh, true));
out.append(word4.target(attr_a_vrb, true));
out.append("<3>");
out.append(word4.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
else
{
var_temps = word4.source(attr_a_tns, true);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "vaux_verb6"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(var_temps);
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_whole, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_whole, true));
out.append('$');
out.append(blank3);
out.append('^');
out.append(word4.target(attr_lemh, true));
out.append(word4.target(attr_a_vrb, true));
out.append("<3>");
out.append(word4.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
}

// REGLA: VAUX VBHAVER VBLEX/VBSER - would have been,  would have ended,  might have allowed,  could have levelled out, may have represented,  might have been
public void rule65__vaux_vbhaver__vbhaver__vblex_vbser(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word3);
if (list_willwouldshallhave.containsIgnoreCase(word1.source(attr_lem, true)))
{
macro_set_temps1(out, word1);
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "verb_pp"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append("<pp3>");
out.append('{');
out.append('^');
out.append("esti");
out.append("<vbser>");
out.append(var_temps);
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lemh, true));
out.append(word3.target(attr_a_vrb, true));
out.append("<3>");
out.append(word3.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
else
if ((word1.source(attr_lem, true)).equalsIgnoreCase("may"))
{
var_temps = "<past>";
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "verb3a"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(var_temps);
out.append('{');
out.append('^');
out.append("eble");
out.append("<adv>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lemh, true));
out.append(word3.target(attr_a_vrb, true));
out.append("<3>");
out.append(word3.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
else
if ((word1.source(attr_lem, true)).equalsIgnoreCase("might"))
{
var_temps = "<cni>";
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "verb3b"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(var_temps);
out.append('{');
out.append('^');
out.append("eble");
out.append("<adv>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lemh, true));
out.append(word3.target(attr_a_vrb, true));
out.append("<3>");
out.append(word3.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
else
if (((word1.source(attr_lem, true)).equalsIgnoreCase("can")
    || (word1.source(attr_a_tns, true)).equals("past")))
{
var_temps = "<cni>";
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "vaux_pp"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append("<inf>");
out.append('{');
out.append('^');
out.append("povi");
out.append("<vaux><past>");
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lemh, true));
out.append(word3.target(attr_a_vrb, true));
out.append("<3>");
out.append(word3.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
else
{
var_temps = "<past>";
if ((word1.source(attr_lem, true)).equalsIgnoreCase("should"))
{
var_temps = "<cni>";
}
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "vaux_verb7"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(var_temps);
out.append('{');
out.append('^');
out.append(word1.target(attr_lemh, true));
out.append(word1.target(attr_a_vrb, true));
out.append("<3>");
out.append(word1.target(attr_lemq, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_lemh, true));
out.append(word3.target(attr_a_vrb, true));
out.append("<inf>");
out.append(word3.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
}

// REGLA: VAUX VBSER VBLEXGER
public void rule66__vaux_vbhaver__vbser__vblexger(Writer out, TransferWord word1, String blank1, TransferWord word2, String blank2, TransferWord word3) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word3);
if (list_willwouldshallhave.containsIgnoreCase(word1.source(attr_lem, true)))
{
macro_set_temps1(out, word1);
macro_sendu_blankon_se_havas_formaton2(out, word1, blank1, word2);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "verb_vbger"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(var_temps);
out.append('{');
out.append('^');
out.append(word2.target(attr_lemh, true));
out.append(word2.target(attr_a_vrb, true));
out.append("<3>");
out.append(word2.target(attr_lemq, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_whole, true));
out.append('$');
out.append("}$");
}
else
{
var_temps = word2.source(attr_a_tns, true);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "vaux_verb8"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(var_temps);
out.append('{');
out.append('^');
out.append(word1.target(attr_whole, true));
out.append('$');
out.append(blank1);
out.append('^');
out.append(word2.target(attr_lemh, true));
out.append(word2.target(attr_a_vrb, true));
out.append("<3>");
out.append(word2.target(attr_lemq, true));
out.append('$');
out.append(blank2);
out.append('^');
out.append(word3.target(attr_whole, true));
out.append('$');
out.append("}$");
}
}

public void rule67__vbdo(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "vbdo"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(word1.target(attr_a_tns, true));
out.append('{');
out.append('^');
out.append(word1.target(attr_lemh, true));
out.append(word1.target(attr_a_vrb, true));
out.append("<3>");
out.append(word1.target(attr_lemq, true));
out.append('$');
out.append("}$");
}

public void rule68__vb_all(Writer out, TransferWord word1) throws IOException
{
macro_firstWord(out, word1);
macro_set_tipus_verbs1(out, word1);
out.append("^"+TransferWord.copycase(var_caseFirstWord, "verb_all"));
out.append("<SV>");
out.append(var_tipus_verb);
out.append(word1.target(attr_a_tns, true));
out.append('{');
out.append('^');
out.append(word1.target(attr_lemh, true));
out.append(word1.target(attr_a_vrb, true));
out.append("<3>");
out.append(word1.target(attr_lemq, true));
out.append('$');
out.append("}$");
}
}
