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

  // This if block is mainly in case the word contains a space and isn't fully quoted
  if (argc < 3) {
    cerr << "Usage: " << argv[0] << " bidix word" << endl;
    exit(EXIT_FAILURE);
  } else if (argc == 3) {
    word = argv[2];
  } else {
    for (int i=2;i<argc;i++) {
      if (i==2) {
        word = argv[i];
      } else {
        word.append(" ");
        word.append(argv[i]);
      }
      if (word[word.length()-1]=='$' && i!=argc-1) {
        cerr << "Usage: " << argv[0] << " bidix word" << endl;
        cerr << "Only translates a single word" << endl;
        exit(EXIT_FAILURE);
      }
    }
  }
  if (word[0]!='^' && word[word.length()-1]!='$') {
    cerr << "Usage: " << argv[0] << " bidix word" << endl;
    cerr << "word must be quoted" << endl;
    exit(EXIT_FAILURE);
  }

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
