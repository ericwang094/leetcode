package LeetCodeArrayList;

import TwoPointers.ListNode;
import TwoPointers.PartitionArray;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}

		return prev;
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode reversedListHead = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return reversedListHead;
	}

	public ListNode test(ListNode head) {

		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;

		while (cur != null) {
			next = cur.next;
			cur.next = pre;

			pre = cur;
			cur = next;
		}

		return pre;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);

		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode result = rll.reverseList(node);
	}

}
