package HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	/**
	 * @param num: A list of integers
	 * @return: An integer
	 */
	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> visited = new HashSet<>();
		for (int number : num) {
			set.add(number);
		}

		int longestSubarray = 0;
		for (int i = 0; i < num.length; i++) {
			int localLength = 0;
			int currentNum = num[i];
			if (visited.contains(currentNum)) {
				continue;
			}
			visited.add(currentNum);

			localLength++;

			int upperNum = currentNum;
			while (set.contains(upperNum + 1)) {
				localLength++;
				upperNum += 1;
				visited.add(upperNum);
			}

			int lowerNum = currentNum;
			while(set.contains(lowerNum - 1)) {
				localLength++;
				lowerNum -= 1;
				visited.add(lowerNum);
			}

			longestSubarray = Math.max(longestSubarray, localLength);
		}

		return longestSubarray;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int[] input = {1,2,0,1};

		lcs.longestConsecutive(input);
	}
}
