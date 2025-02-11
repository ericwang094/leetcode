package msb;

import msb.CommonDataStructure.Edge;
import msb.CommonDataStructure.Graph;
import msb.CommonDataStructure.Node;

import java.util.*;

public class Kruskal_7_135 {
    public class MySets {
        public HashMap<Node, List<Node>> setMap;
        public MySets(List<Node> nodes) {
            for (Node cur : nodes) {
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);

            for (Node toNode: toSet) {
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public Set<Edge> kruskalMST(Graph graph) {
        List<Node> list = (List<Node>) graph.nodes.values();
        MySets mySets = new MySets(list);

        PriorityQueue<Edge> pQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            pQueue.offer(edge);
        }

        Set<Edge> result = new HashSet<>();
        while (!pQueue.isEmpty()) {
            Edge edge = pQueue.peek();
            if (!mySets.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                mySets.union(edge.from, edge.to);
            }
        }
        return result;
    }

}
