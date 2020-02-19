package HashMap;

public class FirstUniqueNumberInDataStream {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        DataStream ds = new DataStream();
        for (int i = 0; i < nums.length; i++) {
            ds.add(nums[i]);
            if (nums[i] == number) {
                return ds.firstUnique();
            }
        }
        return -1;
    }
}



