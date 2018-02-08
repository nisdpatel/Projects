// File EmptyTreeException.java - created in order to complement the Tree
// implementation of a Tree interface.
// Mike Qualls

package chapter7.tree;

public class EmptyTreeException extends RuntimeException {
		static final long serialVersionUID = 0L;

		// first a no-arg constructor, since we define one with arguments
		public EmptyTreeException () {   }
		
		// now, a constructor with its string message
		public EmptyTreeException (String message) {
			
			// last, invoke the superclass constructor to do its thing
			super (message);
		}  // end constructor
		
}  // end class EmptyTreeException
