package LintCodeIntroduction;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {
	/**
	 * @param s: input string
	 * @return: the longest palindromic substring
	 */
	public String longestPalindrome(String s) {
		// write your code here
		if (s == null) {
			return null;
		}

		String maxString = "";
		for (int i = 0; i < s.length(); i++) {
			String s1 = expandPalindrome(s, i, i);
			String s2 = expandPalindrome(s, i, i + 1);
			if (Math.max(s1.length(), s2.length()) > maxString.length()) {
				if (s1.length() > maxString.length()) {
					maxString = s1;
				}

				if (s2.length() > maxString.length()) {
					maxString = s2;
				}
			}
		}

		return maxString;
	}

	private String expandPalindrome(String s, int i, int j) {
		String result = "";
		if (i < 0 || j > s.length() - 1) {
			return result;
		}

		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) != s.charAt(j)) {
				break;
			}
			i--;
			j++;
		}
		i++;
		j--;
		result = s.substring(i, j + 1);
		return result;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		String input = "bb";

		lps.longestPalindrome(input);
	}
}
