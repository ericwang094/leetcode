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
    private Point globalOrigin;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        globalOrigin = origin;
        Queue<Point> priorityQueue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int diff = getDistance(p2, globalOrigin) - getDistance(p1, globalOrigin);
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

        int index = k-1;
        Point[] result = new Point[k];
        while (!priorityQueue.isEmpty()) {
            result[index] = priorityQueue.poll();
            index--;
        }

        return result;
    }

    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
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
