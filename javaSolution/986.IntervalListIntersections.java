import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//FB
class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        Arrays.sort(A, Comparator.comparingInt(x -> x[0]));
        Arrays.sort(B, Comparator.comparingInt(x -> x[0]));

        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][0] > B[j][1]) {
                j++;
            } else if (A[i][1] < B[j][0]) {
                i++;
            } else {
                res.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
                if (A[i][1] <= B[j][1]) i++;
                if (i < A.length && B[j][1] <= A[i][1]) j++;
            }
        }

        int[][] returnVal = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            returnVal[k] = res.get(k);
        }

        return returnVal;
    }
}