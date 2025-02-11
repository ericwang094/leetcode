package msb;

import msb.CommonDataStructure.Edge;
import msb.CommonDataStructure.Graph;
import msb.CommonDataStructure.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimMST_7_159 {

    private class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> pQueue = new PriorityQueue<>(new EdgeComparator());

        HashSet<Node> visitedSet = new HashSet<>();
        HashSet<Edge> result = new HashSet<>();

        for (Node node : graph.nodes.values()) {
            if (visitedSet.contains(node)) {
                continue;
            }

            visitedSet.add(node);
            for (Edge edge : node.edges) {
                pQueue.add(edge);
            }

            while (!pQueue.isEmpty()) {
                Edge edge = pQueue.poll();
                Node toNode = edge.to;
                if (!visitedSet.contains(toNode)) {
                    visitedSet.add(toNode);
                    result.add(edge);
                    for (Edge nextEdge : toNode.edges) {
                        pQueue.add(nextEdge);
                    }
                }
            }
        }
        return result;
    }
}
