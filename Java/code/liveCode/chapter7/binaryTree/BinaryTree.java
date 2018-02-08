// File BinaryTree - define a Binary Tree ADT interface that extends
// the Tree interface.  Adapted from Live Code 7.14 of the text.
// Mike Qualls

package chapter7.binaryTree;

import chapter6.positionList.*;
import chapter7.tree.*;

public interface BinaryTree<E> extends Tree<E> {
	public Position<E> left (Position<E> v)
				throws InvalidPositionException, BoundaryViolationException;
	public Position<E> right (Position<E> v)
				throws InvalidPositionException, BoundaryViolationException;
	public boolean hasLeft (Position<E> v)
				throws InvalidPositionException;
	public boolean hasRight (Position<E> v)
	throws InvalidPositionException;	
}  // end interface BinaryTree
