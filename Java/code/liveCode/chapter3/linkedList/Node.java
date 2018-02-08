// File Node.java - a file to define a generic Node class.  Adapted from Code
// Fragment 3.12, p. 116.  Add the use of generics to the text definition
// copyright, Michael G. Qualls, 2007.


package chapter3.linkedList;

public class Node<V> {
	// instance variables
	private V element;
	private Node<V> next;
	
	// methods, constructor first
	public Node () {
		this (null, null);		// call the constructor with two args
	}  // end no argument constructor
	public Node (V element, Node<V> next) {
		this.element = element;
		this.next = next;
	}  // end constructor with arguments
	
	// set/get methods
	public V getElement () { return element; }
	public Node<V> getNext () { return next; }
	public void setElement (V element) { this.element = element; }
	public void setNext (Node<V> next) { this.next = next; }

}  // end class Node
