package BinarySearch;

public class SearchRotatedSortedArray {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] > A[end]) {
                if (target > A[end] && target >= A[mid]) {
                    start = mid;
                }else {
                    end = mid;
                }
            } else {
                if (target < A[end] && target >= A[mid]) {
                    start = mid;
                }else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray test = new SearchRotatedSortedArray();
        int[] input = {6,8,9,1,3,5};
        System.out.println(test.search(input, 5));
    }
}
