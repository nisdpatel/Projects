// File: MyQueueTest.java - a test driver that makes use of a 'comparable' class
// Auto and a 'type-free' sort method in class DList
// Author: Mike Qualls


package comparable;

public class MyQueueTest  {

	public static void main(String[] args) {
		// declare local variables/objects.
		MyQueue<Auto> autos = new MyQueue<Auto> ();
		
		// build a queue of autos.  Build the queue, print it, sort it, and print again
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
		autos.sort ();
		System.out.println ("Queue autos Sorted: " + autos);
		
	}  // end method main

	
}  // end class MyQueueTest
