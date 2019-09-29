package BinarySearch;

public class MaximumNumberMountainSequence {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return Math.max(nums[start], nums[end]);
    }

    public static void main(String[] args) {
        MaximumNumberMountainSequence test = new MaximumNumberMountainSequence();
        int[] input = {1, 2, 4, 8, 6, 3};
        System.out.println(test.mountainSequence(input));
    }
}
