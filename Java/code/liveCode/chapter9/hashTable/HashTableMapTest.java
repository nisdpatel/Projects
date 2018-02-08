// File - HashTableMapTest.java.  Test driver to test my HashTableMap implementation.
// Adapt Code Fragment 9.6 p. 388 of the text.  On the command line, accept a file
// name.  The file should be a text file with ASCII text words only.  The test
// driver opens the file, does file I/O, reads the words, and generates a word count.
// (Location of the file may or may not be clear.  In my case, the file "test.txt"
// was placed in my project folder - CSIS294.  Then, in supplying command line
// arguments, I supplied only the file name.
// Mike Qualls, 11/07


package chapter9.hashTable;

import java.io.*;
import java.util.Scanner;

public class HashTableMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, InvalidKeyException {
		// declare locals variables/objects
		Scanner doc = null;
	    File file = null;

	    // Get the file name from the command line
	    if (args.length > 0)
	    	file = new File (args[0]);
	    else
	    	usage ("Must supply a file name on the command line.");

	    // now, open the file
	    try {
	       // Create a scanner to read the file
	       doc = new Scanner (file);
	    } catch (FileNotFoundException e) {
	    	System.out.println ("File not found!");
	    	// Stop program if no file found
	    	System.exit (0);
	    }  // end catch block
		
		doc.useDelimiter ("[^a-zA-Z]");
/*		This appears to be an error in the text - or an inconsistency that won't work
 * 		with HashTableMap as it appears in the text.  Call the constructor expecting
 * 		one argument.  If not big enough, it will be rehashed soon.
 *		HashTableMap<String, Integer> h = new HashTableMap<String, Integer> ();
 **/
		 HashTableMap<String, Integer> h = new HashTableMap<String, Integer> (5000);
		
		String word;
		Integer count;
		
		// loop through the document
		while (doc.hasNext ()) {
			word = doc.next ();
			if (word.equals (""))
				continue;
			
			// convert to all lower case
			word = word.toLowerCase ();
			
			// get the previous count from the map
			count = h.get (word);
			if (count == null)
				// if not in the map, place it there with a count of 1
				h.put( word, 1);
			else
				h.put (word, ++count);
			
		}  // end while statement
		
		// now, iterate through the collection of entries looking for the maximum
		// count
		int maxCount = 0;
		String maxWord = "no word";
		for (Entry<String, Integer> ent : h.entries ()) {
			if (ent.getValue () > maxCount) {
				maxWord = ent.getKey ();
				maxCount = ent.getValue ();
			} // end if ent.getValue ()
		} // end loop to process entries in the map
		
		// now, tell the user
		System.out.printf ("Final map size is %d\n", h.size ());
		System.out.printf ("The most frequent word is: \"" + maxWord);
		System.out.println ("\" with word-count = " + maxCount + ".");
	} // end method main
	
	public static void usage (String msg) {
		System.out.printf ("Usage: %s\n", msg);
		System.exit (1);
	} // end method usage

}  // end class HashTableMapTest
