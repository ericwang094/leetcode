package TwoPointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringMostKDistinctCharacters {
	/**
	 * @param s: A string
	 * @param k: An integer
	 * @return: An integer
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int longestLength = 0;
		char[] charArray = s.toCharArray();

		Map<Character, Integer> map = new HashMap<>();
		int left = 0;

		for (int right = 0; right < charArray.length; right++) {

			map.put(charArray[right], map.getOrDefault(charArray[right], 0) + 1);
			while (left <= right && map.size() > k) {

				int count = map.get(charArray[left]);
				count--;
				if (count == 0) {
					map.remove(charArray[left]);
				} else {
					map.put(charArray[left], count);
				}
				left++;
			}
			longestLength = Math.max(longestLength, right - left + 1);
		}

		return longestLength;
	}
}
