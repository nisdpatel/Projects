package chapter5.nodeQueue;

import chapter3.linkedList.*;

public class NodeQueue<E> implements Queue<E> {
	// instance variables
	protected Node<E> head, tail;
	protected int size;
	
	// methods (starting with constructor first)
	public NodeQueue () {
		head = tail = null;
		size = 0;
	}
	public int size () {	
		return size;
	}
	public boolean isEmpty () {
		if (size == 0)
			return true;
		else
			return false;
	}  // end method isEmpty
	
	public E front () throws EmptyQueueException {
		if (isEmpty ())
			throw new EmptyQueueException ("Queue is empty.");
		return head.getElement ();
	}
	public void enqueue (E element) {
		Node<E> node = new Node<E> ();
		node.setElement (element);
		node.setNext (null);
		if (size == 0)
			head = node;
		else
			tail.setNext (node);
		tail = node;
		size++;	
	}
	public E dequeue () throws EmptyQueueException {
		if (size == 0)
			throw new EmptyQueueException ("Queue is empty.");
		E tmp = head.getElement ();
		head = head.getNext ();
		size--;
		if (size == 0)
			tail = null;
		return tmp;	
	}

}  // end class NodeQueue
