package TwoPointers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthInArrays {
	/**
	 * @param arrays: a list of array
	 * @param k: An integer
	 * @return: an integer, K-th largest element in N arrays
	 */
	public int KthInArrays(int[][] arrays, int k) {
		Comparator<Pair> pairComparator = new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.val - o1.val;
			}
		};

		PriorityQueue<Pair> pq = new PriorityQueue<>(pairComparator);

		for (int i = 0; i < arrays.length; i++) {
			if (arrays[i].length > 0) {
				Arrays.sort(arrays[i]);
				pq.add(new Pair(i, arrays[i].length - 1, arrays[i][arrays[i].length - 1]));
			}
		}

		int result = 0;
		for (int i = 0; i < k; i++) {
			Pair curr = pq.poll();
			result = curr.val;

			if (curr.y - 1 >= 0) {
				pq.add(new Pair(curr.x, curr.y - 1, arrays[curr.x][curr.y - 1]));
			}
		}
		return result;
	}

	private class Pair {
		int x;
		int y;
		int val;
		public Pair(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
}
