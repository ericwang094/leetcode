package leetcode.BFS;

import java.util.*;

public class LintNumberOfIslands {
//    /**
//     * @param grid: a boolean 2D matrix
//     * @return: an integer
//     */
//    public int numIslands(boolean[][] grid) {
//    	if (grid == null || grid.length == 0 || grid[0].length == 0) {
//    		return 0;
//	    }
//    	int island = 0;
//
//	    for (int i = 0; i < grid.length; i++) {
//	    	for (int j = 0; j < grid[i].length; j++ ){
//	    		if (grid[i][j]) {
//	    			changeIslands(i, j, grid);
//	    			island++;
//			    }
//		    }
//	    }
//	    return island;
//    }
//
//    private void changeIslands (int x, int y, boolean[][] grid) {
//		int[] directionX = {0, 1, -1, 0};
//		int[] directionY = {-1, 0, 0, 1};
//
//		Queue<Coordinate> queue = new LinkedList<>();
//
//		queue.offer(new Coordinate(x, y));
//		grid[x][y] = false;
//
//		while (!queue.isEmpty()) {
//			Coordinate coor = queue.poll();
//			for (int i = 0; i < 4; i++) {
//				Coordinate adj = new Coordinate(
//					coor.x + directionX[i],
//					coor.y + directionY[i]
//				);
//				if (!inBound(adj, grid)) {
//					continue;
//				}
//				if (grid[adj.x][adj.y]) {
//					grid[adj.x][adj.y] = false;
//					queue.offer(adj);
//				}
//			}
//		}
//    }
//
//    private boolean inBound(Coordinate coor, boolean[][] grid) {
//    	int n = grid.length;
//    	int m = grid[0].length;
//
//    	return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
//    }
//}
//
//class Coordinate {
//    int x, y;
//
//    public Coordinate(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }

	/**
	 * @param grid: a boolean 2D matrix
	 * @return: an integer
	 */
	public int numIslands(boolean[][] grid) {
		// write your code here
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int numOfIsland = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j]) {
					numOfIsland++;
					grid[i][j] = false;
					bfs(grid, new Point(i, j));
				}
			}
		}
		return numOfIsland;
	}

	private void bfs(boolean[][] grid, Point point) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(point);

		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();
			List<Point> neighbors = getNeighbors(point.x, point.y, grid);
			for (Point neighbor : neighbors) {
				if (grid[neighbor.x][neighbor.y]) {
					grid[neighbor.x][neighbor.y] = false;
					queue.add(neighbor);
				}
			}
		}
	}

	private List<Point> getNeighbors(int x, int y, boolean[][] grid) {
		List<Point> neighbors = new ArrayList<>();
		int[] directionX = {-1, 0, 1, 0};
		int[] directionY = {0, -1, 0, 1};
		for (int i = 0; i < directionX.length; i++) {
			int newX = x + directionX[i];
			int newY = y + directionY[i];

			if (!isValidPosition(newX, newY, grid)) {
				continue;
			}

			neighbors.add(new Point(newX, newY));
		}

		return neighbors;
	}

	private boolean isValidPosition(int x, int y, boolean[][] grid) {
		if (x < 0 || y < 0) {
			return false;
		}

		if (x > grid.length - 1 || y > grid[x].length - 1) {
			return false;
		}

		return true;
	}

	class Point {
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int x;
		int y;
	}

	public static void main(String[] args) {
		LintNumberOfIslands islands = new LintNumberOfIslands();
		boolean[][] input = {
				{true, true, false, false, false},
				{false, true, false, false, true},
				{false, false, false, true, true},
				{false, false, false, false, false},
				{false, false, false, false, true},
		};

		islands.numIslands(input);
	}
}



