package oop.util;

/*
 * Need to explain how to read strings from arguments and get numbers, integers or floats.
 * May be show them with integers, and let them do it for floats
 */
public class ArrayUtils {

  /**
   * Computes the sum of array values 
   * 
   *    sum = (values[off] + ... + values[off+len);
   * 
   * @param values
   * @param off: offset to start from
   * @param len: length to consider
   * @return the sum of the values in the array
   */
  public static int sum(int[] values, int off, int len) {
    throw new RuntimeException("Not Implemented Yet");
  }

  /**
   * Computes the sum of array values sum = (values[off] + ... + values[off+len);
   * 
   * @param values
   * @param off: offset to start from
   * @param len: length to consider
   * @return the sum of the values in the array
   */
  public static float sum(float[] values, int off, int len) {
    throw new RuntimeException("Not Implemented Yet");
  }

  /**
   * Computes the average of array values 
   * 
   *    avg = (values[off] + ... + values[off+len-1])/len;
   * 
   * @param values, an array of values
   * @param off: offset to start from
   * @param len: length to consider
   * @return the average of the values in the array
   */
  public static int average(int[] values, int off, int len) {
    throw new RuntimeException("Not Implemented Yet");
  }

  /**
   * Computes the average of array values 
   * 
   *    avg = (values[off] + ... + values[off+len-1])/len;
   * 
   * @param values, an array of values
   * @param off: offset to start from
   * @param len: length to consider
   * @return the average of the values in the array
   */
  public static float average(float[] values, int off, int len) {
    throw new RuntimeException("Not Implemented Yet");
  }

  /**
   * Makes a copy of the given array, creating a new array.
   * 
   * @param src
   * @return the copy
   */
  public static int[] copy(int[] src) {
    throw new RuntimeException("Not Implemented Yet");
  }

  /**
   * Copies values from the source array into the destination array.
   * 
   * @param dst, the destination array
   * @param src, the source array
   * @throws IllegalArgumentException if the two arrays are the same object
   */
  public static void copy(int[] dst, int[] src) {
    throw new RuntimeException("Not Implemented Yet");
  }

  /**
   * Copies values from the source array into the destination array
   * 
   * @param dst, the destination array
   * @param dstOffset, the offset where to start copying to, in the destination
   *        array
   * @param src, the source array
   * @param offset, the offset where to start copying from, in the source array
   * @param length, the number of values copied
   * @throws IllegalArgumentException if the two arrays are the same object
   */
  public static void copy(int[] dst, int dstOffset, int[] src, int offset, int length) {
    throw new RuntimeException("Not Implemented Yet");
  }

  /**
   * Makes a copy of the given source array into the destination array
   * 
   * @param src, the source array
   * @return the copy
   * @throws IllegalArgumentException if the two arrays are the same object
   */
  public static float[] copy(float[] src) {
    throw new RuntimeException("Not Implemented Yet");
  }

  /**
   * Copies values from the source array into the destination array
   * 
   * @param dst, the destination array
   * @param src, the source array
   * @throws IllegalArgumentException if the two arrays are the same object
   */
  public static void copy(float[] dst, float[] src) {
    throw new RuntimeException("Not Implemented Yet");
  }

  /**
   * Copies values from the source array into the destination array
   * 
   * @param dst, the destination array
   * @param dstOffset, the offset where to start copying to, in the destination
   *        array
   * @param src, the source array
   * @param offset, the offset where to start copying from, in the source array
   * @param length, the number of values copied
   * @throws IllegalArgumentException if the two arrays are the same object
   */
  public static void copy(float[] dst, int dstOffset, float[] src, int offset, int length) {
    throw new RuntimeException("Not Implemented Yet");
  }

  /**
   * Sorts the values in the given array
   * 
   * @param array of values to sort
   */
  public static void bubbleSort(float[] array) {
    throw new RuntimeException("Not Implemented Yet");
  }

  public static void sort(float[] array) {
    bubbleSort(array);
  }

  /**
   * Sorts the values in the given array
   * 
   * @param array of values to sort
   */
  public static void bubbleSort(int[] array) {
    throw new RuntimeException("Not Implemented Yet");
  }

  public static void sort(int[] array) {
    bubbleSort(array);
  }
}
