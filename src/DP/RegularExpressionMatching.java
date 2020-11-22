package DP;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		// write your code here
		if (s == null || p == null) {
			return false;
		}

		boolean[][] visited = new boolean[s.length()][p.length()];
		boolean[][] memo = new boolean[s.length()][p.length()];

		return matchHelper(s, 0, p, 0, visited, memo);
	}

	private boolean matchHelper(String s, int i, String p, int j, boolean[][] visited, boolean[][] memo) {
		if (j == p.length()) {
			return s.length() == i;
		}

		if (i == s.length()) {
			return emptyHelper(p, j);
		}

		if (visited[i][j]) {
			return memo[i][j];
		}

		char currS = s.charAt(i);
		char currP = p.charAt(j);
		boolean match = false;
		if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
			match = matchHelper(s, i, p, j + 2, visited, memo) ||
					((currP == '.' || currP == currS) && matchHelper(s, i + 1, p, j, visited, memo));
		} else {
			match = (currS == currP || currP == '.') && matchHelper(s, i + 1, p, j + 1, visited, memo);
		}

		visited[i][j] = true;
		memo[i][j] = match;
		return match;
	}

	private boolean emptyHelper(String p, int index) {
		if (index == p.length()) {
			return true;
		}

		String subString = p.substring(index);
		if (subString.length() % 2 != 0){
			return false;
		}

		while (subString.length() > 0) {
			char second = subString.charAt(1);
			if (second != '*') {
				return false;
			}
			subString = subString.substring(2);
		}

		return true;
	}

	public static void main(String[] args) {
		RegularExpressionMatching dp = new RegularExpressionMatching();
//		dp.isMatch("aab", "c*a*b");
		dp.isMatch("aab", ".*");
	}
}
