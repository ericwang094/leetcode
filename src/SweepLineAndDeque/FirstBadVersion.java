package SweepLineAndDeque;

public class FirstBadVersion {
	/**
	 * @param n: An integer
	 * @return: An integer which is the first bad version.
	 */
	public int findFirstBadVersion(int n) {
		int start = 1;
		int end = n;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (SVNRepo.isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (SVNRepo.isBadVersion(start)) {
			return end;
		}

		return start;
	}

	private static class SVNRepo {
		public static boolean isBadVersion(int k) {
			return true;
		}
	}
}
