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
			} else {
				head = head.next;
			}
		}

		return dummy.next;
	}

	private ListNode reverseListNode(ListNode head, ListNode end) {
		ListNode curr = head.next;
		ListNode firstNode = curr;
		ListNode pre = head;

		while (curr != end) {
			ListNode next = curr.next;
			curr.next = pre;

			pre = curr;
			curr = next;
		}

		head.next = pre;
		firstNode.next = curr;

		return firstNode;
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
