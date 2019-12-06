package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), n);
        return result;
    }

    private void helper(List<List<String>> result, List<Integer> tempList, int size) {
        if (tempList.size() == size) {
            result.add(fromArrayToResult(new ArrayList<Integer>(tempList)));
        } else {
            for (int i = 0; i < size; i++) {
                if (isValidPlace(tempList, i)) {
                    tempList.add(i);
                    helper(result, tempList, size);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isValidPlace(List<Integer> tempList, int newValue) {
        for (int i = 0; i < tempList.size(); i++) {
            int difference = Math.abs(tempList.get(i) - newValue);
            if (difference == 0 || difference == tempList.size() - i) {
                return false;
            }
        }

        return true;
    }

    private List<String> fromArrayToResult (List<Integer> tempList) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < tempList.size(); i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < tempList.size(); j++) {
                if (j == tempList.get(i)) {
                    row.append("Q");
                } else {
                    row.append(".");
                }
            }
            result.add(row.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        nq.solveNQueens(2);
    }
}
