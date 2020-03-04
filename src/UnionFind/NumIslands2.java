package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class NumIslands2 {
	int components = 0;
	boolean[][] matrix;
	Point[][] fatherMatrix;
	/**
	 * @param n: An integer
	 * @param m: An integer
	 * @param operators: an array of point
	 * @return: an integer array
	 */
	public List<Integer> numIslands2(int n, int m, Point[] operators) {
		List<Integer> result = new ArrayList<>();
		if (operators == null || operators.length == 0) {
			return result;
		}
		// write your code here
		matrix = new boolean[n][m];
		fatherMatrix = new Point[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = false;
				Point p = new Point(i, j);
				fatherMatrix[i][j] = p;
			}
		}


		int[] directionX = {-1, 0, 1, 0};
		int[] directionY = {0, 1, 0, -1};
		for (Point currP : operators) {
			if (matrix[currP.x][currP.y]) {
				result.add(components);
				continue;
			}
			matrix[currP.x][currP.y] = true;
			components++;
			for (int i = 0; i < 4; i++) {
				int newX = currP.x + directionX[i];
				int newY = currP.y + directionY[i];
				if (!isValid(matrix, newX, newY)) {
					continue;
				}
				Point neighbour = fatherMatrix[newX][newY];
				connect(currP, neighbour);
			}

			result.add(components);
		}

		return result;
	}

	private void connect(Point p1, Point p2) {
		Point p1Father = find(p1);
		Point p2Father = find(p2);
		if (p1Father != p2Father) {
			fatherMatrix[p1Father.x][p1Father.y] = p2Father;
			components--;
		}
	}

	private Point find(Point p) {
		Point father = fatherMatrix[p.x][p.y];
		while (father != fatherMatrix[father.x][father.y]) {
			father = fatherMatrix[father.x][father.y];
		}

		while (p != father) {
			Point temp = fatherMatrix[p.x][p.y];
			fatherMatrix[p.x][p.y] = father;
			p = temp;
		}

		return father;
	}

	private boolean isValid(boolean[][] matrix, int newX, int newY) {
		if (newX < 0 || newX >= matrix.length) {
			return false;
		}

		if (newY < 0 || newY >= matrix[0].length) {
			return false;
		}

		if (!matrix[newX][newY]) {
			return false;
		}

		return true;
	}

	private static class Point {
		int x;
		int y;

		Point (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		NumIslands2 test = new NumIslands2();

		Point p1 = new Point(1, 1);
		Point p2 = new Point(0, 1);
		Point p3 = new Point(3, 3);
		Point p4 = new Point(3, 4);

		Point[] grid = {p1, p2, p3, p4};
		test.numIslands2(4, 5, grid);
	}
}
