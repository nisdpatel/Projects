// File: FlowerTest.java - the test driver for Flowers
// Author: Mike Qualls

package lab1;

public class FlowerTest {

	public static void main(String[] args) {
		// declare local variables/references
		final int NUMBER_FLOWERS = 5;
		Flower[] flowers = new Flower [NUMBER_FLOWERS];
		
		// create the Flower objects
		flowers [0] = new Flower ("Petunia", 5, 2.50f);
		flowers [1] = new Flower ("Rose", 10, 5.50f);
		flowers [2] = new Flower ("Violet", 4, 2.75f);
		flowers [3] = new Flower ("Iris", 8, 4.45f);
		flowers [4] = new Flower ("Bug", 4, 5.00f);
		
		// display the flowers
		System.out.println ("Flowers before changes");
		for (int count = 0; count < flowers.length; count++)
			System.out.printf ("\tFlower #%d: %s\n", count + 1, flowers [count]);
		
		// change some values
		flowers [1].setPrice (10.0f);
		flowers [4].setNumberPetals (0);
		
		// display the flowers again
		System.out.println ("\n\nFlowers after changes");
		for (int count = 0; count < flowers.length; count++)
			System.out.printf ("\tFlower #%d: %s\n", count + 1, flowers [count]);	

	}  // end method main

}  // end class FlowerTest
