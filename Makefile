all: 
	ant -quiet jar

install: all
	cp dist/lttoolbox.jar /usr/local/share/apertium/
	cp -a lt-proc-j lt-expand-j lt-comp-j lt-validate-j /usr/local/bin/

tests:
	ant -quiet test

clean:
	ant -quiet clean


