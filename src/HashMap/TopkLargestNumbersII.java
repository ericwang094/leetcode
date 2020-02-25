package HashMap;

import java.util.*;

public class TopkLargestNumbersII {
	Queue<Integer> pq;
	int capacity;
	/*
	 * @param k: An integer
	 */public TopkLargestNumbersII(int k) {
		// do intialization if necessary
		this.pq = new PriorityQueue<>();
		this.capacity = k;
	}

	/*
	 * @param num: Number to be added
	 * @return: nothing
	 */
	public void add(int num) {
		pq.add(num);
		if (pq.size() > capacity) {
			pq.poll();
		}
	}

	/*
	 * @return: Top k element
	 */
	public List<Integer> topk() {
		// write your code here
		Iterator it = pq.iterator();
		List<Integer> result = new ArrayList<>();
		while (it.hasNext()) {
			result.add((Integer) it.next());
		}

		result.sort(Collections.reverseOrder());
		return result;
	}
}
