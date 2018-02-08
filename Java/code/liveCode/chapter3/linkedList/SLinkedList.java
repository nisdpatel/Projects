// File SLinkedList.java - define a generic single linked list.  Adapted from Code
// Fragment 3.13, p. 116 of the text.  Add generics to that definition.  Algorithms modified and/or added to
// to allow removal of the tail node as well as removal from the interior of the list.  This requires keeping
// a 'previous' or 'before' reference to a list node.
// copyright, Michael G. Qualls, 9/14/2008.


package chapter3.linkedList;

public class SLinkedList<V> {
	// instance variables.  Add the tail reference.
	protected Node<V> head, tail;
	protected long size;
	
	// methods, empty list constructor first
	public SLinkedList () {
		head = null;
		tail = null;
		size = 0;
	}  // end constructor of a SLinkedList
	
	// method to add nodes to the list.  Storage space for the node
	// is already allocated in the calling method
	public void addFirst (Node<V> node) {
		// set the tail only if this is the very first node
		if (tail == null)
			tail = node;
		node.setNext (head);  	// make next of the new node refer to the head
		head = node;			// give head a new value
		
		// change our size
		size++;
	}  // end method addFirst
	
	// addAfter - add new node after current node, checking to see if we are at the tail
	public void addAfter (Node<V>currentNode, Node<V>newNode) {
		if (currentNode == tail)
			tail = newNode;
		newNode.setNext (currentNode.getNext ());
		currentNode.setNext (newNode);
		
		// change our size
		size++;
	}  // end method addAfter
	
	// addLast - add new node after the tail node.  Adapted from Code Fragment 3.15, p. 118.
	// Mike Qualls
	public void addLast (Node<V> node) {
		node.setNext (null);
		tail.setNext (node);
		tail = node;
		size++;		
	}  // end method addLast
	
	// methods to remove nodes from the list.  (Unfortunately, with a single linked list
	// there is no way to remove last.  Need a previous reference to do that.  (See
	// Double Linked Lists and the code below.)
	public Node<V> removeFirst () {
		if (head == null)
			System.err.println("Error:  Attempt to remove from an empty list");
		
		// save the one to return
		Node<V> temp = head;
		
		// do reference manipulation
		head = head.getNext ();
		temp.setNext(null);
		size--;
		
		return temp;
		
	}  // end method removeFirst

	// remove the node at the end of the list.  tail refers to this node, but
	// since the list is single linked, there is no way to refer to the node
	// before the tail node.  Need to traverse the list.
	public Node<V> removeLast () {
		// // declare local variables/objects
		Node<V> nodeBefore;
		Node<V> nodeToRemove;
		
		// make sure we have something to remove
		if (size == 0)
			System.err.println("Error:  Attempt to remove fron an empty list");
		
		// traverse through the list, getting a reference to the node before
		// the trailer.  Since there is no previous reference.
		nodeBefore = getFirst ();
		
		// potential error	??  See an analysis and drawing that indicates the number of iterations
		// 9/21/10.  size - 2 to account for the head and tail nodes.  We want to refer to the one before the
		// tail.
		for (int count = 0; count < size - 2; count++)
			nodeBefore = nodeBefore.getNext ();
		
		// save the last node
		nodeToRemove = tail;
		
		// now, do the pointer manipulation
		nodeBefore.setNext (null);
		tail = nodeBefore;
		size--;
		
		return nodeToRemove;
				
	}  // end method removeLast
	
	// method remove.  Remove a known node from the list.  No need to search or return a value.  This method
	// makes use of a 'before' reference in order to allow list manipulation.
	public void remove (Node<V> nodeToRemove) {
		// declare local variables/references
		Node<V> nodeBefore, currentNode;
		
		// make sure we have something to remove
		if (size == 0)
			System.err.println("Error:  Attempt to remove fron an empty list");
		
		// starting at the beginning check for removal
		currentNode = getFirst ();
		if (currentNode == nodeToRemove)
			removeFirst ();
		currentNode = getLast ();
		if (currentNode == nodeToRemove)
			removeLast ();
		
		// we've already check two nodes, check the rest
		if (size - 2 > 0) {
			nodeBefore = getFirst ();
			currentNode = getFirst ().getNext ();
			for (int count = 0; count < size - 2; count++) {
				if (currentNode == nodeToRemove) {
					// remove current node
					nodeBefore.setNext (currentNode.getNext ());
					size--;
					break;
				}  // end if node found
				
				// change references
				nodeBefore = currentNode;
				currentNode = currentNode.getNext ();
			}  // end loop to process elements
		}  // end if size - 2 > 0
		
	}  // end method remove
	
	public String toString () {
		String s = "[";
		Node<V> next = head;			// reference to the top of the list
		
		for (int i = 0; i < size; i++) {
			s += next.getElement () + " ";
			next = next.getNext ();
		} // end for loop
		
		s += "]";
		
		return s;
		
	}  // end method toString

	// the gets to return the head and/or tail nodes and size of the list
	public Node<V> getFirst () { return head; }
	public Node<V> getLast () { return tail; }	
	public long getSize () { return size; }
	
}  // end class SLinkedList
