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

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);

		ReverseLinkedListII rll = new ReverseLinkedListII();
		ListNode result = rll.reverseBetween(node, 2, 4);
	}
}
