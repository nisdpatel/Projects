/**
 * File: Entry.java - the interface defining the operations on an Entry object.
 * Mike Qualls
 */


package chapter10.binarySearchTree;

public interface Entry<K, V> {
	// return the key and value
	public K getKey ();
	public V getValue ();

}
