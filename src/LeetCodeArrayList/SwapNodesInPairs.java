package LeetCodeArrayList;

import TwoPointers.ListNode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode tempHead = head.next;
		head.next = head.next.next;
		tempHead.next = head;

		tempHead.next.next = swapPairs(tempHead.next.next);

		return tempHead;
	}

	public ListNode swapPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;

		while (current.next != null && current.next.next != null) {
			ListNode first = current.next;
			ListNode second = current.next.next;
			first.next = second.next;
			current.next = second;

			current.next.next = first;
			current = current.next.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		SwapNodesInPairs snp = new SwapNodesInPairs();

		ListNode input = new ListNode(1);
		input.next = new ListNode(2);
		input.next.next = new ListNode(3);
		input.next.next.next = new ListNode(4);

		ListNode list = snp.swapPairs(input);
	}
}
