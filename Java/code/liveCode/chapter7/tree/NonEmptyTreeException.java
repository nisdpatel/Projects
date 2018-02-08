// File NonEmptyTreeException.java - exception class to handle an empty
// tree.
// Mike Qualls

package chapter7.tree;

public class NonEmptyTreeException extends RuntimeException {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public NonEmptyTreeException () {   }
		
	// now, a constructor with its string message
	public NonEmptyTreeException (String message) {
			
		// last, invoke the superclass constructor to do its thing
		super (message);
	}  // end constructor
		
}  // end class NonEmptyTreeException

