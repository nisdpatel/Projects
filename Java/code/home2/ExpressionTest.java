// File ExpressionTest.java - solution to Home #2.  Implement the buildExpression
// algorithm.  Use the expression introduced in Fig. 7.11, p. 301 of the text.
// Utilize inorder traversal of a tree complete with an 'add-back' of parentheses
// in order to reconstitute the expression from the tree.

package home2;

import chapter7.binaryTree.*;
import chapter7.tree.EmptyTreeException;

public class ExpressionTest {

	/**
	 * @param args
	 * @throws EmptyTreeException 
	 */
	public static void main(String[] args) throws EmptyTreeException {
		// declare local variables/objects
		String s = new String ();
		String exp= "((((3+1)x3)/((9-5)+2))-((3x(7-4))+6))";
		Expression<String> expression = new Expression<String> ();
		
		// print the expression string
		System.out.printf ("The original String: %s\n\n", exp);
		
		// create the tree
		LinkedBinaryTree<String> tree = expression.buildExpression (exp);
		
		// print tree contents first in preorder then in inorder
		System.out.printf ("The expression tree in preorder: %s\n", tree);
		try {
			System.out.printf ("The expression tree in inorder using parentheses: %s\n\n",
									tree.toStringInorder (tree.root (), s));
		}  // end try block
		catch (Exception exception) {}
		// print and examine the recaptured expression
		System.out.printf ("The recaptured expression: %s\n",
												expression.getExpressionTree ());
		
		// now, evaluate and print a result
		int result = expression.evaluateExpression (tree, (BTNode<String>)tree.root ());
		System.out.printf ("\n\n The evaluated expression is: %d\n", result);
		
	}  // end method main

}  // end class ExpressionTest
