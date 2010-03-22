/*
 * Copyright (C) 2005 Universitat d'Alacant / Universidad de Alicante
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

package org.apertium.tagger;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import org.apertium.lttoolbox.Compression;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

/**
 *
 * @author jimregan
 */
public class HMM {
    private double ZERO = 1e-10;
    private TaggerData td;
    private int eos;
    private boolean debug;
    private boolean show_sf;
    private boolean null_flush;

    void set_eos(int t) {
        eos = t;
    }

    void set_debug (boolean d) {
        debug = d;
    }

    void set_show_sf (boolean sf) {
        show_sf = sf;
    }

    void read_ambiguity_classes (InputStream in) throws IOException {
        boolean eof = false;
        while (!eof) {
            int ntags = Compression.multibyte_read(in);
            if (ntags == -1) {
                eof = true;
                break;
            }
            
            Set<Integer> ambiguity_class = new HashSet<Integer>();

            for (; ntags != 0; ntags--) {
                ambiguity_class.add(Compression.multibyte_read(in));
            }

            if (ambiguity_class.size() != 0) {
                td.getOutput().add(ambiguity_class);
            }
        }
        td.setProbabilities(td.getTagIndex().size(), td.getOutput().size());
    }

    void write_ambiguity_classes (OutputStream o) throws IOException {
        for (int i=0; i!=td.getOutput().size(); i++) {
            Set<Integer> ac = td.getOutput().get(i);
            Compression.multibyte_write(ac.size(), o);
            for (int it : ac) {
                Compression.multibyte_write(it, o);
            }
        }
    }

    void read_probabilities (InputStream in) throws IOException {
        td.read(in);
    }

    void write_probabilities (OutputStream out) throws IOException {
        td.write(out);
    }

    void init_probabilities_kupiec (InputStream is) throws IOException {
        int N = td.getN();
        int M = td.getM();
        int i, j, k, k1, k2, nw=0;
        /**
         * M = Number of ambiguity classes
         */
        double[] classes_occurrences = new double[M];
        double[][] classes_pair_occurrences = new double[M][M];
        /**
         * N = Number of tags (states)
         */
        double[] tags_estimate = new double[N];
        double[][] tags_pair_estimate = new double[N][N];

        Collection output = td.getOutput();

        MorphoStream lexmorfo = new MorphoStream (is, true, td);
        TaggerWord word = new TaggerWord();

        for (k=0; k<M; k++) {
            classes_occurrences[k] = 1;
            for (k2=0; k2<M; k2++)
                classes_pair_occurrences[k][k2] = 1;
        }

        Set<Integer> tags = new HashSet<Integer>();
        tags.add(eos);
        k1=output.get(tags);
        classes_occurrences[k]++;

        word = lexmorfo.get_next_word();
        while (word!=null) {
            if (++nw%10000==0)
                System.err.println('.');

            tags = word.get_tags();

            if (tags.size()==0) {
                tags = td.getOpenClass();
            } else if (output.has_not(tags)) {
                String errors;
                errors = "A new ambiguity class was found. I cannot continue.\n";
                errors+= "Word '"+word.get_superficial_form()+"' not found in the dictionary.\n";
                errors+= "New ambiguity class: "+word.get_string_tags()+"\n";
                errors+= "Take a look at the dictionary and at the training corpus. Then, retrain.";
                fatal_error(errors);
            }

            k2=output.get(tags);

            classes_occurrences[k1]++;
            classes_pair_occurrences[k1][k2]++;
            word=lexmorfo.get_next_word();
            k1=k2;
        }

        // Estimation of the number of time each tags occurs in the training text
        for (i=0; i<N; i++) {
            tags_estimate[i] = 0;
            for (k=0; k<M; k++) {
                if (output.get(k).contains(i)) {
                    tags_estimate[i] += classes_occurrences[k]/output.get(k).size();
                }
            }
        }

        //Estimation of the number of times each tag pair occurs
        for (i=0; i<N; i++)
            for (j=0; j<N; j++)
                tags_pair_estimate[i][j] = 0;

        Set<Integer> tags1, tags2;
        for (k1=0; k1<M; k1++) {
            tags1=output.get(k1);
            for (k2=0; k2<M; k2++) {
                tags2 = output.get(k2);
                double noccurrences = classes_pair_occurrences[k1][k2]/(double) (tags1.size()*tags2.size());
                for (Integer itag1 : tags1.toArray(new Integer[tags1.size()]))
                    for (Integer itag2 : tags2.toArray(new Integer[tags2.size()]))
                        tags_pair_estimate[itag1][itag2]+=noccurrences;
            }
        }

        //a[i][j] estimation
        double sum;
        double[][] tmpA = td.getA();
        for (i=0; i<N; i++) {
            sum=0;
            for (j=0; j<N; j++)
                sum+=tags_pair_estimate[i][j];

            for (j=0; j<N; j++) {
                if (sum>0) {
                    tmpA[i][j] = tags_pair_estimate[i][j]/sum;
                } else {
                    tmpA[i][j] = 0;
                }
            }
        }
        td.setA(tmpA);

        //b[i][k] estimation
        double[][] tmpB = td.getB();
        for (i=0; i<N; i++) {
            for (k=0; k<M; k++) {
                if (output.get(k).contains(i)) {
                    if (tags_estimate[i]>0)
                        tmpB[i][k] = (classes_occurrences[k]/output.get(k).size())/tags_estimate[i];
                    else
                        tmpB[i][k] = 0;
                }
            }
        }
        td.setB(tmpB);

        System.err.println();
    }

