// File Project.java - test my exception class.
// copyright, Michael G. Qualls, 2007.

package chapter2.newException;

public class ExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ProjectException {
		// create an exception generating object
		ThrowsException generator = new ThrowsException ();
		
		generator.run ();
		
	}  // end method main

}  // end class Project


