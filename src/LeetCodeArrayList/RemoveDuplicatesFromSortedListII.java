package LeetCodeArrayList;

import TwoPointers.ListNode;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);

		dummy.next = head;

		ListNode fast = dummy.next;
		ListNode slow = dummy;
		while (fast != null) {
			while (fast.next != null && fast.val == fast.next.val) {
				fast = fast.next;
			}

			if (slow.next == fast) {
				slow = slow.next;
			} else {
				slow.next = fast.next;
			}

			fast = fast.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII rfel = new RemoveDuplicatesFromSortedListII();

//		ListNode node = new ListNode(1);
//		node.next = new ListNode(2);
//		node.next.next = new ListNode(3);
//		node.next.next.next = new ListNode(3);
//		node.next.next.next.next = new ListNode(4);
//		node.next.next.next.next.next = new ListNode(4);
//		node.next.next.next.next.next.next = new ListNode(5);

		ListNode node = new ListNode(1);
		node.next = new ListNode(1);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(2);
		node.next.next.next.next = new ListNode(3);

		rfel.deleteDuplicates(node);
	}
}
