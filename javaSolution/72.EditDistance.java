import java.util.Arrays;
import java.util.Collections;

class EditDistance {

    /*
        f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2

        Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
            f(i, j) = f(i - 1, j - 1)

        Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
            f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
            1. f(i, j - 1) represents insert operation
            2. f(i - 1, j) represents delete operation
            3. f(i - 1, j - 1) represents replace operation
     */
    /*
        Trick is to set DP array [m+1][n+1] size to initialize start state.
     */
    // ros -> horse
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] editTracker = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            editTracker[i][0] = i;
        }
        for (int i = 0; i < n+1; i++) {
            editTracker[0][i] = i;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    editTracker[i][j] = editTracker[i-1][j-1];
                } else {
                    editTracker[i][j] = Collections.min(
                            Arrays.asList(
                                    editTracker[i - 1][j - 1],
                                    editTracker[i - 1][j],
                                    editTracker[i][j - 1]
                            )) + 1;
                }
            }
        }
        return editTracker[m][n];
    }
}