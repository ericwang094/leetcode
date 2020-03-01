package TwoPointers;

import java.util.*;

public class KthSmallestSumInTwoSortedArrays {
	/**
	 * @param A: an integer arrays sorted in ascending order
	 * @param B: an integer arrays sorted in ascending order
	 * @param k: An integer
	 * @return: An integer
	 */
	public int kthSmallestSum(int[] A, int[] B, int k) {
		Comparator<Pair> comparator = new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.sum - o2.sum;
			}
		};

		PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);
		int[] directionsX = {0, 1};
		int[] directionsY = {1, 0};

//		Set<Integer> set = new HashSet<>();

		pq.add(new Pair(0, 0, A[0] + B[0]));

		boolean[][] visited = new boolean[A.length][B.length];

		for (int i = 0; i < k - 1; i++) {
			Pair curr = pq.poll();

			for (int j = 0; j < 2; j++) {
				int nextX = curr.x + directionsX[j];
				int nextY = curr.y + directionsY[j];
				if (nextX < A.length && nextY < B.length && !visited[nextX][nextY]) {
					int sum = A[nextX] + B[nextY];
//					if (set.contains(sum)) {
//						continue;
//					}
					visited[nextX][nextY] = true;
//					set.add(sum);
					pq.add(new Pair(nextX, nextY, sum));
				}
			}
		}
		return pq.peek().sum;
	}

	private class Pair {
		int x;
		int y;
		int sum;
		public Pair (int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
	}

	public static void main(String[] args) {
		KthSmallestSumInTwoSortedArrays test = new KthSmallestSumInTwoSortedArrays();
		int[] input1 = {1, 7, 11};
		int[] input2 = {2, 4, 6};
		test.kthSmallestSum(input1, input2, 8);
	}
}
