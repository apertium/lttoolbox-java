
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.apertium.lttoolbox.process.FSTProcessor;
import org.apertium.transfer.ApertiumTransfer;
import org.apertium.transfer.ApertiumTransferCompile;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob Nordfalk
 */
public class Playground {

    public static void main(String[] args) throws IOException, Exception {
String[] fa = {
"/home/j/esperanto/a/apertium-eo-ca/apertium-eo-ca.ca-eo.t1x",
"/home/j/esperanto/a/apertium-eo-en/apertium-eo-en.en-eo.genitive.t1x",
"/home/j/esperanto/a/apertium-eo-en/apertium-eo-en.en-eo.t1x",
"/home/j/esperanto/a/apertium-eo-en/apertium-eo-en.eo-en.t1x",
"/home/j/esperanto/a/apertium-eo-es/apertium-eo-es.es-eo.t1x",


"/home/j/esperanto/a/apertium/incubator/apertium-eu-en/apertium-eu-en.eu-en.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-eu-en/apertium-eu-en.ordinals.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-eu-fr/apertium-eu-fr.eu-fr.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-eu-fr/apertium-eu-fr.ordinals.t1x",
"/home/j/esperanto/a/apertium-en-ca/apertium-en-ca.ca-en.t1x",
"/home/j/esperanto/a/apertium-en-ca/apertium-en-ca.en-ca.genitive.t1x",
"/home/j/esperanto/a/apertium-en-ca/apertium-en-ca.en-ca.t1x",
"/home/j/esperanto/a/apertium-en-ca/empty.t1x",
"/home/j/esperanto/a/apertium-en-es/apertium-en-es.en-es-vacio.t1x",
"/home/j/esperanto/a/apertium-en-es/apertium-en-es.en-es.t1x",
"/home/j/esperanto/a/apertium-en-es/apertium-en-es.es-en.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-ca-it/apertium-ca-it.ca-it.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-ca-it/apertium-ca-it.it-ca.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-af/apertium-en-af.af-en.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-af/apertium-en-af.en-af.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-de/apertium-en-de.de-en.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-fr/apertium-en-fr.en-fr.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-fr/apertium-en-fr.fr-en.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-hi/apertium-en-hi.en-hi.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-it/apertium-en-it.en-it.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-it/apertium-en-it.it-en.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-lv/apertium-en-lv.lv-en.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-nl/apertium-en-nl.en-nl.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-nl/apertium-en-nl.nl-en.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-pl/apertium-en-pl.en-pl.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-pt/apertium-en-pt.en-pt.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-en-pt/apertium-en-pt.pt-en.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-eo-fr/apertium-eo-fr.fr-eo.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-fo-is/apertium-fo-is.is-fo.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-hi-en-unicode/apertium-hi-en.hi-en.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-id-ms/apertium-id-ms.id-ms.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-ru-uk/apertium-ru-uk.ru-uk.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-ru-uk/apertium-ru-uk.uk-ru.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-sme-smj/apertium-sme-smj.sme-smj.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-tg-fa/apertium-tg-fa.fa-tg.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-tg-fa/apertium-tg-fa.tg-fa.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-tr-az/apertium-tr-az.az-tr.t1x",
"/home/j/esperanto/a/apertium/incubator/apertium-tr-az/apertium-tr-az.tr-az.t1x",
"/home/j/esperanto/a/apertium-fr-es/apertium-fr-es.es-fr.t1x",
"/home/j/esperanto/a/apertium-fr-es/apertium-fr-es.fr-es.t1x",
"/home/j/esperanto/a/apertium-is-en/apertium-is-en.is-en.t1x",
"/home/j/esperanto/a/apertium-ne-en/apertium-ne-en.en-ne.t1x",
"/home/j/esperanto/a/apertium-ne-en/apertium-ne-en.ne-en.t1x",
"/home/j/esperanto/a/apertium-nn-nb/apertium-nn-nb.nb-nn.t1x",
"/home/j/esperanto/a/apertium-nn-nb/apertium-nn-nb.nn-nb.t1x",
"/home/j/esperanto/a/apertium-sl-mk/apertium-sl-mk.mk-sl.t1x",
"/home/j/esperanto/a/apertium-sl-mk/apertium-sl-mk.sl-mk.t1x",
"/home/j/esperanto/a/apertium-sv-da/apertium-sv-da.da-sv.t1x",
"/home/j/esperanto/a/apertium-sv-da/apertium-sv-da.sv-da.t1x",
"/home/j/esperanto/a/apertium-sv-da/profiler/apertium-sv-da.da-sv.t1x",
"/home/j/esperanto/a/apertium-sv-da/profiler/apertium-sv-da.sv-da.t1x",
"/home/j/esperanto/a/lttoolbox-java/testdata/transfer/apertium-eo-en.en-eo.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-bn-en/apertium-bn-en.bn-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-bn-en/apertium-bn-en.en-bn.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-br-fr/apertium-br-fr.br-fr.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-br-fr/apertium-br-fr.pre-xfer-br.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-ca-ro/apertium-ca-ro.ca-ro.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-ca-ro/apertium-ca-ro.ro-ca.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-cy-en/apertium-cy-en.cy-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-cy-en/apertium-cy-en.en-cy.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-cy-en/apertium-cy-en.pre-cy.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-en-ca/apertium-en-ca.ca-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-en-ca/apertium-en-ca.en-ca.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-en-ca/empty.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-en-es/apertium-en-es.en-es-vacio.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-en-es/apertium-en-es.en-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-en-es/apertium-en-es.es-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-en-gl/apertium-en-gl.en-gl.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-en-gl/apertium-en-gl.gl-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-eo-ca/apertium-eo-ca.ca-eo.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-eo-en/apertium-eo-en.en-eo.genitive.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-eo-en/apertium-eo-en.en-eo.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-eo-en/apertium-eo-en.eo-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-eo-es/apertium-eo-es.es-eo.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-es-ast/apertium-es-ast.ast-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-es-ast/apertium-es-ast.es-ast.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-es-ast/apertium-es-ast.post-es-ast.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-es-gl/apertium-es-gl.es-gl.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-es-gl/apertium-es-gl.gl-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-es-it/apertium-es-it.es-it.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-es-it/apertium-es-it.it-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-es-ro/apertium-es-ro.es-ro.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-es-ssp/apertium-es-ssp.es-ssp.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-eu-es/apertium-eu-es.eu-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-eu-es/apertium-eu-es.ordinals.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-fr-ca/apertium-fr-ca.ca-fr.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-fr-ca/apertium-fr-ca.fr-ca.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-fr-es/apertium-fr-es.es-fr.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-fr-es/apertium-fr-es.fr-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-ga-gd/apertium-ga-gd.ga-gd.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-ga-gd/apertium-ga-gd.gd-ga.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-ga-gd/apertium-ga-gd.pre-ga.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-ga-gd/apertium-ga-gd.pre-gd.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-is-en/apertium-is-en.is-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-ne-en/apertium-ne-en.en-ne.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-ne-en/apertium-ne-en.ne-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-nn-nb/apertium-nn-nb.nb-nn.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-nn-nb/apertium-nn-nb.nn-nb.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-pt-ca/apertium-pt-ca.ca-pt.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-pt-ca/apertium-pt-ca.pt-ca.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-sh-mk/apertium-sh-mk.mk-sh.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-sh-mk/apertium-sh-mk.sh-mk.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-si-en/apertium-si-en.en-si.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-si-en/apertium-si-en.si-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-sl-mk/apertium-sl-mk.mk-sl.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-sl-mk/apertium-sl-mk.sl-mk.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-sv-da/apertium-sv-da.da-sv.t1x",
"/home/j/esperanto/apertium-svn/apertium/trunk/apertium-sv-da/apertium-sv-da.sv-da.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-bn-en/apertium-bn-en.bn-en.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-bn-en/apertium-bn-en.en-bn.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-ca-ro/apertium-ca-ro.ca-ro.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-ca-ro/apertium-ca-ro.ro-ca.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-en-es/apertium-en-es.en-es-vacio.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-en-es/apertium-en-es.en-es.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-en-es/apertium-en-es.es-en.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-en-gl/apertium-en-gl.en-gl.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-en-gl/apertium-en-gl.gl-en.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-eo-ca/apertium-eo-ca.ca-eo.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-eo-en/apertium-eo-en.en-eo.genitive.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-eo-en/apertium-eo-en.en-eo.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-eo-en/apertium-eo-en.eo-en.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-es-ast/apertium-es-ast.ast-es.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-es-ast/apertium-es-ast.es-ast.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-es-ast/apertium-es-ast.post-es-ast.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-es-ro/apertium-es-ro.es-ro.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-es-ssp/apertium-es-ssp.es-ssp.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-fr-es/apertium-fr-es.es-fr.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-fr-es/apertium-fr-es.fr-es.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-ga-gd/apertium-ga-gd.ga-gd.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-ga-gd/apertium-ga-gd.gd-ga.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-ga-gd/apertium-ga-gd.pre-ga.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-ga-gd/apertium-ga-gd.pre-gd.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-ne-en/apertium-ne-en.en-ne.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-ne-en/apertium-ne-en.ne-en.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-pt-ca/apertium-pt-ca.ca-pt.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-pt-ca/apertium-pt-ca.pt-ca.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-sh-mk/apertium-sh-mk.mk-sh.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-sh-mk/apertium-sh-mk.sh-mk.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-sl-mk/apertium-sl-mk.mk-sl.t1x",
"/home/j/esperanto/apertium-svn-https/apertium/trunk/apertium-sl-mk/apertium-sl-mk.sl-mk.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-br-fr/release-0.1.0/apertium-br-fr.br-fr.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-br-fr/release-0.1.0/apertium-br-fr.pre-xfer-br.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-cy-en/release-0.1.0/apertium-cy-en.cy-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-cy-en/release-0.1.0/apertium-cy-en.en-cy.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-cy-en/release-0.1.0/apertium-cy-en.pre-cy.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.2/apertium-en-ca.ca-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.2/apertium-en-ca.en-ca.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.3/apertium-en-ca.ca-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.3/apertium-en-ca.en-ca.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.4/apertium-en-ca.ca-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.4/apertium-en-ca.en-ca.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.9/apertium-en-ca.ca-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.9/apertium-en-ca.en-ca.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.9/empty.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.9/apertium-en-ca/apertium-en-ca.ca-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.9/apertium-en-ca/apertium-en-ca.en-ca.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-ca/release-0.8.9/apertium-en-ca/empty.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-es/release-0.6/apertium-en-es.en-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-es/release-0.6/apertium-en-es.es-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-gl/release-0.5.1/apertium-en-gl.en-gl.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-en-gl/release-0.5.1/apertium-en-gl.gl-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-eo-ca/release-0.9.0/apertium-eo-ca.ca-eo.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-eo-en/release-0.9.8/apertium-eo-en.en-eo.genitive.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-eo-en/release-0.9.8/apertium-eo-en.en-eo.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-eo-en/release-0.9.8/apertium-eo-en.eo-en.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-eo-es/release-0.9.0/apertium-eo-es.es-eo.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-es-gl/release-1.0.5/apertium-es-gl.es-gl.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-es-gl/release-1.0.5/apertium-es-gl.gl-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-es-gl/release-1.0.6/apertium-es-gl.es-gl.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-es-gl/release-1.0.6/apertium-es-gl.gl-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-es-gl/release-1.0.7/apertium-es-gl.es-gl.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-es-gl/release-1.0.7/apertium-es-gl.gl-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-eu-es/apertium-eu-es-0.3.0/apertium-eu-es.eu-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-eu-es/release-0.3.1/apertium-eu-es.eu-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-eu-es/release-0.3.1/apertium-eu-es.ordinals.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-fr-es/release-0.8.0/apertium-fr-es.es-fr.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-fr-es/release-0.8.0/apertium-fr-es.fr-es.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-nn-nb/release-0.6.0/apertium-nn-nb.nb-nn.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-nn-nb/release-0.6.0/apertium-nn-nb.nn-nb.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-nn-nb/release-0.6.1/apertium-nn-nb.nb-nn.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-nn-nb/release-0.6.1/apertium-nn-nb.nn-nb.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-pt-ca/release-0.8.0/apertium-pt-ca.ca-pt.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-pt-ca/release-0.8.0/apertium-pt-ca.pt-ca.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-sv-da/release-0.5.0/apertium-sv-da.da-sv.t1x",
"/home/j/esperanto/apertium-svn/apertium/tags/apertium-sv-da/release-0.5.0/apertium-sv-da.sv-da.t1x",
};

  int n = 0;
  for (String inf : fa) {
    String dir = "testdata/transfer/";
    String outFile = "/tmp/transfer-output-malgranda.txt"+n++;
    ApertiumTransferCompile.main(new String[]{inf, "/tmp/transfer.class"+n});
    Runtime.getRuntime().exec("apertium-preprocess-transfer "+inf+" /tmp/transfer.bin"+n).waitFor();
    ApertiumTransfer.main(new String[]{"/tmp/transfer.class"+n, "/tmp/transfer.bin"+n, dir+"en-eo.autobil.bin",
      dir+"transferinput-en-eo.t1x-malgranda.txt", outFile});
  }
  }


    public static void xmain(String[] args) throws IOException {

//   fstp.load(new BufferedInputStream(new FileInputStream("/home/j/esperanto/apertium/apertium-eo-en/apertium-eo-en.en-eo.bin")));

      FSTProcessor bilfstp = new FSTProcessor();
      bilfstp.load(new BufferedInputStream(new FileInputStream("/home/j/esperanto/apertium/apertium-eo-en/en-eo.autobil.bin")));
      bilfstp.initBiltrans();
      String output = bilfstp.biltrans("house<n><sg>" , false);
      System.err.println("output = " + output);

    }

      public static void xxmain(String[] argv) throws Exception {
          
          FSTProcessor fstp = new FSTProcessor();
          fstp.load(new BufferedInputStream(new FileInputStream("testdata/cb.bin")));
          fstp.initAnalysis();
          StringWriter output = new StringWriter();
          String input = "c b[\n]";
          fstp.analysis(new StringReader2( input ), output);
          System.err.println("analysis output = " + output);
      }
}
