/**
 * File DefaultComparator.java - definition of a comparator class to be used
 * with priority queues.
 * @author mike.qualls
 *
 */


package chapter8.priorityQueue;
import java.util.Comparator;


public class DefaultComparator<E> implements Comparator<E> {
	
	// the method to compare two elements
	public int compare (E left, E right) throws ClassCastException {
		return ((Comparable<E>)left).compareTo (right);
	}   // end method compare

}  // end class DefaultComparator
