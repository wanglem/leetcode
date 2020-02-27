/*
    G.
    DP.
    N chars, L,A,P -> no more than two consecutive L, no more than one A.
    Two sub-problems:
        1. With A (n char)
        2. With no A (n-1 char)
    with dp[i] means all possible combinations at length i.
    When appending a new char:
        1. sequence ends with P         -> dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
        2. sequence ends with single L  -> dp[i][1] = dp[i-1][0]
        3. sequence ends with double L  -> dp[i][2] = dp[i-1][1]

    Adding with `A` case:
        Above DP, insert `A` at any given position i.
 */
class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        int k = (int) Math.pow(10, 9) + 7;
        int[][] dp = new int[n][3];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 0;

        int sum = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % k;
            dp[i][1] = dp[i-1][0];
            dp[i][2] = dp[i-1][1];
        }
        sum = (sum + (dp[n-1][0] + dp[n-1][1] + dp[n-1][2]))%k;

        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 1 : (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%k;
            int right = i == n-1 ? 1 : (dp[n-i-2][0] + dp[n-i-2][1] + dp[n-i-2][2])%k;
            sum = (sum + (left*right)%k);
        }

        return sum;
    }
}