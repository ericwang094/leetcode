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

    public static void main(String[] args) {
        GreaterThanTarget test = new GreaterThanTarget();
        test.twoSum2(new int[]{-1, 0, 1}, 0);

    }
}
