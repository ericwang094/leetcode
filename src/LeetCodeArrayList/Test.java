package LeetCodeArrayList;

import TwoPointers.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode current = result;
		boolean carry = false;

		while (l1 != null || l2 != null) {
			int l1Val = l1 == null ? 0 : l1.val;
			int l2Val = l2 == null ? 0 : l2.val;

			int newSum = l1Val + l2Val;
			if (carry) {
				newSum += 1;
			}

			carry = newSum >= 10;
			if (carry) {
				newSum -= 10;
			}

			current.next = new ListNode(newSum);
			current = current.next;

			l1 = l1 == null ? l1 : l1.next;
			l2 = l2 == null ? l2 : l2.next;
		}

		if (carry) {
			current.next = new ListNode(1);
		}

		return result.next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode slow = dummy;
		ListNode fast = head;

		for (int i = 1; i < n; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;

		return dummy.next;
	}

	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode pre = dummy;

		while (head != null && head.next != null) {
			ListNode next = head.next;
			ListNode nextTwo = next.next;

			pre.next = next;
			next.next = head;
			head.next = nextTwo;

			pre = head;
			head = pre.next;
		}

		return dummy.next;
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}

		ListNode current = head;

		int length = 0;
		while (current != null) {
			current = current.next;
			length++;
		}

		while (k >= length) {
			k = k - length;
		}

		if (k == 0) {
			return head;
		}

		ListNode lastEle = head;
		ListNode fast = head;

		while (k > 0) {
			fast = fast.next;
			k--;
		}

		while (fast.next != null) {
			lastEle = lastEle.next;
			fast = fast.next;
		}

		ListNode needToRotate = lastEle.next;
		lastEle.next = null;
		fast.next = head;

		return needToRotate;
	}



	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;

		while (l1 != null && l2 != null) {
			int l1Val = l1.val;
			int l2Val = l2.val;

			if (l1Val < l2Val) {
				head.next = new ListNode(l1Val);
				l1 = l1.next;
			} else {
				head.next = new ListNode(l2Val);
				l2 = l2.next;
			}
			head = head.next;
		}

		if (l1 != null) {
			head.next = l1;
		}

		if (l2 != null) {
			head.next = l2;
		}

		return dummy.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return mergeKListsHelper(lists, 0, lists.length - 1);
	}

	private ListNode mergeKListsHelper(ListNode[] lists, int min, int max) {
		if (min == max) {
			return lists[min];
		}

		int mid = min + (max - min) / 2;
		ListNode list1 = mergeKListsHelper(lists, min, mid);
		ListNode list2 = mergeKListsHelper(lists, mid + 1, max);

		return mergeTwoLists(list1, list2);
	}

	public ListNode mergeKLists_s2(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		Queue<ListNode> priorityQueue = new PriorityQueue<>(comparator);
		for (int i = 0; i < lists.length; i++ ) {
			if (lists[i] != null) {
				priorityQueue.add(lists[i]);
			}
		}

		ListNode dummy = new ListNode(0);
		ListNode head = dummy.next;

		while (priorityQueue.size() != 0) {
			head.next = priorityQueue.poll();
			head = head.next;
			if (head.next != null) {
				priorityQueue.add(head.next);
			}
		}

		return dummy.next;

	}

	private Comparator<ListNode> comparator = new Comparator<ListNode>(){
		@Override
		public int compare (ListNode l1, ListNode l2) {
			return l1.val - l2.val;
		}
	};

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode slow = dummy;
		ListNode fast = dummy.next;
		while (fast != null) {
			while (fast.val == fast.next.val) {
				fast = fast.next;
			}

			if (slow.next == fast) {
				slow = slow.next;
			} else {
				slow.next = fast.next;
			}

			fast = fast.next;
		}

		return dummy.next;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode reversedNode = reverseList(head.next);
		head.next.next = head;
		head.next = null;

		return reversedNode;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode connection = dummy;
		ListNode tail = head;

		for (int i = 0; i < n; i++) {
			if (i == m - 1) {
				connection = head;
				tail = head.next;
			}

			head = head.next;
		}

		ListNode pre = null;
		ListNode current = connection.next;

		while (current != head.next) {
			ListNode next = current.next;
			current.next = pre;

			pre = current;
			current = next;
		}

		tail.next = current;

		connection.next = pre;

		return dummy.next;
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode midNode = findMid(head);
		ListNode reversedTail = reverseListNode(midNode);

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode next = null;
		ListNode reversedTailNext = null;
		while (head.next != null) {
			next = head.next;
			reversedTailNext = reversedTail.next;

			head.next = reversedTail;
			reversedTail.next = next;

			head = next;
			reversedTail = reversedTailNext;
		}

		if (reversedTail != null) {
			head.next = reversedTail;
		}
	}

	private ListNode reverseListNode(ListNode node) {
		ListNode prev = null;

		while (node != null) {
			ListNode next = node.next;
			node.next = prev;

			prev = node;
			node = next;
		}

		return prev;
	}

	private ListNode findMid(ListNode node) {
		ListNode fast = node;
		ListNode slow = node;
		ListNode prev = node;

		while (fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}

		prev.next = null;
		return slow;
	}

	public static void main(String[] args) {
//		ListNode input1 = new ListNode(2);
//		input1.next = new ListNode(4);
//		input1.next.next = new ListNode(3);
//
//		ListNode input2 = new ListNode(5);
//		input2.next = new ListNode(6);
//		input2.next.next = new ListNode(4);

//		ListNode input1 = new ListNode(1);
//		input1.next = new ListNode(2);
//		input1.next.next = new ListNode(3);
//		input1.next.next.next = new ListNode(4);
//		input1.next.next.next.next = new ListNode(5);

		ListNode input1 = new ListNode(1);
		input1.next = new ListNode(2);
		input1.next.next = new ListNode(3);


		Test test = new Test();
		test.reverseBetween(input1,1 ,2);
		input1.next.next.next = new ListNode(4);
		input1.next.next.next.next = new ListNode(5);
		
		test.reorderList(input1);
	}
}
