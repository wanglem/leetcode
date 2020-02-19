import java.util.*;

class MinimumNumberOfFlipsToConvertBinaryToZeroMatrix {
    public int minFlips(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;

        int m = mat.length, n = mat[0].length;
        int len = m*n;

        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start  = (start << 1) | mat[i][j];
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        int step = 0;
        queue.offer(start);
        seen.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int next = queue.poll();
                if (next == 0) return step;
                for (int i = 0; i < len; i++) {
                    int child = flip(next, i, m, n);
                    if (!seen.contains(child)) {
                        seen.add(child);
                        queue.offer(child);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    private int flip(int num, int idx, int m, int n) {
        int i = idx / n;
        int j = idx % n;
        num ^= 1 << idx;
        if (i > 0) num ^= 1 << (idx - n);
        if (i < m-1) num ^= 1 << (idx + n);
        if (j > 0) num ^= 1 << (idx - 1);
        if (j < n-1) num ^= 1 << (idx + 1);

        return num;

    }

}