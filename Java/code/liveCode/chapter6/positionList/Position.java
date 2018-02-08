// File Position.java.  Adapted from Code Fragment 6.4, p. 234 of "Data Structures and
// Algorithms in Java", Goodrich et.al.
// Define the Position ADT that will be used to add the concept of position to a
// node list.  The single operation, element, will return the element at a certain
// position.  The operation will be called on a Position capable object.
// Defined to be generic.
// Mike Qualls

package chapter6.positionList;

public interface Position<E> {
	// method called on a position capable object
	E element () throws InvalidPositionException;  	// done in order to be compatible
													// with DNode class
}  // end interface Position
