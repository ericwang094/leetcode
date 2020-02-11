package LeetCodeArrayList;

import TwoPointers.ListNode;

public class RemoveLinkedList {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode slow = dummy;
		ListNode fast = head;

		while (slow != null) {
			while (fast != null && fast.val == val) {
				fast = fast.next;
				slow.next = fast;
			}

			slow = slow.next;
			if (fast != null) {
				fast = fast.next;
			}
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(6);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);

		RemoveLinkedList test = new RemoveLinkedList();
		test.removeElements(node, 6);
	}
}
