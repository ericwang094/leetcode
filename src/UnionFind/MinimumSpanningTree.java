package UnionFind;

import java.util.*;

public class MinimumSpanningTree {
	/**
	 * @param connections given a list of connections include two cities and cost
	 * @return a list of connections from results
	 */
	public List<Connection> lowestCost(List<Connection> connections) {
		// Write your code here
		Comparator<Connection> comp = new Comparator<Connection>() {
			@Override
			public int compare(Connection a, Connection b) {
				if (a.cost != b.cost) {
					return a.cost - b.cost;
				}
				if (a.city1.equals(b.city1)) {
					return a.city2.compareTo(b.city2);
				}
				return a.city1.compareTo(b.city1);
			}
		};

		List<Connection> result = new ArrayList<>();
		if (connections == null || connections.size() == 0) {
			return result;
		}

		Collections.sort(connections, comp);

		UnionFind uf = new UnionFind(connections.size() * 2);
		Index idx = new Index();

		for (Connection connection : connections) {
			int c1 = idx.getIndex(connection.city1);
			int c2 = idx.getIndex(connection.city2);
			if (!uf.connect(c1, c2)) {
				result.add(connection);
			}
		}

		return result.size() == idx.n - 1 ? result : new ArrayList<>();
	}

	class Index {
		int n = 0;
		private Map<String, Integer> nameToIds = new HashMap<>();

		public int getIndex(String name) {
			if (nameToIds.containsKey(name)) {
				return nameToIds.get(name);
			} else {
				nameToIds.put(name, n++);
				return n-1;
			}
		}
	}
	class UnionFind {
		int[] f;

		public UnionFind(int n) {
			f = new int[n];
			for (int i = 0; i < n; i++) {
				f[i] = i;
			}
		}

		public boolean connect(int a, int b) {
			int aFather = find(a);
			int bFather = find(b);
			if (aFather != bFather) {
				f[bFather] = aFather;
				return false;
			}
			return true;
		}

		public int find(int x) {
			int father = f[x];
			while (father != f[father]) {
				father = f[father];
			}

			while (x != father) {
				int temp = f[x];
				f[x] = father;
				x = temp;
			}
			return father;
		}
	}

	private class Connection {
		public String city1, city2;
		public int cost;
		public Connection (String city1, String city2, int cost) {
			this.city1 = city1;
			this.city2 = city2;
			this.cost = cost;
		}
	}
}
