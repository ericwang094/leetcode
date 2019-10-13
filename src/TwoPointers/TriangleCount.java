package TwoPointers;

import java.util.Arrays;

// solution https://leetcode.com/problems/valid-triangle-number/discuss/128135/A-similar-O(n2)-solution-to-3-Sum
public class TriangleCount {
    private int count = 0;
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        Arrays.sort(S);

        int result = 0;
        for (int i = S.length - 1; i > 1; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (S[j] + S[k] > S[i]) {
                    result += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TriangleCount tc = new TriangleCount();

        System.out.println(tc.triangleCount(new int[]{4,4,4,4}));

    }
}
