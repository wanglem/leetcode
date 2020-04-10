// MSFT
// each center expand
// center can be one or two letters
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        String longest = "";
        for (int i = 0; i < n; i++) {
            String odd = longestPalindrome(s, i, i);
            String even = longestPalindrome(s, i, i+1);
            longest = odd.length() > longest.length() ? odd : longest;
            longest = even.length() > longest.length() ? even : longest;
        }

        return longest;
    }

    private String longestPalindrome(String s, int left, int right) {
        int n = s.length();
        String longest = "";
        while (left >=0 && right < n && s.charAt(left) == s.charAt(right)) {
            longest = s.substring(left, right+1);
            left--;
            right++;
        }

        return longest;
    }
}