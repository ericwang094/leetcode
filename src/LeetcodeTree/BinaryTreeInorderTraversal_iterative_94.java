package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_iterative_94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<>();
		while (root != null) {
			stack.add(root);
			root = root.left;
		}

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.add(node);
					node = node.left;
				}
			}
		}

		return result;
	}
}
