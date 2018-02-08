// File InvalidPositonException.java - created in order to complement the PositionList
// interface.
// Mike Qualls

package chapter6.positionList;

public class InvalidPositionException extends RuntimeException {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public InvalidPositionException () {   }
	
	// now, a constructor with its string message
	public InvalidPositionException (String message) {
		
		// last, invoke the superclass constructor to do its thing
		super (message);
	}  // end constructor
	
}  // end class InvalidPositionException
