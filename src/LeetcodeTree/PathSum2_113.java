package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2_113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		helper(root, sum, result, new ArrayList<>());
		return result;
	}

	private void helper(TreeNode node, int sum, List<List<Integer>> result, List<Integer> tempList) {
		if (node == null) { return; }
		if (node.left == null && node.right == null) {
			if (sum == node.val) {
				tempList.add(node.val);
				result.add(new ArrayList<>(tempList));
				tempList.remove(tempList.size() - 1);
			}
		} else {
			if (node.left != null) {
				tempList.add(node.val);
				helper(node.left, sum - node.val, result, tempList);
				tempList.remove(tempList.size() - 1);
			}

			if (node.right != null) {
				tempList.add(node.val);
				helper(node.right, sum - node.val, result, tempList);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
