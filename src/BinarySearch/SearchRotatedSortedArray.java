package BinarySearch;

public class SearchRotatedSortedArray {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        // write your code here
        int povitPoint = findPovitPoint(A);
        int start, end;
        if (target >= A[povitPoint] && target <= A[A.length - 1]) {
            start = povitPoint;
            end = A.length - 1;
        } else {
            start = 0;
            end = Math.max(0, povitPoint - 1);
        }

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
            return start;
        }
        if (A[end] == target) {
            return end;
        }

        return -1;
    }

    private int findPovitPoint(int[] A) {
        // write your code here
        int start = 0, end = A.length - 1;
        int lastElement = A[end];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < lastElement) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[start] < A[end]) {
            return start;
        } else {
            return end;
        }
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray test = new SearchRotatedSortedArray();
        int[] input = {1, 2, 3};
        System.out.println(test.search(input, 1));
    }
}
