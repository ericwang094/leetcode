package LeetCodeArrayList;

import TwoPointers.ListNode;
import leetcode.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListBinarySearchTree_s2 {
	private List<Integer> values = new ArrayList<>();

	public TreeNode sortedListToBST(ListNode head) {
		while (head != null) {
			values.add(head.val);
			head = head.next;
		}

		return helper(values, 0, values.size() - 1);
	}

	private TreeNode helper(List<Integer> list, int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(list.get(mid));
		node.left = helper(list, start, mid - 1);
		node.right = helper(list, mid + 1, end);
		return node;
	}
}
