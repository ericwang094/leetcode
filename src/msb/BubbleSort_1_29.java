package msb;

public class BubbleSort_1_29 {
    class Solution {
        public int[] sortArray(int[] nums) {
            if (nums == null || nums.length < 2) {
                return nums;
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[j+1]) {
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }
                }
            }

            return nums;
        }
    }
}
