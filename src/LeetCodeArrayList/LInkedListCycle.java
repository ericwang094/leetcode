package LeetCodeArrayList;

import TwoPointers.ListNode;

import java.util.HashSet;

public class LInkedListCycle {
	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> visitedNode = new HashSet<>();
		while (head != null) {
			if (visitedNode.contains(head)) {
				return true;
			}
			visitedNode.add(head);
			head = head.next;
		}

		return false;
	}

	public boolean hasCycle2(ListNode head) {
		if (head == null) return false;
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}

		return false;
	}
}
