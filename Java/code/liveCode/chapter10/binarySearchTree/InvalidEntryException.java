// File InvalidPositonException.java - created in order to complement the PositionList
// interface.
// Mike Qualls

package chapter10.binarySearchTree;

public class InvalidEntryException extends RuntimeException {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public InvalidEntryException () {   }
	
	// now, a constructor with its string message
	public InvalidEntryException (String message) {
		
		// last, invoke the superclass constructor to do its thing
		super (message);
	}  // end constructor
	
}  // end class InvalidPositionException
