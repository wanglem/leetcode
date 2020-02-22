/*
S = "abcdebdde", T = "bde"
Output: "bcde"

    dp[i][j] = k means S[k:j+1] is the min window of T[0;i+1]
 */
class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length();
        int[][] min = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    if (i == 0) {
                        min[i][j] = 1;
                    } else {
                        for (int k = j-1; k >= 0; k--) {
                            if (min[i-1][k] > 0) {
                                min[i][j] = min[i-1][k] + j-k;
                                break;
                            }
                        }
                    }
                }
            }
        }

        String minStr = S + "a";
        for (int i = 0; i < m; i++) {
            if (min[n-1][i] > 0 && min[n-1][i] < minStr.length()) {
                minStr = S.substring(i - min[n-1][i] + 1, i+1);
            }
        }
        return minStr.length() == m+1 ? "" : minStr;
    }
}