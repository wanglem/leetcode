import java.util.*;

// Google
/*
On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
What is the largest possible number of moves we can make? */
/*
    num island problem.
    1. island means connected positions by same row or same column.
    2. for each island with size K, you can remove K-1 times! (size 1 means 0 remove)
        2a. M island with K size -> M*(K-1).
        2b. Say total num position is N, "N-K" means each island has 1 stone left! (BETTER)
 */
class MostStonesRemovedRowColumn {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> cols = new HashMap<>();
        for (int[] stone: stones) {
            int sr = stone[0];
            int sc = stone[1];
            if (!rows.containsKey(sr)) {
                rows.put(sr, new ArrayList<>());
            }
            if (!cols.containsKey(sc)) {
                cols.put(sc, new ArrayList<>());
            }
            rows.get(sr).add(sc);
            cols.get(sc).add(sr);
        }
        Set<Integer> seenRow = new HashSet<>();
        Set<Integer> seenCol = new HashSet<>();
        int numGroups = 0;
        for (Integer row : rows.keySet()) {
            if (!seenRow.contains(row)){
                numGroups++;
                markRow(seenRow, seenCol, rows, cols, row);
            }
        }
        return stones.length - numGroups;
    }

    private void markRow(Set<Integer> seenRow, Set<Integer> seenCol, Map<Integer, List<Integer>> rows, Map<Integer, List<Integer>> cols, int row) {
        if (seenRow.contains(row)) return;
        List<Integer> columnsAt = rows.get(row);
        seenRow.add(row);
        for (Integer columnAt : columnsAt) {
            markCol(seenRow, seenCol, rows, cols, columnAt);
        }
    }
    private void markCol(Set<Integer> seenRow, Set<Integer> seenCol, Map<Integer, List<Integer>> rows, Map<Integer, List<Integer>> cols, int col) {
        if (seenCol.contains(col)) return;
        List<Integer> rowsAt = cols.get(col);
        seenCol.add(col);
        for (Integer rowAt : rowsAt) {
            markRow(seenRow, seenCol, rows, cols, rowAt);
        }
    }
}