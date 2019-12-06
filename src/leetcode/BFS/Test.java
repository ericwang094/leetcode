package leetcode.BFS;

import TwoPointers.ListNode;

import java.util.*;

public class Test {
	/**
	 * @param maze: the maze
	 * @param start: the start
	 * @param destination: the destination
	 * @return: the shortest distance for the ball to stop at the destination
	 */
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		// write your code here
		if (maze == null || maze.length == 0 || maze[0].length == 0) {
			return -1;
		}

		int m = maze.length;
		int n = maze[0].length;

		int[][] res = new int[m][n];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				res[i][j] = Integer.MAX_VALUE;
			}
		}

		Queue<PointWithSteps> queue = new LinkedList();
		queue.add(new PointWithSteps(start[0], start[1], 0));

		int[] directionX = {-1, 0, 1, 0};
		int[] directionY = {0, -1, 0, 1};

		while (!queue.isEmpty()) {
			PointWithSteps currentPoint = queue.poll();
			if (currentPoint.steps >= res[currentPoint.x][currentPoint.y]) {
				continue;
			}

			res[currentPoint.x][currentPoint.y] = currentPoint.steps;

			for (int i = 0; i < 4; i++) {
				int newX = currentPoint.x;
				int newY = currentPoint.y;
				int steps = currentPoint.steps;

				while (newX >= 0 && newX < m
						&& newY >= 0 && newY < n
						&& maze[newX][newY] == 0) {
					newX += directionX[i];
					newY += directionY[i];
					steps++;
				}

				newX -= directionX[i];
				newY -= directionY[i];
				steps--;
				queue.add(new PointWithSteps(newX, newY, steps));
			}
		}

		return res[destination[0]][destination[1]] == Integer.MAX_VALUE ?
				-1 : res[destination[0]][destination[1]];
	}

	public static void main(String[] args) {
		Test t = new Test();
		int[] input = {1, 2, 3};
		int[][] des = {{1,2}, {1,3}, {2,3}};

	}
}

