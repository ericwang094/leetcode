package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingNumberII {
	public int findMissing2(int n, String str) {
		// write your code here
		Set<Integer> set = new HashSet<>();
		dfs(n, str, set, new ArrayList<>());
		for (int i = 1; i <= n; i++ ) {
			if (!set.contains(i)){
				return i;
			}
		}

		return -1;
	}

	private void dfs(int n, String str, Set<Integer> set, List<Integer> tempList) {
		if (tempList.size() == n - 1 && str.length() == 0) {
			set.addAll(new ArrayList<>(tempList));
		} else {

			int numOfDigits = n > 9 ? 2 : 1;
			for (int i = 0; i < numOfDigits; i++) {
				if (i + 1 > str.length()) {
					return;
				}
				int value = Integer.parseInt(str.substring(0, i + 1));
				if (value == 0 || value > n) {
					return;
				}

				if (tempList.contains(value)) {
					continue;
				}
				tempList.add(value);
				dfs(n, str.substring(i + 1), set, tempList);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		FindMissingNumberII fmn = new FindMissingNumberII();
		fmn.findMissing2(20,"19201234568910117121314151618");
	}
}
