package chapter8.priorityQueue;

public class EmptyPriorityQueueException extends RuntimeException {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public EmptyPriorityQueueException () {   }
	
	// now, a constructor with its string message
	public EmptyPriorityQueueException (String message) {
			
		// last, invoke the superclass constructor to do its thing
		super (message);
	}  // end constructor
}  // end class EmptyPriorityQueueException
