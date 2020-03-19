package SweepLineAndDeque;

//https://github.com/ChaohuiYu/LeetCode-2/blob/master/Copy%20Books.java
//https://yeqiuquan.blogspot.com/2017/03/lintcode-437-copy-books.html
public class CopyBook {
	/**
	 * @param pages: an array of integers
	 * @param k: An integer
	 * @return: an integer
	 */
	public int copyBooks(int[] pages, int k) {
		// write your code here

		int start = 0, end = 0;
		for (int i = 0; i < pages.length; i++) {
			end += pages[i];
			start = Math.max(start, pages[i]);
		}

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int people = countPeople(pages, mid);
			if (people > k) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (countPeople(pages, start) <= k) {
			return start;
		}
		if (countPeople(pages, end) <= k) {
			return end;
		}

		return start;
	}

	private int countPeople (int[] pages, int limit) {
		if (pages.length == 0) {
			return 0;
		}
		int people = 1;
		int sum = 0;
		for (int i = 0; i < pages.length; i++) {
			if (pages[i] + sum > limit) {
				people++;
				sum = 0;
			}
			sum += pages[i];
		}

		return people;
	}

	public static void main(String[] args) {
		CopyBook cb = new CopyBook();
		int[] input = new int[]{3, 2, 4};
		cb.copyBooks(input, 2);
	}
}
