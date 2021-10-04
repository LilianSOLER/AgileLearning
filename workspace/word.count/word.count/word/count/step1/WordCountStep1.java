package word.count.step1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WordCountStep1 {

  public static void main(String[] args) throws Exception {
    WordCount wc;
    InputStreamReader reader;
    if (args.length == 0) {
      System.out.println("Please type some text and then Ctrl-D");
      reader = new InputStreamReader(System.in);
      wc = new WordCount(reader);
      wc.parse();
      reader.close();
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
          reader = new InputStreamReader(is,"UTF-8");
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
      }
      if (args.length != 1) {
        System.out.println("Totals:");
        System.out.printf("\tVocab\tLines\tWords\tChars\n");
        System.out.printf("\t%d\t%d\t%d\t%d \n", nvocabs, nlines, nwords, nchars);
      }
    }
  }
}
