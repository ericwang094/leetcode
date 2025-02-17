package msb;

import java.util.*;

//https://leetcode.com/problems/connecting-cities-with-minimum-cost/?envType=problem-list-v2&envId=minimum-spanning-tree
// this one is similar
// https://leetcode.com/problems/min-cost-to-connect-all-points/?envType=problem-list-v2&envId=minimum-spanning-tree
// This is not correct answer.
public class ConnectingCitiesWithMinimumCostPrim_7_135 {
    private class Node {
        public int val;
        public int in;
        public int out;
        public List<Node> nexts;
        public List<Edge> edges;

        public Node(int val) {
            this.val = val;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    private class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    private class Graph {
        Map<Integer, Node> nodes;
        Set<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }

    public int minimumCost(int n, int[][] connections) {
        Graph graph = constructGraph(connections);

        Set<Node> visited = new HashSet<>();
        Set<Edge> result = new HashSet<>();

        PriorityQueue<Edge> pQueue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        Node node = graph.nodes.get(1);
        if (node == null) {
            return -1;
        }
        pQueue.add(new Edge(0, node, node));
        while (!pQueue.isEmpty()) {
            Edge edge = pQueue.poll();
            Node to = edge.to;
            if (!visited.contains(to)) {
                result.add(edge);
                visited.add(to);
                pQueue.addAll(to.edges);
            }
        }

//        System.out.println("graph node size: " + graph.nodes.size());
//        for (Edge edge : result) {
//            System.out.println("from: " + edge.from.val + " to: " + edge.to.val + " weight: " + edge.weight);
//        }

        if (visited.size() != n) {
            return -1;
        }

        int price = 0;
        for (Edge edge: result) {
            price += edge.weight;
        }

        System.out.println(price);
        return price;
    }

    private Graph constructGraph(int[][] connections) {
        Graph graph = new Graph();
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            int cost = connection[2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);

            Edge edge = new Edge(cost, fromNode, toNode);
            Edge edge2 = new Edge(cost, toNode, fromNode);

            fromNode.edges.add(edge);
            fromNode.nexts.add(toNode);
            fromNode.in++;
            fromNode.out++;

            toNode.edges.add(edge2);
            toNode.nexts.add(fromNode);
            toNode.in++;
            toNode.out++;

            graph.edges.add(edge);
            graph.edges.add(edge2);
        }

        return graph;
    }

    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCostPrim_7_135 sol = new ConnectingCitiesWithMinimumCostPrim_7_135();

        int[][] test = {{2,1,50459},{3,2,47477},{4,2,52585},{5,3,16477}};

//        int[][] test = {{2,1,50459}};

        sol.minimumCost(4, test);
    }
}


