package LeetcodeTree;

import leetcode.BFS.TreeNode;

public class FlattenBinaryTreeLinkedList_114 {
	public void flatten(TreeNode root) {
		if (root == null) {return;}
		helper(root);
	}

	private TreeNode helper(TreeNode node) {
		if (node == null) {
			return null;
		}

		helper(node.left);
		helper(node.right);

		TreeNode temp = node.right;
		node.right = node.left;
		node.left = null;

		TreeNode rightMost = node;

		while (rightMost.right != null) {
			rightMost = rightMost.right;
		}

		rightMost.right = temp;

		return node;
	}
}
