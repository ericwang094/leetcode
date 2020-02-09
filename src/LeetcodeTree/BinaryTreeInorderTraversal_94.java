package LeetcodeTree;

import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
	private List<Integer> list = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return null;
		}
		inorderTraversal(root.left);
		list.add(root.val);
		inorderTraversal(root.right);

		return list;
	}


}
