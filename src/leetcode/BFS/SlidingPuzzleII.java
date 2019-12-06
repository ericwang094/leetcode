package leetcode.BFS;


import java.util.*;

public class SlidingPuzzleII {
	/**
	 * @param init_state: the initial state of chessboard
	 * @param final_state: the final state of chessboard
	 * @return: return an integer, denote the number of minimum moving
	 */
	public int minMoveStep(int[][] init_state, int[][] final_state) {
		// # write your code here
		String source = matrixToString(init_state);
		String target = matrixToString(final_state);

		Set<String> set = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(source);
		set.add(source);

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currentBoard = queue.poll();
				if (currentBoard.equals(target)) {
					return count;
				}

				for (String neighbor : getNext(currentBoard)) {
					if (set.contains(neighbor)) {
						continue;
					}
					set.add(neighbor);
					queue.add(neighbor);
				}
			}
			count++;
		}

		return -1;
	}

	private String matrixToString(int[][] matrix) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(matrix[i][j]);
			}
		}
		return sb.toString();
	}

	private List<String> getNext(String s) {
		List<String> list = new ArrayList<>();
		int zeroIndex = s.indexOf('0');

		int row = zeroIndex / 3;
		int col = zeroIndex % 3;

		int[] directionXs = {1, 0, -1, 0};
		int[] directionYs = {0, 1, 0, -1};

		for (int i = 0; i < 4; i++) {
			int newX = row + directionXs[i];
			int newY = col + directionYs[i];

			if (newX >= 0 && newX < 3 && newY >= 0 && newY < 3) {
				char[] charArray = s.toCharArray();
				charArray[zeroIndex] = charArray[newX * 3 + newY];
				charArray[newX * 3 + newY] = '0';

				list.add(new String(charArray));
			}
		}

		return list;
	}

	public static void main(String[] args) {
		SlidingPuzzleII sp = new SlidingPuzzleII();
//		[[2,8,3],[1,0,4],[7,6,5]]
//[[1,2,3],[8,0,4],[7,6,5]]
		int[][] input1 = {
				{2,8,3},
				{1,0,4},
				{7,6,5},
		};

		int[][] input2 = {
				{1,2,3},
				{8,0,4},
				{7,6,5},
		};

		sp.minMoveStep(input1, input2);
	}
}
