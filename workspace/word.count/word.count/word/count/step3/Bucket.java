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
	  words = new Word[NWORDS];
	  nwords = 0;
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
	  for (int i = 0; i < nwords; i++) {
	        if (words[i].equals(word)) {
	          return words[i];
	        }
	  }
	  return null;
	  }
	  
  /**
   * Add a word to this bucket, aliasing the given word object.
   */
  public void add(Word word) {
    // TODO	  
	    Word word_tmp = find(word);
	    if(word_tmp == (Word) null && word.toString().length() != 0) {
	    	nwords++;
	    	Word words2[] = new Word[nwords];
			System.arraycopy(words, 0, words2, 0, nwords - 1);
			words2[nwords - 1] = word;
			words = new Word[nwords];
			System.arraycopy(words2, 0, words, 0, nwords);
		}
  }

  /**
   * @return the number of words that this bucket holds
   */
  public int getWordCount() {
    // TODO
    return nwords;
  }

  /**
   * @return an array of the words that this bucket holds.
   * @warning do not create any aliasing here.
   */
  public Word[] getWords() {
    // TODO
	Word words2[] = new Word[nwords];
	System.arraycopy(words, 0, words2, 0, nwords);
	return words2;
  }

}