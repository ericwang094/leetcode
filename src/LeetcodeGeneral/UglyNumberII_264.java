package LeetcodeGeneral;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumberII_264 {
	public int nthUglyNumber(int n) {
		Queue<Long> pq = new PriorityQueue<>();
		Set<Long> set = new HashSet<>();
		int[] prime  = new int[3];
		prime[0] = 2;
		prime[1] = 3;
		prime[2] = 5;

		pq.add(2L);
		pq.add(3L);
		pq.add(5L);

		set.add(2L);
		set.add(3L);
		set.add(5L);

		Long num = 1L;
		for (int i = 1; i < n; i++) {
			num = pq.poll();
			for (int j = 0; j < prime.length; j++ ) {
				long val = num * prime[j];
				if (!set.contains(val)) {
					pq.add(val);
					set.add(val);
				}
			}
		}

		return num.intValue();
	}

	public static void main(String[] args) {
		UglyNumberII_264 test = new UglyNumberII_264();
		test.nthUglyNumber(10);
	}
}
