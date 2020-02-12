import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class InterleavingString {
    /*
        DP method.
        canBuild[i][j] means prefix [0, i] and [0,j] of s1 and s2 can build i+j of s3.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m+n != s3.length()) return false;
        boolean[][] canBuild = new boolean[m+1][n+1];
        canBuild[0][0] = true;
        for (int i = 0; i < m; i++) {
            canBuild[i+1][0] = s1.charAt(i) == s3.charAt(i) && canBuild[i][0];
        }
        for (int i = 0; i < n; i++) {
            canBuild[0][i+1] = s2.charAt(i) == s3.charAt(i) && canBuild[0][i];
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                canBuild[i][j] =
                        canBuild[i][j-1] && s1.charAt(i-1) == s3.charAt(i+j-1) ||
                                canBuild[i-1][j] && s2.charAt(j-1) == s3.charAt(i+j-1);
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        return canBuild[m][n];

    }
}