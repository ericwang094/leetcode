package LeetCodeArrayList;

import TwoPointers.ListNode;

public class Test {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode current = result;
		boolean carry = false;

		while (l1 != null || l2 != null) {
			int l1Val = l1 == null ? 0 : l1.val;
			int l2Val = l2 == null ? 0 : l2.val;

			int newSum = l1Val + l2Val;
			if (carry) {
				newSum += 1;
			}

			carry = newSum >= 10;
			if (carry) {
				newSum -= 10;
			}

			current.next = new ListNode(newSum);
			current = current.next;

			l1 = l1 == null ? l1 : l1.next;
			l2 = l2 == null ? l2 : l2.next;
		}

		if (carry) {
			current.next = new ListNode(1);
		}

		return result.next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode slow = dummy;
		ListNode fast = head;

		for (int i = 1; i < n; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode input1 = new ListNode(2);
		input1.next = new ListNode(4);
		input1.next.next = new ListNode(3);

		ListNode input2 = new ListNode(5);
		input2.next = new ListNode(6);
		input2.next.next = new ListNode(4);

		Test test = new Test();
		test.addTwoNumbers(input1, input2);
	}
}
