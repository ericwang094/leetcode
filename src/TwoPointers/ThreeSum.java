package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();

        if (numbers == null || numbers.length < 3) {
            return result;
        }

        Arrays.sort(numbers);

        // write your code here
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int target = -numbers[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < numbers.length; j++) {

                int component = target - numbers[j];
                if (map.containsKey(component)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(component);
                    list.add(numbers[j]);
                    result.add(list);
                } else {
                    map.put(numbers[j], component);
                }
                while (numbers[j] == numbers[j - 1]) {
                    j++;
                }
            }
        }

        return result;
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> results = new ArrayList<>();
//
//        if (nums == null || nums.length < 3) {
//            return results;
//        }
//
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            // skip duplicate triples with the same first numebr
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//
//            int left = i + 1, right = nums.length - 1;
//            int target = -nums[i];
//
//            twoSum(nums, left, right, target, results);
//        }
//
//        return results;
//    }
//
//    public void twoSum(int[] nums,
//                       int left,
//                       int right,
//                       int target,
//                       List<List<Integer>> results) {
//        while (left < right) {
//            if (nums[left] + nums[right] == target) {
//                ArrayList<Integer> triple = new ArrayList<>();
//                triple.add(-target);
//                triple.add(nums[left]);
//                triple.add(nums[right]);
//                results.add(triple);
//
//                left++;
//                right--;
//                // skip duplicate pairs with the same left
//                while (left < right && nums[left] == nums[left - 1]) {
//                    left++;
//                }
//                // skip duplicate pairs with the same right
//                while (left < right && nums[right] == nums[right + 1]) {
//                    right--;
//                }
//            } else if (nums[left] + nums[right] < target) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
//        System.out.println(test.threeSum(new int[]{1,0,-1,-1,-1,-1,0,1,1,1}));
//        System.out.println(test.threeSum(new int[]{-2, 1, 1}));
        System.out.println(test.threeSum(new int[]{-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5}));
    }
}
