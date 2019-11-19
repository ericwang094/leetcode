package TwoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumDataStructure {
    private List<Integer> list = new ArrayList<Integer>();
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        list.add(number);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here

        for (int num : list) {
            if (map.containsKey(value - num) && map.get(value - num) >= 1) {
                map.put(value - num, map.get(value - num) - 1);
                return true;
            } else {
                map.put(num, 1);
            }
        }

        return false;
    }
}
