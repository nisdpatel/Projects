/**
 * File: Entry.java - the interface defining the operations on an Entry object.
 * Mike Qualls
 */


package chapter8.priorityQueue;

public interface Entry<K, V> {
	// return the key and value
	public K getKey ();
	public V getValue ();

}
