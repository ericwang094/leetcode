package TwoPointers;

public class InterleavingPositiveNegativeNumbers {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        int countPositive = 0;
        int positiveIndex = 0;

        int negIndex = 0;
        int posIndex = 1;
        for (int i = 0; i < A.length; i++) {
            if(A[i] > 0) {
                swap(A, i, positiveIndex);
                countPositive++;
                positiveIndex++;
            }
        }

        if (countPositive > A.length / 2) {
            posIndex = 0;
            negIndex = 1;
            int left = 0;
            int right = A.length - 1;
            while (left < right) {
                swap(A, left, right);
                left++;
                right--;
            }
        }

        while (posIndex < A.length && negIndex < A.length) {
            while (posIndex < A.length && A[posIndex] > 0) {
                posIndex += 2;
            }

            while (negIndex < A.length && A[negIndex] < 0) {
                negIndex += 2;
            }

            if (posIndex < A.length && negIndex < A.length) {
                swap(A, posIndex, negIndex);
            }
        }
    }

    public void swap (int[] A, int l, int r) {
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }

    public static void main(String[] args) {
        InterleavingPositiveNegativeNumbers pa = new InterleavingPositiveNegativeNumbers();
        int[] input = {-27,2,-22,26,-17,34,-2,32,-18,2,28,9,-35,25,-33,2,-4,35,-8};
        pa.rerange(input);
       for(int i = 0; i < input.length; i++) {
           System.out.print(input[i]+",");
       }
    }
}
