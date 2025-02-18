package msb;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-length-of-pair-chain/description/
public class MaximumLengthOfPairChain_8 {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, (int[] a, int[] b) -> a[1] - b[1]);
        int result = 0;
        int rightVal = Integer.MIN_VALUE;
        for (int[] pair: pairs) {
            if (pair[0] > rightVal) {
                result++;
                rightVal = pair[1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumLengthOfPairChain_8 maxLengthOfPairChain = new MaximumLengthOfPairChain_8();
        int[][] test = {{1,2}, {2,3},{3,5}};
        int result = maxLengthOfPairChain.findLongestChain(test);
        System.out.println(result);
    }
}
