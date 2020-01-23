package LeetCodeArrayList;

import TwoPointers.ListNode;

public class RemoveDuplicateFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null) {
			if (fast.val != slow.val) {
				slow.next = fast;
				slow = slow.next;
			}
			fast = fast.next;
		}

		if (slow != null) {
			slow.next = null;
		}
		return head;
	}

	public ListNode deleteDuplicatesII(ListNode head) {
		ListNode node = head;
		while (node != null && node.next != null) {
			if (node.val == node.next.val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}
}
