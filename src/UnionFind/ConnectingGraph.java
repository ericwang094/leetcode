package UnionFind;

public class ConnectingGraph {
	int[] graph;
	/*
	 * @param n: An integer
	 */
	public ConnectingGraph(int n) {
		// do intialization if necessary
		this.graph = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = i;
		}
	}

	private int find(int node) {
	 	int father = graph[node];
		while (father != graph[father]) {
	 		father = graph[father];
	    }

	    int temp = 0;
		while (node != father) {
	 		temp = graph[node];
	 		graph[node] = father;
	 		node = temp;
		}

		return father;
	}
	/*
	 * @param a: An integer
	 * @param b: An integer
	 * @return: nothing
	 */
	public void connect(int a, int b) {
		// write your code here
		int findA = find(a);
		int findB = find(b);
		this.graph[findA] = findB;
	}

	/*
	 * @param a: An integer
	 * @param b: An integer
	 * @return: A boolean
	 */
	public boolean query(int a, int b) {
		// write your code here
		return find(a) == find(b);
	}
}
