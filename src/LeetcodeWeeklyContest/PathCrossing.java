package LeetcodeWeeklyContest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathCrossing {
	public boolean isPathCrossing(String path) {
		if (path == null || path.length() == 0) {
			return false;
		}
		char[] pathArr = path.toCharArray();
		Map<Character, int[]> map = new HashMap<>();
		map.put('N', new int[]{0, 1});
		map.put('S', new int[]{0, -1});
		map.put('W', new int[]{-1, 0});
		map.put('E', new int[]{1, 0});

		Map<Integer, Set<Integer>> visited = new HashMap<>();

		int x = 0;
		int y = 0;
		visited.putIfAbsent(0, new HashSet<>());
		visited.get(0).add(0);
		for (int i = 0; i < pathArr.length; i++) {
			char currentDir = pathArr[i];
			int[] dirArr = map.get(currentDir);
			x += dirArr[0];
			y += dirArr[1];
			if (visited.containsKey(x) && visited.get(x).contains(y)) {
				return true;
			}
			visited.putIfAbsent(x, new HashSet<>());
			visited.get(x).add(y);
		}

		return false;
	}

	public static void main(String[] args) {
		PathCrossing pc = new PathCrossing();
		String input = "S";
		pc.isPathCrossing(input);
	}
}
