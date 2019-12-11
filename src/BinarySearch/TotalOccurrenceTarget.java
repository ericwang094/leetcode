package BinarySearch;

public class TotalOccurrenceTarget {
	/**
	 * @param A: A an integer array sorted in ascending order
	 * @param target: An integer
	 * @return: An integer
	 */
	public int totalOccurrence(int[] A, int target) {
		// write your code here
		if (A == null || A.length == 0) {
			return 0;
		}
		int left = 0;
		int right = 0;

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

		if (A[start] == target) {
			left = start;
		} else if (A[end] == target) {
			left = end;
		} else {
			return 0;
		}

		int start1 = 0;
		int end1 = A.length - 1;
		while (start1 + 1 < end1) {
			int mid = start1 + (end1 - start1) / 2;
			if (A[mid] == target) {
				start1 = mid;
			} else if (A[mid] < target) {
				start1 = mid;
			} else {
				end1 = mid;
			}
		}

		if (A[end1] == target) {
			right = end1;
		} else if (A[start1] == target) {
			right = start1;
		}
		return right - left + 1;
	}

	public static void main(String[] args) {
		TotalOccurrenceTarget tot = new TotalOccurrenceTarget();
//		int[] input = {1,3,3,4,5};
		int[] input = {1,1,1,1,1,1,1,1,1,1,1};

		tot.totalOccurrence(input, 1);
	}
}
