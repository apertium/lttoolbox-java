// compile with: g++ single_translation.cc `pkg-config --cflags --libs lttoolbox-3.1`
#include <lttoolbox/fst_processor.h>
#include <lttoolbox/lt_locale.h>
#include <lttoolbox/xml_parse_util.h>

#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <iostream>
#include <string>

using namespace std;

int
main (int argc, char* argv[])
{
  FSTProcessor fstp;
  FILE* f;
  string word = "";

  if (argc != 3) {
    cerr << "Usage: " << argv[0] << " bidix word" << endl;
    exit(EXIT_FAILURE);
  } 

  word = argv[2];

  wstring lemma=XMLParseUtil::stows(word);

  f=fopen(argv[1], "r");
  if (f==NULL||ferror(f)) {
    cerr << "Error opening file: " << argv[1] << endl;
    exit(EXIT_FAILURE);
  }

  fstp.load(f);
  fclose(f);
  if (!fstp.valid()) {
    exit(EXIT_FAILURE);
  }
  fstp.initBiltrans();
  wstring out = fstp.biltrans(lemma, true);
  wcout << out << endl;
}
