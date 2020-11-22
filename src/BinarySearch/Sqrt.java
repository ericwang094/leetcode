package BinarySearch;

public class Sqrt {
	public int sqrt(int x) {
		// write your code here
		if (x == 0 || x == 1) {
			return x;
		}

		int ans = x;
		while (ans > x /ans) {

			ans /= 2;
			System.out.println("ans: " + ans);
		}

		if (ans * 2 < x) {
			return ans * 2;
		}
		return ans;
	}

	public static void main(String[] args) {
		Sqrt s = new Sqrt();
		s.sqrt(65536);
	}
}
