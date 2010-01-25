PACKAGE=lttoolbox-java-3.2.0
DISTFILES=README dist/lttoolbox.jar autogen.sh build.xml COPYING lt-comp-j lt-expand-j lt-proc-j lt-validate-j Makefile nbproject src test testdata

all: dist/lttoolbox.jar

dist/lttoolbox.jar:
	ant -quiet jar

install: dist/lttoolbox.jar
	@if [ ! -e prefix ]; then \
		echo "/usr/local" > prefix; \
	fi
	@echo installing into `cat prefix`;
	cp dist/lttoolbox.jar `cat prefix`/share/apertium/;
	cp -a lt-proc-j lt-expand-j lt-comp-j lt-validate-j `cat prefix`/bin/;

tests:
	ant -quiet test

clean:
	ant -quiet clean
	rm -f prefix;

dist: dist/lttoolbox.jar
	rm -rf ${PACKAGE}
	mkdir ${PACKAGE}
	cp -a ${DISTFILES} ${PACKAGE}
	tar --exclude-vcs --exclude=${PACKAGE}/nbproject/private -czf ${PACKAGE}.tar.gz ${PACKAGE}
	rm -rf ${PACKAGE}



