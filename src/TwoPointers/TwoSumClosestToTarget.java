package TwoPointers;

import java.util.Arrays;

public class TwoSumClosestToTarget {
    private int diff = Integer.MAX_VALUE;
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex < endIndex) {
            int currentSum = nums[startIndex] + nums[endIndex];
            if (currentSum == target) {
                return 0;
            }
            if (currentSum < target) {
                if (Math.abs(currentSum - target) < diff) {
                    diff = Math.abs(currentSum - target);
                }
                startIndex++;

            } else {
                if (Math.abs(currentSum - target) < diff) {
                    diff = Math.abs(currentSum - target);
                }
                endIndex--;
            }
        }

        return diff;
    }

    public static void main(String[] args) {
        TwoSumClosestToTarget test = new TwoSumClosestToTarget();
        int[] input = new int[] {-1,2,1,-4};

        System.out.println(test.twoSumClosest(input, 4));
    }
}
