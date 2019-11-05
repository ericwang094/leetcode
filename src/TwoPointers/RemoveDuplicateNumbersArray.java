package TwoPointers;

import java.util.*;

public class RemoveDuplicateNumbersArray {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int slowRunner = 0;
        for (int fasterRunner = 0; fasterRunner < nums.length; fasterRunner++) {
            if (nums[slowRunner] != nums[fasterRunner]) {
                slowRunner++;
                nums[slowRunner] = nums[fasterRunner];
            }
        }

        return slowRunner + 1;
    }

    public int deduplication2(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, true);
        }

        int index = 0;
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            nums[index] = entry.getKey();
            index++;
        }

        return index;
    }

    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicateNumbersArray rdna = new RemoveDuplicateNumbersArray();
        int[] input = {1,3,1,4,4,2};
//        int[] input = {2, 1};
        System.out.println(rdna.deduplication3(input));
    }
}
