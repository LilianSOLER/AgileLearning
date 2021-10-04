package object.collections.step3;

public interface IList {

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

  Iterator iterator();

  /**
   * @return the length of the list
   */
  int length();

  /**
   * @param index
   * @return the element at the given index, if the index is valid.
   * @throws IndexOutOfBoundsException otherwise.
   */
  Object elementAt(int index);

  /**
   * Updates the element at the given index, if the index is valid.
   * @param index
   * @throws IndexOutOfBoundsException otherwise.
   */
  Object updateAt(int index, Object niu);

  /**
   * Insert the element at the given index.
   * Nota Bene: if the index is greater than the list length,
   *            the list is grown.
   * @param index
   * @param elem
   * @throws IndexOutOfBoundsException if the index is negative.
   */
  void insertAt(int index, Object elem);

  /**
   * Removes the element at the given index, if the index is valid.
   * @param index
   * @throws IndexOutOfBoundsException otherwise.
   */
  Object removeAt(int index);

  /**
   * Remove the element if found, otherwise does nothing
   * @param index
   * @return true if the element was found and removed
   */
  boolean remove(Object elem);

  /**
   * @param elem
   * @return true if the element is in the list.
   */
  boolean contains(Object elem);

  /**
   * Copies the list elements to the given array
   * @param elems
   */
  void toArray(Object elems[]);

}