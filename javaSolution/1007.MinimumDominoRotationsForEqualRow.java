class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int minRotate = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            int aToB = rotate(A, B, i);
            int bToA = rotate(B, A, i);
            minRotate = Math.min(Math.min(aToB, bToA), minRotate);
        }
        return minRotate == Integer.MAX_VALUE ? -1 : minRotate;
    }

    private int rotate(int[] A, int[] B, int target) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target) {
                if (B[i] != target) return Integer.MAX_VALUE;
                count++;
            }
        }
        return count;
    }
}