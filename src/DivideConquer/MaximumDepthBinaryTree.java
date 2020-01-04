package DivideConquer;

import leetcode.BFS.TreeNode;

public class MaximumDepthBinaryTree {
	/**
	 * @param root: The root of binary tree.
	 * @return: An integer
	 */
	public int maxDepth(TreeNode root) {
		// write your code here
		if (root == null) {
			return 0;
		}

		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
