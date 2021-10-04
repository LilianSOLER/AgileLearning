package word.count.step2;

public class Vocabulary {

  private Word words[];
  private int nwords;
  private int nadds;

  public Vocabulary() {
    // TODO
    throw new RuntimeException("NYI");
  }

  /**
   * @return the count of known words in this vocabulary
   */
  public int getWordCount() {
    // TODO
    throw new RuntimeException("NYI");
  }

  /**
   * @return the known words as an array of words
   *         the size of the array is the word count
   *         of this vocabulary.
   * @warning: do not create any aliasing here.
   */
  public Word[] getWords() {
    // TODO
    throw new RuntimeException("NYI");
  }

  /**
   * Determines if the given word is already known or not.
   * Two words are equals if the Word.equals(Word) method
   * returns true.
   * @param word: the given word to look for
   * @return null if the given word is not found in this vocabulary 
   *         or returns the word found in this vocabulary.
   */
  public Word find(Word word) {
    // TODO
    throw new RuntimeException("NYI");
  }

  /**
   * Adds a word only if it is not already known.
   * This code **MUST** invoke the method find above to
   * check if the given word is already known to this
   * vocabulary.
   * @param word
   * @return
   */
  public Word add(Word word) {
    // TODO
    throw new RuntimeException("NYI");
  }

}