    void init_probabilities_from_tagged_text (InputStream ftagged, InputStream funtagged) throws IOException {
        int i, j, k, nw = 0;
        int N = td.getN();
        int M = td.getM();
        double tags_pair[][] = new double[N][N];
        double emission[][] = new double[N][M];

        MorphoStream stream_tagged = new MorphoStream(ftagged, true, td);
        MorphoStream stream_untagged = new MorphoStream(funtagged, true, td);

        TaggerWord word_tagged = new TaggerWord();
        TaggerWord word_untagged = new TaggerWord();
        Collection output = td.getOutput();

        Set<Integer> tags = new HashSet<Integer>();

        for (i=0; i<N; i++)
            for (j=0; j<N; j++)
                tags_pair[i][j] = 0;
        for (k=0; k<M; k++)
            for (i=0; i<N; k++)
                if (output.get(k).contains(i))
                    emission[i][k] = 0;

        Integer tag1, tag2;
        tag1 = eos;

        // FIXME check get_next_word()
        word_tagged = stream_tagged.get_next_word();
        word_untagged = stream_untagged.get_next_word();
        while (word_tagged != null) {
            System.err.print(word_tagged);
            System.err.println(" -- " + word_untagged);

            if (!word_untagged.get_superficial_form().equals(word_tagged.get_superficial_form())) {
                System.err.println();
                System.err.println("Tagged text (.tagged) and analyzed text (.untagged) streams are not aligned.");
                System.err.println("Take a look at tagged text (.tagged).");
                System.err.println("Perhaps this is caused by a multiword unit that is not a multiword unit in one of the two files.");
                System.err.println(word_tagged + " -- " + word_untagged);
                System.exit(1);
            }

            if (++nw%100==0) {
                System.err.print(".");
                System.err.flush();
            }

            tag2 = tag1;

            if (word_untagged==null) {
                System.err.println("word_untagged==NULL");
                System.exit(1);
            }

            if (word_tagged.get_tags().size()==0) // Unknown word
                tag1 = -1;
            else if (word_tagged.get_tags().size()>1) // Ambiguous word
                System.err.println("Error in tagged text. An ambiguous word was found: " + word_tagged.get_superficial_form());
            else
                tag1 = word_tagged.get_tags().iterator().next();

            if ((tag1>=0) && (tag2>=0))
                tags_pair[tag2][tag1]++;

            if (word_untagged.get_tags().size()==0)
                tags = td.getOpenClass();
            else if (output.has_not(word_untagged.get_tags())) {
                String errors;
                errors = "A new ambiguity class was found. I cannot continue.\n";
                errors+= "Word '"+word_untagged.get_superficial_form()+"' not found in the dictionary.\n";
                errors+= "New ambiguity class: "+word_untagged.get_string_tags()+"\n";
                errors+= "Take a look at the dictionary, then retrain.";
                fatal_error(errors);
            } else {
                tags = word_untagged.get_tags();
            }

            k = output.get(tags);
            if (tag1>=0)
                emission[tag1][k]++;

            word_tagged=stream_tagged.get_next_word();
            word_untagged=stream_untagged.get_next_word();
        }

        //Estimate of a[i][j]
        for (i=0; i<N; i++) {
            double sum=0;
            for(j=0; j<N; j++)
                sum += tags_pair[i][j]+1.0;
            for(j=0; j<N; j++) {
                td.setAElement(i, j, (tags_pair[i][j]+1.0)/sum);
            }
        }

        //Estimate of b[i][k]
        for(i=0; i<N; i++) {
        int nclasses_appear=0;
        double times_appear=0.0;
        for(k=0; k<M; k++)  {
            if (output.get(k).contains(i))  {
                nclasses_appear++;
                times_appear+=emission[i][k];
            }
        }	
        for(k=0; k<M; k++)  {
            if (output.get(k).contains(i))
                td.setBElement(i, k, (emission[i][k]+(1.0/nclasses_appear))/(times_appear+1.0));
            }
        }

        System.err.println();
    }

