package leetcode.BFS;

import java.util.*;

public class L0127_WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {

        dict.add(start);
        dict.add(end);

        HashSet<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        set.add(start);

        int count = 1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                ArrayList<String> nextWords = getNextWords(currentWord, dict);
                for (String word : nextWords) {
                    if (word.equals(end)) {
                        return count;
                    }
                    if (set.contains(word)) {
                        continue;
                    }
                    queue.offer(word);
                    set.add(word);
                }
            }

        }
        return 0;
    }

    private ArrayList<String> getNextWords (String word, Set<String> set) {
        ArrayList<String> result = new ArrayList<String>();
        for (Character c = 'a'; c < 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.indexOf(i) == c) {
                    continue;
                }
                char[] cArray = word.toCharArray();
                cArray[i] = c;
                String newWord = new String(cArray);
                if (set.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }
        return result;
    }

}
