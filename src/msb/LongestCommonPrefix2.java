package msb;

import java.util.Arrays;
import java.util.HashMap;

public class LongestCommonPrefix2 {
        private class TrieNode {
        public int path;
        public int end;
        public HashMap<Character, TrieNode> nexts;

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            this.nexts = new HashMap<>();
        }
    }

    private class TrieTree {
        TrieNode root;
        public TrieTree() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }

            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.path++;

            for (int i = 0; i < chs.length; i++) {
                if (!node.nexts.containsKey(chs[i])) {
                    node.nexts.put(chs[i], new TrieNode());
                }
                TrieNode nodePath = node.nexts.get(chs[i]);
                nodePath.path++;
                node = nodePath;
            }

            node.end++;
        }

        public int searchPrefix(String pre) {
            if (pre == null) {
                return 0;
            }

            char[] chs = pre.toCharArray();
            TrieNode node = root;

            for (int i = 0; i < chs.length; i++) {
                if (!node.nexts.containsKey(chs[i])) {
                    return 0;
                }

                node = node.nexts.get(chs[i]);

            }

            return node.path;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        TrieTree trieTree = new TrieTree();
        for (String str: strs) {
            trieTree.insert(str);
        }

        Arrays.sort(strs, (String a, String b) -> a.length() - b.length());
        String shortestString = strs[0];
        for (int i = shortestString.length(); i >= 0; i--) {
            String pre = shortestString.substring(0, i);
            int prefixPass = trieTree.searchPrefix(pre);

            if (prefixPass == strs.length) {
                return pre;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        LongestCommonPrefix2 lcp = new LongestCommonPrefix2();
//        String[] strs = {"cir","car"};
        String[] strs = {"flower","flow","flight"};
//        String res = lcp.longestCommonPrefix(strs);
        String res = lcp.longestCommonPrefix(strs);
        System.out.println(res);
    }
}
