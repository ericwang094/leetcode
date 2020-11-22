package TwoPointers;

public class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int pl = 0;
        int pr = nums.length - 1;
        int i = 0;

        while (i <= pr) {
            if (nums[i] == 0) {
                swap(nums, pl, i);
                pl++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, pr, i);
                pr--;
            }
        }
    }

    public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int pl = 0;
        int pr = nums.length - 1;
        int i = 0;

        while (i <= pr) {
            if (nums[i] == 0) {
                swap(nums, pl, i);
                pl++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, pr, i);
                pr--;
            }
        }
    }

    public void sortColors3(int[] nums) {
        // write your code here
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] == 2) {
                swap(nums,j,k);
                k--;
            } else {
                j++;
            }
        }
    }

    public void swap (int[] A, int l, int r) {
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
//        int[] input = {1, 0, 2, 1, 1, 0, 0, 2};
        int[] input = {0,2,2,2,2,1,0,1,0,0,0,1,0,2,0};
        sc.sortColors3(input);
    }
}
