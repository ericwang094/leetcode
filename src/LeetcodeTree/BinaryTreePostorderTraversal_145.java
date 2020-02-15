package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		helper(root, result);
		return result;
	}

	private void helper(TreeNode node, List<Integer> result) {
		if (node == null) {
			return;
		}

		helper(node.left, result);
		helper(node.right, result);
		result.add(node.val);
	}

	public List<Integer> postorderTraversal_2(TreeNode root) {
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
			TreeNode node = stack.peek();
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.add(node);
					node = node.left;
				}
			} else {
				node = stack.pop();
				result.add(node.val);

				while (!stack.isEmpty() && stack.peek().right == node) {
					node = stack.pop();
					result.add(node.val);
				}
			}
		}

		return result;
	}
}