package home1;
import chapter6.positionList.*;
import chapter5.nodeStack.EmptyStackException;
import chapter5.nodeStack.NodeStack;


public class ReverseList {

	public static void main(String[] args) {
		// Declare local variables/object references
		GameEntry entry;
		NodePositionList<GameEntry>list = new NodePositionList<GameEntry> ();
		
		// create entries and add them to the list
		entry = new GameEntry ("Mike", 550);
		list.addFirst (entry);
		entry = new GameEntry ("Bill", 656);
		list.addFirst (entry);
		entry = new GameEntry ("Sam", 250);
		list.addFirst (entry);
		entry = new GameEntry ("Mary", 1000);
		list.addFirst (entry);
		entry = new GameEntry ("Sue", 1500);
		list.addFirst (entry);
		entry = new GameEntry ("Ridley", 600);
		list.addFirst (entry);
		entry = new GameEntry ("Goober", 5);
		list.addFirst (entry);
		entry = new GameEntry ("John", 1200);
		list.addFirst (entry);
		
		// print the list
		System.out.printf ("The list before reversal:\n\t%s\n", list);
		
		// reverse elements of the list - letting the method modify the argument
		reverse (list);
		
		// print the list again
		System.out.printf ("\nThe list after reversal:\n\t%s\n", list);
		
	}  // end method main
	
	public static <T> void reverse (NodePositionList<T> list) {
		// declare local variables/object references
		NodeStack<T>stack = new NodeStack<T> ();
		
		// move elements to the stack getting the size first because that will change - also removing them from the list
		int size = list.size ();
		for (int count = 0; count < size; count++) {
			Position<T>position = list.last ();
			stack.push ((T)position.element ());
			list.remove (position);
		}  // end for loop to move entries
			
		// now move them back to the list
		size = stack.size ();
		for (int count = 0; count < size; count++) {
			try {
				list.addFirst ((T)stack.pop ());
			} catch (EmptyStackException e) {
				// don't do much right now
				e.printStackTrace();
			}
		}  // end for statement
				
	}  // end method reverse

}   // end class ReverseList

