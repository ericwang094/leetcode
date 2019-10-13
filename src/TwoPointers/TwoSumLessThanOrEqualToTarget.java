package TwoPointers;

import java.util.Arrays;

public class TwoSumLessThanOrEqualToTarget {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int count = 0;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int value = nums[left] + nums[right];

            if (value > target) {
                right--;
            } else {
                count += right - left;
                left++;
            }
        }

        return count;
    }
}
