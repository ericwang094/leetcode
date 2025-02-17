package msb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ConnectingCitiesWithMinimumCostKruskal {
     private class Node {
        public int val;
        public HashSet<Node> nexts;
        public HashSet<Edge> edges;

        public Node (int val) {
            this.val = val;
            this.nexts = new HashSet<>();
            this.edges = new HashSet<>();
        }
    }

    private class Edge {
        public Node fromNode;
        public Node toNode;
        public int weight;

        public Edge (Node fromNode, Node toNode, int weight) {
            this.fromNode = fromNode;
            this.toNode = toNode;
            this.weight = weight;
        }
    }

    private class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph () {
            this.nodes = new HashMap<>();
            this.edges = new HashSet<>();
        }
    }

    private Graph constructGraph(int[][] connections) {
        Graph graph = new Graph();
        for (int[] connection: connections) {
            int from = connection[0];
            int to = connection[1];
            int weight = connection[2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }

            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);

            fromNode.nexts.add(toNode);
            toNode.nexts.add(fromNode);

            Edge edge1 = new Edge(fromNode, toNode, weight);
            Edge edge2 = new Edge(toNode, fromNode, weight);

            fromNode.edges.add(edge1);
            toNode.edges.add(edge2);

            graph.edges.add(edge1);
            graph.edges.add(edge2);
        }

        return graph;
    }

    public class MySet {
        public HashMap<Node, HashSet<Node>> setMap = new HashMap<>();
        public MySet(Set<Node> nodes) {
            for (Node node: nodes) {
                HashSet<Node> set = new HashSet<>();
                set.add(node);
                setMap.put(node, set);
            }
        }

        public boolean isSameSet(Node nodeA, Node nodeB) {
            return setMap.get(nodeA) == setMap.get(nodeB);
        }

        public void union(Node nodeA, Node nodeB) {
            HashSet<Node> nodeASet = setMap.get(nodeA);
            HashSet<Node> nodeBSet = setMap.get(nodeB);

            nodeASet.addAll(nodeBSet);
            for (Node n : nodeASet) {
                setMap.put(n, nodeASet);
            }

//            for (Node toNode: nodeBSet) {
//                nodeASet.add(toNode);
//                setMap.put(toNode, nodeASet);
//            }
        }
    }

    public int minimumCost(int n, int[][] connections) {
        Graph graph = constructGraph(connections);

        MySet mySet = new MySet(new HashSet<>(graph.nodes.values()));

        PriorityQueue<Edge> pQueue = new PriorityQueue<>((Edge o1, Edge o2) -> o1.weight - o2.weight);

        pQueue.addAll(graph.edges);

        int cost = 0;
        int numEdges = 0;
        while (!pQueue.isEmpty()) {
            Edge edge = pQueue.poll();
            if (!mySet.isSameSet(edge.fromNode, edge.toNode)) {
                cost += edge.weight;
                numEdges++;
                mySet.union(edge.fromNode, edge.toNode);
            }
        }
        System.out.println("num edges: " + numEdges + " cost: " + cost);
        if (numEdges != n - 1 ) {
            return -1;

        }
        System.out.println("cost: " + cost);
        return cost;
    }

    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCostKruskal sol = new ConnectingCitiesWithMinimumCostKruskal();

//        int[][] test = {{2,1,50459},{3,2,47477},{4,2,52585},{5,3,16477}};
//        int[][] test = {{2,1,50459}};
        int[][] test2 = {{1,2,5},{1,3,6},{2,3,1}};
        sol.minimumCost(4, test2);

    }
}
