package msb;

public class TrieNode_8_20 {
    private class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            // nexts[0] == null, no path to a
            // nexts[0] != null, has path to a
            // ...
            // nexts[25] != null, has path to z
            this.nexts = new TrieNode[26];
        }
    }

    private class Trie {
        private TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }

            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }

                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        // search how many times the word has appeared
        public int search(String word) {
            if (word == null) {
                return 0;
            }

            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }

                node = node.nexts[index];
            }

            return node.end;
        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }

            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i< chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }

                node = node.nexts[index];
            }

            return node.pass;
        }

        public void delete(String word) {
            if (word == null) {
                return;
            }

            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass--;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

}
