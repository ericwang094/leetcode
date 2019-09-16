package leetcode.BFS;

import java.util.*;

public class L0127_WordLadder {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (beginWord.equals(endWord)) {
//            return 1;
//        }
//        Set<String> dict = new HashSet<>();
//        for (String word : wordList) {
//            dict.add(word);
//        }
//
//        HashSet<String> hash = new HashSet<String>();
//        Queue<String> queue = new LinkedList<String>();
//        queue.offer(beginWord);
//        hash.add(beginWord);
//
//        int length = 1;
//        while (!queue.isEmpty()) {
//            length++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String word = queue.poll();
//                for (String nextWord: getNextWords(word, dict)) {
//                    if (hash.contains(nextWord)) {
//                        continue;
//                    }
//                    if (nextWord.equals(endWord)) {
//                        return length;
//                    }
//                    hash.add(nextWord);
//                    queue.offer(nextWord);
//                }
//            }
//        }
//
//        return 0;
//    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }

        HashSet<String> dict = new HashSet<String>(wordList);

        Queue<String> queue = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        queue.offer(beginWord);
        set.add(endWord);

        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(endWord)) {
                        return length;
                    }

                    set.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }

    private String replace(String word, int i, char c) {
        char[] chars = word.toCharArray();
        chars[i] = c;
        return new String(chars);
    }

    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> newWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.indexOf(i)) {
                    continue;
                }

                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    newWords.add(nextWord);
                }
            }
        }
        return newWords;
    }
}
