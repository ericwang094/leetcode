package Others;

public class MaxSubarray4 {
	public int maxSubarray4(int[] nums, int k) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] dp = new int[nums.length];
		int[] length = new int[nums.length];


		int result = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				dp[i] = nums[i];
				length[i] = 1;
			} else {
				if (dp[i - 1] + nums[i] >= nums[i]) {
					dp[i] = dp[i - 1] + nums[i];
					length[i] = length[i - 1] + 1;
				} else {
					dp[i] = nums[i];
					length[i] = 1;
				}

				if (dp[i] > result && length[i] >= k) {
					result = dp[i];
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		MaxSubarray4 ms = new MaxSubarray4();
		ms.maxSubarray4(new int[]{-2,2,-3,4,-1,2,1,-5,3}, 5);
	}
}
