package msb;

public class InsertionSort_1_131 {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j+1]; j--) {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }

        return nums;
    }

    public int[] sortArray2(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 1 && nums[j-1] > nums[j]; j--) {
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }
        }

        return nums;
    }
}
