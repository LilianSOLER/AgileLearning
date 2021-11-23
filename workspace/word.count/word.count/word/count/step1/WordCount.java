package word.count.step1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WordCount {

  private int charCount;
  private int wordCount;
  private int lineCount;
  private InputStreamReader reader;

  /**
   * Construct a word count.
   * @param is
   */
  public WordCount(InputStreamReader reader) {
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
    return 0;
  }

  /**
   * Reads from the aggregated input stream, parsing
   * the read characters in order to count the number
   * of characters, words, and lines.
   * @throws IOException
   */
  public void parse() throws IOException {
    char c;
    int r;
    // variable that tells if the last character, read from the stream,
    // was a separator character or any other character
    boolean lastCharNotSeparator = false;
    r = reader.read();
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
	        lastCharNotSeparator = false;
	        wordCount++;
    	}
        break;
      // character that marks the end of a line,
      // also a separator
      case '\n':
    	  lineCount++;
    	  if(lastCharNotSeparator) {
	        lastCharNotSeparator = false;
	        wordCount++;
    	  }
        break;
      // all other characters are not separators, 
      // they are making up words
      default:
        lastCharNotSeparator = true;
      }
      r = reader.read();
      charCount++;
    }
    if(lastCharNotSeparator) {
    	wordCount++;
    }
  }
}
