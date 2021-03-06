// fb, g
// remove one char to make it palindrome
// only need try remove first non-equal char
class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i < j) {
            return isPalindrome(s, i) || isPalindrome(s, j);
        }

        return true;
    }

    private boolean isPalindrome(String s, int removeIndex) {
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (i == removeIndex) i++;
            if (j == removeIndex) j--;
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}