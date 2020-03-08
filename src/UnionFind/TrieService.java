package UnionFind;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TrieService {

	private TrieNode root = null;

	public TrieService() {
		root = new TrieNode();
	}

	public TrieNode getRoot() {
		// Return root of trie root, and
		// lintcode will print the tree struct.
		return root;
	}

	// @param word a string
	// @param frequency an integer
	public void insert(String word, int frequency) {
		Comparator<Integer> compare = new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		};

		// Write your cod here
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!cur.children.containsKey(c)) {
				cur.children.put(c, new TrieNode());
			}
			cur = cur.children.get(c);
			cur.top10.add(frequency);

			List<Integer> frequencyList = cur.top10;
			Collections.sort(frequencyList, compare);
			while (frequencyList.size() > 10) {
				frequencyList.remove(frequencyList.size() - 1);
			}
			cur.top10 = frequencyList;
		}
	}

	private class TrieNode {
		public List<Integer> top10;
		public Map<Character, TrieNode> children;
	}
//	  Definition of TrieNode:
//	public class TrieNode {
//		public NavigableMap<Character, TrieNode> children;
//		public List<Integer> top10;
//		public TrieNode() {
//		  children = new TreeMap<Character, TrieNode>();
//		  top10 = new ArrayList<Integer>();
//		}
//	}
}
