package leetcode.BFS;

import java.util.*;

public class L0127_WordLadder {
	/*
	 * @param start: a string
	 * @param end: a string
	 * @param dict: a set of string
	 * @return: An integer
	 */
	public int ladderLength(String start, String end, Set<String> dict) {
		// write your code here
		if (dict == null || dict.size() == 0) {
			return 0;
		}

		if (start == end) {
			return 1;
		}

		dict.add(start);
		dict.add(end);

		HashSet<String> hash = new HashSet<String>();
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		hash.add(start);
		int length = 1;
		while(!queue.isEmpty()) {
			length++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currentWord = queue.poll();
				List<String> availableWords = getNextWords(currentWord, dict);
				for (String availableWord : availableWords) {
					if (hash.contains(availableWord)) {
						continue;
					}

					if (availableWord.equals(end)) {
						return length;
					}

					hash.add(availableWord);
					queue.add(availableWord);
				}
			}
		}
		return 0;
	}

	private List<String> getNextWords(String currentWord, Set<String> dict) {
		List<String> result = new ArrayList<>();
		char[] wordArray = currentWord.toCharArray();
		for (int i = 0; i < wordArray.length; i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				char[] newWordArray = wordArray.clone();

				if (wordArray[i] == c) {
					continue;
				}
				newWordArray[i] = c;
				String newWord = new String(newWordArray);
				if (dict.contains(newWord)) {
					result.add(newWord);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		L0127_WordLadder test = new L0127_WordLadder();
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		test.ladderLength("hit", "cog", dict);
	}
}
