package LeetCodeArrayList;

import TwoPointers.ListNode;

public class AddTwoNum {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode currentNode = dummy;

		boolean carry = false;
		while (l1 != null || l2 != null) {

			int l1Val = l1 == null ? 0 : l1.val;
			int l2Val = l2 == null ? 0 : l2.val;

			int newVal = carry ? l1Val + l2Val + 1 : l1Val + l2Val;

			carry = newVal >= 10;
			if (carry) {
				newVal -= 10;
			}
			currentNode.next = new ListNode(newVal);
			currentNode = currentNode.next;

			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}

		if (carry) {
			currentNode.next = new ListNode(1);
		}

		return dummy.next;
	}
}
