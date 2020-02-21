class NumberofSubmatricesThatSumtoTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m  = matrix.length, n = matrix[0].length;
        int[][] subsum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                subsum[i][j] += matrix[i][j];
                if (i > 0) {
                    subsum[i][j] += subsum[i-1][j];
                }
                if (j > 0) {
                    subsum[i][j] += subsum[i][j-1];
                }
                if (i > 0 && j > 0) {
                    subsum[i][j] -= subsum[i-1][j-1];
                }
            }
        }

        int count = 0;
        for (int x1 = 0; x1 < m; x1++) {
            for (int x2 = x1; x2 < m; x2++) {
                for (int y1 = 0; y1 < n; y1++) {
                    for (int y2 = y1; y2 < n; y2++) {
                        if (getSum(subsum, x1, x2, y1, y2) == target) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private int getSum(int[][] subsum, int x1, int x2, int y1, int y2) {
        int sum = subsum[x2][y2];
        if (y1 > 0) sum -= subsum[x2][y1-1];
        if (x1 > 0) sum -= subsum[x1-1][y2];
        if (x1 > 0 && y1 > 0) sum += subsum[x1-1][y1-1];

        return sum;
    }
}