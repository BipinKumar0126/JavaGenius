package dataStructures.tree;

import java.util.Stack;

import dataStructures.models.TreeNode;

public class TraversePreOrder {

	public static void main(String[] args) {
		
		TreeNode root;
	  	  
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        root.left.left.right = new TreeNode(16);
        
        preOrderRecursive(root);
        System.out.println();
        preOrderIterative(root);
	}
	
	public static void preOrderRecursive(TreeNode root) {
		if(root == null)
			return;
		
		System.out.print(root.val + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
		
		
	}
	
	public static void preOrderIterative(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode currentNode = stack.pop();
			System.out.print(currentNode.val + " ");
			if(currentNode.right != null)
				stack.push(currentNode.right);
			if(currentNode.left != null)
				stack.push(currentNode.left);
		}
	}

	public static void morrisPreOrder(TreeNode root) {
		if(root == null)
			return;
		TreeNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.val + " ");
				curr = curr.right;
			} else {
				TreeNode predecessor = curr.left;
				while(predecessor.right != null && predecessor.right != curr)
					predecessor = predecessor.right;

				if(predecessor.right != null) {
					predecessor.right = null;
					curr = curr.right;
				} else {
					predecessor.right = curr;
					System.out.print(curr.val + " ");
					curr = curr.left;
				}
			}
		}
	}

}
