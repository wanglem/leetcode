import java.util.stream.IntStream;

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

class NumberOfIslandsUnionFind {
    private int[] parent;
    public int numIslands(char[][] G) {
        if (G.length == 0) return 0;
        int m = G.length, n = G[0].length;
        parent = new int[m*n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (G[i][j] == '1') {
                    parent[idx(i, j, n)] = idx(i, j, n);
                    if (j > 0 && G[i][j-1] == '1') union(idx(i, j, n), idx(i, j-1, n));
                    if (i > 0 && G[i-1][j] == '1') union(idx(i, j, n), idx(i-1, j, n));
                }
            }
        }

        return (int) IntStream.range(0, parent.length)
                .filter(i -> parent[i] == i)
                .count();
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    private int find(int x) {
        if (parent[x] != x) return find(parent[x]);
        return x;
    }

    private int idx(int x, int y, int n) {
        return x*n + y;
    }
}