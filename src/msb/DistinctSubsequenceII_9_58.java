package msb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/distinct-subsequences-ii/description/
// This one test case pass, but exceed time limit, so probably still need DP
public class DistinctSubsequenceII_9_58 {
    public int distinctSubseqII(String s) {
        char[] chs = s.toCharArray();
        Set<String> resSet = new HashSet<>();
        process(chs, 0, new ArrayList<>(), resSet);

        // minus one for empty string
        return resSet.size() - 1;
    }

    public void process(char[] chs, int i, List<Character> res, Set<String> resSet) {
        if (i == chs.length) {
            StringBuilder sb = new StringBuilder();

            for (Character ch : res) {
                sb.append(ch);
            }
            String str = sb.toString();
            resSet.add(str);
            return;
        }

        List<Character> resKeep = new ArrayList<>(res);
        resKeep.add(chs[i]);
        process(chs, i + 1, resKeep, resSet);
        List<Character> resNotKeep = new ArrayList<>(res);
        process(chs, i + 1, resNotKeep, resSet);
    }

    public static void main(String[] args) {
        DistinctSubsequenceII_9_58 sol = new DistinctSubsequenceII_9_58();
        String test = "pcrdhwdxmqdznbenhwjsenjhvulyve";
        System.out.println(sol.distinctSubseqII(test));
    }
}
