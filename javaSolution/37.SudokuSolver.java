import java.util.*;

// MSFT
// This is not working tho...
class SudokuSolver {
    private class SodokuCell implements Comparable {

        int x;
        int y;
        Set<Character> candidates;

        @Override
        public int compareTo(Object o) {
            SodokuCell that = (SodokuCell) o;
            return Integer.compare(candidates.size(), that.candidates.size());
        }

        SodokuCell(int x1, int y1) {
            x = x1;
            y = y1;
            candidates = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                candidates.add((char) ('1' + i));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SodokuCell that = (SodokuCell) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
    }
    public void solveSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        TreeMap<SodokuCell, SodokuCell> cells = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    cells.put(new SodokuCell(i, j), new SodokuCell(i, j));
                }
            }
        }

        int placed = 0;
        boolean[][] marked = new boolean[m][n];
        while (placed < m*n) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != '.' && !marked[i][j]) {
                        placed++;
                        marked[i][j] = true;
                        cancel(cells, i, j, board);
                    }
                    while (cells.firstKey().candidates.size() == 1) {
                        Map.Entry<SodokuCell, SodokuCell> entry = cells.pollFirstEntry();
                        SodokuCell cell = entry.getKey();
                        board[cell.x][cell.y] = cell.candidates.iterator().next();
                        placed++;
                    }
                }
            }
        }
    }

    private void cancel(TreeMap<SodokuCell, SodokuCell> cells, int x, int y, char[][] board) {
        char c = board[x][y];
        // row
        for (int i = 0; i < board[0].length; i++) {
            SodokuCell cell = cells.get(new SodokuCell(x, i));
            cell.candidates.remove(c);
            cells.put(cell, cell);
        }
        // col
        for (int i = 0; i < board.length; i++) {
            SodokuCell cell = cells.get(new SodokuCell(i, y));
            cell.candidates.remove(c);
            cells.put(cell, cell);
        }
        // square
        int baseX = (x/3)*3, baseY = (y/3)*3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                SodokuCell cell = cells.get(new SodokuCell(baseX+i, baseY+y));
                cell.candidates.remove(c);
                cells.put(cell, cell);
            }
        }
    }
}