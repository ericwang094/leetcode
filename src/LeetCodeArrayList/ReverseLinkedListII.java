package LeetCodeArrayList;

import TwoPointers.ListNode;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode pre = null;
		ListNode next = null;
		ListNode curr = head;

		ListNode remainHead = null;
		ListNode remainTail = null;

		ListNode lastEle = curr;
		int count = 1;

		while (curr != null) {
			if (count >= m && count <= n) {
				if (count == m) {
					lastEle = curr;
				}
				next = curr.next;
				curr.next = pre;

				pre = curr;
				curr = next;
			} else if (count < m){
				remainHead = curr;
				curr = curr.next;
			} else {
				remainTail = curr;
				curr = curr.next;
			}
			count++;
		}

		if (remainHead != null) {
			remainHead.next = pre;
		}
		if (lastEle != null) {
			lastEle.next = remainTail;
		}

		return dummy.next;
	}

	public ListNode reverseBetween1(ListNode head, int m, int n) {
		ListNode prev = null;
		ListNode current = head;
		for (int i = 1; i < m; i++) {
			prev = current;
			current = current.next;

		}

		ListNode connectionNode = prev;
		ListNode tail = current;

		for (int i = 1; i <= n - m + 1; i++) {
			ListNode next = current.next;
			current.next = prev;

			prev = current;
			current = next;
		}

		if (connectionNode != null) {
			connectionNode.next = prev;
		} else {
			head = prev;
		}

		tail.next = current;

		return head;
	}

	public ListNode reverseBetween2(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode connectionNode = dummy;


		for (int i = 1; i < m; i++) {
			connectionNode = head;
			head = head.next;
		}

		for (int i = 1; i <= n - m + 1; i++) {
			ListNode next = head.next;
			head.next = next.next;
			next.next = connectionNode.next;
			connectionNode.next = next;
		}

		return dummy.next;
	}

	public ListNode test (ListNode head, int m, int n) {
		ListNode current = head;
		ListNode prev = null;
		for (int i = 1; i < m; i++) {
			prev = current;
			current = current.next;
		}

		ListNode connectionNode = prev;
		ListNode tail = current;

		for (int i = m; i <= n; i++) {
			ListNode next = current.next;
			current.next = prev;

			prev = current;
			current = next;
		}

		if (connectionNode != null) {
			connectionNode.next = prev;
		} else {
			head = prev;
		}

		tail.next = current;

		return head;
	}

	public static void main(String[] args) {
//		ListNode node = new ListNode(1);
//		node.next = new ListNode(2);
//		node.next.next = new ListNode(3);
//		node.next.next.next = new ListNode(4);
//		node.next.next.next.next = new ListNode(5);

		ListNode node = new ListNode(1);

		ReverseLinkedListII rll = new ReverseLinkedListII();
//		ListNode result = rll.reverseBetween(node, 2, 4);
//		ListNode result = rll.test(node, 1, 1);
		ListNode result = rll.reverseBetween1(node, 1, 1);
	}
}
