package StackHeap;

import java.util.Stack;

public class LargestRectangleHistogram {
	/**
	 * @param height: A list of integer
	 * @return: The area of largest rectangle in the histogram
	 */
	public int largestRectangleArea(int[] height) {
		// write your code here
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		if (height == null || height.length == 0 ) {
			return max;
		}
		stack.add(height[0]);
		for (int i = 0; i <= height.length; i++) {
			int curr = i == height.length? -1 : height[i];
			while (!stack.isEmpty() && curr <= height[stack.peek()]) {
				int h = height[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
			stack.add(i);
		}

		return max;
	}
}
