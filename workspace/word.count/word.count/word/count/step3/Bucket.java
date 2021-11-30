package word.count.step3;

class Bucket {

  /*
   * The size of the initial bucket, 
   * that is, the initial length of the array of words.
   */
  static final int NWORDS = 16;

  private Word words[];
  private int nwords;
  private int nadds;

  public Bucket() {
    // TODO
	  words = new Word[NWORDS];
	  nwords = 0;
	  nadds = 0;
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
	    if(word_tmp == (Word) null) {
	    	nwords++;
	    	nadds++;
	    	word.noccurrences++;
	    	
	    	Word[] words_tmp = new Word[nwords];
	    	 for(int i = 0; i < nwords - 1; i++) {
	    	    	words_tmp[i] = words[i];
	    	    }
	    	 words_tmp[nwords-1] = word;
	    	 words  = words_tmp;
	    } else {
	    	word_tmp.noccurrences++;
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
    Word[] word_tmp = new Word[nwords];
    for(int i = 0; i < nwords; i++) {
    	word_tmp[i] = new Word(words[i]);
    }
    return word_tmp;
  }

}