// File ThrowsException.java - objects of this class will throw a custom
// exception.
// copyright, Michael G. Qualls, 2007.


package chapter2.newException;

public class ThrowsException {
	// instance variables
	// none
	
	// methods (allow the compiler to supply a no-argument constructor)
	// even though the exception will be handled in processData, need to
	// declare a throws to keep the compiler happy for stack unwinding
	public void run () throws ProjectException {
		
		// call our function
		processData ();
		
	}  // end method run

	public void processData () throws ProjectException {
		// declare local variables
		String progress = "Working on Project Data";
		int number1 = 1, number2 = 2, sum = 0;
		
		// here is our try block
		try {
			// let's get started\
			System.out.println (progress);
			sum = number1 + number2;
			if (sum < 1000)
				throw new ProjectException ("You took too long");
		} // end try block
		catch (ProjectException exception) {
			// better to use a logger for this message, but ...
			System.err.println ("There's  been a project error");
			System.err.printf("%s\n\n", exception.getMessage ());
			exception.printStackTrace ();
			
			// run without and with the following statement.  View the
			// different handling, and that the last println statement
			// doesn't execute
//			   sum = sum / 0;
		}  // end catch block.  Let execution proceed with next statement
		   // (unless the stack has to unwind)
		
		// proceed after the last catch clause.  Don't have a finally
		// clause, but execution would proceed after that
		System.out.println ("\n\nOK.  Glad you fixed the problem.");
		
	}  // end method processData
	
}  // end class ThrowsException
