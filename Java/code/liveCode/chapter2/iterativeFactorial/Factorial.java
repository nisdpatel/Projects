// File Factorial.java - a class definition to calculate factorial numbers.  One
// solution will use an iterative approach, the other recursive.
// copyright, Michael G. Qualls, 2007.

package chapter2.iterativeFactorial;

public final class Factorial {
	// instance variables
	
	public static int iterativeFactorial (int number) {
		// declare local variables
		int factorial = 1;
		
		// calculate iteratively
		if (number == 0)
			return factorial;
		else {
			for (int i = 1; i <= number; i++)
				factorial *= i;
			return factorial;
		}  // end else if number == 0
					
	}  // end method iterativeFactorial
	
	// adopted from Code Fragment 3.29, p. 135
	public static int recursiveFactorial (int number) {
		// start with the terminating test
		if (number == 0)
			return 1;
		else
			return (number * recursiveFactorial (number - 1));
			
	}  // end method recursiveFactorial

}  // end class Factorial
