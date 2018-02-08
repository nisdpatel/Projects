/**
 * File:  SortedListPriorityQueue.java - a sorted list implementation of a
 * priority queue.  Adapted from code fragments 8.6, 8.7package chapter8.priorityQueue;
 * @author Mike Qualls
 *
 */
package chapter8.priorityQueue;
import chapter6.positionList.*;
import java.util.Comparator;


public class SortedListPriorityQueue<K, V> implements PriorityQueue<K, V> {
	// instance variables/references
	protected PositionList<Entry<K, V>> entries;	// the list
	protected Comparator<K> comp;
	protected Position<Entry<K, V>> actionPos;		// used by subclasses?
	
	// and inner class for entries
	protected static class MyEntry<K, V> implements Entry<K, V> {
		protected K key;
		protected V value;
		
		// constructor
		public MyEntry (K key, V value) {
			this.key = key;
			this.value = value;
		}  // end constructor with two arguments
		
		// methods of the interface
		public K getKey () {return key;}
		public V getValue () {return value;}
		
		//and, toString
		public String toString () {
			// return a string representation of the object
			return (String.format ("[%s, %s]", getKey (), getValue ()));
		}  // end method toString
	}   // end the inner class MyEntry
	
	// a default constructor
	public SortedListPriorityQueue () {
		entries = new NodePositionList<Entry<K, V>> ();
		comp = new DefaultComparator<K> ();
	}  // end default constructor
	
	// constructor with a comparator for a parameter
	public SortedListPriorityQueue (Comparator<K> comp) {
		entries = new NodePositionList<Entry<K, V>> ();
		this.comp = comp;		
	}  // end constructor with parameter
	
	// now, the interface operations
	public int size () {
		return entries.size ();
	}
	
	//  is it empty?
	public boolean isEmpty () {
		return entries.isEmpty();
	}
	
	// return but do not remove Entry with minimum key
	public Entry<K, V> min () throws EmptyPriorityQueueException {
		if (entries.isEmpty ())
			throw new EmptyPriorityQueueException ("Priority queue is empty");
		else
			return entries.first ().element ();		// return the element only
	}  // end method min
	
	// insert a key-value pair
	public Entry<K, V> insert (K key, V value) throws InvalidKeyException {
		checkKey (key);
		Entry<K, V> entry = new MyEntry<K, V> (key, value);
		insertEntry (entry);
		return entry;
	}
	
	// aux method used for insertion
	public void insertEntry (Entry<K, V> e) {
		if (entries.isEmpty ()) {
			entries.addFirst (e);
			actionPos = entries.last ();
		}  // end if isEmpty
		else if (comp.compare (e.getKey (), entries.last ().element ().getKey ()) > 0) {
			entries.addLast (e);
			actionPos = entries.last ();
		}  // end else if
		else {
			Position<Entry<K, V>> curr = entries.first ();
			while (comp.compare (e.getKey (), curr.element ().getKey ()) > 0) {
				curr = entries.next (curr);
			}  // end while
			entries.addBefore (curr, e);
			actionPos = entries.prev (curr);
		}  // end else
	} // end method insertEntry
			
	
	// return and remove Entry with minimum key.  this method depends
	// on the list being sorted at insertion time
	public Entry<K, V> removeMin () throws EmptyPriorityQueueException {
		if (entries.isEmpty ())
			throw new EmptyPriorityQueueException ("Priority queue is empty");
		else
			return entries.remove (entries.first ());
	}  // end method removeMin
	
	// some of the 'helper' methods
	public void checkKey (K key) {
		// somehow, check the key
		
	}  // end method checkKey
	
	public String toString () {
		return entries.toString ();
	}  // end method toString
	
}// end class SortedListPriorityQueue
