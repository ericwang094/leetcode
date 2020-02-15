package LeetcodeTree;

import DivideConquer.BSTIterator;
import leetcode.BFS.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator_173 {
	Stack<TreeNode> stack = new Stack<>();
	TreeNode root = null;
	public BinarySearchTreeIterator_173(TreeNode root) {
		while (root != null) {
			stack.add(root);
			root = root.left;
		}
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		if (node.right != null) {
			TreeNode rightNode = node.right;
			while (rightNode != null) {
				stack.add(rightNode);
				rightNode = rightNode.left;
			}
		}

		System.out.println(node.val);
		return node.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (!stack.isEmpty()) {
			System.out.println("has next ");
		} else {
			System.out.println("no next ");
		}
		return !stack.isEmpty();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);

		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);

		BinarySearchTreeIterator_173 test = new BinarySearchTreeIterator_173(root);
		test.next();
		test.next();
		test.hasNext();
		test.next();
		test.hasNext();
		test.next();
		test.hasNext();
		test.next();
		test.hasNext();
	}
}
