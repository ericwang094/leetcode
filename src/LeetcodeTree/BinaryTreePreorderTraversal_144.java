package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.*;

public class BinaryTreePreorderTraversal_144 {
	public List<Integer> preorderTraversal(TreeNode root) {
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

		result.add(node.val);
		helper(node.left, result);
		helper(node.right, result);
	}

	public List<Integer> preorderTraversal_2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<>();
		while (root != null) {
			result.add(root.val);
			stack.add(root);
			root = root.left;
		}

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					result.add(node.val);
					stack.add(node);
					node = node.left;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		BinaryTreePreorderTraversal_144 test = new BinaryTreePreorderTraversal_144();

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);

		root.left.right = new TreeNode(4);
		test.preorderTraversal_2(root);
	}
}
