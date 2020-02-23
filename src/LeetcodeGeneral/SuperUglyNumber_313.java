package LeetcodeGeneral;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SuperUglyNumber_313 {
	public int nthSuperUglyNumber(int n, int[] primes) {
		Queue<Long> queue = new PriorityQueue<>();
		Set<Long> set = new HashSet<>();

		for (int i = 0; i < primes.length; i++) {
			queue.add((long) primes[i]);
			set.add((long)  primes[i]);
		}

		long num = 1L;
		for (int i = 1; i < n; i++) {
			num = queue.poll();
			for (int j = 0; j < primes.length; j++) {
				long val = primes[j] * num;
				if (!set.contains(val)) {
					set.add(val);
					queue.add(val);
				}
			}
		}
		return (int) num;
	}
}
