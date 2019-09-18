package leetcode.BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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

        int result = 0;

        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(source);
        grid[source.x][source.y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;

            for (int i = 0; i < size; i++ ) {
                Point currentPoint = queue.poll();
                ArrayList<Point> neighbors = getNeighbors(currentPoint, grid);
                for(Point neighbor : neighbors) {
                    if (neighbor.x == destination.x && neighbor.y == destination.y) {
                        return result;
                    }
                    queue.offer(neighbor);
                }
            }
        }

        return -1;
    }

    private ArrayList<Point> getNeighbors(Point point, boolean[][] grid) {
        ArrayList<Point> neighbors = new ArrayList<Point>();
        int[] coordStepOne = {1, -1};
        int[] coordStepTwo = {2, -2};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int newX = point.x + coordStepOne[i];
                int newY = point.y + coordStepTwo[j];
                if (inBound(newX, newY, grid)) {
                    Point newPoint = new Point(newX, newY);
                    grid[newX][newY] = true;
                    neighbors.add(newPoint);
                }

                newX = point.x + coordStepTwo[i];
                newY = point.y + coordStepOne[j];
                if (inBound(newX, newY, grid)) {
                    Point newPoint = new Point(newX, newY);
                    grid[newX][newY] = true;
                    neighbors.add(newPoint);
                }
            }
        }
        return neighbors;
    }

    private boolean inBound(int pointX, int pointY, boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return pointX >= 0 && pointX < n
                && pointY >= 0 && pointY < m && !grid[pointX][pointY];
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

