package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.Stack;

public class KthSmallestElementBST_230 {
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();

		while (root != null) {
			stack.add(root);
			root = root.left;
		}

		int count = 0;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			count++;
			if (k == count) {
				return node.val;
			}

			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.add(node);
					node = node.left;
				}
			}
		}

		return -1;
	}

	public int kthSmallest_1(TreeNode root, int k) {
		int numOfLeft = countNode(root.left);

		if (numOfLeft == k - 1) {
			return root.val;
		} else if (numOfLeft > k) {
			return kthSmallest_1(root.left, k);
		} else {
			return kthSmallest_1(root.right, k - numOfLeft - 1);
		}
	}

	private int countNode (TreeNode node) {
		if (node == null) {
			return 0;
		}

		return 1 + countNode(node.left) + countNode(node.right);
	}
}
