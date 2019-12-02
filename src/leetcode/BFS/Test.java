package leetcode.BFS;

import TwoPointers.ListNode;

import java.util.*;

public class Test {
	/**
	 * @param root the root of binary tree
	 * @return a lists of linked list
	 */
	public List<ListNode> binaryTreeToLists(TreeNode root) {
		List<ListNode> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		// Write your code here
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			ListNode dummy = new ListNode(0);
			ListNode currentList = dummy;
			for (int i = 0; i < size; i++) {
				TreeNode currentNode = queue.poll();
				currentList.next = new ListNode(currentNode.val);
				currentList = currentList.next;

				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}

			result.add(dummy.next);
		}

		return result;
	}

	public static void main(String[] args) {
		Test t = new Test();
		int[] input = {1, 2, 3};
		int[][] des = {{1,2}, {1,3}, {2,3}};

	}
}

