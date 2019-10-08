package TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumUniquePairs {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left  < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                count++;
                left++;
                right--;
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TwoSumUniquePairs test = new TwoSumUniquePairs();
//        test.twoSum6(new int[]{1, 1, 2, 45, 46, 46}, 47);
        test.twoSum6(new int[]{11}, 22);
    }
}
