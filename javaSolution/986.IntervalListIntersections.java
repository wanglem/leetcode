import java.util.ArrayList;
import java.util.List;

//FB
// two interval array, merge their intersection
class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][1] < B[j][0]) {
                i++;
            } else if (A[i][0] > B[j][1]) {
                j++;
            } else {
                res.add(
                        new int[]{
                                Math.max(A[i][0], B[j][0]),
                                Math.min(A[i][1], B[j][1])
                        }
                );
                if (A[i][1] < B[j][1]) i++;
                else j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}