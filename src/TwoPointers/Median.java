package TwoPointers;

public class Median {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        return sub(nums, 0, nums.length - 1, (nums.length + 1)/2);
    }
    private int sub(int[] nums, int start, int end, int size) {
        int mid = (start + end) / 2;
        int pivot = nums[mid];
        int i = start, j = end;
        while (i <= j) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }

            while (i <= j && nums[j] >= pivot) {
                j--;
            }

            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        if (i - start + 1 >= size) {
            return sub(nums, start, i, size);
        } else if (j - start >= size) {
            return nums[j - 1];
        } else {
            return sub(nums, j, end, size - (j - start));
        }
    }

    public static void main(String[] args) {
        Median test = new Median();
        int[] input = new int[] {4, 5, 1, 2, 3};
        test.median(input);
    }
}
