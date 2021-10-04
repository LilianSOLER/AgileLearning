package object.collections.step2;

public class List {

  /** 
   * Inner private class to link elements.  
   * Note that the fields are not private, 
   * they will be accessed directly, from methods
   * on the class List.
   * You may need to add constructors to this class.
   */
  private static class Cell {
    Object elem; // the element
    Cell next;   // the link on the next cell.
    
    Cell(Cell prev, Cell next, Object elem) {
    	throw new IllegalStateException("NotYetImplemented");
    }

    Cell(Object elem) {
    	throw new IllegalStateException("NotYetImplemented");
    }
  }

  Cell head; 	// head of the list of cells
  int ncells;	// number of cells in the list

  /**
   * This is an inner class (because it is solely for this 
   * List implementation, but it is public because it is 
   * of the public behavior defined by the List class.
   * 
   * NOTA BENE: make sure the two methods agree with each other.
   */
  public static class Iterator {
    /**
     * @return true if there is a next element.
     */
    public boolean hasNext() {
    	throw new IllegalStateException("NotYetImplemented");
    }

    /**
     * @return the next element in the list.
     */
    public Object next() {
    	throw new IllegalStateException("NotYetImplemented");
    }
  }

  public Iterator iterator() {
    throw new IllegalStateException("NotYetImplemented");
  }

  public List() {
  }

  /**
   * The list is initialized with the elements found in the 
   * given array. The array will not be aliased.
   */
  public List(Object array[]) {
  	throw new IllegalStateException("NotYetImplemented");
  }

  /**
   * The list is initialized with the elements found in the 
   * given list. 
   */
  public List(List l) {
  	throw new IllegalStateException("NotYetImplemented");
  }

  private void check(int idx) {
    if (idx < 0 || idx >= ncells)
      throw new IndexOutOfBoundsException(Integer.toString(idx));
  }

  public int length() {
  	throw new IllegalStateException("NotYetImplemented");
  }

  /**
   * @param index
   * @return the element at the given index, if the index is valid.
   * @throws IndexOutOfBoundsException otherwise.
   */
  public Object elementAt(int index) {
    check(index);
	throw new IllegalStateException("NotYetImplemented");
  }

  /**
   * Updates the element at the given index, if the index is valid.
   * @param index
   * @throws IndexOutOfBoundsException otherwise.
   */
  public Object updateAt(int index, Object niu) {
    check(index);
	throw new IllegalStateException("NotYetImplemented");
  }

  /**
   * Insert the element at the given index.
   * Nota Bene: if the index is greater than the list length,
   *            the list is grown.
   * @param index
   * @param elem
   * @throws IndexOutOfBoundsException if the index is negative.
   */
  public void insertAt(int index, Object elem) {
  	throw new IllegalStateException("NotYetImplemented");
  }

  /**
   * Removes the element at the given index, if the index is valid.
   * @param index
   * @throws IndexOutOfBoundsException otherwise.
   */
  public Object removeAt(int index) {
  	throw new IllegalStateException("NotYetImplemented");
  }

  /**
   * Remove the element if found, otherwise does nothing
   * @param index
   * @return true if the element was found and removed
   */
  public boolean remove(Object elem) {
  	throw new IllegalStateException("NotYetImplemented");
  }

  /**
   * @param elem
   * @return true if the element is in the list.
   */
  public boolean contains(Object elem) {
  	throw new IllegalStateException("NotYetImplemented");
  }

}
