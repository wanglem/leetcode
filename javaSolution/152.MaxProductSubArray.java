import java.util.TreeMap;

class MaxProductSubArray {
    public int maxProduct(int[] A) {
        int maxP = A[0];
        int imin = maxP;
        int imax = maxP;
        for (int i = 1; i < A.length; i++) {
            int nmin = Math.min(Math.min(A[i]*imax, A[i]*imin), A[i]);
            imax = Math.max(Math.max(A[i]*imax, A[i]*imin), A[i]);
            maxP = Math.max(imax, maxP);
            imin = nmin;
        }
        return maxP;
    }
}