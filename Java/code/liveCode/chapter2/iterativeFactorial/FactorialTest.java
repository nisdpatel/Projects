// File FactorialTest.java - the test driver for my Factorial class.
// copyright, Michael G. Qualls, 2007.

package chapter2.iterativeFactorial;

public class FactorialTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare local variables/objects
		int number;
		
		// calculate and display some factorial numbers
		number = 5;
		System.out.printf ("Number = %d, Iterative calculation = %d\n", number,
											Factorial.iterativeFactorial (number));
		System.out.printf ("Number = %d, Recursive calculation = %d\n", number,
				Factorial.recursiveFactorial (number));

	}  // end method main

}  // end class FactorialTest
