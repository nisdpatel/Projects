/**
 * Queue - an interface for a generic queue.  Defines the operations to be provided
 * by concrete classes that implement the interface.  Adapted from Code Fragment
 * 5.13, p. 206 of "Data Structures and Algorithms in Java", Goodrich and
 * Tamassia, 4th edition., 2006.
 *
 */

package comparator;

/**
 * Queue - interface class to identify the operations to be performed on a "concrete"
 * queue object.  These must be implemented in any class that implements interface
 * Queue.
 * 
 * @author Mike Qualls
 *
 * @param <T> - the generic type parameter used to instantiate objects of the proper
 * type at runtime.
 * 
 */
public interface Queue<T> {

	// the methods
	public int size ();
	public boolean isEmpty ();
	public T front () throws EmptyQueueException;
	public void enqueue (T element);
	public T dequeue () throws EmptyQueueException;
	
}  // end Queue interface
