package LeetCodeArrayList;

import TwoPointers.ListNode;

import java.util.HashMap;

public class RemoveNthNodeFromEndList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		HashMap<Integer, ListNode> map = new HashMap<>();
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		map.put(0, dummy);

		int position = 1;
		ListNode node = head;
		while (node != null) {
			map.put(position, node);
			node = node.next;
			position++;
		}

		ListNode nodeBeforeRemoved = map.get(position - 1 - n);

		nodeBeforeRemoved.next = nodeBeforeRemoved.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndList test = new RemoveNthNodeFromEndList();
//		ListNode input = new ListNode(1);
//		input.next = new ListNode(2);
//		input.next.next = new ListNode(3);
//		input.next.next.next = new ListNode(4);
//		input.next.next.next.next = new ListNode(5);

		ListNode input = new ListNode(1);

		test.removeNthFromEnd(input, 1);
	}
}
