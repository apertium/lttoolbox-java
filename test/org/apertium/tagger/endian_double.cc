#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <cctype>
#include <cassert>

#if defined __BIG_ENDIAN__
#  define WORDS_BIGENDIAN 1
#endif

#ifndef fread_unlocked
#define fread_unlocked fread
#endif

using namespace std;

double
EndianDoubleUtil_read(FILE *input)
{
  double retval;
#ifdef WORDS_BIGENDIAN
  fread_unlocked(&retval, sizeof(double), 1, input);
#else
  char *s = reinterpret_cast<char *>(&retval);

  for(int i = sizeof(double)-1; i != -1; i--)
  {
    if(fread_unlocked(&(s[i]), 1, 1, input)==0)
    {
      return 0;
    }
  }
#endif
  return retval;
}

void
EndianDoubleUtil_write(FILE *output, double const &val)
{
  double val2 = val;
#ifdef WORDS_BIGENDIAN
  fwrite(&val2, sizeof(double), 1, output);
#else
  char *s = reinterpret_cast<char *>(&val2);

  for(int i = sizeof(double)-1; i != -1; i--)
  {
    fwrite(&(s[i]), 1, 1, output);
  }
#endif
}


int
main (int argc, char* argv[])
{
  FILE* in;
  FILE* out;
  double test=1.90001;

  out=fopen("double-test", "w");

  if (out==NULL||ferror(out)) {
    cerr << "Error opening output file"<< endl;
    exit(EXIT_FAILURE);
  }

  EndianDoubleUtil_write(out, test);
  fclose(out);

  in=fopen("double-test", "r");
  if (in==NULL||ferror(in)) {
    cerr << "Error opening input file"<< endl;
    exit(EXIT_FAILURE);
  }

  double intest = EndianDoubleUtil_read(in);
  fclose(in);

  assert (intest==test);
}
