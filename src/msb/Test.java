package msb;

import msb.CommonDataStructure.ListNode;

import java.util.*;

public class Test {
    private class Edge {
        public int from;
        public int to;
        public int weight;

        public Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }



    private Set<Edge> constructGraph(int[][] connections) {
        Set<Edge> edges = new HashSet<>();
        for (int[] connection: connections) {
            int from = connection[0];
            int to = connection[1];
            int weight = connection[2];

            Edge edge1 = new Edge(from, to, weight);

            edges.add(edge1);
        }

        return edges;
    }

    public class MySet {
        public HashMap<Integer, HashSet<Edge>> setMap = new HashMap<>();
        public MySet(Set<Edge> edges) {
            for (Edge edge: edges) {
                HashSet<Edge> set = new HashSet<>();
                set.add(edge);
                setMap.put(edge.from, set);
            }
        }

        public boolean isSameSet(Integer nodeA, Integer nodeB) {
            return setMap.get(nodeA) == setMap.get(nodeB);
        }

        public void union(Integer nodeA, Integer nodeB) {
            HashSet<Edge> nodeASet = setMap.get(nodeA);
            HashSet<Edge> nodeBSet = setMap.get(nodeB);

            nodeASet.addAll(nodeBSet);
            for (Edge edge : nodeASet) {
                setMap.put(edge.from, nodeASet);
            }

//            for (Node toNode: nodeBSet) {
//                nodeASet.add(toNode);
//                setMap.put(toNode, nodeASet);
//            }
        }
    }

    public int minimumCost(int n, int[][] connections) {
        Set<Edge> graph = constructGraph(connections);

        MySet mySet = new MySet(graph);

        PriorityQueue<Edge> pQueue = new PriorityQueue<>((Edge o1, Edge o2) -> o1.weight - o2.weight);

        pQueue.addAll(graph);

        int cost = 0;
        int numEdges = 0;
        while (!pQueue.isEmpty()) {
            Edge edge = pQueue.poll();
            if (!mySet.isSameSet(edge.from, edge.to)) {
                cost += edge.weight;
                numEdges++;
                mySet.union(edge.from, edge.to);
            }
        }
        if (numEdges != n - 1 ) {
            return -1;

        }
        return cost;
    }


    public static void main(String[] args) {
        Test sol = new Test();

//        int[][] test = {{2,1,50459},{3,2,47477},{4,2,52585},{5,3,16477}};
//        int[][] test = {{2,1,50459}};
        int[][] test2 = {{1,2,5},{1,3,6},{2,3,1}};

//        int[][] test = {{2,1,50459}};

        sol.minimumCost(3, test2);

    }
}
