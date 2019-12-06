package HashMap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int diff = getDistance(o2, origin) - getDistance(o1, origin);
                if (diff == 0) {
                    diff = o2.x - o1.x;
                }
                if (diff == 0) {
                    diff = o2.y - o2.x;
                }
                return diff;
            }
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        k = pq.size();
        Point[] result = new Point[k];
        while (!pq.isEmpty()) {
            k--;
            result[k] = pq.poll();

        }
        return result;
    }

    private int getDistance(Point a, Point b) {
        return (int) (Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
}
