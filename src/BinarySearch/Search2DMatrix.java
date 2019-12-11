package BinarySearch;

public class Search2DMatrix {
	/**
	 * @param matrix: matrix, a list of lists of integers
	 * @param target: An integer
	 * @return: a boolean, indicate whether matrix contains target
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		// write your code here
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int start = 0;
		int end = matrix.length * matrix[0].length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int midIndexX = mid / matrix[0].length;
			int midIndexY = mid % matrix[0].length;
			if (matrix[midIndexX][midIndexY] == target) {
				return true;
			}
			if (matrix[midIndexX][midIndexY] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (matrix[end/matrix[0].length][end%matrix[0].length] == target
				|| matrix[start/matrix[0].length][start%matrix[0].length] == target) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Search2DMatrix s = new Search2DMatrix();
		int[][] input = {
				{1,4,5},
				{6,7,8}
		};

		s.searchMatrix(input, 8);
	}
}
