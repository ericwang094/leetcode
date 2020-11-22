package DivideConquer;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumIII {
	public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
		// write your code here
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		dfs(root, target, result, new ArrayList<>());
		return result;
	}

	private void dfs(ParentTreeNode parent, int target, List<List<Integer>> result, List<Integer> tempList) {
		target -= parent.val;
		tempList.add(parent.val);
		if (target == 0) {
			result.add(new ArrayList<>(tempList));
		}

		if (parent.left != null) {
			dfs(parent.left, target, result, tempList);
		}

		if (parent.right != null) {
			dfs(parent.right, target, result, tempList);
		}

		tempList.remove(tempList.size() - 1);
	}

	public static void main(String[] args) {
		BinaryTreePathSumIII btp3 = new BinaryTreePathSumIII();
		ParentTreeNode input = new ParentTreeNode(1);
		input.left = new ParentTreeNode(2);
		input.right = new ParentTreeNode(3);
		input.left.left = new ParentTreeNode(4);
		btp3.binaryTreePathSum3(input, 6);
	}

	static class ParentTreeNode {
		public int val;
		public ParentTreeNode parent, left, right;

		public ParentTreeNode(int val) {
			this.val = val;
		}
	}
}
