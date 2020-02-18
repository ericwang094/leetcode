package General;

import TwoPointers.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private class ListNode {
		int val;
		int key;
		ListNode next;

		public ListNode(int key, int val) {
			this.val = val;
			this.key = key;
		}
	}
	int capacity;
	Map<Integer, ListNode> mapKToPrev;
	ListNode head;
	ListNode tail;
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.mapKToPrev = new HashMap<>();
		this.head = new ListNode(-1, -1);
		this.tail = new ListNode(-2, -2);
		mapKToPrev.put(tail.key, head);
		head.next = tail;
	}

	public int get(int key) {
		if (!mapKToPrev.containsKey(key)) {
			return -1;
		}

		ListNode prevNode = mapKToPrev.get(key);
		ListNode currentNode = prevNode.next;

		prevNode.next = prevNode.next.next;
		mapKToPrev.put(prevNode.next.key, prevNode);

		ListNode lastEle = mapKToPrev.get(this.tail.key);
		lastEle.next = currentNode;
		mapKToPrev.put(currentNode.key, lastEle);

		currentNode.next = tail;
		mapKToPrev.put(tail.key, currentNode);

		return currentNode.val;
	}

	public void put(int key, int value) {
		if (this.get(key) != -1) {
			mapKToPrev.get(key).next.val = value;
			return;
		}

		if (this.capacity == mapKToPrev.size() - 1) {
			mapKToPrev.remove(mapKToPrev.get(head.next.key).next.key);
			this.head.next = this.head.next.next;
		}

		ListNode newNode = new ListNode(key, value);
		ListNode lastEle = mapKToPrev.get(this.tail.key);
		lastEle.next = newNode;
		newNode.next = tail;

		mapKToPrev.put(key, lastEle);
		mapKToPrev.put(tail.key, newNode);
	}

	public static void main(String[] args) {

		LRUCache test = new LRUCache(3);
		test.put(1, 1);
		test.put(2, 2);
		test.put(3, 3);
		test.put(4, 4);
		test.get(4);
		test.get(3);
		test.get(2);
		test.get(1);
		test.put(5, 5);
		test.get(1);
		test.get(2);
		test.get(3);
		test.get(4);
		test.get(5);
//		LRUCache test = new LRUCache(1);
//		test.put(2, 1);
//		test.get(2);
	}
}
