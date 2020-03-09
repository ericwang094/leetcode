package StackHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
	public List<Integer> medianSlidingWindow(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}
		// write your code here
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		k = Math.min(k, nums.length);

		for (int point = 0; point < k; point++) {
			if (maxHeap.size() == 0 || nums[point] <= maxHeap.peek()) {
				maxHeap.add(nums[point]);
			} else {
				minHeap.add(nums[point]);
			}
			balance(maxHeap, minHeap);

		}
		result.add(maxHeap.peek());

		int left = 1;
		int right = k;
		while (right < nums.length) {
			int removedEle = nums[left - 1];
			maxHeap.remove(removedEle);
			minHeap.remove(removedEle);
			balance(maxHeap, minHeap);

			if (maxHeap.size() == 0 || nums[right] <= maxHeap.peek()) {
				maxHeap.add(nums[right]);
			} else {
				minHeap.add(nums[right]);
			}

			balance(maxHeap, minHeap);
			result.add(maxHeap.peek());

			left++;
			right++;
		}

		return result;
	}

	private void balance (PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		while (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}

		while (maxHeap.size() - 1 > minHeap.size()) {
			minHeap.add(maxHeap.poll());
		}
	}

	public static void main(String[] args) {
		SlidingWindowMedian swm = new SlidingWindowMedian();
		int[] input = {1,2,7,7,2,10,3,4,5};
		swm.medianSlidingWindow(input, 2);
	}
}
