package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList <>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> tempList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				tempList.add(node.val);

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			result.add(tempList);
		}

		return result;
	}
}
