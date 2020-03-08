package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2_v2 {
	public class Solution {
		TrieNode root;
		int[] directionX = {0, -1, 0, 1};
		int[] directionY = {-1, 0, 1, 0};
		/**
		 * @param board: A list of lists of character
		 * @param words: A list of string
		 * @return: A list of string
		 */
		public List<String> wordSearchII(char[][] board, List<String> words) {
			List<String> result = new ArrayList<>();
			if (board == null || board.length == 0 || board[0].length == 0 || words.size() == 0) {
				return result;
			}

			// write your code here
			root = new TrieNode();
			for(String word : words) {
				root.insert(word);
			}
			boolean[][] visited = new boolean[board.length][board[0].length];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					visited[i][j] = true;
					dfs(i, j, board, visited, root, result);
					visited[i][j] = false;
				}
			}

			return result;
		}

		private void dfs(int i, int j, char[][] board, boolean[][] visited, TrieNode node, List<String> result) {
			char currentChar = board[i][j];
			TrieNode children = node.children[currentChar - 'a'];
			if (children == null) {
				return;
			}
			if (children.hasWord) {
				String word = children.word;
				if (!result.contains(word)) {
					result.add(word);
				}
			}


			for (int k = 0; k < 4; k++) {
				int newX = directionX[k] + i;
				int newY = directionY[k] + j;
				if (!valid(newX, newY, visited)) {
					continue;
				}
				visited[newX][newY] = true;
				dfs(newX, newY, board, visited, children, result);
				visited[newX][newY] = false;
			}


		}

		private boolean valid(int i, int j, boolean[][] visited) {
			if (i < 0 || i >= visited.length) {
				return false;
			}

			if (j < 0 || j >= visited[0].length) {
				return false;
			}

			if (visited[i][j]) {
				return false;
			}

			return true;
		}

		private class TrieNode {
			TrieNode[] children;
			boolean hasWord;
			String word;

			public TrieNode() {
				children = new TrieNode[26];
				hasWord = false;
				word = null;
			}

			public void insert(String word) {
				trieNodeInsert(word, 0);
			}

			private void trieNodeInsert(String word, int index) {
				if (index == word.length()) {
					hasWord = true;
					this.word = word;
					return;
				}

				int pos = word.charAt(index) - 'a';
				if (children[pos] == null) {
					children[pos] = new TrieNode();
				}
				children[pos].trieNodeInsert(word, index + 1);
			}
		}
	}
}
