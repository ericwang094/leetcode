package Others;

public class SubarraySumClosest {
	public int[] subarraySumClosest(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return new int[]{};
		}

		int[] preSum = new int[nums.length + 1];
		preSum[0] = 0;
		for (int i = 1; i < preSum.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i - 1];
		}

		int closestNum = Integer.MAX_VALUE;
		int[] closePair = new int[2];

		for (int i = 1; i < preSum.length - 1; i++) {
			for (int j = i; j < preSum.length; j++) {
				int currentSum = preSum[j] - preSum[i - 1];
				if (Math.abs(currentSum) < Math.abs(closestNum)) {
					closePair = new int[]{i - 1, j - 1};
					closestNum = currentSum;
				}
			}
		}

		return closePair;
	}

	public static void main(String[] args) {
		SubarraySumClosest ss = new SubarraySumClosest();
		int[] input = {6,-4,-8,3,1,7};

		ss.subarraySumClosest(input);
	}
}
