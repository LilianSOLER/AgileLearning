package oop.util;

/*
 * Need to explain:
 *    multiple parameters to functions.
 *    return value to function.
 *    multiple signatures -> choice based on what the given parameters are.
 */
public class MathUtils {
  /**
   * @param n
   * @return the absolute value of the given argument.
   */
  static public int abs(int n) {
    return Math.abs(n);
  }

  /**
   * @param n
   * @return the absolute value of the given argument.
   */
  static public float abs(float n) {
	  return Math.abs(n);
  }

  /**
   * Compares the two given numbers and return the smallest.
   * @param x,y
   */
  static public int min(int x, int y) {
    return Math.min(x, y);
  }

  /**
   * Compares the two given numbers and return the smallest.
   * @param x,y
   */
  static public float min(float x, float y) {
	  return Math.min(x, y);
  }

  /**
   * Compares the two given numbers and return the largest.
   * @param x,y
   */
  static public int max(int x, int y) {
	  return Math.max(x, y);
  }

  /**
   * Compares the two given numbers and return the largest.
   * @param x,y
   */
  static public float max(float x, float y) {
	  return Math.max(x, y);
  }
  
  /**
   * Compares the two given numbers.
   * @param x,y
   * @return 0 if the two given numbers are equal, 
   *         -1 if the first is less than the second
   *         +1 if the first is greater than the second
   */
  static public int comp(int x, int y) {
    if(x<y) {
    	return -1;
    }
    return 1;
  }

  /**
   * Compares the two given numbers.
   * @param x,y
   * @return 0 if the two given numbers are equal, 
   *         -1 if the first is less than the second
   *         +1 if the first is greater than the second
   */
  static public int comp(float x, float y) {
	  if(x<y) {
	    	return -1;
	    } else if (x == y) {
	    	return 0;
	    }
	    return 1;
  }

  /**
   * Compute the factorial number of the given number.
   *   n! = n * (n-1) * (n-2) * ... * (n - n + 1)
   *   
   * The implementation is an iterative approach, using
   * a loop statement.
   * @param n
   */
  static public int factI(int n) {
    int i = n;
    int res = 1;
    while(0 < i) {
    	res *= i;
    	i--;
    }
    return res;
  }

  /**
   * Compute the factorial number of the given number.
   *   n! = n * (n-1) * (n-2) * ... * (n - n + 1)
   *   
   * The implementation is a recursive approach, using
   * the recursive definition of factorial:
   * 
   *   n! = n * (n-1)!
   *   
   * @param n
   */
  static public int factR(int n) {
    if(n == 1 || n == 0) {
    	return 1;
    }else {
    	return n*factR(n-1);
    }
  }
  
  /**
   * Divides the first number by the second.
   * @param f1
   * @param f2
   * @return f1/f2
   * @throws IllegalArgumentException in the case of divide-by-zero
   */
  static public float divide(float f1, float f2) {
    return f1/f2;
  }

  /**
   * The {@code double} value that is closer than any other to
   * <i>pi</i>, the ratio of the circumference of a circle to its
   * diameter.
   */
  public static final float PI = 3.14159265358979323846F;

  /**
   * Converts an angle measured in degrees to an approximately
   * equivalent angle measured in radians.  The conversion from
   * degrees to radians is generally inexact.
   *
   * @param   angle: an angle given in degrees
   * @return  the measurement of the given angle in radians.
   * @since   1.2
   */
  public static float toRadians(float angle) {
	    return (angle/360)*2*PI;
  }

  /**
   * Converts an angle measured in radians to an approximately
   * equivalent angle measured in degrees.  The conversion from
   * radians to degrees is generally inexact; users should
   * <i>not</i> expect {@code cos(toRadians(90.0))} to exactly
   * equal {@code 0.0}.
   *
   * @param   angle: an angle given in radians
   * @return  the measurement of the given angle in degrees.
   * @since   1.2
   */
  public static float toDegrees(float angle) {
	    return angle/(2*PI)*360;
  }

  /**
   * Returns the value of the first argument raised to the power of the
   * second argument. Special cases:
   *
   * <ul>
   * <li>If the second argument is positive or negative zero, then the
   * result is 1.0.
   * <li>If the second argument is 1.0, then the result is the same as the
   * first argument.
   * </ul>
   * 
   * @param   a   the base.
   * @param   b   the exponent.
   * @return  the value {@code a}<sup>{@code b}</sup>.
   */
  public static float power(float a, int b) {
    return (float) Math.pow(a, b);
  }
}
