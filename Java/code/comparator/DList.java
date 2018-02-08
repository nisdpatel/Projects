/**
 * Class DList - a 'concrete' class defining a double linked list.  It is
 * adapted from the author's text book, with heavy modifications certainly
 * in development of a sort () method that accepts a Comparator object.  This
 * allows the implementation of 'functor' like capability.  (Functor - a C++
 * term used to refer to a function that is passed as an argument to a function.)
 *
 * @since 11/2/07
 * @Developed by Mike Qualls
 */

package comparator;

/**
 * DList - the generic double linked list class.  Adapted from "Data Structures
 * and Algorithms in Java", Goodrich and Tamassia, Code Fragment 3.22 p. 125.
 */
public class DList<V> {
	/**
	 * size - the number of elements in the list.
	 */
	protected int size;
	
	/**
	 * header - reference to the null sentinel node at the front of the list.
	 * trailer - reference to the null sentinel node at the rear of the list.
	 */
	protected DNode<V> header, trailer;
	
	/**
	 * DList () - the no argument constructor.  Create header and trailer nodes
	 * (sentinel nodes in the words of the authors) and set them to refer to each
	 * other.  List size is set to 0.
	 */
	public DList () {
		size = 0;
		header = new DNode<V> (null, null, null);
		trailer = new DNode<V> (null, null, null);
		
		// have the header refer to the trailer and the trailer refer to the
		// header
		header.setNext(trailer);		// initialize the list to empty
		trailer.setPrevious (header);
	}  // end constructor with args
	
	/**
	 * getSize () - return an int, the number of elements in the list.
	 */
	public int getSize () { return size; }
	
	/**
	 * isEmpty () - return a boolean, true if list is empty otherwise false.
	 */
	public boolean isEmpty () { return (size == 0);};
	
	/**
	 * getFirst - return a node reference.  The node that header.getNext () refers
	 * to.
	 */
	public DNode<V> getFirst () throws IllegalStateException {
		if (isEmpty ())
			throw new IllegalStateException ("List is empty");
		return header.getNext ();
	} // end method getFirst
	
	/**
	 * getLast - return a node reference.  The node that trailer.getPrevious () 
	 * refers to.
	 */
	public DNode<V> getLast () throws IllegalStateException {
		if (isEmpty ())
			throw new IllegalStateException ("List is empty");
		return trailer.getPrevious ();
	}  //end method getLast
	
	/**
	 * getPrevious - return a node reference.  The node that the previous
	 * reference refers to.
	 */
	public DNode<V> getPrevious (DNode<V> v) throws IllegalArgumentException {
		if (v == header)
			throw new IllegalArgumentException (
					    "Cannot move back past the header of the list" );
		return v.getPrevious ();
	}  // end method getPrevious
	
	/**
	 * getNext - return a node reference.  The node that the next reference
	 * refers to.
	 */
	public DNode<V> getNext (DNode<V> v) throws IllegalArgumentException {
		if (v == trailer)
			throw new IllegalArgumentException (
					    "Cannot move forward past the trailer of the list" );
		return v.getNext ();
	}  // end method getNext
	
	/**
	 * addBefore - insert a node into the list s.t. it is in front of another.
	 */
	public void addBefore (DNode<V>v, DNode<V>z) throws IllegalArgumentException {
		DNode<V> u = getPrevious (v);
		
		z.setPrevious (u);
		z.setNext (v);
		v.setPrevious (z);
		u.setNext (z);
		size++;
	}  // end method addBefore
	
	/**
	 * addAfter - insert a node into the list s.t. it is after another.  Added
	 * by Mike Qualls to assist in maintaining an ordered list.
	 */
	public void addAfter (DNode<V> v, DNode<V>z) {
		DNode<V> w = getNext (v);
		z.setPrevious (v);
		z.setNext (w);
		w.setPrevious (z);
		v.setNext (z);
		size++;
	}  // end method addAfter
		
	/**
	 * addFirst - take a node and place it at the front of the list s.t. the
	 * header node refers to it in its next reference.
	 */
	public void addFirst (DNode<V> v){
		addAfter (header, v);
	}  // end method addFirst
	
	/**
	 * addLast - take a node and place it at the end of the list s.t. the
	 * trailer node refers to it in its previous reference.
	 */
	public void addLast (DNode<V> v) {
		addBefore (trailer, v);
	}  // end method addLast
	
	/**
	 * remove - remove a node from the list, doing reference manipulation to 
	 * unlink the node and discard it.  Change size to reflect the removal.
	 */
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
		
	/**
	 * hasPrevious - return a boolean - true if the node has a previous node.
	 */
	public boolean hasPrevious (DNode<V> v) { return v != header; }
	
	/**
	 * toString - method to override the toString () method of class Object
	 * and return a String representation of a list.  Traverse (or walk)
	 * through the list building a string by concatenating the element value
	 * of each node.
	 */
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
	
	/**
	 * sort - method to perform an insertion sort into a list, sorting in
	 * ascending order.  Adapted from "Data Structures and Algorithms in Java",
	 * Goodrich and Tamassia, Code Fragment 3.22 p. 125.  Heavily modified to 
	 * accept a functor (i.e. Comparator class object) to act as a type
	 * specific comparator.  This method will now work with any type of DList.
	 * (Similar in intent to the Java class Comparable.)
	 * 	@author Mike Qualls
	 */
	public void sort (Comparator<V> comp) {
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
			
			// start comparing from the 'end' (actually beginning of the list).  Move
			// items to the right until there is a larger one to the right, or the ones
			// to the right are already sorted.  Use the compareTo method of the Comparator
			// parameter object.  In this fashion, we can sort Strings, Integers, what
			// ever type of Comparator object was created in the test driver.
			while (hasPrevious (ins) && 
						(comp.compareTo (ins.getElement (), pivot.getElement())) > 0)
				ins = ins.getPrevious ();  // move left
			
			//add pivot back and change end if necessary
			addAfter (ins, pivot);
			if (ins == end)
				end = end.getNext ();
		}  // end while loop
		
	}  // end method sort
		
}  // end class DList
