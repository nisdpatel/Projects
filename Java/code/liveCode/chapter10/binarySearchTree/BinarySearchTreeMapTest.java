// File: BinarySearchTreeMapTest - try to develop a test driver for a binary search tree.
// Try - because some of the 'external' methods in BinarySearchTreeMap are missing
// Author: Mike Qualls, 12/10/13


package chapter10.binarySearchTree;

public class BinarySearchTreeMapTest {

	public static void main(String[] args) {
		// declare locals
		BinarySearchTreeMap<Integer, String>map;
		
		// create the tree, using the default constructor that creates a DefaultComparator
		map = new BinarySearchTreeMap<Integer, String> ();
		
		// now, try putting some entries.  Use those of Fig. 10.7
		map.put (44, "One");
		map.put (17, "Two");
		map.put (32,"Three");
		
		map.put (78, "Four");
		map.put (50, "Five");
		map.put (48, "Six");
		map.put (62, "Seven");
		map.put (88, "Eight");
		
		// see if we can print the map
		System.out.printf ("The map is:\n\t%s\n", map);
		
		// see if we can get and print a value
		String value = map.get (48);
		System.out.printf ("\n\nThe value associated with a key of 48 is %s\n", value);
		
	}  // end method main

}  // end class BinarySearchTreeMapTest
