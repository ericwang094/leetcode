package LeetcodeGeneral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom_380 {
	ArrayList<Integer> nums;
	Map<Integer, Integer> num2Index;
	Random random;

	/** Initialize your data structure here. */
	public InsertDeleteGetRandom_380() {
		this.nums = new ArrayList<>();
		this.num2Index = new HashMap<>();
		this.random = new Random();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (num2Index.containsKey(val)) {
			return false;
		}

		nums.add(val);
		num2Index.put(val, nums.size() - 1);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!num2Index.containsKey(val)) {
			return false;
		}

		int index = num2Index.get(val);
		if (index != nums.size() - 1) {
			int lastEle = nums.get(nums.size() - 1);
			nums.set(index, lastEle);
			num2Index.put(lastEle, index);
			nums.remove(nums.size() - 1);
		}

		num2Index.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return random.nextInt(nums.size());
	}
}
