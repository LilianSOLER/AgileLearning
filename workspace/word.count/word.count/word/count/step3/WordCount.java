package word.count.step3;

import java.io.IOException;
import java.io.InputStreamReader;



public class WordCount {
	 private int charCount;
	  private int wordCount;
	  private int lineCount;
	  private int vocabCount;

	  private InputStreamReader reader;
	  private Vocabulary vocabulary;

	  public WordCount(InputStreamReader reader) {
	    this.vocabulary = new Vocabulary();
	    this.reader = reader;
	  }

	  public int charCount() {
	    return charCount;
	  }

	  public int wordCount() {
	    return wordCount;
	  }

	  public int lineCount() {
	    return lineCount;
	  }

	  public int vocabCount() {
	    return vocabCount;
	  }

	  public Vocabulary getVocabulary() {
	    return vocabulary;
	  }

	  /**
	   * Reads from the aggregated input stream, parsing
	   * the read characters in order to count the number
	   * of characters, words, and lines.
	   * @throws IOException
	   */
	  public void parse() throws IOException {
		    Counters.WordCount_parse_count++;
			long start = System.nanoTime();
		    char c;
		    int r;
		    // variable that tells if the last character, read from the stream,
		    // was a separator character or any other character
		    boolean lastCharNotSeparator = false;
		    r = reader.read();
		    Word word = new Word();
		    while (r != -1) {
		      c = (char) r;
		      switch (c) {
		      // characters that are word separators:
		      case '(':
		      case ')':
		      case '.':
		      case ',':
		      case ':':
		      case ';':
		      case ' ':
		    	if(lastCharNotSeparator) {
		    		if(vocabulary.add(word) == word) {
		    			vocabCount++;
		    		}
		    		word = new Word();
		    		
			        lastCharNotSeparator = false;
			        wordCount++;
		    	}
		        break;
		      // character that marks the end of a line,
		      // also a separator
		      case '\n':
		    	  lineCount++;
		    	  if(lastCharNotSeparator) {
		    		  if(vocabulary.add(word) == word) {
			    			vocabCount++;
			    		}
		    		  word = new Word();
		    		  
			        lastCharNotSeparator = false;
			        wordCount++;
		    	  }
		        break;
		      // all other characters are not separators, 
		      // they are making up words
		      default:
		        lastCharNotSeparator = true;
		        word.add(c);
		      }
		      r = reader.read();
		      charCount++;
		    }
		    if(lastCharNotSeparator) {
		    	if(vocabulary.add(word) == word) {
	    			vocabCount++; 
	    		}
		    	wordCount++;
		    }
		    long end = System.nanoTime();
			Counters.WordCount_parse_elapsed += end-start;
		  }
	}
