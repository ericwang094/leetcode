package DivideConquer;

import leetcode.BFS.TreeNode;

public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftMax = maxPathSum(root.left);
		int rightMax = maxPathSum(root.right);
		int sum = Math.max(root.val, Math.max(leftMax + root.val, rightMax + root.val));

		max = Math.max(max, Math.max(leftMax + rightMax + root.val, sum));
		return sum;
	}


	public int maxPathSum2(TreeNode root) {
		// write your code here
		helper2(root);
		return max;
	}

	private int helper2(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftMax = helper2(node.left);
		int rightMax = helper2(node.right);

		int curMax = Math.max(leftMax + node.val, rightMax + node.val);
		max = Math.max(curMax, max);

		return curMax;
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum btp3 = new BinaryTreeMaximumPathSum();
		TreeNode input = new TreeNode(-1);
		input.left = new TreeNode(2);
		input.right = new TreeNode(10);

		btp3.maxPathSum2(input);
	}
}
