package LeetCodeArrayList;

import TwoPointers.ListNode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode smallDummy = new ListNode(0);
		ListNode smallList = smallDummy;

		ListNode bigDummy = new ListNode(0);
		ListNode bigList = bigDummy;

		while (head != null) {
			if (head.val < x) {
				smallList.next = head;
				smallList = smallList.next;
			} else {
				bigList.next = head;
				bigList = bigList.next;
			}

			head = head.next;
		}

		bigList.next = null;
		smallList.next = bigDummy.next;

		return smallDummy.next;
	}

	public static void main(String[] args) {
		PartitionList rfel = new PartitionList();

		ListNode node = new ListNode(1);
		node.next = new ListNode(4);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(2);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(2);

		rfel.partition(node, 3);
	}
}
