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
		int left = 0;
		int right = 0;
		for (int i = 0; i < L.length; i++) {
			right = Math.max(right, L[i]);
		}

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			int cut = cut(L, mid);
			if (cut >= k) {
				left = mid;
			} else {
				right = mid;
			}
		}

		if (cut(L, right) >= k) {
			return right;
		}

		if (cut(L, left) >= k) {
			return left;
		}

		return left;
	}

	private int cut(int[] L, int k) {
		if (k == 0) {
			return 0;
		}
		int num = 0;
		for (int i = 0; i < L.length; i++) {
			num += L[i] / k;
		}

		return num;
	}

}
