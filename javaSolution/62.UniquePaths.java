class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] numPaths = new int[n][m];

        for (int i = 0; i < numPaths.length; i++) {
            for (int j = 0; j < numPaths[0].length; j++) {
                if (i == 0 && j == 0) {
                    numPaths[0][0] = 1;
                } else {
                    if(j != 0) {
                        numPaths[i][j] += numPaths[i][j-1];
                    }
                    if (i != 0) {
                        numPaths[i][j] += numPaths[i-1][j];
                    }
                }
            }
        }
        return numPaths[n-1][m-1];
    }
}