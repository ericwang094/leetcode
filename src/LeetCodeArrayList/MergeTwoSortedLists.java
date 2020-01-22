package LeetCodeArrayList;

import TwoPointers.ListNode;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;

		while (l1 != null || l2 != null) {
			int val1 = nextVal(l1);
			int val2 = nextVal(l2);
			if (val1 <= val2) {
				head.next = new ListNode(val1);
				l1 = l1.next;
			} else {
				head.next = new ListNode(val2);
				l2 = l2.next;
			}
			head = head.next;
		}

		return dummy.next;
	}

	private int nextVal (ListNode node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		} else {
			return node.val;
		}
	}
}
