// wrong answer, but get the dp point
/*
    dp[i][j] is height of 1's at i, j
    loop through whole matrix and calculate
 */
class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int largest[][][] = new int[matrix.length][matrix[0].length][2];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    largest[i][j][0] = matrix[i][j] == '1'? i : 0;
                    largest[i][j][1] = matrix[i][j] == '1'? i : 0;
                } else if (matrix[i][j] == '0') {
                    largest[i][j][0] = 0;
                    largest[i][j][1] = 0;
                } else {
                    int m = 0;
                    while (m < largest[i-1][j-1][0] && matrix[i-m][j] == '1') {
                        int curMax = (m+1)*(largest[i-1][j-1][1]+1);
                        if (curMax >= maxArea) {
                            largest[i][j][0] = m;
                            largest[i][j][1] = largest[i-1][j-1][1]+1;
                            maxArea = curMax;
                        }
                        m++;
                    }
                }
            }
        }
        return maxArea;
    }
}