package TwoPointers;

public class ValidPalindromeII {
    /**
     * @param s: a string
     * @return boolean: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindromeII(String s) {
        // Write your code here
        int startIndex = 0;
        int endIndex = s.length() - 1;
        boolean meetBefore = false;
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                if (meetBefore) {
                    return false;
                } else {
                    meetBefore = true;
                    if (startIndex + 1 < s.length() && s.charAt(startIndex + 1) == s.charAt(endIndex)) {
                        startIndex++;
                    } else if (endIndex - 1 > 0 && s.charAt(endIndex - 1) == s.charAt(startIndex)) {
                        endIndex--;
                    } else {
                        return false;
                    }
                }
            } else {
                startIndex++;
                endIndex--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII test = new ValidPalindromeII();
        System.out.println(test.validPalindromeII("abccbaa"));
    }
}
