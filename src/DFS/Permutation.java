package DFS;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!tempList.contains(nums[i])) {
                    tempList.add(nums[i]);
                    helper(nums, tempList, result);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
