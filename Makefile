all: 
	ant -quiet jar

install: all
	PREFIX=`cat prefix`;
ifeq ($PREFIX, "")
	@echo "Run autogen.sh"
else
	cp dist/lttoolbox.jar $(PREFIX)/share/apertium/
	cp -a lt-proc-j lt-expand-j lt-comp-j lt-validate-j $(PREFIX)/bin/
endif

tests:
	ant -quiet test

clean:
	ant -quiet clean
	rm prefix;
