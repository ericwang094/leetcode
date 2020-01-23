package LeetCodeArrayList;

import TwoPointers.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
			if (fast == null) {
				fast = head;
			}
		}

		if (fast == head) {
			return head;
		}


		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		ListNode firstNode = slow.next;

		fast.next = head;
		slow.next = null;

		return firstNode;
	}

	public static void main(String[] args) {
		RotateList rl = new RotateList();

		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);

		ListNode result = rl.rotateRight(node, 6);
	}
}
