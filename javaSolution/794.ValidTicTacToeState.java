class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        char[][] b = new char[3][3];
        for (int i = 0; i < 3; i++) {
            b[i][0] = board[i].charAt(0);
            b[i][1] = board[i].charAt(1);
            b[i][2] = board[i].charAt(2);
        }

        int numX = 0, numO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] =='X') numX++;
                else if (b[i][j] == 'O') numO++;
            }
        }

        if (!(numX == numO || numX == numO+1)) return false;

        boolean wonX = won(b, 'X');
        boolean wonO = won(b, 'O');

        if (wonX && wonO) return false;
        if (wonX && numX == numO) return false;
        if (wonO && numX == numO + 1) return false;

        return true;
    }

    private boolean won(char[][] b, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (same(b[i][0], b[i][1], b[i][2], symbol)) return true;
            if (same(b[0][i], b[1][i], b[2][i], symbol)) return true;
        }
        if (same(b[0][0], b[1][1], b[2][2], symbol)) return true;
        if (same(b[0][2], b[1][1], b[2][0], symbol)) return true;

        return false;
    }

    private boolean same(char a, char b, char c, char d) {
        return a == b && b == c && c == d;
    }
}