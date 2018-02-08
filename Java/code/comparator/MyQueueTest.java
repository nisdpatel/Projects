/**
 * Class MyQueueTest - the test driver class intended to validate the operation
 * of our MyQueue class.  The class demonstrates several things:
 * 	1)generation of random numbers
 * 	2)definition of inner classes
 * 	3)instantiation of Comparator subclass objects.
 * 	4)creation and manipulation of different types of MyQueue objects.
 * Copyright, Michael G. Qualls, 2007.
 *
 * @since 11/2/07
 * @Developed by Mike Qualls
 */

/* Modified:  11/18/08.  This is now Lab #5, complete with a queue of Auto objects */

package comparator;

import java.util.Random;


public class MyQueueTest  {

	/**
	 * main - the main method of the class.
	 * @param args - the String array containing any command line arguments
	 */
	public static void main(String[] args) {
		// declare local variables/objects.  Note that I create two MyQueue objects
		// of different generic type.
		int number;
		final int SIZE_OF_QUEUE = 50;
		Random generator = new Random ();  // random number generator
		
		// create the queues
		MyQueue<Integer> queue = new MyQueue<Integer> ();	// queue of Integer
		MyQueue<String> queue1 = new MyQueue<String> ();	// queue of String
		MyQueue<Auto> autos = new MyQueue<Auto> ();
		
		// enqueue 50 Integer objects
		for (int count = 0; count < SIZE_OF_QUEUE; count++) {
			number = 1 + generator.nextInt (100);
			queue.enqueue (number);
		}  // end for loop to populate queue
		
		System.out.println ("Queue queue Unsorted: " + queue);
		
		// sort the queue.  Create an IntegerComparator object and pass as an argument.
		// since IntegerComparator is "inner" to class MyQueue, we need to use this syntax.
		// i.e. app.new IntegerComparator<Integer> ().  This is the only purpose of app.
		queue.sort (new IntegerComparator<Integer> ());
		System.out.println ("Queue queue Sorted: " + queue + "\n\n");
					
		// create and do the same for a String queue
		queue1.enqueue ("Mike");
		queue1.enqueue ("Mike");
		queue1.enqueue ("Zeke");
		queue1.enqueue ("Ally");
		queue1.enqueue ("Cam");
		queue1.enqueue ("Mike");
		queue1.enqueue ("Frank");
		queue1.enqueue ("Bill");
		System.out.println ("Queue queue1 Unsorted: " + queue1);
		queue1.sort (new StringComparator<String> ());
		System.out.println ("Queue queue1 Sorted: " + queue1 + "\n\n");
		
		// now, do the same for autos.  Build the queue, print it, sort it, and print again
		autos.enqueue (new Auto ("Chevy", "Camaro", 2500.0, 340));
		autos.enqueue (new Auto ("Pontiac", "Firebird", 2500.0, 340));
		autos.enqueue (new Auto ("Cadilac", "DeVille", 30000.0, 165));
		autos.enqueue (new Auto ("Volvo", "S-241", 2500.0, 340));
		autos.enqueue (new Auto ("Dodge", "Viper", 20000.0, 500));
		autos.enqueue (new Auto ("Chrysler", "Woody", 12000.0, 80));
		autos.enqueue (new Auto ("Honda", "Wagon", 7500.0, 87));
		autos.enqueue (new Auto ("Yamaha", "Bendo", 22500.0, 125));
		autos.enqueue (new Auto ("Toyota", "Prius", 33000.0, 60));
		autos.enqueue (new Auto ("Isuzu", "Sneeze", 11000.0, 120));
		
		System.out.println ("Queue autos Unsorted: " + autos);
		autos.sort (new AutoComparator<Auto> ());
		System.out.println ("Queue autos Sorted: " + autos);
		
	
	}  // end method main

	/**
	 * IntegerComparator - inner class that implements my Comparator interface.
	 * As such, it must provide a definition for the compareTo () method.  I do
	 * a rather 'kludgy' comparison of Integers, and return appropriate integer values.
	 * This will provide a 'functor like' capability to a Java program.  (A functor
	 * in C++ is a function address that can be passed to another function.)
	 * 
	 */
	private static class IntegerComparator<T> implements Comparator<T> {
		
		/**
		 * compareTo - the method to compare two Integer objects.
		 * 
		 * @param left - the argument value that would be on the "left" of any
		 * comparison operator.
		 * @param right - the argument value that would be on the "right" of any
		 * comparison operator.
		 * 
		 * @return - return an int value: -1 if left is less than right, 0 if 
		 * they are equal, and 1 if left is greater than right.
		 */
		public int compareTo (T left, T right){
			int status = 0;
			Integer i1 = (Integer)left;
			Integer i2 = (Integer)right;
			if (i1 > i2) status = 1;
			if (i1 == i2) status = 0;
			if (i1 < i2) status = -1;
			return status;
		}  // end method compareTo				
	}  // end class IntegerComparator
	
	/**
	 * StringComparator - inner class that implements my Comparator interface.
	 * As such, it must provide a definition for the compareTo () method.  I simply
	 * call the String class implementation of the compareTo () method.
	 * 
	 * @author Mike Qualls
	 *
	 * @param <T> - the generic type parameter used during runtime instantiation
	 * of a class object.
	 * 
	 */
	private static class StringComparator<T> implements Comparator<T> {
		
		/**
		 * compareTo - method to compare two String objects.  Use the corresponding
		 * String method.
		 * 
		 * @param left - the argument value that would be on the "left" of any
		 * comparison operator.
		 * @param right - the argument value that would be on the "right" of any
		 * comparison operator.

		 * @return - return an int value: -1 if left is lexicographiclly less than
		 * right, 0 if they are equal, and 1 if left is lexicographically more than
		 * right.  (I think I have that right.)
		 */
		public int compareTo (T left, T right) {
			String s1 = (String) left;
			String s2 = (String) right;
			return (s1.compareTo (s2));
		}  // end method compareTo
	}  // end class StringComparator
	
	// here is the Comparator class for Autos
	private static class AutoComparator<T> implements Comparator<T> {
		public int compareTo (T left, T right) {
			Auto auto1 = (Auto)left;
			Auto auto2 = (Auto)right;
			int status = 0;
			
			// calculate the $ cost per horse of horsePower
			double ratioAuto1 = auto1.getCost () / auto1.getHorsePower ();
			double ratioAuto2 = auto2.getCost () / auto2.getHorsePower ();
			
			// now, do the comparison setting the value status
			if (ratioAuto1 > ratioAuto2) status = 1;
			if (ratioAuto1 == ratioAuto2) status = 0;
			if (ratioAuto1 < ratioAuto2) status = -1;
			
			return status;

		}  // end method compareTo
	}  // end inner class AutoComparator<T>
	
}  // end class MyQueueTest
