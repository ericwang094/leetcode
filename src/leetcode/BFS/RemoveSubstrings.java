package leetcode.BFS;

import java.util.*;

public class RemoveSubstrings {
	/*
	 * @param s: a string
	 * @param dict: a set of n substrings
	 * @return: the minimum length
	 */
	public int minLength(String s, Set<String> dict) {
		if (s == null || s.equals("")) {
			return 0;
		}

		int result = s.length();
		Queue<String> queue = new LinkedList<>();
		Set<String> set = new HashSet<>();
		set.add(s);
		queue.add(s);

		while (!queue.isEmpty()) {
			String currentString = queue.poll();
			for (String subString : dict) {
				int index = currentString.indexOf(subString);
				while (index != -1) {
					String newString = currentString.substring(0, index)
							+ currentString.substring(index + subString.length());
					if (!set.contains(newString)) {
						if (newString.length() < result) {
							result = newString.length();
						}
						set.add(newString);
						queue.add(newString);
					}

					index = currentString.indexOf(subString, index + 1);
				}
			}
		}

		return result;

	}


	public static void main(String[] args) {
		RemoveSubstrings rs = new RemoveSubstrings();
//		Set<String> input = new HashSet<>(Arrays.asList("ab", "cd"));
		Set<String> input = new HashSet<>(Arrays.asList("ab","abcd"));
		System.out.println(rs.minLength("abcabd", input));
	}
}
