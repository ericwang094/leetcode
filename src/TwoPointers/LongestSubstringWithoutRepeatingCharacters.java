package TwoPointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

	/**
	 * @param s: a string
	 * @return: an integer
	 */
	public int lengthOfLongestSubstring2(String s) {
		int result = Integer.MIN_VALUE;
		if (s == null || s.length() == 0) {
			return 0;
		}

		Set<Character> set = new HashSet<>();

		int left = 0;
		char[] charArray = s.toCharArray();
		for (int right = 0; right < charArray.length; right++) {
			char curr = charArray[right];
			if (!set.contains(curr)) {
				set.add(curr);
			} else {
				while (set.contains(curr)) {
					set.remove(charArray[left]);
					left++;
				}
				set.add(curr);
			}
			result = Math.max(result, right - left + 1);
		}

		return result;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		test.lengthOfLongestSubstring2("an++--viaj");

	}
}
