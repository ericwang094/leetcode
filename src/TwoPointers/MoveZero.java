package TwoPointers;

public class MoveZero {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        int slowRunner = 0;

        for (int fastRunner = 1; fastRunner < nums.length; fastRunner++) {
            if (nums[fastRunner] == 0) {
                continue;
            }
            while (slowRunner < fastRunner && nums[slowRunner] != 0) {
                slowRunner++;
            }

            if (nums[slowRunner] == 0) {
                int temp = nums[slowRunner];
                nums[slowRunner] = nums[fastRunner];
                nums[fastRunner] = temp;

                slowRunner++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0 ) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        MoveZero mz = new MoveZero();
        int[] input = {0, 1, 0, 3, 12};
        mz.moveZeroes(input);
    }
}
