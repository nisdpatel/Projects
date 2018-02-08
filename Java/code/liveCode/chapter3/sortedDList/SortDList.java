package chapter3.sortedDList;

public class SortDList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare local variables/objects
		DList<String> list = new DList<String> ();  // create an empty list
		
		// populate the list
		list.addFirst(new DNode<String> ("Mike", null, null));
		list.addFirst (new DNode<String> ("Qualls", null, null));
		list.addFirst(new DNode<String> ("Bob", null, null));
		list.addFirst (new DNode<String> ("Cat", null, null));
		list.addFirst(new DNode<String> ("Zero", null, null));
		list.addFirst (new DNode<String> ("Max", null, null));
		
		// print the list
		System.out.printf ("List before Sorting: %s\n", list);
		
		// sort the list
		list.sort ();
		
		// print again
		System.out.printf ("List After Sorting: %s\n", list);

	}  // end method main

}  // end class SortDList
