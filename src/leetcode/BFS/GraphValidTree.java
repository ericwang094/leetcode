package leetcode.BFS;

import java.util.*;

public class GraphValidTree {
	/**
	 * @param n: An integer
	 * @param edges: a list of undirected edges
	 * @return: true if it's a valid tree, or false
	 */
	public boolean validTree(int n, int[][] edges) {
		if (n == 0 || edges.length != n - 1) {
			return false;
		}

		if (edges.length == 0) {
			return n == 1;
		}

		Map<Integer, Set<Integer>> graph = initializeGraph(edges);
		Queue<Integer> queue = new LinkedList<>();

		Set<Integer> set = new HashSet<>();

		queue.add(edges[0][0]);
		set.add(edges[0][0]);

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int neighbor : graph.get(node)) {
				if (set.contains(neighbor)) {
					continue;
				}

				queue.add(neighbor);
				set.add(neighbor);
			}
		}

		return set.size() == n;
	}

	private Map<Integer, Set<Integer>> initializeGraph(int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			if (!graph.containsKey(edge[0])) {
				graph.put(edge[0], new HashSet<>());
			}
			graph.get(edge[0]).add(edge[1]);

			if (!graph.containsKey(edge[1])) {
				graph.put(edge[1], new HashSet<>());
			}
			graph.get(edge[1]).add(edge[0]);
		}

		return graph;
	}

	public static void main(String[] args) {
		GraphValidTree gvt = new GraphValidTree();
		int[][] input = {
			{0, 1},
			{1, 2},
			{2, 3},
			{1, 3},
			{1, 4}
		};

		boolean result = gvt.validTree(5, input);
		if (result) {
			System.out.println("true");
		}
	}
}
