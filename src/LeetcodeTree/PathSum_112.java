package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum_112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		List<TreeNode> list = new ArrayList<>();
		return helper(root, sum, list);
	}

	private boolean helper(TreeNode root, int sum, List<TreeNode> list) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return root.val == sum;
		} else {
			list.add(root.left);
			if (helper(root.left, sum - root.val, list)) {
				return true;
			} else {
				list.remove(list.size() - 1);
			}

			list.add(root.right);
			if (helper(root.right, sum - root.val, list)) {
				return true;
			} else {
				list.remove(list.size() - 1);
			}

			return false;
		}
	}
}
