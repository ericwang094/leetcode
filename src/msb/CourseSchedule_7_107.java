package msb;

import java.util.*;

// https://leetcode.com/problems/course-schedule/?envType=problem-list-v2&envId=topological-sort
public class CourseSchedule_7_107 {
    private class Node {
        public int val;
        public List<Node> nexts;
        public int in;

        public Node(int val) {
            this.val = 0;
            this.nexts = new ArrayList<>();
            this.in = 0;
        }
    }

    private class Graph {
        public HashMap<Integer, Node> map;
        public Graph() {
            this.map = new HashMap<>();
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();

        for (int i = 0; i < prerequisites.length; i++) {
            int main = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            if (!graph.map.containsKey(main)) {
                graph.map.put(main, new Node(main));
            }

            if (!graph.map.containsKey(prerequisite)) {
                graph.map.put(prerequisite, new Node(prerequisite));
            }

            Node mainNode = graph.map.get(main);
            Node prerequisiteNode = graph.map.get(prerequisite);

            mainNode.in++;
            prerequisiteNode.nexts.add(mainNode);
        }

        Queue<Node> zeroInQueue = new LinkedList<>();
        HashMap<Node, Integer> inMap = new HashMap<>();

        for (Node node : graph.map.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node node : cur.nexts) {
                inMap.put(node, inMap.get(node) - 1);
                if (inMap.get(node) == 0) {
                    zeroInQueue.add(node);
                }
            }
        }

        return result.size() == graph.map.size();
    }
}
