package TwoPointers;

public class WindowSum {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums.length == 0 || nums.length < k) {
            return new int[]{};
        }
        int[] result = new int[nums.length - k + 1];

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        result[0] = sum;

        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] - nums[i - 1] + nums[i + k - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        WindowSum ws = new WindowSum();
        int[] input = {1,2,7,7,2};
        ws.winSum(input, 3);
    }
}
