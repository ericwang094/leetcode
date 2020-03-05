package UnionFind;

import java.util.HashMap;
import java.util.Map;

public class SetUnion {
	Map<Integer, Integer> parent;
	int component;
	/**
	 * @param sets: Initial set list
	 * @return: The final number of sets
	 */
	public int setUnion(int[][] sets) {
		parent = new HashMap<>();
		component = 0;

		for (int i = 0; i < sets.length; i++) {
			for (int j = 0; j < sets[i].length; j++) {
				if (parent.containsKey(sets[i][j])) {
					continue;
				}
				parent.put(sets[i][j], sets[i][j]);
				component++;
			}
		}

		for (int i = 0; i < sets.length; i++) {
			for (int j = 1; j < sets[i].length; j++) {
				connect(sets[i][0], sets[i][j]);
			}
		}

		return component;
	}

	private void connect(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if (parentA == parentB) {
			parent.put(parentA, parentB);
			component--;
		}
	}

	private int find(int a) {
		int sameSet = parent.get(a);
		while (sameSet != parent.get(sameSet)) {
			sameSet = parent.get(sameSet);
		}

		while (a != sameSet) {
			int temp = parent.get(a);
			parent.put(a, sameSet);
			a = temp;
		}

		return sameSet;
	}

	public static void main(String[] args) {
		SetUnion su = new SetUnion();
//		int[][] input = {
//				{1},
//				{1, 2, 3},
//				{4},
//				{8,7,4,5},
//		};

		int[][] input = {
				{1, 2, 3},
				{3,9,7},
				{4,5,10},
		};
		
//		int[][] input =
//				{{3730,3013,4400,3476},{938,6236,1818,7729,202,9370,3439,3551,558,3935,40,2420,3135,6969,10365,11012,2076,6103,7297,1813},{516,10236,8845,6775,9427,1158,7829,331,8761},{5267,8631,6696,6487,1988,6937,10376,5671,9171,5000,2190,9979,1556,3306,5008,2067,2997},{4478,842,2239,1174,4776,5773,8959,199,9501}};

		su.setUnion(input);
	}
}
