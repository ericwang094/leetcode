package BinarySearch;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] hayStack = {1, 2, 3, 3, 4, 5, 10};
//        BinarySearch bs = new BinarySearch();
//        System.out.println(bs.binarySearch(hayStack, 10));
        int i = 8;
        int result = i >>= 2;
        System.out.println(result);
    }
}
