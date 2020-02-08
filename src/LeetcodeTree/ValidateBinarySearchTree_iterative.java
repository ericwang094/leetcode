package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree_iterative {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		Stack<TreeNode> stack = new Stack<>();
		while (root != null) {
			stack.add(root);
			root = root.left;
		}

		long prevVal = Long.MIN_VALUE;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.val <= prevVal) {
				return false;
			}

			prevVal = node.val;

			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.add(node);
					node = node.left;
				}
			}
		}

		return true;
	}
}
