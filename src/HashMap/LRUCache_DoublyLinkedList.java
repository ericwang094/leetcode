package HashMap;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_DoublyLinkedList {
	private class DoublyList {
		DoublyList prev;
		DoublyList next;
		int key;
		int value;

		public DoublyList(int key, int value) {
			this.prev = null;
			this.next = null;
			this.key = key;
			this.value = value;
		}
	}

	private int capacity;
	private Map<Integer, DoublyList> map;
	private DoublyList head;
	private DoublyList tail;

	public LRUCache_DoublyLinkedList (int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.head = new DoublyList(-1, -1);
		this.tail = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			return -1;
		}

		// move element to last of list
		DoublyList node = map.get(key);
		moveToTail(node);


		return node.value;
	}

	public void set(int key, int value) {
		if (this.get(key) != -1) {
			this.map.get(key).value = value;
		}

		if (map.size() == capacity) {
			map.remove(this.head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}

		DoublyList node = new DoublyList(key, value);
		this.map.put(key, node);
		this.moveToTail(node);
	}

	private void moveToTail(DoublyList node) {
		node.prev.next = node.next;

		node.prev = this.tail.prev;
		node.next = this.tail;

		this.tail.prev = node;
	}
}
