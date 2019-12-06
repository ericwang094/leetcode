package DFS;

import java.util.ArrayList;
import java.util.List;

public class SplitString {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, int index, List<String> tempList, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(tempList));
        } else {
            tempList.add(String.valueOf(s.charAt(index)));
            helper(s, index + 1, tempList, result);
            tempList.remove(tempList.size() - 1);

            if (index < s.length() - 1) {
                tempList.add(s.substring(index, index + 2));
                helper(s, index + 2, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
