package HashMap;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
	private int min;
	private int capacity;
	private Map<Integer, Integer> keyToVal;
	private Map<Integer, Integer> keyToCount;
	private Map<Integer, LinkedHashSet<Integer>> countToLRUKeys;
	/*
	 * @param capacity: An integer
	 */public LFUCache(int capacity) {
		// do intialization if necessary
		this.min = -1;
		this.capacity = capacity;
		this.keyToVal = new HashMap<>();
		this.keyToCount = new HashMap<>();
		this.countToLRUKeys = new HashMap<>();
	}

	/*
	 * @param key: An integer
	 * @param value: An integer
	 * @return: nothing
	 */
	public void set(int key, int value) {
		// write your code here
		if (capacity < 0) {
			return;
		}

		if (keyToVal.containsKey(key)) {
			keyToVal.put(key, value);
			get(key);
		} else {
			if (keyToVal.size() == capacity) {
				int minKey = countToLRUKeys.get(min).iterator().next();
				countToLRUKeys.get(min).remove(minKey);
			}

			min = 1;
			putCount(key, min);
			keyToVal.put(key, value);
		}
	}

	/*
	 * @param key: An integer
	 * @return: An integer
	 */
	public int get(int key) {
		// write your code here
		if (!keyToVal.containsKey(key)) {
			return -1;
		}

		int count = keyToCount.get(key);
		countToLRUKeys.get(count).remove(key);
		if (count == min && countToLRUKeys.get(count).size() == 0) {
			min++;
		}
		putCount(key, count + 1);
		return keyToVal.get(key);

	}

	private void putCount(int key, int count) {
		keyToCount.put(key, count);
		countToLRUKeys.putIfAbsent(count, new LinkedHashSet<>());
		countToLRUKeys.get(count).add(key);
	}
}
