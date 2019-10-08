package TwoPointers;

public class ValidPalindrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        s = s.trim();
        int start = 0;
        int lastIndex = s.length() - 1;
        while (start < lastIndex) {
            Character startChar = s.charAt(start);
            Character endChar = s.charAt(lastIndex);
            if (!Character.isLetterOrDigit(startChar)) {
                start++;
            } else if (!Character.isLetterOrDigit(endChar)) {
                lastIndex--;
            } else if (Character.toLowerCase(startChar)
                    != Character.toLowerCase(endChar)) {
                return false;
            } else {
                start++;
                lastIndex--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome test = new ValidPalindrome();
        String input = "A man, a plan, a canal: Panama";
        System.out.println(test.isPalindrome(input));
    }
}
