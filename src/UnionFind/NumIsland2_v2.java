package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class NumIsland2_v2 {
	public List<Integer> numIslands2(int n, int m, Point[] operators) {
		// write your code here
		List<Integer> result = new ArrayList<>();
		if (operators == null || operators.length == 0) {
			return result;
		}

		// Map<Integer, Integer> pointToId = new HashMap<>();
		// for (int i = 0; i < n; i++) {
		//     for (int j = 0; j < m; j++) {
		//         int id = convertPosToId(i, j, m);
		//         pointToId.put(id, id);
		//     }
		// }

		int numOfIsland = 0;
		UnionFind uf = new UnionFind(m*n);
		boolean[][] visited = new boolean[n][m];

		int[] directionX = {0, -1, 0, 1};
		int[] directionY = {-1, 0, 1, 0};

		for (int i = 0; i < operators.length; i++) {
			Point currentPoint = operators[i];
			// pointToId.put(convertPosToId(currentPoint.x, currentPoint.y, m), i);
			int currentPointId = convertPosToId(currentPoint.x, currentPoint.y, m);

			if (visited[currentPoint.x][currentPoint.y]) {
				result.add(uf.component);
				continue;
			}
			visited[currentPoint.x][currentPoint.y] = true;
			uf.component++;

			for (int j = 0; j < 4; j++) {
				int newX = currentPoint.x + directionX[j];
				int newY = currentPoint.y + directionY[j];
				if (!isValid(newX, newY, visited)) {
					continue;
				}

				if (visited[newX][newY]) {
					int id = convertPosToId(newX, newY, m);
					uf.connect(currentPointId, id);
				}
			}

			result.add(uf.component);
		}

		return result;
	}

	private int convertPosToId(int x, int y, int z) {
		return x * z + y;
	}

	private boolean isValid(int x, int y, boolean[][] grid) {
		if (x < 0 || x >= grid.length) {
			return false;
		}

		if (y < 0 || y >= grid[0].length) {
			return false;
		}

		return true;
	}

	private class UnionFind {
		int[] f;
		int component;

		public UnionFind (int size) {
			component = 0;
			f = new int[size];
			for (int i = 0; i < size; i++) {
				f[i] = i;
			}
		}

		public boolean connect(int a, int b) {
			int fatherA = find(a);
			int fatherB = find(b);
			if (fatherA != fatherB) {
				f[fatherA] = fatherB;
				component--;
				return false;
			}
			return true;
		}

		public int find(int a) {
			int father = f[a];
			while (father != f[father]) {
				father = f[father];
			}

			while (a != father) {
				int temp = f[a];
				f[a] = father;
				a = temp;
			}

			return father;
		}
	}

	private static class Point {
		int x;
		int y;

		Point (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
