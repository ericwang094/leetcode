package DFS;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		// write your code here
		List<String> result = new ArrayList<>();
		dfs(s, result, new ArrayList<>(), 4);

		return result;
	}

	private void dfs(String s, List<String> result, ArrayList<String> tempList, int availableDot) {
		if (s.length() == 0 && availableDot == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < tempList.size(); i++) {
				sb.append(tempList.get(i)).append(".");
			}
			result.add(sb.toString());
		} else if (availableDot == 0) {
			return;
		} else {
			for (int i = 1; i <= 3; i++) {
				if (s.length() < i) {
					return;
				}


				String possibleComponentStr = s.substring(0, i);
				int possibleComponentInt = Integer.parseInt(possibleComponentStr);
				if (possibleComponentInt < 1 || possibleComponentInt > 255) {
					continue;
				}

				tempList.add(possibleComponentStr);
				dfs(s.substring(i), result, tempList, availableDot - 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		RestoreIPAddresses ra = new RestoreIPAddresses();
		ra.restoreIpAddresses("25525511135");
	}
}
