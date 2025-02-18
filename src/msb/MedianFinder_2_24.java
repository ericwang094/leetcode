package msb;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/description/
public class MedianFinder_2_24 {

    public PriorityQueue<Integer> maxHeap;
    public PriorityQueue<Integer> minHeap;

    public MedianFinder_2_24() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0) {
            maxHeap.add(num);
        } else {
            int maxHeapValue = maxHeap.peek();
            if (num <= maxHeapValue) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if (maxHeap.size() - minHeap.size() >= 2) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() >= 2) {
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0d;
        } else {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder_2_24 mf = new MedianFinder_2_24();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
