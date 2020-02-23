package TwoPointers;

public class Median_MyVersion {
	private int quickMedian(int[] nums, int start, int end, int size) {
		int pivotIndex = partition(nums, start, end);
		if (pivotIndex == size - 1 ) {
			return nums[pivotIndex];
		}
		if (pivotIndex > size - 1) {
			return quickMedian(nums, start, pivotIndex - 1, size);
		} else {
			return quickMedian(nums, pivotIndex + 1, end, size);
		}
	}

	private int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (nums[j] > pivot) {
				continue;
			}
			i++;
			swap(nums, i, j);
		}

		i++;
		swap(nums, i, end);
		return i;
	}

	private void swap(int[] nums, int index1, int index2) {
		if (index1 == index2) {
			return;
		}

		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}
