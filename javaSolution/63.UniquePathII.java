class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] pathTrack = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    pathTrack[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    pathTrack[i][j] = 1;
                } else {
                    if (i != 0) {
                        pathTrack[i][j] += pathTrack[i-1][j];
                    }
                    if (j != 0) {
                        pathTrack[i][j] += pathTrack[i][j-1];
                    }
                }
            }
        }
        return pathTrack[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}