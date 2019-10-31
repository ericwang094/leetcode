package TwoPointers;

import DivideConquer.KthSmallest;

public class KthSmallestNumber {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSort(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int left = start, right = end;
        int pivot = nums[(left + right) / 2];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

        if ( left <= end && left <= k) {
            return quickSort(nums, left, end, k);
        } else if (start <= right && right >= k) {
            return quickSort(nums, start, right, k);
        } else {
            return nums[k];
        }

//        if (start <= right && right >= k) {
//            return quickSort(nums, start, right, k);
//        } else if ( left <= end && left <= k) {
//            return quickSort(nums, left, end, k);
//        } else {
//            return nums[k];
//        }
    }

    public static void main(String[] args) {
        KthSmallestNumber test = new KthSmallestNumber();
        int[] input = new int[]{3, 4, 1, 2, 5};
        System.out.println(test.kthSmallest(3, input));

    }
}
