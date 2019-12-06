package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, new ArrayList<>(), result,0);

        return result;
    }

    private void helper(int[] nums, List<Integer> tempList, List<List<Integer>> result, int index) {
        result.add(new ArrayList<>(tempList));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            helper(nums, tempList, result, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
