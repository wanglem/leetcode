class PreviousPermutationWithOneSwap {
    // [2,1,1,3]
    public int[] prevPermOpt1(int[] A) {
        int largerIndex = A.length-2;
        while (largerIndex > -1 && A[largerIndex] <= A[largerIndex+1]) largerIndex--;
        if (largerIndex == -1) return A;
        int switchIndex = A.length - 1;
        while (A[switchIndex] >= A[largerIndex]) switchIndex--;
        while (A[switchIndex] == A[switchIndex-1]) switchIndex--;
        swap(A, largerIndex, switchIndex);
        return A;
    }
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}