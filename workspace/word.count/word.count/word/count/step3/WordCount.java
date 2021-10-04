package word.count.step3;

import java.io.IOException;
import java.io.InputStreamReader;

public class WordCount {

  private int charCount;
  private int wordCount;
  private int lineCount;

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
    return 0;
  }

  public Vocabulary getVocabulary() {
    return vocabulary;
  }

  public void parse() throws IOException {
    // TODO: copy from previous step (step2)
    throw new RuntimeException("NYI");
  }

}
