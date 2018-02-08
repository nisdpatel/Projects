// File NodeStackTest.java - test driver designed to create and use a node stack.
// Will be used to model a plate dispenser in a cafeteria.  Classes used are:
//
//			Plate - model a plate in the dispenser
//			Stack - ADT providing operations of a stack
// Mike Qualls

package chapter5.nodeStack;

public class NodeStackTest {
	private static final int NUMBER_PLATES = 2;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws EmptyStackException {
		// declare local variables/objects
		Plate plates [] = new Plate [NUMBER_PLATES];
		NodeStack<Plate> dispenser = new NodeStack<Plate> ();

		// create some plates
		plates [0] = new Plate (8, "white");
		plates [1] = new Plate (6, "brown");
		
		// load the dispenser
		load (dispenser, plates);
		
		// now, remove and print them
		System.out.println ("Plates in the dispenser");
		try {
			
			// first, toString
			System.out.printf ("\n\ttoString: %s\n\n", dispenser);

			for (int i = dispenser.size (); i > 0; i--)
				System.out.printf ("\tPlate #%d: %s\n", i, dispenser.pop ());
			
		}  // end try block
		catch (EmptyStackException exception) {
			
			System.err.print ("Exception: ");
			System.err.printf("%s\n\n", exception.getMessage ());
			exception.printStackTrace ();
			
		}// end catch block
	}  // end method main
	
	public static void load (NodeStack<Plate> dispenser, Plate plates []) {
		for (int i = 0; i < plates.length; i++)
			dispenser.push (plates [i]);
	}  // end method load

}  // end class NodeStackTest
