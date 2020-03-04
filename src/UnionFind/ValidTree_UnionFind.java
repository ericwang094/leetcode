package UnionFind;

public class ValidTree_UnionFind {
	int components;
	int[] graph;
	/**
	 * @param n: An integer
	 * @param edges: a list of undirected edges
	 * @return: true if it's a valid tree, or false
	 */
	public boolean validTree(int n, int[][] edges) {
		components = n;

		// write your code here
		graph = new int[n];
		for (int i = 0; i < n; i++) {
			graph[i] = i;
		}
		for (int i = 0; i < edges.length; i++) {
			if (!connect(edges[i][0], edges[i][1])) {
				return false;
			}
		}

		return components == 1;
	}

	private boolean connect(int a, int b) {
		int fatherA = find(a);
		int fatherB = find(b);
		if (fatherA != fatherB) {
			components--;
			graph[fatherA] = fatherB;
			return true;
		}

		return false;
	}

	private int find(int a) {
		int father = graph[a];
		while (father != graph[father]) {
			father = graph[father];
		}

		while (a != father) {
			int temp = graph[a];
			graph[a] = father;
			a = temp;
		}

		return father;
	}
}
