import java.util.*;

class ShortestPathInAGridWithObstaclesElimination {
    private class Mark {
        int i, j, k, walk;
        Mark(int i, int j, int k, int walk){
            this.i = i;
            this.j = j;
            this.k = k;
            this.walk = walk;
        }
        @Override
        public int hashCode() {
            int result = 7;
            result = 31 * result + i;
            result = 31 * result + j;
            result = 31 * result + k;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != this.getClass()) return false;
            Mark o = (Mark) obj;
            return i == o.i && j == o.j && k == o.k;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Queue<Mark> Q = new LinkedList<>();
        Set<Mark> visited = new HashSet<>();
        Q.offer(new Mark(0, 0, k, 0));
        visited.add(Q.peek());
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                Mark last = Q.poll();
                if (last.k < 0) continue;
                if (last.i < 0 || last.i >= m || last.j < 0 || last.j >= n ) continue;
                if (visited.contains(last)) continue;
                if (last.i == m-1 && last.j == n-1) {
                    return last.walk+1;
                }
                int kLeft = last.k - grid[last.i][last.j];
                int nextWalk = last.walk + 1;
                Q.offer(new Mark(last.i-1, last.j, kLeft, nextWalk));
                Q.offer(new Mark(last.i+1, last.j, kLeft, nextWalk));
                Q.offer(new Mark(last.i, last.j-1, kLeft, nextWalk));
                Q.offer(new Mark(last.i, last.j+1, kLeft, nextWalk));
            }
        }

        return -1;
    }
}