package TwoPointers;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * @param s: a string
	 * @return: an integer
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<>();

		char[] charArray = s.toCharArray();
		int length = 0;
		int j = 0;
		for (int i = 0; i < charArray.length; i++) {
			while (j < charArray.length && !set.contains(charArray[j])) {
				set.add(charArray[j]);
				length = Math.max(length, j - i + 1);
				j++;
			}
			set.remove(charArray[i]);
		}

		return length;
	}
}
