package leetcode.BFS;

import java.util.*;

public class LintCodeAlienDictionary2 {
	public String alienOrder(String[] words) {
		// Write your code here
		if (words == null || words.length == 0) {
			return "";
		}

		Map<Character, Integer> inDegree = new HashMap<>();
		Map<Character, Set<Character>> graph = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				inDegree.putIfAbsent(word.charAt(j), 0);
				graph.putIfAbsent(word.charAt(j), new HashSet<>());
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word = words[i];
			String nextWord = words[i + 1];
			int index = 0;
			while (index < word.length() && index < nextWord.length()) {
				if (word.charAt(index) != nextWord.charAt(index)) {
					if (!graph.get(word.charAt(index)).contains(nextWord.charAt(index))) {
						graph.get(word.charAt(index)).add(nextWord.charAt(index));
						inDegree.put(nextWord.charAt(index), inDegree.get(nextWord.charAt(index)) + 1);
						break;
					}
				}
				index++;
			}
		}

		PriorityQueue<Character> pq = new PriorityQueue<>();
		for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
			if (entry.getValue() == 0) {
				pq.add(entry.getKey());
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {

			char c = pq.poll();
			sb.append(c);
			for (Character next : graph.get(c)) {
				inDegree.put(next, inDegree.get(next) - 1);
				if (inDegree.get(next) == 0) {
					pq.add(next);
				}
			}

		}

		if (sb.length() != inDegree.size()) {
			return "";
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LintCodeAlienDictionary2 t = new LintCodeAlienDictionary2();

		t.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
	}
}
