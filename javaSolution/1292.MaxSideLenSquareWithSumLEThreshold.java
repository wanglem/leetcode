class MaxSideLenSquareWithSumLEThreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] incrementSum = new int[m+1][n+1];
        int maxSideLen = 0;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                incrementSum[i][j] += mat[i-1][j-1];
                if (i > 1) incrementSum[i][j] += incrementSum[i-1][j];
                if (j > 1) incrementSum[i][j] += incrementSum[i][j-1];
                if (i > 1 && j > 1) incrementSum[i][j] -= incrementSum[i-1][j-1];
                int squareSideLen = Math.min(i, j);
                for (int k = Math.max(1, maxSideLen); k <= squareSideLen; k++) {
                    int squareSum = incrementSum[i][j]
                            - incrementSum[i][j-k]
                            - incrementSum[i-k][j]
                            + incrementSum[i-k][j-k];
                    if (squareSum <= threshold) {
                        maxSideLen = k;
                    }
                }

            }
        }
        return maxSideLen;

    }
}