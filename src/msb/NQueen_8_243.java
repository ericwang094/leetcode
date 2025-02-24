package msb;

public class NQueen_8_243 {
    //https://leetcode.com/problems/n-queens-ii/
    public int totalNQueens(int n) {
        int[] record = new int[n];
        return process(0, record, n);
    }

    private int process(int row, int[] record, int n) {
        if (row == n) {
            return 1;
        }

        int res = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(record, row, col)) {
                record[row] = col;
                res += process(row + 1, record, n);
            }
        }

        return res;
    }

    private boolean isValid(int[] record, int row, int col) {
        for (int k = 0; k < row; k++) {
            if (col == record[k] || Math.abs(record[k] - col) == Math.abs(row - k)) {
                return false;
            }
        }

        return true;
    }

}
