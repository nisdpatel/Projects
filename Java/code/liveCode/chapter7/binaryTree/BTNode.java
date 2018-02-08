// File BTNode.java - definition of a node class for a Binary Tree.  What
// is (must be) supplied in the same package is class BTPosition
// Mike Qualls

package chapter7.binaryTree;

public class BTNode<E> implements BTPosition<E> {
	// instance variables
	private E element;		// element at this node
	private BTPosition<E> left, right, parent;  // positions of related nodes
	
	// methods, constructor first
	public BTNode (E element, BTPosition<E> parent,
						BTPosition<E> left, BTPosition<E> right) {
		// use sets to initialize
		setElement (element);
		setParent (parent);
		setLeft (left);
		setRight (right);		
	}  // end constructor
	
	// sets and gets (using the name element for getElement
	public E element () { return element; }
	public void setElement (E element) { this.element = element; }
	public BTPosition<E> getLeft () { return left; }
	public void setLeft (BTPosition<E> left) { this.left = left; }
	public BTPosition<E> getRight () { return right; }
	public void setRight (BTPosition<E> right) { this.right = right; }
	public BTPosition<E> getParent () { return parent; }
	public void setParent (BTPosition<E> parent) { this.parent = parent; }
	
}  // end class BTNode
