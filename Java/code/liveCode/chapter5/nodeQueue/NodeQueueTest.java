package chapter5.nodeQueue;

public class NodeQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare local variables/objects
		NodeQueue<GameEntry> scores = new NodeQueue<GameEntry> ();
		GameEntry entry;
		
		// create and enqueue some objects
		entry = new GameEntry ("Mike", 740);
		scores.enqueue (entry);
		entry = new GameEntry ("Jan", 520);
		scores.enqueue (entry);
		
		try {
			System.out.printf ("Entry: %d\n", scores.dequeue ().getScore ());
			System.out.printf ("Entry: %d\n", scores.dequeue ().getScore () );
			System.out.printf ("Entry: %d\n", scores.dequeue ().getScore () );
		}
		catch (Exception except) {  
			System.err.print ("Empty Queue\n");
		}
		
	}  // end method main

}  // end class NodeQueueTest
