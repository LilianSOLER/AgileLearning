package oop.games;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Utils {

  private static BufferedReader br;
  private static Random rand;

  public static void initUtils() {
    rand = new Random();
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public static int nextInt() {
    return rand.nextInt();
  }
  public static int nextInt(int bound) {
    return rand.nextInt(bound);
  }
  
  public static String readLine() throws IOException {
    return br.readLine();
  }

  public static char readChar() throws IOException {
    while (true) {
      String line = br.readLine();
      if (line.length() > 0)
        return line.charAt(0);
    }
  }

  public static int readInt() throws IOException {
    while (true) {
      String line = br.readLine();
      if (line.length() > 0)
        return Integer.parseInt(line);
    }
  }

}
