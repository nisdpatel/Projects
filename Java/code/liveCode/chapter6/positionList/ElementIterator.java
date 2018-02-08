// File ElementIterator.java.  Adapted from Code Fragment 6.14, p. 245 of "Data Structures and
// Algorithms in Java", Goodrich et.al.
// Define a simple iterator class that implements next () and hasNext () methods for our position
// list.  This does not use the concept of position or the positions () method of Code Fragment
// 6.16.    Note:  This class is specific to PositionList.  NodePositionList has its own iterator
// defined in Code Fragments 6.16 and 6.17.
// Mike Qualls

package chapter6.positionList;

import java.util.Iterator;

public class ElementIterator<E> implements Iterator<E> {
	// instance variables
	protected NodePositionList<E> list;		// the list the iterator works with
	protected Position<E> cursor;			// implement the concept of a current position
	
	// constructor
	public ElementIterator (NodePositionList<E> l)
							throws EmptyListException {
		list = l;
		cursor = (list.isEmpty ()) ? null : list.first ();
	}  // end constructor
	
	public boolean hasNext () {return (cursor != null);}
	public E next () {
		E toReturn = null;
		try {
			if (cursor == null)
				throw new NoSuchElementException ("No next element");
			toReturn = cursor.element ();
			
			// reset the cursor
			cursor = (cursor == list.last ()) ? null : list.next (cursor);
		}  // end try block
		catch (NoSuchElementException exception) { }
		catch (InvalidPositionException exception) { }
		catch (EmptyListException exception) { }
		catch (BoundaryViolationException exception) { }
		
		return toReturn;

	}  // end method next
	
	// go ahead and hack a remove () method to remove the position at the cursor
	public void remove () {
		// wrap the NodePositionList method
		try {
			list.remove (cursor);
		}
		catch (InvalidPositionException exception) {  }  // end catch block
	}  // end method remove
	
}  // end class ElementIterator
