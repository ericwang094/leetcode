package msb;

// https://leetcode.com/problems/sort-colors/
public class SortColor_2_140 {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int white = 0;

        while (white <= blue) {
            if (nums[white] == 0) {
                int temp = nums[white];
                nums[white] = nums[red];
                nums[red] = temp;

                white++;
                red++;
            }else if (nums[white] == 1) {
                white++;
            } else {
                int temp = nums[white];
                nums[white] = nums[blue];
                nums[blue] = temp;
                blue--;
            }
        }
    }
}
