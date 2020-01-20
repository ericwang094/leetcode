package HashMap;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private int capacity, size;
	private ListNode dummy, tail;
	private Map<Integer, ListNode> keyToPrev;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.keyToPrev = new HashMap<Integer, ListNode>();
		this.dummy = new ListNode(0, 0);
		this.tail = this.dummy;
	}

	public int get(int key) {
		if (!keyToPrev.containsKey(key)) {
			return -1;
		}

		moveToTail(key);
		return tail.val;
	}

	private void moveToTail(int key) {
		ListNode prev = keyToPrev.get(key);
		ListNode curt = prev.next;

		if (curt == tail) {
			return;
		}

		prev.next = prev.next.next;
		tail.next = curt;

		if (prev.next != null) {
			keyToPrev.put(prev.next.key, prev);
		}
		keyToPrev.put(curt.key, tail);
		tail = curt;
	}

	public void set(int key, int value) {
		if (get(key) != -1) {
			ListNode prev = keyToPrev.get(key);
			prev.next.val = value;
			return;
		}

		if (size < capacity) {
			size++;
			ListNode curt = new ListNode(key, value);
			tail.next = curt;
			keyToPrev.put(key, tail);

			tail = curt;
			return;
		}

		ListNode first = dummy.next;
		keyToPrev.remove(first.key);

		first.key = key;
		first.val = value;
		keyToPrev.put(key, dummy);

		moveToTail(key);
	}
}
