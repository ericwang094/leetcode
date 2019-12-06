package leetcode.BFS;

import java.util.*;

public class LintCodeSequenceReconstruction {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // build nodes
        Map<Integer, Integer> degree = new HashMap<>();
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < seqs.length; i++) {
            for (int j = 0; j < seqs[i].length; j++) {
                degree.put(seqs[i][j], 0);
                edges.put(seqs[i][j], new ArrayList<>());
            }
        }

        // build edges
        for (int i = 0; i < seqs.length; i++) {
            for (int j = 0; j < seqs[i].length; j++) {
                if (j != 0) {
                    degree.put(seqs[i][j], degree.get(seqs[i][j]) + 1);
                }

                if (j != seqs[i].length - 1) {
                    edges.get(seqs[i][j]).add(seqs[i][j + 1]);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> degreeEntry : degree.entrySet()) {
            if (degreeEntry.getValue() == 0) {
                queue.add(degreeEntry.getKey());
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }

            int currentInt = queue.poll();
            if (count > org.length - 1 || org[count] != currentInt) {
                return false;
            }

            List<Integer> sequence = edges.get(currentInt);
            for (int edge : sequence) {
                int newDegree = degree.get(edge) - 1;
                degree.put(edge, newDegree);
                if (newDegree == 0) {
                    queue.add(edge);
                }
            }
            count++;
        }

        return count == org.length;
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
