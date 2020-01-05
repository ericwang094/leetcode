package BinarySearch;

public class MedianTwoSortedArray {
	/*
	 * @param A: An integer array
	 * @param B: An integer array
	 * @return: a double whose format is *.5 or *.0
	 */
	public double findMedianSortedArrays(int[] A, int[] B) {
		int lengthA = A.length;
		int lengthB = B.length;

		int midLength = (lengthA + lengthB + 1) / 2;

		int[] shortArray = lengthA < lengthB ? A : B;
		int[] longArray = lengthA < lengthB ? B : A;

		int start = 0;
		int end = shortArray.length;
		while (start + 1 < end) {
			int midPointShort = (start + end) / 2;
			int midPointLong = midLength - midPointShort;

			int maxLeftX = (midPointShort < 0) ? shortArray[0]:shortArray[midPointShort - 1];
			int minRightX = (midPointShort > shortArray.length - 1) ? shortArray[shortArray.length - 1]:shortArray[midPointShort];

			int maxLeftY = (midPointLong < 0) ? longArray[midPointLong - 1]:longArray[midPointLong - 1];
			int minRightY = (midPointLong > longArray.length - 1) ? longArray[longArray.length - 1]:longArray[midPointLong];

			if (maxLeftX <= minRightY
					&& maxLeftY <= minRightX) {
				if ((lengthA + lengthB) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX <= minRightY) {
				start = midPointShort - 1;
			} else {
				end = midPointShort + 1;
			}
		}
		return -1;
	}


}
