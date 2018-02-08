// File LinkedBinaryTree.java - a linked structure implementation of the
// Binary Tree.  Adapted from Code Fragments 7.16-7.20, pp. 290-294 of the
// text.
// Mike Qualls

package chapter7.binaryTree;

import java.util.*;
import chapter6.positionList.*;
import chapter7.tree.*;


public class LinkedBinaryTree<E> implements BinaryTree<E> {
	// instance variables
	protected BTPosition<E> root;		// the root of the tree
	protected int size;					// number of nodes
	
	// methods, constructor first
	public LinkedBinaryTree () {
		root = null;
		size = 0;
	}  // end constructor to create an empty tree
	
	// generic methods from interface Tree
	public int size () { return size; }
	public boolean isEmpty () { return (size == 0); }
	
	// query methods of class Tree
	// does this element have a child/children?
	public boolean isInternal (Position<E> v)
								throws InvalidPositionException {
		checkPosition (v);		// is v a valid element
		return (hasLeft (v) || hasRight (v));  // yes it has		
	}  // end method isInternal
	
	// does this element have any children?	
	public boolean isExternal (Position<E> v)
								throws InvalidPositionException {
		checkPosition (v);		// is v a valid element
		return (!isInternal (v));		
}  // end method isExternal
	
	// is this the root?
	public boolean isRoot (Position<E> v)
								throws InvalidPositionException,
										EmptyTreeException {
		checkPosition (v);
		return (v == root ());
	} // end method isRoot
	
	public boolean hasLeft (Position<E> v)
								throws InvalidPositionException {
		BTPosition<E> vv = checkPosition (v);
		return (vv.getLeft () != null);
	}  // end method hasLeft
	
	public boolean hasRight (Position<E> v)
								throws InvalidPositionException {
		BTPosition<E> vv = checkPosition (v);
		return (vv.getRight () != null);
	}  // end method hasLeft
	
	// 'accessor' methods of class Tree
	// get the root first
	public Position<E> root () throws EmptyTreeException {
		if (root == null)
			throw new EmptyTreeException ("The tree is empty.");
		return root;		
	} // end method root
	
	// get the left
	public Position<E> left (Position<E> v) 
								throws InvalidPositionException,
											BoundaryViolationException {
		BTPosition<E> vv = checkPosition (v);
		Position<E> leftPos = vv.getLeft ();
		if (leftPos == null)
			throw new BoundaryViolationException ("No left child");
		return leftPos;
	}  // end method left
	
	// get the right
	public Position<E> right (Position<E> v) 
								throws InvalidPositionException,
											BoundaryViolationException {
		BTPosition<E> vv = checkPosition (v);
		Position<E> rightPos = vv.getRight ();
		if (rightPos == null)
			throw new BoundaryViolationException ("No left child");
		return rightPos;
	}  // end method right
	
