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
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		// write your code here
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j]) {
					result += 1;
					bfs(i, j, grid);
				}
			}
		}
		return result;
	}

	private void bfs (int i, int j, boolean[][] grid) {
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(i, j));

		while (!queue.isEmpty()) {
			Position currentPosition = queue.poll();
			List<Position> neighborList = neighbors(currentPosition.x, currentPosition.y, grid);
			for (Position p : neighborList) {
				if (!grid[p.x][p.y]) {
					continue;
				}
				grid[p.x][p.y] = false;
				queue.offer(p);
			}
		}
	}

	private List<Position> neighbors(int x, int y, boolean[][] grid) {
		List<Position> neighbors = new ArrayList<>();
		int[] directionX = {-1, 0, 1, 0};
		int[] directionY = {0, -1, 0, 1};
		for (int i = 0; i < directionX.length; i++) {
			int newX = x + directionX[i];
			int newY = y + directionY[i];

			if (!isValidPosition(newX, newY, grid)) {
				continue;
			}

			neighbors.add(new Position(newX, newY));
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

	class Position {
		public Position(int x, int y) {
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



