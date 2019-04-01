/*
    1. cache[i][j] means longest at i, j
    2. if previous >= current then stop searching, so no need for visited matrix
 */
class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int longestPath = 0;
        int[][] longest = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestPath = Math.max(longestPath, maxPath(matrix, i, j, longest, Integer.MIN_VALUE));
            }
        }
        return longestPath;
    }

    private int maxPath(int[][] matrix, int i, int j, int[][] longest, int prev) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (matrix[i][j] <= prev) {
            return 0;
        }
        if (longest[i][j] != 0) {
            return longest[i][j];
        }
        int maxPath = 0;
        int[][] directions = {{0, 1}, {1,0}, {0, -1}, {-1, 0}};
        for (int[] direction: directions)  {
            maxPath = Math.max(maxPath, maxPath(matrix, i+direction[0], j+direction[1], longest, matrix[i][j])+1);
        }
        longest[i][j] = maxPath;
        return longest[i][j];
    }
}