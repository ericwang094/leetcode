package LeetcodeTree;

import leetcode.BFS.TreeNode;

public class ConstructBinaryTreeInorderPostorderTraversal_106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode helper(int[] inorder, int[] postorder, int postStart, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}

		TreeNode node = new TreeNode(postorder[postStart]);
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == node.val) {
				index = i;
				break;
			}
		}

		node.left = helper(inorder, postorder, postStart + index - inEnd - 1, inStart, index - 1);
		node.right = helper(inorder, postorder, postStart - 1, index + 1, inEnd);

		return node;
	}
}
