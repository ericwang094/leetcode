package TwoPointers;

import java.util.HashSet;
import java.util.Set;

public class Deduplication {
	public int deduplication(int[] nums) {
		// write your code here
		int slow = 0;
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {

			if (!set.contains(nums[i])) {
				int temp = nums[slow];
				nums[slow] = nums[i];
				nums[i] =temp;

				slow++;
			}
			set.add(nums[i]);
		}

		return slow - 1;
	}

	public static void main(String[] args) {
		Deduplication d = new Deduplication();
		int[] input = {1,3,4,4,2,1};
		d.deduplication(input);
	}
}
