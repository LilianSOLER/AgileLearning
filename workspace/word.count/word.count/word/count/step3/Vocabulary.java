package word.count.step3;

public class Vocabulary {

  /*
   * The number of buckets in this vocabulary.
   * Notice that we have a power of two,
   * shifting left the hexadecimal value 0x01
   * by 8, we get 0x100, which is 256 decimal.
   */
  static final int NBUCKETS = (0x01 << 8);

  private Bucket buckets[];
  private int nwords;
  private int nadds;

  public Vocabulary() {
    // TODO
    throw new RuntimeException("NYI");
  }

  /**
   * Adds a word if it is not already known. <br>
   * Relies on the find method to determine if the given word is known or not.
   * 
   * @param word
   * @return the given word if it was not in the vocabulary or the word that
   *         was already in the vocabulary with the same sequence of characters.
   *
   * @warning the given word is aliased if added to the vocabulary
   */
  public Word add(Word word) {
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
   * Compute the number of known words in this vocabulary.
   */
  public int getWordCount() {
    // TODO
    throw new RuntimeException("NYI");
  }

  /**
   * Search for a word, efficiently, using the hash of the given word to choose
   * the bucket in which to lookup if the word is already known.
   * 
   * @param word
   * @return
   */
  public Word find(Word word) {
    // TODO
    throw new RuntimeException("NYI");
  }

}
