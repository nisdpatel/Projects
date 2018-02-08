// File InvalidKeyException.java - exception class to handle an invalid
// key.
// Mike Qualls

package chapter9.hashTable;

public class InvalidKeyException extends Exception {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public InvalidKeyException () {   }
			
	// now, a constructor with its string message
	public InvalidKeyException (String message) {
				
		// last, invoke the superclass constructor to do its thing
		super (message);
	}  // end constructor
			
}  // end class InvalidKeyException
