/**
 * Class EmptyQueueException - define a custom exception class to handle the
 * case of an empty queue.  Object constructors (the one with arguments) lets
 * the superclass (Exception) have final handling of the exception.
 *
 * @since 11/2/07
 * @Developed by Mike Qualls
 */
package comparable;

/**
 * EmptyQueueEzception - extend Java class library class Exception.
 * @author Mike Qualls
 *
 */
public class EmptyQueueException extends Exception {
	static final long serialVersionUID = 0L;

	/**
	 * EmptyQueueException - a no argument constructor.  Added simply because
	 * we also define a constructor with arguments.  As a result, the compiler
	 * will not create a default constructor.
	 */
	public EmptyQueueException () {   }
	
	/**
	 * EmptyQueueException - a constructor with arguments.
	 * @param message - the String to be displayed to the user.  Let the super
	 * class, Exception, do that.  As well as provide the exception trace.
	 */
	public EmptyQueueException (String message) {
			
		// last, invoke the superclass constructor to do its thing
		super (message);
		
	}  // end constructor

}  // end class EmptyQueueException
