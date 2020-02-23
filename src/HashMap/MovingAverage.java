package HashMap;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	private int size = 0;
	private Queue<Long> queue;
	private Long sum;
	/*
	 * @param size: An integer
	 */
	public MovingAverage(int size) {
		// do intialization if necessary
		this.size = size;
		this.queue = new LinkedList<>();
		this.sum = 0L;
	}

	/*
	 * @param val: An integer
	 * @return:
	 */
	public double next(int val) {
		if (size == 0) {
			return 0d;
		}

		// write your code here
		queue.add((long) val);
		sum += val;
		if (queue.size() > size) {
			sum -= queue.poll();
		}

		return (double) sum / queue.size();
	}
}
