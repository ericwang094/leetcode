package HashMap;

public class MergeKSortedArray {
	/**
	 * @param arrays: k sorted integer arrays
	 * @return: a sorted array
	 */
	public int[] mergekSortedArrays(int[][] arrays) {
		// write your code here
		return helper(arrays, 0, arrays.length - 1);

	}

	private int[] helper(int[][] arrays, int start, int end) {
		if (start >= end) {

			return arrays[start];
		}
		int mid = (start + end) / 2;
		int[] leftPart = helper(arrays, start, mid);
		int[] rightPart = helper(arrays, mid + 1, end);
		return mergeTwoArray(leftPart, rightPart);
	}

	private int[] mergeTwoArray(int[] array1, int[] array2) {
		int length1 = array1.length;
		int length2 = array2.length;

		int[] newArray = new int[length1 + length2];

		int i = 0;
		int j = 0;
		int index = 0;

		while (i < length1 && j < length2) {
			if (array1[i] <= array2[j]) {
				newArray[index] = array1[i];
				i++;
			} else if (array1[i] > array2[j]) {
				newArray[index] = array2[j];
				j++;
			}
			index++;
		}

		while( i < length1 ) {
			newArray[index] = array1[i];
			i++;
			index++;
		}

		while (j < length2) {
			newArray[index] = array2[j];
			j++;
			index++;
		}

		return newArray;
	}

	public static void main(String[] args) {
		int[][] input = new int[3][];
		int[] input1 = new int[] {1,3,5,7};
		int[] input2 = new int[] {2,4,6};
		int[] input3 = new int[] {0,8,9,10,11};

		input[0] = input1;
		input[1] = input2;
		input[2] = input3;

		MergeKSortedArray test = new MergeKSortedArray();
		test.mergekSortedArrays(input);
	}
}
