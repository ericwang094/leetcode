package TwoPointers;

public class KthLargestElement {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        return reverseQuickSort(nums, 0, nums.length - 1, n - 1);
    }

    private int reverseQuickSort(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int left = start;
        int right = end;
        int pivot = nums[(left + right) / 2];

        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }

            while (left <= right && nums[right] < pivot) {
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

        if (left <= k && left <= end) {
            return reverseQuickSort(nums, left, end, k);
        } else if (right >= k && right > start) {
            return reverseQuickSort(nums, start, right, k);
        } else {
            return nums[k];
        }
    }
}
