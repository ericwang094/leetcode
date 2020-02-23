package HashMap;

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> map;
    private ArrayList<Integer> list;
    private Random rand;
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();

        this.rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        if (index != list.size() - 1) {
            int lastEle = list.get(list.size() - 1);
            map.put(lastEle, index);
            list.set(index, lastEle);
        }

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
       return list.get(rand.nextInt(list.size()));
    }
}
