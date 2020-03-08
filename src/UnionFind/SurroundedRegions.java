package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {
	/*
	 * @param board: board a 2D board containing 'X' and 'O'
	 * @return: nothing
	 */
	public void surroundedRegions(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		int n = board.length;
		int m = board[0].length;

		UnionFind uf = new UnionFind(n * m);
		int[] directionX = {0, -1, 0, 1};
		int[] directionY = {-1, 0, 1, 0};

		List<Integer> openEdges = new ArrayList<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'X') {
					continue;
				}

				int currentId = convertPointToId(i, j, m);
				for (int k = 0; k < 4; k++) {
					int newX = i + directionX[k];
					int newY = j + directionY[k];
					if (!valid(newX, newY, board)) {
						continue;
					}
					uf.connect(currentId, convertPointToId(newX, newY, m));
				}

				if (isOpenEdge(i, j, board)) {
					openEdges.add(currentId);
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'X') {
					continue;
				}

				int id = convertPointToId(i, j, m);
				boolean canClose = true;
				for (int openEdge : openEdges) {
					if (uf.find(id) == uf.find(openEdge)) {
						canClose = false;
						break;
					}
				}
				if (canClose) {
					board[i][j] = 'X';
				}
			}
		}
	}

	private boolean isOpenEdge(int i, int j, char[][] board) {
		if ((i == 0 || i == board.length - 1
				|| j == 0 || j == board[i].length - 1)
				&& board[i][j] == 'O') {
			return true;
		}

		return false;
	}

	private boolean valid(int x, int y, char[][] board) {
		if (x < 0 || x >= board.length) {
			return false;
		}

		if (y < 0 || y >= board[0].length) {
			return false;
		}

		if (board[x][y] == 'X') {
			return false;
		}

		return true;
	}

	private int convertPointToId (int i, int j, int m) {
		return i * m + j;
	}

	private class UnionFind {
		int[] f;
		public UnionFind (int size) {
			f = new int[size];
			for (int i = 0; i < size; i++) {
				f[i] = i;
			}
		}

		private boolean connect(int a, int b) {
			int fatherA = find(a);
			int fatherB = find(b);
			if (fatherA != fatherB) {
				f[fatherA] = fatherB;
				return false;
			}

			return true;
		}

		private int find(int a) {
			int father = f[a];
			while (father != f[father]) {
				father = f[father];
			}

			while (a != father) {
				int temp = f[a];
				f[a] = father;
				a = temp;
			}

			return father;
		}
	}

	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
		char[][] input = {
				{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'},
		};

		char[][] input2 = {
				{'X', 'O', 'O', 'X', 'X'},
				{'X', 'O', 'X', 'X', 'X'},
				{'X', 'X', 'X', 'X', 'O'},
				{'X', 'O', 'X', 'X', 'X'},
				{'O', 'X', 'X', 'X', 'O'}
		};


		sr.surroundedRegions(input2);
	}
}
