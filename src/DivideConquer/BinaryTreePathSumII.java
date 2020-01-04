package DivideConquer;

import leetcode.BFS.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumII {
	/*
	 * @param root: the root of binary tree
	 * @param target: An integer
	 * @return: all valid paths
	 */
	public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> buffer = new ArrayList<>();
		if (root == null) {
			return results;
		}

		findSum(root, target, buffer, 0, results);
		return results;
	}

	public void findSum(TreeNode head, int sum, List<Integer> buffer, int level, List<List<Integer>> results) {
		if (head == null) {
			return;
		}

		int temp = sum;
		buffer.add(head.val);
		for (int i = level; i >= 0; i--) {
			temp -= buffer.get(i);
			if (temp == 0) {
				List<Integer> tempList = new ArrayList<>();
				for (int j = i; j <= level; j++) {
					tempList.add(buffer.get(j));
				}
				results.add(tempList);
			}
		}

		findSum(head.left, sum, buffer, level + 1, results);
		findSum(head.right, sum, buffer, level + 1, results);
		buffer.remove(buffer.size() - 1);
	}
}
