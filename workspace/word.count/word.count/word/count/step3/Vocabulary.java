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
    buckets = new Bucket[NBUCKETS];
    for(int i = 0; i < NBUCKETS; i++) {
    	buckets[i] = new Bucket();
    }
    nwords = 0;
    nadds = 0;
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
	Counters.Vocabulary_add_count++;
	long start = System.nanoTime();
	
	Word word_tmp = find(word);
	if(word_tmp == null && word.toString().length() != 0) {
		nwords++;
		nadds++;
		buckets[word.hashCode()].add(word);
		long end = System.nanoTime();
		Counters.Vocabulary_add_elapsed += end - start;
		return word;
	}
	long end = System.nanoTime();
	Counters.Vocabulary_add_elapsed += end - start;
	return word_tmp;
  }

  /**
   * @return the known words as an array of words
   *         the size of the array is the word count
   *         of this vocabulary.
   * @warning: do not create any aliasing here.
   */
  public Word[] getWords() {
    // TODO
	  Word words1[] = new Word[nwords];
		int c = 0;
		for (int i = 0; i < NBUCKETS; i++) {
			Word tmp[] = new Word[buckets[i].getWordCount()];
			tmp = buckets[i].getWords();
			for (int j = 0; j < tmp.length; j++) {
				words1[c] = tmp[j];
				c++;
			}
		}
		return words1;
  }

  /**
   * Compute the number of known words in this vocabulary.
   */
  public int getWordCount() {
    // TODO
    return nwords;
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
    long start = System.nanoTime();
    try {
    	int i = word.hashCode();
    	return buckets[i].find(word);
    } finally {
    	long end = System.nanoTime();
    	Counters.Vocabulary_find_count++;
		Counters.Vocabulary_find_elapsed += (end - start);
    }
  }

}
