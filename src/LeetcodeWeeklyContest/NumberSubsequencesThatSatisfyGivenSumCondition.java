package LeetcodeWeeklyContest;

import java.util.Arrays;

public class NumberSubsequencesThatSatisfyGivenSumCondition {
	public int numSubseq(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int mod = 1000000007;
		double result = 0;
		Arrays.sort(nums);

		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			if (nums[l] + nums[r] >= target) {
				r--;
			} else {
				result = (result + Math.pow(2, (r - l))) % mod;
				l++;
			}
		}

		return (int) result;

	}

	public static void main(String[] args) {
		NumberSubsequencesThatSatisfyGivenSumCondition test = new NumberSubsequencesThatSatisfyGivenSumCondition();
		int[] input = new int[]{3,5,6,7};

		test.numSubseq(input, 9);
	}
}
