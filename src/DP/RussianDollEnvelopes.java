package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0){
			return 0;
		}

		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] e1, int[] e2) {
				int diff = e1[0] - e2[0];
				if (diff == 0) {
					diff = e1[1] - e2[1];
				}
				return diff;
			}
		});

		int[] f = new int[envelopes.length];
		Arrays.fill(f, 1);

		int result = 1;
		for (int i = 1; i < envelopes.length; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]
						&& f[i] < f[j] + 1) {
					f[i] = f[j] + 1;
					result = Math.max(result, f[i]);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		RussianDollEnvelopes dp = new RussianDollEnvelopes();
		int[][] input = {
				{5,4},
				{6,4},
				{6,7},
				{2,3}
		};
		dp.maxEnvelopes(input);
	}
}
class Pair {
	int width;
	int height;
	public Pair (int width, int height) {
		this.width = width;
		this.height = height;
	}
}