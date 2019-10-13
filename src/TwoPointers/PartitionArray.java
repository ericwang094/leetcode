package TwoPointers;

public class PartitionArray {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex < endIndex) {
            while (startIndex < endIndex && nums[startIndex] < k) {
                startIndex++;
            }
            while (startIndex <= endIndex && nums[endIndex] >= k) {
                endIndex--;
            }

            if (startIndex <= endIndex) {
                int temp = nums[startIndex];
                nums[startIndex] = nums[endIndex];
                nums[endIndex] = temp;

                startIndex++;
                endIndex--;
            }
        }

        return startIndex;
    }
}
