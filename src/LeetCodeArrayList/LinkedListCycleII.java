package LeetCodeArrayList;

import TwoPointers.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();

		while (head != null) {
			if (set.contains(head)) {
				return head;
			}
			set.add(head);
			head = head.next;
		}

		return null;
	}
}
