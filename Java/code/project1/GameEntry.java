// File - GameEntry.java - reimplementation of the GameEntry class.  Adaptation
// of C.F. 3.1, p. 100 of the author's text.
// Copyright, M. Qualls, 9/20/11.

package project1;

public class GameEntry {
	// declare instance variables
	protected String name;
	protected int score;
	
	public GameEntry (String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName () { return name; }
	public int getScore () { return score; }
	public void setName (String name) { this.name = name; }
	public void setScore (int score) { this.score = score; }
	
	public String toString () {
		return "(" + name + ", " + score + ")";
	}  // end method toString

}  // end class GameEntry
