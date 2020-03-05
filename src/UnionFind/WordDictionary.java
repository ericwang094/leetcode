package UnionFind;

public class WordDictionary {
	TrieTree node = new TrieTree();
	/*
	 * @param word: Adds a word into the data structure.
	 * @return: nothing
	 */
	public void addWord(String word) {
		// write your code here
		node.insert(word, 0);
	}

	/*
	 * @param word: A word could contain the dot character '.' to represent any one letter.
	 * @return: if the word is in the data structure.
	 */
	public boolean search(String word) {
		// write your code here
		return find(word, 0, node);
	}

	private boolean find(String word, int index, TrieTree node) {
		if (index == word.length()) {
			return node.hasWord;
		}

		char c = word.charAt(index);
		if (c == '.') {
			for (int i = 0; i < 26; i++){
				if (node.children[i] != null) {
					if (find(word, index + 1, node.children[i])) {
						return true;
					}
				}
			}
			return false;
		} else if (node.children[c - 'a'] != null) {
			return find(word, index + 1, node.children[c - 'a']);
		} else {
			return false;
		}
	}

	private class TrieTree {
		TrieTree[] children;
		boolean hasWord;

		public TrieTree() {
			this.children = new TrieTree[26];
			this.hasWord = false;
		}

		public void insert(String s, int index) {
			if (s.length() == index) {
				this.hasWord = true;
				return;
			}

			int pos = s.charAt(index) - 'a';
			if (children[pos] == null) {
				children[pos] = new TrieTree();
			}
			children[pos].insert(s, index + 1);
		}

		public TrieTree find(String s, int index) {
			if (s.length() == index) {
				return this;
			}

			int pos = s.charAt(index) - 'a';
			if (children[pos] == null) {
				return null;
			}

			return children[pos].find(s, index + 1);
		}
	}
}
