// File Map.java - the interface file defining the operations on a Map.  Adapted
// from the general comments on p. 369 of the text.
// Adapted by M. Qualls, 11/28/07.

package chapter10.binarySearchTree;

public interface Map <K, V> {
	public int size ();
	public boolean isEmpty ();
	public V get (K key) throws InvalidKeyException;
	public V put (K key, V value) throws InvalidKeyException;
	public V remove (K key) throws InvalidKeyException;
	public Iterable<K> keys ();
	public Iterable<V> values ();
	public Iterable<Entry<K, V>> entries ();
		
}  // end interface Map
