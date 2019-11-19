package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, result, new ArrayList<>(), target, 0);
        return result;
    }

    private void helper(int[] candidates, List<List<Integer>> result,
                        List<Integer> tempList, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = index; i < candidates.length; i++) {
                int currentNum = candidates[i];

                if (i != 0 && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                if (currentNum <= target) {
                    tempList.add(currentNum);
                    helper(candidates, result, tempList, target - currentNum, i);
                    tempList.remove(tempList.size() - 1);
                } else {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] input = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = cs.combinationSum(input, target);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
