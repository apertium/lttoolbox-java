PACKAGE=lttoolbox-java-3.2.0
DISTFILES=README dist/lttoolbox.jar autogen.sh build.xml COPYING lt-comp-j lt-expand-j lt-proc-j lt-validate-j Makefile nbproject src test testdata

.PHONY : test dist

all: dist/lttoolbox.jar symlinks

dist/lttoolbox.jar:
	ant -quiet jar

apertium-j: lt-proc-j
	ln -s lt-proc-j $@

apertium-preprocess-transfer-bytecode-j: lt-proc-j
	ln -s lt-proc-j $@

apertium-transfer-j: lt-proc-j
	ln -s lt-proc-j $@

apertium-interchunk-j: lt-proc-j
	ln -s lt-proc-j $@

apertium-postchunk-j: lt-proc-j
	ln -s lt-proc-j $@

apertium-tagger-j: lt-proc-j
	ln -s lt-proc-j $@

apertium-pretransfer-j: lt-proc-j
	ln -s lt-proc-j $@

apertium-destxt-j: lt-proc-j
	ln -s lt-proc-j $@

apertium-retxt-j: lt-proc-j
	ln -s lt-proc-j $@

lt-comp-j: lt-proc-j
	ln -s lt-proc-j $@

lt-expand-j: lt-proc-j
	ln -s lt-proc-j $@

lt-validate-j: lt-proc-j
	ln -s lt-proc-j $@

symlinks: lt-validate-j lt-expand-j lt-comp-j apertium-transfer-j apertium-interchunk-j apertium-postchunk-j apertium-tagger-j apertium-preprocess-transfer-bytecode-j apertium-pretransfer-j apertium-destxt-j apertium-retxt-j apertium-j
	echo "Making symlinks"

install: dist/lttoolbox.jar
	@if [ ! -e prefix ]; then \
		echo "/usr/local" > prefix; \
	fi
	@echo installing into `cat prefix`;
	mkdir -p `cat prefix`/share/apertium/;
	cp dist/lttoolbox.jar `cat prefix`/share/apertium/;
#	cp -a lt-proc-j lt-expand-j lt-comp-j lt-validate-j `cat prefix`/bin/;
	chmod a+x apertium-transfer-j apertium-preprocess-transfer-bytecode-j lt-proc-j lt-expand-j lt-comp-j lt-validate-j apertium-pretransfer-j apertium-destxt-j apertium-retxt-j;
	cp -a apertium-transfer-j apertium-preprocess-transfer-bytecode-j lt-proc-j lt-expand-j lt-comp-j lt-validate-j apertium-pretransfer-j apertium-destxt-j apertium-retxt-j `cat prefix`/bin/;

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



