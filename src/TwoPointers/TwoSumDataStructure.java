package TwoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumDataStructure {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        if (!map.containsKey(number)) {
            list.add(number);
            map.put(number, 1);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int target = value - list.get(i);
            if (map.containsKey(target)) {
                if (target != list.get(i) || map.get(target) > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSumDataStructure tsds = new TwoSumDataStructure();
        tsds.add(2);
        tsds.add(3);
        tsds.find(4);
    }
}
