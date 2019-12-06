package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, new ArrayList<>(), result,0);

        return result;
    }

    private void helper(int[] nums, List<Integer> tempList, List<List<Integer>> result, int index) {
        result.add(new ArrayList<>(tempList));

        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            helper(nums, tempList, result, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset test = new Subset();
        int[] input = {1, 2};
        test.subsets(input);
    }
}
