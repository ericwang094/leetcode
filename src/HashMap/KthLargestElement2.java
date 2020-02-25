package HashMap;

public class KthLargestElement2 {
	/**
	 * @param nums: an integer unsorted array
	 * @param k: an integer from 1 to n
	 * @return: the kth largest element
	 */
	public int kthLargestElement2(int[] nums, int k) {
		return helper(nums, 0, nums.length - 1, nums.length - k);
	}

	private int helper(int[] nums, int start, int end, int k) {
		if (start >= end) {
			return nums[k];
		}

		int left = start, right = end;
		int pivot = nums[(start + end) / 2];

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
		if (right >= start && k <= right) {
			return helper(nums, start, right, k);
		} else if (left <= end && k >= left) {
			return helper(nums, left, end, k);
		} else {
			return nums[k];
		}
	}
}
