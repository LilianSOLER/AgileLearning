package oop.util.tests;

import java.util.Random;

import oop.util.ArrayUtils;

public class ArrayTests {

  public static void main(String args[]) {
    System.out.print("Array tests: ");
    Test01();
    Test02();
    Test03();
    Test04();
    Test05();
    Test06();
    Test07();
    Test08();
    Test09();
    Test10();
    Test11();
    Test12();
    Test13();
    Test14();
    System.out.println("PASSED");
  }

  public static void Test01() {
    int[] values = new int[] {4,5,6};
    int sum = ArrayUtils.sum(values,0,values.length);
    AllTests.verify(sum == 15);
  }

  public static void Test02() {
    float[] values = new float[] {4.3F,5.2F,6.0F};
    float sum = ArrayUtils.sum(values,0,values.length);
    AllTests.verify(sum == 15.5F);
  }

  public static void Test03() {
    int[] values = new int[] {4,5,6};
    int avg = ArrayUtils.average(values,0,values.length);
    AllTests.verify(avg == 15/3);
  }

  public static void Test04() {
    float[] values = new float[] {4.3F,5.2F,6.0F};
    float avg = ArrayUtils.average(values,0,values.length);
    AllTests.verify(avg == 15.5F/3F);
  }

  public static void Test05() {
    int[] values = new int[] {0, 1, 2, 3, 4,5,6};
    int avg = ArrayUtils.average(values,4,3);
    AllTests.verify(avg == 15/3);
  }

  public static void Test06() {
    float[] values = new float[] {0, 1, 2, 3, 4.3F,5.2F,6.0F};
    float avg = ArrayUtils.average(values,4,3);
    AllTests.verify(avg == 15.5F/3F);
  }

  public static void Test07() {
    int[] values = new int[] {4,5,6};
    int[] copy = ArrayUtils.copy(values);
    AllTests.verify(copy!=null);
    AllTests.verify(copy!=values);
    AllTests.verify(copy.length==values.length);
    for (int i=0;i<copy.length;i++)
      AllTests.verify(copy[i]==values[i]);
  }

  public static void Test08() {
    int[] values = new int[] {4,5,6};
    int[] copy = new int[values.length+10];
    ArrayUtils.copy(copy,values);
    for (int i=0;i<values.length;i++)
      AllTests.verify(copy[i]==values[i]);
    for (int i=values.length;i<copy.length;i++)
      AllTests.verify(copy[i]==0);
  }

  public static void Test09() {
    int[] values = new int[] {4,5,6};
    int[] copy = null;
    try {
      ArrayUtils.copy(copy,values);
      // the above invocation should never return,
      // it should throw an exception
      AllTests.verify(false); 
    } catch (NullPointerException ex) {
      // this is expected.
    }
  }

  public static void Test10() {
    int[] values = new int[] {4,5,6};
    int[] copy = values;
    try {
      ArrayUtils.copy(copy,values);
      // the above invocation should never return,
      // it should throw an exception
      AllTests.verify(false); 
    } catch (IllegalArgumentException ex) {
      // this is expected.
    }
  }

  public static void Test11() {
    int[] values = new int[] { 3,1,6,5,7,4,8 };
    ArrayUtils.sort(values);
    for (int i=0;i<values.length-1;i++)
      AllTests.verify(values[i] <= values[i+1]);
  }

  public static void Test12() {
    int[] values = new int[20];
    Random rand = new Random();
    for (int i=0;i<values.length;i++)
      values[i] = rand.nextInt(1000);
    ArrayUtils.sort(values);
    for (int i=0;i<values.length-1;i++)
      AllTests.verify(values[i] <= values[i+1]);
  }

  public static void Test13() {
    float[] values = new float[] { 3.1F,1.2F,6.4F,5.3F,7.5F,4.6F,8.7F };
    ArrayUtils.sort(values);
    for (int i=0;i<values.length-1;i++)
      AllTests.verify(values[i] <= values[i+1]);
  }

  public static void Test14() {
    float[] values = new float[20];
    Random rand = new Random();
    for (int i=0;i<values.length;i++)
      values[i] = rand.nextFloat();
    ArrayUtils.sort(values);
    for (int i=0;i<values.length-1;i++)
      AllTests.verify(values[i] <= values[i+1]);
  }

}
