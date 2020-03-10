package StackHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWater2 {
	private class Cell {
		public int x;
		public int y;
		public int height;

		public Cell (int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}
	}

	int[] dx = {0, -1, 0, 1};
	int[] dy = {-1, 0, 1, 0};
	/**
	 * @param heights: a matrix of integers
	 * @return: an integer
	 */
	public int trapRainWater(int[][] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}

		PriorityQueue<Cell> minheap = new PriorityQueue<>(new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				return c1.height - c2.height;
			}
		});

		boolean[][] visited = new boolean[heights.length][heights[0].length];

		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[0].length; j++) {
				if (i == 0 || i == heights.length - 1 || j == 0 || j == heights[0].length - 1) {
					minheap.add(new Cell(i, j, heights[i][j]));
					visited[i][j] = true;
				}
			}
		}

		int water = 0;
		while (!minheap.isEmpty()) {
			Cell cell = minheap.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cell.x + dx[i];
				int ny = cell.y + dy[i];
				if (nx < 0 || nx >= heights.length || ny < 0 || ny >= heights[0].length) {
					continue;
				}

				if (visited[nx][ny]) {
					continue;
				}

				visited[nx][ny] = true;
				minheap.add(new Cell(nx, ny, Math.max(cell.height, heights[nx][ny])));
				water += Math.max(0, cell.height - heights[nx][ny]);
			}
		}

		return water;
	}
}
