package LeetCodeArrayList;

import TwoPointers.ListNode;

import java.util.ArrayList;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// reverse second half
		ListNode currentNode = slow.next;
		ListNode pre = null;

		slow.next = null;

		while (currentNode != null) {
			ListNode next = currentNode.next;
			currentNode.next = pre;

			pre = currentNode;
			currentNode = next;
		}

		ListNode l1 = dummy.next;
		while (l1 != null) {
			ListNode l1Next = l1.next;
			ListNode preNext = pre == null ? pre : pre.next;

			l1.next = pre;
			if (l1.next != null) {
				l1.next.next = l1Next;
			}
			l1 = l1Next;
			pre = preNext;
		}
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);

		ReorderList test = new ReorderList();
		test.reorderList(node);
	}
}
