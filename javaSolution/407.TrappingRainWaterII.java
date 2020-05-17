import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
    PriorityQueue, sort by height.
    First send all boarder cell to PQ.
    maintain int maxHeight; tracks current max height while popping from PQ.
    For each popped cell, find all its neighbors.
        If neighbor height < maxHeight, then we can trap water there.
        If not, send neighbor to PQ.


    The idea of PQ is to from outer most cell to inner ones, process shortest cell (lose water)
    to taller ones.

 */
class TrappingRainWaterII {
    private class Cell {
        int row;
        int col;
        int height;
        Cell(int r, int c, int h) {
            row = r;
            col = c;
            height = h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.height));
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m-1][i] = true;
            pq.offer(new Cell(0, i, heightMap[0][i]));
            pq.offer(new Cell(m-1, i, heightMap[m-1][i]));
        }

        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n-1] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }

        int maxHeight = 0;
        int waterTrapped = 0;
        while (!pq.isEmpty()) {
            Cell shorterOne = pq.poll();
            visited[shorterOne.row][shorterOne.col] = true;
            maxHeight = Math.max(shorterOne.height, maxHeight);
            for (int[] nb: getNeighbor(shorterOne.row, shorterOne.col, m, n)) {
                if (!visited[nb[0]][nb[1]]) {
                    visited[nb[0]][nb[1]] = true;
                    if (heightMap[nb[0]][nb[1]] < maxHeight) {
                        waterTrapped += maxHeight - heightMap[nb[0]][nb[1]];
                    }
                    pq.offer(new Cell(nb[0], nb[1], heightMap[nb[0]][nb[1]]));
                }
            }
        }
        return waterTrapped;
    }

    private List<int[]> getNeighbor(int x, int y, int m, int n) {
        List<int[]> res = new ArrayList<>();
        if (x > 0) res.add(new int[]{x-1, y});
        if (y > 0) res.add(new int[]{x, y-1});
        if (x < m-1) res.add(new int[]{x+1, y});
        if (y < n-1) res.add(new int[]{x, y+1});
        return res;
    }
}