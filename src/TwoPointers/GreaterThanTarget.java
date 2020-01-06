package TwoPointers;

import java.util.Arrays;

public class GreaterThanTarget {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        Arrays.sort(nums);

        // write your code here
        int count = 0;

        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex < endIndex) {

            while (startIndex < endIndex) {
                int value = nums[startIndex] + nums[endIndex];
                if (value <= target) {
                    startIndex++;
                } else {
                    count += endIndex - startIndex;
                    endIndex--;
                }
            }
        }
        return count;
    }

    public int TwoSum2_2 (int[] nums, int target) {
        int result = 0;
        // write your code here
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int start = i + 1;
            while (start < nums.length) {
                int sum = nums[i] + nums[start];
                if (sum > target) {
                    result += (nums.length - start);
                    break;
                }
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GreaterThanTarget test = new GreaterThanTarget();
        test.twoSum2(new int[]{-1, 0, 1}, 0);

    }
}
