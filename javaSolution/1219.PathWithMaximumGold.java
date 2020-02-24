import java.util.Arrays;
import java.util.Collections;
/*
    Google
 */
class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxGold = 0;
        for (int i= 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxGold = Math.max(collectGold(grid, visited, i, j), maxGold);
            }
        }
        return maxGold;
    }
    private int collectGold(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        if (visited[i][j]) return 0;
        if (grid[i][j] == 0) return 0;

        visited[i][j] = true;
        int up = collectGold(grid, visited, i-1, j);
        int down = collectGold(grid, visited, i+1, j);
        int left = collectGold(grid, visited, i, j-1);
        int right = collectGold(grid, visited, i, j+1);
        visited[i][j] = false;
        int maxTail = Collections.max(Arrays.asList(up, down, left, right));

        return grid[i][j] + maxTail;
    }
}