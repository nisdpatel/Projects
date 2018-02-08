// File LinkedList.java - create and instantiate a concrete SLinkedList object.
// The parametric type - String - has to agree for both nodes and the list.
// (Of course).  This is my test driver to test the SLinkedList and Node classes.
// copyright, Michael G. Qualls, 2007.

package chapter3.linkedList;

public class SLinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare local variables/objects
		SLinkedList<String> list = new SLinkedList<String> ();
		Node<String> node;
		
		// create a new node and place on list
		node = new Node<String> ("Mike", null);
		list.addFirst (node);
		node = new Node<String> ("Sue", null);
		list.addFirst(node);
		
		long size = list.getSize ();
		for (int i = 0; i < size; i++) {
			node = list.removeFirst ();
			System.out.printf ("Node: %s\n", node.getElement ());
		}  // end loop to traverse list
	}  // end method main

}  // end class SLinkedListTest
