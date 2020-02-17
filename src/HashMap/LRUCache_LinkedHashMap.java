package HashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_LinkedHashMap {
	private Map<Integer, Integer> map;
	private int capacity;

	public LRUCache_LinkedHashMap(int capacity) {
		this.capacity = capacity;
		this.map = new LinkedHashMap<Integer, Integer>();
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		int val = map.remove(key);
		map.put(key, val);

		return val;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			map.remove(key);
			map.put(key, value);
			return;
		}

		map.put(key ,value);
		if (map.size() > this.capacity) {
			map.remove(map.entrySet().iterator().next().getKey());
		}
	}
}
