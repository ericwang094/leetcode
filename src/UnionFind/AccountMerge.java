package UnionFind;

import java.util.*;

public class AccountMerge {
	Map<String, String> emailToName = new HashMap<>();
	Map<String, String> parentMap = new HashMap<>();

	/**
	 * @param accounts: List[List[str]]
	 * @return: return a List[List[str]]
	 */
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> result = new ArrayList<>();
		if (accounts == null || accounts.size() == 0) {
			return result;
		}

		for (List<String> account : accounts) {
			String name = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				emailToName.put(account.get(i), name);
				parentMap.put(account.get(i), account.get(i));
			}
		}

		for (List<String> account : accounts) {
			for (int i = 1; i < account.size() - 1; i++) {
				union(account.get(i), account.get(i + 1));
			}
		}

		Map<String, List<String>> resultMap = new HashMap<>();
		for (String email : parentMap.keySet()) {
			String parent = find(email);
			resultMap.putIfAbsent(parent, new ArrayList<>());
			resultMap.get(parent).add(email);
		}

		for (List<String> list : resultMap.values()) {
			Collections.sort(list);
			list.add(0, emailToName.get(list.get(0)));
			result.add(list);
		}

		return result;
	}

	private String find(String email) {
		String parent = parentMap.get(email);
		while (!parent.equals(parentMap.get(parent))) {
			parent = parentMap.get(parent);
		}

		while (!email.equals(parent)) {
			String temp = parentMap.get(email);
			parentMap.put(email, parent);
			email = temp;
		}

		return parent;
	}

	private void union(String a, String b) {
		String parentA = find(a);
		String parentB = find(b);
		if (!parentA.equals(parentB)) {
			parentMap.put(parentA, parentB);
		}
	}
}
