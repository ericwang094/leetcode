package UnionFind;

import java.util.*;

public class AccountMerge {
	Map<String, EmailAccounts> map;
	/**
	 * @param accounts: List[List[str]]
	 * @return: return a List[List[str]]
	 */
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		// write your code here
		List<List<String>> result = new ArrayList<>();

		map = new HashMap<>();
		for (List<String> list : accounts) {
			EmailAccounts ea = new EmailAccounts(list.get(0), new PriorityQueue<>());
			for (int i = 1; i < list.size(); i++) {
				ea.pq.add(list.get(i));
				map.put(list.get(i), ea);
			}
		}


	}

	private void connect(String email1, String email2) {
		EmailAccounts father1 = find(email1);
		EmailAccounts father2 = find(email2);
		if (father1 != father2) {
			father1.pq.addAll(father2.pq);
		}
	}

	private EmailAccounts find(String email) {
		EmailAccounts father = map.get(email);
		while (father != map.get(father.pq.peek())) {
			father = map.get(father.pq.peek());
		}

		while (father != map.get(email)) {
			EmailAccounts ea = map.get(email);

			Iterator<String> iterator = ea.pq.iterator();
			while (iterator.hasNext()) {
				map.put(iterator.next(), father);
			}


		}
	}

	private class EmailAccounts {
		String name;
		PriorityQueue<String> pq;

		public EmailAccounts (String name, PriorityQueue<String> pq){
			this.name = name;
			this.pq = pq;
		}
	}
}
