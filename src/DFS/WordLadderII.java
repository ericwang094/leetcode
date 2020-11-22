package DFS;

import java.util.*;

public class WordLadderII {
//    public List<List<String>> findLadders(String start, String end,
//                                          Set<String> dict) {
//        List<List<String>> ladders = new ArrayList<List<String>>();
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        Map<String, Integer> distance = new HashMap<String, Integer>();
//
//        dict.add(start);
//        dict.add(end);
//
//        bfs(map, distance, end, start, dict);
//
//        List<String> path = new ArrayList<String>();
//
//        dfs(ladders, path, start, end, distance, map);
//
//        return ladders;
//    }
//
//    void dfs(List<List<String>> ladders, List<String> path, String crt,
//             String end, Map<String, Integer> distance,
//             Map<String, List<String>> map) {
//        path.add(crt);
//        if (crt.equals(end)) {
//            ladders.add(new ArrayList<String>(path));
//        } else {
//            for (String next : map.get(crt)) {
//                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
//                    dfs(ladders, path, next, end, distance, map);
//                }
//            }
//        }
//        path.remove(path.size() - 1);
//    }
//
//    void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
//             String start, String end, Set<String> dict) {
//        Queue<String> q = new LinkedList<String>();
//        q.offer(start);
//        distance.put(start, 0);
//        for (String s : dict) {
//            map.put(s, new ArrayList<String>());
//        }
//
//        while (!q.isEmpty()) {
//            String crt = q.poll();
//
//            List<String> nextList = expand(crt, dict);
//            for (String next : nextList) {
//                map.get(crt).add(next);
//                if (!distance.containsKey(next)) {
//                    distance.put(next, distance.get(crt) + 1);
//                    q.offer(next);
//                }
//            }
//        }
//    }
//
//    List<String> expand(String crt, Set<String> dict) {
//        List<String> expansion = new ArrayList<String>();
//
//        for (int i = 0; i < crt.length(); i++) {
//            for (char ch = 'a'; ch <= 'z'; ch++) {
//                if (ch != crt.charAt(i)) {
//                    String expanded = crt.substring(0, i) + ch
//                            + crt.substring(i + 1);
//                    if (dict.contains(expanded)) {
//                        expansion.add(expanded);
//                    }
//                }
//            }
//        }
//
//        return expansion;
//    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> distance = new HashMap<>();

        dict.add(start);
        dict.add(end);
        Set<String> allPath = bfs(start, end, dict, distance);

        return result;
    }

    private Set<String> bfs (String start, String end, Set<String> dict, Map<String, Integer> distance) {
        Set<String> result = new HashSet<>();

        if (start.equals(end)) {
            return result;
        }

        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentStr = queue.poll();
                result.add(currentStr);
                if (distance.containsKey(currentStr)) {
                    continue;
                }
                distance.put(currentStr, steps);
                List<String> nextWords = nextWords(currentStr, dict);
                for (String word : nextWords) {
                    queue.add(word);
                    result.add(word);
                }
            }
            steps++;
        }
        return result;
    }

    private List<String> nextWords(String str, Set<String> dict) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char[] charArr = str.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (charArr[i] == c) {
                    continue;
                }

                charArr[i] = c;
                String newWord = new String(charArr);
                if (dict.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
	    WordLadderII wp = new WordLadderII();
        Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");

        wp.findLadders("hit", "cog", set);
    }
}
