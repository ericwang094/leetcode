package LeetcodeTree;

import leetcode.BFS.TreeNode;

public class LowestCommonAncestorBinarySearchTree_235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val == root.val || q.val == root.val) {
			return root;
		} else if (p.val < root.val && q.val > root.val) {
			return root;
		} else if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return lowestCommonAncestor(root.right, p, q);
		}
	}
}
