package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	/**
	 * @param root: A Tree
	 * @return: Preorder in ArrayList which contains node values.
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		// write your code here
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (root != null) {
			list.add(root.val);
			stack.add(root);
			root = root.left;
		}

		while (!stack.isEmpty()) {
			 TreeNode node = stack.pop();
			 if (node.right != null) {
			 	node = node.right;
			 	while (node != null) {
			 		list.add(node.val);
			 		stack.add(node);
			 		node = node.left;
			    }
			 } else {
			 	while (!stack.isEmpty() && stack.peek().right == node) {
			 		node = stack.pop();
			    }
			 }
		}

		return list;
	}

	public static void main(String[] args) {
		BinaryTreePreorderTraversal btpt = new BinaryTreePreorderTraversal();
		TreeNode input = new TreeNode(1);
		input.right = new TreeNode(2);
		input.right.right = new TreeNode(3);

		btpt.preorderTraversal(input);
	}
}
