package msb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutation2_9_114 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        List<Integer> comb = new ArrayList<>();
        backtrack(comb, nums.length, counter, results);
        return results;
    }

    private void backtrack(List<Integer> comb, int n, HashMap<Integer, Integer> counter, List<List<Integer>> results) {
        if (comb.size() == n) {
            results.add(new ArrayList<>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry: counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0) {
                continue;
            }

            comb.add(num);
            counter.put(num, count - 1);

            backtrack(comb, n, counter, results);

            // revert the previous choice
            comb.removeLast();
            counter.put(num, count);
        }
    }
}
