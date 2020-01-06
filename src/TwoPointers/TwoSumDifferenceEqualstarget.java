package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSumDifferenceEqualstarget {
	public int[] twoSum7(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[]{map.get(i) + 1, i + 1};
			} else {
				int sum = target + nums[i];
				int diff = nums[i] - target;
				map.put(sum, i);
				map.put(diff, i);
			}
		}

		return new int[]{};
	}
}
