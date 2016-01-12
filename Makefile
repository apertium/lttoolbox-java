PACKAGE=lttoolbox-java-3.2.0

SYMLINKS=lt-validate-j lt-print-j lt-expand-j lt-comp-j lt-proc-j lt-trim-j\
apertium-destxt-j apertium-retxt-j apertium-tagger-j apertium-pretransfer-j\
apertium-transfer-j apertium-interchunk-j apertium-postchunk-j apertium-preprocess-transfer-bytecode-j

DISTFILES=README dist/lttoolbox.jar autogen.sh build.xml COPYING Makefile nbproject src test testdata apertium-j apertium-pack-j ${SYMLINKS}

.PHONY : test dist

all: dist/lttoolbox.jar symlinks

dist/lttoolbox.jar:
	ant -quiet jar

symlinks: ${SYMLINKS}

${SYMLINKS}:
	@echo "Making symlinks"
	for i in ${SYMLINKS}; do ln -sf apertium-j $$i; done

install: dist/lttoolbox.jar
	@if [ ! -e prefix ]; then \
		echo "/usr/local" > prefix; \
	fi
	@echo installing into `cat prefix`;
	mkdir -p `cat prefix`/bin/;
	mkdir -p `cat prefix`/share/apertium/;
	cp dist/lttoolbox.jar `cat prefix`/share/apertium/;
#	cp -a apertium-j lt-expand-j lt-comp-j lt-validate-j `cat prefix`/bin/;
	chmod a+x ${SYMLINKS} apertium-j apertium-pack-j;
	cp -a ${SYMLINKS} apertium-j apertium-pack-j `cat prefix`/bin/;

test:
	ant -quiet test

clean:
	ant -quiet clean

distclean: clean
	rm -f prefix ${SYMLINKS};

dist: dist/lttoolbox.jar
	rm -rf ${PACKAGE}
	mkdir ${PACKAGE}
	cp -a ${DISTFILES} ${PACKAGE}
	tar --exclude-vcs --exclude=${PACKAGE}/nbproject/private -czf ${PACKAGE}.tar.gz ${PACKAGE}
	rm -rf ${PACKAGE}
