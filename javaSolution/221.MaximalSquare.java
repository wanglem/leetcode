import java.util.Arrays;
import java.util.Collections;

// max square only contains '1'
// dp sizes[i][j] means max square size at i, j
class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] sizes = new int[m][n];
        int maxSize = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0'){
                    sizes[i][j] = 0;
                }else if (i == 0 || j == 0) {
                    sizes[i][j] = 1;
                } else {
                    sizes[i][j] = Collections.min(Arrays.asList(sizes[i-1][j], sizes[i][j-1], sizes[i-1][j-1])) + 1;
                }
                maxSize = Math.max(sizes[i][j], maxSize);
            }
        }
        return maxSize*maxSize;
    }
}