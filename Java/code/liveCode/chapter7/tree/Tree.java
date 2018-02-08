//File Tree.java - the Tree interface ADT interface.  Adapted from Code
//Fragment 7.1, p. 271 of the text.
//Mike Qualls

package chapter7.tree;

import java.util.*;
import chapter6.positionList.*;			// uses PositionList classes

public interface Tree<E> {
	// the 'generic' methods
	public int size ();
	public boolean isEmpty ();
	public Iterator<E> iterator ()
				throws InvalidPositionException,
							EmptyTreeException, BoundaryViolationException;
	public Iterable<Position<E>> positions ()
				throws InvalidPositionException,
							EmptyTreeException, BoundaryViolationException;
	public E replace (Position<E> v, E e)
				throws InvalidPositionException;
	
	// the 'accessor' methods
	public Position<E> root () throws EmptyTreeException;
	public Position<E> parent (Position<E> v)
				throws InvalidPositionException, BoundaryViolationException;
	public Iterable<Position<E>> children (Position<E> v)
				throws InvalidPositionException, BoundaryViolationException;
	
	// the 'query' methods
	public boolean isInternal (Position<E> v)
				throws InvalidPositionException;
	public boolean isExternal (Position <E> v)
				throws InvalidPositionException;
	public boolean isRoot (Position<E> v)
				throws InvalidPositionException, EmptyTreeException;
	
}  // end Tree interface
