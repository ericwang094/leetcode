package DFS;

import java.util.*;

public class LetterCombinationsPhoneNumber {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        helper(digits, "", result, 0, map);
        return result;
    }

    private void helper(String digits, String tempString, List<String> result, int index, Map<Character, char[]> map) {
        if (digits.length() == tempString.length()) {
            result.add(tempString);
        } else {
            Character currentCharacter = digits.charAt(tempString.length());
            char[] mapStringArray = map.get(currentCharacter);
            for (char mapString : mapStringArray) {
                helper(digits, tempString+mapString, result, index, map);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber lcpn = new LetterCombinationsPhoneNumber();
        String input = "23";
        List<String> result = lcpn.letterCombinations(input);
        System.out.println(Arrays.toString(result.toArray()));

    }
}
