class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int[][] minPathSum = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                minPathSum[i][j] += grid[i][j];
                if ( i > 0 && j > 0) {
                    minPathSum[i][j] += Math.min(minPathSum[i-1][j], minPathSum[i][j-1]);
                } else if ( i > 0) {
                    minPathSum[i][j] += minPathSum[i-1][j];
                } else if (j > 0) {
                    minPathSum[i][j] += minPathSum[i][j-1];
                }
            }
        }
        return minPathSum[grid.length-1][grid[0].length-1];
    }
}