package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootLeafNumbers_129 {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<Integer> result = new ArrayList<>();
		helper(root, result, new ArrayList<>());

		int finalVal = 0;
		for (Integer i : result) {
			finalVal += i;
		}

		return finalVal;
	}

	private void helper(TreeNode node, List<Integer> result, List<Integer> tempList) {
		if (node.left == null && node.right == null) {
			StringBuilder sb = new StringBuilder();
			for (Integer s : tempList) {
				sb.append(s.toString());
			}
			sb.append(node.val);
			result.add(Integer.valueOf(sb.toString()));
		} else {
			if (node.left != null) {
				tempList.add(node.val);
				helper(node.left, result, tempList);
				tempList.remove(tempList.size() - 1);
			}

			if (node.right != null) {
				tempList.add(node.val);
				helper(node.right, result, tempList);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
