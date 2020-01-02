package DivideConquer;

import leetcode.BFS.TreeNode;

public class LCABinarySearchTree {
	/**
	 * @param root: root of the tree
	 * @param p: the node p
	 * @param q: the node q
	 * @return: find the LCA of p and q
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// write your code here
		int smallerVal = p.val >= q.val ? q.val : p.val;
		int biggerVal = p.val >= q.val ? p.val : q.val;

		if (root.val >= smallerVal && root.val <= biggerVal) {
			return root;
		} else if (root.val > biggerVal) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return lowestCommonAncestor(root.right, p, q);
		}
	}
}
