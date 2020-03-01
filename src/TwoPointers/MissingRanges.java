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
			if (upper - lower == 0) {
				result.add(String.valueOf(upper));
			} else if(upper- lower == 2) {
				result.add(String.valueOf(lower + 1));
			} else {
				String sb = String.valueOf(lower) +
						"->" +
						String.valueOf(upper);
				result.add(sb);

			}
			return result;
		}

		Long firstRange = Long.valueOf(nums[0] - lower);
		if (firstRange == 1) {
			result.add(String.valueOf(lower));
		} else if (firstRange != 0) {
			String sb = String.valueOf((long) lower) +
					"->" +
					String.valueOf((long) nums[0] - 1);
			result.add(sb);
		}

		for (int left = 0; left < nums.length - 1; left++) {
			if ((long) nums[left + 1] - (long) nums[left] == 1) {
				continue;
			}

			if ((long) nums[left + 1] - (long) nums[left] == 2) {
				result.add(String.valueOf((long) nums[left] + 1));
			} else {
				String sb = String.valueOf((long) nums[left] + 1) +
						"->" +
						String.valueOf((long) nums[left + 1] - 1);
				result.add(sb);
			}

		}

		if ((long) upper - (long) nums[nums.length - 1] != 0) {
			if ((long) upper - (long) nums[nums.length - 1] == 1) {
				result.add(String.valueOf(upper));
			}
			else if ((long) upper - (long) nums[nums.length - 1] == 2) {
				result.add(String.valueOf(upper - 1));
			} else {
				String sb = String.valueOf((long) nums[nums.length - 1] + 1) +
						"->" +
						String.valueOf((long) upper);
				result.add(sb);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		MissingRanges test = new MissingRanges();
//		int[] input = {0,1,3,50,75};
		int[] input = {2147483647};
		test.findMissingRanges(input, 0, 2147483647);
	}
}
