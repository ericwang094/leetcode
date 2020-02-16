package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.Stack;

public class InvertBinaryTree_226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null || root.left == null && root.right == null) {
			return null;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		root.left = right;
		root.right = left;

		return root;
	}

	public TreeNode invertTree_2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) {
			return null;
		}

		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			TreeNode tempLeft = node.left;
			node.left = node.right;
			node.right = tempLeft;

			if (node.left != null) {
				stack.add(node.left);
			}

			if(node.right != null) {
				stack.add(node.right);
			}
		}

		return root;
	}
}
