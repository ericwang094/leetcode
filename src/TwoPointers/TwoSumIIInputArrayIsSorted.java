package TwoPointers;

public class TwoSumIIInputArrayIsSorted {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] result = new int[2];
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex < endIndex) {
            int currentNum = nums[startIndex] + nums[endIndex];

            if (currentNum == target) {
                result[0] = startIndex + 1;
                result[1] = endIndex + 1;
                return result;
            }
            if (currentNum > target) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted test = new TwoSumIIInputArrayIsSorted();
        int[] input = {2, 7, 11, 15};
        test.twoSum(input, 9);
    }
}
