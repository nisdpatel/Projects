// file Stack.java - adapted from Code Fragment 5.2, p. 191 of the text.  This
// is the generic interface used for the concrete implementations of the Stack
// ADT.
// Mike Qualls

package chapter5.nodeStack;

public interface Stack<E> {
	public int size ();
	public boolean isEmpty ();
	public E top () throws EmptyStackException;
	public void push (E element);
	public E pop () throws EmptyStackException;

}  // end interface Stack
