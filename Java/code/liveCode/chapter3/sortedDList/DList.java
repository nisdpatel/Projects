// file DList.java - implementation of a double linked list adapted from the author's
// class definition Code Fragment, p. 125.

package chapter3.sortedDList;

public class DList<V> {
	// instance variables
	protected int size;
	protected DNode<V> header, trailer;
	
	// methods, constructor(s) first
	public DList () {
		size = 0;
		header = new DNode<V> (null, null, null);
		trailer = new DNode<V> (null, null, null);
		
		// have the header refer to the trailer and the trailer refer to the
		// header
		header.setNext(trailer);		// initialize the list to empty
		trailer.setPrevious (header);
	}  // end constructor with args
	
	// information/access methods
	public int getSize () { return size; }
	public boolean isEmpty () { return (size == 0);};
	
	// start returning nodes, first and last
	public DNode<V> getFirst () throws IllegalStateException {
		if (isEmpty ())
			throw new IllegalStateException ("List is empty");
		return header.getNext ();
	} // end method getFirst
	public DNode<V> getLast () throws IllegalStateException {
		if (isEmpty ())
			throw new IllegalStateException ("List is empty");
		return trailer.getPrevious ();
	}  //end method getLast
	
	// return nodes before and after
	public DNode<V> getPrevious (DNode<V> v) throws IllegalArgumentException {
		if (v == header)
			throw new IllegalArgumentException (
					    "Cannot move back past the header of the list" );
		return v.getPrevious ();
	}  // end method getPrevious
	public DNode<V> getNext (DNode<V> v) throws IllegalArgumentException {
		if (v == trailer)
			throw new IllegalArgumentException (
					    "Cannot move forward past the trailer of the list" );
		return v.getNext ();
	}  // end method getNext
	
	// now add nodes to the list
	public void addBefore (DNode<V>v, DNode<V>z) throws IllegalArgumentException {
		DNode<V> u = getPrevious (v);
		
		z.setPrevious (u);
		z.setNext (v);
		v.setPrevious (z);
		u.setNext (z);
		size++;
	}  // end method addBefore	
	public void addAfter (DNode<V> v, DNode<V>z) {
		DNode<V> w = getNext (v);
		z.setPrevious (v);
		z.setNext (w);
		w.setPrevious (z);
		v.setNext (z);
		size++;
	}  // end method addAfter
		
	// insert at the head or the tail
	public void addFirst (DNode<V> v){
		addAfter (header, v);
	}  // end method addFirst
	public void addLast (DNode<V> v) {
		addBefore (trailer, v);
	}  // end method addLast
	
	// remove a node
	public void remove (DNode<V> v) {
		DNode<V> u = getPrevious (v);	// may generate an exception
		DNode<V> w = getNext (v);
		
		// unlink from the list
		w.setPrevious (u);
		u.setNext (w);
		v.setPrevious (null);
		v.setNext (null);
		size--;
	}  // end method remove
		
	// some helpers
	public boolean hasPrevious (DNode<V> v) { return v != header; }
	public boolean hasNext (DNode<V> v) { return v != trailer; }
	
	public String toString () {
		String s = "[";
		DNode<V> v = header.getNext ();
		while (v != trailer) {
			s += v.getElement ();
			v = v.getNext ();
			if (v != trailer)
				s += ", ";
		}  // end while loop to traverse through the list
		s += "]";
		return s;
	}  // end method toString
	
	// adapt Code Fragment 3.28, p. 133 of the text and make the insertion sort
	// method a member of the class
	public void sort () {
		DNode<V> pivot;
		DNode<V> ins;
		DNode<V> end = getFirst ();  // end of run
		
		// check size of list first
		if (size <= 1)
			return;		// empty or one item list
		
		// do for each item in the list
		while (end != getLast ()) {
			pivot = end.getNext ();
			remove (pivot);
			ins = end;
			
			// start comparing from the end of the already sorted items.  Create 
			// my own compareTo in order to cast arguments to the proper type (in
			// this case String) and to use the String compareTo method.
			// is there a node to the left of ins and is it lexicographically
			// greater than pivot.  If so, move left.
			while (hasPrevious (ins) && 
						(compareTo (ins.getElement (), pivot.getElement())) > 0)
				ins = ins.getPrevious ();  // move left
			
			//add pivot back and change end if necessary
			addAfter (ins, pivot);
			if (ins == end)
				end = end.getNext ();
		}  // end while loop
		
	}  // end method sort
	
	//  a type specific compareTo designed to work with two String arguments.  Your task
	// should you accept it, is to develop a generic class DList that takes a method
	// reference/address as an argument (argument to go along with type when the type
	// specific DList is instantiated).  compareTo then becomes a generic method that
	// is instantiated when the DList is instantiated.  (This can be done in C++.  Can
	// it be done in Java?)
	public int compareTo (V op1, V op2) {
		String left = (String)op1;
		String right = (String)op2;

		return left.compareTo (right);		
	}  // end my method compareTo
	
}  // end class DList
