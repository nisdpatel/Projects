// File - GameEntry.java - adaptation of Code Fragment 3.1, p. 96 of DSAiJ by
// Goodrich, et. al.  Developed in solution of exercise P-3.3, p. 152.  See the test
// driver for a more complete problem statement.
// Mike Qualls, 10/15/07

package chapter5.nodeQueue;

public class GameEntry {
	// instance variables
	protected String name;
	protected int score;
	
	// methods, constructor first
	public GameEntry (String name, int score) {
		this.name = name;
		this.score = score;
	}  // end constructor with arguments
	
	// gets (set values via the constructor)
	public String getName () { return name; }
	public int getScore () { return score; }
	
	// generate a string representation of an object
	public String toString () {
		return "(" + name + ", " + score + ")";
	}  // end method toString

}  // end class GameEntry
