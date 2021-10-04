package about.streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScoreLedger {

  String[] names;
  int[] scores;
  int nscores;

  ScoreLedger(int size) {
    names = new String[size];
    scores = new int[size];
  }

  public String toString() {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < nscores; i++) {
      b.append(names[i]);
      b.append(" ");
      b.append(scores[i]);
      b.append(", ");
    }
    return b.toString();
  }

  /**
   * @return the size of the ledger
   */
  public int size() {
    return names.length;
  }

  /**
   * @return the number of top scores in the ledger
   */
  public int nscores() {
    return nscores;
  }

  /**
   * @param i
   * @return the player name at the given rank
   */
  public String name(int i) {
    return names[i];
  }

  /**
   * @param i
   * @return the player score at the given rank
   */
  public int score(int i) {
    return scores[i];
  }

  /**
   * Declares a new score.
   * The new score will be kept if it enters the top 
   * ranked scores already memorized.
   * @param name
   * @param score
   * @return
   */
  public boolean newScore(String name, int score) {
    for (int i = 0; i < nscores; i++) {
      if (score > scores[i]) {
        for (int j = nscores; j > i; j--) {
          scores[j] = scores[j - 1];
          names[j] = names[j - 1];
        }
        names[i] = name;
        scores[i] = score;
        nscores++;
        return true;
      }
    }
    if (nscores < scores.length) {
      names[nscores] = name;
      scores[nscores++] = score;
      return true;
    }
    return false;
  }

  /**
   * Loads the score ledger from the given stream
   * @param dis
   * @throws IOException
   */
  public void load(DataInputStream dis) throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Save the score ledger in the given stream
   * @param dos
   * @throws IOException
   */
  public void save(DataOutputStream dos) throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Just a simple demo program, creating a simple ledger,
   * saving it, and then reloading it.  
   * @param args
   * @throws IOException
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws IOException, FileNotFoundException {

    ScoreLedger sl1 = new ScoreLedger(10);
    sl1.newScore("Trinity", 625000);
    sl1.newScore("Smith", 400000);
    sl1.newScore("Morpheus", 500000);
    sl1.newScore("Neo", 980000);

    File file = new File("scores");
    DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
    sl1.save(dos);
    dos.close();

    ScoreLedger sl2 = new ScoreLedger(10);
    DataInputStream dis = new DataInputStream(new FileInputStream(file));
    sl2.load(dis);
    dis.close();
    if (sl2.size() != 10)
      fail();
    if (sl2.nscores() != 4)
      fail();
    if (!sl2.name(0).equals("Neo") || sl2.score(0) != 980000)
      fail();
    if (!sl2.name(1).equals("Trinity") || sl2.score(1) != 625000)
      fail();
    if (!sl2.name(2).equals("Morpheus") || sl2.score(2) != 500000)
      fail();
    if (!sl2.name(3).equals("Smith") || sl2.score(3) != 400000)
      fail();
    System.out.println("Passed.");
    System.exit(0);
  }

  static void fail() {
    System.err.println("Failed.");
    System.exit(-1);
  }
}
