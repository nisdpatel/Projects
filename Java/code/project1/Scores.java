// File - Scores.java - adaptation of Code Fragment 3.2, p. 102 of text by
// Goodrich, et. al.  Developed in solution of exercise P-3.4, p. 159.  This class
// will be used to create game entry objects in the array of highest scores.  For my
// class, use my generic classes developed for a single linked list in the 
// chapter3.linkedList package.  Note, that the text created an array of integer numbers.
// Since this lost the name information,  I am creating a linked list of nodes.
// See the test driver for a more complete problem statement.
// Mike Qualls, 9/20/11

package project1;
import chapter3.linkedList.*;

public class Scores {
	// instance variables
	private final static int MAX_ENTRIES = 10;
	protected int numEntries;								// number of actual entries
	protected MyLinkedList<GameEntry> entries;				// the list of game entries
	
	// methods, default constructor first
	public Scores () {
		entries = new MyLinkedList<GameEntry> ();					// default linked list
		numEntries = 0;
	}  // end default constructor
	
	// method to add a game entry.  Adapt the add (e) algorithm on p. 102 and Code
	// Fragment 3.3, p. 104 to work with a linked list of nodes.
	public void add (GameEntry newEntry) {
		// declare local variables
		Node<GameEntry> currentNode, nextNode, newNode;
		GameEntry currentEntry, nextEntry;
		
		// First, check to see if the array is full.  If it is, check to see
		// if the new score is larger than the last entry.
		// If so, the new one must be added and the last one dropped.
		if (numEntries == MAX_ENTRIES) {
			// get the GameEntry data element for the last node in the list
			currentEntry = entries.getLast ().getElement ();
			
			// is the new score less than or equal to the last one?  If so,
			// just return.
			if (newEntry.getScore () <= currentEntry.getScore ())
				return;
		}  // end numEntries == maxEntries

		// we're going to add an entry and the leader board is not full.  Increase the count
		else
			numEntries++;
		
		// create a new node and determine where to place in the list
		newNode = new Node<GameEntry> (newEntry, null);

		// check to see if list is empty
		if (entries.getSize () == 0)
			// it is, add node at the beginning
			entries.addFirst (newNode);
		else {
			// make first node the current node
			currentNode = (Node<GameEntry>)entries.getFirst ();		// the first node (highest score)
			currentEntry = currentNode.getElement ();				// this is the GameEntry object
			
			// check to see if the new score is greater than the first score
			if (newEntry.getScore () > currentEntry.getScore ())		
				// it is.  make the new entry first
				entries.addFirst (newNode);
			else {
				// now, check all the other entries.  We subtract one because we have already checked the first
				for (int i = 0; i < numEntries - 1; i++) {
					// for a single linked list, can only do an addAfter.  nodes of 
					// interest are current node, next node, and new node.
					// if new node is greater than next node, add after current node
					nextNode = currentNode.getNext ();
					
					// are we at the end of the list?  if so, insert after current node
					if (nextNode == null) {
						entries.addAfter (currentNode, newNode);
						break;
					}  // end if nextNode == null
					
					// is our new score higher than the next score but less than the
					// current score?  if so, insert it.
					nextEntry = nextNode.getElement ();					
					if (newEntry.getScore () > nextEntry.getScore ()) {
						// add newNode after current node
						entries.addAfter (currentNode, newNode);
						break;					// we have added the node, break out of the loop
					}  // end if score greater
					
					// change/move the current node reference
					currentNode = nextNode;
					currentEntry = currentNode.getElement ();
				}  // end loop through elements
				
			}  // end else not greater
		}  // end else add the node to the middle of the list
		
		// if we just added a node and are now too large, remove the last node (9/20/11)
		if (numEntries > MAX_ENTRIES) {
			entries.removeLast ();
			numEntries--;
		}  // end if too full
		
	}  // end method add
		
	// the method remove - developed from the pseudocode and code of pp. 105-106.  Only, now we
	// have to work with a linked list.  Rather than use an array index to identify an entry, use
	// a score and find the corresponding GameEntry object and node
	public GameEntry remove (int scoreToRemove) {
		// declare local variables/objects
		Node<GameEntry> removedNode;
		GameEntry temp = null;
		
		// find the node and remove it.  
		removedNode = getNode (scoreToRemove);
		
		// if null, the node was not there
		if (removedNode != null)
			temp = removedNode.getElement ();
		
		// return temp, even if null
		return temp;
	} // end method remove

	
	// the method getNode.  Returns a Node object.  In this case, the one to be removed from
	// the linked list.  We will examine the first and last nodes
	// first, then we will begin to traverse the list.  We will need to keep track of the
	// 'previous' node as we are doing a comparison.
	public Node<GameEntry> getNode (int scoreToRemove) {
		// declare local variables/object references
		Node<GameEntry> currentNode, previousNode, nodeToRemove = null;
		
		// get and check the first and last node.  Remove and return if found
		currentNode = entries.getFirst ();
		if (currentNode.getElement ().getScore () == scoreToRemove) {
			entries.remove (currentNode);
			nodeToRemove = currentNode;		// remember the node to remove
		}
		currentNode = entries.getLast ();
		if (currentNode.getElement ().getScore () == scoreToRemove) {
			// remove the known node from the list
			entries.remove (currentNode);
			nodeToRemove = currentNode;		// remember the node to remove
		}
		
		// we've checked two nodes, now traverse and check the others.  Be sure to account
		// for lists of 1 or 2 nodes
		numEntries = (int)entries.getSize ();  // definitely assume the list is 'small'
		if (numEntries - 2 > 0) {
			previousNode = entries.getFirst ();
			currentNode = previousNode.getNext ();
			for (int count = 0; count < numEntries - 2; count++) {
				if (currentNode.getElement ().getScore () == scoreToRemove) {
					// found the match.  Save the node
					nodeToRemove = currentNode;
					
					// now remove the node letting the linked list method do all the grunt work
					entries.remove (nodeToRemove);
					break;		// skip what's next
				}  // end if scores match
				
				// change the references.  Do this if we are to continue iterating through the list
				previousNode = currentNode;
				currentNode = currentNode.getNext ();
			}  // end loop to traverse interior of list
		}  // end if numEntries -2 > 0
				
		// return the removed node
		return nodeToRemove;
	}  // end method getNode
	
	
	// construct a string representation of a Scores object
	public String toString () {
		String rep = "[\n";
		Node<GameEntry> currentNode;
		GameEntry currentEntry;
		
		// get the first element
		currentNode = (Node<GameEntry>)entries.getFirst ();
		
		// append the list elements
		for (int i = 0; i < entries.getSize (); i++) { 
			currentEntry = (GameEntry)currentNode.getElement ();
			rep += " " + currentEntry.getName () + ", " + currentEntry.getScore () + "\n";													
			currentNode = currentNode.getNext ();
		}
		rep += "]";
		return rep;
	}  // method toString
	
	

}
