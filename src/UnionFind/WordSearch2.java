package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearch2 {
	public int[] dx = {1, 0, -1, 0};   //搜索方向
	public int[] dy = {0, 1, 0, -1};
	/**
	 * @param board: A list of lists of character
	 * @param words: A list of string
	 * @return: A list of string
	 */
	public List<String> wordSearchII(char[][] board, List<String> words) {
		// write your code here
		List<String> results = new ArrayList<>();
		TrieTree tree = new TrieTree(new TrieNode());
		for (String s : words) {
			tree.insert(s);
		}

		for (int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				search(board, i, j, tree.root, results);
			}
		}

		return results;
	}

	public void search(char[][] board, int x, int y, TrieNode root, List<String> results) {
		if (!root.children.containsKey(board[x][y])) {
			return;
		}

		TrieNode child = root.children.get(board[x][y]);

		if (child.word != null) {
			if (!results.contains(child.word)) {
				results.add(child.word);
			}
		}

		char tmp = board[x][y];

		board[x][y] = 0;
		for (int i = 0; i < 4; i++) {      //向四个方向dfs搜索
			if (!isValid(board, x + dx[i], y + dy[i])) {
				continue;
			}
			search(board, x + dx[i], y + dy[i], child, results);
		}

		board[x][y] = tmp;  // revert the mark
	}

	private boolean isValid(char[][] board, int x, int y) {     //检测搜索位置合法
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
			return false;
		}

		return board[x][y] != 0;
	}

	private class TrieNode {
		String word;
		HashMap<Character, TrieNode> children;

		public TrieNode() {
			word = null;
			children = new HashMap<>();
		}
	}
	private class TrieTree {
		TrieNode root;

		public TrieTree(TrieNode trieNode) {
			root = trieNode;
		}

		public void insert(String word) {
			TrieNode node = root;
			char[] charArray = word.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (!node.children.containsKey(charArray[i])) {
					node.children.put(charArray[i], new TrieNode());
				}
				node = node.children.get(charArray[i]);
			}
			node.word = word;
		}
	}
}
