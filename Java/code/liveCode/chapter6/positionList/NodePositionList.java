// File NodePositionList.java.  Adapted from Code Fragments 6.9-611, pp. 239-241 of
// "Data Structures and Algorithms in Java", Goodrich et.al.  Some operations
// such as addAfter () have been developed by M. Qualls.
// Implement the ADT as a double linked list of nodes that are "aware" of their 
// position.  In fact, Position is used to work with nodes and their element
// values, thus requiring a cast in order to retrieve the element value.
// Defined to be generic.
// Note: Additions are made to the code of PositionList primarily in the area
// exceptions thrown by methods.
// Mike Qualls

package chapter6.positionList;

import java.util.Iterator;

public class NodePositionList<E> implements PositionList<E>  {
	// declare instance variables
	protected int numElts;				// number of elements in the list
	protected DNode<E> header, trailer;	// sentinel nodes as introduced in chapt. 3
	
	// no argument constructor to initialize an empty list
	public NodePositionList () {
		numElts = 0;				// size of zero
		header = new DNode<E> (null, null, null);
		trailer = new DNode<E> (header, null, null);
		header.setNext (trailer);		// header and trailer refer to each other
	}  // end no argument constructor
	
	// the operations of the PositionList interface
	public int size () {return numElts;}
	public boolean isEmpty () {return (numElts == 0);}
	public Position<E> first () throws EmptyListException {
		if (isEmpty ())
			throw new EmptyListException ("List is empty");
		return header.getNext ();		// remember, header is the sentinel node
	}  // end method first
	public Position<E> last () throws EmptyListException {
		if (isEmpty ())
			throw new EmptyListException ("List is empty");
		return trailer.getPrev ();
	}  // end method last
	
	// return a position capable node
	public Position<E> next (Position<E> p)
			throws InvalidPositionException,
						BoundaryViolationException {
		DNode<E> v = checkPosition (p);			// get the node at the position
		DNode<E> nextNode = v.getNext ();
		if (nextNode == trailer)
			throw new BoundaryViolationException (
			"Cannot move past the end of the list");
		return nextNode;
	}  // end method next	
	public Position<E> prev (Position<E> p)		// returns node/position before p
			  throws InvalidPositionException,
			  			BoundaryViolationException {
		DNode<E> v = checkPosition (p);			// get the node at the position
		DNode<E> previousNode = v.getPrev ();
		if (previousNode == header)
			throw new BoundaryViolationException (
						"Cannot advance past the beginning of the list");
		return previousNode;
	}  // end method prev
	
	// the add methods
	public void addFirst (E element) {
		numElts++;
		DNode<E> newNode = new DNode<E> (header, header.getNext (), element);
		
		// set header references
		header.getNext ().setPrev(newNode);
		header.setNext (newNode);
	}  // end method addFirst
	public void addLast (E element) {
		numElts++;
		DNode<E> newNode = new DNode<E> (trailer.getPrev (), trailer, element);
		
		// set trailer references
		trailer.getPrev ().setNext (newNode);
		trailer.setPrev (newNode);
	}  // end method addLast
	
	public void addAfter (Position<E> p, E element)
			throws InvalidPositionException {
		DNode<E> v = checkPosition (p);				// check and get the node (current)
		numElts++;
		
		// create a new node with proper previous and next references
		DNode<E> newNode = new DNode<E> (v, v.getNext (), element);
		
		// now, change the references of node v
		v.getNext ().setPrev (newNode);
		v.setNext (newNode);
	}  // end method addAfter
	public void addBefore (Position<E> p, E element)
			throws InvalidPositionException {
		DNode<E> v = checkPosition (p);				// check and get the node (the current node)
		numElts++;
		
		// create a new node with proper previous and next references
		DNode<E> newNode = new DNode<E> (v.getPrev (), v, element);
		
		// now, change the references of node v
		v.getPrev ().setNext (newNode);		// set next reference of the previous node
		v.setPrev (newNode);				// set previous reference of the current node		
	}  // end method addBefore

	public E remove (Position<E> p)
			throws InvalidPositionException {
		DNode<E> v = checkPosition (p);		// is the position valid
		numElts--;
		
		// get previous and next references of the node we're removing
		DNode<E> vPrev = v.getPrev ();
		DNode<E> vNext = v.getNext ();
		
		//  now, "link out" the v node by: 1)setting the next reference of the
		// previous node to next of v; and 2)setting the previous reference of
		// the next node to the previous of v
		vPrev.setNext (vNext);
		vNext.setPrev (vPrev);
		
		// get the element of the node being removed
		E vElem = v.element ();
		
		// unlink the node and return its element value
		v.setNext (null);
		v.setPrev (null);
		return vElem;		
	}  // end method remove
	
	/**
	 * set - set the element value at a specified position.
	 * @param - p. The specified position whose element value will be
	 * changed.
	 * @param - element- The element value.
	 * @return - E.  Return the old element value.
	 */
	public E set (Position<E> p, E element)
			throws InvalidPositionException {
		DNode<E> v = checkPosition (p);
		E oldElem = v.element ();
		v.setElement (element);
		return oldElem;		
	}  // end method set
	
	// the iterator () method using the ElementIterator class that provides definitions
	// for methods next () and hasNext ().
	public Iterator<E> iterator ()  {
		ElementIterator<E> iter = null;
		try {
			iter = new ElementIterator<E> (this);
		}
		catch (EmptyListException exception) {  }
		
		return iter;
	}  // end method iterator
	
	// method toString that uses our iterator class
	public static <E> String toString (PositionList<E> i) {
		Iterator<E> iter = i.iterator ();
		String s = "[";
		while (iter.hasNext ()) {
			s += iter.next ();		// will be an implicit conversion to String
			if (iter.hasNext ())
				s += ", ";			
		}  // end while
		s += "]";
		return s;
	}  // end method toString
	
	/**
	 * toString () - method that overrides the Object method.
	 */
	public String toString () {
		Iterator<E> iter = this.iterator ();
		String s = "[";
		while (iter.hasNext ()) {
			s += iter.next ();		// will be an implicit conversion to String
			if (iter.hasNext ())
				s += ", ";			
		}  // end while
		s += "]";
		return s;		
	}  // end method toString that overrides Object method
	
	// the utility method to check if a position is valid, and if so, converts
	// it to a DNode
	protected DNode<E> checkPosition (Position<E> p)
							throws InvalidPositionException {
		if (p == null)
			throw new InvalidPositionException ("Null position passed to NodeList");
		if (p == header)
			throw new InvalidPositionException ("The header node is a sentinel only");
		if (p == trailer)
			throw new InvalidPositionException ("The trailer node is a sentinel only");
		
		// handle other exceptions in a try block
		try {
			DNode<E> temp = (DNode<E>) p;		// here is the cast
			if ((temp.getPrev () == null) || (temp.getNext () == null))
				throw new InvalidPositionException (
									"Position does not belong to a valid node list");
			return temp;
		}  // end try block
		catch (ClassCastException e) {
			// the cast didn't work
			throw new InvalidPositionException (
									" Position is of wrong type for this list");	
		}  // end catch block					
	}  // end method checkPosition

}  // end class NodePositionList
