package SweepLineAndDeque;

import java.util.Arrays;

public class Woodcut {
	/**
	 * @param L: Given n pieces of wood with length L[i]
	 * @param k: An integer
	 * @return: The maximum length of the small pieces
	 */
	public int woodCut(int[] L, int k) {
		if (L == null || L.length == 0) {
			return 0;
		}

		int max = 0;
		for (int i : L) {
			max = Math.max(i, max);
		}

		int start = 0;
		int end = max;

		int result = 0;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int pieces = 0;
			for (int i = 0; i < L.length; i++) {
				pieces += L[i] / mid;
			}
			if (pieces >= k) {
				result = mid;
				start = mid;
			} else {
				end = mid;
			}
		}

		return result;
	}
}
