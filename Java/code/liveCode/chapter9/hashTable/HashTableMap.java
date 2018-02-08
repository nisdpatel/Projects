// HashTableMap.java - an implementation file for the Map interface.  Utilizes the MAD
// compression function that transforms a hash code into an integer in the range
// 0 <= n <= N-1, where N is the size of the bucket array.  Also, utilize a linear
// probe algorithm to handle collisions.

package chapter9.hashTable;
import chapter6.positionList.*;

public class HashTableMap<K, V> implements Map <K,V> {
	// real quick, an inner class
	public static class HashEntry<K, V> implements Entry<K, V> {
		// instance variables
		protected K key;
		protected V value;
		
		// a constructor and the get methods
		public HashEntry (K key, V value) {
			this.key = key;
			this.value = value;
		}  // end constructor
		public K getKey () { return key; }
		public V getValue () { return value; }
		public V setValue (V value) {
			V oldValue = value;
			this.value = value;
			return oldValue;
		}  // end method setValue
		
		// a method override to perform an equals comparison of HashEntry objects
		public boolean equals (Object o) {
			// local variables/objects
			HashEntry<K, V> ent;
			
			// do the evaluation in a try block, doing a cast of the Object parameter to
			// a HashEntry object
			try {
				ent = (HashEntry<K, V>)o;
			}  // end try block
			catch (ClassCastException ex) {
				return false;
			}  // end catch block to handle improper casts
			
			// normal return after the cast
			return (ent.getKey () == key) && (ent.getValue () == value);
		} // end method equals			
	}  // end inner class HashEntry

	// now, start the HashTableMap stuff
	protected Entry<K, V> AVAILABLE = new HashEntry<K, V> (null, null);
	protected int n = 0;
	protected int prime, capacity;
	protected Entry<K, V> bucket [];		// the bucket array reference
	protected long scale, shift;
	
	// constructors, with different arguments
	public HashTableMap (int cap) {
		// call the constructor expecting two arguments
		this (109345121, cap);
	}  // end constructor with one argument
	public HashTableMap (int prime, int capacity) {
		this.prime = prime;
		this.capacity = capacity;
	
		// allocate space for the array, performing a cast to ensure the right type of
		// storage.
		bucket = (Entry<K, V> []) new Entry [capacity];
		
		// a random number generator
		java.util.Random rand = new java.util.Random ();
		scale = rand.nextInt (prime - 1) + 1;
		shift = rand.nextInt (prime);
	} // end constructor with two arguments
	
	// determine validity of key
	public void checkKey (K key) throws InvalidKeyException {
		if (key == null)
			throw new InvalidKeyException ("Invalid key: null.");
	} // end method checkKey
	
	// Mad compression function to generate a number in the range 0 < n < N-1
	public int hashValue (K key) {
		return (int) ((Math.abs (key.hashCode () * scale + shift) % prime) % capacity);		
	}  // end method hashValue
	
	// the interface methods
	public int size () { return n; }
	public boolean isEmpty () { return (n == 0); };
	
	public V get (K key) throws InvalidKeyException {
		int i = findEntry (key);
		if (i < 0)
			return null;
		return bucket [i].getValue ();
	}  // end method get
	
	public V put (K key, V value) throws InvalidKeyException {
		int i = findEntry (key );
		
		// does this key have a previous value
		if (i >= 0)
			// it does.  Replace it and return the old one
			return ((HashEntry<K, V>)bucket [i]).setValue (value);
			
		// check the distribution
		if (n >= capacity / 2) {
			rehash ();		// reallocate space and hash aain to keep load factor to 0.5
								// or less, and find again the entry
			i = findEntry (key);
		} // end if n >= capacity / 2
		bucket [-i - 1]= new HashEntry<K, V>(key, value);
		n++;
		return null;
	} // end method put
				
	public V remove (K key) throws InvalidKeyException {
		int i = findEntry (key);
		if (i < 0)
			return null;
		V toReturn = bucket [i].getValue();
		bucket [i] = AVAILABLE;
		n--;
		return toReturn;
	}// end method remove
	
	// return an iterable collection of keys
	public Iterable<K> keys () {
		PositionList<K> keys = new NodePositionList<K> ();
		
		for (int i = 0; i < capacity; i++)
			if ((bucket [i] != null) && (bucket [i] != AVAILABLE))
				keys.addLast (bucket [i].getKey ());
		return keys;
	}  // end method keys
	
	// return an iterable collection of values
	public Iterable<V> values () {
		PositionList<V> vals = new NodePositionList<V> ();
		
		for (int i = 0; i < capacity; i++)
			if ((bucket [i] != null) && (bucket [i] != AVAILABLE))
				vals.addLast (bucket [i].getValue ());
		return vals;
	}  // end method values
	
	// return an iterable collection of Entry objects
	public Iterable<Entry<K, V>> entries () {
		PositionList<Entry<K, V>> ents =
								new NodePositionList<Entry<K, V>> ();
		for (int i = 0; i < capacity; i++)
			if ((bucket [i] != null) && (bucket [i] != AVAILABLE))
				ents.addLast (bucket [i]);
		return ents;			
	}  // end method entries
	
	protected int findEntry (K key) throws InvalidKeyException {
		int avail = -1;
		checkKey (key);
		int i = hashValue (key);
		int j = i;
		
		// now, loop/scan through the bucket array
		do {
			Entry<K, V> e = bucket [i];
			if (e == null) {
				if (avail < 0)
					avail = i;
				break;
			} // end if e == null
			
			// have we found the key
			if (key.equals (e.getKey ()))
				return i;
			if (e == AVAILABLE) {
				if (avail < 0)
					avail = i;
				break;
			} // end if AVAILABLE
			i = (i + 1) % capacity;;
		} while (i != j);
		return -(avail + 1);
	} // end method findEntry
			
	// now, to improve distribution, do a rehash
	protected void rehash () throws InvalidKeyException {
		// double the capacity and save a reference to the old array
		capacity *= 2;
		Entry<K, V> old [] = bucket;
		
		// allocate a new array
		bucket = (Entry<K, V> []) new Entry [capacity];
		
		// generate new MAD factors for this array
		java.util.Random rand = new java.util.Random ();
		scale = rand.nextInt (prime - 1) + 1;
		shift = rand.nextInt (prime);
		
		// now, copy the entries
		for (int i = 0; i < old.length; i++) {
			Entry<K, V>e = old [i];
			if ((e != null) && (e != AVAILABLE)) {
				int j = -1 - findEntry (e.getKey ());
				bucket [j] = e;
			}  // end if e ...
		}  // end loop to copy entries	
	}  // end method rehash
	
}  // end class HashTableMap
