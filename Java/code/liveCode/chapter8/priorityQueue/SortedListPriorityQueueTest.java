package chapter8.priorityQueue;

public class SortedListPriorityQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare local variables/references
		SortedListPriorityQueue <Integer, String> queue =
			new SortedListPriorityQueue <Integer, String> ();
		
		// create an object
		queue.insert (5, "A");
		queue.insert (9, "C");
		queue.insert (3, "B");
		queue.insert (7, "D");
		
		// print the queue
		System.out.printf ("The queue is: %s\n", queue);
		
		queue.removeMin ();
		queue.removeMin ();
		queue.removeMin ();
		
		// print again
		System.out.printf ("The queue after removal is: %s\n", queue);
		
	}  // end method main

}  // end class SortedListPriorityQueueTest
