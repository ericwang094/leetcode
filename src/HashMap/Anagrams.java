package HashMap;

import java.util.*;

public class Anagrams {
	/**
	 * @param strs: A list of strings
	 * @return: A list of strings
	 */
	public List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<>();
		if (strs == null || strs.length == 0) {
			return result;
		}

		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);

			String newString = new String(charArray);
			if (map.containsKey(newString)) {
				map.get(newString).add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(newString, list);
			}
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if (entry.getValue().size() > 1) {
				result.addAll(entry.getValue());
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Anagrams test = new Anagrams();
		String[] input = {"","b", ""};
		test.anagrams(input);
	}
}
