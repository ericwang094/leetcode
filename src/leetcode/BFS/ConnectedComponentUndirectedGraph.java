package leetcode.BFS;

import java.util.*;

public class ConnectedComponentUndirectedGraph {
	/*
	 * @param nodes: a array of Undirected graph node
	 * @return: a connected set of a Undirected graph
	 */
	public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
		// write your code here
		List<List<Integer>> result = new ArrayList<>();
		Set<Integer> set = new HashSet<>();

		for (UndirectedGraphNode node : nodes) {
			if (set.contains(node.label)) {
				continue;
			}

			List<Integer> nodeResult = new ArrayList<>();
			nodeResult.add(node.label);
			set.add(node.label);

			Queue<UndirectedGraphNode> queue = new LinkedList<>();
			queue.add(node);

			while (!queue.isEmpty()) {
				UndirectedGraphNode currentNode = queue.poll();
				for (UndirectedGraphNode neighbor : currentNode.neighbors) {
					if (set.contains(neighbor.label)) {
						continue;
					}

					queue.add(neighbor);
					set.add(neighbor.label);
					nodeResult.add(neighbor.label);
				}
			}

			Collections.sort(nodeResult);
			result.add(nodeResult);
		}

		return result;
	}
}
