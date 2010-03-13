/*
 * Copyright 2010 Jimmy O'Regan
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */

package org.apertium.charlifter;

/**
 * This class should be replaced, using the same mechanism as ACX
 * Starting with it, for simplicity's sake
 * @author jimregan
 */
public class Asciify {
    /**
     * # data taken from the table in transtab package:
     * # http://www.cl.cam.ac.uk/~mgk25/download/transtab.tar.gz
     * @param s UTF-8 string
     * @return ASCII-fied version
     */
    public static String toascii (String s) {
	// first batch are characters to delete - these need to get
	// added to charlifter script too...
	s.replaceAll("[\\x{A8}\\x{B4}\\x{B8}]", "");  // wipe out latin-1 diacriticals
	s.replaceAll("[\\p{M}]", "");  // important to wipe out ALL marks (start at 0x0300)
	s.replaceAll("[\\x{02B9}-\\x{02DD}]", "");  // "modifier letters"

	s.replaceAll("[\\x{02BB}]","'");  // correct "okina" in Hawaiian, Samoan, etc.
	s.replaceAll("[ʹʼ]","'");
	s.replaceAll("ˌ",",");
	s.replaceAll("ː",":");
	// some latin-1 range stuff:
	s.replaceAll("©","(C)");
	s.replaceAll("®","(R)");
	s.replaceAll("«","<<");
	s.replaceAll("»",">>");
	s.replaceAll("¼","1/4");
	s.replaceAll("½","1/2");
	s.replaceAll("¾","3/4");
	s.replaceAll("±","+/-");
	s.replaceAll("[\\x{A0}]"," ");  // nbsp
	s.replaceAll("[\\x{A1}]","!");  // inverted !
	s.replaceAll("[\\x{A7}]","\\S");  // section sign
	s.replaceAll("°","^o");
	s.replaceAll("[\\x{B2}]","^2");
	s.replaceAll("[\\x{B3}]","^3");
	s.replaceAll("[\\x{B9}]","^1");
	s.replaceAll("[\\x{B7}]","*");         // MIDDLE DOT
	         // Unicode general punc. block
	s.replaceAll("[\\x{2000}-\\x{200b}]"," ");   // all spaces even if thin or zero width!
	s.replaceAll("[\\x{200c}-\\x{200f}]","");   // L to R, R to L, markers etc.
	s.replaceAll("[\\x{2010}-\\x{2015}]","-");     // hyphens
	s.replaceAll("\\x{2016}","||");     // Double Vertical Line
	s.replaceAll("\\x{2017}","=");     // Double Low Line
	s.replaceAll("\\x{2018}","'");     // LEFT SINGLE QUOTATION MARK
	s.replaceAll("\\x{2019}","'");     // RIGHT SINGLE QUOTATION MARK
	s.replaceAll("\\x{201a}",",");     // SINGLE LOW 9 QUOTATION MARK
	s.replaceAll("\\x{201b}","'");     // SINGLE HIGH REVERSED 9 QUOTATION MARK
	s.replaceAll("\\x{201c}","\"");     // LEFT DOUBLE QUOTATION MARK
	s.replaceAll("\\x{201d}","\"");     // RIGHT DOUBLE QUOTATION MARK
	s.replaceAll("\\x{201e}",",,");    // DOUBLE LOW 9 QUOTATION MARK
	s.replaceAll("\\x{2022}","*");     // BULLET
	s.replaceAll("\\x{2025}","..");
	s.replaceAll("\\x{2026}","...");   // HORIZONTAL ELLIPSIS
	s.replaceAll("\\x{2027}",".");
	s.replaceAll("\\x{2030}","%");     // MILLE SIGN (close enough)
	s.replaceAll("[\\x{20AC}]","EUR");
	s.replaceAll("[ÀÁÂÃÄÅĀĂĄÅǍǞǠǺȀȂȦḀẠẢẤẦẨẪẬẮẰẲẴẶ]","A");
	s.replaceAll("[ÆǢǼ]","AE");
	s.replaceAll("[ḂƁƂƄḄḆ]","B");
	s.replaceAll("[ÇĆĈĊČƇḈ]","C");
	s.replaceAll("[ÐĎĐḊƉƊƋḌḎḐḒ]","D");
	s.replaceAll("[ǄǱ]","DZ");
	s.replaceAll("[ǅǲ]","Dz");
	s.replaceAll("[ÈÉÊËĒĔĖĘĚƐƎƏȄȆȨḔḖḘḚḜẸẺẼẾỀỂỄỆƏ]","E");
	s.replaceAll("[ḞƑ]","F");
	s.replaceAll("[ĜĞĠĢƓƔǤǦǴḠ]","G");
	s.replaceAll("[ĤĦȞḢḤḦḨḪ]","H");
	s.replaceAll("Ƕ","Hv");
	s.replaceAll("[ÌÍÎÏĨĪĬĮİƖƗǏȈȊḬḮỈỊ]","I");
	s.replaceAll("Ĳ","IJ");
	s.replaceAll("Ĵ","J");
	s.replaceAll("[ĶKƘǨḰḲḴ]","K");
	s.replaceAll("[ĹĻĽĿŁḶḸḺḼ]","L");
	s.replaceAll("Ǉ","LJ");
	s.replaceAll("ǈ","Lj");
	s.replaceAll("[ṀƜḾṂ]","M");
	s.replaceAll("[ÑŃŅŇŊƝǸṄṆṈṊ]","N");
	s.replaceAll("Ǌ","NJ");
	s.replaceAll("ǋ","Nj");
	s.replaceAll("[ÒÓÔÕÖØŌŎŐΩƆƟƠǑǪǬǾȌȎȪȬȮȰṌṎṐṒỌỎỐỒỔỖỘỚỜỞỠỢ]","O");
	s.replaceAll("Œ","OE");
	s.replaceAll("Ƣ","OI");
	s.replaceAll("[ṖƤṔ]","P");
	s.replaceAll("[ŔŖŘƦȐȒṘṚṜṞ]","R");
	s.replaceAll("[ŚŜŞŠȘṠƧƩṢṤṦṨ]","S");
	s.replaceAll("[ŢŤŦȚṪƬƮṬṮṰ]","T");
	s.replaceAll("Þ","Th");
	s.replaceAll("[ÙÚÛÜŨŪŬŮŰŲƯƱǓǕǗǙǛȔȖṲṴṶṸṺỤỦỨỪỬỮỰ]","U");
	s.replaceAll("[ṼṾƲ]","V");
	s.replaceAll("[ŴẀẂẄẆẈ]","W");
	s.replaceAll("[ẊẌ]","X");
	s.replaceAll("[ÝŶŸỲƳȲẎỴỶỸ]","Y");
	s.replaceAll("[ŹŻŽƵƷƸǮȤẐẒẔ]","Z");
	s.replaceAll("ˆ","^");
	s.replaceAll("[ʻʽ]","`");
	s.replaceAll("[ªàáâãäåāăąǎǟǡǻȁȃȧḁẚạảấầẩẫậắằẳẵặ]","a");
	s.replaceAll("[æǣǽ]","ae");
	s.replaceAll("[ḃƀƃƅɓ̄ḅḇ]","b");
	s.replaceAll("[çćĉċčƈḉ]","c");
	s.replaceAll("[ðďđḋƌƍɗḍḏḑḓɖ]","d");
	s.replaceAll("[ǆǳ]","dz");
	s.replaceAll("[èéêëēĕėęěɛǝȅȇȩḕḗḙḛḝẹẻẽếềểễệə]","e");
	s.replaceAll("[ƒḟẛ]","f");
	s.replaceAll("ﬀ","ff");
	s.replaceAll("ﬃ","ffi");
	s.replaceAll("ﬄ","ffl");
	s.replaceAll("ﬁ","fi");
	s.replaceAll("ﬂ","fl");
	s.replaceAll("[ĝğġģǥǧǵḡɣ]","g");
	s.replaceAll("[ĥħȟḣḥḧḩḫẖ]","h");
	s.replaceAll("ƕ","hv");
	s.replaceAll("[ìíîïĩīĭįıǐȉȋḭḯỉịɩ]","i");
	s.replaceAll("ĳ","ij");
	s.replaceAll("[ĵǰ]","j");
	s.replaceAll("[ķĸƙǩḱḳḵ]","k");
	s.replaceAll("[ĺļľŀłℓƚƛḷḹḻḽ]","l");
	s.replaceAll("ǉ","lj");
	s.replaceAll("[ṁḿṃ]","m");
	s.replaceAll("[ñńņňŉŋⁿƞǹṅṇṉṋɲ]","n");
	s.replaceAll("ǌ","nj");
	s.replaceAll("[ºòóôõöøōŏőɔơǒǫǭǿȍȏȫȭȯȱṍṏṑṓọỏốồổỗộớờởỡợ]","o");
	s.replaceAll("œ","oe");
	s.replaceAll("ƣ","oi");
	s.replaceAll("ṗƥṕ]","p");
	s.replaceAll("ŕŗřȑȓṙṛṝṟ]","r");
	s.replaceAll("[śŝşšſșṡƨṣṥṧṩ]","s");
	s.replaceAll("ß", "ss");
	s.replaceAll("[ﬅﬆ]","st");
	s.replaceAll("[ţťŧțṫƫƭṭṯṱẗ]","t");
	s.replaceAll("þ","th");
	s.replaceAll("[µùúûüũūŭůűųưǔǖǘǚǜȕȗṳṵṷṹṻụủứừửữự]","u");
	s.replaceAll("[ṽṿʋ]","v");
	s.replaceAll("[ŵẁẃẅẇẉẘ]","w");
	s.replaceAll("[ẋẍ]","x");
	s.replaceAll("[ýÿŷỳƴȳẏẙỵỷỹ]","y");
	s.replaceAll("[źżžƶƹƺǯȥẑẓẕ]","z");

        return s;
    }

}
