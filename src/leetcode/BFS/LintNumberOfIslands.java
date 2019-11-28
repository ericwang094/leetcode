package leetcode.BFS;

import java.util.*;

public class LintNumberOfIslands {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
    	if (grid == null || grid.length == 0 || grid[0].length == 0) {
    		return 0;
	    }
    	int island = 0;

	    for (int i = 0; i < grid.length; i++) {
	    	for (int j = 0; j < grid[i].length; j++ ){
	    		if (grid[i][j]) {
	    			changeIslands(i, j, grid);
	    			island++;
			    }
		    }
	    }
	    return island;
    }

    private void changeIslands (int x, int y, boolean[][] grid) {
		int[] directionX = {0, 1, -1, 0};
		int[] directionY = {-1, 0, 0, 1};

		Queue<Coordinate> queue = new LinkedList<>();

		queue.offer(new Coordinate(x, y));
		grid[x][y] = false;

		while (!queue.isEmpty()) {
			Coordinate coor = queue.poll();
			for (int i = 0; i < 4; i++) {
				Coordinate adj = new Coordinate(
					coor.x + directionX[i],
					coor.y + directionY[i]
				);
				if (!inBound(adj, grid)) {
					continue;
				}
				if (grid[adj.x][adj.y]) {
					grid[adj.x][adj.y] = false;
					queue.offer(adj);
				}
			}
		}
    }

    private boolean inBound(Coordinate coor, boolean[][] grid) {
    	int n = grid.length;
    	int m = grid[0].length;

    	return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
    }
}

class Coordinate {
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}



