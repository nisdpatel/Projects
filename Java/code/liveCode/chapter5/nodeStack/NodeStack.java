// file NodeStack.java - adapted from Code Fragment 5.7 of the text.
// This generic class is the implementation of the abstract Stack interface.
// Mike Qualls

package chapter5.nodeStack;

import chapter3.linkedList.*;	

public class NodeStack <E> implements Stack<E> {
	// declare instance variables
	protected Node<E> top;			// reference to the top of the stack
	protected int size;
	
	// methods - constructors first
	public NodeStack () {
		top = null;
		size = 0;
	}  // end constructor with no arguments
	
	// the interface methods
	public int size () { return size; }
	
	public boolean isEmpty (){
		return ((top == null) ? true : false);
	}  // end method isEmpty
	
	public E top () throws EmptyStackException {
		if (isEmpty ())
			throw new EmptyStackException ("Stack is empty.");
		else
			return top.getElement ();		// use the Node class method
	}  // end method top
	
	public void push (E element){
		Node<E> v = new Node<E> (element, top);	// create a new node that refers to
											    // the current top
		top = v;		// set top to point to this node
		size++;			// say we're bigger	
	}  // end method push
	
	public E pop () throws EmptyStackException {
		if (isEmpty ())
			throw new EmptyStackException ("Stack is empty.");
		E temp = top.getElement ();			// create a new data element
		top = top.getNext ();				// set top to be the next node
		size--;								// say we're smaller
		return temp;						// return node from the pop operation			
	}  // end pop method	

	public String toString () {
		String s = "[";
		Node<E> next = top;			// reference to the top of the stack
		
		for (int i = 0; i < size; i++) {
			s += next.getElement () + " ";
			next = next.getNext ();
		} // end for loop
		
		s += "]";
		
		return s;
		
	}  // end method toString
	
}  // end class NodeStack

