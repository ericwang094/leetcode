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
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSelect(int[] A, int start, int end, int k) {
        if (start == end) {
            return A[start];
        }
        int left = start, right = end;
        int pivot = A[(start + end) / 2];

        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;

                left++;
                right--;
            }
        }

        if (right >= k && start <= right) {
            return quickSelect(A, start, right, k);
        } else if (left <= k && left <= end) {
            return quickSelect(A, left, end, k);
        } else {
            return A[k];
        }
    }

    public static void main(String[] args) {
        KthSmallestNumber test = new KthSmallestNumber();
        int[] input = new int[]{3, 4, 1, 2, 5};
        test.kthSmallest(3, input);

    }
}
