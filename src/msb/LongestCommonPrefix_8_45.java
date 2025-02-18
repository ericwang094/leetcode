package msb;

import java.util.Arrays;

//https://leetcode.com/problems/longest-common-prefix/description/?envType=problem-list-v2&envId=trie
public class LongestCommonPrefix_8_45 {
    private class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    private class TrieTree{
        TrieNode root;
        public TrieTree() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }

            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for(int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }

                node.nexts[index].pass++;
                node = node.nexts[index];
            }

            node.end++;
        }

        public int searchPrefix(String pre) {
            if (pre == null) {
                return 0;
            }

            char[] chars = pre.toCharArray();
            TrieNode node = root;
            int index = 0;

            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }

                node = node.nexts[index];
            }
            return node.pass;
        }
    }



    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        TrieTree tree = new TrieTree();
        String shortestStr = strs[0];

        for (String str : strs) {
            tree.insert(str);
            if (str.length() < shortestStr.length()) {
                shortestStr = str;
            }
        }

        for (int i = shortestStr.length(); i >= 0; i--) {
            String prefix = shortestStr.substring(0, i);
            int result = tree.searchPrefix(prefix);
            if (result == strs.length) {
                return prefix;
            }
        }
        return "";
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String shortestString = strs[0];
        for (String str: strs) {
            shortestString = shortestString.length() <= str.length() ? shortestString: str;
        }

        String result = "";

        int index = 0;

        while (index < shortestString.length()) {
            char commonChar = shortestString.charAt(index);
            for (String str: strs) {
                if (str.charAt(index) != commonChar) {
                    return result;
                }
            }
            result = shortestString.substring(0, index + 1);
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix_8_45 lcp = new LongestCommonPrefix_8_45();
        String[] strs = {"flower","flow","flight"};

//        String res = lcp.longestCommonPrefix(strs);
        String res = lcp.longestCommonPrefix2(strs);
        System.out.println(res);
    }
}
