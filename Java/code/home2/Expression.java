package home2;

import java.util.Iterator;

import chapter6.positionList.NodePositionList;
import chapter6.positionList.Position;
import chapter6.positionList.PositionList;
import chapter7.binaryTree.*;
import chapter5.nodeStack.*;

public class Expression<T> {
	// instance variables
	LinkedBinaryTree<T> expressionTree;
	NodeStack<LinkedBinaryTree<T>> expressionStack;
	
	// methods, constructor first
	public Expression () {
		// create the expression tree, initially empty
		expressionTree = new LinkedBinaryTree<T> ();
		expressionStack = new NodeStack<LinkedBinaryTree<T>> ();	
	}  // end constructor
	
	public LinkedBinaryTree<T> buildExpression (String expression) {
		// declare locals
		LinkedBinaryTree<T> op2, op1, operand;
		String symbol;
		
		// do a try/catch block set
		try {
			// process characters of the string one by one making sure to process
			// all.  (Note:  the n-1 of the book is misleading as that is 'to'.
			// this accomplishes the same number of iterations
			for (int i = 0; i < expression.length (); i++) {
			
				// get the next symbol, one at a time - beginning and ending
				// indexes.  There can be no spaces as of yet.
				symbol = expression.substring (i, i + 1);
			
				// if symbol is a variable or an operator
				if ((!symbol.equals ("(")) && (!symbol.equals (")"))) {
					// a variable or operator - create a tree consisting of just
					// a root, and put on stack
					operand = new LinkedBinaryTree<T> ();
					operand.addRoot ((T)symbol);
					expressionStack.push (operand);
				} // end variable or operator
			
				// is it a left paren?  if so, the expression is 'opening'.
				// Continue building
				else if (symbol.equals ("("))
					continue;
			
				// has to be a right paren
				else {
					// the expression is 'closed'.  Get the three parts of the
					// subexpression that are on the stack.  Remembering, that
					// each item on the stack is a tree with only a root node.
					// the trees popped are - op1 op op2.
					op2 = expressionStack.pop ();
					operand = expressionStack.pop ();
					op1 = expressionStack.pop ();

					// then, build a new three node tree with the operation at the 
					// root.  Push that tree on the stack.
					operand.attach (operand.root (),op1, op2);
					expressionStack.push (operand);
				}  // end else right paren
			}  // end loop to examine symbols
		
			// the last and only element on the stack is the complete expression tree
			expressionTree = expressionStack.pop ();
		
		}  // end try block
		catch (Exception exception) {  }
	
		// return the expression tree
		return expressionTree;
		
	}  // end method buildExpression
	
	
	/**
	 * evaluateExpression - generate and return a single result of expression tree evaluation
	 * 
	 *
	*/
	public int evaluateExpression (LinkedBinaryTree<T> tree, BTPosition<T> v) {
		// declare locals
		String operator;
		int op1, op2, result = 0;
		
		// check to see if internal node.  If so, it's an operator
		if (tree.isInternal (v)) {
			operator = (String)v.element();
			op1 = evaluateExpression (tree, (BTPosition<T>)tree.left (v));
			op2 = evaluateExpression (tree, (BTPosition<T>)tree.right (v));
			
			// calculate and return a value
			switch (operator) {
			case "+":
				result = op1 + op2;
				break;
			case "-":
				result = op1 - op2;
				break;
			case "*":
			case "x":
				result = op1 * op2;
				break;
			case "/":
				result = op1 / op2;
				break;	
			}  // end switch
			return result;
		}  // end if internal
		else
			return Integer.parseInt((String)v.element ());
				
	}  // end method evaluateExpression
	
	/**
	 * call the recursive toStringInorder to create a string representation of the
	 * expression tree complete with parentheses added back
	 * 
	 * @return s - the complete expression
	 */
	public String getExpressionTree () {
		String s = "";
		try {
			s = expressionTree.toStringInorder (expressionTree.root (), s);
		}
		catch (Exception exception) {  }
		
		return s;
	}  // end method getExpressionTree
	
} // end class Expression
