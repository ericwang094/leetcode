package SweepLineAndDeque;

public class MaximumAverageSubarrayII {
	/**
	 * @param nums: an array with positive and negative numbers
	 * @param k: an integer
	 * @return: the maximum average
	 */
	public double maxAverage(int[] nums, int k) {
		// write your code here
		double start, end, mid;
		start = end = 0;
		for (int i = 0; i < nums.length; i++) {
			start = Math.min(nums[i], start);
			end = Math.max(nums[i], end);
		}

		while (start + 1.e-5 < end) {
			mid = start + (end - start)/2;
			if (canFind(nums, k, mid)) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return start;
	}

	private boolean canFind(int[] A, int k, double avg) {
		double rightSum = 0, leftSum = 0, minLeftSum = 0;

		for (int i = 0; i < k; i++) {
			rightSum += A[i] - avg;
		}

		for (int i = k; i < A.length; i++) {
			if (rightSum - minLeftSum >= 0) {
				return true;
			}

			rightSum += A[i] - avg;
			leftSum += A[i - k] - avg;
			minLeftSum = Math.min(minLeftSum, leftSum);
		}
		if (rightSum - minLeftSum >= 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MaximumAverageSubarrayII mas = new MaximumAverageSubarrayII();
		int[] input = new int[]{1,12,-5,-6,50,3};
		mas.maxAverage(input, 3);
	}
}
