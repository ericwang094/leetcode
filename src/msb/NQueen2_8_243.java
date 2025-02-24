package msb;

import java.util.ArrayList;
import java.util.List;

public class NQueen2_8_243 {
    //https://leetcode.com/problems/n-queens-ii/
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] record = new int[n];
        process(0, record, n, res);

        return res;
    }

    private void process(int row, int[] record, int n, List<List<String>> res) {
        if (row == n) {
            List<String> tempSol= new ArrayList<>();

            for (int solRow = 0; solRow < n; solRow++) {
                String levelString = "";
                for (int solCol = 0; solCol < n; solCol++) {
                    if (record[solRow] == solCol) {
                        levelString += "Q";
                    } else {
                        levelString += ".";
                    }
                }
                tempSol.add(levelString);
            }
            res.add(tempSol);
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, record)) {
                record[row] = col;
                process(row + 1, record, n, res);
            }
        }
    }

    private boolean isValid(int row, int col, int[] record) {
        for (int i = 0; i < row; i++) {
            if (record[i] == col || Math.abs(i - row) == Math.abs(col - record[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        NQueen2_8_243 solver = new NQueen2_8_243();
        List<List<String>> res = solver.solveNQueens(4);
        System.out.println(res);
    }
}
