// File: BinarySearchTreeMap.java - an adaptation of Code Fragments 10.3-10.5.  Even
// though there are many missing methods and/or code, we begin an implementation (12/10/13)
// Author: Mike Qualls

package chapter10.binarySearchTree;
import chapter8.priorityQueue.DefaultComparator;
import chapter7.binaryTree.*;
//import chapter7.tree.*;
import chapter6.positionList.*;

import java.util.*;

public class BinarySearchTreeMap <K, V>
										extends LinkedBinaryTree<Entry<K, V>> implements Map<K, V> {
	// instance variables
	protected Comparator<K> compare;						// the Comparator reference used to compare keys
	protected Position<Entry<K, V>> actionPos; 		// a Position reference used for insertion or removal
	protected int numEntries = 0;									// number of entries in the map
	
	
	// the methods, constructor(s) first, starting with a 'default'
	public BinarySearchTreeMap () {
		compare = new DefaultComparator<K> ();		// use the default (initially for Integers defined for PositionLists)
		addRoot (null);		
	}  // end default constructor
	public BinarySearchTreeMap (Comparator<K> compare) {
		this.compare = compare;
		addRoot (null);
	}  // end constructor with argument
	
	// a nested inner class defining search tree entries
	protected static class BSTEntry <K,V> implements Entry<K, V> {
		// instance variables
		protected K key;
		protected V value;
		protected Position<Entry<K, V>> pos;
		
		// methods, constructor(s) first
		BSTEntry () {  /* this is the default constructor - empty*/  }
		BSTEntry (K key, V value, Position<Entry<K, V>> pos) {
			this.key = key;
			this.value = value;
			this.pos = pos;
		}  // end constructor with args
		
		// the gets and utilities
		public K getKey () { return key;}
		public V getValue () { return value;}
		public Position<Entry<K, V>> position () { return pos;}
	}  // end inner class, BSTEntry
	
	// extract a key
	protected K key (Position<Entry<K, V>> position) {
		return position.element ().getKey ();
	}  // end method key
	
	// extract a value
	protected V value (Position<Entry<K, V>> position) {
		return position.element ().getValue ();
	}  // end method value
	
	// extract an entry
	protected Entry<K, V> entry (Position<Entry<K, V>> position) {
		return position.element ();
	}  // end method entry
	
	// replace an entry
	protected V replaceEntry (Position<Entry<K, V>> position, Entry<K, V> entry) {
		((BSTEntry<K, V>) entry).pos = position;
		return replace (position, entry).getValue ();
	}  // end method replaceEntry
	
	// key check
	protected void checkKey (K key) throws InvalidKeyException {
		if (key == null)		// the author's simple test
			throw new InvalidKeyException ("null key");
	}  // end method checkKey
	
	// entry check
	protected void checkEntry (Entry<K, V> entry) throws InvalidEntryException {
		if ((entry == null) || !(entry instanceof BSTEntry))
			throw new InvalidEntryException ("invalid entry");
	}  // end method checkEntry
	
	// insert entry at an external node
	protected Entry<K, V> insertAtExternal (Position<Entry<K, V>> v, Entry<K, V> e) {
		expandExternal (v, null, null);
		replace (v, e);
		numEntries++;
		return e;
	}  // end method insertAtExternal
	
	private void expandExternal(Position<Entry<K, V>> v, Object object,
			Object object2) {
		// TODO Auto-generated method stub
		
	}
	
	// remove external node and its parent
	protected void removeExternal (Position<Entry<K, V>> v) {
		removeAboveExternal (v);
		numEntries--;
	}  // end method removeExternal
	private void removeAboveExternal(Position<Entry<K, V>> v) {
		// TODO Auto-generated method stub
		
	}
	
	// auxiliary tree search algorithm used by find, insert, remove
	protected Position<Entry<K, V>> treeSearch (K key, Position<Entry<K, V>> pos) {
		// test to see if we are at an external node
		if (isExternal (pos))
			return pos;
		else {
			K curKey = key (pos);
			int comp = compare.compare (key, curKey);
			
			// determine which subtree to 'throw away'
			if (comp < 0)
				return treeSearch (key, left (pos));			// search the left subtree
			else if (comp > 0)
				return treeSearch (key, right (pos));		// search the right subtree
			
			// the key must have been found, return its position
			return pos;
		}  // end else not external
	}  // end method treeSearch
	
	// methods of the Map ADT
	public int size () { return numEntries; }
	public boolean isEmpty () { return size() == 0; }
	
	public V get (K key) throws InvalidKeyException {
		checkKey (key);
		Position<Entry<K, V>> curPos = treeSearch (key, root ());
		actionPos = curPos;
		if (isInternal (curPos))  return value (curPos);
		
		return null;
	}  // end method get
	
	public V put (K k, V x) throws InvalidKeyException {
		checkKey (k);
		
		Position<Entry<K, V>> insPos = treeSearch (k, root ());
		BSTEntry<K, V> e = new BSTEntry<K, V> (k, x, insPos);
		actionPos = insPos;
		if (isExternal (insPos)) {
			return insertAtExternal (insPos, e).getValue ();
		}  // end if isExternal
		
		//  key already exists
		return replaceEntry (insPos, e);
	}  // end method put
	
	public V remove (K k) throws InvalidKeyException {
		checkKey (k);
		
		// search the tree for the one to remove and get its entry
		Position<Entry<K, V>> remPos = treeSearch (k, root ());
		Entry<K, V> toReturn = entry (remPos);
		
		// now, handle the tree collapse
		if (isExternal (left (remPos)))					// easy
			remPos = left (remPos);
		else if (isExternal (right (remPos)))		// easy
			remPos = right (remPos);
		else {
			// now, do the hard one.  Move down the tree looking to reach an external
			Position<Entry<K, V>> swapPos = remPos;
			remPos = right (swapPos);
			do 
				remPos = left (remPos);
			while (isInternal (remPos));
			replaceEntry (swapPos, (Entry<K, V>) parent (remPos).element ());
		}  // end else its the 'hard' one
		
		// remove an external
		actionPos = sibling (remPos);
		removeExternal (remPos);
		return toReturn.getValue ();
	}  // end method remove
	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<Entry<K, V>> entries() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// see if we can delegate a toString to the LinkedBinaryTree
	public String toString () {
		return super.toString ();
	}  // end method toString
	
}  // end class BinarySearchTreeMap
