package LeetCodeArrayList;

import TwoPointers.ListNode;

public class ReverseNodesInKGroup {
	ListNode pre = null;
	ListNode current = null;
	ListNode tail = null;

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		current = head;
		tail = head;

		pre = dummy;

		while (current != null) {
			reverseListNode(k);
			tail.next = pre;
			tail = current;
		}
		return dummy.next;
	}

	private void reverseListNode(int k) {
		while (current != null && k > 0) {
			ListNode next = current.next;
			current.next = pre;

			pre = current;
			current = next;

			k--;
		}
	}

	public static void main(String[] args) {
		ReverseNodesInKGroup snp = new ReverseNodesInKGroup();

		ListNode input = new ListNode(1);
		input.next = new ListNode(2);
		input.next.next = new ListNode(3);
		input.next.next.next = new ListNode(4);

		ListNode list = snp.reverseKGroup(input, 2);
	}
}
