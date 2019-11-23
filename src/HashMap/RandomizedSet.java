package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> num2Index;
    Random rand;

    public RandomizedSet() {
        // do intialization if necessary
        nums = new ArrayList<Integer>();
        num2Index = new HashMap<Integer, Integer>();
        rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if (num2Index.containsKey(val)) {
            return false;
        }

        num2Index.put(val, nums.size());
        nums.add(val);

        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!num2Index.containsKey(val)) {
            return false;
        }

        int index = num2Index.get(val);
        // remove the last one
        if (index < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            num2Index.put(last, index);
        }
        num2Index.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        return nums.get(rand.nextInt(nums.size()));
    }
}
