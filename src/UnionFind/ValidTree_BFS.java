package UnionFind;

import java.util.*;

public class ValidTree_BFS {
	public boolean validTree(int n, int[][] edges) {
		if (n == 0) {
			return false;
		}

		if (edges == null || edges.length != n - 1) {
			return false;
		}

		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new HashSet<>());
		}

		for (int i = 0; i < edges.length; i++) {
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}

		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		queue.add(0);
		set.add(0);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (Integer neighbor : graph.get(node)) {
				if (set.contains(neighbor)) {
					continue;
				}
				set.add(neighbor);
				queue.add(neighbor);
			}
		}

		return set.size() == n;
	}

	public static void main(String[] args) {
		ValidTree_BFS gvt = new ValidTree_BFS();
		int[][] input = {
				{0, 1},
				{1, 2},
				{2, 3},
				{1, 3},
		};

		boolean result = gvt.validTree(5, input);
		if (result) {
			System.out.println("true");
		}
	}
}
