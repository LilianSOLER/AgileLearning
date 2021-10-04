package edu.polytech.oop.collections;

public interface ICollection {

  public interface Iterator {

    /**
     * @return true if there is a next element.
     */
    public boolean hasNext();

    /**
     * @return the next element in the list.
     */
    public Object next();
  }

  /** 
   * Iterator on the elements of this collection
   * @return
   */
  Iterator iterator();

  /**
   * @return the length of the list
   */
  int length();

  /**
   * Copies the elements of the collection to the given array
   * @param elems
   */
  void toArray(Object elems[]);

}
