#!/bin/bash

LTProcJ="java -cp /home/j/esperanto/apertium/gsoc2009/rah/lttoolbox-java-maven/target/lttoolbox-1.0-SNAPSHOT.jar org.apertium.lttoolbox.LTProc"
#LTProcC="/home/j/esperanto/apertium/lttoolbox/lttoolbox/lt-proc"
LTProcC="lt-proc"
F=/tmp/lt-proc-output.txt
ERR=/tmp/lt-proc-output-diff.txt

function fail() {
	echo "error"
	echo "Command was: $1"
	echo "Output is in $F - differences is in $ERR"
	exit 1
}


rm -f $F
echo -n "C analysis is... " 
cat analysis_input | $LTProcC -a fr-es.automorf.bin > $F
diff analysis_output $F > $ERR && echo "OK" || fail "cat analysis_input | $LTProcC -a fr-es.automorf.bin"

rm -f $F
echo -n "Java analysis is... "
cat analysis_input | $LTProcJ -a fr-es.automorf.bin > $F
diff analysis_output $F > $ERR && echo "OK" || fail



rm -f $F
echo -n "C generator -g is ... "
cat generator_input | $LTProcC  -g fr-es.autogen.bin > $F
diff generator_g_output $F > $ERR && echo "OK" || fail

rm -f $F
echo -n "Java generator -g is ... "
cat generator_input | $LTProcJ  -g fr-es.autogen.bin > $F
diff generator_g_output $F > $ERR && echo "OK" || fail "cat generator_input | $LTProcJ  -g fr-es.autogen.bin"


rm -f $F
echo -n "C generator -d is ... "
cat generator_input | $LTProcC  -d fr-es.autogen.bin > $F
diff generator_d_output $F > $ERR && echo "OK" || fail

rm -f $F
echo -n "Java generator -d is ... "
cat generator_input | $LTProcJ  -d fr-es.autogen.bin > $F
diff generator_d_output $F > $ERR && echo "OK" || fail


rm -f $F
echo -n "C generator -n is ... "
cat generator_input | $LTProcC  -n fr-es.autogen.bin > $F
diff generator_n_output $F > $ERR && echo "OK" || fail

rm -f $F
echo -n "Java generator -n is ... "
cat generator_input | $LTProcJ  -n fr-es.autogen.bin > $F
diff generator_n_output $F > $ERR && echo "OK" || fail


rm -f $F
echo -n "C postgenerator -p is ... "
cat postgenerator_input | $LTProcC  -p fr-es.autopgen.bin > $F
diff postgenerator_output $F > $ERR && echo "OK" || fail "cat postgenerator_input | $LTProcC  -p fr-es.autopgen.bin"


rm -f $F
echo -n "Java postgenerator -p is ... "
cat postgenerator_input | $LTProcJ  -p fr-es.autopgen.bin > $F
diff postgenerator_output $F > $ERR && echo "OK" || fail "cat postgenerator_input | $LTProcJ  -p fr-es.autopgen.bin"


#cat analysis_input | java -cp /home/j/esperanto/apertium/gsoc2009/rah/lttoolbox-java-maven/target/lttoolbox-1.0-SNAPSHOT.jar org.apertium.lttoolbox.LTProc fr-es.automorf.bin > res_java_version
#cat analysis_input | /home/j/esperanto/apertium/lttoolbox/lttoolbox/lt-proc fr-es.automorf.bin > res_c_version
#cat generator_input | lt-proc -g fr-es.autogen.bin > xq

echo "All tests passed"
