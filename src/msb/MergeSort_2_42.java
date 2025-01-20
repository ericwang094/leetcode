package msb;

public class MergeSort_2_42 {
    public int[] sortArray(int[] nums) {
        process(nums, 0, nums.length - 1);
        return nums;
    }

    public void process(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;

        process(nums, left, mid);
        process(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int i, int m, int j) {

        int[] temp = new int[j - i + 1];

        int temp_index = 0;
        int left = i;
        int right = m + 1;

        while (left <= m && right <= j) {
            temp[temp_index++] = nums[left] < nums[right] ? nums[left++]: nums[right++];
        }

        while (left <= m) {
            temp[temp_index++] = nums[left++];
        }

        while (right <= j) {
            temp[temp_index++] = nums[right++];
        }

        for (int k = 0; k < temp.length; k++) {
            nums[i + k] = temp[k];
        }
    }
}
