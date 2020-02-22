package HashMap;

import java.util.ArrayList;
import java.util.List;

public class SubarraySum {
	public List<Integer> subarraySum(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums == null) {
			return result;
		}
		int slowRunner = 0;
		while (slowRunner < nums.length) {
			int sum = nums[slowRunner];
			if (sum == 0) {
				result.add(slowRunner);
				result.add(slowRunner);
				return result;
			}
			for (int fasterRunner = slowRunner + 1; fasterRunner < nums.length; fasterRunner++) {
				sum += nums[fasterRunner];
				if (sum == 0) {

					result.add(slowRunner);
					result.add(fasterRunner);

					return result;
				}
			}
			slowRunner++;
		}
		return result;
	}

	public static void main(String[] args) {
		SubarraySum test = new SubarraySum();
		int[] input = {0};
		test.subarraySum(input);
	}
}
