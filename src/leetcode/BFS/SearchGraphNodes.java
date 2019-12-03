package leetcode.BFS;

import java.util.*;

public class SearchGraphNodes {
	/*
	 * @param graph: a list of Undirected graph node
	 * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
	 * @param node: an Undirected graph node
	 * @param target: An integer
	 * @return: a node
	 */
	public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
	                                      Map<UndirectedGraphNode, Integer> values,
	                                      UndirectedGraphNode node,
	                                      int target) {

		if (node == null) {
			return null;
		}

		if (values.get(node) == target) {
			return node;
		}

		Set<UndirectedGraphNode> set = new HashSet<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(node);
		set.add(node);

		while (!queue.isEmpty()) {
			UndirectedGraphNode currentNode = queue.poll();
			if (values.get(currentNode) == target) {
				return currentNode;
			}

			for (UndirectedGraphNode neighbor : currentNode.neighbors) {
				if (set.contains(neighbor)) {
					continue;
				}

				queue.add(neighbor);
				set.add(neighbor);
			}
		}

		return null;
	}
}
