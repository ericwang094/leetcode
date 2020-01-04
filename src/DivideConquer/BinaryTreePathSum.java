package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {
	/*
	 * @param root: the root of binary tree
	 * @param target: An integer
	 * @return: all valid paths
	 */
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		List<Integer> tempList = new ArrayList<>();
		tempList.add(root.val);
		helper(root, tempList, result, target - root.val);
		return result;
	}

	private void helper(TreeNode node, List<Integer> tempList, List<List<Integer>> result, int target) {
		if (node.left == null && node.right == null) {
			if (target == 0) {
				result.add(new ArrayList<>(tempList));
			}
		} else {
			if (node.left != null) {
				tempList.add(node.left.val);
				helper(node.left, tempList, result, target - node.left.val);
				tempList.remove(tempList.size() - 1);
			}

			if (node.right != null) {
				tempList.add(node.right.val);
				helper(node.right, tempList, result, target - node.right.val);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTreePathSum btps = new BinaryTreePathSum();
        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right = new TreeNode(4);

        input.left.left = new TreeNode(2);
        input.left.right = new TreeNode(3);

        btps.binaryTreePathSum(input, 5);
	}
}
