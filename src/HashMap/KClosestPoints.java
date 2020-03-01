package HashMap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPoints {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    private Point globalOriginal;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        this.globalOriginal = origin;

        Queue<Point> priorityQueue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int diff = getDistance(p2, globalOriginal) - getDistance(p1, globalOriginal);
                if (diff == 0) {
                    diff = p2.x - p1.x;
                }

                if (diff == 0) {
                    diff = p2.y - p1.y;
                }
                return diff;
            }
        });

        for (int i = 0; i < points.length; i++) {
            priorityQueue.add(points[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        Point[] result = new Point[k];
        k--;
        while (k >= 0) {
            result[k] = priorityQueue.poll();
            k--;
        }

        return result;
    }

    private int getDistance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    private class Point {
        int x;
        int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static void main(String[] args) {
        KClosestPoints test = new KClosestPoints();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(1);
        pq.add(3);
        pq.add(2);

        pq.poll();

    }
}
