package LeetCodeArrayList;

import TwoPointers.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;

		while (head != null) {
			pre = dummy;
			while (pre.next != null && pre.next.val < head.val) {
				pre = pre.next;
			}
			ListNode next = head.next;
			head.next = pre.next;
			pre.next = head;

			head = next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(4);
		node.next = new ListNode(2);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(3);

		InsertionSortList test = new InsertionSortList();
		test.insertionSortList(node);
	}
}
