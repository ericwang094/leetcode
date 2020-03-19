package SweepLineAndDeque;

public class FindTheDuplicateNumber {
	/**
	 * @param nums: an array containing n + 1 integers which is between 1 and n
	 * @return: the duplicate one
	 */
	public int findDuplicate(int[] nums) {
		// write your code here
		if (nums.length <= 1)
			return -1;

		int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
	}

	public static void main(String[] args) {
		FindTheDuplicateNumber fdn = new FindTheDuplicateNumber();
		fdn.findDuplicate(new int[]{1,2,3,4,4,5});
	}

	public int findDuplicate1(int[] nums) {
		int slow = nums[0];
		int fast = nums[nums[0]];

		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
