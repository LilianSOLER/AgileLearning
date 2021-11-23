package word.count.step2;

public class Vocabulary {

  private Word words[];
  private int nwords;
  private int nadds;

  public Vocabulary() {
    nwords = 0;
    nadds = 0;
  }

  /**
   * @return the count of known words in this vocabulary
   */
  public int getWordCount() {
    // TODO
    return nwords;
  }

  /**
   * @return the known words as an array of words
   *         the size of the array is the word count
   *         of this vocabulary.
   * @warning: do not create any aliasing here.
   */
  public Word[] getWords() {
    // TODO
    Word[] word_tmp = new Word[nwords];
    for(int i = 0; i < nwords; i++) {
    	word_tmp[i] = words[i];
    }
    return word_tmp;
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
    for(int i = 0; i < nwords; i++) {
    	if(words[i].equals(word)) {
    		return words[i];
    	}
    }
    return null;
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
    	 return word;
    } else {
    	word_tmp.noccurrences++;
    	return word_tmp;
    }
  }

}
