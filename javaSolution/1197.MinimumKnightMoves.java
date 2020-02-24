import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
    Google.
    Use BFS to simulate moves, and return step when found.
 */
class MinimumKnightMoves {
    private int[][] moves = {{1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}, {-2,1}, {-1,2}};

    public int minKnightMoves(int x, int y) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0,0});
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        int step = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                int[] cur = Q.poll();
                if (cur[0] == x && cur[1] == y) return step;
                for (int[] n: nextMoves(cur[0], cur[1])) {
                    if (!seen.contains(hc(n[0], n[1]))) {
                        seen.add(hc(n[0], n[1]));
                        Q.offer(n);
                    }
                }
            }
            step++;
        }
        throw new RuntimeException("no way");
    }

    private int hc(int x, int y) {
        return 4001*x+y;
    }

    private int[][] nextMoves(int x, int y) {
        int[][] next = new int[8][2];
        for (int i = 0; i < 8; i++) {
            next[i] = new int[]{x+moves[i][0], y+moves[i][1]};
        }
        return next;
    }
}