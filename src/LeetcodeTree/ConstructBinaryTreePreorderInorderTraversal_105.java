package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreePreorderInorderTraversal_105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[0]);
		int indexForInorder = findIndex(inorder, node.val);
		if (indexForInorder == -1 ){
			return null;
		}
		int[] newPreorderLeft = Arrays.copyOfRange(preorder, 1, preorder.length);
		int[] newPreorderRight = Arrays.copyOfRange(preorder, indexForInorder + 1, preorder.length);

		int[] newInorderLeft = Arrays.copyOfRange(inorder, 0, indexForInorder);
		int[] newInorderRight = Arrays.copyOfRange(inorder, indexForInorder + 1, inorder.length);

		node.left = buildTree(newPreorderLeft, newInorderLeft);
		node.right = buildTree(newPreorderRight, newInorderRight);

		return node;
	}

	public TreeNode buildTree_2(int[] preorder, int[] inorder) {
		return helper(preorder, inorder, 0, 0, inorder.length);
	}

	private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[preStart]);
		int midIndex = 0;
		for (int i = inStart; i < inEnd; i++) {
			if (inorder[i] == node.val) {
				midIndex = i;
			}
		}
		node.left = helper(preorder, inorder, preStart + 1, inStart, midIndex - 1);
		node.right = helper(preorder, inorder, preStart + midIndex - inStart + 1, midIndex + 1, inEnd);

		return node;
	}

	private int findIndex(int[] array, int val) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == val) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder  = {9,3,15,20,7};

		ConstructBinaryTreePreorderInorderTraversal_105 test = new ConstructBinaryTreePreorderInorderTraversal_105();
		TreeNode result = test.buildTree(preorder, inorder);
	}
}
