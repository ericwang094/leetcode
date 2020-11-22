package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Test {
	ListNode head;
	ListNode tail;
	Map<Integer, Integer> keyValMap;
	Map<Integer, ListNode> keyToPrev;
	int size;

	/*
	 * @param capacity: An integer
	 */
	public Test(int capacity) {
		// do intialization if necessary
		this.head = new ListNode(0, 0);
		this.tail = head;
		this.keyToPrev = new HashMap<>();
		this.size = capacity;
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

		int result = keyToPrev.get(key).next.val;

		moveToLast(key);
		return result;
	}

	/*
	 * @param key: An integer
	 * @param value: An integer
	 * @return: nothing
	 */
	public void set(int key, int value) {
		// write your code here
		if (get(key) != -1) {
			keyToPrev.get(key).next.val = value;
		} else {
			if (keyToPrev.size() == size) {
				// remove first node
				ListNode firstNode = this.head.next;
				keyToPrev.remove(firstNode.key);

				this.head.next = this.head.next.next;
				if (head.next != null) {
					keyToPrev.put(head.next.key, head);
				}
			}

			ListNode newNode = new ListNode(key, value);
			tail.next = newNode;

			keyToPrev.put(key, tail);

			tail = newNode;
		}
	}

	private void moveToLast(int key) {
		ListNode prevNode = keyToPrev.get(key);
		ListNode currentNode = prevNode.next;
		ListNode nextNode = currentNode.next;

		if (nextNode != null) {
			// not tail;
			tail.next = currentNode;
			keyToPrev.put(currentNode.key, tail);
			tail = currentNode;

			prevNode.next = nextNode;
			keyToPrev.put(prevNode.next.key, prevNode);
		}
	}

	public static void main(String[] args) {

	}

	// private void moveToLast(int key) {
	//     ListNode prevNode = keyToPrev.get(key);

	//     if (prevNode.next.next != null) {
	//         tail.next = prevNode.next;
	//         keyToPrev.put(prevNode.next.key, tail);
	//         tail = prevNode.next;

	//         prevNode.next = prevNode.next.next;
	//         keyToPrev.put(prevNode.next.key, prevNode);

	//     }
	// }
}

