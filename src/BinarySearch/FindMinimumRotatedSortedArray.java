package BinarySearch;

public class FindMinimumRotatedSortedArray {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int start = 0, end = nums.length - 1;
        int target = nums[end];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }

    public static void main(String[] args) {
        FindMinimumRotatedSortedArray test = new FindMinimumRotatedSortedArray();
        int[] input = {4,5,6,7,8,9,1,2,3};
        System.out.println(test.findMin(input));

    }
}
