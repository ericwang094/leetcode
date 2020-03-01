package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	/**
	 * @param source : A string
	 * @param target: A string
	 * @return: A string denote the minimum window, return "" if there is no such a string
	 */
	public String minWindow(String source , String target) {
		if (source == null || target == null || source.equals("")) {
			return "";
		}

		char[] s = source.toCharArray();
		char[] t = source.toCharArray();

		Map<Character, Integer> map = new HashMap<>();
		int uniqueCharacter = 0;
		for (char c : t) {
			int num = map.getOrDefault(c, 0);
			if (num == 0) {
				uniqueCharacter++;
			}
			map.put(c, num + 1);
		}

		int left = 0;
		int right = 0;

		int numOfOccurance = 0;

		for (; right < s.length; right++) {
			while (left < right && map.get()) {

			}
		}
	}
}
