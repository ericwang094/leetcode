package HashMap;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_SinglyLinkedList {
	private Map<Integer, ListNode> keyToPrev;
	private ListNode head;
	private ListNode tail;
	private int capacity;
	/*
	 * @param capacity: An integer
	 */public LRUCache_SinglyLinkedList(int capacity) {
		// do intialization if necessary
		this.capacity = capacity;
		this.keyToPrev = new HashMap<>();
		this.head = new ListNode(-1, -1);
		this.tail = head;
	}

	/*
	 * @param key: An integer
	 * @return: An integer
	 */
	public int get(int key) {
		// write your code here
		if (!keyToPrev.containsKey(key)) {
			return -1;
		}

		moveToEnd(key);
		return keyToPrev.get(key).next.val;
	}

	/*
	 * @param key: An integer
	 * @param value: An integer
	 * @return: nothing
	 */
	public void set(int key, int value) {
		if (get(key) != -1) {
			keyToPrev.get(key).next.val = value;
			return;
		}

		if (keyToPrev.size() == capacity) {
			// remove first element
			keyToPrev.remove(head.next.key);
			head.next = head.next.next;

			if (head.next != null) {
				keyToPrev.put(head.next.key, head);
			}
		}

		ListNode node = new ListNode(value, key);
		tail.next = node;

		keyToPrev.put(key, tail);

		tail = node;
	}

	private void moveToEnd(int key) {
		ListNode prevNode = keyToPrev.get(key);

		if (prevNode.next.next != null) {
			tail.next = prevNode.next;
			keyToPrev.put(prevNode.next.key, tail);
			tail = prevNode.next;

			prevNode.next = prevNode.next.next;
			keyToPrev.put(prevNode.next.key, prevNode);

		}
	}

	private class ListNode {
		int val;
		int key;
		ListNode next;

		public ListNode (int val, int key) {
			this.val = val;
			this.key = key;
		}
	}
}
