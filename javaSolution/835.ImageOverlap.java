import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    G.
    For each position in (ia,ja) in A and (ib, jb) in B.
    Point to Point move means [ia-ib, ja-jb], this is directional.
    Hash above move and find largest count of a hash value.
 */
class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        List<int[]> pas = new ArrayList<>(), pbs = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i][j] == 1) pas.add(new int[]{i, j});
                if (B[i][j] == 1) pbs.add(new int[]{i, j});
            }
        }

        Map<Integer, Integer> vector = new HashMap<>();
        for (int[] pa: pas) {
            for (int[] pb: pbs) {
                int key = hash(pa[0]-pb[0], pa[1]-pb[1]);
                vector.put(key, vector.getOrDefault(key, 0)+1);
            }
        }
        return vector.values().stream().max(Integer::compare).orElse(0);
    }

    private int hash(int a, int b) {
        return a*4001 + b;
    }    
}