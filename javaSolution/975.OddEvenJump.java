import java.util.Collections;
import java.util.TreeMap;

// Google
/*
    1. Loop from backwards.
    2. boolean even[i] odd[i] means can reach to end when jump at i with even/odd jump
    3. each loop put number->index to TreeMap so next search will include it.

    Note:
        1. each jump can only have one landing index
        2. current even[i] will jump to next odd[j]
        3. numbers of true in odd[] is canJump count
 */
class OddEvenJumpTreeMap {
    public int oddEvenJumps(int[] A) {
        int m = A.length;
        TreeMap<Integer, Integer> jumps = new TreeMap<>();
        boolean[] even = new boolean[m];
        boolean[] odd = new boolean[m];
        even[m-1] = odd[m-1] = true;
        jumps.put(A[m-1], m-1);
        for (int i = m-2; i >= 0; i--) {
            Integer ceiling = jumps.ceilingKey(A[i]);
            Integer floor = jumps.floorKey(A[i]);
            if (ceiling != null) {
                odd[i] = even[jumps.get(ceiling)];
            }
            if (floor != null) {
                even[i] = odd[jumps.get(floor)];
            }
            jumps.put(A[i], i);
        }
        int canJump = 0;
        for (boolean goodJump: odd) {
            if (goodJump) canJump++;
        }
        return canJump;
    }
}

class OddEvenJumpBruteForce {
    public int oddEvenJumps(int[] A) {
        int m = A.length;
        // first jump at index i
        int canJump = 0;
        for (int i = 0; i < m; i++) {
            int j = i, jumpCount = 1;
            Integer next;
            while (j < m - 1) {
                next = jumpCount % 2 == 1 ? ceiling(A, j+1, A[j]) : floor(A, j+1, A[j]);
                if (next == null) break;
                j = next;
                jumpCount++;
            }
            if (j == m-1) canJump++;
        }
        return canJump;
    }
    private Integer ceiling(int[] A, int start, int value) {
        Integer ceiling = null;
        for (int i = start; i < A.length; i++) {
            if (A[i] >= value && (ceiling == null || A[i] < A[ceiling])) {
                ceiling = i;
            }
        }
        return ceiling;
    }
    private Integer floor(int[] A, int start, int value) {
        Integer floor = null;
        for (int i = start; i < A.length; i++) {
            if (A[i] <= value && (floor == null || A[i] > A[floor])) {
                floor = i;
            }
        }
        return floor;
    }
}