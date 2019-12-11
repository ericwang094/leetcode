package BinarySearch;

import DivideConquer.ClosestBinarySearchTreeValue;

public class ClosestNumberSortedArray {
	/**
	 * @param A: an integer array sorted in ascending order
	 * @param target: An integer
	 * @return: an integer
	 */
	public int closestNumber(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				end = mid;
			} else if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		int index = -1;
		if (A[start] >= target) {
			index = start;
		} else {
			index = end;
		}
		if (index > 0 && Math.abs(A[index - 1] - target) < Math.abs(A[index] - target)) {
			return index - 1;
		} else {
			return index;
		}
	}

	public static void main(String[] args) {
		ClosestNumberSortedArray test = new ClosestNumberSortedArray();
		int[] input = {1,2,3};
		test.closestNumber(input, 2);
	}
}
