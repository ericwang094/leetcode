package LintCodeIntroduction;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	/**
	 * @param s: a string which consists of lowercase or uppercase letters
	 * @return: the length of the longest palindromes that can be built
	 */
	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		char[] sArray = s.toCharArray();
		for (char c : sArray) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		boolean oddConsidered = false;
		int length = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			length += entry.getValue() / 2 * 2;
			if (entry.getValue() % 2 != 0 && !oddConsidered) {
				length += 1;
				oddConsidered = true;
			}
		}

		return length;
	}
}
