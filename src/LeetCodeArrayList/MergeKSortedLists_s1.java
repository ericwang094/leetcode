package LeetCodeArrayList;

import TwoPointers.ListNode;

import java.util.List;

public class MergeKSortedLists_s1 {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		return mergeHelper(lists, 0, lists.size() - 1);
	}

	private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
		if (start == end) {
			return lists.get(start);
		}

		int mid = start + (end - start) / 2;
		ListNode left = mergeHelper(lists, start, mid);
		ListNode right = mergeHelper(lists, mid + 1, end);

		return mergeTwoLists(left, right);
	}

	private ListNode mergeTwoLists(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				head.next = new ListNode(left.val);
				head = head.next;
				left = left.next;
			} else {
				head.next = new ListNode(right.val);
				head = head.next;
				right = right.next;
			}
		}
		if (left != null) {
			head.next = left;
		}
		if (right != null) {
			head.next = right;
		}

		return dummy.next;
	}
}
