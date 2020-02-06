package LeetCodeArrayList;

import TwoPointers.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}

		while (headB != null) {
			if (set.contains(headB)) {
				return headB;
			}

			headB = headB.next;
		}

		return null;
	}

	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		ListNode tempA = headA;
		ListNode tempB = headB;

		while (tempA != tempB) {
			tempA = tempA == null?headB: tempA.next;
			tempB = tempB == null ? headA : tempB.next;
		}

		return tempA;

	}
}
