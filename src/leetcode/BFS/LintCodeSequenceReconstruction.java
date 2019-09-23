package leetcode.BFS;

import java.util.*;

public class LintCodeSequenceReconstruction {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        // build graph
        Map<Integer, Set<Integer>> graph = buildGraph(seqs);

        // build degree
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            int nodeDegree = entry.getKey();
            if (!inDegree.containsKey(nodeDegree)) {
                inDegree.put(nodeDegree, 0);
            }

            for (int num : entry.getValue()) {
                int existingDegree = inDegree.getOrDefault(num, 0);
                inDegree.put(num, existingDegree + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        if (queue.size() > 1) {
            return false;
        }

        int[] result = new int[inDegree.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }

            int node = queue.poll();
            result[index] = node;
            for (int edge : graph.get(node)) {
                int newDegree = inDegree.get(edge) - 1;
                inDegree.put(edge, newDegree);
                if (newDegree == 0) {
                    queue.offer(edge);
                }
            }
            index++;
        }
        return Arrays.equals(result, org);
    }

    private Map<Integer, Set<Integer>> buildGraph (int[][] seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        // build node
        for (int[] seq : seqs) {
            for (int num : seq) {
                if (!graph.containsKey(num)) {
                    graph.put(num, new HashSet<Integer>());
                }
            }
        }

        // build edge
        for (int[] seg : seqs) {
            for (int i = 0; i < seg.length - 1; i++) {
                graph.get(seg[i]).add(seg[i + 1]);
            }
        }
        return graph;
    }

    public static void main (String[] args) {
        LintCodeSequenceReconstruction test = new LintCodeSequenceReconstruction();
        int[] orgs = {1, 2, 3};
        int[][] seqs = {
                {1, 2},
                {1, 3},
                {2, 3},
        };
        boolean result = test.sequenceReconstruction(orgs, seqs);
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
