package LintCodeIntroduction;

public class RotateStringII {
	/**
	 * @param str: A String
	 * @param left: a left offset
	 * @param right: a right offset
	 * @return: return a rotate string
	 */
	public String RotateString2(String str, int left, int right) {
		// write your code here
		if (str == null || str.length() == 0) {
			return str;
		}
		int realLeft = left % str.length();
		int realRight = right % str.length();

		int offset = realLeft >= realRight ? realLeft - realRight : str.length() - (realRight - realLeft);
		return str.substring(offset) + str.substring(0, offset);
	}
}
