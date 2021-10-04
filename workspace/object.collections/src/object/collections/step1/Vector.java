package object.collections.step1;

public class Vector {

  Object elems[];
  int nelems;

  /*
   * DO NOT IMPLEMENT THIS CLASS UNTIL YOU ARE TOLD TO DO SO.
   */
  public static class Iterator {
    Vector owner;
    Iterator(Vector v) {
      this.owner = v;
    }
    public boolean hasNext() {
      throw new RuntimeException("NYI");
    }
    public Object  next() {
      throw new RuntimeException("NYI");
    }
  }
  
  public Iterator iterator() {
    return new Iterator(this);
  }
  
  /**
   * Constructs an empty vector.
   */
  public Vector() {
    throw new RuntimeException("NYI");
  }

  /**
   * Constructs a vector, initialized with
   * the elements from the given array.
   */
  public Vector(Object array[]) {
    throw new RuntimeException("NYI");
  }
  
  /**
   * Constructs a vector, initialized with
   * the elements from the given vector,
   * effectively making a copy of the given vector.
   */
  public Vector(Vector v) {
    throw new RuntimeException("NYI");
  }

  /**
   * Returns the length 
   */
  public int length() {
    throw new RuntimeException("NYI");
  }

  /**
   * Returns the element at the given index.
   * @param index of the element
   * @return the element
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  public Object elementAt(int index) {
    throw new RuntimeException("NYI");
  }

  /**
   * Replaces the element at the given index by the given element
   * The length of the vector remains the same. 
   * @param index where to replace the element
   * @param niu the new element
   * @return the replaced element
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  public Object updateAt(int index, Object niu) {
    throw new RuntimeException("NYI");
  }

  /**
   * Insert the given element at the given index,
   * making room for the new element, that is,
   * shifting all elements, with a higher indices
   * than the given one, to a higher index by 1 position.
   * The length of the vector is therefore larger by 
   * one element than it was.
   * @param index
   * @param elem
   */
  public void insertAt(int index, Object elem) {
    throw new RuntimeException("NYI");
  }

  /**
   * Removing the element at the given index,
   * shifting all elements, with higher indices than 
   * the given one, to a lower index by 1 position.
   * The length of the vector is therefore smaller by 
   * one element than it was.
   * @param index
   * @return the removed element
   */
  public Object removeAt(int index) {
    throw new RuntimeException("NYI");
  }

  /**
   * Removing the element at the given element,
   * searching for it through the entire vector.
   * The elements with higher indices in the vector
   * are shifted to lower indices by 1 position.
   * The length of the vector is therefore smaller by 
   * one element.
   * @param index
   * @return the removed element
   */
  public boolean remove(Object elem) {
    throw new RuntimeException("NYI");
  }

  /**
   * @param elem
   * @return true if the given element apppears in this vector,
   *         false otherwise.
   */
  public boolean contains(Object elem) {
    throw new RuntimeException("NYI");
  }

}
