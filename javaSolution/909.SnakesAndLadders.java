import java.util.ArrayList;
import java.util.List;

// MSFT
// DFS, probably got the idea...
class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int m = board.length;
        boolean[][] visited = new boolean[m][m];
        return search(visited, board, m-1, 0);
    }

    private int search(boolean[][] visited, int[][] board, int x, int y) {
        if (end(board, x, y)) return 0;
        if (visited[x][y]) return -1;
        visited[x][y] = true;
        int minSteps = Integer.MAX_VALUE;
        for (int[] move: move(board, x, y)) {
            int steps = search(visited, board, move[0], move[1]);
            if (steps >= 0) {
                minSteps = Math.min(steps, minSteps);
            }
        }

        return minSteps == Integer.MAX_VALUE ? -1: minSteps;
    }

    private boolean end(int[][] board, int x, int y) {
        int endX = 0, endY = 0;
        if (board.length % 2 == 1) endY = board.length - 1;
        return x == endX && y == endY;
    }

    private int[] pointToCoordinates(int p, int m) {
        int x = m-1, y = 0;
        int  moveDirection = -1;
        while (--p > 0) {
            if (y == m - 1) {
                x = x-1;
                moveDirection *= -1;
            } else {
                y = y+moveDirection;
            }
        }
        return new int[]{x, y};
    }

    private List<int[]> move(int[][] board, int x, int y) {
        int  moveDirection = -1;
        int m = board.length;
        if ((m - x - 1) % 2 == 1)  moveDirection = 1;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int x1, y1;
            if (y == m - 1) {
                x1 = x-1;
                y1 = y;
                moveDirection *= -1;
            } else {
                x1 = x;
                y1 = y+moveDirection;
            }
            int[] next = new int[]{x1, y1};
            if (!end(board, x1, y1)) {
                if (board[x1][y1] != -1) {
                    next = pointToCoordinates(board[x1][y1], m);
                }
                res.add(next);
            }
        }
        return res;
    }
}