package msb;

// wrong answer
public class MaximumUnitOnATruck_9_200 {
//    https://leetcode.com/problems/maximum-units-on-a-truck/
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        return process (boxTypes, 0, 0, truckSize);
    }

    private int process(int[][] boxTypes, int i, int alreadyWeight, int truckSize) {
        if (alreadyWeight > truckSize) {
            return -boxTypes[i-1][0] * boxTypes[i-1][1];
        }

        if (i == boxTypes.length) {
            return 0;
        }

        return Math.max(
            process(boxTypes, i + 1, alreadyWeight, truckSize), // don't choose the current box
            boxTypes[i][0] * boxTypes[i][1] + process(boxTypes, i + 1, alreadyWeight + boxTypes[i][0], truckSize));

    }
}
