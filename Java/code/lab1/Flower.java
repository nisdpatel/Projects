// File: Flower.java - model flowers, name, price petals
// Author: Mike Qualls

package lab1;

public class Flower 
{
	// instance variables
	private String name;
	private int numberPetals;
	private float price;
	
	// methods
	public Flower () {
		setName ("A Flower");
		setNumberPetals (3);
		setPrice (1.50f);
	}
	public Flower (String name, int numberPetals, float price) {
		setName (name);
		setNumberPetals (numberPetals);
		setPrice (price);
		
	}
	
	// sets/gets
	public void setName (String name) {
		this.name = name;
	}
	public String getName () {
		return name;
	}
	public void setNumberPetals (int numberPetals) {
		this.numberPetals = numberPetals;
	}
	public int getNumberPetals () {
		return numberPetals;
	}
	public void setPrice (float price) {
		this.price = price;
	}
	public float getPrice () {
		return price;
	}
	
	// generate a string representation
	public String toString () {
		return String.format ("Flower: %s, Number of Petals: %d, Price: $%.2f", getName (),
															getNumberPetals (), getPrice ());
	}  // end method toString
	

}  // end class Flower
