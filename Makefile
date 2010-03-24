PACKAGE=lttoolbox-java-3.2.0
DISTFILES=README dist/lttoolbox.jar autogen.sh build.xml COPYING lt-comp-j lt-expand-j lt-proc-j lt-validate-j Makefile nbproject src test testdata

.PHONY : test dist

all: dist/lttoolbox.jar symlinks

dist/lttoolbox.jar:
	ant -quiet jar

apertium-preprocess-transfer-bytecode-j: lt-proc-j
	ln -s lt-proc-j $@

apertium-transfer-j: lt-proc-j
	ln -s lt-proc-j $@

lt-comp-j: lt-proc-j
	ln -s lt-proc-j $@

lt-expand-j: lt-proc-j
	ln -s lt-proc-j $@

lt-validate-j: lt-proc-j
	ln -s lt-proc-j $@

symlinks: lt-validate-j lt-expand-j lt-comp-j apertium-transfer-j apertium-preprocess-transfer-bytecode-j
	echo "Making symlinks"

install: dist/lttoolbox.jar
	@if [ ! -e prefix ]; then \
		echo "/usr/local" > prefix; \
	fi
	@echo installing into `cat prefix`;
	mkdir -p `cat prefix`/share/apertium/;
	cp dist/lttoolbox.jar `cat prefix`/share/apertium/;
#	cp -a lt-proc-j lt-expand-j lt-comp-j lt-validate-j `cat prefix`/bin/;
	cp -a apertium-transfer-j apertium-preprocess-transfer-bytecode-j lt-proc-j lt-expand-j lt-comp-j lt-validate-j `cat prefix`/bin/;

test:
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



