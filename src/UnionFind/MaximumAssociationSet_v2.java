package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumAssociationSet_v2 {
	/**
	 * @param ListA: The relation between ListB's books
	 * @param ListB: The relation between ListA's books
	 * @return: The answer
	 */
	public List<String> maximumAssociationSet(String[] ListA, String[] ListB) {
		List<String> result = new ArrayList<>();
		// Write your code here
		if (ListA == null || ListB == null || ListA.length == 0 || ListB.length == 0) {
			return result;
		}

		Map<String, Integer> mapBookToId = new HashMap<>();

		UnionFind uf = new UnionFind(ListA.length * 2);
		for (int i = 0; i < ListA.length; i++) {
			String bookA = ListA[i];
			String bookB = ListB[i];
			if (!mapBookToId.containsKey(bookA)) {
				mapBookToId.put(bookA, i);
			}

			if (!mapBookToId.containsKey(bookB)) {
				mapBookToId.put(bookB, i);
			}

			uf.connect(mapBookToId.get(bookA), mapBookToId.get(bookB));
		}

		int maxSizeFather = uf.maxSizeFather;

		for(Map.Entry<String, Integer> entry : mapBookToId.entrySet()) {
			String bookName = entry.getKey();
			int id = entry.getValue();
			if (uf.find(id) == maxSizeFather) {
				result.add(bookName);
			}
		}

		return result;
	}

	private class UnionFind {
		int[] father;
		int[] sizeArray;
		int maxSizeFather;

		public UnionFind (int size) {
			this.father = new int[size];
			this.sizeArray = new int[size];
			maxSizeFather = 0;

			for (int i = 0; i < size; i++) {
				this.father[i] = i;
				this.sizeArray[i] = 1;
			}
		}

		public boolean connect (int a, int b) {
			int fatherA = find(a);
			int fatherB = find(b);
			if (fatherA != fatherB) {
				father[fatherA] = fatherB;
				sizeArray[fatherB] += sizeArray[fatherA];
				if (sizeArray[fatherB] > sizeArray[maxSizeFather]) {
					maxSizeFather = fatherB;
				}
				return false;
			}
			return true;
		}

		public int find(int a) {
			int f = father[a];
			while (f != father[f]) {
				f = father[f];
			}

			while (a != f) {
				int temp = father[a];
				father[a] = f;
				a = temp;
			}

			return f;
		}
	}

	public static void main(String[] args) {
		MaximumAssociationSet_v2 mas = new MaximumAssociationSet_v2();
		String[] input1 = {"abc","abc","abc"};
		String[] input2 = {"bcd","acd","def"};

		mas.maximumAssociationSet(input1, input2);
	}
}
