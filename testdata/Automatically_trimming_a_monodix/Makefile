all:
	lt-comp lr test-en.dix test-en.bin
	lt-comp lr correctly-pruned-en.dix correctly-pruned-en.bin
	lt-comp lr test-en-eu.dix test-en-eu.bin
	lt-print test-en.bin > test-en.att
	lt-print correctly-pruned-en.bin > correctly-pruned-en.att
	lt-print test-en-eu.bin > test-en-eu.att

hfst:
	hfst-txt2fst -e ε <  test-en.att > test-en.fst
	hfst-txt2fst -e ε <  test-en-eu.att > test-en-eu.fst
	hfst-invert test-en.fst -o test-en.mor.fst
	hfst-project -p upper test-en-eu.fst > test-en-eu.en.fst
	echo " ?* " | hfst-regexp2fst > any.fst
	hfst-concatenate -1 test-en-eu.en.fst -2 any.fst -o test-en-eu.en-prefixes.fst
	hfst-compose-intersect -1 test-en-eu.en-prefixes.fst -2 test-en.mor.fst | hfst-invert -o test-en.trimmed.fst


clean:
	rm *.bin *.att *.fst

