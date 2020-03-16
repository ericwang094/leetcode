package SweepLineAndDeque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
	public List<Integer> maxSlidingWindow(int[] nums, int k) {
		// write your code here
		List<Integer> ans = new ArrayList<>();
		Deque<Integer> deque = new ArrayDeque<>();
		if (nums.length == 0) {
			return ans;
		}

		for (int i = 0; i < k - 1; i++) {
			inQueue(deque, i, nums);
		}

		for (int i = k - 1; i < nums.length; i++) {
			inQueue(deque, i, nums);
			ans.add(nums[deque.peekFirst()]);
			outQueue(deque, i-k+1, nums);
		}
		return ans;
	}

	private void inQueue(Deque<Integer> deque, int pos, int[] nums) {
		while (!deque.isEmpty()
				&& nums[deque.peekLast()] <= nums[pos]) {
			deque.pollLast();
		}
		deque.add(pos);
	}

	private void outQueue(Deque<Integer> deque, int pos, int[] nums) {
		if (deque.peekFirst() == pos) {
			deque.pollFirst();
		}
	}
}
