package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class KthSmallestElementBST_230_followup {
	public int kthSmallest(TreeNode root, int k) {
		Map<TreeNode, Integer> map = new HashMap<>();
		countNode(root, map);
		return quickSelectOnTree(root, k, map);
	}

	private int countNode(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null) {
			return 0;
		}

		int left = countNode(root.left, map);
		int right = countNode(root.right, map);
		map.put(root, 1 + left + right);
		return 1 + left + right;
	}

	private int quickSelectOnTree(TreeNode root, int k, Map<TreeNode, Integer> map) {
		int numOfLeft = root.left == null ? 0 : map.get(root.left) ;
		if (numOfLeft == k - 1) {
			return root.val;
		} else if (numOfLeft >= k) {
			return quickSelectOnTree(root.left, k, map);
		} else {
			return quickSelectOnTree(root.right, numOfLeft - k - 1, map);
		}
	}
}
