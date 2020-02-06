package LeetCodeArrayList;

import TwoPointers.ListNode;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode mid = findMid(head);
		ListNode reversedMid = reverse(mid);

		while (head != null) {
			if (head.val != reversedMid.val) {
				return false;
			}

			head = head.next;
			reversedMid = reversedMid.next;
		}
		return true;
	}

	private ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		return slow;
	}

	private ListNode reverse(ListNode head) {
		ListNode current = head;
		ListNode pre = null;

		while (current != null) {
			ListNode next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}

		return pre;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(1);
//		node.next.next.next = new ListNode(4);
//		node.next.next.next.next = new ListNode(5);
//		node.next.next.next.next.next = new ListNode(6);

		PalindromeLinkedList test = new PalindromeLinkedList();
		test.isPalindrome(node);
	}
}
