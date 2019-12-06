package leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieMatrix {
	/**
	 * @param grid: a 2D integer grid
	 * @return: an integer
	 */
	public int zombie(int[][] grid) {
		Queue<Point> queue = new LinkedList<>();

		int numOfPeople = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					queue.add(new Point(i, j));
				} else if (grid[i][j] == 0) {
					numOfPeople++;
				}
			}
		}

		int[] directionX = {-1, 0, 1, 0};
		int[] directionY = {0, -1, 0, 1};

		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;

			for (int i = 0; i < size; i++) {
				Point currentPoint = queue.poll();

				for (int j = 0; j < 4; j++) {
					int newX = currentPoint.x + directionX[j];
					int newY = currentPoint.y + directionY[j];

					if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[newX].length &&
							grid[newX][newY] == 0) {
						Point newPoint = new Point(newX, newY);
						grid[newX][newY] = 1;
						queue.add(newPoint);
						numOfPeople--;
						if (numOfPeople == 0) {
							return count;
						}
//						break;
					}
				}
			}
		}

		return numOfPeople == 0 ? count : -1;
	}

	public static void main(String[] args) {
		int[][] input = {
				{0, 1, 2, 0, 0},
				{1, 0, 0, 2, 1},
				{0, 1, 0, 0, 0}
		};

		ZombieMatrix zm = new ZombieMatrix();
		System.out.println(zm.zombie(input));
	}
}
