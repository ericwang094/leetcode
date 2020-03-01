package TwoPointers;

public class MinimumSizeSubarraySum {
	/**
	 * @param nums: an array of integers
	 * @param s: An integer
	 * @return: an integer representing the minimum size of subarray
	 */
	public int minimumSize(int[] nums, int s) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int minimunSize = -1;

		int i = 0, j = 0;
		int sum = 0;

		for (j = 0; j < nums.length; j++) {
			sum += nums[j];

			while (sum >= s) {
				minimunSize = minimunSize == -1 ? j - i + 1 : Math.min(minimunSize, j - i + 1);
				sum -= nums[i++];
			}
		}

		return minimunSize;
	}
}
