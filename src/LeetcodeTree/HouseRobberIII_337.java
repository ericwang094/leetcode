package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.*;

public class HouseRobberIII_337 {
	public int rob(TreeNode root) {
		return helper(root, new HashMap<>());
	}

	private int helper(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null) {
			return 0;
		}

		if (map.containsKey(root)) {
			return map.get(root);
		}

		int val = 0;
		if (root.left != null) {
			val += helper(root.left.left, map) + helper(root.left.right, map);
		}

		if (root.right != null) {
			val += helper(root.right.left, map) + helper(root.right.right, map);
		}

		val = Math.max(val + root.val, helper(root.left, map) + helper(root.right, map));
		map.put(root, val);

		return val;
	}

	public static void main(String[] args) {
		HouseRobberIII_337 test = new HouseRobberIII_337();
		TreeNode input = new TreeNode(3);
		input.left = new TreeNode(4);
		input.right = new TreeNode(5);

		input.left.left = new TreeNode(1);
		input.left.right = new TreeNode(3);

		input.right.right = new TreeNode(1);

		test.rob(input);
	}
}
