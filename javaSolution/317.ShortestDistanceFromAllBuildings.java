import java.util.LinkedList;
import java.util.Queue;

/*
    1. BFS - first processed must have shortest distance to that point.
    2. keep building count, final position must visited by all buildings.
    3. Edge case of adding build position to queue - add neighbors directly.
 */
class ShortestDistanceFromAllBuildings {
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] distance = new int[m][n][2];
        Queue<int[]> walk = new LinkedList<>();
        int buildings = 0;
        for (int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                buildings++;
                boolean[][] visited = new boolean[m][n];
                addNeighbors(i, j, 1, walk);
                // 0.i, 1.j, 2.distance
                while (!walk.isEmpty()) {
                    int[] step = walk.poll();
                    if (step[0] < 0 || step[0] >= m || step[1] < 0 || step[1] >= n) continue;
                    if (visited[step[0]][step[1]]) continue;
                    if (grid[step[0]][step[1]] != 0) continue;
                    distance[step[0]][step[1]][0] += step[2];
                    distance[step[0]][step[1]][1]++;
                    visited[step[0]][step[1]] = true;
                    addNeighbors(step[0], step[1], step[2]+1, walk);
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j][1] == buildings) {
                    minDistance = Math.min(minDistance, distance[i][j][0]);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private void addNeighbors(int i, int j, int dist, Queue<int[]> walk) {
        for (int[] dir : dirs) {
            walk.offer(new int[] {i+dir[0], j+dir[1], dist});
        }
    }
}