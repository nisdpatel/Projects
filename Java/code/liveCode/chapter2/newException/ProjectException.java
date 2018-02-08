// File ProjectException.java - file defining my custom Exception class.  A newly
// created object merely passes the message to the super class constructor.
// copyright, Michael G. Qualls, 2007.

package chapter2.newException;

// here is an exception class that extends class Exception.  Thus,
// creating a checked exception that must be handled


public class ProjectException extends Exception {
	static final long serialVersionUID = 0L;

	// first a no-arg constructor, since we define one with arguments
	public ProjectException () {   }
	
	// now, a constructor with its string message
	public ProjectException (String message) {
		
	
		// last, invoke the superclass constructor to do its thing
		super (message);
	}  // end constructor
	
}  // end class ProjectException
