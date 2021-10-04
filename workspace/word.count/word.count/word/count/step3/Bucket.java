package word.count.step3;

class Bucket {

  /*
   * The size of the initial bucket, 
   * that is, the initial length of the array of words.
   */
  static final int NWORDS = 16;

  private Word words[];
  private int nwords;

  public Bucket() {
    // TODO
    throw new RuntimeException("NYI");
  }

  /**
   * Finds if the given word exist in this bucket.
   * @param word
   * @return null if the given word was not found,
   *         otherwise returns the word that was found
   *         to have the same character sequence as the given word.
   */
  public Word find(Word word) {
    // TODO
    throw new RuntimeException("NYI");
  }

  /**
   * Add a word to this bucket, aliasing the given word object.
   */
  public void add(Word word) {
    // TODO
    throw new RuntimeException("NYI");
  }

  /**
   * @return the number of words that this bucket holds
   */
  public int getWordCount() {
    // TODO
    throw new RuntimeException("NYI");
  }

  /**
   * @return an array of the words that this bucket holds.
   * @warning do not create any aliasing here.
   */
  public Word[] getWords() {
    // TODO
    throw new RuntimeException("NYI");
  }

}