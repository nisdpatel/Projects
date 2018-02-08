// file DNode.java - define a generic double linked list node.  Algorithm adapted
// from the author's Code Fragment 3.17, p. 120

package chapter3.sortedDList;

public class DNode<V> {
	// instance variables
	protected V element;
	protected DNode<V> next, previous;
	
	// methods, constructor first
	public DNode (V element, DNode<V> previous, DNode<V> next) {
		this.element = element;
		this.previous = previous;
		this.next = next;
	}  // end constructor with args
	
	// the sets and gets
	public V getElement () { return element; }
	public DNode<V> getPrevious () { return previous; }
	public DNode<V> getNext () { return next; }
	public void setElement (V element) {this.element = element; }
	public void setPrevious (DNode<V> previous) { this.previous = previous; }
	public void setNext (DNode<V> next) { this.next = next; }

}  // end class DNode<V>
