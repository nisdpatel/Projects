// File PositionList.java.  Adapted from Code Fragment 6.5, p. 235 of "Data Structures and
// Algorithms in Java", Goodrich et.al.
// Define the PositionList ADT that identifies the operations on a list that is
// "position" aware.  Later, the ADT will be implemented with a double linked list
// of nodes.
// Operations will work with and return positions, rather than the elements themselves.
// In that sense, a Position wraps an element value.  The concept of position 
// allows us to identify the elements previous to and after a given element.
// Defined to be generic.  Can be used to wrap the Deque ADT implemented with a
// double linked list.
// 
// After initial implementation, add an iterator capability.
// Mike Qualls


package chapter6.positionList;

import java.util.Iterator;

public interface PositionList<E> extends Iterable<E> {
	public int size ();				// return the number of elements in the list
	public boolean isEmpty ();		// is the list empty
	public Position<E> first ()
			throws EmptyListException;	// return the first node/position in the list
	public Position<E> last ()
			throws EmptyListException;		// return the last
	public Position<E> next (Position<E> p)
			  throws InvalidPositionException,
			  			BoundaryViolationException;	// returns node/position after p
	public Position<E> prev (Position<E> p)
			  throws InvalidPositionException,
			  			BoundaryViolationException;	// returns node/position before p
	public void addFirst (E e);		// insert element at front of list
	public void addLast (E e);		// insert element at back
	public void addAfter (Position<E> p, E e)
			throws InvalidPositionException;		// insert after a given node
	public void addBefore (Position<E> p, E e)
			throws InvalidPositionException;		// insert before a given node
	public E remove (Position<E> p)
			throws InvalidPositionException;		// remove and return a node
	public E set (Position<E> p, E e)
			throws InvalidPositionException;		// replace an element with a new
													// one and return the old
	public Iterator<E> iterator ();					// return a list iterator
}  // end interface PositionList

