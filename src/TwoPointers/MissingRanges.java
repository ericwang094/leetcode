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
			result.add(convertRangeToString(lower, upper));
			return result;
		}

		String pre = convertRangeToString(lower, (long)nums[0] - 1);
		if (pre != null) {
			result.add(pre);
		}

		for (int i = 0; i < nums.length - 1; i++) {
			String str = convertRangeToString((long)nums[i] + 1, (long)nums[i + 1] - 1);
			if (str != null) {
				result.add(str);
			}
		}

		String str = convertRangeToString((long) nums[nums.length - 1] + 1, upper);
		if (str != null) {
			result.add(str);
		}
		return result;
	}

	private String convertRangeToString(long lower, long upper) {
		if (lower > upper) {
			return null;
		}
		if (upper - lower == 0) {
			return String.valueOf(lower);
		} else {
			return String.valueOf(lower) + "->" + String.valueOf(upper);
		}
	}

	public static void main(String[] args) {
		MissingRanges test = new MissingRanges();
//		int[] input = {0,1,3,50,75};
		int[] input = {2147483647};
		test.findMissingRanges(input, 0, 2147483647);
	}
}
