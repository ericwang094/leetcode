package leetcode.BFS;

import java.util.*;

public class LintCodeAlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = constructGraph(words);
        return topologicalSorting(graph);
    }

    private Map<Character, Set<Character>> constructGraph(String[] words) {
        // create node
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!map.containsKey(word.charAt(i))) {
                    map.put(word.charAt(i), new HashSet<>());
                }
            }
        }

        // create edge
        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            while (index < words[i].length() && index < words[i + 1].length()) {
                if (words[i].charAt(index) != words[i + 1].charAt(index)) {
                    map.get(words[i].charAt(index)).add(words[i + 1].charAt(index));
                    break;
                }
                index++;
            }
        }

        return map;
    }

    private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> degreeMap = new HashMap<>();
        for (Character c : graph.keySet()) {
            degreeMap.put(c, 0);
        }

        for (Character c : graph.keySet()) {
            for (Character v : graph.get(c)) {
                degreeMap.put(v, degreeMap.get(v) + 1);
            }
        }

        return degreeMap;
    }

    private String topologicalSorting(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = getIndegree(graph);

        Queue<Character> queue = new PriorityQueue<>();

        for (Character u : indegree.keySet()) {
            if (indegree.get(u) == 0) {
                queue.offer(u);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character head = queue.poll();
            sb.append(head);
            for (Character neighbor : graph.get(head)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (sb.length() != indegree.size()) {
            return "";
        }
        return sb.toString();
    }
}
