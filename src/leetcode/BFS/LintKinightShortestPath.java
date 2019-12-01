package leetcode.BFS;

import java.util.*;

public class LintKinightShortestPath {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        if (source == destination) {
            return 1;
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        int steps = 0;

        int[] directionXs = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] directionYs = {2, -2, 1, -1, 2, -2, 1, -1};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point newPoint = queue.poll();
                if (newPoint.x == destination.x && newPoint.y == destination.y) {
                    return steps;
                }

                for (int direction = 0; direction < 8; direction++) {
                    int newX = newPoint.x + directionXs[direction];
                    int newY = newPoint.y + directionYs[direction];
                    Point nextPoint = new Point(newX, newY);
                    if (isValidPoint(newX, newY, grid)) {
                        queue.add(nextPoint);
                        grid[newX][newY] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean isValidPoint(int x, int y, boolean[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && !grid[x][y];
    }

    public static void main (String[] args) {
        LintKinightShortestPath test = new LintKinightShortestPath();
        boolean[][] grid = {
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };
        Point source = new Point(2, 0);
        Point destination = new Point(2, 2);
        int result = test.shortestPath(grid, source, destination);
        System.out.println(result);
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

