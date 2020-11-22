package DP;

public class MaxSubmatrix {
	public int maxSubmatrix(int[][] matrix) {
		// write your code here
		int n = matrix.length;
		if (n == 0) {
			return 0;
		}

		int m = matrix[0].length;
		if (m == 0) {
			return 0;
		}

		int result = matrix[0][0];

		int[] newArr = new int[m];

		for (int col = 0; col < n; col++ ) {
			for (int col1 = 0; col1 < n; col1++) {
				for (int row = col1 + 1; row < m; row++) {
					newArr[row] += matrix[row][col1];
				}
				int curSum = maxSubArray(newArr);
				result = Math.max(curSum, result);
			}
		}


		return result;
	}

	public int maxSubArray(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		int[] f = new int[n];
		f[0] = nums[0];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			f[i] = Math.max(nums[i], f[i - 1] + nums[i]);
			result = Math.max(f[i], result);
		}

		return result;
	}

	public static void main(String[] args) {
		MaxSubmatrix dp = new MaxSubmatrix();
		int[][] input = {
				{ 23, 90,-39,-100, 89, -10},
				{ -7, 14,-36, 78,  14, -57},
				{-80, 63,-34,  7, -17, -23},
				{-48,-70, 47, -29, -79,  5},
				{-10,-12,-59, 64,  97,  -8},
				{ 92, 35, 28, -86, -21, -9}};
		dp.maxSubmatrix(input);
	}
}
