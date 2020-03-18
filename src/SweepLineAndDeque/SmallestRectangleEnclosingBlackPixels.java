package SweepLineAndDeque;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SmallestRectangleEnclosingBlackPixels {
	/**
	 * @param image: a binary matrix with '0' and '1'
	 * @param x: the location of one of the black pixels
	 * @param y: the location of one of the black pixels
	 * @return: an integer
	 */
	public int minArea(char[][] image, int x, int y) {
		// write your code here
		int left = Integer.MAX_VALUE, right = 0, low = Integer.MAX_VALUE, high = 0;

		boolean[][] visited = new boolean[image.length][image[0].length];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));

		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();
			left = Math.min(left, currentPoint.y);
			right = Math.max(right, currentPoint.y);
			low = Math.min(low, currentPoint.x);
			high = Math.max(high, currentPoint.x);

			List<Point> neighbors = getNeighbors(currentPoint, image, visited);
			for (Point neighbor : neighbors) {
				visited[neighbor.x][neighbor.y] = true;
				queue.add(neighbor);
			}
		}

		return (right - left + 1) * (high - low + 1);
	}

	private List<Point> getNeighbors(Point currentPoint, char[][] image, boolean[][] visited) {
		List<Point> result = new ArrayList<>();

		int[] directionX = {-1, 0, 1, 0};
		int[] directionY = {0, -1, 0, 1};

		for (int i = 0; i < 4; i++) {
			int newX = currentPoint.x + directionX[i];
			int newY = currentPoint.y + directionY[i];

			if (!isValid(newX, newY, image)) {
				continue;
			}

			if (visited[newX][newY]) {
				continue;
			}

			if (image[newX][newY] == '1') {
				result.add(new Point(newX, newY));
			}
		}

		return result;
	}

	private boolean isValid(int x, int y, char[][] image) {
		if (x < 0 || x >= image.length) {
			return false;
		}

		if (y < 0 || y >= image[0].length) {
			return false;
		}

		return true;
	}

	private class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
