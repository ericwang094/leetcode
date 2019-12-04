package leetcode.BFS;

import java.util.*;

public class SixDegrees {
	/*
	 * @param graph: a list of Undirected graph node
	 * @param s: Undirected graph node
	 * @param t: Undirected graph nodes
	 * @return: an integer
	 */
	public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
		if (s.label == t.label) {
			return 0;
		}

		int result = 0;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Set<UndirectedGraphNode> set = new HashSet<>();

		queue.add(s);
		set.add(s);

		while (!queue.isEmpty()) {
			int size = queue.size();
			result++;

			for (int i = 0; i < size; i++) {
				UndirectedGraphNode currentNode = queue.poll();

				for (UndirectedGraphNode neighbor : currentNode.neighbors) {
					if (neighbor.label == t.label) {
						return result;
					}

					if (set.contains(neighbor)) {
						continue;
					}

					queue.add(neighbor);
					set.add(neighbor);
				}
			}
		}

		return -1;
	}
}
