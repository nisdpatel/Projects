package intro.supplemental3;

import net.datastructures.*;

public class SimpleStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare local variables/objects here
		NodeStack<String> stack;
		
		// create the stack as a link list
		stack = new NodeStack<String> ();
		
		// push elements onto the stack
		stack.push ("Hello ");
		stack.push ("World!");
		
		// pop and print
		System.out.println (stack.pop ());
		System.out.println (stack.pop ());
		
	}  // end method main

}  // end class SimpleStack
