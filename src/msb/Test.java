package msb;

import msb.CommonDataStructure.ListNode;

import java.util.*;

public class Test {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = nums.length - 1; i >= 0; i--) {

            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }

        }

        return nums;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = new int[]{5, 2 ,3, 1};

        test.sortArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
