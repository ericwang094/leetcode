package TwoPointers;

public class PartitionArrayByOddAndEven {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            while (start <= end && isOdd(nums[start])) {
                start++;
            }

            while (start <= end && !isOdd(nums[end])) {
                end--;
            }

            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                start++;
                end--;
            }
        }
    }

    private boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public static void main(String[] args) {
        PartitionArrayByOddAndEven test = new PartitionArrayByOddAndEven();
        int[] input = {1,2,3,4,5,6,7,8};

        test.partitionArray(input);
        System.out.println(input);
    }
}
