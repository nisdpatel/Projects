// File: GameEntry.java - adaptation of the author's class
// Author: Mike Qualls

package lab2;

public class GameEntry {
	// instance variables
	private String name;
	private int score;
	
	// methods, constructor(s) first
	public GameEntry (String name, int score) {
		this.name = name;
		this.score = score;
	}  // end constructor
	
	// the get methods
	public String getName () {
		return name;
	}
	public int getScore () {
		return score;
	}
	
	// create string representation with method 'toString'
	public String toString () {
		return "(" + name + ", " + score + ")";
	}  // end method toString

}  // end class GameEntry
