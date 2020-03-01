package TwoPointers;

import java.util.*;

public class KthLargestNArrays_MyVersion {
	/**
	 * @param arrays: a list of array
	 * @param k: An integer
	 * @return: an integer, K-th largest element in N arrays
	 */
	public int KthInArrays(int[][] arrays, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		// write your code here
		for (int i = 0; i < arrays.length; i++) {
			Arrays.sort(arrays[i]);
			if (arrays[i].length != 0) {
				map.put(i, arrays[i].length - 1);
			}
		}

		int result = 0;
		for (int i = 0; i < k; i++) {
			result = getNextLargest(arrays, map);
		}

		return result;
	}

	private int getNextLargest(int[][] arrays, Map<Integer, Integer> map) {
		int winner = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arrays.length; i++) {
			if (!map.containsKey(i)) {
				continue;
			}

			int nextIndex = map.get(i);
			if (arrays[i][nextIndex] > max) {
				winner = i;
				max = arrays[i][nextIndex];
			}
		}

		int winnerIndex = map.get(winner);
		winnerIndex--;
		if (winnerIndex == -1) {
			map.remove(winner);
		} else {
			map.put(winner, winnerIndex);
		}

		return arrays[winner][winnerIndex + 1];
	}
}
