package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.Stack;

public class InorderPredecessorBST {
	private TreeNode preNode = null;
	/**
	 * @param root: the given BST
	 * @param p: the given node
	 * @return: the in-order predecessor of the given node in the BST
	 */
	public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
		// write your code here
		if (root == null) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<>();
		while (root != null) {
			stack.add(root);
			root = root.left;
		}

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node == p) {
				return preNode;
			} else {
				preNode = node;
			}

			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.add(node);
					node = node.left;
				}
			} else {
				while (!stack.isEmpty() && stack.peek().right == node) {
					node = stack.pop();
				}
			}
		}
		return preNode;
	}

	public TreeNode inorderPredecessor2(TreeNode root, TreeNode p) {
		TreeNode result = null;
		while (root != null) {
			if (root.val > p.val) {
				result = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}

		return result;
	}
}
