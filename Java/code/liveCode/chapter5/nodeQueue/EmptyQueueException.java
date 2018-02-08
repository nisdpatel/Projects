package chapter5.nodeQueue;

public class EmptyQueueException extends RuntimeException {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public EmptyQueueException () {   }
	
	// now, a constructor with its string message
	public EmptyQueueException (String message) {
			
		// last, invoke the superclass constructor to do its thing
		super (message);
	}  // end constructor
	
}  // end class EmptyQueueException
