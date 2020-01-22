package LeetCodeArrayList;

import TwoPointers.ListNode;

import java.util.*;

public class MergeKSortedLists_s2 {
	private Comparator<ListNode> comparator = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val;
		}
	};
	public ListNode mergeKLists(List<ListNode> lists) {
		Queue<ListNode> heap = new PriorityQueue<>(comparator);
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				heap.add(lists.get(i));
			}
		}

		ListNode dummy = new ListNode(0);
		ListNode head = dummy;

		while (!heap.isEmpty()) {
			head.next = heap.poll();
			head = head.next;
			if (head.next != null) {
				heap.add(head.next);
			}
		}

		return dummy.next;
	}
}
