package LintCodeIntroduction;

public class ValidPalindrome {
	/**
	 * @param s: A string
	 * @return: Whether the string is a valid palindrome
	 */
	public boolean isPalindrome(String s) {
		// write your code here
		if (s == null) {
			return false;
		}

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
				start++;
			}

			while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
				end--;
			}

			if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		String input = "1a2";
		vp.isPalindrome(input);
	}
}
