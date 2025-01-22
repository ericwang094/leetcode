package msb;

public class QuickSort_2_220 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if(nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1};
        QuickSort_2_220 solution = new QuickSort_2_220();
        int[] result = solution.sortArray(nums);
    }
}
