package LeetCodeArrayList;

import TwoPointers.ListNode;
import leetcode.BFS.TreeNode;

public class ConvertSortedListBinarySearchTree_s3 {
	private ListNode head;

	private int findSize(ListNode head) {
		ListNode ptr = head;
		int c = 0;
		while (ptr != null) {
			ptr = ptr.next;
			c += 1;
		}
		return c;
	}

	private TreeNode convertListToBST(int l, int r) {
		// Invalid case
		if (l > r) {
			return null;
		}

		int mid = (l + r) / 2;

		// First step of simulated inorder traversal. Recursively form
		// the left half
		TreeNode left = this.convertListToBST(l, mid - 1);

		// Once left half is traversed, process the current node
		TreeNode node = new TreeNode(this.head.val);
		node.left = left;

		// Maintain the invariance mentioned in the algorithm
		this.head = this.head.next;

		// Recurse on the right hand side and form BST out of them
		node.right = this.convertListToBST(mid + 1, r);
		return node;
	}

	public TreeNode sortedListToBST(ListNode head) {
		// Get the size of the linked list first
		int size = this.findSize(head);

		this.head = head;

		// Form the BST now that we know the size
		return convertListToBST(0, size - 1);
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(-10);
		node.next = new ListNode(-3);
		node.next.next = new ListNode(0);
//		node.next.next.next = new ListNode(5);
//		node.next.next.next.next = new ListNode(9);

		ConvertSortedListBinarySearchTree_s3 test = new ConvertSortedListBinarySearchTree_s3();
		test.sortedListToBST(node);
	}
}
