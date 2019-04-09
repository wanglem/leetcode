// search a word in grid
// loop through all directions, use visited
class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                boolean found = search(board, word, 0, i, j, visited);
                if (found) return found;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int index, int m, int n, boolean[][] visited) {
        if (index == word.length()) return true;
        if (m >= board.length || n >= board[0].length) return false;
        if (m < 0 || n < 0) return false;
        if (visited[m][n]) return false;
        if (word.charAt(index) == board[m][n]) {
            visited[m][n] = true;
            boolean up = search(board, word, index+1, m-1, n, visited);
            if (up) return true;
            boolean down = search(board, word, index+1, m+1, n, visited);
            if (down) return true;
            boolean left = search(board, word, index+1, m, n-1, visited);
            if (left) return true;
            boolean right = search(board, word, index+1, m, n+1, visited);
            if (right) return true;
            visited[m][n] = false;
        }
        return false;
    }
}