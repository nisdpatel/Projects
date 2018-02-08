/**
 * Interface Comparator - an interface class intended to be implemented by
 * a concrete class that defines the method compareTo.  The concrete class
 * is implemented with a specific type, and compareTo is written to support
 * that type.  This allows the method sort () in class DList to be written 
 * generically so as to support lists of any type.  One of the intents was
 * to model the use of functors as shown in C++.  (Java provides exactly the 
 * same capability through the class Comparable.)
 *
 * @since 11/2/07
 * @Developed by Mike Qualls
 */

package comparator;

/**
 * The Comparator interface provides the signature of the method used to compare
 * objects.  When instantiated, it provides the functor methods (more properly
 * Comparator objects) providing a type specific compareTo () method.
 */
public interface Comparator<T> {
	
	/**
	 * compares parameters op1 and op2.  Each concrete implementation is responsible
	 * for its type specific method of comparison.  The value returned is as follows:
	 *		op1 > op2 - returns 1
	 *		op1 == op2 - returns 0
	 *		op1 < op2 - returns -1
	 */
	public int compareTo (T op1, T op2);

}  // end interface Comparator
