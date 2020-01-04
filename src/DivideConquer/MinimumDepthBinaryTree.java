package DivideConquer;

import leetcode.BFS.TreeNode;

public class MinimumDepthBinaryTree {
	/**
	 * @param root: The root of binary tree
	 * @return: An integer
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		} else if (root.left == null) {
			return 1 + minDepth(root.right);
		} else if (root.right == null) {
			return 1 + minDepth(root.left);
		} else {
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		}
	}
}
