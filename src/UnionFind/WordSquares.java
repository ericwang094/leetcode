package UnionFind;

import java.util.*;

public class WordSquares {
	/*
	 * @param words: a set of words without duplicates
	 * @return: all word squares
	 */
	void initPrefix(String[] words, Map<String, List<String>> hash) {
		for (String item : words) {
			hash.putIfAbsent("", new ArrayList<>());
			hash.get("").add(item);

			String prefix = "";
			for (char c : item.toCharArray()) {
				prefix += c;
				hash.putIfAbsent(prefix, new ArrayList<>());
				hash.get(prefix).add(item);
			}
		}
	}

	boolean checkPrefix(int l, String nextWord, int wordLen, Map<String, List<String>> hash, List<String> squares) {
		for (int j = l + 1; j < wordLen; j++) {
			String prefix = "";
			for (int k = 0; k < l; k++) {
				prefix += squares.get(k).charAt(j);
			}
			prefix += nextWord.charAt(j);
			if (!hash.containsKey(prefix)) {
				return false;
			}
		}
		return true;
	}

	void dfs(int l, int wordLen, Map<String, List<String>> hash, List<String> squares, List<List<String>> ans) {
		if (l == wordLen) {
			ans.add(new ArrayList<>(squares));
			return;
		}
		String prefix = "";
		for (int i = 0; i < l; i++) {
			prefix += squares.get(i).charAt(l);
		}

		for (String item : hash.get(prefix)) {
			if (!checkPrefix(l, item, wordLen, hash, squares)) {
				continue;
			}
			squares.add(item);
			dfs(l + 1, wordLen, hash, squares, ans);
			squares.remove(squares.size() - 1);
		}
	}

	public List<List<String>> wordSquares(String[] words) {
		// Write your code here
		List<List<String>> ans = new ArrayList<>();
		if (words.length == 0) {
			return ans;
		}
		Map<String, List<String>> hash = new HashMap<>();
		initPrefix(words, hash);

		List<String> squares = new ArrayList<>();
		dfs(0, words[0].length(), hash, squares, ans);
		return ans;
	}

	public static void main(String[] args) {
		WordSquares ws = new WordSquares();
		String[] input = {"abat","baba","atan","atal"};
		ws.wordSquares(input);
	}
}
