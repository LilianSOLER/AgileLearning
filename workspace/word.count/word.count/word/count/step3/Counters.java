package word.count.step3;

public class Counters {

  /**
   * Counters for the class Vocabulary, method add.
   */
  static int Vocabulary_add_count;
  static long Vocabulary_add_elapsed;

  /**
   * Counters for the class Vocabulary, method find.
   */
  static int Vocabulary_find_count;
  static long Vocabulary_find_elapsed;

  /**
   * Counters for the class WordCount, method parse.
   */
  static int WordCount_parse_count;
  static long WordCount_parse_elapsed;

  static public void echo() {
    long elapsed;
    System.out.println("Vocabulary:");
    elapsed = Vocabulary_add_elapsed / 1000L;
    System.out.printf("  add:\t\t%d\t%d us\n", Vocabulary_add_count, elapsed);
    elapsed = Vocabulary_find_elapsed / 1000L;
    System.out.printf("  find:\t\t%d\t%d us\n", Vocabulary_find_count, elapsed);

    System.out.println("WordCount:");
    elapsed = WordCount_parse_elapsed / 1000L;
    System.out.printf("  parse:\t%d\t%d us\n", WordCount_parse_count, elapsed);

  }
}
