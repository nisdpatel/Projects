// File: Scores.java - implementation of the author's class complete
// with methods 'add' and 'remove'
// Author: Mike Qualls

package lab2;

public class Scores {
	// instance variables
	public static final int MAX_ENTRIES = 10;
	protected int numEntries;
	
	// the array reference of GameEntry objects
	protected GameEntry[] entries;
	
	// methods, constructor(s) first
	public Scores () {
		// allocate array storage and initialize count of objects 
		// to zero
		entries = new GameEntry [MAX_ENTRIES];
		numEntries = 0;
	}  // end default constructor
	
	// the 'add' and 'remove' methods
	public void add (GameEntry e) {
		// the score to add
		int newScore = e.getScore ();
		
		// is the array full
		if (numEntries == MAX_ENTRIES) {
			// is the new entry greater than the last entry
			if (newScore <= entries [numEntries - 1].getScore ())
				// it isn't.  Simply return
				return;
		} // end is the array full
		else	// the array is not full, add to the numEntries value
			numEntries++;
		
		// now, put the new entry in the proper spot
		int i = numEntries - 1;			// why is this initialization done outside the loop
		for ( ; (i >= 1) && (newScore > entries [i - 1].getScore ()); i--)
			entries [i] = entries [i - 1];
		
		// place the new object in the array (and, here's why the initialization)
		entries [i] = e;
					
	}  // end method add
		
	public GameEntry remove (int index) throws IndexOutOfBoundsException {
		// check to see that 'index' is a valid subscript
		if ((index < 0) || (index >= numEntries))
			throw new IndexOutOfBoundsException ("Invalid Index: " + index);
		
		GameEntry temp = entries [index];			// save the object to be removed
		for (int j = index; j < numEntries; j++)
			entries [j] = entries [j + 1];		// move entry to the left overwriting the element
												// being removed
		
		// null out the last score
		entries [numEntries - 1] = null;
		
		// change the count of entries
		numEntries--;
		
		// return the 'removed' object
		return temp;
			
	}  // end method remove
	
	// create a string representation of a Scores object
	public String toString () {
		String s = "[";
		
		// iterate through the array adding strings
		for (int i = 0; i < numEntries; i++) {
			// if not the first object, add the ", "
			if (i > 0)
				s += ", ";
			
			// now add the object depending on the toString of GameEntry
			s += entries [i];
		}  // end loop to add strings
		
		return s + "]";
	}  // end method toString

}  // end class Scores
