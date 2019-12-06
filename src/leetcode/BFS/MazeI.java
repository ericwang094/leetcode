package leetcode.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MazeI {
	/**
	 * @param maze: the maze
	 * @param start: the start
	 * @param destination: the destination
	 * @return: whether the ball could stop at the destination
	 */
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		// write your code here
		Queue<Point> queue = new LinkedList<>();

		Point startPoint = new Point(start[0], start[1]);
		queue.add(startPoint);

		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();
			if (currentPoint.x == destination[0] && currentPoint.y == destination[1]) {
				return true;
			}

			getNextSteps(currentPoint, queue, maze);
		}

		return false;
	}

	private void getNextSteps(Point currentPoint, Queue<Point> queue, int[][] maze) {
		int[] directionX = {-1, 0, 1, 0};
		int[] directionY = {0, 1, 0, -1};

		for (int i = 0; i < 4; i++) {
			int newX = currentPoint.x;
			int newY = currentPoint.y;

			while (validPoint(newX, newY, maze)) {
				if (hitWall(newX + directionX[i], newY + directionY[i], maze)) {
					if (maze[newX][newY] == 2) {
						break;
					}
					maze[newX][newY] = 2;
					queue.add(new Point(newX, newY));
					break;
				}

				newX += directionX[i];
				newY += directionY[i];
			}
		}
	}

	private boolean validPoint(int x, int y, int[][] maze) {
		return x >= 0 && x < maze.length && y >= 0 && y < maze[x].length;
	}

	private boolean hitWall(int x, int y, int[][] maze) {
		return x == -1 || x == maze.length || y == -1 || y == maze[x].length || maze[x][y] == 1;
	}

	public static void main(String[] args) {
		MazeI test = new MazeI();
		int[][] maze = {
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0}
		};

		int[] start = {0, 4};
		int[] end = {4, 4};

		test.hasPath(maze, start, end);
	}
}

