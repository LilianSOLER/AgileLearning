package edu.polytech.oop.collections;

public interface IMap extends ICollection {

  /**
   * Returns an iterator on the keys in this map.
   */
  Iterator keys();

  /**
   * Returns an iterator on the values in this map.
   */
  Iterator values();

  /**
   * The get method performs a lookup, it finds if the given key is known. 
   * If it is, the associated value is returned, otherwise null is returned.
   * Keys are compared using == and Object.equals(Object)
   */
  Object get(Object key);

  /**
   * The put method adds or updates a pair to the associative collection. 
   * If the key is unknown, the pair is added, and the method returns null. 
   * If the key is known, the value is updated with the given value and 
   * the replaced value is returned.
   * Keys are compared using == and Object.equals(Object)
   */
  Object put(Object key, Object value);

  /**
   * The method remove is fairly straightforward, 
   * it removes the pair identified by the given key from the collection. 
   * If the pair was unknown, null is returned. 
   * Otherwise, the value associated with the given key is returned.
   * Keys are compared using == and Object.equals(Object)
   */
  Object remove(Object key);

  /**
   * The method contains returns true if the map contains a pair
   * with the given key.
   * Keys are compared using == and Object.equals(Object)
   */
  boolean contains(Object key);
  
  /**
   * Copies the keys to the given array
   * @param elems
   */
  void keysToArray(Object elems[]);

  /**
   * Copies the values to the given array
   * @param elems
   */
  void valuesToArray(Object elems[]);


}