// File NodePositionListTest.java - test driver to use the operations of Example 6.3,
// p. 250 of the text to create and exercise a NodePositionList object.
// Mike qualls

package chapter6.positionList;

public class NodePositionListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare local variables/objects
		NodePositionList<Integer> list;
		Position<Integer> p = null;
		list = new NodePositionList<Integer> ();
		/* Interestingly, I need to use the Integer class resulting in a collection of
		 * objects.  There are a number of forum posts on this problem.  This is a
		 * feature of the Java Collections Framework.  Because PositionList is a type of
		 * Iterable?
		 */
		
		// add first element 8 to the list - [8]
		list.addFirst (8);
		System.out.println ("List: " +  NodePositionList.toString (list));

		try {
			// get the position of the first element 8 and add the second element after
			p = list.first ();
			list.addAfter (p, 5);
			// print the resultant list
			System.out.println ("List after addAfter: " +
												 NodePositionList.toString (list));
				
			// get the position of the second element 5 and add the next element 3
			// before - [8, 3, 5]
			p = list.next (p);
			list.addBefore (p, 3);
			System.out.println ("List after addBefore: " +
					 NodePositionList.toString (list));
			
			// add element 9 to the beginning of the list - [9, 8, 3, 5]
			list.addFirst (9);
			System.out.println ("List after addFirst: " +
					 NodePositionList.toString (list));
			
			// get the position of the first element and remove it - [8, 3, 5]
			p = list.first ();
			list.remove (p);
			System.out.println ("List after removeFirst: " +
					 NodePositionList.toString (list));
			
			// set the value of position 3 to 7.  This illustrates that the position of an element
			// does not change.  The element 5 is in position 2 and the element 3 is in position 3.
			p = list.first ();
			p = list.next (p);
			list.set (p, 7);
			System.out.println ("List after set: " +
									NodePositionList.toString (list));
			
			// test addAfter and print using the second toString method - the one that overrides Object
			// toString
			list.addAfter (list.first (), 2);
/*			System.out.println ("List after addAfter: " +
									NodePositionList.toString (list)); */
			System.out.println ("List after addAfter: " + list);
			
//			System.out.println ("List after addAfter: " + list);
			

		}  // end try block
		catch (EmptyListException exception) {  }
		catch (InvalidPositionException exception) {  }
		catch (BoundaryViolationException exception) {  }
	}  // end method main

}  // end 
