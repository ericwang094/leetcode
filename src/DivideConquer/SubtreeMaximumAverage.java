package DivideConquer;

import leetcode.BFS.TreeNode;

public class SubtreeMaximumAverage {
	private ResultTypeWithCountAndSum rt = null;
	/**
	 * @param root: the root of binary tree
	 * @return: the root of the maximum average of subtree
	 */
	public TreeNode findSubtree2(TreeNode root) {
		if (root == null) {
			return null;
		}
		helper(root);
		return rt.root;
	}

	private ResultTypeWithCountAndSum helper(TreeNode node) {
		if (node == null) {
			return new ResultTypeWithCountAndSum(node, 0, 0);
		}

		ResultTypeWithCountAndSum left = helper(node.left);
		ResultTypeWithCountAndSum right = helper(node.right);

		int sum = left.sum + right.sum + node.val;
		int count = left.count + right.count + 1;
		ResultTypeWithCountAndSum newRt = new ResultTypeWithCountAndSum(node, sum, count);

		if (rt == null || newRt.sum * rt.count > newRt.count * rt.sum) {
			this.rt = newRt;
		}

		return newRt;
	}

	class ResultTypeWithCountAndSum {
		public TreeNode root;
		public int sum;
		public int count;

		public ResultTypeWithCountAndSum(TreeNode root, int sum, int count) {
			this.root = root;
			this.sum = sum;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		SubtreeMaximumAverage sma = new SubtreeMaximumAverage();

//		TreeNode input = new TreeNode(1);
//		input.left = new TreeNode(-5);
//		input.right = new TreeNode(11);
//
//		input.left.left = new TreeNode(1);
//		input.left.right = new TreeNode(2);
//
//		input.right.left = new TreeNode(4);
//		input.right.right = new TreeNode(-2);

		TreeNode input = null;

		sma.findSubtree2(input);


	}
}
