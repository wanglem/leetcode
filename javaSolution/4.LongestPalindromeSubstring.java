class LongestPalindromeSubstring {
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        if (s.length() < 1) return "";
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1+1; j <= s.length(); j++) {
                String toTest = s.substring(i, j);
                if (toTest.length() > longestPalindrome.length() && isPalindrome(toTest)) {
                    longestPalindrome = toTest;
                }
            }
        }
        return longestPalindrome;
    }
}