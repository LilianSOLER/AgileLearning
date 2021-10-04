package oop.util.tests;

public class AllTests {
  
  public static void verify(boolean cond) {
    if (!cond) {
      System.err.println("FAILED");
      throw new AssertionError();
      
    }
  }
  
  public static void main(String args[]) {
    MathTests.main(args);
    ArrayTests.main(args);
  }
}
