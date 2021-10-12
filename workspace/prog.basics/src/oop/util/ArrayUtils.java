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
	  int sum = 0;
	  for(int i = off; i < off+len; i++) {
    	sum += values[i];
    }
	  return sum;
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
	  float sum = 0;
	  for(int i = off; i < off+len; i++) {
    	sum += values[i];
    }
	  return sum;
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
    return sum(values,off,len)/len;
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
	  return sum(values,off,len)/len;
  }

  /**
   * Makes a copy of the given array, creating a new array.
   * 
   * @param src
   * @return the copy
   */
  public static int[] copy(int[] src) {
	  int len = src.length;
	  int[] aux = new int[len];
	  for(int i = 0;i < len; i++) {
		  aux[i] = src[i];
	  }
	  return aux;
  }

  /**
   * Copies values from the source array into the destination array.
   * 
   * @param dst, the destination array
   * @param src, the source array
   * @throws IllegalArgumentException if the two arrays are the same object
   */
  public static void copy(int[] dst, int[] src) {
	  if(dst == src) {
		  throw new IllegalArgumentException();
	  }
	  int len = src.length;
	  for(int i = 0;i < len; i++) {
		  dst[i] = src[i];
	  }
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
	  if(dst == src) {
		  throw new IllegalArgumentException();
	  }
	  for(int i = dstOffset;i < dstOffset+offset; i++) {
		  dst[i] = src[i];
	  }
  }

  /**
   * Makes a copy of the given source array into the destination array
   * 
   * @param src, the source array
   * @return the copy
   * @throws IllegalArgumentException if the two arrays are the same object
   */
  public static float[] copy(float[] src){
	  float[] dst = new float[src.length];
	    copy(dst, 0, src, 0, src.length);
	    return dst;
  }

  /**
   * Copies values from the source array into the destination array
   * 
   * @param dst, the destination array
   * @param src, the source array
   * @throws IllegalArgumentException if the two arrays are the same object
   */
  public static void copy(float[] dst, float[] src) {
	  copy(dst, 0, src, 0, src.length);
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
  public static void copy(float[] dst, int dstOffset, float[] src, int offset, int length){
	  if(dst == src) {
		  throw new IllegalArgumentException();
	  }
	  for(int i = dstOffset;i < offset+length; i++) {
		  dst[i] = src[i];
	  }
  }

  /**
   * Sorts the values in the given array
   * 
   * @param array of values to sort
   */
  public static void bubbleSort(float[] array) {
	  int n = array.length;
	  float tmp = 0;
	    for(int j = 0; j < n; j++) {
	    	for(int i = 1; i < (n-j); i++) {
	    		if(array[i-1] > array[i]) {
	    			tmp = array[i-1];
	    			array[i-1] = array[i];
	    			array[i] = tmp;
	    		}
	    	}
	    }
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
	  int n = array.length;
	  int tmp = 0;
	    for(int j = 0; j < n; j++) {
	    	for(int i = 1; i < (n-j); i++) {
	    		if(array[i-1] > array[i]) {
	    			tmp = array[i-1];
	    			array[i-1] = array[i];
	    			array[i] = tmp;
	    		}
	    	}
	    }
  }

  public static void sort(int[] array) {
    bubbleSort(array);
  }
}
