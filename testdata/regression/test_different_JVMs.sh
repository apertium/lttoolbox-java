#!/bin/bash

#for i in java cacao gij jamvm '/usr/bin/java -client' '/usr/bin/java -server' '/usr/bin/java -cacao' '/usr/bin/java -zero'

for i in java cacao gij '/usr/bin/java -client' '/usr/bin/java -server' '/usr/bin/java -zero'
do
	echo  ===========================
	echo  ======== $i 
	echo  ===========================
#	CONTINUE_ON_ERROR=true JAVA="$i" ./compare_java_and_c.sh
	JAVA="$i" ./test_java_and_c.sh
done
