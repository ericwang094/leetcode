package UnionFind;

public class ConnectingGraph2 {
	int[] graph;
	int[] size;
	/*
	 * @param n: An integer
	 */public ConnectingGraph2(int n) {
		// do intialization if necessary
		this.graph = new int[n + 1];
		this.size = new int[n + 1];
		for (int i = 1; i <= n ; i++) {
			this.graph[i] = i;
			this.size[i] = 1;
		}
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
	/*
	 * @param a: An integer
	 * @param b: An integer
	 * @return: nothing
	 */
	public void connect(int a, int b) {
		// write your code here
		int aFather = find(a);
		int bFather = find(b);
		if (aFather != bFather) {
			graph[aFather] = bFather;
			size[bFather] += size[aFather];
		}
	}

	/*
	 * @param a: An integer
	 * @return: An integer
	 */
	public int query(int a) {
		// write your code here
		int fatherA = find(a);
		return size[fatherA];
	}
}
