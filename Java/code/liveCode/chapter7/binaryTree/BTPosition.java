// File BTPosition.java - interface definition of a BTPosition.  Following
// the lead of chapter 6, will declare only one method
// Mike Qualls (not adapted) 

package chapter7.binaryTree;

import chapter6.positionList.*;

public interface BTPosition<T> extends Position<T> {
	// methods called on a position capable object
	  public void setElement(T element);
	  public BTPosition<T> getLeft(); 
	  public void setLeft(BTPosition<T> left); 
	  public BTPosition<T> getRight(); 
	  public void setRight(BTPosition<T> right); 
	  public BTPosition<T> getParent(); 
	  public void setParent(BTPosition<T> parent);
	  
	  // the declaration of the 'element' method of Position is
	  // 'inherited'
	  
}  // end interface BTPosition
