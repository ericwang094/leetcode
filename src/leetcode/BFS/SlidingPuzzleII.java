package leetcode.BFS;

import java.util.*;

public class SlidingPuzzleII {
	/**
	 * @param init_state: the initial state of chessboard
	 * @param final_state: the final state of chessboard
	 * @return: return an integer, denote the number of minimum moving
	 */
	public int minMoveStep(int[][] init_state, int[][] final_state) {
		String startString = matrixToString(init_state);
		String endString = matrixToString(final_state);

		Queue<String> queue = new LinkedList<>();
		Set<String> set = new HashSet<>();

		set.add(startString);
		queue.add(startString);

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currentState = queue.poll();
				if (currentState.equals(endString)) {
					return count;
				}

				List<String> neighbors = getNext(startString);
				for (String neighbor : neighbors) {
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

	private String matrixToString(int[][] state) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(state[i][j]);
			}
		}
		return sb.toString();
	}

	private List<String> getNext(String state) {
		List<String> states = new ArrayList<>();

		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};

		int zeroIndex = state.indexOf("0");
		int x = zeroIndex / 3;
		int y = zeroIndex % 3;

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (newX < 0 || newX >= 3 || newY < 0 || newY >= 3) {
				continue;
			}

			char[] chars = state.toCharArray();
			chars[x * 3 + y] = chars[newX * 3 + newY];
			chars[newX + newY] = 0;
			states.add(new String(chars));
		}

		return states;
	}
}
