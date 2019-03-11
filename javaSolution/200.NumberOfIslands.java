class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int numIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    markAdjacent(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void markAdjacent(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        markAdjacent(grid, i - 1, j);
        markAdjacent(grid, i + 1, j);
        markAdjacent(grid, i, j - 1);
        markAdjacent(grid, i, j + 1);
    }
}