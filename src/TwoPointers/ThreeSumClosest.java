package TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest {
    private int closestSum = Integer.MAX_VALUE;
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 3) {
            return closestSum;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            int startIndex = i + 1;
            int endIndex = numbers.length - 1;

            while (startIndex < endIndex) {
                int tempSum = numbers[startIndex] + numbers[endIndex] + numbers[i];
                if (Math.abs(target - tempSum) < Math.abs(target - closestSum)) {
                    closestSum = tempSum;
                }
                if (tempSum < target) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest test = new ThreeSumClosest();
        int[] input = {2,7,11,15};
        System.out.println(test.threeSumClosest(input, 3));
    }
}
