package BinarySearch;

public class FindPeak {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int start = 1, end = A.length - 2;
        while (start + 1  <end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] > A[end]) {
            return start;
        } else {
            return end;
        }
    }
}
