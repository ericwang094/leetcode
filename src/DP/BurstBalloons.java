package DP;

public class BurstBalloons {
	public int maxCoins(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] arr = new int[n + 2];
		arr[0] = 1;
		arr[n + 1] = 1;
		for (int i = 1; i <= n ; i++) {
			arr[i] = nums[i - 1];
		}
		
		int[][] dp = new int[n + 2][n + 2];
		for (int l = 1; l <= n; l++) {
			for (int i = 1; i <= n - l + 1; i++) {
				int j = i + l - 1;
				for (int k = i; k <= j; k++) {
					dp[i][j] = Math.max(
							dp[i][j],
							dp[i][k - 1] +
									arr[i - 1] * arr[k] * arr[j + 1] +
									dp[k + 1][j]);
				}
			}
		}

		return dp[1][n];
	}

	public static void main(String[] args) {
		BurstBalloons bb = new BurstBalloons();
		int[] input = new int[]{4, 1, 5, 10};
		bb.maxCoins(input);
	}
}
