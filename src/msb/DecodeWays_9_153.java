package msb;
// https://leetcode.com/problems/decode-ways/description/

// this will exceed time limit in leetcode
public class DecodeWays_9_153 {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        return process(chars, 0);
    }

    private int process(char[] chars, int i) {
        if (i == chars.length) {
            return 1;
        }

        if (chars[i] == '0') {
            return 0;
        }

        if (chars[i] == '1') {
            int res = process(chars, i + 1); // 1 as standalone part
            if (i + 1 < chars.length) {
                res += process(chars, i + 2); // 1 as the char next to it, ie `ix` as a single part
            }
            return res;
        }

        if (chars[i] == '2') {
            int res = process(chars, i + 1);
            if (i + 1 < chars.length && (chars[i + 1] >= '0' && chars[i + 1] <= '6')) {
                res += process(chars, i + 2);
            }

            return res;
        }

        // chars[i] = 3 ~ 9
        return process(chars, i + 1);
    }
}
