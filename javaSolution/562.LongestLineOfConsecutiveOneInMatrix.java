import java.util.Arrays;
import java.util.Collections;

/*
    G.
    Failed on one test, not sure why. Meh.
 */
class LongestLineOfConsecutiveOneInMatrix {
    public int longestLine(int[][] M) {
        if (M.length == 0) return 0;
        int m = M.length, n = M[0].length;
        int[][][] LR = new int[m+1][n+1][4];
        int max = 0;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (M[i-1][j-1] != 1) continue;
                LR[i][j][0] = LR[i-1][j][0] + 1;
                LR[i][j][1] = LR[i][j-1][1] + 1;
                LR[i][j][2] = LR[i-1][j-1][2] + 1;
                LR[i][n-j][3] = LR[i-1][n-j+1][3] + 1;
                max = Collections.max(Arrays.asList(
                        LR[i][j][0],
                        LR[i][j][1],
                        LR[i][j][2],
                        LR[i][n-j][3],
                        max
                ));
            }
        }
        return max;
    }
}