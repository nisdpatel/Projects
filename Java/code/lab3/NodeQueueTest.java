// File NodeQueueTest.java - test driver that creates a node queue from the
// author's net.datastructures set of classes.  Instantiate as a Queue of
// type Integer (or int).  Add elements as in the lab description:
/*  enqueue(5), enqueue(3), dequeue(), enqueue(2), enqueue(8), dequeue(), 
 *  dequeue(), enqueue(9), enqueue(1), dequeue(), enqueue(7), enqueue(6), 
 *  dequeue(), dequeue(), enqueue(4), dequeue(), dequeue().
 *  Mike Qualls
*/

package lab3;

import net.datastructures.*;

public class NodeQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare local variables/objects
		NodeQueue<Integer> myQueue = new NodeQueue<Integer> ();
		
		myQueue.enqueue (5);		// let compiler "box" this to Integer
		myQueue.enqueue (3);
		System.out.println ("1: " + myQueue.dequeue ());
		myQueue.enqueue (2);
		myQueue.enqueue (8);
		System.out.println ("2: " + myQueue.dequeue ());
		System.out.println ("3: " + myQueue.dequeue ());
		myQueue.enqueue (9);
		myQueue.enqueue (1);
		System.out.println ("4: " + myQueue.dequeue ());
		myQueue.enqueue (7);
		myQueue.enqueue (6);
		System.out.println ("5: " + myQueue.dequeue ());
		System.out.println ("6: " + myQueue.dequeue ());
		myQueue.enqueue (4);
		System.out.println ("7: " + myQueue.dequeue ());
		System.out.println ("8: " + myQueue.dequeue ());
		
	}  // end method main
  
}  // end class NodeQueueTest


