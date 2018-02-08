// File: ScoresTest.java - the test driver for a Scores array of GameEntry objects
// Author: Mike Qualls

package lab2;

public class ScoresTest {

	public static void main(String[] args) {
		// declare local variables/references
		GameEntry entry;
		Scores theMall;
		
		// create the Scores object
		theMall = new Scores ();
		
		// create and add some GameEntry objects
		entry = new GameEntry ("Mike", 500);
		theMall.add (entry);
		entry = new GameEntry ("Sue", 2000);
		theMall.add (entry);
		entry = new GameEntry ("Bill", 750);
		theMall.add (entry);
		entry = new GameEntry ("John", 550);
		theMall.add (entry);
		entry = new GameEntry ("Mary", 2200);
		theMall.add (entry);
		entry = new GameEntry ("Sam", 250);
		theMall.add (entry);
		entry = new GameEntry ("Harry", 650);
		theMall.add (entry);
		entry = new GameEntry ("Jack", 4000);
		theMall.add (entry);
		entry = new GameEntry ("Matt", 775);
		theMall.add (entry);
		
		
		
		// show the array of scores
		System.out.printf ("Scores for the Mall: %s\n", theMall);
		
		// remove an entry, in this case, should be the highest score
		theMall.remove (0);
		
		// show the array of scores
		System.out.printf ("\n\nScores for the Mall After Removal: %s\n", theMall);
		
		
	}  // end method main

}  // end class ScoresTest
