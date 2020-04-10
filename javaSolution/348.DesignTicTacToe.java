class DesignTicTacToe {

    private int[][] board;
    private int n;
    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (row >= n || row < 0 || col >= n || col < 0) return 0;
        if (board[row][col] != 0) return 0;
        board[row][col] = player;

        return won(row, col, player);
    }

    private int won(int x, int y, int p) {
        if (row(x,y,p) || col(x, y, p) || diagonal(x, y, p)) {
            return p;
        }

        return 0;
    }

    private boolean diagonal(int x, int y, int p) {
        boolean l2r = false, r2l = false;
        if (x == y) {
            l2r = true;
            for (int i = 0; i < n; i++) {
                if (board[i][i] != p) {
                    l2r = false;
                    break;
                }
            }
        }
        if (n - x == y+1) {
            r2l = true;
            for (int i = 0; i < n; i++) {
                if (board[n-i-1][i] != p) {
                    r2l = false;
                    break;
                }
            }
        }

        return l2r || r2l;
    }

    private boolean row(int x, int y, int p) {
        for (int i = 0; i < n; i++) {
            if (board[x][i] != p) {
                return false;
            }
        }
        return true;
    }

    private boolean col(int x, int y, int p) {
        for (int i = 0; i < n; i++) {
            if (board[i][y] != p) {
                return false;
            }
        }
        return true;
    }
}