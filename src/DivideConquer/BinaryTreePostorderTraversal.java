package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	/**
	 * @param root: A Tree
	 * @return: Postorder in ArrayList which contains node values.
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		// write your code here
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		helper(root, result);
		return result;
	}

	private void helper(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}

		helper(root.left, result);
		helper(root.right, result);
		result.add(root.val);
	}

	//https://www.youtube.com/watch?v=xLQKdq0Ffjg
	public List<Integer> postorderTraversalWithStack(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (root != null) {
			stack.add(root);
			root = root.left;
		}

		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.right == null) {
				node = stack.pop();
				result.add(node.val);

				while (!stack.isEmpty() && stack.peek().right == node) {
					node = stack.pop();
					result.add(node.val);
				}
			} else {
				node = node.right;
				while (node != null) {
					stack.add(node);
					node = node.left;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		BinaryTreePostorderTraversal btpt = new BinaryTreePostorderTraversal();
		TreeNode input = new TreeNode(1);
		input.left = new TreeNode(2);
		input.right = new TreeNode(3);

//		btpt.postorderTraversal2(input);
	}
}
