import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m*n];
        boolean shouldReverse = false;
        int idx = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> diagonal = readDiagonal(i, 0, matrix);
            if (shouldReverse) Collections.reverse(diagonal);
            shouldReverse = !shouldReverse;
            for (int e: diagonal) {
                res[idx++] = e;
            }
        }

        for (int j = 0; j < n; j++) {
            List<Integer> diagonal = readDiagonal(0, j, matrix);
            if (shouldReverse) Collections.reverse(diagonal);
            shouldReverse = !shouldReverse;
            for (int e: diagonal) {
                res[idx++] = e;
            }
        }

        return res;
        
    }

    private List<Integer> readDiagonal(int x, int y, int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        while (x < m && y < n) {
            res.add(matrix[x++][y++]);
        }
        return res;
    }
}