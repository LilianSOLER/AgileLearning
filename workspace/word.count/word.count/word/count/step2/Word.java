package word.count.step2;

public class Word {
  private char chars[];
  private int nchars;
  public int noccurrences;

  public Word() {
    // TODO
    throw new RuntimeException("NYI");
  }

  /*
   * Make sure there is no aliasing across words.
   */
  public Word(Word c) {
    // TODO
    throw new RuntimeException("NYI");
  }

  /*
   * Create a new string, from the character array
   * of this word.
   */
  public String toString() {
    return new String(chars, 0, nchars);
  }

  /*
   * Add the given character at the end of this word.
   */
  public void add(char c) {
    // TODO
    throw new RuntimeException("NYI");
  }

  /**
   * This method is really important.
   * It checks if two objects, instance of the class Word,
   * are representing the same "word" in terms of the
   * characters they contain.
   * @param w
   * @return
   */
  public boolean equals(Word w) {
    // TODO
    throw new RuntimeException("NYI");
  }
}
