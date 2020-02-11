import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Resurrection {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] seen = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean found = bfs(board, i, j, 0, seen, word);
                if (found) return true;
            }
        }
        return false;
    }

    private boolean bfs(char[][] B, int i, int j, int reach,boolean[][] seen, String word) {
        if (reach == word.length()) return true;
        int m = B.length, n = B[0].length;
        if (i < 0 || i >=m || j < 0 || j >= n) return false;
        if (word.charAt(reach) != B[i][j]) return false;
        if (seen[i][j]) return false;

        seen[i][j] = true;
        boolean up = bfs(B, i-1, j, reach+1, seen, word);
        if (up) return true;
        boolean down = bfs(B, i+1, j, reach+1, seen, word);
        if (down) return true;
        boolean left = bfs(B, i, j-1, reach+1, seen, word);
        if (left) return true;
        boolean right = bfs(B, i, j+1, reach+1, seen, word);
        if (right) return true;
        seen[i][j] = false;
        return false;
    }
}