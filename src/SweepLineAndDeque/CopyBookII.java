package SweepLineAndDeque;

public class CopyBookII {
	public int copyBooksII(int n, int[] times) {
		int left = Integer.MAX_VALUE;
		int right = 0;
		for (int i = 0; i < times.length; i++) {
			left = Math.min(left, times[i]);
		}

		right = left * n;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			int timeRequired = getTime(mid,times);
			if (timeRequired >= n) {
				right = mid;
			} else {
				left = mid;
			}
		}

		if (getTime(left,times) <= n) {
			return left;
		}

		return right;
	}

	private int getTime(int limit, int[] times){
		int num = 0;
		for(int i = 0; i < times.length; i++){
			int time = times[i];
			num += time/limit ;
		}
		return num;
	}
}