	// get the parent
	public Position<E> parent (Position<E> v)
				throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> castV = checkPosition (v);
		Position<E> parentPosition = castV.getParent ();
		if (parentPosition == null)
			throw new BoundaryViolationException ("No Parant.");
		return parentPosition;
	}  // end method parent
	
	// get an iterable collection of the children
	public Iterable<Position<E>> children (Position<E> v)
									throws InvalidPositionException,
											BoundaryViolationException {
		PositionList<Position<E>> childList = new NodePositionList<Position<E>> ();
		if (hasLeft (v))
			childList.addLast (left (v));
		if (hasRight (v))
			childList.addLast (right (v));
		return childList;
	}  // end method children
	
	
	// utility methods.
	// if position is valid, cast to BTPosition and return it
	protected BTPosition<E> checkPosition (Position<E> v)
								throws InvalidPositionException {
		if (v == null || !(v instanceof BTPosition))
			throw new InvalidPositionException ("The position is invalid.");
		
		// cast and return an object
		return (BTPosition<E>)v;		
	}  // end method checkPosition
	
	// methods to iterate
	public Iterable<Position<E>> positions ()
								throws InvalidPositionException,
											EmptyTreeException,
												BoundaryViolationException {
		PositionList<Position<E>> posList = new
											NodePositionList<Position<E>> ();
		if (size != 0)
			preorderPositions (root (), posList);
		return posList;	
	}  // end method positions
	
	public Iterator<E> iterator () throws EmptyTreeException,
								BoundaryViolationException, InvalidPositionException {
		Iterable<Position<E>> positions = positions ();
		PositionList<E> elements = new NodePositionList<E> ();
		for (Position<E> pos: positions)
			elements.addLast (pos.element ());
		return elements.iterator ();		// note: this is the PositionList
											// iterator.
	}  // end method iterator for a LinkedBinaryTree
	
	// replace an element at a node
	public E replace (Position<E> v, E element)
							throws InvalidPositionException {
		BTPosition<E> vv = checkPosition (v);
		E temp = v.element ();
		vv.setElement (element);
		return temp;	
	}  // end method replace
	
	// return the sibling of a node
	public Position<E> sibling (Position<E> v)
						throws InvalidPositionException,
									BoundaryViolationException {
		BTPosition<E> vv = checkPosition (v);
		BTPosition<E> parentPosition = vv.getParent ();
		if (parentPosition != null) {
			BTPosition<E> sibPosition;
			BTPosition<E> leftPosition = parentPosition.getLeft ();
			if (leftPosition == vv)
				sibPosition = parentPosition.getRight ();
			else
				sibPosition = parentPosition.getLeft ();
			if (sibPosition != null)
				return sibPosition;
		}  // end if parentPosition != null
		
		// say there is no sibling
		throw new BoundaryViolationException ("No sibling");
	}  // end method sibling
	
	// some more update methods
	public Position<E> addRoot (E element)
						throws NonEmptyTreeException {
		
		// does the tree already have a root
		if (!isEmpty ())
			throw new NonEmptyTreeException ("Tree already has a root");
		
		// empty tree.  add the root
		size = 1;
		root = createNode (element, null, null, null);
		return root;
	}  // end method addRoot
	
	// insert a left child
	public Position<E> insertLeft (Position<E> v, E element)
									throws InvalidPositionException {
		BTPosition<E> vv = checkPosition (v);
		Position<E> leftPosition = vv.getLeft ();
		if (leftPosition != null)
			throw new InvalidPositionException ("Node already has a left child.");
		
		// create a new node and add it to the tree
		BTPosition<E> newNode = createNode (element, vv, null, null);
		vv.setLeft (newNode);
		size++;
		return newNode;
	}  // end method insertLeft
	
	// insert a right child
	public Position<E> insertRight (Position<E> v, E element)
									throws InvalidPositionException {
		BTPosition<E> vv = checkPosition (v);
		Position<E> rightPosition = vv.getRight ();
		if (rightPosition != null)
			throw new InvalidPositionException ("Node already has a left child.");
		
		// create a new node and add it to the tree
		BTPosition<E> newNode = createNode (element, vv, null, null);
		vv.setRight (newNode);
		size++;
		return newNode;
	}  // end method insertRight
	
	// remove a node with zero or one child from the tree
	public E remove (Position<E> v)
					throws InvalidPositionException {
		BTPosition<E> vv = checkPosition (v);
		BTPosition<E> leftPosition = vv.getLeft ();
		BTPosition<E> rightPosition = vv.getRight ();
		
		// how many children do we have?
		if ((leftPosition != null) && (rightPosition != null))
			throw new InvalidPositionException ("Cannot remove node with two children");
		
		// get the child and see if it's in the right or left position
		BTPosition<E> ww;
		if (leftPosition != null)
			ww = leftPosition;
		else if (rightPosition != null)
			ww = rightPosition;
		else		// ww is a leaf
			ww = null;
		
		// if v is the root, make this child the root
		if (vv == root) {
			if (ww != null)
				ww.setParent (null);
			root = ww;
		}  // end if vv == root
		else {
			// not the root.  replace the node being removed (v) with the child
			BTPosition<E> uu = vv.getParent ();
			if (vv == uu.getLeft ())
				uu.setLeft (ww);
			else
				uu.setRight (ww);
			if (ww != null)
				ww.setParent (uu);
		} // end else not the root
		
		// change the size and return
		size--;
		return v.element ();
		
	}  // end method remove
	
	// take two trees and make them subtrees of an external node
	public void attach (Position<E> v, BinaryTree<E> leftSubTree,
												BinaryTree<E> rightSubTree)
													throws InvalidPositionException,
													  					EmptyTreeException {
		
		BTPosition<E> vv = checkPosition (v);
		
		// is v internal?  can't attach there.
		if (isInternal (v))
			throw new InvalidPositionException ("Cannot attach from internal node.");
		
		// check for empty subtrees.  if empty, don't do anything
		if (!leftSubTree.isEmpty ()) {
			BTPosition<E> leftSubTreeRoot = checkPosition (leftSubTree.root ());
			vv.setLeft (leftSubTreeRoot);
			leftSubTreeRoot.setParent (vv);
			size++;
		}  // end leftSubTree is not empty
		if (!rightSubTree.isEmpty ()) {
			BTPosition<E> rightSubTreeRoot = checkPosition (rightSubTree.root ());
			vv.setRight (rightSubTreeRoot);
			rightSubTreeRoot.setParent (vv);
			size++;
		}  // end rightSubTree is not empty
		
	}  // end method attach
	
	// create a node
	protected BTPosition<E> createNode (E element, BTPosition<E> parent,
							BTPosition<E> left, BTPosition<E> right) {
		return new BTNode<E> (element, parent, left, right);	
	}  // end method createNode
	
	// traverse the tree, preorder first, and create a PositionList of nodes
	protected void preorderPositions (Position<E> v,
							PositionList<Position<E>> pos)
								throws InvalidPositionException,
										BoundaryViolationException {
		pos.addLast (v);
		if (hasLeft (v))
			preorderPositions (left (v), pos);
		if (hasRight (v))
			preorderPositions (right (v), pos);
	}  // end preOrderPositions to create a list

	// traverse the tree, inorder, and create a PositionList of nodes
	public void inorderPositions (Position<E> v,
						   PositionList<Position<E>> pos)
							   throws InvalidPositionException,
							   			BoundaryViolationException {
		// do left subtree first
		if (hasLeft (v))
			inorderPositions (left (v), pos);
		
		// visit 'inorder'
		pos.addLast (v);
		
		// do the right subtree last
		if (hasRight (v))
			inorderPositions (right (v), pos);		
	}  // end method inorderPositons
	
	// method toStringInorder - generate a string with node elements displayed
	// inorder with parentheses added
	public String toStringInorder (Position<E> v, String s) {
		
		try {
			// do left subtree first, adding a paren first
			if (hasLeft (v)) {
				s += "(";
				s = toStringInorder (left (v), s);	
			}  // end if has left
		
			// the inorder action
			s += v.element ();  // the expression value;
			
			// do right subtree next, adding a paren after
			if (hasRight (v)) {
				s = toStringInorder (right (v), s);
				s += ")";
			}  // end if has right
		}
		catch (Exception exception) {  }
		
		// return the string built so far
		return s;
			
	}  // end method toStringInorder
	
	// method toString that uses our iterator class.  create so as to
	// override the Object method.
	// Created by Mike Qualls
	public String toString () {
		// declare local variables/objects
		String s = "[";
		
		// create an empty NodePositionList of Position<E> objects
		PositionList<Position<E>> positions =
								new NodePositionList<Position<E>> ();
		
		// let preorderPositons populate that list
		try {
			preorderPositions (root (), positions);
		
			// create a NodePositionList iterator
			Iterator<Position<E>> iter = positions.iterator ();
			while (iter.hasNext ()) {
				s += iter.next ().element ();		// will be an implicit conversion
									// to String
				if (iter.hasNext ())
					s += ", ";			
			}  // end while
			s += "]";
		}  // end try block
		catch (Exception exception) {  }
		
		return s;
	}  // end method toString
	
}  // end class LinkedBinaryTree
