package DP;

public class Triangle {
	public int minimumTotal(int[][] triangle) {
		// write your code here
		if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
			return 0;
		}

		int[][] memo = new int[triangle.length][triangle.length];
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle[0].length; j++) {
				memo[i][j] = Integer.MAX_VALUE;
			}
		}

		return helper(triangle, 0, 0, memo);
	}

	private int helper(int[][] triangle, int i, int j, int[][] memo) {
		if (i >= triangle.length) {
			return 0;
		}

		if (memo[i][j] != Integer.MAX_VALUE) {
			return memo[i][j];
		}

		memo[i][j] = Math.min(helper(triangle, i + 1, j, memo), helper(triangle, i + 1, j + 1, memo)) + triangle[i][j];

		return memo[i][j];

	}

	public static void main(String[] args) {
		int[][] input = new int[2][2];
		input[0] = new int[]{1, 0};
		input[1] = new int[]{2, 3};

		Triangle t = new Triangle();
		t.minimumTotal(input);
	}
}
