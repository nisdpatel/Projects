package chapter6.positionList;

public class NoSuchElementException extends RuntimeException {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public NoSuchElementException () {   }
		
	// now, a constructor with its string message
	public NoSuchElementException (String message) {
			
		// last, invoke the superclass constructor to do its thing
		super (message);
	}  // end constructor
		
}  // end class NoSuchElementException

