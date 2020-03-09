package StackHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianDataStream {
	/**
	 * @param nums: A list of integers
	 * @return: the median of numbers
	 */
	public int[] medianII(int[] nums) {
		// write your code here
		int n = nums.length;
		int[] result = new int[n];
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0 ; i < nums.length; i++) {
			if (maxHeap.size() == 0 ||
					nums[i] <= maxHeap.peek()) {
				maxHeap.add(nums[i]);
			} else {
				minHeap.add(nums[i]);
			}
			balance(maxHeap, minHeap);
			result[i] = maxHeap.peek();
		}
		return result;
	}

	private void balance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		while (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}

		while(minHeap.size() < maxHeap.size() - 1) {
			minHeap.add(maxHeap.poll());
		}
	}
}
