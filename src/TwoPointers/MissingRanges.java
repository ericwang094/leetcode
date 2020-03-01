package TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	/*
	 * @param nums: a sorted integer array
	 * @param lower: An integer
	 * @param upper: An integer
	 * @return: a list of its missing ranges
	 */
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		if (nums.length == 0) {
			String sb = String.valueOf(lower) +
					"->" +
					String.valueOf(upper);
			result.add(sb);
			return result;
		}

		int firstRange = nums[0] - lower;
		if (firstRange != 0) {
			String sb = String.valueOf(lower) +
					"->" +
					String.valueOf(nums[0]);
			result.add(sb);
		}

		for (int left = 0; left < nums.length - 1; left++) {
			if (nums[left + 1] - nums[left] == 0) {
				continue;
			}

			if (nums[left + 1] - nums[left] == 1) {
				result.add(String.valueOf(nums[left] + 1));
			} else {
				String sb = String.valueOf(nums[left] + 1) +
						"->" +
						String.valueOf(nums[left + 1] - 1);
				result.add(sb);
			}

		}

		if (upper - nums[nums.length - 1] != 0) {
			if (upper - nums[nums.length - 1] == 1) {
				result.add(String.valueOf(upper - 1));
			} else {
				String sb = String.valueOf(nums[nums.length - 1] + 1) +
						"->" +
						String.valueOf(upper);
				result.add(sb);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		MissingRanges test = new MissingRanges();
		int[] input = {0,1,3,50,75};
		test.findMissingRanges(input, 0, 99);
	}
}
