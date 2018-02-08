// File DNode.java.  Adapted from Code Fragment 6.6, p. 236 of "Data Structures and
// Algorithms in Java", Goodrich et.al.
// Define a double linked list node that implements the Position interface.  Thus,
// each node of the linked list will act as positions.  Internally, they are nodes
// of a linked list.  From the outside, they are simply positions in a list.  The
// "details" are abstractd away.
// As before, (my chapter 3) the class is generic.
// Mike Qualls


package chapter6.positionList;

public class DNode<E> implements Position<E> {
	// declare instance variables
	private E element;
	private DNode<E> prev;
	private DNode<E> next;
	
	// constructor with arguments
	public DNode (DNode<E> prev, DNode<E> next, E element) {
		this.prev = prev;
		this.next = next;
		this.element = element;
	}  // end constructor
	
	// sets/gets
	public void setPrev (DNode<E> prev) {this.prev = prev;}
	public void setNext (DNode<E> next) {this.next = next;}
	public void setElement (E element) {this.element = element;}
	public DNode<E> getPrev () {return prev;}
	public DNode<E> getNext () {return next;}
	
	// the method from the Position interface gets an element value
	public E element () throws InvalidPositionException {
		if ((prev == null) && (next == null))
			throw new InvalidPositionException ("Position is not in a list.");
		return element;
	}  // end method element
	
}  // end class DNode
