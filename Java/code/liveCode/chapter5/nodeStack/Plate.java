// file Plate.java - a class to simulate a cafeteria plate for use in a dispenser.
// Mike Qualls


package chapter5.nodeStack;

public class Plate {
	// instance variables
	private int size;
	private String color;
	
	// methods - constructors first
	public Plate () {
		size = 0;
		color = null;
	}  // end no argument constructor
	public Plate (int size, String color) {
		this.size = size;
		this.color = color;
	}  // end constructor with arguments
	
	// generate a string representation of a plate
	public String toString () {
		String rep = "[";
		
		rep = rep + "Size: " + size + ", Color: " + color + "]";
		
		return rep;
	}  // end method toString
	
}  // end class Plate
