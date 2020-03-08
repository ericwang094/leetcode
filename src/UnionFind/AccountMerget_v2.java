package UnionFind;

import java.util.*;

public class AccountMerget_v2 {
	private Map<String, Integer> emailToId;
	/**
	 * @param accounts: List[List[str]]
	 * @return: return a List[List[str]]
	 */
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		// write your code here
		emailToId = new HashMap<>();
		UnionFind uf = new UnionFind(accounts.size());
		for (int i = 0; i < accounts.size(); i++) {
			List<String> account = accounts.get(i);
			for (int j = 1; j < account.size(); j++) {
				String email = account.get(j);
				if (emailToId.containsKey(email)) {
					uf.connect(emailToId.get(email), i);
				} else {
					emailToId.put(email, i);
				}
			}
		}

		// put all emails to their top father email
		Map<Integer, List<String>> topFatherToChildren = new HashMap<>();
		for (String email : emailToId.keySet()) {
			int topFather = uf.find(emailToId.get(email));
			topFatherToChildren.putIfAbsent(topFather, new ArrayList<String>());
			topFatherToChildren.get(topFather).add(email);
		}

		List<List<String>> result = new ArrayList<>();
		for(Integer key : topFatherToChildren.keySet()) {
			List<String> subResult = new ArrayList<>();
			subResult.add(accounts.get(key).get(0));

			List<String> emailList = topFatherToChildren.get(key);
			Collections.sort(emailList);

			subResult.addAll(emailList);
			result.add(subResult);
		}

		return result;
	}

	private class UnionFind {
		int[] father;

		public UnionFind (int size) {
			this.father = new int[size];
			for (int i = 0; i < size; i++) {
				this.father[i] = i;
			}
		}

		public boolean connect (int a, int b) {
			int fatherA = find(a);
			int fatherB = find(b);
			if (fatherA != fatherB) {
				father[fatherA] = fatherB;
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
		AccountMerget_v2 test = new AccountMerget_v2();

		List<String> list1 = new ArrayList<>();
		list1.add("John");
		list1.add("johnsmith@mail.com");
		list1.add("john_newyork@mail.com");

		List<String> list2 = new ArrayList<>();
		list2.add("John");
		list2.add("johnsmith@mail.com");
		list2.add("john00@mail.com");

		List<String> list3 = new ArrayList<>();
		list3.add("Mary");
		list3.add("mary@mail.com");

		List<String> list4 = new ArrayList<>();
		list4.add("John");
		list4.add("johnnybravo@mail.com");

		List<List<String>> list = new ArrayList<>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);

		test.accountsMerge(list);

	}
}
