package word.count.step3;

public class Word {
  char chars[];
  int nchars;
  int noccurrences;

  public Word() {
    chars = new char[4];
  }

  public Word(Word c) {
    noccurrences = c.noccurrences;
    nchars = c.nchars;
    chars = new char[c.nchars];
    System.arraycopy(c.chars, 0, chars, 0, nchars);
  }

  public void add(char c) {
    if (chars.length == nchars) {
      char[] tmp = new char[2 * nchars];
      System.arraycopy(chars, 0, tmp, 0, nchars);
      chars = tmp;
    }
    chars[nchars++] = c;
  }

  /**
   * Returns a simple hash code for this word.
   * REMEMBER that the hash code and the equality of words
   * must be designed together. If two words are equal, 
   * they must have the same hash code. If they are not equal,
   * they may not always have different hash codes.
   * 
   * Note that the hash code may be negative.
   */
  public int hashCode() {
    return (int) chars[0];
  }

  public boolean equals(Word w) {
    if (nchars != w.nchars)
      return false;
    for (int i = 0; i < nchars; i++)
      if (chars[i] != w.chars[i])
        return false;
    return true;
  }
}
