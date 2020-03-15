package SweepLineAndDeque;

public class Sqrt {
	/**
	 * @param x: An integer
	 * @return: The sqrt of x
	 */
	public int sqrt(int x) {
		int start = 1;
		int end = x;
		if (x <= 1) {
			return x;
		}
		while (start + 1< end) {
			int mid = start + (end - start) / 2;
			if (mid == x / mid) {
				return mid;
			}
			if (mid < x / mid) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (end > x / end) {
			return start;
		} else {
			return end;
		}
	}
}
