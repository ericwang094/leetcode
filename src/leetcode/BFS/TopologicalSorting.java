package leetcode.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

        if (graph == null || graph.size() == 0) {
            return result;
        }
        // write your code here
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        for(DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor: node.neighbors) {
                int num = map.getOrDefault(neighbor, 0);
                map.put(neighbor, num + 1);
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode currentNode = queue.poll();
            for (DirectedGraphNode node : currentNode.neighbors) {
                map.put(node, map.get(node) - 1);
                if (map.get(node) == 0) {
                    result.add(node);
                    queue.offer(node);
                }
            }
        }
        return result;
    }
}

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}