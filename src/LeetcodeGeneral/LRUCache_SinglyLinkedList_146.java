package LeetcodeGeneral;


import java.util.HashMap;
import java.util.Map;
import TwoPointers.ListNode;

import java.util.HashMap;
import java.util.Map;
public class LRUCache_SinglyLinkedList_146 {
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

			System.out.println(currentNode.val);
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
				mapKToPrev.put(head.next.key, head);
			}

			ListNode newNode = new ListNode(key, value);
			ListNode lastEle = mapKToPrev.get(this.tail.key);
			lastEle.next = newNode;
			newNode.next = tail;

			mapKToPrev.put(key, lastEle);
			mapKToPrev.put(tail.key, newNode);
		}
	}

	public static void main(String[] args) {
		LRUCache_SinglyLinkedList_146 test = new LRUCache_SinglyLinkedList_146();
		LRUCache_SinglyLinkedList_146.LRUCache realTest = test.new LRUCache(3);
		realTest.put(1, 1);
		realTest.put(2, 2);
		realTest.put(3, 3);
		realTest.put(4, 4);
		realTest.get(4);
		realTest.get(3);
		realTest.get(2);
		realTest.get(1);
		realTest.put(5, 5);
		realTest.get(1);
		realTest.get(2);
		realTest.get(3);
		realTest.get(4);
		realTest.get(5);
	}
}