    void apply_rules () {
        ArrayList<TForbidRule> forbid_rules = td.getForbidRules();
        ArrayList<TEnforceAfterRule> enforce_rules = td.getEnforceRules();
        int N = td.getN();
        int i, j, j2;
        boolean found;

        for (i=0; i < forbid_rules.size(); i++) {
            td.setAElement(forbid_rules.get(i).tagi, forbid_rules.get(i).tagj, ZERO);
        }

        for (i=0; i < enforce_rules.size(); i++) {
            for (j=0; j<N; j++) {
                found = false;
                for (j2=0; j2 < enforce_rules.get(i).tagsj.size(); j2++) {
                    if (enforce_rules.get(i).tagsj.get(j2)==j) {
                        found = true;
                        break;
                    }
                }
                if (!found)
                    td.setAElement(enforce_rules.get(i).tagi, j, ZERO);
            }
        }

        // Normalize probabilities
        for(i=0; i<N; i++) {
            double sum=0;
            for(j=0; j<N; j++)
                sum += td.getA()[i][j];
            for(j=0; j<N; j++) {
                if (sum>0)
                    td.setAElement(i, j, td.getA()[i][j]/sum);
                else
                    td.setAElement(i, j, 0);
            }
        }
    }

    void read_dictionary (InputStream fdic) throws IOException {
        int i, k, nw=0;
        TaggerWord word = new TaggerWord();
        Set<Integer> tags = new HashSet<Integer>();
        Collection output = td.getOutput();

        MorphoStream morpho_stream = new MorphoStream(fdic, true, td);

        word = morpho_stream.get_next_word();

        while (word != null) {
            if (++nw%10000==0) {
                System.err.println(".");
                System.err.flush();
            }

            tags = word.get_tags();

            if (tags.size()>0)
                k = output.get(tags);

            word = morpho_stream.get_next_word();
        }
        System.err.println();

        // OPEN AMBIGUITY CLASS
        // It contains all tags that are not closed.
        // Unknown words are assigned the open ambiguity class
        k=output.get(td.getOpenClass());

        int N = td.getTagIndex().size();

        // Create ambiguity class holding one single tag for each tag.
        // If not created yet
        for(i = 0; i != N; i++) {
            Set<Integer> amb_class = new HashSet<Integer>();
            amb_class.add(i);
            k = output.get(amb_class);
        }

        int M = output.size();

        System.err.println(N + " states and " + M + " ambiguity classes");
        td.setProbabilities(N, M);
    }

    private void fatal_error (String err) {
        System.err.println(err);
        System.exit(1);
    }
}
