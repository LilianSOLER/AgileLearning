package word.count.step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WordCountStep3 {

  static final int NTOP = 10;

  public static void main(String[] args) throws Exception {
    WordCount wc;
    InputStreamReader reader;
    if (args.length == 0) {
      reader = new InputStreamReader(System.in);
      wc = new WordCount(reader);
      wc.parse();
      echoVocab(wc);
      System.out.printf("\tVocab\tLines\tWords\tChars\n");
      System.out.printf("\t%d\t%d\t%d\t%d \n", wc.vocabCount(), wc.lineCount(), wc.wordCount(), wc.charCount());
    } else {
      int nlines = 0, nwords = 0, nchars = 0, nvocabs = 0;
      System.out.printf("\tVocab\tLines\tWords\tChars \n");
      for (int i = 0; i < args.length; i++) {
        String arg = args[i];
        File file = new File(arg);
        InputStream is = new FileInputStream(file);
        if (arg.endsWith(".utf8"))
          reader = new InputStreamReader(is, "UTF-8");
        else
          reader = new InputStreamReader(is);
        wc = new WordCount(reader);
        wc.parse();
        reader.close();
        nlines += wc.lineCount();
        nwords += wc.wordCount();
        nchars += wc.charCount();
        nvocabs += wc.vocabCount();
        System.out.printf("\t%d\t%d\t%d\t%d\t%s\n", wc.vocabCount(), wc.lineCount(), wc.wordCount(), wc.charCount(),
            arg);
        echoVocab(wc);
      }
      if (args.length != 1) {
        System.out.println("Totals:");
        System.out.printf("\tVocab\tLines\tWords\tChars\n");
        System.out.printf("\t%d\t%d\t%d\t%d \n", nvocabs, nlines, nwords, nchars);
      }
    }
    Counters.echo();
  }

  public static void echoVocab(WordCount wc) {
    Vocabulary vocab = wc.getVocabulary();
    if (vocab != null) {
      int nwords = vocab.getWordCount();
      Word[] words = vocab.getWords();
      System.out.printf("Found %d different words within a text of %d words\n", nwords, wc.wordCount());
      for (int j = 0; j < words.length && words[j] != null; j++)
        System.out.printf("\t%d\t%s \n", words[j].noccurrences, words[j].toString());
    } else
      System.out.println("No vocabulary!");
  }

}
