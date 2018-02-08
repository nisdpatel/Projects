/**
 * Class MyQueue - a 'concrete' class that implements the Queue interface.  As
 * such, it defines all the operations of interface Queue.  In addition, it
 * utilizes a double linked list for data storage. Therefore, it 'wraps' many
 * of the DList methods in order to provide Queue functionality.  Class MyQueue
 * thus utilizes the adapter design pattern, similar to the Deque class defined
 * by the authors.
 *
 * @since 11/2/07
 * @Developed by Mike Qualls
 */


package comparator;

/**
 * MyQueue - the queue class implementing the Queue interface.
 * @author Mike Qualls
 *
 * @param <T> - the generic type parameter.  Instantiated as run-time in order
 * to create a type specific queue.
 */
public class MyQueue<T> implements Queue<T> {
	/*
	 * list - the reference to the double linked list to be used by the Queue.
	 */
	protected DList<T> list;
	
	/**
	 * MyQueue - a no argument constructor.  Create a new DList object and 
	 * initialize the list instance variable.
	 */
	public MyQueue () {
		list = new DList<T> ();		
	}  // end no argument constructor

	/**
	 * size - return the size of the queue.  Actually, wrap the size () method
	 * of the DList class.
	 */
	public int size () {
		// wrap the list method
		return list.getSize ();		
	}  // end method size

	/**
	 * isEmpty - return true if the list is empty, else false.
	 */
	public boolean isEmpty () {
		// wrap the list method
		return (list.isEmpty ());		
	}  // end method isEmpty
	
	/**
	 * front - inspects the front of the queue/list.  Throws EmptyQueueException
	 * if the queue/list is empty.  Otherwise, return the data element value of
	 * the node at the front of the queue/list.
	 */
	public T front () throws EmptyQueueException {
		// test for empty
		if (size () == 0)
			throw new EmptyQueueException ("Queue is empty.");
		
		// return the element at the head
		return (list.getFirst ().getElement ());
	}  // end method front
	

	/**
	 * enqueue - insert an element at the tail of the list.  Create a new node to
	 * do so.
	 */
	public void enqueue (T element) {
		// create a new node
		DNode<T> node = new DNode<T> (element, null, null);
		
		// place at tail of the list
		list.addLast (node);
	}  // end method enqueue
	
	/**
	 * dequeue - remove the node at the front of the queue/list, and return its
	 * data element value.
	 */
	public T dequeue () throws EmptyQueueException {
		// declare locals
		DNode<T> temp;
		
		// test for empty
		if (size () == 0)
			throw new EmptyQueueException ("Queue is empty.");
		
		// get the node at the front and then remove it
		temp = list.getFirst ();
		list.remove (temp);
		
		// now return the value
		return (temp.getElement ());
		
	}  // end method dequeue
	
	/**
	 * toString - method to override the Object class method, and return a
	 * meaningful String representation of a MyQueue object.  Wrap the
	 * toString () method of class DList, since that returns a list of element
	 * values from the front of the queue/list to the rear of the queue/list.
	 */
	public String toString () {
		// since the DList toString () generates a list from front to back,
		// wrap that
		return (list.toString ());
		
	}  // end method toString
	
	/**
	 * sort - sort the queue in ascending order.  Wrap the DList sort () method
	 * that performs an insertion sort.
	 * @param comp - the Comparator object.  This is an interface developed by
	 * M. Qualls, similar in intent to the Java class library interface named
	 * Comparable.  The actual argument will be a subclass object (similar in
	 * name to IntegerComparator) that provides a type specific compareTo () 
	 * method to be used by the DList sort () method.  Look at the test driver
	 * (MyQueueTest) for examples of the subclass definition and the creation
	 * of Comparator subclass objects.
	 */
	public void sort (Comparator<T> comp) {
		// sort the list.. This implies of course that I have modified sort () in list to
		// expect a Comparator argument.
		list.sort (comp);		
	}  // end method sort
	
}  // end class MyQueue
