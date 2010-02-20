#! /bin/sh

#echo 
#echo "No automatic generation script needed"
echo "Make sure Java (JDK version 1.6 or newer) and ant is installed and type:"
echo "(Mac users: First type: export JAVA_HOME=/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Home)"
echo "	make"
echo "	sudo make install"
echo 
echo "(other options are: 'make tests' to do regression testing of the package, and 'make clean' to cleanup)"
echo 
echo "You can also build and install this program using Maven 2 (http://maven.apache.org) using the following command:"
echo "  mvn install"
echo
echo "This script just sets the installation prefix. Set another prefix by e.g.: sh autogen.sh --prefix=/usr"
echo -n "Setting prefix to ... ";
echo $1 | grep '\-\-prefix' > /dev/null;

if [ $? -eq 0 ]; then 
	echo $1 | cut -f2 -d'=' > prefix;
	cat prefix;
else
	echo '/usr/local' > prefix;
	cat prefix;
fi


