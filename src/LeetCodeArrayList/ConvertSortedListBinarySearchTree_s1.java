package LeetCodeArrayList;

import TwoPointers.ListNode;
import leetcode.BFS.TreeNode;

public class ConvertSortedListBinarySearchTree_s1 {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode midNode = findMid(head);
		TreeNode root = new TreeNode(midNode.val);

		if (midNode == head) {
			return root;
		}
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(midNode.next);
		return root;
	}

	private ListNode findMid(ListNode head) {
		ListNode prev = null;
		ListNode fastNode = head;
		ListNode slowNode = head;
		while (fastNode != null && fastNode.next != null) {
			prev = slowNode;
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		if (prev != null) {
			prev.next = null;
		}
		return slowNode;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(-10);
		node.next = new ListNode(-3);
		node.next.next = new ListNode(0);
//		node.next.next.next = new ListNode(5);
//		node.next.next.next.next = new ListNode(9);

		ConvertSortedListBinarySearchTree_s1 test = new ConvertSortedListBinarySearchTree_s1();
		test.sortedListToBST(node);
	}
}
