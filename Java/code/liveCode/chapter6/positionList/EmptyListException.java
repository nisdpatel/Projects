// File EmptyListException.java - created in order to complement the NodePositionList
// implementation of a PositionList interface.
// Mike Qualls

package chapter6.positionList;

public class EmptyListException extends RuntimeException {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public EmptyListException () {   }
	
	// now, a constructor with its string message
	public EmptyListException (String message) {
		
		// last, invoke the superclass constructor to do its thing
		super (message);
	}  // end constructor
	
}  // end class EmptyListException
 