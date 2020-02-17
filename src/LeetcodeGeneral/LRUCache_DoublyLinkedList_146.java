package LeetcodeGeneral;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_DoublyLinkedList_146 {
	class LRUCache {
		int capacity;
		Map<Integer, DoublyNode> map;
		DoublyNode head;
		DoublyNode tail;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			this.map = new HashMap<>();
			this.head = new DoublyNode(0, 0);
			this.tail = new DoublyNode(0, 0);

			this.head.next = tail;
			this.tail.prev = head;
		}

		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}

			DoublyNode node = map.get(key);
			moveToTail(node);

			System.out.println(node.val);
			return node.val;
		}

		public void put(int key, int value) {
			if (this.get(key) != -1) {
				map.get(key).val = value;
				return;
			}

			if (this.capacity == map.size()) {
				map.remove(head.next.key);
				head.next = head.next.next;
				head.next.prev = head;

			}

			DoublyNode node = new DoublyNode(key, value);
			map.put(key, node);
			moveToTail(node);
		}

		private void moveToTail(DoublyNode node) {
			if (node.prev != null) {
				node.prev.next = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			}

			node.next = tail;
			tail.prev.next = node;
			node.prev = tail.prev;
			tail.prev = node;
		}
	}

	private class DoublyNode {
		DoublyNode prev;
		DoublyNode next;
		int key;
		int val;

		public DoublyNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		LRUCache_DoublyLinkedList_146 test = new LRUCache_DoublyLinkedList_146();
		LRUCache realTest = test.new LRUCache(2);
		realTest.put(1, 1);
		realTest.put(2, 2);
		realTest.get(1);
		realTest.put(3, 3);
		realTest.get(2);
		realTest.put(4, 4);
		realTest.get(1);
		realTest.get(3);
		realTest.get(4);
	}
}
