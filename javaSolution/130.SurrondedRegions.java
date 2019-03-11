// start with board to mark board in place
class SurrondedRegions {
    public void solve(char[][] board) {
        if(board.length == 0) {
            return;
        }
        // mark first & last columns
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                markBoardered(i, 0, board);
            }
            if (board[i][board[0].length - 1] == 'O') {
                markBoardered(i, board[0].length - 1, board);
            }
        }

        // mark first & last rows
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                markBoardered(0, j, board);
            }
            if (board[board.length - 1][j] == 'O') {
                markBoardered(board.length - 1, j, board);
            }
        }

        // flip
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markBoardered(int i, int j, char[][]board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'X' || board[i][j] == 'M') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'M';
        }
        markBoardered(i-1, j, board);
        markBoardered(i+1, j, board);
        markBoardered(i, j-1, board);
        markBoardered(i, j+1, board);
    }
}