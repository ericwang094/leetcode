package leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MazeII {
	/**
	 * @param maze: the maze
	 * @param start: the start
	 * @param destination: the destination
	 * @return: the shortest distance for the ball to stop at the destination
	 */
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		int m = maze.length;
		int n = maze[0].length;

		int[][] res = new int[m][n];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				res[i][j] = Integer.MAX_VALUE;
			}
		}

		Queue<PointWithSteps> queue = new LinkedList<>();
		queue.add(new PointWithSteps(start[0], start[1], 0));

		int[] directionXs = {-1, 0, 1, 0};
		int[] directionYs = {0, -1, 0, 1};


		while (!queue.isEmpty()) {
			PointWithSteps currentPoint = queue.poll();

			if (currentPoint.steps >= res[currentPoint.x][currentPoint.y]) {
				continue;
			}

			res[currentPoint.x][currentPoint.y] = currentPoint.steps;

			for (int i = 0; i < 4; i++) {
				int currentX = currentPoint.x;
				int currentY = currentPoint.y;
				int currentSteps = currentPoint.steps;
				while (currentX >= 0 && currentX < m
						&& currentY >= 0 && currentY < n && maze[currentX][currentY] == 0) {
					currentX += directionXs[i];
					currentY += directionYs[i];
					currentSteps++;
				}

				currentX -= directionXs[i];
				currentY -= directionYs[i];
				currentSteps--;

				queue.add(new PointWithSteps(currentX, currentY, currentSteps));
			}
		}

		return res[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : res[destination[0]][destination[1]];
	}

	public static void main(String[] args) {
		MazeII test = new MazeII();
		int[][] maze = {
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0}
		};

		int[] start = {0, 4};
		int[] end = {4, 4};

		test.shortestDistance(maze, start, end);
	}
}

class PointWithSteps {
	int x;
	int y;
	int steps;

	public PointWithSteps(int x, int y, int steps) {
		this.x = x;
		this.y = y;
		this.steps = steps;
	}
}
