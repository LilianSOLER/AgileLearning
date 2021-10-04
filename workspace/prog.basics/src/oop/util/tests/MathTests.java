package oop.util.tests;

import oop.util.MathUtils;

public class MathTests {

  public static void main(String args[]) {
    System.out.println("Math tests: ");
    Test20();
    Test21();
    Test22();
    Test23();
    System.out.println("PASSED");
  }

  public static void Test20() {
    float error = 0;
    for (float angle = 0F; angle < 2 * MathUtils.PI; angle += 0.01F) {
      error += MathUtils.abs(MathUtils.toRadians(MathUtils.toDegrees(angle)));
    }
    // since the conversions are not exact, there is a cumulative error.
    // The presence and control of such cumulative errors are amongst 
    // the main challenges of accurate numerical simulations.
    AllTests.verify(error != 0F);
  }

  public static void Test21() {
    int f;
    f = MathUtils.factR(1);
    AllTests.verify(f == 1);
    f = MathUtils.factR(3);
    AllTests.verify(f == 6);
    f = MathUtils.factR(4);
    AllTests.verify(f == 24);
    f = MathUtils.factR(5);
    AllTests.verify(f == 120);
  }

  public static void Test22() {
    int f;
    f = MathUtils.factI(1);
    AllTests.verify(f == 1);
    f = MathUtils.factI(3);
    AllTests.verify(f == 6);
    f = MathUtils.factI(4);
    AllTests.verify(f == 24);
    f = MathUtils.factI(5);
    AllTests.verify(f == 120);
  }

  public static void Test23() {
    float f;
    f = MathUtils.power(10F, 0);
    AllTests.verify(f == 1);
    f = MathUtils.power(10F, 3);
    AllTests.verify(f == 1000);
    f = MathUtils.power(10F, -3);
    AllTests.verify(f == .001F);
  }

}
