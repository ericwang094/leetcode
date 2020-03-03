package UnionFind;

public class ConnectingGraph3 {
	int[] graph;
	int components;
	/**
	 * @return: nothing
	 */
	public ConnectingGraph3(int n) {
		graph = new int[n];
		for (int i = 1; i <= n; i++) {
			graph[i] = i;
		}
		components = n;
		// initialize your data structure here.
	}

	private int find(int node) {
		int father = graph[node];
		while (father != graph[father]) {
			father = graph[father];
		}

		while (node != father) {
			int temp = graph[node];
			graph[node] = father;
			node = temp;
		}

		return father;
	}
	public void connect(int a, int b) {
		// write your code here
		int fatherA = find(a);
		int fatherB = find(b);
		if (fatherA != fatherB) {
			graph[fatherA] = fatherB;
			components--;
		}
	}

	/**
	 * @return: An integer
	 */
	public int query() {
		// write your code here
		return components;
	}
}
