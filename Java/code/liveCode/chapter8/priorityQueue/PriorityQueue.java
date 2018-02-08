/**
 * File:  PriotityQueue.java - the priority queue interface.  Adapted from
 * C.F. 8.4, p. 325 of the text.
 * Mike Qualls
 */


package chapter8.priorityQueue;

public interface PriorityQueue<K, V> {
	// return the size
	public int size ();
	
	//  is it empty?
	public boolean isEmpty ();
	
	// return but do not remove Entry with minimum key
	public Entry<K, V> min () throws EmptyPriorityQueueException;
	
	// return and remove Entry with minimum key
	public Entry<K, V> removeMin () throws EmptyPriorityQueueException;

}  // end interface PriorityQueue
