/**
 * Class DNode - define a node suitable for a double linked list.  Algorithm
 * adapted from the author's Code Fragment 3.17, p. 120.
 *
 * @since 11/2/07
 * @Developed by Mike Qualls
 */

package comparator;

/**
 * DNode - the generic node.
 */
public class DNode<V> {
	/**
	 * element - the generic reference to the node element.
	 */	
	protected V element;
	
	/**
	 * next - the generic reference to the next reference.
	 */		
	protected DNode<V> next;
	
	/**
	 * previous - the generic reference to the previous reference.
	 */			
	protected DNode<V> previous;

	/**
	 * DNode - constructor with arguments.  Initialize the node.
	 * @param element - a reference to the node's data element.
	 * @param previous - a reference to the node's previous element.
	 * @param next - a reference to the node's next element.
	 */
	public DNode (V element, DNode<V> previous, DNode<V> next) {
		this.element = element;
		this.previous = previous;
		this.next = next;
	}  // end constructor with args
	
	/**
	 * getElement - return a reference to the Node's data element.
	 * @return - the data element's reference.
	 */
	public V getElement () { return element; }
	
	/**
	 * getPrevious - return a reference to the Node's previous element.
	 * @return - the previous node's reference.
	 */
	public DNode<V> getPrevious () { return previous; }

	/**
	 * getNext - return the reference a a node's next.
	 * @return - the next node's reference.
	 */
	public DNode<V> getNext () { return next; }

	/**
	 * setElement - 'setter' method to set a node's element reference.
	 * @param element - the reference to the data element.
	 */
	public void setElement (V element) {this.element = element; }

	/**
	 * setPrevious - 'setter' method to set a node's previous reference.
	 * @param previous - the reference to the previous node.
	 */
	public void setPrevious (DNode<V> previous) { this.previous = previous; }

	/**
	 * setNext - 'setter' method to set a node's next reference.
	 * @param next - the reference to the next node.
	 */
	
	public void setNext (DNode<V> next) { this.next = next; }

}  // end class DNode<V>
