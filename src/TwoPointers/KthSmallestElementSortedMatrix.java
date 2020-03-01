package TwoPointers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {
	/**
	 * @param matrix: List[List[int]]
	 * @param k: a integer
	 * @return: return a integer
	 */
	public int kthSmallest(int[][] matrix, int k) {
		Comparator<Pair> pairComparator = new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.val - o2.val;
			}
		};
		PriorityQueue<Pair> pq = new PriorityQueue<>(pairComparator);


		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].length > 0) {
				Arrays.sort(matrix[i]);
				pq.add(new Pair(i, 0, matrix[i][0]));
			}
		}

		int result = 0;
		for (int i = 0; i < k; i++) {
			Pair curr = pq.poll();
			result = curr.val;

			if (curr.y + 1 < matrix[curr.x].length) {
				pq.add(new Pair(curr.x, curr.y + 1, matrix[curr.x][curr.y + 1]));
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
