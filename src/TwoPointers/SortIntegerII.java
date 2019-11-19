package TwoPointers;

public class SortIntegerII {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivot = A[(startIndex + endIndex) / 2];
        int left = startIndex, right = endIndex;
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

        quickSort(A, startIndex, right);
        quickSort(A, left, endIndex);
    }
}
