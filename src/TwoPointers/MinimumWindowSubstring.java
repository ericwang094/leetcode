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
		char[] t = target.toCharArray();

		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> mapSource = new HashMap<>();
		int uniqueCharacter = 0;
		for (char c : t) {
			int num = map.getOrDefault(c, 0);
			if (num == 0) {
				uniqueCharacter++;
			}
			map.put(c, num + 1);
			mapSource.put(c, 0);
		}

		int left = 0;
		int right = 0;

		int numOfOccurance = 0;

		int minLeft = 0;
		int minRight = Integer.MAX_VALUE;

		for (; right < s.length; right++) {
			if (map.containsKey(s[right])) {
				int num = mapSource.get(s[right]);
				mapSource.put(s[right], ++num);
				if (num == map.get(s[right])) {
					numOfOccurance ++;
				}
			}
			while (left <= right && numOfOccurance == uniqueCharacter) {
				if (right - left < minRight - minLeft) {
					minRight = right;
					minLeft = left;
				}
				if (map.containsKey(s[left])) {
					int newNum = mapSource.get(s[left]);
					newNum--;
					mapSource.put(s[left], newNum);
					if (newNum < map.get(s[left])) {
						numOfOccurance--;
					}
				}
				left++;
			}
		}

		if (minRight - minLeft == Integer.MAX_VALUE) {
			return "";
		}
		return source.substring(minLeft, minRight + 1);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		mws.minWindow("adobecodebanc", "abc");

	}
}
