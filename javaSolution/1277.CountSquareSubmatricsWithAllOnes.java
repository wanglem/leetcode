class CountSquareSubmatricsWithAllOnes {
    public int countSquares(int[][] matrix) {
        int[][] area = area(matrix);
        int count = 0;
        for (int i = 1; i < matrix.length+1; i++) {
            for (int j = 1; j < matrix[0].length+1; j++) {
                count += area[i][j];
            }
        }
        return count;
    }

    private int[][] area(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] area = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (M[i-1][j-1] == 1) {
                    int preSquareLen = Math.min(area[i-1][j], area[i][j-1]);
                    preSquareLen = Math.min(preSquareLen, area[i-1][j-1]);
                    area[i][j] = preSquareLen+1;
                }
            }
        }
        return area;
    }
}