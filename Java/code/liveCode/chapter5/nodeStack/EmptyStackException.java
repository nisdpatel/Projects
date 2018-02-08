package chapter5.nodeStack;

public class EmptyStackException extends Exception {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public EmptyStackException () {   }
	
	// now, a constructor with its string message
	public EmptyStackException (String message) {
			
		// last, invoke the superclass constructor to do its thing
		super (message);
		
	}  // end constructor

}  // end class EmptyStackException
