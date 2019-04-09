// upper left to lower right, + or - health
// bottom-up approach, from lower-right to upper-left
class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] minHealth = new int[m][n];
        /* bottom right to upper left
         *  minHealth[i][j] = max(minHealth[i+1][j], minHealth[i][j+1]) + dungeon[i][j]
         *  minHealth[i][j] = min(minHealth[i][j], 1)
         */
        if (dungeon[m-1][n-1] < 0) {
            minHealth[m-1][n-1] =  dungeon[m-1][n-1] - 1;
        } else {
            minHealth[m-1][n-1] =  1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    minHealth[i][j] = minHealth[i+1][j] + dungeon[i][j];
                }
                if (j < n - 1) {
                    minHealth[i][j] = Math.max(minHealth[i][j+1], minHealth[i][j]) + dungeon[i][j];
                }
                if (minHealth[i][j] > 0) {
                    minHealth[i][j] = 1;
                }
            }
        }
        int minNeeded = minHealth[0][0];
        if (minNeeded <= 0) {
            return -1 * minNeeded;
        }
        return minNeeded;
    }
}