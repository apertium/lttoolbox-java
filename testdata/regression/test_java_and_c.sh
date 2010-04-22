#!/bin/bash

if [ "x$JAVA" == "x" ]
then
	#JAVA='/usr/bin/java -client'
	JAVA='java -client'
fi

#LTProcJ="time -f %Usec $JAVA -jar ../../dist/lttoolbox.jar lt-proc"
LTProcJ="time -f %Usec $JAVA -cp ../../dist/lttoolbox.jar org.apertium.lttoolbox.LTProc"

#LTProcC="/home/j/esperanto/apertium/lttoolbox/lttoolbox/lt-proc"
LTProcC="time -f %Usec lt-proc"
#LTProcC="lt-proc"
F=/tmp/lt-proc-output.txt
ERR=/tmp/lt-proc-output-diff.txt

function fail() {
	echo "error"
	echo "Command was: $1"
	echo "Output is in $F - differences is in $ERR"
	if [ "x$CONTINUE_ON_ERROR" == "x" ]
	then
		exit 1
	fi
}

$JAVA -version

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


echo "All tests passed"
exit 0
