// File InvalidKeyException.java - exception class to handle an invalid
// key.
// Mike Qualls

package chapter10.binarySearchTree;

public class InvalidKeyException extends RuntimeException {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public InvalidKeyException () {   }
			
	// now, a constructor with its string message
	public InvalidKeyException (String message) {
				
		// last, invoke the superclass constructor to do its thing
		super (message);
	}  // end constructor
			
}  // end class InvalidKeyException
