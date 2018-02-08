// File:  Auto.java - this is the class definition of what an Auto is.  The goal will
// be to create a queue of Auto objects, and then to sort that queue using an over-
// ridden compareTo () method that performs an auto comparison.

package comparator;

public class Auto {
	// declare instance variables
	String make;
	String model;
	double cost;
	int horsePower;
	
	// methods - constructors first
	public Auto () {
		// set all to a defined state
		make = null;
		model = null;
		cost = 0.0;
		horsePower = 0;
	}
	public Auto (String make, String model, double cost, int horsePower) {
		setMake (make);
		setModel (model);
		setCost (cost);
		setHorsePower (horsePower);
	}
	
	// sets/gets
	public void setMake (String make) {
		this.make = make;
	}
	public void setModel (String model) {
		this.model = model;
	}
	public void setCost (double cost) {
		this.cost = cost;
	}
	public void setHorsePower (int horsePower) {
		this.horsePower = horsePower;
	}
	public String getMake () {
		return make;
	}
	public String getModel () {
		return model;
	}
	public double getCost () {
		return cost;
	}
	public int getHorsePower () {
		return horsePower;
	}
	
	// generate a String representation
	public String toString () {
		return String.format ("Make: %s, Model: %s, Cost/Horse Ratio: %.2f",
								getMake (), getModel (), getCost () / getHorsePower ());
	}  // end method toString

}  // end class Auto
