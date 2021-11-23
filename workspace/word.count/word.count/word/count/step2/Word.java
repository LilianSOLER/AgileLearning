package word.count.step2;

public class Word {
  private char chars[];
  private int nchars;
  public int noccurrences;

  public Word() {
    // TODO
    nchars = 0;
    noccurrences = 0;
  }

  /*
   * Make sure there is no aliasing across words.
   */
  public Word(Word c) {
    // TODO
    this.nchars = c.nchars;
    this.noccurrences = c.noccurrences;
    
    this.chars = new char[nchars];
    for(int i = 0; i < nchars; i++) {
    	this.chars[i] = c.chars[i];
    }  
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
    nchars++;
    
    char[] chars_tmp = new char[nchars];
    for(int i = 0; i < nchars -1; i++) {
    	chars_tmp[i] = chars[i];
    }
    chars_tmp[nchars - 1] = c;
    chars = chars_tmp;
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
    String a = w.toString();
    String b = this.toString();
    if(a.length() != b.length()) {
    	return false;
    } else {
    	for(int i = 0; i < a.length(); i++) {
    		if(a.charAt(i) != b.charAt(i)) {
    			return false;
    		}
    	}
    }
    return true;
  }
}
