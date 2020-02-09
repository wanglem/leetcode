import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!validateLine(board[i])) return false;
            char[] col = new char[9];
            for (int j = 0; j < 9; j++) {
                col[j] = board[i][j];
            }
            if (!validateLine(col)) return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               char[] line = new char[9];
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        line[m*3 + n] = board[m+(i*3)][n+(j*3)];
                        if (!validateLine(line)) return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean validateLine(char[] line) {
        Set<Character> seen = new HashSet<>();
        for (char c : line) {
            if (c != '.') {
                if (seen.contains(c)) return false;
                seen.add(c);
            }
        }
        return true;
    }
}