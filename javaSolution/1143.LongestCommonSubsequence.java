// MSFT
/*
    dp[i][j] means longest subsequence from text1[0..1] and text2[0..j]
    two cases:
        1. if text1[i] == text2[j]: dp[i][j] = dp[i-1][j-1] + 1
        2. if text1[i] != text2[j]: dp[i][j] = max(dp[i-1][j], dp[i][j-1])

    Bonus Note: longest substring set dp[i][j] = 0 if not match.
 */
class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m ==0 || n == 0) return 0;
        // LCS[i][j] means length, LCS[0][0] means zero length
        int[][] LCS = new int[m+1][n+1];

        int longest = 0;
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i == 0 || j == 0) {
                    LCS[i][j] = 0;
                } else if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }

                longest = Math.max(LCS[i][j], longest);
            }
        }
        return longest;
    }
}