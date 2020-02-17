package LeetcodeGeneral;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_linkedHashMap_146 {
	class LRUCache {
		Map<Integer, Integer> map;
		int capacity;
		public LRUCache(int capacity) {
			this.map = new LinkedHashMap<>();
			this.capacity = capacity;
		}

		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}

			int val = map.get(key);
			map.remove(key);
			map.put(key, val);
			return val;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				map.remove(key);
			} else {
				if (map.size() == this.capacity) {
					map.remove(map.entrySet().iterator().next().getKey());
				}
			}
			map.put(key, value);
		}
	}

}
