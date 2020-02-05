package LeetCodeArrayList;

import TwoPointers.ListNode;

public class ReverseNodesInKGroup {


	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 1) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode start = dummy;

		int i = 0;

		while (head != null) {
			i++;
			if (i == k) {
				start = reverseListNode(start, head.next);
				head = start.next;
				i = 0;
			} else {
				head = head.next;
			}
		}

		return dummy.next;
	}

	private ListNode reverseListNode(ListNode start, ListNode end) {
		ListNode current = start.next;
		ListNode pre = start;
		ListNode first = current;

		while (current != end) {
			ListNode next = current.next;
			current.next = pre;

			pre = current;
			current = next;
		}

		start.next = pre;
		first.next = current;

		return first;
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
