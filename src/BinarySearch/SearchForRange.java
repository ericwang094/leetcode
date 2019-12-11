package BinarySearch;

public class SearchForRange {
	public int[] searchRange(int[] A, int target) {
		// write your code here
		int[] result = new int[2];
		if (A == null || A.length == 0) {
			return new int[]{-1, -1};
		}

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
			result[0] = start;
		} else if (A[end] == target) {
			result[0] = end;
		} else {
			return new int[]{-1, -1};
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
			result[1] = end1;
		} else if (A[start1] == target) {
			result[1] = start1;
		}

		return result;
	}

	public static void main(String[] args) {
		SearchForRange sfr = new SearchForRange();
		int[] input = {-1,0,1,2,2,2,3,3,3,4,4,4,5,5,6,90,92,93,101};

		sfr.searchRange(input, 2);
	}
}
