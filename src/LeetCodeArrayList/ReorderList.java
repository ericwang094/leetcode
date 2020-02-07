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

	// solution 2
	public void reorderList2(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode midNode = findMid(head);
		ListNode reversedTail = reverseListNode(midNode);

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode next = null;
		ListNode reversedTailNext = null;
		while (head.next != null) {
			next = head.next;
			reversedTailNext = reversedTail.next;

			head.next = reversedTail;
			reversedTail.next = next;

			head = next;
			reversedTail = reversedTailNext;
		}

		if (reversedTail != null) {
			head.next = reversedTail;
		}
	}

	private ListNode reverseListNode(ListNode node) {
		ListNode prev = null;

		while (node != null) {
			ListNode next = node.next;
			node.next = prev;

			prev = node;
			node = next;
		}

		return prev;
	}

	private ListNode findMid(ListNode node) {
		ListNode fast = node;
		ListNode slow = node;
		ListNode prev = node;

		while (fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}

		prev.next = null;
		return slow;
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);

		ListNode temp = dummy;
		while (head != null) {
			temp = dummy;
			while (temp.next != null && temp.next.val < head.val) {
				temp = temp.next;
			}

			ListNode tempNext = temp.next;
			ListNode headNext = head.next;
			head.next = tempNext;
			temp.next = head;

			head = headNext;
		}
		return dummy.next;
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
