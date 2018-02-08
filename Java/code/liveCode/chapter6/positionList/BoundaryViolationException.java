// File BoundaryViolationException.java.  Created in order to allow the definition
// of a PositionList as shown in Code Fragment 6.5, p. 235.
// Make this similar to the other custom exception classes already created.
// Mike Qualls


package chapter6.positionList;

public class BoundaryViolationException extends RuntimeException {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public BoundaryViolationException () {   }
	
	// now, a constructor with its string message
	public BoundaryViolationException (String message) {
		
		// last, invoke the superclass constructor to do its thing
		super (message);
	}  // end constructor
	
}  // end class BoundaryViolationException
