package LeetcodeWeeklyContest;

public class CheckIfArrayPairsAreDivisibleK {
	public boolean canArrange(int[] arr, int k) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++ ){
			sum += arr[i];
		}

		return sum % k == 0;
	}
}
