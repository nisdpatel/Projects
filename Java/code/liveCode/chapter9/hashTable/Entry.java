// File Entry.java - interface file for the Entry interface.  Adapted from Code
// Fragment 8.1, p. 322 of the test by Mike Qualls

package chapter9.hashTable;

public interface Entry<K, V> {
	/** returns the key of this Entry object */
	public K getKey ();
	
	/** returns the value of this Entry object */
	public V getValue ();
}  // end interface Entry

