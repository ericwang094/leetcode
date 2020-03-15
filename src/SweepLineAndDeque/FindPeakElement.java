package SweepLineAndDeque;

public class FindPeakElement {
	/**
	 * @param A: An integers array.
	 * @return: return any of peek positions.
	 */
	public int findPeak(int[] A) {
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return A[mid];
			}
			if (A[mid] > A[mid - 1]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return -1;
	}
}
