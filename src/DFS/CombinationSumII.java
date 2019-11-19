package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        boolean[] placeHolder = new boolean[num.length];
        Arrays.fill(placeHolder, false);

        helper(num, result, new ArrayList<>(), target, placeHolder, 0);
        return result;
    }

    private void helper(int[] num, List<List<Integer>> result, List<Integer> tempList, int target, boolean[] placeHolder, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = index; i < num.length; i++) {
                if (i != index && num[i] == num[i - 1] || placeHolder[i]) {
                    continue;
                }
                if (num[i] > target) {
                    return;
                } else {
                    tempList.add(num[i]);
                    placeHolder[i] = true;
                    helper(num, result, tempList, target - num[i], placeHolder, i + 1);
                    tempList.remove(tempList.size() - 1);
                    placeHolder[i] = false;
                }
            }
        }
    }
}
