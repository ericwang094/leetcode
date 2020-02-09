package LeetcodeTree;

import leetcode.BFS.TreeNode;

public class ValidateBinarySearchTree_recursive {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isValidBST(root.left, Long.MIN_VALUE, root.val)
				&& isValidBST(root.right, root.val, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}

		if (root.val <= min || root.val >= max) {
			return false;
		}

		return isValidBST(root.left, min, Math.min(root.val, max)) &&
				isValidBST(root.right, Math.max(min, root.val), max);
	}
}
