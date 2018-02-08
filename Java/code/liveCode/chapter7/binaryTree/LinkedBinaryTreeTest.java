package chapter7.binaryTree;


public class LinkedBinaryTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declare local variables/objects
		LinkedBinaryTree<Integer> tree;
		LinkedBinaryTree<Integer> left;
		LinkedBinaryTree<Integer> right;
		String s = "";
		
		// create the trees
		tree = new LinkedBinaryTree<Integer> ();
		left = new LinkedBinaryTree<Integer> ();
		right = new LinkedBinaryTree<Integer> ();
		
		// build tree and subtrees adding only the root
		try {
			tree.addRoot (4);
			left.addRoot (5);
			right.addRoot (6);
			tree.attach (tree.root (), left, right);
			
		}  // end try block
		catch (Exception treeException) {  }
				
		System.out.println ("Tree: " + tree);
		
		// now, an inorder traversal
		System.out.println ("\t\nAn InOrder Traversal");
		try {
			System.out.println ("Tree: " + 
								tree.toStringInorder (tree.root (),s));
		}  // end try block
		catch (Exception treeException) {
			
		}  // end catch block
		
	}   // end method main

}  // end LinkedBinaryTreeTest
